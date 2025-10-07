package ru.mpei.Behaviour;

import java.util.List;
import java.util.Optional;

import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import lombok.extern.slf4j.Slf4j;
import ru.mpei.model.ItemLot;
import ru.mpei.utils.JsonUtils;


@Slf4j
public class BuyBeh extends Behaviour{
    private MessageTemplate mt;
    private double moneyOwn;
    private List<ItemLot> offers;

    @Override
    public void onStart() {
        mt = MessageTemplate.MatchPerformative(ACLMessage.INFORM);
    }

    @Override
    public void action() {
        ACLMessage m = myAgent.receive(mt);
        if (m != null) {
           
            Optional<ItemLot> lot = JsonUtils.fromJson(m.getContent(),ItemLot.class);
            if(!lot.isPresent()){
                log.error("Failed to deserilize message");
                block();
            }

            log.info("Received Offer msg from {} with\nItem {}\nPrice {}",
            m.getSender().getLocalName(), lot.get().getId(), lot.get().getPrice());

            double new_bet = 1+2*Math.random()*lot.get().getPrice();
            if(new_bet<moneyOwn){
                offers.addLast(new ItemLot(lot.get().getId(),new_bet));
                moneyOwn -= new_bet;
            }

            
            
            ACLMessage answer = new ACLMessage(ACLMessage.PROPOSE);
            answer.addReceiver(m.getSender());
            answer.setContent(JsonUtils.toJson(offers.getLast()));
            myAgent.send(answer);
            log.info("Sent offer to {}", m.getSender().getLocalName());
        } else {
            block();
        }
    }

    @Override
    public boolean done() {
        return false;
    }

}
