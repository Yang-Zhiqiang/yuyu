package yuyu.app.siharai.siskuke.siseikyuuuketukesb;

import static yuyu.app.siharai.siskuke.siseikyuuuketukesb.GenSiSeikyuuUketukeSbConstants.*;

import javax.inject.Inject;

import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.web.annotation.BizAppExceptionTerminate;
import jp.co.slcs.swak.web.auth.permission.Roles;
import jp.co.slcs.swak.web.config.annotations.Forward;
import jp.co.slcs.swak.web.config.annotations.Forwards;
import jp.co.slcs.swak.web.config.annotations.Input;
import jp.co.slcs.swak.web.config.annotations.UIBean;
import jp.co.slcs.swak.web.conversation.annotations.Begin;
import jp.co.slcs.swak.web.conversation.annotations.End;
import jp.co.slcs.swak.web.conversation.annotations.MultiPostConstraints;

/**
 * （死亡）請求受付 機能のアクションクラスです。
 */
@Forwards({
    @Forward(name = FORWARDNAME_INIT, page = PAGENO_INIT, path = "/siharai/siskuke/siseikyuuuketukesb/SiSeikyuuUketukeSb.do", redirect = true),
    @Forward(name = FORWARDNAME_INPUTKEY, page = PAGENO_INPUTKEY, path = "/siharai/siskuke/siseikyuuuketukesb/si_seikyuu_uketuke_sb.jsp"),
    @Forward(name = FORWARDNAME_INPUTCONTENTS, page = PAGENO_INPUTCONTENTS, path = "/siharai/siskuke/siseikyuuuketukesb/si_seikyuu_uketuke_sb.jsp"),
    @Forward(name = FORWARDNAME_CONFIRM, page = PAGENO_CONFIRM, path = "/siharai/siskuke/siseikyuuuketukesb/si_seikyuu_uketuke_sb.jsp"),
    @Forward(name = FORWARDNAME_RESULT, page = PAGENO_RESULT, path = "/siharai/siskuke/siseikyuuuketukesb/si_seikyuu_uketuke_sb.jsp"),
    @Forward(name = FORWARDNAME_BACKTOWORKLIST, path = "/workflow/processkanri/siharaiworklist/SiharaiWorkList.do?_eventHandler=fromSiSeikyuuUketukeSb", redirect = true),
})
@Input("/siharai/siskuke/siseikyuuuketukesb/si_seikyuu_uketuke_sb.jsp")
@UIBean(beanClass = SiSeikyuuUketukeSbUiBean.class)
@Roles("siseikyuuuketukesb")
public class SiSeikyuuUketukeSbAction {

    @Inject
    private SiSeikyuuUketukeSbBizLogic bizLogic;

    @Inject
    private SiSeikyuuUketukeSbUiBean uiBean;

    @Begin
    public String init() {

        bizLogic.init();
        return FORWARDNAME_INPUTKEY;
    }

    @Roles("sittzkrirekisyoukai")
    public String fromSiTtzkRirekiSyoukai() {
        String path = bizLogic.pushFromSiSeikyuuUketukeSbBL();
        return path;
    }

    public String fromSiharaiWorkList() {

        String path = "";
        try {
            path = bizLogic.pushFromSiharaiWorkListBL();
        } catch (BizLogicException exception) {

            uiBean.getBzWorkflowInfo().setExceptionToRenkeiInfo(exception);

            bizLogic.pushUnlockProcessBL();

            return FORWARDNAME_BACKTOWORKLIST;
        }
        return path;
    }

    @End
    public String tojiruBtnOnClick() {
        bizLogic.pushUnlockProcessBL();
        return null;
    }

    @End(nested = true)
    public String functionNameOnClick() {

        String path = bizLogic.pushFunctionNameBL();

        return path;
    }

    public String ketteiBtnOnClick() {
        String path = bizLogic.pushKetteiBL();

        return path;
    }

    @End(nested = true)
    @Roles({ "siseikyuuuketukesb.input", "siseikyuuuketukesb.tenken" })
    public String modoruBtnByInputContentsOnClick() {

        String path = bizLogic.pushModoruByInputContentsBL();

        return path;
    }

    @Roles({ "siseikyuuuketukesb.input", "siseikyuuuketukesb.tenken" })
    public String kakuninBtnOnClick() {

        String path = bizLogic.pushKakuninBL();

        return path;
    }

    @Roles({ "siseikyuuuketukesb.input", "siseikyuuuketukesb.tenken" })
    public String modoruBtnByConfirmOnClick() {

        String path = bizLogic.pushModoruByConfirmBL();

        return path;
    }

    @MultiPostConstraints
    @Roles({ "siseikyuuuketukesb.input", "siseikyuuuketukesb.tenken" })
    public String kakuteiBtnOnClick() {
        String path = "";
        try {
            path = bizLogic.pushKakuteiBL();
        } catch (BizLogicException exception) {
            bizLogic.pushUnlockProcessBL();
            throw exception;
        }
        return path;
    }

    @End(nested = true)
    @Roles({ "siseikyuuuketukesb.input", "siseikyuuuketukesb.tenken" })
    public String syokigamenheBtnOnClick() {

        String path = bizLogic.pushSyokigamenheBL();

        return path;
    }


    @BizAppExceptionTerminate
    private void bizAppExceptionTerminate(Throwable e) {
        bizLogic.pushUnlockProcessBL();
    }
}
