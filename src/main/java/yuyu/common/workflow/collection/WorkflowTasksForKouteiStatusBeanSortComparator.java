package yuyu.common.workflow.collection;

import java.util.Comparator;

import yuyu.common.workflow.workflowutility.TaskSummaryForKouteiStatusBean;

/**
 * TaskSummaryForKouteiStatusBeanをソートするためのコンパレータです。<br />
 * ソート条件は｛工程完了年月日（降順）、事務開始年月日（降順）、工程開始年月日（降順）、
 * フロー種類（メインフロー・サブフロー）、最終更新時間（降順）｝です。
 */
public class WorkflowTasksForKouteiStatusBeanSortComparator implements Comparator<TaskSummaryForKouteiStatusBean> {

    @Override
    public int compare(TaskSummaryForKouteiStatusBean o1, TaskSummaryForKouteiStatusBean o2) {

        String ktEnd1 = o1.getKouteiKanryouYmd() == null ? "99999999" : o1.getKouteiKanryouYmd();
        String ktEnd2 = o2.getKouteiKanryouYmd() == null ? "99999999" : o2.getKouteiKanryouYmd();

        String jimSt1 = o1.getJimuStartYmd() == null ? "99999999999999999" : o1.getJimuStartYmd();
        String jimSt2 = o2.getJimuStartYmd() == null ? "99999999999999999" : o2.getJimuStartYmd();

        String ktSt1 = o1.getKouteiKaisiYmd() == null ? "99999999" : o1.getKouteiKaisiYmd();
        String ktSt2 = o2.getKouteiKaisiYmd() == null ? "99999999" : o2.getKouteiKaisiYmd();

        String ktKrId1 = o1.getSyuKouteiKnrId() == null ? "" : o1.getSyuKouteiKnrId();
        String ktKrId2 = o1.getKouteiKnrId() == null ? "" : o1.getKouteiKnrId();
        String ktKrId3 = o2.getSyuKouteiKnrId() == null ? "" : o2.getSyuKouteiKnrId();
        String ktKrId4 = o2.getKouteiKnrId() == null ? "" : o2.getKouteiKnrId();

        String lastUpd1 = o1.getLastUpdateTime() == null ? "99999999999999999" : o1.getLastUpdateTime();
        String lastUpd2 = o2.getLastUpdateTime() == null ? "99999999999999999" : o2.getLastUpdateTime();

        if (!ktEnd1.equals(ktEnd2)) {

            return ktEnd2.compareTo(ktEnd1);
        }
        else if (!jimSt1.equals(jimSt2)) {

            return jimSt2.compareTo(jimSt1);
        }
        else if (!ktSt1.equals(ktSt2)) {

            return ktSt2.compareTo(ktSt1);
        }
        else {

            if (ktKrId1.equals(ktKrId2)) {
                return -1;
            }
            else if (ktKrId3.equals(ktKrId4)) {
                return 1;
            }
            else{
                return lastUpd2.compareTo(lastUpd1);
            }
        }
    }
}
