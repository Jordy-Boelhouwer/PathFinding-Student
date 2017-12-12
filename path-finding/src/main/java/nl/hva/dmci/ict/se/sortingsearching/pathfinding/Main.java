package nl.hva.dmci.ict.se.sortingsearching.pathfinding;

import nl.hva.dmci.ict.se.sortingsearching.weigthedgraph.DirectedEdge;
import nl.hva.dmci.ict.se.sortingsearching.weigthedgraph.EdgeWeightedDigraph;

/**
 * TODO make sure your code is compliant with the HBO-ICT coding conventions!
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
        
        EdgeWeightedDigraph ewd = new EdgeWeightedDigraph("i5");
        Dijkstra dijk = new Dijkstra(ewd, ewd.getStart());
        ewd.show("i2", "test");
        
        if(dijk.hasPathTo(ewd.getEnd())){
            Iterable<DirectedEdge> iterator = dijk.pathTo(ewd.getEnd());
            ewd.tekenPad(iterator);
            
            System.out.println("Lengte van het pad: " + dijk.getTellerLengte());
            System.out.println("Aantal knopen: " + dijk.getTellerKnopen());
            
        }else{
            System.out.println("sukkel er is geen pad!!!111");
        }
        
        dijk.distTo(ewd.getEnd());
       
        
    }
    
}
