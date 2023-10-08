package yuyu.app.sinkeiyaku.sksyoukai.skmossyoukai;

import java.io.Serializable;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.validation.constraints.MultiByteStringsReturnable;
import yuyu.def.classification.C_HasinkyokaKbn;
import yuyu.def.classification.C_HassinsakiKbn;
import yuyu.infr.validation.constraints.InvalidCharacter;

/**
 * 申込状況照会 - ●不備一覧 の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenHubiItiranDataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private BizDate disptrkymd;

    public BizDate getDisptrkymd() {
        return disptrkymd;
    }

    public void setDisptrkymd(BizDate pDisptrkymd) {
        disptrkymd = pDisptrkymd;
    }


    private String dispskhubikoumoku;

    public String getDispskhubikoumoku() {
        return dispskhubikoumoku;
    }

    public void setDispskhubikoumoku(String pDispskhubikoumoku) {
        dispskhubikoumoku = pDispskhubikoumoku;
    }


    private BizDate disphassinymd;

    public BizDate getDisphassinymd() {
        return disphassinymd;
    }

    public void setDisphassinymd(BizDate pDisphassinymd) {
        disphassinymd = pDisphassinymd;
    }


    private BizDate dispkaisyouymd;

    public BizDate getDispkaisyouymd() {
        return dispkaisyouymd;
    }

    public void setDispkaisyouymd(BizDate pDispkaisyouymd) {
        dispkaisyouymd = pDispkaisyouymd;
    }


    private C_HasinkyokaKbn disphasinkyokakbn;

    public C_HasinkyokaKbn getDisphasinkyokakbn() {
        return disphasinkyokakbn;
    }

    public void setDisphasinkyokakbn(C_HasinkyokaKbn pDisphasinkyokakbn) {
        disphasinkyokakbn = pDisphasinkyokakbn;
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


    private String dispskhubinaiyou;

    public String getDispskhubinaiyou() {
        return dispskhubinaiyou;
    }

    public void setDispskhubinaiyou(String pDispskhubinaiyou) {
        dispskhubinaiyou = pDispskhubinaiyou;
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


    private String disprenrakujikou;

    public String getDisprenrakujikou() {
        return disprenrakujikou;
    }

    public void setDisprenrakujikou(String pDisprenrakujikou) {
        disprenrakujikou = pDisprenrakujikou;
    }

}
