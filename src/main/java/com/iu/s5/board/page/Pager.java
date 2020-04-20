package com.iu.s5.board.page;

public class Pager {
	
	private Long curPage;
	private Integer perpage;

	private long startRow;
	private long lastRow;
	private long startNum;
	private long lastNum;
	
	private long totalPage;
	private long totalBlock;
	private long curBlock;
	
	
	private String kind;
	private String search;
	
	
	
	
	public void makeRow() {
		System.out.println("curPage: "+ this.getCurPage());
		this.startRow = (this.getCurPage()-1)*this.getPerpage()+1;
		this.lastRow = this.getCurPage()*this.getPerpage();
	}
	
	public void makePage(long totalCount) {
		//--------------------------------------------------------
		//1. 총글의 갯수 (totalCount : 전체 글의 갯수)
			
		//2.totalCount로 totalPage 계산
		this.totalPage = totalCount/this.getPerpage();
		if(totalCount%this.getPerpage() !=0) {
			this.totalPage++;
		}
		//3. totalPage로 totalBlock 계산
		long perBlock = 5L; // 블럭 당 페이지수
		this.totalBlock = totalPage/perBlock;
		if(totalPage%perBlock !=-0) {
			this.totalBlock++;
		}
		
		//4. curPage 로 curBlock 찾기
		this.curBlock = this.curPage/perBlock;
		if(this.curPage%perBlock != 0) {
			this.curBlock++;
		}
		
		//5. curBlock으로 startNum,lastNum 계산
		this.startNum =(this.curBlock-1)*perBlock+1;
		this.lastNum = (this.curBlock)*perBlock;
		
		if(this.curBlock==this.totalBlock) {
			this.lastNum=this.totalPage;
		}
		
	}
	
	
	
	
	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getSearch() {
		if(this.search==null) {
			search="";
		}
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public long getStartNum() {
		return startNum;
	}

	public long getLastNum() {
		return lastNum;
	}

	public long getTotalBlock() {
		return totalBlock;
	}

	public long getCurBlock() {
		return curBlock;
	}

	public long getTotalPage() {
		return totalPage;
	}

	public Long getCurPage() {
		if(this.curPage == null || this.curPage == 0) {
			this.curPage =1L;
		}
		return curPage;
	}
	public void setCurPage(Long curPage) {
		this.curPage = curPage;
	}
	public Integer getPerpage() {
		if(this.perpage ==null || this.perpage ==0) {
			this.perpage = 10;
		}
		return perpage;
	}
	public void setPerpage(Integer perpage) {
		this.perpage = perpage;
	}


	public long getStartRow() {
		return startRow;
	}


	public long getLastRow() {
		return lastRow;
	}
	
	
	
	
}
