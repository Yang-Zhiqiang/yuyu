package yuyu.app.hozen.khnayose.khsakuinnmnosyuusei;

import static yuyu.app.hozen.khnayose.khsakuinnmnosyuusei.GenKhSakuinnmnoSyuuseiConstants.*;

import javax.inject.Inject;

import jp.co.slcs.swak.web.auth.permission.Roles;
import jp.co.slcs.swak.web.config.annotations.Forward;
import jp.co.slcs.swak.web.config.annotations.Forwards;
import jp.co.slcs.swak.web.config.annotations.Input;
import jp.co.slcs.swak.web.config.annotations.UIBean;
import jp.co.slcs.swak.web.conversation.annotations.Begin;
import jp.co.slcs.swak.web.conversation.annotations.End;

/**
 * 契約保全索引名番号修正 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,          page=PAGENO_INIT,          path="/hozen/khnayose/khsakuinnmnosyuusei/KhSakuinnmnoSyuusei.do", redirect=true),
    @Forward(name=FORWARDNAME_INPUTKEY,      page=PAGENO_INPUTKEY,      path="/hozen/khnayose/khsakuinnmnosyuusei/kh_sakuinnmno_syuusei.jsp"),
    @Forward(name=FORWARDNAME_INPUTCONTENTS, page=PAGENO_INPUTCONTENTS, path="/hozen/khnayose/khsakuinnmnosyuusei/kh_sakuinnmno_syuusei.jsp"),
    @Forward(name=FORWARDNAME_CONFIRM,       page=PAGENO_CONFIRM,       path="/hozen/khnayose/khsakuinnmnosyuusei/kh_sakuinnmno_syuusei.jsp"),
    @Forward(name=FORWARDNAME_RESULT,        page=PAGENO_RESULT,        path="/hozen/khnayose/khsakuinnmnosyuusei/kh_sakuinnmno_syuusei.jsp"),
})
@Input("/hozen/khnayose/khsakuinnmnosyuusei/kh_sakuinnmno_syuusei.jsp")
@UIBean(beanClass=KhSakuinnmnoSyuuseiUiBean.class)
@Roles("khsakuinnmnosyuusei")
public class KhSakuinnmnoSyuuseiAction {

    @Inject
    private KhSakuinnmnoSyuuseiBizLogic bizLogic;

    public String init() {

        bizLogic.init();
        return FORWARDNAME_INPUTKEY;
    }

    @End
    public String tojiruBtnOnClick() {
        return null;
    }

    @Begin
    public String ketteiBtnOnClick() {
        bizLogic.pushKetteiBL();
        return FORWARDNAME_INPUTCONTENTS;
    }

    @End
    public String modoruBtnByInputContentsOnClick() {
        return FORWARDNAME_INIT;
    }

    public String kakuninBtnOnClick() {
        bizLogic.pushKakuninBL();
        return FORWARDNAME_CONFIRM;
    }

    public String modoruBtnByConfirmOnClick() {
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
