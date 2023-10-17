package yuyu.app.siharai.sisyoukai.sihkkingakusisan;

import static yuyu.app.siharai.sisyoukai.sihkkingakusisan.GenSiHkkingakuSisanConstants.*;

import javax.inject.Inject;

import jp.co.slcs.swak.web.config.annotations.Forward;
import jp.co.slcs.swak.web.config.annotations.Forwards;
import jp.co.slcs.swak.web.config.annotations.Input;
import jp.co.slcs.swak.web.config.annotations.UIBean;
import jp.co.slcs.swak.web.conversation.annotations.Begin;
import jp.co.slcs.swak.web.conversation.annotations.End;

/**
 * 保険金額試算 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,         page=PAGENO_INIT,         path="/siharai/sisyoukai/sihkkingakusisan/SiHkkingakuSisan.do", redirect=true),
    @Forward(name=FORWARDNAME_INPUTKEY,     page=PAGENO_INPUTKEY,     path="/siharai/sisyoukai/sihkkingakusisan/si_hkkingaku_sisan.jsp"),
    @Forward(name=FORWARDNAME_SIHARAISISAN, page=PAGENO_SIHARAISISAN, path="/siharai/sisyoukai/sihkkingakusisan/si_hkkingaku_sisan.jsp"),
})
@Input("/siharai/sisyoukai/sihkkingakusisan/si_hkkingaku_sisan.jsp")
@UIBean(beanClass=SiHkkingakuSisanUiBean.class)
public class SiHkkingakuSisanAction {

    @Inject
    private SiHkkingakuSisanBizLogic bizLogic;

    public String init() {

        return FORWARDNAME_INPUTKEY;
    }

    @End
    public String tojiruBtnOnClick() {
        return null;
    }

    @Begin(renew = true)
    public String hokenkingakusisanbtnOnClick() {
        bizLogic.taGamenSyori();
        return FORWARDNAME_SIHARAISISAN;
    }

    public String fromCTI() {
        bizLogic.fromCTISyori();
        return FORWARDNAME_INPUTKEY;
    }

    @Begin
    public String ketteiBtnOnClick() {
        bizLogic.ronriChkAndjyouhoSyutoku();
        return FORWARDNAME_SIHARAISISAN;
    }

    public String hkngksisanbtnOnClick() {
        bizLogic.hokenKingakuSisan();
        return FORWARDNAME_SIHARAISISAN;
    }

    @End
    public String syokigamenheBtnOnClick() {
        return FORWARDNAME_INIT;
    }

    public String sisansyosakuseibtnOnClick() {
        bizLogic.sisansyoSakusei();
        return FORWARDNAME_SIHARAISISAN;
    }

    public void print() {
        bizLogic.printReport();
    }
}
