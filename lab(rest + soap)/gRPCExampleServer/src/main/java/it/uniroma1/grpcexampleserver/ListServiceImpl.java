package it.uniroma1.grpcexampleserver;

import io.grpc.stub.StreamObserver;
import it.uniroma1.gRPCExample.ListRequest;
import it.uniroma1.gRPCExample.ListResponse;
import it.uniroma1.gRPCExample.ListServiceGrpc.ListServiceImplBase;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ListServiceImpl extends ListServiceImplBase {

    @Override
    public void listOrInfo(
      ListRequest request, StreamObserver<ListResponse> responseObserver) {
        
        String id = request.getId();
        String result = "";
        System.out.println("... the server has received id: " + request.getId() );
        
        try {


            Class.forName("org.sqlite.JDBC");
            Connection conn
                    = DriverManager.getConnection("jdbc:sqlite:/home/biar/trials/gRPC_SOAP_mk2/DBSimpleManager/books");
            
            if(id.equals("-1")){
                Statement stat = conn.createStatement();
                ResultSet rs = stat.executeQuery("select * from BOOKS" );
                result +="Books:\n";
                while (rs.next()) {
                    result += "ID: "+rs.getString("id")+"\n";
                    result += "Title: " +  rs.getString("title")+"\n";
                    result += "Release Date: " +  rs.getString("year")+"\n\n";
                }

                rs.close();
            }else{
                PreparedStatement prep = conn.prepareStatement("select BOOKS.title, BOOKS.year,BOOKS.ID,"
                    + " AUTHORS.name as an,AUTHORS.yearOfBirth as ay "
                    + "from BOOKS,AUTHORS" 
                    + " where AUTHORS.authorID = BOOKS.authorID and BOOKS.ID = ?" );
                prep.setString(1, id);
                ResultSet rs = prep.executeQuery();
                result +="Book with ID: " + id + "\n";
                while (rs.next()) {
                  
                    result += "Title: " +  rs.getString("title")+"\n";
                    result += "Author Name: " +  rs.getString("an")+"\n";
                    result += "Author Year Of Birth: " +  rs.getString("ay")+"\n";
                    result += "Release Date: " +  rs.getString("year")+"\n\n";
                }

            }
            conn.close();



            /* flush out*/
            ListResponse response = ListResponse.newBuilder()
                    .setList(result)
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ListServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ListServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
