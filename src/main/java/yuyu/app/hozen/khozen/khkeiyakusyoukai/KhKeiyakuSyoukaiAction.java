package yuyu.app.hozen.khozen.khkeiyakusyoukai;

import static yuyu.app.hozen.khozen.khkeiyakusyoukai.GenKhKeiyakuSyoukaiConstants.*;

import javax.inject.Inject;

import jp.co.slcs.swak.web.config.annotations.Forward;
import jp.co.slcs.swak.web.config.annotations.Forwards;
import jp.co.slcs.swak.web.config.annotations.Input;
import jp.co.slcs.swak.web.config.annotations.UIBean;
import jp.co.slcs.swak.web.conversation.annotations.Begin;
import jp.co.slcs.swak.web.conversation.annotations.End;

/**
 * 契約内容照会 機能のアクションクラスです。
 */
@Forwards({
    @Forward(name = FORWARDNAME_INIT, page = PAGENO_INIT, path = "/hozen/khozen/khkeiyakusyoukai/KhKeiyakuSyoukai.do", redirect = true),
    @Forward(name = FORWARDNAME_CURRENT, path = "/hozen/khozen/khkeiyakusyoukai/kh_keiyaku_syoukai.jsp"),
    @Forward(name = FORWARDNAME_INPUTKEY, page = PAGENO_INPUTKEY, path = "/hozen/khozen/khkeiyakusyoukai/kh_keiyaku_syoukai.jsp"),
    @Forward(name = FORWARDNAME_SEARCHRESULT, page = PAGENO_SEARCHRESULT, path = "/hozen/khozen/khkeiyakusyoukai/kh_keiyaku_syoukai.jsp"),
    @Forward(name = FORWARDNAME_KEIYAKUNAIYOU, page = PAGENO_KEIYAKUNAIYOU, path = "/hozen/khozen/khkeiyakusyoukai/kh_keiyaku_syoukai.jsp"),
    @Forward(name = FORWARDNAME_TTDKRIREKI, page = PAGENO_TTDKRIREKI, path = "/hozen/khozen/khkeiyakusyoukai/kh_keiyaku_syoukai.jsp"),
    @Forward(name = FORWARDNAME_TTDKSYOUSAI, page = PAGENO_TTDKSYOUSAI, path = "/hozen/khozen/khkeiyakusyoukai/kh_keiyaku_syoukai.jsp"),
    @Forward(name = FORWARDNAME_NYUUKINRIREKI, page = PAGENO_NYUUKINRIREKI, path = "/hozen/khozen/khkeiyakusyoukai/kh_keiyaku_syoukai.jsp"),
    @Forward(name = FORWARDNAME_TUMITATEKINRIREKI, page=PAGENO_TUMITATEKINRIREKI, path="/hozen/khozen/khkeiyakusyoukai/kh_keiyaku_syoukai.jsp"),
    @Forward(name = FORWARDNAME_GOTOKHKYKNAIYOUOSIRASE,                                path="/hozen/khozen/khkyknaiyouosirase/KhKykNaiyouOsirase.do?_eventHandler=fromKhKeiyakuSyoukai", redirect=true),
})
@Input("/hozen/khozen/khkeiyakusyoukai/kh_keiyaku_syoukai.jsp")
@UIBean(beanClass = KhKeiyakuSyoukaiUiBean.class)
public class KhKeiyakuSyoukaiAction {

    @Inject
    private KhKeiyakuSyoukaiBizLogic bizLogic;

    @Begin
    public String init() {

        bizLogic.init();
        return FORWARDNAME_INPUTKEY;
    }

    @Begin(renew = true)
    public String fromOtherFunctions() {
        bizLogic.init();
        bizLogic.pushKykNaiyouBtnbyInputkeyBL();
        return FORWARDNAME_KEIYAKUNAIYOU;
    }

    @Begin
    public String fromCTI() {
        bizLogic.init();
        bizLogic.ctiOpenBL();
        return FORWARDNAME_INPUTKEY;
    }

    @End
    public String tojiruBtnOnClick() {
        return null;
    }

    public String ttdkrrkbtnbykeiyakunaiyouOnClick() {
        bizLogic.pushTtdkRrkBtnBL();
        return FORWARDNAME_TTDKRIREKI;
    }

    public String nkrrkbtnbykeiyakunaiyouOnClick() {
        bizLogic.pushNkrrkBtnBL();
        return FORWARDNAME_NYUUKINRIREKI;
    }

    public String tmttknrrkbtnbykeiyakunaiyouOnClick() {
        bizLogic.pushTmttkrrkBtnBL();
        return FORWARDNAME_TUMITATEKINRIREKI;
    }

    public String kyknaiyoubtnbyttdkrirekiOnClick() {
        bizLogic.pushKykNaiyouBtnBL();
        return FORWARDNAME_KEIYAKUNAIYOU;
    }

    public String nkrrkbtnbyttdkrirekiOnClick() {
        bizLogic.pushNkrrkBtnBL();
        return FORWARDNAME_NYUUKINRIREKI;
    }

    public String tmttknrrkbtnbyttdkrirekiOnClick() {
        bizLogic.pushTmttkrrkBtnBL();
        return FORWARDNAME_TUMITATEKINRIREKI;
    }

    public String kyknaiyoubtnbynyuukinrirekiOnClick() {
        bizLogic.pushKykNaiyouBtnBL();
        return FORWARDNAME_KEIYAKUNAIYOU;
    }

    public String ttdkrrkbtnbynyuukinrirekiOnClick() {
        bizLogic.pushTtdkRrkBtnBL();
        return FORWARDNAME_TTDKRIREKI;
    }

    public String tmttknrrkbtnbynyuukinrirekiOnClick() {
        bizLogic.pushTmttkrrkBtnBL();
        return FORWARDNAME_TUMITATEKINRIREKI;
    }

    public String kyknaiyoubtnbytmttknrirekiOnClick() {
        bizLogic.pushKykNaiyouBtnBL();
        return FORWARDNAME_KEIYAKUNAIYOU;
    }

    public String ttdkrrkbtnbytmttknrirekiOnClick() {
        bizLogic.pushTtdkRrkBtnBL();
        return FORWARDNAME_TTDKRIREKI;
    }

    public String nkrrkbtnbytmttknrirekiOnClick() {
        bizLogic.pushNkrrkBtnBL();
        return FORWARDNAME_NYUUKINRIREKI;
    }

    public String kyknaiyoubtnbyinputkeyOnClick() {
        bizLogic.pushKykNaiyouBtnbyInputkeyBL();
        return FORWARDNAME_KEIYAKUNAIYOU;
    }

    public String ttdkrirekibtnbyinputkeyOnClick() {
        bizLogic.pushTtdkRirekiBtnByinputkeyBL();
        return FORWARDNAME_TTDKRIREKI;
    }

    public String nyuukinrirekibtnbyinputkeyOnClick() {
        bizLogic.pushNyuukinRirekiBtnbyInputkeyBL();
        return FORWARDNAME_NYUUKINRIREKI;
    }

    public String tmttknrrkbtnbyinputkeyOnClick() {
        bizLogic.pushTumitatekinRirekiBtnbyInputkeyBL();
        return FORWARDNAME_TUMITATEKINRIREKI;
    }

    public String dispsyonoOnClick() {
        bizLogic.pushDispSyonoBL();
        return FORWARDNAME_KEIYAKUNAIYOU;
    }

    public String hyoujilink1OnClick() {
        bizLogic.pushHyoujilink1BL();
        return FORWARDNAME_TTDKSYOUSAI;
    }

    public String hyoujilinkOnClick() {
        bizLogic.printHyoujiOut();
        return null;
    }

    public String allhyoujibtnOnClick() {
        bizLogic.printAllHyoujiOut();
        return null;
    }

    public String searchBtnOnClick() {
        bizLogic.pushSearchBL();
        return FORWARDNAME_SEARCHRESULT;
    }

    public String modorubtnbykensakuOnClick() {
        bizLogic.initParam_gotoInputKey();
        return FORWARDNAME_INPUTKEY;
    }

    public String modorubtnbykeiyakunaiyouOnClick() {
        bizLogic.initParam_gotoInputKey();
        return FORWARDNAME_INPUTKEY;
    }

    public String searchresulthemodorubtnbykeiyakunaiyouOnClick() {
        bizLogic.setUiBeanSearchResultBack();
        return FORWARDNAME_SEARCHRESULT;
    }

    public String modorubtnbyttdkrrklistOnClick() {
        bizLogic.initParam_gotoInputKey();
        return FORWARDNAME_INPUTKEY;
    }

    public String searchresulthemodorubtnbyttdkrirekiOnClick() {
        bizLogic.setUiBeanSearchResultBack();
        return FORWARDNAME_SEARCHRESULT;
    }

    public String modorubtnbyttdksyousaiOnClick() {
        bizLogic.setTtdkRirekiListUiBean();
        bizLogic.clearTtdkSyousai();
        return FORWARDNAME_TTDKRIREKI;
    }

    public String modorubtnbynyuukinrirekiOnClick() {
        bizLogic.initParam_gotoInputKey();
        return FORWARDNAME_INPUTKEY;
    }

    public String searchresulthemodorubtnbynyuukinrirekiOnClick() {
        bizLogic.setUiBeanSearchResultBack();
        return FORWARDNAME_SEARCHRESULT;
    }

    public String modorubtnbytmttknrirekiOnClick() {
        bizLogic.initParam_gotoInputKey();
        return FORWARDNAME_INPUTKEY;
    }

    public String srcrsltmdrbtnbytmttknrirekiOnClick() {
        bizLogic.setUiBeanSearchResultBack();
        return FORWARDNAME_SEARCHRESULT;
    }

    public String kensakuResultInfoPagerOnClick() {
        return FORWARDNAME_CURRENT;
    }

    public String tetudukiRirekiListPagerOnClick() {
        return FORWARDNAME_CURRENT;
    }

    public String nyuukinRirekiInfoPagerOnClick() {
        return FORWARDNAME_CURRENT;
    }

    @End
    public String functionNameOnClick() {
        return FORWARDNAME_INIT;
    }
}
