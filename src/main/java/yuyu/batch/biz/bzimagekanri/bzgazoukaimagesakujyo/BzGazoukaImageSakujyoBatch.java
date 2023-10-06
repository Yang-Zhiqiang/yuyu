package yuyu.batch.biz.bzimagekanri.bzgazoukaimagesakujyo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.BzDropImage;
import yuyu.common.biz.bzcommon.BzDropImageInputBean;
import yuyu.common.biz.bzcommon.BzDropImageOutputBean;
import yuyu.common.biz.bzcommon.BzGetImageProps;
import yuyu.common.biz.bzcommon.BzGetImagePropsBean;
import yuyu.common.biz.bzcommon.BzGetImagePropsInBean;
import yuyu.common.biz.bzcommon.BzGetImagePropsOutBean;
import yuyu.common.biz.bzcommon.BzGetSosikiData;
import yuyu.common.biz.bzcommon.BzGetSosikiDataBean;
import yuyu.common.biz.bzcommon.DateFormatUtil;
import yuyu.common.biz.koutei.BzGetProcessSummary;
import yuyu.common.biz.koutei.BzGetProcessSummaryInBean;
import yuyu.common.biz.koutei.BzGetProcessSummaryOutBean;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.report.BzMynumberTyuusyutuListBean;
import yuyu.def.biz.bean.report.BzMynumberTyuusyutuListDataSourceBean;
import yuyu.def.biz.configuration.YuyuBizConfig;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_ImagegazoukaKbn;
import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_TantouCdKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BM_TantouCd;
import yuyu.def.db.entity.BM_TorikomiSyoruiHukaInfo;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.JT_Sk;
import yuyu.def.db.entity.JT_SkKihon;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;

import com.google.common.collect.Ordering;

/**
 * 業務共通 イメージ管理 画像化イメージ削除
 */
public class BzGazoukaImageSakujyoBatch implements Batch {

    private static final String BZ_GAZOUKAIMAGE_SAKUJYO = "画像化イメージ削除";

    private static final String SUBSYSTEMID_HOZEN = "hozen";

    private static final String SUBSYSTEMID_SIHARAI = "siharai";

    private int sakujyoKns;

    private List<BzDropCyouhyouBean> bzDropCyouhyouBeanLst;

    private List<BzMynumberTyuusyutuListDataSourceBean> bzMynumberTyuusyutuListDataSourceBeanLst;

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private SiharaiDomManager siharaiDomManager;

    @Inject
    private BizDomManager bizDomManager;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        BizDate syoriYmd = bzBatchParam.getSyoriYmd();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(syoriYmd)));

        sakujyoKns = 0;
        bzDropCyouhyouBeanLst = new ArrayList<>();
        bzMynumberTyuusyutuListDataSourceBeanLst = new ArrayList<>();

        List<BM_TorikomiSyoruiHukaInfo> torikomiSyoruiHukaInfoLst = bizDomManager
            .getTorikomiSyoruiHukaInfosByImagegazoukaKbn(C_ImagegazoukaKbn.GAZOUKATAISYOU);

        for (BM_TorikomiSyoruiHukaInfo torikomiSyoruiHukaInfo : torikomiSyoruiHukaInfoLst) {
            imageDataSakujyo(torikomiSyoruiHukaInfo.getSyoruiCd());
        }

        for (BzDropCyouhyouBean bzDropCyouhyouBean : bzDropCyouhyouBeanLst) {
            if (YuyuBizConfig.getInstance().getMyNumberSyoruiCdList().contains(bzDropCyouhyouBean.getSyoruiCd().getValue())) {
                mynumberTyuusyutuListDSBOut(bzDropCyouhyouBean);
            }
        }

        myNumberCListOut(bzMynumberTyuusyutuListDataSourceBeanLst);

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(sakujyoKns),
            BZ_GAZOUKAIMAGE_SAKUJYO));
    }

    private void imageDataSakujyo(C_SyoruiCdKbn pSyoruiCdKbn) {

        BzGetImageProps bzGetImageProps = SWAKInjector.getInstance(BzGetImageProps.class);
        BzGetImagePropsInBean bzGetImagePropsInBean = SWAKInjector.getInstance(BzGetImagePropsInBean.class);
        List<BzGetImagePropsBean> kanryouTorikeshiImageLst = new ArrayList<>();

        bzGetImagePropsInBean.setSyoruiCd(pSyoruiCdKbn);
        bzGetImagePropsInBean.setKouteiKanriStatus(C_Kouteikanristatus.KANRYOU);
        BzGetImagePropsOutBean bzGetImagePropsOutBean = bzGetImageProps.exec(bzGetImagePropsInBean);

        if (!"0".equals(bzGetImagePropsOutBean.getKekkaStatus())) {
            throw new BizAppException(MessageId.EBF0129, kinou.getKinouNm());
        }

        kanryouTorikeshiImageLst.addAll(bzGetImagePropsOutBean.getBzGetImagePropsBeanLst());

        bzGetImagePropsInBean.setSyoruiCd(pSyoruiCdKbn);
        bzGetImagePropsInBean.setKouteiKanriStatus(C_Kouteikanristatus.TORIKESI);
        bzGetImagePropsOutBean = bzGetImageProps.exec(bzGetImagePropsInBean);

        if (!"0".equals(bzGetImagePropsOutBean.getKekkaStatus())) {
            throw new BizAppException(MessageId.EBF0129, kinou.getKinouNm());
        }

        kanryouTorikeshiImageLst.addAll(bzGetImagePropsOutBean.getBzGetImagePropsBeanLst());

        if (kanryouTorikeshiImageLst.size() > 0) {
            Map<String, BzGetImagePropsBean> imageIdMap = new HashMap<>();
            for (BzGetImagePropsBean bzGetImagePropsBeanLoop : kanryouTorikeshiImageLst) {
                imageIdMap.put(bzGetImagePropsBeanLoop.getImageId(), bzGetImagePropsBeanLoop);
            }

            kanryouTorikeshiImageLst = new ArrayList<>(imageIdMap.values());
        }

        for (BzGetImagePropsBean bzGetImagePropsBean : kanryouTorikeshiImageLst) {

            BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);

            BzGetProcessSummaryInBean bzGetProcessSummaryInBean = SWAKInjector
                .getInstance(BzGetProcessSummaryInBean.class);

            bzGetProcessSummaryInBean.setKouteiKanriId(bzGetImagePropsBean.getKouteiKanriId());
            bzGetProcessSummaryInBean.setKouteEndYmdFrom(BizDate.valueOf(19700101));
            bzGetProcessSummaryInBean.setKouteEndYmdTo(bzBatchParam.getSyoriYmd().addBusinessDays(-5));

            List<BzGetProcessSummaryOutBean> bzGetProcessSummaryOutBeanLst = bzGetProcessSummary
                .exec(bzGetProcessSummaryInBean);
            if (bzGetProcessSummaryOutBeanLst.size() == 0) {
                continue;
            }

            BzDropImage bzDropImage = SWAKInjector.getInstance(BzDropImage.class);
            BzDropImageInputBean bzDropImageInputBean = SWAKInjector.getInstance(BzDropImageInputBean.class);

            bzDropImageInputBean.setImageId(bzGetImagePropsBean.getImageId());
            bzDropImageInputBean.setUserId(baseUserInfo.getUserId());
            BzDropImageOutputBean bzDropImageOutputBean = bzDropImage.exec(bzDropImageInputBean);
            if ("9".equals(bzDropImageOutputBean.getKekkaStatus())) {
                throw new BizAppException(MessageId.EBF0129, kinou.getKinouNm());

            } else if ("-1".equals(bzDropImageOutputBean.getKekkaStatus())) {

                batchLogger.error(MessageUtil.getMessage(MessageId.EBF1028, bzGetImagePropsBean.getKouteiKanriId(),
                    bzGetImagePropsBean.getImageId()));
                continue;
            }

            BzDropCyouhyouBean bzDropCyouhyouBean = SWAKInjector.getInstance(BzDropCyouhyouBean.class);
            bzDropCyouhyouBean.setImageId(bzGetImagePropsBean.getImageId());
            bzDropCyouhyouBean.setKouteiKanriId(bzGetImagePropsBean.getKouteiKanriId());
            bzDropCyouhyouBean.setSyoruiCd(bzGetImagePropsBean.getSyoruiCd());
            bzDropCyouhyouBean.setSyoruiTtykYmdTime(bzGetImagePropsBean.getSyoruiTtykYmdTime());
            bzDropCyouhyouBean.setKouteiKanriStatus(bzGetImagePropsBean.getKouteiKanriStatus());
            bzDropCyouhyouBean.setKengenUmu(bzGetImagePropsBean.getKengenUmu());
            bzDropCyouhyouBean.setTourokuAccountId(bzGetImagePropsBean.getTourokuAccountId());
            bzDropCyouhyouBean.setPageCount(bzGetImagePropsBean.getPageCount());
            bzDropCyouhyouBean.setJimuTetuzukiCd(bzGetProcessSummaryOutBeanLst.get(0).getJimuTetuzukiCd());
            bzDropCyouhyouBean.setJimuTetuzukiNm(bzGetProcessSummaryOutBeanLst.get(0).getJimuTetuzukiNm());
            bzDropCyouhyouBean.setKouteiStartYmd(bzGetProcessSummaryOutBeanLst.get(0).getKouteiStartYmd());
            bzDropCyouhyouBean.setKouteEndYmd(bzGetProcessSummaryOutBeanLst.get(0).getKouteEndYmd());
            bzDropCyouhyouBean.setLastKosTime(bzGetProcessSummaryOutBeanLst.get(0).getLastKosTime());
            bzDropCyouhyouBean.setFirstTantId(bzGetProcessSummaryOutBeanLst.get(0).getFirstTantId());
            bzDropCyouhyouBean.setZnkTantId(bzGetProcessSummaryOutBeanLst.get(0).getZnkTantId());
            bzDropCyouhyouBean.setZnkNodoId(bzGetProcessSummaryOutBeanLst.get(0).getZnkNodoId());
            bzDropCyouhyouBean.setZnkNodoNm(bzGetProcessSummaryOutBeanLst.get(0).getZnkNodoNm());
            bzDropCyouhyouBean.setNowTantId(bzGetProcessSummaryOutBeanLst.get(0).getNowTantId());
            bzDropCyouhyouBean.setNowNodoId(bzGetProcessSummaryOutBeanLst.get(0).getNowNodoId());
            bzDropCyouhyouBean.setNowNodoNm(bzGetProcessSummaryOutBeanLst.get(0).getNowNodoNm());
            bzDropCyouhyouBean.setJimuStartYmd(bzGetProcessSummaryOutBeanLst.get(0).getJimuStartYmd());
            bzDropCyouhyouBean.setMosNo(bzGetProcessSummaryOutBeanLst.get(0).getMosNo());
            bzDropCyouhyouBean.setSyoNo(bzGetProcessSummaryOutBeanLst.get(0).getSyoNo());
            bzDropCyouhyouBean.setSkNo(bzGetProcessSummaryOutBeanLst.get(0).getSkNo());
            bzDropCyouhyouBean.setNkSysyNo(bzGetProcessSummaryOutBeanLst.get(0).getNkSysyNo());
            bzDropCyouhyouBean.setSkeijimuKbn(bzGetProcessSummaryOutBeanLst.get(0).getSkeijimuKbn());
            bzDropCyouhyouBean.setMosUketukeKbn(bzGetProcessSummaryOutBeanLst.get(0).getMosUketukeKbn());
            bzDropCyouhyouBean.setHknsyuruiNo(bzGetProcessSummaryOutBeanLst.get(0).getHknsyuruiNo());
            bzDropCyouhyouBean.setDairitencd1(bzGetProcessSummaryOutBeanLst.get(0).getDairitencd1());
            bzDropCyouhyouBean.setDairitencd2(bzGetProcessSummaryOutBeanLst.get(0).getDairitencd2());
            bzDropCyouhyouBean.setJimuyoucd(bzGetProcessSummaryOutBeanLst.get(0).getJimuyoucd());
            bzDropCyouhyouBean.setJmycdMisetteiKbn(bzGetProcessSummaryOutBeanLst.get(0).getJmycdMisetteiKbn());
            bzDropCyouhyouBean.setDoujimosumu(bzGetProcessSummaryOutBeanLst.get(0).getDoujimosumu());
            bzDropCyouhyouBean.setJimuStartYmdTime(bzGetProcessSummaryOutBeanLst.get(0).getJimuStartYmdTime());
            bzDropCyouhyouBean.setMosymd(bzGetProcessSummaryOutBeanLst.get(0).getMosymd());
            bzDropCyouhyouBean.setKetteiKbn(bzGetProcessSummaryOutBeanLst.get(0).getKetteiKbn());
            bzDropCyouhyouBean.setSeirituKbn(bzGetProcessSummaryOutBeanLst.get(0).getSeirituKbn());
            bzDropCyouhyouBean.setLincjkKbn(bzGetProcessSummaryOutBeanLst.get(0).getLincjkKbn());
            bzDropCyouhyouBean.setSyukouteiKbn(bzGetProcessSummaryOutBeanLst.get(0).getSyukouteiKbn());
            bzDropCyouhyouBean.setSubSystemId(bzGetProcessSummaryOutBeanLst.get(0).getSubSystemId());
            bzDropCyouhyouBean.setJimutetuzukiDispOrder(bzGetProcessSummaryOutBeanLst.get(0)
                .getJimutetuzukiDispOrder());
            bzDropCyouhyouBean.setTaskDispOrder(bzGetProcessSummaryOutBeanLst.get(0).getTskDispOrder());
            bzDropCyouhyouBeanLst.add(bzDropCyouhyouBean);
            sakujyoKns++;

        }

    }

    private void mynumberTyuusyutuListDSBOut(BzDropCyouhyouBean pBzDropCyouhyouBean) {

        String seikyuusyaNm = "";
        if (SUBSYSTEMID_HOZEN.equals(pBzDropCyouhyouBean.getSubSystemId())) {
            IT_KykKihon kykKihon = hozenDomManager.getKykKihon(pBzDropCyouhyouBean.getSyoNo());
            seikyuusyaNm = kykKihon.getKykSya().getKyknmkj();
        }
        else if (SUBSYSTEMID_SIHARAI.equals(pBzDropCyouhyouBean.getSubSystemId())) {
            Integer skMaxSeikyuurirekino = siharaiDomManager.getSkMaxSeikyuurirekinoBySknoSyono(
                pBzDropCyouhyouBean.getSkNo(), pBzDropCyouhyouBean.getSyoNo());
            JT_SkKihon skKihon = siharaiDomManager.getSkKihon(pBzDropCyouhyouBean.getSkNo(),
                pBzDropCyouhyouBean.getSyoNo());
            JT_Sk sK = skKihon.getSkBySeikyuurirekino(skMaxSeikyuurirekino);
            seikyuusyaNm = sK.getSeikyuusyanmkj();
        }

        BzMynumberTyuusyutuListDataSourceBean bzMynumberTyuusyutuListDataSourceBean = SWAKInjector
            .getInstance(BzMynumberTyuusyutuListDataSourceBean.class);

        bzMynumberTyuusyutuListDataSourceBean.setIrScanreadymd(pBzDropCyouhyouBean.getSyoruiTtykYmdTime().substring(0,
            8));
        bzMynumberTyuusyutuListDataSourceBean.setIrTourokutime(pBzDropCyouhyouBean.getSyoruiTtykYmdTime().substring(8,
            10)
            + ":"
            + pBzDropCyouhyouBean.getSyoruiTtykYmdTime().substring(10, 12)
            + ":"
            + pBzDropCyouhyouBean.getSyoruiTtykYmdTime().substring(12, 14));
        bzMynumberTyuusyutuListDataSourceBean.setIrSyono(pBzDropCyouhyouBean.getSyoNo());
        bzMynumberTyuusyutuListDataSourceBean.setIrSeikyuusyanmkj(seikyuusyaNm);
        bzMynumberTyuusyutuListDataSourceBean.setIrGyoumunm(pBzDropCyouhyouBean.getJimuTetuzukiNm());
        bzMynumberTyuusyutuListDataSourceBean.setIrMaisuu(pBzDropCyouhyouBean.getPageCount());
        bzMynumberTyuusyutuListDataSourceBean.setIrBikou1("");

        bzMynumberTyuusyutuListDataSourceBeanLst.add(bzMynumberTyuusyutuListDataSourceBean);

    }

    private void myNumberCListOut(List<BzMynumberTyuusyutuListDataSourceBean> pBzMynumberTyuusyutuListDataSourceBeanLst) {

        List<IReportDataSouceBean> iReportDataSouceBeanLst = new ArrayList<>();

        if (pBzMynumberTyuusyutuListDataSourceBeanLst.size() > 0) {

            Comparator<BzMynumberTyuusyutuListDataSourceBean> comparator =
                new Comparator<BzMynumberTyuusyutuListDataSourceBean>() {

                @Override
                public int compare(BzMynumberTyuusyutuListDataSourceBean pTarget1,
                    BzMynumberTyuusyutuListDataSourceBean pTarget2) {
                    int result = pTarget1.getIrScanreadymd().compareTo(pTarget2.getIrScanreadymd());
                    if (result != 0) {
                        return result;
                    }
                    result = pTarget1.getIrTourokutime().compareTo(pTarget2.getIrTourokutime());
                    if (result != 0) {
                        return result;
                    }

                    result = pTarget1.getIrSyono().compareTo(pTarget2.getIrSyono());

                    return result;
                }
            };

            Ordering<BzMynumberTyuusyutuListDataSourceBean> ordering = Ordering
                .from(comparator);
            List<BzMynumberTyuusyutuListDataSourceBean> tempLst = ordering
                .sortedCopy(pBzMynumberTyuusyutuListDataSourceBeanLst);

            iReportDataSouceBeanLst.addAll(tempLst);
        }

        BM_TantouCd tantouCd = bizDomManager.getTantouCd(C_TantouCdKbn.DAIRITENJIMUHOZEN);
        BzGetSosikiData getSosikiData = SWAKInjector.getInstance(BzGetSosikiData.class);
        BzGetSosikiDataBean bzGetSosikiDataBean = getSosikiData.exec(tantouCd.getBusitucd() + "0000");
        String tantousituNm = bzGetSosikiDataBean.getKanjisosikinm20();

        BzMynumberTyuusyutuListBean bzMynumberTyuusyutuLstBean = SWAKInjector
            .getInstance(BzMynumberTyuusyutuListBean.class);
        BizDate syoriYmd = bzBatchParam.getSyoriYmd();

        bzMynumberTyuusyutuLstBean.setIrTantousitunm(tantousituNm);
        bzMynumberTyuusyutuLstBean.setIrSakuseiymd(DateFormatUtil.dateKANJINoEx(syoriYmd));

        CreateReport createReport = SWAKInjector.getInstance(CreateReport.class);
        ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(kinou.getSubSystemId(),
            kinou.getCategoryId(), kinou.getKinouId(), C_SyoruiCdKbn.CM_MYNUMBERTYUUSYUTULIST);
        reportServicesBean.setSyoriYmd(syoriYmd);
        reportServicesBean.addParamObjects(iReportDataSouceBeanLst, bzMynumberTyuusyutuLstBean);
        createReport.execNoCommit(reportServicesBean);

    }
}