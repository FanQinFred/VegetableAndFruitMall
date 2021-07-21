import service from "./request.js"

export function wishlist(data) {
    return service.request({
        method: 'post',
        url: 'http://fanqin.vaiwan.com/shop/wishlist',
        data: data //左边的data是变量名(key)后台接受，右边的data是参数,如果两者名字相同可以只写一个
    })
}

export function getInfoById(data) {
        return service.request({
            method: 'post',
            url: 'http://fanqin.vaiwan.com/shop/getInfoById',
            data: data //左边的data是变量名(key)后台接受，右边的data是参数,如果两者名字相同可以只写一个
        })
    }


    export function AddWish(data) {
        return service.request({
            method: 'post',
            url: 'http://fanqin.vaiwan.com/shop/wish',
            data: data //左边的data是变量名(key)后台接受，右边的data是参数,如果两者名字相同可以只写一个
        })
    }


    export function deleteGoodsInWishList(data) {
        return service.request({
            method: 'post',
            url: 'http://fanqin.vaiwan.com/wishlist/deleteGoodsInWishList',
            data: data //左边的data是变量名(key)后台接受，右边的data是参数,如果两者名字相同可以只写一个
        })
    }