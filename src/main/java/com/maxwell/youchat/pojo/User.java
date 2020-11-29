package com.maxwell.youchat.pojo;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_user")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String username;

    private String password;

    private Integer sex; // 0-male 1-female

    private String introduction;

    private String icon;

}
