/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mateus.emergencias.beans;

/**
 *
 * @author Aluno
 */
public class Regiao {
    int    regiaoId;
    String regiaoNome;
    int    regiaoQtOcorrencia;
    float  regiaoPericulosidade;
    public int ocorrencia;

    public int getOcorrencia() {
        return ocorrencia;
    }

    public void setOcorrencia(int ocorrencia) {
        this.ocorrencia = ocorrencia;
    }

    public int getRegiaoId() {
        return regiaoId;
    }

    public void setRegiaoId(int regiaoId) {
        this.regiaoId = regiaoId;
    }

    public String getRegiaoNome() {
        return regiaoNome;
    }

    public void setRegiaoNome(String regiaoNome) {
        this.regiaoNome = regiaoNome;
    }

    public int getRegiaoQtOcorrencia() {
        return regiaoQtOcorrencia;
    }

    public void setRegiaoQtOcorrencia(int regiaoQtOcorrencia) {
        this.regiaoQtOcorrencia = regiaoQtOcorrencia;
    }

    public float getRegiaoPericulosidade() {
        return regiaoPericulosidade;
    }

    public void setRegiaoPericulosidade(float regiaoPericulosidade) {
        this.regiaoPericulosidade = regiaoPericulosidade;
    }
    
     public Regiao(){
        
    }
    
    public Regiao(int id,String nome){
        this.regiaoId = id;
        this.regiaoNome = nome;
    }
}
