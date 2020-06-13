package model;

public class food {

	private int Fid;
	private String Fname;
	private int Fprice;
	private String Fimage;
	
	
	public food() {
		super();
		// TODO Auto-generated constructor stub
	}


	public food(int fid, String fname, int fprice, String fimage) {
		super();
		Fid = fid;
		Fname = fname;
		Fprice = fprice;
		Fimage = fimage;
	}


	public int getFid() {
		return Fid;
	}


	public void setFid(int fid) {
		Fid = fid;
	}


	public String getFname() {
		return Fname;
	}


	public void setFname(String fname) {
		Fname = fname;
	}


	public int getFprice() {
		return Fprice;
	}


	public void setFprice(int fprice) {
		Fprice = fprice;
	}


	public String getFimage() {
		return Fimage;
	}


	public void setFimage(String fimage) {
		Fimage = fimage;
	}
	
	
	
	
}

