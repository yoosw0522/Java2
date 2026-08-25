package ai0825;

import java.util.Random;

public class LABRandomWiseSaying {
    public static void main(String[] args) {
        String[] wiseSay = {
                "삶이 있는 한 희망은 있다. - 키케로",
                "어제와 똑같이 살면서 다른 미래를 기대하는 것은 정신병 초기 증세다. - 알베르트 아인슈타인",
                "가장 큰 위험은 위험을 감수하지 않는 것이다. - 마크 저커버그",
                "당신이 할 수 있다고 믿든 할 수 없다고 믿든, 당신의 믿음대로 될 것이다. - 헨리 포드",
                "오랫동안 꿈을 그리는 사람은 마침내 그 꿈을 닮아간다. - 앙드레 말로",
                "성공은 최종적인 것이 아니며, 실패는 치명적인 것이 아니다. 중요한 것은 지속하는 용기다. - 윈스턴 처칠",
                "행복은 이미 만들어져 있는 것이 아니다. 그것은 당신의 행동에서 비롯된다. - 달라이 라마",
                "한 번도 실패하지 않았다는 것은 새로운 일을 전혀 시도하지 않았다는 거다. - 알베르트 아인슈타인",
                "내일의 실현을 가로막는 유일한 장애물은 오늘의 의심일 것이다. - 프랭클린 D. 루스벨트",
                "인생은 거울과 같으니, 마주 보고 웃을 때 가장 좋은 결과를 얻는다. - 평화의 순례자"
        };

        Random random = new Random();
        int randomIndex = random.nextInt(wiseSay.length);

        System.out.println("오늘의 명언: " + wiseSay[randomIndex]);
    }
}