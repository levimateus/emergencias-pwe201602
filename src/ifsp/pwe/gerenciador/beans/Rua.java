/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ifsp.pwe.gerenciador.beans;

import java.util.ArrayList;

/**
 *
 * @author Aluno
 */
public class Rua {
    int ruaId;
    String ruaNome;
    int ruaStatus;
    public int regiaoId;
    int ruaLoc_x;
    int ruaLoc_y;

    public int getRuaId() {
        return ruaId;
    }

    public void setRuaId(int ruaId) {
        this.ruaId = ruaId;
    }

    public String getRuaNome() {
        return ruaNome;
    }

    public void setRuaNome(String ruaNome) {
        this.ruaNome = ruaNome;
    }

    public int getRuaStatus() {
        return ruaStatus;
    }

    public void setRuaStatus(int ruaStatus) {
        this.ruaStatus = ruaStatus;
    }

    public int getRegiaoId() {
        return regiaoId;
    }

    public void setRegiaoId(int regiaoId) {
        this.regiaoId = regiaoId;
    }
    
    public int getRuaLoc_x() {
        return ruaLoc_x;
    }

    public void setRuaLoc_x(int x) {
        this.ruaLoc_x = x;
    }
    
    public int getRuaLoc_y() {
        return ruaLoc_y;
    }

    public void setRuaLoc_y(int y) {
        this.ruaLoc_y = y;
    }
    
     public Rua(){
        
    }
    
    public Rua(int id,int regiao_id){
        this.ruaId = id;
        this.regiaoId = regiao_id;
    }
}
