package yuyu.common.sinkeiyaku.koutei;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.util.string.StringUtil;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzProcessUpdate;
import yuyu.common.biz.bzcommon.BzProcessUpdateForBatch;
import yuyu.common.biz.bzcommon.BzProcessUpdateForBatchInputBean;
import yuyu.common.biz.bzcommon.BzProcessUpdateForBatchOutputBean;
import yuyu.common.biz.bzcommon.BzProcessUpdateInputBean;
import yuyu.common.biz.bzcommon.TuikaParamForBatchInputBean;
import yuyu.common.biz.bzcommon.TuikaParamInputBean;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.biz.koutei.BzGetProcessSummary;
import yuyu.common.biz.koutei.BzGetProcessSummaryInBean;
import yuyu.common.biz.koutei.BzGetProcessSummaryOutBean;
import yuyu.common.biz.koutei.BzLockProcess;
import yuyu.common.biz.koutei.BzLockProcessOutBean;
import yuyu.common.biz.koutei.BzUnlockProcess;
import yuyu.common.biz.koutei.GetSyoriKokouteiInfo;
import yuyu.common.biz.koutei.GetSyoriKokouteiInfoOutBean;
import yuyu.common.sinkeiyaku.skcommon.ISkCommonKoumoku;
import yuyu.def.MessageId;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_KouteiLockKekkaKbn;
import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.BT_GyoumuKouteiInfo;
import yuyu.def.db.entity.HT_MosDairiten;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_SyoriCTL;

/**
 * 新契約 工程 新契約工程情報更新
 */
public class SkProcessUpdate {

    private TuikaParamInputBean tuikaParamInputBean = null;

    private C_YouhiKbn kouteiLockSyutokuYh;

    public static final String BZUPDATEPROCESS_KEKKA_OK  = "0";

    @Inject
    private static Logger logger;

    @Inject
    private BizDomManager bizDomMan;

    public SkProcessUpdate() {
        super();
    }

    public void exec(HT_SyoriCTL pSyoriCTL, String pSkDrtenKouteiLockKey, String pSkHenkinKouteiLockKey) {

        logger.debug("▽ 新契約工程情報更新 開始");

        //        tuikaParamInputBean = SWAKInjector.getInstance(TuikaParamInputBean.class);
        //
        //        String aAtkisyaTratkiagCd = "";
        //        String bAtkisyaTratkiagCd = "";
        //        C_HknsyuruiNo hknsyuruiNo = null;
        //        String jimuyouCd = null;
        //        BizDate mosymd = null;
        //
        //        HT_MosDairiten mosDairiten1 = pSyoriCTL.getMosDairitenByRenno(1);
        //
        //        if (mosDairiten1 != null) {
        //            aAtkisyaTratkiagCd = mosDairiten1.getOyadrtencd();
        //        }
        //
        //        HT_MosDairiten mosDairiten2 = pSyoriCTL.getMosDairitenByRenno(2);
        //
        //        if (mosDairiten2 != null) {
        //            bAtkisyaTratkiagCd = mosDairiten2.getOyadrtencd();
        //        }
        //
        //        HT_MosKihon mosKihon = pSyoriCTL.getMosKihon();
        //
        //        if (mosKihon != null) {
        //            hknsyuruiNo = mosKihon.getHknsyuruino();
        //            jimuyouCd = mosKihon.getJimuyoucd();
        //            mosymd = mosKihon.getMosymd();
        //        }
        //
        //        tuikaParamInputBean.setSkeijimukbn(pSyoriCTL.getSkeijimukbn());
        //        tuikaParamInputBean.setMosuketukekbn(pSyoriCTL.getMosuketukekbn());
        //        tuikaParamInputBean.setHknsyuruiNo(hknsyuruiNo);
        //        tuikaParamInputBean.setDairitencd1(aAtkisyaTratkiagCd);
        //        tuikaParamInputBean.setDairitencd2(bAtkisyaTratkiagCd);
        //        tuikaParamInputBean.setKoDairitenTaisyouKbn(null);
        //        tuikaParamInputBean.setJimuyoucd(jimuyouCd);
        //        tuikaParamInputBean.setJmycdMisetteiKbn(null);
        //        tuikaParamInputBean.setDoujimosumu(pSyoriCTL.getDoujimosumu());
        //        tuikaParamInputBean.setMosymd(mosymd);
        //        tuikaParamInputBean.setJimustartymd(null);
        //        tuikaParamInputBean.setSyono(pSyoriCTL.getSyono());
        //        tuikaParamInputBean.setNksysyno(null);
        //        tuikaParamInputBean.setMosno(pSyoriCTL.getMosno());
        //        tuikaParamInputBean.setKetteiKbn(pSyoriCTL.getKetteikbn());
        //        tuikaParamInputBean.setSeirituKbn(pSyoriCTL.getSeiritukbn());
        //        tuikaParamInputBean.setLincjkKbn(pSyoriCTL.getLincjkkbn());
        //
        //        updateGymFlow(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, pSkDrtenKouteiLockKey);
        //
        //        updateGymFlow(ISkCommonKoumoku.JIMUTETUZUKICD_SKHENKIN, pSkHenkinKouteiLockKey);

        if (pSyoriCTL.getMosKihon() != null) {
            List<BzProcessUpdateForBatchInputBean> bzProcessUpdateForBatchInputBeanList =
                editProcessUpdateForBatchInfo(pSyoriCTL, pSyoriCTL.getMosKihon(), pSyoriCTL.getMosDairitens());

            execForBatch(bzProcessUpdateForBatchInputBeanList);
        }

        logger.debug("△ 新契約工程情報更新 終了");
    }

    public void exec(TuikaParamInputBean pTuikaParamInputBean, String pSkDrtenKouteiLockKey, String pSkHenkinKouteiLockKey) {

        logger.debug("▽ 新契約工程情報更新 開始");

        tuikaParamInputBean = pTuikaParamInputBean;

        //        updateGymFlow(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, pSkDrtenKouteiLockKey);
        //
        //        updateGymFlow(ISkCommonKoumoku.JIMUTETUZUKICD_SKHENKIN, pSkHenkinKouteiLockKey);

        List<BzProcessUpdateForBatchInputBean> bzProcessUpdateForBatchInputBeanList =
            editProcessUpdateForBatchInfo(null, null, null);

        execForBatch(bzProcessUpdateForBatchInputBeanList);

        logger.debug("△ 新契約工程情報更新 終了");
    }

    public List<BzProcessUpdateForBatchInputBean> editProcessUpdateForBatchInfo(
        HT_SyoriCTL pSyoriCTL, HT_MosKihon  pMoskihon, List<HT_MosDairiten> pMosDairitenList){

        logger.debug("▽ 工程情報更新（バッチ用）情報編集処理 開始");

        BzProcessUpdateForBatchInputBean bzProcessUpdateForBatchInputBean = null;

        TuikaParamForBatchInputBean tuikaParamForBatchInputBean = new TuikaParamForBatchInputBean();
        List<BzProcessUpdateForBatchInputBean> bzProcessUpdateForBatchInputBeanList
        = new ArrayList<BzProcessUpdateForBatchInputBean>();

        if (tuikaParamInputBean != null) {

            tuikaParamForBatchInputBean.setSkeijimukbn(tuikaParamInputBean.getSkeijimukbn());
            tuikaParamForBatchInputBean.setMosuketukekbn(tuikaParamInputBean.getMosuketukekbn());
            tuikaParamForBatchInputBean.setHknsyuruiNo(tuikaParamInputBean.getHknsyuruiNo());
            tuikaParamForBatchInputBean.setDairitencd1(tuikaParamInputBean.getDairitencd1());
            tuikaParamForBatchInputBean.setDairitencd2(tuikaParamInputBean.getDairitencd2());
            tuikaParamForBatchInputBean.setJimuyoucd(tuikaParamInputBean.getJimuyoucd());
            tuikaParamForBatchInputBean.setDoujimosumu(tuikaParamInputBean.getDoujimosumu());
            tuikaParamForBatchInputBean.setMosymd(tuikaParamInputBean.getMosymd());
            tuikaParamForBatchInputBean.setJimustartymd(tuikaParamInputBean.getJimustartymd());
            tuikaParamForBatchInputBean.setSyono(tuikaParamInputBean.getSyono());
            tuikaParamForBatchInputBean.setNksysyno(tuikaParamInputBean.getNksysyno());
            tuikaParamForBatchInputBean.setMosno(tuikaParamInputBean.getMosno());
            tuikaParamForBatchInputBean.setKetteiKbn(tuikaParamInputBean.getKetteiKbn());
            tuikaParamForBatchInputBean.setSeirituKbn(tuikaParamInputBean.getSeirituKbn());
            tuikaParamForBatchInputBean.setLincjkKbn(tuikaParamInputBean.getLincjkKbn());
        }
        else {

            String dairitenCode1 = null;
            String dairitenCode2 = null;

            for (HT_MosDairiten mosDairiten : pMosDairitenList) {

                if (mosDairiten.getRenno() == 1) {

                    dairitenCode1 = mosDairiten.getOyadrtencd();
                }
                else if (mosDairiten.getRenno() == 2) {

                    dairitenCode2 = mosDairiten.getOyadrtencd();
                }
            }

            tuikaParamForBatchInputBean.setSkeijimukbn(pSyoriCTL.getSkeijimukbn());
            tuikaParamForBatchInputBean.setMosuketukekbn(pSyoriCTL.getMosuketukekbn());
            tuikaParamForBatchInputBean.setHknsyuruiNo(pMoskihon.getHknsyuruino());
            tuikaParamForBatchInputBean.setDairitencd1(dairitenCode1);
            tuikaParamForBatchInputBean.setDairitencd2(dairitenCode2);
            tuikaParamForBatchInputBean.setJimuyoucd(pMoskihon.getJimuyoucd());
            tuikaParamForBatchInputBean.setDoujimosumu(pSyoriCTL.getDoujimosumu());
            tuikaParamForBatchInputBean.setMosymd(pMoskihon.getMosymd());
            tuikaParamForBatchInputBean.setJimustartymd(null);
            tuikaParamForBatchInputBean.setSyono(pSyoriCTL.getSyono());
            tuikaParamForBatchInputBean.setNksysyno(null);
            tuikaParamForBatchInputBean.setMosno(pSyoriCTL.getMosno());
            tuikaParamForBatchInputBean.setKetteiKbn(pSyoriCTL.getKetteikbn());
            tuikaParamForBatchInputBean.setSeirituKbn(pSyoriCTL.getSeiritukbn());
            tuikaParamForBatchInputBean.setLincjkKbn(pSyoriCTL.getLincjkkbn());
        }

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = new BzGetProcessSummaryInBean();
        BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);
        BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = null;
        List<BzGetProcessSummaryOutBean> bzGetProcessSummaryOutBeanList = null;

        bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
        bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
        bzGetProcessSummaryInBean.setMosNo(tuikaParamForBatchInputBean.getMosno());

        bzGetProcessSummaryOutBeanList = bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

        if (bzGetProcessSummaryOutBeanList.size() > 0) {

            bzGetProcessSummaryOutBean = bzGetProcessSummaryOutBeanList.get(0);
            bzProcessUpdateForBatchInputBean = new BzProcessUpdateForBatchInputBean();

            bzProcessUpdateForBatchInputBean.setJimuTetuzukiCd(bzGetProcessSummaryOutBean.getJimuTetuzukiCd()) ;
            bzProcessUpdateForBatchInputBean.setKouteiKanriId(bzGetProcessSummaryOutBean.getKouteiKanriId());
            bzProcessUpdateForBatchInputBean.setKokouteiUpdumu(C_UmuKbn.ARI);
            bzProcessUpdateForBatchInputBean.setTuikaParamForBatchInputBean(tuikaParamForBatchInputBean);

            bzProcessUpdateForBatchInputBeanList.add(bzProcessUpdateForBatchInputBean);
        }

        bzGetProcessSummaryInBean = new BzGetProcessSummaryInBean();

        bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKHENKIN);
        bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
        bzGetProcessSummaryInBean.setMosNo(tuikaParamForBatchInputBean.getMosno());

        bzGetProcessSummaryOutBeanList = bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

        if (bzGetProcessSummaryOutBeanList.size() > 0) {

            bzGetProcessSummaryOutBean = bzGetProcessSummaryOutBeanList.get(0);
            bzProcessUpdateForBatchInputBean = new BzProcessUpdateForBatchInputBean();

            bzProcessUpdateForBatchInputBean.setJimuTetuzukiCd(bzGetProcessSummaryOutBean.getJimuTetuzukiCd()) ;
            bzProcessUpdateForBatchInputBean.setKouteiKanriId(bzGetProcessSummaryOutBean.getKouteiKanriId());
            bzProcessUpdateForBatchInputBean.setKokouteiUpdumu(C_UmuKbn.ARI);
            bzProcessUpdateForBatchInputBean.setTuikaParamForBatchInputBean(tuikaParamForBatchInputBean);

            bzProcessUpdateForBatchInputBeanList.add(bzProcessUpdateForBatchInputBean);
        }

        logger.debug("△ 工程情報更新（バッチ用）情報編集処理 終了");

        return bzProcessUpdateForBatchInputBeanList;
    }

    public void execForBatch(List<BzProcessUpdateForBatchInputBean> pBzProcessUpdateForBatchInputBeanList){

        logger.debug("▽ 新契約工程情報更新（バッチ用） 開始");

        if (pBzProcessUpdateForBatchInputBeanList == null) {

            return;
        }
        else if (pBzProcessUpdateForBatchInputBeanList.size() == 0) {

            return;
        }

        BzProcessUpdateForBatch bzProcessUpdateForBatch = SWAKInjector.getInstance(BzProcessUpdateForBatch.class);

        BzProcessUpdateForBatchOutputBean bzProcessUpdateForBatchOutputBean =
            bzProcessUpdateForBatch.exec(pBzProcessUpdateForBatchInputBeanList);

        if (!BZUPDATEPROCESS_KEKKA_OK.equals(bzProcessUpdateForBatchOutputBean.getKekkaStatus())) {

            throw new CommonBizAppException("詳細メッセージコード=" + bzProcessUpdateForBatchOutputBean.getSyousaiMsgCd()
                + " 詳細メッセージ=" + bzProcessUpdateForBatchOutputBean.getSyousaiMsg()
                + " 工程管理ＩＤ=" + bzProcessUpdateForBatchOutputBean.getErrKouteiKanriId());
        }

        logger.debug("△ 新契約工程情報更新（バッチ用） 終了");
    }

    public List<BT_GyoumuKouteiInfo> changeKouteikanriMosNo(HT_SyoriCTL pTgtSyoriCtl, String pKouteiKanriId,
        String pKouteiLockKey_skMainDrt, String pKouteiLockKey_skHenkin) {

        logger.debug("▽ 工程管理申込番号変更 開始");

        List<BT_GyoumuKouteiInfo> gyoumuKouteiInfoLst = null;

        if (pTgtSyoriCtl == null) {
            logger.debug("△ 工程管理申込番号変更 終了");
            return gyoumuKouteiInfoLst;
        }
        if (BizUtil.isBlank(pKouteiKanriId)) {
            logger.debug("△ 工程管理申込番号変更 終了");
            return gyoumuKouteiInfoLst;
        }

        BzGetProcessSummaryInBean bzGetProcSum_In = new BzGetProcessSummaryInBean();
        bzGetProcSum_In.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
        bzGetProcSum_In.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
        bzGetProcSum_In.setKouteiKanriId(pKouteiKanriId);
        BzGetProcessSummary              bzGetProcSum        = SWAKInjector.getInstance(BzGetProcessSummary.class);
        List<BzGetProcessSummaryOutBean> bzGetProcSum_OutLst = bzGetProcSum.exec(bzGetProcSum_In);

        if (bzGetProcSum_OutLst.size() > 0) {

            BzProcessUpdateForBatchInputBean bzProcUpdBat_In = new BzProcessUpdateForBatchInputBean();
            bzProcUpdBat_In.setJimuTetuzukiCd(bzGetProcSum_OutLst.get(0).getJimuTetuzukiCd()) ;
            bzProcUpdBat_In.setKouteiKanriId(bzGetProcSum_OutLst.get(0).getKouteiKanriId());
            bzProcUpdBat_In.setKokouteiUpdumu(C_UmuKbn.ARI);
            TuikaParamForBatchInputBean tuikaParam = new TuikaParamForBatchInputBean();
            tuikaParam.setMosno(pTgtSyoriCtl.getMosno());
            tuikaParam.setSyono(pTgtSyoriCtl.getSyono());
            bzProcUpdBat_In.setTuikaParamForBatchInputBean(tuikaParam);
            List<BzProcessUpdateForBatchInputBean> execForBat_In = new ArrayList<BzProcessUpdateForBatchInputBean>();
            execForBat_In.add(bzProcUpdBat_In);
            execForBatch(execForBat_In);
        }

        gyoumuKouteiInfoLst = bizDomMan.getGyoumuKouteiInfosBySyukouteikanriid(pKouteiKanriId);
        for(BT_GyoumuKouteiInfo gyoumuKouteiInfo : gyoumuKouteiInfoLst){
            gyoumuKouteiInfo.setMosno(pTgtSyoriCtl.getMosno());
            gyoumuKouteiInfo.setSyono(pTgtSyoriCtl.getSyono());
        }

        logger.debug("△ 新契約工程管理申込番号変更 終了");

        return gyoumuKouteiInfoLst;
    }

    private void updateGymFlow(String pJimuTetuzukiCd, String pKouteiLockKey) {

        BzProcessUpdate bzProcessUpdate = SWAKInjector.getInstance(BzProcessUpdate.class);
        BzProcessUpdateInputBean bzProcessUpdateInputBean = SWAKInjector.getInstance(BzProcessUpdateInputBean.class);
        BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);
        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);
        List<BzGetProcessSummaryOutBean> bzGetProcessSummaryOutBeanList = null;
        BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = null;

        bzGetProcessSummaryInBean.setJimuTetuzukiCd(pJimuTetuzukiCd);
        bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
        bzGetProcessSummaryInBean.setMosNo(tuikaParamInputBean.getMosno());

        bzGetProcessSummaryOutBeanList = bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

        if (bzGetProcessSummaryOutBeanList.size() == 0) {
            return;
        }

        bzGetProcessSummaryOutBean = bzGetProcessSummaryOutBeanList.get(0);

        bzProcessUpdateInputBean.setJimuTetuzukiCd(pJimuTetuzukiCd);
        bzProcessUpdateInputBean.setKouteiKanriId(bzGetProcessSummaryOutBean.getKouteiKanriId());
        bzProcessUpdateInputBean.setTuikaParamInputBean(tuikaParamInputBean);
        bzProcessUpdateInputBean.setKokouteiUpdumu(C_UmuKbn.ARI);

        String kouteiLockKey = lockProcess(bzGetProcessSummaryOutBean.getKouteiKanriId(), pJimuTetuzukiCd, pKouteiLockKey);

        bzProcessUpdateInputBean.setKouteiLockKey(kouteiLockKey);

        bzProcessUpdate.exec(bzProcessUpdateInputBean);

        unlockProcess(bzGetProcessSummaryOutBean.getKouteiKanriId(),
            pJimuTetuzukiCd, bzProcessUpdateInputBean.getKouteiLockKey());
    }

    private String lockProcess(String pKouteiKanriId, String pJimuTetuzukiCd, String pKouteiLockKey) {

        String kouteiLockKey = pKouteiLockKey;

        if (StringUtil.isNullOrBlank(kouteiLockKey)) {

            BzLockProcess bzLockProcess = SWAKInjector.getInstance(BzLockProcess.class);
            BzLockProcessOutBean bzLockProcessOutBean = null;

            bzLockProcessOutBean = bzLockProcess.exec(pKouteiKanriId, pJimuTetuzukiCd);

            if (!C_KouteiLockKekkaKbn.SUCCESS.eq(bzLockProcessOutBean.getKouteiLockKekkaKbn())) {
                throw new BizLogicException(MessageId.EBA0110);
            }

            kouteiLockSyutokuYh = C_YouhiKbn.YOU;

            kouteiLockKey = bzLockProcessOutBean.getKouteiLockKey();
        }
        else {

            GetSyoriKokouteiInfo getSyoriKokouteiInfo = SWAKInjector.getInstance(GetSyoriKokouteiInfo.class);
            BzLockProcess bzLockProcess = null;

            List<GetSyoriKokouteiInfoOutBean> getSyoriKokouteiInfoOutBeanLst =
                getSyoriKokouteiInfo.exec(pKouteiKanriId, pJimuTetuzukiCd);

            for (GetSyoriKokouteiInfoOutBean getSyoriKokouteiInfoOutBean : getSyoriKokouteiInfoOutBeanLst) {

                bzLockProcess = SWAKInjector.getInstance(BzLockProcess.class);

                bzLockProcess.exec(
                    getSyoriKokouteiInfoOutBean.getSyoriKokouteikanriId(),
                    getSyoriKokouteiInfoOutBean.getSyoriKokouteiJimutetuzukiCd(),
                    kouteiLockKey);
            }
        }

        return kouteiLockKey;
    }

    private void unlockProcess(String pKouteiKanriId, String pJimuTetuzukiCd, String pKouteiLockKey) {

        BzUnlockProcess bzUnlockProcess = SWAKInjector.getInstance(BzUnlockProcess.class);

        if (C_YouhiKbn.YOU.eq(kouteiLockSyutokuYh)) {
            bzUnlockProcess.exec(pKouteiKanriId, pJimuTetuzukiCd, pKouteiLockKey);

            kouteiLockSyutokuYh = C_YouhiKbn.HUYOU;
        }
    }
}