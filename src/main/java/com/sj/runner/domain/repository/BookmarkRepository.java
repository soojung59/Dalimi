package com.sj.runner.domain.repository;

import com.sj.runner.domain.entity.BookmarkEntity;
import com.sj.runner.domain.entity.MemberEntity;
import com.sj.runner.domain.entity.RecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookmarkRepository extends  JpaRepository<BookmarkEntity, Long> {

    Optional<BookmarkEntity> findBookmarkEntityByMemberAndRecord(MemberEntity member, String id);
}
