package yuyu.app.workflow.processkanri.sinkeiyakuworklist;

import static yuyu.app.workflow.processkanri.sinkeiyakuworklist.GenSinkeiyakuWorkListConstants.*;
import static yuyu.app.workflow.processkanri.sinkeiyakuworklist.SinkeiyakuWorkListConstants.*;

import javax.inject.Inject;

import jp.co.slcs.swak.web.auth.permission.Roles;
import jp.co.slcs.swak.web.config.annotations.Forward;
import jp.co.slcs.swak.web.config.annotations.Forwards;
import jp.co.slcs.swak.web.config.annotations.Input;
import jp.co.slcs.swak.web.config.annotations.UIBean;
import jp.co.slcs.swak.web.conversation.annotations.Begin;
import jp.co.slcs.swak.web.conversation.annotations.End;
import yuyu.def.classification.C_TaskKbn;

/**
 * 新契約工程ワークリスト 機能のアクションクラスです。
 */
@Forwards

({
    @Forward(name=FORWARDNAME_INIT,                      page=PAGENO_INIT,                  path="/workflow/processkanri/sinkeiyakuworklist/SinkeiyakuWorkList.do", redirect=true),
    @Forward(name=FORWARDNAME_CURRENT,                                                      path="/workflow/processkanri/sinkeiyakuworklist/sinkeiyaku_work_list.jsp"),
    @Forward(name=FORWARDNAME_INPUTKEYTSKSNTKSNKYK,      page=PAGENO_INPUTKEYTSKSNTKSNKYK,  path="/workflow/processkanri/sinkeiyakuworklist/sinkeiyaku_work_list.jsp"),
    @Forward(name=FORWARDNAME_INPUTKEYANKNITRNSNKYK,     page=PAGENO_INPUTKEYANKNITRNSNKYK, path="/workflow/processkanri/sinkeiyakuworklist/sinkeiyaku_work_list.jsp"),
    @Forward(name=FORWARDNAME_ERROR,                                                        path="/workflow/processkanri/sinkeiyakuworklist/SinkeiyakuWorkList.do?_eventHandler=error", redirect=true),
    @Forward(name=FORWARDNAME_GOTOSKMOUSIKOMISYO,                                           path="/sinkeiyaku/skmousikomi/skmousikomisyo/SkMousikomisyo.do?_eventHandler=fromSinkeiyakuWorkList", redirect=true),
    @Forward(name=FORWARDNAME_GOTOSKKOKUTISYO,                                              path="/sinkeiyaku/skmousikomi/skkokutisyo/SkKokutisyo.do?_eventHandler=fromSinkeiyakuWorkList", redirect=true),
    @Forward(name=FORWARDNAME_GOTOSKKANKYOUSATEI,                                           path="/sinkeiyaku/skkettei/skkankyousatei/SkKankyouSatei.do?_eventHandler=fromSinkeiyakuWorkList", redirect=true),
    @Forward(name=FORWARDNAME_GOTOSKTORIKESI,                                               path="/sinkeiyaku/skkettei/skkankyousatei/SkKankyouSatei.do?_eventHandler=fromSinkeiyakuWorkListMousikomitorikesi", redirect=true),
    @Forward(name=FORWARDNAME_GOTOSKIMUSATEI,                                               path="/sinkeiyaku/skkettei/skimusatei/SkImuSatei.do?_eventHandler=fromSinkeiyakuWorkList", redirect=true),
    @Forward(name=FORWARDNAME_GOTOSKKEIYAKUKAKUNINKEKKA,                                    path="/sinkeiyaku/skkettei/skkeiyakukakuninkekka/SkKeiyakuKakuninKekka.do?_eventHandler=fromSinkeiyakuWorkList", redirect=true),
    @Forward(name=FORWARDNAME_GOTOSKHENKIN,                                                 path="/sinkeiyaku/sknyuukin/skhenkin/SkHenkin.do?_eventHandler=fromSinkeiyakuWorkList", redirect=true),
    @Forward(name=FORWARDNAME_GOTOSKMOUSIKOMITENKEN,                                        path="/sinkeiyaku/skmousikomi/skmousikomitenken/SkMousikomiTenken.do?_eventHandler=fromSinkeiyakuWorkList", redirect=true),
    @Forward(name=FORWARDNAME_GOTOSKHUBITOUROKU,                                            path="/sinkeiyaku/skhubikanri/skhubitouroku/SkHubiTouroku.do?_eventHandler=fromSinkeiyakuWorkList", redirect=true),
    @Forward(name=FORWARDNAME_GOTOSKHUBIKAISYOU,                                            path="/sinkeiyaku/skhubikanri/skhubikaisyou/SkHubiKaisyou.do?_eventHandler=fromSinkeiyakuWorkList", redirect=true),
})
@Input("/workflow/processkanri/sinkeiyakuworklist/sinkeiyaku_work_list.jsp")
@UIBean(beanClass=SinkeiyakuWorkListUiBean.class)
@Roles("sinkeiyakuworklist")
public class SinkeiyakuWorkListAction {

    @Inject
    private SinkeiyakuWorkListBizLogic bizLogic;

    @Begin
    public String init() {

        bizLogic.init();
        return FORWARDNAME_INPUTKEYTSKSNTKSNKYK;
    }

    public String fromHozenWorkListTest() {
        bizLogic.fromHozenWorkListTest();

        return FORWARDNAME_CURRENT;
    }

    @End(nested = true)
    public String error() {

        bizLogic.messageManagerClear();

        bizLogic.dispErrorMessages();

        bizLogic.setExceptionInstance(null);

        return FORWARDNAME_CURRENT;
    }

    public String fromSkMousikomisyo() {
        bizLogic.fromHozenWorkListTest();
        if (bizLogic.isError()) {
            return FORWARDNAME_ERROR;
        }
        return FORWARDNAME_CURRENT;
    }

    public String fromSkKokutisyo() {
        bizLogic.fromHozenWorkListTest();
        if (bizLogic.isError()) {
            return FORWARDNAME_ERROR;
        }
        return FORWARDNAME_CURRENT;
    }

    public String fromSkMousikomiTenken() {
        bizLogic.fromHozenWorkListTest();
        if (bizLogic.isError()) {
            return FORWARDNAME_ERROR;
        }
        return FORWARDNAME_CURRENT;
    }

    public String fromSkHubiTouroku() {
        bizLogic.fromHozenWorkListTest();
        if (bizLogic.isError()) {
            return FORWARDNAME_ERROR;
        }
        return FORWARDNAME_CURRENT;
    }

    public String fromSkHubiKaisyou() {
        bizLogic.fromHozenWorkListTest();
        if (bizLogic.isError()) {
            return FORWARDNAME_ERROR;
        }
        return FORWARDNAME_CURRENT;
    }

    public String fromSkKankyouSatei() {
        bizLogic.fromHozenWorkListTest();
        if (bizLogic.isError()) {
            return FORWARDNAME_ERROR;
        }
        return FORWARDNAME_CURRENT;
    }

    public String fromSkImuSatei() {
        bizLogic.fromHozenWorkListTest();
        if (bizLogic.isError()) {
            return FORWARDNAME_ERROR;
        }
        return FORWARDNAME_CURRENT;
    }

    public String fromSkKeiyakuKakuninKekka() {
        bizLogic.fromHozenWorkListTest();
        if (bizLogic.isError()) {
            return FORWARDNAME_ERROR;
        }
        return FORWARDNAME_CURRENT;
    }

    public String fromSkHenkin() {
        bizLogic.fromHozenWorkListTest();
        if (bizLogic.isError()) {
            return FORWARDNAME_ERROR;
        }
        return FORWARDNAME_CURRENT;
    }

    @End
    public String tojiruBtnOnClick() {
        return null;
    }

    public String joukenHozonBtnOnClick() {
        bizLogic.joukenHozonBtnOnClick();
        return FORWARDNAME_CURRENT;
    }

    public String saisetteiBtnOnClick() {
        bizLogic.saisetteiBtnOnClick();
        return FORWARDNAME_CURRENT;
    }

    public String searchBtnOnClick() {
        bizLogic.searchBtnOnClick();
        return FORWARDNAME_CURRENT;
    }

    @Begin(nested=true)
    public String kojinNyuuryokuLinkOnClick() {
        String transitionMappingName = bizLogic.taskSntkNyuuryokuLinkOnClick(C_TaskKbn.KOJIN);
        if (transitionMappingName == null){
            return FORWARDNAME_CURRENT;
        }

        return transitionMappingName;
    }

    public String kojinItiranLinkOnClick() {
        String transitionName = bizLogic.itiranLinkOnClick(C_TaskKbn.KOJIN);
        if (transitionName == null){
            return FORWARDNAME_CURRENT;
        }

        return FORWARDNAME_INPUTKEYANKNITRNSNKYK;
    }

    @Begin(nested=true)
    public String kyouyouNyuuryokuLinkOnClick() {
        String transitionMappingName = bizLogic.taskSntkNyuuryokuLinkOnClick(C_TaskKbn.KYOUYUU);
        if (transitionMappingName == null){
            return FORWARDNAME_CURRENT;
        }

        return transitionMappingName;
    }

    public String kyouyouItiranLinkOnClick() {
        String transitionName = bizLogic.itiranLinkOnClick(C_TaskKbn.KYOUYUU);
        if (transitionName == null){
            return FORWARDNAME_CURRENT;
        }

        return FORWARDNAME_INPUTKEYANKNITRNSNKYK;
    }

    @Begin(nested=true)
    public String nyuuryokuLinkOnClick() {
        return bizLogic.anknItrnNyuuryokuLinkOnClick();
    }

    public String modorubtnOnClick() {
        bizLogic.modorubtnOnClick();
        return FORWARDNAME_INPUTKEYTSKSNTKSNKYK;
    }

    public String resultInfoItiranPagerOnClick() {
        bizLogic.resultInfoItiranPagerOnClick();
        return FORWARDNAME_CURRENT;
    }
}
