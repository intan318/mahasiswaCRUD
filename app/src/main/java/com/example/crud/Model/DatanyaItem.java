package com.example.crud.Model;

import com.google.gson.annotations.SerializedName;


public class DatanyaItem{

	@SerializedName("nim")
	private String nim;

	@SerializedName("name")
	private String name;

	@SerializedName("jurusan")
	private String jurusan;

	@SerializedName("id")
	private String id;

	public void setNim(String nim){
		this.nim = nim;
	}

	public String getNim(){
		return nim;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setJurusan(String jurusan){
		this.jurusan = jurusan;
	}

	public String getJurusan(){
		return jurusan;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	@Override
 	public String toString(){
		return 
			"DatanyaItem{" + 
			"nim = '" + nim + '\'' + 
			",name = '" + name + '\'' + 
			",jurusan = '" + jurusan + '\'' + 
			",id = '" + id + '\'' + 
			"}";
		}
}