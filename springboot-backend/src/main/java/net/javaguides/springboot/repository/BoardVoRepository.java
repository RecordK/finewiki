package net.javaguides.springboot.repository;

import net.javaguides.springboot.model.BoardVo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardVoRepository extends JpaRepository<BoardVo,Integer> {
}
