import request from '@/utils/request'

// 查询编码规则列表
export function listRules(query) {
  return request({
    url: '/bidding/rules/list',
    method: 'get',
    params: query
  })
}

// 查询编码规则详细
export function getRules(codeRulesId) {
  return request({
    url: '/bidding/rules/' + codeRulesId,
    method: 'get'
  })
}

// 新增编码规则
export function addRules(data) {
  return request({
    url: '/bidding/rules',
    method: 'post',
    data: data
  })
}

// 修改编码规则
export function updateRules(data) {
  return request({
    url: '/bidding/rules',
    method: 'put',
    data: data
  })
}

// 删除编码规则
export function delRules(codeRulesId) {
  return request({
    url: '/bidding/rules/' + codeRulesId,
    method: 'delete'
  })
}
