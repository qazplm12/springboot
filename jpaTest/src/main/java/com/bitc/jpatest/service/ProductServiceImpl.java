package com.bitc.jpatest.service;

import com.bitc.jpatest.data.entity.ProductEntity;
import com.bitc.jpatest.data.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public void finds() throws Exception {
        System.out.println("-------------findBy() 쿼리 메소드 실행----------------");

        Optional<ProductEntity> prod1 = productRepository.findByNumber((long) 1);
        Optional<ProductEntity> prod2 = productRepository.findProductEntityByNumber((long) 2);
        List<ProductEntity> prod3 = productRepository.findAllByName("상품1");
        ProductEntity prod4 = productRepository.queryByName("상품1");

    }

    @Override
    public void exists() throws Exception {
        System.out.println("-------------existsBy() 쿼리 메소드 실행----------------");

        boolean isProductNumber = productRepository.existsByNumber((long) 200);

    }

    @Override
    public void count() throws Exception {
        System.out.println("-------------countBy() 쿼리 메소드 실행----------------");

        int countProduct = productRepository.countByName("상품1");
    }

    @Override
    public void delete() throws Exception {
        System.out.println("-------------deleteBy() 쿼리 메소드 실행----------------");

//        productRepository.deleteByNumber((long) 10);
//        long removeProduct =  productRepository.removeByName("상품9");
    }

    @Override
    public void limit() throws Exception {

    }

    @Override
    public void equals() throws Exception {

    }

    @Override
    public void isNot() throws Exception {

    }

    @Override
    public void isNull() throws Exception {

    }

    @Override
    public void isNotNull() throws Exception {

    }

    @Override
    public void and() throws Exception {
        System.out.println("-------------and() 쿼리 메소드 실행----------------");

        ProductEntity product1 = productRepository.findByNumberAndName((long) 5,"상품6");
        ProductEntity product2 = productRepository.findByNumberAndName((long) 6,"상품6");
    }

    @Override
    public void or() throws Exception {

    }

    @Override
    public void between() throws Exception {

    }

    @Override
    public void like() throws Exception {

    }

    @Override
    public void orderBy() throws Exception {

    }

    @Override
    public void querySelectAll() throws Exception {
        System.out.println("--------- @query 사용, querySelectAll 실행 -----------");
        List <ProductEntity> prod1 = productRepository.querySelectAll();
        System.out.println("--------- @query 사용완료, querySelectAll 실행완료 -----------");}

    @Override
    public void querySelectName() throws Exception {
        System.out.println("--------- @query 사용, querySelectName 실행 -----------");
        ProductEntity prod1 = productRepository.querySelectName();
        ProductEntity prod2 = productRepository.querySelectName("상품3");
        ProductEntity prod3 = productRepository.querySelectNameAndPrice("상품3", 2000);
        System.out.println("--------- @query 사용, querySelectName 실행완료 -----------");

    }
}
