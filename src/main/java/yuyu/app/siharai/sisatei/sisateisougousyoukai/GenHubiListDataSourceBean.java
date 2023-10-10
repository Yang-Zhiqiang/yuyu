package yuyu.app.siharai.sisatei.sisateisougousyoukai;

import java.io.Serializable;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import yuyu.def.classification.C_HassinsakiKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.infr.validation.constraints.InvalidCharacter;

/**
 * 査定総合照会 - ●不備一覧 の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenHubiListDataSourceBean implements Serializable {

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


    private C_UmuKbn genponhnkykumu;

    public C_UmuKbn getGenponhnkykumu() {
        return genponhnkykumu;
    }

    public void setGenponhnkykumu(C_UmuKbn pGenponhnkykumu) {
        genponhnkykumu = pGenponhnkykumu;
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


    private String dispnyuryokutantounm;

    public String getDispnyuryokutantounm() {
        return dispnyuryokutantounm;
    }

    public void setDispnyuryokutantounm(String pDispnyuryokutantounm) {
        dispnyuryokutantounm = pDispnyuryokutantounm;
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


    private String hubisyoruimsg;

    public String getHubisyoruimsg() {
        return hubisyoruimsg;
    }

    public void setHubisyoruimsg(String pHubisyoruimsg) {
        hubisyoruimsg = pHubisyoruimsg;
    }


    @InvalidCharacter
    private String hubisyouninktntnm;

    public String getHubisyouninktntnm() {
        return hubisyouninktntnm;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setHubisyouninktntnm(String pHubisyouninktntnm) {
        hubisyouninktntnm = pHubisyouninktntnm;
    }

}
