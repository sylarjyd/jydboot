export const SYSROLEMENU_NAMESPACE = 'sysRoleMenu';

export function SYSROLEMENU_LIST(payload) {
  return {
    type: `${SYSROLEMENU_NAMESPACE}/fetchList`,
    payload,
  };
}

export function SYSROLEMENU_DETAIL(id) {
  return {
    type: `${SYSROLEMENU_NAMESPACE}/fetchDetail`,
    payload: { id },
  };
}

export function SYSROLEMENU_CLEAR_DETAIL() {
  return {
    type: `${SYSROLEMENU_NAMESPACE}/clearDetail`,
    payload: {},
  };
}

export function SYSROLEMENU_SUBMIT(payload) {
  return {
    type: `${SYSROLEMENU_NAMESPACE}/submit`,
    payload,
  };
}

export function SYSROLEMENU_REMOVE(payload) {
  return {
    type: `${SYSROLEMENU_NAMESPACE}/remove`,
    payload,
  };
}
