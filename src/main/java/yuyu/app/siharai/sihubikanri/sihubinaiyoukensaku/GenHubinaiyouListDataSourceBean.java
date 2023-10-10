package yuyu.app.siharai.sihubikanri.sihubinaiyoukensaku;

import java.io.Serializable;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.MultiByteStringsReturnable;
import jp.co.slcs.swak.validation.constraints.ValidTextArea;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.infr.validation.constraints.InvalidCharacter;

/**
 * 保険金給付金不備内容検索 - hubinaiyouList の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenHubinaiyouListDataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String disphubinaiyou;

    public String getDisphubinaiyou() {
        return disphubinaiyou;
    }

    public void setDisphubinaiyou(String pDisphubinaiyou) {
        disphubinaiyou = pDisphubinaiyou;
    }


    @ValidTextArea(length=30, rows=5)
    @MultiByteStringsReturnable
    @InvalidCharacter
    private String disphubinaiyoumsg;

    public String getDisphubinaiyoumsg() {
        return disphubinaiyoumsg;
    }

    @DataConvert("toMultiByte")
    public void setDisphubinaiyoumsg(String pDisphubinaiyoumsg) {
        disphubinaiyoumsg = pDisphubinaiyoumsg;
    }


    private C_SyoruiCdKbn syoruiCd;

    public C_SyoruiCdKbn getSyoruiCd() {
        return syoruiCd;
    }

    public void setSyoruiCd(C_SyoruiCdKbn pSyoruiCd) {
        syoruiCd = pSyoruiCd;
    }


    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    private String syoruinm;

    public String getSyoruinm() {
        return syoruinm;
    }

    @Trim("both")
    public void setSyoruinm(String pSyoruinm) {
        syoruinm = pSyoruinm;
    }


    private String hubinaiyoucd;

    public String getHubinaiyoucd() {
        return hubinaiyoucd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHubinaiyoucd(String pHubinaiyoucd) {
        hubinaiyoucd = pHubinaiyoucd;
    }


    private String sentakulink;

    public String getSentakulink() {
        return sentakulink;
    }

    public void setSentakulink(String pSentakulink) {
        sentakulink = pSentakulink;
    }

}
