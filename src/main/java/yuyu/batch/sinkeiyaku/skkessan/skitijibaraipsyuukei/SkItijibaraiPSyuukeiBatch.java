package yuyu.batch.sinkeiyaku.skkessan.skitijibaraipsyuukei;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.date.CHolidayAdjustingMode;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.sinkeiyaku.skkessan.skitijibaraipsyuukei.dba.SkItijibaraiPSyuukeiDao;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzfiledl.BzFileUploadUtil;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_FileSyuruiCdKbn;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.sinkeiyaku.file.csv.SkItjbrzoutokkykpdailyLayoutFile;
import yuyu.def.sinkeiyaku.file.csv.SkItjbrzoutokkykpmonthlyLayoutFile;
import yuyu.def.sinkeiyaku.result.bean.ItijibaraiNkInfosByKakutyoujobcdStartymdFromSyoriYmdBean;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 新契約 決算 一時払契約増額特約付契約Ｐ集計
 */
public class SkItijibaraiPSyuukeiBatch implements Batch {

    private static final String TYSYTTAISYOUTABLEID = "HT_SyoriCTL";

    private static final String RECOVERYFILTERID = "Sk001";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private SkItijibaraiPSyuukeiDao skItijibaraiPSyuukeiDao;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute () {

        BizDate syoriYmd = bzBatchParam.getSyoriYmd();
        String kakutyouJobCd = bzBatchParam.getIbKakutyoujobcd();
        BizDate zengetuFstEigyoubi = null;
        BizDate tougetuFstEigyoubi = null;

        batchLogger.info(MessageUtil.getMessage(
            MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW1018), kakutyouJobCd));
        batchLogger.info(MessageUtil.getMessage(
            MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003), String.valueOf(syoriYmd)));

        zengetuFstEigyoubi = getFirstBusinessDay(syoriYmd.getPreviousMonth());
        tougetuFstEigyoubi = getFirstBusinessDay(syoriYmd);

        BizDate startYmdFrom = null;

        if (BizDateUtil.compareYmd(syoriYmd, tougetuFstEigyoubi) == BizDateUtil.COMPARE_EQUAL) {

            startYmdFrom = zengetuFstEigyoubi;
        }
        else {

            startYmdFrom = tougetuFstEigyoubi;
        }

        List<SkItjbrzoutokkykpmonthlyLayoutFile> monthlyLayoutFileLst = new ArrayList<SkItjbrzoutokkykpmonthlyLayoutFile>();
        List<SkItjbrzoutokkykpdailyLayoutFile> dailyLayoutFileLst = new ArrayList<SkItjbrzoutokkykpdailyLayoutFile>();
        ItijibaraiNkInfosByKakutyoujobcdStartymdFromSyoriYmdBean syoriItjbrNkInfoBean = null;
        ItijibaraiNkInfosByKakutyoujobcdStartymdFromSyoriYmdBean znkSyoriItjbrNkInfoBean = null;
        BizCurrency fstpRyosyugk = BizCurrency.valueOf(0);
        BizCurrency dengk = BizCurrency.valueOf(0);
        long kensuu = 0;
        long monthlyLayoutFileKensuu = 0;
        long dailyLayoutFileKensuu = 0;
        SkItjbrzoutokkykpmonthlyLayoutFile monthlyLayoutFile = SWAKInjector.getInstance(SkItjbrzoutokkykpmonthlyLayoutFile.class);
        SkItjbrzoutokkykpdailyLayoutFile dailyLayoutFile = SWAKInjector.getInstance(SkItjbrzoutokkykpdailyLayoutFile.class);
        BizDate syoriInputYmd = null;
        C_Segcd syoriSeg1Cd = null;
        C_Tuukasyu syoriRsTuukasyu = null;
        BizNumber syoriKawaseRate = null;
        String kawaseRate = "";

        try (ExDBResults<ItijibaraiNkInfosByKakutyoujobcdStartymdFromSyoriYmdBean> exDBResults =
            skItijibaraiPSyuukeiDao.getItijibaraiNkInfosByKakutyoujobcdStartymdFromSyoriYmd(
                kakutyouJobCd, startYmdFrom, syoriYmd)) {

            Iterator<ItijibaraiNkInfosByKakutyoujobcdStartymdFromSyoriYmdBean> iterator = exDBResults.iterator();

            if (iterator.hasNext()) {

                while  (iterator.hasNext()) {

                    syoriItjbrNkInfoBean = iterator.next();

                    syoriInputYmd = syoriItjbrNkInfoBean.getInputymd();
                    syoriSeg1Cd = syoriItjbrNkInfoBean.getSeg1cd();
                    syoriRsTuukasyu = syoriItjbrNkInfoBean.getRstuukasyu();
                    syoriKawaseRate = syoriItjbrNkInfoBean.getDenkawaserate();

                    bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(kakutyouJobCd);
                    bzRecoveryDatasikibetuBean.setIbTableid(TYSYTTAISYOUTABLEID);
                    bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(RECOVERYFILTERID);
                    bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(syoriItjbrNkInfoBean.getMosno());

                    if (znkSyoriItjbrNkInfoBean == null) {

                        znkSyoriItjbrNkInfoBean =
                            SWAKInjector.getInstance(ItijibaraiNkInfosByKakutyoujobcdStartymdFromSyoriYmdBean.class);

                        znkSyoriItjbrNkInfoBean.setInputymd(syoriInputYmd);
                        znkSyoriItjbrNkInfoBean.setSeg1cd(syoriSeg1Cd);
                        znkSyoriItjbrNkInfoBean.setRstuukasyu(syoriRsTuukasyu);
                        znkSyoriItjbrNkInfoBean.setDenkawaserate(syoriKawaseRate);

                        fstpRyosyugk = BizCurrency.valueOf(0, syoriItjbrNkInfoBean.getRsgaku().getType());
                    }

                    if (BizDateUtil.compareYmd(syoriInputYmd, znkSyoriItjbrNkInfoBean.getInputymd()) == BizDateUtil.COMPARE_EQUAL &&
                        syoriSeg1Cd.eq(znkSyoriItjbrNkInfoBean.getSeg1cd()) &&
                        syoriRsTuukasyu.eq(znkSyoriItjbrNkInfoBean.getRstuukasyu()) &&
                        syoriKawaseRate.compareTo(znkSyoriItjbrNkInfoBean.getDenkawaserate()) == 0) {

                        fstpRyosyugk = fstpRyosyugk.add(syoriItjbrNkInfoBean.getRsgaku());
                        dengk = dengk.add(syoriItjbrNkInfoBean.getDenyenkagk());
                        kensuu++;
                    }
                    else {

                        kawaseRate = BizUtil.zero2blank(znkSyoriItjbrNkInfoBean.getDenkawaserate().toString());

                        if (BizDateUtil.compareYmd(syoriYmd, tougetuFstEigyoubi) == BizDateUtil.COMPARE_EQUAL &&
                            BizDateUtil.compareYmd(
                                znkSyoriItjbrNkInfoBean.getInputymd(), tougetuFstEigyoubi) == BizDateUtil.COMPARE_LESSER) {

                            monthlyLayoutFile = SWAKInjector.getInstance(SkItjbrzoutokkykpmonthlyLayoutFile.class);

                            monthlyLayoutFile.setIfcInputymd(znkSyoriItjbrNkInfoBean.getInputymd().toString());
                            monthlyLayoutFile.setIfcKeiricd(znkSyoriItjbrNkInfoBean.getSeg1cd().getValue());
                            monthlyLayoutFile.setIfcSyusyoukbn("");
                            monthlyLayoutFile.setIfcTuukasyu(znkSyoriItjbrNkInfoBean.getRstuukasyu().getContent());
                            monthlyLayoutFile.setIfcKawaserate(kawaseRate);
                            monthlyLayoutFile.setIfcPryosyugk(fstpRyosyugk.toString());
                            monthlyLayoutFile.setIfcDengk(dengk.toString());
                            monthlyLayoutFile.setIfcKensuu(String.valueOf(kensuu));

                            monthlyLayoutFileLst.add(monthlyLayoutFile);

                            monthlyLayoutFileKensuu++;
                        }
                        else {
                            dailyLayoutFile = SWAKInjector.getInstance(SkItjbrzoutokkykpdailyLayoutFile.class);

                            dailyLayoutFile.setIfcInputymd(znkSyoriItjbrNkInfoBean.getInputymd().toString());
                            dailyLayoutFile.setIfcKeiricd(znkSyoriItjbrNkInfoBean.getSeg1cd().getValue());
                            dailyLayoutFile.setIfcSyusyoukbn("");
                            dailyLayoutFile.setIfcTuukasyu(znkSyoriItjbrNkInfoBean.getRstuukasyu().getContent());
                            dailyLayoutFile.setIfcKawaserate(kawaseRate);
                            dailyLayoutFile.setIfcPryosyugk(fstpRyosyugk.toString());
                            dailyLayoutFile.setIfcDengk(dengk.toString());
                            dailyLayoutFile.setIfcKensuu(String.valueOf(kensuu));

                            dailyLayoutFileLst.add(dailyLayoutFile);

                            dailyLayoutFileKensuu++;
                        }

                        znkSyoriItjbrNkInfoBean.setInputymd(syoriInputYmd);
                        znkSyoriItjbrNkInfoBean.setSeg1cd(syoriSeg1Cd);
                        znkSyoriItjbrNkInfoBean.setRstuukasyu(syoriRsTuukasyu);
                        znkSyoriItjbrNkInfoBean.setDenkawaserate(syoriKawaseRate);

                        fstpRyosyugk = syoriItjbrNkInfoBean.getRsgaku();
                        dengk = syoriItjbrNkInfoBean.getDenyenkagk();
                        kensuu = 1;
                    }
                }

                kawaseRate = BizUtil.zero2blank(znkSyoriItjbrNkInfoBean.getDenkawaserate().toString());

                if (BizDateUtil.compareYmd(syoriYmd, tougetuFstEigyoubi) == BizDateUtil.COMPARE_EQUAL &&
                    BizDateUtil.compareYmd(znkSyoriItjbrNkInfoBean.getInputymd(), tougetuFstEigyoubi) == BizDateUtil.COMPARE_LESSER) {

                    monthlyLayoutFile = SWAKInjector.getInstance(SkItjbrzoutokkykpmonthlyLayoutFile.class);

                    monthlyLayoutFile.setIfcInputymd(znkSyoriItjbrNkInfoBean.getInputymd().toString());
                    monthlyLayoutFile.setIfcKeiricd(znkSyoriItjbrNkInfoBean.getSeg1cd().getValue());
                    monthlyLayoutFile.setIfcSyusyoukbn("");
                    monthlyLayoutFile.setIfcTuukasyu(znkSyoriItjbrNkInfoBean.getRstuukasyu().getContent());
                    monthlyLayoutFile.setIfcKawaserate(kawaseRate);
                    monthlyLayoutFile.setIfcPryosyugk(fstpRyosyugk.toString());
                    monthlyLayoutFile.setIfcDengk(dengk.toString());
                    monthlyLayoutFile.setIfcKensuu(String.valueOf(kensuu));

                    monthlyLayoutFileLst.add(monthlyLayoutFile);

                    monthlyLayoutFileKensuu++;
                }
                else {
                    dailyLayoutFile = SWAKInjector.getInstance(SkItjbrzoutokkykpdailyLayoutFile.class);

                    dailyLayoutFile.setIfcInputymd(znkSyoriItjbrNkInfoBean.getInputymd().toString());
                    dailyLayoutFile.setIfcKeiricd(znkSyoriItjbrNkInfoBean.getSeg1cd().getValue());
                    dailyLayoutFile.setIfcSyusyoukbn("");
                    dailyLayoutFile.setIfcTuukasyu(znkSyoriItjbrNkInfoBean.getRstuukasyu().getContent());
                    dailyLayoutFile.setIfcKawaserate(kawaseRate);
                    dailyLayoutFile.setIfcPryosyugk(fstpRyosyugk.toString());
                    dailyLayoutFile.setIfcDengk(dengk.toString());
                    dailyLayoutFile.setIfcKensuu(String.valueOf(kensuu));

                    dailyLayoutFileLst.add(dailyLayoutFile);

                    dailyLayoutFileKensuu++;
                }
            }

            bzRecoveryDatasikibetuBean.initializeBlank();

            BzFileUploadUtil bzFileUploadUtil = SWAKInjector.getInstance(BzFileUploadUtil.class);

            if (BizDateUtil.compareYmd(syoriYmd, tougetuFstEigyoubi) == BizDateUtil.COMPARE_EQUAL) {

                bzFileUploadUtil.exec(C_FileSyuruiCdKbn.SK_ITJBRZOUTOKKYKPMONTHLY, monthlyLayoutFileLst, true);
            }

            bzFileUploadUtil.exec(C_FileSyuruiCdKbn.SK_ITJBRZOUTOKKYKPDAILY, dailyLayoutFileLst, true);
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(monthlyLayoutFileKensuu), "前月分"));
        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(dailyLayoutFileKensuu), "今月分"));
    }

    private BizDate getFirstBusinessDay(BizDate pSyoriYmd) {

        BizDateYM syoriYm = pSyoriYmd.getBizDateYM();
        BizDate tougetuStartYmd = syoriYm.getFirstDay();
        BizDate tougetuFirstEgyb = tougetuStartYmd.getBusinessDay(CHolidayAdjustingMode.NEXT);

        return tougetuFirstEgyb;
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {
        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery = SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);
        bzBatchAbendCommonRecovery.exec();
    }
}
