import request from '@/utils/request'

// 查询专家库列表
export function listExpert_pool(query) {
  return request({
    url: '/bidding/expert_pool/list',
    method: 'get',
    params: query
  })
}

// 查询专家库详细
export function getExpert_pool(expertPoolId) {
  return request({
    url: '/bidding/expert_pool/' + expertPoolId,
    method: 'get'
  })
}

// 新增专家库
export function addExpert_pool(data) {
  return request({
    url: '/bidding/expert_pool',
    method: 'post',
    data: data
  })
}

// 修改专家库
export function updateExpert_pool(data) {
  return request({
    url: '/bidding/expert_pool',
    method: 'put',
    data: data
  })
}

// 删除专家库
export function delExpert_pool(expertPoolId) {
  return request({
    url: '/bidding/expert_pool/' + expertPoolId,
    method: 'delete'
  })
}
