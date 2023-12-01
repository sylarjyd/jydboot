export const SOCIALACCOUNT_NAMESPACE = 'socialAccount';

export function SOCIALACCOUNT_LIST(payload) {
  return {
    type: `${SOCIALACCOUNT_NAMESPACE}/fetchList`,
    payload,
  };
}

export function SOCIALACCOUNT_DETAIL(id) {
  return {
    type: `${SOCIALACCOUNT_NAMESPACE}/fetchDetail`,
    payload: { id },
  };
}

export function SOCIALACCOUNT_CLEAR_DETAIL() {
  return {
    type: `${SOCIALACCOUNT_NAMESPACE}/clearDetail`,
    payload: {},
  };
}

export function SOCIALACCOUNT_SUBMIT(payload) {
  return {
    type: `${SOCIALACCOUNT_NAMESPACE}/submit`,
    payload,
  };
}

export function SOCIALACCOUNT_REMOVE(payload) {
  return {
    type: `${SOCIALACCOUNT_NAMESPACE}/remove`,
    payload,
  };
}
