import request from '@/utils/request'

// 查询采购需求物料表列表
export function listDemand(query) {
  return request({
    url: '/pms/shopping/demand/list',
    method: 'get',
    params: query
  })
}

// 查询采购需求物料表详细
export function getDemand(demandId) {
  return request({
    url: '/pms/shopping/demand/' + demandId,
    method: 'get'
  })
}

// 收货单物料信息
export function showDemand(demandId) {
    return request({
      url: '/shopping/demand/showDemand/' + demandId,
      method: 'get'
    })
  }

// 新增采购需求物料表
export function addDemand(data) {
  return request({
    url: '/pms/shopping/demand',
    method: 'post',
    data: data
  })
}

// 修改采购需求物料表
export function updateDemand(data) {
  return request({
    url: '/pms/shopping/demand',
    method: 'put',
    data: data
  })
}

// 删除采购需求物料表
export function delDemand(demandId) {
  return request({
    url: '/pms/shopping/demand/' + demandId,
    method: 'delete'
  })
}
