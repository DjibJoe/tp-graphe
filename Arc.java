package dijsktra;

public class Arc {

	private int num,poid;
	private boolean marked= false;
	public Arc(int num, int poid) {
		super();
		this.num = num;
		this.poid = poid;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getPoid() {
		return poid;
	}
	public void setPoid(int poid) {
		this.poid = poid;
	}
	
	public boolean isMarked() {
		return marked;
	}
	public void setMarked(boolean marked) {
		this.marked = marked;
	}
	@Override
	public String toString() {
		return " [noeud=" + num + ", poid=" + poid + "]";
	}
	
	
	
}
