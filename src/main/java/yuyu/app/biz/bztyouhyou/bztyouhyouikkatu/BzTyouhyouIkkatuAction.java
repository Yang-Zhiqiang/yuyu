package yuyu.app.biz.bztyouhyou.bztyouhyouikkatu;

import static yuyu.app.biz.bztyouhyou.bztyouhyouikkatu.GenBzTyouhyouIkkatuConstants.*;

import javax.inject.Inject;

import jp.co.slcs.swak.web.auth.permission.Roles;
import jp.co.slcs.swak.web.config.annotations.Forward;
import jp.co.slcs.swak.web.config.annotations.Forwards;
import jp.co.slcs.swak.web.config.annotations.Input;
import jp.co.slcs.swak.web.config.annotations.UIBean;
import jp.co.slcs.swak.web.conversation.annotations.Begin;
import jp.co.slcs.swak.web.conversation.annotations.End;
import jp.co.slcs.swak.web.conversation.annotations.MultiPostConstraints;

/**
 * 帳票一括出力 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,              page=PAGENO_INIT,              path="/biz/bztyouhyou/bztyouhyouikkatu/BzTyouhyouIkkatu.do", redirect=true),
    @Forward(name=FORWARDNAME_INPUTKEY,          page=PAGENO_INPUTKEY,          path="/biz/bztyouhyou/bztyouhyouikkatu/bz_tyouhyou_ikkatu.jsp"),
    @Forward(name=FORWARDNAME_KENSAKURESULT,     page=PAGENO_KENSAKURESULT,     path="/biz/bztyouhyou/bztyouhyouikkatu/bz_tyouhyou_ikkatu.jsp"),
    @Forward(name=FORWARDNAME_CONFIRM,           page=PAGENO_CONFIRM,           path="/biz/bztyouhyou/bztyouhyouikkatu/bz_tyouhyou_ikkatu.jsp"),
    @Forward(name=FORWARDNAME_RESULT,            page=PAGENO_RESULT,            path="/biz/bztyouhyou/bztyouhyouikkatu/bz_tyouhyou_ikkatu.jsp"),
    @Forward(name=FORWARDNAME_OUTPUTKENGENERROR, page=PAGENO_OUTPUTKENGENERROR, path="/biz/bztyouhyou/bztyouhyouikkatu/bz_tyouhyou_ikkatu.jsp"),
})
@Input("/biz/bztyouhyou/bztyouhyouikkatu/bz_tyouhyou_ikkatu.jsp")
@UIBean(beanClass=BzTyouhyouIkkatuUiBean.class)
@Roles("bztyouhyouikkatu")
public class BzTyouhyouIkkatuAction {

    @Inject
    private BzTyouhyouIkkatuBizLogic bizLogic;

    @Begin
    public String init() {

        if (!bizLogic.init()) {
            return FORWARDNAME_INPUTKEY;
        }

        return FORWARDNAME_OUTPUTKENGENERROR;
    }


    @End
    public String tojiruBtnOnClick() {
        return null;
    }

    @Begin(nested=true)
    public String dispsyoruinmOnClick() {
        bizLogic.syoruinmLink();
        return FORWARDNAME_CONFIRM;
    }

    public String searchBtnOnClick() {
        bizLogic.pushKensaku();
        return FORWARDNAME_KENSAKURESULT;
    }

    @End
    public String modorubtnbykensakuOnClick() {
        return FORWARDNAME_INIT;
    }

    public String modoruBtnByConfirmOnClick() {
        return FORWARDNAME_KENSAKURESULT;
    }

    @MultiPostConstraints
    public String kakuteiBtnOnClick() {
        bizLogic.pushKakutei();
        return FORWARDNAME_RESULT;
    }

    @End
    public String syokigamenheBtnOnClick() {
        return FORWARDNAME_INIT;
    }

    @MultiPostConstraints
    public void print(){
        bizLogic.printOut();
    }

    @End(nested=true)
    public String searchresulthemdrbtnbykekkaOnClick() {
        bizLogic.pushKensaku();
        return FORWARDNAME_KENSAKURESULT;
    }
}
