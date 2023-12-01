export const SYSROLE_NAMESPACE = 'sysRole';

export function SYSROLE_LIST(payload) {
  return {
    type: `${SYSROLE_NAMESPACE}/fetchList`,
    payload,
  };
}

export function SYSROLE_DETAIL(id) {
  return {
    type: `${SYSROLE_NAMESPACE}/fetchDetail`,
    payload: { id },
  };
}

export function SYSROLE_CLEAR_DETAIL() {
  return {
    type: `${SYSROLE_NAMESPACE}/clearDetail`,
    payload: {},
  };
}

export function SYSROLE_SUBMIT(payload) {
  return {
    type: `${SYSROLE_NAMESPACE}/submit`,
    payload,
  };
}

export function SYSROLE_REMOVE(payload) {
  return {
    type: `${SYSROLE_NAMESPACE}/remove`,
    payload,
  };
}
