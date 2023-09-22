package yuyu.common.sinkeiyaku.moschk;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.message.MessageUtil;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.ICommonKoumoku;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.def.MessageId;
import yuyu.def.classification.C_KakoymdkyytknKbn;
import yuyu.def.classification.C_KetsrhkosKbn;
import yuyu.def.classification.C_KituenKbn;
import yuyu.def.classification.C_SkeijimuKbn;
import yuyu.def.classification.C_SyosaiKbn;
import yuyu.def.classification.C_TknKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.HT_Houjyou;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.db.entity.HT_Tokunin;
import yuyu.def.sinkeiyaku.configuration.YuyuSinkeiyakuConfig;

/**
 * 新契約 申込内容チェック 報状TBLチェック
 */
public class CheckTblHoujyou {

    public final long KITUENHONSUU_ZERO  = 0;

    @Inject
    private static Logger logger;

    @Inject
    private SetHubiMsg setHubiMsg;

    public CheckTblHoujyou() {
        super();
    }

    public void exec(MosnaiCheckParam pMp) {

        if (logger.isDebugEnabled()) {
            logger.debug("▽ 報状テーブルチェック 開始");
        }

        HT_SyoriCTL syoriCTL = pMp.getDataSyoriControl();
        String mosNo = syoriCTL.getMosno();

        HT_Houjyou houjyouSyosin = syoriCTL.getHoujyouBySyosaikbn(C_SyosaiKbn.SOYSIN);

        if (houjyouSyosin == null) {
            throw new CommonBizAppException("申込番号 = " + mosNo);
        }
        BizDate kktYmd = houjyouSyosin.getKktymd();
        HT_Houjyou houjyouSaisin = syoriCTL.getHoujyouBySyosaikbn(C_SyosaiKbn.SAISIN);

        C_KakoymdkyytknKbn kakoymdkyytknKbn = null;

        HT_Tokunin tokuNin = syoriCTL.getTokunin();

        if (tokuNin != null) {
            kakoymdkyytknKbn = tokuNin.getKakoymdkyytknkbn();
        }
        else{
            kakoymdkyytknKbn = C_KakoymdkyytknKbn.NONE;
        }

        BizDate syoriYmd = pMp.getSysDate();
        BizDate syoriYmdMinus = syoriYmd.addDays(-YuyuSinkeiyakuConfig.getInstance().getKktKakoKyoyou());

        if ((syoriYmdMinus.compareTo(kktYmd) < 0 || syoriYmdMinus.compareTo(kktYmd) == 0) &&
                (kktYmd.compareTo(syoriYmd) < 0 || kktYmd.compareTo(syoriYmd) == 0)) {

        }
        else {
            C_TknKbn tknKbn = null;

            if (C_KakoymdkyytknKbn.NONE.eq(kakoymdkyytknKbn)) {
                tknKbn = C_TknKbn.KANOU;
            }
            else {
                tknKbn = C_TknKbn.SUMI;
            }

            setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                    makeMsg(MessageId.EBC0046, MessageId.EBC0046, ICommonKoumoku.DISP_S_KKTYMD),
                    pMp, tknKbn);
        }

        boolean saisinSonzaiFlg = false;
        C_SyosaiKbn syosinSaisinKbn = null;
        BizDate shinsaYmd = null;


        C_UmuKbn hjyNrkHbUmu = syoriCTL.getHjynrkhbumu();

        if (C_UmuKbn.NONE.eq(hjyNrkHbUmu) && houjyouSaisin != null) {
            saisinSonzaiFlg = true;
            syosinSaisinKbn = houjyouSaisin.getSyosaikbn();
            shinsaYmd       = houjyouSaisin.getSinsaymd();
        }
        else {
            syosinSaisinKbn = houjyouSyosin.getSyosaikbn();
            shinsaYmd       = houjyouSyosin.getSinsaymd();
        }

        int minus = 0;

        C_SkeijimuKbn skeiJimuKbn = syoriCTL.getSkeijimukbn();

        if (C_SkeijimuKbn.SHOP.eq(skeiJimuKbn)) {
            minus = YuyuSinkeiyakuConfig.getInstance().getSinsaKakoKyoyou();
        }
        else if (C_SkeijimuKbn.SMBC.eq(skeiJimuKbn)
                || C_SkeijimuKbn.TIGINSINKIN.eq(skeiJimuKbn)
                || C_SkeijimuKbn.SMTB.eq(skeiJimuKbn)
                || C_SkeijimuKbn.MIZUHO.eq(skeiJimuKbn)){
            minus = YuyuSinkeiyakuConfig.getInstance().getSinsaKakoKyoyouMdhn();
        }

        BizDate kktYmdMinus = kktYmd.addMonths(-minus).getRekijyou();

        if ((kktYmdMinus.compareTo(shinsaYmd) < 0 || kktYmdMinus.compareTo(shinsaYmd) == 0) &&
                (shinsaYmd.compareTo(syoriYmd) < 0 || shinsaYmd.compareTo(syoriYmd) == 0)) {
        }
        else {
            setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                    makeMsg(MessageId.EBC0046,
                            MessageId.EBC0046,
                            ICommonKoumoku.DISP_S_SINSAYMD
                            + "（"
                            + syosinSaisinKbn.getContent()
                            + "）"),
                            pMp);
        }

        if (saisinSonzaiFlg) {
            BizDate syosinShinsaYmd = houjyouSyosin.getSinsaymd();
            if (syosinShinsaYmd.compareTo(shinsaYmd) > 0) {
                setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                        makeMsg(MessageId.EHC0059,
                                MessageId.EHC0059,
                                ICommonKoumoku.DISP_S_SINSAYMD),
                                pMp);
            }
        }

        C_KituenKbn  kituenKbn         = houjyouSyosin.getKituenkbn();
        long          kituenhon        = houjyouSyosin.getKituenhon();

        if (C_KituenKbn.KITUEN.eq(kituenKbn)) {
            if (kituenhon <= KITUENHONSUU_ZERO) {
                setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                        MessageUtil.getMessage(MessageId.EBC0045,
                                MessageId.EBC0045 + " " + ICommonKoumoku.DISP_N_KITUENHON),
                                pMp);
            }
        }
        else {
            if (kituenhon > KITUENHONSUU_ZERO) {
                setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                        MessageUtil.getMessage(MessageId.EBC0007,
                                MessageId.EBC0007 + " " + ICommonKoumoku.DISP_N_KITUENHON),
                                pMp);
            }
        }

        if (logger.isDebugEnabled()) {
            logger.debug("△ 報状テーブルチェック 終了");
        }

    }

    private String makeMsg(String pInMessageID, String pMsgID, String pReplaceMsg1) {

        StringBuffer ret = new StringBuffer();
        ret.append(pInMessageID);
        ret.append(" ");
        ret.append(MessageUtil.getMessage(pMsgID, pReplaceMsg1));
        return ret.toString();
    }

}
