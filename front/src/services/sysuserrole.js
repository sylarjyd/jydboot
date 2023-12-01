import { stringify } from 'qs';
import func from '../utils/Func';
import request from '../utils/request';

export async function list(params) {
  return request(`/api/jydboot/sysuserrole/list?${stringify(params)}`);
}

export async function submit(params) {
  return request('/api/jydboot/sysuserrole/submit', {
    method: 'POST',
    body: params,
  });
}

export async function detail(params) {
  return request(`/api/jydboot/sysuserrole/detail?${stringify(params)}`);
}

export async function remove(params) {
  return request('/api/jydboot/sysuserrole/remove', {
    method: 'POST',
    body: func.toFormData(params),
  });
}
