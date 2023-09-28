package yuyu.common.biz.kaikei;

import javax.validation.constraints.NotNull;

import jp.co.slcs.swak.number.BizCurrency;
import yuyu.def.classification.C_KawasetekiyoKbn;

/**
 * （共通）仕訳明細BEAN データレイアウトのBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
public class BzSiwakeMeisaiBean extends GenBzSiwakeMeisaiBean {

    private static final long serialVersionUID = 1L;

    public BzSiwakeMeisaiBean() {

        super.setIbTaisyakutyouseiflg(false);
    }

    @NotNull
    private BizCurrency ibKeiyakutuukagk;

    private C_KawasetekiyoKbn ibKawasetekiyokbn;

    public BizCurrency getIbKeiyakutuukagk() {
        return ibKeiyakutuukagk;
    }

    public void setIbKeiyakutuukagk(BizCurrency pIbKeiyakutuukagk) {
        ibKeiyakutuukagk = pIbKeiyakutuukagk;
    }

    public C_KawasetekiyoKbn getIbKawasetekiyokbn() {
        return ibKawasetekiyokbn;
    }

    public void setIbKawasetekiyokbn(C_KawasetekiyoKbn pIbKawasetekiyokbn) {
        ibKawasetekiyokbn = pIbKawasetekiyokbn;
    }

}
