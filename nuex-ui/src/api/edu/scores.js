import request from '@/utils/request'

// 查询成绩表列表
export function listScores(query) {
  return request({
    url: '/edu/scores/list',
    method: 'get',
    params: query
  })
}

// 查询成绩表详细
export function getScores(scoreId) {
  return request({
    url: '/edu/scores/' + scoreId,
    method: 'get'
  })
}

// 新增成绩表
export function addScores(data) {
  return request({
    url: '/edu/scores',
    method: 'post',
    data: data
  })
}

// 修改成绩表
export function updateScores(data) {
  return request({
    url: '/edu/scores',
    method: 'put',
    data: data
  })
}

// 删除成绩表
export function delScores(scoreId) {
  return request({
    url: '/edu/scores/' + scoreId,
    method: 'delete'
  })
}
