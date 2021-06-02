/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;

/**
 *
 * @author admin
 */
public class Champion implements Serializable{
    public String id;
    public String name;
    public float hp;
    public float mp;
    public float atk;
    public float def;
    public String type;
    public float power;
    
    public Champion(){
        
    }

    public Champion(String id, String name, float hp, float mp, float atk, float def, String type, float power) {
        this.id = id;
        this.name = name;
        this.hp = hp;
        this.mp = mp;
        this.atk = atk;
        this.def = def;
        this.type = type;
        this.power = power;
    }
    
    
}
