package ru.mpei.Behs;

import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LisenToDeals extends Behaviour {
    private MessageTemplate mt;
    private 

    @Override
    public void onStart() {
        mt = MessageTemplate.MatchPerformative(ACLMessage.PROPOSE);
    }

    @Override
    public void action() {
        ACLMessage m = myAgent.receive(mt);
        if (m != null) {
            log.info("Received Pong msg from {} with {}", m.getSender().getLocalName(), m.getContent());
        } else {
            block();
        }
    }


    @Override
    public boolean done() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'done'");
    }

    

}
