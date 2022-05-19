/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adaptercliente.adapter;

import adaptercliente.model.Cliente;
import lib.ClienteExterno;

/**
 *
 * @author Rubens Jr
 */
public class ClienteAdapter extends Cliente {
    ClienteExterno clienteExt;
    public ClienteAdapter(ClienteExterno c){
        this.clienteExt = c;
    }
    
    @Override
    public String getCelular(){
        return clienteExt.getDddCelular()+ clienteExt.getCelular();
    }
    
    @Override
    public String getTelefone(){
        return clienteExt.getDddTelefone()+ clienteExt.getTelefone();
    }
    
    @Override
    public String getEmail(){
        return clienteExt.getEmail();
    }
    
    @Override
    public String getNomeCompleto(){
        return clienteExt.getNome() + clienteExt.getSobreNome();
    }
}
