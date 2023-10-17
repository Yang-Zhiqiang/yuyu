package yuyu.app.hozen.khhubikanri.khhubinaiyoukensaku;

import java.io.Serializable;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.MultiByteStringsReturnable;
import jp.co.slcs.swak.validation.constraints.ValidTextArea;
import yuyu.def.classification.C_HassinsakiKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.infr.validation.constraints.InvalidCharacter;

/**
 * 契約保全不備内容検索 - fubinaiyouList の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenFubinaiyouListDataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String dispkhhubinaiyou;

    public String getDispkhhubinaiyou() {
        return dispkhhubinaiyou;
    }

    public void setDispkhhubinaiyou(String pDispkhhubinaiyou) {
        dispkhhubinaiyou = pDispkhhubinaiyou;
    }


    private C_HassinsakiKbn disphassinsakikbn;

    public C_HassinsakiKbn getDisphassinsakikbn() {
        return disphassinsakikbn;
    }

    public void setDisphassinsakikbn(C_HassinsakiKbn pDisphassinsakikbn) {
        disphassinsakikbn = pDisphassinsakikbn;
    }


    private C_UmuKbn dispgenponhnkykumu;

    public C_UmuKbn getDispgenponhnkykumu() {
        return dispgenponhnkykumu;
    }

    public void setDispgenponhnkykumu(C_UmuKbn pDispgenponhnkykumu) {
        dispgenponhnkykumu = pDispgenponhnkykumu;
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


    private String sentakulink;

    public String getSentakulink() {
        return sentakulink;
    }

    public void setSentakulink(String pSentakulink) {
        sentakulink = pSentakulink;
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


    private Boolean dispgenponhnkykumuchkbox;

    public Boolean getDispgenponhnkykumuchkbox() {
        return dispgenponhnkykumuchkbox == null ? Boolean.FALSE : dispgenponhnkykumuchkbox;
    }

    public void setDispgenponhnkykumuchkbox(Boolean pDispgenponhnkykumuchkbox) {
        dispgenponhnkykumuchkbox = pDispgenponhnkykumuchkbox == null ? Boolean.FALSE : pDispgenponhnkykumuchkbox;
    }

}
