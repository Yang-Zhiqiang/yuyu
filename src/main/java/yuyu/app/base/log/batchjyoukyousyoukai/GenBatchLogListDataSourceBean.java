package yuyu.app.base.log.batchjyoukyousyoukai;

import java.io.Serializable;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import yuyu.def.classification.C_LogLevelKbn;

/**
 * バッチ状況照会 - batchLogList の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenBatchLogListDataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String logOutputTime;

    public String getLogOutputTime() {
        return logOutputTime;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setLogOutputTime(String pLogOutputTime) {
        logOutputTime = pLogOutputTime;
    }


    private C_LogLevelKbn logLevelKbn;

    public C_LogLevelKbn getLogLevelKbn() {
        return logLevelKbn;
    }

    public void setLogLevelKbn(C_LogLevelKbn pLogLevelKbn) {
        logLevelKbn = pLogLevelKbn;
    }


    private String logNaiyou;

    public String getLogNaiyou() {
        return logNaiyou;
    }

    @Trim("both")
    public void setLogNaiyou(String pLogNaiyou) {
        logNaiyou = pLogNaiyou;
    }

}
