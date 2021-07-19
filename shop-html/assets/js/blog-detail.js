import service from "./request.js"

export function newComment(data) {
    return service.request({
        method: 'post',
        url: 'http://localhost:40000/detail/comment',
        data: data //左边的data是变量名(key)后台接受，右边的data是参数,如果两者名字相同可以只写一个
    })
}


export function recentPost(data) {
    return service.request({
        method: 'get',
        url: 'http://localhost:40000/index/blog',
        data: data //左边的data是变量名(key)后台接受，右边的data是参数,如果两者名字相同可以只写一个
    })
}

export function getBlogById(data) {
    return service.request({
        method: 'post',
        url: 'http://localhost:40000/index/getBlogById',
        data: data //左边的data是变量名(key)后台接受，右边的data是参数,如果两者名字相同可以只写一个
    })
}

export function newArrivals(data) {
    return service.request({
        method: 'get',
        url: 'http://localhost:40000/index/newArrival',
        data: data //左边的data是变量名(key)后台接受，右边的data是参数,如果两者名字相同可以只写一个
    })
}

export function topRated(data) {
    return service.request({
        method: 'get',
        url: 'http://localhost:40000/index/topRated',
        data: data //左边的data是变量名(key)后台接受，右边的data是参数,如果两者名字相同可以只写一个
    })
}

export function getUrlParam(name) {
    var url = window.location.href;
  
    let params = url.substr(url.lastIndexOf("?") + 1).split("&");
    for (let i = 0; i < params.length; i++) {
      let param = params[i];
      let key = param.split("=")[0];
      let value = param.split("=")[1];
      if (key === name) {
        return value;
      }
    }
  }


