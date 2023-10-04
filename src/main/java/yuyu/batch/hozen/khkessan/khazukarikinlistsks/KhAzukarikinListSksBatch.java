package yuyu.batch.hozen.khkessan.khazukarikinlistsks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import jp.co.slcs.swak.number.currencytype.CurrencyType;
import jp.co.slcs.swak.util.message.MessageUtil;
import lombok.Getter;
import lombok.Setter;
import yuyu.common.biz.bzcommon.BizEntityUtil;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.DateFormatUtil;
import yuyu.common.biz.bzcommon.GetKawaseRate;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.bzcommon.KeisanGaikakanzan;
import yuyu.common.biz.bzfiledl.BzFileUploadUtil;
import yuyu.common.biz.report.ViewReport;
import yuyu.common.hozen.khcommon.SetKessanNensibi;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_AzukarijikiKbn;
import yuyu.def.classification.C_AzukarikinBknkessanKbn;
import yuyu.def.classification.C_BknJkuKbn;
import yuyu.def.classification.C_BkncdKbn;
import yuyu.def.classification.C_EigyoubiHoseiKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_FileSyuruiCdKbn;
import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.classification.C_KawaserateSyuruiKbn;
import yuyu.def.classification.C_KawasetekiyoKbn;
import yuyu.def.classification.C_KawasetsryKbn;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.IT_AzukarikinKessankanri;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.hozen.bean.report.KhAzukarikinLstBean;
import yuyu.def.hozen.bean.report.KhAzukarikinLstDataSourceBean;
import yuyu.def.hozen.file.csv.KhAzukarikinLstCsvfFile;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;

/**
 * 契約保全 決算 預り金リスト作成
 */
public class KhAzukarikinListSksBatch implements Batch {

    private static final String TABLE_ID = IT_AzukarikinKessankanri.TABLE_NAME;

    private static final String RECOVERY_FILTER_ID = "Bz001";

    private static final String FLG_TYOUHYOUYEN = "flg_TyouHyouYen";

    private static final String FLG_TYOUHYOUGAIKADISPYEN = "flg_TyouHyouGaikaDispYen";

    private static final String FLG_TYOUHYOUGAIKADISPGAIKA = "flg_TyouHyouGaikaDispGaika";

    private static final String FLG_TYOUHYOUGOKEI = "flg_TyouHyouGoukei";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private KhAzukarikinListSksBatchParam khAzukarikinListSksBatchParam;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Override
    public BatchParam getParam() {

        return khAzukarikinListSksBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(
            MessageId.IBW0003), String.valueOf(khAzukarikinListSksBatchParam.getSyoriYmd())));

        try (ExDBResults<IT_AzukarikinKessankanri> azukarikinKessankanriLst = hozenDomManager.
            getKhAzukarikinKessankanrisByKakutyoujobcdKessankijyunymd(
                khAzukarikinListSksBatchParam.getIbKakutyoujobcd(), khAzukarikinListSksBatchParam.getKessanYmd())) {

            Map<String, String> mapHknSyruiKey = new TreeMap<String, String>();
            Map<String, KhAzukarikinListSksSyuukeiBean> mapYenkaKey = new HashMap<String, KhAzukarikinListSksSyuukeiBean>();
            Map<String, KhAzukarikinListSksSyuukeiBean> mapGaikaYenKey = new HashMap<String, KhAzukarikinListSksSyuukeiBean>();
            Map<String, KhAzukarikinListSksSyuukeiBean> mapGaikaDoruKey = new HashMap<String, KhAzukarikinListSksSyuukeiBean>();

            List<KhAzukarikinLstCsvfFile> khAzukarikinLstCsvfFileList = new ArrayList<KhAzukarikinLstCsvfFile>();

            long syoriKensuu = 0;
            String mapKey = "";
            KhAzukarikinLstBean khAzukarikinLstBean = createAzukarikinBikinHeaderTyouhyou(khAzukarikinListSksBatchParam.getKessanYmd());

            for (IT_AzukarikinKessankanri azukarikinKessankanri : azukarikinKessankanriLst) {

                azukarikinKessankanri.detach();

                IT_AzukarikinKessankanri azukarikinKessankanriTyouhyou = convertAzukarikinKessankanriTBL(khAzukarikinListSksBatchParam.getKessanYmd(), azukarikinKessankanri);

                IT_AzukarikinKessankanri azukarikinKessankanriCsv = azukarikinKessankanri;

                mapKey = azukarikinKessankanriTyouhyou.getKbnkeirisegcd().getValue();

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(khAzukarikinListSksBatchParam.getIbKakutyoujobcd());
                bzRecoveryDatasikibetuBean.setIbTableid(TABLE_ID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(RECOVERY_FILTER_ID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(azukarikinKessankanriTyouhyou.getSyono());

                if (!mapHknSyruiKey.containsKey(mapKey)) {

                    C_Segcd mstHknSyruiLevel = azukarikinKessankanri.getKbnkeirisegcd();

                    IT_KykKihon kykKihon = hozenDomManager.getKykKihon(azukarikinKessankanri.getSyono());

                    List<IT_KykSyouhn> kykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

                    IT_KykSyouhn kykSyouhn = kykSyouhnLst.get(0);

                    C_Tuukasyu mstTuukaSyu = kykSyouhn.getKyktuukasyu();

                    HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);

                    CurrencyType tuukaType = henkanTuuka.henkanTuukaKbnToType(mstTuukaSyu);

                    GetKawaseRate getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);

                    getKawaseRate.exec(
                        khAzukarikinListSksBatchParam.getKessanYmd(),
                        C_KawaserateSyuruiKbn.PM17JIKAWASERATE,
                        mstTuukaSyu,
                        C_Tuukasyu.JPY,
                        C_KawasetekiyoKbn.TTM,
                        C_KawasetsryKbn.JISSEIRATE,
                        C_EigyoubiHoseiKbn.ZENEIGYOUBI,
                        C_YouhiKbn.HUYOU);

                    mapHknSyruiKey.put(mapKey, getKawaseRate.getKawaserate().toString());

                    KhAzukarikinListSksSyuukeiBean yenKhAzukarikinListSksSyuukeiBean = new KhAzukarikinListSksSyuukeiBean(BizCurrencyTypes.YEN);
                    KhAzukarikinListSksSyuukeiBean gaikaYenKhAzukarikinListSksSyuukeiBean = new KhAzukarikinListSksSyuukeiBean(BizCurrencyTypes.YEN);
                    KhAzukarikinListSksSyuukeiBean gaikaKhAzukarikinListSksSyuukeiBean = new KhAzukarikinListSksSyuukeiBean(tuukaType);

                    yenKhAzukarikinListSksSyuukeiBean.setHknSyruiLevel(mstHknSyruiLevel);
                    yenKhAzukarikinListSksSyuukeiBean.setTuukaSyu(C_Tuukasyu.JPY);
                    gaikaYenKhAzukarikinListSksSyuukeiBean.setHknSyruiLevel(mstHknSyruiLevel);
                    gaikaYenKhAzukarikinListSksSyuukeiBean.setTuukaSyu(mstTuukaSyu);
                    gaikaKhAzukarikinListSksSyuukeiBean.setHknSyruiLevel(mstHknSyruiLevel);
                    gaikaKhAzukarikinListSksSyuukeiBean.setTuukaSyu(mstTuukaSyu);

                    mapYenkaKey.put(mapKey, yenKhAzukarikinListSksSyuukeiBean);
                    mapGaikaYenKey.put(mapKey, gaikaYenKhAzukarikinListSksSyuukeiBean);
                    mapGaikaDoruKey.put(mapKey, gaikaKhAzukarikinListSksSyuukeiBean);
                }

                if (C_Tuukasyu.JPY.eq(azukarikinKessankanriTyouhyou.getTuukasyu())) {
                    azukarikinBknSyuukei(mapYenkaKey.get(mapKey), azukarikinKessankanriTyouhyou);
                }
                else {
                    azukarikinBknSyuukei(mapGaikaYenKey.get(mapKey), azukarikinKessankanriTyouhyou);
                    azukarikinBknSyuukei(mapGaikaDoruKey.get(mapKey), azukarikinKessankanriTyouhyou);
                }

                khAzukarikinLstCsvfFileList.add(editKhAzukarikinLstCsvfFile(azukarikinKessankanriCsv));

                syoriKensuu = syoriKensuu + 1;
            }

            bzRecoveryDatasikibetuBean.initializeBlank();

            List<IReportDataSouceBean> khAzukarikinLstDataSourceBeanLst = new ArrayList<>();

            if (syoriKensuu > 0) {
                for (String hknSyruiKey : mapHknSyruiKey.keySet()) {
                    mapKey = hknSyruiKey;
                    String syoZokuKawaseRate = mapHknSyruiKey.get(mapKey);
                    KhAzukarikinListSksSyuukeiBean khAzukarikinListSksSyuukeiBean =
                        createAzukarikinBikinGokeiBean(mapYenkaKey.get(mapKey), mapGaikaYenKey.get(mapKey));

                    khAzukarikinLstDataSourceBeanLst.add(createAzukarikinBikinTyouhyou(mapYenkaKey.get(mapKey), syoZokuKawaseRate, FLG_TYOUHYOUYEN));
                    khAzukarikinLstDataSourceBeanLst.add(createAzukarikinBikinTyouhyou(mapGaikaDoruKey.get(mapKey), syoZokuKawaseRate, FLG_TYOUHYOUGAIKADISPGAIKA));
                    khAzukarikinLstDataSourceBeanLst.add(createAzukarikinBikinTyouhyou(mapGaikaYenKey.get(mapKey), syoZokuKawaseRate, FLG_TYOUHYOUGAIKADISPYEN));
                    khAzukarikinLstDataSourceBeanLst.add(createAzukarikinBikinTyouhyou(khAzukarikinListSksSyuukeiBean, syoZokuKawaseRate, FLG_TYOUHYOUGOKEI));
                }
            }
            else {
                KhAzukarikinListSksSyuukeiBean khAzukarikinListSksSyuukeiBean = new KhAzukarikinListSksSyuukeiBean(BizCurrencyTypes.YEN);
                khAzukarikinLstDataSourceBeanLst.add(createAzukarikinBikinTyouhyou(khAzukarikinListSksSyuukeiBean, "", ""));
            }

            CreateReport createReport = SWAKInjector.getInstance(CreateReport.class);

            ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(
                kinou.getSubSystemId(),
                kinou.getCategoryId(),
                kinou.getKinouId(),
                C_SyoruiCdKbn.KK_AZUKARIKINLIST);

            reportServicesBean.addParamObjects(khAzukarikinLstDataSourceBeanLst, khAzukarikinLstBean);
            reportServicesBean.setSyoriYmd(BizDate.getSysDate());

            createReport.execNoCommit(reportServicesBean);

            BzFileUploadUtil bzFileUploadUtil = SWAKInjector.getInstance(BzFileUploadUtil.class);
            C_ErrorKbn errorKbn = bzFileUploadUtil.exec(
                C_FileSyuruiCdKbn.KH_AZUKARIKINLSTCSVF,
                khAzukarikinLstCsvfFileList,
                true);

            if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                throw new BizAppException(MessageId.EBF0129, kinou.getKinouNm());
            }

            batchLogger.info(MessageUtil.getMessage(
                MessageId.IBF0002, String.valueOf(syoriKensuu), "<<預り金リスト作成>>"));
        }
    }

    private void azukarikinBknSyuukei(
        KhAzukarikinListSksSyuukeiBean pKhAzukarikinListSksSyuukeiBean, IT_AzukarikinKessankanri pAzukarikinKessankanri) {

        pKhAzukarikinListSksSyuukeiBean.setKawaseRate(pAzukarikinKessankanri.getKawaserate());

        if (C_Tuukasyu.JPY.equals(pKhAzukarikinListSksSyuukeiBean.getTuukaSyu())) {
            if (C_AzukarijikiKbn.TOUNEND.eq(pAzukarikinKessankanri.getAzukarijikikbn())) {
                pKhAzukarikinListSksSyuukeiBean.setTndAzukarikinGankin(
                    pKhAzukarikinListSksSyuukeiBean.getTndAzukarikinGankin().add(pAzukarikinKessankanri.getTounendgankin()));
                pKhAzukarikinListSksSyuukeiBean.setTndAzukarikinRsk(
                    pKhAzukarikinListSksSyuukeiBean.getTndAzukarikinRsk().add(pAzukarikinKessankanri.getTounendrsk()));
                pKhAzukarikinListSksSyuukeiBean.setTndAzukarikinShrgk(
                    pKhAzukarikinListSksSyuukeiBean.getTndAzukarikinShrgk().add(pAzukarikinKessankanri.getAzukarikinshrgk()));
                pKhAzukarikinListSksSyuukeiBean.setTndAzukarikinShrRskgk(
                    pKhAzukarikinListSksSyuukeiBean.getTndAzukarikinShrRskgk().add(pAzukarikinKessankanri.getAzukarikinshrrskgk()));
                pKhAzukarikinListSksSyuukeiBean.setTndBknkeiRskgk(
                    pKhAzukarikinListSksSyuukeiBean.getTndBknkeiRskgk().add(pAzukarikinKessankanri.getSinbikinkeirskgk()));
                pKhAzukarikinListSksSyuukeiBean.setTndSyoumetuUkeMishr(
                    pKhAzukarikinListSksSyuukeiBean.getTndSyoumetuUkeMishr().add(pAzukarikinKessankanri.getTounendsyoumetuukemishrgk()));
                pKhAzukarikinListSksSyuukeiBean.setTndAzukarikinrsksyukei(
                    pKhAzukarikinListSksSyuukeiBean.getTndAzukarikinrsksyukei().add(pAzukarikinKessankanri.getTounendrsksyukeisitu()));
            }
            else {
                pKhAzukarikinListSksSyuukeiBean.setZndAzukarikinGankin(
                    pKhAzukarikinListSksSyuukeiBean.getZndAzukarikinGankin().add(pAzukarikinKessankanri.getTounendgankin()));
                pKhAzukarikinListSksSyuukeiBean.setZndAzukarikinRsk(
                    pKhAzukarikinListSksSyuukeiBean.getZndAzukarikinRsk().add(pAzukarikinKessankanri.getTounendrsk()));
                pKhAzukarikinListSksSyuukeiBean.setZndAzukarikinShrgk(
                    pKhAzukarikinListSksSyuukeiBean.getZndAzukarikinShrgk().add(pAzukarikinKessankanri.getAzukarikinshrgk()));
                pKhAzukarikinListSksSyuukeiBean.setZndAzukarikinShrRskgk(
                    pKhAzukarikinListSksSyuukeiBean.getZndAzukarikinShrRskgk().add(pAzukarikinKessankanri.getAzukarikinshrrskgk()));
                pKhAzukarikinListSksSyuukeiBean.setZndBknkeiRskgk(
                    pKhAzukarikinListSksSyuukeiBean.getZndBknkeiRskgk().add(pAzukarikinKessankanri.getSinbikinkeirskgk()));
                pKhAzukarikinListSksSyuukeiBean.setZndSyoumetuUkeMishr(
                    pKhAzukarikinListSksSyuukeiBean.getZndSyoumetuUkeMishr().add(pAzukarikinKessankanri.getTounendsyoumetuukemishrgk()));
                pKhAzukarikinListSksSyuukeiBean.setZndAzukarikinrsksyukei(
                    pKhAzukarikinListSksSyuukeiBean.getZndAzukarikinrsksyukei().add(pAzukarikinKessankanri.getZennendrsksyukeisitu()));
            }
        }
        else {
            CurrencyType tukaType = pKhAzukarikinListSksSyuukeiBean.getTndAzukarikinGankin().getType();
            BizCurrency azukarikinGankin = BizCurrency.valueOf(0, tukaType);
            BizCurrency azukarikinRisoku = BizCurrency.valueOf(0, tukaType);
            BizCurrency azukarikinShrgk = BizCurrency.valueOf(0, tukaType);
            BizCurrency azukarikinShrRskgk = BizCurrency.valueOf(0, tukaType);
            BizCurrency bknkeiRskgk = BizCurrency.valueOf(0, tukaType);
            BizCurrency syoumetuMishr =  BizCurrency.valueOf(0, tukaType);
            BizCurrency tndAzukarikinrsksyukei =  BizCurrency.valueOf(0, tukaType);
            BizCurrency zndAzukarikinrsksyukei =  BizCurrency.valueOf(0, tukaType);

            if (BizCurrencyTypes.YEN.equals(tukaType)) {
                azukarikinGankin = pAzukarikinKessankanri.getTounendgankin();
                azukarikinRisoku = pAzukarikinKessankanri.getTounendrsk();

                if (C_YuukousyoumetuKbn.SYOUMETU.eq(pAzukarikinKessankanri.getYuukousyoumetukbn())
                    && C_BkncdKbn.BLNK.eq(pAzukarikinKessankanri.getBkncdkbn())) {
                    azukarikinShrgk = pAzukarikinKessankanri.getTounendgankin();
                    azukarikinShrRskgk = pAzukarikinKessankanri.getTounendrsk();
                }

                else if (C_BknJkuKbn.SINBI.eq(pAzukarikinKessankanri.getBknjkukbn())) {
                    bknkeiRskgk = pAzukarikinKessankanri.getTounendrsk();
                    syoumetuMishr = pAzukarikinKessankanri.getTounendgankin();
                }

                tndAzukarikinrsksyukei = pAzukarikinKessankanri.getTounendrsksyukeisitu();
                zndAzukarikinrsksyukei = pAzukarikinKessankanri.getZennendrsksyukeisitu();
            }
            else {
                azukarikinGankin = pAzukarikinKessankanri.getGaikatounendgankin();
                azukarikinRisoku = pAzukarikinKessankanri.getGaikatounendrsk();

                if (C_YuukousyoumetuKbn.SYOUMETU.eq(pAzukarikinKessankanri.getYuukousyoumetukbn())
                    && C_BkncdKbn.BLNK.eq(pAzukarikinKessankanri.getBkncdkbn())) {
                    azukarikinShrgk = pAzukarikinKessankanri.getGaikatounendgankin();
                    azukarikinShrRskgk = pAzukarikinKessankanri.getGaikatounendrsk();
                }

                else if (C_BknJkuKbn.SINBI.eq(pAzukarikinKessankanri.getBknjkukbn())) {
                    bknkeiRskgk = pAzukarikinKessankanri.getGaikatounendrsk();
                    syoumetuMishr = pAzukarikinKessankanri.getGaikatounendgankin();
                }
            }

            if (C_AzukarijikiKbn.TOUNEND.eq(pAzukarikinKessankanri.getAzukarijikikbn())) {
                pKhAzukarikinListSksSyuukeiBean.setTndAzukarikinGankin(
                    pKhAzukarikinListSksSyuukeiBean.getTndAzukarikinGankin().add(azukarikinGankin));
                pKhAzukarikinListSksSyuukeiBean.setTndAzukarikinRsk(
                    pKhAzukarikinListSksSyuukeiBean.getTndAzukarikinRsk().add(azukarikinRisoku));
                pKhAzukarikinListSksSyuukeiBean.setTndAzukarikinShrgk(
                    pKhAzukarikinListSksSyuukeiBean.getTndAzukarikinShrgk().add(azukarikinShrgk));
                pKhAzukarikinListSksSyuukeiBean.setTndAzukarikinShrRskgk(
                    pKhAzukarikinListSksSyuukeiBean.getTndAzukarikinShrRskgk().add(azukarikinShrRskgk));
                pKhAzukarikinListSksSyuukeiBean.setTndBknkeiRskgk(
                    pKhAzukarikinListSksSyuukeiBean.getTndBknkeiRskgk().add(bknkeiRskgk));
                pKhAzukarikinListSksSyuukeiBean.setTndSyoumetuUkeMishr(
                    pKhAzukarikinListSksSyuukeiBean.getTndSyoumetuUkeMishr().add(syoumetuMishr));
                pKhAzukarikinListSksSyuukeiBean.setTndAzukarikinrsksyukei(
                    pKhAzukarikinListSksSyuukeiBean.getTndAzukarikinrsksyukei().add(tndAzukarikinrsksyukei));
            }
            else {
                pKhAzukarikinListSksSyuukeiBean.setZndAzukarikinGankin(
                    pKhAzukarikinListSksSyuukeiBean.getZndAzukarikinGankin().add(azukarikinGankin));
                pKhAzukarikinListSksSyuukeiBean.setZndAzukarikinRsk(
                    pKhAzukarikinListSksSyuukeiBean.getZndAzukarikinRsk().add(azukarikinRisoku));
                pKhAzukarikinListSksSyuukeiBean.setZndAzukarikinShrgk(
                    pKhAzukarikinListSksSyuukeiBean.getZndAzukarikinShrgk().add(azukarikinShrgk));
                pKhAzukarikinListSksSyuukeiBean.setZndAzukarikinShrRskgk(
                    pKhAzukarikinListSksSyuukeiBean.getZndAzukarikinShrRskgk().add(azukarikinShrRskgk));
                pKhAzukarikinListSksSyuukeiBean.setZndBknkeiRskgk(
                    pKhAzukarikinListSksSyuukeiBean.getZndBknkeiRskgk().add(bknkeiRskgk));
                pKhAzukarikinListSksSyuukeiBean.setZndSyoumetuUkeMishr(
                    pKhAzukarikinListSksSyuukeiBean.getZndSyoumetuUkeMishr().add(syoumetuMishr));
                pKhAzukarikinListSksSyuukeiBean.setZndAzukarikinrsksyukei(
                    pKhAzukarikinListSksSyuukeiBean.getZndAzukarikinrsksyukei().add(zndAzukarikinrsksyukei));
            }
        }
    }

    private KhAzukarikinLstCsvfFile editKhAzukarikinLstCsvfFile(IT_AzukarikinKessankanri pAzukarikinKessankanri) {

        SetKessanNensibi setKessanNensibi = SWAKInjector.getInstance(SetKessanNensibi.class);

        BizDate kessanNensibi = setKessanNensibi.exec(pAzukarikinKessankanri.getKessankijyunymd());

        String kessanNen = DateFormatUtil.dateYKANJISeireki(kessanNensibi.getBizDateY()).concat("度");

        KhAzukarikinLstCsvfFile khAzukarikinLstCsvfFile = SWAKInjector.getInstance(KhAzukarikinLstCsvfFile.class);

        khAzukarikinLstCsvfFile.setIfcListnm("税制適格特約による預り金リスト");
        khAzukarikinLstCsvfFile.setIfcSakuseiymdseireki(convertDateFormat(BizDate.getSysDate()));
        khAzukarikinLstCsvfFile.setIfcKessannnd(kessanNen);
        khAzukarikinLstCsvfFile.setIfcHknsyuruilevel(pAzukarikinKessankanri.getKbnkeirisegcd().getContent());
        khAzukarikinLstCsvfFile.setIfcSegcd(pAzukarikinKessankanri.getKbnkeirisegcd().getValue());
        khAzukarikinLstCsvfFile.setIfcSyono(pAzukarikinKessankanri.getSyono());
        khAzukarikinLstCsvfFile.setIfcTuukasyu(pAzukarikinKessankanri.getTuukasyu().getValue());
        khAzukarikinLstCsvfFile.setIfcHnykbknjkukbn(pAzukarikinKessankanri.getBknjkukbn().getContent());
        khAzukarikinLstCsvfFile.setIfcSyoumetuymd(convertDateFormat(pAzukarikinKessankanri.getSyoumetuymd()));
        khAzukarikinLstCsvfFile.setIfcCalckijyunymd(convertDateFormat(pAzukarikinKessankanri.getCalckijyunymd()));
        khAzukarikinLstCsvfFile.setIfcAzukarikinhsiymd(convertDateFormat(pAzukarikinKessankanri.getAzukarikinhsiymd()));
        khAzukarikinLstCsvfFile.setIfcAzukariganrikin(BizUtil.comma(pAzukarikinKessankanri.getAzukariganrikin().toString()));
        khAzukarikinLstCsvfFile.setIfcTounendgankin(BizUtil.comma(pAzukarikinKessankanri.getTounendgankin().toString()));
        khAzukarikinLstCsvfFile.setIfcTounendrsk(BizUtil.comma(pAzukarikinKessankanri.getTounendrsk().toString()));
        khAzukarikinLstCsvfFile.setIfcKwsratekjymd(convertDateFormat(pAzukarikinKessankanri.getKwsratekjymd()));
        khAzukarikinLstCsvfFile.setIfcKawaserate(pAzukarikinKessankanri.getKawaserate().toString());
        khAzukarikinLstCsvfFile.setIfcGaikaazukariganrikin(BizUtil.comma(pAzukarikinKessankanri.getGaikaazukariganrikin().toString(), BizUtil.ZERO_FILL_LAST_ONLY, 2));
        khAzukarikinLstCsvfFile.setIfcGaikatounendgankin(BizUtil.comma(pAzukarikinKessankanri.getGaikatounendgankin().toString(), BizUtil.ZERO_FILL_LAST_ONLY, 2));
        khAzukarikinLstCsvfFile.setIfcGaikatounendrsk(BizUtil.comma(pAzukarikinKessankanri.getGaikatounendrsk().toString(), BizUtil.ZERO_FILL_LAST_ONLY, 2));
        khAzukarikinLstCsvfFile.setIfcGaikashrkwsratekjnymd(convertDateFormat(pAzukarikinKessankanri.getGaikashrkwsratekjnymd()));
        khAzukarikinLstCsvfFile.setIfcGaikashrkwsrate(pAzukarikinKessankanri.getGaikashrkwsrate());
        khAzukarikinLstCsvfFile.setIfcGkknsnmaeazukariganrikin(BizUtil.comma(pAzukarikinKessankanri.getGaikaknsnmaeazukariganrikin().toString()));
        khAzukarikinLstCsvfFile.setIfcGkknsnmaetounendgankin(BizUtil.comma(pAzukarikinKessankanri.getGaikaknsnmaetounendgankin().toString()));
        khAzukarikinLstCsvfFile.setIfcGkknsnmaetounendrsk(BizUtil.comma(pAzukarikinKessankanri.getGaikaknsnmaetounendrsk().toString()));
        khAzukarikinLstCsvfFile.setIfcTounendrsksyukeisitu(BizUtil.comma(pAzukarikinKessankanri.getTounendrsksyukeisitu().toString()));
        khAzukarikinLstCsvfFile.setIfcZennendrsksyukeisitu(BizUtil.comma(pAzukarikinKessankanri.getZennendrsksyukeisitu().toString()));
        khAzukarikinLstCsvfFile.setIfcKwsratekjymd1q(convertDateFormat(pAzukarikinKessankanri.getKwsratekjymd1q()));
        khAzukarikinLstCsvfFile.setIfcKawaserate1q(pAzukarikinKessankanri.getKawaserate1q().toString());
        khAzukarikinLstCsvfFile.setIfcAzukarikinrsk1q(BizUtil.comma(pAzukarikinKessankanri.getAzukarikinrsk1q().toString()));
        khAzukarikinLstCsvfFile.setIfcKwsratekjymd2q(convertDateFormat(pAzukarikinKessankanri.getKwsratekjymd2q()));
        khAzukarikinLstCsvfFile.setIfcKawaserate2q(pAzukarikinKessankanri.getKawaserate2q().toString());
        khAzukarikinLstCsvfFile.setIfcAzukarikinrsk2q(BizUtil.comma(pAzukarikinKessankanri.getAzukarikinrsk2q().toString()));
        khAzukarikinLstCsvfFile.setIfcKwsratekjymd3q(convertDateFormat(pAzukarikinKessankanri.getKwsratekjymd3q()));
        khAzukarikinLstCsvfFile.setIfcKawaserate3q(pAzukarikinKessankanri.getKawaserate3q().toString());
        khAzukarikinLstCsvfFile.setIfcAzukarikinrsk3q(BizUtil.comma(pAzukarikinKessankanri.getAzukarikinrsk3q().toString()));
        khAzukarikinLstCsvfFile.setIfcKwsratekjymd4q(convertDateFormat(pAzukarikinKessankanri.getKwsratekjymd4q()));
        khAzukarikinLstCsvfFile.setIfcKawaserate4q(pAzukarikinKessankanri.getKawaserate4q().toString());
        khAzukarikinLstCsvfFile.setIfcAzukarikinrsk4q(BizUtil.comma(pAzukarikinKessankanri.getAzukarikinrsk4q().toString()));

        return khAzukarikinLstCsvfFile;
    }

    private KhAzukarikinListSksSyuukeiBean createAzukarikinBikinGokeiBean(
        KhAzukarikinListSksSyuukeiBean pYenSyuukeiBean, KhAzukarikinListSksSyuukeiBean pGaikaSyuukeiBean) {

        KhAzukarikinListSksSyuukeiBean khAzukarikinListSksSyuukeiBean =
            new KhAzukarikinListSksSyuukeiBean(BizCurrencyTypes.YEN);

        BizNumber kawaseRate = BizNumber.ZERO;
        if (!pGaikaSyuukeiBean.getKawaseRate().isZeroOrOptional()) {
            kawaseRate = pGaikaSyuukeiBean.getKawaseRate();
        } else {
            kawaseRate = pYenSyuukeiBean.getKawaseRate();
        }

        khAzukarikinListSksSyuukeiBean.setHknSyruiLevel(pYenSyuukeiBean.getHknSyruiLevel());
        khAzukarikinListSksSyuukeiBean.setTuukaSyu(pYenSyuukeiBean.getTuukaSyu());
        khAzukarikinListSksSyuukeiBean.setKawaseRate(kawaseRate);
        khAzukarikinListSksSyuukeiBean.setTndAzukarikinGankin(
            pYenSyuukeiBean.getTndAzukarikinGankin().add(pGaikaSyuukeiBean.getTndAzukarikinGankin()));
        khAzukarikinListSksSyuukeiBean.setTndAzukarikinRsk(
            pYenSyuukeiBean.getTndAzukarikinRsk().add(pGaikaSyuukeiBean.getTndAzukarikinRsk()));
        khAzukarikinListSksSyuukeiBean.setZndAzukarikinGankin(
            pYenSyuukeiBean.getZndAzukarikinGankin().add(pGaikaSyuukeiBean.getZndAzukarikinGankin()));
        khAzukarikinListSksSyuukeiBean.setZndAzukarikinRsk(
            pYenSyuukeiBean.getZndAzukarikinRsk().add(pGaikaSyuukeiBean.getZndAzukarikinRsk()));
        khAzukarikinListSksSyuukeiBean.setZndAzukarikinShrgk(
            pYenSyuukeiBean.getZndAzukarikinShrgk().add(pGaikaSyuukeiBean.getZndAzukarikinShrgk()));
        khAzukarikinListSksSyuukeiBean.setZndAzukarikinShrRskgk(
            pYenSyuukeiBean.getZndAzukarikinShrRskgk().add(pGaikaSyuukeiBean.getZndAzukarikinShrRskgk()));
        khAzukarikinListSksSyuukeiBean.setTndAzukarikinShrgk(
            pYenSyuukeiBean.getTndAzukarikinShrgk().add(pGaikaSyuukeiBean.getTndAzukarikinShrgk()));
        khAzukarikinListSksSyuukeiBean.setTndAzukarikinShrRskgk(
            pYenSyuukeiBean.getTndAzukarikinShrRskgk().add(pGaikaSyuukeiBean.getTndAzukarikinShrRskgk()));
        khAzukarikinListSksSyuukeiBean.setZndBknkeiRskgk(
            pYenSyuukeiBean.getZndBknkeiRskgk().add(pGaikaSyuukeiBean.getZndBknkeiRskgk()));
        khAzukarikinListSksSyuukeiBean.setTndBknkeiRskgk(
            pYenSyuukeiBean.getTndBknkeiRskgk().add(pGaikaSyuukeiBean.getTndBknkeiRskgk()));
        khAzukarikinListSksSyuukeiBean.setZndSyoumetuMishr(
            pYenSyuukeiBean.getZndSyoumetuMishr().add(pGaikaSyuukeiBean.getZndSyoumetuMishr()));
        khAzukarikinListSksSyuukeiBean.setTndSyoumetuMishr(
            pYenSyuukeiBean.getTndSyoumetuMishr().add(pGaikaSyuukeiBean.getTndSyoumetuMishr()));
        khAzukarikinListSksSyuukeiBean.setZndSyoumetuUkeMishr(
            pYenSyuukeiBean.getZndSyoumetuUkeMishr().add(pGaikaSyuukeiBean.getZndSyoumetuUkeMishr()));
        khAzukarikinListSksSyuukeiBean.setTndSyoumetuUkeMishr(
            pYenSyuukeiBean.getTndSyoumetuUkeMishr().add(pGaikaSyuukeiBean.getTndSyoumetuUkeMishr()));
        khAzukarikinListSksSyuukeiBean.setBikinShrgk(pYenSyuukeiBean.getBikinShrgk().add(pGaikaSyuukeiBean.getBikinShrgk()));
        khAzukarikinListSksSyuukeiBean.setTndAzukarikinrsksyukei(
            pYenSyuukeiBean.getTndAzukarikinrsksyukei().add(pGaikaSyuukeiBean.getTndAzukarikinrsksyukei()));
        khAzukarikinListSksSyuukeiBean.setZndAzukarikinrsksyukei(
            pYenSyuukeiBean.getZndAzukarikinrsksyukei().add(pGaikaSyuukeiBean.getZndAzukarikinrsksyukei()));

        return khAzukarikinListSksSyuukeiBean;
    }

    private KhAzukarikinLstBean createAzukarikinBikinHeaderTyouhyou(BizDate pKessankijyunymd) {

        String tyouhyouSakuseiYmd = DateFormatUtil.dateKANJISeirekiNoZero(BizDate.getSysDate());

        String kessanNen = "";
        C_AzukarikinBknkessanKbn aukarikinBknkessanKbn = C_AzukarikinBknkessanKbn.BLNK;

        SetKessanNensibi setKessanNensibi = SWAKInjector.getInstance(SetKessanNensibi.class);

        BizDate kessanNensibi = setKessanNensibi.exec(pKessankijyunymd);

        kessanNen = DateFormatUtil.dateYKANJISeireki(kessanNensibi.getBizDateY()).concat("度");

        if (pKessankijyunymd.getMonth() == 3) {
            aukarikinBknkessanKbn = C_AzukarikinBknkessanKbn.KESSAN;
        }
        else if (pKessankijyunymd.getMonth() == 6) {
            aukarikinBknkessanKbn = C_AzukarikinBknkessanKbn.DAI1SHNK;
        }
        else if (pKessankijyunymd.getMonth() == 9) {
            aukarikinBknkessanKbn = C_AzukarikinBknkessanKbn.HNK;
        }
        else if (pKessankijyunymd.getMonth() == 12) {
            aukarikinBknkessanKbn = C_AzukarikinBknkessanKbn.DAI3SHNK;
        }

        String hozonKkn = ViewReport.getHozonKknTani(C_SyoruiCdKbn.KK_AZUKARIKINLIST);

        KhAzukarikinLstBean khAzukarikinLstBean = SWAKInjector.getInstance(KhAzukarikinLstBean.class);
        khAzukarikinLstBean.setIrTyouhyousakuseiymd(tyouhyouSakuseiYmd);
        khAzukarikinLstBean.setIrKessannnd(kessanNen);
        khAzukarikinLstBean.setIrAzukarikinbknkessankbn(aukarikinBknkessanKbn);
        khAzukarikinLstBean.setIrHozonkkn(hozonKkn);

        return khAzukarikinLstBean;
    }

    private KhAzukarikinLstDataSourceBean createAzukarikinBikinTyouhyou(
        KhAzukarikinListSksSyuukeiBean pKhAzukarikinListSksSyuukeiBean, String pkawaserate, String pTyouhyouSyuruiFlg) {

        String azukariTuukasyu = "";
        String hnykTuukasyu = pKhAzukarikinListSksSyuukeiBean.getTuukaSyu().getContent();
        if (FLG_TYOUHYOUYEN.equals(pTyouhyouSyuruiFlg)) {
            azukariTuukasyu = hnykTuukasyu + "建分";
        }
        else if (FLG_TYOUHYOUGAIKADISPYEN.equals(pTyouhyouSyuruiFlg)) {
            azukariTuukasyu = hnykTuukasyu + "建分（円表示）";
        }
        else if (FLG_TYOUHYOUGAIKADISPGAIKA.equals(pTyouhyouSyuruiFlg)) {
            azukariTuukasyu = hnykTuukasyu + "建分（ドル表示）";
        }
        else if (FLG_TYOUHYOUGOKEI.equals(pTyouhyouSyuruiFlg)) {
            azukariTuukasyu = "合計分";
        }

        String tyoHyoDispTuukasyu = " ";
        if (!FLG_TYOUHYOUGAIKADISPGAIKA.equals(pTyouhyouSyuruiFlg)) {
            tyoHyoDispTuukasyu = tyoHyoDispTuukasyu + "円";
        } else {
            tyoHyoDispTuukasyu = tyoHyoDispTuukasyu + hnykTuukasyu;
        }

        String kawaserate = "";
        if ((!BizUtil.isBlank(azukariTuukasyu)) && FLG_TYOUHYOUGAIKADISPYEN.equals(pTyouhyouSyuruiFlg)) {
            kawaserate = pkawaserate + " 円";
        }
        else if (!BizUtil.isBlank(azukariTuukasyu) && FLG_TYOUHYOUGOKEI.equals(pTyouhyouSyuruiFlg)) {
            kawaserate = pkawaserate + " 円";
        }

        KhAzukarikinLstDataSourceBean khAzukarikinLstDataSourceBean = SWAKInjector.
            getInstance(KhAzukarikinLstDataSourceBean.class);
        khAzukarikinLstDataSourceBean.setIrHknsyruilevel(pKhAzukarikinListSksSyuukeiBean.getHknSyruiLevel().getContent());
        khAzukarikinLstDataSourceBean.setIrAzukarikintuukasyu(azukariTuukasyu);
        khAzukarikinLstDataSourceBean.setIrKawaserate(kawaserate);
        khAzukarikinLstDataSourceBean.setIrTndazukarikingankin(
            BizUtil.comma(pKhAzukarikinListSksSyuukeiBean.getTndAzukarikinGankin().toString(), BizUtil.ZERO_FILL_LAST_ONLY, 2) + tyoHyoDispTuukasyu);
        khAzukarikinLstDataSourceBean.setIrTndazukarikinrsk(
            BizUtil.comma(pKhAzukarikinListSksSyuukeiBean.getTndAzukarikinRsk().toString(), BizUtil.ZERO_FILL_LAST_ONLY, 2) + tyoHyoDispTuukasyu);
        khAzukarikinLstDataSourceBean.setIrZndazukarikingankin(
            BizUtil.comma(pKhAzukarikinListSksSyuukeiBean.getZndAzukarikinGankin().toString(), BizUtil.ZERO_FILL_LAST_ONLY, 2) + tyoHyoDispTuukasyu);
        khAzukarikinLstDataSourceBean.setIrZndazukarikinrsk(
            BizUtil.comma(pKhAzukarikinListSksSyuukeiBean.getZndAzukarikinRsk().toString(), BizUtil.ZERO_FILL_LAST_ONLY, 2) + tyoHyoDispTuukasyu);
        khAzukarikinLstDataSourceBean.setIrZndazukarikinshrgk(
            BizUtil.comma(pKhAzukarikinListSksSyuukeiBean.getZndAzukarikinShrgk().toString(), BizUtil.ZERO_FILL_LAST_ONLY, 2) + tyoHyoDispTuukasyu);
        khAzukarikinLstDataSourceBean.setIrZndazukarikinshrrskgk(
            BizUtil.comma(pKhAzukarikinListSksSyuukeiBean.getZndAzukarikinShrRskgk().toString(), BizUtil.ZERO_FILL_LAST_ONLY, 2) + tyoHyoDispTuukasyu);
        khAzukarikinLstDataSourceBean.setIrTndazukarikinshrgk(
            BizUtil.comma(pKhAzukarikinListSksSyuukeiBean.getTndAzukarikinShrgk().toString(), BizUtil.ZERO_FILL_LAST_ONLY, 2) + tyoHyoDispTuukasyu);
        khAzukarikinLstDataSourceBean.setIrTndazukarikinshrrskgk(
            BizUtil.comma(pKhAzukarikinListSksSyuukeiBean.getTndAzukarikinShrRskgk().toString(), BizUtil.ZERO_FILL_LAST_ONLY, 2) + tyoHyoDispTuukasyu);
        khAzukarikinLstDataSourceBean.setIrZndbknkeirskgk(
            BizUtil.comma(pKhAzukarikinListSksSyuukeiBean.getZndBknkeiRskgk().toString(), BizUtil.ZERO_FILL_LAST_ONLY, 2) + tyoHyoDispTuukasyu);
        khAzukarikinLstDataSourceBean.setIrTndbknkeirskgk(
            BizUtil.comma(pKhAzukarikinListSksSyuukeiBean.getTndBknkeiRskgk().toString(), BizUtil.ZERO_FILL_LAST_ONLY, 2) + tyoHyoDispTuukasyu);
        khAzukarikinLstDataSourceBean.setIrZndsyoumetumishr(
            BizUtil.comma(pKhAzukarikinListSksSyuukeiBean.getZndSyoumetuMishr().toString(), BizUtil.ZERO_FILL_LAST_ONLY, 2) + tyoHyoDispTuukasyu);
        khAzukarikinLstDataSourceBean.setIrTndsyoumetumishr(
            BizUtil.comma(pKhAzukarikinListSksSyuukeiBean.getTndSyoumetuMishr().toString(), BizUtil.ZERO_FILL_LAST_ONLY, 2) + tyoHyoDispTuukasyu);
        khAzukarikinLstDataSourceBean.setIrZndsyoumetuukemishr(
            BizUtil.comma(pKhAzukarikinListSksSyuukeiBean.getZndSyoumetuUkeMishr().toString(), BizUtil.ZERO_FILL_LAST_ONLY, 2) + tyoHyoDispTuukasyu);
        khAzukarikinLstDataSourceBean.setIrTndsyoumetuukemishr(
            BizUtil.comma(pKhAzukarikinListSksSyuukeiBean.getTndSyoumetuUkeMishr().toString(), BizUtil.ZERO_FILL_LAST_ONLY, 2) + tyoHyoDispTuukasyu);
        khAzukarikinLstDataSourceBean.setIrBikinshrgk(
            BizUtil.comma(pKhAzukarikinListSksSyuukeiBean.getBikinShrgk().toString(), BizUtil.ZERO_FILL_LAST_ONLY, 2) + tyoHyoDispTuukasyu);

        if (FLG_TYOUHYOUGAIKADISPYEN.equals(pTyouhyouSyuruiFlg) || FLG_TYOUHYOUGOKEI.equals(pTyouhyouSyuruiFlg)) {
            khAzukarikinLstDataSourceBean.setIrTndazukarikinrsksyukei(
                BizUtil.comma(pKhAzukarikinListSksSyuukeiBean.getTndAzukarikinrsksyukei().toString(), BizUtil.ZERO_FILL_LAST_ONLY, 2) + tyoHyoDispTuukasyu);
            khAzukarikinLstDataSourceBean.setIrZndazukarikinrsksyukei(
                BizUtil.comma(pKhAzukarikinListSksSyuukeiBean.getZndAzukarikinrsksyukei().toString(), BizUtil.ZERO_FILL_LAST_ONLY, 2) + tyoHyoDispTuukasyu);
        }

        return khAzukarikinLstDataSourceBean;
    }

    private IT_AzukarikinKessankanri convertAzukarikinKessankanriTBL(BizDate pKessanYmd, IT_AzukarikinKessankanri pAzukarikinKessankanri) {

        IT_AzukarikinKessankanri azukarikinKessankanriTyouhyou = BizEntityUtil.copyEntity(pAzukarikinKessankanri);

        if ((!C_BkncdKbn.BLNK.eq(pAzukarikinKessankanri.getBkncdkbn()) ||
            C_YuukousyoumetuKbn.SYOUMETU.eq(pAzukarikinKessankanri.getYuukousyoumetukbn())) &&
            pAzukarikinKessankanri.getGaikaknsnmaeazukariganrikin().compareTo(BizCurrency.valueOf(0,
                pAzukarikinKessankanri.getGaikaknsnmaeazukariganrikin().getType())) == 0 &&
                pAzukarikinKessankanri.getGaikaazukariganrikin().compareTo(BizCurrency.valueOf(0,
                    pAzukarikinKessankanri.getGaikaazukariganrikin().getType())) > 0 ) {

            HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);

            C_Tuukasyu tuukaSyu = henkanTuuka.henkanTuukaTypeToKbn(pAzukarikinKessankanri.getGaikaazukariganrikin().getType());

            GetKawaseRate getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);

            getKawaseRate.exec(
                pKessanYmd,
                C_KawaserateSyuruiKbn.PM17JIKAWASERATE,
                tuukaSyu,
                C_Tuukasyu.JPY,
                C_KawasetekiyoKbn.TTM,
                C_KawasetsryKbn.JISSEIRATE,
                C_EigyoubiHoseiKbn.ZENEIGYOUBI,
                C_YouhiKbn.HUYOU);

            BizNumber kessankwsrate = getKawaseRate.getKawaserate();

            KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);

            BizCurrency azukariganrikin = keisanGaikakanzan.exec(
                C_Tuukasyu.JPY,
                pAzukarikinKessankanri.getGaikaazukariganrikin(),
                kessankwsrate,
                C_HasuusyoriKbn.SUTE);

            BizCurrency tounendgankin = keisanGaikakanzan.exec(
                C_Tuukasyu.JPY,
                pAzukarikinKessankanri.getGaikatounendgankin(),
                kessankwsrate,
                C_HasuusyoriKbn.SUTE);

            azukarikinKessankanriTyouhyou.setAzukariganrikin(azukariganrikin);
            azukarikinKessankanriTyouhyou.setTounendgankin(tounendgankin);
            azukarikinKessankanriTyouhyou.setTounendrsk(azukariganrikin.subtract(tounendgankin));
        }

        else if (pAzukarikinKessankanri.getGaikaknsnmaeazukariganrikin().compareTo(BizCurrency.valueOf(0,
            pAzukarikinKessankanri.getGaikaknsnmaeazukariganrikin().getType())) > 0) {

            BizCurrency azukariganrikin = pAzukarikinKessankanri.getGaikaknsnmaeazukariganrikin();
            BizCurrency tounendgankin = pAzukarikinKessankanri.getGaikaknsnmaetounendgankin();

            azukarikinKessankanriTyouhyou.setAzukariganrikin(azukariganrikin);
            azukarikinKessankanriTyouhyou.setTounendgankin(tounendgankin);
            azukarikinKessankanriTyouhyou.setTounendrsk(azukariganrikin.subtract(tounendgankin));

            if (C_YuukousyoumetuKbn.SYOUMETU.eq(pAzukarikinKessankanri.getYuukousyoumetukbn())
                && C_BkncdKbn.BLNK.eq(pAzukarikinKessankanri.getBkncdkbn())) {

                azukarikinKessankanriTyouhyou.setAzukarikinshrgk(azukarikinKessankanriTyouhyou.getTounendgankin());
                azukarikinKessankanriTyouhyou.setAzukarikinshrrskgk(azukarikinKessankanriTyouhyou.getTounendrsk());
            }

            else if (C_BknJkuKbn.SINBI.eq(pAzukarikinKessankanri.getBknjkukbn())) {

                azukarikinKessankanriTyouhyou.setTounendsyoumetuukemishrgk(azukarikinKessankanriTyouhyou.getTounendgankin());
                azukarikinKessankanriTyouhyou.setSinbikinkeirskgk(azukarikinKessankanriTyouhyou.getTounendrsk());
            }
        }

        return azukarikinKessankanriTyouhyou;
    }

    private String convertDateFormat(BizDate pHenkanMaeYmd) {

        String henkanGoYmd = "";

        if (pHenkanMaeYmd != null) {
            henkanGoYmd = DateFormatUtil.dateKANJISeirekiNoZero(pHenkanMaeYmd);
        }

        return henkanGoYmd;
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);
        bzBatchAbendCommonRecovery.exec();
    }

    class KhAzukarikinListSksSyuukeiBean {

        @Getter @Setter
        private C_Segcd hknSyruiLevel;

        @Getter @Setter
        private C_Tuukasyu tuukaSyu;

        @Getter @Setter
        private BizNumber kawaseRate;

        @Getter @Setter
        private BizCurrency tndAzukarikinGankin;

        @Getter @Setter
        private BizCurrency tndAzukarikinRsk;

        @Getter @Setter
        private BizCurrency zndAzukarikinGankin;

        @Getter @Setter
        private BizCurrency zndAzukarikinRsk;

        @Getter @Setter
        private BizCurrency zndAzukarikinShrgk;

        @Getter @Setter
        private BizCurrency zndAzukarikinShrRskgk;

        @Getter @Setter
        private BizCurrency tndAzukarikinShrgk;

        @Getter @Setter
        private BizCurrency tndAzukarikinShrRskgk;

        @Getter @Setter
        private BizCurrency zndBknkeiRskgk;

        @Getter @Setter
        private BizCurrency tndBknkeiRskgk;

        @Getter @Setter
        private BizCurrency zndSyoumetuMishr;

        @Getter @Setter
        private BizCurrency tndSyoumetuMishr;

        @Getter @Setter
        private BizCurrency zndSyoumetuUkeMishr;

        @Getter @Setter
        private BizCurrency tndSyoumetuUkeMishr;

        @Getter @Setter
        private BizCurrency bikinShrgk;

        @Getter @Setter
        private BizCurrency tndAzukarikinrsksyukei;

        @Getter @Setter
        private BizCurrency zndAzukarikinrsksyukei;

        public KhAzukarikinListSksSyuukeiBean(CurrencyType pSiteiTuuka) {

            hknSyruiLevel = C_Segcd.BLNK;
            tuukaSyu = C_Tuukasyu.BLNK;
            kawaseRate = BizNumber.ZERO;
            tndAzukarikinGankin = BizCurrency.valueOf(0, pSiteiTuuka);
            tndAzukarikinRsk = BizCurrency.valueOf(0, pSiteiTuuka);
            zndAzukarikinGankin = BizCurrency.valueOf(0, pSiteiTuuka);
            zndAzukarikinRsk = BizCurrency.valueOf(0, pSiteiTuuka);
            zndAzukarikinShrgk = BizCurrency.valueOf(0, pSiteiTuuka);
            zndAzukarikinShrRskgk = BizCurrency.valueOf(0, pSiteiTuuka);
            tndAzukarikinShrgk = BizCurrency.valueOf(0, pSiteiTuuka);
            tndAzukarikinShrRskgk = BizCurrency.valueOf(0, pSiteiTuuka);
            zndBknkeiRskgk = BizCurrency.valueOf(0, pSiteiTuuka);
            tndBknkeiRskgk = BizCurrency.valueOf(0, pSiteiTuuka);
            zndSyoumetuMishr = BizCurrency.valueOf(0, pSiteiTuuka);
            tndSyoumetuMishr = BizCurrency.valueOf(0, pSiteiTuuka);
            zndSyoumetuUkeMishr = BizCurrency.valueOf(0, pSiteiTuuka);
            tndSyoumetuUkeMishr = BizCurrency.valueOf(0, pSiteiTuuka);
            bikinShrgk = BizCurrency.valueOf(0, pSiteiTuuka);
            tndAzukarikinrsksyukei = BizCurrency.valueOf(0, pSiteiTuuka);
            zndAzukarikinrsksyukei = BizCurrency.valueOf(0, pSiteiTuuka);
        }
    }
}

