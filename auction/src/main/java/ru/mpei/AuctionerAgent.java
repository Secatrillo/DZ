package ru.mpei;

import jade.core.Agent;
import ru.mpei.utils.DfUtils;


public class AuctionerAgent extends Agent{

    @Override
    protected void setup() {
        DfUtils.register(this, "Auctioneer");
        


    } 
}
