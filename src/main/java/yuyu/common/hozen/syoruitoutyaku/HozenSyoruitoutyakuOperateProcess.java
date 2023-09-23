package yuyu.common.hozen.syoruitoutyaku;

import yuyu.common.biz.syoruitoutyaku.SyoruitoutyakuOperateProcess;
import yuyu.common.hozen.khcommon.IKhozenCommonConstants;
import yuyu.def.classification.C_SyoruiCdKbn;

/**
 * 契約保全 書類到着 契約保全書類到着時工程操作処理
 */
public class HozenSyoruitoutyakuOperateProcess extends SyoruitoutyakuOperateProcess {

    public HozenSyoruitoutyakuOperateProcess() {
        super();
    }

    private String syoruiToutyakuNodeId;

    @Override
    public boolean hanteiToutyakuProcessForwardSyoruiCd(C_SyoruiCdKbn pSyoruiCdKbn) {

        boolean result = false;
        syoruiToutyakuNodeId = "";

        if (C_SyoruiCdKbn.KK_SYOSAIHK_SKS.eq(pSyoruiCdKbn) ||
            C_SyoruiCdKbn.KK_MEIGIHNK_SKS.eq(pSyoruiCdKbn) ||
            C_SyoruiCdKbn.KK_SEINENGAPPISEI_SKS.eq(pSyoruiCdKbn) ||
            C_SyoruiCdKbn.KK_GENGAKU_SKS.eq(pSyoruiCdKbn) ||
            C_SyoruiCdKbn.KK_KAIYAKU_SKS.eq(pSyoruiCdKbn) ||
            C_SyoruiCdKbn.KK_ADRHNK_SKS.eq(pSyoruiCdKbn) ||
            C_SyoruiCdKbn.KK_STDRHNK_SKS.eq(pSyoruiCdKbn) ||
            C_SyoruiCdKbn.KK_KAIGOMAETKHNK_SKS.eq(pSyoruiCdKbn) ||
            C_SyoruiCdKbn.KK_MKHGKHNK_SKS.eq(pSyoruiCdKbn) ||
            C_SyoruiCdKbn.KK_YENDTHNKHNRKN_SKS.eq(pSyoruiCdKbn) ||
            C_SyoruiCdKbn.KK_TUMITATEKINITEN_SKS.eq(pSyoruiCdKbn) ||
            C_SyoruiCdKbn.KK_DSHR_SKS.eq(pSyoruiCdKbn) ||
            C_SyoruiCdKbn.AS_PKZHRIKEIRAI.eq(pSyoruiCdKbn) ||
            C_SyoruiCdKbn.AS_PHRKKAISUUHENKOUMOS.eq(pSyoruiCdKbn) ||
            C_SyoruiCdKbn.AS_CREDITCARDMOS.eq(pSyoruiCdKbn) ||
            C_SyoruiCdKbn.KK_YENDTHNK_SKS.eq(pSyoruiCdKbn) ||
            C_SyoruiCdKbn.KK_KZKTRKKYKDRTKYKHNK_SKS.eq(pSyoruiCdKbn)) {

            syoruiToutyakuNodeId = IKhozenCommonConstants.NODEID_SYORUITOUTYAKU;
            result = true;

        }
        else if (C_SyoruiCdKbn.KK_SYOSAIHK_HB.eq(pSyoruiCdKbn) ||
            C_SyoruiCdKbn.KK_MEIGIHNK_HB.eq(pSyoruiCdKbn) ||
            C_SyoruiCdKbn.KK_SEINENGAPPISEI_HB.eq(pSyoruiCdKbn) ||
            C_SyoruiCdKbn.KK_GENGAKU_HB.eq(pSyoruiCdKbn) ||
            C_SyoruiCdKbn.KK_KAIYAKU_HB.eq(pSyoruiCdKbn) ||
            C_SyoruiCdKbn.KK_ADRHNK_HB.eq(pSyoruiCdKbn) ||
            C_SyoruiCdKbn.KK_KYKTORIKESI_HB.eq(pSyoruiCdKbn) ||
            C_SyoruiCdKbn.KK_CLGOFF_HB.eq(pSyoruiCdKbn) ||
            C_SyoruiCdKbn.KK_KAIJYO_HB.eq(pSyoruiCdKbn) ||
            C_SyoruiCdKbn.KK_MUKOU_HB.eq(pSyoruiCdKbn) ||
            C_SyoruiCdKbn.KK_SBKAIJYO_HB.eq(pSyoruiCdKbn) ||
            C_SyoruiCdKbn.KK_SBMENSEKI_HB.eq(pSyoruiCdKbn) ||
            C_SyoruiCdKbn.KK_STDRHNK_HB.eq(pSyoruiCdKbn) ||
            C_SyoruiCdKbn.KK_KAIGOMAETKHNK_HB.eq(pSyoruiCdKbn) ||
            C_SyoruiCdKbn.KK_SBMUKOU_HB.eq(pSyoruiCdKbn) ||
            C_SyoruiCdKbn.KK_SBMUKOUNOSHR_HB.eq(pSyoruiCdKbn) ||
            C_SyoruiCdKbn.KK_SBMENSEKINOSHR_HB.eq(pSyoruiCdKbn) ||
            C_SyoruiCdKbn.KK_MKHGKHNK_HB.eq(pSyoruiCdKbn) ||
            C_SyoruiCdKbn.KK_YENDTHNKHNRKN_HB.eq(pSyoruiCdKbn) ||
            C_SyoruiCdKbn.KK_TUMITATEKINITEN_HB.eq(pSyoruiCdKbn) ||
            C_SyoruiCdKbn.KK_DSHR_HB.eq(pSyoruiCdKbn) ||
            C_SyoruiCdKbn.AS_HRHN_HB.eq(pSyoruiCdKbn) ||
            C_SyoruiCdKbn.KK_YENDTHNK_NINI_HB.eq(pSyoruiCdKbn) ||
            C_SyoruiCdKbn.KK_KZKTRK_KYKDRTKYKHNK_HB.eq(pSyoruiCdKbn)) {

            syoruiToutyakuNodeId = IKhozenCommonConstants.NODEID_HUBIKAITOUMATI;
            result = true;
        }

        return result;
    }

    @Override
    public String getSyoruitoutyakuNodeId() {

        return syoruiToutyakuNodeId;
    }
}
