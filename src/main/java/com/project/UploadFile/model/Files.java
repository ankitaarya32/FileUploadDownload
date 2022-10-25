package com.project.UploadFile.model;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Files {
	 @Id
	    @GeneratedValue(generator = "uuid")
	   
private long id;
	 private String fileName;

	    private String fileType;
@Lob
private byte[] data;
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getFileName() {
	return fileName;
}
public void setFileName(String fileName) {
	this.fileName = fileName;
}
public String getFileType() {
	return fileType;
}
public void setFileType(String fileType) {
	this.fileType = fileType;
}
public byte[] getData() {
	return data;
}
public void setData(byte[] data) {
	this.data = data;
}
public Files(String fileName, String fileType, byte[] data) {
	super();
	this.fileName = fileName;
	this.fileType = fileType;
	this.data = data;
}
public Files() {
	super();
}
@Override
public String toString() {
	return "Files [id=" + id + ", fileName=" + fileName + ", fileType=" + fileType + ", data=" + Arrays.toString(data)
			+ "]";
}


}
