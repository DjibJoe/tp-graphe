package floydWarshall;

import dijsktra.Noeud;

public class Main {

	static Double infini= Double.POSITIVE_INFINITY;
	
	public static void main(String[] args) {
		
		Double couts [][] = {
				{0d,2d,infini,6d},
				{infini,0d,-2d,infini},
				{infini,5d,0d,5d},
				{-4d,-1d,infini,0d},
		};
		
		int p[][]=new int[couts.length][couts.length];
		for (int i = 0; i < p.length; i++) {
			for (int j = 0; j < p.length; j++) {
				p[i][j]=i+1;
			}
		}
		Double D[][]=null;
		floyd(4,couts,D);
		
	}

static void floyd(int n,Double  [][] couts,Double [][] D) {
		
		//initialisation des neoud a l'inifi excepter le premier qui est à 0
				//D°
			Double [][]LastD;
			D=couts.clone();
			LastD=copy(D);
			print(D,LastD, 0);
			//calcul du pluscourt chemin
			for (int k = 0; k < n; k++) {
				
				for (int i = 0; i < n; i++) {
					
						for (int j = 0; j < n; j++) {
							
							D[i][j] = Math.min(D[i][j],D[i][k]+D[k][j]);					
						}
					}
					
				print(D,LastD,k+1);
				LastD = copy(D);
			}
	}



  static Double[][] copy(Double[][] d) {
	  Double [][] arrayCop = new Double[d.length][d.length];
	for (int i = 0; i < d.length; i++) {
		for (int j = 0; j < d.length; j++) {
			arrayCop[i][j] = d[i][j];
		}
	}
	return arrayCop;
 }
 static void print(Double[][] d,Double[][] lastD, int k) {
	// TODO Auto-generated method stub
	System.out.println("D^"+k+"-----------------------");
	for (int i = 0; i < d.length; i++) {
		
		for (int j = 0; j < d.length; j++) {
			if (Double.compare(lastD[i][j],d[i][j]) == 0) 
				System.out.print(d[i][j]+"\t");
			
			else 
				System.err.print(d[i][j]+"\t");
			
			if(j == 3 || j == 7 || j == 11 || j == 15)
				System.out.println("\n");
		}
		
	}
	System.out.println("----------------------");
}		
	
}
