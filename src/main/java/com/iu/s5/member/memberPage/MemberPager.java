package com.iu.s5.member.memberPage;

public class MemberPager {
	
	private Long curPage;
	private Integer perPage;
	
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
		this.startRow = (this.getCurPage()-1)*this.getPerPage()+1;
		this.lastRow = this.getCurPage()*this.getPerPage();
	}
	
	public void makePage(long totalCount) {
		
		//totalcount로 totalpage 계산
		this.totalPage = totalCount/this.getPerPage();
		if(totalCount%this.getPerPage() !=0) {
			this.totalPage++;
		}
		
		//totalpage로 totalblock 계산
		long perBlock =5L;
		this.totalBlock = totalPage/perBlock;
		if(totalPage%perBlock !=0) {
			this.totalBlock++;
		}
		
		//curpage로 curblock 찾기
		this.curBlock = this.curPage/perBlock;
		if(this.curPage%perBlock !=0) {
			this.curBlock++;
		}
		
		//curBlock으로 startNum,lastNum 계산
		this.startNum = (this.curBlock-1)*perBlock+1;
		this.lastNum = this.curBlock*perBlock;
		
		if(this.curBlock==this.totalBlock) {
			this.lastNum=this.totalPage;
		}
		
	}

	
	
	
	public long getStartRow() {
		return startRow;
	}
	public long getLastRow() {
		return lastRow;
	}
	public long getStartNum() {
		return startNum;
	}
	public long getLastNum() {
		return lastNum;
	}
	public long getTotalPage() {
		return totalPage;
	}
	public long getTotalBlock() {
		return totalBlock;
	}
	public long getCurBlock() {
		return curBlock;
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

	public Long getCurPage() {
		if(this.curPage==null|| this.curPage==0) {
			this.curPage=1L;
		}
		return curPage;
	}
	
	public void setCurPage(Long curPage) {
		this.curPage = curPage;
	}
	
	public Integer getPerPage() {
		if(this.perPage==null||this.perPage==0) {
			this.perPage=10;
		}
		return perPage;
	}
	
	public void setPerPage(Integer perPage) {
		this.perPage = perPage;
	}
}
