package yuyu.app.workflow.processkanri.kouteitorikesi;

import yuyu.common.workflow.collection.WorkflowSubsystemConstants;
import yuyu.infr.auth.SubSystem;

import com.google.common.base.Predicate;


/**
 * イメージワークフロー表示可能サブシステム抽出処理です。<br/ >
 * 工程取消SubSystemのフィルタークラスです。
 * 取得したSubSytemクラスの内容から工程取消だけで表示するサブシステムだけ抽出します。
 *
 */
public class KouteiTorikesiSubSystemFilter implements Predicate<SubSystem> {

    public KouteiTorikesiSubSystemFilter(){

    }

    @Override
    public boolean apply(SubSystem subsystem) {
        if (WorkflowSubsystemConstants.E_SubSystem.KEIYAKUHOZEN.getSubSystemId().equals(subsystem.getSubSystemId())||
                WorkflowSubsystemConstants.E_SubSystem.HOKENKYUHUSIHARAI.getSubSystemId().equals(subsystem.getSubSystemId())||
                WorkflowSubsystemConstants.E_SubSystem.NENKINSIHARAI.getSubSystemId().equals(subsystem.getSubSystemId())
                ) {
            return true;
        }
        return false;
    }
}
