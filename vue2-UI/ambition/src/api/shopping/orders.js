import request from '@/utils/request'

// 查询采购订单表列表
export function listOrders(query) {
  return request({
    url: '/shopping/orders/list',
    method: 'get',
    params: query
  })
}
export function showOO() {
  return request({
    url: '/shopping/orders/showOO',
    method: 'get',
  })
}
// 改变审批状态
export function updateExamine(data) {
  return request({
    url: '/shopping/orders/updateExamine',
    method: 'post',
    data: data
  })
}
// 查询采购订单表详细
export function getOrders(orderId) {
  return request({
    url: '/shopping/orders/' + orderId,
    method: 'get'
  })
}

// 收货单（详情显示）
export function showsDetailsReceipt(orderId) {
  return request({
    url: '/shopping/orders/showsDetailsReceipt/' + orderId,
    method: 'get'
  })
}

// 供应商首页（我的订单）
export function showSupplierId(oSupplierId) {
  return request({
    url: '/shopping/orders/showOrderSupplierId/',
    method: 'get',
    params:oSupplierId
  })
}

// 新增采购订单表
export function addOrders(data) {
  return request({
    url: '/shopping/orders',
    method: 'post',
    data: data
  })
}
// 新增采购订单表1
export function addOrders1(data) {
  return request({
    url: '/shopping/orders/addOrders',
    method: 'post',
    data: data
  })
}
// 查询合同总数量
export function OrderSum() {
  return request({
    url: 'shopping/orders/OrderSum',
    method: 'get'
  })
}
// 修改采购订单表
export function updateOrders(data) {
  return request({
    url: '/shopping/orders',
    method: 'put',
    data: data
  })
}
// 修改待收货状态
export function updateOrderState(orderId) {
  return request({
    url: '/shopping/orders/updateOrderState/'+ orderId,
    method: 'put'
  })
}
// 改变审批状态
export function updateExamine1(data) {
  return request({
    url: '/shopping/orders/updateExamine1',
    method: 'post',
    data: data
  })
}
// 删除采购订单表
export function delOrders(orderId) {
  return request({
    url: '/shopping/orders/' + orderId,
    method: 'delete'
  })
}
