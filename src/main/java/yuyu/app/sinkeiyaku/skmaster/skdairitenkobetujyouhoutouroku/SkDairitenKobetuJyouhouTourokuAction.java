package yuyu.app.sinkeiyaku.skmaster.skdairitenkobetujyouhoutouroku;

import static yuyu.app.sinkeiyaku.skmaster.skdairitenkobetujyouhoutouroku.GenSkDairitenKobetuJyouhouTourokuConstants.*;

import javax.inject.Inject;

import jp.co.slcs.swak.web.config.annotations.Forward;
import jp.co.slcs.swak.web.config.annotations.Forwards;
import jp.co.slcs.swak.web.config.annotations.Input;
import jp.co.slcs.swak.web.config.annotations.UIBean;
import jp.co.slcs.swak.web.conversation.annotations.Begin;
import jp.co.slcs.swak.web.conversation.annotations.Begin.Mode;
import jp.co.slcs.swak.web.conversation.annotations.End;
import jp.co.slcs.swak.web.conversation.annotations.MultiPostConstraints;
import yuyu.app.sinkeiyaku.skmaster.skdairitenkobetujyouhoutouroku.SkDairitenKobetuJyouhouTourokuConstants.E_SyoriKbn;

/**
 * 代理店個別情報登録 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,          page=PAGENO_INIT,          path="/sinkeiyaku/skmaster/skdairitenkobetujyouhoutouroku/SkDairitenKobetuJyouhouTouroku.do", redirect=true),
    @Forward(name=FORWARDNAME_INPUTKEY,      page=PAGENO_INPUTKEY,      path="/sinkeiyaku/skmaster/skdairitenkobetujyouhoutouroku/sk_dairiten_kobetu_jyouhou_touroku.jsp"),
    @Forward(name=FORWARDNAME_INPUTCONTENTS, page=PAGENO_INPUTCONTENTS, path="/sinkeiyaku/skmaster/skdairitenkobetujyouhoutouroku/sk_dairiten_kobetu_jyouhou_touroku.jsp"),
    @Forward(name=FORWARDNAME_CONFIRM,       page=PAGENO_CONFIRM,       path="/sinkeiyaku/skmaster/skdairitenkobetujyouhoutouroku/sk_dairiten_kobetu_jyouhou_touroku.jsp"),
    @Forward(name=FORWARDNAME_RESULT,        page=PAGENO_RESULT,        path="/sinkeiyaku/skmaster/skdairitenkobetujyouhoutouroku/sk_dairiten_kobetu_jyouhou_touroku.jsp"),
})
@Input("/sinkeiyaku/skmaster/skdairitenkobetujyouhoutouroku/sk_dairiten_kobetu_jyouhou_touroku.jsp")
@UIBean(beanClass=SkDairitenKobetuJyouhouTourokuUiBean.class)
public class SkDairitenKobetuJyouhouTourokuAction {

    @Inject
    private SkDairitenKobetuJyouhouTourokuBizLogic bizLogic;

    @Inject
    private SkDairitenKobetuJyouhouTourokuUiBean uiBean;

    public String init() {

        bizLogic.init();
        return FORWARDNAME_INPUTKEY;
    }

    @End
    public String tojiruBtnOnClick() {
        return null;
    }

    @Begin
    public String tourokuBtnOnClick() {

        bizLogic.pushAddBL();
        return FORWARDNAME_INPUTCONTENTS;
    }

    @Begin
    public String henkouBtnOnClick() {

        bizLogic.pushUpdBL();
        return FORWARDNAME_INPUTCONTENTS;
    }

    @Begin(mode=Mode.DELETE)
    public String sakujyoBtnOnClick() {

        bizLogic.pushDelBL();
        return FORWARDNAME_CONFIRM;
    }

    @End
    public String modoruBtnByInputContentsOnClick() {
        return FORWARDNAME_INIT;
    }

    public String kakuninBtnOnClick() {

        bizLogic.pushKakuninBL();
        return FORWARDNAME_CONFIRM;
    }

    @End(mode=Mode.DELETE)
    public String modoruBtnByConfirmOnClick() {

        String forwardName = null;
        E_SyoriKbn gamenSyoriKbn = uiBean.getGamenSyoriKbn();

        if (E_SyoriKbn.NEW.equals(gamenSyoriKbn) || E_SyoriKbn.UPD.equals(gamenSyoriKbn)) {
            forwardName = FORWARDNAME_INPUTCONTENTS;
        }
        else {
            forwardName = FORWARDNAME_INIT;
        }

        return forwardName;
    }

    @MultiPostConstraints
    public String kakuteiBtnOnClick() {

        bizLogic.pushKakuteiBL();
        return FORWARDNAME_RESULT;
    }

    @End(nested=true)
    public String syokigamenheBtnOnClick() {
        return FORWARDNAME_INIT;
    }
}
