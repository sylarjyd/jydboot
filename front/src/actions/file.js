export const FILE_NAMESPACE = 'file';

export function FILE_LIST(payload) {
  return {
    type: `${FILE_NAMESPACE}/fetchList`,
    payload,
  };
}

export function FILE_DETAIL(id) {
  return {
    type: `${FILE_NAMESPACE}/fetchDetail`,
    payload: { id },
  };
}

export function FILE_CLEAR_DETAIL() {
  return {
    type: `${FILE_NAMESPACE}/clearDetail`,
    payload: {},
  };
}

export function FILE_SUBMIT(payload) {
  return {
    type: `${FILE_NAMESPACE}/submit`,
    payload,
  };
}

export function FILE_REMOVE(payload) {
  return {
    type: `${FILE_NAMESPACE}/remove`,
    payload,
  };
}
