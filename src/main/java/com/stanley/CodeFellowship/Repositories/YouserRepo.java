package com.stanley.CodeFellowship.Repositories;

import com.stanley.CodeFellowship.Models.Youser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface YouserRepo extends JpaRepository<Youser, Long> {
    Youser findByUsername(String username);
}
