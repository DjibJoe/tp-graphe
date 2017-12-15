package dijsktra;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class GrapheListAdj {

	private List<Arc> graphe[];
	private Noeud nodes[] ; 
	 static Double infini=Double.POSITIVE_INFINITY;
	 
	public GrapheListAdj(int n) {
		graphe = new LinkedList[n];
		nodes = new Noeud[n];
		for (int i = 0; i <n; i++) {
			graphe[i] = new LinkedList<>();
			nodes[i] = new Noeud();
			nodes[i].setVal(infini);
			nodes[i].setM(false);
		}
		nodes[0].setP(0);
	}
	
	public void addArc(int u, Arc a) {
		graphe[u].add(0,a);
	}
	public boolean areConnected(int u,int v) {
		for (Arc arc : graphe[u]) {
			if(arc.getNum() == v)
				return true;
		}
		return false;	
	}
	
	int getminIndex(List<Arc> t) {		
        Double min =Double.POSITIVE_INFINITY;
        int minIndex=-1; 
   
        	for(int j = 0; j< t.size(); j++) {
        		if(t.get(j).getPoid() < min && !t.get(j).isMarked()) {
        			minIndex = j;
        			t.get(j).setMarked(true);
        		}
        	}     
 
        return minIndex;    
}
	public void Dijsktra() {
		
		for (int i = 0; i < graphe.length; i++) {
			int minIndex = getminIndex(graphe[0]);
			graphe[i].get(minIndex).setMarked(true);
			for (int j = 0; j < graphe[minIndex].size(); j++) {
				if(areConnected(graphe[j].get(minIndex).getNum(), j) && nodes[j].getP() > (graphe[i].get(minIndex).getPoid()+nodes[j].getP()));
				{
					nodes[j].setD((double) (graphe[minIndex].get(j).getPoid()+nodes[j].getP()));
				}
			}
		}
			
		
		for (int i = 0; i < nodes.length; i++) {
			System.out.println(nodes[i].getP()+"joe");
		}
			
		
	}

	@Override
	public String toString() {
		String result= "";
		for (int i = 0; i < graphe.length; i++) {
			result += i+1+"==>" + graphe[i] + "\n";
		}
		return result;
	}

	public static void main(String[] args) {
		
		
		GrapheListAdj g = new GrapheListAdj(7);
		
//		explicatin "g.addArc(0,new Arc(2,1))"  ==>  ∀(0,2) ∈ S c(0,2) = 1
		
		g.addArc(0,new Arc(2,1));
		g.addArc(0,new Arc(3,4));
		g.addArc(0,new Arc(4,7));
		g.addArc(0,new Arc(5,11));
		g.addArc(0,new Arc(6,14));
		g.addArc(0,new Arc(7,16));		
		g.addArc(1,new Arc(3,2));		
		g.addArc(2,new Arc(4,3));
		g.addArc(3,new Arc(5,4));
		g.addArc(4,new Arc(6,3));
		g.addArc(5,new Arc(7,2));
		g.addArc(6,new Arc(4,2));		
		System.out.println(g);
		
		g.Dijsktra();
			
		
			
				
			
			

	}

	


	
}
