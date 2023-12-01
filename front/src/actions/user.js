export const USER_NAMESPACE = 'user';

export function USER_LIST(payload) {
  return {
    type: `${USER_NAMESPACE}/fetchList`,
    payload,
  };
}

export function USER_DETAIL(id) {
  return {
    type: `${USER_NAMESPACE}/fetchDetail`,
    payload: { id },
  };
}

export function USER_CLEAR_DETAIL() {
  return {
    type: `${USER_NAMESPACE}/clearDetail`,
    payload: {},
  };
}

export function USER_SUBMIT(payload) {
  return {
    type: `${USER_NAMESPACE}/submit`,
    payload,
  };
}

export function USER_REMOVE(payload) {
  return {
    type: `${USER_NAMESPACE}/remove`,
    payload,
  };
}
