package yuyu.app.hozen.khansyuu.khkariuketeisei;

import static yuyu.app.hozen.khansyuu.khkariuketeisei.GenKhKariukeTeiseiConstants.*;

import javax.inject.Inject;

import jp.co.slcs.swak.web.config.annotations.Forward;
import jp.co.slcs.swak.web.config.annotations.Forwards;
import jp.co.slcs.swak.web.config.annotations.Input;
import jp.co.slcs.swak.web.config.annotations.UIBean;
import jp.co.slcs.swak.web.conversation.annotations.Begin;
import jp.co.slcs.swak.web.conversation.annotations.End;
import jp.co.slcs.swak.web.conversation.annotations.MultiPostConstraints;
import yuyu.common.biz.bzcommon.BizUiBeanBackupUtil;

/**
 * 仮受訂正 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,          page=PAGENO_INIT,          path="/hozen/khansyuu/khkariuketeisei/KhKariukeTeisei.do", redirect=true),
    @Forward(name=FORWARDNAME_INPUTKEY,      page=PAGENO_INPUTKEY,      path="/hozen/khansyuu/khkariuketeisei/kh_kariuke_teisei.jsp"),
    @Forward(name=FORWARDNAME_INPUTCONTENTS, page=PAGENO_INPUTCONTENTS, path="/hozen/khansyuu/khkariuketeisei/kh_kariuke_teisei.jsp"),
    @Forward(name=FORWARDNAME_CONFIRM,       page=PAGENO_CONFIRM,       path="/hozen/khansyuu/khkariuketeisei/kh_kariuke_teisei.jsp"),
    @Forward(name=FORWARDNAME_RESULT,        page=PAGENO_RESULT,        path="/hozen/khansyuu/khkariuketeisei/kh_kariuke_teisei.jsp"),
})
@Input("/hozen/khansyuu/khkariuketeisei/kh_kariuke_teisei.jsp")
@UIBean(beanClass=KhKariukeTeiseiUiBean.class)
public class KhKariukeTeiseiAction {

    @Inject
    private KhKariukeTeiseiBizLogic bizLogic;

    @Inject
    private KhKariukeTeiseiUiBean uiBean;

    @Inject
    private InputContentsCopyBean contentsCopyBean;

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
        bizLogic.pushInputBL();
        return FORWARDNAME_INPUTCONTENTS;
    }

    @End
    public String modoruBtnByInputContentsOnClick() {
        return FORWARDNAME_INIT;
    }

    public String kakuninBtnOnClick() {
        BizUiBeanBackupUtil.backup(uiBean,contentsCopyBean);
        bizLogic.pushKakuninBL();
        return FORWARDNAME_CONFIRM;
    }

    public String modoruBtnByConfirmOnClick() {
        BizUiBeanBackupUtil.restore(uiBean, contentsCopyBean);
        return FORWARDNAME_INPUTCONTENTS;
    }

    @MultiPostConstraints
    public String kakuteiBtnOnClick() {
        bizLogic.pushKakuteiBL();
        return FORWARDNAME_RESULT;
    }

    @End
    public String syokigamenheBtnOnClick() {
        return FORWARDNAME_INIT;
    }

    //    @MultiPostConstraints
    //    public void print () {
    //        bizLogic.printOut();
    //    }
}
