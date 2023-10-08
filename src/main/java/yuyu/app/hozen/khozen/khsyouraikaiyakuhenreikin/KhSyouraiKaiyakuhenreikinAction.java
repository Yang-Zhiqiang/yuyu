package yuyu.app.hozen.khozen.khsyouraikaiyakuhenreikin;

import static yuyu.app.hozen.khozen.khsyouraikaiyakuhenreikin.GenKhSyouraiKaiyakuhenreikinConstants.*;

import java.io.IOException;

import javax.inject.Inject;

import jp.co.slcs.swak.web.config.annotations.Forward;
import jp.co.slcs.swak.web.config.annotations.Forwards;
import jp.co.slcs.swak.web.config.annotations.Input;
import jp.co.slcs.swak.web.config.annotations.UIBean;
import jp.co.slcs.swak.web.conversation.annotations.Begin;
import jp.co.slcs.swak.web.conversation.annotations.End;
import jp.co.slcs.swak.web.conversation.annotations.MultiPostConstraints;

/**
 * 将来解約返戻金照会 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,     page=PAGENO_INIT,     path="/hozen/khozen/khsyouraikaiyakuhenreikin/KhSyouraiKaiyakuhenreikin.do", redirect=true),
    @Forward(name=FORWARDNAME_INPUTKEY, page=PAGENO_INPUTKEY, path="/hozen/khozen/khsyouraikaiyakuhenreikin/kh_syourai_kaiyakuhenreikin.jsp"),
    @Forward(name=FORWARDNAME_RESULT,   page=PAGENO_RESULT,   path="/hozen/khozen/khsyouraikaiyakuhenreikin/kh_syourai_kaiyakuhenreikin.jsp"),
})
@Input("/hozen/khozen/khsyouraikaiyakuhenreikin/kh_syourai_kaiyakuhenreikin.jsp")
@UIBean(beanClass=KhSyouraiKaiyakuhenreikinUiBean.class)
public class KhSyouraiKaiyakuhenreikinAction {

    @Inject
    private KhSyouraiKaiyakuhenreikinBizLogic bizLogic;

    @Begin
    public String init() {
        bizLogic.init();
        return FORWARDNAME_INPUTKEY;
    }

    @Begin(renew = true)
    public String fromSrKykhrkFunctions() {
        bizLogic.init();
        return FORWARDNAME_INPUTKEY;
    }

    @End
    public String tojiruBtnOnClick() {
        return null;
    }

    public String syonodesyoukaibtnOnClick() {
        bizLogic.pushSearchBySyonoBL();
        return FORWARDNAME_RESULT;
    }

    public String inputnaiyoudesyoukaibtnOnClick() {
        bizLogic.pushSearchByInputBL();
        return FORWARDNAME_RESULT;
    }

    @End
    public String modorubtnOnClick() {
        bizLogic.pushBackBL();
        return FORWARDNAME_INIT;
    }

    public void callAjaxCommon() throws IOException {
        bizLogic.callAjaxCommonBL();
    }

    @MultiPostConstraints
    public String print() {

        bizLogic.printOut();

        return null;
    }
}
