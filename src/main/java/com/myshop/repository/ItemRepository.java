package com.myshop.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.myshop.constant.ItemSellStatus;
import com.myshop.entity.Item;

// JpaRepository : 기본적인 CRUD 및 페이지 처리를 위한 메소드가 정의가 되어있다.
// <사용할 entity, entity class의 기본키 타입을 넣어주면 됨!>
public interface ItemRepository extends JpaRepository<Item, Long> {
//	// select * from item where item_nm = ?
//	List<Item> findByItemNm(String itemNm);
//
//	// select * from item where item_nm = ? or item_detail = ?
//	List<Item> findByItemNmOrItemDetail(String itemNm, String itemDetail);
//
//	// select * from item where price < ?
//	List<Item> findByPriceLessThan(Integer price);
//
//	//
//	List<Item> findByPriceLessThanOrderByPriceDesc(Integer price);
//	
//	
//	List<Item> findByItemNmOrItemSellStatus(String itemNm, ItemSellStatus itemSellStatus);
//	
//	
//	List<Item> findByPriceBetween(Integer price, Integer price2);
//
//	List<Item> findByregTimeAfter(LocalDateTime regTime);
//	
//	List<Item> findByItemSellStatusNotNull();
//	
//	List<Item> findByItemDetailEndingWith(String itemDetail);

//쿼리문 하고 똑같은데 entity 명(Item)을 써주면 된다! 별칭도 붙여줘야 함! jpql은 :이 이썽야함 param으로 받아서 %:으로 사용!
//	@Query("select i from Item i where i.itemDetail like %:itemDetail% order by i.price desc")
//	List<Item> findByItemDetail(@Param("itemDetail") String itemDetail);

	//아래와 같이 사용할 수도 있음 다만 위에 껄 더 많이 쓴다
	@Query("select i from Item i where i.itemDetail like %?1% order by i.price desc")
	List<Item> findByItemDetail(String itemDetail);

//	//ㄱ추상메소드
//	@Query(value="select * from Item i where i.itemDetail like order by i.price desc", nativeQuery = true)
//	List<Item> findByItemDetailByNative(@Param("itemDetail") String itemDetail);
	
	@Query("select i from Item i where i.price >= :price")
	List<Item> getPriceGreaterThanEqual(@Param("price") Integer price);

	
	@Query("select i from Item i where i.itemNm = :itemNm and itemSellStatus = :itemSellStatus")
	List<Item> getItemNmAndItemSellStatus(@Param("itemNm") String itemNm, @Param("itemSellStatus") ItemSellStatus itemSellStatus);
	
	
	
	
	
}
