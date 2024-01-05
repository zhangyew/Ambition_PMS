import request from '@/utils/request'

// 查询中标公告列表
export function listNotice(query) {
  return request({
    url: 'bidding/notice/list',
    method: 'get',
    params: query
  })
}
// 查询中标公告列表
export function selAll() {
  return request({
    url: 'bidding/notice/selAll',
    method: 'get',
  })
}

// 查询中标公告详细
export function getNotice(noticeId) {
  return request({
    url: 'bidding/notice/' + noticeId,
    method: 'get'
  })
}

// 新增中标公告
export function addNotice(data) {
  return request({
    url: 'bidding/notice',
    method: 'post',
    data: data
  })
}

// 修改中标公告
export function updateNotice(data) {
  return request({
    url: '/pms2/notice',
    method: 'put',
    data: data
  })
}

// 删除中标公告
export function delNotice(noticeId) {
  return request({
    url: 'bidding/notice/' + noticeId,
    method: 'delete'
  })
}
