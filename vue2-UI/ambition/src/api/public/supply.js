import request from '@/utils/request'

// 查询供应商供货表列表
export function listSupply(query) {
  return request({
    url: '/bidding/supply/list',
    method: 'get',
    params: query
  })
}

// 查询供应商供货表详细
export function getSupply(supplyId) {
  return request({
    url: '/bidding/supply/' + supplyId,
    method: 'get'
  })
}

// 新增供应商供货表
export function addSupply(data) {
  return request({
    url: '/bidding/supply',
    method: 'post',
    data: data
  })
}

// 修改供应商供货表
export function updateSupply(data) {
  return request({
    url: '/bidding/supply',
    method: 'put',
    data: data
  })
}

// 删除供应商供货表
export function delSupply(supplyId) {
  return request({
    url: '/bidding/supply/' + supplyId,
    method: 'delete'
  })
}
