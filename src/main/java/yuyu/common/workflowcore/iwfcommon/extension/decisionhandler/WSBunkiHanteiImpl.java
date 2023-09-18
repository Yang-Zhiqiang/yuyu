package yuyu.common.workflowcore.iwfcommon.extension.decisionhandler;

import static yuyu.common.workflowcore.core.iwfinfr.util.IwfMessageCd.*;

import javax.transaction.Transactional;

import jp.co.slcs.swak.core.logger.LoggerFactory;
import net.arnx.jsonic.JSON;

import org.jbpm.graph.exe.ExecutionContext;
import org.slf4j.Logger;

import yuyu.common.workflowcore.client.rule.TransitionRuleEngine;
import yuyu.common.workflowcore.client.rule.holder.KnowledgeBaseHolder;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfBase64Urls;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfEditMessageUtil;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfMessageCd;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfValidateUtil;
import yuyu.common.workflowcore.core.iwfinfr.util.item.EIwfItemInfo;
import yuyu.def.classification.C_ResultCdKbn;

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
public class WSBunkiHanteiImpl implements WSBunkiHantei {

    private final static Logger LOGGER = LoggerFactory.getLogger(WSBunkiHanteiImpl.class);

    @Override
    @Transactional
    public WSBunkiHanteiResponse executeBizMain(WSBunkiHanteiRequest request) throws Exception {

        LOGGER.debug("│主処理を開始します。");

        WSBunkiHanteiResponse response = new WSBunkiHanteiResponse();

        try {
            response = validate(request);

            if (C_ResultCdKbn.NG.toString().equals(response.getKekkastatus())) {
                return response;
            }

            LOGGER.debug("コンディションBeanを取得します。リクエストID : " + request.getRequestid());

            Object conditionBean = JSON.decode(IwfBase64Urls.decodeToString(request.getRuleCondition()),
                    Class.forName(IwfBase64Urls.decodeToString(request.getRuleConditionName())));
            if (conditionBean == null) {
                IwfEditMessageUtil.setMsgResultNG(response, IWF1004);
                return response;
            }
            LOGGER.debug("コンディションBeanを取得しました。");
            LOGGER.debug("ルール名：" + request.getRule());

            TransitionRuleEngine<WSBunkiHanteiResponse> transitionRuleEngine = TransitionRuleEngine.newInstance(request.getRule());
            LOGGER.debug("遷移決定ルールエンジンを作成しました。");

            transitionRuleEngine.apply(conditionBean, response);
            LOGGER.debug("ルールエンジン実行完了しました。");
            LOGGER.debug("判定結果：" + response.getHanteikekka());

            if (response.getHanteikekka() == null) {
                IwfEditMessageUtil.setMsgResultNG(response, IWF1006);
                return response;
            }

            IwfEditMessageUtil.setMsgResultOK(response, "分岐判定");
        } catch (Exception e) {
            LOGGER.error("想定外のエラーが発生しました。", e);
            IwfEditMessageUtil.setMsgResultNG(response, IwfMessageCd.IWF0001, "分岐判定");
        }

        return response;
    }

    public WSBunkiHanteiResponse validate(WSBunkiHanteiRequest request) throws Exception {

        LOGGER.debug("│バリデーションチェック処理を行います。");

        WSBunkiHanteiResponse response = new WSBunkiHanteiResponse();

        if (IwfValidateUtil.isErrorRequire(EIwfItemInfo.S_REQUESTID, request.getRequestid(), response)) {
            IwfEditMessageUtil.setMsgResultNG(response, IwfMessageCd.IWF0002, "リクエストID");
            return response;
        }

        if (IwfValidateUtil.isErrorRequire(EIwfItemInfo.S_REQUESTID, request.getRule(), response)) {
            IwfEditMessageUtil.setMsgResultNG(response, IwfMessageCd.IWF0002, "ルール名");
            return response;
        }

        KnowledgeBaseHolder holder = KnowledgeBaseHolder.getInstance();
        if (!holder.exists(request.getRule())) {
            IwfEditMessageUtil.setMsgResultNG(response, IwfMessageCd.IWF0002, "ルール");
            return response;
        }
        return response;
    }
}
