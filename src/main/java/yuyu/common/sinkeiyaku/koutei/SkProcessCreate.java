package yuyu.common.sinkeiyaku.koutei;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.util.message.MessageUtil;

import org.slf4j.Logger;

import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzGetImage;
import yuyu.common.biz.bzcommon.BzGetImageOutputBean;
import yuyu.common.biz.bzcommon.BzGetImageProps;
import yuyu.common.biz.bzcommon.BzGetImagePropsBean;
import yuyu.common.biz.bzcommon.BzGetImagePropsInBean;
import yuyu.common.biz.bzcommon.BzGetImagePropsOutBean;
import yuyu.common.biz.bzcommon.BzImageInfoBean;
import yuyu.common.biz.bzcommon.BzPutImage;
import yuyu.common.biz.bzcommon.BzPutImageInputBean;
import yuyu.common.biz.bzcommon.BzPutImageOutputBean;
import yuyu.common.biz.koutei.BzForceProcessForward;
import yuyu.common.biz.koutei.BzGetProcessSummary;
import yuyu.common.biz.koutei.BzGetProcessSummaryInBean;
import yuyu.common.biz.koutei.BzGetProcessSummaryOutBean;
import yuyu.common.biz.koutei.BzIwfUtilConstants;
import yuyu.common.biz.koutei.BzLockProcess;
import yuyu.common.biz.koutei.BzLockProcessOutBean;
import yuyu.common.biz.koutei.BzOutputProcessRecord;
import yuyu.common.biz.koutei.BzProcessCreate;
import yuyu.common.biz.koutei.BzProcessCreateInBean;
import yuyu.common.biz.koutei.BzProcessCreateOutBean;
import yuyu.common.biz.koutei.BzUnlockProcess;
import yuyu.common.sinkeiyaku.skcommon.ISkCommonKoumoku;
import yuyu.def.MessageId;
import yuyu.def.classification.C_KetteiKbn;
import yuyu.def.classification.C_KouteiLockKekkaKbn;
import yuyu.def.classification.C_KouteiSakuseiKekkaKbn;
import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.classification.C_LincjkKbn;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_SkkinouModeIdKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.workflowcore.manager.IwfCoreDomManager;
import yuyu.infr.kinoumode.KinouMode;

/**
 * 新契約 工程 新契約工程作成
 */
public class SkProcessCreate {

    private SkProcessCreateInBean skProcessCreateInBean;

    @Inject
    private static Logger logger;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private IwfCoreDomManager iwfCoreDomManager;

    public SkProcessCreate() {
        super();
    }

    public String exec(SkProcessCreateInBean pSkProcessCreateInBean) {
        logger.debug("▽ 新契約工程作成 開始");

        skProcessCreateInBean = pSkProcessCreateInBean;
        String jimuTetuzukiCd = skProcessCreateInBean.getJimuTetuzukiCd();
        String kouteiKanriId = "";

        if (ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN.equals(jimuTetuzukiCd)) {
            kouteiKanriId = makeGymFlow(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "", "");
            makeGymFlow(ISkCommonKoumoku.JIMUTETUZUKICD_SKINPUTMOS, kouteiKanriId, ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
            makeGymFlow(ISkCommonKoumoku.JIMUTETUZUKICD_SKINPUTKOKUTI, kouteiKanriId, ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
            makeGymFlow(ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN, kouteiKanriId, ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
            makeGymFlow(ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU, kouteiKanriId, ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
            makeGymFlow(ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU, kouteiKanriId, ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
            makeGymFlow(ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU, kouteiKanriId, ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
        }
        else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBIKAISYOU.equals(jimuTetuzukiCd)) {
            BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);
            BzGetProcessSummaryInBean bzGetProcessSummaryInBean = new BzGetProcessSummaryInBean();

            bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
            bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
            bzGetProcessSummaryInBean.setMosNo(skProcessCreateInBean.getMosNo());

            List<BzGetProcessSummaryOutBean> skDairitenProcessSummaryBeanList = bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

            if (skDairitenProcessSummaryBeanList.size() > 0) {

                BzGetProcessSummaryOutBean skDairitenProcessSummaryBean = skDairitenProcessSummaryBeanList.get(0);

                kouteiKanriId = makeGymFlow(ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBIKAISYOU,
                    skDairitenProcessSummaryBean.getKouteiKanriId(),
                    ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
            }
        }
        else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKKEIYAKUKAKUNIN.equals(jimuTetuzukiCd)) {
            BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);
            BzGetProcessSummaryInBean bzGetProcessSummaryInBean = new BzGetProcessSummaryInBean();

            bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
            bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
            bzGetProcessSummaryInBean.setMosNo(skProcessCreateInBean.getMosNo());

            List<BzGetProcessSummaryOutBean> skDairitenProcessSummaryBeanList = bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

            if (skDairitenProcessSummaryBeanList.size() > 0) {

                BzGetProcessSummaryOutBean skDairitenProcessSummaryBean = skDairitenProcessSummaryBeanList.get(0);

                if (!C_SeirituKbn.SEIRITU.eq(skDairitenProcessSummaryBean.getSeirituKbn())) {
                    kouteiKanriId = makeGymFlow(ISkCommonKoumoku.JIMUTETUZUKICD_SKKEIYAKUKAKUNIN,
                        skDairitenProcessSummaryBean.getKouteiKanriId(),
                        ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
                }
            }
        }
        else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKTORIKESI.equals(jimuTetuzukiCd)) {
            BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);
            BzGetProcessSummaryInBean bzGetProcessSummaryInBean = new BzGetProcessSummaryInBean();

            bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
            bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
            bzGetProcessSummaryInBean.setMosNo(skProcessCreateInBean.getMosNo());

            List<BzGetProcessSummaryOutBean> skDairitenProcessSummaryBeanList = bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

            if (skDairitenProcessSummaryBeanList.size() > 0) {

                BzGetProcessSummaryOutBean skDairitenProcessSummaryBean = skDairitenProcessSummaryBeanList.get(0);

                kouteiKanriId = makeGymFlow(ISkCommonKoumoku.JIMUTETUZUKICD_SKTORIKESI,
                    skDairitenProcessSummaryBean.getKouteiKanriId(),
                    ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
            }
        }
        else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKHENKIN.equals(jimuTetuzukiCd)) {
            kouteiKanriId = makeGymFlow(ISkCommonKoumoku.JIMUTETUZUKICD_SKHENKIN, "", "");
        }

        logger.debug("△ 新契約工程作成 終了");

        return kouteiKanriId;
    }

    public String copyKouteiInfos(String pSrcMosno, String pTgtMosno, String pTgtSyono, KinouMode pKinouMode) {

        logger.debug("▽ 工程情報複製処理 開始");

        if (BizUtil.isBlank(pSrcMosno)) {
            logger.debug("△ 工程情報複製処理 終了");
            return "";
        }
        if (BizUtil.isBlank(pTgtMosno)) {
            logger.debug("△ 工程情報複製処理 終了");
            return "";
        }
        if (pTgtSyono == null) {
            logger.debug("△ 工程情報複製処理 終了");
            return "";
        }
        if (pKinouMode == null || BizUtil.isBlank(pKinouMode.getKinouMode())) {
            logger.debug("△ 工程情報複製処理 終了");
            return "";
        }




        BzGetProcessSummary       bzGetProcSum    = SWAKInjector.getInstance(BzGetProcessSummary.class);
        BzGetProcessSummaryInBean bzGetProcSum_In = new BzGetProcessSummaryInBean();
        bzGetProcSum_In.setMosNo(pSrcMosno);
        bzGetProcSum_In.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
        List<BzGetProcessSummaryOutBean> srcProcSums = bzGetProcSum.exec(bzGetProcSum_In);
        if (srcProcSums == null || srcProcSums.size() <= 0) {
            logger.debug("△ 工程情報複製処理 終了");
            return "";
        }


        BzGetProcessSummaryOutBean srcProcSum_main = null;
        String tgtKouteiKanriId = null;
        for (BzGetProcessSummaryOutBean srcProcSum : srcProcSums) {
            if (ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN.equals(srcProcSum.getJimuTetuzukiCd())) {
                srcProcSum_main = srcProcSum;
                SkProcessCreateInBean skProcCre_In = SWAKInjector.getInstance(SkProcessCreateInBean.class);
                skProcCre_In.setSkeiJimuKbn(srcProcSum.getSkeijimuKbn());
                skProcCre_In.setMosUketukeKbn(srcProcSum.getMosUketukeKbn());
                skProcCre_In.setHknSyuruiNo(srcProcSum.getHknsyuruiNo());
                skProcCre_In.setDairitenCd1(srcProcSum.getDairitencd1());
                skProcCre_In.setDairitenCd2(srcProcSum.getDairitencd2());
                skProcCre_In.setJimuyouCd(srcProcSum.getJimuyoucd());
                skProcCre_In.setJmycdMisetteiKbn(srcProcSum.getJmycdMisetteiKbn());
                skProcCre_In.setDoujimosUmu(srcProcSum.getDoujimosumu());
                skProcCre_In.setMosYmd(srcProcSum.getMosymd());
                skProcCre_In.setJimuStartYmd(srcProcSum.getJimuStartYmdTime());
                skProcCre_In.setSyoNo(pTgtSyono);
                skProcCre_In.setMosNo(pTgtMosno);
                skProcCre_In.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
                skProcCre_In.setKetteiKbns(srcProcSum.getKetteiKbn());
                skProcCre_In.setSeirituKbn(srcProcSum.getSeirituKbn());
                skProcCre_In.setLincjkKbn(srcProcSum.getLincjkKbn());
                tgtKouteiKanriId = exec(skProcCre_In);
                break;
            }
        }
        if (srcProcSum_main == null) {
            logger.debug("△ 工程情報複製処理 終了");
            return "";
        }
        if (BizUtil.isBlank(tgtKouteiKanriId)) {
            logger.debug("△ 工程情報複製処理 終了");
            return "";
        }




        BzGetImageProps       bzGetImgProp    = SWAKInjector.getInstance(BzGetImageProps.class);
        BzGetImagePropsInBean bzGetImgProp_In = SWAKInjector.getInstance(BzGetImagePropsInBean.class);
        bzGetImgProp_In.setJimuTetuzukiCd(srcProcSum_main.getJimuTetuzukiCd());
        bzGetImgProp_In.setKouteiKanriId(srcProcSum_main.getKouteiKanriId());
        bzGetImgProp_In.setKouteiKanriStatus(C_Kouteikanristatus.SYORITYUU);
        BzGetImagePropsOutBean bzGetImgProp_Out = bzGetImgProp.exec(bzGetImgProp_In);
        if (!BzIwfUtilConstants.API_RESULTCD_OK.equals(bzGetImgProp_Out.getKekkaStatus())) {
            logger.debug("△ 工程情報複製処理 終了");
            return "";
        }


        String[] imdIds;
        BzGetImage           bzGetImg     = SWAKInjector.getInstance(BzGetImage.class);
        BzGetImageOutputBean bzGetImg_Out;
        BzPutImage           bzPutImg     = SWAKInjector.getInstance(BzPutImage.class);
        BzPutImageInputBean  bzPutImg_In  = SWAKInjector.getInstance(BzPutImageInputBean.class);
        BzPutImageOutputBean bzPutImg_Out;
        for (BzGetImagePropsBean srcImgProp : bzGetImgProp_Out.getBzGetImagePropsBeanLst()) {
            imdIds = new String[1];
            imdIds[0] = srcImgProp.getImageId();
            bzGetImg_Out = bzGetImg.exec(imdIds, baseUserInfo.getUserId());
            if (!BzIwfUtilConstants.API_RESULTCD_OK.equals(bzGetImg_Out.getSyoriKekkaStatus())) {
                logger.debug("△ 工程情報複製処理 終了");
                return "";
            }
            for(BzImageInfoBean srcImgInfo : bzGetImg_Out.getBzImageInfoBeanList()){
                bzPutImg_In.setSyoruiCd(C_SyoruiCdKbn.valueOf(srcImgInfo.getTorikomiSyoruiCd()));
                bzPutImg_In.setUserId(baseUserInfo.getUserId());
                bzPutImg_In.setImageDatas(srcImgInfo.getPdfImage());
                bzPutImg_In.setKouteiKanriId(tgtKouteiKanriId);
                bzPutImg_In.setSyoruiTtykYmdTime(srcImgInfo.getSyoruiTtykYmdTime());
                bzPutImg_In.setTourokuYmdTime(srcImgInfo.getSyoruiTtykYmdTime());
                bzPutImg_Out = bzPutImg.exec(bzPutImg_In);
                if (!BzIwfUtilConstants.API_RESULTCD_OK.equals(bzPutImg_Out.getKekkaStatus())) {
                    logger.debug("△ 工程情報複製処理 終了");
                    return "";
                }
            }
        }




        bzGetProcSum_In = new BzGetProcessSummaryInBean();
        bzGetProcSum_In.setMosNo(pTgtMosno);
        bzGetProcSum_In.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
        List<BzGetProcessSummaryOutBean> tgtProcSums = bzGetProcSum.exec(bzGetProcSum_In);
        if (tgtProcSums == null || tgtProcSums.size() <= 0) {
            logger.debug("△ 工程情報複製処理 終了");
            return "";
        }


        BzLockProcess        lock     = SWAKInjector.getInstance(BzLockProcess.class);
        BzLockProcessOutBean lock_Out = lock.exec(tgtKouteiKanriId, ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
        if (!C_KouteiLockKekkaKbn.SUCCESS.eq(lock_Out.getKouteiLockKekkaKbn())) {
            logger.debug("△ 工程情報複製処理 終了");
            return "";
        }
        String tgtLockKey = lock_Out.getKouteiLockKey();


        boolean isFindDai;
        BzForceProcessForward bzForceProcFwd = SWAKInjector.getInstance(BzForceProcessForward.class);
        try {
            for (BzGetProcessSummaryOutBean tgtProcSum : tgtProcSums) {
                isFindDai = false;
                for (BzGetProcessSummaryOutBean srcProcSum : srcProcSums) {
                    if (tgtProcSum.getJimuTetuzukiCd().equals(srcProcSum.getJimuTetuzukiCd())) {
                        isFindDai = true;
                        bzForceProcFwd.exec(tgtProcSum.getKouteiKanriId(), tgtProcSum.getJimuTetuzukiCd(),
                            srcProcSum.getNowNodoId(), tgtLockKey);
                        break;
                    }
                }
                if (!isFindDai) {
                    throw new Exception();
                }
            }
        }
        catch (Exception ex) {
            logger.debug("△ 工程情報複製処理 終了");
            return "";
        }
        finally {
            BzUnlockProcess unlock = SWAKInjector.getInstance(BzUnlockProcess.class);
            unlock.exec(tgtKouteiKanriId, ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, tgtLockKey);
        }


        String dispKinouMode = C_SkkinouModeIdKbn.getContentByValue(pKinouMode.getKinouMode());
        String msg = MessageUtil.getMessage(MessageId.IHF1016, pSrcMosno);
        BzOutputProcessRecord outProcRec = SWAKInjector.getInstance(BzOutputProcessRecord.class);
        outProcRec.exec(tgtKouteiKanriId, ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, msg, dispKinouMode,
            C_SyorikekkaKbn.KANRYOU);

        iwfCoreDomManager.flush();

        logger.debug("△ 工程情報複製処理 終了");
        return tgtKouteiKanriId;
    }

    private String makeGymFlow(String pJimuTetuzukiCd, String pOyaKouteiKanriId, String pOyaJimuTetuzukiCd) {
        BzProcessCreate bzProcessCreate = SWAKInjector.getInstance(BzProcessCreate.class);
        BzProcessCreateInBean bzProcessCreateInBean = new BzProcessCreateInBean();
        String kouteiKanriId = "";
        C_KetteiKbn ketteiKbn = skProcessCreateInBean.getKetteiKbn();
        C_SeirituKbn seirituKbn = skProcessCreateInBean.getSeirituKbn();
        C_LincjkKbn lincjkKbn = skProcessCreateInBean.getLincjkKbn();

        bzProcessCreateInBean.setSubSystemId(ISkCommonKoumoku.SUBSYSTEMID_SINKEIYAKU);
        bzProcessCreateInBean.setSkeijimuKbn(skProcessCreateInBean.getSkeiJimuKbn());
        bzProcessCreateInBean.setMosUketukeKbn(skProcessCreateInBean.getMosUketukeKbn());
        bzProcessCreateInBean.setHknsyuruiNo(skProcessCreateInBean.getHknSyuruiNo());
        bzProcessCreateInBean.setDairitenCd1(skProcessCreateInBean.getDairitenCd1());
        bzProcessCreateInBean.setDairitenCd2(skProcessCreateInBean.getDairitenCd2());
        bzProcessCreateInBean.setJimuyouCd(skProcessCreateInBean.getJimuyouCd());

        if (BizUtil.isBlank(skProcessCreateInBean.getJimuyouCd())) {
            bzProcessCreateInBean.setJmycdMisetteiKbn(C_UmuKbn.ARI);
        }
        else {
            bzProcessCreateInBean.setJmycdMisetteiKbn(C_UmuKbn.NONE);
        }

        if (ketteiKbn == null) {
            ketteiKbn = C_KetteiKbn.NONE;
        }

        if (seirituKbn == null) {
            seirituKbn = C_SeirituKbn.NONE;
        }

        if (lincjkKbn == null) {
            lincjkKbn = C_LincjkKbn.MIHANTEI;
        }

        bzProcessCreateInBean.setDoujiMosumu(skProcessCreateInBean.getDoujimosUmu());
        bzProcessCreateInBean.setMosymd(skProcessCreateInBean.getMosYmd());
        bzProcessCreateInBean.setJimustartYmd(skProcessCreateInBean.getJimuStartYmd());
        bzProcessCreateInBean.setSyoNo(skProcessCreateInBean.getSyoNo());
        bzProcessCreateInBean.setMosNo(skProcessCreateInBean.getMosNo());
        bzProcessCreateInBean.setJimuTetuzukiCd(pJimuTetuzukiCd);
        bzProcessCreateInBean.setKetteiKbn(ketteiKbn);
        bzProcessCreateInBean.setSeirituKbn(seirituKbn);
        bzProcessCreateInBean.setLincjkKbn(lincjkKbn);

        if (!BizUtil.isBlank(pOyaKouteiKanriId)) {
            bzProcessCreateInBean.setOyaKouteiKanriId(pOyaKouteiKanriId);
        }

        if (!BizUtil.isBlank(pOyaJimuTetuzukiCd)) {
            bzProcessCreateInBean.setOyaKouteiJimuTetuzukiCd(pOyaJimuTetuzukiCd);
        }

        BzProcessCreateOutBean bzProcessCreateOutBean = bzProcessCreate.exec(bzProcessCreateInBean);

        if (C_KouteiSakuseiKekkaKbn.SUCCESS.eq(bzProcessCreateOutBean.getKouteiSakuseiKekkaKbn()) ||
            C_KouteiSakuseiKekkaKbn.MISAKUSEI_KIZON_ARI.eq(bzProcessCreateOutBean.getKouteiSakuseiKekkaKbn())) {

            if (!BizUtil.isBlank(pOyaKouteiKanriId)) {
                kouteiKanriId = pOyaKouteiKanriId;
            }
            else {
                kouteiKanriId = bzProcessCreateOutBean.getKouteiKanriId();
            }

        }
        else {
            throw new BizAppException(MessageId.EBS0008);
        }

        iwfCoreDomManager.flush();

        return kouteiKanriId;
    }
}