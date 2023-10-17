package yuyu.app.hozen.khansyuu.khzennouseisangksyoukai;

import static yuyu.app.hozen.khansyuu.khzennouseisangksyoukai.GenKhZennouSeisanGkSyoukaiConstants.*;

import javax.inject.Inject;

import jp.co.slcs.swak.web.config.annotations.Forward;
import jp.co.slcs.swak.web.config.annotations.Forwards;
import jp.co.slcs.swak.web.config.annotations.Input;
import jp.co.slcs.swak.web.config.annotations.UIBean;
import jp.co.slcs.swak.web.conversation.annotations.Begin;
import jp.co.slcs.swak.web.conversation.annotations.End;

/**
 * 前納精算額照会 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,      page=PAGENO_INIT,      path="/hozen/khansyuu/khzennouseisangksyoukai/KhZennouSeisanGkSyoukai.do", redirect=true),
    @Forward(name=FORWARDNAME_INPUTKEY,  page=PAGENO_INPUTKEY,  path="/hozen/khansyuu/khzennouseisangksyoukai/kh_zennou_seisan_gk_syoukai.jsp"),
    @Forward(name=FORWARDNAME_REFERENCE, page=PAGENO_REFERENCE, path="/hozen/khansyuu/khzennouseisangksyoukai/kh_zennou_seisan_gk_syoukai.jsp"),
})
@Input("/hozen/khansyuu/khzennouseisangksyoukai/kh_zennou_seisan_gk_syoukai.jsp")
@UIBean(beanClass=KhZennouSeisanGkSyoukaiUiBean.class)
public class KhZennouSeisanGkSyoukaiAction {

    @Inject
    private KhZennouSeisanGkSyoukaiBizLogic bizLogic;

    @Begin
    public String init() {

        bizLogic.init();
        return FORWARDNAME_INPUTKEY;
    }

    @End
    public String tojiruBtnOnClick() {
        return null;
    }

    public String syoukaibtnbyinputkeyOnClick() {
        bizLogic.pushSyoukaiBL();
        return FORWARDNAME_REFERENCE;
    }

    public String modorubtnbysyoukaiOnClick() {
        return FORWARDNAME_INPUTKEY;
    }
}
