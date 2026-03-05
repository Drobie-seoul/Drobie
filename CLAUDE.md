# Drobie Client - Library Guide

## Navigation 3 (navigation3-ui:1.0.0-alpha05)

### 기본 사용법

```kotlin
// 1. 백스택 생성
val backStack = remember { mutableStateListOf<Any>(HomeScreen) }

// 2. NavDisplay로 화면 렌더링
NavDisplay(backStack = backStack) { screen ->
    when (screen) {
        is HomeScreen -> HomeContent(
            onProductClick = { backStack.add(ProductScreen(it)) }
        )
        is ProductScreen -> ProductContent(
            onBack = { backStack.removeLast() }
        )
    }
}
```

### 화면 이동
```kotlin
backStack.add(ProductScreen(id = 123))   // 화면 추가
backStack.removeLast()                    // 뒤로가기
```

### ViewModel 연동 (lifecycle-viewmodel-navigation3)
```kotlin
NavDisplay(backStack = backStack) { screen ->
    when (screen) {
        is HomeScreen -> {
            val viewModel = viewModel<HomeViewModel>()
            HomeContent(viewModel)
        }
    }
}
```

## Koin DI (koin:4.1.1)

### 모듈 정의
```kotlin
val appModule = module {
    singleOf(::CartRepository)
    viewModelOf(::HomeViewModel)
    viewModelOf(::ProductViewModel)
}
```

### 앱 초기화
```kotlin
// commonMain App.kt
KoinApplication(application = { modules(appModule) }) {
    // App content
}
```

### ViewModel 주입
```kotlin
@Composable
fun HomeScreen() {
    val viewModel = koinViewModel<HomeViewModel>()
}
```

## Architecture: MVVM + 단일 UiState

```kotlin
// State
data class HomeUiState(
    val isLoading: Boolean = true,
    val products: List<Product> = emptyList()
)

// ViewModel
class HomeViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()
}

// View
@Composable
fun HomeScreen(viewModel: HomeViewModel) {
    val uiState by viewModel.uiState.collectAsState()
}
```
