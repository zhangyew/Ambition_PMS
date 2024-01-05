import request from '@/utils/request'

// 查询专家列表
export function listExpert(query) {
  return request({
    url: '/bidding/expert/list',
    method: 'get',
    params: query
  })
}

// 查询专家详细
export function getExpert(expertId) {
  return request({
    url: '/bidding/expert/' + expertId,
    method: 'get'
  })
}

// 新增专家
export function addExpert(data) {
  return request({
    url: '/bidding/expert',
    method: 'post',
    data: data
  })
}

// 修改专家
export function updateExpert(data) {
  return request({
    url: '/bidding/expert',
    method: 'put',
    data: data
  })
}

// 删除专家
export function delExpert(expertId) {
  return request({
    url: '/bidding/expert/' + expertId,
    method: 'delete'
  })
}
