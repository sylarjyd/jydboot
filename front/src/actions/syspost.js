export const SYSPOST_NAMESPACE = 'sysPost';

export function SYSPOST_LIST(payload) {
  return {
    type: `${SYSPOST_NAMESPACE}/fetchList`,
    payload,
  };
}

export function SYSPOST_DETAIL(id) {
  return {
    type: `${SYSPOST_NAMESPACE}/fetchDetail`,
    payload: { id },
  };
}

export function SYSPOST_CLEAR_DETAIL() {
  return {
    type: `${SYSPOST_NAMESPACE}/clearDetail`,
    payload: {},
  };
}

export function SYSPOST_SUBMIT(payload) {
  return {
    type: `${SYSPOST_NAMESPACE}/submit`,
    payload,
  };
}

export function SYSPOST_REMOVE(payload) {
  return {
    type: `${SYSPOST_NAMESPACE}/remove`,
    payload,
  };
}
