package yuyu.app.sinkeiyaku.sksonota.skseikyuusyosakusei;

import static yuyu.app.sinkeiyaku.sksonota.skseikyuusyosakusei.GenSkSeikyuusyoSakuseiConstants.*;

import javax.inject.Inject;

import jp.co.slcs.swak.web.annotation.BizAppExceptionTerminate;
import jp.co.slcs.swak.web.config.annotations.Forward;
import jp.co.slcs.swak.web.config.annotations.Forwards;
import jp.co.slcs.swak.web.config.annotations.Input;
import jp.co.slcs.swak.web.config.annotations.UIBean;
import jp.co.slcs.swak.web.conversation.annotations.Begin;
import jp.co.slcs.swak.web.conversation.annotations.End;
import jp.co.slcs.swak.web.conversation.annotations.MultiPostConstraints;

/**
 * 新契約請求書作成 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,     page=PAGENO_INIT,     path="/sinkeiyaku/sksonota/skseikyuusyosakusei/SkSeikyuusyoSakusei.do", redirect=true),
    @Forward(name=FORWARDNAME_INPUTKEY, page=PAGENO_INPUTKEY, path="/sinkeiyaku/sksonota/skseikyuusyosakusei/sk_seikyuusyo_sakusei.jsp"),
    @Forward(name=FORWARDNAME_CONFIRM,  page=PAGENO_CONFIRM,  path="/sinkeiyaku/sksonota/skseikyuusyosakusei/sk_seikyuusyo_sakusei.jsp"),
    @Forward(name=FORWARDNAME_RESULT,   page=PAGENO_RESULT,   path="/sinkeiyaku/sksonota/skseikyuusyosakusei/sk_seikyuusyo_sakusei.jsp"),
})
@Input("/sinkeiyaku/sksonota/skseikyuusyosakusei/sk_seikyuusyo_sakusei.jsp")
@UIBean(beanClass=SkSeikyuusyoSakuseiUiBean.class)
public class SkSeikyuusyoSakuseiAction {

    @Inject
    private SkSeikyuusyoSakuseiBizLogic bizLogic;

    public String init() {
        bizLogic.init();
        return FORWARDNAME_INPUTKEY;
    }

    @End
    public String tojiruBtnOnClick() {
        bizLogic.doUnlockProcess();
        return null;
    }

    @Begin
    public String kakuninBtnOnClick() {
        bizLogic.pushKakuninBL();
        return FORWARDNAME_CONFIRM;
    }

    @End
    public String modorubtnOnClick() {
        bizLogic.doUnlockProcess();
        return FORWARDNAME_INIT;
    }

    @MultiPostConstraints
    public String kakuteiBtnOnClick() {
        bizLogic.doContinueLockProcess();
        bizLogic.pushKakuteiBL();
        bizLogic.doUnlockProcess();
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

    @End
    public String functionNameOnClick() {
        bizLogic.doUnlockProcess();
        return FORWARDNAME_INIT;
    }

    @BizAppExceptionTerminate
    private void bizAppExceptionTerminate(Throwable e) {
        bizLogic.doUnlockProcess();
    }
}
