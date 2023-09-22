package yuyu.common.sinkeiyaku.moschk;

import java.math.RoundingMode;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import jp.co.slcs.swak.util.message.MessageUtil;

import org.slf4j.Logger;

import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.def.MessageId;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_KetsrhkosKbn;
import yuyu.def.classification.C_MsgKbn;
import yuyu.def.classification.C_PWaribikiKbn;
import yuyu.def.classification.C_PWaribikitekiyouKbn;
import yuyu.def.classification.C_SpKeisanKahiKbn;
import yuyu.def.classification.C_SysKbn;
import yuyu.def.classification.C_TknKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_SyoriCTL;

/**
 * 新契約 申込内容チェック SP設定
 */
public class SetSP {

    private C_ErrorKbn errorKbn;

    @Inject
    private static Logger logger;

    @Inject
    private  SetHubiMsg setHubiMsg;

    public SetSP() {
        super();
    }

    public C_ErrorKbn getiErrorKbn() {
        return errorKbn;
    }

    public void exec(MosnaiCheckParam pMp) {

        if (logger.isDebugEnabled()) {
            logger.debug("▽ SP設定 開始");
        }

        errorKbn = C_ErrorKbn.OK;

        HT_SyoriCTL syoriCTL = pMp.getDataSyoriControl();
        KeisanSP keisanSP = SWAKInjector.getInstance(yuyu.common.sinkeiyaku.moschk.KeisanSP.class);

        keisanSP.exec(pMp);

        C_SysKbn sysKbn = pMp.getSysKbn();

        if (C_SysKbn.ESHIEN.eq(sysKbn)) {
            if (C_ErrorKbn.ERROR.eq(keisanSP.getiErrorKbn())) {

                String msg = MessageId.EHC0125 + " " + MessageUtil.getMessage(MessageId.EHC0125);

                setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                    msg,
                    pMp,
                    C_TknKbn.NONE,
                    C_MsgKbn.ERROR);
            }
        }
        else {
            if (C_ErrorKbn.ERROR.eq(keisanSP.getiErrorKbn())) {
                if (C_UmuKbn.ARI.eq(syoriCTL.getKthhbkbn()) &&
                    !C_SpKeisanKahiKbn.SPKEISANHUKA.eq(pMp.getKthjiSpKeisanKahiKbn())) {

                    String msg = MessageId.WHC1014 + " " + MessageUtil.getMessage(MessageId.WHC1014);

                    setHubiMsg.exec(C_KetsrhkosKbn.WARNING, msg, pMp, C_TknKbn.NONE, C_MsgKbn.WARNING);

                    pMp.setKthjiSpKeisanKahiKbn(C_SpKeisanKahiKbn.SPKEISANHUKA);
                }
                else {
                    throw new CommonBizAppException("申込番号=" + syoriCTL.getMosno());
                }
            }
        }

        HT_MosKihon mosKihon = syoriCTL.getMosKihon();

        C_PWaribikitekiyouKbn pwaribikitekiyouKbn = ketteiPWaribikitekiyouKbn(pMp, keisanSP);

        mosKihon.setSeitoufstpkei(keisanSP.getSeitoufstpkei());

        mosKihon.setFstphrkgk(keisanSP.getFstphrkgk());

        mosKihon.setHeijyunp(keisanSP.getHeijyunp());
        mosKihon.setHeijyunpryoumasinasi(keisanSP.getHeijyunpryoumasinasi());
        mosKihon.setIkkatup(keisanSP.getIkkatup());
        mosKihon.setZennoup(keisanSP.getZennoup());
        mosKihon.setZennoujyuutoup(keisanSP.getZennoujyuutoup());
        mosKihon.setHyouteip(keisanSP.getHyouteiP());
        mosKihon.setPharaikomisougaku(keisanSP.getPharaikomisougaku());
        mosKihon.setPwaribikitekiyoukbn(pwaribikitekiyouKbn);

        if (logger.isDebugEnabled()) {
            logger.debug("｜ MP.申込基本TBL.申込番号 = " + syoriCTL.getMosno());
            logger.debug("｜ MP.申込基本TBL.正当初回P合計額 = " + mosKihon.getSeitoufstpkei());
            logger.debug("｜ MP.申込基本TBL.初回P払込必要額 = " + mosKihon.getFstphrkgk());
            logger.debug("｜ MP.申込基本TBL.平準払Ｐ = " + mosKihon.getHeijyunp());
            logger.debug("｜ MP.申込基本TBL.平準払Ｐ（料増除） = " + mosKihon.getHeijyunpryoumasinasi());
            logger.debug("｜ MP.申込基本TBL.一括払Ｐ = " + mosKihon.getIkkatup());
            logger.debug("｜ MP.申込基本TBL.前納Ｐ = " + mosKihon.getZennoup());
            logger.debug("｜ MP.申込基本TBL.前納年払充当Ｐ = " + mosKihon.getZennoujyuutoup());
            logger.debug("｜ MP.申込基本TBL.保険料払込総額 = " + mosKihon.getPharaikomisougaku());
            logger.debug("｜ MP.申込基本TBL.保険料割引適用区分 = " + mosKihon.getPwaribikitekiyoukbn());

            logger.debug("△ SP設定 終了");
        }
    }

    private C_PWaribikitekiyouKbn ketteiPWaribikitekiyouKbn(MosnaiCheckParam pMosnaiCheckParam, KeisanSP pKeisanSP) {

        C_PWaribikitekiyouKbn pwaribikitekiyoukbn = pMosnaiCheckParam.getDataSyoriControl().getMosKihon().getPwaribikitekiyoukbn();

        if (C_ErrorKbn.ERROR.eq(pKeisanSP.getiErrorKbn())) {
            return pwaribikitekiyoukbn;
        }

        C_PWaribikiKbn pwaribikikbn = pMosnaiCheckParam.getSyuSyouhnZokusei().getPwaribikikbn();

        if (C_PWaribikiKbn.PWARISEIDO.eq(pwaribikikbn)) {

            int hrkkaisuu = Integer.valueOf(pMosnaiCheckParam.getDataSyoriControl().getMosKihon().getHrkkaisuu().getValue());
            BizCurrency tukiYenharaigk = pKeisanSP.getHeijyunp().divide(hrkkaisuu, 0, RoundingMode.UP);

            if (tukiYenharaigk.compareTo(BizCurrency.valueOf(15000, BizCurrencyTypes.YEN)) < 0) {
                pwaribikitekiyoukbn = C_PWaribikitekiyouKbn.PWARISEIDO_NONE;
            }
            else if (BizCurrency.valueOf(15000, BizCurrencyTypes.YEN).compareTo(tukiYenharaigk) <= 0
                && tukiYenharaigk.compareTo(BizCurrency.valueOf(30000, BizCurrencyTypes.YEN)) < 0) {
                pwaribikitekiyoukbn = C_PWaribikitekiyouKbn.PWARISEIDO_RANK01;
            }
            else if (BizCurrency.valueOf(30000, BizCurrencyTypes.YEN).compareTo(tukiYenharaigk) <= 0) {
                pwaribikitekiyoukbn = C_PWaribikitekiyouKbn.PWARISEIDO_RANK02;
            }

        }

        return pwaribikitekiyoukbn;

    }
}