package yuyu.common.sinkeiyaku.moschk;

import java.util.List;

import jp.co.slcs.swak.core.classification.Classification;
import jp.co.slcs.swak.date.BizDate;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_KykKbn;
import yuyu.def.classification.C_Kyksei;
import yuyu.def.classification.C_Seibetu;
import yuyu.def.classification.C_SknnkaisikitkhukaKbn;
import yuyu.def.classification.C_SysKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TknKbn;
import yuyu.def.classification.C_YakuwariKbn;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_MosSyouhn;
import yuyu.def.db.entity.HT_SyoriCTL;

/**
 * 新契約 申込内容チェック フリーインシュアランスチェック
 */
public class CheckFreeInsurance {

    public CheckFreeInsurance() {
        super();
    }

    public void exec(MosnaiCheckParam pMp, C_Seibetu pSei, String pSyuSyouhinCd, C_TknKbn pTknkbn) {

        HT_SyoriCTL syoriCTL = pMp.getDataSyoriControl();
        String mosNo = syoriCTL.getMosno();

        HT_MosKihon mosKihon = syoriCTL.getMosKihon();
        C_KykKbn kykKbn = mosKihon.getKykkbn();
        C_Kyksei kykSei = mosKihon.getKyksei();
        String kykNmKn = mosKihon.getKyknmkn();
        BizDate kykSeiYmd = mosKihon.getKykseiymd();
        C_Hhknsei hhknSei = mosKihon.getHhknsei();
        String hhknNmKn = mosKihon.getHhknnmkn();
        BizDate hhknSeiYmd = mosKihon.getHhknseiymd();
        C_SknnkaisikitkhukaKbn sknKskTkkKbn = mosKihon.getSknnkaisikitkhukakbn();

        C_SysKbn sysKbn = pMp.getSysKbn();

        Classification<?> hnknMaeSeiKbn;
        C_Seibetu seiKbn = C_Seibetu.BLNK;
        C_YakuwariKbn yakuwariKbn;
        String smKn;
        BizDate seiYmd;

        if (C_SysKbn.ESHIEN.eq(sysKbn) &&  !C_SknnkaisikitkhukaKbn.HUKA.eq(sknKskTkkKbn)) {
            return;
        }

        String syuSyouhinCd = null;

        if (BizUtil.isBlank(pSyuSyouhinCd)) {

            if (C_SysKbn.SKEI.eq(sysKbn)) {

                List<HT_MosSyouhn> mosSyouhnList = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

                if (mosSyouhnList == null || mosSyouhnList.size() == 0) {
                    throw new CommonBizAppException("申込番号：" + mosNo);
                }

                syuSyouhinCd = mosSyouhnList.get(0).getSyouhncd();
            }
        }
        else {
            syuSyouhinCd = pSyuSyouhinCd;
        }

        if (!C_KykKbn.KEIHI_DOUITU.eq(kykKbn)) {

            hnknMaeSeiKbn = kykSei;
            yakuwariKbn = C_YakuwariKbn.KYK;
            smKn = kykNmKn;
            seiYmd = kykSeiYmd;
        }
        else {
            hnknMaeSeiKbn = hhknSei;
            yakuwariKbn = C_YakuwariKbn.HHKN;
            smKn = hhknNmKn;
            seiYmd = hhknSeiYmd;
        }

        if (C_Seibetu.BLNK.eq(pSei)) {

            seiKbn = getCheckMrInfoSeibetu(hnknMaeSeiKbn, yakuwariKbn);
        }
        else {
            seiKbn = pSei;
        }

        //  2016/03/23 S社導入：コメントアウト
        //        checkMRInfo.exec(C_YakuwariKbn.KYK, smKn, seiYmd, seiKbn, syuSyouhinCd, kinouId);
        //
        //        msgIdLists = checkMRInfo.getmsgIdList();
        //        msgLists = checkMRInfo.getMsgList();
        //
        //        if (msgIdLists != null && msgIdLists.length > 0) {
        //
        //            pMp.setFreeinsuranceUmu(C_UmuKbn.ARI);
        //
        //            if (C_SysKbn.SKEI.eq(sysKbn) && C_SknnkaisikitkhukaKbn.HUKA.eq(sknKskTkkKbn)) {
        //
        //                C_KetsrhkosKbn ketSrhkoskbn = C_KetsrhkosKbn.SRHORYU_HUBI;
        //                C_MsgKbn msgkbn = C_MsgKbn.ERROR;
        //
        //                for (int index = 0; index < msgIdLists.length; index++) {
        //
        //                    msg = makeMsg(msgIdLists[index], msgLists[index]);
        //                    setHubiMsg.exec(ketSrhkoskbn, msg, pMp, pTknkbn, msgkbn);
        //
        //                    msg = null;
        //                }
        //            }
        //            else if (C_SysKbn.ESHIEN.eq(sysKbn)) {
        //
        //                pMp.setSakuinTsnKbn(C_SakuintsnKbn.ERROR);
        //                pMp.setChkKekkaKbn(C_ChkkekkaKbn.ERROR);
        //
        //                C_KetsrhkosKbn ketSrhkoskbn = C_KetsrhkosKbn.KETHORYU_HUBI;
        //                C_MsgKbn msgkbn = C_MsgKbn.ERROR;
        //
        //                msg = makeMsg(MessageId.EHC0159, MessageUtil.getMessage(
        //                        MessageId.EHC0159, C_YakuwariKbn.KYK.getContent()));
        //
        //                setHubiMsg.exec(ketSrhkoskbn, msg, pMp, C_TknKbn.NONE, msgkbn);
        //            }
        //        }

    }

    private C_Seibetu getCheckMrInfoSeibetu(Classification<?> pHnknMaeSeiKbn, C_YakuwariKbn pYakuwariKbn) {

        C_Seibetu sei = C_Seibetu.BLNK;

        if (C_YakuwariKbn.KYK.eq(pYakuwariKbn)) {

            if (C_Kyksei.MALE.eq((C_Kyksei)pHnknMaeSeiKbn)) {

                sei = C_Seibetu.MALE;
            }
            else if (C_Kyksei.FEMALE.eq((C_Kyksei)pHnknMaeSeiKbn)) {

                sei = C_Seibetu.FEMALE;
            }
        }
        else if (C_YakuwariKbn.HHKN.eq(pYakuwariKbn)) {

            if (C_Hhknsei.MALE.eq((C_Hhknsei)pHnknMaeSeiKbn)) {

                sei = C_Seibetu.MALE;
            }
            else if (C_Hhknsei.FEMALE.eq((C_Hhknsei)pHnknMaeSeiKbn)) {

                sei = C_Seibetu.FEMALE;
            }
        }

        return sei;
    }

    //  2016/03/23 S社導入：コメントアウト
    //    private String makeMsg(String pInMessageId, String pMsg) {
    //        StringBuffer ret = new StringBuffer();
    //        ret.append(pInMessageId);
    //        ret.append(" ");
    //        ret.append(pMsg);
    //        return ret.toString();
    //    }

}