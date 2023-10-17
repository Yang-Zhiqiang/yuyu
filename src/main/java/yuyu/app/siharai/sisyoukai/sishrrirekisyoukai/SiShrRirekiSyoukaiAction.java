package yuyu.app.siharai.sisyoukai.sishrrirekisyoukai;

import static yuyu.app.siharai.sisyoukai.sishrrirekisyoukai.GenSiShrRirekiSyoukaiConstants.*;

import javax.inject.Inject;

import jp.co.slcs.swak.web.auth.permission.Roles;
import jp.co.slcs.swak.web.config.annotations.Forward;
import jp.co.slcs.swak.web.config.annotations.Forwards;
import jp.co.slcs.swak.web.config.annotations.Input;
import jp.co.slcs.swak.web.config.annotations.UIBean;
import jp.co.slcs.swak.web.conversation.annotations.Begin;
import jp.co.slcs.swak.web.conversation.annotations.End;
import yuyu.def.classification.C_Syorikeiyu;

/**
 * 支払履歴照会 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,             page=PAGENO_INIT,             path="/siharai/sisyoukai/sishrrirekisyoukai/SiShrRirekiSyoukai.do", redirect=true),
    @Forward(name=FORWARDNAME_CURRENT,                                        path="/siharai/sisyoukai/sishrrirekisyoukai/si_shr_rireki_syoukai.jsp"),
    @Forward(name=FORWARDNAME_INPUTKEY,         page=PAGENO_INPUTKEY,         path="/siharai/sisyoukai/sishrrirekisyoukai/si_shr_rireki_syoukai.jsp"),
    @Forward(name=FORWARDNAME_KENSAKURESULT,    page=PAGENO_KENSAKURESULT,    path="/siharai/sisyoukai/sishrrirekisyoukai/si_shr_rireki_syoukai.jsp"),
    @Forward(name=FORWARDNAME_SHRRIREKI,        page=PAGENO_SHRRIREKI,        path="/siharai/sisyoukai/sishrrirekisyoukai/si_shr_rireki_syoukai.jsp"),
    @Forward(name=FORWARDNAME_SHRRIREKISYOUSAI, page=PAGENO_SHRRIREKISYOUSAI, path="/siharai/sisyoukai/sishrrirekisyoukai/si_shr_rireki_syoukai.jsp"),
})
@Input("/siharai/sisyoukai/sishrrirekisyoukai/si_shr_rireki_syoukai.jsp")
@UIBean(beanClass=SiShrRirekiSyoukaiUiBean.class)
@Roles("sishrrirekisyoukai")
public class SiShrRirekiSyoukaiAction {

    @Inject
    private SiShrRirekiSyoukaiBizLogic bizLogic;

    @Inject
    private SiShrRirekiSyoukaiUiBean uiBean;

    @Begin
    public String init() {

        bizLogic.init();
        return FORWARDNAME_INPUTKEY;
    }

    @Begin(renew = true)
    public String fromOtherFunctions() {
        bizLogic.pushSyoukaiBL();
        return FORWARDNAME_SHRRIREKI;
    }

    @End
    public String tojiruBtnOnClick() {
        return null;
    }

    public String syoukaibtnOnClick() {
        bizLogic.pushSyoukaiBL();
        return FORWARDNAME_SHRRIREKI;
    }

    public String searchBtnOnClick() {
        bizLogic.pushSearchBL();
        return FORWARDNAME_KENSAKURESULT;
    }

    public String syonoOnClick() {
        bizLogic.pushDispSyoNoBL();
        return FORWARDNAME_SHRRIREKI;
    }

    public String syousaiLinkOnClick() {
        bizLogic.pushSyousaiBL();
        return FORWARDNAME_SHRRIREKISYOUSAI;
    }

    public String hyoujilinkOnClick() {
        bizLogic.printHyoujiOut();
        return null;
    }

    public String allhyoujibtnOnClick() {
        bizLogic.printAllHyoujiOut();
        return null;
    }

    public String modorubtnbykensakuOnClick() {
        bizLogic.clear();
        return FORWARDNAME_INPUTKEY;
    }

    public String modorubtnbysyoukaiOnClick() {

        if (C_Syorikeiyu.KEYINPUT.eq(uiBean.getSyoriKeiyuKbn())) {
            bizLogic.clear();
            return FORWARDNAME_INPUTKEY;
        }

        return FORWARDNAME_KENSAKURESULT;
    }

    public String modoruBtnBySyousaiOnClick() {
        return FORWARDNAME_SHRRIREKI;
    }

    public String searchResultsPagerOnClick() {
        return FORWARDNAME_CURRENT;
    }

    public String siharaiRirekiPagerOnClick() {
        return FORWARDNAME_CURRENT;
    }
}