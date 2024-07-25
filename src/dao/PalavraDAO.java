/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import model.Palavra;
import util.ConexaoBD;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author davim
 */
public class PalavraDAO {

    public void insert(Palavra p) throws SQLException {
        String sql = "insert into palavras (ds_nome, ds_significado, nr_versao)"
                + "values ('" + p.nome + "' , '"
                + p.significado + "' , " + p.versao + ")";
        
        try{
            ConexaoBD.executeUpdate(sql);
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public Palavra get(int codigo) {
        Palavra p = null;

        String sql = "select * from palavras where nr_codigo = " + codigo;

        try {
            ResultSet rs = ConexaoBD.executeQuery(sql);
            if (rs.next()) {
                p = new Palavra();
                p.codigo = rs.getInt("nr_codigo");
                p.nome = rs.getString("ds_nome");
                p.significado = rs.getString("ds_significado");
                p.versao = rs.getInt("nr_versao");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return p;
    }
    
    public ArrayList<Palavra> getPalavras() {
        ArrayList<Palavra> palavras = new ArrayList();
        
        String sql = "select * from palavras order by ds_nome";
        
        try{
        ResultSet rs = ConexaoBD.executeQuery(sql);
        while(rs.next()){
                Palavra p = new Palavra();
                p.codigo = rs.getInt("nr_codigo");
                p.nome = rs.getString("ds_nome");
                p.significado = rs.getString("ds_significado");
                p.versao = rs.getInt("nr_versao");
                
                palavras.add(p);
            }
    }
    catch (SQLException ex){
        ex.printStackTrace();
    }
        return palavras;
}
    public Palavra consultarPalavraExata(Palavra p){
        
        String sql = "select * from palavras where ds_nome = " + p.nome;
        
        try{
            ResultSet rs = ConexaoBD.executeQuery(sql);
            if (rs.next()) {
                p = new Palavra();
                p.codigo = rs.getInt("nr_codigo");
                p.nome = rs.getString("ds_nome");
                p.significado = rs.getString("ds_significado");
                p.versao = rs.getInt("nr_versao");
                
            }
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
        return p;
    }

    
    public ArrayList<Palavra> consultarPalavra(String textoParaBuscar){
        ArrayList<Palavra> palavras = new ArrayList();
        
        String sql = "select * from palavras where " +
                    "ds_nome like  '%" + textoParaBuscar + "%'" +
                    " or " + "ds_significado like '%" + textoParaBuscar +
                    "%'";
        
        try{
            ResultSet rs = ConexaoBD.executeQuery(sql);
            while(rs.next()){
                Palavra p = new Palavra();
                p.codigo = rs.getInt("nr_codigo");
                p.nome = rs.getString("ds_nome");
                p.significado = rs.getString("ds_significado");
                p.versao = rs.getInt("nr_versao");
                
                palavras.add(p);
            }
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
        return palavras;
    }
    
    public void update (Palavra p){
        String sql = "update palavras set ds_nome = '" + p.nome + "', " +
                     "ds_significado = '" + p.significado + "' " +
                     "where nr_codigo = " + p.codigo;
        
        try{
            ConexaoBD.executeUpdate(sql);
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void delete (Palavra p){
        String sql = "delete from palavras where nr_codigo = " + p.codigo;
        
        try{
            ConexaoBD.executeUpdate(sql);
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
