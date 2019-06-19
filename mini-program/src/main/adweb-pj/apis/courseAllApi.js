import request from './request.js'

class courseAllApi {
  constructor() {
    const app = getApp();
    console.log(app);
    this._baseUrl = '';
    this._defaultHeader = { 'data-tupe': 'application/json' }
    this._request = new request
    this._request.setErrorHandler(this.errorHander)
  }

  //错误处理
  errorHander(res) {
    console.error(res)
  }

  getCourses(key = null) {
    let data = key != null ? {queryValue: key } : {}
    return this._request.getRequest(this._baseUrl + '/getAllCourses', data).then(res => res.data)
  }
}
export default courseAllApi