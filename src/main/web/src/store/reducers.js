import { combineReducers } from "redux";

import userStore from "./user/reducer";
import userListStore from "./userList/reducer";

export default combineReducers({
  userStore,
  userListStore,
});
