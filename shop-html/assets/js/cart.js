import service from "./request.js"

export function apply_Coupon(data) {
    return service.request({
        method: 'get',
        url: 'http://localhost:40000/cart/apply_Coupon',
        data: data //左边的data是变量名(key)后台接受，右边的data是参数,如果两者名字相同可以只写一个
    })
}

export function updata(data) {
    return service.request({
        method: 'get',
        url: 'http://localhost:40000/cart/updata',
        data: data //左边的data是变量名(key)后台接受，右边的data是参数,如果两者名字相同可以只写一个
    })
}