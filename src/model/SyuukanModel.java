package model;

public class SyuukanModel extends BaseModel {

	private int ID;
	private String aim;
	private String enthusiasm;
	private int kaisuu;

	private   SyuukanModel  syuukanModel;

	public int  getID() {
		return ID;
	}
	public void setID(int ID) {
		this.ID = ID;
	}

	public String getTarget() {
		return aim;
	}
	public void setTarget(String aim) {
		this.aim = aim;
	}
	public String getEnthusiasm() {
		return enthusiasm;
	}
	public void setEnthusiasm(String enthusiasm) {
		this.enthusiasm = enthusiasm;
	}
	public int getKaisuu() {
		return kaisuu	;
	}
	public void setKaisuu(int kaisuu) {
		this.kaisuu = kaisuu;
	}




	public  SyuukanModel getSyuukanModel() {
		return syuukanModel;
	}

	public  void setSyuukanModel(SyuukanModel syuukanModel ){
		this.syuukanModel= syuukanModel;

	}





}
