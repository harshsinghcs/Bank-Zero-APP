package com.bankchor.repository;

import com.bankchor.entity.Bankchor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankchorRepository extends JpaRepository<Bankchor, Long> {
}
