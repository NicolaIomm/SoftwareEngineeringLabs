/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bankaccountsserver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 *
 * @author biar
 */
@Path("accounts")
@Produces("text/xml")
public class AccountRepository {
    
    private Map<Integer, Account> accounts = new HashMap<>();
    
    {
        Account a1 = new Account();
        a1.setId(1);
        a1.setName("Account1");

        Operation o1 = new Operation();
        o1.setId(1);
        o1.setName("Auto");
        Operation o2 = new Operation();
        o2.setId(2);
        o2.setName("Spesa");

        List<Operation> ops = new ArrayList<>();
        ops.add(o1);
        ops.add(o2);

        a1.setOperations(ops);
     
        Account a2 = new Account();
        a2.setId(2);
        a2.setName("Account2");
        
        accounts.put(1, a1);
        accounts.put(2, a2);
    }
    
    private Account findAccountById(int accountId){
        for (Map.Entry<Integer, Account> account : accounts.entrySet()){
            if (account.getKey() == accountId) {
                return account.getValue();
             }
        }
        return null;
    }

    @GET
    @Path("{accountId}")
    public Account getAccount(@PathParam("accountId") int accountId) {
        return findAccountById(accountId);
    }
    
    @POST
    @Path("")
    public Response createAccount(Account account) {
        if (findAccountById(account.getId()) != null){
            return Response.status(Response.Status.CONFLICT).build();
        }
        accounts.put(account.getId(), account);
        return Response.ok().build();
    }
    
    @DELETE
    @Path("{accountId}")
    public Response deleteAccount(@PathParam("accountId") int accountId) {
        accounts.remove(accountId);
        return Response.ok().build();
    }
    
    @PUT
    @Path("{accountId}")
    public Response updateAccount(@PathParam("accountId") int accountId, Account account) {
        Account existingAccount = findAccountById(accountId);
        if (existingAccount == null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        if (existingAccount.equals(account)){
            return Response.notModified().build();
        }
        accounts.put(accountId, account);
        return Response.ok().build();
    }
    
    @Path("{accountId}/operations")
    public Account pathToOperations(@PathParam("accountId") int accountId){
        return findAccountById(accountId);
    }
}
