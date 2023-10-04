package yuyu.batch.hozen.khinterf.khyuukouseingtuutifilesks;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.db.MultipleEntityInserter;
import jp.co.slcs.swak.sequence.RenbanUtil;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.hozen.khinterf.khyuukouseingtuutifilesks.dba.KhYuukouseiNgTuutiBean;
import yuyu.batch.hozen.khinterf.khyuukouseingtuutifilesks.dba.KhYuukouseiNgTuutiFileSksDao;
import yuyu.common.base.format.FixedDateFormatter;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_NosyuruiKbn;
import yuyu.def.classification.C_TuutirirekiTaisyouKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BT_TuutirirekiMeisaiHokan;
import yuyu.def.db.entity.IT_YuukouseiNgTuuti;
import yuyu.def.db.entity.ZT_YuukouseiNgTuutiTy;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 契約保全 インターフェイス 有効性確認ＮＧ通知Ｆ作成
 */
public class KhYuukouseiNgTuutiFileSksBatch implements Batch {

    private static final String TABLEID = IT_YuukouseiNgTuuti.TABLE_NAME;

    private static final String FILTERID = "Kh001";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private KhYuukouseiNgTuutiFileSksDao khYuukouseiNgTuutiFileSksDao;

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
        int syoriKensuu = 0;

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(bzBatchParam.getSyoriYmd())));
        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW1018),
            bzBatchParam.getIbKakutyoujobcd()));

        try (ExDBResults<KhYuukouseiNgTuutiBean> khyuukouseingtuutifileskslist =
            khYuukouseiNgTuutiFileSksDao.getYuukouseiNgTuutiBeans(bzBatchParam.getIbKakutyoujobcd(), bzBatchParam.getSyoriYmd());

            MultipleEntityInserter multipleEntityInserter = new MultipleEntityInserter();) {
            for (KhYuukouseiNgTuutiBean khYuukouseiNgTuutiBean : khyuukouseingtuutifileskslist) {
                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(bzBatchParam.getIbKakutyoujobcd());
                bzRecoveryDatasikibetuBean.setIbTableid(TABLEID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(FILTERID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(khYuukouseiNgTuutiBean.getKbnkey());
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(khYuukouseiNgTuutiBean.getSyono());

                syoriKensuu++;

                ZT_YuukouseiNgTuutiTy yuukouseiNgTuutiTy = new ZT_YuukouseiNgTuutiTy();

                yuukouseiNgTuutiTy.setZtysyoruicd(String.valueOf(khYuukouseiNgTuutiBean.getSyoruiCd()).toUpperCase());
                yuukouseiNgTuutiTy.setZtyhassoukbn(String.valueOf(khYuukouseiNgTuutiBean.getHassoukbn()));
                yuukouseiNgTuutiTy.setZtytyouhyouymd(String.valueOf(khYuukouseiNgTuutiBean.getTyouhyouymd()));
                yuukouseiNgTuutiTy.setZtytyouhyouymdkj(FixedDateFormatter.
                    formatYMDZenkakuSeirekiKanji(khYuukouseiNgTuutiBean.getTyouhyouymd()));
                yuukouseiNgTuutiTy.setZtysyono(khYuukouseiNgTuutiBean.getSyono());
                yuukouseiNgTuutiTy.setZtyshskyno(khYuukouseiNgTuutiBean.getShskyno());
                yuukouseiNgTuutiTy.setZtyshskadr1kj(khYuukouseiNgTuutiBean.getShsadr1kj());
                yuukouseiNgTuutiTy.setZtyshskadr2kj(khYuukouseiNgTuutiBean.getShsadr2kj());
                yuukouseiNgTuutiTy.setZtyshskadr3kj(khYuukouseiNgTuutiBean.getShsadr3kj());
                yuukouseiNgTuutiTy.setZtyshsnmkj(khYuukouseiNgTuutiBean.getShsnmkj());
                yuukouseiNgTuutiTy.setZtytawsosikikj(khYuukouseiNgTuutiBean.getToiawasesosikinmkj());
                yuukouseiNgTuutiTy.setZtytawyno(khYuukouseiNgTuutiBean.getToiawaseyno());
                yuukouseiNgTuutiTy.setZtytawadr1kj(khYuukouseiNgTuutiBean.getToiawaseadr1kj());
                yuukouseiNgTuutiTy.setZtytawadr2kj(khYuukouseiNgTuutiBean.getToiawaseadr2kj());
                yuukouseiNgTuutiTy.setZtytawadr3kj(khYuukouseiNgTuutiBean.getToiawaseadr3kj());
                yuukouseiNgTuutiTy.setZtytawtelnov14(khYuukouseiNgTuutiBean.getToiawasetelno());
                yuukouseiNgTuutiTy.setZtytawteluktkkanou1(khYuukouseiNgTuutiBean.getToiawaseteluktkkanou1());
                yuukouseiNgTuutiTy.setZtytawteluktkkanou2(khYuukouseiNgTuutiBean.getToiawaseteluktkkanou2());
                yuukouseiNgTuutiTy.setZtydai2tawsosikinmkj(khYuukouseiNgTuutiBean.getToiawasesosikinmkj2());
                yuukouseiNgTuutiTy.setZtydai2tawtelno(khYuukouseiNgTuutiBean.getToiawasetelno2());
                yuukouseiNgTuutiTy.setZtyosirasemongon46keta1(khYuukouseiNgTuutiBean.getOsirasemongon46keta1());
                yuukouseiNgTuutiTy.setZtyosirasemongon46keta2(khYuukouseiNgTuutiBean.getOsirasemongon46keta2());
                yuukouseiNgTuutiTy.setZtyosirasemongon46keta3(khYuukouseiNgTuutiBean.getOsirasemongon46keta3());
                yuukouseiNgTuutiTy.setZtyosirasemongon46keta4(khYuukouseiNgTuutiBean.getOsirasemongon46keta4());
                yuukouseiNgTuutiTy.setZtyosirasemongon46keta5(khYuukouseiNgTuutiBean.getOsirasemongon46keta5());
                yuukouseiNgTuutiTy.setZtyosirasemongon46keta6(khYuukouseiNgTuutiBean.getOsirasemongon46keta6());
                yuukouseiNgTuutiTy.setZtyosirasemongon46keta7(khYuukouseiNgTuutiBean.getOsirasemongon46keta7());
                yuukouseiNgTuutiTy.setZtyosirasemongon46keta8(khYuukouseiNgTuutiBean.getOsirasemongon46keta8());
                yuukouseiNgTuutiTy.setZtyosirasemongon46keta9(khYuukouseiNgTuutiBean.getOsirasemongon46keta9());
                yuukouseiNgTuutiTy.setZtyosirasemongon46keta10(khYuukouseiNgTuutiBean.getOsirasemongon46keta10());
                yuukouseiNgTuutiTy.setZtykyknmkj(khYuukouseiNgTuutiBean.getKyknmkj());
                yuukouseiNgTuutiTy.setZtypkngk(String.valueOf(khYuukouseiNgTuutiBean.getHokenryou()));
                yuukouseiNgTuutiTy.setZtycreditcardinfo1(khYuukouseiNgTuutiBean.getCreditcardinfo1());
                yuukouseiNgTuutiTy.setZtycreditcardinfo2(khYuukouseiNgTuutiBean.getCreditcardinfo2());
                yuukouseiNgTuutiTy.setZtycreditcardinfo3(khYuukouseiNgTuutiBean.getCreditcardinfo3());
                yuukouseiNgTuutiTy.setZtycreditcardmaskingmsg(khYuukouseiNgTuutiBean.getCreditcardmaskingmsg());
                yuukouseiNgTuutiTy.setZtygoiraijikoutoumongon1(khYuukouseiNgTuutiBean.getGoiraijikoutoumongon1());
                yuukouseiNgTuutiTy.setZtygoiraijikoutoumongon2(khYuukouseiNgTuutiBean.getGoiraijikoutoumongon2());
                yuukouseiNgTuutiTy.setZtygoiraijikoutoumongon3(khYuukouseiNgTuutiBean.getGoiraijikoutoumongon3());
                yuukouseiNgTuutiTy.setZtyphrkmongon1(khYuukouseiNgTuutiBean.getPhrkmongon1());
                yuukouseiNgTuutiTy.setZtyphrkmongon2(khYuukouseiNgTuutiBean.getPhrkmongon2());
                yuukouseiNgTuutiTy.setZtyphrkmongon3(khYuukouseiNgTuutiBean.getPhrkmongon3());
                yuukouseiNgTuutiTy.setZtyphrkmongon4(khYuukouseiNgTuutiBean.getPhrkmongon4());
                yuukouseiNgTuutiTy.setZtyphrkmongon5(khYuukouseiNgTuutiBean.getPhrkmongon5());
                yuukouseiNgTuutiTy.setZtyphrkmongon6(khYuukouseiNgTuutiBean.getPhrkmongon6());
                yuukouseiNgTuutiTy.setZtyphrkmongon7(khYuukouseiNgTuutiBean.getPhrkmongon7());
                yuukouseiNgTuutiTy.setZtyphrkmongon8(khYuukouseiNgTuutiBean.getPhrkmongon8());
                yuukouseiNgTuutiTy.setZtyphrkmongon9(khYuukouseiNgTuutiBean.getPhrkmongon9());
                BizPropertyInitializer.initialize(yuukouseiNgTuutiTy);
                multipleEntityInserter.add(yuukouseiNgTuutiTy);

                String renbanKekka = RenbanUtil.getRenbanAsString(Integer.parseInt(C_NosyuruiKbn.TUUTIRIREKIRENNO.getValue()));

                BT_TuutirirekiMeisaiHokan tuutirirekiMeisaiHokan = new BT_TuutirirekiMeisaiHokan();

                tuutirirekiMeisaiHokan.setTuutirirekirenno(renbanKekka);
                tuutirirekiMeisaiHokan.setTuutirirekino(C_TuutirirekiTaisyouKbn.SYOUKENNO.getValue() + khYuukouseiNgTuutiBean.getSyono());
                tuutirirekiMeisaiHokan.setTuutisakuseiymd(bzBatchParam.getSyoriYmd());
                tuutirirekiMeisaiHokan.setTuutisakuseino(0);
                tuutirirekiMeisaiHokan.setTuutisyuruicd(kinou.getSyoricd() + "0001");
                tuutirirekiMeisaiHokan.setHyoujiyoutuutisakuseiymd(bzBatchParam.getSyoriYmd());
                BizPropertyInitializer.initialize(tuutirirekiMeisaiHokan);
                multipleEntityInserter.add(tuutirirekiMeisaiHokan);
            }
        }

        bzRecoveryDatasikibetuBean.initializeBlank();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(syoriKensuu)));
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }
}
