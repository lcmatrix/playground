import org.neo4j.cypher.ExecutionEngine;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;

/**
 * Created by norman on 07.12.13.
 */
public class Neo4JServer {
    public static void main(String args[]) {
        GraphDatabaseService databaseService = new GraphDatabaseFactory().newEmbeddedDatabase("./database/neo4j.db");
        registerShutdownHook(databaseService);

        Transaction tx = databaseService.beginTx();
        Node node = databaseService.createNode();
        node.addLabel(new Label() {
            @Override
            public String name() {
                return "Person";
            }
        });
        tx.close();


    }

    private static void registerShutdownHook( final GraphDatabaseService graphDb )
    {
        // Registers a shutdown hook for the Neo4j instance so that it
        // shuts down nicely when the VM exits (even if you "Ctrl-C" the
        // running application).
        Runtime.getRuntime().addShutdownHook( new Thread()
        {
            @Override
            public void run()
            {
                graphDb.shutdown();
            }
        } );
    }
}
