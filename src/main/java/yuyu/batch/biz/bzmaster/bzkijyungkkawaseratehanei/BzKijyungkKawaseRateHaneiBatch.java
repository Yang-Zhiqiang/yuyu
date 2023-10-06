package yuyu.batch.biz.bzmaster.bzkijyungkkawaseratehanei;

import java.math.RoundingMode;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateSpan;
import jp.co.slcs.swak.date.BizDateY;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.date.CHolidayAdjustingMode;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.message.MessageUtil;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.DateFormatUtil;
import yuyu.common.biz.bzcommon.GetKawaseRate;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.report.BzTuusanKawaseRateKakuninBean;
import yuyu.def.biz.bean.report.BzTuusanKawaseRateKakuninDataSourceBean;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_EigyoubiHoseiKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_KawaserateSyuruiKbn;
import yuyu.def.classification.C_KawasetekiyoKbn;
import yuyu.def.classification.C_KawasetsryKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BM_KijyungkHanteiKawaseRate;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;

import com.google.common.collect.Lists;

/**
 * 業務共通 マスタメンテナンス 基準額判定用為替レート反映
 * 基準額判定用為替レートマスタを反映し、通算判定用為替レート確認書を作成するバッチクラス
 */
public class BzKijyungkKawaseRateHaneiBatch implements Batch {


    @Inject
    private BatchLogger batchLogger;

    @Inject
    private static Logger logger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private AS_Kinou kinou;

    private C_ErrorKbn getErrorFlg = C_ErrorKbn.OK;

    private GetKawaseRate getKawaseRate;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016,
                MessageUtil.getMessage(MessageId.IBW0003),
                bzBatchParam.getSyoriYmd().toString()));

        BizDateY kijyunY = bzBatchParam.getSyoriYmd().getBizDateY();
        List<IReportDataSouceBean> bzTuusanKawaseRateKakuninDataSourceBeanList =
                Lists.newArrayList();
        BizNumber usdKawaserateSum = BizNumber.ZERO;
        BizNumber audKawaserateSum = BizNumber.ZERO;
        BizDateYM kaisiYM = BizDateYM.valueOf(kijyunY.getPreviousYear(),
                BzKijyungkKawaseRateHaneiBatchConstants.NENDO_KAISI_MONTH);

        BizDateYM zenendoYM = null;
        BizDate zennendoYmKaisiYMD = null;
        BizDate zenendoGsFsteigyouYMD = null;
        BizNumber kawaserate1 = BizNumber.ZERO;
        BizNumber kawaserate2 = BizNumber.ZERO;

        getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);

        for(int i=0; i < BzKijyungkKawaseRateHaneiBatchConstants.KEISAN_KIKAN; i++) {

            BzTuusanKawaseRateKakuninDataSourceBean bzTuusanKawaseRateKakuninDataSourceBean =
                    SWAKInjector.getInstance(BzTuusanKawaseRateKakuninDataSourceBean.class);

            zenendoYM = kaisiYM.add(new BizDateSpan(0, i, 0));
            zennendoYmKaisiYMD = zenendoYM.getFirstDay();
            zenendoGsFsteigyouYMD = zennendoYmKaisiYMD.getBusinessDay(CHolidayAdjustingMode.NEXT);

            kawaserate1 = getKawaserate(zenendoGsFsteigyouYMD,C_Tuukasyu.USD);

            kawaserate2 = getKawaserate(zenendoGsFsteigyouYMD,C_Tuukasyu.AUD);

            if (getErrorFlg.eq(C_ErrorKbn.OK)) {
                bzTuusanKawaseRateKakuninDataSourceBean.setIrZennendogseigyouymd(zenendoGsFsteigyouYMD);
                bzTuusanKawaseRateKakuninDataSourceBean.setIrKwsrate1(kawaserate1);
                bzTuusanKawaseRateKakuninDataSourceBean.setIrKwsrate2(kawaserate2);

                usdKawaserateSum = usdKawaserateSum.add(kawaserate1);
                audKawaserateSum = audKawaserateSum.add(kawaserate2);

                bzTuusanKawaseRateKakuninDataSourceBeanList.add(bzTuusanKawaseRateKakuninDataSourceBean);
            }
        }

        if (getErrorFlg.eq(C_ErrorKbn.ERROR)) {
            throw new BizAppException(MessageId.EAS0027);
        }

        BizNumber tsnhntiyuKawaserate1 = usdKawaserateSum.divide(bzTuusanKawaseRateKakuninDataSourceBeanList.size(),
                2,RoundingMode.UP);
        BizNumber tsnhntiyuKawaserate2 = audKawaserateSum.divide(bzTuusanKawaseRateKakuninDataSourceBeanList.size(),
                2,RoundingMode.UP);

        BizDate nendoYmd = (BizDate.valueOf(kijyunY,
                BzKijyungkKawaseRateHaneiBatchConstants.NENDO_KAISI_MONTH,
                BzKijyungkKawaseRateHaneiBatchConstants.NENDO_KAISI_DAY));

        logger.info(String.format("%s通算判定用為替レート  米円換算＝%s  豪円換算＝%s",
                DateFormatUtil.dateYKANJIWarekiNendo(nendoYmd),
                BizUtil.comma(tsnhntiyuKawaserate1.toString(), BizUtil.ZERO_FILL, 2),
                BizUtil.comma(tsnhntiyuKawaserate2.toString(), BizUtil.ZERO_FILL, 2)));

        BzTuusanKawaseRateKakuninBean bzTuusanKawaseRateKakuninBean =
                SWAKInjector.getInstance(BzTuusanKawaseRateKakuninBean.class);

        bzTuusanKawaseRateKakuninBean.setIrSyoribi(bzBatchParam.getSyoriYmd());
        bzTuusanKawaseRateKakuninBean.setIrNendoymd(nendoYmd);
        bzTuusanKawaseRateKakuninBean.setIrTsnhntiyukawaserate1(tsnhntiyuKawaserate1);
        bzTuusanKawaseRateKakuninBean.setIrTsnhntiyukawaserate2(tsnhntiyuKawaserate2);

        insertKijyungkHanteiKawaseRate(bzTuusanKawaseRateKakuninBean);

        makeReport(bzTuusanKawaseRateKakuninBean, bzTuusanKawaseRateKakuninDataSourceBeanList);

    }


    private BizNumber getKawaserate(BizDate pKawaserateKijyunymd, C_Tuukasyu pMototuuka) {

        C_ErrorKbn kekka = getKawaseRate.exec(pKawaserateKijyunymd,
                C_KawaserateSyuruiKbn.PM17JIKAWASERATE,
                pMototuuka,
                C_Tuukasyu.JPY,
                C_KawasetekiyoKbn.TTM,
                C_KawasetsryKbn.JISSEIRATE,
                C_EigyoubiHoseiKbn.BLNK,
                C_YouhiKbn.HUYOU);

        if (kekka.eq(C_ErrorKbn.ERROR)) {
            batchLogger.error(MessageUtil.getMessage(MessageId.EBF1021,
                    DateFormatUtil.dateKANJISeireki(pKawaserateKijyunymd),
                    pMototuuka.getContent(),
                    C_Tuukasyu.JPY.getContent()));

            getErrorFlg = C_ErrorKbn.ERROR;

            return BizNumber.ZERO;
        }

        return getKawaseRate.getKawaserate();
    }

    @Transactional
    private void insertKijyungkHanteiKawaseRate(BzTuusanKawaseRateKakuninBean pBean) {

        List<BM_KijyungkHanteiKawaseRate> kijyungkHanteiKawaseRateList = Lists.newArrayList();
        BM_KijyungkHanteiKawaseRate kijyungkHanteiKawaseRate1 = new BM_KijyungkHanteiKawaseRate();
        BM_KijyungkHanteiKawaseRate kijyungkHanteiKawaseRate2 = new BM_KijyungkHanteiKawaseRate();

        kijyungkHanteiKawaseRate1.setKijunnendo(bzBatchParam.getSyoriYmd().getBizDateY().toString());
        kijyungkHanteiKawaseRate1.setKyktuukasyu(C_Tuukasyu.USD);
        kijyungkHanteiKawaseRate1.setKjngkhntiyukawaserate(pBean.getIrTsnhntiyukawaserate1());

        kijyungkHanteiKawaseRateList.add(kijyungkHanteiKawaseRate1);

        kijyungkHanteiKawaseRate2.setKijunnendo(bzBatchParam.getSyoriYmd().getBizDateY().toString());
        kijyungkHanteiKawaseRate2.setKyktuukasyu(C_Tuukasyu.AUD);
        kijyungkHanteiKawaseRate2.setKjngkhntiyukawaserate(pBean.getIrTsnhntiyukawaserate2());

        kijyungkHanteiKawaseRateList.add(kijyungkHanteiKawaseRate2);

        for (BM_KijyungkHanteiKawaseRate kijyungkHanteiKawaseRate :kijyungkHanteiKawaseRateList){
            BizPropertyInitializer.initialize(kijyungkHanteiKawaseRate);
        }

        bizDomManager.insert(kijyungkHanteiKawaseRateList);
    }

    private void makeReport(BzTuusanKawaseRateKakuninBean pBean,
            List<IReportDataSouceBean> pDataSourceBeanList) {

        C_SyoruiCdKbn syoruiCdKbn = C_SyoruiCdKbn.CM_TUUSANKAWASERATEKAKUNIN;
        CreateReport createReport = SWAKInjector.getInstance(CreateReport.class);

        ReportServicesBean reportServicesBean =
                createReport.createNewReportServiceBean(kinou.getSubSystemId(),
                        kinou.getCategoryId(),
                        kinou.getKinouId(),
                        syoruiCdKbn);

        reportServicesBean.setSyoriYmd(bzBatchParam.getSyoriYmd());

        reportServicesBean.addParamObjects(syoruiCdKbn, pDataSourceBeanList, pBean);
        createReport.execNoCommit(reportServicesBean);
    }
}
