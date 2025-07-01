def solution(answers):
    
    #1번 수포자가 찍는 방식의 패턴 -> 12345 반복 (5)
    #2번 수포자가 찍는 방식의 패턴 -> 2123425 반복 (8)
    #3번 수포자가 찍는 방식의 패턴 -> 3311224455 반복 (10)
    
    # 가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아라 => 1번인지 2번인지 3번인지를 리턴하라고.
    # 제한조건 -> 가장 높은 점수를 받은 사람이 여럿일 경우 리턴값을 오름차순
    
    '''
    이런 문제의 경우 나머지연산자를 쓰는 게 편하다.
    동점자인 경우 오름차순으로 리턴하는 것도 코드로 구현이 되어야할 것.
    '''
    
#   우선 수포자들의 패턴을 저장    
    patterns = [
        [1,2,3,4,5],
        [2,1,2,3,2,4,2,5],
        [3,3,1,1,2,2,4,4,5,5]
    ]
    
    scores = [0]*3 
    #[0,0,0]으로 초기화
    
    #enumerate라고 하면 열거형이라고, 인덱스랑 같이리턴?? i랑 answer가 같이 리턴된다
    for i, answer in enumerate(answers):
        for j, pattern in enumerate(patterns):
            if answer  == pattern[i % len(pattern)]: #잘생각해보기. 패턴의 길이를 구하고 ,,, 
                # 여기 [i%len(pattern)] 이거 자주 쓰니까 기억해두면 도움이 된다
                scores[j] += 1
                
    max_score = max(scores)
    
#     근데 우리가 max_score를 출력하는 게 아니라 수포자의 번호를 출력하는 것. => 번호 출력 전에, 가장 높은 사람이 여러 명인지에 따라 정렬을 해야함.
    
    highest_scores = []
    for i, score in enumerate(scores): #이렇게 하면 인덱스번호와 각각의 스코어에 대한 게 읽어지겠네요?
        if score == max_score: #최대 점수를 받았다면
            highest_scores.append(i+1)
        
    return highest_scores



'''
시간복잡도를 보자. n -> answer의 길이
if answer==pattern[i%len(pattern)] 이부분은 O(n)이다.
if score==max_score은 가장 큰 scores를 순회하면서, 연산횟수가 항상 정해져있으니까 O(1)

그래서 시간복잡도가 O(n)이라고 볼 수 있는 알고리즘이다.

이렇게 시간복잡도도 같이 보면서. 문제를 풀어라.
'''