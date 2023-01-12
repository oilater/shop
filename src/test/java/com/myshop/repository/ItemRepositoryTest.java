package com.myshop.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.TestPropertySource;

import com.myshop.constant.ItemSellStatus;
import com.myshop.entity.Item;
import com.myshop.entity.QItem;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.thymeleaf.util.StringUtils;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
class ItemRepositoryTest {

	@Autowired
	ItemRepository itemRepository;
//SELL
// @DisplayName
//	public void createItemTest() {
//		Item item = new Item();
//		item.setItemNm("테스트 상품");
//		item.setPrice(10000);
//		item.setItemDetail("테스트 상품 상세 설명");
//		item.setItemSellStatus(ItemSellStatus.SELL);
//		item.setStockNumber(100);
//		item.setRegTime(LocalDateTime.now()); // 현재 날짜와 시간 저장
//		item.setUpdateTime(LocalDateTime.now()); //현재 날짜와 시간 저장
//	
//		Item savedItem = itemRepository.save(item); //데이터 insert
//		
//		System.out.println(savedItem.toString());
//	}

	public void createItemTest() {
		for (int i = 1; i <= 10; i++) {
			Item item = new Item();
			item.setItemNm("테스트 상품" + i);
			item.setPrice(10000 + i);
			item.setItemDetail("테스트 상품 상세 설명" + i);
			item.setItemSellStatus(ItemSellStatus.SELL);
			item.setStockNumber(100);
			item.setRegTime(LocalDateTime.now()); // 현재 날짜와 시간 저장
			item.setUpdateTime(LocalDateTime.now()); // 현재 날짜와 시간 저장
			Item savedItem = itemRepository.save(item); // 데이터 insert

		}
	}

	public void createItemTest2() {
		for (int i = 1; i <= 5; i++) {
			Item item = new Item();
			item.setItemNm("테스트 상품" + i);
			item.setPrice(10000 + i);
			item.setItemDetail("테스트 상품 상세 설명" + i);
			item.setItemSellStatus(ItemSellStatus.SELL);
			item.setStockNumber(100);
			item.setRegTime(LocalDateTime.now()); // 현재 날짜와 시간 저장
			item.setUpdateTime(LocalDateTime.now()); // 현재 날짜와 시간 저장
			Item savedItem = itemRepository.save(item); // 데이터 insert

		}

		for (int i = 6; i <= 10; i++) {
			Item item = new Item();
			item.setItemNm("테스트 상품" + i);
			item.setPrice(10000 + i);
			item.setItemDetail("테스트 상품 상세 설명" + i);
			item.setItemSellStatus(ItemSellStatus.SOLD_OUT);
			item.setStockNumber(0);
			item.setRegTime(LocalDateTime.now()); // 현재 날짜와 시간 저장
			item.setUpdateTime(LocalDateTime.now()); // 현재 날짜와 시간 저장
			Item savedItem = itemRepository.save(item); // 데이터 insert

		}

	}

//	@Test
//	@DisplayName("상품명 조회 테스트!~!~!~!")
//	public void findByItemNmTest() {
//		this.createItemTest(); // item 테이블에 insert (데이터 10개가 insert 됨)
//		List<Item> itemList = itemRepository.findByItemNm("테스트상품1");
//		for (Item item : itemList) {
//			System.out.println(item.toString());
//		}
//	}

//	@Test
//	@DisplayName("상품명, 상품상세설명 or 테스트")
//	public void findByItemNmOrItemDetailTest() {
//		this.createItemTest();
//		List<Item> itemList = itemRepository.findByItemNmOrItemDetail("테스트 상품1", "테스트상품 상세설명5");
//		for (Item item : itemList) {
//			System.out.println(item.toString());
//		}
//	}

//	@Test
//	@DisplayName("가격 LessThan 테스트")
//	public void findByPriceLessThanTest() {
//		this.createItemTest();
//		List<Item> itemList = itemRepository.findByPriceLessThan(10005);
//		for (Item item : itemList) {
//			System.out.println(item.toString());
//		}
//	}

//	@Test
//	@DisplayName("상품명, 상품상세설명 or 테스트")
//	public void findByPriceThanOrderByPriceDescTest() {
//		this.createItemTest();
//		List<Item> itemList = itemRepository.findByPriceLessThanOrderByPriceDesc(10005);
//		for (Item item : itemList) {
//			System.out.println(item.toString());
//		}
//	}
//	---quiz ---
//	@Test
//	@DisplayName("ItemNm and ItemSellStatus 테스트")
//	public void findByItemNmOrItemSellStatusTest() {
//		this.createItemTest();
//		List<Item> itemList = itemRepository.findByItemNmOrItemSellStatus("테스트 상품1", ItemSellStatus.SELL);
//		for (Item item : itemList) {
//			System.out.println(item.toString());
//		}
//	}
//	
//	@Test
//	@DisplayName("Price Between 테스트")
//	public void findByPriceBetweenTest() {
//		this.createItemTest();
//		List<Item> itemList = itemRepository.findByPriceBetween(10004, 10008);
//		for (Item item : itemList) {
//			System.out.println(item.toString());
//		}
//	}

//	@Test
//	@DisplayName("regTime 조건 테스트")
//	public void findByregTimeAfterTest() {
//		this.createItemTest();
//		List<Item> itemList = itemRepository.findByregTimeAfter(LocalDateTime.of(2023, 1, 1, 12, 12, 44));
//		for (Item item : itemList) {
//			System.out.println(item.toString());
//		}
//	}

//	@Test
//	@DisplayName("ItemSellStatus Not Null 테스트")
//	public void findByItemSellStatusIsNotNullTest() {
//		this.createItemTest();
//		List<Item> itemList = itemRepository.findByItemSellStatusNotNull();
//		for (Item item : itemList) {
//			System.out.println(item.toString());
//		}
//	}
//	
//	@Test
//	@DisplayName("ItemDetail Ending With테스트")
//	public void findByItemDetailEndingWithTest() {
//		this.createItemTest();
//		List<Item> itemList = itemRepository.findByItemDetailEndingWith("설명1");
//		for (Item item : itemList) {
//			System.out.println(item.toString());
//		}
//	}
//	

//	@Test
//	@DisplayName("@Query를 이용한 상품 조회 테스트")
//	public void findByItemDetailTest() {
//		this.createItemTest();
//		List<Item> itemList = itemRepository.findByItemDetail("테스트 상품 상태 설명");
//		for (Item item : itemList) {
//			System.out.println(item.toString());
//
//		}
//	}

//	@Test
//	@DisplayName("Price greater")
//	public void getPriceGreaterThanEqualTest() {
//		this.createItemTest();
//		List<Item> itemList = itemRepository.getPriceGreaterThanEqual(10005);
//		for (Item item : itemList) {
//			System.out.println(item.toString());
//		}
//	}
//	
//	@Test
//	@DisplayName("비교")
//	public void getItemNmAndItemSellStatusTest() {
//		this.createItemTest();
//		List<Item> itemList = itemRepository.getItemNmAndItemSellStatus("테스트 상품1", ItemSellStatus.SELL);
//		for (Item item : itemList) {
//			System.out.println(item.toString());
//		}
//	}

	// EntityManager 가 엔티티에 접근해서 select, insert 라든가 작업을 실행함
	@PersistenceContext
	EntityManager em;

	// 이거 참고해서 퀴즈 풀기
	@Test
	@DisplayName("querydsl 조회 테스트")
	public void queryDslTest() {
		this.createItemTest();
		// 쿼리를 동적으로 생성하기 위한 객체
		JPAQueryFactory qf = new JPAQueryFactory(em);
		QItem qItem = QItem.item;

		// select * from item where itemSellStatus = 'SELL' and itemDetail like %테스트 상품
		// 상세 설명;
		JPAQuery<Item> query = qf.selectFrom(qItem).where(qItem.itemSellStatus.eq(ItemSellStatus.SELL))
				.where(qItem.itemDetail.like("%테스트 상품 상세 설명%"));

		List<Item> itemList = query.fetch();

		for (Item item : itemList) {
			System.out.println(item.toString());
		}
	}

	@Test
	@DisplayName("query-quiz1")
	public void queryquizTest() {
		this.createItemTest();
		JPAQueryFactory qf = new JPAQueryFactory(em);
		QItem qItem = QItem.item;

		JPAQuery<Item> query = qf.selectFrom(qItem).where(qItem.itemNm.eq("테스트 상품1"))
				.where(qItem.itemSellStatus.eq(ItemSellStatus.SELL));
		List<Item> itemList = query.fetch();
		for (Item item : itemList) {
			System.out.println(item.toString());
		}
	}

	@Test
	@DisplayName("query-quiz1")
	public void queryquizTest2() {
		this.createItemTest();
		JPAQueryFactory qf = new JPAQueryFactory(em);
		QItem qItem = QItem.item;

		JPAQuery<Item> query = qf.selectFrom(qItem).where(qItem.price.between(10004, 10008));
		List<Item> itemList = query.fetch();
		for (Item item : itemList) {
			System.out.println(item.toString());
		}
	}

	@Test
	@DisplayName("query-quiz1")
	public void queryquizTest3() {
		this.createItemTest();
		JPAQueryFactory qf = new JPAQueryFactory(em);
		QItem qItem = QItem.item;

		JPAQuery<Item> query = qf.selectFrom(qItem).where(qItem.regTime.after(LocalDateTime.of(2023, 1, 1, 12, 12, 44)));
		List<Item> itemList = query.fetch();
		for (Item item : itemList) {
			System.out.println(item.toString());
		}
	}
	
	
	@Test
	@DisplayName("query-quiz1")
	public void queryquizTest4() {
		this.createItemTest();
		JPAQueryFactory qf = new JPAQueryFactory(em);
		QItem qItem = QItem.item;

		JPAQuery<Item> query = qf.selectFrom(qItem).where(qItem.itemSellStatus.isNotNull());
		List<Item> itemList = query.fetch();
		for (Item item : itemList) {
			System.out.println(item.toString());
		}
	}
	
	@Test
	@DisplayName("query-quiz1")
	public void queryquizTest5() {
		this.createItemTest();
		JPAQueryFactory qf = new JPAQueryFactory(em);
		QItem qItem = QItem.item;

		JPAQuery<Item> query = qf.selectFrom(qItem).where(qItem.itemDetail.endsWith("설명1"));
		
		List<Item> itemList = query.fetch();
		for (Item item : itemList) {
			System.out.println(item.toString());
		}
	}
	
//	@Test
//
//	@DisplayName("querydsl 조회테스트")
//	public void queryDslTest2() {
//		this.createItemTest2();
//		BooleanBuilder b = new BooleanBuilder();
//		QItem item = QItem.item;
//
//		String itemDetail = "테스트 상품 상세 설명";
//		int price = 10003;
//		String itemSellStatus = "SELL";
//
//		b.and(item.itemDetail.like("%" + itemDetail + "%"));
//		b.and(item.price.gt(price)); // price > 10003
//
//		if (StringUtils.equals(itemSellStatus, ItemSellStatus.SELL)) {
//			b.and(item.itemSellStatus.eq(ItemSellStatus.SELL));
//		}
//
//		Pageable page = PageRequest.of(0, 3); // of(조회할 페이지의 번호, 한페이지 당 조회할 데이터 갯수)
//		Page<Item> itemPageResult = itemRepository.findAll(b, page);
//	}

}
