package ru.mpei;

import jade.core.Agent;
import lombok.extern.slf4j.Slf4j;
import ru.mpei.Behs.LisenToDeals;

@Slf4j
public class MoneyBrocker extends Agent {
    @Override
    protected void setup() {
        log.info("WorkerAgent setup");
        this.addBehaviour(new LisenToDeals());
        
    }
    
}
