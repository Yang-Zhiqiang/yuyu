package yuyu.app.direct.dskokyakukanri.dskokyakuseibi;

import java.io.Serializable;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import yuyu.def.classification.C_DsKokyakuJtKbn;
import yuyu.def.classification.C_PasswordJtKbn;
import yuyu.def.classification.C_SeibiRiyuuKbn;
import yuyu.def.classification.C_Syorizumiflg;
import yuyu.infr.validation.constraints.HostInvalidCharacter;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 顧客整備 - ●検索結果 の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenSearchResultInfoDataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String dskokno;

    public String getDskokno() {
        return dskokno;
    }

    public void setDskokno(String pDskokno) {
        dskokno = pDskokno;
    }


    @SyoukenNo
    private String syono;

    public String getSyono() {
        return syono;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyono(String pSyono) {
        syono = pSyono;
    }


    private String dskokyakunmkj;

    public String getDskokyakunmkj() {
        return dskokyakunmkj;
    }

    public void setDskokyakunmkj(String pDskokyakunmkj) {
        dskokyakunmkj = pDskokyakunmkj;
    }


    private BizDate dskokyakuseiymd;

    public BizDate getDskokyakuseiymd() {
        return dskokyakuseiymd;
    }

    public void setDskokyakuseiymd(BizDate pDskokyakuseiymd) {
        dskokyakuseiymd = pDskokyakuseiymd;
    }


    private C_DsKokyakuJtKbn dskokyakujtkbn;

    public C_DsKokyakuJtKbn getDskokyakujtkbn() {
        return dskokyakujtkbn;
    }

    public void setDskokyakujtkbn(C_DsKokyakuJtKbn pDskokyakujtkbn) {
        dskokyakujtkbn = pDskokyakujtkbn;
    }


    private C_PasswordJtKbn passwordjtkbn;

    public C_PasswordJtKbn getPasswordjtkbn() {
        return passwordjtkbn;
    }

    public void setPasswordjtkbn(C_PasswordJtKbn pPasswordjtkbn) {
        passwordjtkbn = pPasswordjtkbn;
    }


    private C_SeibiRiyuuKbn seibiriyuukbn;

    public C_SeibiRiyuuKbn getSeibiriyuukbn() {
        return seibiriyuukbn;
    }

    public void setSeibiriyuukbn(C_SeibiRiyuuKbn pSeibiriyuukbn) {
        seibiriyuukbn = pSeibiriyuukbn;
    }


    @ValidDate
    private BizDate syoriYmd;

    public BizDate getSyoriYmd() {
        return syoriYmd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyoriYmd(BizDate pSyoriYmd) {
        syoriYmd = pSyoriYmd;
    }


    private C_Syorizumiflg syorizumiflg;

    public C_Syorizumiflg getSyorizumiflg() {
        return syorizumiflg;
    }

    public void setSyorizumiflg(C_Syorizumiflg pSyorizumiflg) {
        syorizumiflg = pSyorizumiflg;
    }


    @HostInvalidCharacter
    private String dskokyakunmkn;

    public String getDskokyakunmkn() {
        return dskokyakunmkn;
    }

    public void setDskokyakunmkn(String pDskokyakunmkn) {
        dskokyakunmkn = pDskokyakunmkn;
    }


    private String dskokyakuyno;

    public String getDskokyakuyno() {
        return dskokyakuyno;
    }

    public void setDskokyakuyno(String pDskokyakuyno) {
        dskokyakuyno = pDskokyakuyno;
    }

}
