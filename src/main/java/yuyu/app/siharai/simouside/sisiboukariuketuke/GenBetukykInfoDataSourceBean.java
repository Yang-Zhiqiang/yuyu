package yuyu.app.siharai.simouside.sisiboukariuketuke;

import java.io.Serializable;

import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import yuyu.def.classification.C_BetukutiKeiyakuKbn;
import yuyu.def.classification.C_SysCdKbn;
import yuyu.infr.validation.constraints.InvalidCharacter;

/**
 * 死亡仮受付 - ●別契約情報 の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenBetukykInfoDataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String btkyksyono;

    public String getBtkyksyono() {
        return btkyksyono;
    }

    public void setBtkyksyono(String pBtkyksyono) {
        btkyksyono = pBtkyksyono;
    }


    private C_SysCdKbn syscdkbn;

    public C_SysCdKbn getSyscdkbn() {
        return syscdkbn;
    }

    public void setSyscdkbn(C_SysCdKbn pSyscdkbn) {
        syscdkbn = pSyscdkbn;
    }


    private C_BetukutiKeiyakuKbn betukutikeiyakukbn;

    public C_BetukutiKeiyakuKbn getBetukutikeiyakukbn() {
        return betukutikeiyakukbn;
    }

    public void setBetukutikeiyakukbn(C_BetukutiKeiyakuKbn pBetukutikeiyakukbn) {
        betukutikeiyakukbn = pBetukutikeiyakukbn;
    }


    private String kankeisyakbnname;

    public String getKankeisyakbnname() {
        return kankeisyakbnname;
    }

    public void setKankeisyakbnname(String pKankeisyakbnname) {
        kankeisyakbnname = pKankeisyakbnname;
    }


    private BizDate syoumetuymd;

    public BizDate getSyoumetuymd() {
        return syoumetuymd;
    }

    @Trim("both")
    public void setSyoumetuymd(BizDate pSyoumetuymd) {
        syoumetuymd = pSyoumetuymd;
    }


    private String syoumetujiyuuname;

    public String getSyoumetujiyuuname() {
        return syoumetujiyuuname;
    }

    public void setSyoumetujiyuuname(String pSyoumetujiyuuname) {
        syoumetujiyuuname = pSyoumetujiyuuname;
    }


    @MaxLength(max=40)
    @MultiByteStrings
    @InvalidCharacter
    private String syouhnnm;

    public String getSyouhnnm() {
        return syouhnnm;
    }

    @Trim("right")
    public void setSyouhnnm(String pSyouhnnm) {
        syouhnnm = pSyouhnnm;
    }

}
