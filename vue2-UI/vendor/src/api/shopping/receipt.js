import request from '@/utils/request'
import axios from 'axios'

// 查询待货列表
export function listReceipt(query) {
  return request({
    url: '/shopping/receipt/list',
    method: 'get',
    params: query
  })
}

// 查询收货列表
export function ShowsPublicReceiptList(query) {
  return request({
    url: '/shopping/receipt/ShowsPublicReceiptList',
    method: 'get',
    params: query
  })
}

// 查询收货单详细
export function getReceipt(receiptId) {
  return request({
    url: '/shopping/receipt/' + receiptId,
    method: 'get'
  })
}

// 新增收货单
export function addReceipt(data) {
  return request({
    url: '/shopping/receipt/add',
    method: 'post',
    Headers:'multipart/form-data',
    data: data,
  })
  
}

// 修改收货单
export function updateReceipt(data) {
  return request({
    url: '/shopping/receipt',
    method: 'put',
    data: data
  })
}

// 删除收货单
export function delReceipt(receiptId) {
  return request({
    url: '/shopping/receipt/' + receiptId,
    method: 'delete'
  })
}
