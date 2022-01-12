package net.javaguides.springboot.model;

import lombok.*;

import javax.persistence.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="board_data")
public class BoardVo {
        @Id
        @Column(name = "data_no",nullable = false)
        @GeneratedValue(strategy= GenerationType.IDENTITY)
        private String data_no;

        @Column(name="board_no",nullable = false)
        private int board_no;

        @Column(name="mem_nick",nullable = false)
        private String mem_nick;

        @Column(name="title",nullable = false)
        private String title;

        @Column(name="content",nullable = false)
        private String content;

        @Column(name="regdate",nullable = false)
        private String regdate;

        @Column(name="hit",nullable = false)
        private int hit;

        @Column(name="like",nullable = false)
        private int like;
}
