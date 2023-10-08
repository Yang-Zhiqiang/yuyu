package yuyu.app.hozen.khhubikanri.khhubitouroku;

import java.io.Serializable;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.validation.constraints.MultiByteStringsReturnable;
import jp.co.slcs.swak.validation.constraints.ValidTextArea;
import yuyu.def.classification.C_Delflag;
import yuyu.def.classification.C_HassinsakiKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.infr.validation.constraints.InvalidCharacter;

/**
 * 契約保全不備登録 - ●未発信不備一覧 の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenHubiList2DataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private BizDate disptrkymd;

    public BizDate getDisptrkymd() {
        return disptrkymd;
    }

    public void setDisptrkymd(BizDate pDisptrkymd) {
        disptrkymd = pDisptrkymd;
    }


    private C_SyoruiCdKbn dispsyoruicd;

    public C_SyoruiCdKbn getDispsyoruicd() {
        return dispsyoruicd;
    }

    public void setDispsyoruicd(C_SyoruiCdKbn pDispsyoruicd) {
        dispsyoruicd = pDispsyoruicd;
    }


    private String disphubisyoruinm;

    public String getDisphubisyoruinm() {
        return disphubisyoruinm;
    }

    public void setDisphubisyoruinm(String pDisphubisyoruinm) {
        disphubisyoruinm = pDisphubisyoruinm;
    }


    private Boolean dispgenponhnkykumuchkbox;

    public Boolean getDispgenponhnkykumuchkbox() {
        return dispgenponhnkykumuchkbox == null ? Boolean.FALSE : dispgenponhnkykumuchkbox;
    }

    public void setDispgenponhnkykumuchkbox(Boolean pDispgenponhnkykumuchkbox) {
        dispgenponhnkykumuchkbox = pDispgenponhnkykumuchkbox == null ? Boolean.FALSE : pDispgenponhnkykumuchkbox;
    }


    private C_UmuKbn dispgenponhnkykumu;

    public C_UmuKbn getDispgenponhnkykumu() {
        return dispgenponhnkykumu;
    }

    public void setDispgenponhnkykumu(C_UmuKbn pDispgenponhnkykumu) {
        dispgenponhnkykumu = pDispgenponhnkykumu;
    }


    private BizDate disphassinymd;

    public BizDate getDisphassinymd() {
        return disphassinymd;
    }

    public void setDisphassinymd(BizDate pDisphassinymd) {
        disphassinymd = pDisphassinymd;
    }


    private C_HassinsakiKbn disphassinsakikbn;

    public C_HassinsakiKbn getDisphassinsakikbn() {
        return disphassinsakikbn;
    }

    public void setDisphassinsakikbn(C_HassinsakiKbn pDisphassinsakikbn) {
        disphassinsakikbn = pDisphassinsakikbn;
    }


    private String dispnyuryokutantounm;

    public String getDispnyuryokutantounm() {
        return dispnyuryokutantounm;
    }

    public void setDispnyuryokutantounm(String pDispnyuryokutantounm) {
        dispnyuryokutantounm = pDispnyuryokutantounm;
    }


    private BizDate dispkaisyouymd;

    public BizDate getDispkaisyouymd() {
        return dispkaisyouymd;
    }

    public void setDispkaisyouymd(BizDate pDispkaisyouymd) {
        dispkaisyouymd = pDispkaisyouymd;
    }


    private String sakujyoLink;

    public String getSakujyoLink() {
        return sakujyoLink;
    }

    public void setSakujyoLink(String pSakujyoLink) {
        sakujyoLink = pSakujyoLink;
    }


    private C_Delflag sakujyoflg;

    public C_Delflag getSakujyoflg() {
        return sakujyoflg;
    }

    public void setSakujyoflg(C_Delflag pSakujyoflg) {
        sakujyoflg = pSakujyoflg;
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


    private String dispsyounintantounm;

    public String getDispsyounintantounm() {
        return dispsyounintantounm;
    }

    public void setDispsyounintantounm(String pDispsyounintantounm) {
        dispsyounintantounm = pDispsyounintantounm;
    }


    private String disphubisyoruicd;

    public String getDisphubisyoruicd() {
        return disphubisyoruicd;
    }

    public void setDisphubisyoruicd(String pDisphubisyoruicd) {
        disphubisyoruicd = pDisphubisyoruicd;
    }


    private String disphubinaiyoucd;

    public String getDisphubinaiyoucd() {
        return disphubinaiyoucd;
    }

    public void setDisphubinaiyoucd(String pDisphubinaiyoucd) {
        disphubinaiyoucd = pDisphubinaiyoucd;
    }


    private String jimutetuzukicd;

    public String getJimutetuzukicd() {
        return jimutetuzukicd;
    }

    public void setJimutetuzukicd(String pJimutetuzukicd) {
        jimutetuzukicd = pJimutetuzukicd;
    }


    private C_Delflag sakujyoflg2;

    public C_Delflag getSakujyoflg2() {
        return sakujyoflg2;
    }

    public void setSakujyoflg2(C_Delflag pSakujyoflg2) {
        sakujyoflg2 = pSakujyoflg2;
    }

}
