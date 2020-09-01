import { createActions } from 'redux-actions';

export const { notification } = createActions({
   NOTIFICATION: {
      ADD: (title, message, level, action) => ({ title, message, level, action }),
      CUSTOM: null
   }
});
