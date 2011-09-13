package droolsbook;


import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.ResourceFactory;
import org.drools.runtime.StatefulKnowledgeSession;


/**
 * @author Madhusoodan
 *
 */
public class BasicRulesApp {

    /**
     * @param args
     */
    public static void main(String[] args) {
        KnowledgeBase knowledgeBase = createKnowledgeBase();
        StatefulKnowledgeSession session = knowledgeBase.newStatefulKnowledgeSession();
		
        try {
            Account account = new Account();

            account.setBalance(50);
            session.insert(account);
            session.fireAllRules();
        } finally {
            session.dispose();
        }
		
    }

    /**
     * @return
     * returns a KnowledgeBase
     */
    public static KnowledgeBase createKnowledgeBase() {
        KnowledgeBuilder builder = KnowledgeBuilderFactory.newKnowledgeBuilder();

        builder.add(ResourceFactory.newClassPathResource("basic.drl"),
                ResourceType.DRL);
		
        if (builder.hasErrors()) {
            throw new RuntimeException(builder.getErrors().toString());
        }
        KnowledgeBase knowledgeBase = KnowledgeBaseFactory.newKnowledgeBase();
		
        knowledgeBase.addKnowledgePackages(builder.getKnowledgePackages());
        return knowledgeBase;
    }
}
