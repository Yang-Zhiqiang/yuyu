package yuyu.app.hozen.khhubikanri.khhubinaiyoukensaku;

import static yuyu.app.hozen.khhubikanri.khhubinaiyoukensaku.GenKhHubiNaiyouKensakuConstants.*;

import javax.inject.Inject;

import jp.co.slcs.swak.web.config.annotations.Forward;
import jp.co.slcs.swak.web.config.annotations.Forwards;
import jp.co.slcs.swak.web.config.annotations.Input;
import jp.co.slcs.swak.web.config.annotations.UIBean;
import jp.co.slcs.swak.web.conversation.annotations.Begin;
import jp.co.slcs.swak.web.conversation.annotations.End;

/**
 * 契約保全不備内容検索 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,       page=PAGENO_INIT,       path="/hozen/khhubikanri/khhubinaiyoukensaku/KhHubiNaiyouKensaku.do", redirect=true),
    @Forward(name=FORWARDNAME_SELECTDATA, page=PAGENO_SELECTDATA, path="/hozen/khhubikanri/khhubinaiyoukensaku/kh_hubi_naiyou_kensaku.jsp"),
})
@Input("/hozen/khhubikanri/khhubinaiyoukensaku/kh_hubi_naiyou_kensaku.jsp")
@UIBean(beanClass=KhHubiNaiyouKensakuUiBean.class)
public class KhHubiNaiyouKensakuAction {

    @Inject
    private KhHubiNaiyouKensakuBizLogic bizLogic;

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

        bizLogic.searchBtnOnClick();
        return FORWARDNAME_SELECTDATA;
    }

    public String functionNameOnClick() {
        return FORWARDNAME_SELECTDATA;
    }
}
