package yuyu.batch.sinkeiyaku.skijitoukei.sksyusiboutoukeisks;

import java.util.Arrays;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateSpan;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_IjitoukeiKaijyoKbn;
import yuyu.def.classification.C_IjitoukeiZennouKbn;
import yuyu.def.classification.C_Ketkekkacd;
import yuyu.def.classification.C_KokutiKbn;
import yuyu.def.classification.C_SkeijimuKbn;
import yuyu.def.classification.C_SntkhouKbn;
import yuyu.def.classification.C_Tkhukaumu;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_Syoubyou;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.HM_SiinBunrui;
import yuyu.def.db.entity.HT_IjitoukeiMeisai;
import yuyu.def.db.entity.ZT_SyuSibouToukeiTy;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

import com.google.common.base.Strings;

/**
 * 新契約 医事統計 主契約死亡統計作成
 */
public class SkSyuSibouToukeiSksBatch implements Batch {

    private static final String TYSYTTAISYOUTABLEID = "HT_IjitoukeiMeisai";

    private static final String RECOVERYFILTERID = "Bz001";

    private static final String TASKNM = "主契約死亡統計作成";

    private static final String [] SIINCDSYOKITI = { "0", "00", "000" };

    private static final String DAISIINCDBYOUSI = "1";

    private static final String TYUUSIINCDSONOTA = "19";

    private static final String SYOUSIINCDSONOTA = "800";

    private static final String DAISIINCDSYOKITI = "0";

    private static final String TYUUSIINCDSYOKITI = "00";

    private static final String SYOUSIINCDSYOKITI = "000";


    private static final String BLANK = "";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private BzRecoveryDatasikibetuBean recoverDataBean;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        BizDate syoriYmd = bzBatchParam.getSyoriYmd();
        String kakutyouJobCd = bzBatchParam.getIbKakutyoujobcd();

        batchLogger.info(MessageUtil.getMessage(
            MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003), String.valueOf(syoriYmd)));
        batchLogger.info(MessageUtil.getMessage(
            MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW1018), String.valueOf(kakutyouJobCd)));

        long syoriKensuu = 0;
        BizDate syoumetuymdFrom = null;
        BizDate syoumetuymdTo = null;
        BizDate idousyoriymdTo = null;

        int syoriMonth = syoriYmd.getMonth();
        int syoriYear = syoriYmd.getYear();

        if (syoriMonth == 1) {
            syoumetuymdFrom = BizDate.valueOf(syoriYear - 21, 4, 1);
            syoumetuymdTo = BizDate.valueOf(syoriYear - 1, 6, 30);
            idousyoriymdTo = BizDate.valueOf(syoriYear - 1, 10, 31);
        }
        else if (syoriMonth == 2 || syoriMonth == 3 || syoriMonth == 4) {
            syoumetuymdFrom = BizDate.valueOf(syoriYear - 21, 4, 1);
            syoumetuymdTo = BizDate.valueOf(syoriYear - 1, 9, 30);
            idousyoriymdTo = BizDate.valueOf(syoriYear, 1, 31);
        }
        else if (syoriMonth == 5 || syoriMonth == 6 || syoriMonth == 7) {
            syoumetuymdFrom = BizDate.valueOf(syoriYear - 21, 4, 1);
            syoumetuymdTo = BizDate.valueOf(syoriYear - 1, 12, 31);
            idousyoriymdTo = BizDate.valueOf(syoriYear, 4, 30);
        }
        else if (syoriMonth == 8 || syoriMonth == 9 || syoriMonth == 10) {
            syoumetuymdFrom = BizDate.valueOf(syoriYear - 20, 4, 1);
            syoumetuymdTo = BizDate.valueOf(syoriYear, 3, 31);
            idousyoriymdTo = BizDate.valueOf(syoriYear, 7, 31);
        }
        else  {
            syoumetuymdFrom = BizDate.valueOf(syoriYear - 20, 4, 1);
            syoumetuymdTo = BizDate.valueOf(syoriYear, 6, 30);
            idousyoriymdTo = BizDate.valueOf(syoriYear, 10, 31);
        }

        try (ExDBResults<HT_IjitoukeiMeisai> ijitoukeiMeisaiLst =
            sinkeiyakuDomManager.getIjitoukeiMeisaisBySyuSibouToukeiSksSyoriTaisyou(
                kakutyouJobCd, syoumetuymdFrom, syoumetuymdTo, syoumetuymdTo.getBizDateYM(), idousyoriymdTo);
            EntityInserter<ZT_SyuSibouToukeiTy> syuSibouToukeiTyInserter = new EntityInserter<>()) {

            BM_SyouhnZokusei syouhnZokusei = null;
            HM_SiinBunrui siinBunrui = null;
            BM_Syoubyou syoubyouMst = null;
            ZT_SyuSibouToukeiTy syuSibouToukeiTy = null;
            String htKoukuBetu;
            BizDate htSyoriYmd = null;
            String htToutatuNenrei;
            String htHrkhouKbn;
            String htSnsHuhu;
            String htKetteiKekaKbn;
            String htSyoubyouTyuuBunrui;
            String htSyoubyouCd1x5;
            String htSyoubyouCd2x5;
            String htDaisiinCd;
            String htTyuuSiinCd;
            String htSyouSiinCd;
            String htSoukiSibouHyj;
            String htKeikaKikanKbn;
            String htKoudoSyougaiariHyj;
            String htKaijyoKbn;
            String htHanbaiKeirokbn;
            String sykSbyensitihsyuTyhkUmu;
            String jyudkaigomehrTkhkUmu;
            String htImuStiyuSbusManen;
            String ijtkyznkbn;
            String symtgenincd1keta;
            String symtgenincd2keta;
            String teikiSiharaikinManen;

            for (HT_IjitoukeiMeisai ijitoukeiMeisai : ijitoukeiMeisaiLst) {

                htKoukuBetu = BLANK;
                htSyoriYmd = null;
                htToutatuNenrei = BLANK;
                htHrkhouKbn = BLANK;
                htSnsHuhu = BLANK;
                htKetteiKekaKbn = "0";
                htSyoubyouTyuuBunrui = BLANK;
                htSyoubyouCd1x5 = BLANK;
                htSyoubyouCd2x5 = BLANK;
                htDaisiinCd = BLANK;
                htTyuuSiinCd = BLANK;
                htSyouSiinCd = BLANK;
                htSoukiSibouHyj = BLANK;
                htKeikaKikanKbn = BLANK;
                htKoudoSyougaiariHyj = BLANK;
                htKaijyoKbn = BLANK;
                htHanbaiKeirokbn = BLANK;
                sykSbyensitihsyuTyhkUmu = BLANK;
                jyudkaigomehrTkhkUmu = BLANK;
                htImuStiyuSbusManen = ijitoukeiMeisai.getImustiyusbusmanen().toAdsoluteString();
                ijtkyznkbn = BLANK;
                if (!BizUtil.isBlank(ijitoukeiMeisai.getSymtgenincd())) {
                    symtgenincd1keta = ijitoukeiMeisai.getSymtgenincd().substring(0, 1);
                    if (ijitoukeiMeisai.getSymtgenincd().length() > 2) {
                        symtgenincd2keta = ijitoukeiMeisai.getSymtgenincd().substring(0, 2);
                    }
                    else {
                        symtgenincd2keta = ijitoukeiMeisai.getSymtgenincd();
                    }
                } else {
                    symtgenincd1keta = BLANK;
                    symtgenincd2keta = BLANK;
                }
                teikiSiharaikinManen = ijitoukeiMeisai.getTeikisiharaikinmanen().toAdsoluteString();

                recoverDataBean.setIbKakutyoujobcd(kakutyouJobCd);
                recoverDataBean.setIbTableid(TYSYTTAISYOUTABLEID);
                recoverDataBean.setIbRecoveryfilterid(RECOVERYFILTERID);
                recoverDataBean.setIbRecoveryfilterkey1(ijitoukeiMeisai.getSyono());

                syouhnZokusei = bizDomManager.getSyouhnZokusei(
                    ijitoukeiMeisai.getSyouhncd(), ijitoukeiMeisai.getSyouhnsdno());

                siinBunrui = ijitoukeiMeisai.getSiinBunrui();

                syoubyouMst = bizDomManager.getSyoubyou(ijitoukeiMeisai.getSyoubyoucd1());

                if (C_SntkhouKbn.KKT.eq(ijitoukeiMeisai.getSntkhoukbn()) ||
                    C_SntkhouKbn.SYOKUGYOU.eq(ijitoukeiMeisai.getSntkhoukbn())) {
                    htKoukuBetu = "2";
                }
                else if (C_SntkhouKbn.NONE.eq(ijitoukeiMeisai.getSntkhoukbn())) {
                    htKoukuBetu = "3";
                }
                else {
                    htKoukuBetu = "0";
                }

                if ("4".equals(symtgenincd1keta) ||
                    "5".equals(symtgenincd1keta) ||
                    "9".equals(symtgenincd1keta) ||
                    "135".equals(ijitoukeiMeisai.getSymtgenincd())) {
                    htToutatuNenrei = String.valueOf(ijitoukeiMeisai.getHhknnen() +
                        BizDateUtil.calcDifference(ijitoukeiMeisai.getSyoumetuymd(), ijitoukeiMeisai.getKykymd()).getYears());

                    htSyoriYmd = ijitoukeiMeisai.getIdousyoriymd();
                }
                else {
                    htToutatuNenrei = "000";
                }

                if (C_Hrkkaisuu.ITIJI.eq(ijitoukeiMeisai.getHrkkaisuu())) {
                    htHrkhouKbn = "1";
                }
                else if (C_Hrkkaisuu.TUKI.eq(ijitoukeiMeisai.getHrkkaisuu())) {
                    if ((C_TkiktbrisyuruiKbn.TEIKI_6MONTHS.eq(ijitoukeiMeisai.getTikiktbrisyuruikbn()))||
                        (C_TkiktbrisyuruiKbn.TEIKI_12MONTHS.eq(ijitoukeiMeisai.getTikiktbrisyuruikbn()))) {
                        htHrkhouKbn = "3";

                    }
                    else {
                        if (C_Hrkkeiro.CREDIT.eq(ijitoukeiMeisai.getHrkkeiro())) {
                            htHrkhouKbn = "6";
                        }
                        else {
                            htHrkhouKbn = "5";
                        }
                    }
                }
                else if ((C_Hrkkaisuu.HALFY.eq(ijitoukeiMeisai.getHrkkaisuu()))||
                    (C_Hrkkaisuu.NEN.eq(ijitoukeiMeisai.getHrkkaisuu()))) {
                    htHrkhouKbn = "3";
                }
                else {
                    htHrkhouKbn = "0";
                }

                if (C_SntkhouKbn.NONE.eq(ijitoukeiMeisai.getSntkhoukbn())) {
                    htSnsHuhu = "17";
                }
                else if (C_SntkhouKbn.SYOKUGYOU.eq(ijitoukeiMeisai.getSntkhoukbn())) {
                    htSnsHuhu = "12";
                }
                else if (C_SntkhouKbn.KKT.eq(ijitoukeiMeisai.getSntkhoukbn()) &&
                    C_KokutiKbn.KANIKOKUTI.eq(ijitoukeiMeisai.getKokutikbn())) {
                    htSnsHuhu = "10";
                }
                else {
                    htSnsHuhu = "08";
                }

                if (C_Ketkekkacd.MUJYOUKEN.eq(ijitoukeiMeisai.getDakuhiktkekkacd())) {
                    htKetteiKekaKbn = "1";
                }
                else if (C_Ketkekkacd.GENKAITAI_SYOUDAKU.eq(ijitoukeiMeisai.getDakuhiktkekkacd())) {
                    htKetteiKekaKbn = "3";
                }

                if (syoubyouMst != null) {
                    htSyoubyouTyuuBunrui = editStringPadZero(syoubyouMst.getSyoubyoucdtyuubunruikbn(), 2);
                }
                else {
                    htSyoubyouTyuuBunrui = "00";
                }

                if (!BizUtil.isBlank(ijitoukeiMeisai.getSyoubyoucd1())) {
                    if (ijitoukeiMeisai.getSyoubyoucd1().length() > 5) {
                        htSyoubyouCd1x5 = ijitoukeiMeisai.getSyoubyoucd1().substring(0, 5);
                    }
                    else {
                        htSyoubyouCd1x5 = editStringPadZero(ijitoukeiMeisai.getSyoubyoucd1(), 5);
                    }
                }
                else {
                    htSyoubyouCd1x5 = "00000";
                }


                if (!BizUtil.isBlank(ijitoukeiMeisai.getSyoubyoucd2())) {
                    if (ijitoukeiMeisai.getSyoubyoucd2().length() > 5) {
                        htSyoubyouCd2x5 = ijitoukeiMeisai.getSyoubyoucd2().substring(0, 5);
                    }
                    else {
                        htSyoubyouCd2x5 = editStringPadZero(ijitoukeiMeisai.getSyoubyoucd2(), 5);
                    }
                }
                else {
                    htSyoubyouCd2x5 = "00000";
                }

                if (BLANK.equals(ijitoukeiMeisai.getSiincd()) ||
                    Arrays.asList(SIINCDSYOKITI).contains(ijitoukeiMeisai.getSiincd())) {
                    if ("4".equals(symtgenincd1keta) ||
                        "5".equals(symtgenincd1keta) ||
                        "9".equals(symtgenincd1keta)) {

                        htDaisiinCd = DAISIINCDBYOUSI;
                        htTyuuSiinCd = TYUUSIINCDSONOTA;
                        htSyouSiinCd = SYOUSIINCDSONOTA;

                    }
                    else {
                        htDaisiinCd = DAISIINCDSYOKITI;
                        htTyuuSiinCd = TYUUSIINCDSYOKITI;
                        htSyouSiinCd = SYOUSIINCDSYOKITI;
                    }
                }
                else {
                    if (siinBunrui != null) {
                        htDaisiinCd = siinBunrui.getDaisiincd();
                        htTyuuSiinCd = siinBunrui.getSiintyuubunnruicd();
                        htSyouSiinCd = ijitoukeiMeisai.getSiincd();
                    }
                    else {
                        htDaisiinCd = DAISIINCDBYOUSI;
                        htTyuuSiinCd = TYUUSIINCDSONOTA;
                        htSyouSiinCd = ijitoukeiMeisai.getSiincd();
                    }
                }

                if (("4".equals(symtgenincd1keta) ||
                    "5".equals(symtgenincd1keta) ||
                    "9".equals(symtgenincd1keta)) &&
                    BizDateUtil.calcDifference(ijitoukeiMeisai.getSyoumetuymd(), ijitoukeiMeisai.getKykymd()).getYears() < 2) {
                    htSoukiSibouHyj = "1";
                }
                else {
                    htSoukiSibouHyj = "0";
                }

                if ("4".equals(symtgenincd1keta) ||
                    "5".equals(symtgenincd1keta) ||
                    "9".equals(symtgenincd1keta)) {

                    BizDateSpan htKeikaKikan = BizDateUtil.calcDifference(
                        ijitoukeiMeisai.getSyoumetuymd(), ijitoukeiMeisai.getKykymd());

                    if (htKeikaKikan.getYears() >= 5) {
                        htKeikaKikanKbn = "6";
                    }
                    else if (htKeikaKikan.getYears() >= 2) {
                        htKeikaKikanKbn = "5";
                    }
                    else if (htKeikaKikan.getYears() >= 1 && htKeikaKikan.getMonths() >= 6) {
                        htKeikaKikanKbn = "4";
                    }
                    else if (htKeikaKikan.getYears() >= 1) {
                        htKeikaKikanKbn = "3";
                    }
                    else if (htKeikaKikan.getMonths() >= 6) {
                        htKeikaKikanKbn = "2";
                    }
                    else {
                        htKeikaKikanKbn = "1";
                    }
                }
                else {
                    htKeikaKikanKbn = "0";
                }

                if ("42".equals(symtgenincd2keta)) {
                    htKoudoSyougaiariHyj = "1";
                }
                else {
                    htKoudoSyougaiariHyj = "0";
                }

                if (C_IjitoukeiKaijyoKbn.BLNK.eq(ijitoukeiMeisai.getIjitoukeikaijyokbn())) {
                    htKaijyoKbn = "0";
                }
                else if (C_IjitoukeiKaijyoKbn.SEIZONKAIJYO.eq(ijitoukeiMeisai.getIjitoukeikaijyokbn())) {
                    htKaijyoKbn = "1";
                }
                else if (C_IjitoukeiKaijyoKbn.SKEITORIKESI.eq(ijitoukeiMeisai.getIjitoukeikaijyokbn())) {
                    htKaijyoKbn = "2";
                }
                else if (C_IjitoukeiKaijyoKbn.SIBOUKAIJYO.eq(ijitoukeiMeisai.getIjitoukeikaijyokbn())) {
                    htKaijyoKbn = "3";
                }

                if (C_SkeijimuKbn.TIGINSINKIN.eq(ijitoukeiMeisai.getSkeijimukbn()) ||
                    C_SkeijimuKbn.SMBC.eq(ijitoukeiMeisai.getSkeijimukbn()) ||
                    C_SkeijimuKbn.SMTB.eq(ijitoukeiMeisai.getSkeijimukbn()) ||
                    C_SkeijimuKbn.MIZUHO.eq(ijitoukeiMeisai.getSkeijimukbn())) {
                    htHanbaiKeirokbn = "3";
                }
                else if (C_SkeijimuKbn.SHOP.eq(ijitoukeiMeisai.getSkeijimukbn())) {
                    htHanbaiKeirokbn = "5";
                }
                else {
                    htHanbaiKeirokbn = "0";
                }

                if (C_Tkhukaumu.HUKA.eq(ijitoukeiMeisai.getSyksbyensitihsyutkhkkbn())) {
                    sykSbyensitihsyuTyhkUmu = "1";
                }
                else {
                    sykSbyensitihsyuTyhkUmu = "0";
                }

                if (C_Tkhukaumu.HUKA.eq(ijitoukeiMeisai.getJyudkaigomehrtkhkkbn())) {
                    jyudkaigomehrTkhkUmu = "1";
                }
                else {
                    jyudkaigomehrTkhkUmu = "0";
                }

                if (C_IjitoukeiZennouKbn.ZENKIZENNOU.eq(ijitoukeiMeisai.getIjitoukeizennoukbn())) {
                    ijtkyznkbn = "1";
                }
                else if (C_IjitoukeiZennouKbn.ITIBUZENNOU.eq(ijitoukeiMeisai.getIjitoukeizennoukbn())) {
                    ijtkyznkbn = "2";
                }
                else {
                    ijtkyznkbn = "0";
                }

                syuSibouToukeiTy = new ZT_SyuSibouToukeiTy();

                syuSibouToukeiTy.setZtysyono(editStringPadZero(ijitoukeiMeisai.getSyono(), 11));
                syuSibouToukeiTy.setZtyhknsyukigou(ijitoukeiMeisai.getSyouhncd().substring(0, 2));
                syuSibouToukeiTy.setZtyhknsyurui2keta(editStringPadZero(syouhnZokusei.getIjitoukeihokensyuruikbn(), 2));
                syuSibouToukeiTy.setZtyatukaibetu(htKoukuBetu);
                syuSibouToukeiTy.setZtyhhknseikbn(editStringPadZero(ijitoukeiMeisai.getHhknsei(), 1));
                syuSibouToukeiTy.setZtyhhknnen3(editStringPadZero(ijitoukeiMeisai.getHhknnen(), 3));
                syuSibouToukeiTy.setZtytoutatunenrei(editStringPadZero(htToutatuNenrei, 3));
                syuSibouToukeiTy.setZtykykym(editStringPadZero(ijitoukeiMeisai.getKykymd(), 6).substring(0, 6));
                syuSibouToukeiTy.setZtysymtym(editStringPadZero(ijitoukeiMeisai.getSyoumetuymd(), 6).substring(0, 6));
                syuSibouToukeiTy.setZtysyoriymd(editStringPadZero(htSyoriYmd, 8));
                syuSibouToukeiTy.setZtykyktuuka(editStringPadZero(tuukaSyuHenkanSyori(ijitoukeiMeisai.getKyktuukasyu()), 1));

                if (htImuStiyuSbusManen.length() > 7) {
                    syuSibouToukeiTy.setZtyimustiyusbus(Integer.valueOf(
                        htImuStiyuSbusManen.substring(htImuStiyuSbusManen.length() - 7, htImuStiyuSbusManen.length())));
                }
                else {
                    syuSibouToukeiTy.setZtyimustiyusbus(Integer.valueOf(htImuStiyuSbusManen));
                }

                syuSibouToukeiTy.setZtysykgycd(editStringPadZero(ijitoukeiMeisai.getHhknsykgycd(), 3));
                syuSibouToukeiTy.setZtyhrkhuhukbn(htHrkhouKbn);
                syuSibouToukeiTy.setZtysirajikykkbn(editStringPadZero(ijitoukeiMeisai.getSirajikykkbn(), 1));
                syuSibouToukeiTy.setZtyaatukaisosikicd(editStringPadZero(ijitoukeiMeisai.getAatsukaishasoshikicd(), 7));
                syuSibouToukeiTy.setZtyaatukaikojincd(editStringPadZero(ijitoukeiMeisai.getAatukaikojincd(), 6));
                syuSibouToukeiTy.setZtysinsahouhou(htSnsHuhu);
                syuSibouToukeiTy.setZtysinsasyacd("000000");
                syuSibouToukeiTy.setZtyketteikekkakbn(htKetteiKekaKbn);
                syuSibouToukeiTy.setZtydakuhikettisyacd(editStringPadZero(ijitoukeiMeisai.getPalketsyacd(), 2));
                syuSibouToukeiTy.setZtysyoubyoutyuubunrui(htSyoubyouTyuuBunrui);
                syuSibouToukeiTy.setZtysyoubyoucd1x5(htSyoubyouCd1x5);
                syuSibouToukeiTy.setZtysyoubyoucd2x5(htSyoubyouCd2x5);
                syuSibouToukeiTy.setZtydaisiincd(editStringPadZero(htDaisiinCd, 1));
                syuSibouToukeiTy.setZtytyuusiincd(editStringPadZero(htTyuuSiinCd, 2));
                syuSibouToukeiTy.setZtysyousiincd(editStringPadZero(htSyouSiinCd, 3));
                syuSibouToukeiTy.setZtysoukisibouhyj(htSoukiSibouHyj);
                syuSibouToukeiTy.setZtykeikakikankbn(htKeikaKikanKbn);
                syuSibouToukeiTy.setZtykoudosyougaiarihyj(htKoudoSyougaiariHyj);
                syuSibouToukeiTy.setZtykaijyokbn(htKaijyoKbn);
                syuSibouToukeiTy.setZtynensyuukbn(editStringPadZero(ijitoukeiMeisai.getHhknnensyuukbn(), 1));
                syuSibouToukeiTy.setZtyhanbaikeirokbn(htHanbaiKeirokbn);
                syuSibouToukeiTy.setZtyoyadairitencd(editStringPadZero(ijitoukeiMeisai.getOyadrtencd(), 7));
                syuSibouToukeiTy.setZtybyoumeicd("0000");
                syuSibouToukeiTy.setZtysyksbyensitihsyutyhkumu(sykSbyensitihsyuTyhkUmu);
                syuSibouToukeiTy.setZtyjyudkaigomehrtkhkumu(jyudkaigomehrTkhkUmu);
                syuSibouToukeiTy.setZtyijitoukeizennoukbn(ijtkyznkbn);
                syuSibouToukeiTy.setZtydai1hknkkn(editStringPadZero(ijitoukeiMeisai.getDai1hknkkn(), 2));
                syuSibouToukeiTy.setZtyijitoukeitikshrtkykkbn(editStringPadZero(ijitoukeiMeisai.getIjitoukeitikshrtkykkbn(), 1));

                if (teikiSiharaikinManen.length() > 7) {
                    syuSibouToukeiTy.setZtyteikisiharaikinmanen(Integer.valueOf(
                        teikiSiharaikinManen.substring(teikiSiharaikinManen.length() - 7, teikiSiharaikinManen.length())));
                }
                else {
                    syuSibouToukeiTy.setZtyteikisiharaikinmanen(Integer.valueOf(teikiSiharaikinManen));
                }

                BizPropertyInitializer.initialize(syuSibouToukeiTy);

                syuSibouToukeiTyInserter.add(syuSibouToukeiTy);

                syoriKensuu++;
            }

            recoverDataBean.initializeBlank();
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(syoriKensuu), TASKNM));
    }

    private String tuukaSyuHenkanSyori(C_Tuukasyu pTuukaSyu) {

        String henkanTuukaSyu = "";

        if (C_Tuukasyu.JPY.eq(pTuukaSyu)) {
            henkanTuukaSyu = "1";
        }
        else if (C_Tuukasyu.USD.eq(pTuukaSyu)) {
            henkanTuukaSyu = "2";
        }
        else if (C_Tuukasyu.EUR.eq(pTuukaSyu)) {
            henkanTuukaSyu = "3";
        }
        else if (C_Tuukasyu.AUD.eq(pTuukaSyu)) {
            henkanTuukaSyu = "4";
        }
        else {
            henkanTuukaSyu = "0";
        }

        return henkanTuukaSyu;
    }

    private String editStringPadZero(Object pObject, int pMaxLen) {

        if (pObject != null && pObject.toString().length() == pMaxLen) {
            return pObject.toString();
        }
        else if (pObject == null || pObject.toString().length() == 0) {
            return Strings.padStart(BLANK, pMaxLen, '0');
        }
        else {
            return Strings.padStart(pObject.toString(), pMaxLen, '0');

        }
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);
        bzBatchAbendCommonRecovery.exec();

    }
}
