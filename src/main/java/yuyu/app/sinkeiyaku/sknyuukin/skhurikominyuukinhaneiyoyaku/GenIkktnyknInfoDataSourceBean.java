package yuyu.app.sinkeiyaku.sknyuukin.skhurikominyuukinhaneiyoyaku;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.web.ui.AbstractUiBean.LoopChain;
import jp.co.slcs.swak.web.ui.UserDefsList;
import yuyu.def.classification.C_Tuukasyu;

/**
 * 振込入金反映予約 - ●一括入金額 の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenIkktnyknInfoDataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String ikktnykninfonyknoyadrtennm;

    public String getIkktnykninfonyknoyadrtennm() {
        return ikktnykninfonyknoyadrtennm;
    }

    public void setIkktnykninfonyknoyadrtennm(String pIkktnykninfonyknoyadrtennm) {
        ikktnykninfonyknoyadrtennm = pIkktnykninfonyknoyadrtennm;
    }


    private LoopChain<UserDefsList> ikktnykninfonyknoyadrtennmOptionBeanList = new LoopChain<>();
    public UserDefsList getIkktnykninfonyknoyadrtennmOptionBeanList() {
        return ikktnykninfonyknoyadrtennmOptionBeanList.get();
    }

    public void setIkktnykninfonyknoyadrtennmOptionBeanList(UserDefsList pIkktnykninfonyknoyadrtennmOptionBeanList) {
        ikktnykninfonyknoyadrtennmOptionBeanList.add(pIkktnykninfonyknoyadrtennmOptionBeanList);
    }

    public void clearIkktnykninfonyknoyadrtennmOptionBeanList() {
        ikktnykninfonyknoyadrtennmOptionBeanList.clear();
    }

    private C_Tuukasyu ikktnykninfohrktuukasyu;

    public C_Tuukasyu getIkktnykninfohrktuukasyu() {
        return ikktnykninfohrktuukasyu;
    }

    public void setIkktnykninfohrktuukasyu(C_Tuukasyu pIkktnykninfohrktuukasyu) {
        ikktnykninfohrktuukasyu = pIkktnykninfohrktuukasyu;
    }


    private C_Tuukasyu ikktnykninfositeituukasyu;

    public C_Tuukasyu getIkktnykninfositeituukasyu() {
        return ikktnykninfositeituukasyu;
    }

    public void setIkktnykninfositeituukasyu(C_Tuukasyu pIkktnykninfositeituukasyu) {
        ikktnykninfositeituukasyu = pIkktnykninfositeituukasyu;
    }


    private String ikktnykninfokouzano;

    public String getIkktnykninfokouzano() {
        return ikktnykninfokouzano;
    }

    public void setIkktnykninfokouzano(String pIkktnykninfokouzano) {
        ikktnykninfokouzano = pIkktnykninfokouzano;
    }


    private BizCurrency ikktnykninfoikktnyuukingk;

    public BizCurrency getIkktnykninfoikktnyuukingk() {
        return ikktnykninfoikktnyuukingk;
    }

    public void setIkktnykninfoikktnyuukingk(BizCurrency pIkktnykninfoikktnyuukingk) {
        ikktnykninfoikktnyuukingk = pIkktnykninfoikktnyuukingk;
    }


    private BizCurrency ikktnykninfodengk;

    public BizCurrency getIkktnykninfodengk() {
        return ikktnykninfodengk;
    }

    public void setIkktnykninfodengk(BizCurrency pIkktnykninfodengk) {
        ikktnykninfodengk = pIkktnykninfodengk;
    }


    private BizDate ikktnykninforyosyuymd;

    public BizDate getIkktnykninforyosyuymd() {
        return ikktnykninforyosyuymd;
    }

    public void setIkktnykninforyosyuymd(BizDate pIkktnykninforyosyuymd) {
        ikktnykninforyosyuymd = pIkktnykninforyosyuymd;
    }


    private BizNumber ikktnykninfokawaserate;

    public BizNumber getIkktnykninfokawaserate() {
        return ikktnykninfokawaserate;
    }

    public void setIkktnykninfokawaserate(BizNumber pIkktnykninfokawaserate) {
        ikktnykninfokawaserate = pIkktnykninfokawaserate;
    }

}
