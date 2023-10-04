package yuyu.batch.siharai.dockanri.siaddtorikomidocs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.BzGetImageProps;
import yuyu.common.biz.bzcommon.BzGetImagePropsBean;
import yuyu.common.biz.bzcommon.BzGetImagePropsInBean;
import yuyu.common.biz.bzcommon.BzGetImagePropsOutBean;
import yuyu.common.biz.bzfiledl.BzFileUploadUtil;
import yuyu.common.biz.koutei.BzGetProcessSummary;
import yuyu.common.biz.koutei.BzGetProcessSummaryInBean;
import yuyu.common.biz.koutei.BzGetProcessSummaryOutBean;
import yuyu.common.siharai.sicommon.TeisuuSiharai;
import yuyu.def.MessageId;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_FileSyuruiCdKbn;
import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.classification.C_ShrSkJyoukyou;
import yuyu.def.classification.C_ShrSkJyoukyouGtymd;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BT_GyoumuKouteiInfo;
import yuyu.def.siharai.file.csv.SiTuikaTorikomiSyoruiLayoutFile;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.logger.BatchLogger;

import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;

/**
 * 保険金給付金支払 ドキュメント管理 追加取込書類リスト作成
 */
public class SiAddTorikomiDocsBatch implements Batch {

    private final String STARTTIME = "000000000";

    private final String ENDTIME = "235959999";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam batchParam;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private AS_Kinou kinou;

    @Override
    public BzBatchParam getParam() {
        return batchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        BizDate syoriYmd = batchParam.getSyoriYmd();

        List<BzGetImagePropsBean> bzGetImagePropsBeanLst = new ArrayList<BzGetImagePropsBean>();

        List<SiTuikaTorikomiSyoruiBean> siTuikaTorikomiSyoruiBeanLst = new ArrayList<SiTuikaTorikomiSyoruiBean>();

        List<SiFukusuTorikomiSeikyuusyoBean> siFukusuTorikomiSeikyuusyoBeanLst = new ArrayList<SiFukusuTorikomiSeikyuusyoBean>();

        long syuturyokuKensuu = 0;

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(syoriYmd)));

        BzGetImageProps bzGetImageProps = SWAKInjector.getInstance(BzGetImageProps.class);

        BzGetImagePropsInBean bzGetImagePropsInBean = SWAKInjector.getInstance(BzGetImagePropsInBean.class);

        bzGetImagePropsInBean.setJimuTetuzukiCd(TeisuuSiharai.JIMUTETUZUKICD_SISIBOU);

        bzGetImagePropsInBean.setSyoruiTtykYmdTimeFrom(syoriYmd + STARTTIME);

        bzGetImagePropsInBean.setSyoruiTtykYmdTimeTo(syoriYmd + ENDTIME);

        BzGetImagePropsOutBean bzGetImagePropsOutBean = bzGetImageProps.exec(bzGetImagePropsInBean);

        for (BzGetImagePropsBean bzGetImagePropsBeanLoop : bzGetImagePropsOutBean.getBzGetImagePropsBeanLst()) {

            bzGetImagePropsBeanLst.add(bzGetImagePropsBeanLoop);
        }

        BzGetImagePropsInBean bzGetImagePropsInBean1 = SWAKInjector.getInstance(BzGetImagePropsInBean.class);

        bzGetImagePropsInBean1.setJimuTetuzukiCd(TeisuuSiharai.JIMUTETUZUKICD_SIHUBISIBOU);

        bzGetImagePropsInBean1.setSyoruiTtykYmdTimeFrom(syoriYmd + STARTTIME);

        bzGetImagePropsInBean1.setSyoruiTtykYmdTimeTo(syoriYmd + ENDTIME);

        BzGetImagePropsOutBean bzGetImagePropsOutBean1 = bzGetImageProps.exec(bzGetImagePropsInBean1);

        for (BzGetImagePropsBean bzGetImagePropsBeanLoop : bzGetImagePropsOutBean1.getBzGetImagePropsBeanLst()) {

            bzGetImagePropsBeanLst.add(bzGetImagePropsBeanLoop);
        }

        for (BzGetImagePropsBean bzGetImagePropsBeanLoop : bzGetImagePropsBeanLst) {
            String syukouteiKanriId = bzGetImagePropsBeanLoop.getKouteiKanriId();
            BT_GyoumuKouteiInfo gyoumuKouteiInfo =
                bizDomManager.getGyoumuKouteiInfo(bzGetImagePropsBeanLoop.getKouteiKanriId());
            if (gyoumuKouteiInfo != null) {
                syukouteiKanriId = gyoumuKouteiInfo.getSyukouteikanriid();
            }

            BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);

            BzGetProcessSummaryInBean bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);

            bzGetProcessSummaryInBean.setKouteiKanriId(syukouteiKanriId);
            bzGetProcessSummaryInBean.setSubSystemId(TeisuuSiharai.SUBSYSTEMID_SIHARAI);

            List<BzGetProcessSummaryOutBean> bzGetProcessSummaryOutBeanLst = bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

            if (bzGetProcessSummaryOutBeanLst.size() != 0) {

                if (C_Kouteikanristatus.KANRYOU.eq(bzGetProcessSummaryOutBeanLst.get(0).getKouteiKanriStatus())) {
                    if (syoriYmd.compareTo(bzGetProcessSummaryOutBeanLst.get(0).getKouteEndYmd()) != 0) {

                        SiTuikaTorikomiSyoruiBean siTuikaTorikomiSyoruiBean = SWAKInjector.getInstance(SiTuikaTorikomiSyoruiBean.class);

                        siTuikaTorikomiSyoruiBean.setSkJyoukyou(C_ShrSkJyoukyou.SHRSMSK);

                        siTuikaTorikomiSyoruiBean.setSyoukenNo(bzGetProcessSummaryOutBeanLst.get(0).getSyoNo());

                        siTuikaTorikomiSyoruiBean.setSeikyuuNo(bzGetProcessSummaryOutBeanLst.get(0).getSkNo());

                        siTuikaTorikomiSyoruiBean.setSkJyoukyouGtymd(C_ShrSkJyoukyouGtymd.SHRSYORIYMD);

                        siTuikaTorikomiSyoruiBean.setHiduke(bzGetProcessSummaryOutBeanLst.get(0).getKouteEndYmd().toString());

                        siTuikaTorikomiSyoruiBean.setSyoruiCode(bzGetImagePropsBeanLoop.getSyoruiCd().getValue());

                        siTuikaTorikomiSyoruiBean.setSyoruiNm(bzGetImagePropsBeanLoop.getSyoruiCd().getContent());

                        siTuikaTorikomiSyoruiBeanLst.add(siTuikaTorikomiSyoruiBean);
                    }
                }

                if (TeisuuSiharai.NODEID_SYORUITOUTYAKU.equals(bzGetProcessSummaryOutBeanLst.get(0).getNowNodoId())) {

                    SiTuikaTorikomiSyoruiBean siTuikaTorikomiSyoruiBean = SWAKInjector.getInstance(SiTuikaTorikomiSyoruiBean.class);

                    siTuikaTorikomiSyoruiBean.setSkJyoukyou(C_ShrSkJyoukyou.SKSTTYKMTSK);

                    siTuikaTorikomiSyoruiBean.setSyoukenNo(bzGetProcessSummaryOutBeanLst.get(0).getSyoNo());

                    siTuikaTorikomiSyoruiBean.setSeikyuuNo(bzGetProcessSummaryOutBeanLst.get(0).getSkNo());

                    siTuikaTorikomiSyoruiBean.setSkJyoukyouGtymd(C_ShrSkJyoukyouGtymd.MOUSIDEYMD);

                    siTuikaTorikomiSyoruiBean.setHiduke(bzGetProcessSummaryOutBeanLst.get(0).getKouteiStartYmd().toString());

                    siTuikaTorikomiSyoruiBean.setSyoruiCode(bzGetImagePropsBeanLoop.getSyoruiCd().getValue());

                    siTuikaTorikomiSyoruiBean.setSyoruiNm(bzGetImagePropsBeanLoop.getSyoruiCd().getContent());

                    siTuikaTorikomiSyoruiBeanLst.add(siTuikaTorikomiSyoruiBean);
                }

                if (C_Kouteikanristatus.TORIKESI.eq(bzGetProcessSummaryOutBeanLst.get(0).getKouteiKanriStatus())) {

                    SiTuikaTorikomiSyoruiBean siTuikaTorikomiSyoruiBean = SWAKInjector.getInstance(SiTuikaTorikomiSyoruiBean.class);

                    siTuikaTorikomiSyoruiBean.setSkJyoukyou(C_ShrSkJyoukyou.KTTRKSSK);

                    siTuikaTorikomiSyoruiBean.setSyoukenNo(bzGetProcessSummaryOutBeanLst.get(0).getSyoNo());

                    siTuikaTorikomiSyoruiBean.setSeikyuuNo(bzGetProcessSummaryOutBeanLst.get(0).getSkNo());

                    siTuikaTorikomiSyoruiBean.setSkJyoukyouGtymd(C_ShrSkJyoukyouGtymd.KOUTEITORIKESIYMD);

                    siTuikaTorikomiSyoruiBean.setHiduke(bzGetProcessSummaryOutBeanLst.get(0).getKouteEndYmd().toString());

                    siTuikaTorikomiSyoruiBean.setSyoruiCode(bzGetImagePropsBeanLoop.getSyoruiCd().getValue());

                    siTuikaTorikomiSyoruiBean.setSyoruiNm(bzGetImagePropsBeanLoop.getSyoruiCd().getContent());

                    siTuikaTorikomiSyoruiBeanLst.add(siTuikaTorikomiSyoruiBean);
                }

                if (!C_SyoruiCdKbn.HK_SB_HUBITEISEI.eq(bzGetImagePropsBeanLoop.getSyoruiCd()) &&
                    !C_SyoruiCdKbn.HK_SB_HUBIKNK.eq(bzGetImagePropsBeanLoop.getSyoruiCd()) &&
                    !C_SyoruiCdKbn.HK_SB_KAKUNINHKS.eq(bzGetImagePropsBeanLoop.getSyoruiCd())) {

                    if (C_Kouteikanristatus.SYORITYUU.eq(bzGetProcessSummaryOutBeanLst.get(0).getKouteiKanriStatus())) {

                        List<BzGetImagePropsBean> bzGetImagePropsBeanLst1 = new ArrayList<BzGetImagePropsBean>();

                        BzGetImagePropsInBean bzGetImagePropsInBean2 = SWAKInjector.getInstance(BzGetImagePropsInBean.class);

                        bzGetImagePropsInBean2.setKouteiKanriId(bzGetImagePropsBeanLoop.getKouteiKanriId());
                        bzGetImagePropsInBean2.setSyoruiCd(C_SyoruiCdKbn.HK_SB_HOKEN_SKS);

                        BzGetImagePropsOutBean bzGetImagePropsOutBean2 = bzGetImageProps.exec(bzGetImagePropsInBean2);

                        for (BzGetImagePropsBean bzGetImagePropsBeanLoop1 : bzGetImagePropsOutBean2
                            .getBzGetImagePropsBeanLst()) {

                            if(syoriYmd.compareTo(BizDate.valueOf(bzGetImagePropsBeanLoop1.getSyoruiTtykYmdTime().substring(0, 8))) != 0){

                                bzGetImagePropsBeanLst1.add(bzGetImagePropsBeanLoop1);
                            }
                        }

                        if (bzGetImagePropsBeanLst1.size() != 0) {

                            Comparator<BzGetImagePropsBean> comparator1 = new Comparator<BzGetImagePropsBean>() {

                                @Override
                                public int compare(BzGetImagePropsBean pTarget1, BzGetImagePropsBean pTarget2) {
                                    int iResult = pTarget1.getSyoruiTtykYmdTime().compareTo(pTarget2.getSyoruiTtykYmdTime());

                                    return iResult;
                                }
                            };

                            Ordering<BzGetImagePropsBean> ordering = Ordering.from(comparator1);
                            bzGetImagePropsBeanLst1 = ordering.sortedCopy(bzGetImagePropsBeanLst1);

                            SiTuikaTorikomiSyoruiBean siTuikaTorikomiSyoruiBean = SWAKInjector.getInstance(SiTuikaTorikomiSyoruiBean.class);

                            siTuikaTorikomiSyoruiBean.setSkJyoukyou(C_ShrSkJyoukyou.SKSTRKMYMD_SOUI);

                            siTuikaTorikomiSyoruiBean.setSyoukenNo(bzGetProcessSummaryOutBeanLst.get(0).getSyoNo());

                            siTuikaTorikomiSyoruiBean.setSeikyuuNo(bzGetProcessSummaryOutBeanLst.get(0).getSkNo());

                            siTuikaTorikomiSyoruiBean.setSkJyoukyouGtymd(C_ShrSkJyoukyouGtymd.SKSTORIKOMIYMD);

                            siTuikaTorikomiSyoruiBean.setHiduke(bzGetImagePropsBeanLst1.get(0).getSyoruiTtykYmdTime().substring(0, 8));

                            siTuikaTorikomiSyoruiBean.setSyoruiCode(bzGetImagePropsBeanLoop.getSyoruiCd().getValue());

                            siTuikaTorikomiSyoruiBean.setSyoruiNm(bzGetImagePropsBeanLoop.getSyoruiCd().getContent());

                            siTuikaTorikomiSyoruiBeanLst.add(siTuikaTorikomiSyoruiBean);
                        }

                        List<BzGetImagePropsBean> bzGetImagePropsBeanLst2 = new ArrayList<BzGetImagePropsBean>();

                        BzGetImagePropsInBean bzGetImagePropsInBean3 = SWAKInjector.getInstance(BzGetImagePropsInBean.class);

                        bzGetImagePropsInBean3.setKouteiKanriId(bzGetImagePropsBeanLoop.getKouteiKanriId());
                        bzGetImagePropsInBean3.setSyoruiCd(C_SyoruiCdKbn.HK_SEISANKINHRKM_IRAIS);

                        BzGetImagePropsOutBean bzGetImagePropsOutBean3 = bzGetImageProps.exec(bzGetImagePropsInBean3);

                        for (BzGetImagePropsBean bzGetImagePropsBeanLoop1 : bzGetImagePropsOutBean3
                            .getBzGetImagePropsBeanLst()) {

                            if(syoriYmd.compareTo(BizDate.valueOf(bzGetImagePropsBeanLoop1.getSyoruiTtykYmdTime().substring(0, 8))) != 0){

                                bzGetImagePropsBeanLst2.add(bzGetImagePropsBeanLoop1);
                            }
                        }

                        if (bzGetImagePropsBeanLst2.size() != 0) {

                            Comparator<BzGetImagePropsBean> comparator2 = new Comparator<BzGetImagePropsBean>(){

                                @Override
                                public int compare(BzGetImagePropsBean pTarget1, BzGetImagePropsBean pTarget2) {
                                    int iResult = pTarget1.getSyoruiTtykYmdTime().compareTo(pTarget2.getSyoruiTtykYmdTime());

                                    return iResult;
                                }
                            };

                            Ordering<BzGetImagePropsBean> ordering = Ordering.from(comparator2);
                            bzGetImagePropsBeanLst2 = ordering.sortedCopy(bzGetImagePropsBeanLst2);

                            SiTuikaTorikomiSyoruiBean siTuikaTorikomiSyoruiBean = SWAKInjector.getInstance(SiTuikaTorikomiSyoruiBean.class);

                            siTuikaTorikomiSyoruiBean.setSkJyoukyou(C_ShrSkJyoukyou.SKSTRKMYMD_SOUI);

                            siTuikaTorikomiSyoruiBean.setSyoukenNo(bzGetProcessSummaryOutBeanLst.get(0).getSyoNo());

                            siTuikaTorikomiSyoruiBean.setSeikyuuNo(bzGetProcessSummaryOutBeanLst.get(0).getSkNo());

                            siTuikaTorikomiSyoruiBean.setSkJyoukyouGtymd(C_ShrSkJyoukyouGtymd.SKSTORIKOMIYMD);

                            siTuikaTorikomiSyoruiBean.setHiduke(bzGetImagePropsBeanLst2.get(0).getSyoruiTtykYmdTime().substring(0, 8));

                            siTuikaTorikomiSyoruiBean.setSyoruiCode(bzGetImagePropsBeanLoop.getSyoruiCd().getValue());

                            siTuikaTorikomiSyoruiBean.setSyoruiNm(bzGetImagePropsBeanLoop.getSyoruiCd().getContent());

                            siTuikaTorikomiSyoruiBeanLst.add(siTuikaTorikomiSyoruiBean);
                        }
                    }
                }

                if (C_SyoruiCdKbn.HK_SB_HOKEN_SKS.eq(bzGetImagePropsBeanLoop.getSyoruiCd()) ||
                    C_SyoruiCdKbn.HK_SEISANKINHRKM_IRAIS.eq(bzGetImagePropsBeanLoop.getSyoruiCd())) {

                    boolean taisyouFlg = true;

                    if (siFukusuTorikomiSeikyuusyoBeanLst.size() != 0) {

                        for (SiFukusuTorikomiSeikyuusyoBean siFukusuTorikomiSeikyuusyoBean : siFukusuTorikomiSeikyuusyoBeanLst) {

                            if (siFukusuTorikomiSeikyuusyoBean.getKouteiKanriId().equals(
                                bzGetImagePropsBeanLoop.getKouteiKanriId()) &&
                                siFukusuTorikomiSeikyuusyoBean.getSyoruiCode().equals(
                                    bzGetImagePropsBeanLoop.getSyoruiCd().getValue())) {

                                taisyouFlg = false;

                                break;
                            }
                        }
                    }

                    if (taisyouFlg) {

                        SiFukusuTorikomiSeikyuusyoBean siFukusuTorikomiSeikyuusyoBean = SWAKInjector.getInstance(SiFukusuTorikomiSeikyuusyoBean.class);

                        siFukusuTorikomiSeikyuusyoBean.setKouteiKanriId(bzGetImagePropsBeanLoop.getKouteiKanriId());

                        siFukusuTorikomiSeikyuusyoBean.setSyoruiCode(bzGetImagePropsBeanLoop.getSyoruiCd().getValue());

                        siFukusuTorikomiSeikyuusyoBean.setSyoukenNo(bzGetProcessSummaryOutBeanLst.get(0).getSyoNo());

                        siFukusuTorikomiSeikyuusyoBean.setSeikyuuNo(bzGetProcessSummaryOutBeanLst.get(0).getSkNo());

                        siFukusuTorikomiSeikyuusyoBeanLst.add(siFukusuTorikomiSeikyuusyoBean);
                    }
                }
            }
        }

        for (SiFukusuTorikomiSeikyuusyoBean siFukusuTorikomiSeikyuusyoBean : siFukusuTorikomiSeikyuusyoBeanLst) {

            BzGetImagePropsInBean bzGetImagePropsInBean4 = SWAKInjector.getInstance(BzGetImagePropsInBean.class);

            bzGetImagePropsInBean4.setKouteiKanriId(siFukusuTorikomiSeikyuusyoBean.getKouteiKanriId());
            bzGetImagePropsInBean4.setSyoruiCd(C_SyoruiCdKbn.valueOf(siFukusuTorikomiSeikyuusyoBean.getSyoruiCode()));

            BzGetImagePropsOutBean bzGetImagePropsOutBean4 = bzGetImageProps.exec(bzGetImagePropsInBean4);

            if (bzGetImagePropsOutBean4.getBzGetImagePropsBeanLst().size() > 1) {

                Comparator<BzGetImagePropsBean> comparator3 = new Comparator<BzGetImagePropsBean>() {

                    @Override
                    public int compare(BzGetImagePropsBean pTarget1, BzGetImagePropsBean pTarget2) {
                        int iResult = pTarget1.getSyoruiTtykYmdTime().compareTo(pTarget2.getSyoruiTtykYmdTime());

                        return iResult;
                    }
                };

                Ordering<BzGetImagePropsBean> ordering = Ordering.from(comparator3);
                List<BzGetImagePropsBean> bzGetImagePropsBeanLst3 = ordering.sortedCopy(bzGetImagePropsOutBean4.getBzGetImagePropsBeanLst());

                SiTuikaTorikomiSyoruiBean siTuikaTorikomiSyoruiBean = SWAKInjector.getInstance(SiTuikaTorikomiSyoruiBean.class);

                siTuikaTorikomiSyoruiBean.setSkJyoukyou(C_ShrSkJyoukyou.SKSHKS);

                siTuikaTorikomiSyoruiBean.setSyoukenNo(siFukusuTorikomiSeikyuusyoBean.getSyoukenNo());

                siTuikaTorikomiSyoruiBean.setSeikyuuNo(siFukusuTorikomiSeikyuusyoBean.getSeikyuuNo());

                siTuikaTorikomiSyoruiBean.setSkJyoukyouGtymd(C_ShrSkJyoukyouGtymd.SKSTORIKOMIYMD);

                siTuikaTorikomiSyoruiBean.setHiduke(bzGetImagePropsBeanLst3.get(0).getSyoruiTtykYmdTime().substring(0, 8));

                siTuikaTorikomiSyoruiBean.setSyoruiCode(bzGetImagePropsBeanLst3.get(0).getSyoruiCd().getValue());

                siTuikaTorikomiSyoruiBean.setSyoruiNm(bzGetImagePropsBeanLst3.get(0).getSyoruiCd().getContent());

                siTuikaTorikomiSyoruiBeanLst.add(siTuikaTorikomiSyoruiBean);
            }
        }

        List<SiTuikaTorikomiSyoruiLayoutFile> siTuikaTorikomiSyoruiLayoutFileLst = Lists.newArrayList();

        if (siTuikaTorikomiSyoruiBeanLst.size() != 0) {

            Comparator<SiTuikaTorikomiSyoruiBean> siTuikaTorikomiSyoruiBeanComparator = new Comparator<SiTuikaTorikomiSyoruiBean>(){

                @Override
                public int compare(SiTuikaTorikomiSyoruiBean pTarget1, SiTuikaTorikomiSyoruiBean pTarget2) {
                    int iResult = pTarget1.getSkJyoukyou().getValue().compareTo(pTarget2.getSkJyoukyou().getValue());
                    if (iResult != 0) {
                        return iResult;
                    }
                    iResult = pTarget1.getSyoukenNo().compareTo(pTarget2.getSyoukenNo());
                    if (iResult != 0) {
                        return iResult;
                    }
                    iResult = pTarget1.getSeikyuuNo().compareTo(pTarget2.getSeikyuuNo());
                    if (iResult != 0) {
                        return iResult;
                    }
                    iResult = pTarget1.getHiduke().compareTo(pTarget2.getHiduke());
                    if (iResult != 0) {
                        return iResult;
                    }

                    iResult = pTarget1.getSyoruiCode().compareTo(pTarget2.getSyoruiCode());

                    return iResult;
                }
            };

            Ordering<SiTuikaTorikomiSyoruiBean> ordering = Ordering.from(siTuikaTorikomiSyoruiBeanComparator);
            siTuikaTorikomiSyoruiBeanLst = ordering.sortedCopy(siTuikaTorikomiSyoruiBeanLst);

            long renno = 0;

            for (SiTuikaTorikomiSyoruiBean siTuikaTorikomiSyoruiBean : siTuikaTorikomiSyoruiBeanLst) {

                renno++;

                SiTuikaTorikomiSyoruiLayoutFile siTuikaTorikomiSyoruiLayoutFile = SWAKInjector.getInstance(SiTuikaTorikomiSyoruiLayoutFile.class);

                siTuikaTorikomiSyoruiLayoutFile.setIfcRenno(Integer.valueOf(String.valueOf(renno)));

                siTuikaTorikomiSyoruiLayoutFile.setIfcSeikyuujk(siTuikaTorikomiSyoruiBean.getSkJyoukyou().getContent());

                siTuikaTorikomiSyoruiLayoutFile.setIfcSyono(siTuikaTorikomiSyoruiBean.getSyoukenNo());

                siTuikaTorikomiSyoruiLayoutFile.setIfcSkno(siTuikaTorikomiSyoruiBean.getSeikyuuNo());

                siTuikaTorikomiSyoruiLayoutFile.setIfcDaynm(siTuikaTorikomiSyoruiBean.getSkJyoukyouGtymd().getContent());

                siTuikaTorikomiSyoruiLayoutFile.setIfcDay(BizDate.valueOf(siTuikaTorikomiSyoruiBean.getHiduke()));

                siTuikaTorikomiSyoruiLayoutFile.setIfcSyoruinm(siTuikaTorikomiSyoruiBean.getSyoruiNm());

                siTuikaTorikomiSyoruiLayoutFile.setIfcCheck("");

                syuturyokuKensuu++;

                siTuikaTorikomiSyoruiLayoutFileLst.add(siTuikaTorikomiSyoruiLayoutFile);
            }

        }

        BzFileUploadUtil bzFileUploadUtil = SWAKInjector.getInstance(BzFileUploadUtil.class);

        C_ErrorKbn result = bzFileUploadUtil.exec(C_FileSyuruiCdKbn.SI_TUIKATRKMSYORUILST, siTuikaTorikomiSyoruiLayoutFileLst, true);

        if (C_ErrorKbn.ERROR.eq(result)) {
            throw new BizAppException(MessageId.EBF0129, kinou.getKinouNm());
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(syuturyokuKensuu), kinou.getKinouNm()));
    }
}
