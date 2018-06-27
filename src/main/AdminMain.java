package main;

import analyseAnax.ChiffreDaffairesView;
//import mappingAxel.MappingView;
import mappingAxel.ServerProcessor;
import redevanceDan.FactureView;
import stockAbdessamad.vue.ClientReturnOrderView;
import stockAbdessamad.vue.InventoryListHistoryView;
import stockAbdessamad.vue.SaleProductView;
import stockAbdessamad.vue.StockDeliveryEntryView;

public class AdminMain {
    public static void main(String[]args){
        ChiffreDaffairesView p1 = new ChiffreDaffairesView();
        ServerProcessor bd = new ServerProcessor();
       // MappingView m1 = new MappingView(bd);
        FactureView rv = new FactureView();
        try {
            ClientReturnOrderView frame = new ClientReturnOrderView();
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            InventoryListHistoryView frame = new InventoryListHistoryView();
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            SaleProductView frame = new SaleProductView();
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            StockDeliveryEntryView frame = new StockDeliveryEntryView();
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
