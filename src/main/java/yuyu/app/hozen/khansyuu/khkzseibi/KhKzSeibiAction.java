package yuyu.app.hozen.khansyuu.khkzseibi;

import static yuyu.app.hozen.khansyuu.khkzseibi.GenKhKzSeibiConstants.*;

import javax.inject.Inject;

import jp.co.slcs.swak.web.config.annotations.Forward;
import jp.co.slcs.swak.web.config.annotations.Forwards;
import jp.co.slcs.swak.web.config.annotations.Input;
import jp.co.slcs.swak.web.config.annotations.UIBean;
import jp.co.slcs.swak.web.conversation.annotations.Begin;
import jp.co.slcs.swak.web.conversation.annotations.End;
import yuyu.common.biz.bzcommon.BizUiBeanBackupUtil;

/**
 * 口座整備処理 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,          page=PAGENO_INIT,          path="/hozen/khansyuu/khkzseibi/KhKzSeibi.do", redirect=true),
    @Forward(name=FORWARDNAME_INPUTKEY,      page=PAGENO_INPUTKEY,      path="/hozen/khansyuu/khkzseibi/kh_kz_seibi.jsp"),
    @Forward(name=FORWARDNAME_INPUTCONTENTS, page=PAGENO_INPUTCONTENTS, path="/hozen/khansyuu/khkzseibi/kh_kz_seibi.jsp"),
    @Forward(name=FORWARDNAME_CONFIRM,       page=PAGENO_CONFIRM,       path="/hozen/khansyuu/khkzseibi/kh_kz_seibi.jsp"),
    @Forward(name=FORWARDNAME_RESULT,        page=PAGENO_RESULT,        path="/hozen/khansyuu/khkzseibi/kh_kz_seibi.jsp"),
})
@Input("/hozen/khansyuu/khkzseibi/kh_kz_seibi.jsp")
@UIBean(beanClass=KhKzSeibiUiBean.class)
public class KhKzSeibiAction {

    @Inject
    private KhKzSeibiBizLogic bizLogic;

    @Inject
    private KhKzSeibiUiBean uiBean;

    @Inject
    private InputContentsCopyBean inputContentsCopyBean;

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
        bizLogic.pushNyuuryokuBL();
        return FORWARDNAME_INPUTCONTENTS;
    }

    @End
    public String modoruBtnByInputContentsOnClick() {
        return FORWARDNAME_INIT;
    }

    public String kakuninBtnOnClick() {
        BizUiBeanBackupUtil.backup(uiBean, inputContentsCopyBean);
        bizLogic.pushKakuninBL();
        return FORWARDNAME_CONFIRM;
    }

    public String modoruBtnByConfirmOnClick() {
        BizUiBeanBackupUtil.restore(uiBean, inputContentsCopyBean);
        return FORWARDNAME_INPUTCONTENTS;
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
