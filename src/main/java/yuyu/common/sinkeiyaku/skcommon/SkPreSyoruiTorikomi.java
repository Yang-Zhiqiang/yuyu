package yuyu.common.sinkeiyaku.skcommon;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.slf4j.Logger;

import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.koutei.BzGetProcessSummary;
import yuyu.common.biz.koutei.BzGetProcessSummaryInBean;
import yuyu.common.biz.koutei.BzGetProcessSummaryOutBean;
import yuyu.common.biz.prereport.GetQRCode;
import yuyu.common.biz.prereport.SyoruiToutyakuYoteiTouroku;
import yuyu.def.classification.C_HknsyuruiNo;
import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.classification.C_MosUketukeKbn;
import yuyu.def.classification.C_SkeijimuKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;

/**
 * 新契約 新契約共通 新契約書類取込前処理
 */
public class SkPreSyoruiTorikomi {

    @Inject
    private static Logger logger;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    public SkPreSyoruiTorikomi() {
        super();
    }

    public String[] sinkykSyoruiTorikomi(String pMosNo,
        C_SyoruiCdKbn[] pSyoruiCds,
        C_SkeijimuKbn pSkeijimuKbn,
        C_HknsyuruiNo pHknsyuruiNo,
        C_MosUketukeKbn pMosUketukeKbn,
        String pDrtenCd) {

        logger.debug("▽ 新契約書類取込前処理 開始");

        BzGetProcessSummary bzGetProSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);
        BzGetProcessSummaryInBean bzGetProcessSummaryInBean= SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);

        bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
        bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
        bzGetProcessSummaryInBean.setMosNo(pMosNo);

        List<BzGetProcessSummaryOutBean> bzGetProSummaryOutBeanLst = bzGetProSummary.exec(bzGetProcessSummaryInBean);
        BzGetProcessSummaryOutBean drtProcessSummaryOutBean = null;

        if (bzGetProSummaryOutBeanLst.isEmpty()) {

            HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(pMosNo);

            if (syoriCTL != null) {

                bzGetProcessSummaryInBean = new BzGetProcessSummaryInBean();

                bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
                bzGetProcessSummaryInBean.setSyoNo(syoriCTL.getSyono());

                bzGetProSummaryOutBeanLst = bzGetProSummary.exec(bzGetProcessSummaryInBean);
            }
        }

        if (bzGetProSummaryOutBeanLst.size() > 0) {
            drtProcessSummaryOutBean = bzGetProSummaryOutBeanLst.get(0);
        }

        String[] qrCodes = new String[pSyoruiCds.length];

        if (drtProcessSummaryOutBean == null) {

            ArrayList<SkMosMikakuteiSyoruiSksInBean> skMosMktSrSksInBeanLst = new ArrayList<>();
            SkMosMikakuteiSyoruiSksInBean skMosMktSrSksInBean = null;

            for (int n = 0; n < pSyoruiCds.length; n++) {

                String qrCode = GetQRCode.execGetQRCode(pSyoruiCds[n].getValue());

                qrCodes[n] = qrCode;

                skMosMktSrSksInBean = SWAKInjector.getInstance(SkMosMikakuteiSyoruiSksInBean.class);

                skMosMktSrSksInBean.setDocumentId(qrCode);
                skMosMktSrSksInBean.setSyoruiCd( pSyoruiCds[n]);

                skMosMktSrSksInBeanLst.add(skMosMktSrSksInBean);
            }

            SkMosMikakuteiInfoSks skMosMikakuteiInfoSks = SWAKInjector.getInstance(SkMosMikakuteiInfoSks.class);
            SkMosMikakuteiJyouhouKanriSksInBean skMosMktJhKrSksInBean =
                SWAKInjector.getInstance(SkMosMikakuteiJyouhouKanriSksInBean.class);

            skMosMktJhKrSksInBean.setMosNo(pMosNo);
            skMosMktJhKrSksInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
            skMosMktJhKrSksInBean.setSkeijimuKbn(pSkeijimuKbn);
            skMosMktJhKrSksInBean.setMosUketukeKbn(pMosUketukeKbn);
            skMosMktJhKrSksInBean.setHknsyuruiNo(pHknsyuruiNo);
            skMosMktJhKrSksInBean.setDairitenCd1(pDrtenCd);
            skMosMktJhKrSksInBean.setSyoriYmd(BizDate.getSysDate());
            skMosMktJhKrSksInBean.setGyoumuKousinsyaId(baseUserInfo.getUserId());
            skMosMktJhKrSksInBean.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());
            skMosMktJhKrSksInBean.setSkMosMikakuteiSyoruiSksInBeanLst(skMosMktSrSksInBeanLst);

            skMosMikakuteiInfoSks.mosMikakuteiInfoSksOne(skMosMktJhKrSksInBean);
        }
        else {
            for (int n = 0; n < pSyoruiCds.length; n++) {

                String qrCode = GetQRCode.execGetQRCode(pSyoruiCds[n].getValue());

                qrCodes[n] = qrCode;

                SyoruiToutyakuYoteiTouroku.execSyoruiToutyakuYoteiTouroku(
                    pSyoruiCds[n].getValue(), drtProcessSummaryOutBean.getKouteiKanriId(), qrCode);
            }
        }

        logger.debug("△ 新契約書類取込前処理 終了");

        return qrCodes;
    }

    public String[] sinkykSyoruiTorikomiMany(String pMosNo,
        C_SyoruiCdKbn[] pSyoruiCds,
        C_SkeijimuKbn pSkeijimuKbn,
        C_HknsyuruiNo pHknsyuruiNo,
        C_MosUketukeKbn pMosUketukeKbn,
        String pDrtenCd,
        String pSetMosno1) {

        logger.debug("▽ 新契約書類取込前処理 開始");

        String[] qrCodes = new String[pSyoruiCds.length];
        ArrayList<SkMosMikakuteiJyouhouKanriSksInBean> skMosMktJhKrSksInBeanLst = new ArrayList<>();
        ArrayList<SkMosMikakuteiSyoruiSksInBean> skMosMktSrSksInBeanLst = new ArrayList<>();
        SkMosMikakuteiSyoruiSksInBean skMosMktSrSksInBean = null;

        for (int n = 0; n < pSyoruiCds.length; n++) {

            String qrCode = GetQRCode.execGetQRCodeMos();

            qrCodes[n] = qrCode;

            skMosMktSrSksInBean = SWAKInjector.getInstance(SkMosMikakuteiSyoruiSksInBean.class);

            skMosMktSrSksInBean.setDocumentId(qrCode);
            skMosMktSrSksInBean.setSyoruiCd(pSyoruiCds[n]);

            skMosMktSrSksInBeanLst.add(skMosMktSrSksInBean);
        }

        SkMosMikakuteiInfoSks skMosMikakuteiInfoSks = SWAKInjector.getInstance(SkMosMikakuteiInfoSks.class);
        SkMosMikakuteiJyouhouKanriSksInBean skMosMktJhKrSksInBean =
            SWAKInjector.getInstance(SkMosMikakuteiJyouhouKanriSksInBean.class);

        skMosMktJhKrSksInBean.setMosNo(pMosNo);
        skMosMktJhKrSksInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
        skMosMktJhKrSksInBean.setSkeijimuKbn(pSkeijimuKbn);
        skMosMktJhKrSksInBean.setMosUketukeKbn(pMosUketukeKbn);
        skMosMktJhKrSksInBean.setHknsyuruiNo(pHknsyuruiNo);
        skMosMktJhKrSksInBean.setDairitenCd1(pDrtenCd);
        skMosMktJhKrSksInBean.setSyoriYmd(BizDate.getSysDate());
        skMosMktJhKrSksInBean.setSetMosno1(pSetMosno1);
        skMosMktJhKrSksInBean.setGyoumuKousinsyaId(baseUserInfo.getUserId());
        skMosMktJhKrSksInBean.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());
        skMosMktJhKrSksInBean.setSkMosMikakuteiSyoruiSksInBeanLst(skMosMktSrSksInBeanLst);

        skMosMktJhKrSksInBeanLst.add(skMosMktJhKrSksInBean);

        skMosMikakuteiInfoSks.mosMikakuteiInfoSksMany(skMosMktJhKrSksInBeanLst);

        logger.debug("△ 新契約書類取込前処理 終了");

        return qrCodes;
    }
}
