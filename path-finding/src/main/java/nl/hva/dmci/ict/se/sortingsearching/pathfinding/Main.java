package nl.hva.dmci.ict.se.sortingsearching.pathfinding;

import java.util.ArrayList;
import nl.hva.dmci.ict.se.sortingsearching.weigthedgraph.AdjMatrixEdgeWeightedDigraph;
import nl.hva.dmci.ict.se.sortingsearching.weigthedgraph.DirectedEdge;
import nl.hva.dmci.ict.se.sortingsearching.weigthedgraph.EdgeWeightedDigraph;

/**
 * TODO make sure your code is compliant with the HBO-ICT coding conventions!
 *
 * @author ???
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO Here you can do your experiments.

        // Please have a good look at the constructors of EdgeWeightedDigraph!
        // Before you save any images make sure the value of TileWorldUtil.outputDir points to an
        // existing folder and ands with a '/'!
        // Example: TileWorldUtil.outputDir = "/Users/nico/output/";
        for (int i = 1; i < 22; i++) {
            String img = "i" + Integer.toString(i);
            System.out.println("=== WERELD: " + img + " ===");

            EdgeWeightedDigraph ewd = new EdgeWeightedDigraph(img);
            Dijkstra dijk = new Dijkstra(ewd, ewd.getStart());

            if (dijk.hasPathTo(ewd.getEnd())) {
                Iterable<DirectedEdge> iter = dijk.pathTo(ewd.getEnd());
                ArrayList<Double> weight = new ArrayList();
                iter.forEach((iterator) -> {
                    weight.add(iterator.weight());
                });

                double totalWeight = 0;
                int numNodes = 0;

                for (double d : weight) {
                    totalWeight += d;
                    numNodes++;
                }

//                System.out.println("Aantal knopen vergeleken: " + dijk.getTellerKnopen());
//                System.out.println("Lengte van het pad: " + dijk.getTellerLengte());
//                System.out.println("Kosten van de hele route: " + totalWeight);
//                System.out.println(iter);
//                ewd.tekenPad(iter);
//                ewd.show(img, "");

            } else {
//                System.out.println("Aantal knopen vergeleken: " + dijk.getTellerKnopen());
//                System.out.println("Er is geen pad mogelijk");
            }

            dijk.distTo(ewd.getEnd());
            
            //Nodig voor FloydWarshall
            AdjMatrixEdgeWeightedDigraph adewdg = ewd.createAdjMatrixEdgeWeightedDigraph();
            FloydWarshall fw = new FloydWarshall(adewdg);

                if (fw.hasPath(ewd.getStart(), ewd.getEnd())) {
                Iterable<DirectedEdge> it = fw.path(ewd.getStart(), ewd.getEnd());
                ArrayList<Double> weights = new ArrayList<>();
                it.forEach((iterator) -> {
                    weights.add(iterator.weight());
                });

                double totalWeight = 0;
                int numNodes = 0;

                for (double d : weights) {
                    totalWeight += d;
                    numNodes++;
                }
                
                System.out.println("=== PINK FLOYD WARSHALL ===");
                System.out.println("Floyd Warshall Kortste pad: \n Aantal knopen: " + numNodes + ", Kosten: " + totalWeight);
                System.out.println("Pad: " + it);

                ewd.tekenPad(it);
                ewd.show(img, img);
            } else {
                System.out.println("Floyd Warshall kon geen pad vinden voor wereld: " + img);
            }
        }

    }

}
