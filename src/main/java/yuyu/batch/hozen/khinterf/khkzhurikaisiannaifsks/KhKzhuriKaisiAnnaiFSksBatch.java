package yuyu.batch.hozen.khinterf.khkzhurikaisiannaifsks;

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
import yuyu.batch.hozen.khinterf.khkzhurikaisiannaifsks.dba.KhKzhuriKaisiAnnaiFSksBean;
import yuyu.batch.hozen.khinterf.khkzhurikaisiannaifsks.dba.KhKzhuriKaisiAnnaiFSksDao;
import yuyu.common.base.format.FixedDateFormatter;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.hozen.khcommon.AnsyuKokTyouhyouHensyuu;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_AsTyouhyoukigouKbn;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_NosyuruiKbn;
import yuyu.def.classification.C_TuutirirekiTaisyouKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BT_TuutirirekiMeisaiHokan;
import yuyu.def.db.entity.IT_KouzahuriStartAnnai;
import yuyu.def.db.entity.ZT_KouzahuriStartAnnaiTy;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 契約保全 インターフェイス 口座振替開始案内Ｆ作成
 */
public class KhKzhuriKaisiAnnaiFSksBatch implements Batch {

    private static final String TYSYTTAISYOUTABLEID = IT_KouzahuriStartAnnai.TABLE_NAME;

    private static final String RECOVERYFILTERID = "Kh001";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private KhKzhuriKaisiAnnaiFSksDao khKzhuriKaisiAnnaiFSksDao;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Inject
    private AS_Kinou kinou;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        String kakutyoujobCd = bzBatchParam.getIbKakutyoujobcd();

        BizDate syoriYmd = bzBatchParam.getSyoriYmd();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(syoriYmd)));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW1018),
            kakutyoujobCd));

        long syoriKns = 0;

        try (
            ExDBResults<KhKzhuriKaisiAnnaiFSksBean> khKzhuriKaisiAnnaiFSksBeanExDBResults =
            khKzhuriKaisiAnnaiFSksDao.getKhKzhuriKaisiAnnaiFSksBean(kakutyoujobCd, syoriYmd);
            EntityInserter<ZT_KouzahuriStartAnnaiTy> kouzahuriStartAnnaiTyInserter = new EntityInserter<>();
            EntityInserter<BT_TuutirirekiMeisaiHokan> tuutirirekiMeisaiHokanInserter = new EntityInserter<>()){

            for (KhKzhuriKaisiAnnaiFSksBean khKzhuriKaisiAnnaiFSksBean : khKzhuriKaisiAnnaiFSksBeanExDBResults) {

                String syoNo = khKzhuriKaisiAnnaiFSksBean.getSyono();
                BizDate tyouhyouYmd = khKzhuriKaisiAnnaiFSksBean.getTyouhyouymd();

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(kakutyoujobCd);
                bzRecoveryDatasikibetuBean.setIbTableid(TYSYTTAISYOUTABLEID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(RECOVERYFILTERID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(khKzhuriKaisiAnnaiFSksBean.getKbnkey());
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(khKzhuriKaisiAnnaiFSksBean.getSyono());

                String renNo = String.valueOf(syoriKns + 1);

                C_HassouKbn hassoukbn = khKzhuriKaisiAnnaiFSksBean.getHassoukbn();

                String hnskaRiyuu = null;
                if (C_HassouKbn.HONSYAKAISOU.eq(hassoukbn)) {
                    hnskaRiyuu = "Z01";
                } else {
                    hnskaRiyuu = "000";
                }

                AnsyuKokTyouhyouHensyuu ansyuKokTyouhyouHensyuu = SWAKInjector.getInstance(AnsyuKokTyouhyouHensyuu.class);

                ansyuKokTyouhyouHensyuu.exec(syoNo, renNo, C_AsTyouhyoukigouKbn.AS_KOUHURIKAISIANNAI, hnskaRiyuu);

                String sclatoSyono = ansyuKokTyouhyouHensyuu.getSclatoSyono();

                String sakuseiNo = ansyuKokTyouhyouHensyuu.getSakuseino();

                ZT_KouzahuriStartAnnaiTy kouzahuriStartAnnaiTy = new ZT_KouzahuriStartAnnaiTy();

                kouzahuriStartAnnaiTy.setZtysyoruicd(khKzhuriKaisiAnnaiFSksBean.getSyoruiCd().getValue().toUpperCase());
                kouzahuriStartAnnaiTy.setZtyhassoukbn(khKzhuriKaisiAnnaiFSksBean.getHassoukbn().getValue());
                kouzahuriStartAnnaiTy.setZtytyouhyouymd(String.valueOf(tyouhyouYmd));
                kouzahuriStartAnnaiTy.setZtytyouhyouymdkj(FixedDateFormatter.formatYMDZenkakuSeirekiKanji(tyouhyouYmd));
                kouzahuriStartAnnaiTy.setZtysyono(syoNo);
                kouzahuriStartAnnaiTy.setZtyshskyno(khKzhuriKaisiAnnaiFSksBean.getTsinyno());
                kouzahuriStartAnnaiTy.setZtyshskadr1kj(khKzhuriKaisiAnnaiFSksBean.getTsinadr1kj());
                kouzahuriStartAnnaiTy.setZtyshskadr2kj(khKzhuriKaisiAnnaiFSksBean.getTsinadr2kj());
                kouzahuriStartAnnaiTy.setZtyshskadr3kj(khKzhuriKaisiAnnaiFSksBean.getTsinadr3kj());
                kouzahuriStartAnnaiTy.setZtyshsnmkj(khKzhuriKaisiAnnaiFSksBean.getKyknmkj());
                kouzahuriStartAnnaiTy.setZtytawsosikikj(khKzhuriKaisiAnnaiFSksBean.getToiawasesosikinmkj());
                kouzahuriStartAnnaiTy.setZtytawyno(khKzhuriKaisiAnnaiFSksBean.getToiawaseyno());
                kouzahuriStartAnnaiTy.setZtytawadr1kj(khKzhuriKaisiAnnaiFSksBean.getToiawaseadr1kj());
                kouzahuriStartAnnaiTy.setZtytawadr2kj(khKzhuriKaisiAnnaiFSksBean.getToiawaseadr2kj());
                kouzahuriStartAnnaiTy.setZtytawadr3kj(khKzhuriKaisiAnnaiFSksBean.getToiawaseadr3kj());
                kouzahuriStartAnnaiTy.setZtytawtelnov14(khKzhuriKaisiAnnaiFSksBean.getToiawasetelno());
                kouzahuriStartAnnaiTy.setZtytawteluktkkanou1(khKzhuriKaisiAnnaiFSksBean.getToiawaseteluktkkanou1());
                kouzahuriStartAnnaiTy.setZtytawteluktkkanou2(khKzhuriKaisiAnnaiFSksBean.getToiawaseteluktkkanou2());
                kouzahuriStartAnnaiTy.setZtydai2tawsosikinmkj(khKzhuriKaisiAnnaiFSksBean.getToiawasesosikinmkj2());
                kouzahuriStartAnnaiTy.setZtydai2tawtelno(khKzhuriKaisiAnnaiFSksBean.getToiawasetelno2());
                kouzahuriStartAnnaiTy.setZtysclatosyono(sclatoSyono);
                kouzahuriStartAnnaiTy.setZtysakunm15keta(sakuseiNo);
                kouzahuriStartAnnaiTy.setZtytuutinm(khKzhuriKaisiAnnaiFSksBean.getTuutinm());
                kouzahuriStartAnnaiTy.setZtyaisatumongon1(khKzhuriKaisiAnnaiFSksBean.getAisatumongon1());
                kouzahuriStartAnnaiTy.setZtyaisatumongon2(khKzhuriKaisiAnnaiFSksBean.getAisatumongon2());
                kouzahuriStartAnnaiTy.setZtyaisatumongon3(khKzhuriKaisiAnnaiFSksBean.getAisatumongon3());
                kouzahuriStartAnnaiTy.setZtyaisatumongon4(khKzhuriKaisiAnnaiFSksBean.getAisatumongon4());
                kouzahuriStartAnnaiTy.setZtyaisatumongon5(khKzhuriKaisiAnnaiFSksBean.getAisatumongon5());
                kouzahuriStartAnnaiTy.setZtykzhurikaeonegai1(khKzhuriKaisiAnnaiFSksBean.getKzhurikaeonegai1());
                kouzahuriStartAnnaiTy.setZtykzhurikaeonegai2(khKzhuriKaisiAnnaiFSksBean.getKzhurikaeonegai2());
                kouzahuriStartAnnaiTy.setZtykzhurikaeonegai3(khKzhuriKaisiAnnaiFSksBean.getKzhurikaeonegai3());
                kouzahuriStartAnnaiTy.setZtykzhurikaeonegai4(khKzhuriKaisiAnnaiFSksBean.getKzhurikaeonegai4());
                kouzahuriStartAnnaiTy.setZtykzhurikaeonegai5(khKzhuriKaisiAnnaiFSksBean.getKzhurikaeonegai5());
                kouzahuriStartAnnaiTy.setZtykzhurikaeonegai6(khKzhuriKaisiAnnaiFSksBean.getKzhurikaeonegai6());
                kouzahuriStartAnnaiTy.setZtykzhurikaeonegai7(khKzhuriKaisiAnnaiFSksBean.getKzhurikaeonegai7());
                kouzahuriStartAnnaiTy.setZtykzhurikaeonegai8(khKzhuriKaisiAnnaiFSksBean.getKzhurikaeonegai8());
                kouzahuriStartAnnaiTy.setZtykzhurikaeonegai9(khKzhuriKaisiAnnaiFSksBean.getKzhurikaeonegai9());
                kouzahuriStartAnnaiTy.setZtykzhurikaeonegai10(khKzhuriKaisiAnnaiFSksBean.getKzhurikaeonegai10());
                kouzahuriStartAnnaiTy.setZtykzhurikaeonegai11(khKzhuriKaisiAnnaiFSksBean.getKzhurikaeonegai11());
                kouzahuriStartAnnaiTy.setZtykzhurikaeonegai12(khKzhuriKaisiAnnaiFSksBean.getKzhurikaeonegai12());
                kouzahuriStartAnnaiTy.setZtykzhurikaeonegai13(khKzhuriKaisiAnnaiFSksBean.getKzhurikaeonegai13());
                kouzahuriStartAnnaiTy.setZtykzhurikaeonegai14(khKzhuriKaisiAnnaiFSksBean.getKzhurikaeonegai14());
                kouzahuriStartAnnaiTy.setZtykzhurikaeonegai15(khKzhuriKaisiAnnaiFSksBean.getKzhurikaeonegai15());
                kouzahuriStartAnnaiTy.setZtytuutisakuseiymdseireki(FixedDateFormatter.formatYMDZenkakuSeirekiKanji(tyouhyouYmd));
                kouzahuriStartAnnaiTy.setZtysyono2(syoNo);
                kouzahuriStartAnnaiTy.setZtysyouhnnm(khKzhuriKaisiAnnaiFSksBean.getSyouhnnm());
                kouzahuriStartAnnaiTy.setZtykykymdseireki(FixedDateFormatter.formatYMDZenkakuSeirekiKanji(
                    khKzhuriKaisiAnnaiFSksBean.getKykymd()));
                kouzahuriStartAnnaiTy.setZtytkbriphurikaeyoteigk(khKzhuriKaisiAnnaiFSksBean.getTkbriphurikaeyoteigk());
                kouzahuriStartAnnaiTy.setZtyhhknnmkj(khKzhuriKaisiAnnaiFSksBean.getHhknnmkj());
                kouzahuriStartAnnaiTy.setZtyhurikaekzhosokumongon(khKzhuriKaisiAnnaiFSksBean.getHurikaekzhosokumongon());
                kouzahuriStartAnnaiTy.setZtyhurikaekz1(khKzhuriKaisiAnnaiFSksBean.getHurikaekz1());
                kouzahuriStartAnnaiTy.setZtyhurikaekz2(khKzhuriKaisiAnnaiFSksBean.getHurikaekz2());
                kouzahuriStartAnnaiTy.setZtyhurikaekz3(khKzhuriKaisiAnnaiFSksBean.getHurikaekz3());
                kouzahuriStartAnnaiTy.setZtyhurikaekz4(khKzhuriKaisiAnnaiFSksBean.getHurikaekz4());
                kouzahuriStartAnnaiTy.setZtyhurikaekz5(khKzhuriKaisiAnnaiFSksBean.getHurikaekz5());
                kouzahuriStartAnnaiTy.setZtykzhuristartanfreearea1(khKzhuriKaisiAnnaiFSksBean.getKzhuristartanfreearea1());
                kouzahuriStartAnnaiTy.setZtykzhuristartanfreearea2(khKzhuriKaisiAnnaiFSksBean.getKzhuristartanfreearea2());
                kouzahuriStartAnnaiTy.setZtykzhuristartanfreearea3(khKzhuriKaisiAnnaiFSksBean.getKzhuristartanfreearea3());
                kouzahuriStartAnnaiTy.setZtykzhuristartanfreearea4(khKzhuriKaisiAnnaiFSksBean.getKzhuristartanfreearea4());
                kouzahuriStartAnnaiTy.setZtykzhuristartanfreearea5(khKzhuriKaisiAnnaiFSksBean.getKzhuristartanfreearea5());
                kouzahuriStartAnnaiTy.setZtykzhuristartanfreearea6(khKzhuriKaisiAnnaiFSksBean.getKzhuristartanfreearea6());
                kouzahuriStartAnnaiTy.setZtykzhuristartanfreearea7(khKzhuriKaisiAnnaiFSksBean.getKzhuristartanfreearea7());
                kouzahuriStartAnnaiTy.setZtykzhuristartanfreearea8(khKzhuriKaisiAnnaiFSksBean.getKzhuristartanfreearea8());
                kouzahuriStartAnnaiTy.setZtykzhuristartanfreearea9(khKzhuriKaisiAnnaiFSksBean.getKzhuristartanfreearea9());
                kouzahuriStartAnnaiTy.setZtykzhuristartanfreearea10(khKzhuriKaisiAnnaiFSksBean.getKzhuristartanfreearea10());

                BizPropertyInitializer.initialize(kouzahuriStartAnnaiTy);

                kouzahuriStartAnnaiTyInserter.add(kouzahuriStartAnnaiTy);

                syoriKns++;

                String renbanKekka = RenbanUtil.getRenbanAsString(Integer.parseInt(C_NosyuruiKbn.TUUTIRIREKIRENNO.getValue()));
                BT_TuutirirekiMeisaiHokan tuutirirekiMeisaiHokan = new BT_TuutirirekiMeisaiHokan();
                tuutirirekiMeisaiHokan.setTuutirirekirenno(renbanKekka);
                tuutirirekiMeisaiHokan.setTuutirirekino(C_TuutirirekiTaisyouKbn.SYOUKENNO.getValue() + syoNo);
                tuutirirekiMeisaiHokan.setTuutisakuseiymd(syoriYmd);
                tuutirirekiMeisaiHokan.setTuutisakuseino(0);
                tuutirirekiMeisaiHokan.setTuutisyuruicd(kinou.getSyoricd() + "0001");
                tuutirirekiMeisaiHokan.setHyoujiyoutuutisakuseiymd(syoriYmd);
                BizPropertyInitializer.initialize(tuutirirekiMeisaiHokan);

                tuutirirekiMeisaiHokanInserter.add(tuutirirekiMeisaiHokan);
            }

            bzRecoveryDatasikibetuBean.initializeBlank();
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(syoriKns)));
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery = SWAKInjector
            .getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }
}
