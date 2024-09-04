package com.example.dmc.domain.user.domain;

import com.example.dmc.domain.page.domain.Page;
import jakarta.persistence.*;
import lombok.*;

import javax.management.relation.Role;
import java.util.ArrayList;
import java.util.List;

@Builder
@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "account_id",nullable = false)
    private String accountId;

    private String password;

    private String name;

    private String introduce;

    private Role role;

    @Column(name = "user_image_url", columnDefinition = "TEXT")
    private String userImageUrl;

    @OneToMany(mappedBy = "user")
    private List<Page> pages = new ArrayList<>();

}
