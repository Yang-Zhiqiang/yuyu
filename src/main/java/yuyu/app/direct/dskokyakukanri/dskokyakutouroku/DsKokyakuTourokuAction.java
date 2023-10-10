package yuyu.app.direct.dskokyakukanri.dskokyakutouroku;

import static yuyu.app.direct.dskokyakukanri.dskokyakutouroku.GenDsKokyakuTourokuConstants.*;

import javax.inject.Inject;

import jp.co.slcs.swak.web.config.annotations.Forward;
import jp.co.slcs.swak.web.config.annotations.Forwards;
import jp.co.slcs.swak.web.config.annotations.Input;
import jp.co.slcs.swak.web.config.annotations.UIBean;
import jp.co.slcs.swak.web.conversation.annotations.Begin;
import jp.co.slcs.swak.web.conversation.annotations.End;

/**
 * 顧客登録 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,          page=PAGENO_INIT,          path="/direct/dskokyakukanri/dskokyakutouroku/DsKokyakuTouroku.do", redirect=true),
    @Forward(name=FORWARDNAME_INPUTKEY,      page=PAGENO_INPUTKEY,      path="/direct/dskokyakukanri/dskokyakutouroku/ds_kokyaku_touroku.jsp"),
    @Forward(name=FORWARDNAME_INPUTCONTENTS, page=PAGENO_INPUTCONTENTS, path="/direct/dskokyakukanri/dskokyakutouroku/ds_kokyaku_touroku.jsp"),
    @Forward(name=FORWARDNAME_CONFIRM,       page=PAGENO_CONFIRM,       path="/direct/dskokyakukanri/dskokyakutouroku/ds_kokyaku_touroku.jsp"),
    @Forward(name=FORWARDNAME_RESULT,        page=PAGENO_RESULT,        path="/direct/dskokyakukanri/dskokyakutouroku/ds_kokyaku_touroku.jsp"),
})
@Input("/direct/dskokyakukanri/dskokyakutouroku/ds_kokyaku_touroku.jsp")
@UIBean(beanClass=DsKokyakuTourokuUiBean.class)
public class DsKokyakuTourokuAction {

    @Inject
    private DsKokyakuTourokuBizLogic bizLogic;

    public String init() {

        bizLogic.init();
        return FORWARDNAME_INPUTKEY;
    }

    @End
    public String tojiruBtnOnClick() {
        return null;
    }

    @Begin
    public String nyuuryokubtnOnClick() {
        bizLogic.getKokyakuInfo();
        return FORWARDNAME_INPUTCONTENTS;
    }

    @End
    public String modoruBtnByInputContentsOnClick() {
        return FORWARDNAME_INIT;
    }


    public String kakuninBtnOnClick() {
        bizLogic.checkKokyakuInfo();
        return FORWARDNAME_CONFIRM;
    }

    public String modoruBtnByConfirmOnClick() {
        bizLogic.recoverMessage();
        return FORWARDNAME_INPUTCONTENTS;
    }

    @End
    public String kakuteiBtnOnClick() {
        bizLogic.confirmKokyakuInfo();
        return FORWARDNAME_RESULT;
    }

    public String syokigamenheBtnOnClick() {
        return FORWARDNAME_INIT;
    }
}
