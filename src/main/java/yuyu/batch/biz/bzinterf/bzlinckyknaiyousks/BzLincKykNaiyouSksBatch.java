package yuyu.batch.biz.bzinterf.bzlinckyknaiyousks;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.db.MultipleEntityInserter;
import jp.co.slcs.swak.db.MultipleEntityUpdater;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.biz.bzinterf.bzlinckyknaiyousks.dba.BzLincKykNaiyouSksDao;
import yuyu.batch.biz.bzinterf.bzlinckyknaiyousks.dba.KhLincSousinDataBean;
import yuyu.batch.biz.bzinterf.bzlinckyknaiyousks.dba.SkLincSousinDataBean;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_KykKbn;
import yuyu.def.classification.C_SousinKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.HT_SkLincSousinData;
import yuyu.def.db.entity.IT_KhLincSousinData;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.ZT_OnlineLincSousinTy;
import yuyu.def.db.entity.ZT_YakansyoriLincSousinTy;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

import com.google.common.base.Strings;

/**
 * 業務共通 インターフェイス 契約内容ＬＩＮＣ送信Ｆ作成
 */
public class BzLincKykNaiyouSksBatch implements Batch {

    private static final String TYSYTTAISYOU_TABLE_ID_SINKEIYAKU = "HT_SkLincSousinData";

    private static final String TYSYTTAISYOU_TABLE_ID_HOZEN = "IT_KhLincSousinData";

    private static final String RECOVERY_FILTER_KBNID_SINKEIYAKU = "Sk001";

    private static final String RECOVERY_FILTER_KBNID_HOZEN = "Bz001";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzLincKykNaiyouSksBatchParam bzLincKykNaiyouSksBatchParam;

    @Inject
    private BzLincKykNaiyouSksDao bzLincKykNaiyouSksDao;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private AS_Kinou kinou;

    @Override
    public BatchParam getParam() {
        return bzLincKykNaiyouSksBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        long syoriKensuu = 0;

        String lincSousinDataSyurui = bzLincKykNaiyouSksBatchParam.getLincsousindatasyurui();
        BizDate syoriYmd = bzLincKykNaiyouSksBatchParam.getSyoriYmd();
        String ibKakutyoujobcd = bzLincKykNaiyouSksBatchParam.getIbKakutyoujobcd();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(syoriYmd)));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW1024),
            lincSousinDataSyurui));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW1018),
            ibKakutyoujobcd));

        if ("onlineSk".equals(lincSousinDataSyurui) ||
            "yakanSk".equals(lincSousinDataSyurui)) {

            int lincRecordSyurui;
            if ("onlineSk".equals(lincSousinDataSyurui)) {
                lincRecordSyurui = 5;
            }
            else {
                lincRecordSyurui = 21;
            }

            try (
                ExDBResults<SkLincSousinDataBean> SkLincSousinDataBeanLst = bzLincKykNaiyouSksDao.
                getSkLincSousinDataBeansByRecordsyubetuSyoriymdKakutyoujobcd(lincRecordSyurui, syoriYmd, ibKakutyoujobcd);
                MultipleEntityInserter multipleEntityInserter = new MultipleEntityInserter();
                MultipleEntityUpdater multipleEntityUpdater = new MultipleEntityUpdater();) {

                for (SkLincSousinDataBean skLincSousinDataBean : SkLincSousinDataBeanLst) {
                    bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(ibKakutyoujobcd);
                    bzRecoveryDatasikibetuBean.setIbTableid(TYSYTTAISYOU_TABLE_ID_SINKEIYAKU);
                    bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(RECOVERY_FILTER_KBNID_SINKEIYAKU);
                    bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(skLincSousinDataBean.getMosno());

                    HT_SkLincSousinData skLincSousinData = sinkeiyakuDomManager.getSkLincSousinData(
                        skLincSousinDataBean.getMosno(),
                        skLincSousinDataBean.getSyoriYmd(),
                        skLincSousinDataBean.getRenno());

                    if ("onlineSk".equals(lincSousinDataSyurui)) {

                        ZT_OnlineLincSousinTy onlineLincSousinTy = new ZT_OnlineLincSousinTy();
                        onlineLincSousinTy.setZtydatakbn("2");
                        onlineLincSousinTy.setZtyrecordsyubetukbn(
                            Strings.padStart(skLincSousinData.getLincrecordsyubetu().toString(), 2, '0'));
                        if (BizUtil.isBlank(skLincSousinData.getLinchenkoutype())) {
                            onlineLincSousinTy.setZtyhenkoutype(" ");
                        }
                        else {
                            onlineLincSousinTy.setZtyhenkoutype(skLincSousinData.getLinchenkoutype());
                        }
                        onlineLincSousinTy.setZtysyorikekkacd("0");
                        onlineLincSousinTy.setZtysyorikekkaerrjiyuu("00");
                        onlineLincSousinTy.setZtysyorikekkaerrno("000");
                        onlineLincSousinTy.setZtynayoserecordsuu("000");
                        onlineLincSousinTy.setZtykanyuusyano(
                            Strings.padStart(skLincSousinData.getLinckanyuusyano().toString(), 12, '0'));
                        onlineLincSousinTy.setZtykyoukaisiyouknnm("                                ");
                        onlineLincSousinTy.setZtyhhknseikbn(skLincSousinData.getLinchhknsei().toString());
                        onlineLincSousinTy.setZtyhhknseiymd(nengappiKirikae(skLincSousinData.getLinchhknseiymd()));
                        onlineLincSousinTy.setZtykykymd(nengappiKirikae(skLincSousinData.getLinckykymd()));
                        onlineLincSousinTy.setZtykyksyhhknsydouituhyouji(
                            kykHhknDouHyoujiKirikae(skLincSousinData.getLinckeihidjnhyouji()));
                        onlineLincSousinTy.setZtysousinmotokaisyacd("20");
                        onlineLincSousinTy.setZtyhhknadrkn(
                            Strings.padEnd(skLincSousinData.getLinchhknadrkn(), 30, ' '));
                        onlineLincSousinTy.setZtysiginyuintkykntgkstr(
                            Strings.padStart(skLincSousinData.getLincsgnyukyhng().toAdsoluteString(), 5, '0'));
                        onlineLincSousinTy.setZtysppinyuintkykntgkstr(
                            Strings.padStart(skLincSousinData.getLincsipnyukyhng().toAdsoluteString(), 5, '0'));
                        onlineLincSousinTy.setZtysijnbyutkykntgkstr(
                            Strings.padStart(skLincSousinData.getLincsjnyukyhng().toAdsoluteString(), 5, '0'));
                        onlineLincSousinTy.setZtysonotatokuyakuntgkstr(
                            Strings.padStart(skLincSousinData.getLincsonotanyukyhng().toAdsoluteString(), 5, '0'));
                        onlineLincSousinTy.setZtytrkmousideymd(
                            nengappiKirikae(skLincSousinData.getLinctrkmousideymd()));
                        onlineLincSousinTy.setZtylincsyoriymd("00000000");
                        onlineLincSousinTy.setZtyyuyusiyouknnm(
                            Strings.padEnd(skLincSousinData.getLinchhknnmkn(), 32, ' '));
                        onlineLincSousinTy.setZtykykkanrino(skLincSousinData.getLinckakusyasiyouran());
                        onlineLincSousinTy.setZtyhozenymd("00000000");
                        onlineLincSousinTy.setZtykykknnm(
                            Strings.padEnd(skLincSousinData.getLinckyknmkn(), 42, ' '));
                        onlineLincSousinTy.setZtyhutuusbsstr(
                            Strings.padStart(skLincSousinData.getLinchutuusbs().toAdsoluteString(), 10, '0'));
                        onlineLincSousinTy.setZtysgsbstr(
                            Strings.padStart(skLincSousinData.getLincsgsbksns().toAdsoluteString(), 10, '0'));
                        onlineLincSousinTy.setZtykakusyasiyouran(skLincSousinData.getLinckakusyasiyouran());
                        onlineLincSousinTy.setZtymousideflg(skLincSousinData.getLincmousideflg().toString());
                        onlineLincSousinTy.setZtymousideflgsetymd(nengappiKirikae(
                            skLincSousinData.getLincmousideflgsetymd()));
                        onlineLincSousinTy.setZtymousideflgkaijyoymd(nengappiKirikae(
                            skLincSousinData.getLincmousideflgkaijyoymd()));
                        onlineLincSousinTy.setZtyjgyhknflg(skLincSousinData.getLincjgyhknflg().toString());
                        onlineLincSousinTy.setZtytnknflg(skLincSousinData.getLinctenkanflg().toString());
                        onlineLincSousinTy.setZtykyksyaseikbn(skLincSousinData.getLinckyksei().toString());
                        onlineLincSousinTy.setZtykyksyaseiymd(nengappiKirikae(skLincSousinData.getLinckykseiymd()));
                        onlineLincSousinTy.setZtykykadrkn(
                            Strings.padEnd(skLincSousinData.getLinckykadrkn(), 30, ' '));
                        onlineLincSousinTy.setZtyyobiv17("                 ");
                        onlineLincSousinTy.setZtyknjhhknmei30(
                            Strings.padEnd(skLincSousinData.getLinchhknnmkj(), 30, '　'));
                        onlineLincSousinTy.setZtykjkyknm30(
                            Strings.padEnd(skLincSousinData.getLinckyknmkj(), 30, '　'));
                        onlineLincSousinTy.setZty15sai1000manflg("0");
                        onlineLincSousinTy.setZtykjhngflg("0");
                        onlineLincSousinTy.setZtykykytymd(nengappiKirikae(skLincSousinData.getLinckykytymd()));
                        onlineLincSousinTy.setZtyhozenytymd(nengappiKirikae(skLincSousinData.getLinchozenytymd()));
                        onlineLincSousinTy.setZty15mimantkhukaymd("00000000");
                        onlineLincSousinTy.setZty15mimantkhukayoteiymd("00000000");
                        onlineLincSousinTy.setZtyyobiv46("                                              ");

                        BizPropertyInitializer.initialize(onlineLincSousinTy);

                        multipleEntityInserter.add(onlineLincSousinTy);
                    }
                    else {
                        ZT_YakansyoriLincSousinTy yakansyoriLincSousinTy = new ZT_YakansyoriLincSousinTy();
                        yakansyoriLincSousinTy.setZtydatakbn("2");
                        yakansyoriLincSousinTy.setZtyrecordsyubetukbn(
                            Strings.padStart(skLincSousinData.getLincrecordsyubetu().toString(), 2, '0'));
                        if (BizUtil.isBlank(skLincSousinData.getLinchenkoutype())) {
                            yakansyoriLincSousinTy.setZtyhenkoutype(" ");
                        }
                        else {
                            yakansyoriLincSousinTy.setZtyhenkoutype(skLincSousinData.getLinchenkoutype());
                        }
                        yakansyoriLincSousinTy.setZtysyorikekkacd("0");
                        yakansyoriLincSousinTy.setZtysyorikekkaerrjiyuu("00");
                        yakansyoriLincSousinTy.setZtysyorikekkaerrno("000");
                        yakansyoriLincSousinTy.setZtynayoserecordsuu("000");
                        yakansyoriLincSousinTy.setZtykanyuusyano(
                            Strings.padStart(skLincSousinData.getLinckanyuusyano().toString(), 12, '0'));
                        yakansyoriLincSousinTy.setZtykyoukaisiyouknnm("                                ");
                        yakansyoriLincSousinTy.setZtyhhknseikbn(skLincSousinData.getLinchhknsei().toString());
                        yakansyoriLincSousinTy.setZtyhhknseiymd(nengappiKirikae(skLincSousinData.getLinchhknseiymd()));
                        yakansyoriLincSousinTy.setZtykykymd(nengappiKirikae(skLincSousinData.getLinckykymd()));
                        yakansyoriLincSousinTy.setZtykyksyhhknsydouituhyouji(
                            kykHhknDouHyoujiKirikae(skLincSousinData.getLinckeihidjnhyouji()));
                        yakansyoriLincSousinTy.setZtysousinmotokaisyacd("20");
                        yakansyoriLincSousinTy.setZtyhhknadrkn(
                            Strings.padEnd(skLincSousinData.getLinchhknadrkn(), 30, ' '));
                        yakansyoriLincSousinTy.setZtysiginyuintkykntgkstr(
                            Strings.padStart(skLincSousinData.getLincsgnyukyhng().toAdsoluteString(), 5, '0'));
                        yakansyoriLincSousinTy.setZtysppinyuintkykntgkstr(
                            Strings.padStart(skLincSousinData.getLincsipnyukyhng().toAdsoluteString(), 5, '0'));
                        yakansyoriLincSousinTy.setZtysijnbyutkykntgkstr(
                            Strings.padStart(skLincSousinData.getLincsjnyukyhng().toAdsoluteString(), 5, '0'));
                        yakansyoriLincSousinTy.setZtysonotatokuyakuntgkstr(
                            Strings.padStart(skLincSousinData.getLincsonotanyukyhng().toAdsoluteString(), 5, '0'));
                        yakansyoriLincSousinTy.setZtytrkmousideymd(
                            nengappiKirikae(skLincSousinData.getLinctrkmousideymd()));
                        yakansyoriLincSousinTy.setZtylincsyoriymd("00000000");
                        yakansyoriLincSousinTy.setZtyyuyusiyouknnm(
                            Strings.padEnd(skLincSousinData.getLinchhknnmkn(), 32, ' '));
                        yakansyoriLincSousinTy.setZtykykkanrino(skLincSousinData.getLinckakusyasiyouran());
                        yakansyoriLincSousinTy.setZtyhozenymd("00000000");
                        yakansyoriLincSousinTy.setZtykykknnm(
                            Strings.padEnd(skLincSousinData.getLinckyknmkn(), 42, ' '));
                        yakansyoriLincSousinTy.setZtyhutuusbsstr(
                            Strings.padStart(skLincSousinData.getLinchutuusbs().toAdsoluteString(), 10, '0'));
                        yakansyoriLincSousinTy.setZtysgsbstr(
                            Strings.padStart(skLincSousinData.getLincsgsbksns().toAdsoluteString(), 10, '0'));
                        yakansyoriLincSousinTy.setZtykakusyasiyouran(skLincSousinData.getLinckakusyasiyouran());
                        yakansyoriLincSousinTy.setZtymousideflg(skLincSousinData.getLincmousideflg().toString());
                        yakansyoriLincSousinTy.setZtymousideflgsetymd(nengappiKirikae(
                            skLincSousinData.getLincmousideflgsetymd()));
                        yakansyoriLincSousinTy.setZtymousideflgkaijyoymd(nengappiKirikae(
                            skLincSousinData.getLincmousideflgkaijyoymd()));
                        yakansyoriLincSousinTy.setZtyjgyhknflg(skLincSousinData.getLincjgyhknflg().toString());
                        yakansyoriLincSousinTy.setZtytnknflg(skLincSousinData.getLinctenkanflg().toString());
                        yakansyoriLincSousinTy.setZtykyksyaseikbn(skLincSousinData.getLinckyksei().toString());
                        yakansyoriLincSousinTy.setZtykyksyaseiymd(nengappiKirikae(skLincSousinData.getLinckykseiymd()));
                        yakansyoriLincSousinTy.setZtykykadrkn(
                            Strings.padEnd(skLincSousinData.getLinckykadrkn(), 30, ' '));
                        yakansyoriLincSousinTy.setZtyyobiv17("                 ");
                        yakansyoriLincSousinTy.setZtyknjhhknmei30(
                            Strings.padEnd(skLincSousinData.getLinchhknnmkj(), 30, '　'));
                        yakansyoriLincSousinTy.setZtykjkyknm30(
                            Strings.padEnd(skLincSousinData.getLinckyknmkj(), 30, '　'));
                        yakansyoriLincSousinTy.setZty15sai1000manflg("0");
                        yakansyoriLincSousinTy.setZtykjhngflg("0");
                        yakansyoriLincSousinTy.setZtykykytymd(nengappiKirikae(skLincSousinData.getLinckykytymd()));
                        yakansyoriLincSousinTy.setZtyhozenytymd(nengappiKirikae(skLincSousinData.getLinchozenytymd()));
                        yakansyoriLincSousinTy.setZty15mimantkhukaymd("00000000");
                        yakansyoriLincSousinTy.setZty15mimantkhukayoteiymd("00000000");
                        yakansyoriLincSousinTy.setZtyyobiv46("                                              ");

                        BizPropertyInitializer.initialize(yakansyoriLincSousinTy);

                        multipleEntityInserter.add(yakansyoriLincSousinTy);
                    }

                    skLincSousinData.setLincsousinkbn(C_SousinKbn.SOUSINZUMI);
                    skLincSousinData.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                    skLincSousinData.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());
                    multipleEntityUpdater.add(skLincSousinData);

                    syoriKensuu++;
                }
            }

            bzRecoveryDatasikibetuBean.initializeBlank();
        }
        else {
            try (
                ExDBResults<KhLincSousinDataBean> SkLincSousinDataBeanLst = bzLincKykNaiyouSksDao.
                getKhLincSousinDataBeansBySyoriymdKakutyoujobcd(syoriYmd, ibKakutyoujobcd);
                MultipleEntityInserter multipleEntityInserter = new MultipleEntityInserter();
                MultipleEntityUpdater multipleEntityUpdater = new MultipleEntityUpdater();) {

                for (KhLincSousinDataBean khLincSousinDataBean : SkLincSousinDataBeanLst) {
                    bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(ibKakutyoujobcd);
                    bzRecoveryDatasikibetuBean.setIbTableid(TYSYTTAISYOU_TABLE_ID_HOZEN);
                    bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(RECOVERY_FILTER_KBNID_HOZEN);
                    bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(khLincSousinDataBean.getSyono());

                    IT_KykKihon kykkihon = hozenDomManager.getKykKihon(khLincSousinDataBean.getSyono());
                    IT_KhLincSousinData khLincSousinData = kykkihon.getKhLincSousinDataBySyoriYmdRenno(
                        khLincSousinDataBean.getSyoriYmd(), khLincSousinDataBean.getRenno());

                    ZT_YakansyoriLincSousinTy yakansyoriLincSousinTy = new ZT_YakansyoriLincSousinTy();
                    yakansyoriLincSousinTy.setZtydatakbn("2");
                    yakansyoriLincSousinTy.setZtyrecordsyubetukbn(
                        Strings.padStart(khLincSousinData.getLincrecordsyubetu().toString(), 2, '0'));
                    if (BizUtil.isBlank(khLincSousinData.getLinchenkoutype())) {
                        yakansyoriLincSousinTy.setZtyhenkoutype(" ");
                    }
                    else {
                        yakansyoriLincSousinTy.setZtyhenkoutype(khLincSousinData.getLinchenkoutype());
                    }
                    yakansyoriLincSousinTy.setZtysyorikekkacd("0");
                    yakansyoriLincSousinTy.setZtysyorikekkaerrjiyuu("00");
                    yakansyoriLincSousinTy.setZtysyorikekkaerrno("000");
                    yakansyoriLincSousinTy.setZtynayoserecordsuu("000");
                    yakansyoriLincSousinTy.setZtykanyuusyano(
                        Strings.padStart(khLincSousinData.getLinckanyuusyano().toString(), 12, '0'));
                    yakansyoriLincSousinTy.setZtykyoukaisiyouknnm("                                ");
                    yakansyoriLincSousinTy.setZtyhhknseikbn(khLincSousinData.getLinchhknsei().toString());
                    yakansyoriLincSousinTy.setZtyhhknseiymd(nengappiKirikae(khLincSousinData.getLinchhknseiymd()));
                    yakansyoriLincSousinTy.setZtykykymd(nengappiKirikae(khLincSousinData.getLinckykymd()));
                    yakansyoriLincSousinTy.setZtykyksyhhknsydouituhyouji(
                        kykHhknDouHyoujiKirikae(khLincSousinData.getLinckeihidjnhyouji()));
                    yakansyoriLincSousinTy.setZtysousinmotokaisyacd("20");
                    yakansyoriLincSousinTy.setZtyhhknadrkn(
                        Strings.padEnd(khLincSousinData.getLinchhknadrkn(), 30, ' '));
                    yakansyoriLincSousinTy.setZtysiginyuintkykntgkstr(
                        Strings.padStart(khLincSousinData.getLincsgnyukyhng().toAdsoluteString(), 5, '0'));
                    yakansyoriLincSousinTy.setZtysppinyuintkykntgkstr(
                        Strings.padStart(khLincSousinData.getLincsipnyukyhng().toAdsoluteString(), 5, '0'));
                    yakansyoriLincSousinTy.setZtysijnbyutkykntgkstr(
                        Strings.padStart(khLincSousinData.getLincsjnyukyhng().toAdsoluteString(), 5, '0'));
                    yakansyoriLincSousinTy.setZtysonotatokuyakuntgkstr(
                        Strings.padStart(khLincSousinData.getLincsonotanyukyhng().toAdsoluteString(), 5, '0'));
                    yakansyoriLincSousinTy.setZtytrkmousideymd(
                        nengappiKirikae(khLincSousinData.getLinctrkmousideymd()));
                    yakansyoriLincSousinTy.setZtylincsyoriymd("00000000");
                    yakansyoriLincSousinTy.setZtyyuyusiyouknnm(
                        Strings.padEnd(khLincSousinData.getLinchhknnmkn(), 32, ' '));
                    yakansyoriLincSousinTy.setZtykykkanrino(khLincSousinData.getLinckakusyasiyouran());
                    yakansyoriLincSousinTy.setZtyhozenymd("00000000");
                    yakansyoriLincSousinTy.setZtykykknnm(
                        Strings.padEnd(khLincSousinData.getLinckyknmkn(), 42, ' '));
                    yakansyoriLincSousinTy.setZtyhutuusbsstr(
                        Strings.padStart(khLincSousinData.getLinchutuusbs().toAdsoluteString(), 10, '0'));
                    yakansyoriLincSousinTy.setZtysgsbstr(
                        Strings.padStart(khLincSousinData.getLincsgsbksns().toAdsoluteString(), 10, '0'));
                    yakansyoriLincSousinTy.setZtykakusyasiyouran(khLincSousinData.getLinckakusyasiyouran());
                    yakansyoriLincSousinTy.setZtymousideflg(khLincSousinData.getLincmousideflg().toString());
                    yakansyoriLincSousinTy.setZtymousideflgsetymd(nengappiKirikae(
                        khLincSousinData.getLincmousideflgsetymd()));
                    yakansyoriLincSousinTy.setZtymousideflgkaijyoymd(nengappiKirikae(
                        khLincSousinData.getLincmousideflgkaijyoymd()));
                    yakansyoriLincSousinTy.setZtyjgyhknflg(khLincSousinData.getLincjgyhknflg().toString());
                    yakansyoriLincSousinTy.setZtytnknflg(khLincSousinData.getLinctenkanflg().toString());
                    yakansyoriLincSousinTy.setZtykyksyaseikbn(khLincSousinData.getLinckyksei().toString());
                    yakansyoriLincSousinTy.setZtykyksyaseiymd(nengappiKirikae(khLincSousinData.getLinckykseiymd()));
                    yakansyoriLincSousinTy.setZtykykadrkn(
                        Strings.padEnd(khLincSousinData.getLinckykadrkn(), 30, ' '));
                    yakansyoriLincSousinTy.setZtyyobiv17("                 ");
                    yakansyoriLincSousinTy.setZtyknjhhknmei30(
                        Strings.padEnd(khLincSousinData.getLinchhknnmkj(), 30, '　'));
                    yakansyoriLincSousinTy.setZtykjkyknm30(
                        Strings.padEnd(khLincSousinData.getLinckyknmkj(), 30, '　'));
                    yakansyoriLincSousinTy.setZty15sai1000manflg("0");
                    yakansyoriLincSousinTy.setZtykjhngflg("0");
                    yakansyoriLincSousinTy.setZtykykytymd(nengappiKirikae(khLincSousinData.getLinckykytymd()));
                    yakansyoriLincSousinTy.setZtyhozenytymd(nengappiKirikae(khLincSousinData.getLinchozenytymd()));
                    yakansyoriLincSousinTy.setZty15mimantkhukaymd("00000000");
                    yakansyoriLincSousinTy.setZty15mimantkhukayoteiymd("00000000");
                    yakansyoriLincSousinTy.setZtyyobiv46("                                              ");

                    BizPropertyInitializer.initialize(yakansyoriLincSousinTy);

                    multipleEntityInserter.add(yakansyoriLincSousinTy);

                    khLincSousinData.setLincsousinkbn(C_SousinKbn.SOUSINZUMI);
                    khLincSousinData.setGyoumuKousinKinou(kinou.getKinouId());
                    khLincSousinData.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                    khLincSousinData.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

                    multipleEntityUpdater.add(kykkihon);

                    syoriKensuu++;
                }
            }

            bzRecoveryDatasikibetuBean.initializeBlank();
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IAC0020, String.valueOf(syoriKensuu)));
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);
        bzBatchAbendCommonRecovery.exec();
    }

    private String nengappiKirikae(BizDate pDate) {
        if (pDate == null) {
            return "00000000";
        }

        return pDate.toString();
    }

    private String kykHhknDouHyoujiKirikae(C_KykKbn pKeihidjnHyouji) {
        if (C_KykKbn.KEIHI_BETU.eq(pKeihidjnHyouji)) {

            return "0";
        }

        return "1";
    }
}
