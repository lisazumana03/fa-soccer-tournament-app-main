package za.co.footballassoc.soccertournament.domain.authentication;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import za.co.footballassoc.soccertournament.domain.Name;

import java.io.Serializable;

@Entity
@Table(name = "users")
public class User implements Serializable {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "user_id", updatable = false, nullable = false, columnDefinition = "UUID")
    private String userID;
    @Embedded
    private Name name;
    private String userName;
    private String email;
    private String password;
    private String phoneNumber;
    @Enumerated(EnumType.STRING)
    private Role role;

    public User(){}

    private User(Builder builder) {
        this.name = builder.name;
        this.userName = builder.userName;
        this.email = builder.email;
        this.password = builder.password;
        this.phoneNumber = builder.phoneNumber;
        this.role = builder.role;
    }

    public String getUserID() {
        return userID;
    }

    public Name getName() {
        return name;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return userName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Role getRole() {
        return role;
    }



    @Override
    public String toString() {
        return "User{" +
                "userID='" + userID + '\'' +
                ", name=" + name +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", role=" + role +
                '}';
    }

    public static class Builder {
        private Name name;
        private String userName;
        private String email;
        private String password;
        private String phoneNumber;
        private Role role;

        public Builder setName(Name name) {
            this.name = name;
            return this;
        }

        public Builder setUserName(String userName) {
            this.userName = userName;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder setRole(Role role) {
            this.role = role;
            return this;
        }

        public User build() {
            if (userName == null || userName.trim().isEmpty()) {
                throw new IllegalArgumentException("username cannot be null");
            }
            if (email == null || email.trim().isEmpty()) {
                throw new IllegalArgumentException("email cannot be null");
            }
            if (password == null || password.trim().isEmpty()) {
                throw new IllegalArgumentException("password cannot be null");
            }
            return new User(this);
        }

    }

}
