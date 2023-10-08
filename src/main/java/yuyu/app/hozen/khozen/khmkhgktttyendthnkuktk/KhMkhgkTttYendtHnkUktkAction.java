package yuyu.app.hozen.khozen.khmkhgktttyendthnkuktk;

import static yuyu.app.hozen.khozen.khmkhgktttyendthnkuktk.GenKhMkhgkTttYendtHnkUktkConstants.*;

import javax.inject.Inject;

import jp.co.slcs.swak.web.config.annotations.Forward;
import jp.co.slcs.swak.web.config.annotations.Forwards;
import jp.co.slcs.swak.web.config.annotations.Input;
import jp.co.slcs.swak.web.config.annotations.UIBean;
import jp.co.slcs.swak.web.conversation.annotations.Begin;
import jp.co.slcs.swak.web.conversation.annotations.End;
import yuyu.common.biz.bzcommon.BizUiBeanBackupUtil;

/**
 * 目標額到達時円建変更受付 機能のアクションクラスです。
 */
@Forwards({
    @Forward(name = FORWARDNAME_INIT, page = PAGENO_INIT, path = "/hozen/khozen/khmkhgktttyendthnkuktk/KhMkhgkTttYendtHnkUktk.do", redirect = true),
    @Forward(name = FORWARDNAME_INPUTKEY, page = PAGENO_INPUTKEY, path = "/hozen/khozen/khmkhgktttyendthnkuktk/kh_mkhgk_ttt_yendt_hnk_uktk.jsp"),
    @Forward(name = FORWARDNAME_REFERENCE, page = PAGENO_REFERENCE, path = "/hozen/khozen/khmkhgktttyendthnkuktk/kh_mkhgk_ttt_yendt_hnk_uktk.jsp"),
    @Forward(name = FORWARDNAME_CONFIRM, page = PAGENO_CONFIRM, path = "/hozen/khozen/khmkhgktttyendthnkuktk/kh_mkhgk_ttt_yendt_hnk_uktk.jsp"),
    @Forward(name = FORWARDNAME_RESULT, page = PAGENO_RESULT, path = "/hozen/khozen/khmkhgktttyendthnkuktk/kh_mkhgk_ttt_yendt_hnk_uktk.jsp"),
})
@Input("/hozen/khozen/khmkhgktttyendthnkuktk/kh_mkhgk_ttt_yendt_hnk_uktk.jsp")
@UIBean(beanClass = KhMkhgkTttYendtHnkUktkUiBean.class)
public class KhMkhgkTttYendtHnkUktkAction {

    @Inject
    private KhMkhgkTttYendtHnkUktkBizLogic bizLogic;

    @Inject
    private KhMkhgkTttYendtHnkUktkUiBean uiBean;

    @Inject
    private ReferenceCopyBean referenceBean;

    public String init() {

        bizLogic.init();

        return FORWARDNAME_INPUTKEY;
    }

    @End
    public String tojiruBtnOnClick() {

        return null;
    }

    @Begin
    public String syoukaibtnbyinputkeyOnClick() {

        bizLogic.pushSyoukaiBL();

        return FORWARDNAME_REFERENCE;
    }

    @End
    public String modorubtnOnClick() {

        return FORWARDNAME_INIT;
    }

    public String kakuninBtnOnClick() {

        BizUiBeanBackupUtil.backup(uiBean, referenceBean);

        bizLogic.pushKakuninBL();

        return FORWARDNAME_CONFIRM;
    }

    public String modoruBtnByConfirmOnClick() {

        BizUiBeanBackupUtil.restore(uiBean, referenceBean);

        return FORWARDNAME_REFERENCE;
    }

    @End
    public String kakuteiBtnOnClick() {

        bizLogic.pushKakuteiBL();

        return FORWARDNAME_RESULT;
    }

    public String syokigamenheBtnOnClick() {

        return FORWARDNAME_INIT;
    }
}
