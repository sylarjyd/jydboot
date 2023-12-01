export const SYSUSER_NAMESPACE = 'sysUser';

export function SYSUSER_LIST(payload) {
  return {
    type: `${SYSUSER_NAMESPACE}/fetchList`,
    payload,
  };
}

export function SYSUSER_DETAIL(id) {
  return {
    type: `${SYSUSER_NAMESPACE}/fetchDetail`,
    payload: { id },
  };
}

export function SYSUSER_CLEAR_DETAIL() {
  return {
    type: `${SYSUSER_NAMESPACE}/clearDetail`,
    payload: {},
  };
}

export function SYSUSER_SUBMIT(payload) {
  return {
    type: `${SYSUSER_NAMESPACE}/submit`,
    payload,
  };
}

export function SYSUSER_REMOVE(payload) {
  return {
    type: `${SYSUSER_NAMESPACE}/remove`,
    payload,
  };
}
