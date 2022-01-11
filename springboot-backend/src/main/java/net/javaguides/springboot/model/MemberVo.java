package net.javaguides.springboot.model;

import lombok.*;

import javax.persistence.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="my_member")
public class MemberVo {
    @Id
    @Column
    private String mem_id;

    @Column(name="mem_name")
    private String name;

    @Column(name="mem_email")
    private String email;

    @Column(name="mem_pw")
    private String pw;

    @Column(name="mem_birth")
    private String birth;

    @Column(name="mem_nick",unique = true)
    private String nick;




}
