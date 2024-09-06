package com.example.dmc.domain.user.domain;

import com.example.dmc.domain.page.domain.Page;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.management.relation.Role;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Builder
@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class User {

    @Id @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name="uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID userId;

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
