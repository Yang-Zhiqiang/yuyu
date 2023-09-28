package yuyu.common.biz.workflow;

import jp.co.slcs.swak.core.logger.LoggerFactory;

import org.slf4j.Logger;

import yuyu.def.workflowcore.configration.IwfCoreConfig;
//import jp.co.slcs.swak.core.logger.LoggerFactory;

/**
 * ルール関連の設定を取得します。
 */
public class IwfRuleConfig {

    private static final Logger logger = LoggerFactory.getLogger(IwfRuleConfig.class);

    public String getRuleFileDirectory() {
        try {
            //            WebServiceConfig oCtrFile = GkUtil.getAppConfig().getGkSubSystemCtl(GkSubSystemCtlGshien.sKEY).getGkControlFile();
            return IwfCoreConfig.getInstance().getRuleFileDir();
        } catch (Exception e) {
            logger.warn("ルールファイルのディレクトリパス取得中に例外が発生しました。", e);
            return null;
        }
    }

    public String getRuleLogDirectory() {
        try {
            //            GkControlFile oCtrFile = GkUtil.getAppConfig().getGkSubSystemCtl(GkSubSystemCtlGshien.sKEY).getGkControlFile();
            return IwfCoreConfig.getInstance().getRuleLogDir();
        } catch (Exception e) {
            logger.warn("ルール実行結果ログのディレクトリパス取得中に例外が発生しました。", e);
            return null;
        }
    }
}
