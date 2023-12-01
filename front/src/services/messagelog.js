import { stringify } from 'qs';
import func from '../utils/Func';
import request from '../utils/request';

export async function list(params) {
  return request(`/api/jydboot/messagelog/list?${stringify(params)}`);
}

export async function submit(params) {
  return request('/api/jydboot/messagelog/submit', {
    method: 'POST',
    body: params,
  });
}

export async function detail(params) {
  return request(`/api/jydboot/messagelog/detail?${stringify(params)}`);
}

export async function remove(params) {
  return request('/api/jydboot/messagelog/remove', {
    method: 'POST',
    body: func.toFormData(params),
  });
}
