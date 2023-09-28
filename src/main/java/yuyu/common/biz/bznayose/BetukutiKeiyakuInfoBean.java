package yuyu.common.biz.bznayose;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_BetukutiKeiyakuKbn;
import yuyu.def.classification.C_SysCdKbn;

/**
 * 業務共通 名寄せ 別口契約情報Beanクラス<br>
 * 当機能で必要な任意のオブジェクトを保持するBeanクラス
 */
public class BetukutiKeiyakuInfoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String btkyksyono ;

    private C_SysCdKbn syscdkbn;

    private C_BetukutiKeiyakuKbn betukutikeiyakukbn;

    private String kankeisyakbnname;

    private BizDate syoumetuymd;

    private String syoumetujiyuuname;

    private String syouhnnm;

    public BetukutiKeiyakuInfoBean() {

    }

    public String getBtkyksyono () {
        return btkyksyono ;
    }

    public void setBtkyksyono (String pBtkyksyono ) {
        btkyksyono  = pBtkyksyono ;
    }

    public C_SysCdKbn getSyscdkbn() {
        return syscdkbn;
    }

    public void setSyscdkbn(C_SysCdKbn pSyscdkbn) {
        syscdkbn = pSyscdkbn;
    }

    public C_BetukutiKeiyakuKbn getBetukutikeiyakukbn() {
        return betukutikeiyakukbn;
    }

    public void setBetukutikeiyakukbn(C_BetukutiKeiyakuKbn pBetukutikeiyakukbn) {
        betukutikeiyakukbn = pBetukutikeiyakukbn;
    }

    public String getKankeisyakbnname() {
        return kankeisyakbnname;
    }

    public void setKankeisyakbnname(String pKankeisyakbnname) {
        kankeisyakbnname = pKankeisyakbnname;
    }

    public BizDate getSyoumetuymd() {
        return syoumetuymd;
    }

    public void setSyoumetuymd(BizDate pSyoumetuymd) {
        syoumetuymd = pSyoumetuymd;
    }

    public String getSyoumetujiyuuname() {
        return syoumetujiyuuname;
    }

    public void setSyoumetujiyuuname(String pSyoumetujiyuuname) {
        syoumetujiyuuname = pSyoumetujiyuuname;
    }

    public String getSyouhnnm() {
        return syouhnnm;
    }

    public void setSyouhnnm(String pSyouhnnm) {
        syouhnnm = pSyouhnnm;
    }

}
