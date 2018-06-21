package br.com.sal.Main;

import br.com.sal.DAO.ClienteDAO;
import br.com.sal.Model.ClienteModel;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		
		ClienteModel cliente = new ClienteModel();
        cliente.setCpf("111.111.111-11");
        cliente.setId(1);
        cliente.setNome("Anderson");
        cliente.setRg("34563456356");
        
        ClienteDAO.getInstance().merge(cliente);
        

	}
}
