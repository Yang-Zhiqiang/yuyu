package yuyu.common.workflowcore.inject;

import jp.co.slcs.swak.core.inject.AbstractSWAKModule;
import jp.co.slcs.swak.core.inject.ServiceInitializer;
import yuyu.common.workflowcore.client.rule.holder.KnowledgeBaseHolder;
import yuyu.def.base.configuration.YuyuBaseConfig;

/**
 * 分岐ルール読み取り用クラスです。<br />
 * web/batchの切り替え用にWorkflowcoreCommonModuleとは分離させています。<br />
 */
public class WorkflowcoreRuleModule extends AbstractSWAKModule implements ServiceInitializer {

    @Override
    protected void configure() {
    }

    @SuppressWarnings("deprecation")
    @Override
    public void initialize() {
        if (!YuyuBaseConfig.getInstance().isDebugMode()) {
            KnowledgeBaseHolder holder = KnowledgeBaseHolder.getInstance();
            holder.readAllKnowledgeBase();
        }
    }

}
