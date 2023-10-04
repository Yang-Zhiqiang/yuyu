package yuyu.batch.hozen.khinterf.khhrhnkanryotuutifilesks;

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
import yuyu.batch.hozen.khinterf.khhrhnkanryotuutifilesks.dba.KhHrhnKanryoTuutiBean;
import yuyu.batch.hozen.khinterf.khhrhnkanryotuutifilesks.dba.KhHrhnKanryoTuutiFileSksDao;
import yuyu.common.base.format.FixedDateFormatter;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.hozen.khcommon.AnsyuKokTyouhyouHensyuu;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_AsTyouhyoukigouKbn;
import yuyu.def.classification.C_NosyuruiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_TuutirirekiTaisyouKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BT_TuutirirekiMeisaiHokan;
import yuyu.def.db.entity.IT_HrhnTtdkKan;
import yuyu.def.db.entity.ZT_HrhnTtdkKanTy;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 契約保全 インターフェイス 払変完了通知（ＤＮＰ）Ｆ作成
 */
public class KhHrhnKanryoTuutiFileSksBatch implements Batch {

    private static final String TABLEID = IT_HrhnTtdkKan.TABLE_NAME;

    private static final String FILTERID = "Kh001";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private KhHrhnKanryoTuutiFileSksDao khHrhnKanryoTuutiFileSksDao;

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

        try (ExDBResults<KhHrhnKanryoTuutiBean> khHrhnKanryoTuutiBeanLst =
            khHrhnKanryoTuutiFileSksDao.getKhHrhnKanryoTuutiBeans(kakutyoujobCd, syoriYMD);

            EntityInserter<ZT_HrhnTtdkKanTy> inserter = new EntityInserter<>();
            EntityInserter<BT_TuutirirekiMeisaiHokan> tuutirirekiMeisaiHokaninserter = new EntityInserter<>();){

            for (KhHrhnKanryoTuutiBean khHrhnKanryoTuutiBean : khHrhnKanryoTuutiBeanLst) {

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(kakutyoujobCd);

                bzRecoveryDatasikibetuBean.setIbTableid(TABLEID);

                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(FILTERID);

                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(khHrhnKanryoTuutiBean.getKbnkey());

                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(khHrhnKanryoTuutiBean.getSyono());

                syoriKensuu = syoriKensuu + 1;

                AnsyuKokTyouhyouHensyuu ansyuKokTyouhyouHensyuu = SWAKInjector.getInstance(AnsyuKokTyouhyouHensyuu.class);

                ansyuKokTyouhyouHensyuu.exec(khHrhnKanryoTuutiBean.getSyono(), String.valueOf(syoriKensuu),
                    C_AsTyouhyoukigouKbn.AS_HRHNKANRYOTUUTI_DNP, khHrhnKanryoTuutiBean.getHonsyakaisouriyuu());

                String sclatoSyono = ansyuKokTyouhyouHensyuu.getSclatoSyono();

                String sakuseiNo = ansyuKokTyouhyouHensyuu.getSakuseino();

                String tyouhyouYmd = FixedDateFormatter.formatYMDZenkakuSeirekiKanji(
                    khHrhnKanryoTuutiBean.getTyouhyouymd());

                String kouryokuHasseiYm  = "";

                String ztykouryokuHasseiYmMsg = "";

                if (khHrhnKanryoTuutiBean.getKouryokuhasseiym() != null) {

                    kouryokuHasseiYm = FixedDateFormatter.formatYMZenkakuSeirekiKanji(
                        khHrhnKanryoTuutiBean.getKouryokuhasseiym().getFirstDay());

                    ztykouryokuHasseiYmMsg = "（" + kouryokuHasseiYm + "分から）";
                }

                HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
                C_Tuukasyu tuukasyu = henkanTuuka.henkanTuukaTypeToKbn(khHrhnKanryoTuutiBean.getHrkp().getType());

                ZT_HrhnTtdkKanTy hrhnTtdkKanTy = new ZT_HrhnTtdkKanTy();

                hrhnTtdkKanTy.setZtysyoruicd(khHrhnKanryoTuutiBean.getSyoruiCd().getValue().toUpperCase());

                hrhnTtdkKanTy.setZtytyouhyouymd(khHrhnKanryoTuutiBean.getTyouhyouymd().toString());

                hrhnTtdkKanTy.setZtytyouhyouymdkj(tyouhyouYmd);

                hrhnTtdkKanTy.setZtysyono(khHrhnKanryoTuutiBean.getSyono());

                hrhnTtdkKanTy.setZtyhassoukbn(khHrhnKanryoTuutiBean.getHassoukbn().getValue());

                hrhnTtdkKanTy.setZtysikibetuno(khHrhnKanryoTuutiBean.getHenkousikibetukey());

                hrhnTtdkKanTy.setZtyshskyno(khHrhnKanryoTuutiBean.getShskyno());

                hrhnTtdkKanTy.setZtyshskadr1kj(khHrhnKanryoTuutiBean.getShsadr1kj());

                hrhnTtdkKanTy.setZtyshskadr2kj(khHrhnKanryoTuutiBean.getShsadr2kj());

                hrhnTtdkKanTy.setZtyshskadr3kj(khHrhnKanryoTuutiBean.getShsadr3kj());

                hrhnTtdkKanTy.setZtyshsnmkj(khHrhnKanryoTuutiBean.getShsnmkj());

                hrhnTtdkKanTy.setZtytawsosikikj(khHrhnKanryoTuutiBean.getToiawasesosikinmkj());

                hrhnTtdkKanTy.setZtytawyno(khHrhnKanryoTuutiBean.getToiawaseyno());

                hrhnTtdkKanTy.setZtytawadr1kj(khHrhnKanryoTuutiBean.getToiawaseadr1kj());

                hrhnTtdkKanTy.setZtytawadr2kj(khHrhnKanryoTuutiBean.getToiawaseadr2kj());

                hrhnTtdkKanTy.setZtytawadr3kj(khHrhnKanryoTuutiBean.getToiawaseadr3kj());

                hrhnTtdkKanTy.setZtytawtelnov14(khHrhnKanryoTuutiBean.getToiawasetelno());

                hrhnTtdkKanTy.setZtytawteluktkkanou1(khHrhnKanryoTuutiBean.getToiawaseteluktkkanou1());

                hrhnTtdkKanTy.setZtytawteluktkkanou2(khHrhnKanryoTuutiBean.getToiawaseteluktkkanou2());

                hrhnTtdkKanTy.setZtydai2tawsosikinmkj(khHrhnKanryoTuutiBean.getToiawasesosikinmkj2());

                hrhnTtdkKanTy.setZtydai2tawtelno(khHrhnKanryoTuutiBean.getToiawasetelno2());

                hrhnTtdkKanTy.setZtysclatosyono(sclatoSyono);

                hrhnTtdkKanTy.setZtysakunm15keta(sakuseiNo);

                hrhnTtdkKanTy.setZtykouzamaskingmsg(khHrhnKanryoTuutiBean.getKouzamaskingmsg());

                hrhnTtdkKanTy.setZtyhrkkaisuutkiktbrisyu(khHrhnKanryoTuutiBean.getHrkkaisuutkiktbrisyu());

                hrhnTtdkKanTy.setZtyhrkkeiro(khHrhnKanryoTuutiBean.getHrkkeiro().getValue());

                hrhnTtdkKanTy.setZtyhrkp(khHrhnKanryoTuutiBean.getHrkp().toAdsoluteString());

                hrhnTtdkKanTy.setZtykouryokuhasseiymmsg(ztykouryokuHasseiYmMsg);

                hrhnTtdkKanTy.setZtyptuukatype(tuukasyu.getValue());

                hrhnTtdkKanTy.setZtymsgarea34keta1(khHrhnKanryoTuutiBean.getMsgarea34keta1());

                hrhnTtdkKanTy.setZtymsgarea34keta2(khHrhnKanryoTuutiBean.getMsgarea34keta2());

                hrhnTtdkKanTy.setZtymsgarea34keta3(khHrhnKanryoTuutiBean.getMsgarea34keta3());

                hrhnTtdkKanTy.setZtymsgarea34keta4(khHrhnKanryoTuutiBean.getMsgarea34keta4());

                hrhnTtdkKanTy.setZtymsgarea34keta5(khHrhnKanryoTuutiBean.getMsgarea34keta5());

                hrhnTtdkKanTy.setZtymsgarea34keta6(khHrhnKanryoTuutiBean.getMsgarea34keta6());

                hrhnTtdkKanTy.setZtymsgarea34keta7(khHrhnKanryoTuutiBean.getMsgarea34keta7());

                hrhnTtdkKanTy.setZtyhurikaeyokokumsg34keta1(khHrhnKanryoTuutiBean.getHrkykkmsg34keta1());

                hrhnTtdkKanTy.setZtyhurikaeyokokumsg34keta2(khHrhnKanryoTuutiBean.getHrkykkmsg34keta2());

                hrhnTtdkKanTy.setZtyhurikaeyokokumsg34keta3(khHrhnKanryoTuutiBean.getHrkykkmsg34keta3());

                hrhnTtdkKanTy.setZtyhurikaeyokokumsg34keta4(khHrhnKanryoTuutiBean.getHrkykkmsg34keta4());

                hrhnTtdkKanTy.setZtyhurikaeyokokumsg34keta5(khHrhnKanryoTuutiBean.getHrkykkmsg34keta5());

                hrhnTtdkKanTy.setZtyhurikaeyokokumsg34keta6(khHrhnKanryoTuutiBean.getHrkykkmsg34keta6());

                hrhnTtdkKanTy.setZtyhurikaeyokokumsg34keta7(khHrhnKanryoTuutiBean.getHrkykkmsg34keta7());

                hrhnTtdkKanTy.setZtyhurikaeyokokumsg34keta8(khHrhnKanryoTuutiBean.getHrkykkmsg34keta8());

                hrhnTtdkKanTy.setZtyhurikaeyokokumsg34keta9(khHrhnKanryoTuutiBean.getHrkykkmsg34keta9());

                hrhnTtdkKanTy.setZtyhurikaeyokokumsg34keta10(khHrhnKanryoTuutiBean.getHrkykkmsg34keta10());

                hrhnTtdkKanTy.setZtyhurikaeyokokumsg34keta11(khHrhnKanryoTuutiBean.getHrkykkmsg34keta11());

                hrhnTtdkKanTy.setZtyhurikaeyokokumsg34keta12(khHrhnKanryoTuutiBean.getHrkykkmsg34keta12());

                hrhnTtdkKanTy.setZtyhurikaeyokokumsg34keta13(khHrhnKanryoTuutiBean.getHrkykkmsg34keta13());

                hrhnTtdkKanTy.setZtyhurikaeyokokumsg34keta14(khHrhnKanryoTuutiBean.getHrkykkmsg34keta14());

                hrhnTtdkKanTy.setZtyhurikaeyokokumsg34keta15(khHrhnKanryoTuutiBean.getHrkykkmsg34keta15());

                hrhnTtdkKanTy.setZtyhurikaeyokokumsg34keta16(khHrhnKanryoTuutiBean.getHrkykkmsg34keta16());

                hrhnTtdkKanTy.setZtyhurikaeyokokumsg34keta17(khHrhnKanryoTuutiBean.getHrkykkmsg34keta17());

                hrhnTtdkKanTy.setZtyhurikaeyokokumsg34keta18(khHrhnKanryoTuutiBean.getHrkykkmsg34keta18());

                hrhnTtdkKanTy.setZtyhurikaeyokokumsg34keta19(khHrhnKanryoTuutiBean.getHrkykkmsg34keta19());

                hrhnTtdkKanTy.setZtyhurikaeyokokumsg34keta20(khHrhnKanryoTuutiBean.getHrkykkmsg34keta20());

                hrhnTtdkKanTy.setZtyhurikaeyokokumsg34keta21(khHrhnKanryoTuutiBean.getHrkykkmsg34keta21());

                hrhnTtdkKanTy.setZtyhurikaeyokokumsg34keta22(khHrhnKanryoTuutiBean.getHrkykkmsg34keta22());

                hrhnTtdkKanTy.setZtyhurikaeyokokumsg34keta23(khHrhnKanryoTuutiBean.getHrkykkmsg34keta23());

                hrhnTtdkKanTy.setZtyhurikaeyokokumsg34keta24(khHrhnKanryoTuutiBean.getHrkykkmsg34keta24());

                hrhnTtdkKanTy.setZtyhurikaeyokokumsg34keta25(khHrhnKanryoTuutiBean.getHrkykkmsg34keta25());

                hrhnTtdkKanTy.setZtyhurikaeyokokumsg34keta26(khHrhnKanryoTuutiBean.getHrkykkmsg34keta26());

                hrhnTtdkKanTy.setZtyhurikaeyokokumsg34keta27(khHrhnKanryoTuutiBean.getHrkykkmsg34keta27());

                hrhnTtdkKanTy.setZtyhurikaeyokokumsg34keta28(khHrhnKanryoTuutiBean.getHrkykkmsg34keta28());

                BizPropertyInitializer.initialize(hrhnTtdkKanTy);

                inserter.add(hrhnTtdkKanTy);

                String numKekka = RenbanUtil.getRenbanAsString(Integer.valueOf(C_NosyuruiKbn.TUUTIRIREKIRENNO.getValue()));

                BT_TuutirirekiMeisaiHokan tuutirirekiMeisaiHokan = new BT_TuutirirekiMeisaiHokan();
                tuutirirekiMeisaiHokan.setTuutirirekirenno(numKekka);
                tuutirirekiMeisaiHokan.setTuutirirekino(C_TuutirirekiTaisyouKbn.SYOUKENNO.getValue()
                    + khHrhnKanryoTuutiBean.getSyono());
                tuutirirekiMeisaiHokan.setTuutisakuseiymd(syoriYMD);
                tuutirirekiMeisaiHokan.setTuutisakuseino(0);
                tuutirirekiMeisaiHokan.setTuutisyuruicd(kinou.getSyoricd() + "0001");
                tuutirirekiMeisaiHokan.setHyoujiyoutuutisakuseiymd(syoriYMD);

                BizPropertyInitializer.initialize(tuutirirekiMeisaiHokan);
                tuutirirekiMeisaiHokaninserter.add(tuutirirekiMeisaiHokan);
            }
        }

        bzRecoveryDatasikibetuBean.initializeBlank();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(syoriKensuu)));
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery = SWAKInjector
            .getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }
}
