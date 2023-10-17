package yuyu.app.sinkeiyaku.skhubikanri.skhubitouroku;

import java.io.Serializable;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.validation.constraints.MultiByteStringsReturnable;
import yuyu.def.classification.C_HasinkyokaKbn;
import yuyu.def.classification.C_HassinsakiKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.infr.validation.constraints.InvalidCharacter;

/**
 * 新契約不備登録 - ●発信済み不備一覧 の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenHubiList1DataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private BizDate disptrkymd;

    public BizDate getDisptrkymd() {
        return disptrkymd;
    }

    public void setDisptrkymd(BizDate pDisptrkymd) {
        disptrkymd = pDisptrkymd;
    }


    private C_SyoruiCdKbn hubisyoruicd;

    public C_SyoruiCdKbn getHubisyoruicd() {
        return hubisyoruicd;
    }

    public void setHubisyoruicd(C_SyoruiCdKbn pHubisyoruicd) {
        hubisyoruicd = pHubisyoruicd;
    }


    private BizDate disphassinymd;

    public BizDate getDisphassinymd() {
        return disphassinymd;
    }

    public void setDisphassinymd(BizDate pDisphassinymd) {
        disphassinymd = pDisphassinymd;
    }


    private C_HasinkyokaKbn disphasinkyokakbn;

    public C_HasinkyokaKbn getDisphasinkyokakbn() {
        return disphasinkyokakbn;
    }

    public void setDisphasinkyokakbn(C_HasinkyokaKbn pDisphasinkyokakbn) {
        disphasinkyokakbn = pDisphasinkyokakbn;
    }


    private String dispnyuryokutantounm;

    public String getDispnyuryokutantounm() {
        return dispnyuryokutantounm;
    }

    public void setDispnyuryokutantounm(String pDispnyuryokutantounm) {
        dispnyuryokutantounm = pDispnyuryokutantounm;
    }


    private String dummykmk1;

    public String getDummykmk1() {
        return dummykmk1;
    }

    public void setDummykmk1(String pDummykmk1) {
        dummykmk1 = pDummykmk1;
    }


    private String dispskhubikoumoku;

    public String getDispskhubikoumoku() {
        return dispskhubikoumoku;
    }

    public void setDispskhubikoumoku(String pDispskhubikoumoku) {
        dispskhubikoumoku = pDispskhubikoumoku;
    }


    private String dispskhubinaiyou;

    public String getDispskhubinaiyou() {
        return dispskhubinaiyou;
    }

    public void setDispskhubinaiyou(String pDispskhubinaiyou) {
        dispskhubinaiyou = pDispskhubinaiyou;
    }


    private BizDate dispkaisyouymd;

    public BizDate getDispkaisyouymd() {
        return dispkaisyouymd;
    }

    public void setDispkaisyouymd(BizDate pDispkaisyouymd) {
        dispkaisyouymd = pDispkaisyouymd;
    }


    private C_HassinsakiKbn disphassinsakikbn;

    public C_HassinsakiKbn getDisphassinsakikbn() {
        return disphassinsakikbn;
    }

    public void setDisphassinsakikbn(C_HassinsakiKbn pDisphassinsakikbn) {
        disphassinsakikbn = pDisphassinsakikbn;
    }


    private String dispskseibisijinaiyou;

    public String getDispskseibisijinaiyou() {
        return dispskseibisijinaiyou;
    }

    public void setDispskseibisijinaiyou(String pDispskseibisijinaiyou) {
        dispskseibisijinaiyou = pDispskseibisijinaiyou;
    }


    @MultiByteStringsReturnable
    @InvalidCharacter
    private String tyoubundisprenrakujikou;

    public String getTyoubundisprenrakujikou() {
        return tyoubundisprenrakujikou;
    }

    @DataConvert("toMultiByte")
    public void setTyoubundisprenrakujikou(String pTyoubundisprenrakujikou) {
        tyoubundisprenrakujikou = pTyoubundisprenrakujikou;
    }

}
