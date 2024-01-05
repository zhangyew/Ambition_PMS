import request from '@/utils/request'

// 查询仓库列表
export function listWarehouse(query) {
  return request({
    url: '/shopping/warehouse/list',
    method: 'get',
    params: query
  })
}

// 查询仓库详细 111
export function getWarehouse(warehouseId) {
  return request({
    url: '/shopping/warehouse/' + warehouseId,
    method: 'get'
  })
}

// 新增仓库
export function addWarehouse(data) {
  return request({
    url: '/shopping/warehouse',
    method: 'post',
    data: data
  })
}

// 修改仓库
export function updateWarehouse(data) {
  return request({
    url: '/shopping/warehouse',
    method: 'put',
    data: data
  })
}

// 删除仓库
export function delWarehouse(warehouseId) {
  return request({
    url: '/shopping/warehouse/' + warehouseId,
    method: 'delete'
  })
}
