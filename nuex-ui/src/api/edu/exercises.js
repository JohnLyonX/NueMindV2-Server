import request from '@/utils/request'

// 查询练习集合列表
export function listExercises(query) {
  return request({
    url: '/edu/exercises/list',
    method: 'get',
    params: query
  })
}

// 查询练习集合详细
export function getExercises(exerciseId) {
  return request({
    url: '/edu/exercises/' + exerciseId,
    method: 'get'
  })
}

// 新增练习集合
export function addExercises(data) {
  return request({
    url: '/edu/exercises',
    method: 'post',
    data: data
  })
}

// 修改练习集合
export function updateExercises(data) {
  return request({
    url: '/edu/exercises',
    method: 'put',
    data: data
  })
}

// 删除练习集合
export function delExercises(exerciseId) {
  return request({
    url: '/edu/exercises/' + exerciseId,
    method: 'delete'
  })
}
