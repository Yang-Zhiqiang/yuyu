package yuyu.batch.hozen.khzeimu.khgensenlistsakusei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.hozen.khzeimu.khgensenlistsakusei.dba.IT_KhShrRirekiInfoBean;
import yuyu.batch.hozen.khzeimu.khgensenlistsakusei.dba.KhGensenListSakuseiDao;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.BzGetSosikiData;
import yuyu.common.biz.bzcommon.BzGetSosikiDataBean;
import yuyu.common.biz.bzcommon.DateFormatUtil;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.biz.report.ViewReport;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_ShrsyoriKbn;
import yuyu.def.classification.C_SosikimasterUmuKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_TantouCdKbn;
import yuyu.def.classification.C_TodouhukenKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BM_TantouCd;
import yuyu.def.hozen.bean.report.KhGensenListBean;
import yuyu.def.hozen.bean.report.KhGensenListDataSourceBean;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;

/**
 * 契約保全 税務 源泉徴収リスト作成<br />
 *
 */
public class KhGensenListSakuseiBatch implements Batch {

    private static final String ERRMESSAGE = "想定外の支払処理区分を取得しています。";

    private static final String SHRSYORIKBN = "支払処理区分：";

    private static final String GOUKEI = "合計";

    private static final String ZERO_FOUR_KETA = "0000";

    private static final C_ShrsyoriKbn[] SAKUSEITAISYOU_SHRSYORIKBN = { C_ShrsyoriKbn.KAIYAKU,
        C_ShrsyoriKbn.GENGAKU, C_ShrsyoriKbn.DSEISANTUIBARAI};

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private KhGensenListSakuseiDao khGensenListSakuseiDao;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private CreateReport createReport;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        batchLogger.info(
            MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
                String.valueOf(bzBatchParam.getSyoriYmd())));
        batchLogger.info(
            MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW1018),
                bzBatchParam.getIbKakutyoujobcd()));

        String khShrRirekiId = "IT_KhShrRireki";
        String recoveryFilterId = "Kh001";
        String todouhukenCd = "";
        String todoufukenNm = "";
        BizCurrency shrSaekiGoukeigakuKenbetsu = BizCurrency.valueOf(0);
        BizCurrency kokuzeiGoukeigakuKenbetsu = BizCurrency.valueOf(0);
        BizCurrency tihouzeiGoukeigakuKenbetsu = BizCurrency.valueOf(0);
        Integer goukeiCountKenbetsu = 0;
        BizCurrency shrSaekiSougoukeigaku = BizCurrency.valueOf(0);
        BizCurrency kokuzeiSougoukeigaku = BizCurrency.valueOf(0);
        BizCurrency tihouzeiSougoukeigaku = BizCurrency.valueOf(0);
        Integer sougoukeiCount = 0;
        List<IReportDataSouceBean> iReportDataSouceBeanLst = new ArrayList<>();

        BizDate tyuusyutuStartDate = bzBatchParam.getSyoriYmd().getBizDateYM().getFirstDay();

        BizDate tyuusyutuEndDate = bzBatchParam.getSyoriYmd().getBizDateYM().getLastDay();

        try (
            ExDBResults<IT_KhShrRirekiInfoBean> khShrRirekiInfoBeanLst =
            khGensenListSakuseiDao.getKhShrRirekiInfo(bzBatchParam.getIbKakutyoujobcd(), tyuusyutuStartDate,
                tyuusyutuEndDate);) {

            for (IT_KhShrRirekiInfoBean khShrRirekiInfoBean : khShrRirekiInfoBeanLst) {

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(bzBatchParam.getIbKakutyoujobcd());
                bzRecoveryDatasikibetuBean.setIbTableid(khShrRirekiId);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(recoveryFilterId);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(khShrRirekiInfoBean.getKhShrRireki().getKbnkey());
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(khShrRirekiInfoBean.getKhShrRireki().getSyono());

                if (!todouhukenCd.equals(khShrRirekiInfoBean.getKhShrRireki().getNztodouhukencd())) {

                    if (sougoukeiCount != 0) {

                        KhGensenListDataSourceBean khGensenListDataSourceBean =
                            SWAKInjector.getInstance(KhGensenListDataSourceBean.class);

                        khGensenListDataSourceBean.setIrTodoufukenNm(todoufukenNm);
                        khGensenListDataSourceBean.setIrKinounm("");
                        khGensenListDataSourceBean.setIrShrymd("");
                        khGensenListDataSourceBean.setIrSyono("");
                        khGensenListDataSourceBean.setIrSaeki(BizCurrency.valueOf(0));
                        khGensenListDataSourceBean.setIrYengstszeigknationaltax(BizCurrency.valueOf(0));
                        khGensenListDataSourceBean.setIrYengstszeigklocaltax(BizCurrency.valueOf(0));
                        khGensenListDataSourceBean.setIrGoukeiinfotodouhuken(todoufukenNm + GOUKEI);
                        khGensenListDataSourceBean.setIrSaekigoukeitodouhuken(shrSaekiGoukeigakuKenbetsu);
                        khGensenListDataSourceBean.setIrYengstszeigktdhkkeikkzei(kokuzeiGoukeigakuKenbetsu);
                        khGensenListDataSourceBean.setIrYengstszeigktdhkkeithzei(tihouzeiGoukeigakuKenbetsu);
                        khGensenListDataSourceBean.setIrKensuugoukei(BizNumber.valueOf(goukeiCountKenbetsu));
                        khGensenListDataSourceBean.setIrGoukeiumukbntodouhuken(C_UmuKbn.ARI);
                        khGensenListDataSourceBean.setIrSaekisougoukei(BizCurrency.valueOf(0));
                        khGensenListDataSourceBean.setIrYengstszeigksoukeikkzei(BizCurrency.valueOf(0));
                        khGensenListDataSourceBean.setIrYengstszeigksoukeithzei(BizCurrency.valueOf(0));
                        khGensenListDataSourceBean.setIrKensuusougoukei(BizNumber.valueOf(0));
                        khGensenListDataSourceBean.setIrGoukeiumukbn(C_UmuKbn.NONE);

                        iReportDataSouceBeanLst.add(khGensenListDataSourceBean);

                        todouhukenCd = "";
                        shrSaekiGoukeigakuKenbetsu = BizCurrency.valueOf(0);
                        kokuzeiGoukeigakuKenbetsu = BizCurrency.valueOf(0);
                        tihouzeiGoukeigakuKenbetsu = BizCurrency.valueOf(0);
                        goukeiCountKenbetsu = 0;

                    }

                    todoufukenNm = C_TodouhukenKbn.getContentByValue(
                        firstZeroClear(khShrRirekiInfoBean.getKhShrRireki().getNztodouhukencd()));

                    todouhukenCd = khShrRirekiInfoBean.getKhShrRireki().getNztodouhukencd();
                }


                C_ShrsyoriKbn shrsyorikbn = khShrRirekiInfoBean.getKhShrRireki().getShrsyorikbn();

                if (!Arrays.asList(SAKUSEITAISYOU_SHRSYORIKBN).contains(shrsyorikbn)) {

                    throw new CommonBizAppException(
                        ERRMESSAGE + SHRSYORIKBN + shrsyorikbn);
                }

                String shrymdSeireki = DateFormatUtil.dateKANJISeireki(khShrRirekiInfoBean.getKhShrRireki()
                    .getShrymd());

                KhGensenListDataSourceBean khGensenListDataSourceBean =
                    SWAKInjector.getInstance(KhGensenListDataSourceBean.class);

                khGensenListDataSourceBean.setIrTodoufukenNm(todoufukenNm);
                khGensenListDataSourceBean.setIrKinounm(shrsyorikbn.getContent(C_ShrsyoriKbn.PATTERN_DEFAULT));
                khGensenListDataSourceBean.setIrShrymd(shrymdSeireki);
                khGensenListDataSourceBean.setIrSyono(khShrRirekiInfoBean.getKhShrRireki().getSyono());
                khGensenListDataSourceBean.setIrSaeki(khShrRirekiInfoBean.getKhShrRireki().getYenkztgk());
                khGensenListDataSourceBean.setIrYengstszeigknationaltax(
                    khShrRirekiInfoBean.getKhShrRireki().getYengstszeigknationaltax());
                khGensenListDataSourceBean.setIrYengstszeigklocaltax(
                    khShrRirekiInfoBean.getKhShrRireki().getYengstszeigklocaltax());
                khGensenListDataSourceBean.setIrGoukeiinfotodouhuken("");
                khGensenListDataSourceBean.setIrSaekigoukeitodouhuken(BizCurrency.valueOf(0));
                khGensenListDataSourceBean.setIrYengstszeigktdhkkeikkzei(BizCurrency.valueOf(0));
                khGensenListDataSourceBean.setIrYengstszeigktdhkkeithzei(BizCurrency.valueOf(0));
                khGensenListDataSourceBean.setIrKensuugoukei(BizNumber.valueOf(0));
                khGensenListDataSourceBean.setIrGoukeiumukbntodouhuken(C_UmuKbn.NONE);
                khGensenListDataSourceBean.setIrSaekisougoukei(BizCurrency.valueOf(0));
                khGensenListDataSourceBean.setIrYengstszeigksoukeikkzei(BizCurrency.valueOf(0));
                khGensenListDataSourceBean.setIrYengstszeigksoukeithzei(BizCurrency.valueOf(0));
                khGensenListDataSourceBean.setIrKensuusougoukei(BizNumber.valueOf(0));
                khGensenListDataSourceBean.setIrGoukeiumukbn(C_UmuKbn.NONE);

                iReportDataSouceBeanLst.add(khGensenListDataSourceBean);

                shrSaekiGoukeigakuKenbetsu = shrSaekiGoukeigakuKenbetsu.add(khShrRirekiInfoBean.getKhShrRireki().getYenkztgk());
                kokuzeiGoukeigakuKenbetsu = kokuzeiGoukeigakuKenbetsu.add(
                    khShrRirekiInfoBean.getKhShrRireki().getYengstszeigknationaltax());
                tihouzeiGoukeigakuKenbetsu = tihouzeiGoukeigakuKenbetsu.add(
                    khShrRirekiInfoBean.getKhShrRireki().getYengstszeigklocaltax());
                goukeiCountKenbetsu = goukeiCountKenbetsu + 1;
                shrSaekiSougoukeigaku = shrSaekiSougoukeigaku.add(khShrRirekiInfoBean.getKhShrRireki().getYenkztgk());
                kokuzeiSougoukeigaku = kokuzeiSougoukeigaku.add(
                    khShrRirekiInfoBean.getKhShrRireki().getYengstszeigknationaltax());
                tihouzeiSougoukeigaku = tihouzeiSougoukeigaku.add(
                    khShrRirekiInfoBean.getKhShrRireki().getYengstszeigklocaltax());
                sougoukeiCount = sougoukeiCount + 1;
            }

            bzRecoveryDatasikibetuBean.initializeBlank();

            if (sougoukeiCount != 0) {

                KhGensenListDataSourceBean khGensenListDataSourceBean =
                    SWAKInjector.getInstance(KhGensenListDataSourceBean.class);

                khGensenListDataSourceBean.setIrTodoufukenNm(todoufukenNm);
                khGensenListDataSourceBean.setIrKinounm("");
                khGensenListDataSourceBean.setIrShrymd("");
                khGensenListDataSourceBean.setIrSyono("");
                khGensenListDataSourceBean.setIrSaeki(BizCurrency.valueOf(0));
                khGensenListDataSourceBean.setIrYengstszeigknationaltax(BizCurrency.valueOf(0));
                khGensenListDataSourceBean.setIrYengstszeigklocaltax(BizCurrency.valueOf(0));
                khGensenListDataSourceBean.setIrGoukeiinfotodouhuken(todoufukenNm + GOUKEI);
                khGensenListDataSourceBean.setIrSaekigoukeitodouhuken(shrSaekiGoukeigakuKenbetsu);
                khGensenListDataSourceBean.setIrYengstszeigktdhkkeikkzei(kokuzeiGoukeigakuKenbetsu);
                khGensenListDataSourceBean.setIrYengstszeigktdhkkeithzei(tihouzeiGoukeigakuKenbetsu);
                khGensenListDataSourceBean.setIrKensuugoukei(BizNumber.valueOf(goukeiCountKenbetsu));
                khGensenListDataSourceBean.setIrGoukeiumukbntodouhuken(C_UmuKbn.ARI);
                khGensenListDataSourceBean.setIrSaekisougoukei(BizCurrency.valueOf(0));
                khGensenListDataSourceBean.setIrYengstszeigksoukeikkzei(BizCurrency.valueOf(0));
                khGensenListDataSourceBean.setIrYengstszeigksoukeithzei(BizCurrency.valueOf(0));
                khGensenListDataSourceBean.setIrKensuusougoukei(BizNumber.valueOf(0));
                khGensenListDataSourceBean.setIrGoukeiumukbn(C_UmuKbn.NONE);

                iReportDataSouceBeanLst.add(khGensenListDataSourceBean);

            }

            KhGensenListDataSourceBean khGensenListDataSourceBean =
                SWAKInjector.getInstance(KhGensenListDataSourceBean.class);

            khGensenListDataSourceBean.setIrTodoufukenNm("");
            khGensenListDataSourceBean.setIrKinounm("");
            khGensenListDataSourceBean.setIrShrymd("");
            khGensenListDataSourceBean.setIrSyono("");
            khGensenListDataSourceBean.setIrSaeki(BizCurrency.valueOf(0));
            khGensenListDataSourceBean.setIrYengstszeigknationaltax(BizCurrency.valueOf(0));
            khGensenListDataSourceBean.setIrYengstszeigklocaltax(BizCurrency.valueOf(0));
            khGensenListDataSourceBean.setIrGoukeiinfotodouhuken("");
            khGensenListDataSourceBean.setIrSaekigoukeitodouhuken(BizCurrency.valueOf(0));
            khGensenListDataSourceBean.setIrYengstszeigktdhkkeikkzei(BizCurrency.valueOf(0));
            khGensenListDataSourceBean.setIrYengstszeigktdhkkeithzei(BizCurrency.valueOf(0));
            khGensenListDataSourceBean.setIrKensuugoukei(BizNumber.valueOf(0));
            khGensenListDataSourceBean.setIrGoukeiumukbntodouhuken(C_UmuKbn.NONE);
            khGensenListDataSourceBean.setIrSaekisougoukei(shrSaekiSougoukeigaku);
            khGensenListDataSourceBean.setIrYengstszeigksoukeikkzei(kokuzeiSougoukeigaku);
            khGensenListDataSourceBean.setIrYengstszeigksoukeithzei(tihouzeiSougoukeigaku);
            khGensenListDataSourceBean.setIrKensuusougoukei(BizNumber.valueOf(sougoukeiCount));
            khGensenListDataSourceBean.setIrGoukeiumukbn(C_UmuKbn.ARI);

            iReportDataSouceBeanLst.add(khGensenListDataSourceBean);

            BM_TantouCd tantouCd = bizDomManager.getTantouCd(C_TantouCdKbn.KAIYAKU);

            BzGetSosikiData bzGetSosikiData = SWAKInjector.getInstance(BzGetSosikiData.class);

            BzGetSosikiDataBean bzGetSosikiDataBean = bzGetSosikiData.exec(tantouCd.getBusitucd() + ZERO_FOUR_KETA);

            String tantousituNm = "";

            if (C_SosikimasterUmuKbn.ARI.eq(bzGetSosikiDataBean.getSosikimasterumukbn())) {

                tantousituNm = bzGetSosikiDataBean.getKanjisosikinm20();
            }

            String hozonkkn = ViewReport.getHozonKknTani(C_SyoruiCdKbn.KK_GENSENLIST);

            String taisyouYmSeireki =DateFormatUtil.dateYmKANJI(bzBatchParam.getSyoriYmd().getBizDateYM());

            String shrymdSeireki = DateFormatUtil.dateKANJISeireki(bzBatchParam.getSyoriYmd());

            KhGensenListBean khGensenLstBean = SWAKInjector.getInstance(KhGensenListBean.class);

            khGensenLstBean.setIrTantsitunmkj(tantousituNm);
            khGensenLstBean.setIrSyoriymd(shrymdSeireki);
            khGensenLstBean.setIrGstsym(taisyouYmSeireki);
            khGensenLstBean.setIrKensuu(sougoukeiCount);
            khGensenLstBean.setIrHozonkkn(hozonkkn);

            ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(kinou.getSubSystemId(),
                kinou.getCategoryId(), kinou.getKinouId(), C_SyoruiCdKbn.KK_GENSENLIST);

            reportServicesBean.setSyoriYmd(bzBatchParam.getSyoriYmd());

            reportServicesBean.addParamObjects(iReportDataSouceBeanLst, khGensenLstBean);
            createReport.execNoCommit(reportServicesBean);

            batchLogger.info(MessageUtil.getMessage(MessageId.IAC0020, String.valueOf(sougoukeiCount)));
        }
    }

    private String firstZeroClear(String pVal) {
        int value = Integer.parseInt(pVal);
        return String.valueOf(value);
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }

}
