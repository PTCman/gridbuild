## :loudspeaker:Android Application Practice#2

:round_pushpin:  **출처**

[ArtSpace 앱 만들기]([https://developer.android.com/codelabs/basic-android-kotlin-compose-art-space?hl=ko&continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fandroid-basics-compose-unit-2-pathway-3%3Fhl%3Dko%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fbasic-android-kotlin-compose-art-space#0](https://developer.android.com/codelabs/basic-android-kotlin-compose-practice-grid?hl=ko&continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fandroid-basics-compose-unit-3-pathway-2%3Fhl%3Dko%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fbasic-android-kotlin-compose-practice-grid#0))

### 🌈학습 목표
- lazycolumn 활용
- card를 활용하여 list 항목 불러오기


### :sunny:화면 설정
<div style="display: flex; justify-content: space-between;">
<img src="https://github.com/PTCman/gridbuild/blob/main/img/screen.png" alt="대체 텍스트" style="width:200px;height:400px;">
</div>

대량의 카드를 불러온다

### ✅배운점
구글 녀석들 lazycolum만 알려줘서 lazycolum을 chunk로 쪼개서 사용 했는데 column 수만큼 pair를 만들고 그것을 다시 foreach로 돌리는 방식으로 만들었다. 하지만 솔루션 코드를 보니
LazyVerticalGrid라는 함수가 있었다. 이 함수를 이용하면 여러개의 열을 lazy하게 즉 동적으로 화면에 뽑아 낼수 있다.
그리고 


### ❗부족한점
안드로이드를 공부하면 할 수록 확실히 이것저것 web보단 화면디자인이 훨씬 간편한것 같다. 그러나 그 만큼 내가 모르는 함수들이 많기에, 꾸준히 많이 사용하고 무엇보다 코틀린 공부도 부족하지 않게 해야겠다. 자바를 쓰다 코틀린을 쓰니 확실히 갓틀린 그 잡채
