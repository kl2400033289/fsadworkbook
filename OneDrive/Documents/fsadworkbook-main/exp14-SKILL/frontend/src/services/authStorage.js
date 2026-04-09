const STORAGE_KEY = "exp14_logged_in_user";

export const getStoredUser = () => {
  const raw = window.localStorage.getItem(STORAGE_KEY);
  if (!raw) {
    return null;
  }

  try {
    return JSON.parse(raw);
  } catch {
    return null;
  }
};

export const setStoredUser = (user) => {
  window.localStorage.setItem(STORAGE_KEY, JSON.stringify(user));
};

export const clearStoredUser = () => {
  window.localStorage.removeItem(STORAGE_KEY);
};
