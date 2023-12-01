export const SYSNOTICE_NAMESPACE = 'sysNotice';

export function SYSNOTICE_LIST(payload) {
  return {
    type: `${SYSNOTICE_NAMESPACE}/fetchList`,
    payload,
  };
}

export function SYSNOTICE_DETAIL(id) {
  return {
    type: `${SYSNOTICE_NAMESPACE}/fetchDetail`,
    payload: { id },
  };
}

export function SYSNOTICE_CLEAR_DETAIL() {
  return {
    type: `${SYSNOTICE_NAMESPACE}/clearDetail`,
    payload: {},
  };
}

export function SYSNOTICE_SUBMIT(payload) {
  return {
    type: `${SYSNOTICE_NAMESPACE}/submit`,
    payload,
  };
}

export function SYSNOTICE_REMOVE(payload) {
  return {
    type: `${SYSNOTICE_NAMESPACE}/remove`,
    payload,
  };
}
