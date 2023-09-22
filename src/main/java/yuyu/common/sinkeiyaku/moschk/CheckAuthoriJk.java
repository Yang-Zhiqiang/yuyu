package yuyu.common.sinkeiyaku.moschk;

import javax.inject.Inject;

import org.slf4j.Logger;

import yuyu.def.classification.C_FstphrkkeiroKbn;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_SknnkaisikitkhukaKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_SyoriCTL;

/**
 * 新契約 申込内容チェック オーソリ状況チェック
 */
public class CheckAuthoriJk {

    @Inject
    private static Logger logger;

    @Inject
    private SetHubiMsg setHubiMsg;

    public CheckAuthoriJk() {
        super();
    }

    public void exec(MosnaiCheckParam pMp) {

        if (logger.isDebugEnabled()) {
            logger.debug("▽ オーソリ状況チェック 開始");
        }

        HT_SyoriCTL syoriCTL = pMp.getDataSyoriControl();
        C_SeirituKbn seirituKbn = syoriCTL.getSeiritukbn();
        // TODO テーブル物理削除対応
        //        C_AuthorijkKbn authoriJkKbn = syoriCTL.getAuthorijkkbn();
        C_UmuKbn nyknNrkUmu = syoriCTL.getNyknnrkumu();

        long count = 0;

        HT_MosKihon mosKihon = syoriCTL.getMosKihon();
        C_FstphrkkeiroKbn fstPHrkKeiro = mosKihon.getFstphrkkeirokbn();
        C_SknnkaisikitkhukaKbn sknnKaisikiTkHukaKbn = mosKihon.getSknnkaisikitkhukakbn();

        if (C_SeirituKbn.NONE.eq(seirituKbn)
            && C_FstphrkkeiroKbn.CREDIT.eq(fstPHrkKeiro)
            && C_SknnkaisikitkhukaKbn.HUKA.eq(sknnKaisikiTkHukaKbn)) {
            // TODO テーブル物理削除対応
            //            if (C_AuthorijkKbn.IRAITYUU.eq(authoriJkKbn)) {
            //
            //                setHubiMsg.exec(C_KetsrhkosKbn.WARNING,
            //                    MessageId.WHC0071 + " " + MessageUtil.getMessage(
            //                        MessageId.WHC0071, authoriJkKbn.getContent()), pMp,
            //                        C_TknKbn.NONE, C_MsgKbn.WARNING);
            //            }
            //
            //            if (C_AuthorijkKbn.OK.eq(authoriJkKbn)) {
            //
            //                List<HT_AuthoriRireki> authoriRirekiLst = syoriCTL.getAuthoriRirekisByAuthorijkkbn(C_AuthorijkKbn.NG);
            //
            //                count = authoriRirekiLst.size();
            //            }
            //
            //            if (((count != 0) || (C_AuthorijkKbn.NG.eq(authoriJkKbn)))
            //                && (C_UmuKbn.NONE.eq(nyknNrkUmu))) {
            //
            //                BizDate sKykYmd = mosKihon.getSkykymd();
            //                BizDate kykYmd = mosKihon.getKykymd();
            //                kykYmd = kykYmd.getBizDateYM().getFirstDay();
            //
            //                if (sKykYmd == null) {
            //                    kykYmd =  kykYmd.getBizDateYM().getLastDay();
            //                    if (kykYmd.isHoliday()) {
            //                        kykYmd =  kykYmd.getBusinessDay(CHolidayAdjustingMode.PREVIOUS);
            //                    }
            //                }
            //                else {
            //                    kykYmd = kykYmd.getBizDateYM().getNextMonth().getLastDay();
            //                    if (kykYmd.isHoliday()) {
            //                        kykYmd =  kykYmd.getBusinessDay(CHolidayAdjustingMode.PREVIOUS);
            //                    }
            //                }
            //
            //                String warekiKykYmd = DateFormatUtil.dateDOT(kykYmd);
            //
            //                setHubiMsg.exec(C_KetsrhkosKbn.WARNING, MessageId.WHC0097 + " " +
            //                    MessageUtil.getMessage(MessageId.WHC0097, warekiKykYmd), pMp, C_TknKbn.NONE,
            //                    C_MsgKbn.WARNING);
            //            }
        }
        if (logger.isDebugEnabled()) {
            logger.debug("△ オーソリ状況チェック 終了");
        }
    }
}