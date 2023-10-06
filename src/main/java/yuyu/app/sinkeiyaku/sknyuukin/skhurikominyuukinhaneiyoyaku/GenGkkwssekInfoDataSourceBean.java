package yuyu.app.sinkeiyaku.sknyuukin.skhurikominyuukinhaneiyoyaku;

import java.io.Serializable;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.web.ui.AbstractUiBean.LoopChain;
import jp.co.slcs.swak.web.ui.UserDefsList;
import yuyu.def.classification.C_Tuukasyu;

/**
 * 振込入金反映予約 - ●外貨為替差益 の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenGkkwssekInfoDataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String gkkwssekinfonyknoyadrtennm;

    public String getGkkwssekinfonyknoyadrtennm() {
        return gkkwssekinfonyknoyadrtennm;
    }

    public void setGkkwssekinfonyknoyadrtennm(String pGkkwssekinfonyknoyadrtennm) {
        gkkwssekinfonyknoyadrtennm = pGkkwssekinfonyknoyadrtennm;
    }


    private LoopChain<UserDefsList> gkkwssekinfonyknoyadrtennmOptionBeanList = new LoopChain<>();
    public UserDefsList getGkkwssekinfonyknoyadrtennmOptionBeanList() {
        return gkkwssekinfonyknoyadrtennmOptionBeanList.get();
    }

    public void setGkkwssekinfonyknoyadrtennmOptionBeanList(UserDefsList pGkkwssekinfonyknoyadrtennmOptionBeanList) {
        gkkwssekinfonyknoyadrtennmOptionBeanList.add(pGkkwssekinfonyknoyadrtennmOptionBeanList);
    }

    public void clearGkkwssekinfonyknoyadrtennmOptionBeanList() {
        gkkwssekinfonyknoyadrtennmOptionBeanList.clear();
    }

    private C_Tuukasyu gkkwssekinfohrktuukasyu;

    public C_Tuukasyu getGkkwssekinfohrktuukasyu() {
        return gkkwssekinfohrktuukasyu;
    }

    public void setGkkwssekinfohrktuukasyu(C_Tuukasyu pGkkwssekinfohrktuukasyu) {
        gkkwssekinfohrktuukasyu = pGkkwssekinfohrktuukasyu;
    }


    private C_Tuukasyu gkkwssekinfositeituukasyu;

    public C_Tuukasyu getGkkwssekinfositeituukasyu() {
        return gkkwssekinfositeituukasyu;
    }

    public void setGkkwssekinfositeituukasyu(C_Tuukasyu pGkkwssekinfositeituukasyu) {
        gkkwssekinfositeituukasyu = pGkkwssekinfositeituukasyu;
    }


    private String gkkwssekinfokouzano;

    public String getGkkwssekinfokouzano() {
        return gkkwssekinfokouzano;
    }

    public void setGkkwssekinfokouzano(String pGkkwssekinfokouzano) {
        gkkwssekinfokouzano = pGkkwssekinfokouzano;
    }


    private BizCurrency grossnykngk;

    public BizCurrency getGrossnykngk() {
        return grossnykngk;
    }

    public void setGrossnykngk(BizCurrency pGrossnykngk) {
        grossnykngk = pGrossnykngk;
    }


    private BizCurrency grossdengk;

    public BizCurrency getGrossdengk() {
        return grossdengk;
    }

    public void setGrossdengk(BizCurrency pGrossdengk) {
        grossdengk = pGrossdengk;
    }


    private BizCurrency meisaigoukeidengk;

    public BizCurrency getMeisaigoukeidengk() {
        return meisaigoukeidengk;
    }

    public void setMeisaigoukeidengk(BizCurrency pMeisaigoukeidengk) {
        meisaigoukeidengk = pMeisaigoukeidengk;
    }


    private BizCurrency kawasesasonekikngk;

    public BizCurrency getKawasesasonekikngk() {
        return kawasesasonekikngk;
    }

    public void setKawasesasonekikngk(BizCurrency pKawasesasonekikngk) {
        kawasesasonekikngk = pKawasesasonekikngk;
    }

}
