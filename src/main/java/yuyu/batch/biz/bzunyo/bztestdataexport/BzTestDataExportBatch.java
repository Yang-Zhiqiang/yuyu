package yuyu.batch.biz.bzunyo.bztestdataexport;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.biz.bzunyo.bztestdataexport.dba.BzTestDataExportDao;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.ConvertTestDataForKanaMeigi;
import yuyu.common.biz.bzunyo.BzTestDataExportFileUtil;
import yuyu.common.biz.bzunyo.ConvertTestData;
import yuyu.common.biz.bzunyo.ConvertTestDataOutBean;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.def.MessageId;
import yuyu.def.biz.file.excel.BzAeoiInfoLayoutFile;
import yuyu.def.biz.file.excel.BzAnsyuKihonLayoutFile;
import yuyu.def.biz.file.excel.BzCreditCardInfoLayoutFile;
import yuyu.def.biz.file.excel.BzFatcaInfoLayoutFile;
import yuyu.def.biz.file.excel.BzHhknSyaLayoutFile;
import yuyu.def.biz.file.excel.BzHokenSyoukenLayoutFile;
import yuyu.def.biz.file.excel.BzItekiToukeiInfoLayoutFile;
import yuyu.def.biz.file.excel.BzKhTtdkRirekiLayoutFile;
import yuyu.def.biz.file.excel.BzKhTtdkTyuuiLayoutFile;
import yuyu.def.biz.file.excel.BzKoujyoSymKanriLayoutFile;
import yuyu.def.biz.file.excel.BzKoujyoSymLayoutFile;
import yuyu.def.biz.file.excel.BzKoujyoSymNaiyouLayoutFile;
import yuyu.def.biz.file.excel.BzKouzaLayoutFile;
import yuyu.def.biz.file.excel.BzKykDairitenLayoutFile;
import yuyu.def.biz.file.excel.BzKykKihonLayoutFile;
import yuyu.def.biz.file.excel.BzKykSonotaTkykLayoutFile;
import yuyu.def.biz.file.excel.BzKykSyaLayoutFile;
import yuyu.def.biz.file.excel.BzKykSyouhnLayoutFile;
import yuyu.def.biz.file.excel.BzKykUktLayoutFile;
import yuyu.def.biz.file.excel.BzNyknJissekiRirekiLayoutFile;
import yuyu.def.biz.file.excel.BzTesuuryouLayoutFile;
import yuyu.def.biz.file.excel.BzTesuuryouSyouhnLayoutFile;
import yuyu.def.biz.file.excel.BzTrkKzkLayoutFile;
import yuyu.def.biz.file.excel.BzZennouLayoutFile;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.IT_AeoiInfo;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_CreditCardInfo;
import yuyu.def.db.entity.IT_FatcaInfo;
import yuyu.def.db.entity.IT_HhknSya;
import yuyu.def.db.entity.IT_HokenSyouken;
import yuyu.def.db.entity.IT_ItekiToukeiInfo;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KhTtdkTyuui;
import yuyu.def.db.entity.IT_KoujyoSym;
import yuyu.def.db.entity.IT_KoujyoSymKanri;
import yuyu.def.db.entity.IT_KoujyoSymNaiyou;
import yuyu.def.db.entity.IT_Kouza;
import yuyu.def.db.entity.IT_KykDairiten;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_KykUkt;
import yuyu.def.db.entity.IT_NyknJissekiRireki;
import yuyu.def.db.entity.IT_Tesuuryou;
import yuyu.def.db.entity.IT_TesuuryouSyouhn;
import yuyu.def.db.entity.IT_TrkKzk;
import yuyu.def.db.entity.IT_Zennou;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

import com.google.common.collect.Lists;

/**
 * 業務共通 運用 テスト用データ抽出クラス
 */
public class BzTestDataExportBatch implements Batch {

    private static String XLSX = ".xlsx";

    private static String SHIMEIKANJI = "氏名漢字";

    private static String HHKNNMKJ = "被保険者名漢字";

    private static String KYKNMKJ = "契約者名漢字";

    private static String UKTNMKJ = "受取人名漢字";

    private static String SYOUKENUKTNM1 = "証券受取人名１";

    private static String SYOUKENUKTNM2 = "証券受取人名２";

    private static String SYOUKENUKTNM3 = "証券受取人名３";

    private static String SYOUKENUKTNM4 = "証券受取人名４";

    private static String SYOUKENUKTNM5 = "証券受取人名５";

    private static String SYOUKENUKTNM6 = "証券受取人名６";

    private static String SYOUKENUKTNM7 = "証券受取人名７";

    private static String SYOUKENUKTNM8 = "証券受取人名８";

    private static String SYOUKENUKTNM9 = "証券受取人名９";

    private static String SYOUKENUKTNM10 = "証券受取人名１０";

    private static String SHSNMKJ = "送付先氏名漢字";

    private static String HOSYNYHIHKNSYAMEIKANJI = "保障内容被保険者名漢字";

    private static String UKTNMKJADDSAMA = "受取人名漢字様付加";

    private static String POSTALCD = "1350033";

    private static String TSINADR1KJ = "東京都江東区";

    private static String TSINADR2KJ = "深川";

    private static String TSINADR3KJ = "１－１１－１２";

    private static String TELNO = "03-6240-3461";

    private static String TRKKZKNMKJ = "登録家族名漢字";

    private static String SEIREKINEN2KETA = "17";

    private static String BOSYUUSOSIKICD = "808";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private BzTestDataExportDao bzTestDataExportDao;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private AS_Kinou kinou;

    private ConvertTestDataForKanaMeigi convertTestDataForKanaMeigi;

    @Override
    public BatchParam getParam() {

        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        BizDate syoriYmd = bzBatchParam.getSyoriYmd();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(syoriYmd)));

        bzTestDataExportDao.deleteTestKykData();

        convertTestDataForKanaMeigi = ConvertTestDataForKanaMeigi.getInstance();

        List<BzAeoiInfoLayoutFile> bzAeoiInfoLayoutFileLst = Lists.newArrayList();
        List<BzAnsyuKihonLayoutFile> bzAnsyuKihonLayoutFileLst = Lists.newArrayList();
        List<BzFatcaInfoLayoutFile> bzFatcaInfoLayoutFileLst = Lists.newArrayList();
        List<BzHhknSyaLayoutFile> bzHhknSyaLayoutFileLst = Lists.newArrayList();
        List<BzHokenSyoukenLayoutFile> bzHokenSyoukenLayoutFileLst = Lists.newArrayList();
        List<BzItekiToukeiInfoLayoutFile> bzItekiToukeiInfoLayoutFileLst = Lists.newArrayList();
        List<BzKhTtdkRirekiLayoutFile> bzKhTtdkRirekiLayoutFileLst = Lists.newArrayList();
        List<BzKhTtdkTyuuiLayoutFile> bzKhTtdkTyuuiLayoutFileLst = Lists.newArrayList();
        List<BzKoujyoSymLayoutFile> bzKoujyoSymLayoutFileLst = Lists.newArrayList();
        List<BzKoujyoSymKanriLayoutFile> bzKoujyoSymKanriLayoutFileLst = Lists.newArrayList();
        List<BzKoujyoSymNaiyouLayoutFile> bzKoujyoSymNaiyouLayoutFileLst = Lists.newArrayList();
        List<BzKykDairitenLayoutFile> bzKykDairitenLayoutFileLst = Lists.newArrayList();
        List<BzKykKihonLayoutFile> bzKykKihonLayoutFileLst = Lists.newArrayList();
        List<BzKykSonotaTkykLayoutFile> bzKykSonotaTkykLayoutFileLst = Lists.newArrayList();
        List<BzKykSyaLayoutFile> bzKykSyaLayoutFileLst = Lists.newArrayList();
        List<BzKykSyouhnLayoutFile> bzKykSyouhnLayoutFileLst = Lists.newArrayList();
        List<BzKykUktLayoutFile> bzKykUktLayoutFileLst = Lists.newArrayList();
        List<BzNyknJissekiRirekiLayoutFile> bzNyknJissekiRirekiLayoutFileLst = Lists.newArrayList();
        List<BzTesuuryouLayoutFile> bzTesuuryouLayoutFileLst = Lists.newArrayList();
        List<BzTesuuryouSyouhnLayoutFile> bzTesuuryouSyouhnLayoutFileLst = Lists.newArrayList();
        List<BzTrkKzkLayoutFile> bzTrkKzkLayoutFileLst = Lists.newArrayList();
        List<BzZennouLayoutFile> bzZennouLayoutFileLst = Lists.newArrayList();
        List<BzKouzaLayoutFile> bzKouzaLayoutFileLst = Lists.newArrayList();
        List<BzCreditCardInfoLayoutFile> bzCreditCardInfoLayoutFileLst = Lists.newArrayList();

        BzAeoiInfoLayoutFile bzAeoiInfoLayoutFile = setAeoiInfoKoumokunm();
        bzAeoiInfoLayoutFileLst.add(bzAeoiInfoLayoutFile);

        BzAnsyuKihonLayoutFile bzAnsyuKihonLayoutFile = setAnsyuKihonKoumokunm();
        bzAnsyuKihonLayoutFileLst.add(bzAnsyuKihonLayoutFile);

        BzFatcaInfoLayoutFile bzFatcaInfoLayoutFile = setFatcaInfoKoumokunm();
        bzFatcaInfoLayoutFileLst.add(bzFatcaInfoLayoutFile);

        BzHhknSyaLayoutFile bzHhknSyaLayoutFile = setHhknSyaKoumokunm();
        bzHhknSyaLayoutFileLst.add(bzHhknSyaLayoutFile);

        BzHokenSyoukenLayoutFile bzHokenSyoukenLayoutFile = setHokenSyoukenKoumokunm();
        bzHokenSyoukenLayoutFileLst.add(bzHokenSyoukenLayoutFile);

        BzItekiToukeiInfoLayoutFile bzItekiToukeiInfoLayoutFile = setItekiToukeiInfoKoumokunm();
        bzItekiToukeiInfoLayoutFileLst.add(bzItekiToukeiInfoLayoutFile);

        BzKhTtdkRirekiLayoutFile bzKhTtdkRirekiLayoutFile = setKhTtdkRirekiKoumokunm();
        bzKhTtdkRirekiLayoutFileLst.add(bzKhTtdkRirekiLayoutFile);

        BzKhTtdkTyuuiLayoutFile bzKhTtdkTyuuiLayoutFile = setKhTtdkTyuuiKoumokunm();
        bzKhTtdkTyuuiLayoutFileLst.add(bzKhTtdkTyuuiLayoutFile);

        BzKoujyoSymLayoutFile bzKoujyoSymLayoutFile = setKoujyoSymKoumokunm();
        bzKoujyoSymLayoutFileLst.add(bzKoujyoSymLayoutFile);

        BzKoujyoSymKanriLayoutFile bzKoujyoSymKanriLayoutFile = setKoujyoSymKanriKoumokunm();
        bzKoujyoSymKanriLayoutFileLst.add(bzKoujyoSymKanriLayoutFile);

        BzKoujyoSymNaiyouLayoutFile bzKoujyoSymNaiyouLayoutFile = setKoujyoSymNaiyouKoumokunm();
        bzKoujyoSymNaiyouLayoutFileLst.add(bzKoujyoSymNaiyouLayoutFile);

        BzKykDairitenLayoutFile bzKykDairitenLayoutFile = setKykDairitenKoumokunm();
        bzKykDairitenLayoutFileLst.add(bzKykDairitenLayoutFile);

        BzKykKihonLayoutFile bzKykKihonLayoutFile = setKykKihonKoumokunm();
        bzKykKihonLayoutFileLst.add(bzKykKihonLayoutFile);

        BzKykSonotaTkykLayoutFile bzKykSonotaTkykLayoutFile = setKykSonotaTkykKoumokunm();
        bzKykSonotaTkykLayoutFileLst.add(bzKykSonotaTkykLayoutFile);

        BzKykSyaLayoutFile bzKykSyaLayoutFile = setKykSyaKoumokunm();
        bzKykSyaLayoutFileLst.add(bzKykSyaLayoutFile);

        BzKykSyouhnLayoutFile bzKykSyouhnLayoutFile = setKykSyouhnKoumokunm();
        bzKykSyouhnLayoutFileLst.add(bzKykSyouhnLayoutFile);

        BzKykUktLayoutFile bzKykUktLayoutFile = setKykUktKoumokunm();
        bzKykUktLayoutFileLst.add(bzKykUktLayoutFile);

        BzNyknJissekiRirekiLayoutFile bzNyknJissekiRirekiLayoutFile = setNyknJissekiRirekiKoumokunm();
        bzNyknJissekiRirekiLayoutFileLst.add(bzNyknJissekiRirekiLayoutFile);

        BzTesuuryouLayoutFile bzTesuuryouLayoutFile = setTesuuryouKoumokunm();
        bzTesuuryouLayoutFileLst.add(bzTesuuryouLayoutFile);

        BzTesuuryouSyouhnLayoutFile bzTesuuryouSyouhnLayoutFile = setTesuuryouSyouhnKoumokunm();
        bzTesuuryouSyouhnLayoutFileLst.add(bzTesuuryouSyouhnLayoutFile);

        BzTrkKzkLayoutFile bzTrkKzkLayoutFile = setTrkKzkKoumokunm();
        bzTrkKzkLayoutFileLst.add(bzTrkKzkLayoutFile);

        BzZennouLayoutFile bzZennouLayoutFile = setZennouKoumokunm();
        bzZennouLayoutFileLst.add(bzZennouLayoutFile);

        BzKouzaLayoutFile bzKouzaLayoutFile = setKouzaKoumokunm();
        bzKouzaLayoutFileLst.add(bzKouzaLayoutFile);

        BzCreditCardInfoLayoutFile bzCreditCardInfoLayoutFile = setCreditCardInfoKoumokunm();
        bzCreditCardInfoLayoutFileLst.add(bzCreditCardInfoLayoutFile);

        List<String> kykDataHozenWGLst = bzTestDataExportDao.getHozenSyonos();

        List<String> kykDataK2GaikaWGLst = bzTestDataExportDao.getDirectSyonos1();

        List<String> kykDataK2EnkaWGLst = bzTestDataExportDao.getDirectSyonos2();

        List<String> kykDataKasukedoWGLst = bzTestDataExportDao.getDirectSyonos3();

        List<String> resultLst = new ArrayList<String>();
        resultLst.addAll(kykDataHozenWGLst);
        resultLst.addAll(kykDataK2GaikaWGLst);
        resultLst.addAll(kykDataK2EnkaWGLst);
        resultLst.addAll(kykDataKasukedoWGLst);
        resultLst = new ArrayList<String>(new TreeSet<String>(resultLst));

        BzTestDataExportFileUtil bzTestDataExportFileUtil = SWAKInjector.getInstance(BzTestDataExportFileUtil.class);

        ConvertTestData convertTestData = SWAKInjector.getInstance(ConvertTestData.class);

        long count = resultLst.size();

        for (String syoNo : resultLst) {

            try {
                IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo);
                IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon(syoNo);
                IT_ItekiToukeiInfo itekiToukeiInfo = hozenDomManager.getItekiToukeiInfo(syoNo);

                ConvertTestDataOutBean convertTestDataOutBean = convertTestData.getTestSyoukenNo(null, "808",
                    "BatchSystem");
                String syoukenNo = convertTestDataOutBean.getTestSyono();
                String kbnkey = convertTestDataOutBean.getKbnKey();

                if (kykKihon != null) {
                    for (IT_AeoiInfo aeoiInfo : kykKihon.getAeoiInfos()) {

                        bzAeoiInfoLayoutFile = getBzAeoiInfoLayoutFile(aeoiInfo, kbnkey, syoukenNo);
                        bzAeoiInfoLayoutFileLst.add(bzAeoiInfoLayoutFile);
                    }
                }

                if (ansyuKihon != null) {
                    bzAnsyuKihonLayoutFile = getBzAnsyuKihonLayoutFile(ansyuKihon, kbnkey, syoukenNo);
                    bzAnsyuKihonLayoutFileLst.add(bzAnsyuKihonLayoutFile);
                }

                if (kykKihon != null) {
                    for (IT_FatcaInfo fatcaInfo : kykKihon.getFatcaInfos()) {
                        bzFatcaInfoLayoutFile = getBzFatcaInfoLayoutFileLst(fatcaInfo, kbnkey, syoukenNo);
                        bzFatcaInfoLayoutFileLst.add(bzFatcaInfoLayoutFile);
                    }
                }

                if (kykKihon != null) {
                    IT_HhknSya hhknSya = kykKihon.getHhknSya();
                    if (hhknSya != null) {
                        bzHhknSyaLayoutFile = getBzHhknSyaLayoutFile(hhknSya, kbnkey, syoukenNo);
                        bzHhknSyaLayoutFileLst.add(bzHhknSyaLayoutFile);
                    }
                }

                //                if (kykKihon != null) {
                //                    for (IT_HokenSyouken hokenSyouken : kykKihon.getHokenSyoukens()) {
                //                        bzHokenSyoukenLayoutFile = getBzHokenSyoukenLayoutFile(hokenSyouken, kbnkey, syoukenNo);
                //                        bzHokenSyoukenLayoutFileLst.add(bzHokenSyoukenLayoutFile);
                //                    }
                //                }

                if (itekiToukeiInfo != null) {
                    bzItekiToukeiInfoLayoutFile = getBzItekiToukeiInfoLayoutFile(itekiToukeiInfo, syoukenNo);
                    bzItekiToukeiInfoLayoutFileLst.add(bzItekiToukeiInfoLayoutFile);
                }

                if (kykKihon != null) {
                    for (IT_KhTtdkRireki khTtdkRireki : kykKihon.getKhTtdkRirekis()) {
                        bzKhTtdkRirekiLayoutFile = getBzKhTtdkRirekiLayoutFile(khTtdkRireki, kbnkey, syoukenNo);
                        bzKhTtdkRirekiLayoutFileLst.add(bzKhTtdkRirekiLayoutFile);
                    }
                }

                if (kykKihon != null) {
                    IT_KhTtdkTyuui khTtdkTyuui = kykKihon.getKhTtdkTyuui();
                    if (khTtdkTyuui != null) {
                        bzKhTtdkTyuuiLayoutFile = getBzKhTtdkTyuuiLayoutFile(khTtdkTyuui, kbnkey, syoukenNo);
                        bzKhTtdkTyuuiLayoutFileLst.add(bzKhTtdkTyuuiLayoutFile);
                    }
                }

                if (kykKihon != null) {
                    for (IT_KoujyoSym koujyoSym : kykKihon.getKoujyoSyms()) {
                        bzKoujyoSymLayoutFile = getBzKoujyoSymLayoutFile(koujyoSym, kbnkey, syoukenNo);
                        bzKoujyoSymLayoutFileLst.add(bzKoujyoSymLayoutFile);
                    }
                }

                if (kykKihon != null) {
                    for (IT_KoujyoSymKanri koujyoSymKanri : kykKihon.getKoujyoSymKanris()) {
                        bzKoujyoSymKanriLayoutFile = getBzKoujyoSymKanriLayoutFile(koujyoSymKanri, kbnkey, syoukenNo);
                        bzKoujyoSymKanriLayoutFileLst.add(bzKoujyoSymKanriLayoutFile);
                    }
                }

                if (kykKihon != null) {
                    for (IT_KoujyoSymNaiyou koujyoSymNaiyou : kykKihon.getKoujyoSymNaiyous()) {
                        bzKoujyoSymNaiyouLayoutFile = getBzKoujyoSymNaiyouLayoutFile(koujyoSymNaiyou, kbnkey, syoukenNo);
                        bzKoujyoSymNaiyouLayoutFileLst.add(bzKoujyoSymNaiyouLayoutFile);
                    }
                }

                if (kykKihon != null) {
                    for (IT_KykDairiten kykDairiten : kykKihon.getKykDairitens()) {
                        bzKykDairitenLayoutFile = getBzKykDairitenLayoutFile(kykDairiten, kbnkey, syoukenNo);
                        bzKykDairitenLayoutFileLst.add(bzKykDairitenLayoutFile);
                    }
                }

                if (kykKihon != null) {
                    bzKykKihonLayoutFile = getBzKykKihonLayoutFile(kykKihon, kbnkey, syoukenNo);
                    bzKykKihonLayoutFileLst.add(bzKykKihonLayoutFile);
                }

                if (kykKihon != null) {
                    IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
                    if (kykSonotaTkyk != null) {
                        bzKykSonotaTkykLayoutFile = getBzKykSonotaTkykLayoutFile(kykSonotaTkyk, kbnkey, syoukenNo);
                        bzKykSonotaTkykLayoutFileLst.add(bzKykSonotaTkykLayoutFile);
                    }
                }

                if (kykKihon != null) {
                    IT_KykSya kykSya = kykKihon.getKykSya();
                    if (kykSya != null) {
                        bzKykSyaLayoutFile = getBzKykSyaLayoutFile(kykSya, kbnkey, syoukenNo);
                        bzKykSyaLayoutFileLst.add(bzKykSyaLayoutFile);
                    }
                }

                if (kykKihon != null) {
                    for (IT_KykSyouhn kykSyouhn : kykKihon.getKykSyouhns()) {
                        bzKykSyouhnLayoutFile = getBzKykSyouhnLayoutFile(kykSyouhn, kbnkey, syoukenNo);
                        bzKykSyouhnLayoutFileLst.add(bzKykSyouhnLayoutFile);
                    }
                }

                if (kykKihon != null) {
                    for (IT_KykUkt kykUkt : kykKihon.getKykUkts()) {
                        bzKykUktLayoutFile = getBzKykUktLayoutFile(kykUkt, kbnkey, syoukenNo);
                        bzKykUktLayoutFileLst.add(bzKykUktLayoutFile);
                    }
                }

                if (kykKihon != null) {
                    for (IT_NyknJissekiRireki nyknJissekiRireki : kykKihon.getNyknJissekiRirekis()) {
                        bzNyknJissekiRirekiLayoutFile = getBzNyknJissekiRirekiLayoutFile(nyknJissekiRireki, kbnkey,
                            syoukenNo);
                        bzNyknJissekiRirekiLayoutFileLst.add(bzNyknJissekiRirekiLayoutFile);
                    }
                }

                if (kykKihon != null) {
                    for (IT_Tesuuryou tesuuryou : kykKihon.getTesuuryous()) {
                        bzTesuuryouLayoutFile = getBzTesuuryouLayoutFile(tesuuryou, kbnkey, syoukenNo);
                        bzTesuuryouLayoutFileLst.add(bzTesuuryouLayoutFile);
                    }
                }

                if (kykKihon != null) {
                    for (IT_Tesuuryou tesuuryou : kykKihon.getTesuuryous()) {

                        for (IT_TesuuryouSyouhn tesuuryouSyouhn : tesuuryou.getTesuuryouSyouhns()) {
                            bzTesuuryouSyouhnLayoutFile = getBzTesuuryouSyouhnLayoutFile(tesuuryouSyouhn, kbnkey,
                                syoukenNo);
                            bzTesuuryouSyouhnLayoutFileLst.add(bzTesuuryouSyouhnLayoutFile);
                        }
                    }
                }

                if (kykKihon != null) {
                    for (IT_TrkKzk trkKzk : kykKihon.getTrkKzks()) {
                        bzTrkKzkLayoutFile = getBzTrkKzkLayoutFile(trkKzk, kbnkey, syoukenNo);
                        bzTrkKzkLayoutFileLst.add(bzTrkKzkLayoutFile);
                    }
                }

                if (ansyuKihon != null) {
                    for (IT_Zennou zennou : ansyuKihon.getZennous()) {
                        bzZennouLayoutFile = getBzZennouLayoutFile(zennou, kbnkey, syoukenNo);
                        bzZennouLayoutFileLst.add(bzZennouLayoutFile);
                    }
                }

                if (kykKihon != null) {
                    IT_Kouza kouza = kykKihon.getKouza();
                    if (kouza != null) {
                        bzKouzaLayoutFile = getBzKouzaLayoutFile(kouza, kbnkey, syoukenNo);
                        bzKouzaLayoutFileLst.add(bzKouzaLayoutFile);
                    }
                }

                if (kykKihon != null) {
                    IT_CreditCardInfo creditCardInfo = kykKihon.getCreditCardInfo();
                    if (creditCardInfo != null) {
                        bzCreditCardInfoLayoutFile = getBzCreditCardInfoLayoutFile(creditCardInfo, kbnkey, syoukenNo);
                        bzCreditCardInfoLayoutFileLst.add(bzCreditCardInfoLayoutFile);
                    }
                }

            } catch (CommonBizAppException e){
                batchLogger.info(e.getMessage());
            } catch (Exception e) {

                batchLogger.info(MessageUtil.getMessage(MessageId.EBF0129, "証券番号：" + syoNo));
            }
        }

        boolean result = true;
        String fileId = "";
        String fileName = "";

        fileId = IT_AeoiInfo.TABLE_NAME + String.valueOf(syoriYmd);
        fileName = IT_AeoiInfo.TABLE_NAME + XLSX;
        result = bzTestDataExportFileUtil.fileUpload(fileId, fileName, bzAeoiInfoLayoutFileLst);
        if (!result) {
            batchLogger.info(MessageUtil.getMessage(MessageId.EBA1012, fileName + "のファイルアップロード"));
        }

        fileId = IT_AnsyuKihon.TABLE_NAME + String.valueOf(syoriYmd);
        fileName = IT_AnsyuKihon.TABLE_NAME + XLSX;
        result = bzTestDataExportFileUtil.fileUpload(fileId, fileName, bzAnsyuKihonLayoutFileLst);
        if (!result) {
            batchLogger.info(MessageUtil.getMessage(MessageId.EBA1012, fileName + "のファイルアップロード"));
        }

        fileId = IT_FatcaInfo.TABLE_NAME + String.valueOf(syoriYmd);
        fileName = IT_FatcaInfo.TABLE_NAME + XLSX;
        result = bzTestDataExportFileUtil.fileUpload(fileId, fileName, bzFatcaInfoLayoutFileLst);
        if (!result) {
            batchLogger.info(MessageUtil.getMessage(MessageId.EBA1012, fileName + "のファイルアップロード"));
        }

        fileId = IT_HhknSya.TABLE_NAME + String.valueOf(syoriYmd);
        fileName = IT_HhknSya.TABLE_NAME + XLSX;
        result = bzTestDataExportFileUtil.fileUpload(fileId, fileName, bzHhknSyaLayoutFileLst);
        if (!result) {
            batchLogger.info(MessageUtil.getMessage(MessageId.EBA1012, fileName + "のファイルアップロード"));
        }

        //        fileId = IT_HokenSyouken.TABLE_NAME + String.valueOf(syoriYmd);
        //        fileName = IT_HokenSyouken.TABLE_NAME + XLSX;
        //        result = bzTestDataExportFileUtil.fileUpload(fileId, fileName, bzHokenSyoukenLayoutFileLst);
        //        if (!result) {
        //            batchLogger.info(MessageUtil.getMessage(MessageId.EBA1012, fileName + "のファイルアップロード"));
        //        }

        fileId = IT_ItekiToukeiInfo.TABLE_NAME + String.valueOf(syoriYmd);
        fileName = IT_ItekiToukeiInfo.TABLE_NAME + XLSX;
        result = bzTestDataExportFileUtil.fileUpload(fileId, fileName, bzItekiToukeiInfoLayoutFileLst);
        if (!result) {
            batchLogger.info(MessageUtil.getMessage(MessageId.EBA1012, fileName + "のファイルアップロード"));
        }

        fileId = IT_KhTtdkRireki.TABLE_NAME + String.valueOf(syoriYmd);
        fileName = IT_KhTtdkRireki.TABLE_NAME + XLSX;
        result = bzTestDataExportFileUtil.fileUpload(fileId, fileName, bzKhTtdkRirekiLayoutFileLst);
        if (!result) {
            batchLogger.info(MessageUtil.getMessage(MessageId.EBA1012, fileName + "のファイルアップロード"));
        }

        fileId = IT_KhTtdkTyuui.TABLE_NAME + String.valueOf(syoriYmd);
        fileName = IT_KhTtdkTyuui.TABLE_NAME + XLSX;
        result = bzTestDataExportFileUtil.fileUpload(fileId, fileName, bzKhTtdkTyuuiLayoutFileLst);
        if (!result) {
            batchLogger.info(MessageUtil.getMessage(MessageId.EBA1012, fileName + "のファイルアップロード"));
        }

        fileId = IT_KoujyoSym.TABLE_NAME + String.valueOf(syoriYmd);
        fileName = IT_KoujyoSym.TABLE_NAME + XLSX;
        result = bzTestDataExportFileUtil.fileUpload(fileId, fileName, bzKoujyoSymLayoutFileLst);
        if (!result) {
            batchLogger.info(MessageUtil.getMessage(MessageId.EBA1012, fileName + "のファイルアップロード"));
        }

        fileId = IT_KoujyoSymKanri.TABLE_NAME + String.valueOf(syoriYmd);
        fileName = IT_KoujyoSymKanri.TABLE_NAME + XLSX;
        result = bzTestDataExportFileUtil.fileUpload(fileId, fileName, bzKoujyoSymKanriLayoutFileLst);
        if (!result) {
            batchLogger.info(MessageUtil.getMessage(MessageId.EBA1012, fileName + "のファイルアップロード"));
        }

        fileId = IT_KoujyoSymNaiyou.TABLE_NAME + String.valueOf(syoriYmd);
        fileName = IT_KoujyoSymNaiyou.TABLE_NAME + XLSX;
        result = bzTestDataExportFileUtil.fileUpload(fileId, fileName, bzKoujyoSymNaiyouLayoutFileLst);
        if (!result) {
            batchLogger.info(MessageUtil.getMessage(MessageId.EBA1012, fileName + "のファイルアップロード"));
        }

        fileId = IT_KykDairiten.TABLE_NAME + String.valueOf(syoriYmd);
        fileName = IT_KykDairiten.TABLE_NAME + XLSX;
        result = bzTestDataExportFileUtil.fileUpload(fileId, fileName, bzKykDairitenLayoutFileLst);
        if (!result) {
            batchLogger.info(MessageUtil.getMessage(MessageId.EBA1012, fileName + "のファイルアップロード"));
        }

        fileId = IT_KykKihon.TABLE_NAME + String.valueOf(syoriYmd);
        fileName = IT_KykKihon.TABLE_NAME + XLSX;
        result = bzTestDataExportFileUtil.fileUpload(fileId, fileName, bzKykKihonLayoutFileLst);
        if (!result) {
            batchLogger.info(MessageUtil.getMessage(MessageId.EBA1012, fileName + "のファイルアップロード"));
        }

        fileId = IT_KykSonotaTkyk.TABLE_NAME + String.valueOf(syoriYmd);
        fileName = IT_KykSonotaTkyk.TABLE_NAME + XLSX;
        result = bzTestDataExportFileUtil.fileUpload(fileId, fileName, bzKykSonotaTkykLayoutFileLst);
        if (!result) {
            batchLogger.info(MessageUtil.getMessage(MessageId.EBA1012, fileName + "のファイルアップロード"));
        }

        fileId = IT_KykSya.TABLE_NAME + String.valueOf(syoriYmd);
        fileName = IT_KykSya.TABLE_NAME + XLSX;
        result = bzTestDataExportFileUtil.fileUpload(fileId, fileName, bzKykSyaLayoutFileLst);
        if (!result) {
            batchLogger.info(MessageUtil.getMessage(MessageId.EBA1012, fileName + "のファイルアップロード"));
        }

        fileId = IT_KykSyouhn.TABLE_NAME + String.valueOf(syoriYmd);
        fileName = IT_KykSyouhn.TABLE_NAME + XLSX;
        result = bzTestDataExportFileUtil.fileUpload(fileId, fileName, bzKykSyouhnLayoutFileLst);
        if (!result) {
            batchLogger.info(MessageUtil.getMessage(MessageId.EBA1012, fileName + "のファイルアップロード"));
        }

        fileId = IT_KykUkt.TABLE_NAME + String.valueOf(syoriYmd);
        fileName = IT_KykUkt.TABLE_NAME + XLSX;
        result = bzTestDataExportFileUtil.fileUpload(fileId, fileName, bzKykUktLayoutFileLst);
        if (!result) {
            batchLogger.info(MessageUtil.getMessage(MessageId.EBA1012, fileName + "のファイルアップロード"));
        }

        fileId = IT_NyknJissekiRireki.TABLE_NAME + String.valueOf(syoriYmd);
        fileName = IT_NyknJissekiRireki.TABLE_NAME + XLSX;
        result = bzTestDataExportFileUtil.fileUpload(fileId, fileName, bzNyknJissekiRirekiLayoutFileLst);
        if (!result) {
            batchLogger.info(MessageUtil.getMessage(MessageId.EBA1012, fileName + "のファイルアップロード"));
        }

        fileId = IT_Tesuuryou.TABLE_NAME + String.valueOf(syoriYmd);
        fileName = IT_Tesuuryou.TABLE_NAME + XLSX;
        result = bzTestDataExportFileUtil.fileUpload(fileId, fileName, bzTesuuryouLayoutFileLst);
        if (!result) {
            batchLogger.info(MessageUtil.getMessage(MessageId.EBA1012, fileName + "のファイルアップロード"));
        }

        fileId = IT_TesuuryouSyouhn.TABLE_NAME + String.valueOf(syoriYmd);
        fileName = IT_TesuuryouSyouhn.TABLE_NAME + XLSX;
        result = bzTestDataExportFileUtil.fileUpload(fileId, fileName, bzTesuuryouSyouhnLayoutFileLst);
        if (!result) {
            batchLogger.info(MessageUtil.getMessage(MessageId.EBA1012, fileName + "のファイルアップロード"));
        }

        fileId = IT_TrkKzk.TABLE_NAME + String.valueOf(syoriYmd);
        fileName = IT_TrkKzk.TABLE_NAME + XLSX;
        result = bzTestDataExportFileUtil.fileUpload(fileId, fileName, bzTrkKzkLayoutFileLst);
        if (!result) {
            batchLogger.info(MessageUtil.getMessage(MessageId.EBA1012, fileName + "のファイルアップロード"));
        }

        fileId = IT_Zennou.TABLE_NAME + String.valueOf(syoriYmd);
        fileName = IT_Zennou.TABLE_NAME + XLSX;
        result = bzTestDataExportFileUtil.fileUpload(fileId, fileName, bzZennouLayoutFileLst);
        if (!result) {
            batchLogger.info(MessageUtil.getMessage(MessageId.EBA1012, fileName + "のファイルアップロード"));
        }

        fileId = IT_Kouza.TABLE_NAME + String.valueOf(syoriYmd);
        fileName = IT_Kouza.TABLE_NAME + XLSX;
        result = bzTestDataExportFileUtil.fileUpload(fileId, fileName, bzKouzaLayoutFileLst);
        if (!result) {
            batchLogger.info(MessageUtil.getMessage(MessageId.EBA1012, fileName + "のファイルアップロード"));
        }

        fileId = IT_CreditCardInfo.TABLE_NAME + String.valueOf(syoriYmd);
        fileName = IT_CreditCardInfo.TABLE_NAME + XLSX;
        result = bzTestDataExportFileUtil.fileUpload(fileId, fileName, bzCreditCardInfoLayoutFileLst);
        if (!result) {
            batchLogger.info(MessageUtil.getMessage(MessageId.EBA1012, fileName + "のファイルアップロード"));
        }

        Integer syonoRenban = bzTestDataExportDao.getTestSyonokanriMaxSyonorennoBySeirekinen2ketaBosyuusosikicd(
            SEIREKINEN2KETA, BOSYUUSOSIKICD);

        if (syonoRenban > 75000) {
            bzTestDataExportDao.deleteTestSyoukenNoKanriBySeirekinen2ketaBosyuusosikicd(
                SEIREKINEN2KETA, BOSYUUSOSIKICD);
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(count), kinou.getKinouNm()));
    }

    private BzAeoiInfoLayoutFile getBzAeoiInfoLayoutFile(IT_AeoiInfo pAeoiInfo, String pKbnkey, String pSyoNo) {

        BzAeoiInfoLayoutFile bzAeoiInfoLayoutFile = SWAKInjector.getInstance(BzAeoiInfoLayoutFile.class);

        ConvertTestData convertTestData = SWAKInjector.getInstance(ConvertTestData.class);

        bzAeoiInfoLayoutFile.setIfeTskbnkey(pKbnkey);
        bzAeoiInfoLayoutFile.setIfeTssyono(pSyoNo);
        bzAeoiInfoLayoutFile.setIfeTsrenno(String.valueOf(pAeoiInfo.getRenno()));
        bzAeoiInfoLayoutFile.setIfeTsaeoisyoriymd(convertTestData.setNull(String.valueOf(pAeoiInfo.getAeoisyoriymd())));
        bzAeoiInfoLayoutFile.setIfeTsaeoisyorikbn(convertTestData.setNull(String.valueOf(pAeoiInfo.getAeoisyorikbn())));
        bzAeoiInfoLayoutFile.setIfeTsaeoikouryokusttymd(convertTestData.setNull(String.valueOf(
            pAeoiInfo.getAeoikouryokusttymd())));
        bzAeoiInfoLayoutFile.setIfeTsaeoisyorisosikicd(convertTestData.setNull(pAeoiInfo.getAeoisyorisosikicd()));
        bzAeoiInfoLayoutFile.setIfeTsaeoitaisyousyakbn(convertTestData.setNull(String.valueOf(
            pAeoiInfo.getAeoitaisyousyakbn())));
        bzAeoiInfoLayoutFile.setIfeTsaeoikekkakbn(convertTestData.setNull(String.valueOf(pAeoiInfo.getAeoikekkakbn())));
        bzAeoiInfoLayoutFile.setIfeTsaeoihoujinsyuruikbn(convertTestData.setNull(String.valueOf(
            pAeoiInfo.getAeoihoujinsyuruikbn())));
        bzAeoiInfoLayoutFile.setIfeTsaeoikouryokuendymd(convertTestData.setNull(String.valueOf(
            pAeoiInfo.getAeoikouryokuendymd())));
        bzAeoiInfoLayoutFile.setIfeTsgyoumukousinkinou(convertTestData.setNull(pAeoiInfo.getGyoumuKousinKinou()));
        bzAeoiInfoLayoutFile.setIfeTsgyoumukousinsyaid(convertTestData.setNull(pAeoiInfo.getGyoumuKousinsyaId()));
        bzAeoiInfoLayoutFile.setIfeTsgyoumukousintime(convertTestData.setNull(pAeoiInfo.getGyoumuKousinTime()));
        bzAeoiInfoLayoutFile.setIfeTskousinsyaid("init");
        bzAeoiInfoLayoutFile.setIfeTskousintime("0");
        bzAeoiInfoLayoutFile.setIfeTskousinkinou("init");
        bzAeoiInfoLayoutFile.setIfeTsversion("0");

        return bzAeoiInfoLayoutFile;
    }

    private BzAnsyuKihonLayoutFile getBzAnsyuKihonLayoutFile(IT_AnsyuKihon pAnsyuKihon, String pKbnkey, String pSyoNo) {

        BzAnsyuKihonLayoutFile bzAnsyuKihonLayoutFile = SWAKInjector.getInstance(BzAnsyuKihonLayoutFile.class);
        ConvertTestData convertTestData = SWAKInjector.getInstance(ConvertTestData.class);

        bzAnsyuKihonLayoutFile.setIfeTskbnkey(pKbnkey);
        bzAnsyuKihonLayoutFile.setIfeTssyono(pSyoNo);
        bzAnsyuKihonLayoutFile.setIfeTsjkipjytym(convertTestData.setNull(String.valueOf(pAnsyuKihon.getJkipjytym())));
        bzAnsyuKihonLayoutFile.setIfeTstkiktannaitukisuu(convertTestData.setNull(String.valueOf(
            pAnsyuKihon.getTkiktannaitukisuu())));
        bzAnsyuKihonLayoutFile.setIfeTskjsmhakkouzumiflg(convertTestData.setNull(String.valueOf(
            pAnsyuKihon.getKjsmhakkouzumiflg())));
        bzAnsyuKihonLayoutFile.setIfeTssyuharaimanymd(convertTestData.setNull(String.valueOf(
            pAnsyuKihon.getSyuharaimanymd())));
        bzAnsyuKihonLayoutFile.setIfeTsgyoumukousinkinou(convertTestData.setNull(String.valueOf(
            pAnsyuKihon.getGyoumuKousinKinou())));
        bzAnsyuKihonLayoutFile.setIfeTsgyoumukousinsyaid(convertTestData.setNull(pAnsyuKihon.getGyoumuKousinsyaId()));
        bzAnsyuKihonLayoutFile.setIfeTsgyoumukousintime(convertTestData.setNull(pAnsyuKihon.getGyoumuKousinTime()));
        bzAnsyuKihonLayoutFile.setIfeTskousinsyaid("init");
        bzAnsyuKihonLayoutFile.setIfeTskousintime("0");
        bzAnsyuKihonLayoutFile.setIfeTskousinkinou("init");
        bzAnsyuKihonLayoutFile.setIfeTsversion("0");

        return bzAnsyuKihonLayoutFile;
    }

    private BzFatcaInfoLayoutFile getBzFatcaInfoLayoutFileLst(IT_FatcaInfo pFatcaInfo, String pKbnkey, String pSyoNo) {

        BzFatcaInfoLayoutFile bzFatcaInfoLayoutFile = SWAKInjector.getInstance(BzFatcaInfoLayoutFile.class);

        ConvertTestData convertTestData = SWAKInjector.getInstance(ConvertTestData.class);

        bzFatcaInfoLayoutFile.setIfeTskbnkey(pKbnkey);
        bzFatcaInfoLayoutFile.setIfeTssyono(pSyoNo);
        bzFatcaInfoLayoutFile.setIfeTsrenno(String.valueOf(pFatcaInfo.getRenno()));
        bzFatcaInfoLayoutFile.setIfeTssyoriymd(convertTestData.setNull(String.valueOf(pFatcaInfo.getSyoriYmd())));
        bzFatcaInfoLayoutFile.setIfeTssyorisosikicd(convertTestData.setNull(pFatcaInfo.getSyorisosikicd()));
        bzFatcaInfoLayoutFile.setIfeTsfatcasnsikbn(convertTestData.setNull(String.valueOf(pFatcaInfo.getFatcasnsikbn())));
        bzFatcaInfoLayoutFile.setIfeTsbikkjnssinfokbn(convertTestData.setNull(String.valueOf(pFatcaInfo.getBikkjnssinfokbn())));
        bzFatcaInfoLayoutFile.setIfeTsfatcakekkbn(convertTestData.setNull(String.valueOf(pFatcaInfo.getFatcakekkbn())));
        bzFatcaInfoLayoutFile.setIfeTsfatcahankeiikbn(convertTestData.setNull(String.valueOf(pFatcaInfo.getFatcahankeiikbn())));
        bzFatcaInfoLayoutFile.setIfeTsbikknzsyno(setKoteiatai(pFatcaInfo.getBikknzsyno(), ""));
        bzFatcaInfoLayoutFile.setIfeTssyomeiymd(convertTestData.setNull(String.valueOf(pFatcaInfo.getSyomeiymd())));
        bzFatcaInfoLayoutFile.setIfeTskokno(setKoteiatai(pFatcaInfo.getKokno(), ""));
        bzFatcaInfoLayoutFile.setIfeTsfatcatgkbn(convertTestData.setNull(String.valueOf(pFatcaInfo.getFatcatgkbn())));
        bzFatcaInfoLayoutFile.setIfeTsseionnmkn(convertTestDataForKanaMeigi.getKnmeigi(pFatcaInfo.getSeionnmkn()));
        bzFatcaInfoLayoutFile.setIfeTsnmkn(convertTestDataForKanaMeigi.getKnmeigi(pFatcaInfo.getNmkn()));
        bzFatcaInfoLayoutFile.setIfeTsnmkj(convertTestData.setTestKanjiNm(pFatcaInfo.getNmkj(), SHIMEIKANJI, pSyoNo));
        bzFatcaInfoLayoutFile.setIfeTsseiymd(convertTestData.setNull(String.valueOf(pFatcaInfo.getSeiymd())));
        bzFatcaInfoLayoutFile.setIfeTsseibetu(convertTestData.setNull(String.valueOf(pFatcaInfo.getSeibetu())));
        bzFatcaInfoLayoutFile.setIfeTskouryokuendymd(convertTestData.setNull(String.valueOf(pFatcaInfo.getKouryokuendymd())));
        bzFatcaInfoLayoutFile.setIfeTstrkymd(convertTestData.setNull(String.valueOf(pFatcaInfo.getTrkymd())));
        bzFatcaInfoLayoutFile.setIfeTsgyoumukousinkinou(convertTestData.setNull(pFatcaInfo.getGyoumuKousinKinou()));
        bzFatcaInfoLayoutFile.setIfeTsgyoumukousinsyaid(convertTestData.setNull(pFatcaInfo.getGyoumuKousinsyaId()));
        bzFatcaInfoLayoutFile.setIfeTsgyoumukousintime(convertTestData.setNull(pFatcaInfo.getGyoumuKousinTime()));
        bzFatcaInfoLayoutFile.setIfeTskousinsyaid("init");
        bzFatcaInfoLayoutFile.setIfeTskousintime("0");
        bzFatcaInfoLayoutFile.setIfeTskousinkinou("init");
        bzFatcaInfoLayoutFile.setIfeTsversion("0");

        return bzFatcaInfoLayoutFile;
    }

    private BzHhknSyaLayoutFile getBzHhknSyaLayoutFile(IT_HhknSya pHhknSya, String pKbnkey, String pSyoNo) {

        BzHhknSyaLayoutFile bzHhknSyaLayoutFile = SWAKInjector.getInstance(BzHhknSyaLayoutFile.class);

        ConvertTestData convertTestData = SWAKInjector.getInstance(ConvertTestData.class);

        bzHhknSyaLayoutFile.setIfeTskbnkey(pKbnkey);
        bzHhknSyaLayoutFile.setIfeTssyono(pSyoNo);
        bzHhknSyaLayoutFile.setIfeTskokno(setKoteiatai(pHhknSya.getKokno(), ""));
        bzHhknSyaLayoutFile.setIfeTshhknsakuinmeino(convertTestData.setNull(pHhknSya.getHhknsakuinmeino()));
        bzHhknSyaLayoutFile.setIfeTshhknnmkn(convertTestDataForKanaMeigi.getKnmeigi(pHhknSya.getHhknnmkn()));
        bzHhknSyaLayoutFile.setIfeTshhknnmkj(convertTestData.setTestKanjiNm(pHhknSya.getHhknnmkj(), HHKNNMKJ, pSyoNo));
        bzHhknSyaLayoutFile.setIfeTshhknnmkjkhukakbn(convertTestData.setNull(String.valueOf(
            pHhknSya.getHhknnmkjkhukakbn())));
        bzHhknSyaLayoutFile.setIfeTshhknseiymd(convertTestData.setNull(String.valueOf(pHhknSya.getHhknseiymd())));
        bzHhknSyaLayoutFile.setIfeTshhknsei(convertTestData.setNull(String.valueOf(pHhknSya.getHhknsei())));
        bzHhknSyaLayoutFile.setIfeTshhknyno(setKoteiatai(pHhknSya.getHhknyno(), ""));
        bzHhknSyaLayoutFile.setIfeTshhknadr1kn(setKoteiatai(pHhknSya.getHhknadr1kn(), ""));
        bzHhknSyaLayoutFile.setIfeTshhknadr1kj(setKoteiatai(pHhknSya.getHhknadr1kj(), ""));
        bzHhknSyaLayoutFile.setIfeTshhknadr2kn(setKoteiatai(pHhknSya.getHhknadr2kn(), ""));
        bzHhknSyaLayoutFile.setIfeTshhknadr2kj(setKoteiatai(pHhknSya.getHhknadr2kj(), ""));
        bzHhknSyaLayoutFile.setIfeTshhknadr3kn(setKoteiatai(pHhknSya.getHhknadr3kn(), ""));
        bzHhknSyaLayoutFile.setIfeTshhknadr3kj(setKoteiatai(pHhknSya.getHhknadr3kj(), ""));
        bzHhknSyaLayoutFile.setIfeTshhkntelno(setKoteiatai(pHhknSya.getHhkntelno(), ""));
        bzHhknSyaLayoutFile.setIfeTsgyoumukousinkinou(convertTestData.setNull(pHhknSya.getGyoumuKousinKinou()));
        bzHhknSyaLayoutFile.setIfeTsgyoumukousinsyaid(convertTestData.setNull(pHhknSya.getGyoumuKousinsyaId()));
        bzHhknSyaLayoutFile.setIfeTsgyoumukousintime(convertTestData.setNull(pHhknSya.getGyoumuKousinTime()));
        bzHhknSyaLayoutFile.setIfeTskousinsyaid("init");
        bzHhknSyaLayoutFile.setIfeTskousintime("0");
        bzHhknSyaLayoutFile.setIfeTskousinkinou("init");
        bzHhknSyaLayoutFile.setIfeTsversion("0");

        return bzHhknSyaLayoutFile;

    }

    private BzHokenSyoukenLayoutFile getBzHokenSyoukenLayoutFile(IT_HokenSyouken pHokenSyouken, String pKbnkey,
        String pSyoNo) {

        BzHokenSyoukenLayoutFile bzHokenSyoukenLayoutFile = SWAKInjector.getInstance(BzHokenSyoukenLayoutFile.class);

        ConvertTestData convertTestData = SWAKInjector.getInstance(ConvertTestData.class);

        bzHokenSyoukenLayoutFile.setIfeTskbnkey(pKbnkey);
        bzHokenSyoukenLayoutFile.setIfeTssyono(pSyoNo);
        bzHokenSyoukenLayoutFile.setIfeTstyouhyouymd(String.valueOf(pHokenSyouken.getTyouhyouymd()));
        bzHokenSyoukenLayoutFile.setIfeTshenkousikibetukey(convertTestData.setNull(pHokenSyouken.getHenkousikibetukey()));
        bzHokenSyoukenLayoutFile.setIfeTssinsaihkkbn(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getSinsaihkkbn())));
        bzHokenSyoukenLayoutFile.setIfeTssyoukensaihkkbn(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getSyoukensaihkkbn())));
        bzHokenSyoukenLayoutFile.setIfeTsinsizeishryouhikbn(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getInsizeishryouhikbn())));
        bzHokenSyoukenLayoutFile.setIfeTshassoukbn(convertTestData.setNull(String.valueOf(pHokenSyouken.getHassoukbn())));
        bzHokenSyoukenLayoutFile.setIfeTskoujyosyoumeiumukbn(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getKoujyosyoumeiumukbn())));
        bzHokenSyoukenLayoutFile.setIfeTssuiihyouumukbn(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getSuiihyouumukbn())));
        bzHokenSyoukenLayoutFile.setIfeTskanryoutuutiumukbn(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getKanryoutuutiumukbn())));
        bzHokenSyoukenLayoutFile.setIfeTsstdrsktirasidouhuukbn(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getStdrsktirasidouhuukbn())));
        bzHokenSyoukenLayoutFile.setIfeTsdstirasidouhuukbn(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getDstirasidouhuukbn())));
        bzHokenSyoukenLayoutFile.setIfeTsaisyoumeikbn(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getAisyoumeikbn())));
        bzHokenSyoukenLayoutFile.setIfeTssyotnshuyoupostumukbn(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getSyotnshuyoupostumukbn())));
        bzHokenSyoukenLayoutFile.setIfeTshyoujiranhidarimsgcd1(convertTestData.setNull(
            pHokenSyouken.getHyoujiranhidarimsgcd1()));
        bzHokenSyoukenLayoutFile.setIfeTshyoujiranhidarimsgcd2(convertTestData.setNull(
            pHokenSyouken.getHyoujiranhidarimsgcd2()));
        bzHokenSyoukenLayoutFile.setIfeTshyoujiranhidarimsgcd3(convertTestData.setNull(
            pHokenSyouken.getHyoujiranhidarimsgcd3()));
        bzHokenSyoukenLayoutFile.setIfeTshyoujiranhidarimsgcd4(convertTestData.setNull(
            pHokenSyouken.getHyoujiranhidarimsgcd4()));
        bzHokenSyoukenLayoutFile.setIfeTshyoujiranhidarimsgcd5(convertTestData.setNull(
            pHokenSyouken.getHyoujiranhidarimsgcd5()));
        bzHokenSyoukenLayoutFile.setIfeTshyoujiranhidarimsgcd6(convertTestData.setNull(
            pHokenSyouken.getHyoujiranhidarimsgcd6()));
        bzHokenSyoukenLayoutFile.setIfeTshyoujiranhidarimsgcd7(convertTestData.setNull(
            pHokenSyouken.getHyoujiranhidarimsgcd7()));
        bzHokenSyoukenLayoutFile.setIfeTshyoujiranhidarimsgcd8(convertTestData.setNull(
            pHokenSyouken.getHyoujiranhidarimsgcd8()));
        bzHokenSyoukenLayoutFile.setIfeTshyoujiranhidarimsgcd9(convertTestData.setNull(
            pHokenSyouken.getHyoujiranhidarimsgcd9()));
        bzHokenSyoukenLayoutFile.setIfeTshyoujiranhidarimsgcd10(convertTestData.setNull(
            pHokenSyouken.getHyoujiranhidarimsgcd10()));
        bzHokenSyoukenLayoutFile.setIfeTshyoujiranhidarimsgcd11(convertTestData.setNull(
            pHokenSyouken.getHyoujiranhidarimsgcd11()));
        bzHokenSyoukenLayoutFile.setIfeTshyoujiranhidarimsgcd12(convertTestData.setNull(
            pHokenSyouken.getHyoujiranhidarimsgcd12()));
        bzHokenSyoukenLayoutFile.setIfeTshyoujiranhidarimsgcd13(convertTestData.setNull(
            pHokenSyouken.getHyoujiranhidarimsgcd13()));
        bzHokenSyoukenLayoutFile.setIfeTshyoujiranhidarimsgcd14(convertTestData.setNull(
            pHokenSyouken.getHyoujiranhidarimsgcd14()));
        bzHokenSyoukenLayoutFile.setIfeTshyoujiranhidarimsgcd15(convertTestData.setNull(
            pHokenSyouken.getHyoujiranhidarimsgcd15()));
        bzHokenSyoukenLayoutFile.setIfeTshyoujiranhidarimsgcd16(convertTestData.setNull(
            pHokenSyouken.getHyoujiranhidarimsgcd16()));
        bzHokenSyoukenLayoutFile.setIfeTshyoujiranhidarimsgcd17(convertTestData.setNull(
            pHokenSyouken.getHyoujiranhidarimsgcd17()));
        bzHokenSyoukenLayoutFile.setIfeTshyoujiranhidarimsgcd18(convertTestData.setNull(
            pHokenSyouken.getHyoujiranhidarimsgcd18()));
        bzHokenSyoukenLayoutFile.setIfeTshyoujiranhidarimsgcd19(convertTestData.setNull(
            pHokenSyouken.getHyoujiranhidarimsgcd19()));
        bzHokenSyoukenLayoutFile.setIfeTshyoujiranhidarimsgcd20(convertTestData.setNull(
            pHokenSyouken.getHyoujiranhidarimsgcd20()));
        bzHokenSyoukenLayoutFile.setIfeTshyoujiranmigiimsgcd1(convertTestData.setNull(
            pHokenSyouken.getHyoujiranmigiimsgcd1()));
        bzHokenSyoukenLayoutFile.setIfeTshyoujiranmigiimsgcd2(convertTestData.setNull(
            pHokenSyouken.getHyoujiranmigiimsgcd2()));
        bzHokenSyoukenLayoutFile.setIfeTshyoujiranmigiimsgcd3(convertTestData.setNull(
            pHokenSyouken.getHyoujiranmigiimsgcd3()));
        bzHokenSyoukenLayoutFile.setIfeTshyoujiranmigiimsgcd4(convertTestData.setNull(
            pHokenSyouken.getHyoujiranmigiimsgcd4()));
        bzHokenSyoukenLayoutFile.setIfeTshyoujiranmigiimsgcd5(convertTestData.setNull(
            pHokenSyouken.getHyoujiranmigiimsgcd5()));
        bzHokenSyoukenLayoutFile.setIfeTshyoujiranmigiimsgcd6(convertTestData.setNull(
            pHokenSyouken.getHyoujiranmigiimsgcd6()));
        bzHokenSyoukenLayoutFile.setIfeTshyoujiranmigiimsgcd7(convertTestData.setNull(
            pHokenSyouken.getHyoujiranmigiimsgcd7()));
        bzHokenSyoukenLayoutFile.setIfeTshyoujiranmigiimsgcd8(convertTestData.setNull(
            pHokenSyouken.getHyoujiranmigiimsgcd8()));
        bzHokenSyoukenLayoutFile.setIfeTshyoujiranmigiimsgcd9(convertTestData.setNull(
            pHokenSyouken.getHyoujiranmigiimsgcd9()));
        bzHokenSyoukenLayoutFile.setIfeTshyoujiranmigiimsgcd10(convertTestData.setNull(
            pHokenSyouken.getHyoujiranmigiimsgcd10()));
        bzHokenSyoukenLayoutFile.setIfeTshyoujiranmigiimsgcd11(convertTestData.setNull(
            pHokenSyouken.getHyoujiranmigiimsgcd11()));
        bzHokenSyoukenLayoutFile.setIfeTshyoujiranmigiimsgcd12(convertTestData.setNull(
            pHokenSyouken.getHyoujiranmigiimsgcd12()));
        bzHokenSyoukenLayoutFile.setIfeTshyoujiranmigiimsgcd13(convertTestData.setNull(
            pHokenSyouken.getHyoujiranmigiimsgcd13()));
        bzHokenSyoukenLayoutFile.setIfeTshyoujiranmigiimsgcd14(convertTestData.setNull(
            pHokenSyouken.getHyoujiranmigiimsgcd14()));
        bzHokenSyoukenLayoutFile.setIfeTshyoujiranmigiimsgcd15(convertTestData.setNull(
            pHokenSyouken.getHyoujiranmigiimsgcd15()));
        bzHokenSyoukenLayoutFile.setIfeTshyoujiranmigiimsgcd16(convertTestData.setNull(
            pHokenSyouken.getHyoujiranmigiimsgcd16()));
        bzHokenSyoukenLayoutFile.setIfeTshyoujiranmigiimsgcd17(convertTestData.setNull(
            pHokenSyouken.getHyoujiranmigiimsgcd17()));
        bzHokenSyoukenLayoutFile.setIfeTshyoujiranmigiimsgcd18(convertTestData.setNull(
            pHokenSyouken.getHyoujiranmigiimsgcd18()));
        bzHokenSyoukenLayoutFile.setIfeTshyoujiranmigiimsgcd19(convertTestData.setNull(
            pHokenSyouken.getHyoujiranmigiimsgcd19()));
        bzHokenSyoukenLayoutFile.setIfeTshyoujiranmigiimsgcd20(convertTestData.setNull(
            pHokenSyouken.getHyoujiranmigiimsgcd20()));
        bzHokenSyoukenLayoutFile.setIfeTshyoujiransknnkaisiymd(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getHyoujiransknnkaisiymd())));
        bzHokenSyoukenLayoutFile.setIfeTshyoujiranyoteiriritu(convertTestData.setNull(String.valueOf(pHokenSyouken.getHyoujiranyoteiriritu())));
        bzHokenSyoukenLayoutFile.setIfeTshyoujiransjkkktusirrt(convertTestData.setNull(String.valueOf(pHokenSyouken.getHyoujiransjkkktusirrt())));
        bzHokenSyoukenLayoutFile.setIfeTshknsyukigou(convertTestData.setNull(pHokenSyouken.getHknsyukigou()));
        bzHokenSyoukenLayoutFile.setIfeTssyohakkouymd(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getSyohakkouymd())));
        bzHokenSyoukenLayoutFile.setIfeTshanbainm(convertTestData.setNull(pHokenSyouken.getHanbainm()));
        bzHokenSyoukenLayoutFile.setIfeTsseisikihknnm(convertTestData.setNull(pHokenSyouken.getSeisikihknnm()));
        bzHokenSyoukenLayoutFile.setIfeTskouryokukaisiymd(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getKouryokukaisiymd())));
        bzHokenSyoukenLayoutFile.setIfeTskyknmkj(convertTestData.setTestKanjiNm(pHokenSyouken.getKyknmkj(), KYKNMKJ,
            pSyoNo));
        bzHokenSyoukenLayoutFile.setIfeTskyknmkjkhukakbn(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getKyknmkjkhukakbn())));
        bzHokenSyoukenLayoutFile.setIfeTshhknnmkj(convertTestData.setTestKanjiNm(pHokenSyouken.getHhknnmkj(),
            HHKNNMKJ, pSyoNo));
        bzHokenSyoukenLayoutFile.setIfeTshhknnmkjkhukakbn(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getHhknnmkjkhukakbn())));
        bzHokenSyoukenLayoutFile.setIfeTshhknseiymd(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getHhknseiymd())));
        bzHokenSyoukenLayoutFile.setIfeTshhknsei(convertTestData.setNull(String.valueOf(pHokenSyouken.getHhknsei())));
        bzHokenSyoukenLayoutFile.setIfeTshhknnen(convertTestData.setNull(String.valueOf(pHokenSyouken.getHhknnen())));
        bzHokenSyoukenLayoutFile.setIfeTssyoukenuktmidasikbn1(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getSyoukenuktmidasikbn1())));
        bzHokenSyoukenLayoutFile.setIfeTssyoukenuktkbn1(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getSyoukenuktkbn1())));
        bzHokenSyoukenLayoutFile.setIfeTssyoukenuktnm1(convertTestData.setTestKanjiNm(pHokenSyouken.getSyoukenuktnm1(),
            SYOUKENUKTNM1, pSyoNo));
        bzHokenSyoukenLayoutFile.setIfeTssyoukenuktbnwari1(convertTestData.setNull(String.valueOf(pHokenSyouken.getSyoukenuktbnwari1())));
        bzHokenSyoukenLayoutFile.setIfeTssyoukenuktmidasikbn2(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getSyoukenuktmidasikbn2())));
        bzHokenSyoukenLayoutFile.setIfeTssyoukenuktkbn2(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getSyoukenuktkbn2())));
        bzHokenSyoukenLayoutFile.setIfeTssyoukenuktnm2(convertTestData.setTestKanjiNm(pHokenSyouken.getSyoukenuktnm2(),
            SYOUKENUKTNM2, pSyoNo));
        bzHokenSyoukenLayoutFile.setIfeTssyoukenuktbnwari2(convertTestData.setNull(String.valueOf(pHokenSyouken.getSyoukenuktbnwari2())));
        bzHokenSyoukenLayoutFile.setIfeTssyoukenuktmidasikbn3(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getSyoukenuktmidasikbn3())));
        bzHokenSyoukenLayoutFile.setIfeTssyoukenuktkbn3(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getSyoukenuktkbn3())));
        bzHokenSyoukenLayoutFile.setIfeTssyoukenuktnm3(convertTestData.setTestKanjiNm(pHokenSyouken.getSyoukenuktnm3(),
            SYOUKENUKTNM3, pSyoNo));
        bzHokenSyoukenLayoutFile.setIfeTssyoukenuktbnwari3(convertTestData.setNull(String.valueOf(pHokenSyouken.getSyoukenuktbnwari3())));
        bzHokenSyoukenLayoutFile.setIfeTssyoukenuktmidasikbn4(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getSyoukenuktmidasikbn4())));
        bzHokenSyoukenLayoutFile.setIfeTssyoukenuktkbn4(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getSyoukenuktkbn4())));
        bzHokenSyoukenLayoutFile.setIfeTssyoukenuktnm4(convertTestData.setTestKanjiNm(pHokenSyouken.getSyoukenuktnm4(),
            SYOUKENUKTNM4, pSyoNo));
        bzHokenSyoukenLayoutFile.setIfeTssyoukenuktbnwari4(convertTestData.setNull(String.valueOf(pHokenSyouken.getSyoukenuktbnwari4())));
        bzHokenSyoukenLayoutFile.setIfeTssyoukenuktmidasikbn5(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getSyoukenuktmidasikbn5())));
        bzHokenSyoukenLayoutFile.setIfeTssyoukenuktkbn5(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getSyoukenuktkbn5())));
        bzHokenSyoukenLayoutFile.setIfeTssyoukenuktnm5(convertTestData.setTestKanjiNm(pHokenSyouken.getSyoukenuktnm5(),
            SYOUKENUKTNM5, pSyoNo));
        bzHokenSyoukenLayoutFile.setIfeTssyoukenuktbnwari5(convertTestData.setNull(String.valueOf(pHokenSyouken.getSyoukenuktbnwari5())));
        bzHokenSyoukenLayoutFile.setIfeTssyoukenuktmidasikbn6(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getSyoukenuktmidasikbn6())));
        bzHokenSyoukenLayoutFile.setIfeTssyoukenuktkbn6(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getSyoukenuktkbn6())));
        bzHokenSyoukenLayoutFile.setIfeTssyoukenuktnm6(convertTestData.setTestKanjiNm(pHokenSyouken.getSyoukenuktnm6(),
            SYOUKENUKTNM6, pSyoNo));
        bzHokenSyoukenLayoutFile.setIfeTssyoukenuktbnwari6(convertTestData.setNull(String.valueOf(pHokenSyouken.getSyoukenuktbnwari6())));
        bzHokenSyoukenLayoutFile.setIfeTssyoukenuktmidasikbn7(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getSyoukenuktmidasikbn7())));
        bzHokenSyoukenLayoutFile.setIfeTssyoukenuktkbn7(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getSyoukenuktkbn7())));
        bzHokenSyoukenLayoutFile.setIfeTssyoukenuktnm7(convertTestData.setTestKanjiNm(pHokenSyouken.getSyoukenuktnm7(),
            SYOUKENUKTNM7, pSyoNo));
        bzHokenSyoukenLayoutFile.setIfeTssyoukenuktbnwari7(convertTestData.setNull(String.valueOf(pHokenSyouken.getSyoukenuktbnwari7())));
        bzHokenSyoukenLayoutFile.setIfeTssyoukenuktmidasikbn8(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getSyoukenuktmidasikbn8())));
        bzHokenSyoukenLayoutFile.setIfeTssyoukenuktkbn8(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getSyoukenuktkbn8())));
        bzHokenSyoukenLayoutFile.setIfeTssyoukenuktnm8(convertTestData.setTestKanjiNm(pHokenSyouken.getSyoukenuktnm8(),
            SYOUKENUKTNM8, pSyoNo));
        bzHokenSyoukenLayoutFile.setIfeTssyoukenuktbnwari8(convertTestData.setNull(String.valueOf(pHokenSyouken.getSyoukenuktbnwari8())));
        bzHokenSyoukenLayoutFile.setIfeTssyoukenuktmidasikbn9(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getSyoukenuktmidasikbn9())));
        bzHokenSyoukenLayoutFile.setIfeTssyoukenuktkbn9(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getSyoukenuktkbn9())));
        bzHokenSyoukenLayoutFile.setIfeTssyoukenuktnm9(convertTestData.setTestKanjiNm(pHokenSyouken.getSyoukenuktnm9(),
            SYOUKENUKTNM9, pSyoNo));
        bzHokenSyoukenLayoutFile.setIfeTssyoukenuktbnwari9(convertTestData.setNull(String.valueOf(pHokenSyouken.getSyoukenuktbnwari9())));
        bzHokenSyoukenLayoutFile.setIfeTssyoukenuktmidasikbn10(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getSyoukenuktmidasikbn10())));
        bzHokenSyoukenLayoutFile.setIfeTssyoukenuktkbn10(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getSyoukenuktkbn10())));
        bzHokenSyoukenLayoutFile.setIfeTssyoukenuktnm10(convertTestData.setTestKanjiNm(pHokenSyouken.getSyoukenuktnm10(),
            SYOUKENUKTNM10, pSyoNo));
        bzHokenSyoukenLayoutFile.setIfeTssyoukenuktbnwari10(convertTestData.setNull(String.valueOf(pHokenSyouken.getSyoukenuktbnwari10())));
        bzHokenSyoukenLayoutFile.setIfeTspmsgcd1(convertTestData.setNull(pHokenSyouken.getPmsgcd1()));
        bzHokenSyoukenLayoutFile.setIfeTspmsgcd2(convertTestData.setNull(pHokenSyouken.getPmsgcd2()));
        bzHokenSyoukenLayoutFile.setIfeTspmsgcd3(convertTestData.setNull(pHokenSyouken.getPmsgcd3()));
        bzHokenSyoukenLayoutFile.setIfeTsptuukatype(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getPtuukatype())));
        bzHokenSyoukenLayoutFile.setIfeTshokenryou(convertTestData.setNull(setBizCurrencyVal(pHokenSyouken.getHokenryou())));
        bzHokenSyoukenLayoutFile.setIfeTshokenryout(convertTestData.setNull(setBizCurrencyType(pHokenSyouken.getHokenryou())));
        bzHokenSyoukenLayoutFile.setIfeTsptuuka(convertTestData.setNull(pHokenSyouken.getPtuuka()));
        bzHokenSyoukenLayoutFile.setIfeTsptokuyakumsgcd(convertTestData.setNull(pHokenSyouken.getPtokuyakumsgcd()));
        bzHokenSyoukenLayoutFile.setIfeTskykymd(convertTestData.setNull(String.valueOf(pHokenSyouken.getKykymd())));
        bzHokenSyoukenLayoutFile.setIfeTsphrkkknmidasikbn(convertTestData.setNull(pHokenSyouken.getPhrkkknmidasikbn()));
        bzHokenSyoukenLayoutFile.setIfeTshrkkknmsgkbn(convertTestData.setNull(pHokenSyouken.getHrkkknmsgkbn()));
        bzHokenSyoukenLayoutFile.setIfeTshrkkaisuumsgkbn(convertTestData.setNull(pHokenSyouken.getHrkkaisuumsgkbn()));
        bzHokenSyoukenLayoutFile.setIfeTshrkkitukimsgkbn(convertTestData.setNull(pHokenSyouken.getHrkkitukimsgkbn()));
        bzHokenSyoukenLayoutFile.setIfeTshrkhouhoumsgkbn(convertTestData.setNull(pHokenSyouken.getHrkhouhoumsgkbn()));
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykrenban1(convertTestData.setNull(String.valueOf(pHokenSyouken.getSyukyktkykrenban1())));
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykmsgkbn1(convertTestData.setNull(pHokenSyouken.getSyukyktkykmsgkbn1()));
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkyksmsgkbn1(convertTestData.setNull(
            pHokenSyouken.getSyukyktkyksmsgkbn1()));
        bzHokenSyoukenLayoutFile.setIfeTssykyktkykhknkknmsgkbn1(convertTestData.setNull(
            pHokenSyouken.getSyukyktkykhknkknmsgkbn1()));
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykstuukatype1(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getSyukyktkykstuukatype1())));
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykhknkngk1(convertTestData.setNull(setBizCurrencyVal(pHokenSyouken.getSyukyktkykhknkngk1())));
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykhknkngk1t(convertTestData.setNull(setBizCurrencyType(pHokenSyouken.getSyukyktkykhknkngk1())));
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykdai1hknkkn1(convertTestData.setNull(String.valueOf(pHokenSyouken.getSyukyktkykdai1hknkkn1())));
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykdai2hknkkn1(convertTestData.setNull(String.valueOf(pHokenSyouken.getSyukyktkykdai2hknkkn1())));
        bzHokenSyoukenLayoutFile.setIfeTssyutkdai1hknkknymdto1(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getSyutkdai1hknkknymdto1())));
        bzHokenSyoukenLayoutFile.setIfeTssyutkdai2hknkknymdto1(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getSyutkdai2hknkknymdto1())));
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykrenban2(convertTestData.setNull(String.valueOf(pHokenSyouken.getSyukyktkykrenban2())));
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykmsgkbn2(convertTestData.setNull(pHokenSyouken.getSyukyktkykmsgkbn2()));
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkyksmsgkbn2(convertTestData.setNull(
            pHokenSyouken.getSyukyktkyksmsgkbn2()));
        bzHokenSyoukenLayoutFile.setIfeTssykyktkykhknkknmsgkbn2(convertTestData.setNull(
            pHokenSyouken.getSyukyktkykhknkknmsgkbn2()));
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykstuukatype2(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getSyukyktkykstuukatype2())));
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykhknkngk2(convertTestData.setNull(setBizCurrencyVal(pHokenSyouken.getSyukyktkykhknkngk2())));
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykhknkngk2t(convertTestData.setNull(setBizCurrencyType(pHokenSyouken.getSyukyktkykhknkngk2())));
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykdai1hknkkn2(convertTestData.setNull(String.valueOf(pHokenSyouken.getSyukyktkykdai1hknkkn2())));
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykdai2hknkkn2(convertTestData.setNull(String.valueOf(pHokenSyouken.getSyukyktkykdai2hknkkn2())));
        bzHokenSyoukenLayoutFile.setIfeTssyutkdai1hknkknymdto2(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getSyutkdai1hknkknymdto2())));
        bzHokenSyoukenLayoutFile.setIfeTssyutkdai2hknkknymdto2(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getSyutkdai2hknkknymdto2())));
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykrenban3(convertTestData.setNull(String.valueOf(pHokenSyouken.getSyukyktkykrenban3())));
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykmsgkbn3(convertTestData.setNull(pHokenSyouken.getSyukyktkykmsgkbn3()));
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkyksmsgkbn3(convertTestData.setNull(
            pHokenSyouken.getSyukyktkyksmsgkbn3()));
        bzHokenSyoukenLayoutFile.setIfeTssykyktkykhknkknmsgkbn3(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getSyukyktkykhknkknmsgkbn3())));
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykstuukatype3(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getSyukyktkykstuukatype3())));
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykhknkngk3(convertTestData.setNull(setBizCurrencyVal(pHokenSyouken.getSyukyktkykhknkngk3())));
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykhknkngk3t(convertTestData.setNull(setBizCurrencyType(pHokenSyouken.getSyukyktkykhknkngk3())));
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykdai1hknkkn3(convertTestData.setNull(String.valueOf(pHokenSyouken.getSyukyktkykdai1hknkkn3())));
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykdai2hknkkn3(convertTestData.setNull(String.valueOf(pHokenSyouken.getSyukyktkykdai2hknkkn3())));
        bzHokenSyoukenLayoutFile.setIfeTssyutkdai1hknkknymdto3(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getSyutkdai1hknkknymdto3())));
        bzHokenSyoukenLayoutFile.setIfeTssyutkdai2hknkknymdto3(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getSyutkdai2hknkknymdto3())));
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykrenban4(convertTestData.setNull(String.valueOf(pHokenSyouken.getSyukyktkykrenban4())));
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykmsgkbn4(convertTestData.setNull(pHokenSyouken.getSyukyktkykmsgkbn4()));
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkyksmsgkbn4(convertTestData.setNull(
            pHokenSyouken.getSyukyktkyksmsgkbn4()));
        bzHokenSyoukenLayoutFile.setIfeTssykyktkykhknkknmsgkbn4(convertTestData.setNull(
            pHokenSyouken.getSyukyktkykhknkknmsgkbn4()));
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykstuukatype4(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getSyukyktkykstuukatype4())));
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykhknkngk4(convertTestData.setNull(setBizCurrencyVal(pHokenSyouken.getSyukyktkykhknkngk4())));
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykhknkngk4t(convertTestData.setNull(setBizCurrencyType(pHokenSyouken.getSyukyktkykhknkngk4())));
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykdai1hknkkn4(convertTestData.setNull(String.valueOf(pHokenSyouken.getSyukyktkykdai1hknkkn4())));
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykdai2hknkkn4(convertTestData.setNull(String.valueOf(pHokenSyouken.getSyukyktkykdai2hknkkn4())));
        bzHokenSyoukenLayoutFile.setIfeTssyutkdai1hknkknymdto4(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getSyutkdai1hknkknymdto4())));
        bzHokenSyoukenLayoutFile.setIfeTssyutkdai2hknkknymdto4(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getSyutkdai2hknkknymdto4())));
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykrenban5(convertTestData.setNull(String.valueOf(pHokenSyouken.getSyukyktkykrenban5())));
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykmsgkbn5(convertTestData.setNull(pHokenSyouken.getSyukyktkykmsgkbn5()));
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkyksmsgkbn5(convertTestData.setNull(
            pHokenSyouken.getSyukyktkyksmsgkbn5()));
        bzHokenSyoukenLayoutFile.setIfeTssykyktkykhknkknmsgkbn5(convertTestData.setNull(
            pHokenSyouken.getSyukyktkykhknkknmsgkbn5()));
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykstuukatype5(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getSyukyktkykstuukatype5())));
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykhknkngk5(convertTestData.setNull(setBizCurrencyVal(pHokenSyouken.getSyukyktkykhknkngk5())));
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykhknkngk5t(convertTestData.setNull(setBizCurrencyType(pHokenSyouken.getSyukyktkykhknkngk5())));
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykdai1hknkkn5(convertTestData.setNull(String.valueOf(pHokenSyouken.getSyukyktkykdai1hknkkn5())));
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykdai2hknkkn5(convertTestData.setNull(String.valueOf(pHokenSyouken.getSyukyktkykdai2hknkkn5())));
        bzHokenSyoukenLayoutFile.setIfeTssyutkdai1hknkknymdto5(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getSyutkdai1hknkknymdto5())));
        bzHokenSyoukenLayoutFile.setIfeTssyutkdai2hknkknymdto5(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getSyutkdai2hknkknymdto5())));
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykrenban6(convertTestData.setNull(String.valueOf(pHokenSyouken.getSyukyktkykrenban6())));
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykmsgkbn6(convertTestData.setNull(pHokenSyouken.getSyukyktkykmsgkbn6()));
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkyksmsgkbn6(convertTestData.setNull(
            pHokenSyouken.getSyukyktkyksmsgkbn6()));
        bzHokenSyoukenLayoutFile.setIfeTssykyktkykhknkknmsgkbn6(convertTestData.setNull(
            pHokenSyouken.getSyukyktkykhknkknmsgkbn6()));
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykstuukatype6(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getSyukyktkykstuukatype6())));
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykhknkngk6(convertTestData.setNull(setBizCurrencyVal(pHokenSyouken.getSyukyktkykhknkngk6())));
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykhknkngk6t(convertTestData.setNull(setBizCurrencyType(pHokenSyouken.getSyukyktkykhknkngk6())));
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykdai1hknkkn6(convertTestData.setNull(String.valueOf(pHokenSyouken.getSyukyktkykdai1hknkkn6())));
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykdai2hknkkn6(convertTestData.setNull(String.valueOf(pHokenSyouken.getSyukyktkykdai2hknkkn6())));
        bzHokenSyoukenLayoutFile.setIfeTssyutkdai1hknkknymdto6(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getSyutkdai1hknkknymdto6())));
        bzHokenSyoukenLayoutFile.setIfeTssyutkdai2hknkknymdto6(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getSyutkdai2hknkknymdto6())));
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykrenban7(convertTestData.setNull(String.valueOf(pHokenSyouken.getSyukyktkykrenban7())));
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykmsgkbn7(convertTestData.setNull(pHokenSyouken.getSyukyktkykmsgkbn7()));
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkyksmsgkbn7(convertTestData.setNull(
            pHokenSyouken.getSyukyktkyksmsgkbn7()));
        bzHokenSyoukenLayoutFile.setIfeTssykyktkykhknkknmsgkbn7(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getSyukyktkykhknkknmsgkbn7())));
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykstuukatype7(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getSyukyktkykstuukatype7())));
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykhknkngk7(convertTestData.setNull(setBizCurrencyVal(pHokenSyouken.getSyukyktkykhknkngk7())));
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykhknkngk7t(convertTestData.setNull(setBizCurrencyType(pHokenSyouken.getSyukyktkykhknkngk7())));
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykdai1hknkkn7(convertTestData.setNull(String.valueOf(pHokenSyouken.getSyukyktkykdai1hknkkn7())));
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykdai2hknkkn7(convertTestData.setNull(String.valueOf(pHokenSyouken.getSyukyktkykdai2hknkkn7())));
        bzHokenSyoukenLayoutFile.setIfeTssyutkdai1hknkknymdto7(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getSyutkdai1hknkknymdto7())));
        bzHokenSyoukenLayoutFile.setIfeTssyutkdai2hknkknymdto7(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getSyutkdai2hknkknymdto7())));
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykrenban8(convertTestData.setNull(String.valueOf(pHokenSyouken.getSyukyktkykrenban8())));
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykmsgkbn8(convertTestData.setNull(pHokenSyouken.getSyukyktkykmsgkbn8()));
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkyksmsgkbn8(convertTestData.setNull(
            pHokenSyouken.getSyukyktkyksmsgkbn8()));
        bzHokenSyoukenLayoutFile.setIfeTssykyktkykhknkknmsgkbn8(convertTestData.setNull(
            pHokenSyouken.getSyukyktkykhknkknmsgkbn8()));
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykstuukatype8(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getSyukyktkykstuukatype8())));
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykhknkngk8(convertTestData.setNull(setBizCurrencyVal(pHokenSyouken.getSyukyktkykhknkngk8())));
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykhknkngk8t(convertTestData.setNull(setBizCurrencyType(pHokenSyouken.getSyukyktkykhknkngk8())));
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykdai1hknkkn8(convertTestData.setNull(String.valueOf(pHokenSyouken.getSyukyktkykdai1hknkkn8())));
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykdai2hknkkn8(convertTestData.setNull(String.valueOf(pHokenSyouken.getSyukyktkykdai2hknkkn8())));
        bzHokenSyoukenLayoutFile.setIfeTssyutkdai1hknkknymdto8(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getSyutkdai1hknkknymdto8())));
        bzHokenSyoukenLayoutFile.setIfeTssyutkdai2hknkknymdto8(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getSyutkdai2hknkknymdto8())));
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykrenban9(convertTestData.setNull(String.valueOf(pHokenSyouken.getSyukyktkykrenban9())));
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykmsgkbn9(convertTestData.setNull(pHokenSyouken.getSyukyktkykmsgkbn9()));
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkyksmsgkbn9(convertTestData.setNull(
            pHokenSyouken.getSyukyktkyksmsgkbn9()));
        bzHokenSyoukenLayoutFile.setIfeTssykyktkykhknkknmsgkbn9(convertTestData.setNull(
            pHokenSyouken.getSyukyktkykhknkknmsgkbn9()));
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykstuukatype9(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getSyukyktkykstuukatype9())));
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykhknkngk9(convertTestData.setNull(setBizCurrencyVal(pHokenSyouken.getSyukyktkykhknkngk9())));
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykhknkngk9t(convertTestData.setNull(setBizCurrencyType(pHokenSyouken.getSyukyktkykhknkngk9())));
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykdai1hknkkn9(convertTestData.setNull(String.valueOf(pHokenSyouken.getSyukyktkykdai1hknkkn9())));
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykdai2hknkkn9(convertTestData.setNull(String.valueOf(pHokenSyouken.getSyukyktkykdai2hknkkn9())));
        bzHokenSyoukenLayoutFile.setIfeTssyutkdai1hknkknymdto9(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getSyutkdai1hknkknymdto9())));
        bzHokenSyoukenLayoutFile.setIfeTssyutkdai2hknkknymdto9(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getSyutkdai2hknkknymdto9())));
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykrenban10(convertTestData.setNull(String.valueOf(pHokenSyouken.getSyukyktkykrenban10())));
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykmsgkbn10(convertTestData.setNull(
            pHokenSyouken.getSyukyktkykmsgkbn10()));
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkyksmsgkbn10(convertTestData.setNull(
            pHokenSyouken.getSyukyktkyksmsgkbn10()));
        bzHokenSyoukenLayoutFile.setIfeTssykyktkykhknkkmsgkbn10(convertTestData.setNull(
            pHokenSyouken.getSyukyktkykhknkknmsgkbn10()));
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykstuukatype10(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getSyukyktkykstuukatype10())));
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykhknkngk10(convertTestData.setNull(setBizCurrencyVal(pHokenSyouken.getSyukyktkykhknkngk10())));
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykhknkngk10t(convertTestData.setNull(setBizCurrencyType(pHokenSyouken.getSyukyktkykhknkngk10())));
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykdai1hknkkn10(convertTestData.setNull(String.valueOf(pHokenSyouken.getSyukyktkykdai1hknkkn10())));
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykdai2hknkkn10(convertTestData.setNull(String.valueOf(pHokenSyouken.getSyukyktkykdai2hknkkn10())));
        bzHokenSyoukenLayoutFile.setIfeTssyutkdai1hknkknymdto10(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getSyutkdai1hknkknymdto10())));
        bzHokenSyoukenLayoutFile.setIfeTssyutkdai2hknkknymdto10(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getSyutkdai2hknkknymdto10())));
        bzHokenSyoukenLayoutFile.setIfeTskykniyustmsgcd1(convertTestData.setNull(pHokenSyouken.getKykniyustmsgcd1()));
        bzHokenSyoukenLayoutFile.setIfeTskykniyustmsgcd2(convertTestData.setNull(pHokenSyouken.getKykniyustmsgcd2()));
        bzHokenSyoukenLayoutFile.setIfeTskykniyustmsgcd3(convertTestData.setNull(pHokenSyouken.getKykniyustmsgcd3()));
        bzHokenSyoukenLayoutFile.setIfeTskykniyustmsgcd4(convertTestData.setNull(pHokenSyouken.getKykniyustmsgcd4()));
        bzHokenSyoukenLayoutFile.setIfeTskykniyustmsgcd5(convertTestData.setNull(pHokenSyouken.getKykniyustmsgcd5()));
        bzHokenSyoukenLayoutFile.setIfeTskykniyustmsgcd6(convertTestData.setNull(pHokenSyouken.getKykniyustmsgcd6()));
        bzHokenSyoukenLayoutFile.setIfeTskykniyustmsgcd7(convertTestData.setNull(pHokenSyouken.getKykniyustmsgcd7()));
        bzHokenSyoukenLayoutFile.setIfeTskykniyustmsgcd8(convertTestData.setNull(pHokenSyouken.getKykniyustmsgcd8()));
        bzHokenSyoukenLayoutFile.setIfeTskykniyustmsgcd9(convertTestData.setNull(pHokenSyouken.getKykniyustmsgcd9()));
        bzHokenSyoukenLayoutFile.setIfeTskykniyustmsgcd10(convertTestData.setNull(pHokenSyouken.getKykniyustmsgcd10()));
        bzHokenSyoukenLayoutFile.setIfeTskykniyustmsgcd11(convertTestData.setNull(pHokenSyouken.getKykniyustmsgcd11()));
        bzHokenSyoukenLayoutFile.setIfeTskykniyustmsgcd12(convertTestData.setNull(pHokenSyouken.getKykniyustmsgcd12()));
        bzHokenSyoukenLayoutFile.setIfeTskykniyustmsgcd13(convertTestData.setNull(pHokenSyouken.getKykniyustmsgcd13()));
        bzHokenSyoukenLayoutFile.setIfeTskykniyustmsgcd14(convertTestData.setNull(pHokenSyouken.getKykniyustmsgcd14()));
        bzHokenSyoukenLayoutFile.setIfeTskykniyustmsgcd15(convertTestData.setNull(pHokenSyouken.getKykniyustmsgcd15()));
        bzHokenSyoukenLayoutFile.setIfeTskykniystitjbrptuuktype(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getKykniyustitjbrptuuktype())));
        bzHokenSyoukenLayoutFile.setIfeTskykniyustitjbrp(convertTestData.setNull(setBizCurrencyVal(pHokenSyouken.getKykniyustitjbrp())));
        bzHokenSyoukenLayoutFile.setIfeTskykniyustitjbrpt(convertTestData.setNull(setBizCurrencyType(pHokenSyouken.getKykniyustitjbrp())));
        bzHokenSyoukenLayoutFile.setIfeTsstnaiyouranmsgcd1(convertTestData.setNull(pHokenSyouken.getStnaiyouranmsgcd1()));
        bzHokenSyoukenLayoutFile.setIfeTsstnaiyouranmsgcd2(convertTestData.setNull(pHokenSyouken.getStnaiyouranmsgcd2()));
        bzHokenSyoukenLayoutFile.setIfeTsstnaiyouranmsgcd3(convertTestData.setNull(pHokenSyouken.getStnaiyouranmsgcd3()));
        bzHokenSyoukenLayoutFile.setIfeTsstnaiyouranmsgcd4(convertTestData.setNull(pHokenSyouken.getStnaiyouranmsgcd4()));
        bzHokenSyoukenLayoutFile.setIfeTsstnaiyouranmsgcd5(convertTestData.setNull(pHokenSyouken.getStnaiyouranmsgcd5()));
        bzHokenSyoukenLayoutFile.setIfeTsstnaiyouranmsgcd6(convertTestData.setNull(pHokenSyouken.getStnaiyouranmsgcd6()));
        bzHokenSyoukenLayoutFile.setIfeTsstnaiyouranmsgcd7(convertTestData.setNull(pHokenSyouken.getStnaiyouranmsgcd7()));
        bzHokenSyoukenLayoutFile.setIfeTsstnaiyouranmsgcd8(convertTestData.setNull(pHokenSyouken.getStnaiyouranmsgcd8()));
        bzHokenSyoukenLayoutFile.setIfeTsstnaiyouranmsgcd9(convertTestData.setNull(pHokenSyouken.getStnaiyouranmsgcd9()));
        bzHokenSyoukenLayoutFile.setIfeTsstnaiyouranmsgcd10(convertTestData.setNull(pHokenSyouken.getStnaiyouranmsgcd10()));
        bzHokenSyoukenLayoutFile.setIfeTsstnaiyouranmsgcd11(convertTestData.setNull(pHokenSyouken.getStnaiyouranmsgcd11()));
        bzHokenSyoukenLayoutFile.setIfeTsstnaiyouranmsgcd12(convertTestData.setNull(pHokenSyouken.getStnaiyouranmsgcd12()));
        bzHokenSyoukenLayoutFile.setIfeTsstnaiyouranmsgcd13(convertTestData.setNull(pHokenSyouken.getStnaiyouranmsgcd13()));
        bzHokenSyoukenLayoutFile.setIfeTsstnaiyouranmsgcd14(convertTestData.setNull(pHokenSyouken.getStnaiyouranmsgcd14()));
        bzHokenSyoukenLayoutFile.setIfeTsstnaiyouranmsgcd15(convertTestData.setNull(pHokenSyouken.getStnaiyouranmsgcd15()));
        bzHokenSyoukenLayoutFile.setIfeTsstnaiyouranmsgcd16(convertTestData.setNull(pHokenSyouken.getStnaiyouranmsgcd16()));
        bzHokenSyoukenLayoutFile.setIfeTsstnaiyouranmsgcd17(convertTestData.setNull(pHokenSyouken.getStnaiyouranmsgcd17()));
        bzHokenSyoukenLayoutFile.setIfeTsstnaiyouranmsgcd18(convertTestData.setNull(pHokenSyouken.getStnaiyouranmsgcd18()));
        bzHokenSyoukenLayoutFile.setIfeTsstnaiyouranmsgcd19(convertTestData.setNull(pHokenSyouken.getStnaiyouranmsgcd19()));
        bzHokenSyoukenLayoutFile.setIfeTsstnaiyouranmsgcd20(convertTestData.setNull(pHokenSyouken.getStnaiyouranmsgcd20()));
        bzHokenSyoukenLayoutFile.setIfeTssonotanyransiteituuka(convertTestData.setNull(
            pHokenSyouken.getSonotanyransiteituuka()));
        bzHokenSyoukenLayoutFile.setIfeTssonotanyrannykntuktype(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getSonotanyrannykntuktype())));
        bzHokenSyoukenLayoutFile.setIfeTssonotanyrannykntuukap(convertTestData.setNull(setBizCurrencyVal(pHokenSyouken.getSonotanyrannykntuukap())));
        bzHokenSyoukenLayoutFile.setIfeTssonotanyrannykntuukapt(convertTestData.setNull(setBizCurrencyType(pHokenSyouken.getSonotanyrannykntuukap())));
        bzHokenSyoukenLayoutFile.setIfeTssntnyrannykntuukasyu(convertTestData.setNull(
            pHokenSyouken.getSonotanyrannykntuukasyu()));
        bzHokenSyoukenLayoutFile.setIfeTssntnyranenkhrikmrate(convertTestData.setNull(String.valueOf(pHokenSyouken.getSonotanyranenkhrikmrate())));
        bzHokenSyoukenLayoutFile.setIfeTssntnyranstigikwsrate(convertTestData.setNull(String.valueOf(pHokenSyouken.getSonotanyranstigikwsrate())));
        bzHokenSyoukenLayoutFile.setIfeTssntnyrankjnkngktuktype(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getSonotanyrankjnkngktuktype())));
        bzHokenSyoukenLayoutFile.setIfeTssonotanyrankjnkngk(convertTestData.setNull(setBizCurrencyVal(pHokenSyouken.getSonotanyrankjnkngk())));
        bzHokenSyoukenLayoutFile.setIfeTssonotanyrankjnkngkt(convertTestData.setNull(setBizCurrencyType(pHokenSyouken.getSonotanyrankjnkngk())));
        bzHokenSyoukenLayoutFile.setIfeTssonotanyrankjnkngkrate(convertTestData.setNull(String.valueOf(pHokenSyouken.getSonotanyrankjnkngkrate())));
        bzHokenSyoukenLayoutFile.setIfeTssntnyrankjnkngktuuka(convertTestData.setNull(
            pHokenSyouken.getSonotanyrankjnkngktuuka()));
        bzHokenSyoukenLayoutFile.setIfeTssonotanyranpentuktype(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getSonotanyranpentuktype())));
        bzHokenSyoukenLayoutFile.setIfeTssonotanyranpenknsngk(convertTestData.setNull(setBizCurrencyVal(pHokenSyouken.getSonotanyranpenknsngk())));
        bzHokenSyoukenLayoutFile.setIfeTssonotanyranpenknsngkt(convertTestData.setNull(setBizCurrencyType(pHokenSyouken.getSonotanyranpenknsngk())));
        bzHokenSyoukenLayoutFile.setIfeTssonotanyranmkhwariai(convertTestData.setNull(String.valueOf(pHokenSyouken.getSonotanyranmkhwariai())));
        bzHokenSyoukenLayoutFile.setIfeTssonotanyranytirrt(convertTestData.setNull(String.valueOf(pHokenSyouken.getSonotanyranytirrt())));
        bzHokenSyoukenLayoutFile.setIfeTssntnyransjkkktusirrt(convertTestData.setNull(String.valueOf(pHokenSyouken.getSonotanyransjkkktusirrt())));
        bzHokenSyoukenLayoutFile.setIfeTsstnaiyourangaimsgcd(convertTestData.setNull(
            pHokenSyouken.getStnaiyourangaimsgcd()));
        bzHokenSyoukenLayoutFile.setIfeTstsinyno(setKoteiatai(pHokenSyouken.getTsinyno(), POSTALCD));
        bzHokenSyoukenLayoutFile.setIfeTstsinadr1kj(setKoteiatai(pHokenSyouken.getTsinadr1kj(), TSINADR1KJ));
        bzHokenSyoukenLayoutFile.setIfeTstsinadr2kj(setKoteiatai(pHokenSyouken.getTsinadr2kj(), TSINADR2KJ));
        bzHokenSyoukenLayoutFile.setIfeTstsinadr3kj(setKoteiatai(pHokenSyouken.getTsinadr3kj(), TSINADR3KJ));
        bzHokenSyoukenLayoutFile.setIfeTsshsnmkj(convertTestData.setTestKanjiNm(pHokenSyouken.getShsnmkj(), SHSNMKJ,
            pSyoNo));
        bzHokenSyoukenLayoutFile.setIfeTstnknmissmsg(convertTestData.setNull(pHokenSyouken.getTnknmissmsg()));
        bzHokenSyoukenLayoutFile.setIfeTserrormsgcd(convertTestData.setNull(pHokenSyouken.getErrormsgcd()));
        bzHokenSyoukenLayoutFile.setIfeTssisyacd(convertTestData.setNull(pHokenSyouken.getSisyacd()));
        bzHokenSyoukenLayoutFile.setIfeTsdhutusnrntousaadrmsgcd(convertTestData.setNull(
            pHokenSyouken.getDuhutusnrntousaadrmsgcd()));
        bzHokenSyoukenLayoutFile.setIfeTsduhutusnrnsyono(convertTestData.setNull(pHokenSyouken.getDuhutusnrnsyono()));
        bzHokenSyoukenLayoutFile.setIfeTschannelcd(convertTestData.setNull(String.valueOf(pHokenSyouken.getChannelcd())));
        bzHokenSyoukenLayoutFile.setIfeTsdairitenmidasikbn(convertTestData.setNull(pHokenSyouken.getDairitenmidasikbn()));
        bzHokenSyoukenLayoutFile.setIfeTsdrtennm1kj(convertTestData.setNull(pHokenSyouken.getDrtennm1kj()));
        bzHokenSyoukenLayoutFile.setIfeTsdrtennm2kj(convertTestData.setNull(pHokenSyouken.getDrtennm2kj()));
        bzHokenSyoukenLayoutFile.setIfeTsaisatumsgcd(convertTestData.setNull(pHokenSyouken.getAisatumsgcd()));
        bzHokenSyoukenLayoutFile.setIfeTsccmsgcd(convertTestData.setNull(pHokenSyouken.getCcmsgcd()));
        bzHokenSyoukenLayoutFile.setIfeTshskmsgcd(convertTestData.setNull(pHokenSyouken.getHskmsgcd()));
        bzHokenSyoukenLayoutFile.setIfeTshosyounymsgcd(convertTestData.setNull(pHokenSyouken.getHosyounymsgcd()));
        bzHokenSyoukenLayoutFile.setIfeTshosynyhihknsyameikanji(convertTestData.setTestKanjiNm(
            pHokenSyouken.getHosyounyhihknsyameikanji(), HOSYNYHIHKNSYAMEIKANJI, pSyoNo));
        bzHokenSyoukenLayoutFile.setIfeTssiboumidasimsgcd(convertTestData.setNull(pHokenSyouken.getSiboumidasimsgcd()));
        bzHokenSyoukenLayoutFile.setIfeTssiboumidasimsgcd2(convertTestData.setNull(pHokenSyouken.getSiboumidasimsgcd2()));
        bzHokenSyoukenLayoutFile.setIfeTssiboudai1hknkknmsgcd1(convertTestData.setNull(
            pHokenSyouken.getSiboudai1hknkknmsgcd1()));
        bzHokenSyoukenLayoutFile.setIfeTssiboudai1hknkknmsgcd2(convertTestData.setNull(
            pHokenSyouken.getSiboudai1hknkknmsgcd2()));
        bzHokenSyoukenLayoutFile.setIfeTssiboud1hknkknigimsgcd(convertTestData.setNull(
            pHokenSyouken.getSiboudai1hknkknigimsgcd()));
        bzHokenSyoukenLayoutFile.setIfeTssiboud1hknkknigimsgcd2(convertTestData.setNull(
            pHokenSyouken.getSiboudai1hknkknigimsgcd2()));
        bzHokenSyoukenLayoutFile.setIfeTssiboud1hknkknhrsmsgcd(convertTestData.setNull(
            pHokenSyouken.getSiboudai1hknkknhrsmsgcd()));
        bzHokenSyoukenLayoutFile.setIfeTssiboud1hknkknhrsmsgcd2(convertTestData.setNull(
            pHokenSyouken.getSiboudai1hknkknhrsmsgcd2()));
        bzHokenSyoukenLayoutFile.setIfeTssiboud1hknkknsmrmsgcd(convertTestData.setNull(
            pHokenSyouken.getSiboudai1hknkknsmrmsgcd()));
        bzHokenSyoukenLayoutFile.setIfeTssiboudai2hknkknmsgcd1(convertTestData.setNull(
            pHokenSyouken.getSiboudai2hknkknmsgcd1()));
        bzHokenSyoukenLayoutFile.setIfeTssiboudai2hknkknmsgcd2(convertTestData.setNull(
            pHokenSyouken.getSiboudai2hknkknmsgcd2()));
        bzHokenSyoukenLayoutFile.setIfeTssiboudai2hknkknsmsgcd(convertTestData.setNull(
            pHokenSyouken.getSiboudai2hknkknsmsgcd()));
        bzHokenSyoukenLayoutFile.setIfeTssiboudai2hknkknsmsgcd2(convertTestData.setNull(
            pHokenSyouken.getSiboudai2hknkknsmsgcd2()));
        bzHokenSyoukenLayoutFile.setIfeTssiboudai3hknkknmsgcd1(convertTestData.setNull(
            pHokenSyouken.getSiboudai3hknkknmsgcd1()));
        bzHokenSyoukenLayoutFile.setIfeTssiboudai3hknkknmsgcd2(convertTestData.setNull(
            pHokenSyouken.getSiboudai3hknkknmsgcd2()));
        bzHokenSyoukenLayoutFile.setIfeTssiboudai1hknkkn(convertTestData.setNull(String.valueOf(pHokenSyouken.getSiboudai1hknkkn())));
        bzHokenSyoukenLayoutFile.setIfeTssiboudai1hknkknymdto(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getSiboudai1hknkknymdto())));
        bzHokenSyoukenLayoutFile.setIfeTssibouitjbrpyentuuktype(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getSibouitjbrpyentuuktype())));
        bzHokenSyoukenLayoutFile.setIfeTssibouitjbrpyentuukgk(convertTestData.setNull(setBizCurrencyVal(pHokenSyouken.getSibouitjbrpyentuukgk())));
        bzHokenSyoukenLayoutFile.setIfeTssibouitjbrpyentuukgkt(convertTestData.setNull(setBizCurrencyType(pHokenSyouken.getSibouitjbrpyentuukgk())));
        bzHokenSyoukenLayoutFile.setIfeTssiboud1kjnkngktuuktype(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getSiboudai1kjnkngktuuktype())));
        bzHokenSyoukenLayoutFile.setIfeTssiboudai1kjnkngk(convertTestData.setNull(setBizCurrencyVal(pHokenSyouken.getSiboudai1kjnkngk())));
        bzHokenSyoukenLayoutFile.setIfeTssiboudai1kjnkngkt(convertTestData.setNull(setBizCurrencyType(pHokenSyouken.getSiboudai1kjnkngk())));
        bzHokenSyoukenLayoutFile.setIfeTssiboudai2hknkkn(convertTestData.setNull(String.valueOf(pHokenSyouken.getSiboudai2hknkkn())));
        bzHokenSyoukenLayoutFile.setIfeTssiboudai2hknkknymdto(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getSiboudai2hknkknymdto())));
        bzHokenSyoukenLayoutFile.setIfeTssiboud2kjnkngktuuktype(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getSiboudai2kjnkngktuuktype())));
        bzHokenSyoukenLayoutFile.setIfeTssiboudai2kjnkngk(convertTestData.setNull(setBizCurrencyVal(pHokenSyouken.getSiboudai2kjnkngk())));
        bzHokenSyoukenLayoutFile.setIfeTssiboudai2kjnkngkt(convertTestData.setNull(setBizCurrencyType(pHokenSyouken.getSiboudai2kjnkngk())));
        bzHokenSyoukenLayoutFile.setIfeTssiboud3kjnkngktuuktype(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getSiboudai3kjnkngktuuktype())));
        bzHokenSyoukenLayoutFile.setIfeTssiboudai3kjnkngk(convertTestData.setNull(setBizCurrencyVal(pHokenSyouken.getSiboudai3kjnkngk())));
        bzHokenSyoukenLayoutFile.setIfeTssiboudai3kjnkngkt(convertTestData.setNull(setBizCurrencyType(pHokenSyouken.getSiboudai3kjnkngk())));
        bzHokenSyoukenLayoutFile.setIfeTsdai1skwsrateyendaka(convertTestData.setNull(String.valueOf(pHokenSyouken.getDai1skwsrateyendaka())));
        bzHokenSyoukenLayoutFile.setIfeTsdai1skwsrateyenkijyun(convertTestData.setNull(String.valueOf(pHokenSyouken.getDai1skwsrateyenkijyun())));
        bzHokenSyoukenLayoutFile.setIfeTsdai1skwsrateyenyasu(convertTestData.setNull(String.valueOf(pHokenSyouken.getDai1skwsrateyenyasu())));
        bzHokenSyoukenLayoutFile.setIfeTsdai1skeikanensuu01(convertTestData.setNull(String.valueOf(pHokenSyouken.getDai1skeikanensuu01())));
        bzHokenSyoukenLayoutFile.setIfeTsd1sibousnenoutouymd01(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getDai1sibousnenoutouymd01())));
        bzHokenSyoukenLayoutFile.setIfeTsdai1stuuktype01(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getDai1stuuktype01())));
        bzHokenSyoukenLayoutFile.setIfeTsdai1s01(convertTestData.setNull(setBizCurrencyVal(pHokenSyouken.getDai1s01())));
        bzHokenSyoukenLayoutFile.setIfeTsdai1s01t(convertTestData.setNull(setBizCurrencyType(pHokenSyouken.getDai1s01())));
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyendakaumu01(convertTestData.setNull(
            pHokenSyouken.getDai1syenyendakaumu01()));
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyenkijyunumu01(convertTestData.setNull(
            pHokenSyouken.getDai1syenyenkijyunumu01()));
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyenyasuumu01(convertTestData.setNull(
            pHokenSyouken.getDai1syenyenyasuumu01()));
        bzHokenSyoukenLayoutFile.setIfeTsdai1syentuuktype01(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getDai1syentuuktype01())));
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyendaka01(convertTestData.setNull(setBizCurrencyVal(pHokenSyouken.getDai1syenyendaka01())));
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyendaka01t(convertTestData.setNull(setBizCurrencyType(pHokenSyouken.getDai1syenyendaka01())));
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyenkijyun01(convertTestData.setNull(setBizCurrencyVal(pHokenSyouken.getDai1syenyenkijyun01())));
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyenkijyun01t(convertTestData.setNull(setBizCurrencyType(pHokenSyouken.getDai1syenyenkijyun01())));
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyenyasu01(convertTestData.setNull(setBizCurrencyVal(pHokenSyouken.getDai1syenyenyasu01())));
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyenyasu01t(convertTestData.setNull(setBizCurrencyType(pHokenSyouken.getDai1syenyenyasu01())));
        bzHokenSyoukenLayoutFile.setIfeTsdai1skeikanensuu02(convertTestData.setNull(String.valueOf(pHokenSyouken.getDai1skeikanensuu02())));
        bzHokenSyoukenLayoutFile.setIfeTsd1sibousnenoutouymd02(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getDai1sibousnenoutouymd02())));
        bzHokenSyoukenLayoutFile.setIfeTsdai1stuuktype02(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getDai1stuuktype02())));
        bzHokenSyoukenLayoutFile.setIfeTsdai1s02(convertTestData.setNull(setBizCurrencyVal(pHokenSyouken.getDai1s02())));
        bzHokenSyoukenLayoutFile.setIfeTsdai1s02t(convertTestData.setNull(setBizCurrencyType(pHokenSyouken.getDai1s02())));
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyendakaumu02(convertTestData.setNull(
            pHokenSyouken.getDai1syenyendakaumu02()));
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyenkijyunumu02(convertTestData.setNull(
            pHokenSyouken.getDai1syenyenkijyunumu02()));
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyenyasuumu02(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getDai1syenyenyasuumu02())));
        bzHokenSyoukenLayoutFile.setIfeTsdai1syentuuktype02(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getDai1syentuuktype02())));
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyendaka02(convertTestData.setNull(setBizCurrencyVal(pHokenSyouken.getDai1syenyendaka02())));
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyendaka02t(convertTestData.setNull(setBizCurrencyType(pHokenSyouken.getDai1syenyendaka02())));
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyenkijyun02(convertTestData.setNull(setBizCurrencyVal(pHokenSyouken.getDai1syenyenkijyun02())));
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyenkijyun02t(convertTestData.setNull(setBizCurrencyType(pHokenSyouken.getDai1syenyenkijyun02())));
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyenyasu02(convertTestData.setNull(setBizCurrencyVal(pHokenSyouken.getDai1syenyenyasu02())));
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyenyasu02t(convertTestData.setNull(setBizCurrencyType(pHokenSyouken.getDai1syenyenyasu02())));
        bzHokenSyoukenLayoutFile.setIfeTsdai1skeikanensuu03(convertTestData.setNull(String.valueOf(pHokenSyouken.getDai1skeikanensuu03())));
        bzHokenSyoukenLayoutFile.setIfeTsd1sibousnenoutouymd03(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getDai1sibousnenoutouymd03())));
        bzHokenSyoukenLayoutFile.setIfeTsdai1stuuktype03(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getDai1stuuktype03())));
        bzHokenSyoukenLayoutFile.setIfeTsdai1s03(convertTestData.setNull(setBizCurrencyVal(pHokenSyouken.getDai1s03())));
        bzHokenSyoukenLayoutFile.setIfeTsdai1s03t(convertTestData.setNull(setBizCurrencyType(pHokenSyouken.getDai1s03())));
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyendakaumu03(convertTestData.setNull
            (pHokenSyouken.getDai1syenyendakaumu03()));
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyenkijyunumu03(convertTestData.setNull(
            pHokenSyouken.getDai1syenyenkijyunumu03()));
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyenyasuumu03(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getDai1syenyenyasuumu03())));
        bzHokenSyoukenLayoutFile.setIfeTsdai1syentuuktype03(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getDai1syentuuktype03())));
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyendaka03(convertTestData.setNull(setBizCurrencyVal(pHokenSyouken.getDai1syenyendaka03())));
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyendaka03t(convertTestData.setNull(setBizCurrencyType(pHokenSyouken.getDai1syenyendaka03())));
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyenkijyun03(convertTestData.setNull(setBizCurrencyVal(pHokenSyouken.getDai1syenyenkijyun03())));
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyenkijyun03t(convertTestData.setNull(setBizCurrencyType(pHokenSyouken.getDai1syenyenkijyun03())));
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyenyasu03(convertTestData.setNull(setBizCurrencyVal(pHokenSyouken.getDai1syenyenyasu03())));
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyenyasu03t(convertTestData.setNull(setBizCurrencyType(pHokenSyouken.getDai1syenyenyasu03())));
        bzHokenSyoukenLayoutFile.setIfeTsdai1skeikanensuu04(convertTestData.setNull(String.valueOf(pHokenSyouken.getDai1skeikanensuu04())));
        bzHokenSyoukenLayoutFile.setIfeTsd1sibousnenoutouymd04(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getDai1sibousnenoutouymd04())));
        bzHokenSyoukenLayoutFile.setIfeTsdai1stuuktype04(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getDai1stuuktype04())));
        bzHokenSyoukenLayoutFile.setIfeTsdai1s04(convertTestData.setNull(setBizCurrencyVal(pHokenSyouken.getDai1s04())));
        bzHokenSyoukenLayoutFile.setIfeTsdai1s04t(convertTestData.setNull(setBizCurrencyType(pHokenSyouken.getDai1s04())));
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyendakaumu04(convertTestData.setNull(
            pHokenSyouken.getDai1syenyendakaumu04()));
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyenkijyunumu04(convertTestData.setNull(
            pHokenSyouken.getDai1syenyenkijyunumu04()));
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyenyasuumu04(convertTestData.setNull(
            pHokenSyouken.getDai1syenyenyasuumu04()));
        bzHokenSyoukenLayoutFile.setIfeTsdai1syentuuktype04(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getDai1syentuuktype04())));
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyendaka04(convertTestData.setNull(setBizCurrencyVal(pHokenSyouken.getDai1syenyendaka04())));
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyendaka04t(convertTestData.setNull(setBizCurrencyType(pHokenSyouken.getDai1syenyendaka04())));
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyenkijyun04(convertTestData.setNull(setBizCurrencyVal(pHokenSyouken.getDai1syenyenkijyun04())));
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyenkijyun04t(convertTestData.setNull(setBizCurrencyType(pHokenSyouken.getDai1syenyenkijyun04())));
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyenyasu04(convertTestData.setNull(setBizCurrencyVal(pHokenSyouken.getDai1syenyenyasu04())));
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyenyasu04t(convertTestData.setNull(setBizCurrencyType(pHokenSyouken.getDai1syenyenyasu04())));
        bzHokenSyoukenLayoutFile.setIfeTsdai1skeikanensuu05(convertTestData.setNull(String.valueOf(pHokenSyouken.getDai1skeikanensuu05())));
        bzHokenSyoukenLayoutFile.setIfeTsd1sibousnenoutouymd05(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getDai1sibousnenoutouymd05())));
        bzHokenSyoukenLayoutFile.setIfeTsdai1stuuktype05(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getDai1stuuktype05())));
        bzHokenSyoukenLayoutFile.setIfeTsdai1s05(convertTestData.setNull(setBizCurrencyVal(pHokenSyouken.getDai1s05())));
        bzHokenSyoukenLayoutFile.setIfeTsdai1s05t(convertTestData.setNull(setBizCurrencyType(pHokenSyouken.getDai1s05())));
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyendakaumu05(convertTestData.setNull(
            pHokenSyouken.getDai1syenyendakaumu05()));
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyenkijyunumu05(convertTestData.setNull(
            pHokenSyouken.getDai1syenyenkijyunumu05()));
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyenyasuumu05(convertTestData.setNull(
            pHokenSyouken.getDai1syenyenyasuumu05()));
        bzHokenSyoukenLayoutFile.setIfeTsdai1syentuuktype05(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getDai1syentuuktype05())));
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyendaka05(convertTestData.setNull(setBizCurrencyVal(pHokenSyouken.getDai1syenyendaka05())));
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyendaka05t(convertTestData.setNull(setBizCurrencyType(pHokenSyouken.getDai1syenyendaka05())));
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyenkijyun05(convertTestData.setNull(setBizCurrencyVal(pHokenSyouken.getDai1syenyenkijyun05())));
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyenkijyun05t(convertTestData.setNull(setBizCurrencyType(pHokenSyouken.getDai1syenyenkijyun05())));
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyenyasu05(convertTestData.setNull(setBizCurrencyVal(pHokenSyouken.getDai1syenyenyasu05())));
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyenyasu05t(convertTestData.setNull(setBizCurrencyType(pHokenSyouken.getDai1syenyenyasu05())));
        bzHokenSyoukenLayoutFile.setIfeTsdai1skeikanensuu06(convertTestData.setNull(String.valueOf(pHokenSyouken.getDai1skeikanensuu06())));
        bzHokenSyoukenLayoutFile.setIfeTsd1sibousnenoutouymd06(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getDai1sibousnenoutouymd06())));
        bzHokenSyoukenLayoutFile.setIfeTsdai1stuuktype06(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getDai1stuuktype06())));
        bzHokenSyoukenLayoutFile.setIfeTsdai1s06(convertTestData.setNull(setBizCurrencyVal(pHokenSyouken.getDai1s06())));
        bzHokenSyoukenLayoutFile.setIfeTsdai1s06t(convertTestData.setNull(setBizCurrencyType(pHokenSyouken.getDai1s06())));
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyendakaumu06(convertTestData.setNull(
            pHokenSyouken.getDai1syenyendakaumu06()));
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyenkijyunumu06(convertTestData.setNull(
            pHokenSyouken.getDai1syenyenkijyunumu06()));
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyenyasuumu06(convertTestData.setNull(
            pHokenSyouken.getDai1syenyenyasuumu06()));
        bzHokenSyoukenLayoutFile.setIfeTsdai1syentuuktype06(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getDai1syentuuktype06())));
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyendaka06(convertTestData.setNull(setBizCurrencyVal(pHokenSyouken.getDai1syenyendaka06())));
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyendaka06t(convertTestData.setNull(setBizCurrencyType(pHokenSyouken.getDai1syenyendaka06())));
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyenkijyun06(convertTestData.setNull(setBizCurrencyVal(pHokenSyouken.getDai1syenyenkijyun06())));
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyenkijyun06t(convertTestData.setNull(setBizCurrencyType(pHokenSyouken.getDai1syenyenkijyun06())));
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyenyasu06(convertTestData.setNull(setBizCurrencyVal(pHokenSyouken.getDai1syenyenyasu06())));
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyenyasu06t(convertTestData.setNull(setBizCurrencyType(pHokenSyouken.getDai1syenyenyasu06())));
        bzHokenSyoukenLayoutFile.setIfeTsdai1skeikanensuu07(convertTestData.setNull(String.valueOf(pHokenSyouken.getDai1skeikanensuu07())));
        bzHokenSyoukenLayoutFile.setIfeTsd1sibousnenoutouymd07(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getDai1sibousnenoutouymd07())));
        bzHokenSyoukenLayoutFile.setIfeTsdai1stuuktype07(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getDai1stuuktype07())));
        bzHokenSyoukenLayoutFile.setIfeTsdai1s07(convertTestData.setNull(setBizCurrencyVal(pHokenSyouken.getDai1s07())));
        bzHokenSyoukenLayoutFile.setIfeTsdai1s07t(convertTestData.setNull(setBizCurrencyType(pHokenSyouken.getDai1s07())));
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyendakaumu07(convertTestData.setNull(
            pHokenSyouken.getDai1syenyendakaumu07()));
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyenkijyunumu07(convertTestData.setNull(
            pHokenSyouken.getDai1syenyenkijyunumu07()));
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyenyasuumu07(convertTestData.setNull(
            pHokenSyouken.getDai1syenyenyasuumu07()));
        bzHokenSyoukenLayoutFile.setIfeTsdai1syentuuktype07(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getDai1syentuuktype07())));
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyendaka07(convertTestData.setNull(setBizCurrencyVal(pHokenSyouken.getDai1syenyendaka07())));
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyendaka07t(convertTestData.setNull(setBizCurrencyType(pHokenSyouken.getDai1syenyendaka07())));
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyenkijyun07(convertTestData.setNull(setBizCurrencyVal(pHokenSyouken.getDai1syenyenkijyun07())));
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyenkijyun07t(convertTestData.setNull(setBizCurrencyType(pHokenSyouken.getDai1syenyenkijyun07())));
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyenyasu07(convertTestData.setNull(setBizCurrencyVal(pHokenSyouken.getDai1syenyenyasu07())));
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyenyasu07t(convertTestData.setNull(setBizCurrencyType(pHokenSyouken.getDai1syenyenyasu07())));
        bzHokenSyoukenLayoutFile.setIfeTsdai1skeikanensuu08(convertTestData.setNull(String.valueOf(pHokenSyouken.getDai1skeikanensuu08())));
        bzHokenSyoukenLayoutFile.setIfeTsd1sibousnenoutouymd08(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getDai1sibousnenoutouymd08())));
        bzHokenSyoukenLayoutFile.setIfeTsdai1stuuktype08(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getDai1stuuktype08())));
        bzHokenSyoukenLayoutFile.setIfeTsdai1s08(convertTestData.setNull(setBizCurrencyVal(pHokenSyouken.getDai1s08())));
        bzHokenSyoukenLayoutFile.setIfeTsdai1s08t(convertTestData.setNull(setBizCurrencyType(pHokenSyouken.getDai1s08())));
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyendakaumu08(convertTestData.setNull(
            pHokenSyouken.getDai1syenyendakaumu08()));
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyenkijyunumu08(convertTestData.setNull(
            pHokenSyouken.getDai1syenyenkijyunumu08()));
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyenyasuumu08(convertTestData.setNull(
            pHokenSyouken.getDai1syenyenyasuumu08()));
        bzHokenSyoukenLayoutFile.setIfeTsdai1syentuuktype08(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getDai1syentuuktype08())));
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyendaka08(convertTestData.setNull(setBizCurrencyVal(pHokenSyouken.getDai1syenyendaka08())));
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyendaka08t(convertTestData.setNull(setBizCurrencyType(pHokenSyouken.getDai1syenyendaka08())));
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyenkijyun08(convertTestData.setNull(setBizCurrencyVal(pHokenSyouken.getDai1syenyenkijyun08())));
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyenkijyun08t(convertTestData.setNull(setBizCurrencyType(pHokenSyouken.getDai1syenyenkijyun08())));
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyenyasu08(convertTestData.setNull(setBizCurrencyVal(pHokenSyouken.getDai1syenyenyasu08())));
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyenyasu08t(convertTestData.setNull(setBizCurrencyType(pHokenSyouken.getDai1syenyenyasu08())));
        bzHokenSyoukenLayoutFile.setIfeTsdai1skeikanensuu09(convertTestData.setNull(String.valueOf(pHokenSyouken.getDai1skeikanensuu09())));
        bzHokenSyoukenLayoutFile.setIfeTsd1sibousnenoutouymd09(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getDai1sibousnenoutouymd09())));
        bzHokenSyoukenLayoutFile.setIfeTsdai1stuuktype09(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getDai1stuuktype09())));
        bzHokenSyoukenLayoutFile.setIfeTsdai1s09(convertTestData.setNull(setBizCurrencyVal(pHokenSyouken.getDai1s09())));
        bzHokenSyoukenLayoutFile.setIfeTsdai1s09t(convertTestData.setNull(setBizCurrencyType(pHokenSyouken.getDai1s09())));
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyendakaumu09(convertTestData.setNull(
            pHokenSyouken.getDai1syenyendakaumu09()));
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyenkijyunumu09(convertTestData.setNull(
            pHokenSyouken.getDai1syenyenkijyunumu09()));
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyenyasuumu09(convertTestData.setNull(
            pHokenSyouken.getDai1syenyenyasuumu09()));
        bzHokenSyoukenLayoutFile.setIfeTsdai1syentuuktype09(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getDai1syentuuktype09())));
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyendaka09(convertTestData.setNull(setBizCurrencyVal(pHokenSyouken.getDai1syenyendaka09())));
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyendaka09t(convertTestData.setNull(setBizCurrencyType(pHokenSyouken.getDai1syenyendaka09())));
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyenkijyun09(convertTestData.setNull(setBizCurrencyVal(pHokenSyouken.getDai1syenyenkijyun09())));
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyenkijyun09t(convertTestData.setNull(setBizCurrencyType(pHokenSyouken.getDai1syenyenkijyun09())));
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyenyasu09(convertTestData.setNull(setBizCurrencyVal(pHokenSyouken.getDai1syenyenyasu09())));
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyenyasu09t(convertTestData.setNull(setBizCurrencyType(pHokenSyouken.getDai1syenyenyasu09())));
        bzHokenSyoukenLayoutFile.setIfeTsdai1skeikanensuu10(convertTestData.setNull(String.valueOf(pHokenSyouken.getDai1skeikanensuu10())));
        bzHokenSyoukenLayoutFile.setIfeTsd1sibousnenoutouymd10(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getDai1sibousnenoutouymd10())));
        bzHokenSyoukenLayoutFile.setIfeTsdai1stuuktype10(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getDai1stuuktype10())));
        bzHokenSyoukenLayoutFile.setIfeTsdai1s10(convertTestData.setNull(setBizCurrencyVal(pHokenSyouken.getDai1s10())));
        bzHokenSyoukenLayoutFile.setIfeTsdai1s10t(convertTestData.setNull(setBizCurrencyType(pHokenSyouken.getDai1s10())));
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyendakaumu10(convertTestData.setNull(
            pHokenSyouken.getDai1syenyendakaumu10()));
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyenkijyunumu10(convertTestData.setNull(
            pHokenSyouken.getDai1syenyenkijyunumu10()));
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyenyasuumu10(convertTestData.setNull(
            pHokenSyouken.getDai1syenyenyasuumu10()));
        bzHokenSyoukenLayoutFile.setIfeTsdai1syentuuktype10(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getDai1syentuuktype10())));
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyendaka10(convertTestData.setNull(setBizCurrencyVal(pHokenSyouken.getDai1syenyendaka10())));
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyendaka10t(convertTestData.setNull(setBizCurrencyType(pHokenSyouken.getDai1syenyendaka10())));
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyenkijyun10(convertTestData.setNull(setBizCurrencyVal(pHokenSyouken.getDai1syenyenkijyun10())));
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyenkijyun10t(convertTestData.setNull(setBizCurrencyType(pHokenSyouken.getDai1syenyenkijyun10())));
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyenyasu10(convertTestData.setNull(setBizCurrencyVal(pHokenSyouken.getDai1syenyenyasu10())));
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyenyasu10t(convertTestData.setNull(setBizCurrencyType(pHokenSyouken.getDai1syenyenyasu10())));
        bzHokenSyoukenLayoutFile.setIfeTsdai1stuuktypehuryo(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getDai1stuuktypehuryo())));
        bzHokenSyoukenLayoutFile.setIfeTsdai1shuryo(convertTestData.setNull(setBizCurrencyVal(pHokenSyouken.getDai1shuryo())));
        bzHokenSyoukenLayoutFile.setIfeTsdai1shuryot(convertTestData.setNull(setBizCurrencyType(pHokenSyouken.getDai1shuryo())));
        bzHokenSyoukenLayoutFile.setIfeTsd1syenyendakaumuhuryo(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getDai1syenyendakaumuhuryo())));
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyenkjnumuhuryo(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getDai1syenyenkjnumuhuryo())));
        bzHokenSyoukenLayoutFile.setIfeTsd1syenyenyasuumuhuryo(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getDai1syenyenyasuumuhuryo())));
        bzHokenSyoukenLayoutFile.setIfeTsdai1syentuuktypehuryo(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getDai1syentuuktypehuryo())));
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyendakahuryo(convertTestData.setNull(setBizCurrencyVal(pHokenSyouken.getDai1syenyendakahuryo())));
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyendakahuryot(convertTestData.setNull(setBizCurrencyType(pHokenSyouken.getDai1syenyendakahuryo())));
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyenkijyunhuryo(convertTestData.setNull(setBizCurrencyVal(pHokenSyouken.getDai1syenyenkijyunhuryo())));
        bzHokenSyoukenLayoutFile.setIfeTsd1syenyenkijyunhuryot(convertTestData.setNull(setBizCurrencyType(pHokenSyouken.getDai1syenyenkijyunhuryo())));
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyenyasuhuryo(convertTestData.setNull(setBizCurrencyVal(pHokenSyouken.getDai1syenyenyasuhuryo())));
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyenyasuhuryot(convertTestData.setNull(setBizCurrencyType(pHokenSyouken.getDai1syenyenyasuhuryo())));
        bzHokenSyoukenLayoutFile.setIfeTsinitsbjiyenkasthsygk(convertTestData.setNull(setBizCurrencyVal(pHokenSyouken.getInitsbjiyenkasaiteihsygk())));
        bzHokenSyoukenLayoutFile.setIfeTsinitsbjiyenkasthsygkt(convertTestData.setNull(setBizCurrencyType(pHokenSyouken.getInitsbjiyenkasaiteihsygk())));
        bzHokenSyoukenLayoutFile.setIfeTsdai2stuuktype(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getDai2stuuktype())));
        bzHokenSyoukenLayoutFile.setIfeTsdai2s(convertTestData.setNull(setBizCurrencyVal(pHokenSyouken.getDai2s())));
        bzHokenSyoukenLayoutFile.setIfeTsdai2st(convertTestData.setNull(setBizCurrencyType(pHokenSyouken.getDai2s())));
        bzHokenSyoukenLayoutFile.setIfeTsdai2syentuuktype(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getDai2syentuuktype())));
        bzHokenSyoukenLayoutFile.setIfeTsdai2syenyendaka(convertTestData.setNull(setBizCurrencyVal(pHokenSyouken.getDai2syenyendaka())));
        bzHokenSyoukenLayoutFile.setIfeTsdai2syenyendakat(convertTestData.setNull(setBizCurrencyType(pHokenSyouken.getDai2syenyendaka())));
        bzHokenSyoukenLayoutFile.setIfeTsdai2syenyenkijyun(convertTestData.setNull(setBizCurrencyVal(pHokenSyouken.getDai2syenyenkijyun())));
        bzHokenSyoukenLayoutFile.setIfeTsdai2syenyenkijyunt(convertTestData.setNull(setBizCurrencyType(pHokenSyouken.getDai2syenyenkijyun())));
        bzHokenSyoukenLayoutFile.setIfeTsdai2syenyenyasu(convertTestData.setNull(setBizCurrencyVal(pHokenSyouken.getDai2syenyenyasu())));
        bzHokenSyoukenLayoutFile.setIfeTsdai2syenyenyasut(convertTestData.setNull(setBizCurrencyType(pHokenSyouken.getDai2syenyenyasu())));
        bzHokenSyoukenLayoutFile.setIfeTsdai3stuuktype(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getDai3stuuktype())));
        bzHokenSyoukenLayoutFile.setIfeTsdai3s(convertTestData.setNull(setBizCurrencyVal(pHokenSyouken.getDai3s())));
        bzHokenSyoukenLayoutFile.setIfeTsdai3st(convertTestData.setNull(setBizCurrencyType(pHokenSyouken.getDai3s())));
        bzHokenSyoukenLayoutFile.setIfeTsdai3syentuuktype(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getDai3syentuuktype())));
        bzHokenSyoukenLayoutFile.setIfeTsdai3syenyendaka(convertTestData.setNull(setBizCurrencyVal(pHokenSyouken.getDai3syenyendaka())));
        bzHokenSyoukenLayoutFile.setIfeTsdai3syenyendakat(convertTestData.setNull(setBizCurrencyType(pHokenSyouken.getDai3syenyendaka())));
        bzHokenSyoukenLayoutFile.setIfeTsdai3syenyenkijyun(convertTestData.setNull(setBizCurrencyVal(pHokenSyouken.getDai3syenyenkijyun())));
        bzHokenSyoukenLayoutFile.setIfeTsdai3syenyenkijyunt(convertTestData.setNull(setBizCurrencyType(pHokenSyouken.getDai3syenyenkijyun())));
        bzHokenSyoukenLayoutFile.setIfeTsdai3syenyenyasu(convertTestData.setNull(setBizCurrencyVal(pHokenSyouken.getDai3syenyenyasu())));
        bzHokenSyoukenLayoutFile.setIfeTsdai3syenyenyasut(convertTestData.setNull(setBizCurrencyType(pHokenSyouken.getDai3syenyenyasu())));
        bzHokenSyoukenLayoutFile.setIfeTssibouinjiptnkbn(convertTestData.setNull(pHokenSyouken.getSibouinjiptnkbn()));
        bzHokenSyoukenLayoutFile.setIfeTsmkhyouyensysnikoumsgcd(convertTestData.setNull(
            pHokenSyouken.getMkhyouyensysnikoumsgcd()));
        bzHokenSyoukenLayoutFile.setIfeTsmkhyyensysnikoumsgcd2(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getMkhyouyensysnikoumsgcd2())));
        bzHokenSyoukenLayoutFile.setIfeTsmkhyyensysnikoumsgcd3(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getMkhyouyensysnikoumsgcd3())));
        bzHokenSyoukenLayoutFile.setIfeTsmkhyyensysnikougktype(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getMkhyouyensysnikougktype())));
        bzHokenSyoukenLayoutFile.setIfeTsmkhyouyensysnikougk(convertTestData.setNull(setBizCurrencyVal(pHokenSyouken.getMkhyouyensysnikougk())));
        bzHokenSyoukenLayoutFile.setIfeTsmkhyouyensysnikougkt(convertTestData.setNull(setBizCurrencyType(pHokenSyouken.getMkhyouyensysnikougk())));
        bzHokenSyoukenLayoutFile.setIfeTsmkhyouyensysnikouwra(convertTestData.setNull(String.valueOf(pHokenSyouken.getMkhyouyensysnikouwra())));
        bzHokenSyoukenLayoutFile.setIfeTskaigomaehrtkykmsgcd1(convertTestData.setNull(
            pHokenSyouken.getKaigomaehrtkykmsgcd1()));
        bzHokenSyoukenLayoutFile.setIfeTskaigomaehrtkykmsgcd2(convertTestData.setNull(
            pHokenSyouken.getKaigomaehrtkykmsgcd2()));
        bzHokenSyoukenLayoutFile.setIfeTskaigomaehrtkykmsgcdst1(convertTestData.setNull(
            pHokenSyouken.getKaigomaehrtkykmsgcdst1()));
        bzHokenSyoukenLayoutFile.setIfeTskaigomaehrtkykmsgcdst2(convertTestData.setNull(
            pHokenSyouken.getKaigomaehrtkykmsgcdst2()));
        bzHokenSyoukenLayoutFile.setIfeTskaigomaehruktgkumu(convertTestData.setNull(pHokenSyouken.getKaigomaehruktgkumu()));
        bzHokenSyoukenLayoutFile.setIfeTskaigomaehrtkykkyktuuka(convertTestData.setNull(
            pHokenSyouken.getKaigomaehrtkykkyktuuka()));
        bzHokenSyoukenLayoutFile.setIfeTskaigomaehrtkykstdmsgcd(convertTestData.setNull(
            pHokenSyouken.getKaigomaehrtkykstdmsgcd()));
        bzHokenSyoukenLayoutFile.setIfeTskaigomaehrjrugktype(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getKaigomaehrjrugktype())));
        bzHokenSyoukenLayoutFile.setIfeTskgomaehrsikuhhknnen01(convertTestData.setNull(String.valueOf(pHokenSyouken.getKaigomaehrsikuhhknnen01())));
        bzHokenSyoukenLayoutFile.setIfeTskaigomaehrstikkn01(convertTestData.setNull(String.valueOf(pHokenSyouken.getKaigomaehrstikkn01())));
        bzHokenSyoukenLayoutFile.setIfeTskaigomaehrjrugk01(convertTestData.setNull(setBizCurrencyVal(pHokenSyouken.getKaigomaehrjrugk01())));
        bzHokenSyoukenLayoutFile.setIfeTskaigomaehrjrugk01t(convertTestData.setNull(setBizCurrencyType(pHokenSyouken.getKaigomaehrjrugk01())));
        bzHokenSyoukenLayoutFile.setIfeTskgomaehrsikuhhknnen02(convertTestData.setNull(String.valueOf(pHokenSyouken.getKaigomaehrsikuhhknnen02())));
        bzHokenSyoukenLayoutFile.setIfeTskaigomaehrstikkn02(convertTestData.setNull(String.valueOf(pHokenSyouken.getKaigomaehrstikkn02())));
        bzHokenSyoukenLayoutFile.setIfeTskaigomaehrjrugk02(convertTestData.setNull(setBizCurrencyVal(pHokenSyouken.getKaigomaehrjrugk02())));
        bzHokenSyoukenLayoutFile.setIfeTskaigomaehrjrugk02t(convertTestData.setNull(setBizCurrencyType(pHokenSyouken.getKaigomaehrjrugk02())));
        bzHokenSyoukenLayoutFile.setIfeTskgomaehrsikuhhknnen03(convertTestData.setNull(String.valueOf(pHokenSyouken.getKaigomaehrsikuhhknnen03())));
        bzHokenSyoukenLayoutFile.setIfeTskaigomaehrstikkn03(convertTestData.setNull(String.valueOf(pHokenSyouken.getKaigomaehrstikkn03())));
        bzHokenSyoukenLayoutFile.setIfeTskaigomaehrjrugk03(convertTestData.setNull(setBizCurrencyVal(pHokenSyouken.getKaigomaehrjrugk03())));
        bzHokenSyoukenLayoutFile.setIfeTskaigomaehrjrugk03t(convertTestData.setNull(setBizCurrencyType(pHokenSyouken.getKaigomaehrjrugk03())));
        bzHokenSyoukenLayoutFile.setIfeTskgomaehrsikuhhknnen04(convertTestData.setNull(String.valueOf(pHokenSyouken.getKaigomaehrsikuhhknnen04())));
        bzHokenSyoukenLayoutFile.setIfeTskaigomaehrstikkn04(convertTestData.setNull(String.valueOf(pHokenSyouken.getKaigomaehrstikkn04())));
        bzHokenSyoukenLayoutFile.setIfeTskaigomaehrjrugk04(convertTestData.setNull(setBizCurrencyVal(pHokenSyouken.getKaigomaehrjrugk04())));
        bzHokenSyoukenLayoutFile.setIfeTskaigomaehrjrugk04t(convertTestData.setNull(setBizCurrencyType(pHokenSyouken.getKaigomaehrjrugk04())));
        bzHokenSyoukenLayoutFile.setIfeTskgomaehrsikuhhknnen05(convertTestData.setNull(String.valueOf(pHokenSyouken.getKaigomaehrsikuhhknnen05())));
        bzHokenSyoukenLayoutFile.setIfeTskaigomaehrstikkn05(convertTestData.setNull(String.valueOf(pHokenSyouken.getKaigomaehrstikkn05())));
        bzHokenSyoukenLayoutFile.setIfeTskaigomaehrjrugk05(convertTestData.setNull(setBizCurrencyVal(pHokenSyouken.getKaigomaehrjrugk05())));
        bzHokenSyoukenLayoutFile.setIfeTskaigomaehrjrugk05t(convertTestData.setNull(setBizCurrencyType(pHokenSyouken.getKaigomaehrjrugk05())));
        bzHokenSyoukenLayoutFile.setIfeTskgomaehrsikuhhknnen06(convertTestData.setNull(String.valueOf(pHokenSyouken.getKaigomaehrsikuhhknnen06())));
        bzHokenSyoukenLayoutFile.setIfeTskaigomaehrstikkn06(convertTestData.setNull(String.valueOf(pHokenSyouken.getKaigomaehrstikkn06())));
        bzHokenSyoukenLayoutFile.setIfeTskaigomaehrjrugk06(convertTestData.setNull(setBizCurrencyVal(pHokenSyouken.getKaigomaehrjrugk06())));
        bzHokenSyoukenLayoutFile.setIfeTskaigomaehrjrugk06t(convertTestData.setNull(setBizCurrencyType(pHokenSyouken.getKaigomaehrjrugk06())));
        bzHokenSyoukenLayoutFile.setIfeTskgomaehrsikuhhknnen07(convertTestData.setNull(String.valueOf(pHokenSyouken.getKaigomaehrsikuhhknnen07())));
        bzHokenSyoukenLayoutFile.setIfeTskaigomaehrstikkn07(convertTestData.setNull(String.valueOf(pHokenSyouken.getKaigomaehrstikkn07())));
        bzHokenSyoukenLayoutFile.setIfeTskaigomaehrjrugk07(convertTestData.setNull(setBizCurrencyVal(pHokenSyouken.getKaigomaehrjrugk07())));
        bzHokenSyoukenLayoutFile.setIfeTskaigomaehrjrugk07t(convertTestData.setNull(setBizCurrencyType(pHokenSyouken.getKaigomaehrjrugk07())));
        bzHokenSyoukenLayoutFile.setIfeTskgomaehrsikuhhknnen08(convertTestData.setNull(String.valueOf(pHokenSyouken.getKaigomaehrsikuhhknnen08())));
        bzHokenSyoukenLayoutFile.setIfeTskaigomaehrstikkn08(convertTestData.setNull(String.valueOf(pHokenSyouken.getKaigomaehrstikkn08())));
        bzHokenSyoukenLayoutFile.setIfeTskaigomaehrjrugk08(convertTestData.setNull(setBizCurrencyVal(pHokenSyouken.getKaigomaehrjrugk08())));
        bzHokenSyoukenLayoutFile.setIfeTskaigomaehrjrugk08t(convertTestData.setNull(setBizCurrencyType(pHokenSyouken.getKaigomaehrjrugk08())));
        bzHokenSyoukenLayoutFile.setIfeTskgomaehrsikuhhknnen09(convertTestData.setNull(String.valueOf(pHokenSyouken.getKaigomaehrsikuhhknnen09())));
        bzHokenSyoukenLayoutFile.setIfeTskaigomaehrstikkn09(convertTestData.setNull(String.valueOf(pHokenSyouken.getKaigomaehrstikkn09())));
        bzHokenSyoukenLayoutFile.setIfeTskaigomaehrjrugk09(convertTestData.setNull(setBizCurrencyVal(pHokenSyouken.getKaigomaehrjrugk09())));
        bzHokenSyoukenLayoutFile.setIfeTskaigomaehrjrugk09t(convertTestData.setNull(setBizCurrencyType(pHokenSyouken.getKaigomaehrjrugk09())));
        bzHokenSyoukenLayoutFile.setIfeTskgomaehrsikuhhknnen10(convertTestData.setNull(String.valueOf(pHokenSyouken.getKaigomaehrsikuhhknnen10())));
        bzHokenSyoukenLayoutFile.setIfeTskaigomaehrstikkn10(convertTestData.setNull(String.valueOf(pHokenSyouken.getKaigomaehrstikkn10())));
        bzHokenSyoukenLayoutFile.setIfeTskaigomaehrjrugk10(convertTestData.setNull(setBizCurrencyVal(pHokenSyouken.getKaigomaehrjrugk10())));
        bzHokenSyoukenLayoutFile.setIfeTskaigomaehrjrugk10t(convertTestData.setNull(setBizCurrencyType(pHokenSyouken.getKaigomaehrjrugk10())));
        bzHokenSyoukenLayoutFile.setIfeTshutanhiyustmmsgcdue01(convertTestData.setNull(
            pHokenSyouken.getHutanhiyustmmsgcdue01()));
        bzHokenSyoukenLayoutFile.setIfeTshutanhiyustmmsgcdue02(convertTestData.setNull(
            pHokenSyouken.getHutanhiyustmmsgcdue02()));
        bzHokenSyoukenLayoutFile.setIfeTshutanhiyustmmsgcdue03(convertTestData.setNull(
            pHokenSyouken.getHutanhiyustmmsgcdue03()));
        bzHokenSyoukenLayoutFile.setIfeTshutanhiyustmmsgcdue04(convertTestData.setNull(
            pHokenSyouken.getHutanhiyustmmsgcdue04()));
        bzHokenSyoukenLayoutFile.setIfeTshutanhiyustmknsnhyuptn(convertTestData.setNull(
            pHokenSyouken.getHutanhiyustmknsnhyuptn()));
        bzHokenSyoukenLayoutFile.setIfeTshutanhiyustmmsgcdst01(convertTestData.setNull(
            pHokenSyouken.getHutanhiyustmmsgcdst01()));
        bzHokenSyoukenLayoutFile.setIfeTshutanhiyustmmsgcdst02(convertTestData.setNull(
            pHokenSyouken.getHutanhiyustmmsgcdst02()));
        bzHokenSyoukenLayoutFile.setIfeTshutanhiyustmmsgcdst03(convertTestData.setNull(
            pHokenSyouken.getHutanhiyustmmsgcdst03()));
        bzHokenSyoukenLayoutFile.setIfeTsstdstmmsgcd(convertTestData.setNull(pHokenSyouken.getStdstmmsgcd()));
        bzHokenSyoukenLayoutFile.setIfeTsfstpmsgcd(convertTestData.setNull(pHokenSyouken.getFstpmsgcd()));
        bzHokenSyoukenLayoutFile.setIfeTsfstphrkpkngkketuuktype(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getFstphrkpkngkkeituuktype())));
        bzHokenSyoukenLayoutFile.setIfeTsfstphrkpkngkkei(convertTestData.setNull(setBizCurrencyVal(pHokenSyouken.getFstphrkpkngkkei())));
        bzHokenSyoukenLayoutFile.setIfeTsfstphrkpkngkkeit(convertTestData.setNull(setBizCurrencyType(pHokenSyouken.getFstphrkpkngkkei())));
        bzHokenSyoukenLayoutFile.setIfeTsfstponegaimsgcd(convertTestData.setNull(pHokenSyouken.getFstponegaimsgcd()));
        bzHokenSyoukenLayoutFile.setIfeTsdsmsgcd(convertTestData.setNull(pHokenSyouken.getDsmsgcd()));
        bzHokenSyoukenLayoutFile.setIfeTssyouhnhutaimsgcd1(convertTestData.setNull(pHokenSyouken.getSyouhnhutaimsgcd1()));
        bzHokenSyoukenLayoutFile.setIfeTssyouhnhutaimsgcd2(convertTestData.setNull(pHokenSyouken.getSyouhnhutaimsgcd2()));
        bzHokenSyoukenLayoutFile.setIfeTspyentuuktype(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getPyentuuktype())));
        bzHokenSyoukenLayoutFile.setIfeTspyen(convertTestData.setNull(setBizCurrencyVal(pHokenSyouken.getPyen())));
        bzHokenSyoukenLayoutFile.setIfeTspyent(convertTestData.setNull(setBizCurrencyType(pHokenSyouken.getPyen())));
        bzHokenSyoukenLayoutFile.setIfeTstoiawasesakihanyomsgcd(convertTestData.setNull(
            pHokenSyouken.getToiawasesakihanyoumsgcd()));
        bzHokenSyoukenLayoutFile.setIfeTsannaihanyoumsgcd(convertTestData.setNull(pHokenSyouken.getAnnaihanyoumsgcd()));
        bzHokenSyoukenLayoutFile.setIfeTswmsgcd1(convertTestData.setNull(pHokenSyouken.getWmsgcd1()));
        bzHokenSyoukenLayoutFile.setIfeTswmsgcd2(convertTestData.setNull(pHokenSyouken.getWmsgcd2()));
        bzHokenSyoukenLayoutFile.setIfeTswmsgcd3(convertTestData.setNull(pHokenSyouken.getWmsgcd3()));
        bzHokenSyoukenLayoutFile.setIfeTswtyuuijikoumsgcd1(convertTestData.setNull(pHokenSyouken.getWtyuuijikoumsgcd1()));
        bzHokenSyoukenLayoutFile.setIfeTswtyuuijikoumsgcd2(convertTestData.setNull(pHokenSyouken.getWtyuuijikoumsgcd2()));
        bzHokenSyoukenLayoutFile.setIfeTswtyuuijikoumsgcd3(convertTestData.setNull(pHokenSyouken.getWtyuuijikoumsgcd3()));
        bzHokenSyoukenLayoutFile.setIfeTswtyuuijikoumsgcd4(convertTestData.setNull(pHokenSyouken.getWtyuuijikoumsgcd4()));
        bzHokenSyoukenLayoutFile.setIfeTswtyuuijikoumsgcd5(convertTestData.setNull(pHokenSyouken.getWtyuuijikoumsgcd5()));
        bzHokenSyoukenLayoutFile.setIfeTswitijibrptuktype(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getWitijibrptuktype())));
        bzHokenSyoukenLayoutFile.setIfeTswitijibrp(convertTestData.setNull(setBizCurrencyVal(pHokenSyouken.getWitijibrp())));
        bzHokenSyoukenLayoutFile.setIfeTswitijibrpt(convertTestData.setNull(setBizCurrencyType(pHokenSyouken.getWitijibrp())));
        bzHokenSyoukenLayoutFile.setIfeTswyenhrkgktuktype(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getWyenhrkgktuktype())));
        bzHokenSyoukenLayoutFile.setIfeTswyenhrkgk(convertTestData.setNull(setBizCurrencyVal(pHokenSyouken.getWyenhrkgk())));
        bzHokenSyoukenLayoutFile.setIfeTswyenhrkgkt(convertTestData.setNull(setBizCurrencyType(pHokenSyouken.getWyenhrkgk())));
        bzHokenSyoukenLayoutFile.setIfeTswyenitijibrptuktype(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getWyenitijibrptuktype())));
        bzHokenSyoukenLayoutFile.setIfeTswyenitijibrp(convertTestData.setNull(setBizCurrencyVal(pHokenSyouken.getWyenitijibrp())));
        bzHokenSyoukenLayoutFile.setIfeTswyenitijibrpt(convertTestData.setNull(setBizCurrencyType(pHokenSyouken.getWyenitijibrp())));
        bzHokenSyoukenLayoutFile.setIfeTskoujyosyoumeimsgcd1(convertTestData.setNull(
            pHokenSyouken.getKoujyosyoumeimsgcd1()));
        bzHokenSyoukenLayoutFile.setIfeTskoujyosyoumeimsgcd2(convertTestData.setNull(
            pHokenSyouken.getKoujyosyoumeimsgcd2()));
        bzHokenSyoukenLayoutFile.setIfeTskoujyosyoumeimsgcd3(convertTestData.setNull(
            pHokenSyouken.getKoujyosyoumeimsgcd3()));
        bzHokenSyoukenLayoutFile.setIfeTskoujyosyoumeihskmsgcd(convertTestData.setNull(
            pHokenSyouken.getKoujyosyoumeihskmsgcd()));
        bzHokenSyoukenLayoutFile.setIfeTsnenkoujyosyoumhskmsgcd(convertTestData.setNull(
            pHokenSyouken.getNenkoujyosyoumeihskmsgcd()));
        bzHokenSyoukenLayoutFile.setIfeTstokusyusyorinaiyoukbn1(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getTokusyusyorinaiyoukbn1())));
        bzHokenSyoukenLayoutFile.setIfeTstokusyusyorinaiyoukbn2(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getTokusyusyorinaiyoukbn2())));
        bzHokenSyoukenLayoutFile.setIfeTstokusyusyorinaiyoukbn3(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getTokusyusyorinaiyoukbn3())));
        bzHokenSyoukenLayoutFile.setIfeTstokusyusyorinaiyoukbn4(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getTokusyusyorinaiyoukbn4())));
        bzHokenSyoukenLayoutFile.setIfeTstokusyusyorinaiyoukbn5(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getTokusyusyorinaiyoukbn5())));
        bzHokenSyoukenLayoutFile.setIfeTstokusyusyorinaiyoukbn6(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getTokusyusyorinaiyoukbn6())));
        bzHokenSyoukenLayoutFile.setIfeTstokusyusyorinaiyoukbn7(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getTokusyusyorinaiyoukbn7())));
        bzHokenSyoukenLayoutFile.setIfeTstokusyusyorinaiyoukbn8(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getTokusyusyorinaiyoukbn8())));
        bzHokenSyoukenLayoutFile.setIfeTstokusyusyorinaiyoukbn9(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getTokusyusyorinaiyoukbn9())));
        bzHokenSyoukenLayoutFile.setIfeTstokusyusyorinaiyokbn10(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getTokusyusyorinaiyoukbn10())));
        bzHokenSyoukenLayoutFile.setIfeTstokusyusyorinaiyokbn11(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getTokusyusyorinaiyoukbn11())));
        bzHokenSyoukenLayoutFile.setIfeTstokusyusyorinaiyokbn12(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getTokusyusyorinaiyoukbn12())));
        bzHokenSyoukenLayoutFile.setIfeTstokusyusyorinaiyokbn13(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getTokusyusyorinaiyoukbn13())));
        bzHokenSyoukenLayoutFile.setIfeTstokusyusyorinaiyokbn14(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getTokusyusyorinaiyoukbn14())));
        bzHokenSyoukenLayoutFile.setIfeTstokusyusyorinaiyokbn15(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getTokusyusyorinaiyoukbn15())));
        bzHokenSyoukenLayoutFile.setIfeTstokusyusyorinaiyokbn16(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getTokusyusyorinaiyoukbn16())));
        bzHokenSyoukenLayoutFile.setIfeTstokusyusyorinaiyokbn17(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getTokusyusyorinaiyoukbn17())));
        bzHokenSyoukenLayoutFile.setIfeTsgyoumukousinkinou(convertTestData.setNull(pHokenSyouken.getGyoumuKousinKinou()));
        bzHokenSyoukenLayoutFile.setIfeTsgyoumukousinsyaid(convertTestData.setNull(pHokenSyouken.getGyoumuKousinsyaId()));
        bzHokenSyoukenLayoutFile.setIfeTsgyoumukousintime(convertTestData.setNull(pHokenSyouken.getGyoumuKousinTime()));
        bzHokenSyoukenLayoutFile.setIfeTskousinsyaid("init");
        bzHokenSyoukenLayoutFile.setIfeTskousintime("0");
        bzHokenSyoukenLayoutFile.setIfeTskousinkinou("init");
        bzHokenSyoukenLayoutFile.setIfeTsversion("0");
        bzHokenSyoukenLayoutFile.setIfeTskyknmkn(convertTestDataForKanaMeigi.getKnmeigi(pHokenSyouken.getKyknmkn()));
        bzHokenSyoukenLayoutFile.setIfeTshhknnmkn(convertTestDataForKanaMeigi.getKnmeigi(pHokenSyouken.getHhknnmkn()));
        bzHokenSyoukenLayoutFile.setIfeTssntnyrnnkshrstartymd(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getSonotanyrannkshrstartymd())));
        bzHokenSyoukenLayoutFile.setIfeTssonotanyrannenkinkkn(convertTestData.setNull(String.valueOf(pHokenSyouken.getSonotanyrannenkinkkn())));
        bzHokenSyoukenLayoutFile.setIfeTssntnyrnyensysnhkhnkymd(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getSonotanyranyensysnhkhnkymd())));
        bzHokenSyoukenLayoutFile.setIfeTssntnyrntumitateriritu(convertTestData.setNull(String.valueOf(pHokenSyouken.getSonotanyrantumitateriritu())));
        bzHokenSyoukenLayoutFile.setIfeTssntnyrntmttknzkrtjygn(convertTestData.setNull(String.valueOf(pHokenSyouken.getSonotanyrantmttknzkrtjygn())));
        bzHokenSyoukenLayoutFile.setIfeTssntnyrnsetteibairitu(convertTestData.setNull(String.valueOf(pHokenSyouken.getSonotanyransetteibairitu())));
        bzHokenSyoukenLayoutFile.setIfeTssntnyrntmttkngktuktype(convertTestData.setNull(
            pHokenSyouken.getSonotanyrantmttkngktuktype()));
        bzHokenSyoukenLayoutFile.setIfeTssntnyrnteirittmttkngk(convertTestData.setNull(setBizCurrencyVal(pHokenSyouken.getSonotanyranteiritutmttkngk())));
        bzHokenSyoukenLayoutFile.setIfeTssntnyrnteirittmttkngkt(convertTestData.setNull(setBizCurrencyType(pHokenSyouken.getSonotanyranteiritutmttkngk())));
        bzHokenSyoukenLayoutFile.setIfeTssntnyrnsisuutmttkngk(convertTestData.setNull(setBizCurrencyVal(pHokenSyouken.getSonotanyransisuutmttkngk())));
        bzHokenSyoukenLayoutFile.setIfeTssntnyrnsisuutmttkngkt(convertTestData.setNull(setBizCurrencyType(pHokenSyouken.getSonotanyransisuutmttkngk())));
        bzHokenSyoukenLayoutFile.setIfeTssonotanyransisuunm(convertTestData.setNull(pHokenSyouken.getSonotanyransisuunm()));
        bzHokenSyoukenLayoutFile.setIfeTskgmhrtkd1hknkknmnryymd(convertTestData.setNull(String.valueOf(
            pHokenSyouken.getKgmaehrtkdai1hknkknmnryymd())));
        bzHokenSyoukenLayoutFile.setIfeTsnkmsgcd1(convertTestData.setNull(pHokenSyouken.getNkmsgcd1()));
        bzHokenSyoukenLayoutFile.setIfeTsnkmsgcd2(convertTestData.setNull(pHokenSyouken.getNkmsgcd2()));
        bzHokenSyoukenLayoutFile.setIfeTsnkmsgcd3(convertTestData.setNull(pHokenSyouken.getNkmsgcd3()));
        bzHokenSyoukenLayoutFile.setIfeTsnkmsgcd4(convertTestData.setNull(pHokenSyouken.getNkmsgcd4()));
        bzHokenSyoukenLayoutFile.setIfeTsnkmsgcd5(convertTestData.setNull(pHokenSyouken.getNkmsgcd5()));
        bzHokenSyoukenLayoutFile.setIfeTsnkmsgcd6(convertTestData.setNull(pHokenSyouken.getNkmsgcd6()));
        bzHokenSyoukenLayoutFile.setIfeTsnkmsgcd7(convertTestData.setNull(pHokenSyouken.getNkmsgcd7()));
        bzHokenSyoukenLayoutFile.setIfeTsnkmsgcd8(convertTestData.setNull(pHokenSyouken.getNkmsgcd8()));
        bzHokenSyoukenLayoutFile.setIfeTsnkmsgcd9(convertTestData.setNull(pHokenSyouken.getNkmsgcd9()));
        bzHokenSyoukenLayoutFile.setIfeTsnkmsgcd10(convertTestData.setNull(pHokenSyouken.getNkmsgcd10()));
        bzHokenSyoukenLayoutFile.setIfeTssiboukyuuhukinmsgcd1(convertTestData.setNull(
            pHokenSyouken.getSiboukyuuhukinmsgcd1()));
        bzHokenSyoukenLayoutFile.setIfeTssiboukyuuhukinmsgcd2(convertTestData.setNull(
            pHokenSyouken.getSiboukyuuhukinmsgcd2()));
        bzHokenSyoukenLayoutFile.setIfeTssiboukyuuhukinmsgcd3(convertTestData.setNull(
            pHokenSyouken.getSiboukyuuhukinmsgcd3()));
        bzHokenSyoukenLayoutFile.setIfeTssiboukyuuhukinmsgcd4(convertTestData.setNull(
            pHokenSyouken.getSiboukyuuhukinmsgcd4()));
        bzHokenSyoukenLayoutFile.setIfeTssiboukyuuhukinmsgcd5(convertTestData.setNull(
            pHokenSyouken.getSiboukyuuhukinmsgcd5()));
        bzHokenSyoukenLayoutFile.setIfeTssiboukyuuhukinmsgcd6(convertTestData.setNull(
            pHokenSyouken.getSiboukyuuhukinmsgcd6()));
        bzHokenSyoukenLayoutFile.setIfeTssiboukyuuhukinmsgcd7(convertTestData.setNull(
            pHokenSyouken.getSiboukyuuhukinmsgcd7()));
        bzHokenSyoukenLayoutFile.setIfeTssiboukyuuhukinmsgcd8(convertTestData.setNull(
            pHokenSyouken.getSiboukyuuhukinmsgcd8()));
        bzHokenSyoukenLayoutFile.setIfeTssiboukyuuhukinmsgcd9(convertTestData.setNull(
            pHokenSyouken.getSiboukyuuhukinmsgcd9()));
        bzHokenSyoukenLayoutFile.setIfeTssiboukyuuhukinmsgcd10(convertTestData.setNull(
            pHokenSyouken.getSiboukyuuhukinmsgcd10()));
        bzHokenSyoukenLayoutFile.setIfeTsnkshrstartzenymd(convertTestData.setNull(pHokenSyouken.getNkshrstartzenymd()));
        bzHokenSyoukenLayoutFile.setIfeTsmkhyyennkhknhntktype(convertTestData.setNull(
            pHokenSyouken.getMkhyouyennkhknhentktype()));
        bzHokenSyoukenLayoutFile.setIfeTsmkhyyennkhknhntkmkhgk(convertTestData.setNull(setBizCurrencyVal(pHokenSyouken.getMkhyouyennkhknhentkmkhgk())));
        bzHokenSyoukenLayoutFile.setIfeTsmkhyyennkhknhntkmkhgkt(convertTestData.setNull(setBizCurrencyType(pHokenSyouken.getMkhyouyennkhknhentkmkhgk())));
        bzHokenSyoukenLayoutFile.setIfeTsmkhyyennkhknhntkmkhwar(convertTestData.setNull(String.valueOf(pHokenSyouken.getMkhyouyennkhknhentkmkhwari())));
        bzHokenSyoukenLayoutFile.setIfeTshaibunwarimsgcd1(convertTestData.setNull(pHokenSyouken.getHaibunwarimsgcd1()));
        bzHokenSyoukenLayoutFile.setIfeTshaibunwarimsgcd2(convertTestData.setNull(pHokenSyouken.getHaibunwarimsgcd2()));
        bzHokenSyoukenLayoutFile.setIfeTshaibunwarimsgcd3(convertTestData.setNull(pHokenSyouken.getHaibunwarimsgcd3()));
        bzHokenSyoukenLayoutFile.setIfeTsteiritutmtthbnwr(convertTestData.setNull(String.valueOf(pHokenSyouken.getTeiritutmtthbnwr())));
        bzHokenSyoukenLayoutFile.setIfeTssisuutmtthbnwr(convertTestData.setNull(String.valueOf(pHokenSyouken.getSisuutmtthbnwr())));
        bzHokenSyoukenLayoutFile.setIfeTssisuuannaimsg1(convertTestData.setNull(pHokenSyouken.getSisuuannaimsg1()));
        bzHokenSyoukenLayoutFile.setIfeTssisuuannaimsg2(convertTestData.setNull(pHokenSyouken.getSisuuannaimsg2()));
        bzHokenSyoukenLayoutFile.setIfeTssisuuannaimsg3(convertTestData.setNull(pHokenSyouken.getSisuuannaimsg3()));
        bzHokenSyoukenLayoutFile.setIfeTshutanhiystmytijihiritu(convertTestData.setNull(String.valueOf(pHokenSyouken.getHutanhiyustmytijihiritu())));
        bzHokenSyoukenLayoutFile.setIfeTswmsgcd21(convertTestData.setNull(pHokenSyouken.getWmsgcd21()));
        bzHokenSyoukenLayoutFile.setIfeTswmsgcd22(convertTestData.setNull(pHokenSyouken.getWmsgcd22()));
        bzHokenSyoukenLayoutFile.setIfeTswmsgcd23(convertTestData.setNull(pHokenSyouken.getWmsgcd23()));
        bzHokenSyoukenLayoutFile.setIfeTswmsgcd31(convertTestData.setNull(pHokenSyouken.getWmsgcd31()));
        bzHokenSyoukenLayoutFile.setIfeTswmsgcd32(convertTestData.setNull(pHokenSyouken.getWmsgcd32()));
        bzHokenSyoukenLayoutFile.setIfeTswmsgcd33(convertTestData.setNull(pHokenSyouken.getWmsgcd33()));
        bzHokenSyoukenLayoutFile.setIfeTswmsgcdst1(convertTestData.setNull(pHokenSyouken.getWmsgcdst1()));
        bzHokenSyoukenLayoutFile.setIfeTswtyuuijikoumsgcd6(convertTestData.setNull(pHokenSyouken.getWtyuuijikoumsgcd6()));
        bzHokenSyoukenLayoutFile.setIfeTswtyuuijikoumsgcd7(convertTestData.setNull(pHokenSyouken.getWtyuuijikoumsgcd7()));
        bzHokenSyoukenLayoutFile.setIfeTstantocd(convertTestData.setNull(String.valueOf(pHokenSyouken.getTantocd())));

        return bzHokenSyoukenLayoutFile;
    }

    private BzItekiToukeiInfoLayoutFile getBzItekiToukeiInfoLayoutFile(IT_ItekiToukeiInfo pItekiToukeiInfo,
        String pSyoNo) {

        BzItekiToukeiInfoLayoutFile bzItekiToukeiInfoLayoutFile = SWAKInjector.getInstance(
            BzItekiToukeiInfoLayoutFile.class);

        ConvertTestData convertTestData = SWAKInjector.getInstance(ConvertTestData.class);

        bzItekiToukeiInfoLayoutFile.setIfeTssyono(pSyoNo);
        bzItekiToukeiInfoLayoutFile.setIfeTsketkekkacd(convertTestData.setNull(String.valueOf(
            pItekiToukeiInfo.getKetkekkacd())));
        bzItekiToukeiInfoLayoutFile.setIfeTspalketsyacd(convertTestData.setNull(pItekiToukeiInfo.getPalketsyacd()));
        bzItekiToukeiInfoLayoutFile.setIfeTskousinsyaid("init");
        bzItekiToukeiInfoLayoutFile.setIfeTskousintime("0");
        bzItekiToukeiInfoLayoutFile.setIfeTskousinkinou("init");
        bzItekiToukeiInfoLayoutFile.setIfeTsversion("0");

        return bzItekiToukeiInfoLayoutFile;
    }

    private BzKhTtdkRirekiLayoutFile getBzKhTtdkRirekiLayoutFile(IT_KhTtdkRireki pKhTtdkRireki, String pKbnkey,
        String pSyoNo) {

        BzKhTtdkRirekiLayoutFile bzKhTtdkRirekiLayoutFile = SWAKInjector.getInstance(BzKhTtdkRirekiLayoutFile.class);
        ConvertTestData convertTestData = SWAKInjector.getInstance(ConvertTestData.class);

        bzKhTtdkRirekiLayoutFile.setIfeTskbnkey(pKbnkey);
        bzKhTtdkRirekiLayoutFile.setIfeTssyono(pSyoNo);
        bzKhTtdkRirekiLayoutFile.setIfeTshenkousikibetukey(pKhTtdkRireki.getHenkousikibetukey());
        bzKhTtdkRirekiLayoutFile.setIfeTssyoriymd(convertTestData.setNull(String.valueOf(pKhTtdkRireki.getSyoriYmd())));
        bzKhTtdkRirekiLayoutFile.setIfeTssyorisosikicd(convertTestData.setNull(pKhTtdkRireki.getSyorisosikicd()));
        bzKhTtdkRirekiLayoutFile.setIfeTsshrsyousaiumu(convertTestData.setNull(String.valueOf(
            pKhTtdkRireki.getShrsyousaiumu())));
        bzKhTtdkRirekiLayoutFile.setIfeTssyorikbn(convertTestData.setNull(String.valueOf(pKhTtdkRireki.getSyorikbn())));
        bzKhTtdkRirekiLayoutFile.setIfeTshonninkakninkekkakbn(convertTestData.setNull(String.valueOf(
            pKhTtdkRireki.getHonninkakninkekkakbn())));
        bzKhTtdkRirekiLayoutFile.setIfeTshenkourrkumu(convertTestData.setNull(String.valueOf(
            pKhTtdkRireki.getHenkourrkumu())));
        bzKhTtdkRirekiLayoutFile.setIfeTssmbckanriid(setKoteiatai(pKhTtdkRireki.getSmbckanriid(), ""));
        bzKhTtdkRirekiLayoutFile.setIfeTsnayosekihontblskbtkey(convertTestData.setNull(
            pKhTtdkRireki.getNayosekihontblskbtkey()));
        bzKhTtdkRirekiLayoutFile.setIfeTskouteikanriid(convertTestData.setNull(pKhTtdkRireki.getKouteikanriid()));
        bzKhTtdkRirekiLayoutFile.setIfeTsyoukyuuno(convertTestData.setNull(pKhTtdkRireki.getYoukyuuno()));
        bzKhTtdkRirekiLayoutFile.setIfeTsgyoumukousinkinou(convertTestData.setNull(pKhTtdkRireki.getGyoumuKousinKinou()));
        bzKhTtdkRirekiLayoutFile.setIfeTsgyoumukousinsyaid(convertTestData.setNull(pKhTtdkRireki.getGyoumuKousinsyaId()));
        bzKhTtdkRirekiLayoutFile.setIfeTsgyoumukousintime(convertTestData.setNull(pKhTtdkRireki.getGyoumuKousinTime()));
        bzKhTtdkRirekiLayoutFile.setIfeTskousinsyaid("init");
        bzKhTtdkRirekiLayoutFile.setIfeTskousintime("0");
        bzKhTtdkRirekiLayoutFile.setIfeTskousinkinou("init");
        bzKhTtdkRirekiLayoutFile.setIfeTsversion("0");

        return bzKhTtdkRirekiLayoutFile;
    }

    private BzKhTtdkTyuuiLayoutFile getBzKhTtdkTyuuiLayoutFile(IT_KhTtdkTyuui pKhTtdkTyuui, String pKbnkey,
        String pSyoNo) {

        BzKhTtdkTyuuiLayoutFile bzKhTtdkTyuuiLayoutFile = SWAKInjector.getInstance(BzKhTtdkTyuuiLayoutFile.class);

        ConvertTestData convertTestData = SWAKInjector.getInstance(ConvertTestData.class);

        bzKhTtdkTyuuiLayoutFile.setIfeTskbnkey(pKbnkey);
        bzKhTtdkTyuuiLayoutFile.setIfeTssyono(pSyoNo);
        bzKhTtdkTyuuiLayoutFile.setIfeTsttdktyuuisetymd(convertTestData.setNull(String.valueOf(
            pKhTtdkTyuui.getTtdktyuuisetymd())));
        bzKhTtdkTyuuiLayoutFile.setIfeTsttdktyuuisetnm(convertTestData.setNull(pKhTtdkTyuui.getTtdktyuuisetnm()));
        bzKhTtdkTyuuiLayoutFile.setIfeTskktyuitakbn(convertTestData.setNull(String.valueOf(
            pKhTtdkTyuui.getKktyuitakbn())));
        bzKhTtdkTyuuiLayoutFile.setIfeTsttdktyuuinaiyou1(setKoteiatai(pKhTtdkTyuui.getTtdktyuuinaiyou1(), ""));
        bzKhTtdkTyuuiLayoutFile.setIfeTsttdktyuuinaiyou2(setKoteiatai(pKhTtdkTyuui.getTtdktyuuinaiyou2(), ""));
        bzKhTtdkTyuuiLayoutFile.setIfeTsttdktyuuinaiyou3(setKoteiatai(pKhTtdkTyuui.getTtdktyuuinaiyou3(), ""));
        bzKhTtdkTyuuiLayoutFile.setIfeTsttdktyuuikbn1(convertTestData.setNull(String.valueOf(
            pKhTtdkTyuui.getTtdktyuuikbn1())));
        bzKhTtdkTyuuiLayoutFile.setIfeTsttdktyuuikbn2(convertTestData.setNull(String.valueOf(
            pKhTtdkTyuui.getTtdktyuuikbn2())));
        bzKhTtdkTyuuiLayoutFile.setIfeTsttdktyuuikbn3(convertTestData.setNull(String.valueOf(
            pKhTtdkTyuui.getTtdktyuuikbn3())));
        bzKhTtdkTyuuiLayoutFile.setIfeTsttdktyuuikbn4(convertTestData.setNull(String.valueOf(
            pKhTtdkTyuui.getTtdktyuuikbn4())));
        bzKhTtdkTyuuiLayoutFile.setIfeTsttdktyuuikbn5(convertTestData.setNull(String.valueOf(
            pKhTtdkTyuui.getTtdktyuuikbn5())));
        bzKhTtdkTyuuiLayoutFile.setIfeTsttdktyuuikbnhsknaiyou1(setKoteiatai(
            pKhTtdkTyuui.getTtdktyuuikbnhsknaiyou1(), ""));
        bzKhTtdkTyuuiLayoutFile.setIfeTsttdktyuuikbnhsknaiyou2(setKoteiatai(
            pKhTtdkTyuui.getTtdktyuuikbnhsknaiyou2(), ""));
        bzKhTtdkTyuuiLayoutFile.setIfeTsttdktyuuikbnhsknaiyou3(setKoteiatai(
            pKhTtdkTyuui.getTtdktyuuikbnhsknaiyou3(), ""));
        bzKhTtdkTyuuiLayoutFile.setIfeTsttdktyuuikbnhsknaiyou4(convertTestData.setNull(
            pKhTtdkTyuui.getTtdktyuuikbnhsknaiyou4()));
        bzKhTtdkTyuuiLayoutFile.setIfeTsttdktyuuikbnhsknaiyou5(convertTestData.setNull(
            pKhTtdkTyuui.getTtdktyuuikbnhsknaiyou5()));
        bzKhTtdkTyuuiLayoutFile.setIfeTsttdktyuuikbnsetymd1(convertTestData.setNull(String.valueOf(
            pKhTtdkTyuui.getTtdktyuuikbnsetymd1())));
        bzKhTtdkTyuuiLayoutFile.setIfeTsttdktyuuikbnsetymd2(convertTestData.setNull(String.valueOf(
            pKhTtdkTyuui.getTtdktyuuikbnsetymd2())));
        bzKhTtdkTyuuiLayoutFile.setIfeTsttdktyuuikbnsetymd3(convertTestData.setNull(String.valueOf(
            pKhTtdkTyuui.getTtdktyuuikbnsetymd3())));
        bzKhTtdkTyuuiLayoutFile.setIfeTsttdktyuuikbnsetymd4(convertTestData.setNull(String.valueOf(
            pKhTtdkTyuui.getTtdktyuuikbnsetymd4())));
        bzKhTtdkTyuuiLayoutFile.setIfeTsttdktyuuikbnsetymd5(convertTestData.setNull(String.valueOf(
            pKhTtdkTyuui.getTtdktyuuikbnsetymd5())));
        bzKhTtdkTyuuiLayoutFile.setIfeTssetsosikicd1(convertTestData.setNull(pKhTtdkTyuui.getSetsosikicd1()));
        bzKhTtdkTyuuiLayoutFile.setIfeTssetsosikicd2(convertTestData.setNull(pKhTtdkTyuui.getSetsosikicd2()));
        bzKhTtdkTyuuiLayoutFile.setIfeTssetsosikicd3(convertTestData.setNull(pKhTtdkTyuui.getSetsosikicd3()));
        bzKhTtdkTyuuiLayoutFile.setIfeTssetsosikicd4(convertTestData.setNull(pKhTtdkTyuui.getSetsosikicd4()));
        bzKhTtdkTyuuiLayoutFile.setIfeTssetsosikicd5(convertTestData.setNull(pKhTtdkTyuui.getSetsosikicd5()));
        bzKhTtdkTyuuiLayoutFile.setIfeTsgyoumukousinkinou(convertTestData.setNull(pKhTtdkTyuui.getGyoumuKousinKinou()));
        bzKhTtdkTyuuiLayoutFile.setIfeTsgyoumukousinsyaid(convertTestData.setNull(pKhTtdkTyuui.getGyoumuKousinsyaId()));
        bzKhTtdkTyuuiLayoutFile.setIfeTsgyoumukousintime(convertTestData.setNull(pKhTtdkTyuui.getGyoumuKousinTime()));
        bzKhTtdkTyuuiLayoutFile.setIfeTskousinsyaid("init");
        bzKhTtdkTyuuiLayoutFile.setIfeTskousintime("0");
        bzKhTtdkTyuuiLayoutFile.setIfeTskousinkinou("init");
        bzKhTtdkTyuuiLayoutFile.setIfeTsversion("0");
        bzKhTtdkTyuuiLayoutFile.setIfeTskykdrknhatudoujyoutai(convertTestData.setNull(String.valueOf(
            pKhTtdkTyuui.getKykdrknhatudoujyoutai())));
        bzKhTtdkTyuuiLayoutFile.setIfeTskykdrdouiyouhi(convertTestData.setNull(String.valueOf(
            pKhTtdkTyuui.getKykdrdouiyouhi())));

        return bzKhTtdkTyuuiLayoutFile;
    }

    private BzKoujyoSymLayoutFile getBzKoujyoSymLayoutFile(IT_KoujyoSym pKoujyoSym, String pKbnkey, String pSyoNo) {

        BzKoujyoSymLayoutFile bzKoujyoSymLayoutFile = SWAKInjector.getInstance(BzKoujyoSymLayoutFile.class);

        ConvertTestData convertTestData = SWAKInjector.getInstance(ConvertTestData.class);

        bzKoujyoSymLayoutFile.setIfeTskbnkey(pKbnkey);
        bzKoujyoSymLayoutFile.setIfeTssyono(pSyoNo);
        bzKoujyoSymLayoutFile.setIfeTsnendo(pKoujyoSym.getNendo());
        bzKoujyoSymLayoutFile.setIfeTstyouhyouymd(String.valueOf(pKoujyoSym.getTyouhyouymd()));
        bzKoujyoSymLayoutFile.setIfeTsrenno(String.valueOf(pKoujyoSym.getRenno()));
        bzKoujyoSymLayoutFile.setIfeTskjsmsakuseisyorikbn(convertTestData.setNull(
            String.valueOf(pKoujyoSym.getKjsmsakuseisyorikbn())));
        bzKoujyoSymLayoutFile.setIfeTstekiyouseidokbn(convertTestData.setNull(
            String.valueOf(pKoujyoSym.getTekiyouseidokbn())));
        bzKoujyoSymLayoutFile.setIfeTssyoumeiymd(convertTestData.setNull(String.valueOf(pKoujyoSym.getSyoumeiymd())));
        bzKoujyoSymLayoutFile.setIfeTssyoumeistartym(convertTestData.setNull(
            String.valueOf(pKoujyoSym.getSyoumeistartym())));
        bzKoujyoSymLayoutFile.setIfeTssyoumeiendym(convertTestData.setNull(String.valueOf(pKoujyoSym.getSyoumeiendym())));
        bzKoujyoSymLayoutFile.setIfeTssyoumeikkntukisuu(convertTestData.setNull(String.valueOf(pKoujyoSym.getSyoumeikkntukisuu())));
        bzKoujyoSymLayoutFile.setIfeTssyoumeikknnensuu(convertTestData.setNull(String.valueOf(pKoujyoSym.getSyoumeikknnensuu())));
        bzKoujyoSymLayoutFile.setIfeTskyknmkj(convertTestData.setTestKanjiNm(pKoujyoSym.getKyknmkj(),
            KYKNMKJ, pSyoNo));
        bzKoujyoSymLayoutFile.setIfeTsuktnmkjaddsama(convertTestData.setTestKanjiNm(
            pKoujyoSym.getUktnmkjaddsama(), UKTNMKJADDSAMA, pSyoNo) + "　様");
        bzKoujyoSymLayoutFile.setIfeTsnenkinuktseiymd(convertTestData.setNull(String.valueOf(
            pKoujyoSym.getNenkinuktseiymd())));
        bzKoujyoSymLayoutFile.setIfeTshknsyuruinmrykkj(convertTestData.setNull(String.valueOf(
            pKoujyoSym.getHknsyuruinmrykkj())));
        bzKoujyoSymLayoutFile.setIfeTskykymd(convertTestData.setNull(String.valueOf(pKoujyoSym.getKykymd())));
        bzKoujyoSymLayoutFile.setIfeTshknkknsmnkbnsyu(convertTestData.setNull(String.valueOf(
            pKoujyoSym.getHknkknsmnkbnsyu())));
        bzKoujyoSymLayoutFile.setIfeTshknkknsyu(convertTestData.setNull(String.valueOf(pKoujyoSym.getHknkknsyu())));
        bzKoujyoSymLayoutFile.setIfeTsnenkanhrkkaisuu(convertTestData.setNull(String.valueOf(pKoujyoSym.getNenkanhrkkaisuu())));
        bzKoujyoSymLayoutFile.setIfeTsphrkkkn(convertTestData.setNull(String.valueOf(pKoujyoSym.getPhrkkkn())));
        bzKoujyoSymLayoutFile.setIfeTsnkshrstartymd(convertTestData.setNull(
            String.valueOf(pKoujyoSym.getNkshrstartymd())));
        bzKoujyoSymLayoutFile.setIfeTsnknshry(convertTestData.setNull(pKoujyoSym.getNknshry()));
        bzKoujyoSymLayoutFile.setIfeTskykjyoutai(convertTestData.setNull(String.valueOf(pKoujyoSym.getKykjyoutai())));
        bzKoujyoSymLayoutFile.setIfeTsyuukousyoumetukbn(convertTestData.setNull(String.valueOf(
            pKoujyoSym.getYuukousyoumetukbn())));
        bzKoujyoSymLayoutFile.setIfeTshaitoukinuketorihoukbn(convertTestData.setNull(String.valueOf(
            pKoujyoSym.getHaitoukinuketorihoukbn())));
        bzKoujyoSymLayoutFile.setIfeTsoldippanjissekip(convertTestData.setNull(setBizCurrencyVal(pKoujyoSym.getOldippanjissekip())));
        bzKoujyoSymLayoutFile.setIfeTsoldippanjissekipt(convertTestData.setNull(setBizCurrencyType(pKoujyoSym.getOldippanjissekip())));
        bzKoujyoSymLayoutFile.setIfeTsoldippannenkanp(convertTestData.setNull(setBizCurrencyVal(pKoujyoSym.getOldippannenkanp())));
        bzKoujyoSymLayoutFile.setIfeTsoldippannenkanpt(convertTestData.setNull(setBizCurrencyType(pKoujyoSym.getOldippannenkanp())));
        bzKoujyoSymLayoutFile.setIfeTsoldippanjissekihtkin(convertTestData.setNull(setBizCurrencyVal(pKoujyoSym.getOldippanjissekihaitoukin())));
        bzKoujyoSymLayoutFile.setIfeTsoldippanjissekihtkint(convertTestData.setNull(setBizCurrencyType(pKoujyoSym.getOldippanjissekihaitoukin())));
        bzKoujyoSymLayoutFile.setIfeTsoldippannenkanhtkin(convertTestData.setNull(setBizCurrencyVal(pKoujyoSym.getOldippannenkanhaitoukin())));
        bzKoujyoSymLayoutFile.setIfeTsoldippannenkanhtkint(convertTestData.setNull(setBizCurrencyType(pKoujyoSym.getOldippannenkanhaitoukin())));
        bzKoujyoSymLayoutFile.setIfeTsoldippanjissekisymgk(convertTestData.setNull(setBizCurrencyVal(pKoujyoSym.getOldippanjissekisyoumeigk())));
        bzKoujyoSymLayoutFile.setIfeTsoldippanjissekisymgkt(convertTestData.setNull(setBizCurrencyType(pKoujyoSym.getOldippanjissekisyoumeigk())));
        bzKoujyoSymLayoutFile.setIfeTsoldippannenkansymgk(convertTestData.setNull(setBizCurrencyVal(pKoujyoSym.getOldippannenkansyoumeigk())));
        bzKoujyoSymLayoutFile.setIfeTsoldippannenkansymgkt(convertTestData.setNull(setBizCurrencyType(pKoujyoSym.getOldippannenkansyoumeigk())));
        bzKoujyoSymLayoutFile.setIfeTsnewippanjissekip(convertTestData.setNull(setBizCurrencyVal(pKoujyoSym.getNewippanjissekip())));
        bzKoujyoSymLayoutFile.setIfeTsnewippanjissekipt(convertTestData.setNull(setBizCurrencyType(pKoujyoSym.getNewippanjissekip())));
        bzKoujyoSymLayoutFile.setIfeTsnewippannenkanp(convertTestData.setNull(setBizCurrencyVal(pKoujyoSym.getNewippannenkanp())));
        bzKoujyoSymLayoutFile.setIfeTsnewippannenkanpt(convertTestData.setNull(setBizCurrencyType(pKoujyoSym.getNewippannenkanp())));
        bzKoujyoSymLayoutFile.setIfeTsnewippanjissekihtkin(convertTestData.setNull(setBizCurrencyVal(pKoujyoSym.getNewippanjissekihaitoukin())));
        bzKoujyoSymLayoutFile.setIfeTsnewippanjissekihtkint(convertTestData.setNull(setBizCurrencyType(pKoujyoSym.getNewippanjissekihaitoukin())));
        bzKoujyoSymLayoutFile.setIfeTsnewippannenkanhtkin(convertTestData.setNull(setBizCurrencyVal(pKoujyoSym.getNewippannenkanhaitoukin())));
        bzKoujyoSymLayoutFile.setIfeTsnewippannenkanhtkint(convertTestData.setNull(setBizCurrencyType(pKoujyoSym.getNewippannenkanhaitoukin())));
        bzKoujyoSymLayoutFile.setIfeTsnewippanjissekisymgk(convertTestData.setNull(setBizCurrencyVal(pKoujyoSym.getNewippanjissekisyoumeigk())));
        bzKoujyoSymLayoutFile.setIfeTsnewippanjissekisymgkt(convertTestData.setNull(setBizCurrencyType(pKoujyoSym.getNewippanjissekisyoumeigk())));
        bzKoujyoSymLayoutFile.setIfeTsnewippannenkansymgk(convertTestData.setNull(setBizCurrencyVal(pKoujyoSym.getNewippannenkansyoumeigk())));
        bzKoujyoSymLayoutFile.setIfeTsnewippannenkansymgkt(convertTestData.setNull(setBizCurrencyType(pKoujyoSym.getNewippannenkansyoumeigk())));
        bzKoujyoSymLayoutFile.setIfeTsnewiryoujissekip(convertTestData.setNull(setBizCurrencyVal(pKoujyoSym.getNewiryoujissekip())));
        bzKoujyoSymLayoutFile.setIfeTsnewiryoujissekipt(convertTestData.setNull(setBizCurrencyType(pKoujyoSym.getNewiryoujissekip())));
        bzKoujyoSymLayoutFile.setIfeTsnewiryounenkanp(convertTestData.setNull(setBizCurrencyVal(pKoujyoSym.getNewiryounenkanp())));
        bzKoujyoSymLayoutFile.setIfeTsnewiryounenkanpt(convertTestData.setNull(setBizCurrencyType(pKoujyoSym.getNewiryounenkanp())));
        bzKoujyoSymLayoutFile.setIfeTsnewiryoujissekihtkin(convertTestData.setNull(setBizCurrencyVal(pKoujyoSym.getNewiryoujissekihaitoukin())));
        bzKoujyoSymLayoutFile.setIfeTsnewiryoujissekihtkint(convertTestData.setNull(setBizCurrencyType(pKoujyoSym.getNewiryoujissekihaitoukin())));
        bzKoujyoSymLayoutFile.setIfeTsnewiryounenkanhtkin(convertTestData.setNull(setBizCurrencyVal(pKoujyoSym.getNewiryounenkanhaitoukin())));
        bzKoujyoSymLayoutFile.setIfeTsnewiryounenkanhtkint(convertTestData.setNull(setBizCurrencyType(pKoujyoSym.getNewiryounenkanhaitoukin())));
        bzKoujyoSymLayoutFile.setIfeTsnewiryoujissekisymgk(convertTestData.setNull(setBizCurrencyVal(pKoujyoSym.getNewiryoujissekisyoumeigk())));
        bzKoujyoSymLayoutFile.setIfeTsnewiryoujissekisymgkt(convertTestData.setNull(setBizCurrencyType(pKoujyoSym.getNewiryoujissekisyoumeigk())));
        bzKoujyoSymLayoutFile.setIfeTsnewiryounenkansymgk(convertTestData.setNull(setBizCurrencyVal(pKoujyoSym.getNewiryounenkansyoumeigk())));
        bzKoujyoSymLayoutFile.setIfeTsnewiryounenkansymgkt(convertTestData.setNull(setBizCurrencyType(pKoujyoSym.getNewiryounenkansyoumeigk())));
        bzKoujyoSymLayoutFile.setIfeTsnewnkjissekip(convertTestData.setNull(setBizCurrencyVal(pKoujyoSym.getNewnkjissekip())));
        bzKoujyoSymLayoutFile.setIfeTsnewnkjissekipt(convertTestData.setNull(setBizCurrencyType(pKoujyoSym.getNewnkjissekip())));
        bzKoujyoSymLayoutFile.setIfeTsnewnknenkanp(convertTestData.setNull(setBizCurrencyVal(pKoujyoSym.getNewnknenkanp())));
        bzKoujyoSymLayoutFile.setIfeTsnewnknenkanpt(convertTestData.setNull(setBizCurrencyType(pKoujyoSym.getNewnknenkanp())));
        bzKoujyoSymLayoutFile.setIfeTsnewnkjissekihaitoukin(convertTestData.setNull(setBizCurrencyVal(pKoujyoSym.getNewnkjissekihaitoukin())));
        bzKoujyoSymLayoutFile.setIfeTsnewnkjissekihaitoukint(convertTestData.setNull(setBizCurrencyType(pKoujyoSym.getNewnkjissekihaitoukin())));
        bzKoujyoSymLayoutFile.setIfeTsnewnknenkanhaitoukin(convertTestData.setNull(setBizCurrencyVal(pKoujyoSym.getNewnknenkanhaitoukin())));
        bzKoujyoSymLayoutFile.setIfeTsnewnknenkanhaitoukint(convertTestData.setNull(setBizCurrencyType(pKoujyoSym.getNewnknenkanhaitoukin())));
        bzKoujyoSymLayoutFile.setIfeTsnewnkjissekisyoumeigk(convertTestData.setNull(setBizCurrencyVal(pKoujyoSym.getNewnkjissekisyoumeigk())));
        bzKoujyoSymLayoutFile.setIfeTsnewnkjissekisyoumeigkt(convertTestData.setNull(setBizCurrencyType(pKoujyoSym.getNewnkjissekisyoumeigk())));
        bzKoujyoSymLayoutFile.setIfeTsnewnknenkansyoumeigk(convertTestData.setNull(setBizCurrencyVal(pKoujyoSym.getNewnknenkansyoumeigk())));
        bzKoujyoSymLayoutFile.setIfeTsnewnknenkansyoumeigkt(convertTestData.setNull(setBizCurrencyType(pKoujyoSym.getNewnknenkansyoumeigk())));
        bzKoujyoSymLayoutFile.setIfeTskjnnkkoujyum(convertTestData.setNull(String.valueOf(pKoujyoSym.getKjnnkkoujyum())));
        bzKoujyoSymLayoutFile.setIfeTstsinyno(setKoteiatai(pKoujyoSym.getTsinyno(), POSTALCD));
        bzKoujyoSymLayoutFile.setIfeTstsinadr1kj(setKoteiatai(pKoujyoSym.getTsinadr1kj(), TSINADR1KJ));
        bzKoujyoSymLayoutFile.setIfeTstsinadr2kj(setKoteiatai(pKoujyoSym.getTsinadr2kj(), TSINADR2KJ));
        bzKoujyoSymLayoutFile.setIfeTstsinadr3kj(setKoteiatai(pKoujyoSym.getTsinadr3kj(), TSINADR3KJ));
        bzKoujyoSymLayoutFile.setIfeTstoiawasesosikinmkj(convertTestData.setNull(pKoujyoSym.getToiawasesosikinmkj()));
        bzKoujyoSymLayoutFile.setIfeTstoiawaseyno(convertTestData.setNull(pKoujyoSym.getToiawaseyno()));
        bzKoujyoSymLayoutFile.setIfeTstoiawaseadr1kj(convertTestData.setNull(pKoujyoSym.getToiawaseadr1kj()));
        bzKoujyoSymLayoutFile.setIfeTstoiawaseadr2kj(convertTestData.setNull(pKoujyoSym.getToiawaseadr2kj()));
        bzKoujyoSymLayoutFile.setIfeTstoiawaseadr3kj(convertTestData.setNull(pKoujyoSym.getToiawaseadr3kj()));
        bzKoujyoSymLayoutFile.setIfeTstoiawasetelno(convertTestData.setNull(pKoujyoSym.getToiawasetelno()));
        bzKoujyoSymLayoutFile.setIfeTstoiawaseteluktkkanou1(convertTestData.setNull(
            pKoujyoSym.getToiawaseteluktkkanou1()));
        bzKoujyoSymLayoutFile.setIfeTstoiawaseteluktkkanou2(convertTestData.setNull(
            pKoujyoSym.getToiawaseteluktkkanou2()));
        bzKoujyoSymLayoutFile.setIfeTstoiawasesosikinmkj2(convertTestData.setNull(pKoujyoSym.getToiawasesosikinmkj2()));
        bzKoujyoSymLayoutFile.setIfeTstoiawasetelno2(convertTestData.setNull(pKoujyoSym.getToiawasetelno2()));
        bzKoujyoSymLayoutFile.setIfeTshassoukbn(convertTestData.setNull(String.valueOf(pKoujyoSym.getHassoukbn())));
        bzKoujyoSymLayoutFile.setIfeTsdrtencd(convertTestData.setNull(pKoujyoSym.getDrtencd()));
        bzKoujyoSymLayoutFile.setIfeTsdrtennmkj(convertTestData.setNull(String.valueOf(pKoujyoSym.getDrtennmkj())));
        bzKoujyoSymLayoutFile.setIfeTshengakuumu(convertTestData.setNull(String.valueOf(pKoujyoSym.getHengakuumu())));
        bzKoujyoSymLayoutFile.setIfeTsnewsyoumeigkumukbn(convertTestData.setNull(
            String.valueOf(pKoujyoSym.getNewsyoumeigkumukbn())));
        bzKoujyoSymLayoutFile.setIfeTsgyoumukousinkinou(convertTestData.setNull(pKoujyoSym.getGyoumuKousinKinou()));
        bzKoujyoSymLayoutFile.setIfeTsgyoumukousinsyaid(convertTestData.setNull(pKoujyoSym.getGyoumuKousinsyaId()));
        bzKoujyoSymLayoutFile.setIfeTsgyoumukousintime(convertTestData.setNull(pKoujyoSym.getGyoumuKousinTime()));
        bzKoujyoSymLayoutFile.setIfeTskousinsyaid("init");
        bzKoujyoSymLayoutFile.setIfeTskousintime("0");
        bzKoujyoSymLayoutFile.setIfeTskousinkinou("init");
        bzKoujyoSymLayoutFile.setIfeTsversion("0");
        bzKoujyoSymLayoutFile.setIfeTskoujyosyoumeisentkkbn(convertTestData.setNull(String.valueOf(pKoujyoSym
            .getKoujyosyoumeisentakukbn())));
        bzKoujyoSymLayoutFile.setIfeTskyknmkn(convertTestDataForKanaMeigi.getKnmeigi(pKoujyoSym.getKyknmkn()));
        bzKoujyoSymLayoutFile.setIfeTsuktnmkn(convertTestDataForKanaMeigi.getKnmeigi(pKoujyoSym.getUktnmkn()));
        bzKoujyoSymLayoutFile.setIfeTssaihkhyjkbn(convertTestData.setNull(String.valueOf(pKoujyoSym.getSaihkhyjkbn())));

        return bzKoujyoSymLayoutFile;
    }

    private BzKoujyoSymKanriLayoutFile getBzKoujyoSymKanriLayoutFile(IT_KoujyoSymKanri pKoujyoSymKanri, String pKbnkey,
        String pSyoNo) {

        BzKoujyoSymKanriLayoutFile bzKoujyoSymKanriLayoutFile = SWAKInjector.getInstance(
            BzKoujyoSymKanriLayoutFile.class);

        ConvertTestData convertTestData = SWAKInjector.getInstance(ConvertTestData.class);

        bzKoujyoSymKanriLayoutFile.setIfeTskbnkey(pKbnkey);
        bzKoujyoSymKanriLayoutFile.setIfeTssyono(pSyoNo);
        bzKoujyoSymKanriLayoutFile.setIfeTsnendo(pKoujyoSymKanri.getNendo());
        bzKoujyoSymKanriLayoutFile.setIfeTslastsyoumeiendym(convertTestData.setNull(String.valueOf(
            pKoujyoSymKanri.getLastsyoumeiendym())));
        bzKoujyoSymKanriLayoutFile.setIfeTsgyoumukousinkinou(convertTestData.setNull(
            pKoujyoSymKanri.getGyoumuKousinKinou()));
        bzKoujyoSymKanriLayoutFile.setIfeTsgyoumukousinsyaid(convertTestData.setNull(
            pKoujyoSymKanri.getGyoumuKousinsyaId()));
        bzKoujyoSymKanriLayoutFile.setIfeTsgyoumukousintime(convertTestData.setNull(
            pKoujyoSymKanri.getGyoumuKousinTime()));
        bzKoujyoSymKanriLayoutFile.setIfeTskousinsyaid("init");
        bzKoujyoSymKanriLayoutFile.setIfeTskousintime("0");
        bzKoujyoSymKanriLayoutFile.setIfeTskousinkinou("init");
        bzKoujyoSymKanriLayoutFile.setIfeTsversion("0");

        return bzKoujyoSymKanriLayoutFile;
    }

    private BzKoujyoSymNaiyouLayoutFile getBzKoujyoSymNaiyouLayoutFile(IT_KoujyoSymNaiyou pKoujyoSymNaiyou,
        String pKbnkey, String pSyoNo) {

        BzKoujyoSymNaiyouLayoutFile bzKoujyoSymNaiyouLayoutFile = SWAKInjector.getInstance(
            BzKoujyoSymNaiyouLayoutFile.class);

        ConvertTestData convertTestData = SWAKInjector.getInstance(ConvertTestData.class);

        bzKoujyoSymNaiyouLayoutFile.setIfeTskbnkey(pKbnkey);
        bzKoujyoSymNaiyouLayoutFile.setIfeTssyono(pSyoNo);
        bzKoujyoSymNaiyouLayoutFile.setIfeTssyouhncd(pKoujyoSymNaiyou.getSyouhncd());
        bzKoujyoSymNaiyouLayoutFile.setIfeTsrenno3keta(String.valueOf(pKoujyoSymNaiyou.getRenno3keta()));
        bzKoujyoSymNaiyouLayoutFile.setIfeTskoujyosyoumeinnd(convertTestData.setNull(
            pKoujyoSymNaiyou.getKoujyosyoumeinnd()));
        bzKoujyoSymNaiyouLayoutFile.setIfeTssyoumeistartym(convertTestData.setNull(String.valueOf(
            pKoujyoSymNaiyou.getSyoumeistartym())));
        bzKoujyoSymNaiyouLayoutFile.setIfeTssyoumeiendym(convertTestData.setNull(String.valueOf(
            pKoujyoSymNaiyou.getSyoumeiendym())));
        bzKoujyoSymNaiyouLayoutFile.setIfeTskoujyosyoumeipkbn(convertTestData.setNull(String.valueOf(
            pKoujyoSymNaiyou.getKoujyosyoumeipkbn())));
        bzKoujyoSymNaiyouLayoutFile.setIfeTstekiyouseidokbn(convertTestData.setNull(String.valueOf(
            pKoujyoSymNaiyou.getTekiyouseidokbn())));
        bzKoujyoSymNaiyouLayoutFile.setIfeTskoujyosymnaiyoureckbn(convertTestData.setNull(String.valueOf(
            pKoujyoSymNaiyou.getKoujyosymnaiyoureckbn())));
        bzKoujyoSymNaiyouLayoutFile.setIfeTskoujyosyoumeigk(convertTestData.setNull(setBizCurrencyVal(pKoujyoSymNaiyou.getKoujyosyoumeigk())));
        bzKoujyoSymNaiyouLayoutFile.setIfeTskoujyosyoumeigkt(convertTestData.setNull(setBizCurrencyType(pKoujyoSymNaiyou.getKoujyosyoumeigk())));
        bzKoujyoSymNaiyouLayoutFile.setIfeTsjyutoustartym(convertTestData.setNull(String.valueOf(
            pKoujyoSymNaiyou.getJyutoustartym())));
        bzKoujyoSymNaiyouLayoutFile.setIfeTsnyknjskrrkrenno(convertTestData.setNull(String.valueOf(pKoujyoSymNaiyou.getNyknjskrrkrenno())));
        bzKoujyoSymNaiyouLayoutFile.setIfeTskihrkpssrrkrenno(convertTestData.setNull(String.valueOf(pKoujyoSymNaiyou.getKihrkpssrrkrenno())));
        bzKoujyoSymNaiyouLayoutFile.setIfeTskjsmhakkouzumiflg(convertTestData.setNull(String.valueOf(
            pKoujyoSymNaiyou.getKjsmhakkouzumiflg())));
        bzKoujyoSymNaiyouLayoutFile.setIfeTsgyoumukousinkinou(convertTestData.setNull(
            pKoujyoSymNaiyou.getGyoumuKousinKinou()));
        bzKoujyoSymNaiyouLayoutFile.setIfeTsgyoumukousinsyaid(convertTestData.setNull(
            pKoujyoSymNaiyou.getGyoumuKousinsyaId()));
        bzKoujyoSymNaiyouLayoutFile.setIfeTsgyoumukousintime(convertTestData.setNull(
            pKoujyoSymNaiyou.getGyoumuKousinTime()));
        bzKoujyoSymNaiyouLayoutFile.setIfeTskousinsyaid("init");
        bzKoujyoSymNaiyouLayoutFile.setIfeTskousintime("0");
        bzKoujyoSymNaiyouLayoutFile.setIfeTskousinkinou("init");
        bzKoujyoSymNaiyouLayoutFile.setIfeTsversion("0");
        bzKoujyoSymNaiyouLayoutFile.setIfeTssakujyoflg(convertTestData.setNull(String.valueOf(pKoujyoSymNaiyou
            .getSakujyoflg())));
        bzKoujyoSymNaiyouLayoutFile.setIfeTszennoukaisiymd(convertTestData.setNull(String.valueOf(pKoujyoSymNaiyou
            .getZennoukaisiymd())));
        bzKoujyoSymNaiyouLayoutFile.setIfeTszennourenno(convertTestData.setNull(String.valueOf(pKoujyoSymNaiyou
            .getZennourenno())));
        bzKoujyoSymNaiyouLayoutFile.setIfeTskeisanhukahyoujikbn(convertTestData.setNull(String.valueOf(pKoujyoSymNaiyou
            .getKeisanhukahyoujikbn())));
        bzKoujyoSymNaiyouLayoutFile.setIfeTskeisanhukariyuucd(convertTestData.setNull(pKoujyoSymNaiyou
            .getKeisanhukariyuucd()));

        return bzKoujyoSymNaiyouLayoutFile;
    }

    private BzKykDairitenLayoutFile getBzKykDairitenLayoutFile(IT_KykDairiten pKykDairiten, String pKbnkey,
        String pSyoNo) {

        BzKykDairitenLayoutFile bzKykDairitenLayoutFile = SWAKInjector.getInstance(BzKykDairitenLayoutFile.class);

        ConvertTestData convertTestData = SWAKInjector.getInstance(ConvertTestData.class);

        bzKykDairitenLayoutFile.setIfeTskbnkey(pKbnkey);
        bzKykDairitenLayoutFile.setIfeTssyono(pSyoNo);
        bzKykDairitenLayoutFile.setIfeTsdrtenrenno(String.valueOf(pKykDairiten.getDrtenrenno()));
        bzKykDairitenLayoutFile.setIfeTsdrtencd(convertTestData.setNull(pKykDairiten.getDrtencd()));
        bzKykDairitenLayoutFile.setIfeTsdrtenkanrisosikicd(convertTestData.setNull(pKykDairiten.getDrtenkanrisosikicd()));
        bzKykDairitenLayoutFile.setIfeTsgyousekikjysksosikicd(convertTestData.setNull(
            pKykDairiten.getGyousekikeijyousakisosikicd()));
        bzKykDairitenLayoutFile.setIfeTsoyadrtencd(convertTestData.setNull(pKykDairiten.getOyadrtencd()));
        bzKykDairitenLayoutFile.setIfeTsbosyuucd(convertTestData.setNull(pKykDairiten.getBosyuucd()));
        bzKykDairitenLayoutFile.setIfeTsdaibosyuucd(convertTestData.setNull(pKykDairiten.getDaibosyuucd()));
        bzKykDairitenLayoutFile.setIfeTsdrtenbunumu(convertTestData.setNull(String.valueOf(
            pKykDairiten.getDrtenbunumu())));
        bzKykDairitenLayoutFile.setIfeTskanjidrtflg(convertTestData.setNull(String.valueOf(
            pKykDairiten.getKanjidrtflg())));
        bzKykDairitenLayoutFile.setIfeTsbunwari(convertTestData.setNull(String.valueOf(pKykDairiten.getBunwari())));
        bzKykDairitenLayoutFile.setIfeTsikanymd(convertTestData.setNull(String.valueOf(pKykDairiten.getIkanymd())));
        bzKykDairitenLayoutFile.setIfeTsbsyujoyadrtencd(convertTestData.setNull(pKykDairiten.getBsyujoyadrtencd()));
        bzKykDairitenLayoutFile.setIfeTsbsyujdrtencd(convertTestData.setNull(pKykDairiten.getBsyujdrtencd()));
        bzKykDairitenLayoutFile.setIfeTsbsyujbosyuutrkno(convertTestData.setNull(pKykDairiten.getBsyujbosyuutrkno()));
        bzKykDairitenLayoutFile.setIfeTsgyoumukousinkinou(convertTestData.setNull(pKykDairiten.getGyoumuKousinKinou()));
        bzKykDairitenLayoutFile.setIfeTsgyoumukousinsyaid(convertTestData.setNull(pKykDairiten.getGyoumuKousinsyaId()));
        bzKykDairitenLayoutFile.setIfeTsgyoumukousintime(convertTestData.setNull(pKykDairiten.getGyoumuKousinTime()));
        bzKykDairitenLayoutFile.setIfeTskousinsyaid("init");
        bzKykDairitenLayoutFile.setIfeTskousintime("0");
        bzKykDairitenLayoutFile.setIfeTskousinkinou("init");
        bzKykDairitenLayoutFile.setIfeTsversion("0");

        return bzKykDairitenLayoutFile;

    }

    private BzKykKihonLayoutFile getBzKykKihonLayoutFile(IT_KykKihon pKykKihon, String pKbnkey, String pSyoNo) {

        BzKykKihonLayoutFile bzKykKihonLayoutFile = SWAKInjector.getInstance(BzKykKihonLayoutFile.class);

        ConvertTestData convertTestData = SWAKInjector.getInstance(ConvertTestData.class);

        bzKykKihonLayoutFile.setIfeTskbnkey(pKbnkey);
        bzKykKihonLayoutFile.setIfeTssyono(pSyoNo);
        bzKykKihonLayoutFile.setIfeTsaitesyono(setKoteiatai(pKykKihon.getAitesyono(), ""));
        bzKykKihonLayoutFile.setIfeTshaitoukbn(convertTestData.setNull(String.valueOf(pKykKihon.getHaitoukbn())));
        bzKykKihonLayoutFile.setIfeTshrkkaisuu(convertTestData.setNull(String.valueOf(pKykKihon.getHrkkaisuu())));
        bzKykKihonLayoutFile.setIfeTshrkkeiro(convertTestData.setNull(String.valueOf(pKykKihon.getHrkkeiro())));
        bzKykKihonLayoutFile.setIfeTssdpdkbn(convertTestData.setNull(String.valueOf(pKykKihon.getSdpdkbn())));
        bzKykKihonLayoutFile.setIfeTsdntryouritukbn(convertTestData.setNull(String.valueOf(
            pKykKihon.getDntryouritukbn())));
        bzKykKihonLayoutFile.setIfeTsdntcd(convertTestData.setNull(pKykKihon.getDntcd()));
        bzKykKihonLayoutFile.setIfeTssntkhoukbn(convertTestData.setNull(String.valueOf(pKykKihon.getSntkhoukbn())));
        bzKykKihonLayoutFile.setIfeTssinsakbn(convertTestData.setNull(String.valueOf(pKykKihon.getSinsakbn())));
        bzKykKihonLayoutFile.setIfeTsmosymd(convertTestData.setNull(String.valueOf(pKykKihon.getMosymd())));
        bzKykKihonLayoutFile.setIfeTskktymd(convertTestData.setNull(String.valueOf(pKykKihon.getKktymd())));
        bzKykKihonLayoutFile.setIfeTsfstpnyknymd(convertTestData.setNull(String.valueOf(pKykKihon.getFstpnyknymd())));
        bzKykKihonLayoutFile.setIfeTsmosukeymd(convertTestData.setNull(String.valueOf(pKykKihon.getMosukeymd())));
        bzKykKihonLayoutFile.setIfeTsmosjimosuktymd(convertTestData.setNull(String.valueOf(
            pKykKihon.getMosjimosuktymd())));
        bzKykKihonLayoutFile.setIfeTsseirituymd(convertTestData.setNull(String.valueOf(pKykKihon.getSeirituymd())));
        bzKykKihonLayoutFile.setIfeTsitiprsymd(convertTestData.setNull(String.valueOf(pKykKihon.getItiprsymd())));
        bzKykKihonLayoutFile.setIfeTshrkp(convertTestData.setNull(setBizCurrencyVal(pKykKihon.getHrkp())));
        bzKykKihonLayoutFile.setIfeTshrkpt(convertTestData.setNull(setBizCurrencyType(pKykKihon.getHrkp())));
        bzKykKihonLayoutFile.setIfeTsbosyuuym(convertTestData.setNull(String.valueOf(pKykKihon.getBosyuuym())));
        bzKykKihonLayoutFile.setIfeTsseisekiym(convertTestData.setNull(String.valueOf(pKykKihon.getSeisekiym())));
        bzKykKihonLayoutFile.setIfeTsskeikeijyouym(convertTestData.setNull(String.valueOf(pKykKihon.getSkeikeijyouym())));
        bzKykKihonLayoutFile.setIfeTsplancd(convertTestData.setNull(pKykKihon.getPlancd()));
        bzKykKihonLayoutFile.setIfeTsplanrenno(convertTestData.setNull(String.valueOf(pKykKihon.getPlanrenno())));
        bzKykKihonLayoutFile.setIfeTsaisyoumeikbn(convertTestData.setNull(String.valueOf(pKykKihon.getAisyoumeikbn())));
        bzKykKihonLayoutFile.setIfeTssyusaiumu(convertTestData.setNull(String.valueOf(pKykKihon.getSyusaiumu())));
        bzKykKihonLayoutFile.setIfeTsstknsetkbn(convertTestData.setNull(String.valueOf(pKykKihon.getStknsetkbn())));
        bzKykKihonLayoutFile.setIfeTskykksykjyumu(convertTestData.setNull(String.valueOf(pKykKihon.getKykksykjyumu())));
        bzKykKihonLayoutFile.setIfeTskykksumu(convertTestData.setNull(String.valueOf(pKykKihon.getKykksumu())));
        bzKykKihonLayoutFile.setIfeTsaplkahikbn(convertTestData.setNull(String.valueOf(pKykKihon.getAplkahikbn())));
        bzKykKihonLayoutFile.setIfeTsaplumu(convertTestData.setNull(String.valueOf(pKykKihon.getAplumu())));
        bzKykKihonLayoutFile.setIfeTsfstphrkkeirokbn(convertTestData.setNull(String.valueOf(
            pKykKihon.getFstphrkkeirokbn())));
        bzKykKihonLayoutFile.setIfeTshaitounendo(convertTestData.setNull(String.valueOf(pKykKihon.getHaitounendo())));
        bzKykKihonLayoutFile.setIfeTshaitoukinuketorihoukbn(convertTestData.setNull(String.valueOf(
            pKykKihon.getHaitoukinuketorihoukbn())));
        bzKykKihonLayoutFile.setIfeTstratkityuiumu(convertTestData.setNull(String.valueOf(pKykKihon.getTratkityuiumu())));
        bzKykKihonLayoutFile.setIfeTstratkityuiuny(convertTestData.setNull(String.valueOf(pKykKihon.getTratkityuiuny())));
        bzKykKihonLayoutFile.setIfeTssbuktnin(convertTestData.setNull(String.valueOf(pKykKihon.getSbuktnin())));
        bzKykKihonLayoutFile.setIfeTsgansindankakuteiymd(convertTestData.setNull(pKykKihon.getGansindankakuteiymd()));
        bzKykKihonLayoutFile.setIfeTsmosuketukekbn(convertTestData.setNull(String.valueOf(pKykKihon.getMosuketukekbn())));
        bzKykKihonLayoutFile.setIfeTskijikbn(convertTestData.setNull(String.valueOf(pKykKihon.getKijikbn())));
        bzKykKihonLayoutFile.setIfeTshhknsykgycd(convertTestData.setNull(pKykKihon.getHhknsykgycd()));
        bzKykKihonLayoutFile.setIfeTshhknnensyuukbn(convertTestData.setNull(String.valueOf(
            pKykKihon.getHhknnensyuukbn())));
        bzKykKihonLayoutFile.setIfeTsdrtenkanritodoufukencd(convertTestData.setNull(
            pKykKihon.getDrtenkanritodoufukencd()));
        bzKykKihonLayoutFile.setIfeTscifcd(setKoteiatai(pKykKihon.getCifcd(), ""));
        bzKykKihonLayoutFile.setIfeTssmbckanriid(setKoteiatai(pKykKihon.getSmbckanriid(), ""));
        bzKykKihonLayoutFile.setIfeTstsryhshrkykumukbn(convertTestData.setNull(String.valueOf(
            pKykKihon.getTsryhshrkykumukbn())));
        bzKykKihonLayoutFile.setIfeTskykhonninkknnsyrkbn(convertTestData.setNull(String.valueOf(
            pKykKihon.getKykhonninkakninsyoruikbn())));
        bzKykKihonLayoutFile.setIfeTsskskknhonninkknnsyrkbn(convertTestData.setNull(String.valueOf(
            pKykKihon.getSkskknhonninkakninsyoruikbn())));
        bzKykKihonLayoutFile.setIfeTsboskykjyoutai(convertTestData.setNull(String.valueOf(pKykKihon.getBoskykjyoutai())));
        bzKykKihonLayoutFile.setIfeTskanyuusyano("0");
        bzKykKihonLayoutFile.setIfeTsdrctservicemoskbn(convertTestData.setNull(String.valueOf(
            pKykKihon.getDrctservicemoskbn())));
        bzKykKihonLayoutFile.setIfeTssksyoukenskskbn(convertTestData.setNull(String.valueOf(
            pKykKihon.getSksyoukenskskbn())));
        bzKykKihonLayoutFile.setIfeTssinkyksyokensakuseiymd(convertTestData.setNull(String.valueOf(
            pKykKihon.getSinkyksyokensakuseiymd())));
        bzKykKihonLayoutFile.setIfeTssyoyousinkyksyohakkymd(convertTestData.setNull(String.valueOf(
            pKykKihon.getSyoyousinkyksyohakkouymd())));
        bzKykKihonLayoutFile.setIfeTsskjmosno(setKoteiatai(pKykKihon.getSkjmosno(), "999999998"));
        bzKykKihonLayoutFile.setIfeTsnkuikosumikbn(convertTestData.setNull(String.valueOf(pKykKihon.getNkuikosumikbn())));
        bzKykKihonLayoutFile.setIfeTssyhenkouymd(convertTestData.setNull(String.valueOf(pKykKihon.getSyhenkouymd())));
        bzKykKihonLayoutFile.setIfeTslastsyosaihkymd(convertTestData.setNull(String.valueOf(
            pKykKihon.getLastsyosaihkymd())));
        bzKykKihonLayoutFile.setIfeTslastmeihenymd(convertTestData.setNull(String.valueOf(pKykKihon.getLastmeihenymd())));
        bzKykKihonLayoutFile.setIfeTslastkykmeighnkymd(convertTestData.setNull(String.valueOf(
            pKykKihon.getLastkykmeighnkymd())));
        bzKykKihonLayoutFile.setIfeTslastsbukthenymd(convertTestData.setNull(String.valueOf(
            pKykKihon.getLastsbukthenymd())));
        bzKykKihonLayoutFile.setIfeTslastkyknmseiymdhenkymd(convertTestData.setNull(String.valueOf(
            pKykKihon.getLastkyknmseiymdhenkouymd())));
        bzKykKihonLayoutFile.setIfeTslastkyknmkanakjteiymd(convertTestData.setNull(String.valueOf(
            pKykKihon.getLastkyknmkanakjteiymd())));
        bzKykKihonLayoutFile.setIfeTslasttsinynohenkouymd(convertTestData.setNull(String.valueOf(
            pKykKihon.getLasttsinynohenkouymd())));
        bzKykKihonLayoutFile.setIfeTslastjyuuhenymd(convertTestData.setNull(String.valueOf(
            pKykKihon.getLastjyuuhenymd())));
        bzKykKihonLayoutFile.setIfeTsgyoumukousinkinou(convertTestData.setNull(pKykKihon.getGyoumuKousinKinou()));
        bzKykKihonLayoutFile.setIfeTsgyoumukousinsyaid(convertTestData.setNull(pKykKihon.getGyoumuKousinsyaId()));
        bzKykKihonLayoutFile.setIfeTsgyoumukousintime(convertTestData.setNull(pKykKihon.getGyoumuKousinTime()));
        bzKykKihonLayoutFile.setIfeTskousinsyaid("init");
        bzKykKihonLayoutFile.setIfeTskousintime("0");
        bzKykKihonLayoutFile.setIfeTskousinkinou("init");
        bzKykKihonLayoutFile.setIfeTsversion("0");

        bzKykKihonLayoutFile.setIfeTsseiritujitrhkjikakkbn(convertTestData.setNull(String.valueOf(
            pKykKihon.getSeiritujitrhkjikakkbn())));
        bzKykKihonLayoutFile.setIfeTstikiktbrisyuruikbn(convertTestData.setNull(String.valueOf(pKykKihon
            .getTikiktbrisyuruikbn())));
        bzKykKihonLayoutFile.setIfeTsyakkanjyuryouhoukbn(convertTestData.setNull(String.valueOf(pKykKihon
            .getYakkanjyuryouhoukbn())));
        bzKykKihonLayoutFile.setIfeTsyakkanbunsyono(convertTestData.setNull(pKykKihon.getYakkanbunsyono()));
        bzKykKihonLayoutFile.setIfeTssiorino(convertTestData.setNull(pKykKihon.getSiorino()));

        return bzKykKihonLayoutFile;

    }

    private BzKykSonotaTkykLayoutFile getBzKykSonotaTkykLayoutFile(IT_KykSonotaTkyk pKykSonotaTkyk, String pKbnkey,
        String pSyoNo) {

        BzKykSonotaTkykLayoutFile bzKykSonotaTkykLayoutFile = SWAKInjector.getInstance(BzKykSonotaTkykLayoutFile.class);

        ConvertTestData convertTestData = SWAKInjector.getInstance(ConvertTestData.class);

        bzKykSonotaTkykLayoutFile.setIfeTskbnkey(pKbnkey);
        bzKykSonotaTkykLayoutFile.setIfeTssyono(pSyoNo);
        bzKykSonotaTkykLayoutFile.setIfeTslivingneedshukaumu(convertTestData.setNull(String.valueOf(
            pKykSonotaTkyk.getLivingneedshukaumu())));
        bzKykSonotaTkykLayoutFile.setIfeTsstdrsktkyhkumu(convertTestData.setNull(String.valueOf(
            pKykSonotaTkyk.getStdrsktkyhkumu())));
        bzKykSonotaTkykLayoutFile.setIfeTsstdrsktkyhkymd(convertTestData.setNull(String.valueOf
            (pKykSonotaTkyk.getStdrsktkyhkymd())));
        bzKykSonotaTkykLayoutFile.setIfeTsyennykntkhkumu(convertTestData.setNull(String.valueOf(
            pKykSonotaTkyk.getYennykntkhkumu())));
        bzKykSonotaTkykLayoutFile.setIfeTsgaikanykntkhkumu(convertTestData.setNull(String.valueOf(
            pKykSonotaTkyk.getGaikanykntkhkumu())));
        bzKykSonotaTkykLayoutFile.setIfeTsyenshrtkhkumu(convertTestData.setNull(String.valueOf(
            pKykSonotaTkyk.getYenshrtkhkumu())));
        bzKykSonotaTkykLayoutFile.setIfeTsyenshrkykkykhenkoymd(convertTestData.setNull(String.valueOf(
            pKykSonotaTkyk.getYenshrkykkykhenkoymd())));
        bzKykSonotaTkykLayoutFile.setIfeTsnkgkkateitkumu(convertTestData.setNull(String.valueOf(
            pKykSonotaTkyk.getNkgkkateitkumu())));
        bzKykSonotaTkykLayoutFile.setIfeTsnksgkhosyuwari(convertTestData.setNull(String.valueOf(pKykSonotaTkyk.getNksgkhosyuwari())));
        bzKykSonotaTkykLayoutFile.setIfeTsskjbrnktsumu(convertTestData.setNull(String.valueOf(
            pKykSonotaTkyk.getSkjbrnktsumu())));
        bzKykSonotaTkykLayoutFile.setIfeTsnenkingaku8waritkumu(convertTestData.setNull(String.valueOf(
            pKykSonotaTkyk.getNenkingaku8waritkumu())));
        bzKykSonotaTkykLayoutFile.setIfeTsnenkingaku9waritkumu(convertTestData.setNull(String.valueOf(
            pKykSonotaTkyk.getNenkingaku9waritkumu())));
        bzKykSonotaTkykLayoutFile.setIfeTsnkyentkhukaumu(convertTestData.setNull(String.valueOf(
            pKykSonotaTkyk.getNkyentkhukaumu())));
        bzKykSonotaTkykLayoutFile.setIfeTskwsttkhukaumu(convertTestData.setNull(String.valueOf(
            pKykSonotaTkyk.getKwsttkhukaumu())));
        bzKykSonotaTkykLayoutFile.setIfeTskwstargetrate(convertTestData.setNull(String.valueOf(pKykSonotaTkyk.getKwstargetrate())));
        bzKykSonotaTkykLayoutFile.setIfeTstargettkhkumu(convertTestData.setNull(String.valueOf(
            pKykSonotaTkyk.getTargettkhkumu())));
        bzKykSonotaTkykLayoutFile.setIfeTstargettkykkykhenkoymd(convertTestData.setNull(String.valueOf(
            pKykSonotaTkyk.getTargettkykkykhenkoymd())));
        bzKykSonotaTkykLayoutFile.setIfeTstargettkkbn(convertTestData.setNull(String.valueOf(
            pKykSonotaTkyk.getTargettkkbn())));
        bzKykSonotaTkykLayoutFile.setIfeTstargettkmokuhyouti(convertTestData.setNull(String.valueOf(pKykSonotaTkyk.getTargettkmokuhyouti())));
        bzKykSonotaTkykLayoutFile.setIfeTsysknkshtkumu(convertTestData.setNull(String.valueOf(
            pKykSonotaTkyk.getYsknkshtkumu())));
        bzKykSonotaTkykLayoutFile.setIfeTspmnjtkkbn(convertTestData.setNull(String.valueOf(
            pKykSonotaTkyk.getPmnjtkkbn())));
        bzKykSonotaTkykLayoutFile.setIfeTspmnjtkkykymd(convertTestData.setNull(String.valueOf(
            pKykSonotaTkyk.getPmnjtkkykymd())));
        bzKykSonotaTkykLayoutFile.setIfeTspmnjtksknnkaisiymd(convertTestData.setNull(String.valueOf(
            pKykSonotaTkyk.getPmnjtksknnkaisiymd())));
        bzKykSonotaTkykLayoutFile.setIfeTspmnjtkgansknnkaisiymd(convertTestData.setNull(String.valueOf(
            pKykSonotaTkyk.getPmnjtkgansknnkaisiymd())));
        bzKykSonotaTkykLayoutFile.setIfeTspmhktsknnkaisiymd(convertTestData.setNull(String.valueOf(
            pKykSonotaTkyk.getPmhktsknnkaisiymd())));
        bzKykSonotaTkykLayoutFile.setIfeTspmnjhktgansknnkaisiymd(convertTestData.setNull(String.valueOf(
            pKykSonotaTkyk.getPmnjhktgansknnkaisiymd())));
        bzKykSonotaTkykLayoutFile.setIfeTspmnjtkhtnpbuicd1(convertTestData.setNull(pKykSonotaTkyk.getPmnjtkhtnpbuicd1()));
        bzKykSonotaTkykLayoutFile.setIfeTspmnjtkhtnpkkn1(convertTestData.setNull(String.valueOf(
            pKykSonotaTkyk.getPmnjtkhtnpkkn1())));
        bzKykSonotaTkykLayoutFile.setIfeTspmnjtkhtnpbuicd2(convertTestData.setNull(pKykSonotaTkyk.getPmnjtkhtnpbuicd2()));
        bzKykSonotaTkykLayoutFile.setIfeTspmnjtkhtnpkkn2(convertTestData.setNull(String.valueOf(
            pKykSonotaTkyk.getPmnjtkhtnpkkn2())));
        bzKykSonotaTkykLayoutFile.setIfeTspmnjtkhtnpbuicd3(convertTestData.setNull(pKykSonotaTkyk.getPmnjtkhtnpbuicd3()));
        bzKykSonotaTkykLayoutFile.setIfeTspmnjtkhtnpkkn3(convertTestData.setNull(String.valueOf(
            pKykSonotaTkyk.getPmnjtkhtnpkkn3())));
        bzKykSonotaTkykLayoutFile.setIfeTspmnjtkhtnpbuicd4(convertTestData.setNull(pKykSonotaTkyk.getPmnjtkhtnpbuicd4()));
        bzKykSonotaTkykLayoutFile.setIfeTspmnjtkhtnpkkn4(convertTestData.setNull(String.valueOf(
            pKykSonotaTkyk.getPmnjtkhtnpkkn4())));
        bzKykSonotaTkykLayoutFile.setIfeTspmnjtokkoudosghtnpkbn(convertTestData.setNull(String.valueOf(
            pKykSonotaTkyk.getPmnjtokkoudosghtnpkbn())));
        bzKykSonotaTkykLayoutFile.setIfeTssknnkaisikitkkbn(convertTestData.setNull(String.valueOf(
            pKykSonotaTkyk.getSknnkaisikitkkbn())));
        bzKykSonotaTkykLayoutFile.setIfeTsnstkhkumu(convertTestData.setNull(String.valueOf(
            pKykSonotaTkyk.getNstkhkumu())));
        bzKykSonotaTkykLayoutFile.setIfeTsnkshrtkykhenkoymd(convertTestData.setNull(String.valueOf(
            pKykSonotaTkyk.getNkshrtkykhenkoymd())));
        bzKykSonotaTkykLayoutFile.setIfeTsnkshrtkyknksyukbn(convertTestData.setNull(String.valueOf(
            pKykSonotaTkyk.getNkshrtkyknksyukbn())));
        bzKykSonotaTkykLayoutFile.setIfeTsnkshrtkyknksyukkn(convertTestData.setNull(String.valueOf(pKykSonotaTkyk.getNkshrtkyknksyukkn())));
        bzKykSonotaTkykLayoutFile.setIfeTsinitsbjyensthsytkhkumu(convertTestData.setNull(String.valueOf(
            pKykSonotaTkyk.getInitsbjiyensitihsytkhukaumu())));
        bzKykSonotaTkykLayoutFile.setIfeTsinitsbjiyenkasthsygk(convertTestData.setNull(setBizCurrencyVal(pKykSonotaTkyk.getInitsbjiyenkasaiteihsygk())));
        bzKykSonotaTkykLayoutFile.setIfeTsinitsbjiyenkasthsygkt(convertTestData.setNull(setBizCurrencyType(pKykSonotaTkyk.getInitsbjiyenkasaiteihsygk())));
        bzKykSonotaTkykLayoutFile.setIfeTsjydkgomeharaitkhukaumu(convertTestData.setNull(String.valueOf(
            pKykSonotaTkyk.getJyudkaigomeharaitkhukaumu())));
        bzKykSonotaTkykLayoutFile.setIfeTsjydkgomeharaitkhukaymd(convertTestData.setNull(String.valueOf(
            pKykSonotaTkyk.getJyudkaigomeharaitkhukaymd())));
        bzKykSonotaTkykLayoutFile.setIfeTsgyoumukousinkinou(convertTestData.setNull(
            pKykSonotaTkyk.getGyoumuKousinKinou()));
        bzKykSonotaTkykLayoutFile.setIfeTsgyoumukousinsyaid(convertTestData.setNull(
            pKykSonotaTkyk.getGyoumuKousinsyaId()));
        bzKykSonotaTkykLayoutFile.setIfeTsgyoumukousintime(convertTestData.setNull(pKykSonotaTkyk.getGyoumuKousinTime()));
        bzKykSonotaTkykLayoutFile.setIfeTskousinsyaid("init");
        bzKykSonotaTkykLayoutFile.setIfeTskousintime("0");
        bzKykSonotaTkykLayoutFile.setIfeTskousinkinou("init");
        bzKykSonotaTkykLayoutFile.setIfeTsversion("0");
        bzKykSonotaTkykLayoutFile.setIfeTstargettkykhkymd(convertTestData.setNull(String.valueOf(
            pKykSonotaTkyk.getTargettkykhkymd())));
        bzKykSonotaTkykLayoutFile.setIfeTstargettkykkijyungk(convertTestData.setNull(setBizCurrencyVal(pKykSonotaTkyk.getTargettkykkijyungk())));
        bzKykSonotaTkykLayoutFile.setIfeTstargettkykkijyungkt(convertTestData.setNull(setBizCurrencyType(pKykSonotaTkyk.getTargettkykkijyungk())));
        bzKykSonotaTkykLayoutFile.setIfeTszeiseitkkktkykhukaumu(convertTestData.setNull(String.valueOf(pKykSonotaTkyk
            .getZeiseitkkktkykhukaumu())));
        bzKykSonotaTkykLayoutFile.setIfeTszeiseitkkktkykhukaymd(convertTestData.setNull(String.valueOf(pKykSonotaTkyk
            .getZeiseitkkktkykhukaymd())));
        bzKykSonotaTkykLayoutFile.setIfeTszeiseitkkktkyksymtymd(convertTestData.setNull(String.valueOf(pKykSonotaTkyk
            .getZeiseitkkktkyksyoumetuymd())));
        bzKykSonotaTkykLayoutFile.setIfeTsyennyknsyuruikbn(convertTestData.setNull(String.valueOf(pKykSonotaTkyk
            .getYennyknsyuruikbn())));
        bzKykSonotaTkykLayoutFile.setIfeTskykdrtkykhukaumu(convertTestData.setNull(String.valueOf(pKykSonotaTkyk
            .getKykdrtkykhukaumu())));
        bzKykSonotaTkykLayoutFile.setIfeTskykdrtkykhukaymd(convertTestData.setNull(String.valueOf(pKykSonotaTkyk
            .getKykdrtkykhukaymd())));
        bzKykSonotaTkykLayoutFile.setIfeTskykdrtkykkaiyakuymd(convertTestData.setNull(String.valueOf(pKykSonotaTkyk
            .getKykdrtkykkaiyakuymd())));
        bzKykSonotaTkykLayoutFile.setIfeTsteikishrtkykhukaumu(convertTestData.setNull(String.valueOf(pKykSonotaTkyk
            .getTeikishrtkykhukaumu())));
        bzKykSonotaTkykLayoutFile.setIfeTsteikishrkinshrtuukasyu(convertTestData.setNull(String.valueOf(pKykSonotaTkyk
            .getTeikishrkinshrtuukasyu())));
        bzKykSonotaTkykLayoutFile.setIfeTsteikishrkinshrmd(convertTestData.setNull(String.valueOf(pKykSonotaTkyk
            .getTeikishrkinshrmd())));

        return bzKykSonotaTkykLayoutFile;
    }

    private BzKykSyaLayoutFile getBzKykSyaLayoutFile(IT_KykSya pKykSya, String pKbnkey, String pSyoNo) {

        BzKykSyaLayoutFile bzKykSyaLayoutFile = SWAKInjector.getInstance(BzKykSyaLayoutFile.class);

        ConvertTestData convertTestData = SWAKInjector.getInstance(ConvertTestData.class);

        bzKykSyaLayoutFile.setIfeTskbnkey(pKbnkey);
        bzKykSyaLayoutFile.setIfeTssyono(pSyoNo);
        bzKykSyaLayoutFile.setIfeTskokno(setKoteiatai(pKykSya.getKokno(), ""));
        bzKykSyaLayoutFile.setIfeTskyksakuinmeino(setKoteiatai(pKykSya.getKyksakuinmeino(), ""));
        bzKykSyaLayoutFile.setIfeTskyknmkn(convertTestDataForKanaMeigi.getKnmeigi(pKykSya.getKyknmkn()));
        bzKykSyaLayoutFile.setIfeTskyknmkj(convertTestData.setTestKanjiNm(pKykSya.getKyknmkj(), KYKNMKJ, pSyoNo));
        bzKykSyaLayoutFile.setIfeTskyknmkjkhukakbn(convertTestData.setNull(String.valueOf(pKykSya.getKyknmkjkhukakbn())));
        bzKykSyaLayoutFile.setIfeTskykseiymd(convertTestData.setNull(String.valueOf(pKykSya.getKykseiymd())));
        bzKykSyaLayoutFile.setIfeTskyksei(convertTestData.setNull(String.valueOf(pKykSya.getKyksei())));
        bzKykSyaLayoutFile.setIfeTskkkyktdk(convertTestData.setNull(String.valueOf(pKykSya.getKkkyktdk())));
        bzKykSyaLayoutFile.setIfeTstsinyno(setKoteiatai(pKykSya.getTsinyno(), POSTALCD));
        bzKykSyaLayoutFile.setIfeTstsinadr1kn(setKoteiatai(pKykSya.getTsinadr1kn(), ""));
        bzKykSyaLayoutFile.setIfeTstsinadr1kj(setKoteiatai(pKykSya.getTsinadr1kj(), TSINADR1KJ));
        bzKykSyaLayoutFile.setIfeTstsinadr2kn(setKoteiatai(pKykSya.getTsinadr2kn(), ""));
        bzKykSyaLayoutFile.setIfeTstsinadr2kj(setKoteiatai(pKykSya.getTsinadr2kj(), TSINADR2KJ));
        bzKykSyaLayoutFile.setIfeTstsinadr3kn(setKoteiatai(pKykSya.getTsinadr3kn(), ""));
        bzKykSyaLayoutFile.setIfeTstsinadr3kj(setKoteiatai(pKykSya.getTsinadr3kj(), TSINADR3KJ));
        bzKykSyaLayoutFile.setIfeTstsintelno(setKoteiatai(pKykSya.getTsintelno(), TELNO));
        bzKykSyaLayoutFile.setIfeTsdai2tsintelno(setKoteiatai(pKykSya.getDai2tsintelno(), ""));
        bzKykSyaLayoutFile.setIfeTstsinmailaddress(setKoteiatai(pKykSya.getTsinmailaddress(), ""));
        bzKykSyaLayoutFile.setIfeTskinmusakinm(setKoteiatai(pKykSya.getKinmusakinm(), ""));
        bzKykSyaLayoutFile.setIfeTshjndaiykkbn(convertTestData.setNull(String.valueOf(pKykSya.getHjndaiykkbn())));
        bzKykSyaLayoutFile.setIfeTshjndaiyknm(setKoteiatai(pKykSya.getHjndaiyknm(), ""));
        bzKykSyaLayoutFile.setIfeTshjndainmkn(setKoteiatai(pKykSya.getHjndainmkn(), ""));
        bzKykSyaLayoutFile.setIfeTshjndainmkj(setKoteiatai(pKykSya.getHjndainmkj(), ""));
        bzKykSyaLayoutFile.setIfeTsgyoumukousinkinou(convertTestData.setNull(pKykSya.getGyoumuKousinKinou()));
        bzKykSyaLayoutFile.setIfeTsgyoumukousinsyaid(convertTestData.setNull(pKykSya.getGyoumuKousinsyaId()));
        bzKykSyaLayoutFile.setIfeTsgyoumukousintime(convertTestData.setNull(pKykSya.getGyoumuKousinTime()));
        bzKykSyaLayoutFile.setIfeTskousinsyaid("init");
        bzKykSyaLayoutFile.setIfeTskousintime("0");
        bzKykSyaLayoutFile.setIfeTskousinkinou("init");
        bzKykSyaLayoutFile.setIfeTsversion("0");

        return bzKykSyaLayoutFile;
    }

    private BzKykSyouhnLayoutFile getBzKykSyouhnLayoutFile(IT_KykSyouhn pKykSyouhn, String pKbnkey, String pSyoNo) {

        BzKykSyouhnLayoutFile bzKykSyouhnLayoutFile = SWAKInjector.getInstance(BzKykSyouhnLayoutFile.class);

        ConvertTestData convertTestData = SWAKInjector.getInstance(ConvertTestData.class);

        bzKykSyouhnLayoutFile.setIfeTskbnkey(pKbnkey);
        bzKykSyouhnLayoutFile.setIfeTssyono(pSyoNo);
        bzKykSyouhnLayoutFile.setIfeTssyutkkbn(String.valueOf(pKykSyouhn.getSyutkkbn()));
        bzKykSyouhnLayoutFile.setIfeTssyouhncd(pKykSyouhn.getSyouhncd());
        bzKykSyouhnLayoutFile.setIfeTssyouhnsdno(String.valueOf(pKykSyouhn.getSyouhnsdno()));
        bzKykSyouhnLayoutFile.setIfeTskyksyouhnrenno(String.valueOf(pKykSyouhn.getKyksyouhnrenno()));
        bzKykSyouhnLayoutFile.setIfeTshenkousikibetukey(convertTestData.setNull(pKykSyouhn.getHenkousikibetukey()));
        bzKykSyouhnLayoutFile.setIfeTsyuukousyoumetukbn(convertTestData.setNull(String.valueOf(
            pKykSyouhn.getYuukousyoumetukbn())));
        bzKykSyouhnLayoutFile.setIfeTskykjyoutai(convertTestData.setNull(String.valueOf(pKykSyouhn.getKykjyoutai())));
        bzKykSyouhnLayoutFile.setIfeTssyoumetujiyuu(convertTestData.setNull(String.valueOf(
            pKykSyouhn.getSyoumetujiyuu())));
        bzKykSyouhnLayoutFile.setIfeTssyoumetuymd(convertTestData.setNull(String.valueOf(pKykSyouhn.getSyoumetuymd())));
        bzKykSyouhnLayoutFile.setIfeTskouryokuhasseiymd(convertTestData.setNull(String.valueOf(
            pKykSyouhn.getKouryokuhasseiymd())));
        bzKykSyouhnLayoutFile.setIfeTskykymd(convertTestData.setNull(String.valueOf(pKykSyouhn.getKykymd())));
        bzKykSyouhnLayoutFile.setIfeTskykymdsiteiumukbn(convertTestData.setNull(String.valueOf(
            pKykSyouhn.getKykymdsiteiumukbn())));
        bzKykSyouhnLayoutFile.setIfeTssknnkaisiymd(convertTestData.setNull(String.valueOf(pKykSyouhn.getSknnkaisiymd())));
        bzKykSyouhnLayoutFile.setIfeTsgansknnkaisiymd(convertTestData.setNull(String.valueOf(
            pKykSyouhn.getGansknnkaisiymd())));
        bzKykSyouhnLayoutFile.setIfeTshksknnkaisiymd(convertTestData.setNull(String.valueOf(
            pKykSyouhn.getHksknnkaisiymd())));
        bzKykSyouhnLayoutFile.setIfeTshkgansknnkaisiymd(convertTestData.setNull(String.valueOf(
            pKykSyouhn.getHkgansknnkaisiymd())));
        bzKykSyouhnLayoutFile.setIfeTshknkknsmnkbn(convertTestData.setNull(String.valueOf(pKykSyouhn.getHknkknsmnkbn())));
        bzKykSyouhnLayoutFile.setIfeTshknkkn(convertTestData.setNull(String.valueOf(pKykSyouhn.getHknkkn())));
        bzKykSyouhnLayoutFile.setIfeTshrkkknsmnkbn(convertTestData.setNull(String.valueOf(pKykSyouhn.getHrkkknsmnkbn())));
        bzKykSyouhnLayoutFile.setIfeTshrkkkn(convertTestData.setNull(String.valueOf(pKykSyouhn.getHrkkkn())));
        bzKykSyouhnLayoutFile.setIfeTskyknen(convertTestData.setNull(String.valueOf(pKykSyouhn.getKyknen())));
        bzKykSyouhnLayoutFile.setIfeTshhknnen(convertTestData.setNull(String.valueOf(pKykSyouhn.getHhknnen())));
        bzKykSyouhnLayoutFile.setIfeTshhknseiymd(convertTestData.setNull(String.valueOf(pKykSyouhn.getHhknseiymd())));
        bzKykSyouhnLayoutFile.setIfeTshhknsei(convertTestData.setNull(String.valueOf(pKykSyouhn.getHhknsei())));
        bzKykSyouhnLayoutFile.setIfeTsharaimanymd(convertTestData.setNull(String.valueOf(pKykSyouhn.getHaraimanymd())));
        bzKykSyouhnLayoutFile.setIfeTshknkknmanryouymd(convertTestData.setNull(String.valueOf(
            pKykSyouhn.getHknkknmanryouymd())));
        bzKykSyouhnLayoutFile.setIfeTskatakbn(convertTestData.setNull(String.valueOf(pKykSyouhn.getKatakbn())));
        bzKykSyouhnLayoutFile.setIfeTskyhgndkatakbn(convertTestData.setNull(String.valueOf(
            pKykSyouhn.getKyhgndkatakbn())));
        bzKykSyouhnLayoutFile.setIfeTssyukyhkinkatakbn(convertTestData.setNull(String.valueOf(
            pKykSyouhn.getSyukyhkinkatakbn())));
        bzKykSyouhnLayoutFile.setIfeTskhnkyhkgbairitukbn(convertTestData.setNull(String.valueOf(
            pKykSyouhn.getKhnkyhkgbairitukbn())));
        bzKykSyouhnLayoutFile.setIfeTsrokudaildkbn(convertTestData.setNull(String.valueOf(pKykSyouhn.getRokudaildkbn())));
        bzKykSyouhnLayoutFile.setIfeTspmnjtkkbn(convertTestData.setNull(String.valueOf(pKykSyouhn.getPmnjtkkbn())));
        bzKykSyouhnLayoutFile.setIfeTskihons(convertTestData.setNull(setBizCurrencyVal(pKykSyouhn.getKihons())));
        bzKykSyouhnLayoutFile.setIfeTskihonst(convertTestData.setNull(setBizCurrencyType(pKykSyouhn.getKihons())));
        bzKykSyouhnLayoutFile.setIfeTshokenryou(convertTestData.setNull(setBizCurrencyVal(pKykSyouhn.getHokenryou())));
        bzKykSyouhnLayoutFile.setIfeTshokenryout(convertTestData.setNull(setBizCurrencyType(pKykSyouhn.getHokenryou())));
        bzKykSyouhnLayoutFile.setIfeTskyktuukasyu(convertTestData.setNull(String.valueOf(pKykSyouhn.getKyktuukasyu())));
        bzKykSyouhnLayoutFile.setIfeTsryouritusdno(convertTestData.setNull(pKykSyouhn.getRyouritusdno()));
        bzKykSyouhnLayoutFile.setIfeTsyoteiriritu(convertTestData.setNull(String.valueOf(pKykSyouhn.getYoteiriritu())));
        bzKykSyouhnLayoutFile.setIfeTsyoteirrthendohosyurrt(convertTestData.setNull(String.valueOf(pKykSyouhn.getYoteirrthendohosyurrt())));
        bzKykSyouhnLayoutFile.setIfeTsytirrthndmnskaisuu(convertTestData.setNull(String.valueOf(pKykSyouhn.getYtirrthndmnskaisuu())));
        bzKykSyouhnLayoutFile.setIfeTskyksjkkktyouseiriritu(convertTestData.setNull(String.valueOf(pKykSyouhn.getKyksjkkktyouseiriritu())));
        bzKykSyouhnLayoutFile.setIfeTsnksyukbn(convertTestData.setNull(String.valueOf(pKykSyouhn.getNksyukbn())));
        bzKykSyouhnLayoutFile.setIfeTsnenkinkkn(convertTestData.setNull(String.valueOf(pKykSyouhn.getNenkinkkn())));
        bzKykSyouhnLayoutFile.setIfeTsnkgnshosyouritu(convertTestData.setNull(String.valueOf(pKykSyouhn.getNkgnshosyouritu())));
        bzKykSyouhnLayoutFile.setIfeTsnkgnshosyougk(convertTestData.setNull(setBizCurrencyVal(pKykSyouhn.getNkgnshosyougk())));
        bzKykSyouhnLayoutFile.setIfeTsnkgnshosyougkt(convertTestData.setNull(setBizCurrencyType(pKykSyouhn.getNkgnshosyougk())));
        bzKykSyouhnLayoutFile.setIfeTsgyoumukousinkinou(convertTestData.setNull(pKykSyouhn.getGyoumuKousinKinou()));
        bzKykSyouhnLayoutFile.setIfeTsgyoumukousinsyaid(convertTestData.setNull(pKykSyouhn.getGyoumuKousinsyaId()));
        bzKykSyouhnLayoutFile.setIfeTsgyoumukousintime(convertTestData.setNull(pKykSyouhn.getGyoumuKousinTime()));
        bzKykSyouhnLayoutFile.setIfeTskousinsyaid("init");
        bzKykSyouhnLayoutFile.setIfeTskousintime("0");
        bzKykSyouhnLayoutFile.setIfeTskousinkinou("init");
        bzKykSyouhnLayoutFile.setIfeTsversion("0");
        bzKykSyouhnLayoutFile.setIfeTsgengakugyenitjbrpstgk(convertTestData.setNull(setBizCurrencyVal(pKykSyouhn.getGengakugoyenitijibrpstgk())));
        bzKykSyouhnLayoutFile.setIfeTsgengakugyenitjbrpstgkt(convertTestData.setNull(setBizCurrencyType(pKykSyouhn.getGengakugoyenitijibrpstgk())));
        bzKykSyouhnLayoutFile.setIfeTsyendthnkymd(convertTestData.setNull(String.valueOf(pKykSyouhn.getYendthnkymd())));
        bzKykSyouhnLayoutFile.setIfeTssetteibairitu(convertTestData.setNull(String.valueOf(pKykSyouhn.getSetteibairitu())));
        bzKykSyouhnLayoutFile.setIfeTskykjisisuurendourate(convertTestData.setNull(String.valueOf(pKykSyouhn.getKykjisisuurendourate())));
        bzKykSyouhnLayoutFile.setIfeTstmttknzoukaritujygn(convertTestData.setNull(String.valueOf(pKykSyouhn.getTmttknzoukaritujygn())));
        bzKykSyouhnLayoutFile.setIfeTstumitateriritu(convertTestData.setNull(String.valueOf(pKykSyouhn.getTumitateriritu())));
        bzKykSyouhnLayoutFile.setIfeTstmttknhaibunjyoutai(convertTestData.setNull(String.valueOf(
            pKykSyouhn.getTmttknhaibunjyoutai())));
        bzKykSyouhnLayoutFile.setIfeTssisuukbn(convertTestData.setNull(String.valueOf(pKykSyouhn.getSisuukbn())));
        bzKykSyouhnLayoutFile.setIfeTsgsbunrikzkakuninumu(convertTestData.setNull(String.valueOf(
            pKykSyouhn.getGsbunrikzkakuninumu())));
        bzKykSyouhnLayoutFile.setIfeTsgsbunritaisyou(convertTestData.setNull(String.valueOf(
            pKykSyouhn.getGsbunritaisyou())));
        bzKykSyouhnLayoutFile.setIfeTspharaikomisougaku(convertTestData.setNull(setBizCurrencyVal(pKykSyouhn
            .getPharaikomisougaku())));
        bzKykSyouhnLayoutFile.setIfeTspharaikomisougakut(convertTestData.setNull(setBizCurrencyType(pKykSyouhn
            .getPharaikomisougaku())));
        bzKykSyouhnLayoutFile.setIfeTstmttknitenymd(convertTestData.setNull(String.valueOf(pKykSyouhn.getTmttknitenymd())));
        bzKykSyouhnLayoutFile.setIfeTsloadinghnkgtmttrrt(convertTestData.setNull(String.valueOf(pKykSyouhn.getLoadinghnkgtumitateriritu())));
        bzKykSyouhnLayoutFile.setIfeTsrendouritu(convertTestData.setNull(String.valueOf(pKykSyouhn.getRendouritu())));
        bzKykSyouhnLayoutFile.setIfeTsteikishrritu(convertTestData.setNull(String.valueOf(pKykSyouhn.getTeikishrritu())));

        return bzKykSyouhnLayoutFile;
    }

    private BzKykUktLayoutFile getBzKykUktLayoutFile(IT_KykUkt pKykUkt, String pKbnkey, String pSyoNo) {

        BzKykUktLayoutFile bzKykUktLayoutFile = SWAKInjector.getInstance(BzKykUktLayoutFile.class);

        ConvertTestData convertTestData = SWAKInjector.getInstance(ConvertTestData.class);

        bzKykUktLayoutFile.setIfeTskbnkey(pKbnkey);
        bzKykUktLayoutFile.setIfeTssyono(pSyoNo);
        bzKykUktLayoutFile.setIfeTsuktsyukbn(String.valueOf(pKykUkt.getUktsyukbn()));
        bzKykUktLayoutFile.setIfeTsuktsyurenno(String.valueOf(pKykUkt.getUktsyurenno()));
        bzKykUktLayoutFile.setIfeTskokno(setKoteiatai(pKykUkt.getKokno(), ""));
        bzKykUktLayoutFile.setIfeTsuktkbn(convertTestData.setNull(String.valueOf(pKykUkt.getUktkbn())));
        bzKykUktLayoutFile.setIfeTsuktnmkn(convertTestDataForKanaMeigi.getKnmeigi(pKykUkt.getUktnmkn()));
        bzKykUktLayoutFile.setIfeTsuktnmkj(convertTestData.setTestKanjiNm(pKykUkt.getUktnmkj(), UKTNMKJ, pSyoNo));
        bzKykUktLayoutFile.setIfeTsuktnmkjkhukakbn(convertTestData.setNull(String.valueOf(pKykUkt.getUktnmkjkhukakbn())));
        bzKykUktLayoutFile.setIfeTsuktseiymd(convertTestData.setNull(String.valueOf(pKykUkt.getUktseiymd())));
        bzKykUktLayoutFile.setIfeTsukttdk(convertTestData.setNull(String.valueOf(pKykUkt.getUkttdk())));
        bzKykUktLayoutFile.setIfeTsuktbnwari(convertTestData.setNull(String.valueOf(pKykUkt.getUktbnwari())));
        bzKykUktLayoutFile.setIfeTsgyoumukousinkinou(convertTestData.setNull(pKykUkt.getGyoumuKousinKinou()));
        bzKykUktLayoutFile.setIfeTsgyoumukousinsyaid(convertTestData.setNull(pKykUkt.getGyoumuKousinsyaId()));
        bzKykUktLayoutFile.setIfeTsgyoumukousintime(convertTestData.setNull(pKykUkt.getGyoumuKousinTime()));
        bzKykUktLayoutFile.setIfeTskousinsyaid("init");
        bzKykUktLayoutFile.setIfeTskousintime("0");
        bzKykUktLayoutFile.setIfeTskousinkinou("init");
        bzKykUktLayoutFile.setIfeTsversion("0");
        bzKykUktLayoutFile.setIfeTsuktyno(setKoteiatai(pKykUkt.getUktyno(), ""));
        bzKykUktLayoutFile.setIfeTsuktadr1kj(setKoteiatai(pKykUkt.getUktadr1kj(), ""));
        bzKykUktLayoutFile.setIfeTsuktadr2kj(setKoteiatai(pKykUkt.getUktadr2kj(), ""));
        bzKykUktLayoutFile.setIfeTsuktadr3kj(setKoteiatai(pKykUkt.getUktadr3kj(), ""));

        return bzKykUktLayoutFile;
    }

    private BzNyknJissekiRirekiLayoutFile getBzNyknJissekiRirekiLayoutFile(IT_NyknJissekiRireki pNyknJissekiRireki,
        String pKbnkey, String pSyoNo) {

        BzNyknJissekiRirekiLayoutFile bzNyknJissekiRirekiLayoutFile = SWAKInjector.getInstance(
            BzNyknJissekiRirekiLayoutFile.class);

        ConvertTestData convertTestData = SWAKInjector.getInstance(ConvertTestData.class);

        bzNyknJissekiRirekiLayoutFile.setIfeTskbnkey(pKbnkey);
        bzNyknJissekiRirekiLayoutFile.setIfeTssyono(pSyoNo);
        bzNyknJissekiRirekiLayoutFile.setIfeTsjyutoustartym(String.valueOf(pNyknJissekiRireki.getJyutoustartym()));
        bzNyknJissekiRirekiLayoutFile.setIfeTsrenno(String.valueOf(pNyknJissekiRireki.getRenno()));
        bzNyknJissekiRirekiLayoutFile.setIfeTsjyutouendym(convertTestData.setNull(String.valueOf(
            pNyknJissekiRireki.getJyutouendym())));
        bzNyknJissekiRirekiLayoutFile.setIfeTsrsgaku(convertTestData.setNull(setBizCurrencyVal(pNyknJissekiRireki.getRsgaku())));
        bzNyknJissekiRirekiLayoutFile.setIfeTsrsgakut(convertTestData.setNull(setBizCurrencyType(pNyknJissekiRireki.getRsgaku())));
        bzNyknJissekiRirekiLayoutFile.setIfeTsrstuukasyu(convertTestData.setNull(String.valueOf(
            pNyknJissekiRireki.getRstuukasyu())));
        bzNyknJissekiRirekiLayoutFile.setIfeTsryosyukwsratekjymd(convertTestData.setNull(String.valueOf(
            pNyknJissekiRireki.getRyosyukwsratekjymd())));
        bzNyknJissekiRirekiLayoutFile.setIfeTsryosyukwsrate(convertTestData.setNull(String.valueOf(pNyknJissekiRireki.getRyosyukwsrate())));
        bzNyknJissekiRirekiLayoutFile.setIfeTshrkp(convertTestData.setNull(setBizCurrencyVal(pNyknJissekiRireki.getHrkp())));
        bzNyknJissekiRirekiLayoutFile.setIfeTshrkpt(convertTestData.setNull(setBizCurrencyType(pNyknJissekiRireki.getHrkp())));
        bzNyknJissekiRirekiLayoutFile.setIfeTsiktwaribikikgk(convertTestData.setNull(setBizCurrencyVal(pNyknJissekiRireki.getIktwaribikikgk())));
        bzNyknJissekiRirekiLayoutFile.setIfeTsiktwaribikikgkt(convertTestData.setNull(convertTestData.setNull(setBizCurrencyType(pNyknJissekiRireki.getIktwaribikikgk()))));
        bzNyknJissekiRirekiLayoutFile.setIfeTsnyksyoriymd(convertTestData.setNull(String.valueOf(
            pNyknJissekiRireki.getNyksyoriymd())));
        bzNyknJissekiRirekiLayoutFile.setIfeTsryosyuymd(convertTestData.setNull(String.valueOf(
            pNyknJissekiRireki.getRyosyuymd())));
        bzNyknJissekiRirekiLayoutFile.setIfeTsnykdenno(convertTestData.setNull(pNyknJissekiRireki.getNykdenno()));
        bzNyknJissekiRirekiLayoutFile.setIfeTsnykdenymd(convertTestData.setNull(String.valueOf(
            pNyknJissekiRireki.getNykdenymd())));
        bzNyknJissekiRirekiLayoutFile.setIfeTsnykkeiro(convertTestData.setNull(String.valueOf(
            pNyknJissekiRireki.getNykkeiro())));
        bzNyknJissekiRirekiLayoutFile.setIfeTshrkkaisuu(convertTestData.setNull(String.valueOf(
            pNyknJissekiRireki.getHrkkaisuu())));
        bzNyknJissekiRirekiLayoutFile.setIfeTstikiktbrisyuruikbn(convertTestData.setNull(String
            .valueOf(pNyknJissekiRireki.getTikiktbrisyuruikbn())));
        bzNyknJissekiRirekiLayoutFile.setIfeTsikkatuyoupkaisuu(convertTestData.setNull(String
            .valueOf(pNyknJissekiRireki.getIkkatuyoupkaisuu())));
        bzNyknJissekiRirekiLayoutFile.setIfeTsjyutoukaisuuy(convertTestData.setNull(String.valueOf(pNyknJissekiRireki.getJyutoukaisuuy())));
        bzNyknJissekiRirekiLayoutFile.setIfeTsjyutoukaisuum(convertTestData.setNull(String.valueOf(pNyknJissekiRireki.getJyutoukaisuum())));
        bzNyknJissekiRirekiLayoutFile.setIfeTsnyknaiyoukbn(convertTestData.setNull(String.valueOf(
            pNyknJissekiRireki.getNyknaiyoukbn())));
        bzNyknJissekiRirekiLayoutFile.setIfeTsiktnyuukinnumu(convertTestData.setNull(String.valueOf(
            pNyknJissekiRireki.getIktnyuukinnumu())));
        bzNyknJissekiRirekiLayoutFile.setIfeTsnyktrksflg(convertTestData.setNull(String.valueOf(
            pNyknJissekiRireki.getNyktrksflg())));
        bzNyknJissekiRirekiLayoutFile.setIfeTsnyktrksymd(convertTestData.setNull(String.valueOf(
            pNyknJissekiRireki.getNyktrksymd())));
        bzNyknJissekiRirekiLayoutFile.setIfeTsnyktrksdenno(convertTestData.setNull(String.valueOf(
            pNyknJissekiRireki.getNyktrksdenno())));
        bzNyknJissekiRirekiLayoutFile.setIfeTsnyktrksdenymd(convertTestData.setNull(String.valueOf(
            pNyknJissekiRireki.getNyktrksdenymd())));
        bzNyknJissekiRirekiLayoutFile.setIfeTsyenkansannyknkingk(convertTestData.setNull(setBizCurrencyVal(pNyknJissekiRireki.getYenkansannyknkingk())));
        bzNyknJissekiRirekiLayoutFile.setIfeTsyenkansannyknkingkt(convertTestData.setNull(setBizCurrencyType(pNyknJissekiRireki.getYenkansannyknkingk())));
        bzNyknJissekiRirekiLayoutFile.setIfeTsyenkansantkykwsrateymd(convertTestData.setNull(String.valueOf(
            pNyknJissekiRireki.getYenkansantkykwsrateymd())));
        bzNyknJissekiRirekiLayoutFile.setIfeTsyenkansantkykwsrate(convertTestData.setNull(String.valueOf(pNyknJissekiRireki.getYenkansantkykwsrate())));
        bzNyknJissekiRirekiLayoutFile.setIfeTshenkousikibetukey(convertTestData.setNull(String.valueOf(
            pNyknJissekiRireki.getHenkousikibetukey())));
        bzNyknJissekiRirekiLayoutFile.setIfeTsgyoumukousinkinou(convertTestData.setNull(
            pNyknJissekiRireki.getGyoumuKousinKinou()));
        bzNyknJissekiRirekiLayoutFile.setIfeTsgyoumukousinsyaid(convertTestData.setNull(
            pNyknJissekiRireki.getGyoumuKousinsyaId()));
        bzNyknJissekiRirekiLayoutFile.setIfeTsgyoumukousintime(convertTestData.setNull(
            pNyknJissekiRireki.getGyoumuKousinTime()));
        bzNyknJissekiRirekiLayoutFile.setIfeTskousinsyaid("init");
        bzNyknJissekiRirekiLayoutFile.setIfeTskousintime("0");
        bzNyknJissekiRirekiLayoutFile.setIfeTskousinkinou("init");
        bzNyknJissekiRirekiLayoutFile.setIfeTsversion("0");
        bzNyknJissekiRirekiLayoutFile.setIfeTscreditkessaiyouno(setKoteiatai(pNyknJissekiRireki.getCreditkessaiyouno(), ""));

        return bzNyknJissekiRirekiLayoutFile;
    }

    private BzTesuuryouLayoutFile getBzTesuuryouLayoutFile(IT_Tesuuryou pTesuuryou, String pKbnkey, String pSyoNo) {

        BzTesuuryouLayoutFile bzTesuuryouLayoutFile = SWAKInjector.getInstance(BzTesuuryouLayoutFile.class);

        ConvertTestData convertTestData = SWAKInjector.getInstance(ConvertTestData.class);

        bzTesuuryouLayoutFile.setIfeTskbnkey(pKbnkey);
        bzTesuuryouLayoutFile.setIfeTssyono(pSyoNo);
        bzTesuuryouLayoutFile.setIfeTstsrysyorikbn(String.valueOf(pTesuuryou.getTsrysyorikbn()));
        bzTesuuryouLayoutFile.setIfeTsrenno(String.valueOf(pTesuuryou.getRenno()));
        bzTesuuryouLayoutFile.setIfeTssyoriymd(convertTestData.setNull(String.valueOf(pTesuuryou.getSyoriYmd())));
        bzTesuuryouLayoutFile.setIfeTskouryokuhasseiym(convertTestData.setNull(String.valueOf(
            pTesuuryou.getKouryokuhasseiym())));
        bzTesuuryouLayoutFile.setIfeTsnyknkaisuuy(convertTestData.setNull(String.valueOf(pTesuuryou.getNyknkaisuuy())));
        bzTesuuryouLayoutFile.setIfeTsnyknkaisuum(convertTestData.setNull(String.valueOf(pTesuuryou.getNyknkaisuum())));
        bzTesuuryouLayoutFile.setIfeTsmikeikapariflg(convertTestData.setNull(String.valueOf(
            pTesuuryou.getMikeikapariflg())));
        bzTesuuryouLayoutFile.setIfeTsmisyuupariflg(convertTestData.setNull(String.valueOf(
            pTesuuryou.getMisyuupariflg())));
        bzTesuuryouLayoutFile.setIfeTsmikeikap(convertTestData.setNull(setBizCurrencyVal(pTesuuryou.getMikeikap())));
        bzTesuuryouLayoutFile.setIfeTsmikeikapt(convertTestData.setNull(setBizCurrencyType(pTesuuryou.getMikeikap())));
        bzTesuuryouLayoutFile.setIfeTsiktp(convertTestData.setNull(setBizCurrencyVal(pTesuuryou.getIktp())));
        bzTesuuryouLayoutFile.setIfeTsiktpt(convertTestData.setNull(setBizCurrencyType(pTesuuryou.getIktp())));
        bzTesuuryouLayoutFile.setIfeTsseisekiym(convertTestData.setNull(String.valueOf(pTesuuryou.getSeisekiym())));
        bzTesuuryouLayoutFile.setIfeTshrkkaisuu(convertTestData.setNull(String.valueOf(pTesuuryou.getHrkkaisuu())));
        bzTesuuryouLayoutFile.setIfeTshrkkeiro(convertTestData.setNull(String.valueOf(pTesuuryou.getHrkkeiro())));
        bzTesuuryouLayoutFile.setIfeTshrkp(convertTestData.setNull(setBizCurrencyVal(pTesuuryou.getHrkp())));
        bzTesuuryouLayoutFile.setIfeTshrkpt(convertTestData.setNull(setBizCurrencyType(pTesuuryou.getHrkp())));
        bzTesuuryouLayoutFile.setIfeTsjkipjytym(convertTestData.setNull(String.valueOf(pTesuuryou.getJkipjytym())));
        bzTesuuryouLayoutFile.setIfeTshaitounendo(convertTestData.setNull(String.valueOf(pTesuuryou.getHaitounendo())));
        bzTesuuryouLayoutFile.setIfeTscifcd(setKoteiatai(pTesuuryou.getCifcd(), ""));
        bzTesuuryouLayoutFile.setIfeTssmbckanriid(setKoteiatai(pTesuuryou.getSmbckanriid(), ""));
        bzTesuuryouLayoutFile.setIfeTsboskykjyoutai(convertTestData.setNull(String.valueOf(
            pTesuuryou.getBoskykjyoutai())));
        bzTesuuryouLayoutFile.setIfeTskyknmkj(convertTestData.setTestKanjiNm(pTesuuryou.getKyknmkj(), KYKNMKJ,
            pSyoNo));
        bzTesuuryouLayoutFile.setIfeTsbosyuuym(convertTestData.setNull(String.valueOf(pTesuuryou.getBosyuuym())));
        bzTesuuryouLayoutFile.setIfeTsnyknymd(convertTestData.setNull(String.valueOf(pTesuuryou.getNyknymd())));
        bzTesuuryouLayoutFile.setIfeTsyenkansantkykwsrate(convertTestData.setNull(String.valueOf(pTesuuryou.getYenkansantkykwsrate())));
        bzTesuuryouLayoutFile.setIfeTsyenkansantkykwsrateymd(convertTestData.setNull(String.valueOf(
            pTesuuryou.getYenkansantkykwsrateymd())));
        bzTesuuryouLayoutFile.setIfeTstikiktbrisyuruikbn(convertTestData.setNull(String.valueOf(pTesuuryou
            .getTikiktbrisyuruikbn())));
        bzTesuuryouLayoutFile.setIfeTsgyoumukousinkinou(convertTestData.setNull(pTesuuryou.getGyoumuKousinKinou()));
        bzTesuuryouLayoutFile.setIfeTsgyoumukousinsyaid(convertTestData.setNull(pTesuuryou.getGyoumuKousinsyaId()));
        bzTesuuryouLayoutFile.setIfeTsgyoumukousintime(convertTestData.setNull(pTesuuryou.getGyoumuKousinTime()));
        bzTesuuryouLayoutFile.setIfeTskousinsyaid("init");
        bzTesuuryouLayoutFile.setIfeTskousintime("0");
        bzTesuuryouLayoutFile.setIfeTskousinkinou("init");
        bzTesuuryouLayoutFile.setIfeTsversion("0");

        return bzTesuuryouLayoutFile;
    }

    private BzTesuuryouSyouhnLayoutFile getBzTesuuryouSyouhnLayoutFile(IT_TesuuryouSyouhn pTesuuryouSyouhn,
        String pKbnkey, String pSyoNo) {

        BzTesuuryouSyouhnLayoutFile bzTesuuryouSyouhnLayoutFile = SWAKInjector.getInstance(
            BzTesuuryouSyouhnLayoutFile.class);

        ConvertTestData convertTestData = SWAKInjector.getInstance(ConvertTestData.class);

        bzTesuuryouSyouhnLayoutFile.setIfeTskbnkey(pKbnkey);
        bzTesuuryouSyouhnLayoutFile.setIfeTssyono(pSyoNo);
        bzTesuuryouSyouhnLayoutFile.setIfeTstsrysyorikbn(String.valueOf(pTesuuryouSyouhn.getTsrysyorikbn()));
        bzTesuuryouSyouhnLayoutFile.setIfeTsrenno(String.valueOf(pTesuuryouSyouhn.getRenno()));
        bzTesuuryouSyouhnLayoutFile.setIfeTssyutkkbn(String.valueOf(pTesuuryouSyouhn.getSyutkkbn()));
        bzTesuuryouSyouhnLayoutFile.setIfeTssyouhncd(pTesuuryouSyouhn.getSyouhncd());
        bzTesuuryouSyouhnLayoutFile.setIfeTssyouhnsdno(String.valueOf(pTesuuryouSyouhn.getSyouhnsdno()));
        bzTesuuryouSyouhnLayoutFile.setIfeTskyksyouhnrenno(String.valueOf(pTesuuryouSyouhn.getKyksyouhnrenno()));
        bzTesuuryouSyouhnLayoutFile.setIfeTshenkousikibetukey(convertTestData.setNull(
            pTesuuryouSyouhn.getHenkousikibetukey()));
        bzTesuuryouSyouhnLayoutFile.setIfeTsyuukousyoumetukbn(convertTestData.setNull(String.valueOf(
            pTesuuryouSyouhn.getYuukousyoumetukbn())));
        bzTesuuryouSyouhnLayoutFile.setIfeTskykjyoutai(convertTestData.setNull(String.valueOf(
            pTesuuryouSyouhn.getKykjyoutai())));
        bzTesuuryouSyouhnLayoutFile.setIfeTssyoumetujiyuu(convertTestData.setNull(String.valueOf(
            pTesuuryouSyouhn.getSyoumetujiyuu())));
        bzTesuuryouSyouhnLayoutFile.setIfeTssyoumetuymd(convertTestData.setNull(String.valueOf(
            pTesuuryouSyouhn.getSyoumetuymd())));
        bzTesuuryouSyouhnLayoutFile.setIfeTskouryokuhasseiymd(convertTestData.setNull(String.valueOf(
            pTesuuryouSyouhn.getKouryokuhasseiymd())));
        bzTesuuryouSyouhnLayoutFile.setIfeTskykymd(convertTestData.setNull(String.valueOf(
            pTesuuryouSyouhn.getKykymd())));
        bzTesuuryouSyouhnLayoutFile.setIfeTssknnkaisiymd(convertTestData.setNull(String.valueOf(
            pTesuuryouSyouhn.getSknnkaisiymd())));
        bzTesuuryouSyouhnLayoutFile.setIfeTsgansknnkaisiymd(convertTestData.setNull(String.valueOf(
            pTesuuryouSyouhn.getGansknnkaisiymd())));
        bzTesuuryouSyouhnLayoutFile.setIfeTshknkknsmnkbn(convertTestData.setNull(String.valueOf(
            pTesuuryouSyouhn.getHknkknsmnkbn())));
        bzTesuuryouSyouhnLayoutFile.setIfeTshknkkn(convertTestData.setNull(String.valueOf(pTesuuryouSyouhn.getHknkkn())));
        bzTesuuryouSyouhnLayoutFile.setIfeTshrkkknsmnkbn(convertTestData.setNull(String.valueOf(
            pTesuuryouSyouhn.getHrkkknsmnkbn())));
        bzTesuuryouSyouhnLayoutFile.setIfeTshrkkkn(convertTestData.setNull(String.valueOf(pTesuuryouSyouhn.getHrkkkn())));
        bzTesuuryouSyouhnLayoutFile.setIfeTskyknen(convertTestData.setNull(String.valueOf(pTesuuryouSyouhn.getKyknen())));
        bzTesuuryouSyouhnLayoutFile.setIfeTshhknnen(convertTestData.setNull(String.valueOf(pTesuuryouSyouhn.getHhknnen())));
        bzTesuuryouSyouhnLayoutFile.setIfeTshhknseiymd(convertTestData.setNull(String.valueOf(
            pTesuuryouSyouhn.getHhknseiymd())));
        bzTesuuryouSyouhnLayoutFile.setIfeTshhknsei(convertTestData.setNull(String.valueOf(
            pTesuuryouSyouhn.getHhknsei())));
        bzTesuuryouSyouhnLayoutFile.setIfeTsharaimanymd(convertTestData.setNull(String.valueOf(
            pTesuuryouSyouhn.getHaraimanymd())));
        bzTesuuryouSyouhnLayoutFile.setIfeTshknkknmanryouymd(convertTestData.setNull(String.valueOf(
            pTesuuryouSyouhn.getHknkknmanryouymd())));
        bzTesuuryouSyouhnLayoutFile.setIfeTskatakbn(convertTestData.setNull(String.valueOf(
            pTesuuryouSyouhn.getKatakbn())));
        bzTesuuryouSyouhnLayoutFile.setIfeTskyhgndkatakbn(convertTestData.setNull(String.valueOf(
            pTesuuryouSyouhn.getKyhgndkatakbn())));
        bzTesuuryouSyouhnLayoutFile.setIfeTssyukyhkinkatakbn(convertTestData.setNull(String.valueOf(
            pTesuuryouSyouhn.getSyukyhkinkatakbn())));
        bzTesuuryouSyouhnLayoutFile.setIfeTskhnkyhkgbairitukbn(convertTestData.setNull(String.valueOf(
            pTesuuryouSyouhn.getKhnkyhkgbairitukbn())));
        bzTesuuryouSyouhnLayoutFile.setIfeTsrokudaildkbn(convertTestData.setNull(String.valueOf(
            pTesuuryouSyouhn.getRokudaildkbn())));
        bzTesuuryouSyouhnLayoutFile.setIfeTspmnjtkkbn(convertTestData.setNull(String.valueOf(
            pTesuuryouSyouhn.getPmnjtkkbn())));
        bzTesuuryouSyouhnLayoutFile.setIfeTskihons(convertTestData.setNull(setBizCurrencyVal(pTesuuryouSyouhn.getKihons())));
        bzTesuuryouSyouhnLayoutFile.setIfeTskihonst(convertTestData.setNull(setBizCurrencyType(pTesuuryouSyouhn.getKihons())));
        bzTesuuryouSyouhnLayoutFile.setIfeTshokenryou(convertTestData.setNull(setBizCurrencyVal(pTesuuryouSyouhn.getHokenryou())));
        bzTesuuryouSyouhnLayoutFile.setIfeTshokenryout(convertTestData.setNull(setBizCurrencyType(pTesuuryouSyouhn.getHokenryou())));
        bzTesuuryouSyouhnLayoutFile.setIfeTskyktuukasyu(convertTestData.setNull(String.valueOf(
            pTesuuryouSyouhn.getKyktuukasyu())));
        bzTesuuryouSyouhnLayoutFile.setIfeTsryouritusdno(convertTestData.setNull(pTesuuryouSyouhn.getRyouritusdno()));
        bzTesuuryouSyouhnLayoutFile.setIfeTsyoteiriritu(convertTestData.setNull(String.valueOf(pTesuuryouSyouhn.getYoteiriritu())));
        bzTesuuryouSyouhnLayoutFile.setIfeTsyoteirrthendohosyurrt(convertTestData.setNull(String.valueOf(pTesuuryouSyouhn.getYoteirrthendohosyurrt())));
        bzTesuuryouSyouhnLayoutFile.setIfeTsytirrthndmnskaisuu(convertTestData.setNull(String.valueOf(pTesuuryouSyouhn.getYtirrthndmnskaisuu())));
        bzTesuuryouSyouhnLayoutFile.setIfeTskyksjkkktyouseiriritu(convertTestData.setNull(String.valueOf(pTesuuryouSyouhn.getKyksjkkktyouseiriritu())));
        bzTesuuryouSyouhnLayoutFile.setIfeTsnksyukbn(convertTestData.setNull(String.valueOf(
            pTesuuryouSyouhn.getNksyukbn())));
        bzTesuuryouSyouhnLayoutFile.setIfeTsnenkinkkn(convertTestData.setNull(String.valueOf(pTesuuryouSyouhn.getNenkinkkn())));
        bzTesuuryouSyouhnLayoutFile.setIfeTsnkgnshosyouritu(convertTestData.setNull(String.valueOf(pTesuuryouSyouhn.getNkgnshosyouritu())));
        bzTesuuryouSyouhnLayoutFile.setIfeTsnkgnshosyougk(convertTestData.setNull(setBizCurrencyVal(pTesuuryouSyouhn.getNkgnshosyougk())));
        bzTesuuryouSyouhnLayoutFile.setIfeTsnkgnshosyougkt(convertTestData.setNull(setBizCurrencyType(pTesuuryouSyouhn.getNkgnshosyougk())));
        bzTesuuryouSyouhnLayoutFile.setIfeTsgyoumukousinkinou(convertTestData.setNull(
            pTesuuryouSyouhn.getGyoumuKousinKinou()));
        bzTesuuryouSyouhnLayoutFile.setIfeTsgyoumukousinsyaid(convertTestData.setNull(
            pTesuuryouSyouhn.getGyoumuKousinsyaId()));
        bzTesuuryouSyouhnLayoutFile.setIfeTsgyoumukousintime(convertTestData.setNull(
            pTesuuryouSyouhn.getGyoumuKousinTime()));
        bzTesuuryouSyouhnLayoutFile.setIfeTskousinsyaid("init");
        bzTesuuryouSyouhnLayoutFile.setIfeTskousintime("0");
        bzTesuuryouSyouhnLayoutFile.setIfeTskousinkinou("init");
        bzTesuuryouSyouhnLayoutFile.setIfeTsversion("0");

        return bzTesuuryouSyouhnLayoutFile;
    }

    private BzTrkKzkLayoutFile getBzTrkKzkLayoutFile(IT_TrkKzk pTrkKzk, String pKbnkey, String pSyoNo) {

        BzTrkKzkLayoutFile bzTrkKzkLayoutFile = SWAKInjector.getInstance(BzTrkKzkLayoutFile.class);

        ConvertTestData convertTestData = SWAKInjector.getInstance(ConvertTestData.class);

        bzTrkKzkLayoutFile.setIfeTskbnkey(pKbnkey);
        bzTrkKzkLayoutFile.setIfeTssyono(pSyoNo);
        bzTrkKzkLayoutFile.setIfeTstrkkzkkbn(String.valueOf(pTrkKzk.getTrkkzkkbn()));
        bzTrkKzkLayoutFile.setIfeTstrkkzksetteiymd(convertTestData.setNull(String.valueOf(
            pTrkKzk.getTrkkzksetteiymd())));
        bzTrkKzkLayoutFile.setIfeTstrkkzknmkn(convertTestDataForKanaMeigi.getKnmeigi(pTrkKzk.getTrkkzknmkn()));
        bzTrkKzkLayoutFile.setIfeTstrkkzknmkj(convertTestData.setTestKanjiNm(
            pTrkKzk.getTrkkzknmkj(), TRKKZKNMKJ, pSyoNo));
        bzTrkKzkLayoutFile.setIfeTstrkkzknmkjkhukakbn(convertTestData.setNull(String.valueOf(
            pTrkKzk.getTrkkzknmkjkhukakbn())));
        BizDate trkkzkseiymd = pTrkKzk.getTrkkzkseiymd();
        if (trkkzkseiymd == null) {
            bzTrkKzkLayoutFile.setIfeTstrkkzkseiymd(setKoteiatai(null, ""));
        }
        else {
            bzTrkKzkLayoutFile.setIfeTstrkkzkseiymd(setKoteiatai(String.valueOf(trkkzkseiymd), ""));
        }
        bzTrkKzkLayoutFile.setIfeTstrkkzksei(convertTestData.setNull(String.valueOf(pTrkKzk.getTrkkzksei())));
        bzTrkKzkLayoutFile.setIfeTstrkkzktdk(convertTestData.setNull(String.valueOf(pTrkKzk.getTrkkzktdk())));
        bzTrkKzkLayoutFile.setIfeTstrkkzkyno(setKoteiatai(pTrkKzk.getTrkkzkyno(), ""));
        bzTrkKzkLayoutFile.setIfeTstrkkzkadr1kj(setKoteiatai(pTrkKzk.getTrkkzkadr1kj(), ""));
        bzTrkKzkLayoutFile.setIfeTstrkkzkadr2kj(setKoteiatai(pTrkKzk.getTrkkzkadr2kj(), ""));
        bzTrkKzkLayoutFile.setIfeTstrkkzkadr3kj(setKoteiatai(pTrkKzk.getTrkkzkadr3kj(), ""));
        bzTrkKzkLayoutFile.setIfeTstrkkzktelno(setKoteiatai(pTrkKzk.getTrkkzktelno(), ""));
        bzTrkKzkLayoutFile.setIfeTsgyoumukousinkinou(convertTestData.setNull(
            pTrkKzk.getGyoumuKousinKinou()));
        bzTrkKzkLayoutFile.setIfeTsgyoumukousinsyaid(convertTestData.setNull(
            pTrkKzk.getGyoumuKousinsyaId()));
        bzTrkKzkLayoutFile.setIfeTsgyoumukousintime(convertTestData.setNull(
            pTrkKzk.getGyoumuKousinTime()));
        bzTrkKzkLayoutFile.setIfeTskousinsyaid("init");
        bzTrkKzkLayoutFile.setIfeTskousintime("0");
        bzTrkKzkLayoutFile.setIfeTskousinkinou("init");
        bzTrkKzkLayoutFile.setIfeTsversion("0");
        bzTrkKzkLayoutFile.setIfeTstrkkzktsindousiteikbn(convertTestData.setNull(String.valueOf(
            pTrkKzk.getTrkkzktsindousiteikbn())));

        return bzTrkKzkLayoutFile;
    }

    private BzZennouLayoutFile getBzZennouLayoutFile(IT_Zennou pZennou, String pKbnkey, String pSyoNo) {

        BzZennouLayoutFile bzZennouLayoutFile = SWAKInjector.getInstance(BzZennouLayoutFile.class);

        ConvertTestData convertTestData = SWAKInjector.getInstance(ConvertTestData.class);

        bzZennouLayoutFile.setIfeTskbnkey(pKbnkey);
        bzZennouLayoutFile.setIfeTssyono(pSyoNo);
        bzZennouLayoutFile.setIfeTszennoukaisiymd(String.valueOf(pZennou.getZennoukaisiymd()));
        bzZennouLayoutFile.setIfeTsrenno(String.valueOf(pZennou.getRenno()));
        bzZennouLayoutFile.setIfeTszennounyuukinsyoriymd(convertTestData.setNull(String.valueOf(
            pZennou.getZennounyuukinsyoriymd())));
        bzZennouLayoutFile.setIfeTszennounyuukindenno(setKoteiatai(pZennou.getZennounyuukindenno(), ""));
        bzZennouLayoutFile.setIfeTszennounyuukindenymd(convertTestData.setNull(String.valueOf(
            pZennou.getZennounyuukindenymd())));
        bzZennouLayoutFile.setIfeTsryosyuymd(convertTestData.setNull(String.valueOf(pZennou.getRyosyuymd())));
        bzZennouLayoutFile.setIfeTszennoukikan(convertTestData.setNull(pZennou.getZennoukikan()));
        bzZennouLayoutFile.setIfeTszennounyuukinkgk(convertTestData.setNull(setBizCurrencyVal(
            pZennou.getZennounyuukinkgk())));
        bzZennouLayoutFile.setIfeTszennounyuukinkgkt(convertTestData.setNull(setBizCurrencyType(
            pZennou.getZennounyuukinkgk())));
        bzZennouLayoutFile.setIfeTszennoujihrkp(convertTestData.setNull(setBizCurrencyVal(
            pZennou.getZennoujihrkp())));
        bzZennouLayoutFile.setIfeTszennoujihrkpt(convertTestData.setNull(setBizCurrencyType(
            pZennou.getZennoujihrkp())));
        bzZennouLayoutFile.setIfeTszennouseisankbn(convertTestData.setNull(String.valueOf(
            pZennou.getZennouseisankbn())));
        bzZennouLayoutFile.setIfeTszennouseisansyoriymd(convertTestData.setNull(String.valueOf(
            pZennou.getZennouseisansyoriymd())));
        bzZennouLayoutFile.setIfeTszennouseisankgk(convertTestData.setNull(setBizCurrencyVal(
            pZennou.getZennouseisankgk())));
        bzZennouLayoutFile.setIfeTszennouseisankgkt(convertTestData.setNull(setBizCurrencyType(
            pZennou.getZennouseisankgk())));
        bzZennouLayoutFile.setIfeTszennouseisankijyunymd(convertTestData.setNull(String.valueOf(
            pZennou.getZennouseisankijyunymd())));
        bzZennouLayoutFile.setIfeTszennouseisandenymd(convertTestData.setNull(String.valueOf(
            pZennou.getZennouseisandenymd())));
        bzZennouLayoutFile.setIfeTsannaisaikaiym(convertTestData.setNull(String.valueOf(
            pZennou.getAnnaisaikaiym())));
        bzZennouLayoutFile.setIfeTskjsmyouzennoukaisiymd(convertTestData.setNull(String.valueOf(
            pZennou.getKjsmyouzennoukaisiymd())));
        bzZennouLayoutFile.setIfeTskjsmyouzennoukikanm(convertTestData.setNull(pZennou.getKjsmyouzennoukikanm()));
        bzZennouLayoutFile.setIfeTskjsmyouzennounyukingk(convertTestData.setNull(setBizCurrencyVal(
            pZennou.getKjsmyouzennounyuukinkgk())));
        bzZennouLayoutFile.setIfeTskjsmyouzennounyukingkt(convertTestData.setNull(setBizCurrencyType(
            pZennou.getKjsmyouzennounyuukinkgk())));
        bzZennouLayoutFile.setIfeTsgyoumukousinkinou(convertTestData.setNull(
            pZennou.getGyoumuKousinKinou()));
        bzZennouLayoutFile.setIfeTsgyoumukousinsyaid(convertTestData.setNull(
            pZennou.getGyoumuKousinsyaId()));
        bzZennouLayoutFile.setIfeTsgyoumukousintime(convertTestData.setNull(
            pZennou.getGyoumuKousinTime()));
        bzZennouLayoutFile.setIfeTskousinsyaid("init");
        bzZennouLayoutFile.setIfeTskousintime("0");
        bzZennouLayoutFile.setIfeTskousinkinou("init");
        bzZennouLayoutFile.setIfeTsversion("0");

        return bzZennouLayoutFile;
    }

    private BzKouzaLayoutFile getBzKouzaLayoutFile(IT_Kouza pKouza, String pKbnkey, String pSyoNo) {

        BzKouzaLayoutFile bzKouzaLayoutFile = SWAKInjector.getInstance(BzKouzaLayoutFile.class);

        ConvertTestData convertTestData = SWAKInjector.getInstance(ConvertTestData.class);

        bzKouzaLayoutFile.setIfeTskbnkey(pKbnkey);
        bzKouzaLayoutFile.setIfeTssyono(pSyoNo);
        bzKouzaLayoutFile.setIfeTskokno(setKoteiatai(pKouza.getKokno(), ""));
        bzKouzaLayoutFile.setIfeTsbankcd(convertTestData.setNull(pKouza.getBankcd()));
        bzKouzaLayoutFile.setIfeTssitencd(convertTestData.setNull(pKouza.getSitencd()));
        bzKouzaLayoutFile.setIfeTsyokinkbn(convertTestData.setNull(String.valueOf(pKouza.getYokinkbn())));
        bzKouzaLayoutFile.setIfeTskouzano(setKoteiatai(pKouza.getKouzano(), ""));
        bzKouzaLayoutFile.setIfeTskzmeiginmkn(convertTestDataForKanaMeigi.getKnmeigi(pKouza.getKzmeiginmkn()));
        bzKouzaLayoutFile.setIfeTssinkeizkkbn(convertTestData.setNull(String.valueOf(pKouza.getSinkeizkkbn())));
        bzKouzaLayoutFile.setIfeTssyuudaikocd(convertTestData.setNull(String.valueOf(pKouza.getSyuudaikocd())));
        bzKouzaLayoutFile.setIfeTskzkykdoukbn(convertTestData.setNull(String.valueOf(pKouza.getKzkykdoukbn())));
        bzKouzaLayoutFile.setIfeTsgyoumukousinkinou(convertTestData.setNull(
            pKouza.getGyoumuKousinKinou()));
        bzKouzaLayoutFile.setIfeTsgyoumukousinsyaid(convertTestData.setNull(
            pKouza.getGyoumuKousinsyaId()));
        bzKouzaLayoutFile.setIfeTsgyoumukousintime(convertTestData.setNull(
            pKouza.getGyoumuKousinTime()));
        bzKouzaLayoutFile.setIfeTskousinsyaid("init");
        bzKouzaLayoutFile.setIfeTskousintime("0");
        bzKouzaLayoutFile.setIfeTskousinkinou("init");
        bzKouzaLayoutFile.setIfeTsversion("0");

        return bzKouzaLayoutFile;
    }

    private BzCreditCardInfoLayoutFile getBzCreditCardInfoLayoutFile(IT_CreditCardInfo pCreditCardInfo,
        String pKbnkey, String pSyoNo) {

        BzCreditCardInfoLayoutFile bzCreditCardInfoLayoutFile = SWAKInjector.getInstance(
            BzCreditCardInfoLayoutFile.class);

        ConvertTestData convertTestData = SWAKInjector.getInstance(ConvertTestData.class);

        bzCreditCardInfoLayoutFile.setIfeTskbnkey(pKbnkey);
        bzCreditCardInfoLayoutFile.setIfeTssyono(pSyoNo);
        bzCreditCardInfoLayoutFile.setIfeTscreditkessaiyouno(setKoteiatai(pCreditCardInfo.getCreditkessaiyouno(), ""));
        bzCreditCardInfoLayoutFile.setIfeTscredityuukoukakym(convertTestData.setNull(String.valueOf(
            pCreditCardInfo.getCredityuukoukakym())));
        bzCreditCardInfoLayoutFile.setIfeTscredityuukoukakkekka(convertTestData.setNull(String.valueOf(
            pCreditCardInfo.getCredityuukoukakkekka())));
        bzCreditCardInfoLayoutFile.setIfeTsgyoumukousinkinou(convertTestData.setNull(
            pCreditCardInfo.getGyoumuKousinKinou()));
        bzCreditCardInfoLayoutFile.setIfeTsgyoumukousinsyaid(convertTestData.setNull(
            pCreditCardInfo.getGyoumuKousinsyaId()));
        bzCreditCardInfoLayoutFile.setIfeTsgyoumukousintime(convertTestData.setNull(
            pCreditCardInfo.getGyoumuKousinTime()));
        bzCreditCardInfoLayoutFile.setIfeTskousinsyaid("init");
        bzCreditCardInfoLayoutFile.setIfeTskousintime("0");
        bzCreditCardInfoLayoutFile.setIfeTskousinkinou("init");
        bzCreditCardInfoLayoutFile.setIfeTsversion("0");

        return bzCreditCardInfoLayoutFile;
    }

    private BzAeoiInfoLayoutFile setAeoiInfoKoumokunm() {

        BzAeoiInfoLayoutFile bzAeoiInfoLayoutFile = SWAKInjector.getInstance(BzAeoiInfoLayoutFile.class);

        bzAeoiInfoLayoutFile.setIfeTskbnkey("区分キー");
        bzAeoiInfoLayoutFile.setIfeTssyono("証券番号");
        bzAeoiInfoLayoutFile.setIfeTsrenno("連番");
        bzAeoiInfoLayoutFile.setIfeTsaeoisyoriymd("ＡＥＯＩ処理年月日");
        bzAeoiInfoLayoutFile.setIfeTsaeoisyorikbn("ＡＥＯＩ処理区分");
        bzAeoiInfoLayoutFile.setIfeTsaeoikouryokusttymd("ＡＥＯＩ効力開始年月日");
        bzAeoiInfoLayoutFile.setIfeTsaeoisyorisosikicd("ＡＥＯＩ処理組織コード");
        bzAeoiInfoLayoutFile.setIfeTsaeoitaisyousyakbn("ＡＥＯＩ対象者区分");
        bzAeoiInfoLayoutFile.setIfeTsaeoikekkakbn("ＡＥＯＩ結果区分");
        bzAeoiInfoLayoutFile.setIfeTsaeoihoujinsyuruikbn("ＡＥＯＩ法人種類区分");
        bzAeoiInfoLayoutFile.setIfeTsaeoikouryokuendymd("ＡＥＯＩ効力終了年月日");
        bzAeoiInfoLayoutFile.setIfeTsgyoumukousinkinou("業務用更新機能ＩＤ");
        bzAeoiInfoLayoutFile.setIfeTsgyoumukousinsyaid("業務用更新者ＩＤ");
        bzAeoiInfoLayoutFile.setIfeTsgyoumukousintime("業務用更新時間");
        bzAeoiInfoLayoutFile.setIfeTskousinsyaid("更新者ＩＤ");
        bzAeoiInfoLayoutFile.setIfeTskousintime("更新時間");
        bzAeoiInfoLayoutFile.setIfeTskousinkinou("更新機能");
        bzAeoiInfoLayoutFile.setIfeTsversion("バージョン");

        return bzAeoiInfoLayoutFile;
    }

    private BzAnsyuKihonLayoutFile setAnsyuKihonKoumokunm() {

        BzAnsyuKihonLayoutFile bzAnsyuKihonLayoutFile = SWAKInjector.getInstance(BzAnsyuKihonLayoutFile.class);

        bzAnsyuKihonLayoutFile.setIfeTskbnkey("区分キー");
        bzAnsyuKihonLayoutFile.setIfeTssyono("証券番号");
        bzAnsyuKihonLayoutFile.setIfeTsjkipjytym("次回Ｐ充当年月");
        bzAnsyuKihonLayoutFile.setIfeTstkiktannaitukisuu("定期一括案内月数");
        bzAnsyuKihonLayoutFile.setIfeTskjsmhakkouzumiflg("控除証明書発行済フラグ");
        bzAnsyuKihonLayoutFile.setIfeTssyuharaimanymd("主契約払満日");
        bzAnsyuKihonLayoutFile.setIfeTsgyoumukousinkinou("業務用更新機能ＩＤ");
        bzAnsyuKihonLayoutFile.setIfeTsgyoumukousinsyaid("業務用更新者ＩＤ");
        bzAnsyuKihonLayoutFile.setIfeTsgyoumukousintime("業務用更新時間");
        bzAnsyuKihonLayoutFile.setIfeTskousinsyaid("更新者ＩＤ");
        bzAnsyuKihonLayoutFile.setIfeTskousintime("更新時間");
        bzAnsyuKihonLayoutFile.setIfeTskousinkinou("更新機能");
        bzAnsyuKihonLayoutFile.setIfeTsversion("バージョン");

        return bzAnsyuKihonLayoutFile;
    }

    private BzFatcaInfoLayoutFile setFatcaInfoKoumokunm() {

        BzFatcaInfoLayoutFile bzFatcaInfoLayoutFile = SWAKInjector.getInstance(BzFatcaInfoLayoutFile.class);

        bzFatcaInfoLayoutFile.setIfeTskbnkey("区分キー");
        bzFatcaInfoLayoutFile.setIfeTssyono("証券番号");
        bzFatcaInfoLayoutFile.setIfeTsrenno("連番");
        bzFatcaInfoLayoutFile.setIfeTssyoriymd("処理年月日");
        bzFatcaInfoLayoutFile.setIfeTssyorisosikicd("処理組織コード");
        bzFatcaInfoLayoutFile.setIfeTsfatcasnsikbn("ＦＡＴＣＡ宣誓区分");
        bzFatcaInfoLayoutFile.setIfeTsbikkjnssinfokbn("米国人示唆情報区分");
        bzFatcaInfoLayoutFile.setIfeTsfatcakekkbn("ＦＡＴＣＡ結果区分");
        bzFatcaInfoLayoutFile.setIfeTsfatcahankeiikbn("ＦＡＴＣＡ判明経緯区分");
        bzFatcaInfoLayoutFile.setIfeTsbikknzsyno("米国納税者番号");
        bzFatcaInfoLayoutFile.setIfeTssyomeiymd("署名日");
        bzFatcaInfoLayoutFile.setIfeTskokno("顧客番号");
        bzFatcaInfoLayoutFile.setIfeTsfatcatgkbn("ＦＡＴＣＡ対象者区分");
        bzFatcaInfoLayoutFile.setIfeTsseionnmkn("清音氏名（カナ）");
        bzFatcaInfoLayoutFile.setIfeTsnmkn("氏名（カナ）");
        bzFatcaInfoLayoutFile.setIfeTsnmkj("氏名（漢字）");
        bzFatcaInfoLayoutFile.setIfeTsseiymd("生年月日");
        bzFatcaInfoLayoutFile.setIfeTsseibetu("性別");
        bzFatcaInfoLayoutFile.setIfeTskouryokuendymd("効力終了日");
        bzFatcaInfoLayoutFile.setIfeTstrkymd("登録日");
        bzFatcaInfoLayoutFile.setIfeTsgyoumukousinkinou("業務用更新機能ＩＤ");
        bzFatcaInfoLayoutFile.setIfeTsgyoumukousinsyaid("業務用更新者ＩＤ");
        bzFatcaInfoLayoutFile.setIfeTsgyoumukousintime("業務用更新時間");
        bzFatcaInfoLayoutFile.setIfeTskousinsyaid("更新者ＩＤ");
        bzFatcaInfoLayoutFile.setIfeTskousintime("更新時間");
        bzFatcaInfoLayoutFile.setIfeTskousinkinou("更新機能");
        bzFatcaInfoLayoutFile.setIfeTsversion("バージョン");

        return bzFatcaInfoLayoutFile;
    }

    private BzHhknSyaLayoutFile setHhknSyaKoumokunm() {

        BzHhknSyaLayoutFile bzHhknSyaLayoutFile = SWAKInjector.getInstance(BzHhknSyaLayoutFile.class);

        bzHhknSyaLayoutFile.setIfeTskbnkey("区分キー");
        bzHhknSyaLayoutFile.setIfeTssyono("証券番号");
        bzHhknSyaLayoutFile.setIfeTskokno("顧客番号");
        bzHhknSyaLayoutFile.setIfeTshhknsakuinmeino("被保険者索引名番号");
        bzHhknSyaLayoutFile.setIfeTshhknnmkn("被保険者名（カナ）");
        bzHhknSyaLayoutFile.setIfeTshhknnmkj("被保険者名（漢字）");
        bzHhknSyaLayoutFile.setIfeTshhknnmkjkhukakbn("被保険者名漢字化不可区分");
        bzHhknSyaLayoutFile.setIfeTshhknseiymd("被保険者生年月日");
        bzHhknSyaLayoutFile.setIfeTshhknsei("被保険者性別");
        bzHhknSyaLayoutFile.setIfeTshhknyno("被保険者郵便番号");
        bzHhknSyaLayoutFile.setIfeTshhknadr1kn("被保険者住所１（カナ）");
        bzHhknSyaLayoutFile.setIfeTshhknadr1kj("被保険者住所１（漢字）");
        bzHhknSyaLayoutFile.setIfeTshhknadr2kn("被保険者住所２（カナ）");
        bzHhknSyaLayoutFile.setIfeTshhknadr2kj("被保険者住所２（漢字）");
        bzHhknSyaLayoutFile.setIfeTshhknadr3kn("被保険者住所３（カナ）");
        bzHhknSyaLayoutFile.setIfeTshhknadr3kj("被保険者住所３（漢字）");
        bzHhknSyaLayoutFile.setIfeTshhkntelno("被保険者電話番号");
        bzHhknSyaLayoutFile.setIfeTsgyoumukousinkinou("業務用更新機能ＩＤ");
        bzHhknSyaLayoutFile.setIfeTsgyoumukousinsyaid("業務用更新者ＩＤ");
        bzHhknSyaLayoutFile.setIfeTsgyoumukousintime("業務用更新時間");
        bzHhknSyaLayoutFile.setIfeTskousinsyaid("更新者ＩＤ");
        bzHhknSyaLayoutFile.setIfeTskousintime("更新時間");
        bzHhknSyaLayoutFile.setIfeTskousinkinou("更新機能");
        bzHhknSyaLayoutFile.setIfeTsversion("バージョン");

        return bzHhknSyaLayoutFile;

    }

    private BzHokenSyoukenLayoutFile setHokenSyoukenKoumokunm() {

        BzHokenSyoukenLayoutFile bzHokenSyoukenLayoutFile = SWAKInjector.getInstance(BzHokenSyoukenLayoutFile.class);

        bzHokenSyoukenLayoutFile.setIfeTskbnkey("区分キー");
        bzHokenSyoukenLayoutFile.setIfeTssyono("証券番号");
        bzHokenSyoukenLayoutFile.setIfeTstyouhyouymd("帳票作成日");
        bzHokenSyoukenLayoutFile.setIfeTshenkousikibetukey("変更識別キー");
        bzHokenSyoukenLayoutFile.setIfeTssinsaihkkbn("新規再発行区分");
        bzHokenSyoukenLayoutFile.setIfeTssyoukensaihkkbn("証券再発行区分");
        bzHokenSyoukenLayoutFile.setIfeTsinsizeishryouhikbn("印紙税支払要否区分");
        bzHokenSyoukenLayoutFile.setIfeTshassoukbn("発送区分");
        bzHokenSyoukenLayoutFile.setIfeTskoujyosyoumeiumukbn("控除証明書有無区分");
        bzHokenSyoukenLayoutFile.setIfeTssuiihyouumukbn("推移表有無区分");
        bzHokenSyoukenLayoutFile.setIfeTskanryoutuutiumukbn("完了通知有無区分");
        bzHokenSyoukenLayoutFile.setIfeTsstdrsktirasidouhuukbn("指定代理請求チラシ同封区分");
        bzHokenSyoukenLayoutFile.setIfeTsdstirasidouhuukbn("ＤＳチラシ同封区分");
        bzHokenSyoukenLayoutFile.setIfeTsaisyoumeikbn("愛称名区分");
        bzHokenSyoukenLayoutFile.setIfeTssyotnshuyoupostumukbn("証券転送不要郵便有無区分");
        bzHokenSyoukenLayoutFile.setIfeTshyoujiranhidarimsgcd1("表示欄左メッセージコード１");
        bzHokenSyoukenLayoutFile.setIfeTshyoujiranhidarimsgcd2("表示欄左メッセージコード２");
        bzHokenSyoukenLayoutFile.setIfeTshyoujiranhidarimsgcd3("表示欄左メッセージコード３");
        bzHokenSyoukenLayoutFile.setIfeTshyoujiranhidarimsgcd4("表示欄左メッセージコード４");
        bzHokenSyoukenLayoutFile.setIfeTshyoujiranhidarimsgcd5("表示欄左メッセージコード５");
        bzHokenSyoukenLayoutFile.setIfeTshyoujiranhidarimsgcd6("表示欄左メッセージコード６");
        bzHokenSyoukenLayoutFile.setIfeTshyoujiranhidarimsgcd7("表示欄左メッセージコード７");
        bzHokenSyoukenLayoutFile.setIfeTshyoujiranhidarimsgcd8("表示欄左メッセージコード８");
        bzHokenSyoukenLayoutFile.setIfeTshyoujiranhidarimsgcd9("表示欄左メッセージコード９");
        bzHokenSyoukenLayoutFile.setIfeTshyoujiranhidarimsgcd10("表示欄左メッセージコード１０");
        bzHokenSyoukenLayoutFile.setIfeTshyoujiranhidarimsgcd11("表示欄左メッセージコード１１");
        bzHokenSyoukenLayoutFile.setIfeTshyoujiranhidarimsgcd12("表示欄左メッセージコード１２");
        bzHokenSyoukenLayoutFile.setIfeTshyoujiranhidarimsgcd13("表示欄左メッセージコード１３");
        bzHokenSyoukenLayoutFile.setIfeTshyoujiranhidarimsgcd14("表示欄左メッセージコード１４");
        bzHokenSyoukenLayoutFile.setIfeTshyoujiranhidarimsgcd15("表示欄左メッセージコード１５");
        bzHokenSyoukenLayoutFile.setIfeTshyoujiranhidarimsgcd16("表示欄左メッセージコード１６");
        bzHokenSyoukenLayoutFile.setIfeTshyoujiranhidarimsgcd17("表示欄左メッセージコード１７");
        bzHokenSyoukenLayoutFile.setIfeTshyoujiranhidarimsgcd18("表示欄左メッセージコード１８");
        bzHokenSyoukenLayoutFile.setIfeTshyoujiranhidarimsgcd19("表示欄左メッセージコード１９");
        bzHokenSyoukenLayoutFile.setIfeTshyoujiranhidarimsgcd20("表示欄左メッセージコード２０");
        bzHokenSyoukenLayoutFile.setIfeTshyoujiranmigiimsgcd1("表示欄右メッセージコード１");
        bzHokenSyoukenLayoutFile.setIfeTshyoujiranmigiimsgcd2("表示欄右メッセージコード２");
        bzHokenSyoukenLayoutFile.setIfeTshyoujiranmigiimsgcd3("表示欄右メッセージコード３");
        bzHokenSyoukenLayoutFile.setIfeTshyoujiranmigiimsgcd4("表示欄右メッセージコード４");
        bzHokenSyoukenLayoutFile.setIfeTshyoujiranmigiimsgcd5("表示欄右メッセージコード５");
        bzHokenSyoukenLayoutFile.setIfeTshyoujiranmigiimsgcd6("表示欄右メッセージコード６");
        bzHokenSyoukenLayoutFile.setIfeTshyoujiranmigiimsgcd7("表示欄右メッセージコード７");
        bzHokenSyoukenLayoutFile.setIfeTshyoujiranmigiimsgcd8("表示欄右メッセージコード８");
        bzHokenSyoukenLayoutFile.setIfeTshyoujiranmigiimsgcd9("表示欄右メッセージコード９");
        bzHokenSyoukenLayoutFile.setIfeTshyoujiranmigiimsgcd10("表示欄右メッセージコード１０");
        bzHokenSyoukenLayoutFile.setIfeTshyoujiranmigiimsgcd11("表示欄右メッセージコード１１");
        bzHokenSyoukenLayoutFile.setIfeTshyoujiranmigiimsgcd12("表示欄右メッセージコード１２");
        bzHokenSyoukenLayoutFile.setIfeTshyoujiranmigiimsgcd13("表示欄右メッセージコード１３");
        bzHokenSyoukenLayoutFile.setIfeTshyoujiranmigiimsgcd14("表示欄右メッセージコード１４");
        bzHokenSyoukenLayoutFile.setIfeTshyoujiranmigiimsgcd15("表示欄右メッセージコード１５");
        bzHokenSyoukenLayoutFile.setIfeTshyoujiranmigiimsgcd16("表示欄右メッセージコード１６");
        bzHokenSyoukenLayoutFile.setIfeTshyoujiranmigiimsgcd17("表示欄右メッセージコード１７");
        bzHokenSyoukenLayoutFile.setIfeTshyoujiranmigiimsgcd18("表示欄右メッセージコード１８");
        bzHokenSyoukenLayoutFile.setIfeTshyoujiranmigiimsgcd19("表示欄右メッセージコード１９");
        bzHokenSyoukenLayoutFile.setIfeTshyoujiranmigiimsgcd20("表示欄右メッセージコード２０");
        bzHokenSyoukenLayoutFile.setIfeTshyoujiransknnkaisiymd("表示欄責任開始日");
        bzHokenSyoukenLayoutFile.setIfeTshyoujiranyoteiriritu("表示欄予定利率");
        bzHokenSyoukenLayoutFile.setIfeTshyoujiransjkkktusirrt("表示欄市場価格調整用利率");
        bzHokenSyoukenLayoutFile.setIfeTshknsyukigou("保険種類記号");
        bzHokenSyoukenLayoutFile.setIfeTssyohakkouymd("証券発行年月日");
        bzHokenSyoukenLayoutFile.setIfeTshanbainm("販売名称");
        bzHokenSyoukenLayoutFile.setIfeTsseisikihknnm("正式保険名称");
        bzHokenSyoukenLayoutFile.setIfeTskouryokukaisiymd("効力開始年月日");
        bzHokenSyoukenLayoutFile.setIfeTskyknmkj("契約者名（漢字）");
        bzHokenSyoukenLayoutFile.setIfeTskyknmkjkhukakbn("契約者名漢字化不可区分");
        bzHokenSyoukenLayoutFile.setIfeTshhknnmkj("被保険者名（漢字）");
        bzHokenSyoukenLayoutFile.setIfeTshhknnmkjkhukakbn("被保険者名漢字化不可区分");
        bzHokenSyoukenLayoutFile.setIfeTshhknseiymd("被保険者生年月日");
        bzHokenSyoukenLayoutFile.setIfeTshhknsei("被保険者性別");
        bzHokenSyoukenLayoutFile.setIfeTshhknnen("被保険者年齢");
        bzHokenSyoukenLayoutFile.setIfeTssyoukenuktmidasikbn1("（証券）受取人見出し区分１");
        bzHokenSyoukenLayoutFile.setIfeTssyoukenuktkbn1("（証券）受取人区分１");
        bzHokenSyoukenLayoutFile.setIfeTssyoukenuktnm1("（証券）受取人名１");
        bzHokenSyoukenLayoutFile.setIfeTssyoukenuktbnwari1("（証券）受取人分割割合１");
        bzHokenSyoukenLayoutFile.setIfeTssyoukenuktmidasikbn2("（証券）受取人見出し区分２");
        bzHokenSyoukenLayoutFile.setIfeTssyoukenuktkbn2("（証券）受取人区分２");
        bzHokenSyoukenLayoutFile.setIfeTssyoukenuktnm2("（証券）受取人名２");
        bzHokenSyoukenLayoutFile.setIfeTssyoukenuktbnwari2("（証券）受取人分割割合２");
        bzHokenSyoukenLayoutFile.setIfeTssyoukenuktmidasikbn3("（証券）受取人見出し区分３");
        bzHokenSyoukenLayoutFile.setIfeTssyoukenuktkbn3("（証券）受取人区分３");
        bzHokenSyoukenLayoutFile.setIfeTssyoukenuktnm3("（証券）受取人名３");
        bzHokenSyoukenLayoutFile.setIfeTssyoukenuktbnwari3("（証券）受取人分割割合３");
        bzHokenSyoukenLayoutFile.setIfeTssyoukenuktmidasikbn4("（証券）受取人見出し区分４");
        bzHokenSyoukenLayoutFile.setIfeTssyoukenuktkbn4("（証券）受取人区分４");
        bzHokenSyoukenLayoutFile.setIfeTssyoukenuktnm4("（証券）受取人名４");
        bzHokenSyoukenLayoutFile.setIfeTssyoukenuktbnwari4("（証券）受取人分割割合４");
        bzHokenSyoukenLayoutFile.setIfeTssyoukenuktmidasikbn5("（証券）受取人見出し区分５");
        bzHokenSyoukenLayoutFile.setIfeTssyoukenuktkbn5("（証券）受取人区分５");
        bzHokenSyoukenLayoutFile.setIfeTssyoukenuktnm5("（証券）受取人名５");
        bzHokenSyoukenLayoutFile.setIfeTssyoukenuktbnwari5("（証券）受取人分割割合５");
        bzHokenSyoukenLayoutFile.setIfeTssyoukenuktmidasikbn6("（証券）受取人見出し区分６");
        bzHokenSyoukenLayoutFile.setIfeTssyoukenuktkbn6("（証券）受取人区分６");
        bzHokenSyoukenLayoutFile.setIfeTssyoukenuktnm6("（証券）受取人名６");
        bzHokenSyoukenLayoutFile.setIfeTssyoukenuktbnwari6("（証券）受取人分割割合６");
        bzHokenSyoukenLayoutFile.setIfeTssyoukenuktmidasikbn7("（証券）受取人見出し区分７");
        bzHokenSyoukenLayoutFile.setIfeTssyoukenuktkbn7("（証券）受取人区分７");
        bzHokenSyoukenLayoutFile.setIfeTssyoukenuktnm7("（証券）受取人名７");
        bzHokenSyoukenLayoutFile.setIfeTssyoukenuktbnwari7("（証券）受取人分割割合７");
        bzHokenSyoukenLayoutFile.setIfeTssyoukenuktmidasikbn8("（証券）受取人見出し区分８");
        bzHokenSyoukenLayoutFile.setIfeTssyoukenuktkbn8("（証券）受取人区分８");
        bzHokenSyoukenLayoutFile.setIfeTssyoukenuktnm8("（証券）受取人名８");
        bzHokenSyoukenLayoutFile.setIfeTssyoukenuktbnwari8("（証券）受取人分割割合８");
        bzHokenSyoukenLayoutFile.setIfeTssyoukenuktmidasikbn9("（証券）受取人見出し区分９");
        bzHokenSyoukenLayoutFile.setIfeTssyoukenuktkbn9("（証券）受取人区分９");
        bzHokenSyoukenLayoutFile.setIfeTssyoukenuktnm9("（証券）受取人名９");
        bzHokenSyoukenLayoutFile.setIfeTssyoukenuktbnwari9("（証券）受取人分割割合９");
        bzHokenSyoukenLayoutFile.setIfeTssyoukenuktmidasikbn10("（証券）受取人見出し区分１０");
        bzHokenSyoukenLayoutFile.setIfeTssyoukenuktkbn10("（証券）受取人区分１０");
        bzHokenSyoukenLayoutFile.setIfeTssyoukenuktnm10("（証券）受取人名１０");
        bzHokenSyoukenLayoutFile.setIfeTssyoukenuktbnwari10("（証券）受取人分割割合１０");
        bzHokenSyoukenLayoutFile.setIfeTspmsgcd1("保険料メッセージコード１");
        bzHokenSyoukenLayoutFile.setIfeTspmsgcd2("保険料メッセージコード２");
        bzHokenSyoukenLayoutFile.setIfeTspmsgcd3("保険料メッセージコード３");
        bzHokenSyoukenLayoutFile.setIfeTsptuukatype("保険料通貨タイプ");
        bzHokenSyoukenLayoutFile.setIfeTshokenryou("保険料");
        bzHokenSyoukenLayoutFile.setIfeTshokenryout("保険料(通貨型)");
        bzHokenSyoukenLayoutFile.setIfeTsptuuka("保険料通貨");
        bzHokenSyoukenLayoutFile.setIfeTsptokuyakumsgcd("保険料特約メッセージコード");
        bzHokenSyoukenLayoutFile.setIfeTskykymd("契約日");
        bzHokenSyoukenLayoutFile.setIfeTsphrkkknmidasikbn("保険料払込期間見出し区分");
        bzHokenSyoukenLayoutFile.setIfeTshrkkknmsgkbn("払込期間メッセージ区分");
        bzHokenSyoukenLayoutFile.setIfeTshrkkaisuumsgkbn("払込回数メッセージ区分");
        bzHokenSyoukenLayoutFile.setIfeTshrkkitukimsgkbn("払込期月メッセージ区分");
        bzHokenSyoukenLayoutFile.setIfeTshrkhouhoumsgkbn("払込方法メッセージ区分");
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykrenban1("主契約特約連番１");
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykmsgkbn1("主契約特約メッセージ区分１");
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkyksmsgkbn1("主契約特約保険金額メッセージ区分１");
        bzHokenSyoukenLayoutFile.setIfeTssykyktkykhknkknmsgkbn1("主契約特約保険期間メッセージ区分１");
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykstuukatype1("主契約特約保険金額通貨タイプ１");
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykhknkngk1("主契約特約保険金額１");
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykhknkngk1t("主契約特約保険金額１(通貨型)");
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykdai1hknkkn1("主契約特約第１保険期間１");
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykdai2hknkkn1("主契約特約第２保険期間１");
        bzHokenSyoukenLayoutFile.setIfeTssyutkdai1hknkknymdto1("主契約特約第１保険期間年月日（至）１");
        bzHokenSyoukenLayoutFile.setIfeTssyutkdai2hknkknymdto1("主契約特約第２保険期間年月日（至）１");
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykrenban2("主契約特約連番２");
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykmsgkbn2("主契約特約メッセージ区分２");
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkyksmsgkbn2("主契約特約保険金額メッセージ区分２");
        bzHokenSyoukenLayoutFile.setIfeTssykyktkykhknkknmsgkbn2("主契約特約保険期間メッセージ区分２");
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykstuukatype2("主契約特約保険金額通貨タイプ２");
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykhknkngk2("主契約特約保険金額２");
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykhknkngk2t("主契約特約保険金額２(通貨型)");
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykdai1hknkkn2("主契約特約第１保険期間２");
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykdai2hknkkn2("主契約特約第２保険期間２");
        bzHokenSyoukenLayoutFile.setIfeTssyutkdai1hknkknymdto2("主契約特約第１保険期間年月日（至）２");
        bzHokenSyoukenLayoutFile.setIfeTssyutkdai2hknkknymdto2("主契約特約第２保険期間年月日（至）２");
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykrenban3("主契約特約連番３");
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykmsgkbn3("主契約特約メッセージ区分３");
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkyksmsgkbn3("主契約特約保険金額メッセージ区分３");
        bzHokenSyoukenLayoutFile.setIfeTssykyktkykhknkknmsgkbn3("主契約特約保険期間メッセージ区分３");
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykstuukatype3("主契約特約保険金額通貨タイプ３");
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykhknkngk3("主契約特約保険金額３");
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykhknkngk3t("主契約特約保険金額３(通貨型)");
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykdai1hknkkn3("主契約特約第１保険期間３");
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykdai2hknkkn3("主契約特約第２保険期間３");
        bzHokenSyoukenLayoutFile.setIfeTssyutkdai1hknkknymdto3("主契約特約第１保険期間年月日（至）３");
        bzHokenSyoukenLayoutFile.setIfeTssyutkdai2hknkknymdto3("主契約特約第２保険期間年月日（至）３");
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykrenban4("主契約特約連番４");
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykmsgkbn4("主契約特約メッセージ区分４");
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkyksmsgkbn4("主契約特約保険金額メッセージ区分４");
        bzHokenSyoukenLayoutFile.setIfeTssykyktkykhknkknmsgkbn4("主契約特約保険期間メッセージ区分４");
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykstuukatype4("主契約特約保険金額通貨タイプ４");
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykhknkngk4("主契約特約保険金額４");
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykhknkngk4t("主契約特約保険金額４(通貨型)");
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykdai1hknkkn4("主契約特約第１保険期間４");
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykdai2hknkkn4("主契約特約第２保険期間４");
        bzHokenSyoukenLayoutFile.setIfeTssyutkdai1hknkknymdto4("主契約特約第１保険期間年月日（至）４");
        bzHokenSyoukenLayoutFile.setIfeTssyutkdai2hknkknymdto4("主契約特約第２保険期間年月日（至）４");
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykrenban5("主契約特約連番５");
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykmsgkbn5("主契約特約メッセージ区分５");
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkyksmsgkbn5("主契約特約保険金額メッセージ区分５");
        bzHokenSyoukenLayoutFile.setIfeTssykyktkykhknkknmsgkbn5("主契約特約保険期間メッセージ区分５");
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykstuukatype5("主契約特約保険金額通貨タイプ５");
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykhknkngk5("主契約特約保険金額５");
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykhknkngk5t("主契約特約保険金額５(通貨型)");
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykdai1hknkkn5("主契約特約第１保険期間５");
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykdai2hknkkn5("主契約特約第２保険期間５");
        bzHokenSyoukenLayoutFile.setIfeTssyutkdai1hknkknymdto5("主契約特約第１保険期間年月日（至）５");
        bzHokenSyoukenLayoutFile.setIfeTssyutkdai2hknkknymdto5("主契約特約第２保険期間年月日（至）５");
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykrenban6("主契約特約連番６");
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykmsgkbn6("主契約特約メッセージ区分６");
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkyksmsgkbn6("主契約特約保険金額メッセージ区分６");
        bzHokenSyoukenLayoutFile.setIfeTssykyktkykhknkknmsgkbn6("主契約特約保険期間メッセージ区分６");
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykstuukatype6("主契約特約保険金額通貨タイプ６");
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykhknkngk6("主契約特約保険金額６");
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykhknkngk6t("主契約特約保険金額６(通貨型)");
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykdai1hknkkn6("主契約特約第１保険期間６");
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykdai2hknkkn6("主契約特約第２保険期間６");
        bzHokenSyoukenLayoutFile.setIfeTssyutkdai1hknkknymdto6("主契約特約第１保険期間年月日（至）６");
        bzHokenSyoukenLayoutFile.setIfeTssyutkdai2hknkknymdto6("主契約特約第２保険期間年月日（至）６");
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykrenban7("主契約特約連番７");
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykmsgkbn7("主契約特約メッセージ区分７");
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkyksmsgkbn7("主契約特約保険金額メッセージ区分７");
        bzHokenSyoukenLayoutFile.setIfeTssykyktkykhknkknmsgkbn7("主契約特約保険期間メッセージ区分７");
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykstuukatype7("主契約特約保険金額通貨タイプ７");
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykhknkngk7("主契約特約保険金額７");
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykhknkngk7t("主契約特約保険金額７(通貨型)");
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykdai1hknkkn7("主契約特約第１保険期間７");
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykdai2hknkkn7("主契約特約第２保険期間７");
        bzHokenSyoukenLayoutFile.setIfeTssyutkdai1hknkknymdto7("主契約特約第１保険期間年月日（至）７");
        bzHokenSyoukenLayoutFile.setIfeTssyutkdai2hknkknymdto7("主契約特約第２保険期間年月日（至）７");
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykrenban8("主契約特約連番８");
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykmsgkbn8("主契約特約メッセージ区分８");
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkyksmsgkbn8("主契約特約保険金額メッセージ区分８");
        bzHokenSyoukenLayoutFile.setIfeTssykyktkykhknkknmsgkbn8("主契約特約保険期間メッセージ区分８");
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykstuukatype8("主契約特約保険金額通貨タイプ８");
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykhknkngk8("主契約特約保険金額８");
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykhknkngk8t("主契約特約保険金額８(通貨型)");
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykdai1hknkkn8("主契約特約第１保険期間８");
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykdai2hknkkn8("主契約特約第２保険期間８");
        bzHokenSyoukenLayoutFile.setIfeTssyutkdai1hknkknymdto8("主契約特約第１保険期間年月日（至）８");
        bzHokenSyoukenLayoutFile.setIfeTssyutkdai2hknkknymdto8("主契約特約第２保険期間年月日（至）８");
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykrenban9("主契約特約連番９");
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykmsgkbn9("主契約特約メッセージ区分９");
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkyksmsgkbn9("主契約特約保険金額メッセージ区分９");
        bzHokenSyoukenLayoutFile.setIfeTssykyktkykhknkknmsgkbn9("主契約特約保険期間メッセージ区分９");
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykstuukatype9("主契約特約保険金額通貨タイプ９");
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykhknkngk9("主契約特約保険金額９");
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykhknkngk9t("主契約特約保険金額９(通貨型)");
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykdai1hknkkn9("主契約特約第１保険期間９");
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykdai2hknkkn9("主契約特約第２保険期間９");
        bzHokenSyoukenLayoutFile.setIfeTssyutkdai1hknkknymdto9("主契約特約第１保険期間年月日（至）９");
        bzHokenSyoukenLayoutFile.setIfeTssyutkdai2hknkknymdto9("主契約特約第２保険期間年月日（至）９");
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykrenban10("主契約特約連番１０");
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykmsgkbn10("主契約特約メッセージ区分１０");
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkyksmsgkbn10("主契約特約保険金額メッセージ区分１０");
        bzHokenSyoukenLayoutFile.setIfeTssykyktkykhknkkmsgkbn10("主契約特約保険期間メッセージ区分１０");
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykstuukatype10("主契約特約保険金額通貨タイプ１０");
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykhknkngk10("主契約特約保険金額１０");
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykhknkngk10t("主契約特約保険金額１０(通貨型)");
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykdai1hknkkn10("主契約特約第１保険期間１０");
        bzHokenSyoukenLayoutFile.setIfeTssyukyktkykdai2hknkkn10("主契約特約第２保険期間１０");
        bzHokenSyoukenLayoutFile.setIfeTssyutkdai1hknkknymdto10("主契約特約第１保険期間年月日（至）１０");
        bzHokenSyoukenLayoutFile.setIfeTssyutkdai2hknkknymdto10("主契約特約第２保険期間年月日（至）１０");
        bzHokenSyoukenLayoutFile.setIfeTskykniyustmsgcd1("契約内容欄下メッセージコード１");
        bzHokenSyoukenLayoutFile.setIfeTskykniyustmsgcd2("契約内容欄下メッセージコード２");
        bzHokenSyoukenLayoutFile.setIfeTskykniyustmsgcd3("契約内容欄下メッセージコード３");
        bzHokenSyoukenLayoutFile.setIfeTskykniyustmsgcd4("契約内容欄下メッセージコード４");
        bzHokenSyoukenLayoutFile.setIfeTskykniyustmsgcd5("契約内容欄下メッセージコード５");
        bzHokenSyoukenLayoutFile.setIfeTskykniyustmsgcd6("契約内容欄下メッセージコード６");
        bzHokenSyoukenLayoutFile.setIfeTskykniyustmsgcd7("契約内容欄下メッセージコード７");
        bzHokenSyoukenLayoutFile.setIfeTskykniyustmsgcd8("契約内容欄下メッセージコード８");
        bzHokenSyoukenLayoutFile.setIfeTskykniyustmsgcd9("契約内容欄下メッセージコード９");
        bzHokenSyoukenLayoutFile.setIfeTskykniyustmsgcd10("契約内容欄下メッセージコード１０");
        bzHokenSyoukenLayoutFile.setIfeTskykniyustmsgcd11("契約内容欄下メッセージコード１１");
        bzHokenSyoukenLayoutFile.setIfeTskykniyustmsgcd12("契約内容欄下メッセージコード１２");
        bzHokenSyoukenLayoutFile.setIfeTskykniyustmsgcd13("契約内容欄下メッセージコード１３");
        bzHokenSyoukenLayoutFile.setIfeTskykniyustmsgcd14("契約内容欄下メッセージコード１４");
        bzHokenSyoukenLayoutFile.setIfeTskykniyustmsgcd15("契約内容欄下メッセージコード１５");
        bzHokenSyoukenLayoutFile.setIfeTskykniystitjbrptuuktype("契約内容欄下一時払保険料通貨タイプ");
        bzHokenSyoukenLayoutFile.setIfeTskykniyustitjbrp("契約内容欄下一時払保険料");
        bzHokenSyoukenLayoutFile.setIfeTskykniyustitjbrpt("契約内容欄下一時払保険料(通貨型)");
        bzHokenSyoukenLayoutFile.setIfeTsstnaiyouranmsgcd1("その他内容欄メッセージコード１");
        bzHokenSyoukenLayoutFile.setIfeTsstnaiyouranmsgcd2("その他内容欄メッセージコード２");
        bzHokenSyoukenLayoutFile.setIfeTsstnaiyouranmsgcd3("その他内容欄メッセージコード３");
        bzHokenSyoukenLayoutFile.setIfeTsstnaiyouranmsgcd4("その他内容欄メッセージコード４");
        bzHokenSyoukenLayoutFile.setIfeTsstnaiyouranmsgcd5("その他内容欄メッセージコード５");
        bzHokenSyoukenLayoutFile.setIfeTsstnaiyouranmsgcd6("その他内容欄メッセージコード６");
        bzHokenSyoukenLayoutFile.setIfeTsstnaiyouranmsgcd7("その他内容欄メッセージコード７");
        bzHokenSyoukenLayoutFile.setIfeTsstnaiyouranmsgcd8("その他内容欄メッセージコード８");
        bzHokenSyoukenLayoutFile.setIfeTsstnaiyouranmsgcd9("その他内容欄メッセージコード９");
        bzHokenSyoukenLayoutFile.setIfeTsstnaiyouranmsgcd10("その他内容欄メッセージコード１０");
        bzHokenSyoukenLayoutFile.setIfeTsstnaiyouranmsgcd11("その他内容欄メッセージコード１１");
        bzHokenSyoukenLayoutFile.setIfeTsstnaiyouranmsgcd12("その他内容欄メッセージコード１２");
        bzHokenSyoukenLayoutFile.setIfeTsstnaiyouranmsgcd13("その他内容欄メッセージコード１３");
        bzHokenSyoukenLayoutFile.setIfeTsstnaiyouranmsgcd14("その他内容欄メッセージコード１４");
        bzHokenSyoukenLayoutFile.setIfeTsstnaiyouranmsgcd15("その他内容欄メッセージコード１５");
        bzHokenSyoukenLayoutFile.setIfeTsstnaiyouranmsgcd16("その他内容欄メッセージコード１６");
        bzHokenSyoukenLayoutFile.setIfeTsstnaiyouranmsgcd17("その他内容欄メッセージコード１７");
        bzHokenSyoukenLayoutFile.setIfeTsstnaiyouranmsgcd18("その他内容欄メッセージコード１８");
        bzHokenSyoukenLayoutFile.setIfeTsstnaiyouranmsgcd19("その他内容欄メッセージコード１９");
        bzHokenSyoukenLayoutFile.setIfeTsstnaiyouranmsgcd20("その他内容欄メッセージコード２０");
        bzHokenSyoukenLayoutFile.setIfeTssonotanyransiteituuka("その他内容欄指定通貨");
        bzHokenSyoukenLayoutFile.setIfeTssonotanyrannykntuktype("その他内容欄入金通貨タイプ");
        bzHokenSyoukenLayoutFile.setIfeTssonotanyrannykntuukap("その他内容欄入金通貨保険料");
        bzHokenSyoukenLayoutFile.setIfeTssonotanyrannykntuukapt("その他内容欄入金通貨保険料(通貨型)");
        bzHokenSyoukenLayoutFile.setIfeTssntnyrannykntuukasyu("その他内容欄入金通貨");
        bzHokenSyoukenLayoutFile.setIfeTssntnyranenkhrikmrate("その他内容欄円貨払込特約レート");
        bzHokenSyoukenLayoutFile.setIfeTssntnyranstigikwsrate("その他内容欄指定外通貨払込特約レート");
        bzHokenSyoukenLayoutFile.setIfeTssntnyrankjnkngktuktype("その他内容欄基準金額通貨タイプ");
        bzHokenSyoukenLayoutFile.setIfeTssonotanyrankjnkngk("その他内容欄基準金額");
        bzHokenSyoukenLayoutFile.setIfeTssonotanyrankjnkngkt("その他内容欄基準金額(通貨型)");
        bzHokenSyoukenLayoutFile.setIfeTssonotanyrankjnkngkrate("その他内容欄基準金額換算レート");
        bzHokenSyoukenLayoutFile.setIfeTssntnyrankjnkngktuuka("その他内容欄基準金額通貨");
        bzHokenSyoukenLayoutFile.setIfeTssonotanyranpentuktype("その他内容欄保険料円換算通貨タイプ");
        bzHokenSyoukenLayoutFile.setIfeTssonotanyranpenknsngk("その他内容欄保険料円換算額");
        bzHokenSyoukenLayoutFile.setIfeTssonotanyranpenknsngkt("その他内容欄保険料円換算額(通貨型)");
        bzHokenSyoukenLayoutFile.setIfeTssonotanyranmkhwariai("その他内容欄目標到達割合");
        bzHokenSyoukenLayoutFile.setIfeTssonotanyranytirrt("その他内容欄予定利率");
        bzHokenSyoukenLayoutFile.setIfeTssntnyransjkkktusirrt("その他内容欄市場価格調整用利率");
        bzHokenSyoukenLayoutFile.setIfeTsstnaiyourangaimsgcd("その他内容欄外メッセージコード");
        bzHokenSyoukenLayoutFile.setIfeTstsinyno("通信先郵便番号");
        bzHokenSyoukenLayoutFile.setIfeTstsinadr1kj("通信先住所１（漢字）");
        bzHokenSyoukenLayoutFile.setIfeTstsinadr2kj("通信先住所２（漢字）");
        bzHokenSyoukenLayoutFile.setIfeTstsinadr3kj("通信先住所３（漢字）");
        bzHokenSyoukenLayoutFile.setIfeTsshsnmkj("送付先氏名（漢字）");
        bzHokenSyoukenLayoutFile.setIfeTstnknmissmsg("転換ミスメッセージ");
        bzHokenSyoukenLayoutFile.setIfeTserrormsgcd("エラーメッセージコード");
        bzHokenSyoukenLayoutFile.setIfeTssisyacd("支社コード");
        bzHokenSyoukenLayoutFile.setIfeTsdhutusnrntousaadrmsgcd("同封通信欄当社住所メッセージコード");
        bzHokenSyoukenLayoutFile.setIfeTsduhutusnrnsyono("同封通信欄証券番号");
        bzHokenSyoukenLayoutFile.setIfeTschannelcd("チャネルコード");
        bzHokenSyoukenLayoutFile.setIfeTsdairitenmidasikbn("代理店見出し区分");
        bzHokenSyoukenLayoutFile.setIfeTsdrtennm1kj("代理店名１（漢字）");
        bzHokenSyoukenLayoutFile.setIfeTsdrtennm2kj("代理店名２（漢字）");
        bzHokenSyoukenLayoutFile.setIfeTsaisatumsgcd("挨拶メッセージコード");
        bzHokenSyoukenLayoutFile.setIfeTsccmsgcd("コールセンターメッセージコード");
        bzHokenSyoukenLayoutFile.setIfeTshskmsgcd("補足メッセージコード");
        bzHokenSyoukenLayoutFile.setIfeTshosyounymsgcd("保障内容メッセージコード");
        bzHokenSyoukenLayoutFile.setIfeTshosynyhihknsyameikanji("保障内容被保険者名（漢字）");
        bzHokenSyoukenLayoutFile.setIfeTssiboumidasimsgcd("死亡保障見出しメッセージコード");
        bzHokenSyoukenLayoutFile.setIfeTssiboumidasimsgcd2("死亡保障見出しメッセージコード２");
        bzHokenSyoukenLayoutFile.setIfeTssiboudai1hknkknmsgcd1("死亡保障第１保険期間メッセージコード１");
        bzHokenSyoukenLayoutFile.setIfeTssiboudai1hknkknmsgcd2("死亡保障第１保険期間メッセージコード２");
        bzHokenSyoukenLayoutFile.setIfeTssiboud1hknkknigimsgcd("死亡保障第１保険期間不慮以外Ｓ表メッセージコード");
        bzHokenSyoukenLayoutFile.setIfeTssiboud1hknkknigimsgcd2("死亡保障第１保険期間不慮以外Ｓ表メッセージコード２");
        bzHokenSyoukenLayoutFile.setIfeTssiboud1hknkknhrsmsgcd("死亡保障第１保険期間不慮Ｓ表メッセージコード");
        bzHokenSyoukenLayoutFile.setIfeTssiboud1hknkknhrsmsgcd2("死亡保障第１保険期間不慮Ｓ表メッセージコード２");
        bzHokenSyoukenLayoutFile.setIfeTssiboud1hknkknsmrmsgcd("死亡保障第１保険期間Ｓ表丸印メッセージコード");
        bzHokenSyoukenLayoutFile.setIfeTssiboudai2hknkknmsgcd1("死亡保障第２保険期間メッセージコード１");
        bzHokenSyoukenLayoutFile.setIfeTssiboudai2hknkknmsgcd2("死亡保障第２保険期間メッセージコード２");
        bzHokenSyoukenLayoutFile.setIfeTssiboudai2hknkknsmsgcd("死亡保障第２保険期間Ｓ表メッセージコード");
        bzHokenSyoukenLayoutFile.setIfeTssiboudai2hknkknsmsgcd2("死亡保障第２保険期間Ｓ表メッセージコード２");
        bzHokenSyoukenLayoutFile.setIfeTssiboudai3hknkknmsgcd1("死亡保障第３保険期間メッセージコード１");
        bzHokenSyoukenLayoutFile.setIfeTssiboudai3hknkknmsgcd2("死亡保障第３保険期間メッセージコード２");
        bzHokenSyoukenLayoutFile.setIfeTssiboudai1hknkkn("死亡保障第１保険期間");
        bzHokenSyoukenLayoutFile.setIfeTssiboudai1hknkknymdto("死亡保障第１保険期間年月日（至）");
        bzHokenSyoukenLayoutFile.setIfeTssibouitjbrpyentuuktype("死亡保障一時払保険料相当円換算額通貨タイプ");
        bzHokenSyoukenLayoutFile.setIfeTssibouitjbrpyentuukgk("死亡保障一時払保険料相当円換算額");
        bzHokenSyoukenLayoutFile.setIfeTssibouitjbrpyentuukgkt("死亡保障一時払保険料相当円換算額(通貨型)");
        bzHokenSyoukenLayoutFile.setIfeTssiboud1kjnkngktuuktype("死亡保障第１基準金額通貨タイプ");
        bzHokenSyoukenLayoutFile.setIfeTssiboudai1kjnkngk("死亡保障第１基準金額");
        bzHokenSyoukenLayoutFile.setIfeTssiboudai1kjnkngkt("死亡保障第１基準金額(通貨型)");
        bzHokenSyoukenLayoutFile.setIfeTssiboudai2hknkkn("死亡保障第２保険期間");
        bzHokenSyoukenLayoutFile.setIfeTssiboudai2hknkknymdto("死亡保障第２保険期間年月日（至）");
        bzHokenSyoukenLayoutFile.setIfeTssiboud2kjnkngktuuktype("死亡保障第２基準金額通貨タイプ");
        bzHokenSyoukenLayoutFile.setIfeTssiboudai2kjnkngk("死亡保障第２基準金額");
        bzHokenSyoukenLayoutFile.setIfeTssiboudai2kjnkngkt("死亡保障第２基準金額(通貨型)");
        bzHokenSyoukenLayoutFile.setIfeTssiboud3kjnkngktuuktype("死亡保障第３基準金額通貨タイプ");
        bzHokenSyoukenLayoutFile.setIfeTssiboudai3kjnkngk("死亡保障第３基準金額");
        bzHokenSyoukenLayoutFile.setIfeTssiboudai3kjnkngkt("死亡保障第３基準金額(通貨型)");
        bzHokenSyoukenLayoutFile.setIfeTsdai1skwsrateyendaka("第１死亡保険金額為替レート（円高）");
        bzHokenSyoukenLayoutFile.setIfeTsdai1skwsrateyenkijyun("第１死亡保険金額為替レート（中央値）");
        bzHokenSyoukenLayoutFile.setIfeTsdai1skwsrateyenyasu("第１死亡保険金額為替レート（円安）");
        bzHokenSyoukenLayoutFile.setIfeTsdai1skeikanensuu01("第１死亡保険金額経過年数０１");
        bzHokenSyoukenLayoutFile.setIfeTsd1sibousnenoutouymd01("第１死亡保険金額年単位応当年月日０１");
        bzHokenSyoukenLayoutFile.setIfeTsdai1stuuktype01("第１死亡保険金額通貨タイプ０１");
        bzHokenSyoukenLayoutFile.setIfeTsdai1s01("第１死亡保険金額０１");
        bzHokenSyoukenLayoutFile.setIfeTsdai1s01t("第１死亡保険金額０１(通貨型)");
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyendakaumu01("第１死亡保険金額（円貨）（円高）丸印有無０１");
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyenkijyunumu01("第１死亡保険金額（円貨）（中央値）丸印有無０１");
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyenyasuumu01("第１死亡保険金額（円貨）（円安）丸印有無０１");
        bzHokenSyoukenLayoutFile.setIfeTsdai1syentuuktype01("第１死亡保険金額（円貨）通貨タイプ０１");
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyendaka01("第１死亡保険金額（円貨）（円高）０１");
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyendaka01t("第１死亡保険金額（円貨）（円高）０１(通貨型)");
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyenkijyun01("第１死亡保険金額（円貨）（中央値）０１");
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyenkijyun01t("第１死亡保険金額（円貨）（中央値）０１(通貨型)");
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyenyasu01("第１死亡保険金額（円貨）（円安）０１");
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyenyasu01t("第１死亡保険金額（円貨）（円安）０１(通貨型)");
        bzHokenSyoukenLayoutFile.setIfeTsdai1skeikanensuu02("第１死亡保険金額経過年数０２");
        bzHokenSyoukenLayoutFile.setIfeTsd1sibousnenoutouymd02("第１死亡保険金額年単位応当年月日０２");
        bzHokenSyoukenLayoutFile.setIfeTsdai1stuuktype02("第１死亡保険金額通貨タイプ０２");
        bzHokenSyoukenLayoutFile.setIfeTsdai1s02("第１死亡保険金額０２");
        bzHokenSyoukenLayoutFile.setIfeTsdai1s02t("第１死亡保険金額０２(通貨型)");
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyendakaumu02("第１死亡保険金額（円貨）（円高）丸印有無０２");
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyenkijyunumu02("第１死亡保険金額（円貨）（中央値）丸印有無０２");
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyenyasuumu02("第１死亡保険金額（円貨）（円安）丸印有無０２");
        bzHokenSyoukenLayoutFile.setIfeTsdai1syentuuktype02("第１死亡保険金額（円貨）通貨タイプ０２");
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyendaka02("第１死亡保険金額（円貨）（円高）０２");
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyendaka02t("第１死亡保険金額（円貨）（円高）０２(通貨型)");
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyenkijyun02("第１死亡保険金額（円貨）（中央値）０２");
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyenkijyun02t("第１死亡保険金額（円貨）（中央値）０２(通貨型)");
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyenyasu02("第１死亡保険金額（円貨）（円安）０２");
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyenyasu02t("第１死亡保険金額（円貨）（円安）０２(通貨型)");
        bzHokenSyoukenLayoutFile.setIfeTsdai1skeikanensuu03("第１死亡保険金額経過年数０３");
        bzHokenSyoukenLayoutFile.setIfeTsd1sibousnenoutouymd03("第１死亡保険金額年単位応当年月日０３");
        bzHokenSyoukenLayoutFile.setIfeTsdai1stuuktype03("第１死亡保険金額通貨タイプ０３");
        bzHokenSyoukenLayoutFile.setIfeTsdai1s03("第１死亡保険金額０３");
        bzHokenSyoukenLayoutFile.setIfeTsdai1s03t("第１死亡保険金額０３(通貨型)");
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyendakaumu03("第１死亡保険金額（円貨）（円高）丸印有無０３");
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyenkijyunumu03("第１死亡保険金額（円貨）（中央値）丸印有無０３");
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyenyasuumu03("第１死亡保険金額（円貨）（円安）丸印有無０３");
        bzHokenSyoukenLayoutFile.setIfeTsdai1syentuuktype03("第１死亡保険金額（円貨）通貨タイプ０３");
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyendaka03("第１死亡保険金額（円貨）（円高）０３");
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyendaka03t("第１死亡保険金額（円貨）（円高）０３(通貨型)");
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyenkijyun03("第１死亡保険金額（円貨）（中央値）０３");
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyenkijyun03t("第１死亡保険金額（円貨）（中央値）０３(通貨型)");
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyenyasu03("第１死亡保険金額（円貨）（円安）０３");
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyenyasu03t("第１死亡保険金額（円貨）（円安）０３(通貨型)");
        bzHokenSyoukenLayoutFile.setIfeTsdai1skeikanensuu04("第１死亡保険金額経過年数０４");
        bzHokenSyoukenLayoutFile.setIfeTsd1sibousnenoutouymd04("第１死亡保険金額年単位応当年月日０４");
        bzHokenSyoukenLayoutFile.setIfeTsdai1stuuktype04("第１死亡保険金額通貨タイプ０４");
        bzHokenSyoukenLayoutFile.setIfeTsdai1s04("第１死亡保険金額０４");
        bzHokenSyoukenLayoutFile.setIfeTsdai1s04t("第１死亡保険金額０４(通貨型)");
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyendakaumu04("第１死亡保険金額（円貨）（円高）丸印有無０４");
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyenkijyunumu04("第１死亡保険金額（円貨）（中央値）丸印有無０４");
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyenyasuumu04("第１死亡保険金額（円貨）（円安）丸印有無０４");
        bzHokenSyoukenLayoutFile.setIfeTsdai1syentuuktype04("第１死亡保険金額（円貨）通貨タイプ０４");
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyendaka04("第１死亡保険金額（円貨）（円高）０４");
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyendaka04t("第１死亡保険金額（円貨）（円高）０４(通貨型)");
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyenkijyun04("第１死亡保険金額（円貨）（中央値）０４");
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyenkijyun04t("第１死亡保険金額（円貨）（中央値）０４(通貨型)");
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyenyasu04("第１死亡保険金額（円貨）（円安）０４");
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyenyasu04t("第１死亡保険金額（円貨）（円安）０４(通貨型)");
        bzHokenSyoukenLayoutFile.setIfeTsdai1skeikanensuu05("第１死亡保険金額経過年数０５");
        bzHokenSyoukenLayoutFile.setIfeTsd1sibousnenoutouymd05("第１死亡保険金額年単位応当年月日０５");
        bzHokenSyoukenLayoutFile.setIfeTsdai1stuuktype05("第１死亡保険金額通貨タイプ０５");
        bzHokenSyoukenLayoutFile.setIfeTsdai1s05("第１死亡保険金額０５");
        bzHokenSyoukenLayoutFile.setIfeTsdai1s05t("第１死亡保険金額０５(通貨型)");
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyendakaumu05("第１死亡保険金額（円貨）（円高）丸印有無０５");
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyenkijyunumu05("第１死亡保険金額（円貨）（中央値）丸印有無０５");
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyenyasuumu05("第１死亡保険金額（円貨）（円安）丸印有無０５");
        bzHokenSyoukenLayoutFile.setIfeTsdai1syentuuktype05("第１死亡保険金額（円貨）通貨タイプ０５");
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyendaka05("第１死亡保険金額（円貨）（円高）０５");
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyendaka05t("第１死亡保険金額（円貨）（円高）０５(通貨型)");
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyenkijyun05("第１死亡保険金額（円貨）（中央値）０５");
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyenkijyun05t("第１死亡保険金額（円貨）（中央値）０５(通貨型)");
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyenyasu05("第１死亡保険金額（円貨）（円安）０５");
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyenyasu05t("第１死亡保険金額（円貨）（円安）０５(通貨型)");
        bzHokenSyoukenLayoutFile.setIfeTsdai1skeikanensuu06("第１死亡保険金額経過年数０６");
        bzHokenSyoukenLayoutFile.setIfeTsd1sibousnenoutouymd06("第１死亡保険金額年単位応当年月日０６");
        bzHokenSyoukenLayoutFile.setIfeTsdai1stuuktype06("第１死亡保険金額通貨タイプ０６");
        bzHokenSyoukenLayoutFile.setIfeTsdai1s06("第１死亡保険金額０６");
        bzHokenSyoukenLayoutFile.setIfeTsdai1s06t("第１死亡保険金額０６(通貨型)");
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyendakaumu06("第１死亡保険金額（円貨）（円高）丸印有無０６");
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyenkijyunumu06("第１死亡保険金額（円貨）（中央値）丸印有無０６");
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyenyasuumu06("第１死亡保険金額（円貨）（円安）丸印有無０６");
        bzHokenSyoukenLayoutFile.setIfeTsdai1syentuuktype06("第１死亡保険金額（円貨）通貨タイプ０６");
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyendaka06("第１死亡保険金額（円貨）（円高）０６");
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyendaka06t("第１死亡保険金額（円貨）（円高）０６(通貨型)");
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyenkijyun06("第１死亡保険金額（円貨）（中央値）０６");
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyenkijyun06t("第１死亡保険金額（円貨）（中央値）０６(通貨型)");
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyenyasu06("第１死亡保険金額（円貨）（円安）０６");
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyenyasu06t("第１死亡保険金額（円貨）（円安）０６(通貨型)");
        bzHokenSyoukenLayoutFile.setIfeTsdai1skeikanensuu07("第１死亡保険金額経過年数０７");
        bzHokenSyoukenLayoutFile.setIfeTsd1sibousnenoutouymd07("第１死亡保険金額年単位応当年月日０７");
        bzHokenSyoukenLayoutFile.setIfeTsdai1stuuktype07("第１死亡保険金額通貨タイプ０７");
        bzHokenSyoukenLayoutFile.setIfeTsdai1s07("第１死亡保険金額０７");
        bzHokenSyoukenLayoutFile.setIfeTsdai1s07t("第１死亡保険金額０７(通貨型)");
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyendakaumu07("第１死亡保険金額（円貨）（円高）丸印有無０７");
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyenkijyunumu07("第１死亡保険金額（円貨）（中央値）丸印有無０７");
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyenyasuumu07("第１死亡保険金額（円貨）（円安）丸印有無０７");
        bzHokenSyoukenLayoutFile.setIfeTsdai1syentuuktype07("第１死亡保険金額（円貨）通貨タイプ０７");
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyendaka07("第１死亡保険金額（円貨）（円高）０７");
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyendaka07t("第１死亡保険金額（円貨）（円高）０７(通貨型)");
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyenkijyun07("第１死亡保険金額（円貨）（中央値）０７");
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyenkijyun07t("第１死亡保険金額（円貨）（中央値）０７(通貨型)");
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyenyasu07("第１死亡保険金額（円貨）（円安）０７");
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyenyasu07t("第１死亡保険金額（円貨）（円安）０７(通貨型)");
        bzHokenSyoukenLayoutFile.setIfeTsdai1skeikanensuu08("第１死亡保険金額経過年数０８");
        bzHokenSyoukenLayoutFile.setIfeTsd1sibousnenoutouymd08("第１死亡保険金額年単位応当年月日０８");
        bzHokenSyoukenLayoutFile.setIfeTsdai1stuuktype08("第１死亡保険金額通貨タイプ０８");
        bzHokenSyoukenLayoutFile.setIfeTsdai1s08("第１死亡保険金額０８");
        bzHokenSyoukenLayoutFile.setIfeTsdai1s08t("第１死亡保険金額０８(通貨型)");
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyendakaumu08("第１死亡保険金額（円貨）（円高）丸印有無０８");
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyenkijyunumu08("第１死亡保険金額（円貨）（中央値）丸印有無０８");
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyenyasuumu08("第１死亡保険金額（円貨）（円安）丸印有無０８");
        bzHokenSyoukenLayoutFile.setIfeTsdai1syentuuktype08("第１死亡保険金額（円貨）通貨タイプ０８");
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyendaka08("第１死亡保険金額（円貨）（円高）０８");
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyendaka08t("第１死亡保険金額（円貨）（円高）０８(通貨型)");
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyenkijyun08("第１死亡保険金額（円貨）（中央値）０８");
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyenkijyun08t("第１死亡保険金額（円貨）（中央値）０８(通貨型)");
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyenyasu08("第１死亡保険金額（円貨）（円安）０８");
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyenyasu08t("第１死亡保険金額（円貨）（円安）０８(通貨型)");
        bzHokenSyoukenLayoutFile.setIfeTsdai1skeikanensuu09("第１死亡保険金額経過年数０９");
        bzHokenSyoukenLayoutFile.setIfeTsd1sibousnenoutouymd09("第１死亡保険金額年単位応当年月日０９");
        bzHokenSyoukenLayoutFile.setIfeTsdai1stuuktype09("第１死亡保険金額通貨タイプ０９");
        bzHokenSyoukenLayoutFile.setIfeTsdai1s09("第１死亡保険金額０９");
        bzHokenSyoukenLayoutFile.setIfeTsdai1s09t("第１死亡保険金額０９(通貨型)");
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyendakaumu09("第１死亡保険金額（円貨）（円高）丸印有無０９");
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyenkijyunumu09("第１死亡保険金額（円貨）（中央値）丸印有無０９");
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyenyasuumu09("第１死亡保険金額（円貨）（円安）丸印有無０９");
        bzHokenSyoukenLayoutFile.setIfeTsdai1syentuuktype09("第１死亡保険金額（円貨）通貨タイプ０９");
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyendaka09("第１死亡保険金額（円貨）（円高）０９");
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyendaka09t("第１死亡保険金額（円貨）（円高）０９(通貨型)");
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyenkijyun09("第１死亡保険金額（円貨）（中央値）０９");
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyenkijyun09t("第１死亡保険金額（円貨）（中央値）０９(通貨型)");
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyenyasu09("第１死亡保険金額（円貨）（円安）０９");
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyenyasu09t("第１死亡保険金額（円貨）（円安）０９(通貨型)");
        bzHokenSyoukenLayoutFile.setIfeTsdai1skeikanensuu10("第１死亡保険金額経過年数１０");
        bzHokenSyoukenLayoutFile.setIfeTsd1sibousnenoutouymd10("第１死亡保険金額年単位応当年月日１０");
        bzHokenSyoukenLayoutFile.setIfeTsdai1stuuktype10("第１死亡保険金額通貨タイプ１０");
        bzHokenSyoukenLayoutFile.setIfeTsdai1s10("第１死亡保険金額１０");
        bzHokenSyoukenLayoutFile.setIfeTsdai1s10t("第１死亡保険金額１０(通貨型)");
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyendakaumu10("第１死亡保険金額（円貨）（円高）丸印有無１０");
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyenkijyunumu10("第１死亡保険金額（円貨）（中央値）丸印有無１０");
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyenyasuumu10("第１死亡保険金額（円貨）（円安）丸印有無１０");
        bzHokenSyoukenLayoutFile.setIfeTsdai1syentuuktype10("第１死亡保険金額（円貨）通貨タイプ１０");
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyendaka10("第１死亡保険金額（円貨）（円高）１０");
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyendaka10t("第１死亡保険金額（円貨）（円高）１０(通貨型)");
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyenkijyun10("第１死亡保険金額（円貨）（中央値）１０");
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyenkijyun10t("第１死亡保険金額（円貨）（中央値）１０(通貨型)");
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyenyasu10("第１死亡保険金額（円貨）（円安）１０");
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyenyasu10t("第１死亡保険金額（円貨）（円安）１０(通貨型)");
        bzHokenSyoukenLayoutFile.setIfeTsdai1stuuktypehuryo("第１死亡保険金額通貨タイプ（不慮）");
        bzHokenSyoukenLayoutFile.setIfeTsdai1shuryo("第１死亡保険金額（不慮）");
        bzHokenSyoukenLayoutFile.setIfeTsdai1shuryot("第１死亡保険金額（不慮）(通貨型)");
        bzHokenSyoukenLayoutFile.setIfeTsd1syenyendakaumuhuryo("第１死亡保険金額（円貨）（円高）丸印有無（不慮）");
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyenkjnumuhuryo("第１死亡保険金額（円貨）（中央値）丸印有無（不慮）");
        bzHokenSyoukenLayoutFile.setIfeTsd1syenyenyasuumuhuryo("第１死亡保険金額（円貨）（円安）丸印有無（不慮）");
        bzHokenSyoukenLayoutFile.setIfeTsdai1syentuuktypehuryo("第１死亡保険金額（円貨）通貨タイプ（不慮）");
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyendakahuryo("第１死亡保険金額（円貨）（円高）（不慮）");
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyendakahuryot("第１死亡保険金額（円貨）（円高）（不慮）(通貨型)");
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyenkijyunhuryo("第１死亡保険金額（円貨）（中央値）（不慮）");
        bzHokenSyoukenLayoutFile.setIfeTsd1syenyenkijyunhuryot("第１死亡保険金額（円貨）（中央値）（不慮）(通貨型)");
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyenyasuhuryo("第１死亡保険金額（円貨）（円安）（不慮）");
        bzHokenSyoukenLayoutFile.setIfeTsdai1syenyenyasuhuryot("第１死亡保険金額（円貨）（円安）（不慮）(通貨型)");
        bzHokenSyoukenLayoutFile.setIfeTsinitsbjiyenkasthsygk("初期死亡時円換算最低保証額");
        bzHokenSyoukenLayoutFile.setIfeTsinitsbjiyenkasthsygkt("初期死亡時円換算最低保証額(通貨型)");
        bzHokenSyoukenLayoutFile.setIfeTsdai2stuuktype("第２死亡保険金額通貨タイプ");
        bzHokenSyoukenLayoutFile.setIfeTsdai2s("第２死亡保険金額");
        bzHokenSyoukenLayoutFile.setIfeTsdai2st("第２死亡保険金額(通貨型)");
        bzHokenSyoukenLayoutFile.setIfeTsdai2syentuuktype("第２死亡保険金額（円貨）通貨タイプ");
        bzHokenSyoukenLayoutFile.setIfeTsdai2syenyendaka("第２死亡保険金額（円貨）（円高）");
        bzHokenSyoukenLayoutFile.setIfeTsdai2syenyendakat("第２死亡保険金額（円貨）（円高）(通貨型)");
        bzHokenSyoukenLayoutFile.setIfeTsdai2syenyenkijyun("第２死亡保険金額（円貨）（中央値）");
        bzHokenSyoukenLayoutFile.setIfeTsdai2syenyenkijyunt("第２死亡保険金額（円貨）（中央値）(通貨型)");
        bzHokenSyoukenLayoutFile.setIfeTsdai2syenyenyasu("第２死亡保険金額（円貨）（円安）");
        bzHokenSyoukenLayoutFile.setIfeTsdai2syenyenyasut("第２死亡保険金額（円貨）（円安）(通貨型)");
        bzHokenSyoukenLayoutFile.setIfeTsdai3stuuktype("第３死亡保険金額通貨タイプ");
        bzHokenSyoukenLayoutFile.setIfeTsdai3s("第３死亡保険金額");
        bzHokenSyoukenLayoutFile.setIfeTsdai3st("第３死亡保険金額(通貨型)");
        bzHokenSyoukenLayoutFile.setIfeTsdai3syentuuktype("第３死亡保険金額（円貨）通貨タイプ");
        bzHokenSyoukenLayoutFile.setIfeTsdai3syenyendaka("第３死亡保険金額（円貨）（円高）");
        bzHokenSyoukenLayoutFile.setIfeTsdai3syenyendakat("第３死亡保険金額（円貨）（円高）(通貨型)");
        bzHokenSyoukenLayoutFile.setIfeTsdai3syenyenkijyun("第３死亡保険金額（円貨）（中央値）");
        bzHokenSyoukenLayoutFile.setIfeTsdai3syenyenkijyunt("第３死亡保険金額（円貨）（中央値）(通貨型)");
        bzHokenSyoukenLayoutFile.setIfeTsdai3syenyenyasu("第３死亡保険金額（円貨）（円安）");
        bzHokenSyoukenLayoutFile.setIfeTsdai3syenyenyasut("第３死亡保険金額（円貨）（円安）(通貨型)");
        bzHokenSyoukenLayoutFile.setIfeTssibouinjiptnkbn("死亡保障印字パターン");
        bzHokenSyoukenLayoutFile.setIfeTsmkhyouyensysnikoumsgcd("目標到達時円建終身保険移行特約メッセージコード");
        bzHokenSyoukenLayoutFile.setIfeTsmkhyyensysnikoumsgcd2("目標到達時円建終身保険移行特約メッセージコード２");
        bzHokenSyoukenLayoutFile.setIfeTsmkhyyensysnikoumsgcd3("目標到達時円建終身保険移行特約メッセージコード３");
        bzHokenSyoukenLayoutFile.setIfeTsmkhyyensysnikougktype("目標到達時円建終身保険移行特約目標額通貨タイプ");
        bzHokenSyoukenLayoutFile.setIfeTsmkhyouyensysnikougk("目標到達時円建終身保険移行特約目標額");
        bzHokenSyoukenLayoutFile.setIfeTsmkhyouyensysnikougkt("目標到達時円建終身保険移行特約目標額(通貨型)");
        bzHokenSyoukenLayoutFile.setIfeTsmkhyouyensysnikouwra("目標到達時円建終身保険移行特約目標割合");
        bzHokenSyoukenLayoutFile.setIfeTskaigomaehrtkykmsgcd1("介護前払特約メッセージコード１");
        bzHokenSyoukenLayoutFile.setIfeTskaigomaehrtkykmsgcd2("介護前払特約メッセージコード２");
        bzHokenSyoukenLayoutFile.setIfeTskaigomaehrtkykmsgcdst1("介護前払特約メッセージコード表下１");
        bzHokenSyoukenLayoutFile.setIfeTskaigomaehrtkykmsgcdst2("介護前払特約メッセージコード表下２");
        bzHokenSyoukenLayoutFile.setIfeTskaigomaehruktgkumu("介護前払特約受取額一覧有無");
        bzHokenSyoukenLayoutFile.setIfeTskaigomaehrtkykkyktuuka("介護前払特約契約通貨");
        bzHokenSyoukenLayoutFile.setIfeTskaigomaehrtkykstdmsgcd("介護前払特約指定代理メッセージコード");
        bzHokenSyoukenLayoutFile.setIfeTskaigomaehrjrugktype("介護前払受領額通貨タイプ");
        bzHokenSyoukenLayoutFile.setIfeTskgomaehrsikuhhknnen01("介護前払請求日時点被保険者年齢０１");
        bzHokenSyoukenLayoutFile.setIfeTskaigomaehrstikkn01("介護前払所定期間０１");
        bzHokenSyoukenLayoutFile.setIfeTskaigomaehrjrugk01("介護前払受領額０１");
        bzHokenSyoukenLayoutFile.setIfeTskaigomaehrjrugk01t("介護前払受領額０１(通貨型)");
        bzHokenSyoukenLayoutFile.setIfeTskgomaehrsikuhhknnen02("介護前払請求日時点被保険者年齢０２");
        bzHokenSyoukenLayoutFile.setIfeTskaigomaehrstikkn02("介護前払所定期間０２");
        bzHokenSyoukenLayoutFile.setIfeTskaigomaehrjrugk02("介護前払受領額０２");
        bzHokenSyoukenLayoutFile.setIfeTskaigomaehrjrugk02t("介護前払受領額０２(通貨型)");
        bzHokenSyoukenLayoutFile.setIfeTskgomaehrsikuhhknnen03("介護前払請求日時点被保険者年齢０３");
        bzHokenSyoukenLayoutFile.setIfeTskaigomaehrstikkn03("介護前払所定期間０３");
        bzHokenSyoukenLayoutFile.setIfeTskaigomaehrjrugk03("介護前払受領額０３");
        bzHokenSyoukenLayoutFile.setIfeTskaigomaehrjrugk03t("介護前払受領額０３(通貨型)");
        bzHokenSyoukenLayoutFile.setIfeTskgomaehrsikuhhknnen04("介護前払請求日時点被保険者年齢０４");
        bzHokenSyoukenLayoutFile.setIfeTskaigomaehrstikkn04("介護前払所定期間０４");
        bzHokenSyoukenLayoutFile.setIfeTskaigomaehrjrugk04("介護前払受領額０４");
        bzHokenSyoukenLayoutFile.setIfeTskaigomaehrjrugk04t("介護前払受領額０４(通貨型)");
        bzHokenSyoukenLayoutFile.setIfeTskgomaehrsikuhhknnen05("介護前払請求日時点被保険者年齢０５");
        bzHokenSyoukenLayoutFile.setIfeTskaigomaehrstikkn05("介護前払所定期間０５");
        bzHokenSyoukenLayoutFile.setIfeTskaigomaehrjrugk05("介護前払受領額０５");
        bzHokenSyoukenLayoutFile.setIfeTskaigomaehrjrugk05t("介護前払受領額０５(通貨型)");
        bzHokenSyoukenLayoutFile.setIfeTskgomaehrsikuhhknnen06("介護前払請求日時点被保険者年齢０６");
        bzHokenSyoukenLayoutFile.setIfeTskaigomaehrstikkn06("介護前払所定期間０６");
        bzHokenSyoukenLayoutFile.setIfeTskaigomaehrjrugk06("介護前払受領額０６");
        bzHokenSyoukenLayoutFile.setIfeTskaigomaehrjrugk06t("介護前払受領額０６(通貨型)");
        bzHokenSyoukenLayoutFile.setIfeTskgomaehrsikuhhknnen07("介護前払請求日時点被保険者年齢０７");
        bzHokenSyoukenLayoutFile.setIfeTskaigomaehrstikkn07("介護前払所定期間０７");
        bzHokenSyoukenLayoutFile.setIfeTskaigomaehrjrugk07("介護前払受領額０７");
        bzHokenSyoukenLayoutFile.setIfeTskaigomaehrjrugk07t("介護前払受領額０７(通貨型)");
        bzHokenSyoukenLayoutFile.setIfeTskgomaehrsikuhhknnen08("介護前払請求日時点被保険者年齢０８");
        bzHokenSyoukenLayoutFile.setIfeTskaigomaehrstikkn08("介護前払所定期間０８");
        bzHokenSyoukenLayoutFile.setIfeTskaigomaehrjrugk08("介護前払受領額０８");
        bzHokenSyoukenLayoutFile.setIfeTskaigomaehrjrugk08t("介護前払受領額０８(通貨型)");
        bzHokenSyoukenLayoutFile.setIfeTskgomaehrsikuhhknnen09("介護前払請求日時点被保険者年齢０９");
        bzHokenSyoukenLayoutFile.setIfeTskaigomaehrstikkn09("介護前払所定期間０９");
        bzHokenSyoukenLayoutFile.setIfeTskaigomaehrjrugk09("介護前払受領額０９");
        bzHokenSyoukenLayoutFile.setIfeTskaigomaehrjrugk09t("介護前払受領額０９(通貨型)");
        bzHokenSyoukenLayoutFile.setIfeTskgomaehrsikuhhknnen10("介護前払請求日時点被保険者年齢１０");
        bzHokenSyoukenLayoutFile.setIfeTskaigomaehrstikkn10("介護前払所定期間１０");
        bzHokenSyoukenLayoutFile.setIfeTskaigomaehrjrugk10("介護前払受領額１０");
        bzHokenSyoukenLayoutFile.setIfeTskaigomaehrjrugk10t("介護前払受領額１０(通貨型)");
        bzHokenSyoukenLayoutFile.setIfeTshutanhiyustmmsgcdue01("ご負担費用説明欄メッセージコード表上１");
        bzHokenSyoukenLayoutFile.setIfeTshutanhiyustmmsgcdue02("ご負担費用説明欄メッセージコード表上２");
        bzHokenSyoukenLayoutFile.setIfeTshutanhiyustmmsgcdue03("ご負担費用説明欄メッセージコード表上３");
        bzHokenSyoukenLayoutFile.setIfeTshutanhiyustmmsgcdue04("ご負担費用説明欄メッセージコード表上４");
        bzHokenSyoukenLayoutFile.setIfeTshutanhiyustmknsnhyuptn("ご負担費用説明欄換算費用パターン");
        bzHokenSyoukenLayoutFile.setIfeTshutanhiyustmmsgcdst01("ご負担費用説明欄メッセージコード表下１");
        bzHokenSyoukenLayoutFile.setIfeTshutanhiyustmmsgcdst02("ご負担費用説明欄メッセージコード表下２");
        bzHokenSyoukenLayoutFile.setIfeTshutanhiyustmmsgcdst03("ご負担費用説明欄メッセージコード表下３");
        bzHokenSyoukenLayoutFile.setIfeTsstdstmmsgcd("指定代理請求特約説明欄メッセージコード");
        bzHokenSyoukenLayoutFile.setIfeTsfstpmsgcd("初回Ｐご確認欄メッセージコード");
        bzHokenSyoukenLayoutFile.setIfeTsfstphrkpkngkketuuktype("初回Ｐご確認欄払込保険料合計通貨タイプ");
        bzHokenSyoukenLayoutFile.setIfeTsfstphrkpkngkkei("初回Ｐご確認欄払込保険料合計");
        bzHokenSyoukenLayoutFile.setIfeTsfstphrkpkngkkeit("初回Ｐご確認欄払込保険料合計(通貨型)");
        bzHokenSyoukenLayoutFile.setIfeTsfstponegaimsgcd("初回Ｐご確認欄お願いメッセージコード");
        bzHokenSyoukenLayoutFile.setIfeTsdsmsgcd("スミセイダイレクトサービスメッセージコード");
        bzHokenSyoukenLayoutFile.setIfeTssyouhnhutaimsgcd1("商品付帯サービスメッセージコード１");
        bzHokenSyoukenLayoutFile.setIfeTssyouhnhutaimsgcd2("商品付帯サービスメッセージコード２");
        bzHokenSyoukenLayoutFile.setIfeTspyentuuktype("保険料円換算額通貨タイプ");
        bzHokenSyoukenLayoutFile.setIfeTspyen("保険料円換算額");
        bzHokenSyoukenLayoutFile.setIfeTspyent("保険料円換算額(通貨型)");
        bzHokenSyoukenLayoutFile.setIfeTstoiawasesakihanyomsgcd("問合せ先汎用メッセージコード");
        bzHokenSyoukenLayoutFile.setIfeTsannaihanyoumsgcd("案内汎用メッセージコード");
        bzHokenSyoukenLayoutFile.setIfeTswmsgcd1("解約返戻金メッセージコード１");
        bzHokenSyoukenLayoutFile.setIfeTswmsgcd2("解約返戻金メッセージコード２");
        bzHokenSyoukenLayoutFile.setIfeTswmsgcd3("解約返戻金メッセージコード３");
        bzHokenSyoukenLayoutFile.setIfeTswtyuuijikoumsgcd1("解約返戻金注意事項メッセージコード１");
        bzHokenSyoukenLayoutFile.setIfeTswtyuuijikoumsgcd2("解約返戻金注意事項メッセージコード２");
        bzHokenSyoukenLayoutFile.setIfeTswtyuuijikoumsgcd3("解約返戻金注意事項メッセージコード３");
        bzHokenSyoukenLayoutFile.setIfeTswtyuuijikoumsgcd4("解約返戻金注意事項メッセージコード４");
        bzHokenSyoukenLayoutFile.setIfeTswtyuuijikoumsgcd5("解約返戻金注意事項メッセージコード５");
        bzHokenSyoukenLayoutFile.setIfeTswitijibrptuktype("解約返戻金一時払保険料通貨タイプ");
        bzHokenSyoukenLayoutFile.setIfeTswitijibrp("解約返戻金一時払保険料");
        bzHokenSyoukenLayoutFile.setIfeTswitijibrpt("解約返戻金一時払保険料(通貨型)");
        bzHokenSyoukenLayoutFile.setIfeTswyenhrkgktuktype("解約返戻金円貨払込額通貨タイプ");
        bzHokenSyoukenLayoutFile.setIfeTswyenhrkgk("解約返戻金円貨払込額");
        bzHokenSyoukenLayoutFile.setIfeTswyenhrkgkt("解約返戻金円貨払込額(通貨型)");
        bzHokenSyoukenLayoutFile.setIfeTswyenitijibrptuktype("解約返戻金円換算一時払保険料通貨タイプ");
        bzHokenSyoukenLayoutFile.setIfeTswyenitijibrp("解約返戻金円換算一時払保険料");
        bzHokenSyoukenLayoutFile.setIfeTswyenitijibrpt("解約返戻金円換算一時払保険料(通貨型)");
        bzHokenSyoukenLayoutFile.setIfeTskoujyosyoumeimsgcd1("控除証明説明メッセージコード１");
        bzHokenSyoukenLayoutFile.setIfeTskoujyosyoumeimsgcd2("控除証明説明メッセージコード２");
        bzHokenSyoukenLayoutFile.setIfeTskoujyosyoumeimsgcd3("控除証明説明メッセージコード３");
        bzHokenSyoukenLayoutFile.setIfeTskoujyosyoumeihskmsgcd("控除証明補足メッセージコード");
        bzHokenSyoukenLayoutFile.setIfeTsnenkoujyosyoumhskmsgcd("年間控除証明補足メッセージコード");
        bzHokenSyoukenLayoutFile.setIfeTstokusyusyorinaiyoukbn1("特殊処理内容区分１");
        bzHokenSyoukenLayoutFile.setIfeTstokusyusyorinaiyoukbn2("特殊処理内容区分２");
        bzHokenSyoukenLayoutFile.setIfeTstokusyusyorinaiyoukbn3("特殊処理内容区分３");
        bzHokenSyoukenLayoutFile.setIfeTstokusyusyorinaiyoukbn4("特殊処理内容区分４");
        bzHokenSyoukenLayoutFile.setIfeTstokusyusyorinaiyoukbn5("特殊処理内容区分５");
        bzHokenSyoukenLayoutFile.setIfeTstokusyusyorinaiyoukbn6("特殊処理内容区分６");
        bzHokenSyoukenLayoutFile.setIfeTstokusyusyorinaiyoukbn7("特殊処理内容区分７");
        bzHokenSyoukenLayoutFile.setIfeTstokusyusyorinaiyoukbn8("特殊処理内容区分８");
        bzHokenSyoukenLayoutFile.setIfeTstokusyusyorinaiyoukbn9("特殊処理内容区分９");
        bzHokenSyoukenLayoutFile.setIfeTstokusyusyorinaiyokbn10("特殊処理内容区分１０");
        bzHokenSyoukenLayoutFile.setIfeTstokusyusyorinaiyokbn11("特殊処理内容区分１１");
        bzHokenSyoukenLayoutFile.setIfeTstokusyusyorinaiyokbn12("特殊処理内容区分１２");
        bzHokenSyoukenLayoutFile.setIfeTstokusyusyorinaiyokbn13("特殊処理内容区分１３");
        bzHokenSyoukenLayoutFile.setIfeTstokusyusyorinaiyokbn14("特殊処理内容区分１４");
        bzHokenSyoukenLayoutFile.setIfeTstokusyusyorinaiyokbn15("特殊処理内容区分１５");
        bzHokenSyoukenLayoutFile.setIfeTstokusyusyorinaiyokbn16("特殊処理内容区分１６");
        bzHokenSyoukenLayoutFile.setIfeTstokusyusyorinaiyokbn17("特殊処理内容区分１７");
        bzHokenSyoukenLayoutFile.setIfeTsgyoumukousinkinou("業務用更新機能ＩＤ");
        bzHokenSyoukenLayoutFile.setIfeTsgyoumukousinsyaid("業務用更新者ＩＤ");
        bzHokenSyoukenLayoutFile.setIfeTsgyoumukousintime("業務用更新時間");
        bzHokenSyoukenLayoutFile.setIfeTskousinsyaid("更新者ＩＤ");
        bzHokenSyoukenLayoutFile.setIfeTskousintime("更新時間");
        bzHokenSyoukenLayoutFile.setIfeTskousinkinou("更新機能");
        bzHokenSyoukenLayoutFile.setIfeTsversion("バージョン");
        bzHokenSyoukenLayoutFile.setIfeTskyknmkn("契約者名（カナ）");
        bzHokenSyoukenLayoutFile.setIfeTshhknnmkn("被保険者名（カナ）");
        bzHokenSyoukenLayoutFile.setIfeTssntnyrnnkshrstartymd("その他内容欄年金支払開始日");
        bzHokenSyoukenLayoutFile.setIfeTssonotanyrannenkinkkn("その他内容欄年金期間");
        bzHokenSyoukenLayoutFile.setIfeTssntnyrnyensysnhkhnkymd("その他内容欄円建終身保険変更日");
        bzHokenSyoukenLayoutFile.setIfeTssntnyrntumitateriritu("その他内容欄積立利率");
        bzHokenSyoukenLayoutFile.setIfeTssntnyrntmttknzkrtjygn("その他内容欄積立金増加率上限");
        bzHokenSyoukenLayoutFile.setIfeTssntnyrnsetteibairitu("その他内容欄設定倍率");
        bzHokenSyoukenLayoutFile.setIfeTssntnyrntmttkngktuktype("その他内容欄積立金額通貨タイプ");
        bzHokenSyoukenLayoutFile.setIfeTssntnyrnteirittmttkngk("その他内容欄定率積立金額");
        bzHokenSyoukenLayoutFile.setIfeTssntnyrnteirittmttkngkt("その他内容欄定率積立金額(通貨型)");
        bzHokenSyoukenLayoutFile.setIfeTssntnyrnsisuutmttkngk("その他内容欄指数積立金額");
        bzHokenSyoukenLayoutFile.setIfeTssntnyrnsisuutmttkngkt("その他内容欄指数積立金額(通貨型)");
        bzHokenSyoukenLayoutFile.setIfeTssonotanyransisuunm("その他内容欄指数名");
        bzHokenSyoukenLayoutFile.setIfeTskgmhrtkd1hknkknmnryymd("介護前払特約第１保険期間満了日");
        bzHokenSyoukenLayoutFile.setIfeTsnkmsgcd1("年金メッセージコード１");
        bzHokenSyoukenLayoutFile.setIfeTsnkmsgcd2("年金メッセージコード２");
        bzHokenSyoukenLayoutFile.setIfeTsnkmsgcd3("年金メッセージコード３");
        bzHokenSyoukenLayoutFile.setIfeTsnkmsgcd4("年金メッセージコード４");
        bzHokenSyoukenLayoutFile.setIfeTsnkmsgcd5("年金メッセージコード５");
        bzHokenSyoukenLayoutFile.setIfeTsnkmsgcd6("年金メッセージコード６");
        bzHokenSyoukenLayoutFile.setIfeTsnkmsgcd7("年金メッセージコード７");
        bzHokenSyoukenLayoutFile.setIfeTsnkmsgcd8("年金メッセージコード８");
        bzHokenSyoukenLayoutFile.setIfeTsnkmsgcd9("年金メッセージコード９");
        bzHokenSyoukenLayoutFile.setIfeTsnkmsgcd10("年金メッセージコード１０");
        bzHokenSyoukenLayoutFile.setIfeTssiboukyuuhukinmsgcd1("死亡給付金メッセージコード１");
        bzHokenSyoukenLayoutFile.setIfeTssiboukyuuhukinmsgcd2("死亡給付金メッセージコード２");
        bzHokenSyoukenLayoutFile.setIfeTssiboukyuuhukinmsgcd3("死亡給付金メッセージコード３");
        bzHokenSyoukenLayoutFile.setIfeTssiboukyuuhukinmsgcd4("死亡給付金メッセージコード４");
        bzHokenSyoukenLayoutFile.setIfeTssiboukyuuhukinmsgcd5("死亡給付金メッセージコード５");
        bzHokenSyoukenLayoutFile.setIfeTssiboukyuuhukinmsgcd6("死亡給付金メッセージコード６");
        bzHokenSyoukenLayoutFile.setIfeTssiboukyuuhukinmsgcd7("死亡給付金メッセージコード７");
        bzHokenSyoukenLayoutFile.setIfeTssiboukyuuhukinmsgcd8("死亡給付金メッセージコード８");
        bzHokenSyoukenLayoutFile.setIfeTssiboukyuuhukinmsgcd9("死亡給付金メッセージコード９");
        bzHokenSyoukenLayoutFile.setIfeTssiboukyuuhukinmsgcd10("死亡給付金メッセージコード１０");
        bzHokenSyoukenLayoutFile.setIfeTsnkshrstartzenymd("年金支払開始日前日");
        bzHokenSyoukenLayoutFile.setIfeTsmkhyyennkhknhntktype("目標到達時円建年金保険変更特約目標額通貨タイプ");
        bzHokenSyoukenLayoutFile.setIfeTsmkhyyennkhknhntkmkhgk("目標到達時円建年金保険変更特約目標額");
        bzHokenSyoukenLayoutFile.setIfeTsmkhyyennkhknhntkmkhgkt("目標到達時円建年金保険変更特約目標額(通貨型)");
        bzHokenSyoukenLayoutFile.setIfeTsmkhyyennkhknhntkmkhwar("目標到達時円建年金保険変更特約目標割合");
        bzHokenSyoukenLayoutFile.setIfeTshaibunwarimsgcd1("配分割合メッセージコード１");
        bzHokenSyoukenLayoutFile.setIfeTshaibunwarimsgcd2("配分割合メッセージコード２");
        bzHokenSyoukenLayoutFile.setIfeTshaibunwarimsgcd3("配分割合メッセージコード３");
        bzHokenSyoukenLayoutFile.setIfeTsteiritutmtthbnwr("定率積立部分配分割合");
        bzHokenSyoukenLayoutFile.setIfeTssisuutmtthbnwr("指数積立部分配分割合");
        bzHokenSyoukenLayoutFile.setIfeTssisuuannaimsg1("指数案内メッセージコード１");
        bzHokenSyoukenLayoutFile.setIfeTssisuuannaimsg2("指数案内メッセージコード２");
        bzHokenSyoukenLayoutFile.setIfeTssisuuannaimsg3("指数案内メッセージコード３");
        bzHokenSyoukenLayoutFile.setIfeTshutanhiystmytijihiritu("ご負担費用説明欄予定維持費率");
        bzHokenSyoukenLayoutFile.setIfeTswmsgcd21("解約返戻金メッセージコード２＿１");
        bzHokenSyoukenLayoutFile.setIfeTswmsgcd22("解約返戻金メッセージコード２＿２");
        bzHokenSyoukenLayoutFile.setIfeTswmsgcd23("解約返戻金メッセージコード２＿３");
        bzHokenSyoukenLayoutFile.setIfeTswmsgcd31("解約返戻金メッセージコード３＿１");
        bzHokenSyoukenLayoutFile.setIfeTswmsgcd32("解約返戻金メッセージコード３＿２");
        bzHokenSyoukenLayoutFile.setIfeTswmsgcd33("解約返戻金メッセージコード３＿３");
        bzHokenSyoukenLayoutFile.setIfeTswmsgcdst1("解約返戻金メッセージコード表下１");
        bzHokenSyoukenLayoutFile.setIfeTswtyuuijikoumsgcd6("解約返戻金注意事項メッセージコード６");
        bzHokenSyoukenLayoutFile.setIfeTswtyuuijikoumsgcd7("解約返戻金注意事項メッセージコード７");
        bzHokenSyoukenLayoutFile.setIfeTstantocd("担当コード");

        return bzHokenSyoukenLayoutFile;
    }

    private BzItekiToukeiInfoLayoutFile setItekiToukeiInfoKoumokunm() {

        BzItekiToukeiInfoLayoutFile bzItekiToukeiInfoLayoutFile = SWAKInjector.getInstance(
            BzItekiToukeiInfoLayoutFile.class);
        bzItekiToukeiInfoLayoutFile.setIfeTssyono("証券番号");
        bzItekiToukeiInfoLayoutFile.setIfeTsketkekkacd("決定結果コード");
        bzItekiToukeiInfoLayoutFile.setIfeTspalketsyacd("ＰＡＬ決定者コード");
        bzItekiToukeiInfoLayoutFile.setIfeTskousinsyaid("更新者ＩＤ");
        bzItekiToukeiInfoLayoutFile.setIfeTskousintime("更新時間");
        bzItekiToukeiInfoLayoutFile.setIfeTskousinkinou("更新機能");
        bzItekiToukeiInfoLayoutFile.setIfeTsversion("バージョン");

        return bzItekiToukeiInfoLayoutFile;
    }

    private BzKhTtdkRirekiLayoutFile setKhTtdkRirekiKoumokunm() {

        BzKhTtdkRirekiLayoutFile bzKhTtdkRirekiLayoutFile = SWAKInjector.getInstance(BzKhTtdkRirekiLayoutFile.class);

        bzKhTtdkRirekiLayoutFile.setIfeTskbnkey("区分キー");
        bzKhTtdkRirekiLayoutFile.setIfeTssyono("証券番号");
        bzKhTtdkRirekiLayoutFile.setIfeTshenkousikibetukey("変更識別キー");
        bzKhTtdkRirekiLayoutFile.setIfeTssyoriymd("処理年月日");
        bzKhTtdkRirekiLayoutFile.setIfeTssyorisosikicd("処理組織コード");
        bzKhTtdkRirekiLayoutFile.setIfeTsshrsyousaiumu("支払詳細有無区分");
        bzKhTtdkRirekiLayoutFile.setIfeTssyorikbn("処理区分");
        bzKhTtdkRirekiLayoutFile.setIfeTshonninkakninkekkakbn("本人確認結果区分");
        bzKhTtdkRirekiLayoutFile.setIfeTshenkourrkumu("変更履歴有無");
        bzKhTtdkRirekiLayoutFile.setIfeTssmbckanriid("ＳＭＢＣ受付管理ＩＤ");
        bzKhTtdkRirekiLayoutFile.setIfeTsnayosekihontblskbtkey("名寄せ基本テーブル識別キー");
        bzKhTtdkRirekiLayoutFile.setIfeTskouteikanriid("工程管理ＩＤ");
        bzKhTtdkRirekiLayoutFile.setIfeTsyoukyuuno("要求通番");
        bzKhTtdkRirekiLayoutFile.setIfeTsgyoumukousinkinou("業務用更新機能ＩＤ");
        bzKhTtdkRirekiLayoutFile.setIfeTsgyoumukousinsyaid("業務用更新者ＩＤ");
        bzKhTtdkRirekiLayoutFile.setIfeTsgyoumukousintime("業務用更新時間");
        bzKhTtdkRirekiLayoutFile.setIfeTskousinsyaid("更新者ＩＤ");
        bzKhTtdkRirekiLayoutFile.setIfeTskousintime("更新時間");
        bzKhTtdkRirekiLayoutFile.setIfeTskousinkinou("更新機能");
        bzKhTtdkRirekiLayoutFile.setIfeTsversion("バージョン");

        return bzKhTtdkRirekiLayoutFile;
    }

    private BzKhTtdkTyuuiLayoutFile setKhTtdkTyuuiKoumokunm() {

        BzKhTtdkTyuuiLayoutFile bzKhTtdkTyuuiLayoutFile = SWAKInjector.getInstance(BzKhTtdkTyuuiLayoutFile.class);

        bzKhTtdkTyuuiLayoutFile.setIfeTskbnkey("区分キー");
        bzKhTtdkTyuuiLayoutFile.setIfeTssyono("証券番号");
        bzKhTtdkTyuuiLayoutFile.setIfeTsttdktyuuisetymd("手続注意設定日");
        bzKhTtdkTyuuiLayoutFile.setIfeTsttdktyuuisetnm("手続注意設定者名");
        bzKhTtdkTyuuiLayoutFile.setIfeTskktyuitakbn("契約管理注意取扱区分");
        bzKhTtdkTyuuiLayoutFile.setIfeTsttdktyuuinaiyou1("手続注意内容１");
        bzKhTtdkTyuuiLayoutFile.setIfeTsttdktyuuinaiyou2("手続注意内容２");
        bzKhTtdkTyuuiLayoutFile.setIfeTsttdktyuuinaiyou3("手続注意内容３");
        bzKhTtdkTyuuiLayoutFile.setIfeTsttdktyuuikbn1("手続注意区分１");
        bzKhTtdkTyuuiLayoutFile.setIfeTsttdktyuuikbn2("手続注意区分２");
        bzKhTtdkTyuuiLayoutFile.setIfeTsttdktyuuikbn3("手続注意区分３");
        bzKhTtdkTyuuiLayoutFile.setIfeTsttdktyuuikbn4("手続注意区分４");
        bzKhTtdkTyuuiLayoutFile.setIfeTsttdktyuuikbn5("手続注意区分５");
        bzKhTtdkTyuuiLayoutFile.setIfeTsttdktyuuikbnhsknaiyou1("手続注意区分補足内容１");
        bzKhTtdkTyuuiLayoutFile.setIfeTsttdktyuuikbnhsknaiyou2("手続注意区分補足内容２");
        bzKhTtdkTyuuiLayoutFile.setIfeTsttdktyuuikbnhsknaiyou3("手続注意区分補足内容３");
        bzKhTtdkTyuuiLayoutFile.setIfeTsttdktyuuikbnhsknaiyou4("手続注意区分補足内容４");
        bzKhTtdkTyuuiLayoutFile.setIfeTsttdktyuuikbnhsknaiyou5("手続注意区分補足内容５");
        bzKhTtdkTyuuiLayoutFile.setIfeTsttdktyuuikbnsetymd1("手続注意区分設定日１");
        bzKhTtdkTyuuiLayoutFile.setIfeTsttdktyuuikbnsetymd2("手続注意区分設定日２");
        bzKhTtdkTyuuiLayoutFile.setIfeTsttdktyuuikbnsetymd3("手続注意区分設定日３");
        bzKhTtdkTyuuiLayoutFile.setIfeTsttdktyuuikbnsetymd4("手続注意区分設定日４");
        bzKhTtdkTyuuiLayoutFile.setIfeTsttdktyuuikbnsetymd5("手続注意区分設定日５");
        bzKhTtdkTyuuiLayoutFile.setIfeTssetsosikicd1("設定組織コード１");
        bzKhTtdkTyuuiLayoutFile.setIfeTssetsosikicd2("設定組織コード２");
        bzKhTtdkTyuuiLayoutFile.setIfeTssetsosikicd3("設定組織コード３");
        bzKhTtdkTyuuiLayoutFile.setIfeTssetsosikicd4("設定組織コード４");
        bzKhTtdkTyuuiLayoutFile.setIfeTssetsosikicd5("設定組織コード５");
        bzKhTtdkTyuuiLayoutFile.setIfeTsgyoumukousinkinou("業務用更新機能ＩＤ");
        bzKhTtdkTyuuiLayoutFile.setIfeTsgyoumukousinsyaid("業務用更新者ＩＤ");
        bzKhTtdkTyuuiLayoutFile.setIfeTsgyoumukousintime("業務用更新時間");
        bzKhTtdkTyuuiLayoutFile.setIfeTskousinsyaid("更新者ＩＤ");
        bzKhTtdkTyuuiLayoutFile.setIfeTskousintime("更新時間");
        bzKhTtdkTyuuiLayoutFile.setIfeTskousinkinou("更新機能");
        bzKhTtdkTyuuiLayoutFile.setIfeTsversion("バージョン");
        bzKhTtdkTyuuiLayoutFile.setIfeTskykdrknhatudoujyoutai("契約者代理権発動状態");
        bzKhTtdkTyuuiLayoutFile.setIfeTskykdrdouiyouhi("契約者代理人同意要否");

        return bzKhTtdkTyuuiLayoutFile;
    }

    private BzKoujyoSymLayoutFile setKoujyoSymKoumokunm() {

        BzKoujyoSymLayoutFile bzKoujyoSymLayoutFile = SWAKInjector.getInstance(BzKoujyoSymLayoutFile.class);

        bzKoujyoSymLayoutFile.setIfeTskbnkey("区分キー");
        bzKoujyoSymLayoutFile.setIfeTssyono("証券番号");
        bzKoujyoSymLayoutFile.setIfeTsnendo("年度");
        bzKoujyoSymLayoutFile.setIfeTstyouhyouymd("帳票作成日");
        bzKoujyoSymLayoutFile.setIfeTsrenno("連番");
        bzKoujyoSymLayoutFile.setIfeTskjsmsakuseisyorikbn("控除証明作成処理区分");
        bzKoujyoSymLayoutFile.setIfeTstekiyouseidokbn("適用制度区分");
        bzKoujyoSymLayoutFile.setIfeTssyoumeiymd("証明日");
        bzKoujyoSymLayoutFile.setIfeTssyoumeistartym("証明開始年月");
        bzKoujyoSymLayoutFile.setIfeTssyoumeiendym("証明終了年月");
        bzKoujyoSymLayoutFile.setIfeTssyoumeikkntukisuu("証明期間月数");
        bzKoujyoSymLayoutFile.setIfeTssyoumeikknnensuu("証明期間年数");
        bzKoujyoSymLayoutFile.setIfeTskyknmkj("契約者名（漢字）");
        bzKoujyoSymLayoutFile.setIfeTsuktnmkjaddsama("受取人名（漢字／様付加）");
        bzKoujyoSymLayoutFile.setIfeTsnenkinuktseiymd("年金受取人生年月日");
        bzKoujyoSymLayoutFile.setIfeTshknsyuruinmrykkj("保険種類略称（漢字）");
        bzKoujyoSymLayoutFile.setIfeTskykymd("契約日");
        bzKoujyoSymLayoutFile.setIfeTshknkknsmnkbnsyu("保険期間歳満期区分（主契約）");
        bzKoujyoSymLayoutFile.setIfeTshknkknsyu("保険期間（主契約）");
        bzKoujyoSymLayoutFile.setIfeTsnenkanhrkkaisuu("年間払込回数");
        bzKoujyoSymLayoutFile.setIfeTsphrkkkn("保険料払込期間");
        bzKoujyoSymLayoutFile.setIfeTsnkshrstartymd("年金支払開始日");
        bzKoujyoSymLayoutFile.setIfeTsnknshry("年金支払期間");
        bzKoujyoSymLayoutFile.setIfeTskykjyoutai("契約状態");
        bzKoujyoSymLayoutFile.setIfeTsyuukousyoumetukbn("有効消滅区分");
        bzKoujyoSymLayoutFile.setIfeTshaitoukinuketorihoukbn("配当金受取方法区分");
        bzKoujyoSymLayoutFile.setIfeTsoldippanjissekip("旧制度一般実績保険料");
        bzKoujyoSymLayoutFile.setIfeTsoldippanjissekipt("旧制度一般実績保険料(通貨型)");
        bzKoujyoSymLayoutFile.setIfeTsoldippannenkanp("旧制度一般年間保険料");
        bzKoujyoSymLayoutFile.setIfeTsoldippannenkanpt("旧制度一般年間保険料(通貨型)");
        bzKoujyoSymLayoutFile.setIfeTsoldippanjissekihtkin("旧制度一般実績配当金");
        bzKoujyoSymLayoutFile.setIfeTsoldippanjissekihtkint("旧制度一般実績配当金(通貨型)");
        bzKoujyoSymLayoutFile.setIfeTsoldippannenkanhtkin("旧制度一般年間配当金");
        bzKoujyoSymLayoutFile.setIfeTsoldippannenkanhtkint("旧制度一般年間配当金(通貨型)");
        bzKoujyoSymLayoutFile.setIfeTsoldippanjissekisymgk("旧制度一般実績証明額");
        bzKoujyoSymLayoutFile.setIfeTsoldippanjissekisymgkt("旧制度一般実績証明額(通貨型)");
        bzKoujyoSymLayoutFile.setIfeTsoldippannenkansymgk("旧制度一般年間証明額");
        bzKoujyoSymLayoutFile.setIfeTsoldippannenkansymgkt("旧制度一般年間証明額(通貨型)");
        bzKoujyoSymLayoutFile.setIfeTsnewippanjissekip("新制度一般実績保険料");
        bzKoujyoSymLayoutFile.setIfeTsnewippanjissekipt("新制度一般実績保険料(通貨型)");
        bzKoujyoSymLayoutFile.setIfeTsnewippannenkanp("新制度一般年間保険料");
        bzKoujyoSymLayoutFile.setIfeTsnewippannenkanpt("新制度一般年間保険料(通貨型)");
        bzKoujyoSymLayoutFile.setIfeTsnewippanjissekihtkin("新制度一般実績配当金");
        bzKoujyoSymLayoutFile.setIfeTsnewippanjissekihtkint("新制度一般実績配当金(通貨型)");
        bzKoujyoSymLayoutFile.setIfeTsnewippannenkanhtkin("新制度一般年間配当金");
        bzKoujyoSymLayoutFile.setIfeTsnewippannenkanhtkint("新制度一般年間配当金(通貨型)");
        bzKoujyoSymLayoutFile.setIfeTsnewippanjissekisymgk("新制度一般実績証明額");
        bzKoujyoSymLayoutFile.setIfeTsnewippanjissekisymgkt("新制度一般実績証明額(通貨型)");
        bzKoujyoSymLayoutFile.setIfeTsnewippannenkansymgk("新制度一般年間証明額");
        bzKoujyoSymLayoutFile.setIfeTsnewippannenkansymgkt("新制度一般年間証明額(通貨型)");
        bzKoujyoSymLayoutFile.setIfeTsnewiryoujissekip("新制度介護医療実績保険料");
        bzKoujyoSymLayoutFile.setIfeTsnewiryoujissekipt("新制度介護医療実績保険料(通貨型)");
        bzKoujyoSymLayoutFile.setIfeTsnewiryounenkanp("新制度介護医療年間保険料");
        bzKoujyoSymLayoutFile.setIfeTsnewiryounenkanpt("新制度介護医療年間保険料(通貨型)");
        bzKoujyoSymLayoutFile.setIfeTsnewiryoujissekihtkin("新制度介護医療実績配当金");
        bzKoujyoSymLayoutFile.setIfeTsnewiryoujissekihtkint("新制度介護医療実績配当金(通貨型)");
        bzKoujyoSymLayoutFile.setIfeTsnewiryounenkanhtkin("新制度介護医療年間配当金");
        bzKoujyoSymLayoutFile.setIfeTsnewiryounenkanhtkint("新制度介護医療年間配当金(通貨型)");
        bzKoujyoSymLayoutFile.setIfeTsnewiryoujissekisymgk("新制度介護医療実績証明額");
        bzKoujyoSymLayoutFile.setIfeTsnewiryoujissekisymgkt("新制度介護医療実績証明額(通貨型)");
        bzKoujyoSymLayoutFile.setIfeTsnewiryounenkansymgk("新制度介護医療年間証明額");
        bzKoujyoSymLayoutFile.setIfeTsnewiryounenkansymgkt("新制度介護医療年間証明額(通貨型)");
        bzKoujyoSymLayoutFile.setIfeTsnewnkjissekip("新制度年金実績保険料");
        bzKoujyoSymLayoutFile.setIfeTsnewnkjissekipt("新制度年金実績保険料(通貨型)");
        bzKoujyoSymLayoutFile.setIfeTsnewnknenkanp("新制度年金年間保険料");
        bzKoujyoSymLayoutFile.setIfeTsnewnknenkanpt("新制度年金年間保険料(通貨型)");
        bzKoujyoSymLayoutFile.setIfeTsnewnkjissekihaitoukin("新制度年金実績配当金");
        bzKoujyoSymLayoutFile.setIfeTsnewnkjissekihaitoukint("新制度年金実績配当金(通貨型)");
        bzKoujyoSymLayoutFile.setIfeTsnewnknenkanhaitoukin("新制度年金年間配当金");
        bzKoujyoSymLayoutFile.setIfeTsnewnknenkanhaitoukint("新制度年金年間配当金(通貨型)");
        bzKoujyoSymLayoutFile.setIfeTsnewnkjissekisyoumeigk("新制度年金実績証明額");
        bzKoujyoSymLayoutFile.setIfeTsnewnkjissekisyoumeigkt("新制度年金実績証明額(通貨型)");
        bzKoujyoSymLayoutFile.setIfeTsnewnknenkansyoumeigk("新制度年金年間証明額");
        bzKoujyoSymLayoutFile.setIfeTsnewnknenkansyoumeigkt("新制度年金年間証明額(通貨型)");
        bzKoujyoSymLayoutFile.setIfeTskjnnkkoujyum("個人年金控除有無");
        bzKoujyoSymLayoutFile.setIfeTstsinyno("通信先郵便番号");
        bzKoujyoSymLayoutFile.setIfeTstsinadr1kj("通信先住所１（漢字）");
        bzKoujyoSymLayoutFile.setIfeTstsinadr2kj("通信先住所２（漢字）");
        bzKoujyoSymLayoutFile.setIfeTstsinadr3kj("通信先住所３（漢字）");
        bzKoujyoSymLayoutFile.setIfeTstoiawasesosikinmkj("問合せ先組織名（漢字）");
        bzKoujyoSymLayoutFile.setIfeTstoiawaseyno("問合せ先郵便番号");
        bzKoujyoSymLayoutFile.setIfeTstoiawaseadr1kj("問合せ先住所１（漢字）");
        bzKoujyoSymLayoutFile.setIfeTstoiawaseadr2kj("問合せ先住所２（漢字）");
        bzKoujyoSymLayoutFile.setIfeTstoiawaseadr3kj("問合せ先住所３（漢字）");
        bzKoujyoSymLayoutFile.setIfeTstoiawasetelno("問合せ先電話番号");
        bzKoujyoSymLayoutFile.setIfeTstoiawaseteluktkkanou1("問合せ先電話受付可能時間１");
        bzKoujyoSymLayoutFile.setIfeTstoiawaseteluktkkanou2("問合せ先電話受付可能時間２");
        bzKoujyoSymLayoutFile.setIfeTstoiawasesosikinmkj2("第２問合せ先組織名（漢字）");
        bzKoujyoSymLayoutFile.setIfeTstoiawasetelno2("第２問合せ先電話番号");
        bzKoujyoSymLayoutFile.setIfeTshassoukbn("発送区分");
        bzKoujyoSymLayoutFile.setIfeTsdrtencd("代理店コード");
        bzKoujyoSymLayoutFile.setIfeTsdrtennmkj("代理店名（漢字）");
        bzKoujyoSymLayoutFile.setIfeTshengakuumu("変額保険有無");
        bzKoujyoSymLayoutFile.setIfeTsnewsyoumeigkumukbn("新制度証明額有無区分");
        bzKoujyoSymLayoutFile.setIfeTsgyoumukousinkinou("業務用更新機能ＩＤ");
        bzKoujyoSymLayoutFile.setIfeTsgyoumukousinsyaid("業務用更新者ＩＤ");
        bzKoujyoSymLayoutFile.setIfeTsgyoumukousintime("業務用更新時間");
        bzKoujyoSymLayoutFile.setIfeTskousinsyaid("更新者ＩＤ");
        bzKoujyoSymLayoutFile.setIfeTskousintime("更新時間");
        bzKoujyoSymLayoutFile.setIfeTskousinkinou("更新機能");
        bzKoujyoSymLayoutFile.setIfeTsversion("バージョン");
        bzKoujyoSymLayoutFile.setIfeTskoujyosyoumeisentkkbn("控除証明選択区分");
        bzKoujyoSymLayoutFile.setIfeTskyknmkn("契約者名（カナ）");
        bzKoujyoSymLayoutFile.setIfeTsuktnmkn("受取人名（カナ）");
        bzKoujyoSymLayoutFile.setIfeTssaihkhyjkbn("再発行表示区分");

        return bzKoujyoSymLayoutFile;
    }

    private BzKoujyoSymKanriLayoutFile setKoujyoSymKanriKoumokunm() {

        BzKoujyoSymKanriLayoutFile bzKoujyoSymKanriLayoutFile = SWAKInjector.getInstance(
            BzKoujyoSymKanriLayoutFile.class);

        bzKoujyoSymKanriLayoutFile.setIfeTskbnkey("区分キー");
        bzKoujyoSymKanriLayoutFile.setIfeTssyono("証券番号");
        bzKoujyoSymKanriLayoutFile.setIfeTsnendo("年度");
        bzKoujyoSymKanriLayoutFile.setIfeTslastsyoumeiendym("最終証明終了年月");
        bzKoujyoSymKanriLayoutFile.setIfeTsgyoumukousinkinou("業務用更新機能ＩＤ");
        bzKoujyoSymKanriLayoutFile.setIfeTsgyoumukousinsyaid("業務用更新者ＩＤ");
        bzKoujyoSymKanriLayoutFile.setIfeTsgyoumukousintime("業務用更新時間");
        bzKoujyoSymKanriLayoutFile.setIfeTskousinsyaid("更新者ＩＤ");
        bzKoujyoSymKanriLayoutFile.setIfeTskousintime("更新時間");
        bzKoujyoSymKanriLayoutFile.setIfeTskousinkinou("更新機能");
        bzKoujyoSymKanriLayoutFile.setIfeTsversion("バージョン");

        return bzKoujyoSymKanriLayoutFile;
    }

    private BzKoujyoSymNaiyouLayoutFile setKoujyoSymNaiyouKoumokunm() {

        BzKoujyoSymNaiyouLayoutFile bzKoujyoSymNaiyouLayoutFile = SWAKInjector.getInstance(
            BzKoujyoSymNaiyouLayoutFile.class);

        bzKoujyoSymNaiyouLayoutFile.setIfeTskbnkey("区分キー");
        bzKoujyoSymNaiyouLayoutFile.setIfeTssyono("証券番号");
        bzKoujyoSymNaiyouLayoutFile.setIfeTssyouhncd("商品コード");
        bzKoujyoSymNaiyouLayoutFile.setIfeTsrenno3keta("連番（３桁）");
        bzKoujyoSymNaiyouLayoutFile.setIfeTskoujyosyoumeinnd("控除証明年度");
        bzKoujyoSymNaiyouLayoutFile.setIfeTssyoumeistartym("証明開始年月");
        bzKoujyoSymNaiyouLayoutFile.setIfeTssyoumeiendym("証明終了年月");
        bzKoujyoSymNaiyouLayoutFile.setIfeTskoujyosyoumeipkbn("控除証明保険料区分");
        bzKoujyoSymNaiyouLayoutFile.setIfeTstekiyouseidokbn("適用制度区分");
        bzKoujyoSymNaiyouLayoutFile.setIfeTskoujyosymnaiyoureckbn("控除証明内容レコード区分");
        bzKoujyoSymNaiyouLayoutFile.setIfeTskoujyosyoumeigk("控除証明額");
        bzKoujyoSymNaiyouLayoutFile.setIfeTskoujyosyoumeigkt("控除証明額(通貨型)");
        bzKoujyoSymNaiyouLayoutFile.setIfeTsjyutoustartym("充当開始年月");
        bzKoujyoSymNaiyouLayoutFile.setIfeTsnyknjskrrkrenno("入金実績履歴連番");
        bzKoujyoSymNaiyouLayoutFile.setIfeTskihrkpssrrkrenno("既払込Ｐ精算履歴連番");
        bzKoujyoSymNaiyouLayoutFile.setIfeTskjsmhakkouzumiflg("控除証明書発行済フラグ");
        bzKoujyoSymNaiyouLayoutFile.setIfeTsgyoumukousinkinou("業務用更新機能ＩＤ");
        bzKoujyoSymNaiyouLayoutFile.setIfeTsgyoumukousinsyaid("業務用更新者ＩＤ");
        bzKoujyoSymNaiyouLayoutFile.setIfeTsgyoumukousintime("業務用更新時間");
        bzKoujyoSymNaiyouLayoutFile.setIfeTskousinsyaid("更新者ＩＤ");
        bzKoujyoSymNaiyouLayoutFile.setIfeTskousintime("更新時間");
        bzKoujyoSymNaiyouLayoutFile.setIfeTskousinkinou("更新機能");
        bzKoujyoSymNaiyouLayoutFile.setIfeTsversion("バージョン");
        bzKoujyoSymNaiyouLayoutFile.setIfeTssakujyoflg("削除フラグ");
        bzKoujyoSymNaiyouLayoutFile.setIfeTszennoukaisiymd("前納開始年月日");
        bzKoujyoSymNaiyouLayoutFile.setIfeTszennourenno("前納連番");
        bzKoujyoSymNaiyouLayoutFile.setIfeTskeisanhukahyoujikbn("計算不可表示区分");
        bzKoujyoSymNaiyouLayoutFile.setIfeTskeisanhukariyuucd("計算不可理由コード");

        return bzKoujyoSymNaiyouLayoutFile;
    }

    private BzKykDairitenLayoutFile setKykDairitenKoumokunm() {

        BzKykDairitenLayoutFile bzKykDairitenLayoutFile = SWAKInjector.getInstance(BzKykDairitenLayoutFile.class);

        bzKykDairitenLayoutFile.setIfeTskbnkey("区分キー");
        bzKykDairitenLayoutFile.setIfeTssyono("証券番号");
        bzKykDairitenLayoutFile.setIfeTsdrtenrenno("代理店連番");
        bzKykDairitenLayoutFile.setIfeTsdrtencd("代理店コード");
        bzKykDairitenLayoutFile.setIfeTsdrtenkanrisosikicd("代理店管理組織コード");
        bzKykDairitenLayoutFile.setIfeTsgyousekikjysksosikicd("業績計上先組織コード");
        bzKykDairitenLayoutFile.setIfeTsoyadrtencd("親代理店コード");
        bzKykDairitenLayoutFile.setIfeTsbosyuucd("募集人コード");
        bzKykDairitenLayoutFile.setIfeTsdaibosyuucd("代表募集人コード");
        bzKykDairitenLayoutFile.setIfeTsdrtenbunumu("代理店分担有無");
        bzKykDairitenLayoutFile.setIfeTskanjidrtflg("幹事代理店フラグ");
        bzKykDairitenLayoutFile.setIfeTsbunwari("分担割合");
        bzKykDairitenLayoutFile.setIfeTsikanymd("移管日");
        bzKykDairitenLayoutFile.setIfeTsbsyujoyadrtencd("募集時親代理店コード");
        bzKykDairitenLayoutFile.setIfeTsbsyujdrtencd("募集時代理店コード");
        bzKykDairitenLayoutFile.setIfeTsbsyujbosyuutrkno("募集時募集人登録番号");
        bzKykDairitenLayoutFile.setIfeTsgyoumukousinkinou("業務用更新機能ＩＤ");
        bzKykDairitenLayoutFile.setIfeTsgyoumukousinsyaid("業務用更新者ＩＤ");
        bzKykDairitenLayoutFile.setIfeTsgyoumukousintime("業務用更新時間");
        bzKykDairitenLayoutFile.setIfeTskousinsyaid("更新者ＩＤ");
        bzKykDairitenLayoutFile.setIfeTskousintime("更新時間");
        bzKykDairitenLayoutFile.setIfeTskousinkinou("更新機能");
        bzKykDairitenLayoutFile.setIfeTsversion("バージョン");

        return bzKykDairitenLayoutFile;

    }

    private BzKykKihonLayoutFile setKykKihonKoumokunm() {

        BzKykKihonLayoutFile bzKykKihonLayoutFile = SWAKInjector.getInstance(BzKykKihonLayoutFile.class);

        bzKykKihonLayoutFile.setIfeTskbnkey("区分キー");
        bzKykKihonLayoutFile.setIfeTssyono("証券番号");
        bzKykKihonLayoutFile.setIfeTsaitesyono("相手証券番号");
        bzKykKihonLayoutFile.setIfeTshaitoukbn("配当区分");
        bzKykKihonLayoutFile.setIfeTshrkkaisuu("払込回数");
        bzKykKihonLayoutFile.setIfeTshrkkeiro("払込経路");
        bzKykKihonLayoutFile.setIfeTssdpdkbn("Ｓ建Ｐ建区分");
        bzKykKihonLayoutFile.setIfeTsdntryouritukbn("団体料率区分");
        bzKykKihonLayoutFile.setIfeTsdntcd("団体コード");
        bzKykKihonLayoutFile.setIfeTssntkhoukbn("選択方法区分");
        bzKykKihonLayoutFile.setIfeTssinsakbn("診査区分");
        bzKykKihonLayoutFile.setIfeTsmosymd("申込日");
        bzKykKihonLayoutFile.setIfeTskktymd("告知日");
        bzKykKihonLayoutFile.setIfeTsfstpnyknymd("初回保険料入金日");
        bzKykKihonLayoutFile.setIfeTsmosukeymd("申込書受付日");
        bzKykKihonLayoutFile.setIfeTsmosjimosuktymd("申込時申込書受付日");
        bzKykKihonLayoutFile.setIfeTsseirituymd("成立日");
        bzKykKihonLayoutFile.setIfeTsitiprsymd("１Ｐ領収予定日");
        bzKykKihonLayoutFile.setIfeTshrkp("払込保険料");
        bzKykKihonLayoutFile.setIfeTshrkpt("払込保険料(通貨型)");
        bzKykKihonLayoutFile.setIfeTsbosyuuym("募集年月");
        bzKykKihonLayoutFile.setIfeTsseisekiym("成績計上年月");
        bzKykKihonLayoutFile.setIfeTsskeikeijyouym("新契約計上年月");
        bzKykKihonLayoutFile.setIfeTsplancd("プランコード");
        bzKykKihonLayoutFile.setIfeTsplanrenno("プラン連番");
        bzKykKihonLayoutFile.setIfeTsaisyoumeikbn("愛称名区分");
        bzKykKihonLayoutFile.setIfeTssyusaiumu("出再有無");
        bzKykKihonLayoutFile.setIfeTsstknsetkbn("質権設定区分");
        bzKykKihonLayoutFile.setIfeTskykksykjyumu("契約者貸付約定有無");
        bzKykKihonLayoutFile.setIfeTskykksumu("契約者貸付有無");
        bzKykKihonLayoutFile.setIfeTsaplkahikbn("ＡＰＬ可否区分");
        bzKykKihonLayoutFile.setIfeTsaplumu("ＡＰＬ有無");
        bzKykKihonLayoutFile.setIfeTsfstphrkkeirokbn("初回保険料払込経路区分");
        bzKykKihonLayoutFile.setIfeTshaitounendo("配当年度");
        bzKykKihonLayoutFile.setIfeTshaitoukinuketorihoukbn("配当金受取方法区分");
        bzKykKihonLayoutFile.setIfeTstratkityuiumu("取扱注意有無");
        bzKykKihonLayoutFile.setIfeTstratkityuiuny("取扱注意内容");
        bzKykKihonLayoutFile.setIfeTssbuktnin("死亡受取人人数");
        bzKykKihonLayoutFile.setIfeTsgansindankakuteiymd("がん診断確定日");
        bzKykKihonLayoutFile.setIfeTsmosuketukekbn("申込受付区分");
        bzKykKihonLayoutFile.setIfeTskijikbn("記事区分");
        bzKykKihonLayoutFile.setIfeTshhknsykgycd("被保険者職業コード");
        bzKykKihonLayoutFile.setIfeTshhknnensyuukbn("被保険者年収区分");
        bzKykKihonLayoutFile.setIfeTsdrtenkanritodoufukencd("代理店管理都道府県コード");
        bzKykKihonLayoutFile.setIfeTscifcd("ＣＩＦコード");
        bzKykKihonLayoutFile.setIfeTssmbckanriid("ＳＭＢＣ受付管理ＩＤ");
        bzKykKihonLayoutFile.setIfeTstsryhshrkykumukbn("手数料不支払契約有無区分");
        bzKykKihonLayoutFile.setIfeTskykhonninkknnsyrkbn("契約者本人確認書類区分");
        bzKykKihonLayoutFile.setIfeTsskskknhonninkknnsyrkbn("親権者後見人本人確認書類区分");
        bzKykKihonLayoutFile.setIfeTsboskykjyoutai("募集契約状態");
        bzKykKihonLayoutFile.setIfeTskanyuusyano("加入者番号");
        bzKykKihonLayoutFile.setIfeTsdrctservicemoskbn("ダイレクトサービス申込区分");
        bzKykKihonLayoutFile.setIfeTssksyoukenskskbn("新契約証券作成区分");
        bzKykKihonLayoutFile.setIfeTssinkyksyokensakuseiymd("新契約証券作成日");
        bzKykKihonLayoutFile.setIfeTssyoyousinkyksyohakkymd("証券用新契約証券発行日");
        bzKykKihonLayoutFile.setIfeTsskjmosno("新契約時申込番号");
        bzKykKihonLayoutFile.setIfeTsnkuikosumikbn("年金移行済区分");
        bzKykKihonLayoutFile.setIfeTssyhenkouymd("最終変更日");
        bzKykKihonLayoutFile.setIfeTslastsyosaihkymd("最終証券再発行日");
        bzKykKihonLayoutFile.setIfeTslastmeihenymd("最終名義変更日");
        bzKykKihonLayoutFile.setIfeTslastkykmeighnkymd("最終契約者名義変更日");
        bzKykKihonLayoutFile.setIfeTslastsbukthenymd("最終死亡受取人変更日");
        bzKykKihonLayoutFile.setIfeTslastkyknmseiymdhenkymd("最終契約者名生年月日変更日");
        bzKykKihonLayoutFile.setIfeTslastkyknmkanakjteiymd("最終契約者名仮名漢字訂正日");
        bzKykKihonLayoutFile.setIfeTslasttsinynohenkouymd("最終通信先郵便番号変更日");
        bzKykKihonLayoutFile.setIfeTslastjyuuhenymd("最終住所変更日");
        bzKykKihonLayoutFile.setIfeTsgyoumukousinkinou("業務用更新機能ＩＤ");
        bzKykKihonLayoutFile.setIfeTsgyoumukousinsyaid("業務用更新者ＩＤ");
        bzKykKihonLayoutFile.setIfeTsgyoumukousintime("業務用更新時間");
        bzKykKihonLayoutFile.setIfeTskousinsyaid("更新者ＩＤ");
        bzKykKihonLayoutFile.setIfeTskousintime("更新時間");
        bzKykKihonLayoutFile.setIfeTskousinkinou("更新機能");
        bzKykKihonLayoutFile.setIfeTsversion("バージョン");

        bzKykKihonLayoutFile.setIfeTsseiritujitrhkjikakkbn("成立時取引時確認区分");
        bzKykKihonLayoutFile.setIfeTstikiktbrisyuruikbn("定期一括払種類区分");
        bzKykKihonLayoutFile.setIfeTsyakkanjyuryouhoukbn("約款受領方法区分");
        bzKykKihonLayoutFile.setIfeTsyakkanbunsyono("約款文書番号");
        bzKykKihonLayoutFile.setIfeTssiorino("しおり番号");

        return bzKykKihonLayoutFile;

    }

    private BzKykSonotaTkykLayoutFile setKykSonotaTkykKoumokunm() {

        BzKykSonotaTkykLayoutFile bzKykSonotaTkykLayoutFile = SWAKInjector.getInstance(BzKykSonotaTkykLayoutFile.class);

        bzKykSonotaTkykLayoutFile.setIfeTskbnkey("区分キー");
        bzKykSonotaTkykLayoutFile.setIfeTssyono("証券番号");
        bzKykSonotaTkykLayoutFile.setIfeTslivingneedshukaumu("リビングニーズ特約付加有無");
        bzKykSonotaTkykLayoutFile.setIfeTsstdrsktkyhkumu("指定代理請求特約付加有無");
        bzKykSonotaTkykLayoutFile.setIfeTsstdrsktkyhkymd("指定代理請求特約付加日");
        bzKykSonotaTkykLayoutFile.setIfeTsyennykntkhkumu("円入金特約付加有無");
        bzKykSonotaTkykLayoutFile.setIfeTsgaikanykntkhkumu("外貨入金特約付加有無");
        bzKykSonotaTkykLayoutFile.setIfeTsyenshrtkhkumu("円支払特約付加有無");
        bzKykSonotaTkykLayoutFile.setIfeTsyenshrkykkykhenkoymd("円支払特約契約変更日");
        bzKykSonotaTkykLayoutFile.setIfeTsnkgkkateitkumu("年金額確定特約有無");
        bzKykSonotaTkykLayoutFile.setIfeTsnksgkhosyuwari("年金総額保証割合");
        bzKykSonotaTkykLayoutFile.setIfeTsskjbrnktsumu("即時払年金特則有無");
        bzKykSonotaTkykLayoutFile.setIfeTsnenkingaku8waritkumu("年金額８割保証特約有無");
        bzKykSonotaTkykLayoutFile.setIfeTsnenkingaku9waritkumu("年金額９割保証特約有無");
        bzKykSonotaTkykLayoutFile.setIfeTsnkyentkhukaumu("年金円支払特約付加有無");
        bzKykSonotaTkykLayoutFile.setIfeTskwsttkhukaumu("為替ターゲット特約付加有無");
        bzKykSonotaTkykLayoutFile.setIfeTskwstargetrate("為替ターゲットレート");
        bzKykSonotaTkykLayoutFile.setIfeTstargettkhkumu("ターゲット特約付加有無");
        bzKykSonotaTkykLayoutFile.setIfeTstargettkykkykhenkoymd("ターゲット特約契約変更日");
        bzKykSonotaTkykLayoutFile.setIfeTstargettkkbn("ターゲット特約区分");
        bzKykSonotaTkykLayoutFile.setIfeTstargettkmokuhyouti("ターゲット特約目標値");
        bzKykSonotaTkykLayoutFile.setIfeTsysknkshtkumu("新遺族年金支払特約有無");
        bzKykSonotaTkykLayoutFile.setIfeTspmnjtkkbn("保険料免除特約区分");
        bzKykSonotaTkykLayoutFile.setIfeTspmnjtkkykymd("保険料免除特約契約日");
        bzKykSonotaTkykLayoutFile.setIfeTspmnjtksknnkaisiymd("保険料免除特約責任開始日");
        bzKykSonotaTkykLayoutFile.setIfeTspmnjtkgansknnkaisiymd("保険料免除特約がん責任開始日");
        bzKykSonotaTkykLayoutFile.setIfeTspmhktsknnkaisiymd("保険料免除特約復活責任開始日");
        bzKykSonotaTkykLayoutFile.setIfeTspmnjhktgansknnkaisiymd("保険料免除特約復活がん責任開始日");
        bzKykSonotaTkykLayoutFile.setIfeTspmnjtkhtnpbuicd1("保険料免除特約不担保部位コード１");
        bzKykSonotaTkykLayoutFile.setIfeTspmnjtkhtnpkkn1("保険料免除特約不担保期間１");
        bzKykSonotaTkykLayoutFile.setIfeTspmnjtkhtnpbuicd2("保険料免除特約不担保部位コード２");
        bzKykSonotaTkykLayoutFile.setIfeTspmnjtkhtnpkkn2("保険料免除特約不担保期間２");
        bzKykSonotaTkykLayoutFile.setIfeTspmnjtkhtnpbuicd3("保険料免除特約不担保部位コード３");
        bzKykSonotaTkykLayoutFile.setIfeTspmnjtkhtnpkkn3("保険料免除特約不担保期間３");
        bzKykSonotaTkykLayoutFile.setIfeTspmnjtkhtnpbuicd4("保険料免除特約不担保部位コード４");
        bzKykSonotaTkykLayoutFile.setIfeTspmnjtkhtnpkkn4("保険料免除特約不担保期間４");
        bzKykSonotaTkykLayoutFile.setIfeTspmnjtokkoudosghtnpkbn("保険料免除特約特定高度障害不担保区分");
        bzKykSonotaTkykLayoutFile.setIfeTssknnkaisikitkkbn("責任開始期特約区分");
        bzKykSonotaTkykLayoutFile.setIfeTsnstkhkumu("年金支払特約付加有無");
        bzKykSonotaTkykLayoutFile.setIfeTsnkshrtkykhenkoymd("年金支払特約契約変更日");
        bzKykSonotaTkykLayoutFile.setIfeTsnkshrtkyknksyukbn("年金支払特約年金種類区分");
        bzKykSonotaTkykLayoutFile.setIfeTsnkshrtkyknksyukkn("年金支払特約年金期間");
        bzKykSonotaTkykLayoutFile.setIfeTsinitsbjyensthsytkhkumu("初期死亡時円換算最低保証特約付加有無");
        bzKykSonotaTkykLayoutFile.setIfeTsinitsbjiyenkasthsygk("初期死亡時円換算最低保証額");
        bzKykSonotaTkykLayoutFile.setIfeTsinitsbjiyenkasthsygkt("初期死亡時円換算最低保証額(通貨型)");
        bzKykSonotaTkykLayoutFile.setIfeTsjydkgomeharaitkhukaumu("重度介護前払特約付加有無");
        bzKykSonotaTkykLayoutFile.setIfeTsjydkgomeharaitkhukaymd("重度介護前払特約付加日");
        bzKykSonotaTkykLayoutFile.setIfeTsgyoumukousinkinou("業務用更新機能ＩＤ");
        bzKykSonotaTkykLayoutFile.setIfeTsgyoumukousinsyaid("業務用更新者ＩＤ");
        bzKykSonotaTkykLayoutFile.setIfeTsgyoumukousintime("業務用更新時間");
        bzKykSonotaTkykLayoutFile.setIfeTskousinsyaid("更新者ＩＤ");
        bzKykSonotaTkykLayoutFile.setIfeTskousintime("更新時間");
        bzKykSonotaTkykLayoutFile.setIfeTskousinkinou("更新機能");
        bzKykSonotaTkykLayoutFile.setIfeTsversion("バージョン");
        bzKykSonotaTkykLayoutFile.setIfeTstargettkykhkymd("ターゲット特約付加日");
        bzKykSonotaTkykLayoutFile.setIfeTstargettkykkijyungk("ターゲット特約基準金額");
        bzKykSonotaTkykLayoutFile.setIfeTstargettkykkijyungkt("ターゲット特約基準金額(通貨型)");
        bzKykSonotaTkykLayoutFile.setIfeTszeiseitkkktkykhukaumu("税制適格特約付加有無");
        bzKykSonotaTkykLayoutFile.setIfeTszeiseitkkktkykhukaymd("税制適格特約付加日");
        bzKykSonotaTkykLayoutFile.setIfeTszeiseitkkktkyksymtymd("税制適格特約消滅日");
        bzKykSonotaTkykLayoutFile.setIfeTsyennyknsyuruikbn("円入金特約種類区分");
        bzKykSonotaTkykLayoutFile.setIfeTskykdrtkykhukaumu("契約者代理特約付加有無");
        bzKykSonotaTkykLayoutFile.setIfeTskykdrtkykhukaymd("契約者代理特約付加日");
        bzKykSonotaTkykLayoutFile.setIfeTskykdrtkykkaiyakuymd("契約者代理特約解約日");
        bzKykSonotaTkykLayoutFile.setIfeTsteikishrtkykhukaumu("定期支払特約付加有無");
        bzKykSonotaTkykLayoutFile.setIfeTsteikishrkinshrtuukasyu("定期支払金支払通貨種類");
        bzKykSonotaTkykLayoutFile.setIfeTsteikishrkinshrmd("定期支払金支払月日");

        return bzKykSonotaTkykLayoutFile;
    }

    private BzKykSyaLayoutFile setKykSyaKoumokunm() {

        BzKykSyaLayoutFile bzKykSyaLayoutFile = SWAKInjector.getInstance(BzKykSyaLayoutFile.class);

        bzKykSyaLayoutFile.setIfeTskbnkey("区分キー");
        bzKykSyaLayoutFile.setIfeTssyono("証券番号");
        bzKykSyaLayoutFile.setIfeTskokno("顧客番号");
        bzKykSyaLayoutFile.setIfeTskyksakuinmeino("契約者索引名番号");
        bzKykSyaLayoutFile.setIfeTskyknmkn("契約者名（カナ）");
        bzKykSyaLayoutFile.setIfeTskyknmkj("契約者名（漢字）");
        bzKykSyaLayoutFile.setIfeTskyknmkjkhukakbn("契約者名漢字化不可区分");
        bzKykSyaLayoutFile.setIfeTskykseiymd("契約者生年月日");
        bzKykSyaLayoutFile.setIfeTskyksei("契約者性別");
        bzKykSyaLayoutFile.setIfeTskkkyktdk("契約管理契約者続柄");
        bzKykSyaLayoutFile.setIfeTstsinyno("通信先郵便番号");
        bzKykSyaLayoutFile.setIfeTstsinadr1kn("通信先住所１（カナ）");
        bzKykSyaLayoutFile.setIfeTstsinadr1kj("通信先住所１（漢字）");
        bzKykSyaLayoutFile.setIfeTstsinadr2kn("通信先住所２（カナ）");
        bzKykSyaLayoutFile.setIfeTstsinadr2kj("通信先住所２（漢字）");
        bzKykSyaLayoutFile.setIfeTstsinadr3kn("通信先住所３（カナ）");
        bzKykSyaLayoutFile.setIfeTstsinadr3kj("通信先住所３（漢字）");
        bzKykSyaLayoutFile.setIfeTstsintelno("通信先電話番号");
        bzKykSyaLayoutFile.setIfeTsdai2tsintelno("第２通信先電話番号");
        bzKykSyaLayoutFile.setIfeTstsinmailaddress("通信先メールアドレス");
        bzKykSyaLayoutFile.setIfeTskinmusakinm("勤務先名");
        bzKykSyaLayoutFile.setIfeTshjndaiykkbn("法人代表者役職区分");
        bzKykSyaLayoutFile.setIfeTshjndaiyknm("法人代表者役職名");
        bzKykSyaLayoutFile.setIfeTshjndainmkn("法人代表者名（カナ）");
        bzKykSyaLayoutFile.setIfeTshjndainmkj("法人代表者名（漢字）");
        bzKykSyaLayoutFile.setIfeTsgyoumukousinkinou("業務用更新機能ＩＤ");
        bzKykSyaLayoutFile.setIfeTsgyoumukousinsyaid("業務用更新者ＩＤ");
        bzKykSyaLayoutFile.setIfeTsgyoumukousintime("業務用更新時間");
        bzKykSyaLayoutFile.setIfeTskousinsyaid("更新者ＩＤ");
        bzKykSyaLayoutFile.setIfeTskousintime("更新時間");
        bzKykSyaLayoutFile.setIfeTskousinkinou("更新機能");
        bzKykSyaLayoutFile.setIfeTsversion("バージョン");

        return bzKykSyaLayoutFile;
    }

    private BzKykSyouhnLayoutFile setKykSyouhnKoumokunm() {

        BzKykSyouhnLayoutFile bzKykSyouhnLayoutFile = SWAKInjector.getInstance(BzKykSyouhnLayoutFile.class);

        bzKykSyouhnLayoutFile.setIfeTskbnkey("区分キー");
        bzKykSyouhnLayoutFile.setIfeTssyono("証券番号");
        bzKykSyouhnLayoutFile.setIfeTssyutkkbn("主契約特約区分");
        bzKykSyouhnLayoutFile.setIfeTssyouhncd("商品コード");
        bzKykSyouhnLayoutFile.setIfeTssyouhnsdno("商品世代番号");
        bzKykSyouhnLayoutFile.setIfeTskyksyouhnrenno("契約商品連番");
        bzKykSyouhnLayoutFile.setIfeTshenkousikibetukey("変更識別キー");
        bzKykSyouhnLayoutFile.setIfeTsyuukousyoumetukbn("有効消滅区分");
        bzKykSyouhnLayoutFile.setIfeTskykjyoutai("契約状態");
        bzKykSyouhnLayoutFile.setIfeTssyoumetujiyuu("消滅事由");
        bzKykSyouhnLayoutFile.setIfeTssyoumetuymd("消滅日");
        bzKykSyouhnLayoutFile.setIfeTskouryokuhasseiymd("効力発生日");
        bzKykSyouhnLayoutFile.setIfeTskykymd("契約日");
        bzKykSyouhnLayoutFile.setIfeTskykymdsiteiumukbn("契約日指定有無区分");
        bzKykSyouhnLayoutFile.setIfeTssknnkaisiymd("責任開始日");
        bzKykSyouhnLayoutFile.setIfeTsgansknnkaisiymd("がん責任開始日");
        bzKykSyouhnLayoutFile.setIfeTshksknnkaisiymd("復活責任開始日");
        bzKykSyouhnLayoutFile.setIfeTshkgansknnkaisiymd("復活がん責任開始日");
        bzKykSyouhnLayoutFile.setIfeTshknkknsmnkbn("保険期間歳満期区分");
        bzKykSyouhnLayoutFile.setIfeTshknkkn("保険期間");
        bzKykSyouhnLayoutFile.setIfeTshrkkknsmnkbn("払込期間歳満期区分");
        bzKykSyouhnLayoutFile.setIfeTshrkkkn("払込期間");
        bzKykSyouhnLayoutFile.setIfeTskyknen("契約者年齢");
        bzKykSyouhnLayoutFile.setIfeTshhknnen("被保険者年齢");
        bzKykSyouhnLayoutFile.setIfeTshhknseiymd("被保険者生年月日");
        bzKykSyouhnLayoutFile.setIfeTshhknsei("被保険者性別");
        bzKykSyouhnLayoutFile.setIfeTsharaimanymd("払満日");
        bzKykSyouhnLayoutFile.setIfeTshknkknmanryouymd("保険期間満了日");
        bzKykSyouhnLayoutFile.setIfeTskatakbn("型区分");
        bzKykSyouhnLayoutFile.setIfeTskyhgndkatakbn("給付限度型区分");
        bzKykSyouhnLayoutFile.setIfeTssyukyhkinkatakbn("手術給付金型区分");
        bzKykSyouhnLayoutFile.setIfeTskhnkyhkgbairitukbn("基本給付金額倍率区分");
        bzKykSyouhnLayoutFile.setIfeTsrokudaildkbn("６大生活習慣病追加給付型区分");
        bzKykSyouhnLayoutFile.setIfeTspmnjtkkbn("保険料免除特約区分");
        bzKykSyouhnLayoutFile.setIfeTskihons("基本Ｓ");
        bzKykSyouhnLayoutFile.setIfeTskihonst("基本Ｓ(通貨型)");
        bzKykSyouhnLayoutFile.setIfeTshokenryou("保険料");
        bzKykSyouhnLayoutFile.setIfeTshokenryout("保険料(通貨型)");
        bzKykSyouhnLayoutFile.setIfeTskyktuukasyu("契約通貨種類");
        bzKykSyouhnLayoutFile.setIfeTsryouritusdno("料率世代番号");
        bzKykSyouhnLayoutFile.setIfeTsyoteiriritu("予定利率");
        bzKykSyouhnLayoutFile.setIfeTsyoteirrthendohosyurrt("予定利率変動時保証利率");
        bzKykSyouhnLayoutFile.setIfeTsytirrthndmnskaisuu("予定利率変動見直回数");
        bzKykSyouhnLayoutFile.setIfeTskyksjkkktyouseiriritu("契約時市場価格調整用利率");
        bzKykSyouhnLayoutFile.setIfeTsnksyukbn("年金種類区分");
        bzKykSyouhnLayoutFile.setIfeTsnenkinkkn("年金期間");
        bzKykSyouhnLayoutFile.setIfeTsnkgnshosyouritu("年金原資最低保証率");
        bzKykSyouhnLayoutFile.setIfeTsnkgnshosyougk("年金原資最低保証額");
        bzKykSyouhnLayoutFile.setIfeTsnkgnshosyougkt("年金原資最低保証額(通貨型)");
        bzKykSyouhnLayoutFile.setIfeTsgyoumukousinkinou("業務用更新機能ＩＤ");
        bzKykSyouhnLayoutFile.setIfeTsgyoumukousinsyaid("業務用更新者ＩＤ");
        bzKykSyouhnLayoutFile.setIfeTsgyoumukousintime("業務用更新時間");
        bzKykSyouhnLayoutFile.setIfeTskousinsyaid("更新者ＩＤ");
        bzKykSyouhnLayoutFile.setIfeTskousintime("更新時間");
        bzKykSyouhnLayoutFile.setIfeTskousinkinou("更新機能");
        bzKykSyouhnLayoutFile.setIfeTsversion("バージョン");
        bzKykSyouhnLayoutFile.setIfeTsgengakugyenitjbrpstgk("減額後円換算一時払保険料相当額");
        bzKykSyouhnLayoutFile.setIfeTsgengakugyenitjbrpstgkt("減額後円換算一時払保険料相当額(通貨型)");
        bzKykSyouhnLayoutFile.setIfeTsyendthnkymd("円建変更日");
        bzKykSyouhnLayoutFile.setIfeTssetteibairitu("設定倍率");
        bzKykSyouhnLayoutFile.setIfeTskykjisisuurendourate("契約時指数連動部分割合");
        bzKykSyouhnLayoutFile.setIfeTstmttknzoukaritujygn("積立金増加率上限");
        bzKykSyouhnLayoutFile.setIfeTstumitateriritu("積立利率");
        bzKykSyouhnLayoutFile.setIfeTstmttknhaibunjyoutai("積立金配分状態");
        bzKykSyouhnLayoutFile.setIfeTssisuukbn("指数区分");
        bzKykSyouhnLayoutFile.setIfeTsgsbunrikzkakuninumu("源泉分離課税確認有無");
        bzKykSyouhnLayoutFile.setIfeTsgsbunritaisyou("源泉分離課税対象");
        bzKykSyouhnLayoutFile.setIfeTspharaikomisougaku("保険料払込総額");
        bzKykSyouhnLayoutFile.setIfeTspharaikomisougakut("保険料払込総額(通貨型)");
        bzKykSyouhnLayoutFile.setIfeTstmttknitenymd("積立金移転日");
        bzKykSyouhnLayoutFile.setIfeTsloadinghnkgtmttrrt("ローディング変更後積立利率");
        bzKykSyouhnLayoutFile.setIfeTsrendouritu("連動率");
        bzKykSyouhnLayoutFile.setIfeTsteikishrritu("定期支払率");

        return bzKykSyouhnLayoutFile;
    }

    private BzKykUktLayoutFile setKykUktKoumokunm() {

        BzKykUktLayoutFile bzKykUktLayoutFile = SWAKInjector.getInstance(BzKykUktLayoutFile.class);

        bzKykUktLayoutFile.setIfeTskbnkey("区分キー");
        bzKykUktLayoutFile.setIfeTssyono("証券番号");
        bzKykUktLayoutFile.setIfeTsuktsyukbn("受取人種類区分");
        bzKykUktLayoutFile.setIfeTsuktsyurenno("受取人種類別連番");
        bzKykUktLayoutFile.setIfeTskokno("顧客番号");
        bzKykUktLayoutFile.setIfeTsuktkbn("受取人区分");
        bzKykUktLayoutFile.setIfeTsuktnmkn("受取人名（カナ）");
        bzKykUktLayoutFile.setIfeTsuktnmkj("受取人名（漢字）");
        bzKykUktLayoutFile.setIfeTsuktnmkjkhukakbn("受取人名漢字化不可区分");
        bzKykUktLayoutFile.setIfeTsuktseiymd("受取人生年月日");
        bzKykUktLayoutFile.setIfeTsukttdk("受取人続柄");
        bzKykUktLayoutFile.setIfeTsuktbnwari("受取人分割割合");
        bzKykUktLayoutFile.setIfeTsgyoumukousinkinou("業務用更新機能ＩＤ");
        bzKykUktLayoutFile.setIfeTsgyoumukousinsyaid("業務用更新者ＩＤ");
        bzKykUktLayoutFile.setIfeTsgyoumukousintime("業務用更新時間");
        bzKykUktLayoutFile.setIfeTskousinsyaid("更新者ＩＤ");
        bzKykUktLayoutFile.setIfeTskousintime("更新時間");
        bzKykUktLayoutFile.setIfeTskousinkinou("更新機能");
        bzKykUktLayoutFile.setIfeTsversion("バージョン");
        bzKykUktLayoutFile.setIfeTsuktyno("受取人郵便番号");
        bzKykUktLayoutFile.setIfeTsuktadr1kj("受取人住所１（漢字）");
        bzKykUktLayoutFile.setIfeTsuktadr2kj("受取人住所２（漢字）");
        bzKykUktLayoutFile.setIfeTsuktadr3kj("受取人住所３（漢字）");

        return bzKykUktLayoutFile;
    }

    private BzNyknJissekiRirekiLayoutFile setNyknJissekiRirekiKoumokunm() {

        BzNyknJissekiRirekiLayoutFile bzNyknJissekiRirekiLayoutFile = SWAKInjector.getInstance(
            BzNyknJissekiRirekiLayoutFile.class);

        bzNyknJissekiRirekiLayoutFile.setIfeTskbnkey("区分キー");
        bzNyknJissekiRirekiLayoutFile.setIfeTssyono("証券番号");
        bzNyknJissekiRirekiLayoutFile.setIfeTsjyutoustartym("充当開始年月");
        bzNyknJissekiRirekiLayoutFile.setIfeTsrenno("連番");
        bzNyknJissekiRirekiLayoutFile.setIfeTsjyutouendym("充当終了年月");
        bzNyknJissekiRirekiLayoutFile.setIfeTsrsgaku("領収金額");
        bzNyknJissekiRirekiLayoutFile.setIfeTsrsgakut("領収金額(通貨型)");
        bzNyknJissekiRirekiLayoutFile.setIfeTsrstuukasyu("領収通貨種類");
        bzNyknJissekiRirekiLayoutFile.setIfeTsryosyukwsratekjymd("領収為替レート基準日");
        bzNyknJissekiRirekiLayoutFile.setIfeTsryosyukwsrate("領収為替レート");
        bzNyknJissekiRirekiLayoutFile.setIfeTshrkp("払込保険料");
        bzNyknJissekiRirekiLayoutFile.setIfeTshrkpt("払込保険料(通貨型)");
        bzNyknJissekiRirekiLayoutFile.setIfeTsiktwaribikikgk("一括割引料");
        bzNyknJissekiRirekiLayoutFile.setIfeTsiktwaribikikgkt("一括割引料(通貨型)");
        bzNyknJissekiRirekiLayoutFile.setIfeTsnyksyoriymd("入金処理日");
        bzNyknJissekiRirekiLayoutFile.setIfeTsryosyuymd("領収日");
        bzNyknJissekiRirekiLayoutFile.setIfeTsnykdenno("入金伝票番号");
        bzNyknJissekiRirekiLayoutFile.setIfeTsnykdenymd("入金伝票日付");
        bzNyknJissekiRirekiLayoutFile.setIfeTsnykkeiro("入金経路");
        bzNyknJissekiRirekiLayoutFile.setIfeTshrkkaisuu("払込回数");
        bzNyknJissekiRirekiLayoutFile.setIfeTstikiktbrisyuruikbn("定期一括払種類区分");
        bzNyknJissekiRirekiLayoutFile.setIfeTsikkatuyoupkaisuu("一括要Ｐ回数");
        bzNyknJissekiRirekiLayoutFile.setIfeTsjyutoukaisuuy("充当回数（年）");
        bzNyknJissekiRirekiLayoutFile.setIfeTsjyutoukaisuum("充当回数（月）");
        bzNyknJissekiRirekiLayoutFile.setIfeTsnyknaiyoukbn("入金内容区分");
        bzNyknJissekiRirekiLayoutFile.setIfeTsiktnyuukinnumu("一括入金有無");
        bzNyknJissekiRirekiLayoutFile.setIfeTsnyktrksflg("入金取消フラグ");
        bzNyknJissekiRirekiLayoutFile.setIfeTsnyktrksymd("入金取消処理日");
        bzNyknJissekiRirekiLayoutFile.setIfeTsnyktrksdenno("入金取消伝票番号");
        bzNyknJissekiRirekiLayoutFile.setIfeTsnyktrksdenymd("入金取消伝票日付");
        bzNyknJissekiRirekiLayoutFile.setIfeTsyenkansannyknkingk("円換算入金額");
        bzNyknJissekiRirekiLayoutFile.setIfeTsyenkansannyknkingkt("円換算入金額(通貨型)");
        bzNyknJissekiRirekiLayoutFile.setIfeTsyenkansantkykwsrateymd("円換算適用為替レート基準日");
        bzNyknJissekiRirekiLayoutFile.setIfeTsyenkansantkykwsrate("円換算適用為替レート");
        bzNyknJissekiRirekiLayoutFile.setIfeTshenkousikibetukey("変更識別キー");
        bzNyknJissekiRirekiLayoutFile.setIfeTsgyoumukousinkinou("業務用更新機能ＩＤ");
        bzNyknJissekiRirekiLayoutFile.setIfeTsgyoumukousinsyaid("業務用更新者ＩＤ");
        bzNyknJissekiRirekiLayoutFile.setIfeTsgyoumukousintime("業務用更新時間");
        bzNyknJissekiRirekiLayoutFile.setIfeTskousinsyaid("更新者ＩＤ");
        bzNyknJissekiRirekiLayoutFile.setIfeTskousintime("更新時間");
        bzNyknJissekiRirekiLayoutFile.setIfeTskousinkinou("更新機能");
        bzNyknJissekiRirekiLayoutFile.setIfeTsversion("バージョン");
        bzNyknJissekiRirekiLayoutFile.setIfeTscreditkessaiyouno("クレジットカード決済用番号");

        return bzNyknJissekiRirekiLayoutFile;
    }

    private BzTesuuryouSyouhnLayoutFile setTesuuryouSyouhnKoumokunm() {

        BzTesuuryouSyouhnLayoutFile bzTesuuryouSyouhnLayoutFile = SWAKInjector.getInstance(
            BzTesuuryouSyouhnLayoutFile.class);

        bzTesuuryouSyouhnLayoutFile.setIfeTskbnkey("区分キー");
        bzTesuuryouSyouhnLayoutFile.setIfeTssyono("証券番号");
        bzTesuuryouSyouhnLayoutFile.setIfeTstsrysyorikbn("手数料処理区分");
        bzTesuuryouSyouhnLayoutFile.setIfeTsrenno("連番");
        bzTesuuryouSyouhnLayoutFile.setIfeTssyutkkbn("主契約特約区分");
        bzTesuuryouSyouhnLayoutFile.setIfeTssyouhncd("商品コード");
        bzTesuuryouSyouhnLayoutFile.setIfeTssyouhnsdno("商品世代番号");
        bzTesuuryouSyouhnLayoutFile.setIfeTskyksyouhnrenno("契約商品連番");
        bzTesuuryouSyouhnLayoutFile.setIfeTshenkousikibetukey("変更識別キー");
        bzTesuuryouSyouhnLayoutFile.setIfeTsyuukousyoumetukbn("有効消滅区分");
        bzTesuuryouSyouhnLayoutFile.setIfeTskykjyoutai("契約状態");
        bzTesuuryouSyouhnLayoutFile.setIfeTssyoumetujiyuu("消滅事由");
        bzTesuuryouSyouhnLayoutFile.setIfeTssyoumetuymd("消滅日");
        bzTesuuryouSyouhnLayoutFile.setIfeTskouryokuhasseiymd("効力発生日");
        bzTesuuryouSyouhnLayoutFile.setIfeTskykymd("契約日");
        bzTesuuryouSyouhnLayoutFile.setIfeTssknnkaisiymd("責任開始日");
        bzTesuuryouSyouhnLayoutFile.setIfeTsgansknnkaisiymd("がん責任開始日");
        bzTesuuryouSyouhnLayoutFile.setIfeTshknkknsmnkbn("保険期間歳満期区分");
        bzTesuuryouSyouhnLayoutFile.setIfeTshknkkn("保険期間");
        bzTesuuryouSyouhnLayoutFile.setIfeTshrkkknsmnkbn("払込期間歳満期区分");
        bzTesuuryouSyouhnLayoutFile.setIfeTshrkkkn("払込期間");
        bzTesuuryouSyouhnLayoutFile.setIfeTskyknen("契約者年齢");
        bzTesuuryouSyouhnLayoutFile.setIfeTshhknnen("被保険者年齢");
        bzTesuuryouSyouhnLayoutFile.setIfeTshhknseiymd("被保険者生年月日");
        bzTesuuryouSyouhnLayoutFile.setIfeTshhknsei("被保険者性別");
        bzTesuuryouSyouhnLayoutFile.setIfeTsharaimanymd("払満日");
        bzTesuuryouSyouhnLayoutFile.setIfeTshknkknmanryouymd("保険期間満了日");
        bzTesuuryouSyouhnLayoutFile.setIfeTskatakbn("型区分");
        bzTesuuryouSyouhnLayoutFile.setIfeTskyhgndkatakbn("給付限度型区分");
        bzTesuuryouSyouhnLayoutFile.setIfeTssyukyhkinkatakbn("手術給付金型区分");
        bzTesuuryouSyouhnLayoutFile.setIfeTskhnkyhkgbairitukbn("基本給付金額倍率区分");
        bzTesuuryouSyouhnLayoutFile.setIfeTsrokudaildkbn("６大生活習慣病追加給付型区分");
        bzTesuuryouSyouhnLayoutFile.setIfeTspmnjtkkbn("保険料免除特約区分");
        bzTesuuryouSyouhnLayoutFile.setIfeTskihons("基本Ｓ");
        bzTesuuryouSyouhnLayoutFile.setIfeTskihonst("基本Ｓ(通貨型)");
        bzTesuuryouSyouhnLayoutFile.setIfeTshokenryou("保険料");
        bzTesuuryouSyouhnLayoutFile.setIfeTshokenryout("保険料(通貨型)");
        bzTesuuryouSyouhnLayoutFile.setIfeTskyktuukasyu("契約通貨種類");
        bzTesuuryouSyouhnLayoutFile.setIfeTsryouritusdno("料率世代番号");
        bzTesuuryouSyouhnLayoutFile.setIfeTsyoteiriritu("予定利率");
        bzTesuuryouSyouhnLayoutFile.setIfeTsyoteirrthendohosyurrt("予定利率変動時保証利率");
        bzTesuuryouSyouhnLayoutFile.setIfeTsytirrthndmnskaisuu("予定利率変動見直回数");
        bzTesuuryouSyouhnLayoutFile.setIfeTskyksjkkktyouseiriritu("契約時市場価格調整用利率");
        bzTesuuryouSyouhnLayoutFile.setIfeTsnksyukbn("年金種類区分");
        bzTesuuryouSyouhnLayoutFile.setIfeTsnenkinkkn("年金期間");
        bzTesuuryouSyouhnLayoutFile.setIfeTsnkgnshosyouritu("年金原資最低保証率");
        bzTesuuryouSyouhnLayoutFile.setIfeTsnkgnshosyougk("年金原資最低保証額");
        bzTesuuryouSyouhnLayoutFile.setIfeTsnkgnshosyougkt("年金原資最低保証額(通貨型)");
        bzTesuuryouSyouhnLayoutFile.setIfeTsgyoumukousinkinou("業務用更新機能ＩＤ");
        bzTesuuryouSyouhnLayoutFile.setIfeTsgyoumukousinsyaid("業務用更新者ＩＤ");
        bzTesuuryouSyouhnLayoutFile.setIfeTsgyoumukousintime("業務用更新時間");
        bzTesuuryouSyouhnLayoutFile.setIfeTskousinsyaid("更新者ＩＤ");
        bzTesuuryouSyouhnLayoutFile.setIfeTskousintime("更新時間");
        bzTesuuryouSyouhnLayoutFile.setIfeTskousinkinou("更新機能");
        bzTesuuryouSyouhnLayoutFile.setIfeTsversion("バージョン");

        return bzTesuuryouSyouhnLayoutFile;
    }

    private BzTesuuryouLayoutFile setTesuuryouKoumokunm() {

        BzTesuuryouLayoutFile bzTesuuryouLayoutFile = SWAKInjector.getInstance(BzTesuuryouLayoutFile.class);

        bzTesuuryouLayoutFile.setIfeTskbnkey("区分キー");
        bzTesuuryouLayoutFile.setIfeTssyono("証券番号");
        bzTesuuryouLayoutFile.setIfeTstsrysyorikbn("手数料処理区分");
        bzTesuuryouLayoutFile.setIfeTsrenno("連番");
        bzTesuuryouLayoutFile.setIfeTssyoriymd("処理年月日");
        bzTesuuryouLayoutFile.setIfeTskouryokuhasseiym("効力発生年月");
        bzTesuuryouLayoutFile.setIfeTsnyknkaisuuy("入金回数（年）");
        bzTesuuryouLayoutFile.setIfeTsnyknkaisuum("入金回数（月）");
        bzTesuuryouLayoutFile.setIfeTsmikeikapariflg("未経過Ｐ有フラグ");
        bzTesuuryouLayoutFile.setIfeTsmisyuupariflg("未収Ｐ有フラグ");
        bzTesuuryouLayoutFile.setIfeTsmikeikap("未経過保険料");
        bzTesuuryouLayoutFile.setIfeTsmikeikapt("未経過保険料(通貨型)");
        bzTesuuryouLayoutFile.setIfeTsiktp("一括払保険料");
        bzTesuuryouLayoutFile.setIfeTsiktpt("一括払保険料(通貨型)");
        bzTesuuryouLayoutFile.setIfeTsseisekiym("成績計上年月");
        bzTesuuryouLayoutFile.setIfeTshrkkaisuu("払込回数");
        bzTesuuryouLayoutFile.setIfeTshrkkeiro("払込経路");
        bzTesuuryouLayoutFile.setIfeTshrkp("払込保険料");
        bzTesuuryouLayoutFile.setIfeTshrkpt("払込保険料(通貨型)");
        bzTesuuryouLayoutFile.setIfeTsjkipjytym("次回Ｐ充当年月");
        bzTesuuryouLayoutFile.setIfeTshaitounendo("配当年度");
        bzTesuuryouLayoutFile.setIfeTscifcd("ＣＩＦコード");
        bzTesuuryouLayoutFile.setIfeTssmbckanriid("ＳＭＢＣ受付管理ＩＤ");
        bzTesuuryouLayoutFile.setIfeTsboskykjyoutai("募集契約状態");
        bzTesuuryouLayoutFile.setIfeTskyknmkj("契約者名（漢字）");
        bzTesuuryouLayoutFile.setIfeTsbosyuuym("募集年月");
        bzTesuuryouLayoutFile.setIfeTsnyknymd("入金日");
        bzTesuuryouLayoutFile.setIfeTsyenkansantkykwsrate("円換算適用為替レート");
        bzTesuuryouLayoutFile.setIfeTsyenkansantkykwsrateymd("円換算適用為替レート基準日");
        bzTesuuryouLayoutFile.setIfeTstikiktbrisyuruikbn("定期一括払種類区分");
        bzTesuuryouLayoutFile.setIfeTsgyoumukousinkinou("業務用更新機能ＩＤ");
        bzTesuuryouLayoutFile.setIfeTsgyoumukousinsyaid("業務用更新者ＩＤ");
        bzTesuuryouLayoutFile.setIfeTsgyoumukousintime("業務用更新時間");
        bzTesuuryouLayoutFile.setIfeTskousinsyaid("更新者ＩＤ");
        bzTesuuryouLayoutFile.setIfeTskousintime("更新時間");
        bzTesuuryouLayoutFile.setIfeTskousinkinou("更新機能");
        bzTesuuryouLayoutFile.setIfeTsversion("バージョン");

        return bzTesuuryouLayoutFile;
    }

    private BzTrkKzkLayoutFile setTrkKzkKoumokunm() {

        BzTrkKzkLayoutFile bzTrkKzkLayoutFile = SWAKInjector.getInstance(BzTrkKzkLayoutFile.class);

        bzTrkKzkLayoutFile.setIfeTskbnkey("区分キー");
        bzTrkKzkLayoutFile.setIfeTssyono("証券番号");
        bzTrkKzkLayoutFile.setIfeTstrkkzkkbn("登録家族区分");
        bzTrkKzkLayoutFile.setIfeTstrkkzksetteiymd("登録家族設定年月日");
        bzTrkKzkLayoutFile.setIfeTstrkkzknmkn("登録家族名（カナ）");
        bzTrkKzkLayoutFile.setIfeTstrkkzknmkj("登録家族名（漢字）");
        bzTrkKzkLayoutFile.setIfeTstrkkzknmkjkhukakbn("登録家族名漢字化不可区分");
        bzTrkKzkLayoutFile.setIfeTstrkkzkseiymd("登録家族生年月日");
        bzTrkKzkLayoutFile.setIfeTstrkkzksei("登録家族性別");
        bzTrkKzkLayoutFile.setIfeTstrkkzktdk("登録家族続柄");
        bzTrkKzkLayoutFile.setIfeTstrkkzkyno("登録家族郵便番号");
        bzTrkKzkLayoutFile.setIfeTstrkkzkadr1kj("登録家族住所１（漢字）");
        bzTrkKzkLayoutFile.setIfeTstrkkzkadr2kj("登録家族住所２（漢字）");
        bzTrkKzkLayoutFile.setIfeTstrkkzkadr3kj("登録家族住所３（漢字）");
        bzTrkKzkLayoutFile.setIfeTstrkkzktelno("登録家族電話番号");
        bzTrkKzkLayoutFile.setIfeTsgyoumukousinkinou("業務用更新機能ＩＤ");
        bzTrkKzkLayoutFile.setIfeTsgyoumukousinsyaid("業務用更新者ＩＤ");
        bzTrkKzkLayoutFile.setIfeTsgyoumukousintime("業務用更新時間");
        bzTrkKzkLayoutFile.setIfeTskousinsyaid("更新者ＩＤ");
        bzTrkKzkLayoutFile.setIfeTskousintime("更新時間");
        bzTrkKzkLayoutFile.setIfeTskousinkinou("更新機能");
        bzTrkKzkLayoutFile.setIfeTsversion("バージョン");
        bzTrkKzkLayoutFile.setIfeTstrkkzktsindousiteikbn("登録家族通信先同一指定区分");

        return bzTrkKzkLayoutFile;
    }

    private BzZennouLayoutFile setZennouKoumokunm() {

        BzZennouLayoutFile bzZennouLayoutFile = SWAKInjector.getInstance(BzZennouLayoutFile.class);

        bzZennouLayoutFile.setIfeTskbnkey("区分キー");
        bzZennouLayoutFile.setIfeTssyono("証券番号");
        bzZennouLayoutFile.setIfeTszennoukaisiymd("前納開始年月日");
        bzZennouLayoutFile.setIfeTsrenno("連番");
        bzZennouLayoutFile.setIfeTszennounyuukinsyoriymd("前納入金処理日");
        bzZennouLayoutFile.setIfeTszennounyuukindenno("前納入金伝票番号");
        bzZennouLayoutFile.setIfeTszennounyuukindenymd("前納入金伝票日付");
        bzZennouLayoutFile.setIfeTsryosyuymd("領収日");
        bzZennouLayoutFile.setIfeTszennoukikan("前納期間");
        bzZennouLayoutFile.setIfeTszennounyuukinkgk("前納入金額");
        bzZennouLayoutFile.setIfeTszennounyuukinkgkt("前納入金額（通貨型）");
        bzZennouLayoutFile.setIfeTszennoujihrkp("前納時払込保険料");
        bzZennouLayoutFile.setIfeTszennoujihrkpt("前納時払込保険料（通貨型）");
        bzZennouLayoutFile.setIfeTszennouseisankbn("前納精算区分");
        bzZennouLayoutFile.setIfeTszennouseisansyoriymd("前納精算処理日");
        bzZennouLayoutFile.setIfeTszennouseisankgk("前納精算金額");
        bzZennouLayoutFile.setIfeTszennouseisankgkt("前納精算金額（通貨型）");
        bzZennouLayoutFile.setIfeTszennouseisankijyunymd("前納精算基準日");
        bzZennouLayoutFile.setIfeTszennouseisandenymd("前納精算伝票日付");
        bzZennouLayoutFile.setIfeTsannaisaikaiym("案内再開年月");
        bzZennouLayoutFile.setIfeTskjsmyouzennoukaisiymd("控除証明用前納開始年月日");
        bzZennouLayoutFile.setIfeTskjsmyouzennoukikanm("控除証明用前納期間（月）");
        bzZennouLayoutFile.setIfeTskjsmyouzennounyukingk("控除証明用前納入金額");
        bzZennouLayoutFile.setIfeTskjsmyouzennounyukingkt("控除証明用前納入金額（通貨型）");
        bzZennouLayoutFile.setIfeTsgyoumukousinkinou("業務用更新機能ＩＤ");
        bzZennouLayoutFile.setIfeTsgyoumukousinsyaid("業務用更新者ＩＤ");
        bzZennouLayoutFile.setIfeTsgyoumukousintime("業務用更新時間");
        bzZennouLayoutFile.setIfeTskousinsyaid("更新者ＩＤ");
        bzZennouLayoutFile.setIfeTskousintime("更新時間");
        bzZennouLayoutFile.setIfeTskousinkinou("更新機能");
        bzZennouLayoutFile.setIfeTsversion("バージョン");

        return bzZennouLayoutFile;
    }

    private BzKouzaLayoutFile setKouzaKoumokunm() {

        BzKouzaLayoutFile bzKouzaLayoutFile = SWAKInjector.getInstance(BzKouzaLayoutFile.class);

        bzKouzaLayoutFile.setIfeTskbnkey("区分キー");
        bzKouzaLayoutFile.setIfeTssyono("証券番号");
        bzKouzaLayoutFile.setIfeTskokno("顧客番号");
        bzKouzaLayoutFile.setIfeTsbankcd("銀行コード");
        bzKouzaLayoutFile.setIfeTssitencd("支店コード");
        bzKouzaLayoutFile.setIfeTsyokinkbn("預金種目区分");
        bzKouzaLayoutFile.setIfeTskouzano("口座番号");
        bzKouzaLayoutFile.setIfeTskzmeiginmkn("口座名義人氏名（カナ）");
        bzKouzaLayoutFile.setIfeTssinkeizkkbn("新規継続区分");
        bzKouzaLayoutFile.setIfeTssyuudaikocd("収納代行社コード");
        bzKouzaLayoutFile.setIfeTskzkykdoukbn("口座名義契約者同一人区分");
        bzKouzaLayoutFile.setIfeTsgyoumukousinkinou("業務用更新機能ＩＤ");
        bzKouzaLayoutFile.setIfeTsgyoumukousinsyaid("業務用更新者ＩＤ");
        bzKouzaLayoutFile.setIfeTsgyoumukousintime("業務用更新時間");
        bzKouzaLayoutFile.setIfeTskousinsyaid("更新者ＩＤ");
        bzKouzaLayoutFile.setIfeTskousintime("更新時間");
        bzKouzaLayoutFile.setIfeTskousinkinou("更新機能");
        bzKouzaLayoutFile.setIfeTsversion("バージョン");

        return bzKouzaLayoutFile;
    }

    private BzCreditCardInfoLayoutFile setCreditCardInfoKoumokunm() {

        BzCreditCardInfoLayoutFile bzCreditCardInfoLayoutFile = SWAKInjector.getInstance(
            BzCreditCardInfoLayoutFile.class);

        bzCreditCardInfoLayoutFile.setIfeTskbnkey("区分キー");
        bzCreditCardInfoLayoutFile.setIfeTssyono("証券番号");
        bzCreditCardInfoLayoutFile.setIfeTscreditkessaiyouno("クレジットカード決済用番号");
        bzCreditCardInfoLayoutFile.setIfeTscredityuukoukakym("クレジットカード有効確認年月");
        bzCreditCardInfoLayoutFile.setIfeTscredityuukoukakkekka("クレジットカード有効確認結果");
        bzCreditCardInfoLayoutFile.setIfeTsgyoumukousinkinou("業務用更新機能ＩＤ");
        bzCreditCardInfoLayoutFile.setIfeTsgyoumukousinsyaid("業務用更新者ＩＤ");
        bzCreditCardInfoLayoutFile.setIfeTsgyoumukousintime("業務用更新時間");
        bzCreditCardInfoLayoutFile.setIfeTskousinsyaid("更新者ＩＤ");
        bzCreditCardInfoLayoutFile.setIfeTskousintime("更新時間");
        bzCreditCardInfoLayoutFile.setIfeTskousinkinou("更新機能");
        bzCreditCardInfoLayoutFile.setIfeTsversion("バージョン");

        return bzCreditCardInfoLayoutFile;
    }

    private String setKoteiatai(String pBeforeAtai, String pKoteiAtai) {

        String afterAtai = "";

        if (BizUtil.isBlank(pBeforeAtai)) {
            ConvertTestData convertTestData = SWAKInjector.getInstance(ConvertTestData.class);
            afterAtai = convertTestData.setNull(pBeforeAtai);
        }
        else {
            afterAtai = pKoteiAtai;
        }
        return afterAtai;
    }

    private String setBizCurrencyVal(BizCurrency pBeforeAtai) {

        String afterAtai = "";

        if (pBeforeAtai != null) {
            afterAtai = pBeforeAtai.toAdsoluteString();
        }
        else {
            afterAtai = String.valueOf(pBeforeAtai);
        }
        return afterAtai;
    }

    private String setBizCurrencyType(BizCurrency pBeforeAtai) {

        String afterAtai = "";

        if (pBeforeAtai != null) {
            afterAtai = String.valueOf(pBeforeAtai.getType());
        }
        else {
            afterAtai = String.valueOf(pBeforeAtai);
        }
        return afterAtai;
    }
}
