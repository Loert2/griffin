import React from "react";
import { Route, Switch } from "react-router-dom";
import MainPage from "./components/MainPage";
import Authorisation from "./components/form/Authorisation";
import Registration from "./components/form/Registration";

const App = () => {
  return (
    <Switch>
      <Route exact path="/" component={MainPage} />
      <Route exact path="/Authorisation" component={Authorisation} />
      <Route exact path="/Registration" component={Registration} />
    </Switch>
  );
};

export default App;
