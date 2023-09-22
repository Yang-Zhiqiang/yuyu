package yuyu.common.sinkeiyaku.moschk;

import javax.inject.Inject;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.ICommonKoumoku;
import yuyu.def.MessageId;
import yuyu.def.classification.C_FstphrkkeiroKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_IkkatubaraiKaisuuKbn;
import yuyu.def.classification.C_KetsrhkosKbn;
import yuyu.def.classification.C_MsgKbn;
import yuyu.def.classification.C_SkeijimuKbn;
import yuyu.def.classification.C_SysKbn;
import yuyu.def.classification.C_TknKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.HT_MosKihon;

/**
 * 新契約 申込内容チェック 払込経路チェック
 */
public class CheckHrkKeiro {

    @Inject
    private static Logger logger;

    @Inject
    private SetHubiMsg setHubiMsg;

    public CheckHrkKeiro() {
        super();
    }

    public void exec(MosnaiCheckParam pMP, BM_SyouhnZokusei pSyouhinZokusei) {

        HT_MosKihon mosKihon;
        C_Hrkkaisuu hrkkaisuu;
        C_Hrkkeiro hrkkeiro;
        C_FstphrkkeiroKbn fstphrkkeiroKbn;
        C_UmuKbn zennouUmu;
        C_UmuKbn creditcardhrtekiUmu;
        String syouhnNm;
        C_SysKbn sysKbn;

        if (logger.isDebugEnabled()) {
            logger.debug("▽ 払込経路チェック 開始");
        }

        C_SkeijimuKbn skeijimuKbn = pMP.getDataSyoriControl().getSkeijimukbn();
        mosKihon = pMP.getDataSyoriControl().getMosKihon();
        hrkkaisuu = mosKihon.getHrkkaisuu();
        hrkkeiro = mosKihon.getHrkkeiro();
        fstphrkkeiroKbn = mosKihon.getFstphrkkeirokbn();
        C_IkkatubaraiKaisuuKbn ikkatubaraiKaisuu = mosKihon.getIkkatubaraikaisuu();
        zennouUmu = pSyouhinZokusei.getZennouumu();
        creditcardhrtekiUmu = pSyouhinZokusei.getCreditcardhrtekiumu();
        syouhnNm = pSyouhinZokusei.getSyouhnnm();
        sysKbn = pMP.getSysKbn();

        if (!C_Hrkkaisuu.ITIJI.eq(hrkkaisuu)) {
            if (C_Hrkkeiro.BLNK.eq(hrkkeiro)) {
                setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                    MakeHubiMsg.exec(MessageId.EBA0027, MessageId.EBA0027,
                        ICommonKoumoku.DISP_N_HRKKEIRO),pMP);
            }
        }

        if (C_Hrkkeiro.HURIKAE.eq(hrkkeiro)) {
            if (C_UmuKbn.NONE.eq(zennouUmu)) {
                setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                    MakeHubiMsg.exec(MessageId.EHC0019, MessageId.EHC0019,
                        syouhnNm, hrkkeiro.getContent()),pMP);
            }
        }

        if (C_Hrkkeiro.CREDIT.eq(hrkkeiro)) {
            if (C_UmuKbn.NONE.eq(creditcardhrtekiUmu)) {
                setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                    MakeHubiMsg.exec(MessageId.EHC0019, MessageId.EHC0019, syouhnNm, hrkkeiro.getContent()),
                    pMP);
            }
        }

        if ((C_Hrkkeiro.KOUHURI.eq(hrkkeiro)
            || C_Hrkkeiro.HURIKAE.eq(hrkkeiro))
            && !C_FstphrkkeiroKbn.HURIKOMI.eq(fstphrkkeiroKbn)) {
            setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                MakeHubiMsg.exec(MessageId.EHC0111, MessageId.EHC0111),
                pMP);

        }

        if (C_Hrkkeiro.CREDIT.eq(hrkkeiro)
            && !C_FstphrkkeiroKbn.HURIKOMI.eq(fstphrkkeiroKbn)
            && !C_FstphrkkeiroKbn.CREDIT.eq(fstphrkkeiroKbn)) {
            setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                MakeHubiMsg.exec(MessageId.EHC0111, MessageId.EHC0111),
                pMP);
        }

        if (C_FstphrkkeiroKbn.CREDIT.eq(fstphrkkeiroKbn) && !C_Hrkkeiro.CREDIT.eq(hrkkeiro)) {
            setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                MakeHubiMsg.exec(MessageId.EHC0111, MessageId.EHC0111),
                pMP);
        }

        if (C_FstphrkkeiroKbn.CREDIT.eq(fstphrkkeiroKbn) && !C_SkeijimuKbn.SHOP.eq(skeijimuKbn)) {
            setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                MakeHubiMsg.exec(MessageId.EHC1127, MessageId.EHC1127, fstphrkkeiroKbn.getContent()),
                pMP);
        }

        if (C_Hrkkaisuu.ITIJI.eq(hrkkaisuu)) {
            if (!C_FstphrkkeiroKbn.HURIKOMI.eq(fstphrkkeiroKbn)) {
                setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                    MakeHubiMsg.exec(MessageId.EHC0165, MessageId.EHC0165,
                        fstphrkkeiroKbn.getContent(), hrkkaisuu.getContent()),
                        pMP);
            }
        }

        if (!C_Hrkkaisuu.TUKI.eq(hrkkaisuu)) {
            if (C_FstphrkkeiroKbn.CREDIT.eq(fstphrkkeiroKbn) || C_Hrkkeiro.CREDIT.eq(hrkkeiro)) {
                setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                    MakeHubiMsg.exec(MessageId.EHC0209, MessageId.EHC0209, hrkkaisuu.getContent()),
                    pMP,
                    C_TknKbn.NONE,
                    C_MsgKbn.ERROR);
            }
        }

        if(!C_IkkatubaraiKaisuuKbn.BLNK.eq(ikkatubaraiKaisuu)){
            if (C_FstphrkkeiroKbn.CREDIT.eq(fstphrkkeiroKbn) || C_Hrkkeiro.CREDIT.eq(hrkkeiro)) {
                setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                    MakeHubiMsg.exec(MessageId.EHC0209, MessageId.EHC0209, ikkatubaraiKaisuu.getContent()),
                    pMP,
                    C_TknKbn.NONE,
                    C_MsgKbn.ERROR);
            }
        }

        if (logger.isDebugEnabled()) {
            logger.debug("△ 払込経路チェック 終了");
        }
    }
}