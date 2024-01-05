import request from '@/utils/request'

// 查询采购计划表列表
export function listBuy_plan(query) {
  return request({
    url: '/shopping/buy_plan/list',
    method: 'get',
    params: query
  })
}

// 查询采购计划（合同签订[状态:通过]）
export function listBuyPlan(buyPlan) {
  console.log("ayfcyguh:"+buyPlan)
  return request({
    url: '/shopping/buy_plan/showBuyPlan'+buyPlan,
    method: 'get'
  })
}

// 查询采购计划表详细
export function getBuy_plan(buyPlanId) {
  return request({
    url: '/shopping/buy_plan/' + buyPlanId,
    method: 'get'
  })
}

// 新增采购计划表
export function addBuy_plan(data) {
  return request({
    url: '/shopping/buy_plan',
    method: 'post',
    data: data
  })
}

// 修改采购计划表
export function updateBuy_plan(data) {
  return request({
    url: '/shopping/buy_plan',
    method: 'put',
    data: data
  })
}
// 改变审批状态
export function updateExamine(data) {
  return request({
    url: '/shopping/buy_plan/updateExamine',
    method: 'post',
    data: data
  })
}
export function upState(bid) {
  return request({
    url: '/shopping/buy_plan/upState/'+bid,
    method: 'get',
  })
}
// 删除采购计划表
export function delBuy_plan(buyPlanId) {
  return request({
    url: '/shopping/buy_plan/' + buyPlanId,
    method: 'delete'
  })
}
