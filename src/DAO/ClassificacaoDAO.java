/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Classificacao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Solange
 */
public class ClassificacaoDAO extends ExecuteSQL {
       
    public ClassificacaoDAO(Connection con) {
        super(con);
    }

    public String Inserir_Classificacao (Classificacao a){
        String sql = "insert into classificacao values(0,?,?,?,?,?,?,?,?,?,?)";
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            
            ps.setString(1, a.getNome());
            ps.setDouble(2, a.getPreco());
            
            if (ps.executeUpdate() > 0){
                return "Inserido com sucesso.";
            }else{
                return "Erro ao inserir";
            }
        } catch (SQLException e) {
            return e.getMessage();
        }
    }
    
    public List<Classificacao> ListarClassificacao(){
        String sql = "select idclassificacao,nome,rg,cpf,telefone,email from classificacao";
        List<Classificacao> lista = new ArrayList<>();
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while (rs.next()){
                    Classificacao a = new Classificacao();
                    a.setCodigo(rs.getInt(1));
                    a.setNome(rs.getString(2));
                    a.setPreco(rs.getDouble(3));
                    
                    lista.add(a);
                    
                }
                return lista;
            }else{
                return null;
            }
        } catch (SQLException e){
            return null;
        }
    }
    
    public List<Classificacao> Pesquisar_Nome_Classificacao(String nome){
        String sql = "select idclassificacao, nome, RG, CPF, Telefone, Email " 
                + "from classificacao where nome Like'" + nome +"%'";
        List<Classificacao> lista = new ArrayList<>();
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while (rs.next()){
                    Classificacao a = new Classificacao();
                    a.setCodigo(rs.getInt(1));
                    a.setNome(rs.getString(2));
                    a.setPreco(rs.getDouble(3));
                    
                    lista.add(a);
                    
                }
                return lista;
            }else{
                return null;
            }
        } catch (SQLException e){
            return null;
        }
        
    }
    
        public List<Classificacao> Pesquisar_Cod_Classificacao(int cod){
        String sql = "select idclassificacao, nome, RG, CPF, Telefone, Email " 
                + "from classificacao where idclassificacao'" + cod +"'";
        List<Classificacao> lista = new ArrayList<>();
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while (rs.next()){
                    Classificacao a = new Classificacao();
                    a.setCodigo(rs.getInt(1));
                    a.setNome(rs.getString(2));
                    a.setPreco(rs.getDouble(3));
                    
                    lista.add(a);
                    
                }
                return lista;
            }else{
                return null;
            }
        } catch (SQLException e){
            return null;
        }
        
    }
        
        public boolean Testar_Classificacao(int cod){
            boolean Resultado = false;
            try{
            
                String sql = "select * from classificacao where idclassificacao = " + cod +"";
                PreparedStatement ps = getCon().prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                
                if (rs != null){
                    while (rs.next()) {
                        Resultado = true;
                        
                    }
                }
            } catch (SQLException ex){
                ex.getMessage();
            }
            return Resultado;
        }
        
        public List<Classificacao> CapturarClassificacao(int cod){
            String sql = "select * from classificacao where idclassificacao =" + cod +" ";
            List<Classificacao> lista = new ArrayList<>();
            try{
                PreparedStatement ps = getCon().prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                if (rs != null){
                    while (rs.next()){
                    Classificacao a = new Classificacao();
                    a.setCodigo(rs.getInt(1));
                    a.setNome(rs.getString(2));
                    a.setPreco(rs.getDouble(3));
                    lista.add(a);
                 }
                    return lista;
                }else{
                    return null;
                }
            } catch (SQLException e){
                return null;
            }
        }
        
        public String Alterar_Classificacao(Classificacao a){
            String sql = "update classificacao set nome = ? ,data_nasc = ?,rg = ?"
                    + ",cpf = ?,email = ?,telefone = ?,bairro = ?,rua = ?,"
                    + ",numero = ?,cep = ? where idclassificacao";
            try{
                PreparedStatement ps = getCon().prepareStatement(sql);
                ps.setString(1, a.getNome());
                ps.setInt(11, a.getCodigo());
                if (ps.executeUpdate() > 0){
                    return "Atualizado com sucesso";
                }else{
                    return "Erro ao Atualizar";
                }
            } catch (SQLException e){
                return e.getMessage();
            }
        }
        
        public List<Classificacao> ListarComboClassificacao() {
            
            String sql = "Select nome from classificacao order by nome ";
            List<Classificacao> lista = new ArrayList<>();
            try {
                PreparedStatement ps = getCon().prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                
                if (rs != null) {
                    while (rs.next()) {
                        Classificacao a = new Classificacao();
                        a.setNome(rs.getString(1));
                        lista.add(a);
                    }
                    return lista;
                }else{
                 return null;
                }
                
            } catch (Exception e) {
                return null;
            }
        }
        
        public List<Classificacao> ConsultarCodigoClassificacao(String nome) {
            String sql = "select idclassificacao from classificacao where nome = '" + nome + "'";
            List<Classificacao> lista = new ArrayList<>();
            try {
                PreparedStatement ps = getCon().prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                
                if (rs != null){
                    while (rs.next()) {
                        Classificacao a = new Classificacao();
                        a.setCodigo(rs.getInt(1));
                        lista.add(a);
                        
                    }
                    return lista;
                }else{
                    return null;
                }
            } catch (Exception e) {
                return null;
            }
        }
        
        public String Excluir_Classificacao(Classificacao a){
            String sql = "delete from classificacao where idclassificacao =? and nome = ?";
            
            try {
                PreparedStatement ps = getCon().prepareStatement(sql);
                ps.setInt(1, a.getCodigo());
                ps.setString(2, a.getNome());
                if(ps.executeUpdate()>0){
                    return "Excluido com sucesso.";
                }else{
                    return "Erro ao excluir";
            }
            } catch (Exception e) {
                return e.getMessage();
            }
            }
}
