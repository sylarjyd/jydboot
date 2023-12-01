export const SYSDEPT_NAMESPACE = 'sysDept';

export function SYSDEPT_LIST(payload) {
  return {
    type: `${SYSDEPT_NAMESPACE}/fetchList`,
    payload,
  };
}

export function SYSDEPT_DETAIL(id) {
  return {
    type: `${SYSDEPT_NAMESPACE}/fetchDetail`,
    payload: { id },
  };
}

export function SYSDEPT_CLEAR_DETAIL() {
  return {
    type: `${SYSDEPT_NAMESPACE}/clearDetail`,
    payload: {},
  };
}

export function SYSDEPT_SUBMIT(payload) {
  return {
    type: `${SYSDEPT_NAMESPACE}/submit`,
    payload,
  };
}

export function SYSDEPT_REMOVE(payload) {
  return {
    type: `${SYSDEPT_NAMESPACE}/remove`,
    payload,
  };
}
