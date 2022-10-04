package com.sj.runner.domain.repository;

import com.sj.runner.domain.entity.BookmarkEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookmarkRepository extends  JpaRepository<BookmarkEntity, Long> {
}
