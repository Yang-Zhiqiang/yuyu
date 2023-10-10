package yuyu.app.direct.dssyoukai.dsmailsousinrirekisyoukai;

import static yuyu.app.direct.dssyoukai.dsmailsousinrirekisyoukai.GenDsMailSousinRirekiSyoukaiConstants.*;

import javax.inject.Inject;

import jp.co.slcs.swak.web.config.annotations.Forward;
import jp.co.slcs.swak.web.config.annotations.Forwards;
import jp.co.slcs.swak.web.config.annotations.Input;
import jp.co.slcs.swak.web.config.annotations.UIBean;
import jp.co.slcs.swak.web.conversation.annotations.Begin;
import jp.co.slcs.swak.web.conversation.annotations.End;

/**
 * ＤＳメール送信履歴照会 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,             page=PAGENO_INIT,             path="/direct/dssyoukai/dsmailsousinrirekisyoukai/DsMailSousinRirekiSyoukai.do", redirect=true),
    @Forward(name=FORWARDNAME_CURRENT,                                        path="/direct/dssyoukai/dsmailsousinrirekisyoukai/ds_mail_sousin_rireki_syoukai.jsp"),
    @Forward(name=FORWARDNAME_DSSENDMAILSEARCH, page=PAGENO_DSSENDMAILSEARCH, path="/direct/dssyoukai/dsmailsousinrirekisyoukai/ds_mail_sousin_rireki_syoukai.jsp"),
})
@Input("/direct/dssyoukai/dsmailsousinrirekisyoukai/ds_mail_sousin_rireki_syoukai.jsp")
@UIBean(beanClass=DsMailSousinRirekiSyoukaiUiBean.class)
public class DsMailSousinRirekiSyoukaiAction {

    @Inject
    private DsMailSousinRirekiSyoukaiBizLogic bizLogic;

    @Begin
    public String init() {

        bizLogic.init();
        return FORWARDNAME_DSSENDMAILSEARCH;
    }

    @End
    public String tojiruBtnOnClick() {
        return null;
    }

    public String searchbtnbyinputkeyselectOnClick() {
        bizLogic.pushSearchBtnbyInputkeySelectBL();
        return FORWARDNAME_DSSENDMAILSEARCH;
    }

    @End
    public String clearbtnbyinputkeyselectOnClick() {
        return FORWARDNAME_INIT;
    }

    public String searchResultInfoPagerOnClick() {
        return FORWARDNAME_CURRENT;
    }
}
