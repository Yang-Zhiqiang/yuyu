package yuyu.app.hozen.khozen.khkawaserateyoteirrtsyoukai;

import static yuyu.app.hozen.khozen.khkawaserateyoteirrtsyoukai.GenKhKawaseRateYoteiRrtSyoukaiConstants.*;

import javax.inject.Inject;

import jp.co.slcs.swak.web.config.annotations.Forward;
import jp.co.slcs.swak.web.config.annotations.Forwards;
import jp.co.slcs.swak.web.config.annotations.Input;
import jp.co.slcs.swak.web.config.annotations.UIBean;
import jp.co.slcs.swak.web.conversation.annotations.Begin;
import jp.co.slcs.swak.web.conversation.annotations.End;

/**
 * 為替レート予定利率推移照会（平準払） 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,      page=PAGENO_INIT,      path="/hozen/khozen/khkawaserateyoteirrtsyoukai/KhKawaseRateYoteiRrtSyoukai.do", redirect=true),
    @Forward(name=FORWARDNAME_CURRENT,                          path="/hozen/khozen/khkawaserateyoteirrtsyoukai/kh_kawase_rate_yotei_rrt_syoukai.jsp"),
    @Forward(name=FORWARDNAME_INPUTKEY,  page=PAGENO_INPUTKEY,  path="/hozen/khozen/khkawaserateyoteirrtsyoukai/kh_kawase_rate_yotei_rrt_syoukai.jsp"),
    @Forward(name=FORWARDNAME_REFERENCE, page=PAGENO_REFERENCE, path="/hozen/khozen/khkawaserateyoteirrtsyoukai/kh_kawase_rate_yotei_rrt_syoukai.jsp"),
})
@Input("/hozen/khozen/khkawaserateyoteirrtsyoukai/kh_kawase_rate_yotei_rrt_syoukai.jsp")
@UIBean(beanClass=KhKawaseRateYoteiRrtSyoukaiUiBean.class)
public class KhKawaseRateYoteiRrtSyoukaiAction {

    @Inject
    private KhKawaseRateYoteiRrtSyoukaiBizLogic bizLogic;

    @Begin
    public String init() {

        bizLogic.init();
        return FORWARDNAME_INPUTKEY;
    }

    @End
    public String tojiruBtnOnClick() {
        return null;
    }

    public String syoukaibtnOnClick() {
        bizLogic.pushReferenceBL();
        return FORWARDNAME_REFERENCE;
    }

    @End
    public String modorubtnOnClick() {
        return FORWARDNAME_INIT;
    }

    public String referenceListPagerOnClick() {
        return FORWARDNAME_CURRENT;
    }
}
