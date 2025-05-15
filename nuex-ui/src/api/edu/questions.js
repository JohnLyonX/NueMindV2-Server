import request from '@/utils/request'

// 查询练习题目列表
export function listQuestions(query) {
  return request({
    url: '/edu/questions/list',
    method: 'get',
    params: query
  })
}

// 查询练习题目详细
export function getQuestions(questionId) {
  return request({
    url: '/edu/questions/' + questionId,
    method: 'get'
  })
}

// 新增练习题目
export function addQuestions(data) {
  return request({
    url: '/edu/questions',
    method: 'post',
    data: data
  })
}

// 修改练习题目
export function updateQuestions(data) {
  return request({
    url: '/edu/questions',
    method: 'put',
    data: data
  })
}

// 删除练习题目
export function delQuestions(questionId) {
  return request({
    url: '/edu/questions/' + questionId,
    method: 'delete'
  })
}
