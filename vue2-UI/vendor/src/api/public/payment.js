import request from '@/utils/request'

// 查询合同付款列表
export function listPayment(query) {
  return request({
    url: '/shopping/payment/list',
    method: 'get',
    params: query
  })
}

// 查询合同付款详细
export function getPayment(paymentId) {
  return request({
    url: '/shopping/payment/' + paymentId,
    method: 'get'
  })
}

// 新增合同付款
export function addPayment(data) {
  return request({
    url: '/shopping/payment',
    method: 'post',
    data: data
  })
}

// 修改合同付款
export function updatePayment(data) {
  return request({
    url: '/shopping/payment',
    method: 'put',
    data: data
  })
}

// 删除合同付款
export function delPayment(paymentId) {
  return request({
    url: '/shopping/payment/' + paymentId,
    method: 'delete'
  })
}
