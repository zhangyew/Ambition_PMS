import request from '@/utils/request'

// 查询采购需求表列表
export function listPro_require(query) {
  return request({
    url: '/shopping/pro_require/list',
    method: 'get',
    params: query
  })
}

// 查询采购需求表详细
export function getPro_require(requireId) {
  return request({
    url: '/shopping/pro_require/' + requireId,
    method: 'get'
  })
}

// 新增采购需求表
export function addPro_require(data) {
  return request({
    url: '/shopping/pro_require',
    method: 'post',
    data: data
  })
}

// 修改采购需求表
export function updatePro_require(data) {
  return request({
    url: '/shopping/pro_require',
    method: 'put',
    data: data
  })
}
export function upReState(rid) {
  return request({
    url: '/shopping/pro_require/upReState/'+rid,
    method: 'get',
  })
}
// 改变审批状态
export function updateExamine(data) {
  return request({
    url: '/shopping/pro_require/updateExamine',
    method: 'post',
    data: data
  })
}
// 删除采购需求表
export function delPro_require(requireId) {
  return request({
    url: '/shopping/pro_require/' + requireId,
    method: 'delete'
  })
}
