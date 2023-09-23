package yuyu.common.siharai.chksk;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.def.classification.C_Bnshrkaisuu;
import yuyu.def.classification.C_Hkuktsyu;
import yuyu.def.classification.C_NkHaitoukinuketorihouKbn;
import yuyu.def.classification.C_Nstknsyu;
import yuyu.def.classification.C_SKNaiyouChkKbn;
import yuyu.def.classification.C_SUketoriHouhouKbn;
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_Tkhukaumu;
import yuyu.def.classification.C_TokuyakuNenkinsyuKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.JT_SiKykKihon;
import yuyu.def.db.entity.JT_SiUkt;

/**
 * 保険金給付金支払 請求内容チェック 年金請求チェック
 */
public class ChkSubNenkinSk {

    @Inject
    private static Logger logger;

    public ChkSubNenkinSk() {
        super();
    }

    public void exec(BizDate pSyoruiUkeYmd,
        C_SUketoriHouhouKbn pSUketoriHouhouKbn, C_Tkhukaumu pNstkHukaUmukbn,
        C_Nstknsyu pNkSyuKbn, Integer pNknShrY,
        C_Bnshrkaisuu pBnShrKaisuu, BizCurrency pNkkknJyutouGk,
        C_NkHaitoukinuketorihouKbn pNkHaitoukinUketoriHouKbn,
        BizDate pHanteiKijyunYmd, C_SeikyuuSyubetu pSeikyuuSyubetu,
        JT_SiKykKihon pSiKykKihon, List<ChkKekkaBean> pChkKekkaBeanLst) {

        logger.debug("▽ 年金請求チェック 開始");


        if (C_SUketoriHouhouKbn.ZENGAKU_ITIJIKN.eq(pSUketoriHouhouKbn)) {

            chkNksyurui(pNkSyuKbn, pChkKekkaBeanLst);

            chkNkshrkikan(pNknShrY, pChkKekkaBeanLst);

            chkBnshrkaisuu(pBnShrKaisuu, pChkKekkaBeanLst);

            chkNkkknjyutougk(pNkkknJyutouGk, pChkKekkaBeanLst);

            chkHaitoukinuketorihou(pNkHaitoukinUketoriHouKbn, pChkKekkaBeanLst);

        } else if (C_SUketoriHouhouKbn.ZENGAKU_NENKIN.eq(pSUketoriHouhouKbn)) {

            chkNksyuruiMinyuuryoku(pNkSyuKbn, pChkKekkaBeanLst);

            chkNkshrkikanMinyuuryoku(pNknShrY, pChkKekkaBeanLst);

            chkBnshrkaisuuMinyuuryoku(pBnShrKaisuu, pChkKekkaBeanLst);

            chkNkkknjyutougk(pNkkknJyutouGk, pChkKekkaBeanLst);

            chkHaitoukinuketorihouMinyuuryoku(pNkHaitoukinUketoriHouKbn, pChkKekkaBeanLst);

        } else if (C_SUketoriHouhouKbn.ITIBU_NENKIN.eq(pSUketoriHouhouKbn)) {

            chkNksyuruiMinyuuryoku(pNkSyuKbn, pChkKekkaBeanLst);

            chkNkshrkikanMinyuuryoku(pNknShrY, pChkKekkaBeanLst);

            chkBnshrkaisuuMinyuuryoku(pBnShrKaisuu, pChkKekkaBeanLst);

            chkNkkknjyutougkMinyuuryoku(pNkkknJyutouGk, pChkKekkaBeanLst);

            chkHaitoukinuketorihouMinyuuryoku(pNkHaitoukinUketoriHouKbn, pChkKekkaBeanLst);
        }


        if (C_UmuKbn.NONE.eq(pSiKykKihon.getNstkhkumu())) {

            if (C_Tkhukaumu.NONE.eq(pNstkHukaUmukbn)) {

                chkNkshrtkhukanasiZenitjknigai(pSUketoriHouhouKbn, pChkKekkaBeanLst);

            } else if (C_Tkhukaumu.HUKA.eq(pNstkHukaUmukbn)) {

                chkNkshrtkhukaZenitjkn(pSUketoriHouhouKbn, pChkKekkaBeanLst);
            }
        }


        if (C_UmuKbn.ARI.eq(pSiKykKihon.getNstkhkumu())
            || (C_UmuKbn.NONE.eq(pSiKykKihon.getNstkhkumu())
                && C_Tkhukaumu.HUKA.eq(pNstkHukaUmukbn))) {

            chkNkshrtkhukaUkthukusuu(pSeikyuuSyubetu, pSUketoriHouhouKbn,
                pSiKykKihon, pChkKekkaBeanLst);
        }


        if (C_UmuKbn.ARI.eq(pSiKykKihon.getNstkhkumu())) {

            chkNkshrtkhukaSys(pSUketoriHouhouKbn, pChkKekkaBeanLst);

            chkNkshrkaisigoItibu(pSyoruiUkeYmd, pSUketoriHouhouKbn,
                pHanteiKijyunYmd, pChkKekkaBeanLst);

            chkNkshrkaisigoNkshiharaihenkou(pSyoruiUkeYmd,
                pNknShrY, pBnShrKaisuu, pHanteiKijyunYmd,
                pSiKykKihon, pChkKekkaBeanLst);
        }

        logger.debug("△ 年金請求チェック 終了");
    }


    private void chkNksyurui(C_Nstknsyu pNkSyuKbn,
        List<ChkKekkaBean> pChkKekkaBeanLst) {

        if (!C_TokuyakuNenkinsyuKbn.BLNK.eq(C_TokuyakuNenkinsyuKbn
            .valueOf(pNkSyuKbn.getValue()))) {
            ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
            chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.NKSYU_CHK);
            pChkKekkaBeanLst.add(chkKekkaBean);
        }
    }

    private void chkNkshrkikan(Integer pNknShrY,
        List<ChkKekkaBean> pChkKekkaBeanLst) {

        if (pNknShrY != 0) {
            ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
            chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SHRKKN_CHK);
            pChkKekkaBeanLst.add(chkKekkaBean);
        }
    }

    private void chkBnshrkaisuu(C_Bnshrkaisuu pBnShrKaisuu,
        List<ChkKekkaBean> pChkKekkaBeanLst) {

        if (!C_Bnshrkaisuu.BLNK.eq(pBnShrKaisuu)) {
            ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
            chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.BNSHRKAISUU_CHK);
            pChkKekkaBeanLst.add(chkKekkaBean);
        }
    }

    private void chkNkkknjyutougk(BizCurrency pNenkinKikinJyuutouKingaku,
        List<ChkKekkaBean> pChkKekkaBeanLst) {

        if (!BizCurrency.valueOf(0).equalsValue(pNenkinKikinJyuutouKingaku)) {
            ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
            chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.NKKKN_CHK);
            pChkKekkaBeanLst.add(chkKekkaBean);
        }
    }

    private void chkHaitoukinuketorihou(
        C_NkHaitoukinuketorihouKbn pNkHaitoukinUketoriHouKbn,
        List<ChkKekkaBean> pChkKekkaBeanLst) {

        if (!C_NkHaitoukinuketorihouKbn.NONE.eq(pNkHaitoukinUketoriHouKbn)) {
            ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
            chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.HAITOUUKTR_CHK);
            pChkKekkaBeanLst.add(chkKekkaBean);
        }
    }

    private void chkNksyuruiMinyuuryoku(C_Nstknsyu pNkSyuKbn,
        List<ChkKekkaBean> pChkKekkaBeanLst) {

        if (C_TokuyakuNenkinsyuKbn.BLNK.eq(C_TokuyakuNenkinsyuKbn
            .valueOf(pNkSyuKbn.getValue()))) {
            ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
            chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.NKSYU_MINYUCHK);
            pChkKekkaBeanLst.add(chkKekkaBean);
        }
    }

    private void chkNkshrkikanMinyuuryoku(Integer pNknShrY,
        List<ChkKekkaBean> pChkKekkaBeanLst) {

        if (pNknShrY == 0) {
            ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
            chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SHRKKN_MINYUCHK);
            pChkKekkaBeanLst.add(chkKekkaBean);
        }
    }

    private void chkBnshrkaisuuMinyuuryoku(C_Bnshrkaisuu pBnShrKaisuu,
        List<ChkKekkaBean> pChkKekkaBeanLst) {

        if (C_Bnshrkaisuu.BLNK.eq(pBnShrKaisuu)) {
            ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
            chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.BNSHRKAISUU_MINYUCHK);
            pChkKekkaBeanLst.add(chkKekkaBean);
        }
    }

    private void chkNkkknjyutougkMinyuuryoku(BizCurrency pNkkknJyutouGk,
        List<ChkKekkaBean> pChkKekkaBeanLst) {

        if (BizCurrency.valueOf(0).equalsValue(pNkkknJyutouGk)) {
            ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
            chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.NKKKN_CHK_MINYUCHK);
            pChkKekkaBeanLst.add(chkKekkaBean);
        }
    }

    private void chkHaitoukinuketorihouMinyuuryoku(
        C_NkHaitoukinuketorihouKbn pNkHaitoukinUketoriHouKbn,
        List<ChkKekkaBean> pChkKekkaBeanLst) {

        if (C_NkHaitoukinuketorihouKbn.NONE.eq(pNkHaitoukinUketoriHouKbn)) {
            ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
            chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.HAITOUUKTR_MINYUCHK);
            pChkKekkaBeanLst.add(chkKekkaBean);
        }
    }

    private void chkNkshrtkhukanasiZenitjknigai(
        C_SUketoriHouhouKbn pSUketoriHouhouKbn,
        List<ChkKekkaBean> pChkKekkaBeanLst) {

        if (!C_SUketoriHouhouKbn.ZENGAKU_ITIJIKN.eq(pSUketoriHouhouKbn)) {
            ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
            chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.NSTK_NASICHK_ZNITIIGAI);
            pChkKekkaBeanLst.add(chkKekkaBean);
        }
    }

    private void chkNkshrtkhukaZenitjkn(C_SUketoriHouhouKbn pSUketoriHouhouKbn,
        List<ChkKekkaBean> pChkKekkaBeanLst) {

        if (C_SUketoriHouhouKbn.ZENGAKU_ITIJIKN.eq(pSUketoriHouhouKbn)) {
            ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
            chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.NSTK_CHK_ZNITII);
            pChkKekkaBeanLst.add(chkKekkaBean);
        }
    }

    private void chkNkshrtkhukaSys(C_SUketoriHouhouKbn pSUketoriHouhouKbn,
        List<ChkKekkaBean> pChkKekkaBeanLst) {

        if (C_SUketoriHouhouKbn.ZENGAKU_ITIJIKN.eq(pSUketoriHouhouKbn)) {
            ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
            chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.NSTK_CHK_NKSYS);
            pChkKekkaBeanLst.add(chkKekkaBean);
        }
    }

    private void chkNkshrtkhukaUkthukusuu(C_SeikyuuSyubetu pSeikyuuSyubetu,
        C_SUketoriHouhouKbn pSUketoriHouhouKbn, JT_SiKykKihon pSiKykKihon,
        List<ChkKekkaBean> pChkKekkaBeanLst) {

        if (C_SeikyuuSyubetu.SB.eq(pSeikyuuSyubetu)) {
            int sibouUketukeNinzuu = 0;

            for (JT_SiUkt e : pSiKykKihon.getSiUkts()) {
                if (C_Hkuktsyu.SBHKKUKT.eq(e.getHkuktsyu())
                    || C_Hkuktsyu.SBKYFKUKT.eq(e.getHkuktsyu())) {
                    sibouUketukeNinzuu = sibouUketukeNinzuu + 1;
                }
            }

            if (sibouUketukeNinzuu > 1) {
                if (!C_SUketoriHouhouKbn.ZENGAKU_ITIJIKN.eq(pSUketoriHouhouKbn)) {
                    ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
                    chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.NSTK_CHK_UKTHUKUSUU);
                    pChkKekkaBeanLst.add(chkKekkaBean);
                }
            }
        }
    }

    private void chkNkshrkaisigoItibu(BizDate pSyoruiUkeYmd,
        C_SUketoriHouhouKbn pSUketoriHouhouKbn, BizDate pHanteiKijyunYmd,
        List<ChkKekkaBean> pChkKekkaBeanLst) {

        BizDate syoribi = pHanteiKijyunYmd.addYears(1).getRekijyou();

        if (BizDateUtil.compareYmd(syoribi, pSyoruiUkeYmd) == BizDateUtil.COMPARE_LESSER) {
            if (C_SUketoriHouhouKbn.ITIBU_NENKIN.eq(pSUketoriHouhouKbn)) {
                ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
                chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.NKSHR_KAISIGO_CHK_ITINK);
                chkKekkaBean.setMsgHikisuu2(C_SUketoriHouhouKbn.ITIBU_NENKIN.getContent());
                pChkKekkaBeanLst.add(chkKekkaBean);
            }
        }
    }


    private void chkNkshrkaisigoNkshiharaihenkou(BizDate pSyoruiUkeYmd,
        Integer pNknShrY, C_Bnshrkaisuu pBnShrKaisuu,
        BizDate pHanteiKijyunYmd, JT_SiKykKihon pSiKykKihon,
        List<ChkKekkaBean> pChkKekkaBeanLst) {

        BizDate syoribi = pHanteiKijyunYmd.addYears(1).getRekijyou();

        if (BizDateUtil.compareYmd(syoribi, pSyoruiUkeYmd) == BizDateUtil.COMPARE_LESSER) {
            if (!pNknShrY.equals(pSiKykKihon.getNkshrtkyknksyukkn())
                || !C_Bnshrkaisuu.NEN1KAI.eq(pBnShrKaisuu)) {
                ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
                chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.NKSHR_KAISIGO_CHK_HENKOU);
                pChkKekkaBeanLst.add(chkKekkaBean);
            }
        }
    }
}
