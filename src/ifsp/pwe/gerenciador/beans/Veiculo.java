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
public class Veiculo {
    int veiculoId;
    String veiculoTipo;
    String veiculoEstado;
    String veiculoPlaca;
    int ruaId;
    int ocorrenciaId;

    public int getVeiculoId() {
        return veiculoId;
    }

    public void setVeiculoId(int veiculoId) {
        this.veiculoId = veiculoId;
    }

    public String getVeiculoTipo() {
        return veiculoTipo;
    }

    public void setVeiculoTipo(String veiculoTipo) {
        this.veiculoTipo = veiculoTipo;
    }

    public String getVeiculoEstado() {
        return veiculoEstado;
    }

    public void setVeiculoEstado(String veiculoEstado) {
        this.veiculoEstado = veiculoEstado;
    }

    public String getVeiculoPlaca() {
        return veiculoPlaca;
    }

    public void setVeiculoPlaca(String veiculoPlaca) {
        this.veiculoPlaca = veiculoPlaca;
    }

    public int getRuaId() {
        return ruaId;
    }

    public void setRuaId(int ruaId) {
        this.ruaId = ruaId;
    }

    public int getOcorrenciaId() {
        return ocorrenciaId;
    }

    public void setOcorrenciaId(int ocorrenciaId) {
        this.ocorrenciaId = ocorrenciaId;
    }
    
    public Veiculo(int id_inteiro,String tipo,String estado, String placa, int id_rua_inteiro){
        this.veiculoId = id_inteiro;
        this.veiculoTipo = tipo;
        this.veiculoEstado = estado;
        this.veiculoPlaca = placa;
        this.ruaId = id_rua_inteiro;
        
    }
    
    public Veiculo(){
        
    }
}
