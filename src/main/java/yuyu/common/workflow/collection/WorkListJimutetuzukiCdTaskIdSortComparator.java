package yuyu.common.workflow.collection;

import java.util.Comparator;

import yuyu.common.workflow.workflowutility.ExecutableTaskInfoBean;

/**
 * 工程ワークリスト 機能の事務手続コード・タスクIDソート用クラスです。
 * 工程ワークリストで表示する事務手続コード・タスクIDの表示順に合わせてソートを実施します。
 */
public class WorkListJimutetuzukiCdTaskIdSortComparator implements Comparator<ExecutableTaskInfoBean> {


    @Override
    public int compare(ExecutableTaskInfoBean executableTaskInfo1, ExecutableTaskInfoBean executableTaskInfo2) {

        Integer jimutetuzukiDispOrder1 = executableTaskInfo1.getJimutetuzukiDispOrder();
        Integer jimutetuzukiDispOrder2 = executableTaskInfo2.getJimutetuzukiDispOrder();

        Integer tskDispOrder1 = executableTaskInfo1.getTskDispOrder();
        Integer tskDispOrder2 = executableTaskInfo2.getTskDispOrder();

        if(!(jimutetuzukiDispOrder1.equals(jimutetuzukiDispOrder2))){
            return jimutetuzukiDispOrder1 - jimutetuzukiDispOrder2;
        } else {
            return tskDispOrder1 - tskDispOrder2;
        }
    }


}
