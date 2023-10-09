package yuyu.app.direct.dssyoukai.dssousarirekisyoukai;

import java.io.Serializable;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import yuyu.def.classification.C_SousaRirekiJkKbn;
import yuyu.def.classification.C_TtdkKekkaKbn;
import yuyu.def.classification.C_TtdkKinouKbn;

/**
 * 操作履歴照会 - ●検索結果 の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenKensakukekkaDataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @ValidDate
    private BizDate ttdkstartymd;

    public BizDate getTtdkstartymd() {
        return ttdkstartymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTtdkstartymd(BizDate pTtdkstartymd) {
        ttdkstartymd = pTtdkstartymd;
    }


    private String ttdkstarttime;

    public String getTtdkstarttime() {
        return ttdkstarttime;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTtdkstarttime(String pTtdkstarttime) {
        ttdkstarttime = pTtdkstarttime;
    }


    @ValidDate
    private BizDate ttdkendymd;

    public BizDate getTtdkendymd() {
        return ttdkendymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTtdkendymd(BizDate pTtdkendymd) {
        ttdkendymd = pTtdkendymd;
    }


    private String ttdkendtime;

    public String getTtdkendtime() {
        return ttdkendtime;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTtdkendtime(String pTtdkendtime) {
        ttdkendtime = pTtdkendtime;
    }


    private String dispsyono;

    public String getDispsyono() {
        return dispsyono;
    }

    public void setDispsyono(String pDispsyono) {
        dispsyono = pDispsyono;
    }


    private C_TtdkKinouKbn ttdkkinoukbn;

    public C_TtdkKinouKbn getTtdkkinoukbn() {
        return ttdkkinoukbn;
    }

    public void setTtdkkinoukbn(C_TtdkKinouKbn pTtdkkinoukbn) {
        ttdkkinoukbn = pTtdkkinoukbn;
    }


    private C_SousaRirekiJkKbn dispsousarirekijkkbn;

    public C_SousaRirekiJkKbn getDispsousarirekijkkbn() {
        return dispsousarirekijkkbn;
    }

    public void setDispsousarirekijkkbn(C_SousaRirekiJkKbn pDispsousarirekijkkbn) {
        dispsousarirekijkkbn = pDispsousarirekijkkbn;
    }


    private C_TtdkKekkaKbn dispsousarirekikekkakbn;

    public C_TtdkKekkaKbn getDispsousarirekikekkakbn() {
        return dispsousarirekikekkakbn;
    }

    public void setDispsousarirekikekkakbn(C_TtdkKekkaKbn pDispsousarirekikekkakbn) {
        dispsousarirekikekkakbn = pDispsousarirekikekkakbn;
    }


    private String syousaiLink;

    public String getSyousaiLink() {
        return syousaiLink;
    }

    public void setSyousaiLink(String pSyousaiLink) {
        syousaiLink = pSyousaiLink;
    }

}
