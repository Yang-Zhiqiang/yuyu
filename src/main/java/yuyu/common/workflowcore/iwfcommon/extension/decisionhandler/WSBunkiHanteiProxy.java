package yuyu.common.workflowcore.iwfcommon.extension.decisionhandler;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.logger.LoggerFactory;
import net.arnx.jsonic.JSONException;

import org.slf4j.Logger;

import yuyu.common.workflowcore.core.iwfinfr.util.IwfBase64Urls;
import yuyu.def.classification.C_ResultCdKbn;

/**
 * 分岐判定のWebサービスのプロキシクラスです。
 */
public class WSBunkiHanteiProxy {


    private static final Logger LOGGER = LoggerFactory.getLogger(WSBunkiHanteiProxy.class);

    private WSBunkiHantei bunkiHantei;

    public String getTransition(String rule, String ruleConditionName, String ruleCondition, String requestId) {

        try {
            WSBunkiHanteiRequest request = new WSBunkiHanteiRequest();

            request.setRequestid(requestId);
            request.setRule(rule);
            request.setRuleCondition(IwfBase64Urls.encodeFromString(ruleCondition));
            request.setRuleConditionName(IwfBase64Urls.encodeFromString(ruleConditionName));

            bunkiHantei = SWAKInjector.getInstance(WSBunkiHanteiImpl.class);
            WSBunkiHanteiResponse response = bunkiHantei.executeBizMain(request);

            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("│");
                LOGGER.debug("│▼─ルール判定─[レスポンス]─────");
                LOGGER.debug("││hanteikekka  : " + response.getHanteikekka());
                LOGGER.debug("││kekkastatus  : " + response.getKekkastatus());
                LOGGER.debug("││syousaimsgcd : " + response.getSyousaimsgcd());
                LOGGER.debug("││syousaimsg   : " + response.getSyousaimsg());
                LOGGER.debug("│▲─ルール判定─[レスポンス]─────");
            }

            if (!C_ResultCdKbn.OK.getValue().equals(response.getKekkastatus())) {
                LOGGER.debug("ルール判定に失敗したため、デフォルト遷移先に遷移します。");
                return "default";
            }
            return response.getHanteikekka();
        } catch (JSONException e) {
            LOGGER.debug("ルール判定でJSONエラーが発生しました。", e);
            throw new RuntimeException(e);
        } catch (Exception e) {
            LOGGER.debug("ルール判定で例外が発生しました。", e);
            throw new RuntimeException(e);
        }
    }
}
