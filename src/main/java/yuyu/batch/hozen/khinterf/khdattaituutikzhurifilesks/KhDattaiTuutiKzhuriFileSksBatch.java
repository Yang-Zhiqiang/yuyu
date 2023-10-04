package yuyu.batch.hozen.khinterf.khdattaituutikzhurifilesks;

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
import yuyu.batch.hozen.khinterf.khdattaituutikzhurifilesks.dba.KhDattaiTuutiKzhuriBean;
import yuyu.batch.hozen.khinterf.khdattaituutikzhurifilesks.dba.KhDattaiTuutiKzhuriFileSksDao;
import yuyu.common.base.format.FixedDateFormatter;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_NosyuruiKbn;
import yuyu.def.classification.C_TuutirirekiTaisyouKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BT_TuutirirekiMeisaiHokan;
import yuyu.def.db.entity.IT_DattaiTuutiKzhuri;
import yuyu.def.db.entity.ZT_DattaiTuutiKzhuriTy;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 契約保全 インターフェイス 脱退通知（口座振替）Ｆ作成
 */
public class KhDattaiTuutiKzhuriFileSksBatch implements Batch {

    private static final String TABLEID = IT_DattaiTuutiKzhuri.TABLE_NAME;

    private static final String FILTERID = "Kh001";

    private static final String TUUTISYURUICD_SIMO4KETA = "0001";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private KhDattaiTuutiKzhuriFileSksDao khDattaiTuutiKzhuriFileSksDao;

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

        BizDate syoriYMD = bzBatchParam.getSyoriYmd();
        String ibKakutyoujobCd = bzBatchParam.getIbKakutyoujobcd();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(
            MessageId.IBW0003), String.valueOf(syoriYMD)));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(
            MessageId.IBW1018), ibKakutyoujobCd));

        long syoriKensuu = 0;

        try (ExDBResults<KhDattaiTuutiKzhuriBean> khDattaiTuutiKzhuriBeanLst =
            khDattaiTuutiKzhuriFileSksDao.getDattaiTuutiKzhuriBeans(ibKakutyoujobCd, syoriYMD);

            EntityInserter<ZT_DattaiTuutiKzhuriTy> entityInserter = new EntityInserter<>();
            EntityInserter<BT_TuutirirekiMeisaiHokan> entityInserterTuuti = new EntityInserter<>();) {

            for (KhDattaiTuutiKzhuriBean khDattaiTuutiKzhuriBean : khDattaiTuutiKzhuriBeanLst) {

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(ibKakutyoujobCd);
                bzRecoveryDatasikibetuBean.setIbTableid(TABLEID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(FILTERID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(khDattaiTuutiKzhuriBean.getKbnkey());
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(khDattaiTuutiKzhuriBean.getSyono());

                syoriKensuu++;

                String sclatoSyono = khDattaiTuutiKzhuriBean.getSyono().substring(3, 11)
                    + khDattaiTuutiKzhuriBean.getSyono().substring(0, 3);

                String sakuseiNo = BizUtil.zeroNum(String.valueOf(syoriKensuu), 7, 0);

                ZT_DattaiTuutiKzhuriTy dattaiTuutiKzhuriTy = new ZT_DattaiTuutiKzhuriTy();

                dattaiTuutiKzhuriTy.setZtysyoruicd(khDattaiTuutiKzhuriBean.getSyoruiCd().getValue().toUpperCase());
                dattaiTuutiKzhuriTy.setZtyhassoukbn(khDattaiTuutiKzhuriBean.getHassouKbn().getValue());
                dattaiTuutiKzhuriTy.setZtytyouhyouymd(String.valueOf(khDattaiTuutiKzhuriBean.getTyouhyouYmd()));
                dattaiTuutiKzhuriTy.setZtytyouhyouymdkj(FixedDateFormatter
                    .formatYMDZenkakuSeirekiKanji(khDattaiTuutiKzhuriBean.getTyouhyouYmd()));
                dattaiTuutiKzhuriTy.setZtysyono(khDattaiTuutiKzhuriBean.getSyono());
                dattaiTuutiKzhuriTy.setZtyshskyno(khDattaiTuutiKzhuriBean.getShsKyNo());
                dattaiTuutiKzhuriTy.setZtyshskadr1kj(khDattaiTuutiKzhuriBean.getShsAdr1Kj());
                dattaiTuutiKzhuriTy.setZtyshskadr2kj(khDattaiTuutiKzhuriBean.getShsAdr2Kj());
                dattaiTuutiKzhuriTy.setZtyshskadr3kj(khDattaiTuutiKzhuriBean.getShsAdr3Kj());
                dattaiTuutiKzhuriTy.setZtyshsnmkj(khDattaiTuutiKzhuriBean.getShsNmKj());
                dattaiTuutiKzhuriTy.setZtytawsosikikj(khDattaiTuutiKzhuriBean.getToiawaseSosikiNmKj());
                dattaiTuutiKzhuriTy.setZtytawyno(khDattaiTuutiKzhuriBean.getToiawaseYno());
                dattaiTuutiKzhuriTy.setZtytawadr1kj(khDattaiTuutiKzhuriBean.getToiawaseAdr1Kj());
                dattaiTuutiKzhuriTy.setZtytawadr2kj(khDattaiTuutiKzhuriBean.getToiawaseAdr2Kj());
                dattaiTuutiKzhuriTy.setZtytawadr3kj(khDattaiTuutiKzhuriBean.getToiawaseAdr3Kj());
                dattaiTuutiKzhuriTy.setZtytawtelnov14(khDattaiTuutiKzhuriBean.getToiawaseTelNo());
                dattaiTuutiKzhuriTy.setZtytawteluktkkanou1(khDattaiTuutiKzhuriBean.getToiawaseTelUktkKanou1());
                dattaiTuutiKzhuriTy.setZtytawteluktkkanou2(khDattaiTuutiKzhuriBean.getToiawaseTelUktkKanou2());
                dattaiTuutiKzhuriTy.setZtydai2tawsosikinmkj(khDattaiTuutiKzhuriBean.getToiawaseSosikiNmKj2());
                dattaiTuutiKzhuriTy.setZtydai2tawtelno(khDattaiTuutiKzhuriBean.getToiawaseTelNo2());
                dattaiTuutiKzhuriTy.setZtysclatosyono(sclatoSyono);
                dattaiTuutiKzhuriTy.setZtysakunm15keta(sakuseiNo);
                dattaiTuutiKzhuriTy.setZtyosirasemongon1(khDattaiTuutiKzhuriBean.getOsiraseMongon1());
                dattaiTuutiKzhuriTy.setZtyosirasemongon2(khDattaiTuutiKzhuriBean.getOsiraseMongon2());
                dattaiTuutiKzhuriTy.setZtyosirasemongon3(khDattaiTuutiKzhuriBean.getOsiraseMongon3());
                dattaiTuutiKzhuriTy.setZtyosirasemongon4(khDattaiTuutiKzhuriBean.getOsiraseMongon4());
                dattaiTuutiKzhuriTy.setZtyosirasemongon5(khDattaiTuutiKzhuriBean.getOsiraseMongon5());
                dattaiTuutiKzhuriTy.setZtyosirasemongon6(khDattaiTuutiKzhuriBean.getOsiraseMongon6());
                dattaiTuutiKzhuriTy.setZtyosirasemongon7(khDattaiTuutiKzhuriBean.getOsiraseMongon7());
                dattaiTuutiKzhuriTy.setZtyosirasemongon8(khDattaiTuutiKzhuriBean.getOsiraseMongon8());
                dattaiTuutiKzhuriTy.setZtyosirasemongon9(khDattaiTuutiKzhuriBean.getOsiraseMongon9());
                dattaiTuutiKzhuriTy.setZtysyono2(khDattaiTuutiKzhuriBean.getSyono());
                dattaiTuutiKzhuriTy.setZtyhhknnmkj(khDattaiTuutiKzhuriBean.getHhknNmKj());
                dattaiTuutiKzhuriTy.setZtykzinfo30keta1(khDattaiTuutiKzhuriBean.getKzInfo30Keta1());
                dattaiTuutiKzhuriTy.setZtykzinfo30keta2(khDattaiTuutiKzhuriBean.getKzInfo30Keta2());
                dattaiTuutiKzhuriTy.setZtykzinfo30keta3(khDattaiTuutiKzhuriBean.getKzInfo30Keta3());
                dattaiTuutiKzhuriTy.setZtykouzamaskingmsg(khDattaiTuutiKzhuriBean.getKouzaMaskingMsg());

                BizPropertyInitializer.initialize(dattaiTuutiKzhuriTy);

                entityInserter.add(dattaiTuutiKzhuriTy);

                String renbanKekka = RenbanUtil.getRenbanAsString(Integer.parseInt(C_NosyuruiKbn.
                    TUUTIRIREKIRENNO.getValue()));

                BT_TuutirirekiMeisaiHokan tuutirirekiMeisaiHokan = new BT_TuutirirekiMeisaiHokan();
                tuutirirekiMeisaiHokan.setTuutirirekirenno(renbanKekka);
                tuutirirekiMeisaiHokan.setTuutirirekino(C_TuutirirekiTaisyouKbn.SYOUKENNO.getValue() +
                    khDattaiTuutiKzhuriBean.getSyono());
                tuutirirekiMeisaiHokan.setTuutisakuseiymd(syoriYMD);
                tuutirirekiMeisaiHokan.setTuutisakuseino(0);
                tuutirirekiMeisaiHokan.setTuutisyuruicd(kinou.getSyoricd() + TUUTISYURUICD_SIMO4KETA);
                tuutirirekiMeisaiHokan.setHyoujiyoutuutisakuseiymd(syoriYMD);

                BizPropertyInitializer.initialize(tuutirirekiMeisaiHokan);

                entityInserterTuuti.add(tuutirirekiMeisaiHokan);

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