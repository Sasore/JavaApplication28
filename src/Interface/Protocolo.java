/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

/**
 *
 * @author soare_000
 */
public class Protocolo {

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
  private  int    ID;
  private  String Protocolo;
  private  String data;
  private  String hora;
  private  String assunto;
  private  String descricao;
  private  int    TipoProtocolo;//Anatel ou Oi

    public int getTipoProtocolo() {
        return TipoProtocolo;
    }

    public void setTipoProtocolo(int TipoProtocolo) {
        this.TipoProtocolo = TipoProtocolo;
    }

    public String getProtocolo() {
        return Protocolo;
    }

    public void setProtocolo(String Protocolo) {
        this.Protocolo = Protocolo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
  
    
    
}
