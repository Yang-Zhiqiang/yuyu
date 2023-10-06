package yuyu.app.workflow.processkanri.hozenworklist;

import static yuyu.app.workflow.processkanri.hozenworklist.GenHozenWorkListConstants.*;

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
 * 契約保全工程ワークリスト 機能のアクションクラスです。
 */
@Forwards

({
    @Forward(name=FORWARDNAME_INIT,                   page=PAGENO_INIT,                   path="/workflow/processkanri/hozenworklist/HozenWorkList.do", redirect=true),
    @Forward(name=FORWARDNAME_CURRENT,                                                    path="/workflow/processkanri/hozenworklist/hozen_work_list.jsp"),
    @Forward(name=FORWARDNAME_INPUTKEYTSKSNTKKYKHZN,  page=PAGENO_INPUTKEYTSKSNTKKYKHZN,  path="/workflow/processkanri/hozenworklist/hozen_work_list.jsp"),
    @Forward(name=FORWARDNAME_INPUTKEYANKNITRNKYKHZN, page=PAGENO_INPUTKEYANKNITRNKYKHZN, path="/workflow/processkanri/hozenworklist/hozen_work_list.jsp"),
    @Forward(name=FORWARDNAME_ERROR,                                                                 path="/workflow/processkanri/hozenworklist/HozenWorkList.do?_eventHandler=error", redirect=true),
    @Forward(name=FORWARDNAME_GOTOKHJYUUSYOHENKOU,                                        path="/hozen/khozen/khjyuusyohenkou/KhJyuusyoHenkou.do?_eventHandler=fromHozenWorkList", redirect=true),
    @Forward(name=FORWARDNAME_GOTOKHHUBITOUROKU,                                          path="/hozen/khhubikanri/khhubitouroku/KhHubiTouroku.do?_eventHandler=fromHozenWorkList", redirect=true),
    @Forward(name=FORWARDNAME_GOTOKHHUBIKAISYOU,                                          path="/hozen/khhubikanri/khhubikaisyou/KhHubiKaisyou.do?_eventHandler=fromHozenWorkList", redirect=true),
    @Forward(name=FORWARDNAME_GOTOKHKAIYAKU,                                              path="/hozen/khozen/khkaiyaku/KhKaiyaku.do?_eventHandler=fromHozenWorkList", redirect=true),
    @Forward(name=FORWARDNAME_GOTOKHSYOUKENSAIHAKKOU,                                     path="/hozen/khozen/khsyoukensaihakkou/KhSyoukenSaihakkou.do?_eventHandler=fromHozenWorkList", redirect=true),
    @Forward(name=FORWARDNAME_GOTOKHMEIGIHENKOU,                                                     path="/hozen/khozen/khmeigihenkou/KhMeigiHenkou.do?_eventHandler=fromHozenWorkList", redirect=true),
    @Forward(name=FORWARDNAME_GOTOKHSITEIDAIRITOKUYAKUHUKA,                                          path="/hozen/khozen/khsiteidairitokuyakuhuka/KhSiteidairiTokuyakuHuka.do?_eventHandler=fromHozenWorkList", redirect=true),
    @Forward(name=FORWARDNAME_GOTOKHGENGAKU,                                                         path="/hozen/khozen/khgengaku/KhGengaku.do?_eventHandler=fromHozenWorkList", redirect=true),
    @Forward(name=FORWARDNAME_GOTOKHTARGETTOKUYAKUHENKOU,                                            path="/hozen/khozen/khtargettokuyakuhenkou/KhTargetTokuyakuHenkou.do?_eventHandler=fromHozenWorkList", redirect=true),
    @Forward(name=FORWARDNAME_GOTOKHNENKINSIHARAITOKUYAKUHENKOU,                                     path="/hozen/khozen/khnenkinsiharaitokuyakuhenkou/KhNenkinSiharaiTokuyakuHenkou.do?_eventHandler=fromHozenWorkList", redirect=true),
    @Forward(name=FORWARDNAME_GOTOKHSEINENGAPPISEITEISEI,                                            path="/hozen/khozen/khseinengappiseiteisei/KhSeinengappiSeiTeisei.do?_eventHandler=fromHozenWorkList", redirect=true),
    @Forward(name=FORWARDNAME_GOTOKHSIHARAIKOUZAHENKOU,                                              path="/hozen/khozen/khsiharaikouzahenkou/KhSiharaiKouzaHenkou.do?_eventHandler=fromHozenWorkList", redirect=true),
    @Forward(name=FORWARDNAME_GOTOKHKEIYAKUTORIKESI,                                                 path="/hozen/khozen/khkeiyakutorikesi/KhKeiyakuTorikesi.do?_eventHandler=fromHozenWorkList", redirect=true),
    @Forward(name=FORWARDNAME_GOTOKHKAIGOMAEBARAITKHENKOU,                                           path="/hozen/khozen/khkaigomaebaraitkhenkou/KhKaigomaebaraiTkHenkou.do?_eventHandler=fromHozenWorkList", redirect=true),
    @Forward(name=FORWARDNAME_GOTOKHMKHGKHENKOU,                                                     path="/hozen/khozen/khmkhgkhenkou/KhMkhgkHenkou.do?_eventHandler=fromHozenWorkList", redirect=true),
    @Forward(name=FORWARDNAME_GOTOKHYENDTHNKHRSHR,                                                   path="/hozen/khozen/khyendthnkhrshr/KhYendtHnkHrShr.do?_eventHandler=fromHozenWorkList", redirect=true),
    @Forward(name=FORWARDNAME_GOTOKHTMTTKINITEN,                                                     path="/hozen/khozen/khtmttkiniten/KhTmttkinIten.do?_eventHandler=fromHozenWorkList", redirect=true),
    @Forward(name=FORWARDNAME_GOTOKHHARAIKATAHENKOU,                                                 path="/hozen/khansyuu/khharaikatahenkou/KhHaraikataHenkou.do?_eventHandler=fromHozenWorkList", redirect=true),
    @Forward(name=FORWARDNAME_GOTOKHDSHR,                                                            path="/hozen/khozen/khdshr/KhDShr.do?_eventHandler=fromHozenWorkList", redirect=true),
    @Forward(name=FORWARDNAME_GOTOKHYENDTHNKUKTKNINI,                                                path="/hozen/khozen/khyendthnkuktknini/KhYendtHnkUktkNini.do?_eventHandler=fromHozenWorkList", redirect=true),
    @Forward(name=FORWARDNAME_GOTOKHKZKTRKKYKDRHNK,                                                  path="/hozen/khozen/khkzktrkkykdrhnk/KhKzktrkKykdrHnk.do?_eventHandler=fromHozenWorkList", redirect=true),
})
@Input("/workflow/processkanri/hozenworklist/hozen_work_list.jsp")
@UIBean(beanClass=HozenWorkListUiBean.class)
@Roles("hozenworklist")
public class HozenWorkListAction {

    @Inject
    private HozenWorkListBizLogic bizLogic;

    @Begin
    public String init() {

        bizLogic.init();
        return FORWARDNAME_INPUTKEYTSKSNTKKYKHZN;
    }


    public String fromHozenWorkListTest() {
        return init();
    }

    @End(nested = true)
    public String error() {

        bizLogic.messageManagerClear();

        bizLogic.dispErrorMessages();

        bizLogic.setExceptionInstance(null);

        return FORWARDNAME_CURRENT;
    }

    public String fromKhHubiTouroku() {
        bizLogic.fromKeiyakuHozen();
        if (bizLogic.isError()) {
            return FORWARDNAME_ERROR;
        }
        return FORWARDNAME_CURRENT;
    }

    public String fromKhHubiKaisyou() {
        bizLogic.fromKeiyakuHozen();
        if (bizLogic.isError()) {
            return FORWARDNAME_ERROR;
        }
        return FORWARDNAME_CURRENT;
    }

    public String fromKhJyuusyoHenkou() {
        bizLogic.fromKeiyakuHozen();
        if (bizLogic.isError()) {
            return FORWARDNAME_ERROR;
        }
        return FORWARDNAME_CURRENT;
    }

    public String fromKhMeigiHenkou() {
        bizLogic.fromKeiyakuHozen();
        if (bizLogic.isError()) {
            return FORWARDNAME_ERROR;
        }
        return FORWARDNAME_CURRENT;
    }

    public String fromKhSiteidairiTokuyakuHuka() {
        bizLogic.fromKeiyakuHozen();
        if (bizLogic.isError()) {
            return FORWARDNAME_ERROR;
        }
        return FORWARDNAME_CURRENT;
    }

    public String fromKhKaiyaku() {
        bizLogic.fromKeiyakuHozen();
        if (bizLogic.isError()) {
            return FORWARDNAME_ERROR;
        }
        return FORWARDNAME_CURRENT;
    }

    public String fromKhGengaku() {
        bizLogic.fromKeiyakuHozen();
        if (bizLogic.isError()) {
            return FORWARDNAME_ERROR;
        }
        return FORWARDNAME_CURRENT;
    }

    public String fromKhTargetTokuyakuHenkou() {
        bizLogic.fromKeiyakuHozen();
        if (bizLogic.isError()) {
            return FORWARDNAME_ERROR;
        }
        return FORWARDNAME_CURRENT;
    }

    public String fromKhNenkinSiharaiTokuyakuHenkou() {
        bizLogic.fromKeiyakuHozen();
        if (bizLogic.isError()) {
            return FORWARDNAME_ERROR;
        }
        return FORWARDNAME_CURRENT;
    }

    public String fromKhSeinengappiSeiTeisei() {
        bizLogic.fromKeiyakuHozen();
        if (bizLogic.isError()) {
            return FORWARDNAME_ERROR;
        }
        return FORWARDNAME_CURRENT;
    }

    public String fromKhSyoukenSaihakkou() {
        bizLogic.fromKeiyakuHozen();
        if (bizLogic.isError()) {
            return FORWARDNAME_ERROR;
        }
        return FORWARDNAME_CURRENT;
    }

    public String fromKhSiharaiKouzaHenkou() {
        bizLogic.fromKeiyakuHozen();
        if (bizLogic.isError()) {
            return FORWARDNAME_ERROR;
        }
        return FORWARDNAME_CURRENT;
    }

    public String fromKhKeiyakuTorikesi() {
        bizLogic.fromKeiyakuHozen();
        if (bizLogic.isError()) {
            return FORWARDNAME_ERROR;
        }
        return FORWARDNAME_CURRENT;
    }

    public String fromKhNaiyouKakunin() {
        bizLogic.fromKeiyakuHozen();
        if (bizLogic.isError()) {
            return FORWARDNAME_ERROR;
        }
        return FORWARDNAME_CURRENT;
    }

    public String fromKhKaigomaebaraiTkHenkou() {
        bizLogic.fromKeiyakuHozen();
        if (bizLogic.isError()) {
            return FORWARDNAME_ERROR;
        }
        return FORWARDNAME_CURRENT;
    }

    public String fromKhMkhgkHenkou() {
        bizLogic.fromKeiyakuHozen();
        if (bizLogic.isError()) {
            return FORWARDNAME_ERROR;
        }
        return FORWARDNAME_CURRENT;
    }

    public String fromKhYendtHnkHrShr() {
        bizLogic.fromKeiyakuHozen();
        if (bizLogic.isError()) {
            return FORWARDNAME_ERROR;
        }
        return FORWARDNAME_CURRENT;
    }

    public String fromKhTmttkinIten() {
        bizLogic.fromKeiyakuHozen();
        if (bizLogic.isError()) {
            return FORWARDNAME_ERROR;
        }
        return FORWARDNAME_CURRENT;
    }

    public String fromKhHaraikataHenkou() {
        bizLogic.fromKeiyakuHozen();
        if (bizLogic.isError()) {
            return FORWARDNAME_ERROR;
        }
        return FORWARDNAME_CURRENT;
    }

    public String fromKhDShr() {
        bizLogic.fromKeiyakuHozen();
        if (bizLogic.isError()) {
            return FORWARDNAME_ERROR;
        }
        return FORWARDNAME_CURRENT;
    }

    public String fromKhYendtHnkUktkNini() {
        bizLogic.fromKeiyakuHozen();
        if (bizLogic.isError()) {
            return FORWARDNAME_ERROR;
        }
        return FORWARDNAME_CURRENT;
    }

    public String fromKhKzktrkKykdrHnk() {
        bizLogic.fromKeiyakuHozen();
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

        String transitionMappingName =  bizLogic.taskSntkNyuuryokuLinkOnClick(C_TaskKbn.KOJIN);
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

        return FORWARDNAME_INPUTKEYANKNITRNKYKHZN;
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

        return FORWARDNAME_INPUTKEYANKNITRNKYKHZN;
    }

    @Begin(nested=true)
    public String nyuuryokuLinkOnClick() {
        return bizLogic.anknItrnNyuuryokuLinkOnClick();
    }

    public String modorubtnOnClick() {
        bizLogic.modorubtnOnClick();
        return FORWARDNAME_INPUTKEYTSKSNTKKYKHZN;
    }

    public String resultInfoItiranPagerOnClick() {
        return FORWARDNAME_CURRENT;
    }
}
