import request from './request.js'

class loginApi{
  constructor() {
    const app = getApp();
    console.log(app);
    this._baseUrl = '';
    this._defaultHeader = { 'content-type': 'application/json' }
    this._request = new request
    this._request.setErrorHandler(this.errorHander)
  }

  loginAuth(code){
    let data = {code : code};
    return this._request.getRequest(this._baseUrl + '/loginAuth ', data).then(res => res.data)
  }
}