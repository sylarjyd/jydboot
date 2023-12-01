export const AUDITLOG_NAMESPACE = 'auditLog';

export function AUDITLOG_LIST(payload) {
  return {
    type: `${AUDITLOG_NAMESPACE}/fetchList`,
    payload,
  };
}

export function AUDITLOG_DETAIL(id) {
  return {
    type: `${AUDITLOG_NAMESPACE}/fetchDetail`,
    payload: { id },
  };
}

export function AUDITLOG_CLEAR_DETAIL() {
  return {
    type: `${AUDITLOG_NAMESPACE}/clearDetail`,
    payload: {},
  };
}

export function AUDITLOG_SUBMIT(payload) {
  return {
    type: `${AUDITLOG_NAMESPACE}/submit`,
    payload,
  };
}

export function AUDITLOG_REMOVE(payload) {
  return {
    type: `${AUDITLOG_NAMESPACE}/remove`,
    payload,
  };
}
