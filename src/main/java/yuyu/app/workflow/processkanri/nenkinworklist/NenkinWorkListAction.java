package yuyu.app.workflow.processkanri.nenkinworklist;

import static yuyu.app.workflow.processkanri.nenkinworklist.GenNenkinWorkListConstants.*;

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
 * 年金支払工程ワークリスト 機能のアクションクラスです。
 */
@Forwards

({
    @Forward(name=FORWARDNAME_INIT,                     page=PAGENO_INIT,                  path="/workflow/processkanri/nenkinworklist/NenkinWorkList.do", redirect=true),
    @Forward(name=FORWARDNAME_CURRENT,                                                     path="/workflow/processkanri/nenkinworklist/nenkin_work_list.jsp"),
    @Forward(name=FORWARDNAME_INPUTKEYTSKSNTKNKSHR,     page=PAGENO_INPUTKEYTSKSNTKNKSHR,  path="/workflow/processkanri/nenkinworklist/nenkin_work_list.jsp"),
    @Forward(name=FORWARDNAME_INPUTKEYANKNITRNNKSHR,    page=PAGENO_INPUTKEYANKNITRNNKSHR, path="/workflow/processkanri/nenkinworklist/nenkin_work_list.jsp"),
    @Forward(name=FORWARDNAME_ERROR,                                                       path="/workflow/processkanri/nenkinworklist/NenkinWorkList.do?_eventHandler=error", redirect=true),
    @Forward(name=FORWARDNAME_GOTONKSIHARAI,                                               path="/nenkin/nksiharai/nksiharai/NkSiharai.do?_eventHandler=fromNenkinWorkList", redirect=true),
    @Forward(name=FORWARDNAME_GOTONKSIBOU,                                                 path="/nenkin/nkhenkou/nksibou/NkSibou.do?_eventHandler=fromNenkinWorkList", redirect=true),
    @Forward(name=FORWARDNAME_GOTONKMEIGIJYUUSYOHENKOU,                                    path="/nenkin/nkhenkou/nkmeigijyuusyohenkou/NkMeigiJyuusyoHenkou.do?_eventHandler=fromNenkinWorkList", redirect=true),
    @Forward(name=FORWARDNAME_GOTONKKAISUUHENKOU,                                          path="/nenkin/nkhenkou/nkkaisuuhenkou/NkKaisuuHenkou.do?_eventHandler=fromNenkinWorkList", redirect=true),
    @Forward(name=FORWARDNAME_GOTONKKOUZAHENKOU,                                           path="/nenkin/nkhenkou/nkkouzahenkou/NkKouzaHenkou.do?_eventHandler=fromNenkinWorkList", redirect=true),
    @Forward(name=FORWARDNAME_GOTONKSAIHAKKOU,                                             path="/nenkin/nkhenkou/nksaihakkou/NkSaihakkou.do?_eventHandler=fromNenkinWorkList", redirect=true),
    @Forward(name=FORWARDNAME_GOTONKTOKUYAKUHENKOU,                                        path="/nenkin/nkhenkou/nktokuyakuhenkou/NkTokuyakuHenkou.do?_eventHandler=fromNenkinWorkList", redirect=true),
    @Forward(name=FORWARDNAME_GOTONKHUBITOUROKU,                                           path="/nenkin/nkhubikanri/nkhubitouroku/NkHubiTouroku.do?_eventHandler=fromNenkinWorkList", redirect=true),
    @Forward(name=FORWARDNAME_GOTONKHUBIKAISYOU,                                           path="/nenkin/nkhubikanri/nkhubikaisyou/NkHubiKaisyou.do?_eventHandler=fromNenkinWorkList", redirect=true),
})
@Input("/workflow/processkanri/nenkinworklist/nenkin_work_list.jsp")
@UIBean(beanClass = NenkinWorkListUiBean.class)
@Roles("nenkinworklist")
public class NenkinWorkListAction {

    @Inject
    private NenkinWorkListBizLogic bizLogic;

    @Begin
    public String init() {

        bizLogic.init();
        return FORWARDNAME_INPUTKEYTSKSNTKNKSHR;
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

    public String fromNkSiharai() {
        bizLogic.fromHozenWorkListTest();
        if (bizLogic.isError()) {
            return FORWARDNAME_ERROR;
        }
        return FORWARDNAME_CURRENT;
    }

    public String fromNkHubiKaisyou() {
        bizLogic.fromHozenWorkListTest();
        if (bizLogic.isError()) {
            return FORWARDNAME_ERROR;
        }
        return FORWARDNAME_CURRENT;
    }

    public String fromNkHubiTouroku() {
        bizLogic.fromHozenWorkListTest();
        if (bizLogic.isError()) {
            return FORWARDNAME_ERROR;
        }
        return FORWARDNAME_CURRENT;
    }

    public String fromNkSibou() {
        bizLogic.fromHozenWorkListTest();
        if (bizLogic.isError()) {
            return FORWARDNAME_ERROR;
        }
        return FORWARDNAME_CURRENT;
    }

    public String fromNkMeigiJyuusyoHenkou() {
        bizLogic.fromHozenWorkListTest();
        if (bizLogic.isError()) {
            return FORWARDNAME_ERROR;
        }
        return FORWARDNAME_CURRENT;
    }

    public String fromNkKaisuuHenkou() {
        bizLogic.fromHozenWorkListTest();
        if (bizLogic.isError()) {
            return FORWARDNAME_ERROR;
        }
        return FORWARDNAME_CURRENT;
    }

    public String fromNkKouzaHenkou() {
        bizLogic.fromHozenWorkListTest();
        if (bizLogic.isError()) {
            return FORWARDNAME_ERROR;
        }
        return FORWARDNAME_CURRENT;
    }

    public String fromNkSaihakkou() {
        bizLogic.fromHozenWorkListTest();
        if (bizLogic.isError()) {
            return FORWARDNAME_ERROR;
        }
        return FORWARDNAME_CURRENT;
    }

    public String fromNkTokuyakuHenkou() {
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

    @Begin(nested = true)
    public String kojinNyuuryokuLinkOnClick() {

        String transitionMappingName = bizLogic.taskSntkNyuuryokuLinkOnClick(C_TaskKbn.KOJIN);

        if (transitionMappingName == null) {
            return FORWARDNAME_CURRENT;
        }

        return transitionMappingName;
    }

    public String kojinItiranLinkOnClick() {
        String transitionName = bizLogic.itiranLinkOnClick(C_TaskKbn.KOJIN);
        if (transitionName == null) {
            return FORWARDNAME_CURRENT;
        }

        return FORWARDNAME_INPUTKEYANKNITRNNKSHR;
    }

    @Begin(nested = true)
    public String kyouyouNyuuryokuLinkOnClick() {

        String transitionMappingName = bizLogic.taskSntkNyuuryokuLinkOnClick(C_TaskKbn.KYOUYUU);
        if (transitionMappingName == null) {
            return FORWARDNAME_CURRENT;
        }

        return transitionMappingName;
    }

    public String kyouyouItiranLinkOnClick() {
        String transitionName = bizLogic.itiranLinkOnClick(C_TaskKbn.KYOUYUU);
        if (transitionName == null) {
            return FORWARDNAME_CURRENT;
        }

        return FORWARDNAME_INPUTKEYANKNITRNNKSHR;
    }

    @Begin(nested = true)
    public String nyuuryokuLinkOnClick() {
        return bizLogic.anknItrnNyuuryokuLinkOnClick();
    }

    public String modorubtnOnClick() {
        bizLogic.modorubtnOnClick();
        return FORWARDNAME_INPUTKEYTSKSNTKNKSHR;
    }

    public String resultInfoItiranPagerOnClick() {
        return FORWARDNAME_CURRENT;
    }
}
