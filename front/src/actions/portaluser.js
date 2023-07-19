export const PORTALUSER_NAMESPACE = 'portalUser';

export function PORTALUSER_LIST(payload) {
  return {
    type: `${PORTALUSER_NAMESPACE}/fetchList`,
    payload,
  };
}

export function PORTALUSER_DETAIL(id) {
  return {
    type: `${PORTALUSER_NAMESPACE}/fetchDetail`,
    payload: { id },
  };
}

export function PORTALUSER_CLEAR_DETAIL() {
  return {
    type: `${PORTALUSER_NAMESPACE}/clearDetail`,
    payload: {},
  };
}

export function PORTALUSER_SUBMIT(payload) {
  return {
    type: `${PORTALUSER_NAMESPACE}/submit`,
    payload,
  };
}

export function PORTALUSER_REMOVE(payload) {
  return {
    type: `${PORTALUSER_NAMESPACE}/remove`,
    payload,
  };
}
