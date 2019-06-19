package jp.co.central_soft.train2019.wakaba.domain;

public enum MashiMashiTypeEnum
{
	YASAI("野菜","野菜","ふつう","マシ","マシマシ"),
	ABURA("油","油","ふつう","マシ","マシマシ"),
	KARAME("からめ","う","ふつう","マシ","マシマシ"),
	KATASA("かたさ","え","ふつう","硬め","バリカタ");

	private String name,description,element1,element2,element3;

	private MashiMashiTypeEnum(String name,String description,String element1, String element2, String element3)
	{
		this.name = name;
		this.description = description;
		this.element1 = element1;
		this.element2 = element2;
		this.element3 = element3;
	}


	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String getElement1() {
		return element1;
	}

	public String getElement2() {
		return element2;
	}

	public String getElement3() {
		return element3;
	}



}


