package controlas;

import dao.PalavraDAO;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Palavra;
import telas.TelaPrincipal;

/**
 *
 * @author artur
 */
public class Dicionario {

    private PalavraDAO dao = new PalavraDAO();
    
    public Dicionario() {
        
    }
    
    public String addPalavra(Palavra novoObjeto) {
        try {
            if (novoObjeto.nome.isEmpty() || novoObjeto.significado.isEmpty()) {
                return "Preencha todos os campos";
            }
            
            if (consultarPalavraExata(novoObjeto.nome) == null) {
                
                dao.insert(novoObjeto);
                
                return null;
            } else {
                return "Palavra com o nome " + novoObjeto.nome + " já existe!";
            }
        } catch (Exception ex) {
            Logger.getLogger(Dicionario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "Tive problemas ao cadastrar nova palavra";
    }
    
    public Palavra consultarPalavraPorCodigo(int codigo) {
        return dao.get(codigo);
    }
    
    public Palavra consultarPalavraExata(String textoParaBuscar) {
        for (Palavra palvaraDentroDoArray : dao.consultarPalavra(textoParaBuscar)) {
            if (palvaraDentroDoArray.nome.equals(textoParaBuscar)) {
                return palvaraDentroDoArray;
            }
        }
        
        return null;
    }
    
    public ArrayList<Palavra> consultarPalavra(String textoParaBuscar) { 
       
        return dao.consultarPalavra(textoParaBuscar);
    }
    
    public ArrayList<Palavra> getPalavras() {
        return dao.getPalavras();
    }
    
    public void removePalavra(Palavra palavraParaRemover) {
        dao.delete(consultarPalavraPorCodigo(palavraParaRemover.codigo));
    }
    
    public void updatePalavra(Palavra p){
        dao.update(p);
    }
}
