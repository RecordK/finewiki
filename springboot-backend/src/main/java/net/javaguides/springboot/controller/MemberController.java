package net.javaguides.springboot.controller;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.MemberVo;
import net.javaguides.springboot.repository.MemberVoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/member")
public class MemberController {

    @Autowired
    private MemberVoRepository mR;

    @GetMapping
    public List<MemberVo> getAllMembers(){
        return mR.findAll();
    }
    // build create Member REST API
    @PostMapping
    public MemberVo createMember(@RequestBody MemberVo vo) {
        return mR.save(vo);
    }

    // build get MemberVo by id REST API
    @GetMapping("{id}")
    public ResponseEntity<MemberVo> getMemberVoById(@PathVariable  String id){
        MemberVo vo = mR.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("해당 아이디를 가진 회원이 존재하지 않습니다. :" + id));
        return ResponseEntity.ok(vo);
    }

    // build update MemberVo REST API
    @PutMapping("{id}")
    public ResponseEntity<MemberVo> updateMemberVo(@PathVariable String id,@RequestBody MemberVo memberDetails) {
        MemberVo updateMemberVo = mR.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("해당 아이디를 가진 회원이 존재하지 않습니다. : " + id));

        updateMemberVo.setNick(memberDetails.getNick());
        updateMemberVo.setEmail(memberDetails.getEmail());
        updateMemberVo.setPw(memberDetails.getPw());

        mR.save(updateMemberVo);

        return ResponseEntity.ok(updateMemberVo);
    }

    // build delete member REST API
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteMemberVo(@PathVariable String id){

        MemberVo vo = mR.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("해당 아이디를 가진 회원이 존재하지 않습니다: " + id));

        mR.delete(vo);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}