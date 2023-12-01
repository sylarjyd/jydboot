export const DISTRICT_NAMESPACE = 'district';

export function DISTRICT_LIST(payload) {
  return {
    type: `${DISTRICT_NAMESPACE}/fetchList`,
    payload,
  };
}

export function DISTRICT_DETAIL(id) {
  return {
    type: `${DISTRICT_NAMESPACE}/fetchDetail`,
    payload: { id },
  };
}

export function DISTRICT_CLEAR_DETAIL() {
  return {
    type: `${DISTRICT_NAMESPACE}/clearDetail`,
    payload: {},
  };
}

export function DISTRICT_SUBMIT(payload) {
  return {
    type: `${DISTRICT_NAMESPACE}/submit`,
    payload,
  };
}

export function DISTRICT_REMOVE(payload) {
  return {
    type: `${DISTRICT_NAMESPACE}/remove`,
    payload,
  };
}
