import request from '@/utils/request'

// 查询合同明细列表
export function listContractdetails(query) {
  return request({
    url: 'bidding/contractdetails/list',
    method: 'get',
    params: query
  })
}

// 供应商合同列表
export function selectVendorList(vendorId) {
  return request({
    url: '/bidding/contractdetails/selectVendorList',
    method: 'get',
    params: vendorId
  })
}

// 显示供应商列表
export function listVendor(vendor_id) {
  return request({
    url: '/bidding/contractdetails/showsPublicVendorList',
    method: 'get',
    params:vendor_id
  })
}

// 供应商首页（我的合同）
export function listVendorContract(vendorId) {
  return request({
    url: '/bidding/contractdetails/VendorContractId',
    method: 'get',
    params:vendorId
  })
}

// 查询合同总数量
export function ContractCountList() {
  return request({
    url: 'bidding/contractdetails/ContractCount',
    method: 'get'
  })
}

// 查询合同总金额
export function ContractSumList() {
  return request({
    url: 'bidding/contractdetails/ContractSum',
    method: 'get'
  })
}

//改变状态6
export function upConState(conId) {
  return request({
    url: '/bidding/contractdetails/upConState/'+conId,
    method: 'get',
  })
}
// 查询合同明细详细
export function Shows(contractdetailsId) {
  return request({
    url: '/bidding/contractdetails/Shows/' + contractdetailsId,
    method: 'get'
  })
}

// 查询合同明细详细
export function getContractdetails(contractdetailsId) {
  return request({
    url: '/bidding/contractdetails/' + contractdetailsId,
    method: 'get'
  })
}

// 新增合同明细
export function addContractdetails(data) {
  return request({
    url: '/bidding/contractdetails/add',
    method: 'post',
    data: data
  })
}

// 新增签署执行状态
export function addSigning(data) {
  return request({
    url: '/bidding/contractdetails/signingAdd',
    method: 'post',
    data: data
  })
}

// 修改合同明细
export function updateContractdetails(data) {
  return request({
    url: '/bidding/contractdetails',
    method: 'put',
    data: data
  })
}

// 删除合同明细
export function delContractdetails(contractdetailsId) {
  return request({
    url: '/pms.public/contractdetails/' + contractdetailsId,
    method: 'delete'
  })
}

// 查询合同总数量
export function ContractCountLists(vendorId) {
  return request({
    url: 'bidding/contractdetails/ContractCounts',
    method: 'get',
    params:vendorId
  })
}

// 查询合同总金额
export function ContractSumLists(vendorId) {
  return request({
    url: 'bidding/contractdetails/ContractSums',
    method: 'get',
    params:vendorId
  })
}
