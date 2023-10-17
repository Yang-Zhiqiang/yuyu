package yuyu.app.sinkeiyaku.sksyoukai.skmossyoukai;

import static yuyu.app.sinkeiyaku.sksyoukai.skmossyoukai.GenSkMosSyoukaiConstants.*;

import javax.inject.Inject;

import jp.co.slcs.swak.web.config.annotations.Forward;
import jp.co.slcs.swak.web.config.annotations.Forwards;
import jp.co.slcs.swak.web.config.annotations.Input;
import jp.co.slcs.swak.web.config.annotations.UIBean;
import jp.co.slcs.swak.web.conversation.annotations.Begin;
import jp.co.slcs.swak.web.conversation.annotations.End;
import yuyu.app.sinkeiyaku.sksyoukai.skmossyoukai.SkMosSyoukaiConstants.E_SyoriKeiyu;

/**
 * 申込状況照会 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,                 page=PAGENO_INIT,             path="/sinkeiyaku/sksyoukai/skmossyoukai/SkMosSyoukai.do", redirect=true),
    @Forward(name=FORWARDNAME_CURRENT,                                            path="/sinkeiyaku/sksyoukai/skmossyoukai/sk_mos_syoukai.jsp"),
    @Forward(name=FORWARDNAME_INPUTKEY,             page=PAGENO_INPUTKEY,         path="/sinkeiyaku/sksyoukai/skmossyoukai/sk_mos_syoukai.jsp"),
    @Forward(name=FORWARDNAME_KENSAKURESULT,        page=PAGENO_KENSAKURESULT,    path="/sinkeiyaku/sksyoukai/skmossyoukai/sk_mos_syoukai.jsp"),
    @Forward(name=FORWARDNAME_KEIYAKUNAIYOU,        page=PAGENO_KEIYAKUNAIYOU,    path="/sinkeiyaku/sksyoukai/skmossyoukai/sk_mos_syoukai.jsp"),
    @Forward(name=FORWARDNAME_HUBIJK,               page=PAGENO_HUBIJK,           path="/sinkeiyaku/sksyoukai/skmossyoukai/sk_mos_syoukai.jsp"),
    @Forward(name=FORWARDNAME_HUBITRKINFO,          page=PAGENO_HUBITRKINFO,      path="/sinkeiyaku/sksyoukai/skmossyoukai/sk_mos_syoukai.jsp"),
    @Forward(name=FORWARDNAME_KETTEIJK,             page=PAGENO_KETTEIJK,         path="/sinkeiyaku/sksyoukai/skmossyoukai/sk_mos_syoukai.jsp"),
    @Forward(name=FORWARDNAME_NYUUKINJK,            page=PAGENO_NYUUKINJK,        path="/sinkeiyaku/sksyoukai/skmossyoukai/sk_mos_syoukai.jsp"),
    @Forward(name=FORWARDNAME_SYORUITOUTYAKUJK,     page=PAGENO_SYORUITOUTYAKUJK, path="/sinkeiyaku/sksyoukai/skmossyoukai/sk_mos_syoukai.jsp"),
    @Forward(name=FORWARDNAME_TEISEIRRKLIST,        page=PAGENO_TEISEIRRKLIST,    path="/sinkeiyaku/sksyoukai/skmossyoukai/sk_mos_syoukai.jsp"),
    @Forward(name=FORWARDNAME_SAKUININFO,           page=PAGENO_SAKUININFO,       path="/sinkeiyaku/sksyoukai/skmossyoukai/sk_mos_syoukai.jsp"),
    @Forward(name=FORWARDNAME_KOUTEIJK,             page=PAGENO_KOUTEIJK,         path="/sinkeiyaku/sksyoukai/skmossyoukai/sk_mos_syoukai.jsp"),
    @Forward(name=FORWARDNAME_GOTOKHKEIYAKUSYOUKAI,                               path="/hozen/khozen/khkeiyakusyoukai/KhKeiyakuSyoukai.do?_eventHandler=fromSkMosSyoukai", redirect=true),
})
@Input("/sinkeiyaku/sksyoukai/skmossyoukai/sk_mos_syoukai.jsp")
@UIBean(beanClass=SkMosSyoukaiUiBean.class)
public class SkMosSyoukaiAction {

    @Inject
    private SkMosSyoukaiBizLogic bizLogic;

    @Begin
    public String init() {

        bizLogic.init();
        return FORWARDNAME_INPUTKEY;
    }

    @Begin(renew = true)
    public String fromOtherFunctions() {
        bizLogic.init();
        bizLogic.pushSyoukaiBL();
        return FORWARDNAME_KEIYAKUNAIYOU;
    }

    @End
    public String tojiruBtnOnClick() {
        return null;
    }

    public String hubijkbtnbykeiyakunaiyouOnClick() {
        bizLogic.pushHubijkbtnbykeiyakunaiyouBL();
        return FORWARDNAME_HUBIJK;
    }

    public String hbtrjhbtnbykeiyakunaiyouOnClick() {
        bizLogic.pushHbtrjhBtnByKeiyakuNaiyouBL();
        return FORWARDNAME_HUBITRKINFO;
    }

    public String ktjkbtnbykeiyakunaiyouOnClick() {
        bizLogic.pushKtjkBtnByKeiyakuNaiyouBL();
        return FORWARDNAME_KETTEIJK;
    }

    public String nkjkbtnbykeiyakunaiyouOnClick() {
        bizLogic.pushNkjkBtnByKeiyakuNaiyouBL();
        return FORWARDNAME_NYUUKINJK;
    }

    public String kouteijkbtnbykeiyakunaiyouOnClick() {
        bizLogic.pushKouteijkBtnByKeiyakuNaiyouBL();
        return FORWARDNAME_KOUTEIJK;
    }

    public String srttjkbtnbykeiyakunaiyouOnClick() {
        bizLogic.pushSyoruiTtykBtnByKeiyakuNaiyouBL();
        return FORWARDNAME_SYORUITOUTYAKUJK;
    }

    public String tsrrkbtnbykeiyakunaiyouOnClick() {
        bizLogic.pushTsrrkBtnByKeiyakuNaiyouBL();
        return FORWARDNAME_TEISEIRRKLIST;
    }

    public String skininfobtnbykeiyakunaiyouOnClick() {
        bizLogic.pushSakuinInfoBtnByKeiyakuNaiyouBL();
        return FORWARDNAME_SAKUININFO;
    }

    public String kyknaiyoubtnbyhubijkOnClick() {
        bizLogic.pushKykNaiyouBtnByHubijkBL();
        return FORWARDNAME_KEIYAKUNAIYOU;
    }

    public String hubitourokuinfobtnbyhubijkOnClick() {
        bizLogic.pushHubiTourokuInfoBtnByHubijkBL();
        return FORWARDNAME_HUBITRKINFO;
    }

    public String ketteijyoukyoubtnbyhubijkOnClick() {
        bizLogic.pushKetteiJyoukyouBtnByHubijkBL();
        return FORWARDNAME_KETTEIJK;
    }

    public String nyuukinjyoukyoubtnbyhubijkOnClick() {
        bizLogic.pushNyuukinjyoukyouBtnByHubijkBL();
        return FORWARDNAME_NYUUKINJK;
    }

    public String kouteijkbtnbyhubijkOnClick() {
        bizLogic.pushKouteijkBtnByHubijkBL();
        return FORWARDNAME_KOUTEIJK;
    }

    public String srttjkbtnbyhubijkOnClick() {
        bizLogic.pushSyoruiTtykBtnByHubijkBL();
        return FORWARDNAME_SYORUITOUTYAKUJK;
    }

    public String tsrrkbtnbyhubijkOnClick() {
        bizLogic.pushTsrrkBtnByHubijkBL();
        return FORWARDNAME_TEISEIRRKLIST;
    }

    public String skininfobtnbyhubijkOnClick() {
        bizLogic.pushSakuinInfoBtnByHubijkBL();
        return FORWARDNAME_SAKUININFO;
    }

    public String kyknaiyoubtnbyhubitrkinfoOnClick() {
        bizLogic.pushKykNaiyouBtnByHubitrkinfoBL();
        return FORWARDNAME_KEIYAKUNAIYOU;
    }

    public String hubijkbtnbyhubitrkinfoOnClick() {
        bizLogic.pushHubijkBtnByHubitrkInfoBL();
        return FORWARDNAME_HUBIJK;
    }

    public String ktjkbtnbyhubitrkinfoOnClick() {
        bizLogic.pushKtjkBtnByHubitrkInfoBL();
        return FORWARDNAME_KETTEIJK;
    }

    public String nkjkbtnbyhubitrkinfoOnClick() {
        bizLogic.pushNkjkBtnByHubitrkInfoBL();
        return FORWARDNAME_NYUUKINJK;
    }

    public String kouteijkbtnbyhubitrkinfoOnClick() {
        bizLogic.pushKouteijkBtnByHubitrkInfoBL();
        return FORWARDNAME_KOUTEIJK;
    }

    public String srttjkbtnbyhubitrkinfoOnClick() {
        bizLogic.pushSyoruiTtykBtnByHubitrkInfoBL();
        return FORWARDNAME_SYORUITOUTYAKUJK;
    }

    public String tsrrkbtnbyhubitrkinfoOnClick() {
        bizLogic.pushTsrrkBtnByHubitrkInfoBL();
        return FORWARDNAME_TEISEIRRKLIST;
    }

    public String skininfobtnbyhubitrkinfoOnClick() {
        bizLogic.pushSakuinInfoBtnByHubitrkInfoBL();
        return FORWARDNAME_SAKUININFO;
    }

    public String kyknaiyoubtnbyketteijkOnClick() {
        bizLogic.pushKykNaiyouBtnByKetteijkBL();
        return FORWARDNAME_KEIYAKUNAIYOU;
    }

    public String hubijyoukyoubtnbyketteijkOnClick() {
        bizLogic.pushHubiJyoukyouBtnByKetteijkBL();
        return FORWARDNAME_HUBIJK;
    }

    public String hbtrjhbtnbyketteijkOnClick() {
        bizLogic.pushHbtrjhBtnByKetteijkBL();
        return FORWARDNAME_HUBITRKINFO;
    }

    public String nkjkbtnbyketteijkOnClick() {
        bizLogic.pushNkjkBtnByKetteijkBL();
        return FORWARDNAME_NYUUKINJK;
    }

    public String kouteijkbtnbyketteijkOnClick() {
        bizLogic.pushKouteijkBtnByKetteijkBL();
        return FORWARDNAME_KOUTEIJK;
    }

    public String srttjkbtnbyketteijkOnClick() {
        bizLogic.pushSyoruiTtykBtnByKetteijkBL();
        return FORWARDNAME_SYORUITOUTYAKUJK;
    }

    public String tsrrkbtnbyketteijkOnClick() {
        bizLogic.pushTsrrkBtnByKetteijkBL();
        return FORWARDNAME_TEISEIRRKLIST;
    }

    public String skininfobtnbyketteijkOnClick() {
        bizLogic.pushSakuinInfoBtnByKetteijkBL();
        return FORWARDNAME_SAKUININFO;
    }
    public String kyknaiyoubtnbynyuukinjkOnClick() {
        bizLogic.pushKykNaiyouBtnByNyuukinjkBL();
        return FORWARDNAME_KEIYAKUNAIYOU;
    }

    public String hubijyoukyoubtnbynyuukinjkOnClick() {
        bizLogic.pushHubiJyoukyouBtnByNyuukinjkBL();
        return FORWARDNAME_HUBIJK;
    }

    public String hbtrjhbtnbynyuukinjkOnClick() {
        bizLogic.pushHbtrjhBtnByNyuukinjkBL();
        return FORWARDNAME_HUBITRKINFO;
    }

    public String ktjkbtnbynyuukinjkOnClick() {
        bizLogic.pushKtjkBtnByNyuukinjkBL();
        return FORWARDNAME_KETTEIJK;
    }

    public String kouteijkbtnbynyuukinjkOnClick() {
        bizLogic.pushKouteijkBtnByNyuukinjkBL();
        return FORWARDNAME_KOUTEIJK;
    }

    public String srttjkbtnbynyuukinjkOnClick() {
        bizLogic.pushSyoruiTtykBtnByNyuukinjkBL();
        return FORWARDNAME_SYORUITOUTYAKUJK;
    }

    public String tsrrkbtnbynyuukinjkOnClick() {
        bizLogic.pushTsrrkBtnByNyuukinjkBL();
        return FORWARDNAME_TEISEIRRKLIST;
    }

    public String skininfobtnbynyuukinjkOnClick() {
        bizLogic.pushSakuinInfoBtnByNyuukinjkBL();
        return FORWARDNAME_SAKUININFO;
    }
    public String kyknybtnbysyoruitoutyakujkOnClick() {
        bizLogic.pushKyknyBtnBySyoruiToutyakujkBL();
        return FORWARDNAME_KEIYAKUNAIYOU;
    }

    public String hubijkbtnbysyoruitoutyakujkOnClick() {
        bizLogic.pushHubijkBtnBySyoruiToutyakujkBL();
        return FORWARDNAME_HUBIJK;
    }

    public String hbtrjhbtnbysyoruitoutyakujkOnClick() {
        bizLogic.pushHbtrjhBtnBySyoruiToutyakujkBL();
        return FORWARDNAME_HUBITRKINFO;
    }

    public String ktjkbtnbysyoruitoutyakujkOnClick() {
        bizLogic.pushKtjkBtnBySyoruiToutyakujkBL();
        return FORWARDNAME_KETTEIJK;
    }

    public String nkjkbtnbysyoruitoutyakujkOnClick() {
        bizLogic.pushNkjkBtnBySyoruiToutyakujkBL();
        return FORWARDNAME_NYUUKINJK;
    }


    public String kouteijkbtnbysrttjkOnClick() {
        bizLogic.pushKouteijkBtnBysyoruiToutyakujkBL();
        return FORWARDNAME_KOUTEIJK;
    }


    public String tsrrkbtnbysyoruitoutyakujkOnClick() {
        bizLogic.pushTsrrkBtnBysyoruiToutyakujkBL();
        return FORWARDNAME_TEISEIRRKLIST;
    }

    public String skininfobtnbysyoruittykjkOnClick() {
        bizLogic.pushSakuinInfoBtnBySyoruiToutyakujkBL();
        return FORWARDNAME_SAKUININFO;
    }

    public String hyoujilinkOnClick() {
        bizLogic.printHyoujiOut();
        return null;
    }

    public String allhyoujibtnOnClick() {
        bizLogic.printAllHyoujiOut();
        return null;
    }
    public String kyknaiyoubtnbyteiseirrklistOnClick() {
        bizLogic.pushKykNaiyouBtnByTeiseirrklistBL();
        return FORWARDNAME_KEIYAKUNAIYOU;
    }

    public String hubijkbtnbyteiseirrklistOnClick() {
        bizLogic.pushHubijkBtnByTeiseirrklistBL();
        return FORWARDNAME_HUBIJK;
    }

    public String hbtrjhbtnbyteiseirrklistOnClick() {
        bizLogic.pushHbtrjhBtnByteiseirrklistBL();
        return FORWARDNAME_HUBITRKINFO;
    }

    public String ktjkbtnbyteiseirrklistOnClick() {
        bizLogic.pushKtjkBtnByTeiseirrklistBL();
        return FORWARDNAME_KETTEIJK;
    }

    public String nkjkbtnbyteiseirrklistOnClick() {
        bizLogic.pushNkjkBtnbyTeiseirrklistBL();
        return FORWARDNAME_NYUUKINJK;
    }

    public String kouteijkbtnbyteiseirrklistOnClick() {
        bizLogic.pushKouteijkBtnbyTeiseirrklistBL();
        return FORWARDNAME_KOUTEIJK;
    }

    public String srttjkbtnbyteiseirrklistOnClick() {
        bizLogic.pushSyoruiTtykBtnByTeiseirrklistBL();
        return FORWARDNAME_SYORUITOUTYAKUJK;
    }

    public String skininfobtnbyteiseirrklistOnClick() {
        bizLogic.pushSakuinInfoBtnByTeiseirrklistBL();
        return FORWARDNAME_SAKUININFO;
    }

    public String kyknaiyoubtnbyskininfoOnClick() {
        bizLogic.pushKykNaiyouBtnBySakuinInfoBL();
        return FORWARDNAME_KEIYAKUNAIYOU;
    }

    public String hubijkbtnbyskininfoOnClick() {
        bizLogic.pushHubijkBtnBySakuinInfoBL();
        return FORWARDNAME_HUBIJK;
    }

    public String hbtrjhbtnbyskininfoOnClick() {
        bizLogic.pushHbtrjhBtnBySakuinInfoBL();
        return FORWARDNAME_HUBITRKINFO;
    }

    public String ktjkbtnbyskininfoOnClick() {
        bizLogic.pushKtjkBtnBySakuinInfoBL();
        return FORWARDNAME_KETTEIJK;
    }

    public String nkjkbtnbyskininfoOnClick() {
        bizLogic.pushNkjkBtnbySakuinInfoBL();
        return FORWARDNAME_NYUUKINJK;
    }

    public String kouteijkbtnbyskininfoOnClick() {
        bizLogic.pushKouteijkBtnbySakuinInfoBL();
        return FORWARDNAME_KOUTEIJK;
    }

    public String srttjkbtnbyskininfoOnClick() {
        bizLogic.pushSyoruiTtykBtnBySakuinInfoBL();
        return FORWARDNAME_SYORUITOUTYAKUJK;
    }

    public String tsrrkbtnbyskininfoOnClick() {
        bizLogic.pushTsrrkBtnBySakuinInfoBL();
        return FORWARDNAME_TEISEIRRKLIST;
    }

    public String kyknybtnbykouteijkOnClick() {
        bizLogic.pushKykNaiyouBtnByKouteijkBL();
        return FORWARDNAME_KEIYAKUNAIYOU;
    }

    public String hubijkbtnbykouteijkOnClick() {
        bizLogic.pushHubiJyoukyouBtnByKouteijkBL();
        return FORWARDNAME_HUBIJK;
    }

    public String hbtrjhbtnbykouteijkOnClick() {
        bizLogic.pushHbtrjhBtnByKouteijkBL();
        return FORWARDNAME_HUBITRKINFO;
    }

    public String ktjkbtnbykouteijkOnClick() {
        bizLogic.pushKtjkBtnByKouteijkBL();
        return FORWARDNAME_KETTEIJK;
    }

    public String nkjkbtnbykouteijkOnClick() {
        bizLogic.pushNyuukinjkBtnByKouteijkBL();
        return FORWARDNAME_NYUUKINJK;
    }

    public String srttjkbtnbykouteijkOnClick() {
        bizLogic.pushSyoruiTtykBtnByKouteijkBL();
        return FORWARDNAME_SYORUITOUTYAKUJK;
    }

    public String tsrrkbtnbykouteijkOnClick() {
        bizLogic.pushTsrrkBtnByKouteijkBL();
        return FORWARDNAME_TEISEIRRKLIST;
    }

    public String skininfobtnbykouteijkOnClick() {
        bizLogic.pushSakuinInfoBtnByKouteijkBL();
        return FORWARDNAME_SAKUININFO;
    }

    public String syoukaibtnOnClick() {
        bizLogic.pushSyoukaiBL();
        return FORWARDNAME_KEIYAKUNAIYOU;
    }

    public String searchBtnOnClick() {
        bizLogic.pushSearchBL();
        return FORWARDNAME_KENSAKURESULT;
    }

    public String dispmosnoOnClick() {
        bizLogic.pushDispMoshiNoBL();
        return FORWARDNAME_KEIYAKUNAIYOU;
    }

    public String modorubtnbykensakuOnClick() {
        bizLogic.clear();
        return FORWARDNAME_INPUTKEY;
    }

    public String modorubtnbykeiyakunaiyouOnClick() {
        E_SyoriKeiyu gmSyoriKbn = bizLogic.getModoruBtnForward();

        if (E_SyoriKeiyu.SYORI_KENSAKU.equals(gmSyoriKbn)) {
            bizLogic.clearForKensakuResult();
            return FORWARDNAME_KENSAKURESULT;
        }

        bizLogic.clear();
        return FORWARDNAME_INPUTKEY;
    }

    public String modorubtnbyhubijkOnClick() {
        E_SyoriKeiyu gmSyoriKbn = bizLogic.getModoruBtnForward();

        if (E_SyoriKeiyu.SYORI_KENSAKU.equals(gmSyoriKbn)) {
            bizLogic.clearForKensakuResult();
            return FORWARDNAME_KENSAKURESULT;
        }

        bizLogic.clear();
        return FORWARDNAME_INPUTKEY;
    }

    public String modorubtnbyhubitrkinfoOnClick() {
        E_SyoriKeiyu gmSyoriKbn = bizLogic.getModoruBtnForward();

        if (E_SyoriKeiyu.SYORI_KENSAKU.equals(gmSyoriKbn)) {
            bizLogic.clearForKensakuResult();
            return FORWARDNAME_KENSAKURESULT;
        }

        bizLogic.clear();
        return FORWARDNAME_INPUTKEY;
    }

    public String modorubtnbyketteijkOnClick() {
        E_SyoriKeiyu gmSyoriKbn = bizLogic.getModoruBtnForward();

        if (E_SyoriKeiyu.SYORI_KENSAKU.equals(gmSyoriKbn)) {
            bizLogic.clearForKensakuResult();
            return FORWARDNAME_KENSAKURESULT;
        }

        bizLogic.clear();
        return FORWARDNAME_INPUTKEY;
    }

    public String modorubtnbynyuukinjkOnClick() {
        E_SyoriKeiyu gmSyoriKbn = bizLogic.getModoruBtnForward();

        if (E_SyoriKeiyu.SYORI_KENSAKU.equals(gmSyoriKbn)) {
            bizLogic.clearForKensakuResult();
            return FORWARDNAME_KENSAKURESULT;
        }

        bizLogic.clear();
        return FORWARDNAME_INPUTKEY;
    }

    public String modorubtnbysyoruitoutyakujkOnClick() {
        E_SyoriKeiyu gmSyoriKbn = bizLogic.getModoruBtnForward();

        if (E_SyoriKeiyu.SYORI_KENSAKU.equals(gmSyoriKbn)) {
            bizLogic.clearForKensakuResult();
            return FORWARDNAME_KENSAKURESULT;
        }

        bizLogic.clear();
        return FORWARDNAME_INPUTKEY;
    }

    public String modorubtnbyteiseirrklistOnClick() {
        E_SyoriKeiyu gmSyoriKbn = bizLogic.getModoruBtnForward();

        if (E_SyoriKeiyu.SYORI_KENSAKU.equals(gmSyoriKbn)) {
            bizLogic.clearForKensakuResult();
            return FORWARDNAME_KENSAKURESULT;
        }

        bizLogic.clear();
        return FORWARDNAME_INPUTKEY;
    }

    public String modorubtnbysakuininfoOnClick() {
        bizLogic.pushModoruBtnBySakuinInfoBL();
        E_SyoriKeiyu gmSyoriKbn = bizLogic.getModoruBtnForward();

        if (E_SyoriKeiyu.SYORI_KENSAKU.equals(gmSyoriKbn)) {
            bizLogic.clearForKensakuResult();
            return FORWARDNAME_KENSAKURESULT;
        }

        bizLogic.clear();
        return FORWARDNAME_INPUTKEY;
    }

    public String modorubtnbykouteijkOnClick() {
        E_SyoriKeiyu gmSyoriKbn = bizLogic.getModoruBtnForward();

        if (E_SyoriKeiyu.SYORI_KENSAKU.equals(gmSyoriKbn)) {
            bizLogic.clearForKensakuResult();
            return FORWARDNAME_KENSAKURESULT;
        }

        bizLogic.clear();
        return FORWARDNAME_INPUTKEY;
    }

    public String kensakuKekkaPagerOnClick() {
        return FORWARDNAME_CURRENT;
    }

}