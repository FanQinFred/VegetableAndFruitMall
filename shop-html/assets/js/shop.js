import service from "./request.js"

export function select(data) {
    return service.request({
        method: 'get',
        url: 'http://localhost:40000/select',
        data: data //左边的data是变量名(key)后台接受，右边的data是参数,如果两者名字相同可以只写一个
    })
}