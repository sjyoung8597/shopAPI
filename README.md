# 지원자
송재영

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
		
# 회고
	- 개발진행 과정
		1. 첫번째 고민
			과제를 받고 첫번째로 고민 했던 내용은 "산정 규칙 이녀석을 어떻게 나누지?" 였습니다.
			최대한 익숙한 필기도구와 필기노트를 꺼내어 그림을 그렸습니다.
			"계산 규칙은 정해져 있지만 바뀔수 있어! 이걸 DB로 관리하는것이 과연 옳은가? 아닌가?"
			"반영 비율의 의미는 뭘까? 100%를 만들어야 되는것인가? 그렇기에는 최대 점수가 3만점인데? 	
			이 또한 변경 가능 하다고 봐야겠어!"
			"점수는 과연 정수에서 끝날까? 문자열이나, 소수점 일수도 있을것 같아."
			이런저런 변경 될 수 있다는 가설정보로 기획을 하였습니다. 기획을 하고 나니 패턴을 그려야 했습니다.
			"데코레이터를 써서 해당 정보를 하나씩 계산하자" "지금은 쓸일이 없겠지만 추상화팩토리를 만들어 볼까?" 등등
			즐거운 고민의 연속이였습니다. 아무리 생각 해도 정렬과 산정규칙은 나중에 더 고민을 해야 될 상황이 벌어 질 것같아,
			패턴 정리와 설계를 이쯤 하고 다른 기능을 구현 하기로 하였습니다.
		
		2. 첫번째 난관
			역시 자바 개발은 환경 설정이 절반인것이 맞는 것 같습니다. 집에 설치 되어 있지 않은 자바를 설치 후 메이븐과 
			이클립스 연동, 톰캣까지 설정 하니 여러가지 문제가 봉착 하게 되었습니다. 설정을 자주 해 본것이 아니라, 
			여러 상황과 여러 문제의 해결에 시간을 소모 하였습니다.
		
		3. 두번째 난관 
			DB역할 (json) 문제도 여러 시행착오를 겪어야만 했습니다. 당연히 간단하게 풀릴 것이라 생각했고, 
			얼마 걸리지 않을것이라 생각 했던 json 파일의 경로 문제로 어찌 할까 고민을 해야 했습니다. 최초 데이터를 초기 
			셋팅 하는 api를 개발 하려 했지만,이런것을 면접관들이 원할까? 란 생각에 결국은 web 폴더의 
			httpServletRequest path 로 해결 하기로 하였습니다. 
			(제가 2대의 컴퓨터에서는 테스트 시 이상이 없었는데 불안합니다.;; 안되시면 꼭 회신 부탁드립니다.)

		4. 두번째 고민
			정렬문제를 조금 이쁘게 만들기 위해 
			Comparator 를 사용 함에 있어 확장성을 고민 해야 했고, 각 조건마다 factory 시켜 조건을 실행 할수 있는 
			방향으로 고민을 하였습니다.
			그런데 Comparator는 interface로 직접 조건을 넣기에는 무리가 있어 보여 해당 Comparator를 추상화가 상속 시켜 아래 
			조건class의 팩토리 패턴 분리화를 시킬수 있었습니다.  
		
		5. 세번째 고민
			개발을 하다보니 리펙토링이 필요한 시점이 왔습니다. 아무리 그림을 그리고, 고민을 거듭하여 만들어도 중복 되는 
			코드나, 확장성이 떨어지는 코드가 생성되기 시작하였습니다. 모든 클래스를 interface화 시키고, 추상화 시켜서
			 모든 class를 재활용 목적으로 개발 할순 없지만  조금이나마 package를 최대한 분리화 하고, 나누는 작업을 
			 진행 하였습니다.
		
		6. 마무리
			다행히도 초창기 설계 해 놓은 고민 대로 과제를 무사히 끝나게 되어 기쁩니다.
			그리고 오랜만에 너무 즐거운 고민을 한 한주였습니다. 좋은 결과 기대 하겠습니다.
			
			
		
		
		 
		
