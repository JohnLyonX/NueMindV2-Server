import request from '@/utils/request'

// 查询学生提交答案表列表
export function listAnswers(query) {
  return request({
    url: '/edu/answers/list',
    method: 'get',
    params: query
  })
}

// 查询学生提交答案表详细
export function getAnswers(answerId) {
  return request({
    url: '/edu/answers/' + answerId,
    method: 'get'
  })
}

// 新增学生提交答案表
export function addAnswers(data) {
  return request({
    url: '/edu/answers',
    method: 'post',
    data: data
  })
}

// 修改学生提交答案表
export function updateAnswers(data) {
  return request({
    url: '/edu/answers',
    method: 'put',
    data: data
  })
}

// 删除学生提交答案表
export function delAnswers(answerId) {
  return request({
    url: '/edu/answers/' + answerId,
    method: 'delete'
  })
}
