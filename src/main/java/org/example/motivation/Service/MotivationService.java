package org.example.motivation.Service;

import org.example.Container;
import org.example.motivation.entity.Motivation;

import java.util.ArrayList;
import java.util.List;

public class MotivationService {

    private List<Motivation> motivations;
    private int lastNo;

    // 생성자
    // 모티베이션 배열 생성, 마지막 인덱스를 기억하는 변수 초기화
    // MotivationController 클래스에서만 인스턴스를 한 번 생성했기 때문에 생성자는 1회 실행됨
    public MotivationService() {
        motivations = new ArrayList<Motivation>();
        lastNo = 1;
    }

    public int add(String source, String body) {
        // motivation 인스턴스 생성, 배열에 저장
        // 생성한 모티베이션 인스턴스의 번호 반환
        // add 메서드가 호출될 때마다 lastNo 1 증가
        int no = lastNo++;
        Motivation motivation = new Motivation(no, source, body);
        motivations.add(motivation);

        return no;
    }

    public void list() {
        System.out.println("====== motivation 목록 =======");
        System.out.println(" No.  |  Source  |  Motivation");

        // 생성된 모티베이션 인스턴스가 없을 때(모티베이션 배열이 비었을 때) 실행
        if (motivations.isEmpty()) {
            System.out.println("---------- nothing -----------");
            return;
        }
        System.out.println("------------------------------");

        // 모티베이션 배열을 거꾸로 순회하며 출력
        for (int i = motivations.size() - 1; i >= 0; i--) {
            Motivation motivation = motivations.get(i);

            // 출력할 source와 moitvation의 길이 확인
            boolean overSource = (motivation.getSource().length() > 6);
            boolean overMotivation = (motivation.getMotivation().length() > 10);

            // source와 motivation의 길이에 따른 출력 형식
            if (overSource && overMotivation) {
                System.out.printf("  %d.  |  %s  |  %s \n", motivation.getNo(),
                        motivation.getSource().substring(0, 4) + "..", motivation.getMotivation().substring(0, 8) + "..");

            } else if (overSource) {
                System.out.printf("  %d.  |  %s  |  %-10s \n", motivation.getNo(),
                        motivation.getSource().substring(0, 4) + "..", motivation.getMotivation());

            } else if (overMotivation) {
                System.out.printf("  %d.  |  %-6s  |  %s \n", motivation.getNo(),
                        motivation.getSource(), motivation.getMotivation().substring(0, 8) + "..");

            } else {
                System.out.printf("  %d.  |  %-6s  |  %-10s \n", motivation.getNo(),
                        motivation.getSource(), motivation.getMotivation());
            }
        }
        System.out.println("------------------------------");
    }

    public void edit(int editNo, String source, String motivation) {
        // 전달받은 매개변수 editNo로 getMotivation 메서드 호출
        // source, motivation 매개변수 setter에 전달
        Motivation editMotivation = getMotivation(editNo);
        editMotivation.setSource(source);
        editMotivation.setMotivation(motivation);

        System.out.printf("%d번 motivation이 수정되었습니다.\n", editNo);
        System.out.println("------------------------------");
    }

    public void detail(int detailNo) {
        // 전달받은 매개변수 detailNo로 getMotivation 메서드 호출, 상세 출력
        Motivation detailMotivation = getMotivation(detailNo);

        System.out.printf("==== %d번 motivation 상세 =====\n", detailNo);
        System.out.printf("No. : %d\n", detailMotivation.getNo());
        System.out.printf("Source : %s\n", detailMotivation.getSource());
        System.out.printf("Motivation : %s\n", detailMotivation.getMotivation());
    }

    public void delete(int deleteNo) {
        // 전달받은 매개변수 deleteNo로 getMotivation 메서드 호출, 삭제
        Motivation deketeMotivation = getMotivation(deleteNo);
        motivations.remove(deketeMotivation);
    }

    // 입력받은 번호의 모티베이션이 존재하는 지 여부를 확인하는 메서드
    public boolean motivationIsExits(int editNo) {
        for(Motivation motivation : motivations) {
            if (motivation.getNo() == editNo) {
                return true;
            }
        }
        return false;
    }

    // 번호를 매개변수로 하여 일치하는 모티베이션 반환하는 메서드
    public Motivation getMotivation(int editNo) {
        for (Motivation motivation : motivations) {
            if (motivation.getNo() == editNo) {
                return motivation;
            }
        }
        return null;
    }
}
