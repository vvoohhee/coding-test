# Graph 
* 정점(vetex)과 간선(edge)의 집합으로 정점 사이의 연결 관계를 나타내는 자료구조 <br>
* G(v, e) 로 표현

<br>

---

## 그래프의 종류
### <b>1. 방향그래프 vs 무향그래프</b> <br>
   정점에 연결된 간선의 방향 유무에 따라 나누는 방식 

### <b>2. 다중그래프 vs 단순그래프</b> <br> 
   두 정점 사이에 연결된 간선의 개수에 따라 나누는 방식

### <b>3. 가중치그래프 (다익스트라)</b> <br> 
   간선마다의 가중치가 존재하는 그래프

<br>

---

## 표현 방법
### 인접리스트
* vertex:[connectedVertex1, connectedVertex2, .. ] 형태로 인접한 정점 리스트를 HashMap에 저장

### 인접행렬
* array[i][j] 형태, 각 배열 요소에 i, j 버텍스 간의 간선 개수를 배열로 표현

### 암시적그래프
* array[i][j] 형태, 직접 간선의 관계를 표현하지 않지만 한 요소를 정점으로 보고 연결됨, 간선없음으로 표현

<br>

---

## 그래프 순회 방법
### BFS : 너비 우선 탐색
기준이 되는 정점에 가장 가까운 순으로 탐색하는 방식 <br>
DFS는 최대한 멀리 있는 노드를 우선 탐색하지만, BFS는 다까운 노드부터 탐색한다. <br>
BFS 구현은 FIFO 방식인 큐를 사용하는 것이 정석이다. (가까운 것부터 순서대로 탐색하므로) <br>
BFS 탐색의 경우, 노드 방문 여부를 반드시 검사해야 한다. (무한루프 방지)

#### 장단점과 쓰임
* 장점 : 최단 경로를 항상 찾을 수 있으며, 일반적인 경우 DFS보다 빠르게 동작
* 단점 : 구현이 복잡, 모든 경우를 탐색하는 경우 큐에 모든 노드를 저장해하므로 DFS에 비해 메모리 많이 사용
* 활용 : 최단 경로 탐색, 가까운 곳부터 탐색이 필요한 경우

#### 동작 방식
1. 탐색 시작 노드를 "큐"에 삽입, 방문 처리 (들어온 순서대로 처리해야하기 때문에 큐를 사용한다)
2. 큐에서 노드를 꺼내 인접 노드 중 방문하지 않은 노드를 모듀 큐에 삽입, 방문 처리
3. 2의 과정을 더 이상 수행할 수 없을 때(=모든 노드를 방문)까지 반복

<br>

### DFS
기준이 되는 정점에 연결된 정점을 깊이 기준 탐색 <br>
특정 경로의 끝까지 최대한 깊이 들어가서 노드를 방문하고 다시 되돌아가는 방식이다. <br>
구현에 재귀 알고리즘과 스택 자료구조가 사용된다. (가장 나중에 들어온, 즉 가장 먼 노드를 먼저 탐색하므로)<br>
어떤 노드를 방문했었는지 여부를 반드시 검사해야 한다. (무한루프 방지)

#### 장단점과 쓰임
* 장점 : 재귀를 통해 쉽게 구현이 가능하며, 목표 노드가 깊은 곳에 있을 떄 유리
* 단점 : 최단 경로를 보장하지 않고, 깊이가 깊을수록 시간 복잡도가 증가
* 활용 : 모든 경로를 탐색해야 하는 백트랙킹, 퍼즐 문제 / 사이클 탐지, 위상 정렬, 강결합 컴포넌트 찾기

#### 동작 방식
1. 탐색 시작 노드를 "스택"에 삽입, 방문 처리 (가장 나중에 들어온, 즉 가장 먼 노드를 먼저 탐색하므로)
2. 스택의 최상단 노드에 방문하지 않은 인접 노드가 
   3. 있다 -> 스택에 인접 노드를 넣고 방문 처리
   4. 없다 -> 스택에서 최상단 노드를 꺼낸다
3. 2의 과정을 더 이상 수행할 수 없을 때(=모든 노드를 방문)까지 반복