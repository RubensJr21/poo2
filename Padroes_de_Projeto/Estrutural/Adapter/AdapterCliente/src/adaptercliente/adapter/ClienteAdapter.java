/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adaptercliente.adapter;

import adaptercliente.model.ICliente;
import lib.ClienteExterno;

/**
 *
 * @author Rubens Jr
 */
public class ClienteAdapter implements ICliente {
    ClienteExterno clienteExt;

    public ClienteAdapter(ClienteExterno c){
        this.clienteExt = c;
    }
    
    private void methodNotImplements() {
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        // Na linha a seguir é obtido a classe que chamou este método
        // https://stackoverflow.com/questions/421280/how-do-i-find-the-caller-of-a-method-using-stacktrace-or-reflection#:~:text=StackTraceElement%5B%5D%20stackTraceElements%20%3D%20Thread,%5B2%5D).
        String nameFunction = stackTraceElements[2].getMethodName();
        String strOut = String.format("Função ClienteAdapter.%s não implementado", nameFunction);
        new Exception(strOut).printStackTrace();
    }
    
    @Override
    public String getCelular(){
        return clienteExt.getDddCelular() + clienteExt.getCelular();
    }
    
    @Override
    public String getTelefone(){
        return clienteExt.getDddTelefone() + clienteExt.getTelefone();
    }
    
    @Override
    public String getEmail(){
        return clienteExt.getEmail();
    }
    
    @Override
    public String getNomeCompleto(){
        return clienteExt.getNome() + " " + clienteExt.getSobreNome();
    }

    @Override
    public void setNomeCompleto(String nomeCompleto) {
        methodNotImplements();
    }

    @Override
    public void setTelefone(String telefone) {
        methodNotImplements();
    }

    @Override
    public void setEmail(String email) {
        methodNotImplements();
    }

    @Override
    public void setCelular(String celular) {
        methodNotImplements();
    }
}
