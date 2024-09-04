package com.example.dmc.domain.page.domain.repository;

import com.example.dmc.domain.page.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface PageRepository extends JpaRepository<Page,String> {
    Page findByPageId(String pageId);

}
