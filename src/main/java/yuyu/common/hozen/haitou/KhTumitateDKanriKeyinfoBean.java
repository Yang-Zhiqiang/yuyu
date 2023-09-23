package yuyu.common.hozen.haitou;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;

/**
 * 契約保全 配当 キー情報（積立Ｄ管理TBL）Beanクラス
 */
public class KhTumitateDKanriKeyinfoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String syono;

    private BizDate tumitatedtumitateymd;

    private Integer renno;

    public String getSyono() {
        return syono;
    }

    public void setSyono(String pSyono) {
        syono = pSyono;
    }

    public BizDate getTumitatedtumitateymd() {
        return tumitatedtumitateymd;
    }

    public void setTumitatedtumitateymd(BizDate pTumitatedtumitateymd) {
        tumitatedtumitateymd = pTumitatedtumitateymd;
    }

    public Integer getRenno() {
        return renno;
    }

    public void setRenno(Integer pRenno) {
        renno = pRenno;
    }
}
