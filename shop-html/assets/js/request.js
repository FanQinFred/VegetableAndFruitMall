const service = axios.create({
    baseURL: 'http://localhost:40000', //http://localhost:8080/devApi =='http://www.web-jshtml.cn/productapi'
    timeout: 15000, //超时时间，最好设大一点，不然请求接口时间如果超过超时时间就会无法返回
    headers: {
        "X-Custom-Header": "foobar",
    },
});


// 添加请求拦截器，请求接口前，做一些数据处理
service.interceptors.request.use(
    function (config) {
        // 在发送请求之前做些什么
        //后台需要前端这边传相关的参数（在请求头添加参数）
        //Tokey userId sui

        //业务需求

        //向请求头添加参数： config.headers['userId']='xxx'
        //为请求头对象，添加token验证的Authorization字段
        config.headers.token = window.sessionStorage.getItem("token");
        return config;
    },
    function (error) {
        // 对请求错误做些什么
        return Promise.reject(error);
    }
);

// 添加响应拦截器,请求接口，返回数据进行拦截
service.interceptors.response.use(
    function (response) {
        let data = response.data;

        if (data.status != '200') {
            // Message.error(data.message);
            return Promise.reject(data);
            
        } else { // 对响应数据做点什么
            return response;
        }


    },
    function (error) {
        // 对响应错误做点什么
        return Promise.reject(error);
    }
);

export default service;