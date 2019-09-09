package it.uniroma1.diag.stockmarket.peer.server.jmsstockmarketserver;

public class StockMarketServer {

	public static void main(String args[]) throws Exception {

            NotificatoreAcquisto n = new NotificatoreAcquisto();
                n.start();	
            
            ProduttoreQuotazioni q = new ProduttoreQuotazioni();
		q.start();
                
                
	}
}