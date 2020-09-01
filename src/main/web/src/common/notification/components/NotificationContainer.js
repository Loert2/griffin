import React, { Component } from "react";
import PropTypes from "prop-types";
import NotificationSystem from "react-notification-system";
import { connect } from "react-redux";

class NotificationContainer extends Component {
  componentDidMount() {
    this.notificationSystem = this.refs.notificationSystem;
  }

  componentDidUpdate(prevProps) {
    const { notification } = this.props;
    if (
      notification &&
      (notification.title || notification.message) &&
      notification.level
    ) {
      this.notificationSystem.addNotification(notification);
    }
  }

  render() {
    return <NotificationSystem ref="notificationSystem" />;
  }
}

NotificationContainer.propTypes = {
  message: PropTypes.string,
  level: PropTypes.string,
};

const mapStateToProps = (state) => ({
  notification: state.common.notificationStore,
});

export default connect(mapStateToProps)(NotificationContainer);
