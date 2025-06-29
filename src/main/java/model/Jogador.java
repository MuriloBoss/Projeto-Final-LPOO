/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author muril
 */

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tbl_jogador")
public class Jogador implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "jog_id")
    private Integer id;

    @Column(name = "jog_nickname", nullable = false)
    private String nickname;

    @Column(name = "jog_level")
    private int level;


    public Jogador() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString(){
        return "Nickname: " + nickname + " - " + "Level: " + level;
    }
   
    
    
}
