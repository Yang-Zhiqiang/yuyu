package yuyu.batch.hozen.khinterf.khminyuutuutifilesks;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.sequence.RenbanUtil;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.hozen.khinterf.khminyuutuutifilesks.dba.KhMinyuuTuutiBean;
import yuyu.batch.hozen.khinterf.khminyuutuutifilesks.dba.KhMinyuuTuutiFileSksDao;
import yuyu.common.base.format.FixedDateFormatter;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.hozen.khcommon.AnsyuKokTyouhyouHensyuu;
import yuyu.common.hozen.khcommon.IKhozenCommonConstants;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_AsTyouhyoukigouKbn;
import yuyu.def.classification.C_NosyuruiKbn;
import yuyu.def.classification.C_TuutirirekiTaisyouKbn;
import yuyu.def.db.entity.BT_TuutirirekiMeisaiHokan;
import yuyu.def.db.entity.IT_KouzahuriMinyuTuuti;
import yuyu.def.db.entity.ZT_KouzahuriMinyuTuutiTy;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 契約保全 インターフェイス 未入通知Ｆ作成
 */
public class KhMinyuuTuutiFileSksBatch implements Batch {

    private static final String TABLEID = IT_KouzahuriMinyuTuuti.TABLE_NAME;

    private static final String FILTERID = "Kh001";

    @Inject
    private BatchLogger batchLogger;
    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private KhMinyuuTuutiFileSksDao khMinyuuTuutiFileSksDao;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        String kakutyoujobCd = bzBatchParam.getIbKakutyoujobcd();
        BizDate tyouhyouYmd = bzBatchParam.getSyoriYmd();
        long syoriKensuu = 0;
        long syoriKensuuMiiri = 0;
        long syoriKensuuSaikoku = 0;

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(
            MessageId.IBW0003), String.valueOf(tyouhyouYmd)));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(
            MessageId.IBW1018), kakutyoujobCd));

        try (ExDBResults<KhMinyuuTuutiBean> khMinyuTuutiBeanLst =
            khMinyuuTuutiFileSksDao.getMinyuuTuutiBeans(kakutyoujobCd, tyouhyouYmd);

            EntityInserter<ZT_KouzahuriMinyuTuutiTy> inserter = new EntityInserter<>();
            EntityInserter<BT_TuutirirekiMeisaiHokan> tuutirirekiMeisaiHokaninserter = new EntityInserter<>();) {

            for (KhMinyuuTuutiBean khMinyuTuutiBean : khMinyuTuutiBeanLst) {

                String syoNo = khMinyuTuutiBean.getSyono();
                BizDate tyouhyouYmd2 = khMinyuTuutiBean.getTyouhyouymd();

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(kakutyoujobCd);
                bzRecoveryDatasikibetuBean.setIbTableid(TABLEID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(FILTERID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(khMinyuTuutiBean.getKbnkey());
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(syoNo);

                String tuutiSakuseiKinouId = "";

                C_AsTyouhyoukigouKbn tyouhyouKbn = khMinyuTuutiBean.getTyouhyoukigoukbn();

                if (C_AsTyouhyoukigouKbn.AS_KOUHURIMINYUUTUUTI.eq(tyouhyouKbn)) {

                    tuutiSakuseiKinouId = IKhozenCommonConstants.KINOUID_MINYUUTUUTIFILESKS;
                }
                else if (C_AsTyouhyoukigouKbn.AS_SAIKOKUTUUTI.eq(tyouhyouKbn)) {

                    tuutiSakuseiKinouId = IKhozenCommonConstants.KINOUID_KHSAIKOKUTUUTISKS;
                }

                String syoriCd = khMinyuuTuutiFileSksDao.getSyoricd(tuutiSakuseiKinouId);

                syoriKensuu = syoriKensuu + 1;

                if (C_AsTyouhyoukigouKbn.AS_KOUHURIMINYUUTUUTI.eq(tyouhyouKbn)) {

                    syoriKensuuMiiri = syoriKensuuMiiri + 1;
                }
                else if (C_AsTyouhyoukigouKbn.AS_SAIKOKUTUUTI.eq(tyouhyouKbn)) {

                    syoriKensuuSaikoku = syoriKensuuSaikoku + 1;
                }

                String hnskaRiyuu = "000";

                if (!BizUtil.isBlank(khMinyuTuutiBean.getTuutisyuruicd())) {

                    hnskaRiyuu = khMinyuTuutiBean.getTuutisyuruicd();
                }

                String renNo = "";

                AnsyuKokTyouhyouHensyuu ansyuKokTyouhyouHensyuu = SWAKInjector.getInstance(AnsyuKokTyouhyouHensyuu.class);

                if (C_AsTyouhyoukigouKbn.AS_KOUHURIMINYUUTUUTI.eq(tyouhyouKbn)) {

                    renNo = String.valueOf(syoriKensuuMiiri);
                }

                else if (C_AsTyouhyoukigouKbn.AS_SAIKOKUTUUTI.eq(tyouhyouKbn)) {

                    renNo = String.valueOf(syoriKensuuSaikoku);
                }
                ansyuKokTyouhyouHensyuu.exec(syoNo, renNo, tyouhyouKbn, hnskaRiyuu);

                String sakuseiNo = ansyuKokTyouhyouHensyuu.getSakuseino();

                String sclatoSyono = ansyuKokTyouhyouHensyuu.getSclatoSyono();

                ZT_KouzahuriMinyuTuutiTy kouzahuriMinyuTuutiTy = new ZT_KouzahuriMinyuTuutiTy();

                kouzahuriMinyuTuutiTy.setZtysyoruicd(khMinyuTuutiBean.getSyoruiCd().toString().toUpperCase());
                kouzahuriMinyuTuutiTy.setZtyhassoukbn(khMinyuTuutiBean.getHassoukbn().toString());
                kouzahuriMinyuTuutiTy.setZtytyouhyouymd(tyouhyouYmd2.toString());
                kouzahuriMinyuTuutiTy.setZtytyouhyouymdkj(FixedDateFormatter.formatYMDZenkakuSeirekiKanji(
                    tyouhyouYmd2));
                kouzahuriMinyuTuutiTy.setZtysyono(syoNo);
                kouzahuriMinyuTuutiTy.setZtyshskyno(khMinyuTuutiBean.getShskyno());
                kouzahuriMinyuTuutiTy.setZtyshskadr1kj(khMinyuTuutiBean.getShsadr1kj());
                kouzahuriMinyuTuutiTy.setZtyshskadr2kj(khMinyuTuutiBean.getShsadr2kj());
                kouzahuriMinyuTuutiTy.setZtyshskadr3kj(khMinyuTuutiBean.getShsadr3kj());
                kouzahuriMinyuTuutiTy.setZtyshsnmkj(khMinyuTuutiBean.getShsnmkj());
                kouzahuriMinyuTuutiTy.setZtytawsosikikj(khMinyuTuutiBean.getToiawasesosikinmkj());
                kouzahuriMinyuTuutiTy.setZtytawyno(khMinyuTuutiBean.getToiawaseyno());
                kouzahuriMinyuTuutiTy.setZtytawadr1kj(khMinyuTuutiBean.getToiawaseadr1kj());
                kouzahuriMinyuTuutiTy.setZtytawadr2kj(khMinyuTuutiBean.getToiawaseadr2kj());
                kouzahuriMinyuTuutiTy.setZtytawadr3kj(khMinyuTuutiBean.getToiawaseadr3kj());
                kouzahuriMinyuTuutiTy.setZtytawtelnov14(khMinyuTuutiBean.getToiawasetelno());
                kouzahuriMinyuTuutiTy.setZtytawteluktkkanou1(khMinyuTuutiBean.getToiawaseteluktkkanou1());
                kouzahuriMinyuTuutiTy.setZtytawteluktkkanou2(khMinyuTuutiBean.getToiawaseteluktkkanou2());
                kouzahuriMinyuTuutiTy.setZtydai2tawsosikinmkj(khMinyuTuutiBean.getToiawasesosikinmkj2());
                kouzahuriMinyuTuutiTy.setZtydai2tawtelno(khMinyuTuutiBean.getToiawasetelno2());
                kouzahuriMinyuTuutiTy.setZtysclatosyono(sclatoSyono);
                kouzahuriMinyuTuutiTy.setZtysakunm15keta(sakuseiNo);
                kouzahuriMinyuTuutiTy.setZtytuutinm30keta(khMinyuTuutiBean.getTuutinm30keta());
                kouzahuriMinyuTuutiTy.setZtyminyuttmsg1(khMinyuTuutiBean.getMinyuttmsg1());
                kouzahuriMinyuTuutiTy.setZtyminyuttmsg2(khMinyuTuutiBean.getMinyuttmsg2());
                kouzahuriMinyuTuutiTy.setZtyminyuttmsg3(khMinyuTuutiBean.getMinyuttmsg3());
                kouzahuriMinyuTuutiTy.setZtyminyuttmsg4(khMinyuTuutiBean.getMinyuttmsg4());
                kouzahuriMinyuTuutiTy.setZtyminyuttmsg5(khMinyuTuutiBean.getMinyuttmsg5());
                kouzahuriMinyuTuutiTy.setZtyminyuttmsg6(khMinyuTuutiBean.getMinyuttmsg6());
                kouzahuriMinyuTuutiTy.setZtyminyuttmsg7(khMinyuTuutiBean.getMinyuttmsg7());
                kouzahuriMinyuTuutiTy.setZtyminyuttmsg8(khMinyuTuutiBean.getMinyuttmsg8());
                kouzahuriMinyuTuutiTy.setZtyminyuttmsg9(khMinyuTuutiBean.getMinyuttmsg9());
                kouzahuriMinyuTuutiTy.setZtyminyuttmsg10(khMinyuTuutiBean.getMinyuttmsg10());
                kouzahuriMinyuTuutiTy.setZtyminyuttmsg11(khMinyuTuutiBean.getMinyuttmsg11());
                kouzahuriMinyuTuutiTy.setZtyminyuttmsg12(khMinyuTuutiBean.getMinyuttmsg12());
                kouzahuriMinyuTuutiTy.setZtypannainm(khMinyuTuutiBean.getPannainm());
                kouzahuriMinyuTuutiTy.setZtyhrkhou12keta(khMinyuTuutiBean.getHrkhou12keta());
                kouzahuriMinyuTuutiTy.setZtysyono2(syoNo);
                kouzahuriMinyuTuutiTy.setZtyhhknnmkj(khMinyuTuutiBean.getHhknnmkj());
                kouzahuriMinyuTuutiTy.setZtynextkzhrnaiyou1(khMinyuTuutiBean.getNexthurikaenaiyou1());
                kouzahuriMinyuTuutiTy.setZtynextkzhrnaiyou2(khMinyuTuutiBean.getNexthurikaenaiyou2());
                kouzahuriMinyuTuutiTy.setZtynextkzhrnaiyou3(khMinyuTuutiBean.getNexthurikaenaiyou3());
                kouzahuriMinyuTuutiTy.setZtysaikokuyykk1(khMinyuTuutiBean.getSaikokutukiyykkn1());
                kouzahuriMinyuTuutiTy.setZtysaikokuyykk2(khMinyuTuutiBean.getSaikokutukiyykkn2());
                kouzahuriMinyuTuutiTy.setZtyhrkmiraimsg1(khMinyuTuutiBean.getHrkmirmsg1());
                kouzahuriMinyuTuutiTy.setZtyhrkmiraimsg2(khMinyuTuutiBean.getHrkmirmsg2());
                kouzahuriMinyuTuutiTy.setZtyhrkmiraimsg3(khMinyuTuutiBean.getHrkmirmsg3());
                kouzahuriMinyuTuutiTy.setZtyzenhurinaiyou1(khMinyuTuutiBean.getZenhurikaenaiyou1());
                kouzahuriMinyuTuutiTy.setZtyzenhurinaiyou2(khMinyuTuutiBean.getZenhurikaenaiyou2());
                kouzahuriMinyuTuutiTy.setZtyzenhurinaiyou3(khMinyuTuutiBean.getZenhurikaenaiyou3());
                kouzahuriMinyuTuutiTy.setZtyzenhurinaiyou4(khMinyuTuutiBean.getZenhurikaenaiyou4());
                kouzahuriMinyuTuutiTy.setZtyhurikaekz37keta1(khMinyuTuutiBean.getHurikaekz37keta1());
                kouzahuriMinyuTuutiTy.setZtyhurikaekz37keta2(khMinyuTuutiBean.getHurikaekz37keta2());
                kouzahuriMinyuTuutiTy.setZtyhurikaekz37keta3(khMinyuTuutiBean.getHurikaekz37keta3());
                kouzahuriMinyuTuutiTy.setZtyhurikaekz37keta4(khMinyuTuutiBean.getHurikaekz37keta4());
                kouzahuriMinyuTuutiTy.setZtyhurikaekz37keta5(khMinyuTuutiBean.getHurikaekz37keta5());
                kouzahuriMinyuTuutiTy.setZtyhurikaekz37keta6(khMinyuTuutiBean.getHurikaekz37keta6());
                kouzahuriMinyuTuutiTy.setZtyminyuttaddmsg1(khMinyuTuutiBean.getMinyuttaddmsg1());
                kouzahuriMinyuTuutiTy.setZtyminyuttaddmsg2(khMinyuTuutiBean.getMinyuttaddmsg2());
                kouzahuriMinyuTuutiTy.setZtyminyuttaddmsg3(khMinyuTuutiBean.getMinyuttaddmsg3());
                kouzahuriMinyuTuutiTy.setZtyminyuttaddmsg4(khMinyuTuutiBean.getMinyuttaddmsg4());
                kouzahuriMinyuTuutiTy.setZtyminyuttaddmsg5(khMinyuTuutiBean.getMinyuttaddmsg5());
                kouzahuriMinyuTuutiTy.setZtyminyuttaddmsg6(khMinyuTuutiBean.getMinyuttaddmsg6());
                kouzahuriMinyuTuutiTy.setZtyminyuttaddmsg7(khMinyuTuutiBean.getMinyuttaddmsg7());
                kouzahuriMinyuTuutiTy.setZtyminyuttaddmsg8(khMinyuTuutiBean.getMinyuttaddmsg8());
                kouzahuriMinyuTuutiTy.setZtyminyuttaddmsg9(khMinyuTuutiBean.getMinyuttaddmsg9());
                kouzahuriMinyuTuutiTy.setZtyminyuttaddmsg10(khMinyuTuutiBean.getMinyuttaddmsg10());
                kouzahuriMinyuTuutiTy.setZtyminyuttaddmsg11(khMinyuTuutiBean.getMinyuttaddmsg11());
                kouzahuriMinyuTuutiTy.setZtyminyuttaddmsg12(khMinyuTuutiBean.getMinyuttaddmsg12());
                kouzahuriMinyuTuutiTy.setZtyminyuttaddmsg13(khMinyuTuutiBean.getMinyuttaddmsg13());
                kouzahuriMinyuTuutiTy.setZtyminyuttaddmsg14(khMinyuTuutiBean.getMinyuttaddmsg14());
                kouzahuriMinyuTuutiTy.setZtyminyuttaddmsg15(khMinyuTuutiBean.getMinyuttaddmsg15());
                kouzahuriMinyuTuutiTy.setZtyminyuttaddmsg16(khMinyuTuutiBean.getMinyuttaddmsg16());
                kouzahuriMinyuTuutiTy.setZtyminyuttaddmsg17(khMinyuTuutiBean.getMinyuttaddmsg17());
                kouzahuriMinyuTuutiTy.setZtyminyuttaddmsg18(khMinyuTuutiBean.getMinyuttaddmsg18());
                kouzahuriMinyuTuutiTy.setZtyminyuttaddmsg19(khMinyuTuutiBean.getMinyuttaddmsg19());
                kouzahuriMinyuTuutiTy.setZtyminyuttaddmsg20(khMinyuTuutiBean.getMinyuttaddmsg20());
                kouzahuriMinyuTuutiTy.setZtyminyuttaddmsg21(khMinyuTuutiBean.getMinyuttaddmsg21());

                BizPropertyInitializer.initialize(kouzahuriMinyuTuutiTy);
                inserter.add(kouzahuriMinyuTuutiTy);

                String numKekka = RenbanUtil.getRenbanAsString(Integer.valueOf(C_NosyuruiKbn.TUUTIRIREKIRENNO.getValue()));

                BT_TuutirirekiMeisaiHokan tuutirirekiMeisaiHokan = new BT_TuutirirekiMeisaiHokan();
                tuutirirekiMeisaiHokan.setTuutirirekirenno(numKekka);
                tuutirirekiMeisaiHokan.setTuutirirekino(C_TuutirirekiTaisyouKbn.SYOUKENNO.getValue()
                    + khMinyuTuutiBean.getSyono());
                tuutirirekiMeisaiHokan.setTuutisakuseiymd(tyouhyouYmd);
                tuutirirekiMeisaiHokan.setTuutisakuseino(0);
                tuutirirekiMeisaiHokan.setTuutisyuruicd(syoriCd + "0001");
                tuutirirekiMeisaiHokan.setHyoujiyoutuutisakuseiymd(tyouhyouYmd);

                BizPropertyInitializer.initialize(tuutirirekiMeisaiHokan);
                tuutirirekiMeisaiHokaninserter.add(tuutirirekiMeisaiHokan);
            }

            bzRecoveryDatasikibetuBean.initializeBlank();
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(syoriKensuuMiiri), "未入通知"));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(syoriKensuuSaikoku), "催告通知"));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(syoriKensuu), "合計"));
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery = SWAKInjector
            .getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }
}