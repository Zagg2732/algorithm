// https://programmers.co.kr/learn/courses/30/lessons/42860
/*
컴파일 옵션
조이스틱
문제 설명
조이스틱으로 알파벳 이름을 완성하세요. 맨 처음엔 A로만 이루어져 있습니다.
ex) 완성해야 하는 이름이 세 글자면 AAA, 네 글자면 AAAA

조이스틱을 각 방향으로 움직이면 아래와 같습니다.

▲ - 다음 알파벳
▼ - 이전 알파벳 (A에서 아래쪽으로 이동하면 Z로)
◀ - 커서를 왼쪽으로 이동 (첫 번째 위치에서 왼쪽으로 이동하면 마지막 문자에 커서)
▶ - 커서를 오른쪽으로 이동
예를 들어 아래의 방법으로 "JAZ"를 만들 수 있습니다.

- 첫 번째 위치에서 조이스틱을 위로 9번 조작하여 J를 완성합니다.
- 조이스틱을 왼쪽으로 1번 조작하여 커서를 마지막 문자 위치로 이동시킵니다.
- 마지막 위치에서 조이스틱을 아래로 1번 조작하여 Z를 완성합니다.
따라서 11번 이동시켜 "JAZ"를 만들 수 있고, 이때가 최소 이동입니다.
만들고자 하는 이름 name이 매개변수로 주어질 때, 이름에 대해 조이스틱 조작 횟수의 최솟값을 return 하도록 solution 함수를 만드세요.

제한 사항
name은 알파벳 대문자로만 이루어져 있습니다.
name의 길이는 1 이상 20 이하입니다.
입출력 예
name	    return
"JEROEN"	56
"JAN"	    23
*/
//ASCII 코드는 65가 A, 90이 Z임

import java.util.ArrayList;
import java.util.List;



class Solution02 {
    public boolean checkIfLeftAllA(int[] list, int index) { //남아있는놈들이 모두 A인지 확인하는함수
        for (int i = index; i < list.length; i++) {
            if(list[i] == 65) {
                continue;
            } else {
                return false; //만약 남은것중에 A가아니다. 그럼 false
            }
        }
        return true; //A밖에안남았다 그럼 true
    }

    public int solution(String name) {
        int answer = 0; //정답
        int baseNum = 65; //A

        String[] toAscii; //ASCII코드로 변환할 알파벳들이 들어갈 리스트
        toAscii = name.split(""); // ""기준으로 split하면 한 글자씩 들어간다

        int[] ascii = new int[name.length()];
        //모든 단어들이 for문으로 들어가서 ASCII코드에 맞는 숫자로 변환된다
        for (int i = 0 ; i < toAscii.length ; i++) {
            ascii[i] = toAscii[i].charAt(0); //변환코드
        }

        for (int i = 0 ; i < ascii.length; i++) {
            if(checkIfLeftAllA(ascii, i)) { //남은게 모두 A라면?
                System.out.println("test. 남는게 모두 A입니다.");
                return answer;
            }
            if(ascii[i] - baseNum == 0) { //현재있는곳이 A라면
                answer++; //다음으로 넘어감
                continue;
            } else if (ascii[i] > 78) { //알파벳 절반을 넘어가면 뒤로가야함
                answer += 91 - ascii[i];
                answer++;
            } else {
                answer += ascii[i] - baseNum;
                answer++;
            }
        }
        answer--;
        return answer;
    }
}
public class Greedy02 {
    public static void main(String[] args) {
        Solution02 solution02 = new Solution02();
        System.out.println(solution02.solution("JEROEN"));
        System.out.println(solution02.solution("JAN"));

        System.out.println(solution02.solution("JAZ"));
    }
}
