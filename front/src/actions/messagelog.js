export const MESSAGELOG_NAMESPACE = 'messageLog';

export function MESSAGELOG_LIST(payload) {
  return {
    type: `${MESSAGELOG_NAMESPACE}/fetchList`,
    payload,
  };
}

export function MESSAGELOG_DETAIL(id) {
  return {
    type: `${MESSAGELOG_NAMESPACE}/fetchDetail`,
    payload: { id },
  };
}

export function MESSAGELOG_CLEAR_DETAIL() {
  return {
    type: `${MESSAGELOG_NAMESPACE}/clearDetail`,
    payload: {},
  };
}

export function MESSAGELOG_SUBMIT(payload) {
  return {
    type: `${MESSAGELOG_NAMESPACE}/submit`,
    payload,
  };
}

export function MESSAGELOG_REMOVE(payload) {
  return {
    type: `${MESSAGELOG_NAMESPACE}/remove`,
    payload,
  };
}
