import request from '@/utils/request'

// 查询物料类别列表
export function listCategory(query) {
  return request({
    url: '/shopping/category/list',
    method: 'get',
    params: query
  })
}

// 查询物料类别详细
export function getCategory(categoryId) {
  return request({
    url: '/shopping/category/' + categoryId,
    method: 'get'
  })
}

//查询物料类别父级列表
export function ParentCategoryList(parentCategory) {
  return request({
    url: '/shopping/category/ParentCategoryList',
    method: 'get',
    params:parentCategory
  })
}

// 新增物料类别
export function addCategory(data) {
  return request({
    url: '/shopping/category',
    method: 'post',
    data: data
  })
}

// 修改物料类别
export function updateCategory(data) {
  return request({
    url: '/shopping/category',
    method: 'put',
    data: data
  })
}

// 删除物料类别
export function delCategory(categoryId) {
  return request({
    url: '/shopping/category/' + categoryId,
    method: 'delete'
  })
}

