package yuyu.app.siharai.sikessan.sibikintuikasakujyo;

import static yuyu.app.siharai.sikessan.sibikintuikasakujyo.GenSiBikinTuikaSakujyoConstants.*;

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
 * 保険金給付金備金追加削除 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,          page=PAGENO_INIT,          path="/siharai/sikessan/sibikintuikasakujyo/SiBikinTuikaSakujyo.do", redirect=true),
    @Forward(name=FORWARDNAME_INPUTKEY,      page=PAGENO_INPUTKEY,      path="/siharai/sikessan/sibikintuikasakujyo/si_bikin_tuika_sakujyo.jsp"),
    @Forward(name=FORWARDNAME_INPUTCONTENTS, page=PAGENO_INPUTCONTENTS, path="/siharai/sikessan/sibikintuikasakujyo/si_bikin_tuika_sakujyo.jsp"),
    @Forward(name=FORWARDNAME_CONFIRM,       page=PAGENO_CONFIRM,       path="/siharai/sikessan/sibikintuikasakujyo/si_bikin_tuika_sakujyo.jsp"),
    @Forward(name=FORWARDNAME_RESULT,        page=PAGENO_RESULT,        path="/siharai/sikessan/sibikintuikasakujyo/si_bikin_tuika_sakujyo.jsp"),
})
@Input("/siharai/sikessan/sibikintuikasakujyo/si_bikin_tuika_sakujyo.jsp")
@UIBean(beanClass=SiBikinTuikaSakujyoUiBean.class)
@Roles("sibikintuikasakujyo")
public class SiBikinTuikaSakujyoAction {

    @Inject
    private SiBikinTuikaSakujyoBizLogic bizLogic;

    public String init() {

        bizLogic.init();
        return FORWARDNAME_INPUTKEY;
    }

    @End
    public String tojiruBtnOnClick() {
        return null;
    }

    @Begin
    public String ketteiBtnOnClick() {

        String path =  bizLogic.pushKetteiBL();

        return path;
    }

    @End
    public String modoruBtnByInputContentsOnClick() {
        return FORWARDNAME_INIT;
    }

    public String kakuninBtnOnClick() {

        String path = bizLogic.pushKakuninBL();

        return path;
    }

    public String modoruBtnByConfirmOnClick() {
        return FORWARDNAME_INPUTCONTENTS;
    }

    @MultiPostConstraints
    public String kakuteiBtnOnClick() {

        String path = bizLogic.pushKakuteiBL();

        return path;
    }

    @End
    public String syokigamenheBtnOnClick() {
        return FORWARDNAME_INIT;
    }

    @End
    public String functionNameOnClick() {
        return FORWARDNAME_INIT;
    }
}
