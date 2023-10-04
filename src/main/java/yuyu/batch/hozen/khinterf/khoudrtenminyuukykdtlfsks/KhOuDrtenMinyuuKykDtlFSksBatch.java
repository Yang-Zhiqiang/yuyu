package yuyu.batch.hozen.khinterf.khoudrtenminyuukykdtlfsks;

import java.math.BigDecimal;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.db.MultipleEntityInserter;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.hozen.khinterf.khoudrtenminyuukykdtlfsks.dba.DrtenMinyuKykNaiyouBean;
import yuyu.batch.hozen.khinterf.khoudrtenminyuukykdtlfsks.dba.KhOuDrtenMinyuuKykDtlFSksDao;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.BzKbnHenkanUtil;
import yuyu.common.biz.bzcommon.KbnInfoBean;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_HurihunoKbn;
import yuyu.def.classification.C_SystemRenkeiHenkanHoukouKbn;
import yuyu.def.db.entity.IT_DrtenMinyuKykNaiyou;
import yuyu.def.db.entity.ZT_DrtenMinyuuKykInfoTy;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

import com.google.common.base.Strings;

/**
 * 契約保全 インターフェイス ＯＵ代理店未入契約明細Ｆ作成
 */
public class KhOuDrtenMinyuuKykDtlFSksBatch implements Batch {

    private static final String TABLEID = IT_DrtenMinyuKykNaiyou.TABLE_NAME;

    private static final String FILTERID = "Kh001";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam khMisyuupTorikomiParam;

    @Inject
    private KhOuDrtenMinyuuKykDtlFSksDao khOuDrtenMinyuuKykDtlFSksDao;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Override
    public BatchParam getParam() {
        return khMisyuupTorikomiParam;
    }

    @Execute
    @Transactional
    public void execute() {

        BizDate syoriYmd = khMisyuupTorikomiParam.getSyoriYmd();

        String kakutyouJobcd = khMisyuupTorikomiParam.getIbKakutyoujobcd();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(
            MessageId.IBW0003), String.valueOf(syoriYmd)));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(
            MessageId.IBW1018), kakutyouJobcd));

        long kensu = 0;

        String mrariHyj = "";

        String keizokuTyuuihyj = "";

        try (
            MultipleEntityInserter inserter = new MultipleEntityInserter();

            ExDBResults<DrtenMinyuKykNaiyouBean> DrtenMinyuKykNaiyouBeanList =
                khOuDrtenMinyuuKykDtlFSksDao.getMisyuupRendoBean(kakutyouJobcd, syoriYmd.getBizDateYM());) {

            for (DrtenMinyuKykNaiyouBean drtenMinyuKykNaiyouBean : DrtenMinyuKykNaiyouBeanList) {

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(kakutyouJobcd);

                bzRecoveryDatasikibetuBean.setIbTableid(TABLEID);

                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(FILTERID);

                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(drtenMinyuKykNaiyouBean.getKbnkey());

                bzRecoveryDatasikibetuBean
                .setIbRecoveryfilterkey2(String.valueOf(drtenMinyuKykNaiyouBean.getSyono()));

                BzKbnHenkanUtil bzKbnHenkanUtil = SWAKInjector.getInstance(BzKbnHenkanUtil.class);

                KbnInfoBean hrkkaiSuuKbn = bzKbnHenkanUtil.convKbn(
                    drtenMinyuKykNaiyouBean.getHrkkaiSuu().getValue(), C_Hrkkaisuu.class,
                    C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER);

                KbnInfoBean hrkKeiroKbn = bzKbnHenkanUtil.convKbn(
                    drtenMinyuKykNaiyouBean.getHrkKeiro().getValue(), C_Hrkkeiro.class,
                    C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER);

                if (BizUtil.isBlank(drtenMinyuKykNaiyouBean.getMrariHyj())) {
                    mrariHyj = "0";
                }
                else {
                    mrariHyj = drtenMinyuKykNaiyouBean.getMrariHyj();
                }

                if (BizUtil.isBlank(drtenMinyuKykNaiyouBean.getKeizokuTyuuihyj())) {
                    keizokuTyuuihyj = "0";
                }
                else {
                    keizokuTyuuihyj = drtenMinyuKykNaiyouBean.getKeizokuTyuuihyj();
                }

                String syouhnnMkbn = Strings.padStart(drtenMinyuKykNaiyouBean.getSyouhnnMkbn(), 2, '0');

                C_HurihunoKbn ztykzhurikaehurihunoKbn = C_HurihunoKbn.BLNK;

                if(C_Hrkkeiro.KOUHURI.eq(drtenMinyuKykNaiyouBean.getHrkKeiro())){

                    ztykzhurikaehurihunoKbn = drtenMinyuKykNaiyouBean.getHuriHunoKbn();
                }

                else if(C_Hrkkeiro.CREDIT.eq(drtenMinyuKykNaiyouBean.getHrkKeiro())){

                    ztykzhurikaehurihunoKbn = C_HurihunoKbn.OTHER;
                }

                ZT_DrtenMinyuuKykInfoTy drtenMinyuuKykInfoTy = new ZT_DrtenMinyuuKykInfoTy(
                    drtenMinyuKykNaiyouBean.getSyono());

                drtenMinyuuKykInfoTy.setZtykykymd(String.valueOf(drtenMinyuKykNaiyouBean.getKeiyakuYmd()));

                drtenMinyuuKykInfoTy.setZtybsyym(String.valueOf(drtenMinyuKykNaiyouBean.getBosyuuYM()));

                drtenMinyuuKykInfoTy.setZtyhrkkaisuukbn(hrkkaiSuuKbn.getKbnData());

                drtenMinyuuKykInfoTy.setZtyhrkkeirokbn(hrkKeiroKbn.getKbnData());

                drtenMinyuuKykInfoTy.setZtysyuukeikbn(drtenMinyuKykNaiyouBean.getSyuuKeikbn());

                drtenMinyuuKykInfoTy.setZtyminyukaisuu(String.valueOf(drtenMinyuKykNaiyouBean.getMinyuKaisuu()));

                drtenMinyuuKykInfoTy.setZtymisyuup(new BigDecimal(
                    drtenMinyuKykNaiyouBean.getMisyuUp().toAdsoluteString()).longValue());

                drtenMinyuuKykInfoTy.setZtyhsys(new BigDecimal(
                    drtenMinyuKykNaiyouBean.getHsyS().toAdsoluteString()).longValue());

                drtenMinyuuKykInfoTy.setZtysyuuseis(new BigDecimal(
                    drtenMinyuKykNaiyouBean.getSyuuseiS().toAdsoluteString()).longValue());

                drtenMinyuuKykInfoTy.setZtyfukkatutyuuikbn(drtenMinyuKykNaiyouBean.getHukkatuTyuuiKbn());

                drtenMinyuuKykInfoTy.setZtymrarihyj(mrariHyj);

                drtenMinyuuKykInfoTy.setZtyfsttatekaekykhyj(drtenMinyuKykNaiyouBean.getFstttKekykhyj());

                drtenMinyuuKykInfoTy.setZtytatekaekjrenzokukaisu(String.valueOf(drtenMinyuKykNaiyouBean
                    .getTtkernzkKaisuu()));

                drtenMinyuuKykInfoTy.setZtykeizokutyuuihyouji(keizokuTyuuihyj);

                drtenMinyuuKykInfoTy.setZtysyouhinbunruikbn(drtenMinyuKykNaiyouBean.getSyouhinBunruiKbn());

                drtenMinyuuKykInfoTy.setZtysyouhnnmkbn(syouhnnMkbn);

                drtenMinyuuKykInfoTy.setZtyhknsyukigou(drtenMinyuKykNaiyouBean.getHknsyuKigou());

                drtenMinyuuKykInfoTy.setZtyjikaipjyuutouym(drtenMinyuKykNaiyouBean.getJkipjytYM().toString());

                drtenMinyuuKykInfoTy.setZtykzhurikaehurihunokbn(ztykzhurikaehurihunoKbn.getValue());

                drtenMinyuuKykInfoTy.setZtyautocalltaisyoukykhyj(drtenMinyuKykNaiyouBean.getAutocallKykhyj());

                drtenMinyuuKykInfoTy.setZtybsudirtnatkikeitaikbn(drtenMinyuKykNaiyouBean
                    .getBosyuudairiTenatkikeitaiKbn().getValue());

                drtenMinyuuKykInfoTy.setZtybsydrtencdx1(drtenMinyuKykNaiyouBean.getDairiTencd1());

                drtenMinyuuKykInfoTy.setZtybsydrtencdx2(drtenMinyuKykNaiyouBean.getDairiTencd2());

                drtenMinyuuKykInfoTy.setZtyikkatubaraikbn(drtenMinyuKykNaiyouBean.getIkkaTubaraiKbn().getValue());

                drtenMinyuuKykInfoTy.setZtyikkatubaraikaisuu(
                    drtenMinyuKykNaiyouBean.getIkkatubaraiKaiSuu().getValue());

                BizPropertyInitializer.initialize(drtenMinyuuKykInfoTy);

                inserter.add(drtenMinyuuKykInfoTy);

                kensu = kensu + 1;
            }

            bzRecoveryDatasikibetuBean.initializeBlank();

            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(kensu)));
        }
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery = SWAKInjector
            .getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }
}