package org.example.motivation.Service;

import org.example.Container;
import org.example.motivation.entity.Motivation;

import java.util.ArrayList;
import java.util.List;

public class MotivationService {

    private List<Motivation> motivations;
    private int lastNo;

    public MotivationService() {
        motivations = new ArrayList<Motivation>();
        lastNo = 1;
    }

    public int getMotivationsSize() {
        return motivations.size();
    }

    public int add(String source, String body) {
        int no = lastNo++;
        Motivation motivation = new Motivation(no, source, body);
        motivations.add(motivation);

        return no;
    }

    public void list() {
        if (getMotivationsSize() == 0) {
            System.out.println("---------- nothing -----------");
            return;
        }

        System.out.println("------------------------------");

        for (int i = motivations.size() - 1; i >= 0; i--) {
            Motivation motivation = motivations.get(i);

            boolean overSource = (motivation.getSource().length() > 6);
            boolean overMotivation = (motivation.getMotivation().length() > 10);

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

        Motivation editMotivation = getMotivation(editNo);
        editMotivation.setSource(source);
        editMotivation.setMotivation(motivation);

        System.out.printf("%d번 motivation이 수정되었습니다.\n", editNo);
        System.out.println("------------------------------");
    }

    public void detail(int detailNo) {
        Motivation motivation = getMotivation(detailNo);

        System.out.printf("==== %d번 motivation 상세 =====\n", detailNo);
        System.out.printf("No. : %d\n", motivation.getNo());
        System.out.printf("Source : %s\n", motivation.getSource());
        System.out.printf("Motivation : %s\n", motivation.getMotivation());
    }

    public void delete(int deleteNo) {
        Motivation motivation = getMotivation(deleteNo);
        motivations.remove(motivation);
    }

    public boolean motivationIsExits(int editNo) {

        for(Motivation motivation : motivations) {
            if (motivation.getNo() == editNo) {
                return true;
            }
        }
        return false;
    }
    // 번호를 매개변수로 하여 일치하는 모티베이션 반환

    public Motivation getMotivation(int editNo) {
        for (Motivation motivation : motivations) {
            if (motivation.getNo() == editNo) {
                return motivation;
            }
        }
        return null;
    }
}
