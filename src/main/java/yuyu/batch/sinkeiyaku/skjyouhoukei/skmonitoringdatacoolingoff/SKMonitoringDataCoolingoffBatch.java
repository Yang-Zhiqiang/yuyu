package yuyu.batch.sinkeiyaku.skjyouhoukei.skmonitoringdatacoolingoff;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import jp.co.slcs.swak.util.string.ConvertUtil;
import yuyu.batch.sinkeiyaku.skjyouhoukei.skmonitoringdatacoolingoff.dba.SKMonitoringDataCoolingoffDao;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.bzcommon.KeisanGaikakanzan;
import yuyu.common.biz.bzfiledl.BzFileUploadUtil;
import yuyu.common.biz.interf.ConvBossRnkKoumoku;
import yuyu.common.biz.interf.ConvBossRnkKoumokuBean;
import yuyu.common.hozen.khcommon.HanteiTyotikuseihokenBean;
import yuyu.common.hozen.khcommon.SetManryoubi;
import yuyu.common.hozen.khcommon.SetTyotikuseihokenhyouji;
import yuyu.common.sinkeiyaku.skcommon.EditPalRenkeiKoumoku;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_FileSyuruiCdKbn;
import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.classification.C_HonninkakuninSyoruiKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Ketkekkacd;
import yuyu.def.classification.C_KknsmnKbn;
import yuyu.def.classification.C_KykKbn;
import yuyu.def.classification.C_NyknsyubetuKbn;
import yuyu.def.classification.C_PtratkituukasiteiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.HT_DakuhiKettei;
import yuyu.def.db.entity.HT_Henkin;
import yuyu.def.db.entity.HT_KouzaJyouhou;
import yuyu.def.db.entity.HT_MosDairiten;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_MosSyouhn;
import yuyu.def.db.entity.HT_Nyuukin;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.file.csv.SkMonitoringDataCoolingoffCsvFile;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.def.sinkeiyaku.sorter.SortHT_MosSyouhn;
import yuyu.def.sinkeiyaku.sorter.SortHT_Nyuukin;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

import com.google.common.collect.Lists;

/**
 * 新契約 情報系 新契約モニタリングデータ抽出（クーリングオフ）
 */
public class SKMonitoringDataCoolingoffBatch implements Batch {

    public static final String TYSYTTAISYOUTABLEID = HT_SyoriCTL.TABLE_NAME;

    public static final String RECOVERYFILTERID = "Sk001";

    private final int FILE_SAVE_MAX_LIST_COUNT = 2000;

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private SKMonitoringDataCoolingoffDao sKMonitoringDataCoolingoffDao;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {


        String ibKakutyoujobcd = bzBatchParam.getIbKakutyoujobcd();
        BizDate syoriYmd = bzBatchParam.getSyoriYmd();
        List<SkMonitoringDataCoolingoffCsvFile> skMonitoringDataCoolingoffCsvFileLst = new ArrayList<>();
        skMonitoringDataCoolingoffCsvFileLst.clear();
        long skMonitoringDataCoolingoffOutKensuu = 0;
        int fileRenban = 1;

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(
            MessageId.IBW1018), ibKakutyoujobcd));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(
            MessageId.IBW0003), String.valueOf(syoriYmd)));

        BizDate taisyoukknFrom = BizDate.valueOf("00000000");
        BizDate taisyoukknTo = BizDate.valueOf("00000000");

        if (syoriYmd.getMonth() >= 1 && syoriYmd.getMonth() <= 6) {
            taisyoukknFrom = BizDate.valueOf(syoriYmd.getPreviousYear().getBizDateY(), 4, 1);
            taisyoukknTo = BizDate.valueOf(syoriYmd.getBizDateY(), 3, 31);
        }
        else if (syoriYmd.getMonth() >= 7 && syoriYmd.getMonth() <= 11) {
            taisyoukknFrom = BizDate.valueOf(syoriYmd.getBizDateY(), 4, 1);
            taisyoukknTo = BizDate.valueOf(syoriYmd.getBizDateY(), 9, 30);
        }
        else if (syoriYmd.getMonth() == 12) {
            taisyoukknFrom = BizDate.valueOf(syoriYmd.getBizDateY(), 4, 1);
            taisyoukknTo = BizDate.valueOf(syoriYmd.getNextYear().getBizDateY(), 3, 31);
        }


        SortHT_MosSyouhn mosSyouhnSort = SWAKInjector.getInstance(SortHT_MosSyouhn.class);
        EditPalRenkeiKoumoku editPalRenkeiKoumoku = SWAKInjector.getInstance(EditPalRenkeiKoumoku.class);
        ConvBossRnkKoumoku convBossRnkKoumoku = SWAKInjector.getInstance(ConvBossRnkKoumoku.class);
        KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);
        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
        SetManryoubi setManryoubi = SWAKInjector.getInstance(SetManryoubi.class);
        SetTyotikuseihokenhyouji setTyotikuseihokenhyouji = SWAKInjector.getInstance(
            SetTyotikuseihokenhyouji.class);

        try (ExDBResults<HT_SyoriCTL> syoriCTLLst =
            sKMonitoringDataCoolingoffDao.getSyoriCTLsBySrsyoriymdHuseirituItems(ibKakutyoujobcd, taisyoukknFrom,
                taisyoukknTo)) {

            for (HT_SyoriCTL syoriCTL : syoriCTLLst) {

                String mosNo = syoriCTL.getMosno();

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(ibKakutyoujobcd);
                bzRecoveryDatasikibetuBean.setIbTableid(TYSYTTAISYOUTABLEID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(RECOVERYFILTERID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(mosNo);

                List<HT_Nyuukin> nyuukinLst = syoriCTL.getNyuukinByNyknsyubetuNe(C_NyknsyubetuKbn.CREDIT);

                if (nyuukinLst.size() != 0) {

                    HT_MosKihon mosKihon = syoriCTL.getMosKihon();

                    HT_KouzaJyouhou kouzaJyouhou = syoriCTL.getKouzaJyouhou();
                    HT_DakuhiKettei dakuhiKettei = sinkeiyakuDomManager.getDakuhiKetteiByMosnoMaxDakuhiktrenno(mosNo);
                    List<HT_MosDairiten> mosDairitenLst = syoriCTL.getMosDairitens();

                    List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhns();
                    mosSyouhnLst = mosSyouhnSort
                        .OrderHT_MosSyouhnByBM_SyouhnZokuseiSyutkkbnSyohnsortnoAsc(mosSyouhnLst);

                    editPalRenkeiKoumoku.getSyuEntity(mosSyouhnLst);
                    BM_SyouhnZokusei syouhnZokusei = editPalRenkeiKoumoku.getSyouhnZokusei();
                    HT_MosSyouhn mosSyouhn = editPalRenkeiKoumoku.getMosSyouhn();
                    ConvBossRnkKoumokuBean convBossRnkKoumokuBean = convBossRnkKoumoku.execAll(syouhnZokusei,
                        mosKihon.getHrkkeiro(),mosKihon.getKyktuukasyu());

                    String kyknmKn = editPalRenkeiKoumoku.editKyknmkn(mosKihon.getKykkbn(),
                        mosKihon.getHhknnmkn(), mosKihon.getKyknmkn(), 18);
                    kyknmKn = ConvertUtil.toHanAll(kyknmKn, 0, 1);

                    String kyknmKj = editPalRenkeiKoumoku.editKyknmkj(mosKihon.getKykkbn(),
                        mosKihon.getHhknnmkj(), mosKihon.getKyknmkj(), 32);

                    BizDate kykseiYmd = mosKihon.getHhknseiymd();

                    if (C_KykKbn.KEIHI_BETU.eq(mosKihon.getKykkbn())) {

                        kykseiYmd = mosKihon.getKykseiymd();
                    }

                    String hrkKeiroKbn = editPalRenkeiKoumoku.editHrkKeiroKbnSyuudanCreditHkm(mosKihon.getHrkkeiro(),
                        mosKihon.getHrkkaisuu());

                    String kzkykdouHyouji = "0";

                    if (kouzaJyouhou != null) {

                        kzkykdouHyouji = kouzaJyouhou.getKzkykdoukbn().getValue();
                    }

                    BizCurrency syokaiharaikomipYen = BizCurrency.valueOf(0,BizCurrencyTypes.YEN);
                    Map<CurrencyType, BizCurrency> sumRskngkMap = new HashMap<CurrencyType, BizCurrency>();
                    Map<CurrencyType, BizCurrency> sumHnkngkMap = new HashMap<CurrencyType, BizCurrency>();
                    BizDate syokairsymd = BizDate.valueOf("00000000");

                    sumRskngkMap = syoriCTL.getNyuukinSumRyosyugkByNyknsyubetukbn();

                    List<HT_Henkin> henkinLst = syoriCTL.getHenkinsByHnknsyoriymdNull();

                    BizCurrency hnkngkTmp = null;

                    CurrencyType type = null;
                    for (HT_Henkin henkin : henkinLst) {

                        hnkngkTmp = henkin.getHnkngk();

                        if (hnkngkTmp != null) {

                            type = hnkngkTmp.getType();
                            if (sumHnkngkMap.get(type) == null) {

                                sumHnkngkMap.put(type, hnkngkTmp);
                            } else {

                                sumHnkngkMap.put(type, sumHnkngkMap.get(type).add(hnkngkTmp));
                            }
                        }
                    }

                    SortHT_Nyuukin sortNyuukin = SWAKInjector.getInstance(SortHT_Nyuukin.class);
                    nyuukinLst = sortNyuukin.OrderHT_NyuukinByRyosyuymdAsc(nyuukinLst);

                    syokairsymd = nyuukinLst.get(0).getRyosyuymd();

                    for (CurrencyType sumRskngk : sumRskngkMap.keySet()) {

                        C_Tuukasyu tuukasyu = henkanTuuka.henkanTuukaTypeToKbn(sumRskngk);

                        if (C_Tuukasyu.JPY.eq(tuukasyu)) {

                            if (sumHnkngkMap.get(sumRskngk) == null) {

                                syokaiharaikomipYen = syokaiharaikomipYen.add(sumRskngkMap.get(sumRskngk));
                            }

                            else {

                                syokaiharaikomipYen = syokaiharaikomipYen.add(sumRskngkMap.get(sumRskngk)).subtract(sumHnkngkMap.get(sumRskngk));
                            }
                        }

                        else {
                            BizCurrency  syokaiharaikomipGk = BizCurrency.valueOf(0,sumRskngk);

                            if (sumHnkngkMap.get(sumRskngk) == null) {

                                syokaiharaikomipGk = sumRskngkMap.get(sumRskngk);
                            }

                            else {

                                syokaiharaikomipGk = sumRskngkMap.get(sumRskngk).subtract(sumHnkngkMap.get(sumRskngk));
                            }

                            BizNumber enknsnKawaseRate = editPalRenkeiKoumoku.getEnknsnKawaseRate(tuukasyu,
                                syokairsymd, mosKihon.getHrkkaisuu(), mosKihon.getZennoumousideumu(),
                                mosKihon.getIkkatubaraikbn());
                            syokaiharaikomipYen = syokaiharaikomipYen.add(
                                keisanGaikakanzan.exec(C_Tuukasyu.JPY, syokaiharaikomipGk, enknsnKawaseRate, C_HasuusyoriKbn.SUTE));
                        }

                    }

                    BizNumber yoteiriritu = mosSyouhn.getYoteiriritu();
                    BizCurrency hokenryou = mosSyouhn.getSyutkp();

                    if (C_PtratkituukasiteiKbn.HRKTUUKA.eq(syouhnZokusei.getPtratkituukasiteikbn())
                        && !C_Hrkkaisuu.BLNK.eq(mosKihon.getHrkkaisuu())
                        && !C_Hrkkaisuu.ITIJI.eq(mosKihon.getHrkkaisuu())) {

                        yoteiriritu = BizNumber.ZERO;
                        hokenryou = mosSyouhn.getHrktuukasyutkp();
                    }

                    BizDate haraimanYmd =  setManryoubi.exec(
                        mosKihon.getKykymd(),
                        mosKihon.getHhknnen(),
                        mosSyouhn.getHrkkkn(),
                        C_KknsmnKbn.valueOf(mosSyouhn.getHrkkknsmnkbn().getValue()));

                    HanteiTyotikuseihokenBean hanteiTyotikuseihokenBean = SWAKInjector.getInstance(
                        HanteiTyotikuseihokenBean.class);

                    hanteiTyotikuseihokenBean.setSyouhnCd(mosSyouhn.getSyouhncd());
                    hanteiTyotikuseihokenBean.setSyouhnsdNo(mosSyouhn.getSyouhnsdno());
                    hanteiTyotikuseihokenBean.setRyouritusdNo(mosSyouhn.getRyouritusdno());
                    hanteiTyotikuseihokenBean.setYoteiriritu(yoteiriritu);
                    hanteiTyotikuseihokenBean.setHrkkaisuu(mosKihon.getHrkkaisuu());
                    hanteiTyotikuseihokenBean.setHknkknsmnkbn(mosSyouhn.getHknkknsmnkbn());
                    hanteiTyotikuseihokenBean.setHrkkknsmnkbn(mosSyouhn.getHrkkknsmnkbn());
                    hanteiTyotikuseihokenBean.setHrkkkn(mosSyouhn.getHrkkkn());
                    hanteiTyotikuseihokenBean.setHknkkn(mosSyouhn.getHknkkn());
                    hanteiTyotikuseihokenBean.setHhknnen(mosKihon.getHhknnen());
                    hanteiTyotikuseihokenBean.setHhknsei(mosKihon.getHhknsei());
                    hanteiTyotikuseihokenBean.setKihons(mosSyouhn.getSeitoukihons());
                    hanteiTyotikuseihokenBean.setHokenryou(hokenryou);
                    hanteiTyotikuseihokenBean.setKykymd(mosKihon.getKykymd());
                    hanteiTyotikuseihokenBean.setKyktuukaSyu(mosKihon.getKyktuukasyu());
                    hanteiTyotikuseihokenBean.setMosymd(mosKihon.getMosymd());
                    hanteiTyotikuseihokenBean.setYoteirrthendohosyurrt(syouhnZokusei.getYoteirirituminhosyouritu());
                    hanteiTyotikuseihokenBean.setHrkkeiro(mosKihon.getHrkkeiro());
                    hanteiTyotikuseihokenBean.setHaraimanymd(haraimanYmd);
                    hanteiTyotikuseihokenBean.setTyotikuseihokenhyoujihanteiflag(true);
                    hanteiTyotikuseihokenBean.setDai1hknkkn(mosSyouhn.getDai1hknkkn());

                    C_ErrorKbn errorKbn = setTyotikuseihokenhyouji.hanteiTyotikuseihoken(hanteiTyotikuseihokenBean);

                    C_UmuKbn houteityotkhknFlg = setTyotikuseihokenhyouji.getHouteityotkhknhyj();

                    C_UmuKbn maitosikaiyakuhr5000iyoFlg = C_UmuKbn.NONE;

                    if (C_ErrorKbn.OK.eq(errorKbn)) {

                        maitosikaiyakuhr5000iyoFlg = setTyotikuseihokenhyouji.getTyotkhknhyj();
                    }
                    else {

                        if (!C_UmuKbn.ARI.eq(houteityotkhknFlg)) {

                            maitosikaiyakuhr5000iyoFlg = C_UmuKbn.ARI;
                        }
                    }

                    C_UmuKbn over100manflg = C_UmuKbn.NONE;

                    if (syokaiharaikomipYen.compareTo(BizCurrency.valueOf(1000000, BizCurrencyTypes.YEN)) > 0) {
                        over100manflg = C_UmuKbn.ARI;
                    }

                    String mosjihonninkknnKbn = "";
                    if (C_HonninkakuninSyoruiKbn.UNTEN.eq(mosKihon.getKykhonninkakninsyoruikbn())) {

                        mosjihonninkknnKbn = "01";
                    }
                    else if (C_HonninkakuninSyoruiKbn.PASSPORT.eq(mosKihon.getKykhonninkakninsyoruikbn())) {

                        mosjihonninkknnKbn = "02";

                    }
                    else if (C_HonninkakuninSyoruiKbn.ZAIRYUUCARD.eq(mosKihon.getKykhonninkakninsyoruikbn())) {

                        mosjihonninkknnKbn = "05";

                    }

                    else if (C_HonninkakuninSyoruiKbn.KOKUMINKENKOUHOKEN.eq(mosKihon.getKykhonninkakninsyoruikbn()) ||
                        C_HonninkakuninSyoruiKbn.KENKOUHOKEN.eq(mosKihon.getKykhonninkakninsyoruikbn()) ||
                        C_HonninkakuninSyoruiKbn.SENINHOKEN.eq(mosKihon.getKykhonninkakninsyoruikbn()) ||
                        C_HonninkakuninSyoruiKbn.KAIGOHOKEN.eq(mosKihon.getKykhonninkakninsyoruikbn()) ||
                        C_HonninkakuninSyoruiKbn.KOUKIKOUREISYAIRYOU.eq(mosKihon.getKykhonninkakninsyoruikbn()) ||
                        C_HonninkakuninSyoruiKbn.KENKOUHOKENHIYATOI.eq(mosKihon.getKykhonninkakninsyoruikbn()) ||
                        C_HonninkakuninSyoruiKbn.KOKKAKOUMUINKYOUSAI.eq(mosKihon.getKykhonninkakninsyoruikbn()) ||
                        C_HonninkakuninSyoruiKbn.TIHOUKOUMUINKYOUSAI.eq(mosKihon.getKykhonninkakninsyoruikbn()) ||
                        C_HonninkakuninSyoruiKbn.SIRITUGAKKOUKYOUINKYOUSAI.eq(mosKihon.getKykhonninkakninsyoruikbn())) {

                        mosjihonninkknnKbn = "04";

                    }
                    else {

                        mosjihonninkknnKbn = "06";

                    }

                    String mostrksKbn = "2";

                    if (C_Ketkekkacd.MOS_TORIKESI.eq(dakuhiKettei.getKetkekkacd())) {

                        mostrksKbn = "1";
                    }

                    String hrkkaiSuu =  editPalRenkeiKoumoku.editHrkkaisuu(mosKihon);

                    SkMonitoringDataCoolingoffCsvFile skMonitoringDataCoolingoffCsvFile =
                        SWAKInjector.getInstance(SkMonitoringDataCoolingoffCsvFile.class);

                    skMonitoringDataCoolingoffCsvFile.setIfcMosno(mosNo);
                    skMonitoringDataCoolingoffCsvFile.setIfcSyono(syoriCTL.getSyono());
                    skMonitoringDataCoolingoffCsvFile.setIfcOkyksmno("0000000000");
                    skMonitoringDataCoolingoffCsvFile.setIfcKyknmknhan(kyknmKn);
                    skMonitoringDataCoolingoffCsvFile.setIfcKyknmkj(kyknmKj);
                    skMonitoringDataCoolingoffCsvFile.setIfcKykseiymd(kykseiYmd.toString());
                    skMonitoringDataCoolingoffCsvFile.setIfcCommonkihontikucd(mosKihon.getTsinyno());
                    skMonitoringDataCoolingoffCsvFile.setIfcKykymdstr(mosKihon.getKykymd().toString());
                    skMonitoringDataCoolingoffCsvFile.setIfcLastzugkymd("00000000");
                    skMonitoringDataCoolingoffCsvFile.setIfcZuruigk("0");
                    skMonitoringDataCoolingoffCsvFile.setIfcLastmeighnksyoriymd("00000000");
                    skMonitoringDataCoolingoffCsvFile.setIfcHrkkeirokbn(hrkKeiroKbn);
                    skMonitoringDataCoolingoffCsvFile.setIfcSyuunoukeirokbn(convBossRnkKoumokuBean.getSyuunouKeiroKbn());
                    skMonitoringDataCoolingoffCsvFile.setIfcKykkzdoukbn(kzkykdouHyouji);
                    skMonitoringDataCoolingoffCsvFile.setIfcAtukaisisyacd("000");
                    skMonitoringDataCoolingoffCsvFile.setIfcAtukaisibucd("0000");

                    String atukaikojinCd = mosDairitenLst.get(0).getBosyuucd();
                    if (BizUtil.isBlank(atukaikojinCd)){
                        atukaikojinCd = "000000";
                    }
                    skMonitoringDataCoolingoffCsvFile.setIfcAtukaikojincd(atukaikojinCd);

                    skMonitoringDataCoolingoffCsvFile.setIfcMrkykhyj("0");
                    skMonitoringDataCoolingoffCsvFile.setIfcNaibukykhyj("0");
                    skMonitoringDataCoolingoffCsvFile.setIfcJikokykhyj("0");
                    skMonitoringDataCoolingoffCsvFile.setIfcHjnkykhyj("0");
                    skMonitoringDataCoolingoffCsvFile.setIfcCommonsyoricd("");
                    skMonitoringDataCoolingoffCsvFile.setIfcHouteityotkhknhyj(houteityotkhknFlg.getValue());
                    skMonitoringDataCoolingoffCsvFile.setIfcTyotkhknhyj(maitosikaiyakuhr5000iyoFlg.getValue());
                    skMonitoringDataCoolingoffCsvFile.setIfcSyouhnbunruikbn(convBossRnkKoumokuBean.getSyouhinBunruiKbn());
                    skMonitoringDataCoolingoffCsvFile.setIfcSyouhnnmkbn(convBossRnkKoumokuBean.getSyouhnNmKbn());
                    skMonitoringDataCoolingoffCsvFile.setIfcHighriskflg("0");
                    skMonitoringDataCoolingoffCsvFile.setIfcCommonsisyanm("");
                    skMonitoringDataCoolingoffCsvFile.setIfcSosikinm("");
                    skMonitoringDataCoolingoffCsvFile.setIfcSyokaiphrkgk(syokaiharaikomipYen.toString());
                    skMonitoringDataCoolingoffCsvFile.setIfcFsthrkpnyknhhkbn("21");
                    skMonitoringDataCoolingoffCsvFile.setIfcOver100manflg(over100manflg.getValue());
                    skMonitoringDataCoolingoffCsvFile.setIfcOver50manflg("0");
                    skMonitoringDataCoolingoffCsvFile.setIfcSeikeikeirokbn("00");
                    skMonitoringDataCoolingoffCsvFile.setIfcMosjihonninkknnkbn(mosjihonninkknnKbn);
                    skMonitoringDataCoolingoffCsvFile.setIfcMossyoumetukbn("4");
                    skMonitoringDataCoolingoffCsvFile.setIfcMossyoumetukktiymd(syoriCTL.getSrsyoriymd().toString());
                    skMonitoringDataCoolingoffCsvFile.setIfcMostrkskbn(mostrksKbn);
                    skMonitoringDataCoolingoffCsvFile.setIfcMostrkssyousairiyuukbn(dakuhiKettei.getTorikesisyousairiyuucd().getValue());
                    skMonitoringDataCoolingoffCsvFile.setIfcHrkkaisuustr(hrkkaiSuu);
                    skMonitoringDataCoolingoffCsvFile.setIfcTrhkjikakkbn("2");
                    skMonitoringDataCoolingoffCsvFile.setIfcNyuukinjoutaikbn(syoriCTL.getNyuukinjoutaikbn().getValue());
                    skMonitoringDataCoolingoffCsvFile.setIfcJigyoukeiyakuhyouji("0");
                    skMonitoringDataCoolingoffCsvFile.setIfcNyknkaisuu("00");
                    skMonitoringDataCoolingoffCsvFile.setIfcKykhhkndouhyouji("0");
                    skMonitoringDataCoolingoffCsvFile.setIfcAnniskcd("00000000");
                    skMonitoringDataCoolingoffCsvFile.setIfcNyuuryokuanniskcd("00000000");
                    skMonitoringDataCoolingoffCsvFile.setIfcHjndaikjmeigi("");

                    skMonitoringDataCoolingoffCsvFileLst.add(skMonitoringDataCoolingoffCsvFile);

                    skMonitoringDataCoolingoffOutKensuu = skMonitoringDataCoolingoffOutKensuu + 1;

                }
            }
        }


        BzFileUploadUtil bzFileUploadUtil = SWAKInjector.getInstance(BzFileUploadUtil.class);

        if (skMonitoringDataCoolingoffCsvFileLst.size() == 0) {
            C_ErrorKbn errorKbn = bzFileUploadUtil.exec(
                C_FileSyuruiCdKbn.SK_MONITORINGDATACSVFCOOLINGOFF,
                skMonitoringDataCoolingoffCsvFileLst,
                true,
                String.valueOf(1));

            if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                throw new BizAppException(MessageId.EBF0129, "ファイルアップロードユーティリティ");
            }
        }
        else {
            List<List<SkMonitoringDataCoolingoffCsvFile>> bunkatuList = Lists.partition(
                skMonitoringDataCoolingoffCsvFileLst, FILE_SAVE_MAX_LIST_COUNT);

            for (List<SkMonitoringDataCoolingoffCsvFile> csvFileLst : bunkatuList) {

                C_ErrorKbn errorKbn = bzFileUploadUtil.exec(
                    C_FileSyuruiCdKbn.SK_MONITORINGDATACSVFCOOLINGOFF,
                    csvFileLst,
                    true,
                    String.valueOf(String.valueOf(fileRenban)));

                if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                    throw new BizAppException(MessageId.EBF0129, "ファイルアップロードユーティリティ");
                }
                fileRenban = fileRenban + 1;
            }
        }

        bzRecoveryDatasikibetuBean.initializeBlank();

        batchLogger.info(MessageUtil.getMessage(
            MessageId.IBF0001, String.valueOf(skMonitoringDataCoolingoffOutKensuu)));

    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery = SWAKInjector.getInstance(
            BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }

}
