package yuyu.app.sinkeiyaku.sknyuukin.sknyuukinhenkinkakunin;

import static yuyu.app.sinkeiyaku.sknyuukin.sknyuukinhenkinkakunin.GenSkNyuukinHenkinKakuninConstants.*;

import javax.inject.Inject;

import jp.co.slcs.swak.web.config.annotations.Forward;
import jp.co.slcs.swak.web.config.annotations.Forwards;
import jp.co.slcs.swak.web.config.annotations.Input;
import jp.co.slcs.swak.web.config.annotations.UIBean;
import jp.co.slcs.swak.web.conversation.annotations.Begin;
import jp.co.slcs.swak.web.conversation.annotations.End;

/**
 * 入金／返金状況確認 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,      page=PAGENO_INIT,      path="/sinkeiyaku/sknyuukin/sknyuukinhenkinkakunin/SkNyuukinHenkinKakunin.do", redirect=true),
    @Forward(name=FORWARDNAME_INPUTKEY,  page=PAGENO_INPUTKEY,  path="/sinkeiyaku/sknyuukin/sknyuukinhenkinkakunin/sk_nyuukin_henkin_kakunin.jsp"),
    @Forward(name=FORWARDNAME_REFERENCE, page=PAGENO_REFERENCE, path="/sinkeiyaku/sknyuukin/sknyuukinhenkinkakunin/sk_nyuukin_henkin_kakunin.jsp"),
    @Forward(name=FORWARDNAME_MEISAI,    page=PAGENO_MEISAI,    path="/sinkeiyaku/sknyuukin/sknyuukinhenkinkakunin/sk_nyuukin_henkin_kakunin.jsp"),
})
@Input("/sinkeiyaku/sknyuukin/sknyuukinhenkinkakunin/sk_nyuukin_henkin_kakunin.jsp")
@UIBean(beanClass=SkNyuukinHenkinKakuninUiBean.class)
public class SkNyuukinHenkinKakuninAction {

    @Inject
    private SkNyuukinHenkinKakuninBizLogic bizLogic;

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
        bizLogic.pushSyoukaibtnByInputkeyBL();
        return FORWARDNAME_REFERENCE;
    }

    public String modorubtnbysyoukaiOnClick() {
        bizLogic.pushModorubtnBySyoukaiBL();
        return FORWARDNAME_INPUTKEY;
    }

    public String syoukaibtnOnClick() {
        bizLogic.pushSyousaiBL();
        return FORWARDNAME_MEISAI;
    }

    public String modoruBtnBySyousaiOnClick() {
        return FORWARDNAME_REFERENCE;
    }

    public String functionNameOnClick() {
        bizLogic.pushFunctionNameBL();
        return FORWARDNAME_INPUTKEY;
    }
}
