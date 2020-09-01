import { notification } from './actions';
import openLoginWindow from "../../../session/LoginTab";
import {getSession} from "../../../session/store/service"

export const notifyError = (error = {}, title, message) => (dispatch) => {
   if (error.status === 403) {
      return dispatch(notification.add(
         'Ошибка авторизации',
         'Произошла ошибка при выполнении операции. Возможно завершилась сессия, попробуйте перезайти в систему.',
         'error',
          {
             label: 'Войти в систему',
             callback: function () {
                 const msg = openLoginWindow();
                 msg.then(user => {
                     dispatch(getSession());
                 });
             }
          }
      ));
   } else {
      return dispatch(notification.add(title, message || error.message, 'error'));
   }
};

export const notifySuccess = (title, message) => notification.add(title, message, 'success');

export const sendCustomNotification = (customNotification) => (dispatch) => {
   dispatch(notification.custom(customNotification));
};
