export const SYSMENU_NAMESPACE = 'sysMenu';

export function SYSMENU_LIST(payload) {
  return {
    type: `${SYSMENU_NAMESPACE}/fetchList`,
    payload,
  };
}

export function SYSMENU_DETAIL(id) {
  return {
    type: `${SYSMENU_NAMESPACE}/fetchDetail`,
    payload: { id },
  };
}

export function SYSMENU_CLEAR_DETAIL() {
  return {
    type: `${SYSMENU_NAMESPACE}/clearDetail`,
    payload: {},
  };
}

export function SYSMENU_SUBMIT(payload) {
  return {
    type: `${SYSMENU_NAMESPACE}/submit`,
    payload,
  };
}

export function SYSMENU_REMOVE(payload) {
  return {
    type: `${SYSMENU_NAMESPACE}/remove`,
    payload,
  };
}
