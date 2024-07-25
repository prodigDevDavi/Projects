
import telas.TelaPrincipal;
import util.ConexaoBD;

/**
 *
 * @author artur
 */
public class Start
{
    public static void main( String[] args )
    {
        TelaPrincipal telaPrincipal = new TelaPrincipal();
        telaPrincipal.setVisible( true );
        telaPrincipal.setLocationRelativeTo( null );
        
        ConexaoBD.getInstance();
    }        
}
