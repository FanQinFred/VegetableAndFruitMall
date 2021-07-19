import service from "./request.js"

export function getInfoById(data) {
        return service.request({
            method: 'post',
            url: 'http://localhost:40000/shop/getInfoById',
            data: data //左边的data是变量名(key)后台接受，右边的data是参数,如果两者名字相同可以只写一个
        })
    }