/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphics;

import javafx.event.ActionEvent;

/**
 *
 * @author Crimson
 */
public class MainController {
    private Handler handler;
    
    public MainController(){}

    public MainController(Handler handler) {
        this.handler = handler;
    }
    
    public void addOrder(ActionEvent event){
        System.out.println("Testing");
        handler.getCustomerTR().displayorders();
    }
    
    public void setHandler(Handler handler){
        this.handler = handler;
    }
}
