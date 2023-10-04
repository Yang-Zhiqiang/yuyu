package yuyu.batch.hozen.khinterf.khdirectmaildatasel;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.hozen.khinterf.khdirectmaildatasel.dba.KhDirectMailDataSelDao;
import yuyu.batch.hozen.khinterf.khdirectmaildatasel.dba.KhYuukouTaisyouKykInfoBean;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzdairiten.BzGetAgInfo;
import yuyu.common.biz.bzdairiten.BzGetAgInfoBean;
import yuyu.common.hozen.khcommon.CheckYuukouJyoutai;
import yuyu.common.hozen.khcommon.CheckYuukouJyoutaiParam;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_KktyuitaKbn;
import yuyu.def.classification.C_Tdk;
import yuyu.def.classification.C_TtdktyuuiKbn;
import yuyu.def.classification.C_YuukoujyotaichkKbn;
import yuyu.def.db.entity.IT_KykDairiten;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.ZT_DirectMailDataTy;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 契約保全 インターフェース ダイレクトメールデータ抽出
 */
public class KhDirectMailDataSelBatch implements Batch{

    private static final String TYSYTTAISYOU_TABLE_ID = IT_KykKihon.TABLE_NAME;

    private static final String RECOVERY_FILTER_KBNID = "Kh001";

    private static final long SYUTURYOKUTANNI = 10000;

    private static final String SUHHNUKBN_JUUSYOHUMEI = "1";

    private static final String SUHHNUKBN_JUUSYOHUBI = "2";

    private static final String SUHHNUKBN_ANNAIREIGAI = "4";

    private static final String SUHHNUKBN_SYAINNMHUMEI = "5";

    private static final String HANKAKU_ZERO = "0";

    private static final String TOUROKUTBLNM = "ダイレクトメールデータテーブル（中）";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private KhDirectMailDataSelDao khDirectMailDataSelDao;

    @Inject
    private KhozenCommonParam khozenCommonParam;

    @Inject
    private CheckYuukouJyoutai checkYuukouJyoutai;

    @Inject
    private CheckYuukouJyoutaiParam checkYuukouJyoutaiParam;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Inject
    private HozenDomManager hozenDomManager;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        String ibKakutyoujobCd = bzBatchParam.getIbKakutyoujobcd();

        BizDate syoriYmd = bzBatchParam.getSyoriYmd();

        long syoriKensu = 0;

        long syoriKensuDirectMailDataTy = 0;

        BzGetAgInfo bzGetAgInfo = null;

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016,
            MessageUtil.getMessage(MessageId.IBW0003), String.valueOf(syoriYmd)));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016,
            MessageUtil.getMessage(MessageId.IBW1018), ibKakutyoujobCd));

        long syoriTaisyouKensu = khDirectMailDataSelDao.getYuukouTaisyouKykInfoCount(syoriYmd);

        String syono = "";

        try (
            ExDBResults<KhYuukouTaisyouKykInfoBean> exDBResults = khDirectMailDataSelDao.
            getYuukouTaisyouKykInfoBeans(ibKakutyoujobCd, syoriYmd);
            EntityInserter<ZT_DirectMailDataTy> entityInserter = new EntityInserter<>()) {

            for (KhYuukouTaisyouKykInfoBean khYuukouTaisyouKykInfoBean : exDBResults) {

                syoriKensu = syoriKensu + 1;

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(ibKakutyoujobCd);
                bzRecoveryDatasikibetuBean.setIbTableid(TYSYTTAISYOU_TABLE_ID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(RECOVERY_FILTER_KBNID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(khYuukouTaisyouKykInfoBean.getKbnkey());
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(khYuukouTaisyouKykInfoBean.getSyono());

                syono = khYuukouTaisyouKykInfoBean.getSyono();

                checkYuukouJyoutaiParam.setSyono(syono);

                if (C_YuukoujyotaichkKbn.HUKA.eq(checkYuukouJyoutai.exec(khozenCommonParam, checkYuukouJyoutaiParam))) {

                    checkYuukouJyoutai.detachAllEntities(syono);

                    continue;
                }

                String souhuhunoukbn = HANKAKU_ZERO;

                if (C_TtdktyuuiKbn.ADRHUMEI.eq(khYuukouTaisyouKykInfoBean.getTtdktyuuikbn1())
                    || C_TtdktyuuiKbn.ADRHUMEI.eq(khYuukouTaisyouKykInfoBean.getTtdktyuuikbn2())
                    || C_TtdktyuuiKbn.ADRHUMEI.eq(khYuukouTaisyouKykInfoBean.getTtdktyuuikbn3())
                    || C_TtdktyuuiKbn.ADRHUMEI.eq(khYuukouTaisyouKykInfoBean.getTtdktyuuikbn4())
                    || C_TtdktyuuiKbn.ADRHUMEI.eq(khYuukouTaisyouKykInfoBean.getTtdktyuuikbn5())) {

                    souhuhunoukbn = SUHHNUKBN_JUUSYOHUMEI;
                }
                else if (BizUtil.isBlank(khYuukouTaisyouKykInfoBean.getTsinadr1kj())) {
                    souhuhunoukbn = SUHHNUKBN_JUUSYOHUBI;
                }
                else if (C_KktyuitaKbn.DNGNMEMOARI.equals(khYuukouTaisyouKykInfoBean.getKktyuitakbn())) {
                    souhuhunoukbn = SUHHNUKBN_ANNAIREIGAI;
                }
                else if (BizUtil.isBlank(khYuukouTaisyouKykInfoBean.getKyknmkj())) {
                    souhuhunoukbn = SUHHNUKBN_SYAINNMHUMEI;
                }

                String trkKzkUmu = HANKAKU_ZERO;

                long trkKzkInfoCount = khDirectMailDataSelDao.getTrkKzkInfoCount(syono);

                if (trkKzkInfoCount > 0) {

                    trkKzkUmu = "1";
                }

                String oyadrtenCdA = "";

                String oyadrtenCdB = "";

                IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syono);

                List<IT_KykDairiten> kykDairitenLst = kykKihon.getKykDairitens();

                if (kykDairitenLst.size() > 0) {

                    bzGetAgInfo = SWAKInjector.getInstance(BzGetAgInfo.class);
                    BzGetAgInfoBean bzGetAgInfoBean = null;

                    List<BzGetAgInfoBean> bzGetAgInfoBeanList = bzGetAgInfo.exec(
                        kykDairitenLst.get(0).getDrtencd());

                    if (bzGetAgInfoBeanList.size() > 0) {

                        bzGetAgInfoBean = bzGetAgInfoBeanList.get(3);

                        oyadrtenCdA = bzGetAgInfoBean.getDrtenCd();
                    }

                    if (kykDairitenLst.size() > 1) {

                        bzGetAgInfoBeanList = bzGetAgInfo.exec(kykDairitenLst.get(1).getDrtencd());

                        if (bzGetAgInfoBeanList.size() > 0) {

                            bzGetAgInfoBean = bzGetAgInfoBeanList.get(3);

                            oyadrtenCdB = bzGetAgInfoBean.getDrtenCd();
                        }
                    }
                }

                ZT_DirectMailDataTy directMailDataTy = new ZT_DirectMailDataTy();

                directMailDataTy.setZtyhokenkbnnys("1");

                if (C_Tdk.HONNIN.eq(khYuukouTaisyouKykInfoBean.getKkkyktdk())) {

                    directMailDataTy.setZtysakuinmeinonys(khYuukouTaisyouKykInfoBean.getHhknsakuinmeino());
                }
                else {
                    directMailDataTy.setZtysakuinmeinonys(khYuukouTaisyouKykInfoBean.getKyksakuinmeino());
                }

                directMailDataTy.setZtysyainnm(khYuukouTaisyouKykInfoBean.getKyknmkn());
                directMailDataTy.setZtykanjisyainnm(khYuukouTaisyouKykInfoBean.getKyknmkj());
                directMailDataTy.setZtysyainseiymd(String.valueOf(khYuukouTaisyouKykInfoBean.getKykseiymd()));
                directMailDataTy.setZtytsinkihontikucd(khYuukouTaisyouKykInfoBean.getTsinyno());
                directMailDataTy.setZtykanjitsinkaiadr(khYuukouTaisyouKykInfoBean.getTsinadr1kj()
                    + khYuukouTaisyouKykInfoBean.getTsinadr2kj() + khYuukouTaisyouKykInfoBean.getTsinadr3kj());
                directMailDataTy.setZtysyono(khYuukouTaisyouKykInfoBean.getSyono());
                directMailDataTy.setZtysouhuhunoukbn(souhuhunoukbn);
                if (SUHHNUKBN_JUUSYOHUBI.equals(souhuhunoukbn)
                    || SUHHNUKBN_ANNAIREIGAI.equals(souhuhunoukbn)
                    || SUHHNUKBN_SYAINNMHUMEI.equals(souhuhunoukbn)) {

                    directMailDataTy.setZtynaimitureigaihyj("1");
                }
                else {
                    directMailDataTy.setZtynaimitureigaihyj(HANKAKU_ZERO);
                }
                directMailDataTy.setZtydrtenhyj("1");
                directMailDataTy.setZtybsyym(String.valueOf(khYuukouTaisyouKykInfoBean.getBosyuuym()));
                directMailDataTy.setZtyhknnm(khYuukouTaisyouKykInfoBean.getAisyoumeikbn().getContent());
                if (C_HknkknsmnKbn.SAIMANKI.eq(khYuukouTaisyouKykInfoBean.getHknkknsmnkbn())) {

                    directMailDataTy.setZtynenhousiki("1");
                }
                else if (C_HknkknsmnKbn.NENMANKI.eq(khYuukouTaisyouKykInfoBean.getHknkknsmnkbn())) {

                    directMailDataTy.setZtynenhousiki("2");
                }
                else {
                    directMailDataTy.setZtynenhousiki(HANKAKU_ZERO);
                }

                directMailDataTy.setZtykzktrkarihyj(trkKzkUmu);
                directMailDataTy.setZtyaatkioybsydrtencd(oyadrtenCdA);
                directMailDataTy.setZtybatkioybsydrtencd(oyadrtenCdB);

                BizPropertyInitializer.initialize(directMailDataTy);

                entityInserter.add(directMailDataTy);

                syoriKensuDirectMailDataTy = syoriKensuDirectMailDataTy + 1;

                if (syoriKensu % SYUTURYOKUTANNI == 0) {

                    batchLogger.info(MessageUtil.getMessage(MessageId.IIA1001, String.valueOf(syoriKensu),
                        String.valueOf((syoriTaisyouKensu))));
                }

                checkYuukouJyoutai.detachAllEntities(khYuukouTaisyouKykInfoBean.getSyono());
            }

            bzRecoveryDatasikibetuBean.initializeBlank();

            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(syoriKensuDirectMailDataTy), TOUROKUTBLNM));
        }
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);
        bzBatchAbendCommonRecovery.exec();
    }
}
