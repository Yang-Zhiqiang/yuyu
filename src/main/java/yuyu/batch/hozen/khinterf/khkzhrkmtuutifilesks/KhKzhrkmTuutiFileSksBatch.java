package yuyu.batch.hozen.khinterf.khkzhrkmtuutifilesks;

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
import yuyu.batch.hozen.khinterf.khkzhrkmtuutifilesks.dba.KhKzhrkmTuutiDataBean;
import yuyu.batch.hozen.khinterf.khkzhrkmtuutifilesks.dba.KhKzhrkmTuutiFileSksDao;
import yuyu.common.base.format.FixedDateFormatter;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.hozen.khcommon.AnsyuKokTyouhyouHensyuu;
import yuyu.common.hozen.khcommon.AnsyuuSetTetudukityuuiInfo;
import yuyu.common.hozen.khcommon.AnsyuuSetTetudukityuuiInfoBean;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_AsTyouhyoukigouKbn;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_KktyuitaKbn;
import yuyu.def.classification.C_KykdrknHtdjytKbn;
import yuyu.def.classification.C_NosyuruiKbn;
import yuyu.def.classification.C_TuutirirekiTaisyouKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BT_TuutirirekiMeisaiHokan;
import yuyu.def.db.entity.IT_KouzaHrkmTuuti;
import yuyu.def.db.entity.ZT_KouzaHrkmTuutiTy;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 契約保全 インターフェイス 口座振込通知Ｆ作成
 */
public class KhKzhrkmTuutiFileSksBatch implements Batch{

    private static final String TABLEID = IT_KouzaHrkmTuuti.TABLE_NAME;

    private static final String FILTERID = "Kh001";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private KhKzhrkmTuutiFileSksDao khKzhrkmTuutiFileSksDao;

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

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(
            MessageId.IBW0003), String.valueOf(syoriYmd)));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(
            MessageId.IBW1018), kakutyoujobCd));

        long syoriKensuu = 0;

        AnsyuuSetTetudukityuuiInfo ansyuuSetTetudukityuuiInfo = SWAKInjector.getInstance(AnsyuuSetTetudukityuuiInfo.class);

        AnsyuKokTyouhyouHensyuu ansyuKokTyouhyouHensyuu = SWAKInjector.getInstance(AnsyuKokTyouhyouHensyuu.class);

        try(ExDBResults<KhKzhrkmTuutiDataBean> khKzhrkmTuutiDataBeanLst =
            khKzhrkmTuutiFileSksDao.getKzhrkmTuutiDataBeans(kakutyoujobCd, syoriYmd);

            EntityInserter<ZT_KouzaHrkmTuutiTy> inserter= new EntityInserter<>();

            EntityInserter<BT_TuutirirekiMeisaiHokan> tuutirirekiMeisaiHokanInserter = new EntityInserter<>();) {

            for(KhKzhrkmTuutiDataBean khKzhrkmTuutiDataBean : khKzhrkmTuutiDataBeanLst) {

                String syoNo = khKzhrkmTuutiDataBean.getSyono();

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(kakutyoujobCd);

                bzRecoveryDatasikibetuBean.setIbTableid(TABLEID);

                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(FILTERID);

                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(khKzhrkmTuutiDataBean.getKbnkey());

                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(syoNo);

                String renno = String.valueOf(syoriKensuu + 1);

                String hnskaRiyuu = "000";

                C_HassouKbn hassouKbn = khKzhrkmTuutiDataBean.getHassouKbn();

                AnsyuuSetTetudukityuuiInfoBean ansyuuSetTetudukityuuiInfoBean =
                    ansyuuSetTetudukityuuiInfo.getAnsyuuSetTetudukityuuiInfo(syoNo);

                if (C_KktyuitaKbn.DNGNMEMOARI.eq(ansyuuSetTetudukityuuiInfoBean.getKktyuitaKbn())) {

                    hnskaRiyuu = "Z01";
                }
                else if (C_HassouKbn.HONSYAKAISOU.eq(hassouKbn) &&
                    C_KykdrknHtdjytKbn.SETTEI.eq(ansyuuSetTetudukityuuiInfoBean.getKykdrknhatudoujyoutaiKbn())) {

                    hnskaRiyuu = "Z02";
                }

                ansyuKokTyouhyouHensyuu.exec(syoNo, renno, C_AsTyouhyoukigouKbn.AS_KZHURIKOMITUUTI, hnskaRiyuu);

                String sclatoSyono = ansyuKokTyouhyouHensyuu.getSclatoSyono();

                String sakuseiNo = ansyuKokTyouhyouHensyuu.getSakuseino();

                if (!C_HassouKbn.HONSYAKAISOU.eq(hassouKbn) &&
                    (C_KktyuitaKbn.DNGNMEMOARI.eq(ansyuuSetTetudukityuuiInfoBean.getKktyuitaKbn()))) {

                    hassouKbn = C_HassouKbn.HONSYAKAISOU;
                }

                String tyouhyouYmdKanji = FixedDateFormatter.formatYMDZenkakuSeirekiKanji(khKzhrkmTuutiDataBean.getTyouhyouYmd());

                String hurikomiYmdSeireki = FixedDateFormatter.formatYMDZenkakuSeirekiKanji(khKzhrkmTuutiDataBean.getHurikomiYmd());

                ZT_KouzaHrkmTuutiTy kouzaHrkmTuutiTy = new ZT_KouzaHrkmTuutiTy();

                kouzaHrkmTuutiTy.setZtysyoruicd(khKzhrkmTuutiDataBean.getSyoruiCd().getValue().toUpperCase());

                kouzaHrkmTuutiTy.setZtyhassoukbn(hassouKbn.getValue());

                kouzaHrkmTuutiTy.setZtytyouhyouymd(khKzhrkmTuutiDataBean.getTyouhyouYmd().toString());

                kouzaHrkmTuutiTy.setZtytyouhyouymdkj(tyouhyouYmdKanji);

                kouzaHrkmTuutiTy.setZtysyono(syoNo);

                kouzaHrkmTuutiTy.setZtysikibetuno(khKzhrkmTuutiDataBean.getHenkousikibetuKey());

                kouzaHrkmTuutiTy.setZtyshskyno(khKzhrkmTuutiDataBean.getShskyNo());

                kouzaHrkmTuutiTy.setZtyshskadr1kj(khKzhrkmTuutiDataBean.getShsadr1Kj());

                kouzaHrkmTuutiTy.setZtyshskadr2kj(khKzhrkmTuutiDataBean.getShsadr2Kj());

                kouzaHrkmTuutiTy.setZtyshskadr3kj(khKzhrkmTuutiDataBean.getShsadr3Kj());

                kouzaHrkmTuutiTy.setZtyshsnmkj(khKzhrkmTuutiDataBean.getShsnmKj());

                kouzaHrkmTuutiTy.setZtytawsosikikj(khKzhrkmTuutiDataBean.getToiawasesosikinmKj());

                kouzaHrkmTuutiTy.setZtytawyno(khKzhrkmTuutiDataBean.getToiawaseyNo());

                kouzaHrkmTuutiTy.setZtytawadr1kj(khKzhrkmTuutiDataBean.getToiawaseadr1Kj());

                kouzaHrkmTuutiTy.setZtytawadr2kj(khKzhrkmTuutiDataBean.getToiawaseadr2Kj());

                kouzaHrkmTuutiTy.setZtytawadr3kj(khKzhrkmTuutiDataBean.getToiawaseadr3Kj());

                kouzaHrkmTuutiTy.setZtytawtelnov14(khKzhrkmTuutiDataBean.getToiawasetelNo());

                kouzaHrkmTuutiTy.setZtytawteluktkkanou1(khKzhrkmTuutiDataBean.getToiawaseteluktkkanou1());

                kouzaHrkmTuutiTy.setZtytawteluktkkanou2(khKzhrkmTuutiDataBean.getToiawaseteluktkkanou2());

                kouzaHrkmTuutiTy.setZtydai2tawsosikinmkj(khKzhrkmTuutiDataBean.getToiawasesosikinmKj2());

                kouzaHrkmTuutiTy.setZtydai2tawtelno(khKzhrkmTuutiDataBean.getToiawasetelNo2());

                kouzaHrkmTuutiTy.setZtysclatosyono(sclatoSyono);

                kouzaHrkmTuutiTy.setZtysakunm15keta(sakuseiNo);

                kouzaHrkmTuutiTy.setZtytuutisakuseiymdV11(tyouhyouYmdKanji);

                kouzaHrkmTuutiTy.setZtysyono2(syoNo);

                kouzaHrkmTuutiTy.setZtyhrkmymdseireki(hurikomiYmdSeireki);

                kouzaHrkmTuutiTy.setZtyshrgk(khKzhrkmTuutiDataBean.getShrGk().toAdsoluteString());

                kouzaHrkmTuutiTy.setZtyshririyuu1(khKzhrkmTuutiDataBean.getShririyuu1());

                kouzaHrkmTuutiTy.setZtyshririyuu2(khKzhrkmTuutiDataBean.getShririyuu2());

                kouzaHrkmTuutiTy.setZtyshririyuu3(khKzhrkmTuutiDataBean.getShririyuu3());

                kouzaHrkmTuutiTy.setZtysiteikouza1(khKzhrkmTuutiDataBean.getSiteiKouza1());

                kouzaHrkmTuutiTy.setZtysiteikouza2(khKzhrkmTuutiDataBean.getSiteiKouza2());

                kouzaHrkmTuutiTy.setZtysiteikouza3(khKzhrkmTuutiDataBean.getSiteiKouza3());

                kouzaHrkmTuutiTy.setZtysiteikouza4(khKzhrkmTuutiDataBean.getSiteiKouza4());

                kouzaHrkmTuutiTy.setZtysiteikouza5(khKzhrkmTuutiDataBean.getSiteiKouza5());

                BizPropertyInitializer.initialize(kouzaHrkmTuutiTy);

                inserter.add(kouzaHrkmTuutiTy);

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

                syoriKensuu = syoriKensuu + 1;
            }

            bzRecoveryDatasikibetuBean.initializeBlank();

            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(syoriKensuu)));
        }
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery = SWAKInjector
            .getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }
}
