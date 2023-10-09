package yuyu.app.direct.dskokyakukanri.dstrhkservicetouroku;

import static yuyu.app.direct.dskokyakukanri.dstrhkservicetouroku.GenDsTrhkServiceTourokuConstants.*;

import javax.inject.Inject;

import jp.co.slcs.swak.web.config.annotations.Forward;
import jp.co.slcs.swak.web.config.annotations.Forwards;
import jp.co.slcs.swak.web.config.annotations.Input;
import jp.co.slcs.swak.web.config.annotations.UIBean;
import jp.co.slcs.swak.web.conversation.annotations.Begin;
import jp.co.slcs.swak.web.conversation.annotations.End;

/**
 * 取引サービス登録 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,           page=PAGENO_INIT,           path="/direct/dskokyakukanri/dstrhkservicetouroku/DsTrhkServiceTouroku.do", redirect=true),
    @Forward(name=FORWARDNAME_CURRENT,                                    path="/direct/dskokyakukanri/dstrhkservicetouroku/ds_trhk_service_touroku.jsp"),
    @Forward(name=FORWARDNAME_INPUTKEYSELECT, page=PAGENO_INPUTKEYSELECT, path="/direct/dskokyakukanri/dstrhkservicetouroku/ds_trhk_service_touroku.jsp"),
    @Forward(name=FORWARDNAME_INPUTCONTENTS,  page=PAGENO_INPUTCONTENTS,  path="/direct/dskokyakukanri/dstrhkservicetouroku/ds_trhk_service_touroku.jsp"),
    @Forward(name=FORWARDNAME_CONFIRM,        page=PAGENO_CONFIRM,        path="/direct/dskokyakukanri/dstrhkservicetouroku/ds_trhk_service_touroku.jsp"),
    @Forward(name=FORWARDNAME_RESULT,         page=PAGENO_RESULT,         path="/direct/dskokyakukanri/dstrhkservicetouroku/ds_trhk_service_touroku.jsp"),
})
@Input("/direct/dskokyakukanri/dstrhkservicetouroku/ds_trhk_service_touroku.jsp")
@UIBean(beanClass=DsTrhkServiceTourokuUiBean.class)
public class DsTrhkServiceTourokuAction {

    @Inject
    private DsTrhkServiceTourokuBizLogic bizLogic;

    @Begin
    public String init() {

        bizLogic.init();
        return FORWARDNAME_INPUTKEYSELECT;
    }

    @Begin(renew = true)
    public String fromOtherFunctions() {

        bizLogic.init();
        return FORWARDNAME_INPUTKEYSELECT;
    }

    @End
    public String tojiruBtnOnClick() {
        return null;
    }

    public String itijinyuuryokubtnOnClick() {

        bizLogic.pushItijiNyuuryokuBL();

        return FORWARDNAME_INPUTCONTENTS;
    }

    public String nijinyuuryokubtnOnClick() {

        bizLogic.pushNijiNyuuryokuBL();

        return FORWARDNAME_INPUTCONTENTS;
    }

    public String syoukaibtnOnClick() {

        bizLogic.pushSyoukaiBL();

        return FORWARDNAME_INPUTCONTENTS;
    }

    public String torikesiBtnOnClick() {

        bizLogic.pushTorikesiBL();

        return FORWARDNAME_INPUTCONTENTS;
    }

    public String searchbtnbyinputkeyselectOnClick() {

        bizLogic.pushSearchBL();

        return FORWARDNAME_INPUTKEYSELECT;
    }

    public String dsnyuuryokulinkOnClick() {

        bizLogic.pushDsNyuuryokuLinkBL();

        return FORWARDNAME_INPUTCONTENTS;
    }
    public String modoruBtnByInputContentsOnClick() {

        bizLogic.pushModoruBtnByInputContentsBL();

        return FORWARDNAME_INPUTKEYSELECT;
    }

    public String kakuninBtnOnClick() {

        bizLogic.pushKakuninBL();

        return FORWARDNAME_CONFIRM;
    }

    public String modoruBtnByConfirmOnClick() {

        bizLogic.pushModoruBtnByConfirm();

        return FORWARDNAME_INPUTCONTENTS;
    }

    @End
    public String kakuteiBtnOnClick() {

        bizLogic.pushKakuteiBL();

        return FORWARDNAME_RESULT;
    }

    public String syokigamenhebtnbyresultOnClick() {
        return FORWARDNAME_INIT;
    }

    public String trhkServiceInfoPagerOnClick() {
        return FORWARDNAME_CURRENT;
    }
}
