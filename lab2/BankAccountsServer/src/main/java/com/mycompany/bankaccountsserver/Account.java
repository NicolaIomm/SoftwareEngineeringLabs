/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bankaccountsserver;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author biar
 */
@XmlRootElement(name = "Account")
public class Account {
    
    private int id;
    private String name;
    private List<Operation> operations =  new ArrayList<>();

    @GET
    @Path("{accountId}")
    public Operation getOperation(@PathParam("operationId") int operationId) {
        return findOperationById(operationId);
    }
    
    @POST
    @Path("{accountId}")
    public Response createOperation(Operation operation){
        for (Operation o: operations){
            if (o.getId() == operation.getId()){
                return Response.status(Response.Status.CONFLICT).build();
            }
        }
        operations.add(operation);
        return Response.ok().build();
    }
    
    @DELETE
    @Path("{accountId}")
    public Response deleteOperation(@PathParam("accountId") int operationId) {
        Operation operation = findOperationById(operationId);
        if (operation == null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        operations.remove(operation);
        return Response.ok().build();
    }
    
    private Operation findOperationById(int id){
        for (Operation operation: operations){
            if (operation.getId() == id)
                return operation;
        }
        return null;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Operation> getOperations() {
        return operations;
    }

    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.id;
        hash = 17 * hash + Objects.hashCode(this.name);
        hash = 17 * hash + Objects.hashCode(this.operations);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Account other = (Account) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.operations, other.operations)) {
            return false;
        }
        return true;
    }
    
    
    
}
