package net.javaguides.springboot.controller;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.BoardVo;
import net.javaguides.springboot.repository.BoardVoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardVoRepository bR;

    @GetMapping
    public List<BoardVo> getAllBoard(){
        return bR.findAll();
    }
    // build create Board REST API
    @PostMapping
    public BoardVo createBoard(@RequestBody BoardVo vo) {
        return bR.save(vo);
    }

    // build get BoardVo by no REST API
    @GetMapping("{no}")
    public ResponseEntity<BoardVo> getBoardVoByNo(@PathVariable  int no){
        BoardVo vo = bR.findById(no)
                .orElseThrow(() -> new ResourceNotFoundException("해당 아이디를 가진 회원이 존재하지 않습니다. :" + no));
        return ResponseEntity.ok(vo);
    }

    // build update BoardVo REST API
    @PutMapping("{no}")
    public ResponseEntity<BoardVo> updateBoardVo(@PathVariable int no, @RequestBody BoardVo boardDetails) {
        BoardVo updateBoardVo = bR.findById(no)
                .orElseThrow(() -> new ResourceNotFoundException("해당 번호의 게시판이 존재하지 않습니다. : " + no));

        updateBoardVo.setBoard_no(boardDetails.getBoard_no());
        updateBoardVo.setContent(boardDetails.getContent());
        updateBoardVo.setTitle(boardDetails.getTitle());

       bR.save(updateBoardVo);

        return ResponseEntity.ok(updateBoardVo);
    }

    // build delete Board REST API
    @DeleteMapping("{no}")
    public ResponseEntity<HttpStatus> deleteBoardVo(@PathVariable int no){

        BoardVo vo = bR.findById(no)
                .orElseThrow(() -> new ResourceNotFoundException("해당 번호의 게시판이 존재하지 않습니다. " + no));

        bR.delete(vo);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}