package yuyu.common.siharai.chksk;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.hozen.khcommon.HanteiKhSisuurendoTmttknJyoutai;
import yuyu.common.hozen.khcommon.HanteiTmttknJyoutaiBean;
import yuyu.def.classification.C_SKNaiyouChkKbn;

/**
 * 保険金給付金支払 請求内容チェック 積立金状態チェック
 */
public class ChkSubTmttknJyoutai {

    @Inject
    private static Logger logger;

    public ChkSubTmttknJyoutai() {
        super();
    }

    public void exec(BizDate pHanteikijyunymd,
        String pSyono,
        BizDate pKykymd,
        BizDate pTmttknitenymd,
        List<ChkKekkaBean> pChkKekkaBeanLst) {

        logger.debug("▽ 積立金状態チェック 開始");
        if (pHanteikijyunymd != null &&
            pSyono != null &&
            pKykymd != null) {

            if (BizDateUtil.compareYmd(pHanteikijyunymd, pKykymd) == BizDateUtil.COMPARE_LESSER) {
                logger.debug("△ 積立金状態チェック 終了");
                return;
            }
            HanteiKhSisuurendoTmttknJyoutai hanteiKhSisuurendoTmttknJyoutai =
                SWAKInjector.getInstance(HanteiKhSisuurendoTmttknJyoutai.class);
            HanteiTmttknJyoutaiBean hanteiTmttknJyoutaiBean =
                SWAKInjector.getInstance(HanteiTmttknJyoutaiBean.class);
            hanteiTmttknJyoutaiBean.setSyono(pSyono);
            hanteiTmttknJyoutaiBean.setHanteiKijyunymd(pHanteikijyunymd);
            hanteiTmttknJyoutaiBean.setKykymd(pKykymd);
            boolean result = hanteiKhSisuurendoTmttknJyoutai.execChokuzenOutouymTmttknHantei(hanteiTmttknJyoutaiBean);

            if (!result) {
                ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
                chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.TMTTKIN_MIHANEI_CHK);
                pChkKekkaBeanLst.add(chkKekkaBean);
            }

            if (pTmttknitenymd != null) {
                if (BizDateUtil.compareYmd(pTmttknitenymd, pHanteikijyunymd) == BizDateUtil.COMPARE_GREATER) {
                    ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
                    chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.TMTTKIN_ITENBI_CHK);
                    pChkKekkaBeanLst.add(chkKekkaBean);
                }
            }
        }

        logger.debug("△ 積立金状態チェック 終了");
    }
}
