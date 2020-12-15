/**
 * 
 */
package com.mystudy.util;

import org.springframework.stereotype.Service;

/**
 * @author om
 *
 */
@Service
public class PagableImpl{
	private int pageNumber;
	private int pageSize;
	private boolean first;
	private int firstPageNumber = 0;
	private boolean next;
	private int nextPageNumber;
	private boolean previous;
	private int previousPageNumber;
	private boolean last;
	private int lastPageNumber;
	private long totalRecords;
	private int totalRecordsFetched;
	
	public PagableImpl() {
	}
	
	public void setDetails(int pageNumber, int pageSize, long totalRecords, int totalRecordsFetched) {
		this.pageNumber = pageNumber;
		this.pageSize = pageSize;
		this.totalRecords = totalRecords;
		this.totalRecordsFetched = totalRecordsFetched;
		first = pageNumber == 1 ? true : false;
		firstPageNumber = 1;
		if(first) {
			previousPageNumber = pageNumber;
		} else {
			previous = true;
			previousPageNumber = pageNumber - 1;
		}
		int l =(int) (totalRecords / pageSize);
		if(totalRecords % pageSize == 0) {
			last = l != pageNumber ? true : false;
			lastPageNumber = l;
		} else {
			last = l + 1 != pageNumber ? true : false;
			lastPageNumber = l + 1;
		}
		if(last) {
			next = true;
			nextPageNumber = pageNumber + 1;
		} else {
			nextPageNumber = pageNumber;
		}
	}
	
	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public boolean isFirst() {
		return first;
	}

	public void setFirst(boolean first) {
		this.first = first;
	}

	public int getFirstPageNumber() {
		return firstPageNumber;
	}

	public void setFirstPageNumber(int firstPageNumber) {
		this.firstPageNumber = firstPageNumber;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getNextPageNumber() {
		return nextPageNumber;
	}

	public void setNextPageNumber(int nextPageNumber) {
		this.nextPageNumber = nextPageNumber;
	}

	public boolean isPrevious() {
		return previous;
	}

	public void setPrevious(boolean previous) {
		this.previous = previous;
	}

	public int getPreviousPageNumber() {
		return previousPageNumber;
	}

	public void setPreviousPageNumber(int previousPageNumber) {
		this.previousPageNumber = previousPageNumber;
	}

	public boolean isLast() {
		return last;
	}

	public void setLast(boolean last) {
		this.last = last;
	}

	public int getLastPageNumber() {
		return lastPageNumber;
	}

	public void setLastPageNumber(int lastPageNumber) {
		this.lastPageNumber = lastPageNumber;
	}

	public long getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(long totalRecords) {
		this.totalRecords = totalRecords;
	}

	public int getTotalRecordsFetched() {
		return totalRecordsFetched;
	}

	public void setTotalRecordsFetched(int totalRecordsFetched) {
		this.totalRecordsFetched = totalRecordsFetched;
	}
}
