package yuyu.app.biz.bzkyoutuusyoukai.bzkensyouyouratedbsyoukai;

import static yuyu.app.biz.bzkyoutuusyoukai.bzkensyouyouratedbsyoukai.GenBzKensyouyouRatedbsyoukaiConstants.*;

import javax.inject.Inject;

import jp.co.slcs.swak.web.auth.permission.Roles;
import jp.co.slcs.swak.web.config.annotations.Forward;
import jp.co.slcs.swak.web.config.annotations.Forwards;
import jp.co.slcs.swak.web.config.annotations.Input;
import jp.co.slcs.swak.web.config.annotations.UIBean;
import jp.co.slcs.swak.web.conversation.annotations.Begin;
import jp.co.slcs.swak.web.conversation.annotations.End;

/**
 * 検証用レートＤＢ照会 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,     page=PAGENO_INIT,     path="/biz/bzkyoutuusyoukai/bzkensyouyouratedbsyoukai/BzKensyouyouRatedbsyoukai.do", redirect=true),
    @Forward(name=FORWARDNAME_INPUTKEY, page=PAGENO_INPUTKEY, path="/biz/bzkyoutuusyoukai/bzkensyouyouratedbsyoukai/bz_kensyouyou_ratedbsyoukai.jsp"),
    @Forward(name=FORWARDNAME_RESULT,   page=PAGENO_RESULT,   path="/biz/bzkyoutuusyoukai/bzkensyouyouratedbsyoukai/bz_kensyouyou_ratedbsyoukai.jsp"),
})
@Input("/biz/bzkyoutuusyoukai/bzkensyouyouratedbsyoukai/bz_kensyouyou_ratedbsyoukai.jsp")
@UIBean(beanClass=BzKensyouyouRatedbsyoukaiUiBean.class)
@Roles("bzkensyouyouratedbsyoukai")
public class BzKensyouyouRatedbsyoukaiAction {

    @Inject
    private BzKensyouyouRatedbsyoukaiBizLogic bizLogic;

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
        bizLogic.pushSyoukaibtnbyinputkeyBL();
        return FORWARDNAME_RESULT;
    }

    public String modorubtnbyresultrateOnClick() {
        return FORWARDNAME_INPUTKEY;
    }

    public void print() {
        bizLogic.pushPrintReportBL();
    }

    public String functionNameOnClick() {
        return FORWARDNAME_INPUTKEY;
    }
}
