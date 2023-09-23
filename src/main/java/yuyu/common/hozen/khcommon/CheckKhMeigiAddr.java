package yuyu.common.hozen.khcommon;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.bizinfr.exception.ErrorMessageCollector;
import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzChkAdrKetasuu;
import yuyu.common.biz.bzcommon.BzChkAdrKetasuuOutBean;
import yuyu.common.biz.bzcommon.CheckKana;
import yuyu.common.biz.bzcommon.CheckMeigininNmKanji;
import yuyu.def.MessageId;
import yuyu.def.biz.configuration.YuyuBizConfig;
import yuyu.def.classification.C_JyougenketasuutyoukaKbn;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_Kojinhjn;

/**
 * 契約保全 契約保全共通 契約保全名義住所チェック
 */
public class CheckKhMeigiAddr {

    @Inject
    private static Logger logger;

    @Inject
    private ErrorMessageCollector errorMessageCollector;

    public CheckKhMeigiAddr() {
        super();
    }

    public void exec(List<MeigiAddrBean> pMeigiAddrBeanLst) {

        logger.debug("▽ 契約保全名義住所チェック 開始");

        for (MeigiAddrBean meigiAddrBean : pMeigiAddrBeanLst) {

            if (!BizUtil.isBlank(meigiAddrBean.getNmKnFieldNm())) {

                if (!CheckKana.isKyokaMoji(meigiAddrBean.getNmKn())) {
                    errorMessageCollector.addMessage(MessageId.EBC0046, meigiAddrBean.getNmKnFieldNm());
                }

                if (!CheckKana.isKyoyouKetaHankaku(meigiAddrBean.getNmKn(),  YuyuBizConfig.getInstance().getKanaNmKyoyou())) {
                    errorMessageCollector.addMessage(MessageId.EBC0004, meigiAddrBean.getNmKnFieldNm(),
                        String.valueOf(YuyuBizConfig.getInstance().getKanaNmKyoyou()));
                }
            }

            if (!BizUtil.isBlank(meigiAddrBean.getNmKjFieldNm())) {
                if (!CheckMeigininNmKanji.isCheckOK(meigiAddrBean.getNmKj(), C_Kojinhjn.KOJIN)) {
                    errorMessageCollector.addMessage(MessageId.EBC0046, meigiAddrBean.getNmKjFieldNm());
                }

                if (BizUtil.isBlank(meigiAddrBean.getNmKj()) && !C_KjkhukaKbn.BLNK.eq(meigiAddrBean.getNmKjhukaKbn())) {
                    errorMessageCollector.addMessage(MessageId.EBC0043, meigiAddrBean.getNmKjFieldNm());
                }
            }

            if (!BizUtil.isBlank(meigiAddrBean.getSeiYmdFieldNm())) {

                if (BizDateUtil.compareYmd(meigiAddrBean.getSeiYmd(), meigiAddrBean.getSyoriYmd()) == BizDateUtil.COMPARE_GREATER) {
                    errorMessageCollector.addMessage(MessageId.EIA0037, meigiAddrBean.getSeiYmdFieldNm());
                }
            }

            if (!BizUtil.isBlank(meigiAddrBean.getAdrkjFieldNm())) {
                BzChkAdrKetasuu bzChkAdrKetasuu = SWAKInjector.getInstance(BzChkAdrKetasuu.class);

                BzChkAdrKetasuuOutBean bzChkAdrKetasuuOutBean = bzChkAdrKetasuu.exec(meigiAddrBean.getAdrkj1(),
                    meigiAddrBean.getAdrkj2(), meigiAddrBean.getAdrkj3());

                if (C_JyougenketasuutyoukaKbn.CYOUKA.eq(bzChkAdrKetasuuOutBean.getJyougenKetasuuTyoukaKbn())) {
                    errorMessageCollector.addMessage(MessageId.EBA1003, meigiAddrBean.getAdrkjFieldNm(),
                        String.valueOf(bzChkAdrKetasuuOutBean.getInKetasuu()),
                        String.valueOf(bzChkAdrKetasuuOutBean.getInJyougenKetasuu()));
                }
            }
        }

        if (errorMessageCollector.exists()) {
            throw new BizLogicException(errorMessageCollector);
        }

        logger.debug("△ 契約保全名義住所チェック 終了");
    }
}
