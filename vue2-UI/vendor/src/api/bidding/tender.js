import request from '@/utils/request'

// //查询是否有无招标
export function selBidCount(query){
  return request({
    url: '/bidding/tender/selBidCount',
    method: 'get',
    params: query
  })
}
