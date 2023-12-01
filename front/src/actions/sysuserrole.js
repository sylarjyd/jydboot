export const SYSUSERROLE_NAMESPACE = 'sysUserRole';

export function SYSUSERROLE_LIST(payload) {
  return {
    type: `${SYSUSERROLE_NAMESPACE}/fetchList`,
    payload,
  };
}

export function SYSUSERROLE_DETAIL(id) {
  return {
    type: `${SYSUSERROLE_NAMESPACE}/fetchDetail`,
    payload: { id },
  };
}

export function SYSUSERROLE_CLEAR_DETAIL() {
  return {
    type: `${SYSUSERROLE_NAMESPACE}/clearDetail`,
    payload: {},
  };
}

export function SYSUSERROLE_SUBMIT(payload) {
  return {
    type: `${SYSUSERROLE_NAMESPACE}/submit`,
    payload,
  };
}

export function SYSUSERROLE_REMOVE(payload) {
  return {
    type: `${SYSUSERROLE_NAMESPACE}/remove`,
    payload,
  };
}
