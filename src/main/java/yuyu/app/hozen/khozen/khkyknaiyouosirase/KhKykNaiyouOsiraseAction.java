package yuyu.app.hozen.khozen.khkyknaiyouosirase;

import static yuyu.app.hozen.khozen.khkyknaiyouosirase.GenKhKykNaiyouOsiraseConstants.*;

import javax.inject.Inject;

import jp.co.slcs.swak.web.config.annotations.Forward;
import jp.co.slcs.swak.web.config.annotations.Forwards;
import jp.co.slcs.swak.web.config.annotations.Input;
import jp.co.slcs.swak.web.config.annotations.UIBean;
import jp.co.slcs.swak.web.conversation.annotations.Begin;
import jp.co.slcs.swak.web.conversation.annotations.End;
import jp.co.slcs.swak.web.conversation.annotations.MultiPostConstraints;

/**
 * ご契約内容のお知らせ 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,     page=PAGENO_INIT,     path="/hozen/khozen/khkyknaiyouosirase/KhKykNaiyouOsirase.do", redirect=true),
    @Forward(name=FORWARDNAME_INPUTKEY, page=PAGENO_INPUTKEY, path="/hozen/khozen/khkyknaiyouosirase/kh_kyk_naiyou_osirase.jsp"),
    @Forward(name=FORWARDNAME_RESULT,   page=PAGENO_RESULT,   path="/hozen/khozen/khkyknaiyouosirase/kh_kyk_naiyou_osirase.jsp"),
})
@Input("/hozen/khozen/khkyknaiyouosirase/kh_kyk_naiyou_osirase.jsp")
@UIBean(beanClass=KhKykNaiyouOsiraseUiBean.class)
public class KhKykNaiyouOsiraseAction {

    @Inject
    private KhKykNaiyouOsiraseBizLogic bizLogic;

    @Begin
    public String init() {
        bizLogic.init();
        return FORWARDNAME_INPUTKEY;
    }

    @Begin(renew = true)
    public String fromOtherFunctions() {
        bizLogic.init();
        return FORWARDNAME_INPUTKEY;
    }

    @End
    public String tojiruBtnOnClick() {
        return null;
    }

    public String reportsksbtnOnClick() {
        bizLogic.pushReportSksBL();
        return FORWARDNAME_RESULT;
    }

    @End
    public String modorubtnOnClick() {
        return FORWARDNAME_INIT;
    }

    @MultiPostConstraints
    public String print() {
        bizLogic.printOut();
        return null;
    }
}
