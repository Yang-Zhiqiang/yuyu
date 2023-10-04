package yuyu.batch.hozen.khinterf.khmonitoringdatacoolingoff;

import java.util.ArrayList;
import java.util.List;

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
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.hozen.khinterf.khmonitoringdatacoolingoff.dba.KhMonitoringDataCoolingoffBean;
import yuyu.batch.hozen.khinterf.khmonitoringdatacoolingoff.dba.KhMonitoringDataCoolingoffDao;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.BzKbnHenkanUtil;
import yuyu.common.biz.bzcommon.GetKawaseRate;
import yuyu.common.biz.bzcommon.KbnInfoBean;
import yuyu.common.biz.bzcommon.KeisanGaikakanzan;
import yuyu.common.biz.bzfiledl.BzFileUploadUtil;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.hozen.khcommon.EditCommonMonitoringdata;
import yuyu.common.hozen.khcommon.EditCommonMonitoringdataBean;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_FileSyuruiCdKbn;
import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_IkkatubaraiKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_SystemRenkeiHenkanHoukouKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.IT_KhShrRireki;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.hozen.file.csv.KhMonitoringDataCoolingoffCsvFile;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

import com.google.common.collect.Lists;

/**
 * 契約保全 インターフェイス 契約保全モニタリングデータ抽出（クーリングオフ）クラス
 */
public class KhMonitoringDataCoolingoffBatch implements Batch {

    public static final String TYSYTTAISYOUTABLEID = IT_KykKihon.TABLE_NAME;

    public static final String RECOVERYFILTERID = "Kh001";

    private final int FILE_SAVE_MAX_LIST_COUNT = 2000;

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private KhMonitoringDataCoolingoffDao khMonitoringDataCoolingoffDao;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {


        String ibKakutyoujobcd = bzBatchParam.getIbKakutyoujobcd();
        BizDate syoriYmd = bzBatchParam.getSyoriYmd();
        long khMonitoringDataCoolingoffCsvFileKensuu = 0;
        List<KhMonitoringDataCoolingoffCsvFile> khMonitoringDataCoolingoffCsvFileLst = new ArrayList<>();
        int fileRenban = 0;

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(
            MessageId.IBW0003), String.valueOf(syoriYmd)));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(
            MessageId.IBW1018), ibKakutyoujobcd));

        BizDate taisyoukknfrom = null;
        BizDate taisyoukknto = null;

        if (syoriYmd.getMonth() == 4 || syoriYmd.getMonth() == 5) {
            taisyoukknfrom = BizDate.valueOf(syoriYmd.getPreviousYear().getBizDateY(), 4, 1);
            taisyoukknto = BizDate.valueOf(syoriYmd.getBizDateY(), 3, 31);
        }
        else if (syoriYmd.getMonth() == 10 || syoriYmd.getMonth() == 11) {
            taisyoukknfrom = BizDate.valueOf(syoriYmd.getBizDateY(), 4, 1);
            taisyoukknto = BizDate.valueOf(syoriYmd.getBizDateY(), 9, 30);
        }

        EditCommonMonitoringdata editCommonMonitoringdata = SWAKInjector.getInstance(EditCommonMonitoringdata.class);
        BzKbnHenkanUtil bzKbnHenkanUtil = SWAKInjector.getInstance(BzKbnHenkanUtil.class);
        KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);
        GetKawaseRate getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);

        try (ExDBResults<KhMonitoringDataCoolingoffBean> khMonitoringDataCoolingoffBeanLst =
            khMonitoringDataCoolingoffDao.getKhMonitoringDataCoolingoffBeans(ibKakutyoujobcd, taisyoukknfrom,
                taisyoukknto)) {
            for (KhMonitoringDataCoolingoffBean khMonitoringDataCoolingoffBean : khMonitoringDataCoolingoffBeanLst) {
                IT_KykKihon kykKihon = khMonitoringDataCoolingoffBean.getIT_KykKihon();
                IT_KhShrRireki khShrRireki = khMonitoringDataCoolingoffBean.getIT_KhShrRireki();
                String kbnkey = kykKihon.getKbnkey();
                String syoNo = kykKihon.getSyono();

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(ibKakutyoujobcd);
                bzRecoveryDatasikibetuBean.setIbTableid(TYSYTTAISYOUTABLEID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(RECOVERYFILTERID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(kbnkey);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(syoNo);

                BizCurrency syokaiharaikomip = BizCurrency.valueOf(0,BizCurrencyTypes.YEN);
                if (C_Tuukasyu.JPY.eq(khShrRireki.getShrtuukasyu())) {
                    syokaiharaikomip = khShrRireki.getSyushrgkkei();
                }
                else {
                    IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU).get(0);
                    C_UmuKbn zennoumousideumu = C_UmuKbn.NONE;
                    C_IkkatubaraiKbn ikkatubaraiKbn = C_IkkatubaraiKbn.BLNK;
                    if (C_Kykjyoutai.ZENNOU.eq(kykSyouhn.getKykjyoutai())) {

                        zennoumousideumu = C_UmuKbn.ARI;
                    }
                    if (C_TkiktbrisyuruiKbn.TEIKI_6MONTHS.eq(kykKihon.getTikiktbrisyuruikbn()) ||
                        C_TkiktbrisyuruiKbn.TEIKI_12MONTHS.eq(kykKihon.getTikiktbrisyuruikbn())) {

                        ikkatubaraiKbn = C_IkkatubaraiKbn.TEIKIIKKATU;
                    }
                    C_ErrorKbn errorKbn = getKawaseRate.execHyoukagk(kykKihon.getFstpnyknymd(),
                        khShrRireki.getShrtuukasyu(),
                        C_Tuukasyu.JPY,
                        C_YouhiKbn.HUYOU,
                        kykKihon.getHrkkaisuu(),
                        zennoumousideumu,
                        ikkatubaraiKbn);

                    if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                        throw new CommonBizAppException(
                            "評価額算出用為替レート（契約時）取得に失敗しました。領収日：" + kykKihon.getFstpnyknymd()
                            + "　元通貨：" + khShrRireki.getShrtuukasyu().getContent()
                            + "　換算通貨：" + C_Tuukasyu.JPY.getContent()
                            + "　前営業日為替レート取得要否：" + C_YouhiKbn.HUYOU.getContent()
                            + "　払込回数：" + kykKihon.getHrkkaisuu().getContent()
                            + "　前納申出有無：" + zennoumousideumu.getContent()
                            + "　一括払区分：" + ikkatubaraiKbn.getContent());
                    }

                    BizNumber kawaserate = getKawaseRate.getKawaserate();

                    syokaiharaikomip = keisanGaikakanzan.exec(C_Tuukasyu.JPY, khShrRireki.getSyushrgkkei(),
                        kawaserate, C_HasuusyoriKbn.SUTE);
                }

                C_UmuKbn over100manflg = C_UmuKbn.NONE;

                if (syokaiharaikomip.compareTo(BizCurrency.valueOf(1000000,BizCurrencyTypes.YEN)) > 0) {
                    over100manflg = C_UmuKbn.ARI;
                }

                KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(
                    kykKihon.getHrkkaisuu().getValue(),
                    C_Hrkkaisuu.class,
                    C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER);

                String hrkkaisuustr = kbnInfoBean.getKbnData();

                if (C_Hrkkaisuu.TUKI.eq(kykKihon.getHrkkaisuu())) {
                    if (C_TkiktbrisyuruiKbn.TEIKI_12MONTHS.eq(kykKihon.getTikiktbrisyuruikbn())) {
                        hrkkaisuustr = "1";
                    }
                    else if (C_TkiktbrisyuruiKbn.TEIKI_6MONTHS.eq(kykKihon.getTikiktbrisyuruikbn())) {
                        hrkkaisuustr = "2";
                    }
                }

                EditCommonMonitoringdataBean editCommonMonitoringdataBean = editCommonMonitoringdata.exec(kykKihon,
                    taisyoukknto.getBizDateYM());

                KhMonitoringDataCoolingoffCsvFile khMonitoringDataCoolingoffCsvFile =
                    SWAKInjector.getInstance(KhMonitoringDataCoolingoffCsvFile.class);

                khMonitoringDataCoolingoffCsvFile.setIfcMosno(kykKihon.getSkjmosno());
                khMonitoringDataCoolingoffCsvFile.setIfcSyono(editCommonMonitoringdataBean.getSyono());
                khMonitoringDataCoolingoffCsvFile.setIfcOkyksmno(editCommonMonitoringdataBean.getOkyksmno());
                khMonitoringDataCoolingoffCsvFile.setIfcKyknmknhan(editCommonMonitoringdataBean.getKyknmkn());
                khMonitoringDataCoolingoffCsvFile.setIfcKyknmkj(editCommonMonitoringdataBean.getKyknmkj());
                khMonitoringDataCoolingoffCsvFile.setIfcKykseiymd(editCommonMonitoringdataBean.getSeiymd().toString());
                khMonitoringDataCoolingoffCsvFile
                .setIfcCommonkihontikucd(editCommonMonitoringdataBean.getKihontikucd());
                khMonitoringDataCoolingoffCsvFile.setIfcKykymdstr(editCommonMonitoringdataBean.getKykymd().toString());
                khMonitoringDataCoolingoffCsvFile.setIfcLastzugkymd(
                    editCommonMonitoringdataBean.getZougakukeii().toString());
                khMonitoringDataCoolingoffCsvFile.setIfcZuruigk(editCommonMonitoringdataBean.getZougakukingaku()
                    .toAdsoluteString());
                khMonitoringDataCoolingoffCsvFile.setIfcLastmeighnksyoriymd(editCommonMonitoringdataBean
                    .getMeighnkkeii().toString());
                khMonitoringDataCoolingoffCsvFile.setIfcHrkkeirokbn(editCommonMonitoringdataBean.getHrkkeirokbn());
                khMonitoringDataCoolingoffCsvFile.setIfcSyuunoukeirokbn(editCommonMonitoringdataBean
                    .getSyuunoukeirokbn());
                khMonitoringDataCoolingoffCsvFile.setIfcKykkzdoukbn(editCommonMonitoringdataBean.getKzkykdoukbn()
                    .getValue());
                khMonitoringDataCoolingoffCsvFile.setIfcAtukaisisyacd(editCommonMonitoringdataBean.getAtukaisisyacd());
                khMonitoringDataCoolingoffCsvFile.setIfcAtukaisibucd(editCommonMonitoringdataBean.getAtukaisibucd());
                khMonitoringDataCoolingoffCsvFile.setIfcAtukaikojincd(editCommonMonitoringdataBean.getAtukaikojincd());
                khMonitoringDataCoolingoffCsvFile.setIfcMrkykhyj(editCommonMonitoringdataBean.getMrkykhyj().getValue());
                khMonitoringDataCoolingoffCsvFile.setIfcNaibukykhyj(editCommonMonitoringdataBean.getNaibukykhyj()
                    .getValue());
                khMonitoringDataCoolingoffCsvFile.setIfcJikokykhyj(editCommonMonitoringdataBean.getJikokykhyj()
                    .getValue());
                khMonitoringDataCoolingoffCsvFile.setIfcHjnkykhyj(editCommonMonitoringdataBean.getHjnkykhyj()
                    .getValue());
                khMonitoringDataCoolingoffCsvFile.setIfcCommonsyoricd("RB31");
                khMonitoringDataCoolingoffCsvFile.setIfcHouteityotkhknhyj(editCommonMonitoringdataBean
                    .getHouteityotkhknhyj().getValue());
                khMonitoringDataCoolingoffCsvFile.setIfcTyotkhknhyj(editCommonMonitoringdataBean.getTyotkhknhyj()
                    .getValue());
                khMonitoringDataCoolingoffCsvFile.setIfcSyouhnbunruikbn(editCommonMonitoringdataBean
                    .getSyouhnbunruikbn());
                khMonitoringDataCoolingoffCsvFile.setIfcSyouhnnmkbn(editCommonMonitoringdataBean.getSyouhnnmkbn());
                khMonitoringDataCoolingoffCsvFile.setIfcHighriskflg(editCommonMonitoringdataBean.getHighriskflg()
                    .getValue());
                khMonitoringDataCoolingoffCsvFile.setIfcCommonsisyanm("");
                khMonitoringDataCoolingoffCsvFile.setIfcSosikinm("");
                khMonitoringDataCoolingoffCsvFile.setIfcSyokaiphrkgk(syokaiharaikomip.toAdsoluteString());
                khMonitoringDataCoolingoffCsvFile.setIfcFsthrkpnyknhhkbn("21");
                khMonitoringDataCoolingoffCsvFile.setIfcOver100manflg(over100manflg.getValue());
                khMonitoringDataCoolingoffCsvFile.setIfcOver50manflg(C_UmuKbn.NONE.getValue());
                khMonitoringDataCoolingoffCsvFile.setIfcSeikeikeirokbn("00");
                khMonitoringDataCoolingoffCsvFile.setIfcMosjihonninkknnkbn("00");
                khMonitoringDataCoolingoffCsvFile.setIfcMossyoumetukbn("0");
                khMonitoringDataCoolingoffCsvFile.setIfcMossyoumetukktiymd("00000000");
                khMonitoringDataCoolingoffCsvFile.setIfcMostrkskbn("0");
                khMonitoringDataCoolingoffCsvFile.setIfcMostrkssyousairiyuukbn("00");
                khMonitoringDataCoolingoffCsvFile.setIfcHrkkaisuustr(hrkkaisuustr);
                khMonitoringDataCoolingoffCsvFile.setIfcTrhkjikakkbn("2");
                khMonitoringDataCoolingoffCsvFile.setIfcNyuukinjoutaikbn("");
                khMonitoringDataCoolingoffCsvFile.setIfcJigyoukeiyakuhyouji(C_UmuKbn.NONE.getValue());
                khMonitoringDataCoolingoffCsvFile.setIfcNyknkaisuu("00");
                khMonitoringDataCoolingoffCsvFile.setIfcKykhhkndouhyouji("0");
                khMonitoringDataCoolingoffCsvFile.setIfcAnniskcd("00000000");
                khMonitoringDataCoolingoffCsvFile.setIfcNyuuryokuanniskcd("00000000");
                khMonitoringDataCoolingoffCsvFile.setIfcHjndaikjmeigi("");

                khMonitoringDataCoolingoffCsvFileLst.add(khMonitoringDataCoolingoffCsvFile);

                khMonitoringDataCoolingoffCsvFileKensuu = khMonitoringDataCoolingoffCsvFileKensuu + 1;
            }
        }

        bzRecoveryDatasikibetuBean.initializeBlank();


        BzFileUploadUtil bzFileUploadUtil = SWAKInjector.getInstance(BzFileUploadUtil.class);

        if (khMonitoringDataCoolingoffCsvFileLst.size() == 0) {
            C_ErrorKbn errorKbn = bzFileUploadUtil.exec(
                C_FileSyuruiCdKbn.KH_MONITORINGDATACSVFCOOLINGOFF,
                khMonitoringDataCoolingoffCsvFileLst,
                true,
                String.valueOf(1));
            if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                throw new BizAppException(MessageId.EBF0129, "ファイルアップロードユーティリティ");
            }
        }
        else {
            List<List<KhMonitoringDataCoolingoffCsvFile>> bunkatuList = Lists.partition(
                khMonitoringDataCoolingoffCsvFileLst, FILE_SAVE_MAX_LIST_COUNT);

            for (List<KhMonitoringDataCoolingoffCsvFile> csvFileLst : bunkatuList) {
                fileRenban = fileRenban + 1;

                C_ErrorKbn errorKbn = bzFileUploadUtil.exec(
                    C_FileSyuruiCdKbn.KH_MONITORINGDATACSVFCOOLINGOFF,
                    csvFileLst,
                    true,
                    String.valueOf(fileRenban));

                if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                    throw new BizAppException(MessageId.EBF0129, "ファイルアップロードユーティリティ");
                }
            }
        }

        batchLogger.info(MessageUtil.getMessage(
            MessageId.IBF0001, String.valueOf(khMonitoringDataCoolingoffCsvFileKensuu)));
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery = SWAKInjector.getInstance(
            BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }
}
