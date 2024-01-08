package com.busbooking.model.user;

public class UserStatus {
    private int status;
    private String statusMessage;
    private User user;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserStatus(int status, String statusMessage, User user) {
        this.status = status;
        this.statusMessage = statusMessage;
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserStatus{" +
                "status=" + status +
                ", statusMessage='" + statusMessage + '\'' +
                ", user=" + user +
                '}';
    }
}
