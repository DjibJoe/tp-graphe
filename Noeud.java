package dijsktra;

public class Noeud {

	private Double val,d;
	private int p;
	private boolean M ; // si le noeud est marqué M== false; true sinon
	

	public boolean isM() {
		return M;
	}

	public void setM(boolean m) {
		M = m;
	}
	

	public Double getVal() {
		return val;
	}

	public void setVal(Double val) {
		this.val = val;
	}

	public Double getD() {
		return d;
	}

	public void setD(Double d) {
		this.d = d;
	}

	public int getP() {
		return p;
	}

	public void setP(int p) {
		this.p = p;
	}

	public int getPrecedent() {
		return p;
	}

	public void setPrecedent(int dade) {
		this.p = dade;
	}
	
	
	
}
