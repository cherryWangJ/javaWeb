/**   
 * @Title: Page.java 
 * @Package cn.war.core.persistence 
 * @Description: 对象实体
 * @author xiangping
 * @date 2015年11月13日 下午10:14:37 
 * @version V1.0   
 */
package utils;

import java.io.Serializable;

/**
 * @author wuyang
 *
 */
public class Page implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int pageSize = 10; // 每页显示的记录数
	private int totalPage; // 总页数
	private int totalResult;// 总记录数
	private int currentPage;// 当前页
	private int startRow; // 起始行索引
	private int endRow; // 结束行索引
	private String orderField; // 排序字段
	private String orderDirection; // 排序方向
	private boolean allowPage = true; // 是否分页：true:分页，false:不分页

	private String pageStr;// 分页插件

	private PageData pd = new PageData(); // SQL参数

	public Page() {
		if (this.pageSize == 0) {
			this.pageSize = 15;
		}
	}

	public Page(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * @return the pageSize
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * @param pageSize
	 *            the pageSize to set
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * @return the totalPage
	 */
	public int getTotalPage() {
		if (this.totalResult % pageSize == 0) {
			totalPage = totalResult / pageSize;
		} else {
			totalPage = totalResult / pageSize + 1;
		}
		return totalPage;
	}

	/**
	 * @param totalPage
	 *            the totalPage to set
	 */
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	/**
	 * @return the totalResult
	 */
	public int getTotalResult() {
		return totalResult;
	}

	/**
	 * @param totalResult
	 *            the totalResult to set
	 */
	public void setTotalResult(int totalResult) {
		this.totalResult = totalResult;
	}

	/**
	 * @return the currentPage
	 */
	public int getCurrentPage() {
		if (currentPage <= 0) {
			currentPage = 1;
		} else if (currentPage > getTotalPage() && getTotalPage() > 0) {
			currentPage = this.totalPage;
		}
		return currentPage;
	}

	/**
	 * @param currentPage
	 *            the currentPage to set
	 */
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	/**
	 * @return the startRow
	 */
	public int getStartRow() {
		this.startRow = (this.currentPage - 1) * pageSize;
		if (startRow < 0) {
			startRow = 0;
		}
		return startRow;
	}

	/**
	 * @param startRow
	 *            the startRow to set
	 */
	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	/**
	 * @return the endRow
	 */
	public int getEndRow() {
		this.endRow = startRow + pageSize;
		if (endRow > totalResult) {
			endRow = totalResult;
		}
		return endRow;
	}

	/**
	 * @param endRow
	 *            the endRow to set
	 */
	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}

	/**
	 * @return the orderField
	 */
	public String getOrderField() {
		return orderField;
	}

	/**
	 * @param orderField
	 *            the orderField to set
	 */
	public void setOrderField(String orderField) {
		this.orderField = orderField;
	}

	/**
	 * @return the orderDirection
	 */
	public String getOrderDirection() {
		return orderDirection;
	}

	/**
	 * @param orderDirection
	 *            the orderDirection to set
	 */
	public void setOrderDirection(String orderDirection) {
		this.orderDirection = orderDirection;
	}

	/**
	 * @return the allowPage
	 */
	public boolean isAllowPage() {
		return allowPage;
	}

	/**
	 * @param allowPage
	 *            the allowPage to set
	 */
	public void setAllowPage(boolean allowPage) {
		this.allowPage = allowPage;
	}

	/**
	 * @return the pd
	 */
	public PageData getPd() {
		return pd;
	}

	/**
	 * @return the pageStr
	 */
	public String getPageStr() {
		StringBuffer sb = new StringBuffer();
		sb.append("<div id=\"<portlet:namespace/>page\" style=\"margin-top:5px; text-align:center;\">");
		//sb.append("<portlet:renderURL var=\"doVeiwUrl\"/>");
		sb.append("	<script type=\"text/javascript\">");
		sb.append("	$(function(){");
		sb.append("	laypage({");
		sb.append("	  cont: '<portlet:namespace/>page',");
		sb.append("	  pages: "+getTotalPage()+",");
		sb.append("	  skin: '#00AF90',");
		sb.append("	  groups:8,");
		sb.append("	  curr: function(){ ");
		sb.append("	    var page = location.search.match(/currentPage=(\\d+)/);");
		sb.append("	    return page ? page[1] : 1;");
		sb.append("	  }(), ");
		sb.append("	  jump: function(e, first){");
		sb.append("	    if(!first){ ");
		
		
		/*sb.append("var url=window.location.href;");
		sb.append("if(url.indexOf('currentPage=')>0){");
		sb.append("   url=url.substring(0,url.indexOf('currentPage='))+'currentPage='+e.curr;");
		sb.append("}");
		sb.append("else{");
		sb.append("  url=url+'?currentPage='+e.curr;");
		sb.append("}");
		sb.append("	      location.href =url");*/
		
		
		sb.append("	      location.href ='?currentPage='+e.curr;");
		sb.append("	    }");
		sb.append("	  }");
		sb.append("	});");
		sb.append("});");
		sb.append("</script>");
		sb.append("</div>");
		
	
		pageStr = sb.toString();
		return pageStr;
	}

	/**
	 * @param pageStr
	 *            the pageStr to set
	 */
	public void setPageStr(String pageStr) {
		this.pageStr = pageStr;
	}

	/**
	 * @param pd
	 *            the pd to set
	 */
	public void setPd(PageData pd) {
		this.pd = pd;
	}

}
