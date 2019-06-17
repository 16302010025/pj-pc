import request from './request.js'

class courseSelfApi {
  constructor() {
    const app = getApp();
    console.log(app);
    this._baseUrl = '';
    this._defaultHeader = { 'data-tupe': 'application/json' }
    this._request = new request
    this._request.setErrorHandler(this.errorHander)
  }

//错误处理
  errorHander(res){
    console.error(res)
  }

  getCourses(user_id, key=null){
    let data = key != null ? { my_id: my_id, queryValue: key } : { my_id: my_id }
    // let data = null;
    return this._request.getRequest(this._baseUrl + '/user/getAll', data).then(res => res.data)
  }
}
export default courseSelfApi