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
public class SensorAlarme {
    int sensorAlarmeId;
    boolean sensorAlarmeEstado;
    int sensorAlarmeTipo;
    int rua;

    public int getSensorAlarmeId() {
        return sensorAlarmeId;
    }

    public void setSensorAlarmeId(int sensorAlarmeId) {
        this.sensorAlarmeId = sensorAlarmeId;
    }

    public boolean isSensorAlarmeEstado() {
        return sensorAlarmeEstado;
    }

    public void setSensorAlarmeEstado(boolean sensorAlarmeEstado) {
        this.sensorAlarmeEstado = sensorAlarmeEstado;
    }

    public int getSensorAlarmeTipo() {
        return sensorAlarmeTipo;
    }

    public void setSensorAlarmeTipo(int sensorAlarmeTipo) {
        this.sensorAlarmeTipo = sensorAlarmeTipo;
    }

    public int getRua() {
        return rua;
    }

    public void setRua(int rua) {
        this.rua = rua;
    }
    
    
}
