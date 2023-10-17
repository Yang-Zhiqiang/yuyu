package yuyu.app.sinkeiyaku.sksonota.sktetudukityuui;

import static yuyu.app.sinkeiyaku.sksonota.sktetudukityuui.GenSkTetudukiTyuuiConstants.*;

import javax.inject.Inject;

import jp.co.slcs.swak.web.annotation.BizAppExceptionTerminate;
import jp.co.slcs.swak.web.auth.permission.Roles;
import jp.co.slcs.swak.web.config.annotations.Forward;
import jp.co.slcs.swak.web.config.annotations.Forwards;
import jp.co.slcs.swak.web.config.annotations.Input;
import jp.co.slcs.swak.web.config.annotations.UIBean;
import jp.co.slcs.swak.web.conversation.annotations.Begin;
import jp.co.slcs.swak.web.conversation.annotations.End;

/**
 * 新契約手続注意設定 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,          page=PAGENO_INIT,          path="/sinkeiyaku/sksonota/sktetudukityuui/SkTetudukiTyuui.do", redirect=true),
    @Forward(name=FORWARDNAME_INPUTKEY,      page=PAGENO_INPUTKEY,      path="/sinkeiyaku/sksonota/sktetudukityuui/sk_tetuduki_tyuui.jsp"),
    @Forward(name=FORWARDNAME_INPUTCONTENTS, page=PAGENO_INPUTCONTENTS, path="/sinkeiyaku/sksonota/sktetudukityuui/sk_tetuduki_tyuui.jsp"),
    @Forward(name=FORWARDNAME_CONFIRM,       page=PAGENO_CONFIRM,       path="/sinkeiyaku/sksonota/sktetudukityuui/sk_tetuduki_tyuui.jsp"),
    @Forward(name=FORWARDNAME_RESULT,        page=PAGENO_RESULT,        path="/sinkeiyaku/sksonota/sktetudukityuui/sk_tetuduki_tyuui.jsp"),
})
@Input("/sinkeiyaku/sksonota/sktetudukityuui/sk_tetuduki_tyuui.jsp")
@UIBean(beanClass=SkTetudukiTyuuiUiBean.class)
@Roles("sktetudukityuui")
public class SkTetudukiTyuuiAction {

    @Inject
    private SkTetudukiTyuuiBizLogic bizLogic;

    public String init() {

        bizLogic.init();
        return FORWARDNAME_INPUTKEY;
    }

    @End
    public String tojiruBtnOnClick() {
        bizLogic.doUnlockProcess();
        return null;
    }

    public String addbtnbytoriatukaityuuiinfoOnClick() {
        return FORWARDNAME_INPUTCONTENTS;
    }

    public String addbtnbysonotatyuuiinfoOnClick() {
        return FORWARDNAME_INPUTCONTENTS;
    }

    @Begin
    public String tourokuBtnOnClick() {
        bizLogic.pushTourokuBL();
        bizLogic.createToriatukaiList();
        bizLogic.createSonotaList();
        return FORWARDNAME_INPUTCONTENTS;
    }

    @End
    public String modoruBtnByInputContentsOnClick() {
        bizLogic.doUnlockProcess();
        bizLogic.pushModoruByInputContentsBL();
        return FORWARDNAME_INIT;
    }

    public String kakuninBtnOnClick() {
        bizLogic.doContinueLockProcess();
        bizLogic.listClean();
        bizLogic.pushKakuninBL();
        return FORWARDNAME_CONFIRM;
    }

    public String modoruBtnByConfirmOnClick() {
        bizLogic.doContinueLockProcess();
        bizLogic.createToriatukaiList();
        bizLogic.createSonotaList();
        return FORWARDNAME_INPUTCONTENTS;
    }

    @End
    public String kakuteiBtnOnClick() {
        bizLogic.doContinueLockProcess();
        bizLogic.pushKakuteiBL();
        bizLogic.doUnlockProcess();
        return FORWARDNAME_RESULT;
    }

    public String syokigamenheBtnOnClick() {
        return FORWARDNAME_INIT;
    }

    @End
    public String functionNameOnClick() {
        bizLogic.doUnlockProcess();
        return FORWARDNAME_INIT;
    }


    @BizAppExceptionTerminate
    private void bizAppExceptionTerminate(Throwable e) {

        bizLogic.doUnlockProcess();
    }
}
