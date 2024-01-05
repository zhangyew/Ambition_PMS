import request from '@/utils/request'

// 查询招标项目列表
export function listTender_projects(query) {
  return request({
    url: '/bidding/tender_projects/list',
    method: 'get',
    params: query
  })
}

// 查询招标项目详细
export function getTender_projects(tenderProjectsId) {
  return request({
    url: '/bidding/tender_projects/' + tenderProjectsId,
    method: 'get'
  })
}

// 查询合同签订物料信息
export function SHowsProjectRelatedItems(tenderProjectsId,noticeSupplierId) {
  return request({
    url: '/bidding/tender_projects/SHowsProjectRelatedItems?tenderProjectsId='+tenderProjectsId+"&noticeSupplierId="+noticeSupplierId,
    method: 'get',
  })
}

// 查询投标单物料信息
export function deskShows(tenderNoticeId,tenderProjectsId,vendorId) {
  return request({
    url: '/bidding/tender_projects/deskShows?tenderNoticeId='+tenderNoticeId+"&tenderProjectsId="+tenderProjectsId+"&vendorId="+vendorId,
    method: 'get',
  })
}

//合同签订根据项目显示供应商选择供应商
export function htShowVendorId(tenderProjectsId) {
  return request({
    url: '/bidding/tender_projects/htShowVendorId?tenderProjectsId='+tenderProjectsId,
    method: 'get',
  })
}

// 新增招标项目
export function addTender_projects(data) {
  return request({
    url: '/bidding/tender_projects',
    method: 'post',
    data: data
  })
}
export function ProSum() {
  return request({
    url: 'bidding/tender_projects/ProSum',
    method: 'get'
  })
}
// export function TenderSum() {
//   return request({
//     url: 'bidding/tender/TenderSum',
//     method: 'get'
//   })
// }
// 修改招标项目
export function updateTender_projects(data) {
  return request({
    url: '/bidding/tender_projects',
    method: 'put',
    data: data
  })
}

// 删除招标项目
export function delTender_projects(tenderProjectsId) {
  return request({
    url: '/bidding/tender_projects/' + tenderProjectsId,
    method: 'delete'
  })
}
// 删除专家被抽取表
export function delExtract(getExpertExtractId) {
  return request({
    url: '/bidding/extract/' + getExpertExtractId,
    method: 'delete'
  })
}
