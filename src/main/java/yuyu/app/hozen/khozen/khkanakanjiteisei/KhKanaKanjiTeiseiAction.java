package yuyu.app.hozen.khozen.khkanakanjiteisei;

import static yuyu.app.hozen.khozen.khkanakanjiteisei.GenKhKanaKanjiTeiseiConstants.*;

import javax.inject.Inject;

import jp.co.slcs.swak.web.config.annotations.Forward;
import jp.co.slcs.swak.web.config.annotations.Forwards;
import jp.co.slcs.swak.web.config.annotations.Input;
import jp.co.slcs.swak.web.config.annotations.UIBean;
import jp.co.slcs.swak.web.conversation.annotations.Begin;
import jp.co.slcs.swak.web.conversation.annotations.End;
import yuyu.common.biz.bzcommon.BizUiBeanBackupUtil;

/**
 * 仮名漢字訂正 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,      page=PAGENO_INIT,      path="/hozen/khozen/khkanakanjiteisei/KhKanaKanjiTeisei.do", redirect=true),
    @Forward(name=FORWARDNAME_INPUTKEY,  page=PAGENO_INPUTKEY,  path="/hozen/khozen/khkanakanjiteisei/kh_kana_kanji_teisei.jsp"),
    @Forward(name=FORWARDNAME_REFERENCE, page=PAGENO_REFERENCE, path="/hozen/khozen/khkanakanjiteisei/kh_kana_kanji_teisei.jsp"),
    @Forward(name=FORWARDNAME_CONFIRM,   page=PAGENO_CONFIRM,   path="/hozen/khozen/khkanakanjiteisei/kh_kana_kanji_teisei.jsp"),
    @Forward(name=FORWARDNAME_RESULT,    page=PAGENO_RESULT,    path="/hozen/khozen/khkanakanjiteisei/kh_kana_kanji_teisei.jsp"),
})
@Input("/hozen/khozen/khkanakanjiteisei/kh_kana_kanji_teisei.jsp")
@UIBean(beanClass=KhKanaKanjiTeiseiUiBean.class)
public class KhKanaKanjiTeiseiAction {

    @Inject
    private KhKanaKanjiTeiseiBizLogic bizLogic;

    @Inject
    private KhKanaKanjiTeiseiUiBean uiBean;

    @Inject
    private ReferenceCopyBean referenceBean;

    public String init() {

        bizLogic.init();
        return FORWARDNAME_INPUTKEY;
    }

    @End
    public String tojiruBtnOnClick() {
        return null;
    }

    @End(nested=true)
    public String functionNameOnClick() {
        return FORWARDNAME_INIT;
    }

    @Begin
    public String syoukaibtnOnClick() {
        bizLogic.pushSyoukaiBL();
        return FORWARDNAME_REFERENCE;
    }

    @End
    public String modorubtnbysyoukaiOnClick() {
        return FORWARDNAME_INIT;
    }

    public String kakuninBtnOnClick() {
        BizUiBeanBackupUtil.backup(uiBean, referenceBean);

        bizLogic.pushKakuninBL();
        return FORWARDNAME_CONFIRM;
    }

    public String modoruBtnByConfirmOnClick() {
        BizUiBeanBackupUtil.restore(uiBean, referenceBean);

        bizLogic.pushModoruByConfirmBL();
        return FORWARDNAME_REFERENCE;
    }

    @End
    public String kakuteiBtnOnClick() {
        bizLogic.pushKakuteiBL();
        return FORWARDNAME_RESULT;
    }

    public String syokigamenheBtnOnClick() {
        return FORWARDNAME_INIT;
    }
}
