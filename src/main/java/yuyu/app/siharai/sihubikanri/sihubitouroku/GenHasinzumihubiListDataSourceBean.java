package yuyu.app.siharai.sihubikanri.sihubitouroku;

import java.io.Serializable;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.validation.constraints.MultiByteStringsReturnable;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import jp.co.slcs.swak.validation.constraints.ValidTextArea;
import yuyu.def.classification.C_HassinsakiKbn;
import yuyu.infr.validation.constraints.InvalidCharacter;

/**
 * 保険金給付金不備登録 - ●発信済み不備一覧 の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenHasinzumihubiListDataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @ValidDate
    private BizDate trkymd;

    public BizDate getTrkymd() {
        return trkymd;
    }

    @Trim("both")
    public void setTrkymd(BizDate pTrkymd) {
        trkymd = pTrkymd;
    }


    private String hubisyoruinm;

    public String getHubisyoruinm() {
        return hubisyoruinm;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setHubisyoruinm(String pHubisyoruinm) {
        hubisyoruinm = pHubisyoruinm;
    }


    private Boolean genponhnkykumuchkbox;

    public Boolean getGenponhnkykumuchkbox() {
        return genponhnkykumuchkbox == null ? Boolean.FALSE : genponhnkykumuchkbox;
    }

    public void setGenponhnkykumuchkbox(Boolean pGenponhnkykumuchkbox) {
        genponhnkykumuchkbox = pGenponhnkykumuchkbox == null ? Boolean.FALSE : pGenponhnkykumuchkbox;
    }


    private BizDate hasinymd;

    public BizDate getHasinymd() {
        return hasinymd;
    }

    @Trim("both")
    public void setHasinymd(BizDate pHasinymd) {
        hasinymd = pHasinymd;
    }


    private C_HassinsakiKbn hassinsakikbn;

    public C_HassinsakiKbn getHassinsakikbn() {
        return hassinsakikbn;
    }

    public void setHassinsakikbn(C_HassinsakiKbn pHassinsakikbn) {
        hassinsakikbn = pHassinsakikbn;
    }


    private String nyuuryokutantounm;

    public String getNyuuryokutantounm() {
        return nyuuryokutantounm;
    }

    public void setNyuuryokutantounm(String pNyuuryokutantounm) {
        nyuuryokutantounm = pNyuuryokutantounm;
    }


    @ValidDate
    private BizDate kaisyouymd;

    public BizDate getKaisyouymd() {
        return kaisyouymd;
    }

    @Trim("both")
    public void setKaisyouymd(BizDate pKaisyouymd) {
        kaisyouymd = pKaisyouymd;
    }


    @ValidTextArea(length=30, rows=5)
    @MultiByteStringsReturnable
    @InvalidCharacter
    private String hubinaiyoumsg;

    public String getHubinaiyoumsg() {
        return hubinaiyoumsg;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setHubinaiyoumsg(String pHubinaiyoumsg) {
        hubinaiyoumsg = pHubinaiyoumsg;
    }


    private String syounintantounm;

    public String getSyounintantounm() {
        return syounintantounm;
    }

    public void setSyounintantounm(String pSyounintantounm) {
        syounintantounm = pSyounintantounm;
    }

}
