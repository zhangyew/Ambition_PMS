import request from '@/utils/request'

// 查询招标公告列表
export function listTender_notice(query) {
  return request({
    url: '/bidding/tender_notice/list',
    method: 'get',
    params: query
  })
}
//查询供应商端的所有招标公告
export function selAllByGys() {
  return request({
    url: 'bidding/tender_notice/selAllByGys',
    method: 'get',
  })
}
export function bidNeed() {
  return request({
    url: 'bidding/tender_notice/bidNeed',
    method: 'get',
  })
}
// 供应商首页（招投标信息显示）
export function ShowsTenderNoticeList() {
    return request({
      url: 'bidding/tender_notice/ShowsTenderNoticeList',
      method: 'get'
    })
  }

export function showsNoticeList() {
    return request({
      url: 'bidding/tender_notice/showsNoticeList',
      method: 'get'
    })
  }

    // 供应商首页（通知公告）
export function displayTenderNoticeList() {
  return request({
    url: 'bidding/tender_notice/displayTenderNoticeList',
    method: 'get'
  })
}

// 查询招标公告详细
export function getTender_notice(tenderNoticeId) {
  return request({
    url: '/pms/bidding/tender_notice/' + tenderNoticeId,
    method: 'get'
  })
}

// 新增招标公告
export function addTender_notice(data) {
  return request({
    url: '/pms/bidding/tender_notice',
    method: 'post',
    data: data
  })
}

// 修改招标公告
export function updateTender_notice(data) {
  return request({
    url: '/pms/bidding/tender_notice',
    method: 'put',
    data: data
  })
}

// 删除招标公告
export function delTender_notice(tenderNoticeId) {
  return request({
    url: '/pms/bidding/tender_notice/' + tenderNoticeId,
    method: 'delete'
  })
}

// 删除公告附件
export function delAnnex(annexId) {
  return request({
    url: '/bidding/annex/' + annexId,
    method: 'delete'
  })
}