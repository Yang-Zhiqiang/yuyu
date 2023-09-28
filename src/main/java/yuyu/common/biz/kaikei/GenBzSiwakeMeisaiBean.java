package yuyu.common.biz.kaikei;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_TaisyakuKbn;

/**
 * （共通）仕訳明細BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenBzSiwakeMeisaiBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenBzSiwakeMeisaiBean() {
    }

    @NotNull
    private C_TaisyakuKbn ibTaisyakukbn;

    public C_TaisyakuKbn getIbTaisyakukbn() {
        return ibTaisyakukbn;
    }

    public void setIbTaisyakukbn(C_TaisyakuKbn pIbTaisyakukbn) {
        ibTaisyakukbn = pIbTaisyakukbn;
    }

    @NotNull
    private C_Kanjyoukmkcd ibKanjyoukmkcd;

    public C_Kanjyoukmkcd getIbKanjyoukmkcd() {
        return ibKanjyoukmkcd;
    }

    public void setIbKanjyoukmkcd(C_Kanjyoukmkcd pIbKanjyoukmkcd) {
        ibKanjyoukmkcd = pIbKanjyoukmkcd;
    }

    @NotNull
    private String ibSuitoubumoncd;

    public String getIbSuitoubumoncd() {
        return ibSuitoubumoncd;
    }

    public void setIbSuitoubumoncd(String pIbSuitoubumoncd) {
        ibSuitoubumoncd = pIbSuitoubumoncd;
    }

    @NotNull
    private BizCurrency ibDengaikagk;

    public BizCurrency getIbDengaikagk() {
        return ibDengaikagk;
    }

    public void setIbDengaikagk(BizCurrency pIbDengaikagk) {
        ibDengaikagk = pIbDengaikagk;
    }

    @NotNull
    private BizCurrency ibDenyenkagk;

    public BizCurrency getIbDenyenkagk() {
        return ibDenyenkagk;
    }

    public void setIbDenyenkagk(BizCurrency pIbDenyenkagk) {
        ibDenyenkagk = pIbDenyenkagk;
    }

    @NotNull
    private C_Segcd ibSeg1cd;

    public C_Segcd getIbSeg1cd() {
        return ibSeg1cd;
    }

    public void setIbSeg1cd(C_Segcd pIbSeg1cd) {
        ibSeg1cd = pIbSeg1cd;
    }

    @NotNull
    private C_Segcd ibSeg2cd;

    public C_Segcd getIbSeg2cd() {
        return ibSeg2cd;
    }

    public void setIbSeg2cd(C_Segcd pIbSeg2cd) {
        ibSeg2cd = pIbSeg2cd;
    }

    private String ibDenkarikanjyono;

    public String getIbDenkarikanjyono() {
        return ibDenkarikanjyono;
    }

    public void setIbDenkarikanjyono(String pIbDenkarikanjyono) {
        ibDenkarikanjyono = pIbDenkarikanjyono;
    }

    private Boolean ibTaisyakutyouseiflg;

    public Boolean getIbTaisyakutyouseiflg() {
        return ibTaisyakutyouseiflg;
    }

    public void setIbTaisyakutyouseiflg(Boolean pIbTaisyakutyouseiflg) {
        ibTaisyakutyouseiflg = pIbTaisyakutyouseiflg;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
