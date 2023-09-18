package yuyu.common.workflowcore.iwfcommon.extension.decisionhandler;


import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.logger.LoggerFactory;
import net.arnx.jsonic.JSON;

import org.jbpm.graph.exe.ExecutionContext;
import org.jbpm.graph.node.DecisionHandler;
import org.slf4j.Logger;

import yuyu.common.workflowcore.core.iwfinfr.util.enumerate.E_TokenVarKey;

import com.google.common.base.Objects;

/**
 * ディシジョンノードで使用するイベントハンドラーです。 <br />
 * ディシジョンノードのハンドラークラスとして、当イベントハンドラークラスを設定すると、<br />
 * 遷移先を当クラスの{@#decide(ExecutionContext)}の戻り値として指定できます。<br />
 * このクラスは、jbpm3に依存しています。BPMエンジンの変更に伴い、修正する必要があります。 <br />
 * <pre>
 * 工程遷移処理にルール判定が必要な場、当クラスをデザイナで指定してください。
 * 工程遷移処理の際、トークンが（当クラスが設定済みの）決定ノードに達した場合、
 * {@link #decide(ExecutionContext)}が実行されます。
 * {@link #decide(ExecutionContext)}は、Webサービスにより、
 * クライアント側に遷移ルールを問い合わせ、ルールに従った遷移先名を取得します。
 * </pre>
 */
public class IwfDecisionHandler implements DecisionHandler {

    private static final long serialVersionUID = 1L;

    private static final Logger LOGGER = LoggerFactory.getLogger(IwfDecisionHandler.class);

    @Override
    public String decide(ExecutionContext executionContext) throws Exception {


        try {
            LOGGER.debug("▼─ルール判定開始─────────────");
            String rule = executionContext.getProcessDefinition().getName() + "_" + executionContext.getNode().getName();
            String ruleServiceUrl = (String)executionContext.getVariable(E_TokenVarKey.RULE_SERVICE_URL.key);
            String ruleConditionName = (String)executionContext.getVariable(E_TokenVarKey.RULE_CONDITIONNAME.key);
            String ruleCondition = (String)executionContext.getVariable(E_TokenVarKey.RULE_CONDITION.key);
            LOGGER.debug(Objects.toStringHelper(this)
                    .add("ContextInstance", JSON.encode(executionContext.getContextInstance().getVariables()))
                    .toString());
            LOGGER.debug(Objects.toStringHelper(this)
                    .add("RuleServiceUrl", ruleServiceUrl)
                    .toString());

            String requestId = (String)executionContext.getVariable(E_TokenVarKey.REQUEST_ID.key);

            if(LOGGER.isDebugEnabled()){
                LOGGER.debug("│▼─ルール判定─[入力データ]─────");
                LOGGER.debug("││rule      : " + rule);
                LOGGER.debug("││requestId : " + requestId);
                LOGGER.debug("│▲─ルール判定─[入力データ]─────");
            }

            WSBunkiHanteiProxy proxy = SWAKInjector.getInstance(WSBunkiHanteiProxy.class);

            String transition = proxy.getTransition(rule, ruleConditionName, ruleCondition, requestId);
            LOGGER.debug("▲─ルール判定終了─────────────");
            return transition;

        } catch (Exception e) {
            LOGGER.debug("ルール判定で例外が発生しました。", e);
            LOGGER.debug(Objects.toStringHelper(this)
                    .add("ContextInstance", JSON.encode(executionContext.getContextInstance().getVariables()))
                    .toString());
            LOGGER.debug("▲─ルール判定終了(異常)──────────");
            throw new RuntimeException(e);
        }
    }

}
