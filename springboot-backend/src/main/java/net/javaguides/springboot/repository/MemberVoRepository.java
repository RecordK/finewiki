package net.javaguides.springboot.repository;

import net.javaguides.springboot.model.MemberVo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface MemberVoRepository extends JpaRepository<MemberVo,String> {
       // all crud database methods
    }
