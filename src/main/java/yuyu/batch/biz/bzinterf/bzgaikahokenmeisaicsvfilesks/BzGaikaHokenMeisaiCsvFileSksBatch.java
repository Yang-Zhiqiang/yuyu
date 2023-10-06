package yuyu.batch.biz.bzinterf.bzgaikahokenmeisaicsvfilesks;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.biz.bzinterf.bzgaikahokenmeisaicsvfilesks.dba.BzGaikaHokenMeisaiCsvFileSksDao;
import yuyu.batch.biz.bzinterf.bzgaikahokenmeisaicsvfilesks.dba.GaikaHokenMeisaiDataBean;
import yuyu.batch.biz.bzinterf.bzgaikahokenmeisaicsvfilesks.dba.KrDenpyoSelectJyokenBean;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzfiledl.BzFileUploadUtil;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.def.MessageId;
import yuyu.def.biz.file.csv.BzGaikaHokenMeisaiCsvfFile;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_FileSyuruiCdKbn;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 業務共通 インターフェイス 外貨建保険明細ＣＳＶファイル作成クラス
 */
public class BzGaikaHokenMeisaiCsvFileSksBatch implements Batch {

    private final String CHECK_MSG = "対象期間（自）（至）";

    private final int FILE_BUNKATU_MAX = 99;

    private final int CSV_OUT_MAX = 5000;

    private static final String LAST_HANTEI_MARK = "L";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private BzGaikaHokenMeisaiCsvFileSksDao bzGaikaHokenMeisaiCsvFileSksDao;

    @Inject
    private AS_Kinou kinou;

    @Override
    public BatchParam getParam() {

        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        BizDate syoriYmd = bzBatchParam.getSyoriYmd();
        long syoriKensuu = 0;
        long fileOutKensuu = 0;

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(syoriYmd)));

        List<KrDenpyoSelectJyokenBean> krDenpyoSelectJyokenBeanLst =
            bzGaikaHokenMeisaiCsvFileSksDao.getKrDenpyoSelectJyokenBeans(syoriYmd);
        if (krDenpyoSelectJyokenBeanLst.size() == 0 ) {
            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(syoriKensuu)));
            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0005, String.valueOf(fileOutKensuu)));
            return;
        }
        List<BzGaikaHokenMeisaiCsvfFile> bzGaikaHokenMeisaiCsvfFileLst = new ArrayList<>();
        for (KrDenpyoSelectJyokenBean krDenpyoSelectJyokenBean : krDenpyoSelectJyokenBeanLst) {
            BizDate taisyoukknFrom = krDenpyoSelectJyokenBean.getTaisyoukknfrom();
            BizDate taisyoukknTo = krDenpyoSelectJyokenBean.getTaisyoukknto();
            BizDate taisyoukknFromAddOneYear = BizDateUtil.getDateAfterPeriod(taisyoukknFrom, 1, 0);
            C_Kanjyoukmkcd[] kanjyoukmkcds;
            List<C_Kanjyoukmkcd> kanjyoukmkcdLst = new ArrayList<>();
            if ((taisyoukknFrom == null || taisyoukknTo == null)
                ||(BizDateUtil.compareYmd(taisyoukknFrom, taisyoukknTo) == BizDateUtil.COMPARE_GREATER)
                ||(BizDateUtil.compareYmd(taisyoukknFromAddOneYear, taisyoukknTo) == BizDateUtil.COMPARE_LESSER)) {
                batchLogger.info(MessageUtil.getMessage(MessageId.EBA0028, CHECK_MSG));
                batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(syoriKensuu)));
                batchLogger.info(MessageUtil.getMessage(MessageId.IBF0005, String.valueOf(fileOutKensuu)));
                return;
            }
            for (int index = 0; index < 50; index++) {
                try {
                    C_Kanjyoukmkcd kanjyoukmkCd = (C_Kanjyoukmkcd)getKanjyoukmkCd(krDenpyoSelectJyokenBean,
                        "getKanjyoukmkcd", index + 1);
                    if (kanjyoukmkCd != null) {
                        kanjyoukmkcdLst.add(kanjyoukmkCd);
                    }

                } catch (IllegalAccessException
                    | NoSuchMethodException
                    | InvocationTargetException e) {
                    throw new CommonBizAppException();
                }
            }
            kanjyoukmkcds = new C_Kanjyoukmkcd[kanjyoukmkcdLst.size()];
            kanjyoukmkcds = kanjyoukmkcdLst.toArray(kanjyoukmkcds);
            bzGaikaHokenMeisaiCsvfFileLst = new ArrayList<>();
            try (
                ExDBResults<GaikaHokenMeisaiDataBean> gaikaHokenMeisaiDataBeanLst = bzGaikaHokenMeisaiCsvFileSksDao
                .getGaikaHokenMeisaiDataBeans(taisyoukknFrom, taisyoukknTo, kanjyoukmkcds);) {
                for (GaikaHokenMeisaiDataBean gaikaHokenMeisaiDataBean : gaikaHokenMeisaiDataBeanLst) {
                    BzGaikaHokenMeisaiCsvfFile bzGaikaHokenMeisaiCsvfFile = SWAKInjector.getInstance(BzGaikaHokenMeisaiCsvfFile.class);
                    bzGaikaHokenMeisaiCsvfFile.setIfcDensyskbn(gaikaHokenMeisaiDataBean.getDensyskbn().getValue());
                    bzGaikaHokenMeisaiCsvfFile.setIfcDenrenno(gaikaHokenMeisaiDataBean.getDenrenno());
                    bzGaikaHokenMeisaiCsvfFile.setIfcEdano(gaikaHokenMeisaiDataBean.getEdano().toString());
                    bzGaikaHokenMeisaiCsvfFile.setIfcSyono(nullToString(gaikaHokenMeisaiDataBean.getKeirisyono()));
                    bzGaikaHokenMeisaiCsvfFile.setIfcDenymd8keta(nullToString(gaikaHokenMeisaiDataBean.getDenymd()));
                    bzGaikaHokenMeisaiCsvfFile.setIfcTaisyakukbn(nullToString(gaikaHokenMeisaiDataBean.getTaisyakukbn()));
                    bzGaikaHokenMeisaiCsvfFile.setIfcKanjyoukmkcd(nullToString(gaikaHokenMeisaiDataBean.getKanjyoukmkcd()));
                    bzGaikaHokenMeisaiCsvfFile.setIfcSuitoubumoncd(nullToString(gaikaHokenMeisaiDataBean.getSuitoubumoncd()));
                    bzGaikaHokenMeisaiCsvfFile.setIfcTuukasyu(nullToString(gaikaHokenMeisaiDataBean.getTuukasyu()));
                    bzGaikaHokenMeisaiCsvfFile.setIfcDengaikagk(nullToZero(gaikaHokenMeisaiDataBean.getDengaikagk()));
                    if (gaikaHokenMeisaiDataBean.getDengaikagk() == null) {
                        bzGaikaHokenMeisaiCsvfFile.setIfcDengaikagktani("");
                    }
                    else {
                        bzGaikaHokenMeisaiCsvfFile.setIfcDengaikagktani(
                            gaikaHokenMeisaiDataBean.getDengaikagk().getType().toString());
                    }

                    bzGaikaHokenMeisaiCsvfFile.setIfcDenkawaserate(nullToZero(gaikaHokenMeisaiDataBean.getDenkawaserate()));
                    bzGaikaHokenMeisaiCsvfFile.setIfcDenyenkagk(nullToZero(gaikaHokenMeisaiDataBean.getDenyenkagk()));
                    bzGaikaHokenMeisaiCsvfFile.setIfcSyoriymd8keta(nullToString(gaikaHokenMeisaiDataBean.getSyoriYmd()));
                    bzGaikaHokenMeisaiCsvfFile.setIfcSyoricd(nullToString(gaikaHokenMeisaiDataBean.getSyoricd()));
                    bzGaikaHokenMeisaiCsvfFile.setIfcKessantyouseikbn(nullToString(gaikaHokenMeisaiDataBean.getKessantyouseikbn()));
                    bzGaikaHokenMeisaiCsvfFile.setIfcDensyorikbn(nullToString(gaikaHokenMeisaiDataBean.getDensyorikbn()));
                    bzGaikaHokenMeisaiCsvfFile.setIfcKykymdstr(nullToString(gaikaHokenMeisaiDataBean.getKykymd()));
                    bzGaikaHokenMeisaiCsvfFile.setIfcSyouhnsdno(nullToString(gaikaHokenMeisaiDataBean.getSyouhnsdno()));
                    bzGaikaHokenMeisaiCsvfFile.setIfcSknnkaisiymdstr(nullToString(gaikaHokenMeisaiDataBean.getSknnkaisiymd()));
                    bzGaikaHokenMeisaiCsvfFile.setIfcMosymd(nullToString(gaikaHokenMeisaiDataBean.getMosymd()));
                    bzGaikaHokenMeisaiCsvfFile.setIfcFstpryosyuymd(nullToString(gaikaHokenMeisaiDataBean.getFstpryosyuymd()));
                    bzGaikaHokenMeisaiCsvfFile.setIfcKyktuukasyu(nullToString(gaikaHokenMeisaiDataBean.getKyktuukasyu()));
                    bzGaikaHokenMeisaiCsvfFile.setIfcKeiyakutuukagk(nullToZero(gaikaHokenMeisaiDataBean.getKeiyakutuukagk()));
                    bzGaikaHokenMeisaiCsvfFileLst.add(bzGaikaHokenMeisaiCsvfFile);
                    syoriKensuu = syoriKensuu + 1;
                }
                int renNo = 1;
                String pExFileNm;
                BzFileUploadUtil bzFileUploadUtil = SWAKInjector.getInstance(BzFileUploadUtil.class);
                if (bzGaikaHokenMeisaiCsvfFileLst.size() == 0) {
                    pExFileNm = Strings.padStart(String.valueOf(renNo), 2, '0') + LAST_HANTEI_MARK;

                    C_ErrorKbn errorKbn = bzFileUploadUtil.exec(
                        C_FileSyuruiCdKbn.BZ_GAIKAHOKENMEISAICSVF,
                        bzGaikaHokenMeisaiCsvfFileLst,
                        true,
                        pExFileNm);

                    if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                        throw new BizAppException(MessageId.EBF0129, kinou.getKinouNm());
                    }
                    fileOutKensuu = fileOutKensuu + 1;
                }
                else {
                    List<List<BzGaikaHokenMeisaiCsvfFile>> bunkatuList = Lists.partition(
                        bzGaikaHokenMeisaiCsvfFileLst, CSV_OUT_MAX);
                    for (List<BzGaikaHokenMeisaiCsvfFile> csvFileLst : bunkatuList) {
                        if (renNo == bunkatuList.size()) {
                            pExFileNm = Strings.padStart(String.valueOf(renNo), 2, '0') + LAST_HANTEI_MARK;
                        }
                        else {
                            pExFileNm = Strings.padStart(String.valueOf(renNo), 2, '0');
                        }

                        C_ErrorKbn errorKbn = bzFileUploadUtil.exec(
                            C_FileSyuruiCdKbn.BZ_GAIKAHOKENMEISAICSVF,
                            csvFileLst,
                            true,
                            pExFileNm);

                        if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                            throw new BizAppException(MessageId.EBF0129, kinou.getKinouNm());
                        }
                        renNo = renNo + 1;
                        fileOutKensuu = fileOutKensuu + 1;
                        if (renNo > FILE_BUNKATU_MAX) {
                            break;
                        }
                    }
                }
            }
        }
        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(syoriKensuu)));
        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0005, String.valueOf(fileOutKensuu)));
    }

    private Object getKanjyoukmkCd(KrDenpyoSelectJyokenBean pKrDenpyoSelectJyokenBean, String pMethodNm,
        int pMethodNo) throws
        IllegalAccessException,
        NoSuchMethodException,
        InvocationTargetException {
        Method getMethod = pKrDenpyoSelectJyokenBean.getClass().getMethod(pMethodNm + String.valueOf(pMethodNo));
        return getMethod.invoke(pKrDenpyoSelectJyokenBean);
    }

    private String nullToString(Object obj) {
        if (obj == null) {
            return "";
        }
        return obj.toString();
    }

    private String nullToZero(Object obj) {
        if (obj == null) {
            return "0";
        }
        return obj.toString();
    }
}
