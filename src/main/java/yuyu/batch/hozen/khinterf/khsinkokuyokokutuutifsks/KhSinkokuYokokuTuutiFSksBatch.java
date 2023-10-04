package yuyu.batch.hozen.khinterf.khsinkokuyokokutuutifsks;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.sequence.RenbanUtil;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.hozen.khinterf.khsinkokuyokokutuutifsks.dba.KhSinkokuYokokuTuutiFSksDao;
import yuyu.batch.hozen.khinterf.khsinkokuyokokutuutifsks.dba.SinkokuYokokuTuutiDataBean;
import yuyu.common.base.format.FixedDateFormatter;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.hozen.khcommon.AnsyuKokTyouhyouHensyuu;
import yuyu.common.hozen.khcommon.AnsyuuSetTetudukityuuiInfo;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_AsTyouhyoukigouKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_KktyuitaKbn;
import yuyu.def.classification.C_NosyuruiKbn;
import yuyu.def.classification.C_TuutirirekiTaisyouKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BT_TuutirirekiMeisaiHokan;
import yuyu.def.db.entity.IT_SinkokuyokokuTuuti;
import yuyu.def.db.entity.ZT_SinkokuYokokuTuutiFSksTy;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

import com.google.common.base.Strings;

/**
 * 契約保全 インターフェイス 申告予告通知Ｆ作成
 */
public class KhSinkokuYokokuTuutiFSksBatch implements Batch {

    private static final String TYSYTTAISYOUTABLEID = IT_SinkokuyokokuTuuti.TABLE_NAME;

    private static final String RECOVERYFILTERID = "Kh001";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private KhSinkokuYokokuTuutiFSksBatchParam khSinkokuYokokuTuutiFSksBatchParam;

    @Inject
    private KhSinkokuYokokuTuutiFSksDao khSinkokuYokokuTuutiFSksDao;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Inject
    private AS_Kinou kinou;

    @Override
    public BatchParam getParam() {
        return khSinkokuYokokuTuutiFSksBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        BizDate syoriYmd = khSinkokuYokokuTuutiFSksBatchParam.getSyoriYmd();

        String kakutyoujobCd = khSinkokuYokokuTuutiFSksBatchParam.getIbKakutyoujobcd();

        String heisoukbn = khSinkokuYokokuTuutiFSksBatchParam.getHeisoukbn();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(syoriYmd)));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW1018),
            kakutyoujobCd));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBC1025, heisoukbn));

        long syoriKns = 0;

        try (
            ExDBResults<SinkokuYokokuTuutiDataBean> sinkokuYokokuTuutiDataBeanLst =
            khSinkokuYokokuTuutiFSksDao.getSinkokuYokokuTuutiByKakutyoujobcdTyouhyouymdKbnkey(kakutyoujobCd,
                syoriYmd, heisoukbn);

            EntityInserter<ZT_SinkokuYokokuTuutiFSksTy> sinkokuyokokuTuutiTyInserter =
                new EntityInserter<ZT_SinkokuYokokuTuutiFSksTy>();
            EntityInserter<BT_TuutirirekiMeisaiHokan> tuutirirekiMeisaiHokanInserter =
                new EntityInserter<BT_TuutirirekiMeisaiHokan>();) {

            for (SinkokuYokokuTuutiDataBean sinkokuYokokuTuutiDataBean : sinkokuYokokuTuutiDataBeanLst) {

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(kakutyoujobCd);
                bzRecoveryDatasikibetuBean.setIbTableid(TYSYTTAISYOUTABLEID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(RECOVERYFILTERID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(sinkokuYokokuTuutiDataBean.getKbnkey());
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(sinkokuYokokuTuutiDataBean.getSyono());

                String ippanyoteipnew = "";
                String ippanyoteihaitoukinnew = "";
                String ippanyoteisyoumeigknew = "**********";

                String iryouyoteipnew = "";
                String iryouyoteihaitoukinnew = "";
                String iryouyoteisyoumeigknew = "**********";

                String nenkinyoteipnew = "";
                String nenkinyoteihaitoukinnew = "";
                String nenkinyoteisyoumeigknew = "**********";

                int maskMjsuu = 0;

                String renno = sinkokuYokokuTuutiDataBean.getKbnkey().substring(1, 2) +
                    BizUtil.zeroNum(String.valueOf(syoriKns + 1), 6, 0);

                String honsyaKaisouRiyuu = "000";

                AnsyuuSetTetudukityuuiInfo ansyuuSetTetudukityuuiInfo = SWAKInjector.getInstance(AnsyuuSetTetudukityuuiInfo.class);

                C_KktyuitaKbn kktyuitaKbn = ansyuuSetTetudukityuuiInfo.exec(sinkokuYokokuTuutiDataBean.getSyono());

                if (C_KktyuitaKbn.DNGNMEMOARI.eq(kktyuitaKbn)) {

                    honsyaKaisouRiyuu = "Z01";
                }

                AnsyuKokTyouhyouHensyuu ansyuKokTyouhyouHensyuu = SWAKInjector.getInstance(AnsyuKokTyouhyouHensyuu.class);

                ansyuKokTyouhyouHensyuu.exec(
                    sinkokuYokokuTuutiDataBean.getSyono(),
                    renno,
                    C_AsTyouhyoukigouKbn.AS_SINKOKUYOKOKUTUUTI,
                    honsyaKaisouRiyuu);

                String sclatoSyono = ansyuKokTyouhyouHensyuu.getSclatoSyono();
                String sakuseiNo = ansyuKokTyouhyouHensyuu.getSakuseino();

                if (!BizUtil.isZero(sinkokuYokokuTuutiDataBean.getNewippanykkp())) {

                    ippanyoteipnew = sinkokuYokokuTuutiDataBean.getNewippanykkp().toString();
                }

                if (!BizUtil.isZero(sinkokuYokokuTuutiDataBean.getNewippanykkhaitoukin())) {

                    ippanyoteihaitoukinnew = sinkokuYokokuTuutiDataBean.getNewippanykkhaitoukin().toString();

                }

                if (!BizUtil.isZero(sinkokuYokokuTuutiDataBean.getNewippanykksyoumeigk())) {

                    if (sinkokuYokokuTuutiDataBean.getNewippanykksyoumeigk().compareTo(
                        BizCurrency.valueOf(0, sinkokuYokokuTuutiDataBean.getNewippanykksyoumeigk().getType())) > 0) {

                        ippanyoteisyoumeigknew = sinkokuYokokuTuutiDataBean.getNewippanykksyoumeigk().toString();
                        maskMjsuu = 10 - ippanyoteisyoumeigknew.length();

                        String editZeroNum = BizUtil.zeroNum(ippanyoteisyoumeigknew, 10, 0);

                        ippanyoteisyoumeigknew = BizUtil.editMask(editZeroNum, 0, maskMjsuu, '*');
                    }
                    else {

                        ippanyoteisyoumeigknew = Strings.padStart(
                            sinkokuYokokuTuutiDataBean.getNewippanykksyoumeigk().toString(), 10, ' ');
                    }
                }

                if (!BizUtil.isZero(sinkokuYokokuTuutiDataBean.getNewiryouykkp())) {
                    iryouyoteipnew = sinkokuYokokuTuutiDataBean.getNewiryouykkp().toString();
                }

                if (!BizUtil.isZero(sinkokuYokokuTuutiDataBean.getNewiryouykkhaitoukin())) {
                    iryouyoteihaitoukinnew = sinkokuYokokuTuutiDataBean.getNewiryouykkhaitoukin().toString();
                }

                if (!BizUtil.isZero(sinkokuYokokuTuutiDataBean.getNewiryouykksyoumeigk())) {

                    if (sinkokuYokokuTuutiDataBean.getNewiryouykksyoumeigk().compareTo(
                        BizCurrency.valueOf(0, sinkokuYokokuTuutiDataBean.getNewiryouykksyoumeigk().getType())) > 0) {

                        iryouyoteisyoumeigknew = sinkokuYokokuTuutiDataBean.getNewiryouykksyoumeigk().toString();

                        maskMjsuu = 10 - iryouyoteisyoumeigknew.length();

                        String editZeroNum = BizUtil.zeroNum(iryouyoteisyoumeigknew, 10, 0);

                        iryouyoteisyoumeigknew = BizUtil.editMask(editZeroNum, 0, maskMjsuu, '*');
                    }
                    else {

                        iryouyoteisyoumeigknew = Strings.padStart(
                            sinkokuYokokuTuutiDataBean.getNewiryouykksyoumeigk().toString(), 10, ' ');
                    }
                }

                if (!BizUtil.isZero(sinkokuYokokuTuutiDataBean.getNewnenkinykkp())) {

                    nenkinyoteipnew = sinkokuYokokuTuutiDataBean.getNewnenkinykkp().toString();
                }

                if (!BizUtil.isZero(sinkokuYokokuTuutiDataBean.getNewnenkinykkhaitoukin())) {

                    nenkinyoteihaitoukinnew = sinkokuYokokuTuutiDataBean.getNewnenkinykkhaitoukin().toString();
                }

                if (!BizUtil.isZero(sinkokuYokokuTuutiDataBean.getNewnenkinykksyoumeigk())) {

                    if (sinkokuYokokuTuutiDataBean.getNewnenkinykksyoumeigk().compareTo(
                        BizCurrency.valueOf(0, sinkokuYokokuTuutiDataBean.getNewnenkinykksyoumeigk().getType())) > 0) {

                        nenkinyoteisyoumeigknew = sinkokuYokokuTuutiDataBean.getNewnenkinykksyoumeigk().toString()
                            ;
                        maskMjsuu = 10 - nenkinyoteisyoumeigknew.length();

                        String editZeroNum = BizUtil.zeroNum(nenkinyoteisyoumeigknew, 10, 0);

                        nenkinyoteisyoumeigknew = BizUtil.editMask(editZeroNum, 0, maskMjsuu, '*');
                    }
                    else {

                        nenkinyoteisyoumeigknew = Strings.padStart(
                            sinkokuYokokuTuutiDataBean.getNewnenkinykksyoumeigk().toString(), 10, ' ');
                    }
                }

                String sinkokunenkj =
                    FixedDateFormatter.formatYZenkakuSeirekiKanji(
                        BizDate.valueOf(sinkokuYokokuTuutiDataBean.getSinkokunen() + "0101"));

                String kykymdkj = FixedDateFormatter.formatYMDZenkakuSeirekiKanji(sinkokuYokokuTuutiDataBean.getKykymd());

                String sakuseiymd = FixedDateFormatter.formatYMDZenkakuSeirekiKanji(syoriYmd);

                ZT_SinkokuYokokuTuutiFSksTy sinkokuYokokuTuutiFSksTy = new ZT_SinkokuYokokuTuutiFSksTy();
                sinkokuYokokuTuutiFSksTy.setZtysyoruicd((sinkokuYokokuTuutiDataBean.getSyoruiCd().getValue().toUpperCase()));
                sinkokuYokokuTuutiFSksTy.setZtyhassoukbn(sinkokuYokokuTuutiDataBean.getHassoukbn().getValue());
                sinkokuYokokuTuutiFSksTy.setZtytyouhyouymd(String.valueOf(sinkokuYokokuTuutiDataBean.getTyouhyouymd()));
                sinkokuYokokuTuutiFSksTy.setZtysyono(sinkokuYokokuTuutiDataBean.getSyono());
                sinkokuYokokuTuutiFSksTy.setZtyshskyno(sinkokuYokokuTuutiDataBean.getTsinyno());
                sinkokuYokokuTuutiFSksTy.setZtyshskadr1kj(sinkokuYokokuTuutiDataBean.getTsinadr1kj());
                sinkokuYokokuTuutiFSksTy.setZtyshskadr2kj(sinkokuYokokuTuutiDataBean.getTsinadr2kj());
                sinkokuYokokuTuutiFSksTy.setZtyshskadr3kj(sinkokuYokokuTuutiDataBean.getTsinadr3kj());
                sinkokuYokokuTuutiFSksTy.setZtyshsnmkj(sinkokuYokokuTuutiDataBean.getKyknmkj());
                sinkokuYokokuTuutiFSksTy.setZtytawsosikikj(sinkokuYokokuTuutiDataBean.getToiawasesosikinmkj());
                sinkokuYokokuTuutiFSksTy.setZtytawyno(sinkokuYokokuTuutiDataBean.getToiawaseyno());
                sinkokuYokokuTuutiFSksTy.setZtytawadr1kj(sinkokuYokokuTuutiDataBean.getToiawaseadr1kj());
                sinkokuYokokuTuutiFSksTy.setZtytawadr2kj(sinkokuYokokuTuutiDataBean.getToiawaseadr2kj());
                sinkokuYokokuTuutiFSksTy.setZtytawadr3kj(sinkokuYokokuTuutiDataBean.getToiawaseadr3kj());
                sinkokuYokokuTuutiFSksTy.setZtytawtelnov14(sinkokuYokokuTuutiDataBean.getToiawasetelno());
                sinkokuYokokuTuutiFSksTy.setZtytawteluktkkanou1(sinkokuYokokuTuutiDataBean.getToiawaseteluktkkanou1());
                sinkokuYokokuTuutiFSksTy.setZtytawteluktkkanou2(sinkokuYokokuTuutiDataBean.getToiawaseteluktkkanou2());
                sinkokuYokokuTuutiFSksTy.setZtydai2tawsosikinmkj(sinkokuYokokuTuutiDataBean.getToiawasesosikinmkj2());
                sinkokuYokokuTuutiFSksTy.setZtydai2tawtelno(sinkokuYokokuTuutiDataBean.getToiawasetelno2());
                sinkokuYokokuTuutiFSksTy.setZtysclatosyono(sclatoSyono);
                sinkokuYokokuTuutiFSksTy.setZtysakunm15keta(sakuseiNo);
                sinkokuYokokuTuutiFSksTy.setZtykyknmkj(sinkokuYokokuTuutiDataBean.getKyknmkj());
                sinkokuYokokuTuutiFSksTy.setZtysinkokunenkj(sinkokunenkj);
                sinkokuYokokuTuutiFSksTy.setZtymidasi1(sinkokuYokokuTuutiDataBean.getMidasi1());
                sinkokuYokokuTuutiFSksTy.setZtymidasi2(sinkokuYokokuTuutiDataBean.getMidasi2());
                sinkokuYokokuTuutiFSksTy.setZtymidasi3(sinkokuYokokuTuutiDataBean.getMidasi3());
                sinkokuYokokuTuutiFSksTy.setZtymidasi4(sinkokuYokokuTuutiDataBean.getMidasi4());
                sinkokuYokokuTuutiFSksTy.setZtymidasi5(sinkokuYokokuTuutiDataBean.getMidasi5());
                sinkokuYokokuTuutiFSksTy.setZtymidasi6(sinkokuYokokuTuutiDataBean.getMidasi6());
                sinkokuYokokuTuutiFSksTy.setZtymidasi7(sinkokuYokokuTuutiDataBean.getMidasi7());
                sinkokuYokokuTuutiFSksTy.setZtykihonjouhoumongon1(sinkokuYokokuTuutiDataBean.getKihonjouhoumongon1());
                sinkokuYokokuTuutiFSksTy.setZtykihonjouhoumongon2(sinkokuYokokuTuutiDataBean.getKihonjouhoumongon2());
                sinkokuYokokuTuutiFSksTy.setZtykihonjouhoumongon3(sinkokuYokokuTuutiDataBean.getKihonjouhoumongon3());
                sinkokuYokokuTuutiFSksTy.setZtykihonjouhoumongon4(sinkokuYokokuTuutiDataBean.getKihonjouhoumongon4());
                sinkokuYokokuTuutiFSksTy.setZtykihonjouhoumongon5(sinkokuYokokuTuutiDataBean.getKihonjouhoumongon5());
                sinkokuYokokuTuutiFSksTy.setZtykihonjouhoumongon6(sinkokuYokokuTuutiDataBean.getKihonjouhoumongon6());
                sinkokuYokokuTuutiFSksTy.setZtykihonjouhoumongon7(sinkokuYokokuTuutiDataBean.getKihonjouhoumongon7());
                sinkokuYokokuTuutiFSksTy.setZtyippanseimeipyoteigk(ippanyoteipnew);
                sinkokuYokokuTuutiFSksTy.setZtyippanhaitoukinyoteigk(ippanyoteihaitoukinnew);
                sinkokuYokokuTuutiFSksTy.setZtyippansinkokuyoteigk(ippanyoteisyoumeigknew);
                sinkokuYokokuTuutiFSksTy.setZtykaigoiryoupyoteigk(iryouyoteipnew);
                sinkokuYokokuTuutiFSksTy.setZtykaigoiryoudyoteigk(iryouyoteihaitoukinnew);
                sinkokuYokokuTuutiFSksTy.setZtykaigoiryousinkokuyoteigk(iryouyoteisyoumeigknew);
                sinkokuYokokuTuutiFSksTy.setZtynenkinpyoteigk(nenkinyoteipnew);
                sinkokuYokokuTuutiFSksTy.setZtynenkindyoteigk(nenkinyoteihaitoukinnew);
                sinkokuYokokuTuutiFSksTy.setZtynenkinsinkokuyoteigk(nenkinyoteisyoumeigknew);
                sinkokuYokokuTuutiFSksTy.setZtynewhknjytukikan(sinkokuYokokuTuutiDataBean.getHknjyutoukikan());
                sinkokuYokokuTuutiFSksTy.setZtykykymdkj(kykymdkj);

                if (C_Hrkkaisuu.NEN.eq(sinkokuYokokuTuutiDataBean.getHrkkaisuu())) {

                    sinkokuYokokuTuutiFSksTy.setZtyhrkkaisuunm("1");
                }
                else if (C_Hrkkaisuu.HALFY.eq(sinkokuYokokuTuutiDataBean.getHrkkaisuu())) {

                    sinkokuYokokuTuutiFSksTy.setZtyhrkkaisuunm("2");
                }

                sinkokuYokokuTuutiFSksTy.setZtysakuseiymdkj(sakuseiymd);

                BizPropertyInitializer.initialize(sinkokuYokokuTuutiFSksTy);

                sinkokuyokokuTuutiTyInserter.add(sinkokuYokokuTuutiFSksTy);

                String renbanKekka = RenbanUtil.getRenbanAsString(
                    Integer.parseInt(C_NosyuruiKbn.TUUTIRIREKIRENNO.getValue()));

                BT_TuutirirekiMeisaiHokan tuutiRirekiMeisaiHokan = new BT_TuutirirekiMeisaiHokan();

                tuutiRirekiMeisaiHokan.setTuutirirekirenno(renbanKekka);
                tuutiRirekiMeisaiHokan.setTuutirirekino(
                    C_TuutirirekiTaisyouKbn.SYOUKENNO.getValue() + sinkokuYokokuTuutiFSksTy.getZtysyono());
                tuutiRirekiMeisaiHokan.setTuutisakuseiymd(syoriYmd);
                tuutiRirekiMeisaiHokan.setTuutisakuseino(0);
                tuutiRirekiMeisaiHokan.setTuutisyuruicd(kinou.getSyoricd() + "0001");
                tuutiRirekiMeisaiHokan.setHyoujiyoutuutisakuseiymd(syoriYmd);

                BizPropertyInitializer.initialize(tuutiRirekiMeisaiHokan);

                tuutirirekiMeisaiHokanInserter.add(tuutiRirekiMeisaiHokan);

                syoriKns++;
            }

            bzRecoveryDatasikibetuBean.initializeBlank();
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(syoriKns)));
    	
        batchLogger.info(MessageUtil.getMessage(MessageId.IBC1026, heisoukbn));

    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery = SWAKInjector
            .getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }
}
