package yuyu.app.direct.dsmailhaisinkanri.dsmailhaisinyoyaku;

import static yuyu.app.direct.dsmailhaisinkanri.dsmailhaisinyoyaku.DsMailHaisinYoyakuConstants.*;
import static yuyu.app.direct.dsmailhaisinkanri.dsmailhaisinyoyaku.GenDsMailHaisinYoyakuConstants.*;

import javax.inject.Inject;

import jp.co.slcs.swak.web.auth.permission.Roles;
import jp.co.slcs.swak.web.config.annotations.Forward;
import jp.co.slcs.swak.web.config.annotations.Forwards;
import jp.co.slcs.swak.web.config.annotations.Input;
import jp.co.slcs.swak.web.config.annotations.UIBean;
import jp.co.slcs.swak.web.conversation.annotations.Begin;
import jp.co.slcs.swak.web.conversation.annotations.End;
import yuyu.app.direct.dsmailhaisinkanri.dsmailhaisinyoyaku.DsMailHaisinYoyakuConstants.E_SyoriKbn;
import yuyu.common.base.UnknownForwardException;

/**
 * ＤＳメール配信予約 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,      page=PAGENO_INIT,      path="/direct/dsmailhaisinkanri/dsmailhaisinyoyaku/DsMailHaisinYoyaku.do", redirect=true),
    @Forward(name=FORWARDNAME_CURRENT,                          path="/direct/dsmailhaisinkanri/dsmailhaisinyoyaku/ds_mail_haisin_yoyaku.jsp"),
    @Forward(name=FORWARDNAME_REFERENCE, page=PAGENO_REFERENCE, path="/direct/dsmailhaisinkanri/dsmailhaisinyoyaku/ds_mail_haisin_yoyaku.jsp"),
    @Forward(name=FORWARDNAME_TOUROKU,   page=PAGENO_TOUROKU,   path="/direct/dsmailhaisinkanri/dsmailhaisinyoyaku/ds_mail_haisin_yoyaku.jsp"),
    @Forward(name=FORWARDNAME_SYOUNIN,   page=PAGENO_SYOUNIN,   path="/direct/dsmailhaisinkanri/dsmailhaisinyoyaku/ds_mail_haisin_yoyaku.jsp"),
    @Forward(name=FORWARDNAME_SAKUJYO,   page=PAGENO_SAKUJYO,   path="/direct/dsmailhaisinkanri/dsmailhaisinyoyaku/ds_mail_haisin_yoyaku.jsp"),
    @Forward(name=FORWARDNAME_CONFIRM,   page=PAGENO_CONFIRM,   path="/direct/dsmailhaisinkanri/dsmailhaisinyoyaku/ds_mail_haisin_yoyaku.jsp"),
    @Forward(name=FORWARDNAME_RESULT,    page=PAGENO_RESULT,    path="/direct/dsmailhaisinkanri/dsmailhaisinyoyaku/ds_mail_haisin_yoyaku.jsp"),
})
@Input("/direct/dsmailhaisinkanri/dsmailhaisinyoyaku/ds_mail_haisin_yoyaku.jsp")
@UIBean(beanClass=DsMailHaisinYoyakuUiBean.class)
@Roles("dsmailhaisinyoyaku")
public class DsMailHaisinYoyakuAction {

    @Inject
    private DsMailHaisinYoyakuBizLogic bizLogic;

    @Inject
    private DsMailHaisinYoyakuUiBean uiBean;

    @Begin
    public String init() {

        bizLogic.init();

        return FORWARDNAME_REFERENCE;
    }

    @End
    public String tojiruBtnOnClick() {
        return null;
    }

    public String searchBtnOnClick() {

        uiBean.setSyoriKbn(E_SyoriKbn.KENSAKU);

        bizLogic.pushSearchBtnByYoyakuItiran();

        return FORWARDNAME_REFERENCE;
    }

    public String yoyakutourokubtnOnClick() {

        uiBean.setSyoriKbn(E_SyoriKbn.TOUROKU);

        bizLogic.pushYoyakuTourokuBtnByYoyakuItiran();

        return FORWARDNAME_TOUROKU;
    }

    public String syouninlinkOnClick() {

        uiBean.setSyoriKbn(E_SyoriKbn.SYOUNIN);

        bizLogic.syouninLinkOnClick();

        return FORWARDNAME_SYOUNIN;
    }

    public String sakujyoLinkOnClick() {

        uiBean.setSyoriKbn(E_SyoriKbn.SAKUJYO);

        bizLogic.sakujyoLinkOnClick();

        return FORWARDNAME_SAKUJYO;
    }

    @End(nested=true)
    public String modoruBtnByInputContentsOnClick() {

        switch(uiBean.getSyoriKbn()){

            case TOUROKU:

                bizLogic.pushModoruBtnByYoyakuTouroku();
                break;

            case SYOUNIN:

                bizLogic.pushModoruBtnByYoyakuSyounin();
                break;

            case SAKUJYO:

                bizLogic.pushModoruBtnByYoyakuSakujyo();
                break;

            default:
                break;

        }

        return FORWARDNAME_INIT;
    }

    public String kakuninBtnOnClick() {

        switch(uiBean.getSyoriKbn()){

            case TOUROKU:

                bizLogic.pushKakuninBtnByYoyakuTouroku();
                break;

            case SYOUNIN:

                bizLogic.pushKakuninBtnByYoyakuSyounin();
                break;

            case SAKUJYO:

                bizLogic.pushKakuninBtnByYoyakuSakujyo();
                break;

            default:
                break;
        }

        return FORWARDNAME_CONFIRM;
    }

    public String modoruBtnByConfirmOnClick() {

        bizLogic.pushModoruBtnByYoyakuKakunin();

        return getConfirmBackwardName();
    }

    @End
    public String kakuteiBtnOnClick() {

        bizLogic.pushKakuteiBtnBL();

        return FORWARDNAME_RESULT;
    }

    public String syokigamenheBtnOnClick() {

        return FORWARDNAME_INIT;
    }

    public String searchResultInfoPagerOnClick() {

        return FORWARDNAME_CURRENT;
    }


    private String getConfirmBackwardName(){
        switch(uiBean.getSenimotoKbnInput()){

            case DS_MAIL_HAISINYOYAKU_TOUROKU_GAMEN:

                return FORWARDNAME_TOUROKU;

            case DS_MAIL_HAISINYOYAKU_SYONIN_GAMEN:

                return FORWARDNAME_SYOUNIN;

            case DS_MAIL_HAISINYOYAKU_SAKUJYO_GAMEN:

                return FORWARDNAME_SAKUJYO;

            default:
                throw new UnknownForwardException();
        }
    }

}
