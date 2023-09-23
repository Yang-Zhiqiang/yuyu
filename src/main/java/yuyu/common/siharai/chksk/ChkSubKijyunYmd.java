package yuyu.common.siharai.chksk;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.koutei.BzGetProcessSummary;
import yuyu.common.biz.koutei.BzGetProcessSummaryInBean;
import yuyu.common.biz.koutei.BzGetProcessSummaryOutBean;
import yuyu.common.siharai.sicommon.TeisuuSiharai;
import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.classification.C_SKNaiyouChkKbn;
import yuyu.def.db.entity.JT_SiKykKihon;

/**
 * 保険金給付金支払 請求内容チェック 基準日チェック
 */
public class ChkSubKijyunYmd {

    @Inject
    private static Logger logger;

    public ChkSubKijyunYmd() {
        super();
    }

    public void exec(BizDate pSyoruiUketukeYmd, BizDate pHanteiKijyunYmd, BizDate pHubiKanryouYmd,
        String pSkno, String pSyono, JT_SiKykKihon pSiKykKihon, List<ChkKekkaBean> pChkKekkaBeanList) {

        logger.debug("▽ 基準日チェック 開始");

        if (pHanteiKijyunYmd == null) {

            ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
            chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.KIJYUNYMD_MINYUCHK);
            pChkKekkaBeanList.add(chkKekkaBean);
        }
        else {

            chkKijyunbiSyorui(pSyoruiUketukeYmd, pHanteiKijyunYmd, pChkKekkaBeanList);
            chkKiJyunbiKeiyakuHenko(pHanteiKijyunYmd, pSiKykKihon, pChkKekkaBeanList);
            chkKijyunbiHaraikata(pHanteiKijyunYmd, pSiKykKihon, pChkKekkaBeanList);
        }

        BizDate systemYmd = BizDate.getSysDate();

        if (BizDateUtil.compareYmd(pSyoruiUketukeYmd, systemYmd) == BizDateUtil.COMPARE_GREATER) {

            ChkKekkaBean chkKekkaSysBean = SWAKInjector.getInstance(ChkKekkaBean.class);
            chkKekkaSysBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SYORUIUKEYMD_SAKICHK);
            pChkKekkaBeanList.add(chkKekkaSysBean);
        }

        if (pHubiKanryouYmd != null) {

            chkHubiSakihiduke(pHubiKanryouYmd, pChkKekkaBeanList);
            chkHubiSyorui(pSyoruiUketukeYmd, pHubiKanryouYmd, pChkKekkaBeanList);
        } else {
            chkHubiUmu(pSkno, pSyono, pChkKekkaBeanList);
        }

        logger.debug("△ 基準日チェック 終了");

    }

    private void chkKijyunbiSyorui(BizDate pSyoruiUketukeYmd, BizDate pHanteiKijyunYmd,
        List<ChkKekkaBean> pChkKekkaBeanList) {

        if (BizDateUtil.compareYmd(pSyoruiUketukeYmd, pHanteiKijyunYmd) == BizDateUtil.COMPARE_LESSER ||
            BizDateUtil.compareYmd(pSyoruiUketukeYmd, pHanteiKijyunYmd) == BizDateUtil.COMPARE_EQUAL) {

            ChkKekkaBean chkKekkaSyoruiBean = SWAKInjector.getInstance(ChkKekkaBean.class);
            chkKekkaSyoruiBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.KIJYUN_SYORUIUKE_SKCHK);
            pChkKekkaBeanList.add(chkKekkaSyoruiBean);
        }
    }

    private void chkKiJyunbiKeiyakuHenko(BizDate pHanteiKijyunYmd, JT_SiKykKihon pSiKykKihon,
        List<ChkKekkaBean> pChkKekkaBeanList) {

        if (BizDateUtil.compareYmd(pHanteiKijyunYmd, pSiKykKihon.getSykyknyhenkouymd())
            == BizDateUtil.COMPARE_LESSER) {

            ChkKekkaBean chkKekkaKeiyakuBean = SWAKInjector.getInstance(ChkKekkaBean.class);
            chkKekkaKeiyakuBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.KIJYUN_KHENKOU_SKCHK);
            pChkKekkaBeanList.add(chkKekkaKeiyakuBean);
        }
    }

    private void chkKijyunbiHaraikata(BizDate pHanteiKijyunYmd, JT_SiKykKihon pSiKykKihon,
        List<ChkKekkaBean> pChkKekkaBeanList) {

        if (BizDateUtil.compareYmd(pHanteiKijyunYmd, pSiKykKihon.getLasthkhenkouymd())
            == BizDateUtil.COMPARE_LESSER) {

            ChkKekkaBean chkKekkaHaraikataBean = SWAKInjector.getInstance(ChkKekkaBean.class);
            chkKekkaHaraikataBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.KIJYUN_HHENKOU_SKCHK);
            pChkKekkaBeanList.add(chkKekkaHaraikataBean);
        }
    }

    private void chkHubiSakihiduke(BizDate pHubiKanryouYmd, List<ChkKekkaBean> pChkKekkaBeanList) {

        BizDate sysHubiYmd = BizDate.getSysDate();

        if (BizDateUtil.compareYmd(pHubiKanryouYmd, sysHubiYmd) == BizDateUtil.COMPARE_GREATER) {

            ChkKekkaBean chkKekkaHubiBean = SWAKInjector.getInstance(ChkKekkaBean.class);
            chkKekkaHubiBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.HUBIKANRYOUYMD_SAKICHK);
            pChkKekkaBeanList.add(chkKekkaHubiBean);
        }
    }

    private void chkHubiSyorui(BizDate pSyoruiUketukeYmd, BizDate pHubiKanryouYmd,
        List<ChkKekkaBean> pChkKekkaBeanList) {

        if (BizDateUtil.compareYmd(pHubiKanryouYmd, pSyoruiUketukeYmd) == BizDateUtil.COMPARE_LESSER) {

            ChkKekkaBean chkKekkaHubiSyoruiBean = SWAKInjector.getInstance(ChkKekkaBean.class);
            chkKekkaHubiSyoruiBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.HUBI_SYORUIUKE_SKCHK);
            pChkKekkaBeanList.add(chkKekkaHubiSyoruiBean);
        }
    }

    private void chkHubiUmu(String pSkno, String pSyono, List<ChkKekkaBean> pChkKekkaBeanList) {

        if ((!BizUtil.isBlank(pSkno)) && (!BizUtil.isBlank(pSyono))) {
            BzGetProcessSummaryInBean processSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);
            BzGetProcessSummary processSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);
            processSummaryInBean.setJimuTetuzukiCd(TeisuuSiharai.JIMUTETUZUKICD_SIHUBISIBOU);
            processSummaryInBean.setSyoNo(pSyono);
            processSummaryInBean.setSkNos(new String[]{pSkno});
            processSummaryInBean.setSubSystemId(TeisuuSiharai.SUBSYSTEMID_SIHARAI);
            List<BzGetProcessSummaryOutBean> processSummaryOutBeans = processSummary.exec(processSummaryInBean);

            if (processSummaryOutBeans.size() > 0) {
                boolean wkHubityuu = false;

                for (BzGetProcessSummaryOutBean tempProcessSummaryOutBean : processSummaryOutBeans) {
                    if (C_Kouteikanristatus.SYORITYUU.eq(tempProcessSummaryOutBean.getKouteiKanriStatus())) {
                        wkHubityuu = true;
                        break;
                    }
                }

                if(!wkHubityuu){
                    ChkKekkaBean chkKekkaHubiUmuBean = SWAKInjector.getInstance(ChkKekkaBean.class);
                    chkKekkaHubiUmuBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.HUBIKANRYOUYMD_MINYUCHK);
                    pChkKekkaBeanList.add(chkKekkaHubiUmuBean);
                }
            }
        }
    }
}
