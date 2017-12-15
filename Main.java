package dijsktra;


 class Main {
	 
	 static Double infini=Double.POSITIVE_INFINITY;
	 static int getminIndex(Noeud []t) {
	
	        // Initialize min value
	        Double min =Double.POSITIVE_INFINITY;
	        int minIndex=-1;
	 
	        for (int i = 0; i < t.length; i++)
	            if (t[i].getVal() <= min && !t[i].isM())
	            {
	                min = t[i].getVal();
	                minIndex = i;
	            }
	 
	        return minIndex;
	    
}
public static void main(String args[]) {	
		
	//graphe de l'exo 2 td2
	/*	Double graphe [][] = {
						{infini,1d,4d,7d,11d,14d,16d},
						{infini,infini,2d,infini,infini,infini,infini},
						{infini,infini,infini,3,infini,infini,infini},
						{infini,infini,infini,infini,4d,infini,infini},
						{infini,infini,infini,infini,infini,3d,infini},
						{infini,infini,infini,infini,infini,infini,2d},
						{infini,infini,infini,2d,infini,infini,infini}
					 };*/
	
	//graphe de l'exo 3 td2
	Double graphe [][] = {
			{infini,2d,6d,8d,infini,infini,infini,infini},
			{infini,infini,infini,infini,1d,infini,infini,infini},
			{infini,1d,infini,2d,infini,infini,infini,infini},
			{infini,infini,infini,infini,infini,3d,infini,7d},
			{infini,infini,2d,infini,infini,8d,9d,infini},
			{infini,infini,4d,infini,infini,infini,1d,infini},
			{infini,infini,infini,infini,infini,infini,infini,2d},
			{infini,infini,infini,infini,infini,infini,infini,infini},
		 };
	
		Noeud nodes[] = new Noeud[graphe.length];
		
		djisktra(graphe,nodes);		
		

		// affichage
		System.out.println("noeuds \t| distance de la source   pere");
		for (int i = 0; i < nodes.length; i++) 
			System.out.println(i+1 +" \t "+nodes[i].getVal()+" \t \t \t   "+nodes[i].getPrecedent());
		
	
	}


	static void djisktra(Double [][] graphe,Noeud [] nodes) {
		
		//initialisation des neoud a l'inifi excepter le premier qui est à 0
				for (int i = 0; i < nodes.length; i++) {
					nodes[i] = new Noeud();
					nodes[i].setVal(infini);
					nodes[i].setM(false);
				}
				nodes[0].setVal(0d);
				
				//calcul du pluscourt chemin
				for (int i = 0; i < graphe.length-1; i++) {
					int minIndex=getminIndex(nodes);
					nodes[minIndex].setM(true);
					for (int j = 0; j < graphe.length; j++) {
						if( graphe[minIndex][j] != infini && nodes[j].getVal() > (nodes[minIndex].getVal() + graphe[minIndex][j])) {
							
							nodes[j].setVal(nodes[minIndex].getVal() + graphe[minIndex][j]);
							nodes[j].setPrecedent(minIndex+1);
						}
						
					}
				}
			
	}
}
