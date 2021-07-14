package cn.cqu.vspace.service.impl;


import cn.cqu.vspace.nginx.NginxInfo;
import cn.cqu.vspace.service.PictureService;
import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

@Service
public class PictureServiceImp implements PictureService {
    //通过application.yml配置文件中配置的fdfsj配置参数,SpringIOC容器创建了一个storage客户端对象
//在使用的时候直接自动装配使用即可
    @Autowired
    private FastFileStorageClient storageClient;
    //自动装配一个NginxInfo
    @Autowired
    private NginxInfo nginxInfo;

    @Override
    public String upload(byte[] bytes, Long fileSize, String extension) {
        InputStream inputStream = new ByteArrayInputStream(bytes);
//调用客存储器客户端对象的方法上传文件
        StorePath storePath = null;
        try {
            storePath = storageClient.uploadFile(
                    inputStream, //上传文件的输入流对象
                    fileSize, //上传文件大小
                    extension,//上传文件的扩展名
                    null); //上传文件的元数据集可以不用设置,直接指定一个null参数即可
        } catch (Exception e) {
            return null;
        }
//将上传获取到的storePath转换成String类型的url并返回给调用者
        String fullFilePath = storePath.getFullPath();
        fullFilePath = "http://" + nginxInfo.getIp() + ":" + nginxInfo.getPort() + "/" + fullFilePath;
        return fullFilePath;
    }

    @Override
    public String uploadAndThumbnail(byte[] bytes, Long
            fileSize, String extension) {
        InputStream inputStream = new
                ByteArrayInputStream(bytes);
//调用客存储器客户端对象的方法上传文件
        StorePath storePath = null;
        try {
            storePath = storageClient.uploadImageAndCrtThumbImage(
                            inputStream, //上传文件的输入流对象
                            fileSize, //上传文件大小
                            extension,//上传文件的扩展名2.4 配置application.yml
                            null); //上传文件的元数据集可以不用设置,直接指定一个null参数即可
        } catch (Exception e) {
            return null;
        }
//将上传获取到的storePath转换成String类型的url并返回给调用者
        String fullFilePath = storePath.getFullPath();
        fullFilePath = "http://" + nginxInfo.getIp() + ":" + nginxInfo.getPort() + "/" + fullFilePath;
        return fullFilePath;
    }

    @Override
    public void delete(String fileUrl) {
        if (StringUtils.isEmpty(fileUrl)) {
//如果请求文件路径为null,则直接结束
            return;
        }
//将请求路径转换成storage存储器格式的路径
        StorePath storePath = StorePath.parseFromUrl(fileUrl);
//从存储器路径对象中获取组组名称和路径名称,通过二者对文件对象进行删除
        storageClient.deleteFile(storePath.getGroup(), storePath.getPath());
    }
}
