package yuyu.common.biz.kaikei;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.slf4j.Logger;

import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_SegbunruiKbn;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_SyouhnbetuSegment;

/**
 * 業務共通 経理・会計 セグメントコード取得
 */
public class BzSegmentCdSyutoku {

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private static Logger logger;

    public SyouhinbetuSegmentBean exec(String pSyouhnCd, C_Tuukasyu pKykTuukasyu) {

        logger.debug("▽ 商品別セグメントマスタ取得処理 開始");

        String syouhnCd = pSyouhnCd;
        C_Tuukasyu kykTuukasyu = pKykTuukasyu;
        C_SegbunruiKbn segbunruiKbn1 = C_SegbunruiKbn.BLNK;
        C_SegbunruiKbn segbunruiKbn2 =  C_SegbunruiKbn.BLNK;
        C_ErrorKbn errorKbn;
        C_Segcd segcd1;
        C_Segcd segcd2;

        BM_SyouhnbetuSegment syouhnbetuSegment =
            bizDomManager.getSyouhnbetuSegment(syouhnCd, kykTuukasyu, segbunruiKbn1, segbunruiKbn2);

        if (syouhnbetuSegment == null) {

            errorKbn = C_ErrorKbn.ERROR;
            segcd1 = null;
            segcd2 = null;

        }
        else {

            errorKbn = C_ErrorKbn.OK;
            segcd1 = syouhnbetuSegment.getSegcd();
            segcd2 = C_Segcd.BLNK;
        }

        SyouhinbetuSegmentBean syouhinbetuSegmentBean = SWAKInjector.getInstance(SyouhinbetuSegmentBean.class);

        syouhinbetuSegmentBean.setErrorKbn(errorKbn);
        syouhinbetuSegmentBean.setSegcd1(segcd1);
        syouhinbetuSegmentBean.setSegcd2(segcd2);

        logger.debug("△ 商品別セグメントマスタ取得処理 終了");

        return syouhinbetuSegmentBean;
    }
}
