package yuyu.common.sinkeiyaku.skcommon;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.date.CHolidayAdjustingMode;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_MosnoKanri;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;

/**
 * 新契約 新契約共通 申込消却予定日設定
 */
public class SetMossykykyoteiymd {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    public SetMossykykyoteiymd() {
        super();
    }

    public HT_MosnoKanri setMosskykyoteiymdSeiritu(HT_SyoriCTL pSyoriCTL, BizDate pSyoriymd, String pKosid) {

        String mosNoSub = pSyoriCTL.getMosno().substring(0, 8);

        HT_MosnoKanri mosnoKanri = sinkeiyakuDomManager.getMosnoKanri(mosNoSub);

        if (mosnoKanri == null) {
            return null;
        }


        BizDateYM syoriYM = pSyoriymd.getBizDateYM();

        HT_MosKihon mosKihon = pSyoriCTL.getMosKihon();

        syoriYM = syoriYM.addMonths(3);

        BizDateYM mosYM = mosKihon.getMosym().addMonths(14);

        BizDateYM mossykykYoteiYM = null;
        if (syoriYM.compareTo(mosYM) > 0) {
            mossykykYoteiYM = syoriYM;
        }
        else {
            mossykykYoteiYM = mosYM;
        }
        BizDate mossykykYoteiYmd = mossykykYoteiYM.getLastDay();

        mossykykYoteiYmd = mossykykYoteiYmd.getBusinessDay(CHolidayAdjustingMode.PREVIOUS);

        mosnoKanri.setMossykykyoteiymd(mossykykYoteiYmd);
        mosnoKanri.setGyoumuKousinsyaId(pKosid);
        mosnoKanri.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

        return mosnoKanri;
    }

    public HT_MosnoKanri setMosskykyoteiymdHuseiritu(HT_SyoriCTL pSyoriCTL, BizDate pSyoriymd, String pKosid) {

        String mosNoSub = pSyoriCTL.getMosno().substring(0, 8);

        HT_MosnoKanri mosnoKanri = sinkeiyakuDomManager.getMosnoKanri(mosNoSub);

        if (mosnoKanri == null) {
            return null;
        }

        BizDateYM syoriYM = pSyoriymd.getBizDateYM();

        BizDateYM mossykykYoteiYM = null;
        BizDate mossykykYoteiYmd = null;

        HT_MosKihon mosKihon = pSyoriCTL.getMosKihon();

        if (mosKihon.getMosym() != null) {
            syoriYM = syoriYM.addMonths(3);

            BizDateYM mosYM = mosKihon.getMosym().addMonths(14);

            if (syoriYM.compareTo(mosYM) > 0) {
                mossykykYoteiYM = syoriYM;
            }
            else {
                mossykykYoteiYM = mosYM;
            }
            mossykykYoteiYmd = mossykykYoteiYM.getLastDay();

            mossykykYoteiYmd = mossykykYoteiYmd.getBusinessDay(CHolidayAdjustingMode.PREVIOUS);
        }
        else if (C_UmuKbn.ARI.eq(pSyoriCTL.getMosnrkumu())) {
            syoriYM = syoriYM.addMonths(3);

            BizDateYM mosnrkYM = pSyoriCTL.getMosnrkymd().getBizDateYM();

            mosnrkYM = mosnrkYM.addMonths(14);

            if (syoriYM.compareTo(mosnrkYM) > 0) {
                mossykykYoteiYM = syoriYM;
            }
            else {
                mossykykYoteiYM = mosnrkYM;
            }
            mossykykYoteiYmd = mossykykYoteiYM.getLastDay();

            mossykykYoteiYmd = mossykykYoteiYmd.getBusinessDay(CHolidayAdjustingMode.PREVIOUS);
        }
        else {
            mossykykYoteiYM = syoriYM.addMonths(14);

            mossykykYoteiYmd = mossykykYoteiYM.getLastDay();

            mossykykYoteiYmd = mossykykYoteiYmd.getBusinessDay(CHolidayAdjustingMode.PREVIOUS);
        }

        mosnoKanri.setMossykykyoteiymd(mossykykYoteiYmd);
        mosnoKanri.setGyoumuKousinsyaId(pKosid);
        mosnoKanri.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

        return mosnoKanri;
    }

}
