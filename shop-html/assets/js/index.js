import service from "./request.js"

export function popularCategories(data) {
    return service.request({
        method: 'get',
        url: 'http://localhost:40000/index/popularCategories',
        data: data //左边的data是变量名(key)后台接受，右边的data是参数,如果两者名字相同可以只写一个
    })
}

export function ourProducts(data) {
    return service.request({
        method: 'get',
        url: 'http://localhost:40000/index/ourProducts',
        data: data //左边的data是变量名(key)后台接受，右边的data是参数,如果两者名字相同可以只写一个
    })
}

export function whatPeopleSay(data) {
    return service.request({
        method: 'get',
        url: 'http://localhost:40000/index/whatPeopleSay',
        data: data //左边的data是变量名(key)后台接受，右边的data是参数,如果两者名字相同可以只写一个
    })
}


export function bestSellers(data) {
    return service.request({
        method: 'get',
        url: 'http://localhost:40000/index/bestSellers',
        data: data //左边的data是变量名(key)后台接受，右边的data是参数,如果两者名字相同可以只写一个
    })
}


export function fromTheBlog(data) {
    return service.request({
        method: 'get',
        url: 'http://localhost:40000/index/blog',
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


export function getCart(data) {
    return service.request({
        method: 'post',
        url: 'http://localhost:40000/cart/cart',
        data: data //左边的data是变量名(key)后台接受，右边的data是参数,如果两者名字相同可以只写一个
    })
}

export function addToWishList(data) {
    return service.request({
        method: 'post',
        url: 'http://localhost:40000//shop/wish',
        data: data //左边的data是变量名(key)后台接受，右边的data是参数,如果两者名字相同可以只写一个
    })
}

export function addToCart(data) {
    return service.request({
        method: 'post',
        url: 'http://localhost:40000/shop/addCart',
        data: data //左边的data是变量名(key)后台接受，右边的data是参数,如果两者名字相同可以只写一个
    })
}

