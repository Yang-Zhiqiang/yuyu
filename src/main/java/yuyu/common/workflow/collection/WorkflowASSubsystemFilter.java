package yuyu.common.workflow.collection;

import yuyu.def.db.entity.AS_SubSystem;

import com.google.common.base.Predicate;

/**
 * イメージワークフロー表示可能サブシステム抽出処理です。<br/>
 * WorkflowSubsystemのフィルタークラスです。
 * 取得したSubSytemクラスの内容からイメージワークフローで表示するサブシステムだけ抽出します。
 */
public class WorkflowASSubsystemFilter implements Predicate<AS_SubSystem> {

    @Override
    public boolean apply(AS_SubSystem subsystem) {
        if (WorkflowSubsystemConstants.E_SubSystem.SINKEIYAKU.getSubSystemId().equals(subsystem.getSubSystemId())||
                WorkflowSubsystemConstants.E_SubSystem.KEIYAKUHOZEN.getSubSystemId().equals(subsystem.getSubSystemId())||
                WorkflowSubsystemConstants.E_SubSystem.HOKENKYUHUSIHARAI.getSubSystemId().equals(subsystem.getSubSystemId())||
                WorkflowSubsystemConstants.E_SubSystem.NENKINSIHARAI.getSubSystemId().equals(subsystem.getSubSystemId())
                ) {
            return true;
        }
        return false;
    }

}
