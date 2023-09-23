package yuyu.common.hozen.haitou;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDateY;
import yuyu.def.classification.C_HaitoukinsksKbn;
import yuyu.def.classification.C_HaitoumeisaiKbn;

/**
 * 契約保全 配当 キー情報（配当管理TBL）Beanクラス
 */
public class KhHaitouKanriKeyinfoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String syono;

    private BizDateY haitounendo;

    private Integer renno;

    private C_HaitoukinsksKbn haitoukinsksKbn;

    private C_HaitoumeisaiKbn haitoumeisaiKbn;

    public KhHaitouKanriKeyinfoBean() {

    }

    public String getSyono() {
        return syono;
    }

    public void setSyono(String pSyono) {
        syono = pSyono;
    }

    public BizDateY getHaitounendo() {
        return haitounendo;
    }

    public void setHaitounendo(BizDateY pHaitounendo) {
        haitounendo = pHaitounendo;
    }

    public Integer getRenno() {
        return renno;
    }

    public void setRenno(Integer pRenno) {
        renno = pRenno;
    }

    public C_HaitoukinsksKbn getHaitoukinsksKbn() {
        return haitoukinsksKbn;
    }

    public void setHaitoukinsksKbn(C_HaitoukinsksKbn pHaitoukinsksKbn) {
        haitoukinsksKbn = pHaitoukinsksKbn;
    }

    public C_HaitoumeisaiKbn getHaitoumeisaiKbn() {
        return haitoumeisaiKbn;
    }

    public void setHaitoumeisaiKbn(C_HaitoumeisaiKbn pHaitoumeisaiKbn) {
        haitoumeisaiKbn = pHaitoumeisaiKbn;
    }
}
