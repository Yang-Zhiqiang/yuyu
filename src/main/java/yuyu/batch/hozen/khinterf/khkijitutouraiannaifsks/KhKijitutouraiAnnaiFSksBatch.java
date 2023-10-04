package yuyu.batch.hozen.khinterf.khkijitutouraiannaifsks;

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
import yuyu.batch.hozen.khinterf.khkijitutouraiannaifsks.dba.KhKijitutouraiAnnaiFSksBean;
import yuyu.batch.hozen.khinterf.khkijitutouraiannaifsks.dba.KhKijitutouraiAnnaiFSksDao;
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
import yuyu.def.db.entity.IT_KijituTouraiAnnai;
import yuyu.def.db.entity.ZT_KijituTouraiAnnaiTy;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 契約保全 インターフェイス 期日到来案内F作成
 */
public class KhKijitutouraiAnnaiFSksBatch implements Batch {

    private static final String TABLEID  = IT_KijituTouraiAnnai.TABLE_NAME;

    private static final String FILTERID  = "Kh001";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private KhKijitutouraiAnnaiFSksDao khKijitutouraiAnnaiFSksDao;

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

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(
            MessageId.IBW0003), String.valueOf(bzBatchParam.getSyoriYmd())));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(
            MessageId.IBW1018), bzBatchParam.getIbKakutyoujobcd()));

        long syoriKensuu = 0;
        String kakutyoujobCd = bzBatchParam.getIbKakutyoujobcd();
        BizDate syoriYMD = bzBatchParam.getSyoriYmd();

        try ( ExDBResults<KhKijitutouraiAnnaiFSksBean> khKijitutouraiAnnaiFSksBeanLst =
            khKijitutouraiAnnaiFSksDao.getKhKijitutouraiAnnaiFSksBean(kakutyoujobCd, syoriYMD);

            EntityInserter<ZT_KijituTouraiAnnaiTy> kijituTouraiAnnaiTyInserter = new EntityInserter<>();
            EntityInserter<BT_TuutirirekiMeisaiHokan> tuutirirekiMeisaiHokanInserter = new EntityInserter<>();) {

            for (KhKijitutouraiAnnaiFSksBean khKijitutouraiAnnaiFSksBean : khKijitutouraiAnnaiFSksBeanLst) {

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(kakutyoujobCd);
                bzRecoveryDatasikibetuBean.setIbTableid(TABLEID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(FILTERID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(khKijitutouraiAnnaiFSksBean.getKbnkey());
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(khKijitutouraiAnnaiFSksBean.getSyono());

                String renNo = String.valueOf(syoriKensuu + 1);

                C_HassouKbn hassoukbn = khKijitutouraiAnnaiFSksBean.getHassoukbn();

                String hnskaRiyuu = null;
                if (C_HassouKbn.HONSYAKAISOU.eq(hassoukbn)) {
                    hnskaRiyuu = "Z01";
                } else {
                    hnskaRiyuu = "000";
                }

                AnsyuKokTyouhyouHensyuu ansyuKokTyouhyouHensyuu = SWAKInjector.getInstance(AnsyuKokTyouhyouHensyuu.class);

                ansyuKokTyouhyouHensyuu.exec(khKijitutouraiAnnaiFSksBean.getSyono(), renNo, C_AsTyouhyoukigouKbn.AS_KIJITUTOURAIANNAI, hnskaRiyuu);

                String sclatoSyono = ansyuKokTyouhyouHensyuu.getSclatoSyono();

                String sakuseiNo = ansyuKokTyouhyouHensyuu.getSakuseino();

                ZT_KijituTouraiAnnaiTy kijituTouraiAnnaiTy = new ZT_KijituTouraiAnnaiTy();
                kijituTouraiAnnaiTy.setZtysyoruicd(khKijitutouraiAnnaiFSksBean.getSyoruiCd().getValue().toUpperCase());
                kijituTouraiAnnaiTy.setZtyhassoukbn(khKijitutouraiAnnaiFSksBean.getHassoukbn().getValue());
                kijituTouraiAnnaiTy.setZtytyouhyouymd(khKijitutouraiAnnaiFSksBean.getTyouhyouymd().toString());
                kijituTouraiAnnaiTy.setZtytyouhyouymdkj(
                    FixedDateFormatter.formatYMDZenkakuSeirekiKanji(khKijitutouraiAnnaiFSksBean.getTyouhyouymd()));
                kijituTouraiAnnaiTy.setZtysyono(khKijitutouraiAnnaiFSksBean.getSyono());
                kijituTouraiAnnaiTy.setZtyshskyno(khKijitutouraiAnnaiFSksBean.getShskyno());
                kijituTouraiAnnaiTy.setZtyshskadr1kj(khKijitutouraiAnnaiFSksBean.getShsadr1kj());
                kijituTouraiAnnaiTy.setZtyshskadr2kj(khKijitutouraiAnnaiFSksBean.getShsadr2kj());
                kijituTouraiAnnaiTy.setZtyshskadr3kj(khKijitutouraiAnnaiFSksBean.getShsadr3kj());
                kijituTouraiAnnaiTy.setZtyshsnmkj(khKijitutouraiAnnaiFSksBean.getShsnmkj());
                kijituTouraiAnnaiTy.setZtytawsosikikj(khKijitutouraiAnnaiFSksBean.getToiawasesosikinmkj());
                kijituTouraiAnnaiTy.setZtytawyno(khKijitutouraiAnnaiFSksBean.getToiawaseyno());
                kijituTouraiAnnaiTy.setZtytawadr1kj(khKijitutouraiAnnaiFSksBean.getToiawaseadr1kj());
                kijituTouraiAnnaiTy.setZtytawadr2kj(khKijitutouraiAnnaiFSksBean.getToiawaseadr2kj());
                kijituTouraiAnnaiTy.setZtytawadr3kj(khKijitutouraiAnnaiFSksBean.getToiawaseadr3kj());
                kijituTouraiAnnaiTy.setZtytawtelnov14(khKijitutouraiAnnaiFSksBean.getToiawasetelno());
                kijituTouraiAnnaiTy.setZtytawteluktkkanou1(khKijitutouraiAnnaiFSksBean.getToiawaseteluktkkanou1());
                kijituTouraiAnnaiTy.setZtytawteluktkkanou2(khKijitutouraiAnnaiFSksBean.getToiawaseteluktkkanou2());
                kijituTouraiAnnaiTy.setZtydai2tawsosikinmkj(khKijitutouraiAnnaiFSksBean.getToiawasesosikinmkj2());
                kijituTouraiAnnaiTy.setZtydai2tawtelno(khKijitutouraiAnnaiFSksBean.getToiawasetelno2());
                kijituTouraiAnnaiTy.setZtysclatosyono(sclatoSyono);
                kijituTouraiAnnaiTy.setZtysakunm15keta(sakuseiNo);
                kijituTouraiAnnaiTy.setZtytuutinm(khKijitutouraiAnnaiFSksBean.getTuutinm20keta());
                kijituTouraiAnnaiTy.setZtyhurikaeyokokumsg32keta1(khKijitutouraiAnnaiFSksBean.getHrkykkmsg32keta1());
                kijituTouraiAnnaiTy.setZtyhurikaeyokokumsg32keta2(khKijitutouraiAnnaiFSksBean.getHrkykkmsg32keta2());
                kijituTouraiAnnaiTy.setZtyhurikaeyokokumsg32keta3(khKijitutouraiAnnaiFSksBean.getHrkykkmsg32keta3());
                kijituTouraiAnnaiTy.setZtyhurikaeyokokumsg32keta4(khKijitutouraiAnnaiFSksBean.getHrkykkmsg32keta4());
                kijituTouraiAnnaiTy.setZtyhurikaeyokokumsg32keta5(khKijitutouraiAnnaiFSksBean.getHrkykkmsg32keta5());
                kijituTouraiAnnaiTy.setZtyhurikaeyokokumsg32keta6(khKijitutouraiAnnaiFSksBean.getHrkykkmsg32keta6());
                kijituTouraiAnnaiTy.setZtyhurikaeyokokumsg32keta7(khKijitutouraiAnnaiFSksBean.getHrkykkmsg32keta7());
                kijituTouraiAnnaiTy.setZtyhurikaeyokokumsg32keta8(khKijitutouraiAnnaiFSksBean.getHrkykkmsg32keta8());
                kijituTouraiAnnaiTy.setZtyhrkkeiro(khKijitutouraiAnnaiFSksBean.getHrkkeiro().getValue());
                kijituTouraiAnnaiTy.setZtysyono2(khKijitutouraiAnnaiFSksBean.getSyono());
                kijituTouraiAnnaiTy.setZtysyouhnnm(khKijitutouraiAnnaiFSksBean.getSyouhnnm());
                kijituTouraiAnnaiTy.setZtykykymdseireki(
                    FixedDateFormatter.formatYMDZenkakuSeirekiKanji(khKijitutouraiAnnaiFSksBean.getKykymd()));
                kijituTouraiAnnaiTy.setZtyhhknnmkj(khKijitutouraiAnnaiFSksBean.getHhknnmkj());
                kijituTouraiAnnaiTy.setZtykjttrnnfreearea1(khKijitutouraiAnnaiFSksBean.getKjttrnnfreearea1());
                kijituTouraiAnnaiTy.setZtykjttrnnfreearea2(khKijitutouraiAnnaiFSksBean.getKjttrnnfreearea2());
                kijituTouraiAnnaiTy.setZtykjttrnnfreearea3(khKijitutouraiAnnaiFSksBean.getKjttrnnfreearea3());
                kijituTouraiAnnaiTy.setZtykjttrnnfreearea4(khKijitutouraiAnnaiFSksBean.getKjttrnnfreearea4());
                kijituTouraiAnnaiTy.setZtykjttrnnfreearea5(khKijitutouraiAnnaiFSksBean.getKjttrnnfreearea5());
                kijituTouraiAnnaiTy.setZtykjttrnnfreearea6(khKijitutouraiAnnaiFSksBean.getKjttrnnfreearea6());
                kijituTouraiAnnaiTy.setZtykjttrnnfreearea7(khKijitutouraiAnnaiFSksBean.getKjttrnnfreearea7());
                kijituTouraiAnnaiTy.setZtytuutisakuseiymdseireki(
                    FixedDateFormatter.formatYMDZenkakuSeirekiKanji(khKijitutouraiAnnaiFSksBean.getTyouhyouymd()));
                kijituTouraiAnnaiTy.setZtykzhurikaeymdseireki(
                    FixedDateFormatter.formatYMDZenkakuSeirekiKanji(khKijitutouraiAnnaiFSksBean.getHurikaeymd()));
                kijituTouraiAnnaiTy.setZtykzinfo1(khKijitutouraiAnnaiFSksBean.getKzinfo1());
                kijituTouraiAnnaiTy.setZtykzinfo2(khKijitutouraiAnnaiFSksBean.getKzinfo2());
                kijituTouraiAnnaiTy.setZtykzinfo3(khKijitutouraiAnnaiFSksBean.getKzinfo3());
                kijituTouraiAnnaiTy.setZtykzinfo4(khKijitutouraiAnnaiFSksBean.getKzinfo4());
                kijituTouraiAnnaiTy.setZtykzinfo5(khKijitutouraiAnnaiFSksBean.getKzinfo5());
                kijituTouraiAnnaiTy.setZtykzinfo6(khKijitutouraiAnnaiFSksBean.getKzinfo6());
                kijituTouraiAnnaiTy.setZtykzinfo7(khKijitutouraiAnnaiFSksBean.getKzinfo7());
                kijituTouraiAnnaiTy.setZtykzinfo8(khKijitutouraiAnnaiFSksBean.getKzinfo8());
                kijituTouraiAnnaiTy.setZtyhknjytukikan(khKijitutouraiAnnaiFSksBean.getHknjytukikan());
                kijituTouraiAnnaiTy.setZtyhrkgk1(khKijitutouraiAnnaiFSksBean.getHrkgk1());
                kijituTouraiAnnaiTy.setZtyhrkgk2(khKijitutouraiAnnaiFSksBean.getHrkgk2());
                kijituTouraiAnnaiTy.setZtyhrkgk3(khKijitutouraiAnnaiFSksBean.getHrkgk3());
                kijituTouraiAnnaiTy.setZtyhrkgk4(khKijitutouraiAnnaiFSksBean.getHrkgk4());
                kijituTouraiAnnaiTy.setZtykjttrnnfreearea8(khKijitutouraiAnnaiFSksBean.getKjttrnnfreearea8());
                kijituTouraiAnnaiTy.setZtykjttrnnfreearea9(khKijitutouraiAnnaiFSksBean.getKjttrnnfreearea9());
                kijituTouraiAnnaiTy.setZtykjttrnnfreearea10(khKijitutouraiAnnaiFSksBean.getKjttrnnfreearea10());
                kijituTouraiAnnaiTy.setZtykjttrnnfreearea11(khKijitutouraiAnnaiFSksBean.getKjttrnnfreearea11());
                kijituTouraiAnnaiTy.setZtykjttrnnfreearea12(khKijitutouraiAnnaiFSksBean.getKjttrnnfreearea12());
                kijituTouraiAnnaiTy.setZtykjttrnnfreearea13(khKijitutouraiAnnaiFSksBean.getKjttrnnfreearea13());
                BizPropertyInitializer.initialize(kijituTouraiAnnaiTy);

                kijituTouraiAnnaiTyInserter.add(kijituTouraiAnnaiTy);

                syoriKensuu++;

                String renbanKekka = RenbanUtil.getRenbanAsString(Integer.parseInt(C_NosyuruiKbn.TUUTIRIREKIRENNO.getValue()));
                BT_TuutirirekiMeisaiHokan tuutirirekiMeisaiHokan = new BT_TuutirirekiMeisaiHokan();
                tuutirirekiMeisaiHokan.setTuutirirekirenno(renbanKekka);
                tuutirirekiMeisaiHokan.setTuutirirekino(C_TuutirirekiTaisyouKbn.SYOUKENNO.getValue() + khKijitutouraiAnnaiFSksBean.getSyono());
                tuutirirekiMeisaiHokan.setTuutisakuseiymd(syoriYMD);
                tuutirirekiMeisaiHokan.setTuutisakuseino(0);
                tuutirirekiMeisaiHokan.setTuutisyuruicd(kinou.getSyoricd() + "0001");
                tuutirirekiMeisaiHokan.setHyoujiyoutuutisakuseiymd(syoriYMD);
                BizPropertyInitializer.initialize(tuutirirekiMeisaiHokan);

                tuutirirekiMeisaiHokanInserter.add(tuutirirekiMeisaiHokan);
            }
            bzRecoveryDatasikibetuBean.initializeBlank();
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(syoriKensuu)));
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery = SWAKInjector
            .getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }
}