package com.spring.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.DefaultNamingPolicy;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartRequest;

import com.spring.model.PageDTO;
import com.spring.model.ProductDTO;
import com.spring.model.admin_productDTO;

import oracle.net.aso.r;

@Repository
public class Admin_productDAOImpl implements Admin_productDAO{
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public int getListCount() {
		
		return this.sqlSession.selectOne("getListCount");
		
	}
	
	@Override
	public int getListTagCount(Map<String, Object> map) {

		return this.sqlSession.selectOne("getListTagCount", map);
		
	}
	
	@Override
	public List<admin_productDTO> getProductList(PageDTO dto) {
		return this.sqlSession.selectList("getProductList",dto);
	}

	
	@Override
	public List<ProductDTO> getProductList(PageDTO dto, String sort) {
		return this.sqlSession.selectList(sort,dto);
		
	}
	
	@Override
	public List<ProductDTO> getProductTagList(Map<String, Object> map, String sort) {

		return this.sqlSession.selectList(sort+"_tag", map);
		
	}

	@Override
	public admin_productDTO getProductCont(int product_no) {
		return this.sqlSession.selectOne("adminProductContent", product_no);
	}

	@Override
	public List<admin_productDTO> searchProductList(Map<String, Object> map) {
		return this.sqlSession.selectList("adminProductSearch", map);
	}

	@Override
	public int getSearchListCount(String keyword) {
		return this.sqlSession.selectOne("getSearchListCount", keyword);
	}

	@Override
	public int insertProduct(admin_productDTO adto) {

		return this.sqlSession.insert("adminProductInsertt", adto);
	}

	//�Ǹ��� -> �Ǹ�����(ǰ��)
	@Override
	public int productStatusChange(int product_no) {
		return this.sqlSession.update("productStatusChange", product_no);
	}

	//�Ǹ�����(ǰ��) -> �Ǹ���
	@Override
	public int productStatusChange2(int product_no) {
		return this.sqlSession.update("productStatusChange2", product_no);
	}


	@Override
	public int productUpdate(admin_productDTO adto) {
		return this.sqlSession.update("adminProductUpdatee", adto);
	}

	@Override
	public int insertGoods(admin_productDTO adto) {
		return this.sqlSession.insert("adminProductIns", adto);
	}

	@Override
	public int deleteProduct(int product_no) {
		return this.sqlSession.delete("adminProductDelete", product_no);
	}

	@Override
	public void productUpdateSeq(int product_no) {
		this.sqlSession.update("seq", product_no);
	}

	@Override
	public List<admin_productDTO> stopProductList(PageDTO dto) {
		return this.sqlSession.selectList("getStopProductList", dto);
	}

	@Override
	public int getStopProductCount() {
		return this.sqlSession.selectOne("stopProductCount");
	}

	@Override
	public List<admin_productDTO> IngProductList(PageDTO dto) {
		return this.sqlSession.selectList("getIngProductList", dto);
	}

	@Override
	public int getIngProductCount() {
		return this.sqlSession.selectOne("salProductCount");
	}

	@Override
	public int getSearchIngProductCount(String keyword) {
		return this.sqlSession.selectOne("getSearchIngListCount", keyword);
	}

	@Override
	public List<admin_productDTO> searchIngProductList(Map<String, Object> map) {
		return this.sqlSession.selectList("adminIngProductSearch", map);
	}

	@Override
	public int productUpdateWithoutThumbnail(admin_productDTO adto) {
		return this.sqlSession.update("adminProductUpdateWithoutThumbnail", adto);
	}

}
