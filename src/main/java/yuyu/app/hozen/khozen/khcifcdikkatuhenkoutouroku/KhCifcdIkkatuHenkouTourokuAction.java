package yuyu.app.hozen.khozen.khcifcdikkatuhenkoutouroku;

import static yuyu.app.hozen.khozen.khcifcdikkatuhenkoutouroku.GenKhCifcdIkkatuHenkouTourokuConstants.*;

import javax.inject.Inject;

import jp.co.slcs.swak.web.config.annotations.Forward;
import jp.co.slcs.swak.web.config.annotations.Forwards;
import jp.co.slcs.swak.web.config.annotations.Input;
import jp.co.slcs.swak.web.config.annotations.UIBean;
import jp.co.slcs.swak.web.conversation.annotations.Begin;
import jp.co.slcs.swak.web.conversation.annotations.Begin.Mode;
import jp.co.slcs.swak.web.conversation.annotations.End;
import yuyu.app.hozen.khozen.khcifcdikkatuhenkoutouroku.KhCifcdIkkatuHenkouTourokuConstants.E_SyoriKubun;

/**
 * ＣＩＦコード一括変更登録 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,          page=PAGENO_INIT,          path="/hozen/khozen/khcifcdikkatuhenkoutouroku/KhCifcdIkkatuHenkouTouroku.do", redirect=true),
    @Forward(name=FORWARDNAME_INPUTKEY,      page=PAGENO_INPUTKEY,      path="/hozen/khozen/khcifcdikkatuhenkoutouroku/kh_cifcd_ikkatu_henkou_touroku.jsp"),
    @Forward(name=FORWARDNAME_INPUTCONTENTS, page=PAGENO_INPUTCONTENTS, path="/hozen/khozen/khcifcdikkatuhenkoutouroku/kh_cifcd_ikkatu_henkou_touroku.jsp"),
    @Forward(name=FORWARDNAME_CONFIRM,       page=PAGENO_CONFIRM,       path="/hozen/khozen/khcifcdikkatuhenkoutouroku/kh_cifcd_ikkatu_henkou_touroku.jsp"),
    @Forward(name=FORWARDNAME_RESULT,        page=PAGENO_RESULT,        path="/hozen/khozen/khcifcdikkatuhenkoutouroku/kh_cifcd_ikkatu_henkou_touroku.jsp"),
})
@Input("/hozen/khozen/khcifcdikkatuhenkoutouroku/kh_cifcd_ikkatu_henkou_touroku.jsp")
@UIBean(beanClass=KhCifcdIkkatuHenkouTourokuUiBean.class)
public class KhCifcdIkkatuHenkouTourokuAction {

    @Inject
    private KhCifcdIkkatuHenkouTourokuBizLogic bizLogic;

    @Inject
    private KhCifcdIkkatuHenkouTourokuUiBean uiBean;

    public String init() {

        bizLogic.init();
        return FORWARDNAME_INPUTKEY;
    }

    @End
    public String tojiruBtnOnClick() {
        return null;
    }

    @Begin
    public String tourokuBtnOnClick() {

        bizLogic.pushTourokuBL();
        return FORWARDNAME_INPUTCONTENTS;
    }

    @Begin(mode=Mode.DELETE)
    public String sakujyoBtnOnClick() {

        bizLogic.pushSakujyoBL();

        return FORWARDNAME_CONFIRM;
    }

    @End
    public String modoruBtnByInputContentsOnClick() {
        return FORWARDNAME_INIT;
    }

    public String kakuninBtnOnClick() {

        bizLogic.pushKakuninBL();

        return FORWARDNAME_CONFIRM;
    }

    @End(mode=Mode.DELETE)
    public String modoruBtnByConfirmOnClick() {

        if (E_SyoriKubun.SAKUJYO.equals(uiBean.getSyoriKuben())) {
            return FORWARDNAME_INIT;
        }

        bizLogic.pushModoruByConfirmBL();

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

    @End
    public String functionNameOnClick() {
        return FORWARDNAME_INIT;
    }
}
