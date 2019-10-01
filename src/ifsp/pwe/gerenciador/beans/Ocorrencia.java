/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ifsp.pwe.gerenciador.beans;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Aluno
 */
public class Ocorrencia {
    int ocorrenciaId;
    String ocorrenciaEstado;
    int ocorrenciaNivel;
    String ocorrenciaDescricao;
    String ocorrenciaComentarios;
    String ocorrenciaRegistroData;
    String ocorrenciaData;
    String ocorrencia_veiculo_tipo;
    
    int ruaId;
    int funcionarioId;
    int sensorId;

    public int getOcorrenciaId() {
        return ocorrenciaId;
    }

    public void setOcorrenciaId(int ocorrenciaId) {
        this.ocorrenciaId = ocorrenciaId;
    }

    public String getOcorrenciaEstado() {
        return ocorrenciaEstado;
    }

    public void setOcorrenciaEstado(String ocorrenciaEstado) {
        this.ocorrenciaEstado = ocorrenciaEstado;
    }
    
    public String getOcorrencia_veiculo_tipo() {
        return ocorrencia_veiculo_tipo;
    }

    public void setOcorrencia_veiculo_tipo(String ocorrencia_veiculo_tipo) {
        this.ocorrencia_veiculo_tipo = ocorrencia_veiculo_tipo;
    }

    public int getOcorrenciaNivel() {
        return ocorrenciaNivel;
    }

    public void setOcorrenciaNivel(int ocorrenciaNivel) {
        this.ocorrenciaNivel = ocorrenciaNivel;
    }

    public String getOcorrenciaDescricao() {
        return ocorrenciaDescricao;
    }

    public void setOcorrenciaDescricao(String ocorrenciaDescricao) {
        this.ocorrenciaDescricao = ocorrenciaDescricao;
    }

    public String getOcorrenciaComentarios() {
        return ocorrenciaComentarios;
    }

    public void setOcorrenciaComentarios(String ocorrenciaComentarios) {
        this.ocorrenciaComentarios = ocorrenciaComentarios;
    }

    public String getOcorrenciaRegistroData() {
        return ocorrenciaRegistroData;
    }

    public void setOcorrenciaRegistroData(String ocorrenciaRegistroData) {
        this.ocorrenciaRegistroData = ocorrenciaRegistroData;
    }

    public String getOcorrenciaData() {
        return ocorrenciaData;
    }

    public void setOcorrenciaData(String ocorrenciaData) {
        this.ocorrenciaData = ocorrenciaData;
    }

    public int getRuaId() {
        return ruaId;
    }

    public void setRuaId(int ruaId) {
        this.ruaId = ruaId;
    }

    public int getFuncionarioId() {
        return funcionarioId;
    }

    public void setFuncionarioId(int funcionarioId) {
        this.funcionarioId = funcionarioId;
    }

    public int getSensorId() {
        return sensorId;
    }

    public void setSensorId(int sensorId) {
        this.sensorId = sensorId;
    }
    
    public Ocorrencia(String estado ,int nivel,String descricao,String registro_dt,int rua_id, String tipoveiculo){
        this.ocorrenciaEstado = estado;
        this.ocorrenciaNivel = nivel;
        this.ocorrenciaDescricao = descricao;
        this.ocorrenciaRegistroData = registro_dt;
        this.ruaId = rua_id;
        this.ocorrencia_veiculo_tipo = tipoveiculo;
    }
    
    public Ocorrencia(String estado, int nivel, String tipoveiculo, String descricao, String comentario, String registro_dt, String data, int rua_id, int funcionario_id, int sensor_id){
        this.ocorrenciaEstado = estado;
        this.ocorrenciaNivel = nivel;
        this.ocorrencia_veiculo_tipo = tipoveiculo;
        this.ocorrenciaDescricao = descricao;
        this.ocorrenciaComentarios = comentario;
        this.ocorrenciaRegistroData = registro_dt;
        this.ocorrenciaData = data;
        this.ruaId = rua_id;
        this.funcionarioId = funcionario_id;
        this.sensorId = sensor_id;
    }
    
    public Ocorrencia(){
        
    }
    
    
    public Ocorrencia(int id, String estado, int nivel, String descricao, String data, int ruaId ){
        this.ocorrenciaId = id;
        this.ocorrenciaEstado = estado;
        this.ocorrenciaNivel = nivel;
        this.ocorrenciaDescricao = descricao;
        this.ocorrenciaRegistroData = data;
        this.ruaId = ruaId;
    }
    
    
}
