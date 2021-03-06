# 개발환경
	- os : Windows 7 Professional K
	- IDE : Eclipse Java EE IDE for Web Developers. Neon.2 Release (4.6.2)
	- open Source : spingFramework 4.0.0.Release , com.googlecode.json-simple 1.1, jackson 2.8.6 등등
 				

# 실행환경
	- 기반 : 이클립스(Neon.2 Release (4.6.2)) + 메이븐(2.5.1) + 톰캣(7.0.75) + jdk 1.8.0_121
	- 테스트(개발)환경에서의 실행 : 
	1. github에서 해당 소스를 받습니다.(https://github.com/sjyoung8597/shopAPI)
	2. 이클립스에서 해당 소스 maven(existing mave projects) 형식으로 import 합니다
	3. 상단 Project - Clean.. 처리 해 줍니다.
	4. 프로젝트 오른쪽 클릭 - Project Build (없을 경우 스킵)
	5. 프로젝트 오른쪽 클릭 - Maven - Update Project 클릭 (메이븐 설치 필수)
	6. server를 create 합니다. (톰캣 7.0.75)
	7. 서버를 start합니다.
	
# 혹시 모를 에러
	- 이클립스 기반으로 서버 작동시 오류가 발생 한다면 다음 같은 이슈 일 가능성이 높습니다.
	1. JRE System Library 가  jdk1.8.0_121 버전 인가?
	2. 프로젝트 properties - deployment assembly - java build path entries - maven dependencies 가 add 되어 있는가?
	3. json 파일이 없다고 에러 시 컴파일 문제 일 가능성이 높습니다. 
		- json 파일들 위치는 다음 경로에 있습니다.(의도적) src-main-webapp 에 3개의 파일이 존재
		(settingDB_table.json, shopImgInfoDB_table.json, shopInfoDB_table.json)

# API 목록

	- 모든 API는 브라우저 테스트 시 결과물 제공에 용이하기 위하여 Get 방식으로 개발을 종료 하였습니다.(의도적입니다.)
	- API의 특성상 resultCodeStatus 를 포함하여 requestData를 만드는것이 정상이나
		성공(resultCode : 0)/실패(resultCode : -1)에 따른 결과만 update에 한에 도출 하였습니다.

	- 상점 목록 조회
		URL : http://localhost:8080/shop/shopList
		예제 : http://localhost:8080/shop/shopList?sortASC=asc&sortKind=ShopKey&pageSize=5&currentPage=1
		request Parameter : 
			1. sortASC(오름차순 정렬 여부)
				asc = 오른차순, 
				desc(기타) = 내림차순
			2. sortKind(정렬방식)
				shopkey = PK순,
				lookup = 조회수순,
				like = 좋아요순,
				shopvaluescore = 가치정보 순
			3. pageSize(페이징 사이즈)
				int 정수
			4. currentPage(현재 페이지 위치)
				int 정수
				
		response Data :
			1. totalCount = 총 갯수
			2. shopList = 상점정보 
				2-1. n4ShopKey = 상점PK
				2-2. strShopName = 상점 이름
				2-3. strShopDescription = 상점 설명
				2-4. strPhoneNum = 전화번호
				2-5. n4Lookup = 조회수
				2-6. n4Like = 좋아요
				2-7. n4UserAverageScore = 유저평점
				2-8. strShopImg = 대표 이미지url
				2-9. strShopKind = 상점종류
				2-10. isShopPromotionYN = 프로모션 여부
				2-11. n4ShopValueScore = 상점가치점수
				2-12. n4ModifyDate = 최근 수정 날짜
		
		실제 response Data :
			{
				"totalCount":21,
				"shopList":[{
					"n4ShopKey":8,
					"strShopName":"tmm9556",
					"strShopDescription":"sell n",
					"strPhoneNum":"0212969634",
					"n4Lookup":56,
					"n4Like":6,
					"n4UserAverageScore":9,
					"strShopImg":"http://img.com/756",
					"strShopKind":"n",
					"isShopPromotionYN":false,
					"n4ShopValueScore":5550,
					"n4ModifyDate":20170129}]
				
			}
	
	
	- 상점 상세 조회 API
		URL : http://localhost:8080/shop/shopInfo
		예제 : http://localhost:8080/shop/shopInfo?key=21
		request Parameter : 
			1. key(상점PK)
		
		response Data :
			1. n4ShopKey = 상점PK
			2. strShopName = 상점 이름
			3. strShopDescription = 상점 설명
			4. strPhoneNum = 전화번호
			5. n4Lookup = 조회수
			6. n4Like = 좋아요
			7. n4UserAverageScore = 유저평점
			8. strShopImg = 대표 이미지url
			9. strShopKind = 상점종류
			10. isShopPromotionYN = 프로모션 여부
			11. n4ShopValueScore = 상점가치점수
			12. n4ModifyDate = 최근 수정 날짜
		
		실제 response Data :
			{
				"n4ShopKey":21,
				"strShopName":"tmon192",
				"strShopDescription":"sell a",
				"strPhoneNum":"0212341234",
				"n4Lookup":10523,
				"n4Like":86,
				"n4UserAverageScore":8,
				"strShopImg":"http://img.com/123",
				"strShopKind":"n",
				"isShopPromotionYN":true,
				"n4ShopValueScore":0,
				"n4ModifyDate":20170217
			}
			
			
	- 상점 사진 조회 API
		URL : http://localhost:8080/shop/shopImgInfo
		예제 : http://localhost:8080/shop/shopImgInfo?key=21
		request Parameter : 
			1. key(상점PK)
		
		response Data :
			1. n4ShopKey = 상점 PK
			2. strShopImgUrl = 메인이미지
			3. strShopImgOrigin = 사진출처
		
		실제 response Data :
			{
				"n4ShopKey":21,
				"strShopImgUrl":"http://img.com/main/984ds",
				"strShopImgOrigin":"self"
			}
			
			
	- 상점 가치 규칙 변경 API
		URL : http://localhost:8080/shop/ruleSetting
		예제 : http://localhost:8080/shop/ruleSetting?CustomerValuePersent=70&ShopValuePersent=30&LookupPersent=30&LikePersent=40&UserAverageScorePersent=30&NewShopInfoPersent=55&PromotionYNPersent=45
		
		request Parameter : 
			1. CustomerValuePersent = 고객가치 퍼센트
			2. ShopValuePersent = 상점가치 퍼센트
			3. LookupPersent = 조회수 퍼센트
			4. LikePersent = 좋아요 퍼센트
			5. UserAverageScorePersent = 사용자평균점수 퍼센트
			6. NewShopInfoPersent = 최신 정보 업데이트 날짜 퍼센트
			7. PromotionYNPersent = 할인 여부 퍼센트
		
		response Data :
			1. "responseCode":{"n4ResultCode":0,"strResultMessage":"처리완료"}
		
		
	- 상점 가치 점수 적용 API
		URL : http://localhost:8080/shop/valueScoreSetting
		예제 : http://localhost:8080/shop/valueScoreSetting
		
		response Data :
			1. "responseCode":{"n4ResultCode":0,"strResultMessage":"처리완료"}

#테스트 방법
	
	- 규칙 룰 셋팅 API TEST case 
	1. 규칙 룰 셋팅 api 실행
		http://localhost:8080/shop/ruleSetting?CustomerValuePersent=70&ShopValuePersent=30&LookupPersent=30&LikePersent=40&UserAverageScorePersent=30&NewShopInfoPersent=55&PromotionYNPersent=45
	2. 해당 파일 확인(settingDB_table.json) root폴더
	
	- 가치 정보 계산 API TEST case
	1. 상점 목록 api 실행 (상점가치 정보 default = 0)
		http://localhost:8080/shop/shopList?sortASC=dasc&sortKind=lookup&pageSize=10&currentPage=1
	2. 상점 가치 계산 api 실행
		http://localhost:8080/shop/valueScoreSetting
	3. 상점 목록 api 실행 (상점가치 정보 변경 확인)
		http://localhost:8080/shop/shopList?sortASC=dasc&sortKind=lookup&pageSize=10&currentPage=1

	- 상점 목록 API
	1. 상점 목록 api 실행
		http://localhost:8080/shop/shopList?sortASC=dasc&sortKind=lookup&pageSize=10&currentPage=1
		(파라미터 값 변경 위의 API 목록 확인)
	
	- 상점 상세 API
	1. http://localhost:8080/shop/shopInfo?key=21
	
	- 상점 이미지 API
	1. http://localhost:8080/shop/shopImgInfo?key=21

# 간단 Package 설명

	- 데이터 흐름도
		1. com.tmon.shop
			API Controller
		2. com.tmon.biz
			해당 api의 비즈니스
		3. com.tmon.dto
			데이터의 entity
		4. com.tmon.dao
			DB 커넥터 역할(json으로 대체 하였습니다.)
			
	- 비즈니스 Package 설명
		com.tmon.biz
			비즈니스 Interface
		com.tmon.biz.impl
			main 비즈니스
		com.tmon.biz.common
			공통 사용 비즈니스
		com.tmon.biz.check
			httpservletRequest 정보 체크
		com.tmon.biz.calculation / com.tmon.biz.calculation.detail
			가치 산정 규칙 비즈니스
		com.tmon.biz.sort
			정렬 비즈니스
		
			
		
		
		 
		
