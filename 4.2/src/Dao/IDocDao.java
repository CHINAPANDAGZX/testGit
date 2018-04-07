package Dao;

import java.util.HashMap;
import java.util.List;

import Bean.DocSearchBean;
import Bean.Document;


public interface IDocDao {

	//向文档表添加一条记录
	public Integer addDoc(Document doc);
	//查询文档
//	public List<Document> findDocument(HashMap<String,String> map);
	public List<Document> findDocument(DocSearchBean dsb);
	//查询文档
	public List<Document> findAllDocument();

}
