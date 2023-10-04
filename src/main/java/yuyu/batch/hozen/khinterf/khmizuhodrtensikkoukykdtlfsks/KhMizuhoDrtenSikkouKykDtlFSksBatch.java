package yuyu.batch.hozen.khinterf.khmizuhodrtensikkoukykdtlfsks;

import java.math.BigDecimal;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.util.string.ConvertUtil;
import yuyu.batch.hozen.khinterf.khmizuhodrtensikkoukykdtlfsks.dba.KhMizuhoDrtenSikkouKykDtlFSksDao;
import yuyu.batch.hozen.khinterf.khmizuhodrtensikkoukykdtlfsks.dba.PMinyuuSyoumetuInfoBean;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.BzKbnHenkanUtil;
import yuyu.common.biz.bzcommon.KbnInfoBean;
import yuyu.common.biz.bzdairiten.BzGetAgInfo;
import yuyu.common.biz.bzdairiten.BzGetAgInfoBean;
import yuyu.common.hozen.ascommon.AnsyuuBatSyoriHunoKykMisslistSks;
import yuyu.common.hozen.ascommon.KeisanRsgaku;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_DiritenjyouhouKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_IkkatubaraiKaisuuKbn;
import yuyu.def.classification.C_IkkatubaraiKbn;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_SystemRenkeiHenkanHoukouKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_HhknSya;
import yuyu.def.db.entity.IT_Kouza;
import yuyu.def.db.entity.IT_KykDairiten;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_PMinyuuSyoumetuInfo;
import yuyu.def.db.entity.ZT_DrtenMisyuSkInfoDataTy;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 契約保全 インターフェイス みずほ代理店失効契約明細Ｆ作成クラス
 */
public class KhMizuhoDrtenSikkouKykDtlFSksBatch implements Batch {

    public static final String TYSYTTAISYOUTABLEID = IT_PMinyuuSyoumetuInfo.TABLE_NAME;

    public static final String RECOVERYFILTERID = "Kh001";

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private KhMizuhoDrtenSikkouKykDtlFSksDao khMizuhoDrtenSikkouKykDtlFSksDao;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

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

        BizDateYM syoriYm = bzBatchParam.getSyoriYmd().getBizDateYM();

        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector
            .getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);

        ansyuuBatSyoriHunoKykMisslistSks.setErrerLimit(10);

        try (ExDBResults<PMinyuuSyoumetuInfoBean> pMinyuuSyoumetuInfoBeanLst =
            khMizuhoDrtenSikkouKykDtlFSksDao.getPMinyuuSyoumetuInfoBeans(bzBatchParam.getIbKakutyoujobcd(), syoriYm);
            EntityInserter<ZT_DrtenMisyuSkInfoDataTy> entityInserter = new EntityInserter<ZT_DrtenMisyuSkInfoDataTy>();) {

            for (PMinyuuSyoumetuInfoBean pMinyuuSyoumetuInfoBean : pMinyuuSyoumetuInfoBeanLst) {

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(bzBatchParam.getIbKakutyoujobcd());
                bzRecoveryDatasikibetuBean.setIbTableid(TYSYTTAISYOUTABLEID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(RECOVERYFILTERID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(pMinyuuSyoumetuInfoBean.getKbnkey());
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(pMinyuuSyoumetuInfoBean.getSyono());


                IT_KykKihon kykKihon = hozenDomManager.getKykKihon(pMinyuuSyoumetuInfoBean.getSyono());

                BzKbnHenkanUtil bzKbnHenkanUtil = SWAKInjector.getInstance(BzKbnHenkanUtil.class);

                KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(
                    kykKihon.getHrkkaisuu().getValue(),
                    C_Hrkkaisuu.class,
                    C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER);

                String kbnData = kbnInfoBean.getKbnData();


                List<IT_KykSyouhn> kykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

                IT_KykSyouhn kykSyouhn = kykSyouhnLst.get(0);


                IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon(kykKihon.getSyono());


                BizCurrency hrkp = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                int jyuutouNensuu = 0;
                int jyuutouTukisuu =0;
                C_Nykkeiro nykkeiro = C_Nykkeiro.BLNK;
                KeisanRsgaku keisanRsgaku = SWAKInjector.getInstance(KeisanRsgaku.class);

                if (C_Hrkkaisuu.TUKI.eq(kykKihon.getHrkkaisuu())) {

                    if (C_TkiktbrisyuruiKbn.BLNK.eq(kykKihon.getTikiktbrisyuruikbn()) ||
                        C_TkiktbrisyuruiKbn.NONE.eq(kykKihon.getTikiktbrisyuruikbn())) {

                        jyuutouNensuu = 0;
                        jyuutouTukisuu = Integer.valueOf(kykKihon.getHrkkaisuu().getValue());
                    }
                    else if (C_TkiktbrisyuruiKbn.TEIKI_6MONTHS.eq(kykKihon.getTikiktbrisyuruikbn()) ||
                        C_TkiktbrisyuruiKbn.TEIKI_12MONTHS.eq(kykKihon.getTikiktbrisyuruikbn())) {

                        jyuutouNensuu = 0;
                        jyuutouTukisuu = Integer.valueOf(kykKihon.getTikiktbrisyuruikbn().getValue());
                    }
                }
                else if (C_Hrkkaisuu.NEN.eq(kykKihon.getHrkkaisuu())) {

                    jyuutouNensuu = 1;
                    jyuutouTukisuu = 0;
                }
                else if (C_Hrkkaisuu.HALFY.eq(kykKihon.getHrkkaisuu())) {

                    jyuutouNensuu = 0;
                    jyuutouTukisuu = Integer.valueOf(kykKihon.getHrkkaisuu().getValue());
                }

                if (C_Hrkkeiro.KOUHURI.eq(kykKihon.getHrkkeiro())) {

                    nykkeiro = C_Nykkeiro.KZHRK;
                }
                else if (C_Hrkkeiro.CREDIT.eq(kykKihon.getHrkkeiro())) {

                    nykkeiro = C_Nykkeiro.CREDIT;
                }

                C_ErrorKbn errorKbn = keisanRsgaku.exec(
                    kykKihon,
                    nykkeiro,
                    C_NyknaiyouKbn.KEIZOKUP,
                    pMinyuuSyoumetuInfoBean.getSyoumetuymd(),
                    ansyuKihon.getJkipjytym(),
                    jyuutouNensuu,
                    jyuutouTukisuu);

                if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                    ansyuuBatSyoriHunoKykMisslistSks.addErrerMsg(kykKihon.getSyono(),
                        MessageUtil.getMessage(MessageId.EIA3055, keisanRsgaku.getErrorRiyuu()));

                    continue;
                }

                hrkp = keisanRsgaku.getKeisanRsgkOutBean().getRsgakuGoukei();


                C_IkkatubaraiKbn ikkatubaraikbn;
                C_IkkatubaraiKaisuuKbn ikkatubaraikaisuukbn;

                if (C_Hrkkaisuu.TUKI.eq(kykKihon.getHrkkaisuu()) &&
                    C_TkiktbrisyuruiKbn.TEIKI_6MONTHS.eq(kykKihon.getTikiktbrisyuruikbn())) {
                    ikkatubaraikbn = C_IkkatubaraiKbn.TEIKIIKKATU;

                    ikkatubaraikaisuukbn = C_IkkatubaraiKaisuuKbn.IKKATU6;
                }
                else if (C_Hrkkaisuu.TUKI.eq(kykKihon.getHrkkaisuu()) &&
                    C_TkiktbrisyuruiKbn.TEIKI_12MONTHS.eq(kykKihon.getTikiktbrisyuruikbn())) {
                    ikkatubaraikbn = C_IkkatubaraiKbn.TEIKIIKKATU;

                    ikkatubaraikaisuukbn = C_IkkatubaraiKaisuuKbn.IKKATU12;
                }
                else {
                    ikkatubaraikbn = C_IkkatubaraiKbn.BLNK;

                    ikkatubaraikaisuukbn = C_IkkatubaraiKaisuuKbn.BLNK;
                }


                IT_KykSya kykSya = kykKihon.getKykSya();


                IT_HhknSya hhknSya = kykKihon.getHhknSya();


                IT_Kouza kouza = null;

                String kzhurikaeBankcd = "0000";

                String kzhurikaeSitencd = "000";

                String kzhurikaeyokinKbn = C_YokinKbn.BLNK.getValue();

                String kzhurikaeKouzaNo = "0000000";

                String kzhurikaeMeigiNm = null;

                if (C_Hrkkeiro.KOUHURI.eq(kykKihon.getHrkkeiro())) {

                    kouza = kykKihon.getKouza();

                    kzhurikaeBankcd = BizUtil.zeroNum(kouza.getBankcd(), 4, 0);

                    kzhurikaeSitencd = BizUtil.zeroNum(kouza.getSitencd(), 3, 0);

                    kzhurikaeyokinKbn = kouza.getYokinkbn().getValue();

                    if (kouza.getKouzano().length() < 7) {

                        kzhurikaeKouzaNo = BizUtil.zeroNum(kouza.getKouzano(), 7, 0);
                    }
                    else {

                        kzhurikaeKouzaNo = kouza.getKouzano().substring(0, 7);
                    }

                    kzhurikaeMeigiNm = ConvertUtil.toHanAll(kouza.getKzmeiginmkn(), 0, 1);

                }


                String bsydrtenCd = null;

                List<IT_KykDairiten> kykDairitenLst = kykKihon.getKykDairitens();

                for (IT_KykDairiten kykDairiten : kykDairitenLst) {

                    BzGetAgInfo bzGetAgInfo = SWAKInjector.getInstance(BzGetAgInfo.class);

                    List<BzGetAgInfoBean> bzGetAgInfoBeanLst = bzGetAgInfo.exec(kykDairiten.getDrtencd());

                    for (BzGetAgInfoBean bzGetAgInfoBean : bzGetAgInfoBeanLst) {
                        if (C_DiritenjyouhouKbn.KEISYOUKO.eq(bzGetAgInfoBean.getDiritenJyouhouKbn())) {
                            bsydrtenCd = bzGetAgInfoBean.getDrtenCd();
                            break;
                        }
                    }

                    ZT_DrtenMisyuSkInfoDataTy drtenMisyuSkInfoDataTy = new ZT_DrtenMisyuSkInfoDataTy();

                    drtenMisyuSkInfoDataTy.setZtysyono(pMinyuuSyoumetuInfoBean.getSyono());
                    drtenMisyuSkInfoDataTy.setZtybsydrtencd(bsydrtenCd);
                    drtenMisyuSkInfoDataTy.setZtykykymd(String.valueOf(kykSyouhn.getKykymd()));
                    if (C_KjkhukaKbn.KJKHUKA.eq(kykSya.getKyknmkjkhukakbn())) {
                        if (kykSya.getKyknmkn().length() > 15) {

                            drtenMisyuSkInfoDataTy.setZtyhnsyugknjkyksynm(kykSya.getKyknmkn().substring(0, 15));
                        }
                        else {
                            drtenMisyuSkInfoDataTy.setZtyhnsyugknjkyksynm(kykSya.getKyknmkn());
                        }
                    }
                    else {
                        drtenMisyuSkInfoDataTy.setZtyhnsyugknjkyksynm(kykSya.getKyknmkj());
                    }
                    drtenMisyuSkInfoDataTy.setZtyknjhhknmei(hhknSya.getHhknnmkj());
                    drtenMisyuSkInfoDataTy.setZtykykjyutikbn("2");
                    drtenMisyuSkInfoDataTy.setZtytsinkihontikucd(kykSya.getTsinyno());
                    String ztykanjitsinkaiadr = kykSya.getTsinadr1kj() + kykSya.getTsinadr2kj() + kykSya.getTsinadr3kj();
                    if (ztykanjitsinkaiadr.length() > 62) {
                        ztykanjitsinkaiadr = ztykanjitsinkaiadr.substring(0, 62);
                    }
                    drtenMisyuSkInfoDataTy.setZtykanjitsinkaiadr(ztykanjitsinkaiadr);
                    drtenMisyuSkInfoDataTy.setZtytsintelno(kykSya.getTsintelno());
                    drtenMisyuSkInfoDataTy.setZtydai2tsintelno(kykSya.getDai2tsintelno());
                    drtenMisyuSkInfoDataTy.setZtykzhurikaebankcd(kzhurikaeBankcd);
                    drtenMisyuSkInfoDataTy.setZtykzhurikaesitencd(kzhurikaeSitencd);
                    drtenMisyuSkInfoDataTy.setZtykzhurikaeyokinkbn(kzhurikaeyokinKbn);
                    drtenMisyuSkInfoDataTy.setZtykzhurikaekouzano(kzhurikaeKouzaNo);
                    if (C_Hrkkeiro.KOUHURI.eq(kykKihon.getHrkkeiro())) {
                        drtenMisyuSkInfoDataTy.setZtykzhurikaemeiginm(kzhurikaeMeigiNm);
                    }
                    drtenMisyuSkInfoDataTy.setZtyhrkkaisuukbn(kbnData);
                    drtenMisyuSkInfoDataTy.setZty1kaip(new BigDecimal(hrkp.toAdsoluteString()).longValue());
                    drtenMisyuSkInfoDataTy.setZtyskymd(String.valueOf(pMinyuuSyoumetuInfoBean.getSyoumetuymd()));
                    drtenMisyuSkInfoDataTy.setZtyjhurikstkkahikbn("2");
                    drtenMisyuSkInfoDataTy.setZtyhukkatumoskahikbn("2");
                    drtenMisyuSkInfoDataTy.setZtyttdkkigenymd(String.valueOf(pMinyuuSyoumetuInfoBean.
                        getSyoumetuymd().getBizDateYM().getLastDay()));
                    drtenMisyuSkInfoDataTy.setZtykeikatukisuu3keta(String.valueOf(BizDateUtil.calcDifferenceMonths(
                        pMinyuuSyoumetuInfoBean.getSyoumetuymd().getBizDateYM(), kykSyouhn.getKykymd().getBizDateYM())));
                    drtenMisyuSkInfoDataTy.setZtymisyuuhasseiym(String.valueOf(syoriYm.getPreviousMonth()));
                    drtenMisyuSkInfoDataTy.setZtyhanteiymd(String.valueOf(pMinyuuSyoumetuInfoBean.getSyoriYmd()));
                    drtenMisyuSkInfoDataTy.setZtyikkatubaraikbn(ikkatubaraikbn.getValue());
                    drtenMisyuSkInfoDataTy.setZtyikkatubaraikaisuu(ikkatubaraikaisuukbn.getValue());

                    BizPropertyInitializer.initialize(drtenMisyuSkInfoDataTy);

                    entityInserter.add(drtenMisyuSkInfoDataTy);

                    syoriKensuu = syoriKensuu + 1;
                }
            }
            bzRecoveryDatasikibetuBean.initializeBlank();

            if (ansyuuBatSyoriHunoKykMisslistSks.hasMisslistMsg()) {

                KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

                ansyuuBatSyoriHunoKykMisslistSks.createReport(khozenCommonParam, bzBatchParam.getSyoriYmd());
            }

            batchLogger.info(MessageUtil.getMessage("IBF0001", String.valueOf(syoriKensuu)));
        }
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery = SWAKInjector.getInstance(
            BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }

}