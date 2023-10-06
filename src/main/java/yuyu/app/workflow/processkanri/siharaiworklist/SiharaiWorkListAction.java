package yuyu.app.workflow.processkanri.siharaiworklist;

import static yuyu.app.workflow.processkanri.siharaiworklist.GenSiharaiWorkListConstants.*;

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
 * 保険金給付金支払工程ワークリスト 機能のアクションクラスです。
 */

@Forwards

({
    @Forward(name=FORWARDNAME_INIT,                       page=PAGENO_INIT,                   path="/workflow/processkanri/siharaiworklist/SiharaiWorkList.do", redirect=true),
    @Forward(name=FORWARDNAME_CURRENT,                                                        path="/workflow/processkanri/siharaiworklist/siharai_work_list.jsp"),
    @Forward(name=FORWARDNAME_INPUTKEYTSKSNTKHKNSHR,      page=PAGENO_INPUTKEYTSKSNTKHKNSHR,  path="/workflow/processkanri/siharaiworklist/siharai_work_list.jsp"),
    @Forward(name=FORWARDNAME_INPUTKEYANKNITRNHKNSHR,     page=PAGENO_INPUTKEYANKNITRNHKNSHR, path="/workflow/processkanri/siharaiworklist/siharai_work_list.jsp"),
    @Forward(name=FORWARDNAME_ERROR,                                                          path="/workflow/processkanri/siharaiworklist/SiharaiWorkList.do?_eventHandler=error", redirect=true),
    @Forward(name=FORWARDNAME_GOTOSISEIKYUUUKETUKESB,                                         path="/siharai/siskuke/siseikyuuuketukesb/SiSeikyuuUketukeSb.do?_eventHandler=fromSiharaiWorkList", redirect=true),
    @Forward(name=FORWARDNAME_GOTOSISATEISB,                                                  path="/siharai/sisatei/sisateisb/SiSateiSb.do?_eventHandler=fromSiharaiWorkList", redirect=true),
    @Forward(name=FORWARDNAME_GOTOSIHUBITOUROKU,                                              path="/siharai/sihubikanri/sihubitouroku/SiHubiTouroku.do?_eventHandler=fromSiharaiWorkList", redirect=true),
    @Forward(name=FORWARDNAME_GOTOSIHUBIKAISYOU,                                              path="/siharai/sihubikanri/sihubikaisyou/SiHubiKaisyou.do?_eventHandler=fromSiharaiWorkList", redirect=true),
    @Forward(name=FORWARDNAME_GOTOSISINDANSYORYOUSIHARAI,                                     path="/siharai/sisatei/sisindansyoryousiharai/SiSindansyoryouSiharai.do?_eventHandler=fromSiharaiWorkList", redirect=true),
})
@Input("/workflow/processkanri/siharaiworklist/siharai_work_list.jsp")
@UIBean(beanClass=SiharaiWorkListUiBean.class)
@Roles("siharaiworklist")
public class SiharaiWorkListAction {

    @Inject
    private SiharaiWorkListBizLogic bizLogic;

    @Begin
    public String init() {

        bizLogic.init();
        return FORWARDNAME_INPUTKEYTSKSNTKHKNSHR;
    }

    @End(nested = true)
    public String error() {

        bizLogic.messageManagerClear();

        bizLogic.dispErrorMessages();

        bizLogic.setExceptionInstance(null);

        return FORWARDNAME_CURRENT;
    }

    public String fromHozenWorkListTest() {
        return init();
    }

    public String fromSiHubiTouroku() {
        bizLogic.fromHozenWorkListTest();
        if (bizLogic.isError()) {
            return FORWARDNAME_ERROR;
        }
        return FORWARDNAME_CURRENT;
    }

    public String fromSiHubiKaisyou() {
        bizLogic.fromHozenWorkListTest();
        if (bizLogic.isError()) {
            return FORWARDNAME_ERROR;
        }
        return FORWARDNAME_CURRENT;
    }

    public String fromSiSateiSb() {
        bizLogic.fromHozenWorkListTest();
        if (bizLogic.isError()) {
            return FORWARDNAME_ERROR;
        }
        return FORWARDNAME_CURRENT;
    }

    public String fromSiSeikyuuUketukeSb() {
        bizLogic.fromHozenWorkListTest();
        if (bizLogic.isError()) {
            return FORWARDNAME_ERROR;
        }
        return FORWARDNAME_CURRENT;
    }

    public String fromSiSindansyoryouSiharai() {
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

        return FORWARDNAME_INPUTKEYANKNITRNHKNSHR;
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

        return FORWARDNAME_INPUTKEYANKNITRNHKNSHR;
    }

    @Begin(nested=true)
    public String nyuuryokuLinkOnClick() {
        return bizLogic.anknItrnNyuuryokuLinkOnClick();
    }

    public String modorubtnOnClick() {
        bizLogic.modorubtnOnClick();
        return FORWARDNAME_INPUTKEYTSKSNTKHKNSHR;
    }

    public String resultInfoItiranPagerOnClick() {
        return FORWARDNAME_CURRENT;
    }
}
