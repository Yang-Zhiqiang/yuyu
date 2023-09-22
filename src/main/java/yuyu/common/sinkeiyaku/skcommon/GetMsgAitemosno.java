package yuyu.common.sinkeiyaku.skcommon;

import javax.inject.Inject;

import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.def.MessageId;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;

/**
 * 新契約 新契約共通 相手申込番号ワーニングＭＳＧ取得
 */
public class GetMsgAitemosno {

    public static final int KEKKAKBN_NONE = 0;

    public static final int KEKKAKBN_ARI = 1;

    private String gmMsg = "";

    private String gmMsgid = "";

    @Inject
    private SinkeiyakuDomManager manager;

    public GetMsgAitemosno() {
        super();
    }

    public String getS_gmmsg() {
        return gmMsg;
    }

    public String getS_gmmsgid() {
        return gmMsgid;
    }

    public int exec(String pMosno) {

        HT_SyoriCTL syoriCT = manager.getSyoriCTL(pMosno);

        if (syoriCT == null) {

            return KEKKAKBN_NONE;
        }

        if (C_UmuKbn.ARI.eq(syoriCT.getMosnrkumu())) {

            HT_MosKihon mosKihon = syoriCT.getMosKihon();

            if (mosKihon == null) {

                throw new CommonBizAppException("申込番号=" + pMosno);
            }

            return exec(syoriCT.getMosnrkumu(), mosKihon.getAitemosno());
        }

        return KEKKAKBN_NONE;
    }

    public int exec(String pMosno, C_UmuKbn pMosnrkUmu) {

        if (C_UmuKbn.ARI.eq(pMosnrkUmu)) {

            HT_MosKihon mosKihon = manager.getSyoriCTL(pMosno).getMosKihon();

            if (mosKihon == null) {

                throw new CommonBizAppException("申込番号=" + pMosno);
            }

            return exec(pMosnrkUmu, mosKihon.getAitemosno());
        }

        return KEKKAKBN_NONE;
    }

    public int exec(C_UmuKbn pMosnrkUmu, String pAitemosno) {

        if (C_UmuKbn.ARI.eq(pMosnrkUmu) && !BizUtil.isBlank(pAitemosno)) {

            gmMsgid = MessageId.WHA1004;
            gmMsg = MessageUtil.getMessage(gmMsgid, pAitemosno);

            return KEKKAKBN_ARI;
        }

        return KEKKAKBN_NONE;
    }
}