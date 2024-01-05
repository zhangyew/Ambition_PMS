import request from '@/utils/request'

// 查询合同申请表列表
export function listAgreement(query) {
  return request({
    url: '/bidding/agreement/list',
    method: 'get',
    params: query
  })
}
// 查询相关项目
export function listTenderProjects(tenderProjectsNumber) {
  return request({
    url: '/bidding/agreement/agreementTenderProjects'+tenderProjectsNumber,
    method: 'get'
  })
}
// 查询相关主合同
export function listContractParent(contractParent) {
  return request({
    url: '/bidding/agreement/ShowPublicAgreement'+contractParent,
    method: 'get'
  })
}

// 新增合同申请表
export function addAgreement(data) {
  return request({
    url: '/bidding/agreement',
    method: 'post',
    data: data
  })
}

// 修改合同申请表
export function updateAgreement(data) {
  return request({
    url: '/bidding/agreement',
    method: 'put',
    data: data
  })
}

// 删除合同申请表
export function delAgreement(contractId) {
  return request({
    url: '/bidding/agreement/' + contractId,
    method: 'delete'
  })
}
