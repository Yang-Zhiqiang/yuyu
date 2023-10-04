package yuyu.batch.hozen.khinterf.khsoukikaiyakukykitiransks;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.file.util.SeparateConvertUtil;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.BzGetBankData;
import yuyu.common.biz.bzdairiten.BzGetAgInfo;
import yuyu.common.biz.bzdairiten.BzGetAgInfoBean;
import yuyu.common.biz.bzdairiten.BzGetBsInfo;
import yuyu.common.biz.bzfiledl.BzFileUploadUtil;
import yuyu.common.biz.koutei.BzGetProcessSummary;
import yuyu.common.biz.koutei.BzGetProcessSummaryInBean;
import yuyu.common.biz.koutei.BzGetProcessSummaryOutBean;
import yuyu.common.hozen.khcommon.IKhozenCommonConstants;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_DiritenjyouhouKbn;
import yuyu.def.classification.C_FileSyuruiCdKbn;
import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.IT_KykDairiten;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IW_KhKaiyakuWk;
import yuyu.def.hozen.detacher.IT_KykKihonDetacher;
import yuyu.def.hozen.file.csv.KhSoukiKaiyakuDataFile;
import yuyu.def.hozen.file.csv.KhSoukiKaiyakuDataLayoutFile;
import yuyu.def.hozen.file.csv.KhSoukiKaiyakuHeaderRecordFile;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 契約保全 インターフェイス 早期解約契約一覧作成クラス
 */
public class KhSoukiKaiyakuKykItiranSksBatch implements Batch {

    public static String IB_TABLEID = "IW_KhKaiyakuWk";

    public static String IB_RECOVERYFILTERID = "Bz003";

    private static final char KANMA = ',';

    private static final String TITLE = "早期解約";

    private static final String MIDASI = "証券番号,親代理店コード,新契約募集時代理店コード,代理店保有契約代理店コード,"
        + "契約日,解約受付日,募集代理店名,支店名,契約者名,商品名,募集担当者氏名";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzbatchParam;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Override
    public BatchParam getParam() {
        return bzbatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        int kensu = 0;
        List<KhSoukiKaiyakuDataFile> khSoukiKaiyakuDataFileLst = new ArrayList<>();
        BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);
        BzFileUploadUtil bzFileUploadUtil = SWAKInjector.getInstance(BzFileUploadUtil.class);
        BzGetAgInfo bzGetAgInfo = SWAKInjector.getInstance(BzGetAgInfo.class);
        BzGetBsInfo bzGetBsInfo = SWAKInjector.getInstance(BzGetBsInfo.class);
        BzGetBankData bzGetBankData = SWAKInjector.getInstance(BzGetBankData.class);
        List<KhSoukiKaiyakuDataLayoutFile> khSoukiKaiyakuDataLayoutFileList = new ArrayList<>();

        try(ExDBResults<IW_KhKaiyakuWk> khKaiyakuWks =
            hozenDomManager.getKhKaiyakuWksByKakutyoujobcdSkssakuseiymd(bzbatchParam.getIbKakutyoujobcd(),
                bzbatchParam.getSyoriYmd())) {

            BizDateYM syoriYM = bzbatchParam.getSyoriYmd().getBizDateYM().addMonths(-4).getRekijyou();

            for (IW_KhKaiyakuWk khKaiyakuWk :khKaiyakuWks) {

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(bzbatchParam.getIbKakutyoujobcd());
                bzRecoveryDatasikibetuBean.setIbTableid(IB_TABLEID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(IB_RECOVERYFILTERID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(khKaiyakuWk.getKouteikanriid());

                KhSoukiKaiyakuDataFile khSoukiKaiyakuDataFile =
                    SWAKInjector.getInstance(KhSoukiKaiyakuDataFile.class);

                BzGetProcessSummaryInBean bzGetProcessSummaryInBean =
                    SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);

                String bankcd = "";
                String sitencd = "";
                String oyadrtencd = "";
                String skeibsyknjdrtencd = "";
                String drtenhydrtencd = "";
                String bosyudrtennm = "";
                String sitennmkj = "";
                String bosyuunm = "";

                bzGetProcessSummaryInBean.setKouteiKanriId(khKaiyakuWk.getKouteikanriid());
                bzGetProcessSummaryInBean.setJimuTetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_KAIYAKU);
                bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);

                List<BzGetProcessSummaryOutBean> bzGetProcessSummaryOutBeanLst =
                    bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

                if (bzGetProcessSummaryOutBeanLst.size() > 0) {
                    IT_KykKihon kykKihon = hozenDomManager.getKykKihon(khKaiyakuWk.getSyono());

                    kykKihon = IT_KykKihonDetacher.detachKykSyouhnKykDairitenKykSyatouched(kykKihon);

                    IT_KykSya kykSya = kykKihon.getKykSya();

                    IT_KykDairiten kykDairiten = kykKihon.getKykDairitenByDrtenrenno(1);

                    List<IT_KykSyouhn> kykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

                    if (kykSyouhnLst.size() != 0 && kykDairiten != null && kykSya != null) {

                        if (C_YuukousyoumetuKbn.SYOUMETU.eq(kykSyouhnLst.get(0).getYuukousyoumetukbn())) {
                            continue;
                        }

                        BizDateYM mosym = kykKihon.getMosymd().getBizDateYM();

                        if (mosym.compareTo(syoriYM) >= 0) {

                            IT_KykSyouhn kykSyouhn = kykSyouhnLst.get(0);

                            List<BzGetAgInfoBean> bzGetAgInfoBeanLst = bzGetAgInfo.exec(kykDairiten.getDrtencd());

                            for (BzGetAgInfoBean bzGetAgInfoBean : bzGetAgInfoBeanLst) {
                                if (C_DiritenjyouhouKbn.SHITEIKO.eq(bzGetAgInfoBean.getDiritenJyouhouKbn())) {
                                    bankcd = bzGetAgInfoBean.getKinyuuCd();
                                    if(!BizUtil.isBlank(bzGetAgInfoBean.getKinyuuSitenCd())) {
                                        sitencd = bzGetAgInfoBean.getKinyuuSitenCd().substring(1);
                                    }
                                    skeibsyknjdrtencd = bzGetAgInfoBean.getDrtenCd();
                                    bosyudrtennm = bzGetAgInfoBean.getKanjiDairitenNm();
                                }
                                else if (C_DiritenjyouhouKbn.SHITEIOYA.eq(bzGetAgInfoBean.getDiritenJyouhouKbn())) {
                                    oyadrtencd = bzGetAgInfoBean.getDrtenCd();
                                }
                                else if (C_DiritenjyouhouKbn.KEISYOUKO.eq(bzGetAgInfoBean.getDiritenJyouhouKbn())) {
                                    drtenhydrtencd = bzGetAgInfoBean.getDrtenCd();
                                }
                            }

                            if(!BizUtil.isBlank(bankcd) && !BizUtil.isBlank(sitencd)) {
                                sitennmkj = bzGetBankData.exec(bankcd, sitencd, bzbatchParam.getSyoriYmd()).getSitenNmKj();
                            }

                            bosyuunm = bzGetBsInfo.exec(kykDairiten.getBosyuucd()).getKanjiBosyuuninNm();

                            BM_SyouhnZokusei syouhnZokusei = kykSyouhn.getSyouhnZokusei();

                            khSoukiKaiyakuDataFile.setIfcSyono(kykKihon.getSyono());
                            khSoukiKaiyakuDataFile.setIfcOyadrtencd(oyadrtencd);
                            khSoukiKaiyakuDataFile.setIfcSkeibsyknjdrtencd(skeibsyknjdrtencd);
                            khSoukiKaiyakuDataFile.setIfcDrtenhydrtencd(drtenhydrtencd);
                            khSoukiKaiyakuDataFile.setIfcKykymd(kykSyouhn.getKykymd());
                            khSoukiKaiyakuDataFile.setIfcKaiyakuymd(khKaiyakuWk.getSkssakuseiymd().toString());
                            khSoukiKaiyakuDataFile.setIfcBosyudrtennm(bosyudrtennm);
                            khSoukiKaiyakuDataFile.setIfcSitennm(sitennmkj);
                            khSoukiKaiyakuDataFile.setIfcKyksyamei(kykSya.getKyknmkj());
                            khSoukiKaiyakuDataFile.setIfcSyouhnnm(syouhnZokusei.getSyouhnnmsyouken() +
                                "「" + kykKihon.getAisyoumeikbn().getContent() + "」");
                            khSoukiKaiyakuDataFile.setIfcBosyuTntnm(bosyuunm);

                            khSoukiKaiyakuDataFileLst.add(khSoukiKaiyakuDataFile);
                            kensu++;
                        }
                    }
                }
            }
            KhSoukiKaiyakuDataLayoutFile khSoukiKaiyakuDataLayoutFileHeader =
                SWAKInjector.getInstance(KhSoukiKaiyakuDataLayoutFile.class);

            KhSoukiKaiyakuHeaderRecordFile khSoukiKaiyakuHeaderRecordFile =
                SWAKInjector.getInstance(KhSoukiKaiyakuHeaderRecordFile.class);

            List<KhSoukiKaiyakuDataLayoutFile> khSoukiKaiyakuDataLayoutFileListData = new ArrayList<>();

            for (KhSoukiKaiyakuDataFile KhSoukiKaiyakuDataFile : khSoukiKaiyakuDataFileLst) {

                KhSoukiKaiyakuDataLayoutFile khSoukiKaiyakuDataLayoutFile =
                    SWAKInjector.getInstance(KhSoukiKaiyakuDataLayoutFile.class);

                String dataRecord = SeparateConvertUtil.beanToStringForSeparate(KhSoukiKaiyakuDataFile,
                    KANMA);

                khSoukiKaiyakuDataLayoutFile.setIfcSoukikaiyakudata(dataRecord);

                khSoukiKaiyakuDataLayoutFileListData.add(khSoukiKaiyakuDataLayoutFile);
            }

            khSoukiKaiyakuHeaderRecordFile.setIfcTitle(TITLE);

            String headRecord = SeparateConvertUtil.beanToStringForSeparate(khSoukiKaiyakuHeaderRecordFile,
                KANMA);

            khSoukiKaiyakuDataLayoutFileHeader.setIfcSoukikaiyakudata(headRecord);

            khSoukiKaiyakuDataLayoutFileList.add(khSoukiKaiyakuDataLayoutFileHeader);

            KhSoukiKaiyakuDataLayoutFile khSoukiKaiyakuDataLayoutFileMidasi =
                SWAKInjector.getInstance(KhSoukiKaiyakuDataLayoutFile.class);

            khSoukiKaiyakuDataLayoutFileMidasi.setIfcSoukikaiyakudata(MIDASI);

            khSoukiKaiyakuDataLayoutFileList.add(khSoukiKaiyakuDataLayoutFileMidasi);

            khSoukiKaiyakuDataLayoutFileList.addAll(khSoukiKaiyakuDataLayoutFileListData);
        }

        bzRecoveryDatasikibetuBean.initializeBlank();

        bzFileUploadUtil.exec(C_FileSyuruiCdKbn.KH_SOUKIKAIYAKUDATA, khSoukiKaiyakuDataLayoutFileList, false);

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(kensu)));
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }
}
