package org.jiang.COC.common;

import java.io.Serializable;
import java.util.List;

public class Page<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6908234716117634150L;
	
	private int pageSize;//每页显示多少条记�?
	private int currentPage;//当前第几页数�?
	private int totalNumber;// �?��多少条记�?
	private int totalPage;// �?��多少页记�?
	
	/**
	 * 接收分页后的要显示的数据
	 */
	private List<T> listShow;//��Ҫ��ʾ�����?
	
	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalNumber() {
		return totalNumber;
	}

	public void setTotalNumber(int totalNumber) {
		this.totalNumber = totalNumber;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public List<T> getListShow() {
		return listShow;
	}

	public void setListShow(List<T> listShow) {
		this.listShow = listShow;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Page(int pageSize, int currentPage, int totalNumber, int totalPage,
			List<T> listShow) {
		super();
		this.pageSize = pageSize;
		this.currentPage = currentPage;
		this.totalNumber = totalNumber;
		this.totalPage = totalPage;
		this.listShow = listShow;
	}

	public Page() {
		super();
	}

	@Override
	public String toString() {
		return "Page [pageSize=" + pageSize + ", currentPage=" + currentPage
				+ ", totalNumber=" + totalNumber + ", totalPage=" + totalPage
				+ ", listShow=" + listShow + "]";
	}
	/**
	 * 这个�?
	 * @param currentPage
	 * @param pageSzie
	 * @param list
	 */
	public Page(int currentPage,int pageSize,List<T> list){
		if(list==null){
			return;
		}else{
			this.totalNumber=list.size();//总条�?
			this.pageSize=pageSize;//页面大小
			
			//设置总页�?
			this.totalPage=this.totalNumber/this.pageSize;
			if(this.totalNumber%this.pageSize !=0){//整除了页数就是商，有余数那么就再加上�?��
				this.totalPage=this.totalPage+1;
			}
			
			//设置当前�?
			if(this.currentPage>this.totalPage){
				this.currentPage=this.totalPage;
			}else if(this.currentPage<1){
				this.currentPage=1;
			}else{
				this.currentPage=currentPage;
			}
			
			//设置索引
			int fromIndex=this.pageSize*(this.currentPage-1);
			int toIndex=this.pageSize*this.currentPage>this.totalNumber?this.totalNumber:this.pageSize*this.currentPage;

//			if(this.pageSize*this.currentPage>this.totalNumber){//�?��对数据进行判�?
//				 toIndex=this.totalNumber;
//			}else{
//				toIndex=this.pageSize*this.currentPage;//toIndex
//			}
			
			this.listShow=list.subList(fromIndex, toIndex);
		}
	}
}
