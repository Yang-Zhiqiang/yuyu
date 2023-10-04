package yuyu.batch.siharai.sisatei.simakekbnkeiri;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.util.string.ConvertUtil;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.DateFormatUtil;
import yuyu.common.biz.bzcommon.GetKawaseRate;
import yuyu.common.biz.bzcommon.KeisanGaikakanzan;
import yuyu.common.biz.bzfiledl.BzFileUploadUtil;
import yuyu.common.biz.kaikei.BzSegmentCdSyutoku;
import yuyu.common.biz.kaikei.SyouhinbetuSegmentBean;
import yuyu.common.hozen.khcommon.SetKessanNensibi;
import yuyu.def.MessageId;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_EigyoubiHoseiKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_FileSyuruiCdKbn;
import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.classification.C_HushrGeninKbn;
import yuyu.def.classification.C_KawaserateSyuruiKbn;
import yuyu.def.classification.C_KawasetekiyoKbn;
import yuyu.def.classification.C_KawasetsryKbn;
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.JM_Kyuuhu;
import yuyu.def.db.entity.JT_SateiSyouninRireki;
import yuyu.def.db.entity.JT_SiDetail;
import yuyu.def.db.entity.JT_SiRireki;
import yuyu.def.db.entity.JT_Sk;
import yuyu.def.db.entity.JT_SkJiyuu;
import yuyu.def.db.entity.JT_SkKihon;
import yuyu.def.siharai.file.csv.SiKbnKeiriKykMeisaiLayoutFile;
import yuyu.def.siharai.file.csv.SiKbnKeiriKykSyuukeiLayoutFile;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.def.siharai.result.bean.SiKykKihonInfosBySeikyuusyubetuNeShrsyoriymdBean;
import yuyu.def.siharai.sorter.SortJT_SateiSyouninRireki;
import yuyu.def.siharai.sorter.SortJT_SiRireki;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;

/**
 * 保険金給付金支払 査定／支払 区分経理情報作成
 */
public class SiMakeKbnKeiriBatch implements Batch {

    private final String ZERO = "0";

    private final String SYORIKBN_SIHARAI = "4";

    private final String SYORIKBNNM_SIHARAI = "支払";

    private final String SIHARAIKBN_SIHARAI = "0";

    private final String SIHARAIKBN_KAIJYO = "1";

    private final String SIHARAIKBN_MENSEKI = "2";

    private final String SIHARAIKBN_MUKOU = "3";

    private final String KEIJYOUKBN_TOUNENDO = "1";

    private final String KEIJYOUKBN_SINKIBIKIN = "2";

    private final String KEIJYOUKBN_SAIBIKIN = "3";

    private final String KEIJYOUKBN_SAISAIBIKIN = "4";

    private final String KEIJYOUKBN_SONOTA = "5";

    private final String UKETUKEJIGYOUNENDO_TOUNENDO = "当年度";

    private final String UKETUKEJIGYOUNENDO_SINKIBIKIN = "新規備金";

    private final String UKETUKEJIGYOUNENDO_SAIBIKIN = "再備金";

    private final String UKETUKEJIGYOUNENDO_SAISAIBIKIN = "再々備金";

    private final String UKETUKEJIGYOUNENDO_SONOTA = "その他";

    private final String SIKBNKEIRI_FILE = "区分経理情報ファイル";

    private final String SIKBNKEIRI_KYKMEISAI_FILE = "区分経理用支払契約明細ファイル";

    private final String SIKBNKEIRI_SYUUKEI_FILE = "区分経理用支払契約集計ファイル";

    private final String SIHARAIKBN_SAIGAIHIGAITOU = "4";

    private final String SIHARAIKBN_SAIGAISMENSEKI = "5";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private SiharaiDomManager siharaiDomManager;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private AS_Kinou kinou;

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

        long nyuuryokuKensuu = 0;
        long kykmeisaiKensuu = 0;
        long kykSyuukeiKensuu = 0;

        BizDate syoriYmdFrom = syoriYmd.getPreviousMonth().getBizDateYM().getFirstDay();
        BizDate syoriYmdFrom_Zenzengetu = syoriYmd.addMonths(-2).getBizDateYM().getFirstDay();
        BizDate syoriYmdTo = syoriYmd.getPreviousMonth().getBizDateYM().getLastDay();

        List<SiKbnKeiriKykMeisaiLayoutFile> kykMeisaiCsvLst = Lists.newArrayList();
        try (ExDBResults<SiKykKihonInfosBySeikyuusyubetuNeShrsyoriymdBean> siKykKihonInfoLst = siharaiDomManager
            .getSiKykKihonInfosBySeikyuusyubetuNeShrsyoriymd(C_SeikyuuSyubetu.SDSSHR, syoriYmdFrom_Zenzengetu, syoriYmdTo)) {
            for (SiKykKihonInfosBySeikyuusyubetuNeShrsyoriymdBean skKihonTemp : siKykKihonInfoLst) {
                List<SiKbnKeiriKykMeisaiLayoutFile> siKbnKeiriKykMeisaiFileLst = editSiKbnKeiriKykMeisaiFile(skKihonTemp
                    .getJT_SkKihon(), syoriYmdFrom, syoriYmdTo);
                if (siKbnKeiriKykMeisaiFileLst != null) {
                    nyuuryokuKensuu++;
                    kykmeisaiKensuu = kykmeisaiKensuu + siKbnKeiriKykMeisaiFileLst.size();
                    kykMeisaiCsvLst.addAll(siKbnKeiriKykMeisaiFileLst);
                }
            }
        }

        if (kykmeisaiKensuu > 0) {
            BzFileUploadUtil bzFileUploadUtil = SWAKInjector.getInstance(BzFileUploadUtil.class);
            C_ErrorKbn errorKbn = bzFileUploadUtil.exec(C_FileSyuruiCdKbn.SI_KBNKEIRIKYKMEISAI, kykMeisaiCsvLst, true);

            if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                throw new BizAppException(MessageId.EBF0129, kinou.getKinouNm());
            }

            List<SiKbnKeiriKykSyuukeiLayoutFile> syuukeiFileCsvLst = Lists.newArrayList();
            SiKbnKeiriKykMeisaiLayoutFile meisaiFileZen = SWAKInjector.getInstance(SiKbnKeiriKykMeisaiLayoutFile.class);
            SiKbnKeiriKykMeisaiLayoutFile meisaiFileTugi = SWAKInjector
                .getInstance(SiKbnKeiriKykMeisaiLayoutFile.class);
            long shrKensuu = 0;
            BizCurrency shrkingakuSyuukei = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
            long uktkJigyouNendoShrKensuu = 0;
            BizCurrency uktkJigyouNendoShrkgkSyuukei = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
            long siharaiKbnShrKensuu = 0;
            BizCurrency siharaiKbnShrkgkSyuukei = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
            long hknsyruikbnShrKensuu = 0;
            BizCurrency hknsyruikbnShrkgkSyuukei = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
            long shrHknkShrKensuu = 0;
            BizCurrency shrHknkShrkgkSyuukei = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
            long shrKensuuCsv = 0;
            BizCurrency shrkgkSyuukeiCsv = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
            long uktkJigyouNendoShrKensuuCsv = 0;
            BizCurrency uktkJigyouNendoShrkgkSyuukeiCsv = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
            long siharaiKbnShrKensuuCsv = 0;
            BizCurrency siharaiKbnShrkgkSyuukeiCsv = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
            long hknsyruikbnShrKensuuCsv = 0;
            BizCurrency hknsyruikbnShrkgkSyuukeiCsv = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
            long shrHknkShrKensuuCsv = 0;
            BizCurrency shrHknkShrkgkSyuukeiCsv = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
            String hknknsyruikbnZen = "";
            String hknknsyruikbnTugi = "";
            String segcdZen = "";
            String segcdTugi = "";
            String siharaiKbnZen = "";
            String siharaiKbnTugi = "";
            String keijyouKbnZen = "";
            String keijyouKbnTugi = "";
            String uketukeYmZen = "";
            String uketukeYmTugi = "";

            Comparator<SiKbnKeiriKykMeisaiLayoutFile> comparator = new Comparator<SiKbnKeiriKykMeisaiLayoutFile>() {

                @Override
                public int compare(SiKbnKeiriKykMeisaiLayoutFile pTarget1, SiKbnKeiriKykMeisaiLayoutFile pTarget2) {
                    String hknknsyruikbnTarget1 = pTarget1.getIfcHknknsyruikbn();
                    String hknknsyruikbnTarget2 = pTarget2.getIfcHknknsyruikbn();
                    String seglevelkbnTarget1 = pTarget1.getIfcSeglevelkbn();
                    String seglevelkbnTarget2 = pTarget2.getIfcSeglevelkbn();
                    String hknsyruilevelkbnTarget1 = pTarget1.getIfcHknsyruilevelkbn();
                    String hknsyruilevelkbnTarget2 = pTarget2.getIfcHknsyruilevelkbn();
                    String shrkbnkbkrinfoTarget1 = pTarget1.getIfcShrkbnkbkrinfo();
                    String shrkbnkbkrinfoTarget2 = pTarget2.getIfcShrkbnkbkrinfo();
                    String kijykbnTarget1 = pTarget1.getIfcKijykbn();
                    String kijykbnTarget2 = pTarget2.getIfcKijykbn();
                    BizDate uketukeymdTarget1 = pTarget1.getIfcUketukeymd();
                    BizDate uketukeymdTarget2 = pTarget2.getIfcUketukeymd();

                    int result = 0;
                    result = hknknsyruikbnTarget1.compareTo(hknknsyruikbnTarget2);
                    if (result != 0) {
                        return result;
                    }
                    result = seglevelkbnTarget1.compareTo(seglevelkbnTarget2);
                    if (result != 0) {
                        return result;
                    }
                    result = hknsyruilevelkbnTarget1.compareTo(hknsyruilevelkbnTarget2);
                    if (result != 0) {
                        return result;
                    }
                    result = shrkbnkbkrinfoTarget1.compareTo(shrkbnkbkrinfoTarget2);
                    if (result != 0) {
                        return result;
                    }
                    result = kijykbnTarget1.compareTo(kijykbnTarget2);
                    if (result != 0) {
                        return result;
                    }
                    result = BizDateUtil.compareYmd(uketukeymdTarget1, uketukeymdTarget2);

                    return result;
                }
            };

            Ordering<SiKbnKeiriKykMeisaiLayoutFile> ordering = Ordering.from(comparator);
            kykMeisaiCsvLst = ordering.sortedCopy(kykMeisaiCsvLst);

            for (int idx2 = 0; idx2 < kykMeisaiCsvLst.size(); idx2++) {
                uketukeYmTugi = changeZenkakuSeireki(kykMeisaiCsvLst.get(idx2).getIfcUketukeymd());
                meisaiFileTugi = kykMeisaiCsvLst.get(idx2);
                keijyouKbnTugi = meisaiFileTugi.getIfcKijykbn();
                siharaiKbnTugi = meisaiFileTugi.getIfcShrkbnkbkrinfo();
                segcdTugi = meisaiFileTugi.getIfcSeglevelkbn() + meisaiFileTugi.getIfcHknsyruilevelkbn();
                hknknsyruikbnTugi = meisaiFileTugi.getIfcHknknsyruikbn();
                if (idx2 == 0) {
                    meisaiFileZen = meisaiFileTugi;
                    hknknsyruikbnZen = hknknsyruikbnTugi;
                    segcdZen = segcdTugi;
                    siharaiKbnZen = siharaiKbnTugi;
                    keijyouKbnZen = keijyouKbnTugi;
                    uketukeYmZen = uketukeYmTugi;
                    shrKensuu = 1;
                    shrkingakuSyuukei = BizCurrency.valueOf(
                        new BigDecimal(meisaiFileTugi.getIfcShrgk()), BizCurrencyTypes.YEN);
                    uktkJigyouNendoShrKensuu = 1;
                    uktkJigyouNendoShrkgkSyuukei = BizCurrency.valueOf(
                        new BigDecimal(meisaiFileTugi.getIfcShrgk()), BizCurrencyTypes.YEN);
                    siharaiKbnShrKensuu = 1;
                    siharaiKbnShrkgkSyuukei = BizCurrency.valueOf(
                        new BigDecimal(meisaiFileTugi.getIfcShrgk()), BizCurrencyTypes.YEN);
                    hknsyruikbnShrKensuu = 1;
                    hknsyruikbnShrkgkSyuukei = BizCurrency.valueOf(
                        new BigDecimal(meisaiFileTugi.getIfcShrgk()), BizCurrencyTypes.YEN);
                    shrHknkShrKensuu = 1;
                    shrHknkShrkgkSyuukei = BizCurrency.valueOf(
                        new BigDecimal(meisaiFileTugi.getIfcShrgk()), BizCurrencyTypes.YEN);
                }
                else {
                    SiKbnKeiriKykSyuukeiLayoutFile syuukeiFile = SWAKInjector
                        .getInstance(SiKbnKeiriKykSyuukeiLayoutFile.class);
                    syuukeiFile.setIfcKimskensuu("0");
                    syuukeiFile.setIfcKimsshrs("0");
                    syuukeiFile.setIfcSmskensuu("0");
                    syuukeiFile.setIfcSmsshrs("0");
                    syuukeiFile.setIfcKimssmskknnyuhyj("0");
                    syuukeiFile.setIfcUktkjgnedkimskensuu("0");
                    syuukeiFile.setIfcUktkjgnedkimsshrs("0");
                    syuukeiFile.setIfcUktkjgnedsmskensuu("0");
                    syuukeiFile.setIfcUktkjgnedsmsshrs("0");
                    syuukeiFile.setIfcShrkbnkimskensuu("0");
                    syuukeiFile.setIfcShrkbnkimsshrs("0");
                    syuukeiFile.setIfcShrkbnsmskensuu("0");
                    syuukeiFile.setIfcShrkbnsmsshrs("0");
                    syuukeiFile.setIfcKzkkimskensuu("0");
                    syuukeiFile.setIfcKzkkimsshrs("0");
                    syuukeiFile.setIfcKzksmskensuu("0");
                    syuukeiFile.setIfcKzksmsshrs("0");
                    syuukeiFile.setIfcTkkatakimskensuu("0");
                    syuukeiFile.setIfcTkkatakimsshrs("0");
                    syuukeiFile.setIfcTkkatasmskensuu("0");
                    syuukeiFile.setIfcTkkatasmsshrs("0");
                    syuukeiFile.setIfcTksyuruikimskensuu("0");
                    syuukeiFile.setIfcTksyuruikimsshrs("0");
                    syuukeiFile.setIfcTksyuruismskensuu("0");
                    syuukeiFile.setIfcTksyuruismsshrs("0");
                    syuukeiFile.setIfcHknsyuruikimskensuu("0");
                    syuukeiFile.setIfcHknsyuruikimsshrs("0");
                    syuukeiFile.setIfcHknsyuruismskensuu("0");
                    syuukeiFile.setIfcHknsyuruismsshrs("0");
                    syuukeiFile.setIfcShrgkkimskensuu("0");
                    syuukeiFile.setIfcShrgkkimsshrs("0");
                    syuukeiFile.setIfcShrgksmskensuu("0");
                    syuukeiFile.setIfcShrgksmsshrs("0");
                    syuukeiFile.setIfcYobisiharai(" ");

                    if (!hknknsyruikbnTugi.equals(hknknsyruikbnZen)) {
                        shrKensuuCsv = shrKensuu;
                        shrkgkSyuukeiCsv = shrkingakuSyuukei;
                        uktkJigyouNendoShrKensuuCsv = uktkJigyouNendoShrKensuu;
                        uktkJigyouNendoShrkgkSyuukeiCsv = uktkJigyouNendoShrkgkSyuukei;
                        siharaiKbnShrKensuuCsv = siharaiKbnShrKensuu;
                        siharaiKbnShrkgkSyuukeiCsv = siharaiKbnShrkgkSyuukei;
                        hknsyruikbnShrKensuuCsv = hknsyruikbnShrKensuu;
                        hknsyruikbnShrkgkSyuukeiCsv = hknsyruikbnShrkgkSyuukei;
                        shrHknkShrKensuuCsv = shrHknkShrKensuu;
                        shrHknkShrkgkSyuukeiCsv = shrHknkShrkgkSyuukei;

                        syuukeiFile.setIfcSknntisisyrhyj(meisaiFileZen.getIfcSknntisisyrhyj());
                        syuukeiFile.setIfcSyorikbnkbkrinfo(meisaiFileZen.getIfcSyorikbnkbkrinfo());
                        syuukeiFile.setIfcSyorikbnnmkbkrinfo(meisaiFileZen.getIfcSyorikbnnmkbkrinfo());
                        syuukeiFile.setIfcUktkym(uketukeYmZen);
                        syuukeiFile.setIfcHknknsyruikbn(meisaiFileZen.getIfcHknknsyruikbn());
                        syuukeiFile.setIfcShrhknknnm(meisaiFileZen.getIfcShrhknknnm());
                        syuukeiFile.setIfcSeglevelkbn(meisaiFileZen.getIfcSeglevelkbn());
                        syuukeiFile.setIfcHknsyruilevelkbn(meisaiFileZen.getIfcHknsyruilevelkbn());
                        syuukeiFile.setIfcHknsyuruimeikbkrinfo(meisaiFileZen.getIfcHknsyuruimeikbkrinfo());
                        syuukeiFile.setIfcTksyuruikigou(meisaiFileZen.getIfcTksyuruikigou());
                        syuukeiFile.setIfcTokuyakukbnkbkrinfo(meisaiFileZen.getIfcTokuyakukbnkbkrinfo());
                        syuukeiFile.setIfcTokuyakukatanmkbkrinfo(meisaiFileZen.getIfcTokuyakukatanmkbkrinfo());
                        syuukeiFile.setIfcKzkjysyusykbn(meisaiFileZen.getIfcKzkjysyusykbn());
                        syuukeiFile.setIfcKzkjysyusynm(meisaiFileZen.getIfcKzkjysyusynm());
                        syuukeiFile.setIfcShrkbnkbkrinfo(meisaiFileZen.getIfcShrkbnkbkrinfo());
                        syuukeiFile.setIfcShrkbnnmkbkrinfo(meisaiFileZen.getIfcShrkbnnmkbkrinfo());
                        syuukeiFile.setIfcKijykbn(meisaiFileZen.getIfcKijykbn());
                        syuukeiFile.setIfcUktkjigyounendo(meisaiFileZen.getIfcUktkjigyounendo());
                        syuukeiFile.setIfcShrkensuu(String.valueOf(shrKensuuCsv));
                        syuukeiFile.setIfcShrgk(shrkgkSyuukeiCsv.toString());
                        syuukeiFile.setIfcUktkjgnedshrkensuu(String.valueOf(uktkJigyouNendoShrKensuuCsv));
                        syuukeiFile.setIfcUktkjgnedshrgk(uktkJigyouNendoShrkgkSyuukeiCsv.toString());
                        syuukeiFile.setIfcShrkbnshrkensuu(String.valueOf(siharaiKbnShrKensuuCsv));
                        syuukeiFile.setIfcShrkbnshrgk(siharaiKbnShrkgkSyuukeiCsv.toString());
                        syuukeiFile.setIfcKzkshrkensuu(String.valueOf(siharaiKbnShrKensuuCsv));
                        syuukeiFile.setIfcKzkshrgk(siharaiKbnShrkgkSyuukeiCsv.toString());
                        syuukeiFile.setIfcTkkatashrkensuu(String.valueOf(siharaiKbnShrKensuuCsv));
                        syuukeiFile.setIfcTkkatashrgk(siharaiKbnShrkgkSyuukeiCsv.toString());
                        syuukeiFile.setIfcTksyuruishrkensuu(String.valueOf(siharaiKbnShrKensuuCsv));
                        syuukeiFile.setIfcTksyuruishrgk(siharaiKbnShrkgkSyuukeiCsv.toString());
                        syuukeiFile.setIfcHknsyuruishrkensuu(String.valueOf(hknsyruikbnShrKensuuCsv));
                        syuukeiFile.setIfcHknsyuruishrgk(hknsyruikbnShrkgkSyuukeiCsv.toString());
                        syuukeiFile.setIfcShrgkshrkensuu(String.valueOf(shrHknkShrKensuuCsv));
                        syuukeiFile.setIfcShrgkshrgk(shrHknkShrkgkSyuukeiCsv.toString());

                        syuukeiFileCsvLst.add(syuukeiFile);

                        meisaiFileZen = meisaiFileTugi;
                        hknknsyruikbnZen = hknknsyruikbnTugi;
                        segcdZen = segcdTugi;
                        siharaiKbnZen = siharaiKbnTugi;
                        keijyouKbnZen = keijyouKbnTugi;
                        uketukeYmZen = uketukeYmTugi;
                        shrKensuu = 1;
                        shrkingakuSyuukei = BizCurrency.valueOf(
                            new BigDecimal(meisaiFileTugi.getIfcShrgk()), BizCurrencyTypes.YEN);
                        uktkJigyouNendoShrKensuu = 1;
                        uktkJigyouNendoShrkgkSyuukei = BizCurrency.valueOf(
                            new BigDecimal(meisaiFileTugi.getIfcShrgk()), BizCurrencyTypes.YEN);
                        siharaiKbnShrKensuu = 1;
                        siharaiKbnShrkgkSyuukei = BizCurrency.valueOf(
                            new BigDecimal(meisaiFileTugi.getIfcShrgk()), BizCurrencyTypes.YEN);
                        hknsyruikbnShrKensuu = 1;
                        hknsyruikbnShrkgkSyuukei = BizCurrency.valueOf(
                            new BigDecimal(meisaiFileTugi.getIfcShrgk()), BizCurrencyTypes.YEN);
                        shrHknkShrKensuu = 1;
                        shrHknkShrkgkSyuukei = BizCurrency.valueOf(
                            new BigDecimal(meisaiFileTugi.getIfcShrgk()), BizCurrencyTypes.YEN);
                        kykSyuukeiKensuu = kykSyuukeiKensuu + 1;
                    }
                    else {
                        if (!segcdTugi.equals(segcdZen)) {
                            shrKensuuCsv = shrKensuu;
                            shrkgkSyuukeiCsv = shrkingakuSyuukei;
                            uktkJigyouNendoShrKensuuCsv = uktkJigyouNendoShrKensuu;
                            uktkJigyouNendoShrkgkSyuukeiCsv = uktkJigyouNendoShrkgkSyuukei;
                            siharaiKbnShrKensuuCsv = siharaiKbnShrKensuu;
                            siharaiKbnShrkgkSyuukeiCsv = siharaiKbnShrkgkSyuukei;
                            hknsyruikbnShrKensuuCsv = hknsyruikbnShrKensuu;
                            hknsyruikbnShrkgkSyuukeiCsv = hknsyruikbnShrkgkSyuukei;
                            shrHknkShrKensuuCsv = 0;
                            shrHknkShrkgkSyuukeiCsv = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

                            syuukeiFile.setIfcSknntisisyrhyj(meisaiFileZen.getIfcSknntisisyrhyj());
                            syuukeiFile.setIfcSyorikbnkbkrinfo(meisaiFileZen.getIfcSyorikbnkbkrinfo());
                            syuukeiFile.setIfcSyorikbnnmkbkrinfo(meisaiFileZen.getIfcSyorikbnnmkbkrinfo());
                            syuukeiFile.setIfcUktkym(uketukeYmZen);
                            syuukeiFile.setIfcHknknsyruikbn(meisaiFileZen.getIfcHknknsyruikbn());
                            syuukeiFile.setIfcShrhknknnm(meisaiFileZen.getIfcShrhknknnm());
                            syuukeiFile.setIfcSeglevelkbn(meisaiFileZen.getIfcSeglevelkbn());
                            syuukeiFile.setIfcHknsyruilevelkbn(meisaiFileZen.getIfcHknsyruilevelkbn());
                            syuukeiFile.setIfcHknsyuruimeikbkrinfo(meisaiFileZen.getIfcHknsyuruimeikbkrinfo());
                            syuukeiFile.setIfcTksyuruikigou(meisaiFileZen.getIfcTksyuruikigou());
                            syuukeiFile.setIfcTokuyakukbnkbkrinfo(meisaiFileZen.getIfcTokuyakukbnkbkrinfo());
                            syuukeiFile.setIfcTokuyakukatanmkbkrinfo(meisaiFileZen.getIfcTokuyakukatanmkbkrinfo());
                            syuukeiFile.setIfcKzkjysyusykbn(meisaiFileZen.getIfcKzkjysyusykbn());
                            syuukeiFile.setIfcKzkjysyusynm(meisaiFileZen.getIfcKzkjysyusynm());
                            syuukeiFile.setIfcShrkbnkbkrinfo(meisaiFileZen.getIfcShrkbnkbkrinfo());
                            syuukeiFile.setIfcShrkbnnmkbkrinfo(meisaiFileZen.getIfcShrkbnnmkbkrinfo());
                            syuukeiFile.setIfcKijykbn(meisaiFileZen.getIfcKijykbn());
                            syuukeiFile.setIfcUktkjigyounendo(meisaiFileZen.getIfcUktkjigyounendo());
                            syuukeiFile.setIfcShrkensuu(String.valueOf(shrKensuuCsv));
                            syuukeiFile.setIfcShrgk(shrkgkSyuukeiCsv.toString());
                            syuukeiFile.setIfcUktkjgnedshrkensuu(String.valueOf(uktkJigyouNendoShrKensuuCsv));
                            syuukeiFile.setIfcUktkjgnedshrgk(uktkJigyouNendoShrkgkSyuukeiCsv.toString());
                            syuukeiFile.setIfcShrkbnshrkensuu(String.valueOf(siharaiKbnShrKensuuCsv));
                            syuukeiFile.setIfcShrkbnshrgk(siharaiKbnShrkgkSyuukeiCsv.toString());
                            syuukeiFile.setIfcKzkshrkensuu(String.valueOf(siharaiKbnShrKensuuCsv));
                            syuukeiFile.setIfcKzkshrgk(siharaiKbnShrkgkSyuukeiCsv.toString());
                            syuukeiFile.setIfcTkkatashrkensuu(String.valueOf(siharaiKbnShrKensuuCsv));
                            syuukeiFile.setIfcTkkatashrgk(siharaiKbnShrkgkSyuukeiCsv.toString());
                            syuukeiFile.setIfcTksyuruishrkensuu(String.valueOf(siharaiKbnShrKensuuCsv));
                            syuukeiFile.setIfcTksyuruishrgk(siharaiKbnShrkgkSyuukeiCsv.toString());
                            syuukeiFile.setIfcHknsyuruishrkensuu(String.valueOf(hknsyruikbnShrKensuuCsv));
                            syuukeiFile.setIfcHknsyuruishrgk(hknsyruikbnShrkgkSyuukeiCsv.toString());
                            syuukeiFile.setIfcShrgkshrkensuu(String.valueOf(shrHknkShrKensuuCsv));
                            syuukeiFile.setIfcShrgkshrgk(shrHknkShrkgkSyuukeiCsv.toString());

                            syuukeiFileCsvLst.add(syuukeiFile);

                            meisaiFileZen = meisaiFileTugi;
                            hknknsyruikbnZen = hknknsyruikbnTugi;
                            segcdZen = segcdTugi;
                            siharaiKbnZen = siharaiKbnTugi;
                            keijyouKbnZen = keijyouKbnTugi;
                            uketukeYmZen = uketukeYmTugi;
                            shrKensuu = 1;
                            shrkingakuSyuukei = BizCurrency.valueOf(
                                new BigDecimal(meisaiFileTugi.getIfcShrgk()), BizCurrencyTypes.YEN);
                            uktkJigyouNendoShrKensuu = 1;
                            uktkJigyouNendoShrkgkSyuukei = BizCurrency.valueOf(
                                new BigDecimal(meisaiFileTugi.getIfcShrgk()), BizCurrencyTypes.YEN);
                            siharaiKbnShrKensuu = 1;
                            siharaiKbnShrkgkSyuukei = BizCurrency.valueOf(
                                new BigDecimal(meisaiFileTugi.getIfcShrgk()), BizCurrencyTypes.YEN);
                            hknsyruikbnShrKensuu = 1;
                            hknsyruikbnShrkgkSyuukei = BizCurrency.valueOf(
                                new BigDecimal(meisaiFileTugi.getIfcShrgk()), BizCurrencyTypes.YEN);
                            shrHknkShrKensuu = shrHknkShrKensuu + 1;
                            shrHknkShrkgkSyuukei = shrHknkShrkgkSyuukei.add(BizCurrency.valueOf(
                                new BigDecimal(meisaiFileTugi.getIfcShrgk()), BizCurrencyTypes.YEN));
                            kykSyuukeiKensuu = kykSyuukeiKensuu + 1;
                        }
                        else {
                            if (!siharaiKbnTugi.equals(siharaiKbnZen)) {

                                shrKensuuCsv = shrKensuu;
                                shrkgkSyuukeiCsv = shrkingakuSyuukei;
                                uktkJigyouNendoShrKensuuCsv = uktkJigyouNendoShrKensuu;
                                uktkJigyouNendoShrkgkSyuukeiCsv = uktkJigyouNendoShrkgkSyuukei;
                                siharaiKbnShrKensuuCsv = siharaiKbnShrKensuu;
                                siharaiKbnShrkgkSyuukeiCsv = siharaiKbnShrkgkSyuukei;
                                hknsyruikbnShrKensuuCsv = 0;
                                hknsyruikbnShrkgkSyuukeiCsv = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                                shrHknkShrKensuuCsv = 0;
                                shrHknkShrkgkSyuukeiCsv = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

                                syuukeiFile.setIfcSknntisisyrhyj(meisaiFileZen.getIfcSknntisisyrhyj());
                                syuukeiFile.setIfcSyorikbnkbkrinfo(meisaiFileZen.getIfcSyorikbnkbkrinfo());
                                syuukeiFile.setIfcSyorikbnnmkbkrinfo(meisaiFileZen.getIfcSyorikbnnmkbkrinfo());
                                syuukeiFile.setIfcUktkym(uketukeYmZen);
                                syuukeiFile.setIfcHknknsyruikbn(meisaiFileZen.getIfcHknknsyruikbn());
                                syuukeiFile.setIfcShrhknknnm(meisaiFileZen.getIfcShrhknknnm());
                                syuukeiFile.setIfcSeglevelkbn(meisaiFileZen.getIfcSeglevelkbn());
                                syuukeiFile.setIfcHknsyruilevelkbn(meisaiFileZen.getIfcHknsyruilevelkbn());
                                syuukeiFile.setIfcHknsyuruimeikbkrinfo(meisaiFileZen.getIfcHknsyuruimeikbkrinfo());
                                syuukeiFile.setIfcTksyuruikigou(meisaiFileZen.getIfcTksyuruikigou());
                                syuukeiFile.setIfcTokuyakukbnkbkrinfo(meisaiFileZen.getIfcTokuyakukbnkbkrinfo());
                                syuukeiFile.setIfcTokuyakukatanmkbkrinfo(meisaiFileZen.getIfcTokuyakukatanmkbkrinfo());
                                syuukeiFile.setIfcKzkjysyusykbn(meisaiFileZen.getIfcKzkjysyusykbn());
                                syuukeiFile.setIfcKzkjysyusynm(meisaiFileZen.getIfcKzkjysyusynm());
                                syuukeiFile.setIfcShrkbnkbkrinfo(meisaiFileZen.getIfcShrkbnkbkrinfo());
                                syuukeiFile.setIfcShrkbnnmkbkrinfo(meisaiFileZen.getIfcShrkbnnmkbkrinfo());
                                syuukeiFile.setIfcKijykbn(meisaiFileZen.getIfcKijykbn());
                                syuukeiFile.setIfcUktkjigyounendo(meisaiFileZen.getIfcUktkjigyounendo());
                                syuukeiFile.setIfcShrkensuu(String.valueOf(shrKensuuCsv));
                                syuukeiFile.setIfcShrgk(shrkgkSyuukeiCsv.toString());
                                syuukeiFile.setIfcUktkjgnedshrkensuu(String.valueOf(uktkJigyouNendoShrKensuuCsv));
                                syuukeiFile.setIfcUktkjgnedshrgk(uktkJigyouNendoShrkgkSyuukeiCsv.toString());
                                syuukeiFile.setIfcShrkbnshrkensuu(String.valueOf(siharaiKbnShrKensuuCsv));
                                syuukeiFile.setIfcShrkbnshrgk(siharaiKbnShrkgkSyuukeiCsv.toString());
                                syuukeiFile.setIfcKzkshrkensuu(String.valueOf(siharaiKbnShrKensuuCsv));
                                syuukeiFile.setIfcKzkshrgk(siharaiKbnShrkgkSyuukeiCsv.toString());
                                syuukeiFile.setIfcTkkatashrkensuu(String.valueOf(siharaiKbnShrKensuuCsv));
                                syuukeiFile.setIfcTkkatashrgk(siharaiKbnShrkgkSyuukeiCsv.toString());
                                syuukeiFile.setIfcTksyuruishrkensuu(String.valueOf(siharaiKbnShrKensuuCsv));
                                syuukeiFile.setIfcTksyuruishrgk(siharaiKbnShrkgkSyuukeiCsv.toString());
                                syuukeiFile.setIfcHknsyuruishrkensuu(String.valueOf(hknsyruikbnShrKensuuCsv));
                                syuukeiFile.setIfcHknsyuruishrgk(hknsyruikbnShrkgkSyuukeiCsv.toString());
                                syuukeiFile.setIfcShrgkshrkensuu(String.valueOf(shrHknkShrKensuuCsv));
                                syuukeiFile.setIfcShrgkshrgk(shrHknkShrkgkSyuukeiCsv.toString());

                                syuukeiFileCsvLst.add(syuukeiFile);

                                meisaiFileZen = meisaiFileTugi;
                                hknknsyruikbnZen = hknknsyruikbnTugi;
                                segcdZen = segcdTugi;
                                siharaiKbnZen = siharaiKbnTugi;
                                keijyouKbnZen = keijyouKbnTugi;
                                uketukeYmZen = uketukeYmTugi;
                                shrKensuu = 1;
                                shrkingakuSyuukei = BizCurrency.valueOf(
                                    new BigDecimal(meisaiFileTugi.getIfcShrgk()), BizCurrencyTypes.YEN);
                                uktkJigyouNendoShrKensuu = 1;
                                uktkJigyouNendoShrkgkSyuukei = BizCurrency.valueOf(
                                    new BigDecimal(meisaiFileTugi.getIfcShrgk()), BizCurrencyTypes.YEN);
                                siharaiKbnShrKensuu = 1;
                                siharaiKbnShrkgkSyuukei = BizCurrency.valueOf(
                                    new BigDecimal(meisaiFileTugi.getIfcShrgk()), BizCurrencyTypes.YEN);
                                hknsyruikbnShrKensuu = hknsyruikbnShrKensuu + 1;
                                hknsyruikbnShrkgkSyuukei = hknsyruikbnShrkgkSyuukei.add(BizCurrency.valueOf(
                                    new BigDecimal(meisaiFileTugi.getIfcShrgk()), BizCurrencyTypes.YEN));
                                shrHknkShrKensuu = shrHknkShrKensuu + 1;
                                shrHknkShrkgkSyuukei = shrHknkShrkgkSyuukei.add(BizCurrency.valueOf(
                                    new BigDecimal(meisaiFileTugi.getIfcShrgk()), BizCurrencyTypes.YEN));
                                kykSyuukeiKensuu = kykSyuukeiKensuu + 1;
                            }
                            else {
                                if (!keijyouKbnTugi.equals(keijyouKbnZen)) {
                                    shrKensuuCsv = shrKensuu;
                                    shrkgkSyuukeiCsv = shrkingakuSyuukei;
                                    uktkJigyouNendoShrKensuuCsv = uktkJigyouNendoShrKensuu;
                                    uktkJigyouNendoShrkgkSyuukeiCsv = uktkJigyouNendoShrkgkSyuukei;
                                    siharaiKbnShrKensuuCsv = 0;
                                    siharaiKbnShrkgkSyuukeiCsv = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                                    hknsyruikbnShrKensuuCsv = 0;
                                    hknsyruikbnShrkgkSyuukeiCsv = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                                    shrHknkShrKensuuCsv = 0;
                                    shrHknkShrkgkSyuukeiCsv = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

                                    syuukeiFile.setIfcSknntisisyrhyj(meisaiFileZen.getIfcSknntisisyrhyj());
                                    syuukeiFile.setIfcSyorikbnkbkrinfo(meisaiFileZen.getIfcSyorikbnkbkrinfo());
                                    syuukeiFile.setIfcSyorikbnnmkbkrinfo(meisaiFileZen.getIfcSyorikbnnmkbkrinfo());
                                    syuukeiFile.setIfcUktkym(uketukeYmZen);
                                    syuukeiFile.setIfcHknknsyruikbn(meisaiFileZen.getIfcHknknsyruikbn());
                                    syuukeiFile.setIfcShrhknknnm(meisaiFileZen.getIfcShrhknknnm());
                                    syuukeiFile.setIfcSeglevelkbn(meisaiFileZen.getIfcSeglevelkbn());
                                    syuukeiFile.setIfcHknsyruilevelkbn(meisaiFileZen.getIfcHknsyruilevelkbn());
                                    syuukeiFile.setIfcHknsyuruimeikbkrinfo(meisaiFileZen.getIfcHknsyuruimeikbkrinfo());
                                    syuukeiFile.setIfcTksyuruikigou(meisaiFileZen.getIfcTksyuruikigou());
                                    syuukeiFile.setIfcTokuyakukbnkbkrinfo(meisaiFileZen.getIfcTokuyakukbnkbkrinfo());
                                    syuukeiFile.setIfcTokuyakukatanmkbkrinfo(meisaiFileZen
                                        .getIfcTokuyakukatanmkbkrinfo());
                                    syuukeiFile.setIfcKzkjysyusykbn(meisaiFileZen.getIfcKzkjysyusykbn());
                                    syuukeiFile.setIfcKzkjysyusynm(meisaiFileZen.getIfcKzkjysyusynm());
                                    syuukeiFile.setIfcShrkbnkbkrinfo(meisaiFileZen.getIfcShrkbnkbkrinfo());
                                    syuukeiFile.setIfcShrkbnnmkbkrinfo(meisaiFileZen.getIfcShrkbnnmkbkrinfo());
                                    syuukeiFile.setIfcKijykbn(meisaiFileZen.getIfcKijykbn());
                                    syuukeiFile.setIfcUktkjigyounendo(meisaiFileZen.getIfcUktkjigyounendo());
                                    syuukeiFile.setIfcShrkensuu(String.valueOf(shrKensuuCsv));
                                    syuukeiFile.setIfcShrgk(shrkgkSyuukeiCsv.toString());
                                    syuukeiFile.setIfcUktkjgnedshrkensuu(String.valueOf(uktkJigyouNendoShrKensuuCsv));
                                    syuukeiFile
                                    .setIfcUktkjgnedshrgk(uktkJigyouNendoShrkgkSyuukeiCsv.toString());
                                    syuukeiFile.setIfcShrkbnshrkensuu(String.valueOf(siharaiKbnShrKensuuCsv));
                                    syuukeiFile.setIfcShrkbnshrgk(siharaiKbnShrkgkSyuukeiCsv.toString());
                                    syuukeiFile.setIfcKzkshrkensuu(String.valueOf(siharaiKbnShrKensuuCsv));
                                    syuukeiFile.setIfcKzkshrgk(siharaiKbnShrkgkSyuukeiCsv.toString());
                                    syuukeiFile.setIfcTkkatashrkensuu(String.valueOf(siharaiKbnShrKensuuCsv));
                                    syuukeiFile.setIfcTkkatashrgk(siharaiKbnShrkgkSyuukeiCsv.toString());
                                    syuukeiFile.setIfcTksyuruishrkensuu(String.valueOf(siharaiKbnShrKensuuCsv));
                                    syuukeiFile.setIfcTksyuruishrgk(siharaiKbnShrkgkSyuukeiCsv.toString());
                                    syuukeiFile.setIfcHknsyuruishrkensuu(String.valueOf(hknsyruikbnShrKensuuCsv));
                                    syuukeiFile.setIfcHknsyuruishrgk(hknsyruikbnShrkgkSyuukeiCsv.toString());
                                    syuukeiFile.setIfcShrgkshrkensuu(String.valueOf(shrHknkShrKensuuCsv));
                                    syuukeiFile.setIfcShrgkshrgk(shrHknkShrkgkSyuukeiCsv.toString());

                                    syuukeiFileCsvLst.add(syuukeiFile);

                                    meisaiFileZen = meisaiFileTugi;
                                    hknknsyruikbnZen = hknknsyruikbnTugi;
                                    segcdZen = segcdTugi;
                                    siharaiKbnZen = siharaiKbnTugi;
                                    keijyouKbnZen = keijyouKbnTugi;
                                    uketukeYmZen = uketukeYmTugi;
                                    shrKensuu = 1;
                                    shrkingakuSyuukei = BizCurrency.valueOf(
                                        new BigDecimal(meisaiFileTugi.getIfcShrgk()), BizCurrencyTypes.YEN);
                                    uktkJigyouNendoShrKensuu = 1;
                                    uktkJigyouNendoShrkgkSyuukei = BizCurrency.valueOf(
                                        new BigDecimal(meisaiFileTugi.getIfcShrgk()), BizCurrencyTypes.YEN);
                                    siharaiKbnShrKensuu = siharaiKbnShrKensuu + 1;
                                    siharaiKbnShrkgkSyuukei = siharaiKbnShrkgkSyuukei.add(BizCurrency.valueOf(
                                        new BigDecimal(meisaiFileTugi.getIfcShrgk()), BizCurrencyTypes.YEN));
                                    hknsyruikbnShrKensuu = hknsyruikbnShrKensuu + 1;
                                    hknsyruikbnShrkgkSyuukei = hknsyruikbnShrkgkSyuukei.add(BizCurrency.valueOf(
                                        new BigDecimal(meisaiFileTugi.getIfcShrgk()), BizCurrencyTypes.YEN));
                                    shrHknkShrKensuu = shrHknkShrKensuu + 1;
                                    shrHknkShrkgkSyuukei = shrHknkShrkgkSyuukei.add(BizCurrency.valueOf(
                                        new BigDecimal(meisaiFileTugi.getIfcShrgk()), BizCurrencyTypes.YEN));
                                    kykSyuukeiKensuu = kykSyuukeiKensuu + 1;
                                }
                                else {
                                    if (!uketukeYmTugi.equals(uketukeYmZen)) {
                                        shrKensuuCsv = shrKensuu;
                                        shrkgkSyuukeiCsv = shrkingakuSyuukei;
                                        uktkJigyouNendoShrKensuuCsv = 0;
                                        uktkJigyouNendoShrkgkSyuukeiCsv = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                                        siharaiKbnShrKensuuCsv = 0;
                                        siharaiKbnShrkgkSyuukeiCsv = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                                        hknsyruikbnShrKensuuCsv = 0;
                                        hknsyruikbnShrkgkSyuukeiCsv = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                                        shrHknkShrKensuuCsv = 0;
                                        shrHknkShrkgkSyuukeiCsv = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

                                        syuukeiFile.setIfcSknntisisyrhyj(meisaiFileZen.getIfcSknntisisyrhyj());
                                        syuukeiFile.setIfcSyorikbnkbkrinfo(meisaiFileZen.getIfcSyorikbnkbkrinfo());
                                        syuukeiFile.setIfcSyorikbnnmkbkrinfo(meisaiFileZen.getIfcSyorikbnnmkbkrinfo());
                                        syuukeiFile.setIfcUktkym(uketukeYmZen);
                                        syuukeiFile.setIfcHknknsyruikbn(meisaiFileZen.getIfcHknknsyruikbn());
                                        syuukeiFile.setIfcShrhknknnm(meisaiFileZen.getIfcShrhknknnm());
                                        syuukeiFile.setIfcSeglevelkbn(meisaiFileZen.getIfcSeglevelkbn());
                                        syuukeiFile.setIfcHknsyruilevelkbn(meisaiFileZen.getIfcHknsyruilevelkbn());
                                        syuukeiFile.setIfcHknsyuruimeikbkrinfo(meisaiFileZen
                                            .getIfcHknsyuruimeikbkrinfo());
                                        syuukeiFile.setIfcTksyuruikigou(meisaiFileZen.getIfcTksyuruikigou());
                                        syuukeiFile
                                        .setIfcTokuyakukbnkbkrinfo(meisaiFileZen.getIfcTokuyakukbnkbkrinfo());
                                        syuukeiFile.setIfcTokuyakukatanmkbkrinfo(meisaiFileZen
                                            .getIfcTokuyakukatanmkbkrinfo());
                                        syuukeiFile.setIfcKzkjysyusykbn(meisaiFileZen.getIfcKzkjysyusykbn());
                                        syuukeiFile.setIfcKzkjysyusynm(meisaiFileZen.getIfcKzkjysyusynm());
                                        syuukeiFile.setIfcShrkbnkbkrinfo(meisaiFileZen.getIfcShrkbnkbkrinfo());
                                        syuukeiFile.setIfcShrkbnnmkbkrinfo(meisaiFileZen.getIfcShrkbnnmkbkrinfo());
                                        syuukeiFile.setIfcKijykbn(meisaiFileZen.getIfcKijykbn());
                                        syuukeiFile.setIfcUktkjigyounendo(meisaiFileZen.getIfcUktkjigyounendo());
                                        syuukeiFile.setIfcShrkensuu(String.valueOf(shrKensuuCsv));
                                        syuukeiFile.setIfcShrgk(shrkgkSyuukeiCsv.toString());
                                        syuukeiFile.setIfcUktkjgnedshrkensuu(String
                                            .valueOf(uktkJigyouNendoShrKensuuCsv));
                                        syuukeiFile.setIfcUktkjgnedshrgk(uktkJigyouNendoShrkgkSyuukeiCsv
                                            .toString());
                                        syuukeiFile.setIfcShrkbnshrkensuu(String.valueOf(siharaiKbnShrKensuuCsv));
                                        syuukeiFile.setIfcShrkbnshrgk(siharaiKbnShrkgkSyuukeiCsv.toString());
                                        syuukeiFile.setIfcKzkshrkensuu(String.valueOf(siharaiKbnShrKensuuCsv));
                                        syuukeiFile.setIfcKzkshrgk(siharaiKbnShrkgkSyuukeiCsv.toString());
                                        syuukeiFile.setIfcTkkatashrkensuu(String.valueOf(siharaiKbnShrKensuuCsv));
                                        syuukeiFile.setIfcTkkatashrgk(siharaiKbnShrkgkSyuukeiCsv.toString());
                                        syuukeiFile.setIfcTksyuruishrkensuu(String.valueOf(siharaiKbnShrKensuuCsv));
                                        syuukeiFile.setIfcTksyuruishrgk(siharaiKbnShrkgkSyuukeiCsv.toString());
                                        syuukeiFile.setIfcHknsyuruishrkensuu(String.valueOf(hknsyruikbnShrKensuuCsv));
                                        syuukeiFile
                                        .setIfcHknsyuruishrgk(hknsyruikbnShrkgkSyuukeiCsv.toString());
                                        syuukeiFile.setIfcShrgkshrkensuu(String.valueOf(shrHknkShrKensuuCsv));
                                        syuukeiFile.setIfcShrgkshrgk(shrHknkShrkgkSyuukeiCsv.toString());

                                        syuukeiFileCsvLst.add(syuukeiFile);

                                        meisaiFileZen = meisaiFileTugi;
                                        hknknsyruikbnZen = hknknsyruikbnTugi;
                                        segcdZen = segcdTugi;
                                        siharaiKbnZen = siharaiKbnTugi;
                                        keijyouKbnZen = keijyouKbnTugi;
                                        uketukeYmZen = uketukeYmTugi;
                                        shrKensuu = 1;
                                        shrkingakuSyuukei = BizCurrency.valueOf(
                                            new BigDecimal(meisaiFileTugi.getIfcShrgk()), BizCurrencyTypes.YEN);
                                        uktkJigyouNendoShrKensuu = uktkJigyouNendoShrKensuu + 1;
                                        uktkJigyouNendoShrkgkSyuukei = uktkJigyouNendoShrkgkSyuukei.add(BizCurrency
                                            .valueOf(
                                                new BigDecimal(meisaiFileTugi.getIfcShrgk()), BizCurrencyTypes.YEN));
                                        siharaiKbnShrKensuu = siharaiKbnShrKensuu + 1;
                                        siharaiKbnShrkgkSyuukei = siharaiKbnShrkgkSyuukei.add(BizCurrency.valueOf(
                                            new BigDecimal(meisaiFileTugi.getIfcShrgk()), BizCurrencyTypes.YEN));
                                        hknsyruikbnShrKensuu = hknsyruikbnShrKensuu + 1;
                                        hknsyruikbnShrkgkSyuukei = hknsyruikbnShrkgkSyuukei.add(BizCurrency.valueOf(
                                            new BigDecimal(meisaiFileTugi.getIfcShrgk()), BizCurrencyTypes.YEN));
                                        shrHknkShrKensuu = shrHknkShrKensuu + 1;
                                        shrHknkShrkgkSyuukei = shrHknkShrkgkSyuukei.add(BizCurrency.valueOf(
                                            new BigDecimal(meisaiFileTugi.getIfcShrgk()), BizCurrencyTypes.YEN));
                                        kykSyuukeiKensuu = kykSyuukeiKensuu + 1;
                                    }
                                    else {
                                        meisaiFileZen = meisaiFileTugi;
                                        hknknsyruikbnZen = hknknsyruikbnTugi;
                                        segcdZen = segcdTugi;
                                        siharaiKbnZen = siharaiKbnTugi;
                                        keijyouKbnZen = keijyouKbnTugi;
                                        uketukeYmZen = uketukeYmTugi;
                                        shrKensuu = shrKensuu + 1;
                                        shrkingakuSyuukei = shrkingakuSyuukei.add(BizCurrency.valueOf(
                                            new BigDecimal(meisaiFileTugi.getIfcShrgk()), BizCurrencyTypes.YEN));
                                        uktkJigyouNendoShrKensuu = uktkJigyouNendoShrKensuu + 1;
                                        uktkJigyouNendoShrkgkSyuukei = uktkJigyouNendoShrkgkSyuukei
                                            .add(BizCurrency.valueOf(new BigDecimal(meisaiFileTugi.getIfcShrgk()),
                                                BizCurrencyTypes.YEN));
                                        siharaiKbnShrKensuu = siharaiKbnShrKensuu + 1;
                                        siharaiKbnShrkgkSyuukei = siharaiKbnShrkgkSyuukei.add(BizCurrency.valueOf(
                                            new BigDecimal(meisaiFileTugi.getIfcShrgk()), BizCurrencyTypes.YEN));
                                        hknsyruikbnShrKensuu = hknsyruikbnShrKensuu + 1;
                                        hknsyruikbnShrkgkSyuukei = hknsyruikbnShrkgkSyuukei.add(BizCurrency.valueOf(
                                            new BigDecimal(meisaiFileTugi.getIfcShrgk()), BizCurrencyTypes.YEN));
                                        shrHknkShrKensuu = shrHknkShrKensuu + 1;
                                        shrHknkShrkgkSyuukei = shrHknkShrkgkSyuukei.add(BizCurrency.valueOf(
                                            new BigDecimal(meisaiFileTugi.getIfcShrgk()), BizCurrencyTypes.YEN));
                                    }
                                }
                            }
                        }
                    }
                }
            }

            shrKensuuCsv = shrKensuu;
            shrkgkSyuukeiCsv = shrkingakuSyuukei;
            uktkJigyouNendoShrKensuuCsv = uktkJigyouNendoShrKensuu;
            uktkJigyouNendoShrkgkSyuukeiCsv = uktkJigyouNendoShrkgkSyuukei;
            siharaiKbnShrKensuuCsv = siharaiKbnShrKensuu;
            siharaiKbnShrkgkSyuukeiCsv = siharaiKbnShrkgkSyuukei;
            hknsyruikbnShrKensuuCsv = hknsyruikbnShrKensuu;
            hknsyruikbnShrkgkSyuukeiCsv = hknsyruikbnShrkgkSyuukei;
            shrHknkShrKensuuCsv = shrHknkShrKensuu;
            shrHknkShrkgkSyuukeiCsv = shrHknkShrkgkSyuukei;

            SiKbnKeiriKykSyuukeiLayoutFile syuukeiFileLastData = SWAKInjector
                .getInstance(SiKbnKeiriKykSyuukeiLayoutFile.class);
            syuukeiFileLastData.setIfcSknntisisyrhyj(meisaiFileZen.getIfcSknntisisyrhyj());
            syuukeiFileLastData.setIfcSyorikbnkbkrinfo(meisaiFileZen.getIfcSyorikbnkbkrinfo());
            syuukeiFileLastData.setIfcSyorikbnnmkbkrinfo(meisaiFileZen.getIfcSyorikbnnmkbkrinfo());
            syuukeiFileLastData.setIfcUktkym(uketukeYmZen);
            syuukeiFileLastData.setIfcHknknsyruikbn(meisaiFileZen.getIfcHknknsyruikbn());
            syuukeiFileLastData.setIfcShrhknknnm(meisaiFileZen.getIfcShrhknknnm());
            syuukeiFileLastData.setIfcSeglevelkbn(meisaiFileZen.getIfcSeglevelkbn());
            syuukeiFileLastData.setIfcHknsyruilevelkbn(meisaiFileZen.getIfcHknsyruilevelkbn());
            syuukeiFileLastData.setIfcHknsyuruimeikbkrinfo(meisaiFileZen.getIfcHknsyuruimeikbkrinfo());
            syuukeiFileLastData.setIfcTksyuruikigou(meisaiFileZen.getIfcTksyuruikigou());
            syuukeiFileLastData.setIfcTokuyakukbnkbkrinfo(meisaiFileZen.getIfcTokuyakukbnkbkrinfo());
            syuukeiFileLastData.setIfcTokuyakukatanmkbkrinfo(meisaiFileZen.getIfcTokuyakukatanmkbkrinfo());
            syuukeiFileLastData.setIfcKzkjysyusykbn(meisaiFileZen.getIfcKzkjysyusykbn());
            syuukeiFileLastData.setIfcKzkjysyusynm(meisaiFileZen.getIfcKzkjysyusynm());
            syuukeiFileLastData.setIfcShrkbnkbkrinfo(meisaiFileZen.getIfcShrkbnkbkrinfo());
            syuukeiFileLastData.setIfcShrkbnnmkbkrinfo(meisaiFileZen.getIfcShrkbnnmkbkrinfo());
            syuukeiFileLastData.setIfcKijykbn(meisaiFileZen.getIfcKijykbn());
            syuukeiFileLastData.setIfcUktkjigyounendo(meisaiFileZen.getIfcUktkjigyounendo());
            syuukeiFileLastData.setIfcShrkensuu(String.valueOf(shrKensuuCsv));
            syuukeiFileLastData.setIfcShrgk(shrkgkSyuukeiCsv.toString());
            syuukeiFileLastData.setIfcKimskensuu("0");
            syuukeiFileLastData.setIfcKimsshrs("0");
            syuukeiFileLastData.setIfcSmskensuu("0");
            syuukeiFileLastData.setIfcSmsshrs("0");
            syuukeiFileLastData.setIfcKimssmskknnyuhyj("0");
            syuukeiFileLastData.setIfcUktkjgnedshrkensuu(String.valueOf(uktkJigyouNendoShrKensuuCsv));
            syuukeiFileLastData.setIfcUktkjgnedshrgk(uktkJigyouNendoShrkgkSyuukeiCsv.toString());
            syuukeiFileLastData.setIfcUktkjgnedkimskensuu("0");
            syuukeiFileLastData.setIfcUktkjgnedkimsshrs("0");
            syuukeiFileLastData.setIfcUktkjgnedsmskensuu("0");
            syuukeiFileLastData.setIfcUktkjgnedsmsshrs("0");
            syuukeiFileLastData.setIfcShrkbnshrkensuu(String.valueOf(siharaiKbnShrKensuuCsv));
            syuukeiFileLastData.setIfcShrkbnshrgk(siharaiKbnShrkgkSyuukeiCsv.toString());
            syuukeiFileLastData.setIfcShrkbnkimskensuu("0");
            syuukeiFileLastData.setIfcShrkbnkimsshrs("0");
            syuukeiFileLastData.setIfcShrkbnsmskensuu("0");
            syuukeiFileLastData.setIfcShrkbnsmsshrs("0");
            syuukeiFileLastData.setIfcKzkshrkensuu(String.valueOf(siharaiKbnShrKensuuCsv));
            syuukeiFileLastData.setIfcKzkshrgk(siharaiKbnShrkgkSyuukeiCsv.toString());
            syuukeiFileLastData.setIfcKzkkimskensuu("0");
            syuukeiFileLastData.setIfcKzkkimsshrs("0");
            syuukeiFileLastData.setIfcKzksmskensuu("0");
            syuukeiFileLastData.setIfcKzksmsshrs("0");
            syuukeiFileLastData.setIfcTkkatashrkensuu(String.valueOf(siharaiKbnShrKensuuCsv));
            syuukeiFileLastData.setIfcTkkatashrgk(siharaiKbnShrkgkSyuukeiCsv.toString());
            syuukeiFileLastData.setIfcTkkatakimskensuu("0");
            syuukeiFileLastData.setIfcTkkatakimsshrs("0");
            syuukeiFileLastData.setIfcTkkatasmskensuu("0");
            syuukeiFileLastData.setIfcTkkatasmsshrs("0");
            syuukeiFileLastData.setIfcTksyuruishrkensuu(String.valueOf(siharaiKbnShrKensuuCsv));
            syuukeiFileLastData.setIfcTksyuruishrgk(siharaiKbnShrkgkSyuukeiCsv.toString());
            syuukeiFileLastData.setIfcTksyuruikimskensuu("0");
            syuukeiFileLastData.setIfcTksyuruikimsshrs("0");
            syuukeiFileLastData.setIfcTksyuruismskensuu("0");
            syuukeiFileLastData.setIfcTksyuruismsshrs("0");
            syuukeiFileLastData.setIfcHknsyuruishrkensuu(String.valueOf(hknsyruikbnShrKensuuCsv));
            syuukeiFileLastData.setIfcHknsyuruishrgk(hknsyruikbnShrkgkSyuukeiCsv.toString());
            syuukeiFileLastData.setIfcHknsyuruikimskensuu("0");
            syuukeiFileLastData.setIfcHknsyuruikimsshrs("0");
            syuukeiFileLastData.setIfcHknsyuruismskensuu("0");
            syuukeiFileLastData.setIfcHknsyuruismsshrs("0");
            syuukeiFileLastData.setIfcShrgkshrkensuu(String.valueOf(shrHknkShrKensuuCsv));
            syuukeiFileLastData.setIfcShrgkshrgk(shrHknkShrkgkSyuukeiCsv.toString());
            syuukeiFileLastData.setIfcShrgkkimskensuu("0");
            syuukeiFileLastData.setIfcShrgkkimsshrs("0");
            syuukeiFileLastData.setIfcShrgksmskensuu("0");
            syuukeiFileLastData.setIfcShrgksmsshrs("0");
            syuukeiFileLastData.setIfcYobisiharai(" ");
            syuukeiFileCsvLst.add(syuukeiFileLastData);

            kykSyuukeiKensuu = kykSyuukeiKensuu + 1;

            C_ErrorKbn errorKbnSyuukeiFile = bzFileUploadUtil.exec(C_FileSyuruiCdKbn.SI_KBNKEIRIKYKSYUUKEI,
                syuukeiFileCsvLst, true);

            if (C_ErrorKbn.ERROR.eq(errorKbnSyuukeiFile)) {
                throw new BizAppException(MessageId.EBF0129, kinou.getKinouNm());
            }
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(nyuuryokuKensuu), SIKBNKEIRI_FILE));
        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(kykmeisaiKensuu),
            SIKBNKEIRI_KYKMEISAI_FILE));
        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(kykSyuukeiKensuu),
            SIKBNKEIRI_SYUUKEI_FILE));
    }

    private List<SiKbnKeiriKykMeisaiLayoutFile> editSiKbnKeiriKykMeisaiFile(JT_SkKihon pSkKihon,
        BizDate pSyoriYmdFrom, BizDate pSyoriYmdTo) {
        JT_SkKihon skKihon = pSkKihon;
        List<SiKbnKeiriKykMeisaiLayoutFile> kykMeisaiLst = Lists.newArrayList();

        List<JT_Sk> skLst = skKihon.getSks();
        JT_Sk sk = skLst.get(skLst.size() - 1);

        List<JT_SiRireki> siRirekiLst = skKihon.getSiRirekis();

        SortJT_SiRireki sortSiRireki = SWAKInjector.getInstance(SortJT_SiRireki.class);

        JT_SiRireki siRireki = sortSiRireki.OrderJT_SiRirekiByPkDesc(siRirekiLst).get(0);

        List<JT_SkJiyuu> skJiyuuLst = sk.getSkJiyuus();
        List<JT_SiDetail> siDetailLst = skJiyuuLst.get(0).getSiDetails();

        List<JT_SateiSyouninRireki> sateiSyouninRirekiLst = pSkKihon.getSateiSyouninRirekis();

        SortJT_SateiSyouninRireki sateiSyouninRirekiSorter = SWAKInjector.getInstance(SortJT_SateiSyouninRireki.class);
        sateiSyouninRirekiSorter.OrderJT_SateiSyouninRirekiByPkDesc(sateiSyouninRirekiLst);

        JT_SateiSyouninRireki sateiSyouninRireki = new JT_SateiSyouninRireki();

        for (JT_SateiSyouninRireki sateiSyouninRirekiIcnt : sateiSyouninRirekiLst) {

            if (C_SyorikekkaKbn.SIHARAI.eq(sateiSyouninRirekiIcnt.getSyorikekkakbn()) ||
                C_SyorikekkaKbn.HUSIHARAI.eq(sateiSyouninRirekiIcnt.getSyorikekkakbn()) ||
                C_SyorikekkaKbn.SIBOUS_SAIGAIHIGAITOU.eq(sateiSyouninRirekiIcnt.getSyorikekkakbn())) {

                sateiSyouninRireki = sateiSyouninRirekiIcnt;

                break;
            }
        }

        String syono = skKihon.getSyono();
        BizDate uketukeYmd = skKihon.getSiboukaritrkymd();
        BizDate denpyouYmd = siRireki.getTyakkinymd();
        BizDate shrsyoriYmd = siRireki.getShrsyoriymd();
        String siharaiKbn = "";
        Map<String, String> keijyouKbnAndUktkjigyounendoMap;

        if (C_SyorikekkaKbn.SIHARAI.eq(sateiSyouninRireki.getSyorikekkakbn()) &&
            ((BizDateUtil.compareYmd(denpyouYmd, pSyoriYmdFrom) != BizDateUtil.COMPARE_LESSER) &&
                BizDateUtil.compareYmd(denpyouYmd, pSyoriYmdTo) != BizDateUtil.COMPARE_GREATER)) {
            siharaiKbn = SIHARAIKBN_SIHARAI;

            keijyouKbnAndUktkjigyounendoMap = getKijykbnAndUktkjigyounendo(denpyouYmd, uketukeYmd);
        }
        else if (C_SyorikekkaKbn.HUSIHARAI.eq(sateiSyouninRireki.getSyorikekkakbn()) &&
            ((BizDateUtil.compareYmd(shrsyoriYmd, pSyoriYmdFrom) != BizDateUtil.COMPARE_LESSER) &&
                BizDateUtil.compareYmd(shrsyoriYmd, pSyoriYmdTo) != BizDateUtil.COMPARE_GREATER)) {
            if (C_HushrGeninKbn.KAIJYO_KKTIH.eq(sateiSyouninRireki.getHushrgeninkbn()) ||
                C_HushrGeninKbn.KAIJYO_JD.eq(sateiSyouninRireki.getHushrgeninkbn()) ||
                C_HushrGeninKbn.KAIJYO_SONOTA.eq(sateiSyouninRireki.getHushrgeninkbn())) {
                siharaiKbn = SIHARAIKBN_KAIJYO;
            }
            else if (C_HushrGeninKbn.MENSEKI_SNDJST.eq(sateiSyouninRireki.getHushrgeninkbn()) ||
                C_HushrGeninKbn.MENSEKI_JNDJST.eq(sateiSyouninRireki.getHushrgeninkbn()) ||
                C_HushrGeninKbn.MENSEKI_TNDJST.eq(sateiSyouninRireki.getHushrgeninkbn()) ||
                C_HushrGeninKbn.KOI.eq(sateiSyouninRireki.getHushrgeninkbn()) ||
                C_HushrGeninKbn.SONOTA_MS.eq(sateiSyouninRireki.getHushrgeninkbn())) {
                siharaiKbn = SIHARAIKBN_MENSEKI;
            }
            else if (C_HushrGeninKbn.MUKOU_SG.eq(sateiSyouninRireki.getHushrgeninkbn()) ||
                C_HushrGeninKbn.MUKOU_HHST.eq(sateiSyouninRireki.getHushrgeninkbn()) ||
                C_HushrGeninKbn.MUKOU_SONOTA.eq(sateiSyouninRireki.getHushrgeninkbn())) {
                siharaiKbn = SIHARAIKBN_MUKOU;
            }

            keijyouKbnAndUktkjigyounendoMap = getKijykbnAndUktkjigyounendo(shrsyoriYmd.addBusinessDays(1), uketukeYmd);
        }
        else if (C_SyorikekkaKbn.SIBOUS_SAIGAIHIGAITOU.eq(sateiSyouninRireki.getSyorikekkakbn()) &&
            ((BizDateUtil.compareYmd(denpyouYmd, pSyoriYmdFrom) != BizDateUtil.COMPARE_LESSER) &&
                BizDateUtil.compareYmd(denpyouYmd, pSyoriYmdTo) != BizDateUtil.COMPARE_GREATER)) {
            if (C_HushrGeninKbn.SAI_GR.eq(sateiSyouninRireki.getHushrgeninkbn()) ||
                C_HushrGeninKbn.SAI_GH.eq(sateiSyouninRireki.getHushrgeninkbn()) ||
                C_HushrGeninKbn.SAI_JJ.eq(sateiSyouninRireki.getHushrgeninkbn()) ||
                C_HushrGeninKbn.SAI_SONOTA.eq(sateiSyouninRireki.getHushrgeninkbn())) {
                siharaiKbn = SIHARAIKBN_SAIGAIHIGAITOU;
            }
            else if (C_HushrGeninKbn.SAI_MENSEKI_JKT.eq(sateiSyouninRireki.getHushrgeninkbn()) ||
                C_HushrGeninKbn.SAI_MENSEKI_SYK.eq(sateiSyouninRireki.getHushrgeninkbn()) ||
                C_HushrGeninKbn.SAI_MENSEKI_MMK.eq(sateiSyouninRireki.getHushrgeninkbn()) ||
                C_HushrGeninKbn.SAI_MENSEKI_SSN.eq(sateiSyouninRireki.getHushrgeninkbn()) ||
                C_HushrGeninKbn.SAI_MENSEKI_SONOTA.eq(sateiSyouninRireki.getHushrgeninkbn())) {
                siharaiKbn = SIHARAIKBN_SAIGAISMENSEKI;
            }
            keijyouKbnAndUktkjigyounendoMap = getKijykbnAndUktkjigyounendo(denpyouYmd, uketukeYmd);
        }
        else {
            return null;
        }

        String keijyouKbn = keijyouKbnAndUktkjigyounendoMap.get("0");
        String uketukeJigyouNendo = keijyouKbnAndUktkjigyounendoMap.get("1");
        for (JT_SiDetail siDetailTemp : siDetailLst) {
            if (BizUtil.isZero(siDetailTemp.getKyhkg())) {
                continue;
            }

            BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei(siDetailTemp.getSyouhncd(),
                siDetailTemp.getSyouhnsdno());
            JM_Kyuuhu kyuuhu = siharaiDomManager.getKyuuhu(siDetailTemp.getKyuuhucd());
            BzSegmentCdSyutoku bzSegmentCdSyutoku = SWAKInjector.getInstance(BzSegmentCdSyutoku.class);
            SyouhinbetuSegmentBean syouhinbetuSegmentBean = bzSegmentCdSyutoku.exec(siDetailTemp.getSyouhncd(), sk.getKyktuukasyu());
            String kigou = siDetailTemp.getSyouhncd().substring(0, 2);
            String hknknsyruikbn = kyuuhu.getHokenkinsyuruikbn().getValue();
            String shrhknknnm = kyuuhu.getHokenkinsyuruikbn().getContent();
            String seglevelkbn = syouhinbetuSegmentBean.getSegcd1().getValue().substring(0, 2);
            String hknsyruilevelkbn = syouhinbetuSegmentBean.getSegcd1().getValue().substring(2, 4);
            String hknsyuruimeikbkrinfo = syouhnZokusei.getSyouhnnmryaku();

            BizCurrency shrkingaku = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
            if (!C_SyorikekkaKbn.HUSIHARAI.eq(sateiSyouninRireki.getSyorikekkakbn())) {
                if (C_Tuukasyu.JPY.eq(sk.getShrtuukasyu())) {
                    if (C_Tuukasyu.JPY.eq(sk.getKyktuukasyu())) {
                        shrkingaku = siDetailTemp.getKyhkg();
                    }
                    else {
                        shrkingaku = siDetailTemp.getYenkyhgk();
                    }
                }
                else {
                    GetKawaseRate getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);

                    BizDate wkKnsnkijyunYmd = null;

                    if(sk.getHubikanryouymd() != null){
                        wkKnsnkijyunYmd = sk.getHubikanryouymd();
                    } else {
                        wkKnsnkijyunYmd = sk.getSyoruiukeymd();
                    }

                    C_ErrorKbn errorKbn = getKawaseRate.exec(wkKnsnkijyunYmd,
                        C_KawaserateSyuruiKbn.PM17JIKAWASERATE, sk.getKyktuukasyu(), C_Tuukasyu.JPY,
                        C_KawasetekiyoKbn.TTM, C_KawasetsryKbn.JISSEIRATE, C_EigyoubiHoseiKbn.YOKUEIGYOUBI, C_YouhiKbn.HUYOU);
                    if (C_ErrorKbn.OK.eq(errorKbn)) {
                        BizNumber kawaserate = getKawaseRate.getKawaserate();
                        KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);
                        shrkingaku = keisanGaikakanzan.exec(C_Tuukasyu.JPY, siDetailTemp.getKyhkg(),
                            kawaserate, C_HasuusyoriKbn.SUTE);
                    }
                    else {
                        shrkingaku = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                    }
                }
            }
            else {
                shrkingaku = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
            }

            SiKbnKeiriKykMeisaiLayoutFile meisaiFileBean = SWAKInjector
                .getInstance(SiKbnKeiriKykMeisaiLayoutFile.class);
            meisaiFileBean.setIfcSyono(syono);
            meisaiFileBean.setIfcSknntisisyrhyj(ZERO);
            meisaiFileBean.setIfcSyorikbnkbkrinfo(SYORIKBN_SIHARAI);
            meisaiFileBean.setIfcSyorikbnnmkbkrinfo(SYORIKBNNM_SIHARAI);
            meisaiFileBean.setIfcUketukeymd(uketukeYmd);
            meisaiFileBean.setIfcDenpyouymd(denpyouYmd);
            meisaiFileBean.setIfcKigou(kigou);
            meisaiFileBean.setIfcHknknsyruikbn(hknknsyruikbn);
            meisaiFileBean.setIfcShrhknknnm(shrhknknnm);
            meisaiFileBean.setIfcSeglevelkbn(seglevelkbn);
            meisaiFileBean.setIfcHknsyruilevelkbn(hknsyruilevelkbn);
            meisaiFileBean.setIfcHknsyuruimeikbkrinfo(hknsyuruimeikbkrinfo);
            meisaiFileBean.setIfcTksyuruikigou("");
            meisaiFileBean.setIfcTokuyakukbnkbkrinfo(ZERO);
            meisaiFileBean.setIfcTokuyakukatanmkbkrinfo("");
            meisaiFileBean.setIfcKzkjysyusykbn(ZERO);
            meisaiFileBean.setIfcKzkjysyusynm("");
            meisaiFileBean.setIfcShrkbnkbkrinfo(siharaiKbn);
            meisaiFileBean.setIfcShrkbnnmkbkrinfo("");
            meisaiFileBean.setIfcKijykbn(keijyouKbn);
            meisaiFileBean.setIfcUktkjigyounendo(uketukeJigyouNendo);
            meisaiFileBean.setIfcShrgk(shrkingaku.toString());
            meisaiFileBean.setIfcKimsshrs("0");
            meisaiFileBean.setIfcSmsshrs("0");
            kykMeisaiLst.add(meisaiFileBean);
        }

        if (kykMeisaiLst.size() > 0) {
            return kykMeisaiLst;
        }

        return null;
    }

    private Map<String, String> getKijykbnAndUktkjigyounendo(BizDate pDenpyouYmd, BizDate pUketukeYmd) {
        Map<String, String> keijyouMap = new HashMap<>();

        if (pDenpyouYmd == null || pUketukeYmd == null) {
            keijyouMap.put("0", KEIJYOUKBN_SONOTA);
            keijyouMap.put("1", UKETUKEJIGYOUNENDO_SONOTA);
            return keijyouMap;
        }

        SetKessanNensibi setKessanNensibi = SWAKInjector.getInstance(SetKessanNensibi.class);

        BizDate kessanNensibiDenpyou = setKessanNensibi.exec(pDenpyouYmd);
        int denpyouJigyounendo = kessanNensibiDenpyou.getYear();

        BizDate kessanNensibiUketuke = setKessanNensibi.exec(pUketukeYmd);
        int uketukeJigyounendo = kessanNensibiUketuke.getYear();

        int compareResult = denpyouJigyounendo - uketukeJigyounendo;
        if (compareResult == 0) {
            keijyouMap.put("0", KEIJYOUKBN_TOUNENDO);
            keijyouMap.put("1", UKETUKEJIGYOUNENDO_TOUNENDO);
        }
        else if (compareResult == 1) {
            keijyouMap.put("0", KEIJYOUKBN_SINKIBIKIN);
            keijyouMap.put("1", UKETUKEJIGYOUNENDO_SINKIBIKIN);
        }
        else if (compareResult == 2) {
            keijyouMap.put("0", KEIJYOUKBN_SAIBIKIN);
            keijyouMap.put("1", UKETUKEJIGYOUNENDO_SAIBIKIN);
        }
        else if (compareResult == 3) {
            keijyouMap.put("0", KEIJYOUKBN_SAISAIBIKIN);
            keijyouMap.put("1", UKETUKEJIGYOUNENDO_SAISAIBIKIN);
        }
        else if (compareResult >= 4) {
            keijyouMap.put("0", KEIJYOUKBN_SONOTA);
            keijyouMap.put("1", UKETUKEJIGYOUNENDO_SONOTA);
        }

        return keijyouMap;
    }

    private String changeZenkakuSeireki(BizDate pUketukeYmd) {
        String changedUketukeYmd = "";
        if (pUketukeYmd != null) {
            changedUketukeYmd = DateFormatUtil.dateYmKANJI(pUketukeYmd.getBizDateYM());
            changedUketukeYmd = ConvertUtil.toZenNumeric(changedUketukeYmd);
            changedUketukeYmd = ConvertUtil.toZenHiraKana(changedUketukeYmd);
        }
        return changedUketukeYmd;
    }
}
