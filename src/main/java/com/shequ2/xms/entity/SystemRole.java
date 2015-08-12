package com.shequ2.xms.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Transient;


/**
 * 系统角色
 */

@Entity
public class SystemRole extends BaseEntity {
	
	private static final long serialVersionUID = -8303384761473305312L;
	
	private String name;			// 名称
	private String description;		// 描述
	private String status;			// 状态
	
	@Transient private List<SystemFunction> functions;
	@Transient private List<Long> functionIds;
	@Transient private String createAtHead;
	@Transient private String createAtTail;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreateAtHead() {
		return createAtHead;
	}

	public void setCreateAtHead(String createAtHead) {
		this.createAtHead = createAtHead;
	}

	public String getCreateAtTail() {
		return createAtTail;
	}

	public void setCreateAtTail(String createAtTail) {
		this.createAtTail = createAtTail;
	}

	public List<SystemFunction> getFunctions() {
		return functions;
	}

	public void setFunctions(List<SystemFunction> functions) {
		this.functions = functions;
	}

	public List<Long> getFunctionIds() {
		return functionIds;
	}

	public void setFunctionIds(List<Long> functionIds) {
		this.functionIds = functionIds;
	}

}
