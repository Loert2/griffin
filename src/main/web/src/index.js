import React, { Suspense } from "react";
import ReactDOM from "react-dom";
import App from "./App";

import { createStore, applyMiddleware } from "redux";
import { Provider } from "react-redux";
import thunk from "redux-thunk";
import { BrowserRouter } from "react-router-dom";
import { composeWithDevTools } from "redux-devtools-extension";
import rootReducer from "./store/reducers";
import { ScrollToTop } from "vetrf-ui";

import "./i18n";

const store = createStore(
  rootReducer,
  composeWithDevTools(applyMiddleware(thunk))
);

ReactDOM.render(
  <BrowserRouter>
    <Provider store={store}>
      <ScrollToTop>
        <Suspense fallback={<div />}>
          <App />
        </Suspense>
      </ScrollToTop>
    </Provider>
  </BrowserRouter>,
  document.getElementById("root")
);
