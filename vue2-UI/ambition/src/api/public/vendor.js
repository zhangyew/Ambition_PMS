import request from '@/utils/request'

// 查询供应商列表
export function listVendor(query) {
  return request({
    url: '/bidding/vendor/list',
    method: 'get',
    params: query
  })
}
export function showAll() {
  return request({
    url: '/bidding/vendor/showAll',
    method: 'get',
  })
}
// 查询合同总数量
export function VendorSum() {
  return request({
    url: 'bidding/vendor/VendorSum',
    method: 'get'
  })
}
// 查询供应商所有联系人
export function showContactsList(vendorId) {
  return request({
    url: '/bidding/vendor/showContactsList'+vendorId,
    method: 'get',
  })
}
// 查询供应商详细信息
export function findVendorDetailed(vid) {
  return request({
    url: '/bidding/vendor/findVendorDetailed' + vid,
    method: 'post'
  })
}

// 供应商注册
export function insertVendor(map) {
  return ({
    url: '/bidding/vendor/insertVendor',
    method: 'post',
    data: map
  })
}

// 查询供应商详细
export function getVendor(vendorId) {
  return request({
    url: '/bidding/vendor/' + vendorId,
    method: 'get'
  })
}

// 新增供应商
export function addVendor(data) {
  return request({
    url: '/bidding/vendor',
    method: 'post',
    data: data
  })
}

// 修改供应商
export function updateVendor(data) {
  return request({
    url: '/bidding/vendor',
    method: 'put',
    data: data
  })
}

// 删除供应商
export function delVendor(vendorId) {
  return request({
    url: '/bidding/vendor/' + vendorId,
    method: 'delete'
  })
}
