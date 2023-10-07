package yuyu.app.siharai.sihubikanri.sihubinaiyoukensaku;

import static yuyu.app.siharai.sihubikanri.sihubinaiyoukensaku.SiHubiNaiyouKensakuConstants.*;

import javax.inject.Inject;

import jp.co.slcs.swak.web.auth.permission.Roles;
import jp.co.slcs.swak.web.config.annotations.Forward;
import jp.co.slcs.swak.web.config.annotations.Forwards;
import jp.co.slcs.swak.web.config.annotations.Input;
import jp.co.slcs.swak.web.config.annotations.UIBean;
import jp.co.slcs.swak.web.conversation.annotations.Begin;
import jp.co.slcs.swak.web.conversation.annotations.End;

/**
 * 保険金給付金不備内容検索 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,       page=PAGENO_INIT,       path="/siharai/sihubikanri/sihubinaiyoukensaku/SiHubiNaiyouKensaku.do", redirect=true),
    @Forward(name=FORWARDNAME_SELECTDATA, page=PAGENO_SELECTDATA, path="/siharai/sihubikanri/sihubinaiyoukensaku/si_hubi_naiyou_kensaku.jsp"),
})
@Input("/siharai/sihubikanri/sihubinaiyoukensaku/si_hubi_naiyou_kensaku.jsp")
@UIBean(beanClass=SiHubiNaiyouKensakuUiBean.class)
@Roles("sihubinaiyoukensaku")
public class SiHubiNaiyouKensakuAction {

    @Inject
    private SiHubiNaiyouKensakuBizLogic bizLogic;

    @Begin
    public String init() {
        bizLogic.init();
        return FORWARDNAME_SELECTDATA;
    }

    @End
    public String tojiruBtnOnClick() {
        return null;
    }

    public String searchBtnOnClick() {
        bizLogic.pushSearchBL();
        return FORWARDNAME_SELECTDATA;
    }
}
