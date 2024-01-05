import request from '@/utils/request'

// 查询物料列表
export function listGoods(query) {
  return request({
    url: '/shopping/goods/list',
    method: 'get',
    params: query
  })
}

// 查询物料详细
export function getGoods(goodsId) {
  return request({
    url: '/shopping/goods/' + goodsId,
    method: 'get'
  })
}

// 新增物料
export function addGoods(data) {
  return request({
    url: '/shopping/goods',
    method: 'post',
    data: data
  })
}

// 修改物料
export function updateGoods(data) {
  return request({
    url: '/shopping/goods',
    method: 'put',
    data: data
  })
}

// 下架物料
export function delGoods(goodsId) {
  return request({
    url: '/shopping/goods/' + goodsId,
    method: 'delete'
  })
}

// 查询物料列表
export function findCategoryList() {
  return request({
    url: '/shopping/goods/findCategoryList',
    method: 'get'
  })
}
