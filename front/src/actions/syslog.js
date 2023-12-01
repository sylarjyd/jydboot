export const SYSLOG_NAMESPACE = 'sysLog';

export function SYSLOG_LIST(payload) {
  return {
    type: `${SYSLOG_NAMESPACE}/fetchList`,
    payload,
  };
}

export function SYSLOG_DETAIL(id) {
  return {
    type: `${SYSLOG_NAMESPACE}/fetchDetail`,
    payload: { id },
  };
}

export function SYSLOG_CLEAR_DETAIL() {
  return {
    type: `${SYSLOG_NAMESPACE}/clearDetail`,
    payload: {},
  };
}

export function SYSLOG_SUBMIT(payload) {
  return {
    type: `${SYSLOG_NAMESPACE}/submit`,
    payload,
  };
}

export function SYSLOG_REMOVE(payload) {
  return {
    type: `${SYSLOG_NAMESPACE}/remove`,
    payload,
  };
}
