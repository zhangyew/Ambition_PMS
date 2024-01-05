import request from '@/utils/request'

// //查询是否有无招标
export function selBidCount(query){
  return request({
    url: '/bidding/tender/selBidCount',
    method: 'get',
    params: query
  })
}

// 投标
export function addTender(data) {
  return request({
    url: '/bidding/tender',
    method: 'post',
    data: data
  })
}
// 查询投标总数量
export function TenderSum() {
  return request({
    url: 'bidding/tender/TenderSum',
    method: 'get'
  })
}