package yuyu.app.biz.bzkaikei.bzhojyoboruikeigakunyuuryoku;

import static yuyu.app.biz.bzkaikei.bzhojyoboruikeigakunyuuryoku.GenBzHojyoboRuikeigakuNyuuryokuConstants.*;

import javax.inject.Inject;

import jp.co.slcs.swak.web.config.annotations.Forward;
import jp.co.slcs.swak.web.config.annotations.Forwards;
import jp.co.slcs.swak.web.config.annotations.Input;
import jp.co.slcs.swak.web.config.annotations.UIBean;
import jp.co.slcs.swak.web.conversation.annotations.Begin;
import jp.co.slcs.swak.web.conversation.annotations.End;
import jp.co.slcs.swak.web.conversation.annotations.MultiPostConstraints;

/**
 * 補助簿累計額入力 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,          page=PAGENO_INIT,          path="/biz/bzkaikei/bzhojyoboruikeigakunyuuryoku/BzHojyoboRuikeigakuNyuuryoku.do", redirect=true),
    @Forward(name=FORWARDNAME_SELECTDATA,    page=PAGENO_SELECTDATA,    path="/biz/bzkaikei/bzhojyoboruikeigakunyuuryoku/bz_hojyobo_ruikeigaku_nyuuryoku.jsp"),
    @Forward(name=FORWARDNAME_INPUTCONTENTS, page=PAGENO_INPUTCONTENTS, path="/biz/bzkaikei/bzhojyoboruikeigakunyuuryoku/bz_hojyobo_ruikeigaku_nyuuryoku.jsp"),
    @Forward(name=FORWARDNAME_CONFIRM,       page=PAGENO_CONFIRM,       path="/biz/bzkaikei/bzhojyoboruikeigakunyuuryoku/bz_hojyobo_ruikeigaku_nyuuryoku.jsp"),
    @Forward(name=FORWARDNAME_RESULT,        page=PAGENO_RESULT,        path="/biz/bzkaikei/bzhojyoboruikeigakunyuuryoku/bz_hojyobo_ruikeigaku_nyuuryoku.jsp"),
})
@Input("/biz/bzkaikei/bzhojyoboruikeigakunyuuryoku/bz_hojyobo_ruikeigaku_nyuuryoku.jsp")
@UIBean(beanClass=BzHojyoboRuikeigakuNyuuryokuUiBean.class)
public class BzHojyoboRuikeigakuNyuuryokuAction {

    @Inject
    private BzHojyoboRuikeigakuNyuuryokuBizLogic bizLogic;

    @Begin
    public String init() {

        bizLogic.init();
        return FORWARDNAME_SELECTDATA;
    }

    @End
    public String tojiruBtnOnClick() {
        return null;
    }

    public String sinkitourokubtnOnClick() {
        bizLogic.pushSinkiTourokuBL();
        return FORWARDNAME_INPUTCONTENTS;
    }

    public String teiseilinkOnClick() {
        bizLogic.pushTeiseiBL();
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

    @MultiPostConstraints
    public String kakuteiBtnOnClick() {
        bizLogic.pushKakuteiBL();
        return FORWARDNAME_RESULT;
    }

    @End
    public String syokigamenheBtnOnClick() {
        return FORWARDNAME_INIT;
    }

    public String teiseigksakujyobtnOnClick() {
        bizLogic.pushTeiseigksakujyoBL();
        return FORWARDNAME_CONFIRM;
    }
}
