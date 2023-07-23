package yuyu.infr.accesslog;

import java.util.Map;

import yuyu.def.db.entity.AT_AccessLog;

/**
 * #133966 アクセスログ拡張対応②（Ｓ社対応）
 * 端末タイプ、物理組織コード、論理組織コード、端末状態表示の設定をするクラスです。
 */
public class AccessLogExtensionDBAppender extends AccessLogDBAppender{
    @Override
    protected void setExtensions(AT_AccessLog accessLog, Map<String, String> mdc) {
        accessLog.setTanmatuType          (mdc.get(YuyuAccessLogExtensionProp.TanmatuType          .getValue()));
        accessLog.setButsuriSosikiCd      (mdc.get(YuyuAccessLogExtensionProp.ButsuriSosikiCd      .getValue()));
        accessLog.setRonriSosikiCd        (mdc.get(YuyuAccessLogExtensionProp.RonriSosikiCd        .getValue()));
        accessLog.setTanmatuJyoutaiHyouji (mdc.get(YuyuAccessLogExtensionProp.TanmatuJyoutaiHyouji .getValue()));
    }

}
