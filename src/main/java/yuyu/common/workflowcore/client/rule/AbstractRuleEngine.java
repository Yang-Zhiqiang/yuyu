package yuyu.common.workflowcore.client.rule;

import jp.co.slcs.swak.core.logger.LoggerFactory;

import org.drools.runtime.StatefulKnowledgeSession;
import org.slf4j.Logger;

import yuyu.common.workflowcore.client.rule.holder.KnowledgeBaseHolder;

/**
 * 抽象ルールエンジンクラスです。
 * <p>
 * ルールエンジンの適用の手順を抽象化したクラスです。
 * ルールエンジンを使用したい場合、当クラスの具象クラスを作成してください。
 */
abstract public class AbstractRuleEngine<I, O> implements IRuleApplier<I, O> {

    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractRuleEngine.class);

    public abstract String getRuleName();

    public abstract String getLogFilename() throws Exception;

    public abstract String getResultField();

    @Override
    public O apply(I inBean, O outBean) throws Exception {

        if(inBean == null){
            throw new NullPointerException("inBean");
        }
        if(outBean == null){
            throw new NullPointerException("outBean");
        }

        StatefulKnowledgeSession ksession = KnowledgeBaseHolder.getInstance().get(getRuleName()).newStatefulKnowledgeSession();

        ksession.setGlobal(getResultField(), outBean);

        ksession.insert(inBean);

        LOGGER.debug("ルールを実行します。");
        ksession.fireAllRules();

        return outBean;
    }

}
