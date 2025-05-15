import request from '@/utils/request'

// 查询练习题目关联表列表
export function listCorrelation(query) {
  return request({
    url: '/edu/correlation/list',
    method: 'get',
    params: query
  })
}

// 查询练习题目关联表详细
export function getCorrelation(id) {
  return request({
    url: '/edu/correlation/' + id,
    method: 'get'
  })
}

// 新增练习题目关联表
export function addCorrelation(data) {
  return request({
    url: '/edu/correlation',
    method: 'post',
    data: data
  })
}

// 修改练习题目关联表
export function updateCorrelation(data) {
  return request({
    url: '/edu/correlation',
    method: 'put',
    data: data
  })
}

// 删除练习题目关联表
export function delCorrelation(id) {
  return request({
    url: '/edu/correlation/' + id,
    method: 'delete'
  })
}
