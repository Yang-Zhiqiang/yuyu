package yuyu.batch.hozen.khinterf.khmizuhodrtenminyuukykdtlfsks;

import java.math.BigDecimal;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.util.string.ConvertUtil;
import yuyu.batch.hozen.khinterf.khmizuhodrtenminyuukykdtlfsks.dba.KhMizuhoDrtenMinyuuKykDtlFSksDao;
import yuyu.batch.hozen.khinterf.khmizuhodrtenminyuukykdtlfsks.dba.MizuhoMinyuuDtlBean;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.BzKbnHenkanUtil;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_SystemRenkeiHenkanHoukouKbn;
import yuyu.def.db.entity.ZT_DrtenMisyuSkInfoDataTy;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 契約保全 インターフェイス みずほ代理店未入契約明細Ｆ作成
 */
public class KhMizuhoDrtenMinyuuKykDtlFSksBatch implements Batch {

    public static String TYSYTTAISYOUTABLEID = "IT_SeihowebMizuhoMinyuuDtl";

    public static String RECOVERYFILTERID = "Kh001";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam batchParam;

    @Inject
    private KhMizuhoDrtenMinyuuKykDtlFSksDao KhMizuhoDrtenMinyuuKykDtlFSksDao;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Override
    public BatchParam getParam() {
        return batchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        long kensu = 0;

        String kakutyoujobcd = batchParam.getIbKakutyoujobcd();

        BizDate syoriYmd = batchParam.getSyoriYmd();

        batchLogger.info(
            MessageUtil.getMessage("IBA0016", MessageUtil.getMessage("IBW0003"), String.valueOf(syoriYmd)));

        batchLogger.info(MessageUtil.getMessage("IBA0016", MessageUtil.getMessage("IBW1018"), kakutyoujobcd));

        try (EntityInserter<ZT_DrtenMisyuSkInfoDataTy> entityInserter = new EntityInserter<ZT_DrtenMisyuSkInfoDataTy>();
            ExDBResults<MizuhoMinyuuDtlBean> mizuhoMinyuuDtlBeanLst = KhMizuhoDrtenMinyuuKykDtlFSksDao
                .getMizuhoMinyuuDtlBeans(kakutyoujobcd, syoriYmd.getBizDateYM())) {

            for (MizuhoMinyuuDtlBean mizuhoMinyuuDtlBean : mizuhoMinyuuDtlBeanLst) {

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(kakutyoujobcd);
                bzRecoveryDatasikibetuBean.setIbTableid(TYSYTTAISYOUTABLEID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(RECOVERYFILTERID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(mizuhoMinyuuDtlBean.getKbnkey());
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(mizuhoMinyuuDtlBean.getSyono());

                String kzhurikaebankcd = BizUtil.zeroNum(mizuhoMinyuuDtlBean.getBankcd(), 4, 0);

                String kzhurikaesitencd = BizUtil.zeroNum(mizuhoMinyuuDtlBean.getSitencd(), 3, 0);

                String kzhurikaekouzano = null;

                if (mizuhoMinyuuDtlBean.getKouzano().length() < 7) {

                    kzhurikaekouzano = BizUtil.zeroNum(mizuhoMinyuuDtlBean.getKouzano(), 7, 0);
                }
                else {

                    kzhurikaekouzano = mizuhoMinyuuDtlBean.getKouzano().substring(0, 7);
                }

                String kzhurikaemeiginm = ConvertUtil.toHanAll(mizuhoMinyuuDtlBean.getKzmeiginmkn(), 0, 1);

                BzKbnHenkanUtil bzKbnHenkanUtil = SWAKInjector.getInstance(BzKbnHenkanUtil.class);

                String haraikomikaisukbn = bzKbnHenkanUtil.convKbn(mizuhoMinyuuDtlBean.getHrkkaisuu().getValue(),
                    C_Hrkkaisuu.class, C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER).getKbnData();

                ZT_DrtenMisyuSkInfoDataTy drtenMisyuSkInfoDataTy = new ZT_DrtenMisyuSkInfoDataTy();

                drtenMisyuSkInfoDataTy.setZtysyono(mizuhoMinyuuDtlBean.getSyono());
                drtenMisyuSkInfoDataTy.setZtybsydrtencd(mizuhoMinyuuDtlBean.getDrtencd());
                drtenMisyuSkInfoDataTy.setZtykykymd(String.valueOf(mizuhoMinyuuDtlBean.getKeiyakuymd()));
                drtenMisyuSkInfoDataTy.setZtyknjhhknmei(mizuhoMinyuuDtlBean.getHhknnmkj());
                drtenMisyuSkInfoDataTy.setZtykykjyutikbn(mizuhoMinyuuDtlBean.getKykjyutikbn());
                drtenMisyuSkInfoDataTy.setZtytsinkihontikucd(mizuhoMinyuuDtlBean.getTsinkihontikucd());
                drtenMisyuSkInfoDataTy.setZtykanjitsinkaiadr(mizuhoMinyuuDtlBean.getKanjitsinkaiadr());
                drtenMisyuSkInfoDataTy.setZtytsintelno(mizuhoMinyuuDtlBean.getTsintelno());
                drtenMisyuSkInfoDataTy.setZtydai2tsintelno(mizuhoMinyuuDtlBean.getDai2tsintelno());
                drtenMisyuSkInfoDataTy.setZtykzhurikaebankcd(kzhurikaebankcd);
                drtenMisyuSkInfoDataTy.setZtykzhurikaesitencd(kzhurikaesitencd);
                drtenMisyuSkInfoDataTy.setZtykzhurikaeyokinkbn(mizuhoMinyuuDtlBean.getYokinkbn().getValue());
                drtenMisyuSkInfoDataTy.setZtykzhurikaekouzano(kzhurikaekouzano);
                drtenMisyuSkInfoDataTy.setZtykzhurikaemeiginm(kzhurikaemeiginm);
                drtenMisyuSkInfoDataTy.setZtyhrkkaisuukbn(haraikomikaisukbn);
                drtenMisyuSkInfoDataTy.setZty1kaip(
                    new BigDecimal(mizuhoMinyuuDtlBean.getHrkp().toAdsoluteString()).longValue());
                drtenMisyuSkInfoDataTy.setZtynexthurikaeyoteigk(
                    new BigDecimal(mizuhoMinyuuDtlBean.getJkiannaikg().toAdsoluteString()).longValue());
                drtenMisyuSkInfoDataTy.setZtyhrkyykknmnryymd(String.valueOf(mizuhoMinyuuDtlBean.getYykknmnryymd()));
                if (mizuhoMinyuuDtlBean.getSkymd() != null) {
                    drtenMisyuSkInfoDataTy.setZtyskymd(String.valueOf(mizuhoMinyuuDtlBean.getSkymd()));
                }
                drtenMisyuSkInfoDataTy.setZtyjhurikstkkahikbn(mizuhoMinyuuDtlBean.getJhurikstkkahikbn());
                drtenMisyuSkInfoDataTy.setZtyhukkatumoskahikbn(mizuhoMinyuuDtlBean.getHukkatumoskahikbn());
                if (mizuhoMinyuuDtlBean.getTtdkkigenymd() != null) {
                    drtenMisyuSkInfoDataTy.setZtyttdkkigenymd(String.valueOf(mizuhoMinyuuDtlBean.getTtdkkigenymd()));
                }
                if (mizuhoMinyuuDtlBean.getHukkatukanoukknmnryymd() != null) {
                    drtenMisyuSkInfoDataTy.setZtyhukkatukanoukknmnryymd(
                        String.valueOf(mizuhoMinyuuDtlBean.getHukkatukanoukknmnryymd()));
                }
                drtenMisyuSkInfoDataTy.setZtykeikatukisuu3keta(String.valueOf(mizuhoMinyuuDtlBean.getKeikamon3keta()));
                drtenMisyuSkInfoDataTy.setZtymisyuuhasseiym(String.valueOf(mizuhoMinyuuDtlBean.getMisyuuhasseiym()));
                drtenMisyuSkInfoDataTy.setZtymisyuujiyuu(mizuhoMinyuuDtlBean.getMisyuujiyuu());
                drtenMisyuSkInfoDataTy.setZtyhanteiymd(String.valueOf(mizuhoMinyuuDtlBean.getMinyusyoriymd()));
                drtenMisyuSkInfoDataTy.setZtynexthurikaeymd(String.valueOf(mizuhoMinyuuDtlBean.getNexthurikaeymd()));
                drtenMisyuSkInfoDataTy.setZtyikkatubaraikbn(mizuhoMinyuuDtlBean.getIkkatubaraikbn().getValue());
                drtenMisyuSkInfoDataTy.setZtyikkatubaraikaisuu(mizuhoMinyuuDtlBean.getIkkatubaraikaisuu().getValue());

                if (mizuhoMinyuuDtlBean.getKyknm35keta().length() > 15) {

                    drtenMisyuSkInfoDataTy.setZtyhnsyugknjkyksynm(
                        mizuhoMinyuuDtlBean.getKyknm35keta().substring(0, 15));
                }
                else {

                    drtenMisyuSkInfoDataTy.setZtyhnsyugknjkyksynm(mizuhoMinyuuDtlBean.getKyknm35keta());
                }

                BizPropertyInitializer.initialize(drtenMisyuSkInfoDataTy);

                entityInserter.add(drtenMisyuSkInfoDataTy);

                kensu = kensu + 1;
            }
        }
        bzRecoveryDatasikibetuBean.initializeBlank();

        batchLogger.info(MessageUtil.getMessage("IBF0001", String.valueOf(kensu)));
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery = SWAKInjector.getInstance(
            BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }
}