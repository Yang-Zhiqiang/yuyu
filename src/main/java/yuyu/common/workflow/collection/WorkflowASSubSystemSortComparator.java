package yuyu.common.workflow.collection;

import java.util.Comparator;

import yuyu.def.db.entity.AS_SubSystem;

/**
 * イメージワークフローサブシステムソート処理です。<br/>
 * WorkflowSubsystemのソートクラスです。
 * イメージワークフローで表示するサブシステムの表示順に合わせてソートを実施します。
 */
public class WorkflowASSubSystemSortComparator implements Comparator<AS_SubSystem> {


    @Override
    public int compare(AS_SubSystem subsystem1, AS_SubSystem subsystem2) {

        String subSystemId1 = subsystem1.getSubSystemId();
        String subSystemId2 = subsystem2.getSubSystemId();
        int sortId1 = 0;
        int sortId2 = 0;

        if(WorkflowSubsystemConstants.E_SubSystem.SINKEIYAKU.getSubSystemId().equals(subSystemId1)) {
            sortId1 = WorkflowSubsystemConstants.E_SubSystem.SINKEIYAKU.getSortId();
        }else if(WorkflowSubsystemConstants.E_SubSystem.KEIYAKUHOZEN.getSubSystemId().equals(subSystemId1)){
            sortId1 = WorkflowSubsystemConstants.E_SubSystem.KEIYAKUHOZEN.getSortId();
        }else if(WorkflowSubsystemConstants.E_SubSystem.HOKENKYUHUSIHARAI.getSubSystemId().equals(subSystemId1)){
            sortId1 = WorkflowSubsystemConstants.E_SubSystem.HOKENKYUHUSIHARAI.getSortId();
        }else if(WorkflowSubsystemConstants.E_SubSystem.NENKINSIHARAI.getSubSystemId().equals(subSystemId1)){
            sortId1 = WorkflowSubsystemConstants.E_SubSystem.NENKINSIHARAI.getSortId();
        }

        if(WorkflowSubsystemConstants.E_SubSystem.SINKEIYAKU.getSubSystemId().equals(subSystemId2)) {
            sortId2 = WorkflowSubsystemConstants.E_SubSystem.SINKEIYAKU.getSortId();
        }else if(WorkflowSubsystemConstants.E_SubSystem.KEIYAKUHOZEN.getSubSystemId().equals(subSystemId2)){
            sortId2 = WorkflowSubsystemConstants.E_SubSystem.KEIYAKUHOZEN.getSortId();
        }else if(WorkflowSubsystemConstants.E_SubSystem.HOKENKYUHUSIHARAI.getSubSystemId().equals(subSystemId2)){
            sortId2 = WorkflowSubsystemConstants.E_SubSystem.HOKENKYUHUSIHARAI.getSortId();
        }else if(WorkflowSubsystemConstants.E_SubSystem.NENKINSIHARAI.getSubSystemId().equals(subSystemId2)){
            sortId2 = WorkflowSubsystemConstants.E_SubSystem.NENKINSIHARAI.getSortId();
        }

        return sortId1-sortId2;
    }


}
