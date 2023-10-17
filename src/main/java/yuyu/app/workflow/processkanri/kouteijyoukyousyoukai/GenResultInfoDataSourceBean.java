package yuyu.app.workflow.processkanri.kouteijyoukyousyoukai;

import java.io.Serializable;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import yuyu.def.classification.C_SyorikekkaKbn;

/**
 * 工程状況照会 - resultInfo の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenResultInfoDataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String syoriTime;

    public String getSyoriTime() {
        return syoriTime;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyoriTime(String pSyoriTime) {
        syoriTime = pSyoriTime;
    }


    private String dispTskkinousyousaiNm;

    public String getDispTskkinousyousaiNm() {
        return dispTskkinousyousaiNm;
    }

    public void setDispTskkinousyousaiNm(String pDispTskkinousyousaiNm) {
        dispTskkinousyousaiNm = pDispTskkinousyousaiNm;
    }


    private C_SyorikekkaKbn syorikekkakbn;

    public C_SyorikekkaKbn getSyorikekkakbn() {
        return syorikekkakbn;
    }

    public void setSyorikekkakbn(C_SyorikekkaKbn pSyorikekkakbn) {
        syorikekkakbn = pSyorikekkakbn;
    }


    private String disptantounm;

    public String getDisptantounm() {
        return disptantounm;
    }

    public void setDisptantounm(String pDisptantounm) {
        disptantounm = pDisptantounm;
    }


    private String dispRirekiMsg;

    public String getDispRirekiMsg() {
        return dispRirekiMsg;
    }

    public void setDispRirekiMsg(String pDispRirekiMsg) {
        dispRirekiMsg = pDispRirekiMsg;
    }

}
