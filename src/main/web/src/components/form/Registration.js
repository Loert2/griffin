import React, { Component } from "react";
import { bindActionCreators } from "redux";
import { connect } from "react-redux";
import { FormContainer, InputField } from "vetrf-ui";

import * as userService from "../../store/user/service";
import * as catalogSelectors from "../../store/selectors";

class Registration extends Component {
  handleAuhtSubmit = ({ login, email, password }) => {
    const { userService, history } = this.props;
    const { registrationUser } = userService;
    registrationUser({ login, email, password });
    history.push("/");
  };

  render() {
    return (
      <FormContainer onSubmit={(data) => this.handleAuhtSubmit(data)}>
        <InputField
          name="login"
          labelText="Логин"
          required="Поле не заполнено"
        />
        <InputField
          name="email"
          labelText="Электронная почта"
          required="Поле не заполнено"
        />
        <InputField
          name="password"
          labelText="Пароль"
          required="Поле не заполнено"
        />
      </FormContainer>
    );
  }
}

const mapStateToProps = (state) => ({
  user: catalogSelectors.getUser(state),
});

const mapDispatchToProps = (dispatch) => ({
  userService: bindActionCreators(userService, dispatch),
});

export default connect(mapStateToProps, mapDispatchToProps)(Registration);
