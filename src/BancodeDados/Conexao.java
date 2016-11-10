/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BancodeDados;

import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import Interface.Protocolo;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author soare_000
 */
public class Conexao {

    private final String selectAll = "Select * from protocolos where id=? order by id desc;";
    private final String insert = "insert into protocolos(protocolo,data,hora,assunto,descricao,ProtocoloAnatel) values (?,?,?,?,?,?);";
    private final String delete = "delete  from protocolos where  id=?;";
    private final String update = "update protocolos set protocolo=?,assunto=?,descricao=? WHERE ID=?";
    private final String busca = "select * from protocolos where assunto like ? order by id desc;";
    private boolean retorno = false;

    private Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con;
        con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/oiprotocolo", "root", "");
        return con;
    }

    private void closeConnection(Connection con) {//fecha a conexão com o Banco de Dados
        try {
            con.close();
        } catch (SQLException e) {
            //System.out.println("Não foi possível conectar ao Banco de dados");
            JOptionPane.showMessageDialog(null, "Não foi possível conectar ao Banco de dados");
            e.printStackTrace();
        }
    }

    public boolean insereProtocolo(String protocolo, String data, String hora, String assunto, String descricao, int tipoProtocolo) throws ClassNotFoundException {
        Connection con = null;
        try {
            System.out.println("Variaveis: " + protocolo + " " + " " + data + " " + " " + hora + " " + assunto + " " + descricao + "tipo protocolo: " + tipoProtocolo);
            con = getConnection();
            PreparedStatement smt = (PreparedStatement) con.prepareStatement(insert);
            //if((tipoProtocolo!=0) || (tipoProtocolo!=1))tipoProtocolo=0;//tipo protocolo define se é um protoclo da Oi ou da Anatel
            smt.setString(1, protocolo);
            smt.setString(2, data);
            smt.setString(3, hora);
            smt.setString(4, assunto);
            smt.setString(5, descricao);
            System.out.println("protocoolo: " + tipoProtocolo);
            smt.setInt(6, tipoProtocolo);
            retorno = smt.execute();
            if (retorno == true) {
                System.out.println("Gravado com sucesso");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível conectar ao Banco de dados");
            e.printStackTrace();
        } finally {
            closeConnection(con);
        }
        return retorno;
    }

    public int removeProtocolo(int id) throws ClassNotFoundException {
        Connection con = null;
        int retorno1 = 0;
        try {
            con = getConnection();
            PreparedStatement smt = (PreparedStatement) con.prepareStatement(delete);
            smt.setInt(1, id);
            retorno1 = smt.executeUpdate();
            if (retorno1 == 1) {

                //System.out.println("Removido com sucesso");
                //JOptionPane.showMessageDialog(null,"Ocorreu uma falha ao protocolo!");
            } else {
                JOptionPane.showMessageDialog(null, "Ocorreu uma falha ao remover o protocolo!");
                //System.out.println("Não foi possivel remover");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(con);
        }
        return retorno1;
    }

    public int atualizaProtocolo(int id, String protocolo, String data, String hora, String assunto, String descricao) throws ClassNotFoundException {
        Connection con = null;
        int retorno1 = 0;
        try {
            con = getConnection();
            PreparedStatement smt = (PreparedStatement) con.prepareStatement(update);
            smt.setString(1, protocolo);
            smt.setString(2, assunto);
            smt.setString(3, descricao);
            smt.setInt(4, id);

            retorno1 = smt.executeUpdate();
            if (retorno1 == 1) {
                //System.out.println("Atualizado com sucesso");
            } else {
                JOptionPane.showMessageDialog(null, "Ocorreu uma falha ao atualizar o Protocolo!");
                //System.out.println("não foi possível atualizar");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(con);
        }
        return retorno1;
    }

    /**
     *
     * @param protocolo
     * @return
     * @throws ClassNotFoundException
     */
    public ArrayList<Protocolo> selectProtocolos(Protocolo protocolo, int mes) throws SQLException, ClassNotFoundException {
        //---------------------------------------------------------------------------------------------------
        String select = "";
        if (mes == 0) {
            select = "select id,assunto,ProtocoloAnatel from protocolos order by id desc;";
        } else {
            if (mes < 10) {
                select = "SELECT  id,assunto,ProtocoloAnatel FROM `protocolos` WHERE data like '%/" + 0 + mes + "%' order by id desc;";
            } else {
                select = "SELECT  id,assunto,ProtocoloAnatel FROM `protocolos` WHERE data like '%/" + mes + "%' order by id desc;";
            }
        }
        //---------------------------------------------------------------------------------------------------
        Connection con = null;
        ArrayList<Protocolo> listaProtocolo;
        listaProtocolo = new ArrayList<Protocolo>();

        System.out.println("::" + select);
        try {
            con = getConnection();
            PreparedStatement smt = (PreparedStatement) con.prepareStatement(select);
            ResultSet rs = smt.executeQuery();
            while (rs.next()) {
                Protocolo protocolotmp = new Protocolo();
                protocolotmp.setID(rs.getInt("id"));
                //   protocolotmp.setProtocolo(rs.getString("protocolo"));
                //  protocolotmp.setData(rs.getString("data"));
                //  protocolotmp.setHora(rs.getString("hora"));
                protocolotmp.setAssunto(rs.getString("assunto"));
                //  protocolotmp.setDescricao(rs.getString("descricao"));
                protocolotmp.setTipoProtocolo(rs.getInt("ProtocoloAnatel"));
                listaProtocolo.add(protocolotmp);

            }
        } catch (SQLException e) {
            //System.out.println("Ocorreu um erro ao carrega a lista");
            JOptionPane.showMessageDialog(null, "Ocorreu uma falha ao conectar com o banco de dados, tente novamente em alguns minutos!");
            e.printStackTrace();
        } finally {
            closeConnection(con);
        }
        return listaProtocolo;
    }

    public ArrayList<Protocolo> selectProtocoloID(int id) throws SQLException, ClassNotFoundException {
        Connection con = null;
        ArrayList<Protocolo> listaProtocolo;
        listaProtocolo = new ArrayList<Protocolo>();
        try {
            con = getConnection();
            PreparedStatement smt = (PreparedStatement) con.prepareStatement(selectAll);
            smt.setInt(1, id);
            ResultSet rs = smt.executeQuery();
            while (rs.next()) {
                Protocolo protocolotmp = new Protocolo();
                protocolotmp.setID(rs.getInt("id"));
                protocolotmp.setProtocolo(rs.getString("protocolo"));
                protocolotmp.setData(rs.getString("data"));
                protocolotmp.setHora(rs.getString("hora"));
                protocolotmp.setAssunto(rs.getString("assunto"));
                protocolotmp.setDescricao(rs.getString("descricao"));
                protocolotmp.setTipoProtocolo(rs.getInt("ProtocoloAnatel"));
                listaProtocolo.add(protocolotmp);

            }
        } catch (SQLException e) {
            //System.out.println("Ocorreu um erro ao carrega a lista");
            JOptionPane.showMessageDialog(null, "Ocorreu uma falha ao conectar com o banco de dados, tente novamente em alguns minutos!");
            e.printStackTrace();

        } finally {
            closeConnection(con);
        }
        return listaProtocolo;
    }

    public ArrayList<Protocolo> buscaProtocolo(String pesquisa) throws ClassNotFoundException {
        Connection con = null;
        ArrayList<Protocolo> listaProtocolo;
        listaProtocolo = new ArrayList<Protocolo>();
        try {
            con = getConnection();
            PreparedStatement smt = (PreparedStatement) con.prepareStatement(busca);
            smt.setString(1, "%" + pesquisa + "%");
            ResultSet rs = smt.executeQuery();
            System.out.println("ate aqui ok" + pesquisa);

            while (rs.next()) {
                Protocolo protocolotmp = new Protocolo();
                protocolotmp.setID(rs.getInt("id"));
                protocolotmp.setProtocolo(rs.getString("protocolo"));
                protocolotmp.setData(rs.getString("data"));
                protocolotmp.setHora(rs.getString("hora"));
                protocolotmp.setAssunto(rs.getString("assunto"));
                protocolotmp.setDescricao(rs.getString("descricao"));
                listaProtocolo.add(protocolotmp);

            }
        } catch (SQLException e) {
            //System.out.println("Ocorreu um erro ao carrega a lista");
            JOptionPane.showMessageDialog(null, "Ocorreu uma falha ao conectar com o banco de dados, tente novamente em alguns minutos!");
            e.printStackTrace();
        } finally {
            closeConnection(con);
        }
        return listaProtocolo;
    }

    public void iniciarXampp() {//Inicia o servidor xampp
        try {
            //Runtime.getRuntime().exec("calc"); //assim  
            Runtime.getRuntime().exec("C:\\xampp\\xampp_start.exe"); //e assim  
        } catch (Exception e) {
            System.err.println(" Ocorreu uma falha ao iniciar o servidor local xampp, talzes seja necessario inicialo manualmente!");
        }

    }

    public void encerraXampp() {//Inicia o servidor xampp
        try {
            //Runtime.getRuntime().exec("calc"); //assim  
            Runtime.getRuntime().exec("C:\\xampp\\xampp_stop.exe"); //fecha o xampp
            Runtime.getRuntime().exec("C:\\xampp\\mysql_stop.bat"); //fecha o mysql
            Runtime.getRuntime().exec("C:\\xampp\\apache_stop.bat"); //e assim  
        } catch (Exception e) {
            System.err.println(" Ocorreu uma falha ao iniciar o servidor local xampp, talvez seja necessario inicialo manualmente!");
        }

    }
}
