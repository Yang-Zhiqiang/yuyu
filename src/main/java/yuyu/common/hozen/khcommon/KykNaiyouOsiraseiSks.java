package yuyu.common.hozen.khcommon;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.RoundingMode;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;

import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import jp.co.slcs.swak.number.currencytype.CurrencyType;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.util.string.ConvertUtil;
import jp.co.slcs.swak.util.string.IDataConvert;
import yuyu.common.base.format.FixedDateFormatter;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.GetKawaseRate;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.biz.report.ViewReport;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.def.MessageId;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.classification.C_AisyoumeiKbn;
import yuyu.def.classification.C_EigyoubiHoseiKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HknKknKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_KawaserateSyuruiKbn;
import yuyu.def.classification.C_KawasetekiyoKbn;
import yuyu.def.classification.C_KawasetsryKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_TmttknhaibunjyoutaiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.ZT_GaikaKokyakuTuutiTy;
import yuyu.def.hozen.bean.report.KhKykNaiyouOsiraseBean;
import yuyu.def.hozen.bean.report.KhKykNaiyouOsiraseDataSourceBean;
import yuyu.def.hozen.detacher.IT_KykKihonDetacher;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;

import com.google.common.collect.Lists;


/**
 * 契約保全 契約保全共通 ご契約内容のお知らせ作成処理
 */
public class KykNaiyouOsiraseiSks {

    private static final String HUKA_TK_04001 = "04001";

    private static final String HUKA_TK_04002 = "04002";

    private static final String HUKA_TK_04004 = "04004";

    private static final String HUKA_TK_04005 = "04005";

    private static final String HUKA_TK_04006 = "04006";

    private static final String HUKA_TK_04007 = "04007";

    private static final String HUKA_TK_04008 = "04008";

    private static final String HUKA_TK_04009 = "04009";

    private static final String HUKA_TK_04010 = "04010";

    private static final String HUKA_TK_04011 = "04011";

    private static final String HUKA_TK_04012 = "04012";

    private static final String UKTMIDASIKBN_NONE = "01";

    private static final String UKTMIDASIKBN_SBUKT = "02";

    private static final String UKTMIDASIKBN_NKUKT = "03";

    private static final String UKTMIDASIKBN_STDR = "04";

    private static final String UKTMIDASIKBN_SBKHUUKT = "05";

    private static final String UKTMIDASIKBN_KKYDR = "06";

    private static final String UKTRJNKBN_HKN = "02";

    private static final String UKTRJNKBN_HKNKYK = "03";

    private static final String UKTRJNKBN_SOUZOKU = "04";

    private static final String UKTRJNKBN_HKNSYO = "05";

    private static final String UKTRJNKBN_ZENKAKU_MINUS = "06";

    private static final String UKTRJNKBN_HKN_MSG = "被保険者　様";

    private static final String UKTRJNKBN_HKNKYK_MSG = "保険契約者　様";

    private static final String UKTRJNKBN_SOUZOKU_MSG = "法定相続人　様";

    private static final String UKTRJNKBN_HKNSYO_MSG = "保険証券をご覧下さい";

    private static final String ZENKAKU_MINUS_MSG = "－";

    private static final String DSTOUROKUJYOU_TOUROKUNASI = "0";

    private static final String DSTOUROKUJYOU_TOUROKU_KAIYAKUARI = "1";

    private static final String DSTOUROKUJYOU_TOUROKU_KAIYAKUNASI = "2";

    private static final String DSTOUROKUJYOU_MOS_KAIYAKUARI = "3";

    private static final String DSTOUROKUJYOU_MOS_KAIYAKUNASI = "4";

    private static final String KZKTRKJK_TOUROKUNASI = "0";

    private static final String KZKTRKJK_TOUROKUZUMI = "1";

    private static final String HENKANKBN_NONE = "0";

    private static final String HENKANKBN_ZENALL = "1";

    private static final String HENKANKBN_ZENSYMBOL = "2";

    private static final String YENGAIKAKBN_YENKA = "YENKA";

    private static final String YENGAIKAKBN_GAIKA = "GAIKA";

    private static final int KAWASERATE_SEIJYOU  = 0;

    private static final int KAWASERATE_MINASI  = 1;

    private static final String SISUUUPRITUHUGOU_HUSUU = "1";

    private static final String TANI_PERCENT = "%";

    private static final String TANI_PERCENT_ZEN = "％";

    private static final String TANI_BAI = "倍";

    private static final String TANI_SAI = "歳";

    private static final String TANI_NEN = "年";

    private static final String KIGOU_HAN_MINUS = "-";

    private static final String KIGOU_ZEN_MINUS = "－";

    private static final String TMTTKNSUIIRIREKIKBN_KYK = "1";

    private static final String TMTTKNSUIIRIREKIKBN_TMTTKNITEN = "3";

    private static final String TMTTKNJYOUTAI_SISUU = "1";

    private static final String TMTTKNJYOUTAI_TEIRITUTMTT = "2";

    private static final String TMTTKNJYOUTAI_TEIRITUITEN = "3";

    private static final String KNGKHYOUJIKBN_KG = "2";

    private static final String INIT_ZERO = "0";

    private static final int YOBIDASIMOTOKBN_ONLINE = 1;

    private static final int YOBIDASIMOTOKBN_SEIHOWEB = 2;

    private static final String KAWASERATE_WARNINGMSG = "（本日の為替レートが取得できないため、直前のレートでの試算結果となります）";

    private static final String SYOHINTAIOUTIME_GAUDHI = "２０２１年６月";
    private static final String SYOHINTAIOUTIME_BORERO = "２０２１年６月";

    private String errorMsg = "";

    private String tyouhyouKey = "";

    private int kawaserateMinasiKbn = 0;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private BaseDomManager manager;

    @Inject
    private static Logger logger;

    public KykNaiyouOsiraseiSks() {
        super();
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public String getTyouhyouKey() {
        return tyouhyouKey;
    }

    public int getKawaserateMinasiKbn() {
        return kawaserateMinasiKbn;
    }

    public C_ErrorKbn exec(String pSyono, int pYobidasimotoKbn, KhAddKoumokuSetteiBean pAddKoumokuSetteiBean) {

        logger.debug("▽ ご契約内容のお知らせ作成処理　開始");

        C_ErrorKbn errorKbn = C_ErrorKbn.OK;

        String syouhnhanmeikbn = "";
        C_SyoruiCdKbn syoruiCdKbn = C_SyoruiCdKbn.BLNK;
        BizDate sysDate = BizDate.getSysDate();

        BizDate kwsrateKjYmd = null;

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(pSyono);
        kykKihon = IT_KykKihonDetacher.detachKykSyouhntouched(kykKihon);

        if (pYobidasimotoKbn == YOBIDASIMOTOKBN_ONLINE) {

            if (kykKihon == null) {

                throw new BizLogicException(MessageId.EBA0090);
            }
        }

        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU).get(0);

        if (C_YuukousyoumetuKbn.SYOUMETU.eq(kykSyouhn.getYuukousyoumetukbn())) {

            if (pYobidasimotoKbn == YOBIDASIMOTOKBN_ONLINE) {

                throw new BizLogicException(MessageId.EBA0031, C_YuukousyoumetuKbn.SYOUMETU.getContent());
            }
        }

        CheckYuuyokkngai checkYuuyokkngai = SWAKInjector.getInstance(CheckYuuyokkngai.class);
        if (!checkYuuyokkngai.exec(pSyono, sysDate)) {

            if (pYobidasimotoKbn == YOBIDASIMOTOKBN_SEIHOWEB) {

                errorMsg = MessageUtil.getMessage(MessageId.EIA0085);

                errorKbn = C_ErrorKbn.ERROR;

                logger.debug("△ ご契約内容のお知らせ作成処理　終了");

                return errorKbn;
            }

            throw new BizLogicException(MessageId.EIA0085);

        }

        if (BizDateUtil.compareYmd(sysDate, kykSyouhn.getKykymd()) == BizDateUtil.COMPARE_LESSER) {

            if (pYobidasimotoKbn == YOBIDASIMOTOKBN_ONLINE) {

                throw new BizLogicException(MessageId.EIA0070, "処理日");
            }
        }

        int syohinHanteiKbn = SyouhinUtil.hantei(kykSyouhn.getSyouhncd());

        if (syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR) {
            if (kykSyouhn.getYendthnkymd() == null) {
                syouhnhanmeikbn = EditKykNaiyouOsirase.SYOUHNHANMEIKBN_SYUUSIN_GAIKA;
                syoruiCdKbn = C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE1;

                kwsrateKjYmd = getKwsrateKjYmd(sysDate, kykSyouhn.getKyktuukasyu());

                kawaserateMinasiKbn = getKawaserateMinasiKbn(sysDate, kwsrateKjYmd);
            }
            else {
                syouhnhanmeikbn = EditKykNaiyouOsirase.SYOUHNHANMEIKBN_SYUUSIN_ENKA;
                syoruiCdKbn = C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE4;
            }
        }
        else if (syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19) {
            if (kykSyouhn.getYendthnkymd() == null) {
                syouhnhanmeikbn = EditKykNaiyouOsirase.SYOUHNHANMEIKBN_SYUUSIN_GAIKA_KAITEI;
                syoruiCdKbn = C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE6;

                kwsrateKjYmd = getKwsrateKjYmd(sysDate, kykSyouhn.getKyktuukasyu());

                kawaserateMinasiKbn = getKawaserateMinasiKbn(sysDate, kwsrateKjYmd);
            }
            else {

                syouhnhanmeikbn = EditKykNaiyouOsirase.SYOUHNHANMEIKBN_SYUUSIN_ENKA_19;
                syoruiCdKbn = C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE7;
            }
        }
        else if (syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR) {
            if (kykSyouhn.getYendthnkymd() == null) {
                C_TmttknhaibunjyoutaiKbn tmttknhaibunjyoutaiKbn = kykSyouhn.getTmttknhaibunjyoutai();

                if (C_TmttknhaibunjyoutaiKbn.SISUU_ONLY.eq(tmttknhaibunjyoutaiKbn)) {
                    syouhnhanmeikbn = EditKykNaiyouOsirase.SYOUHNHANMEIKBN_NENKIN_SISUU;
                    syoruiCdKbn = C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE2;

                    kwsrateKjYmd = getKwsrateKjYmd(sysDate, kykSyouhn.getKyktuukasyu());

                    kawaserateMinasiKbn = getKawaserateMinasiKbn(sysDate, kwsrateKjYmd);
                }
                else if (C_TmttknhaibunjyoutaiKbn.TEIRITU_ONLY.eq(tmttknhaibunjyoutaiKbn)) {

                    BizDate kykjisisuurendourate = kykSyouhn.getTmttknitenymd();

                    if (kykjisisuurendourate == null) {
                        syouhnhanmeikbn = EditKykNaiyouOsirase.SYOUHNHANMEIKBN_NENKIN_TEIRITU;
                    }
                    else {
                        syouhnhanmeikbn = EditKykNaiyouOsirase.SYOUHNHANMEIKBN_NENKIN_TEIRITUITEN;
                    }

                    syoruiCdKbn = C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE2;

                    kwsrateKjYmd = getKwsrateKjYmd(sysDate, kykSyouhn.getKyktuukasyu());

                    kawaserateMinasiKbn = getKawaserateMinasiKbn(sysDate, kwsrateKjYmd);
                }
                else {
                    if (pYobidasimotoKbn == YOBIDASIMOTOKBN_SEIHOWEB) {

                        errorMsg = MessageUtil.getMessage(MessageId.EIA1015, MessageUtil.getMessage(MessageId.IIW1007));

                        errorKbn = C_ErrorKbn.ERROR;

                        logger.debug("△ ご契約内容のお知らせ作成処理　終了");

                        return errorKbn;
                    }

                    throw new BizLogicException(
                        MessageId.EIA1015,
                        MessageUtil.getMessage(MessageId.IIW1007));
                }
            }
            else {
                syouhnhanmeikbn = EditKykNaiyouOsirase.SYOUHNHANMEIKBN_NENKIN_ENKA;
                syoruiCdKbn = C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE5;
            }
        }
        else if (syohinHanteiKbn == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {
            syouhnhanmeikbn = EditKykNaiyouOsirase.SYOUHNHANMEIKBN_DUO;
            syoruiCdKbn = C_SyoruiCdKbn.KK_KYKNAIYOUOSIRASE3;

            kwsrateKjYmd = getKwsrateKjYmd(sysDate, kykSyouhn.getKyktuukasyu());

            kawaserateMinasiKbn = getKawaserateMinasiKbn(sysDate, kwsrateKjYmd);
        }
        else if (syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) {

            if (pYobidasimotoKbn == YOBIDASIMOTOKBN_SEIHOWEB) {

                errorMsg = MessageUtil.getMessage(MessageId.EIF1165, kykKihon.getAisyoumeikbn().getContent(), SYOHINTAIOUTIME_GAUDHI);

                errorKbn = C_ErrorKbn.ERROR;

                logger.debug("△ ご契約内容のお知らせ作成処理　終了");

                return errorKbn;
            }

            throw new BizLogicException(
                MessageId.EIF1165,
                kykKihon.getAisyoumeikbn().getContent(),
                SYOHINTAIOUTIME_GAUDHI);
        }
        else if (syohinHanteiKbn == SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN) {

            if (pYobidasimotoKbn == YOBIDASIMOTOKBN_SEIHOWEB) {

                errorMsg = MessageUtil.getMessage(MessageId.EIF1165, kykKihon.getAisyoumeikbn().getContent(), SYOHINTAIOUTIME_BORERO);

                errorKbn = C_ErrorKbn.ERROR;

                logger.debug("△ ご契約内容のお知らせ作成処理　終了");

                return errorKbn;
            }

            throw new BizLogicException(
                MessageId.EIF1165,
                kykKihon.getAisyoumeikbn().getContent(),
                SYOHINTAIOUTIME_BORERO);
        }
        else {

            if (pYobidasimotoKbn == YOBIDASIMOTOKBN_SEIHOWEB) {

                errorMsg = MessageUtil.getMessage(MessageId.EIA1015, MessageUtil.getMessage(MessageId.IIW1007));

                errorKbn = C_ErrorKbn.ERROR;

                logger.debug("△ ご契約内容のお知らせ作成処理　終了");

                return errorKbn;
            }

            throw new BizLogicException(
                MessageId.EIA1015,
                MessageUtil.getMessage(MessageId.IIW1007));
        }

        EditKykNaiyouOsirase editKykNaiyouOsirase = SWAKInjector.getInstance(EditKykNaiyouOsirase.class);

        ZT_GaikaKokyakuTuutiTy gaikaKokyakuTuutiTy =
            editKykNaiyouOsirase.editInfo(pSyono, sysDate, sysDate, syouhnhanmeikbn, "0", null, pYobidasimotoKbn);

        if (C_ErrorKbn.ERROR.eq(editKykNaiyouOsirase.getBizLogicErrorKbn())) {

            errorMsg = editKykNaiyouOsirase.getBizLogicErrorMsg();

            errorKbn = C_ErrorKbn.ERROR;

            logger.debug("△ ご契約内容のお知らせ作成処理　終了");

            return errorKbn;
        }

        tyouhyouKey =
            setReportBean(gaikaKokyakuTuutiTy, sysDate.toString(), kwsrateKjYmd, syoruiCdKbn, syouhnhanmeikbn, pYobidasimotoKbn, pAddKoumokuSetteiBean);

        logger.debug("△ ご契約内容のお知らせ作成処理　終了");

        return errorKbn;
    }

    private String setReportBean(
        ZT_GaikaKokyakuTuutiTy pGaikaKokyakuTuutiTy,
        String pSysDate,
        BizDate pKwsrateKjYmd,
        C_SyoruiCdKbn pSyoruiCdKbn,
        String pSyouhnhanmeikbn,
        int pYobidasimotoKbn,
        KhAddKoumokuSetteiBean pAddKoumokuSetteiBean) {

        KhKykNaiyouOsiraseBean khKykNaiyouOsiraseBean = new KhKykNaiyouOsiraseBean();
        List<IReportDataSouceBean> kykNaiyouOsiraseDataSourceBeanList = Lists.newArrayList();
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(pGaikaKokyakuTuutiTy.getZtysyono());
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU).get(0);
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        BM_SyouhnZokusei syouhnZokusei = kykSyouhn.getSyouhnZokusei();

        C_Tuukasyu kyktuuka = C_Tuukasyu.valueOf(pGaikaKokyakuTuutiTy.getZtykyktuukatype());

        String[] dsTourokuJyous = getDsTourokuJyou(pGaikaKokyakuTuutiTy.getZtydstourokujyou());
        String sumiseiDsTrkJyoutai = dsTourokuJyous[0];
        String tokuteitrhkTrkJyoutai = dsTourokuJyous[1];
        khKykNaiyouOsiraseBean.setIrSakuseiymd(pSysDate);
        khKykNaiyouOsiraseBean.setIrSyono(pGaikaKokyakuTuutiTy.getZtysyono());
        khKykNaiyouOsiraseBean.setIrAisyoumei(
            C_AisyoumeiKbn.valueOf(pGaikaKokyakuTuutiTy.getZtyaisyoumeikbn()).getContent());
        khKykNaiyouOsiraseBean.setIrYakkannmei(syouhnZokusei.getSyouhnnmsyouken());
        khKykNaiyouOsiraseBean.setIrKyknm(pGaikaKokyakuTuutiTy.getZtykyknmkj18());
        khKykNaiyouOsiraseBean.setIrHhknnm(pGaikaKokyakuTuutiTy.getZtyhhknnmkj18());
        khKykNaiyouOsiraseBean.setIrKoktuutireportlayoutptn(pGaikaKokyakuTuutiTy.getZtykoktuutireportlayoutptn());
        khKykNaiyouOsiraseBean.setIrKykymd(pGaikaKokyakuTuutiTy.getZtykykymdwa());
        khKykNaiyouOsiraseBean.setIrCalckijyunymd(
            FixedDateFormatter.formatYMDZenkakuSeirekiKanji(pKwsrateKjYmd));
        khKykNaiyouOsiraseBean.setIrSiteituuka(kyktuuka);

        String[] uktNms = getSbSiteiUkNms(pGaikaKokyakuTuutiTy);
        String sbUktNm1 = uktNms[0];
        String sbUktNm2 = uktNms[1];
        String nkUktNm = uktNms[2];
        String kykdrNm = uktNms[3];
        String stdrNm = uktNms[4];

        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm1(sbUktNm1);
        khKykNaiyouOsiraseBean.setIrSibouhokenkinuktnm2(sbUktNm2);
        khKykNaiyouOsiraseBean.setIrNkuktnm(nkUktNm);
        khKykNaiyouOsiraseBean.setIrKykdairinm(kykdrNm);
        khKykNaiyouOsiraseBean.setIrStdrsknm(stdrNm);

        khKykNaiyouOsiraseBean.setIrTk1msg(
            getTyouhyouMessage(pGaikaKokyakuTuutiTy.getZtytk1msgcd()));
        khKykNaiyouOsiraseBean.setIrTk2msg(
            getTyouhyouMessage(pGaikaKokyakuTuutiTy.getZtytk2msgcd()));
        khKykNaiyouOsiraseBean.setIrTk3msg(
            getTyouhyouMessage(pGaikaKokyakuTuutiTy.getZtytk3msgcd()));
        khKykNaiyouOsiraseBean.setIrTk4msg(
            getTyouhyouMessage(pGaikaKokyakuTuutiTy.getZtytk4msgcd()));
        khKykNaiyouOsiraseBean.setIrTk5msg(
            getTyouhyouMessage(pGaikaKokyakuTuutiTy.getZtytk5msgcd()));
        khKykNaiyouOsiraseBean.setIrTk6msg(
            getTyouhyouMessage(pGaikaKokyakuTuutiTy.getZtytk6msgcd()));
        khKykNaiyouOsiraseBean.setIrSdservicetourokujk(sumiseiDsTrkJyoutai);
        khKykNaiyouOsiraseBean.setIrTokuteitrhkkztourokujk(tokuteitrhkTrkJyoutai);

        String[] kzkTrkJkInfo = getKzkTrkJkInfo(pGaikaKokyakuTuutiTy);
        khKykNaiyouOsiraseBean.setIrKzktrkservicetrkjk(kzkTrkJkInfo[0]);
        khKykNaiyouOsiraseBean.setIrTrkkzknm1(kzkTrkJkInfo[1]);
        khKykNaiyouOsiraseBean.setIrTrkkzknm2(kzkTrkJkInfo[2]);

        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm1(pGaikaKokyakuTuutiTy.getZtysyoukaisakidrtennm1());
        khKykNaiyouOsiraseBean.setIrSyoukaisakidrtennm2(pGaikaKokyakuTuutiTy.getZtysyoukaisakidrtennm2());

        if (pYobidasimotoKbn == YOBIDASIMOTOKBN_SEIHOWEB) {

            if (kawaserateMinasiKbn == KAWASERATE_MINASI) {

                khKykNaiyouOsiraseBean.setIrWarningMsg(KAWASERATE_WARNINGMSG);
            }
        }

        if (EditKykNaiyouOsirase.SYOUHNHANMEIKBN_SYUUSIN_GAIKA.equals(pSyouhnhanmeikbn) ||
            EditKykNaiyouOsirase.SYOUHNHANMEIKBN_SYUUSIN_GAIKA_KAITEI.equals(pSyouhnhanmeikbn)) {
            C_Tuukasyu hrktuuka = C_Tuukasyu.valueOf(pGaikaKokyakuTuutiTy.getZtyhrktuukatype());
            khKykNaiyouOsiraseBean.setIrHrktuuka(hrktuuka);
            khKykNaiyouOsiraseBean.setIrDai1hknkknto(pGaikaKokyakuTuutiTy.getZtydai1hknkknfromwa());
            khKykNaiyouOsiraseBean.setIrDai1hknkkn(pGaikaKokyakuTuutiTy.getZtydai1hknkkn());
            khKykNaiyouOsiraseBean.setIrDai2hknkknfrom(pGaikaKokyakuTuutiTy.getZtydai2hknkknfromwa());
            khKykNaiyouOsiraseBean.setIrDai2hknkknto(pGaikaKokyakuTuutiTy.getZtydai2hknkkntowa());
            khKykNaiyouOsiraseBean.setIrDai3hknkknfrom(pGaikaKokyakuTuutiTy.getZtydai3hknkknfromwa());
            khKykNaiyouOsiraseBean.setIrDai3hknkknto(pGaikaKokyakuTuutiTy.getZtydai3hknkknto());
            khKykNaiyouOsiraseBean.setIrItijibrpkyktuuka(
                getConvertKg(
                    pGaikaKokyakuTuutiTy.getZtyitijibrpkyktuuka(),
                    kyktuuka,
                    HENKANKBN_ZENSYMBOL));
            khKykNaiyouOsiraseBean.setIrKihonsktuuka(
                getConvertKg(
                    pGaikaKokyakuTuutiTy.getZtykihonsktuuka(),
                    kyktuuka,
                    HENKANKBN_ZENSYMBOL));
            khKykNaiyouOsiraseBean.setIrYenhrkgk(
                getConvertKg(
                    pGaikaKokyakuTuutiTy.getZtyyenhrkgk(),
                    C_Tuukasyu.JPY,
                    HENKANKBN_ZENSYMBOL));
            khKykNaiyouOsiraseBean.setIrStigituukahrkgk(
                getConvertKg(
                    pGaikaKokyakuTuutiTy.getZtystigituukahrkgk(),
                    hrktuuka,
                    HENKANKBN_ZENSYMBOL));
            khKykNaiyouOsiraseBean.setIrYenkhrikmrate(
                getConvertRate(
                    pGaikaKokyakuTuutiTy.getZtyyenkhrikmrate(),
                    YENGAIKAKBN_YENKA,
                    HENKANKBN_ZENSYMBOL));
            khKykNaiyouOsiraseBean.setIrStigikwsrate(
                getConvertRate(
                    pGaikaKokyakuTuutiTy.getZtystigikwsrate(),
                    YENGAIKAKBN_GAIKA,
                    HENKANKBN_ZENSYMBOL));
            khKykNaiyouOsiraseBean.setIrHrkgkhyoujikbn(
                pGaikaKokyakuTuutiTy.getZtyhrkgkhyoujikbn());
            khKykNaiyouOsiraseBean.setIrKijyunkingaku(
                getConvertKg(
                    pGaikaKokyakuTuutiTy.getZtykijyunkingaku(),
                    C_Tuukasyu.JPY,
                    HENKANKBN_ZENSYMBOL));
            khKykNaiyouOsiraseBean.setIrKjnkngkkawaserate(
                getConvertRate(
                    pGaikaKokyakuTuutiTy.getZtykjnkngkkawaserate(),
                    YENGAIKAKBN_YENKA,
                    HENKANKBN_ZENSYMBOL));
            khKykNaiyouOsiraseBean.setIrKjnkngkhyoujikbn(pGaikaKokyakuTuutiTy.getZtykjnkngkhyoujikbn());
            khKykNaiyouOsiraseBean.setIrSakuseikijyunymdkwsrate(
                getConvertRate(
                    pGaikaKokyakuTuutiTy.getZtysakuseikijyunymdkwsrate(),
                    YENGAIKAKBN_YENKA,
                    HENKANKBN_NONE));
            khKykNaiyouOsiraseBean.setIrSbhknkngkhknkkn(pGaikaKokyakuTuutiTy.getZtysbhknkngkhknkkn());
            khKykNaiyouOsiraseBean.setIrSbhknkngkhknkknfrom(pGaikaKokyakuTuutiTy.getZtysbhknkngkhknkknfromwa());
            khKykNaiyouOsiraseBean.setIrSbhknkngkhknkknto(pGaikaKokyakuTuutiTy.getZtysbhknkngkhknkkntowa());
            khKykNaiyouOsiraseBean.setIrSbhknkngkkyktuuka(
                getConvertKg(
                    pGaikaKokyakuTuutiTy.getZtysbhknkngkkyktuuka(),
                    kyktuuka,
                    HENKANKBN_ZENSYMBOL));

            C_HknKknKbn hknKknKbn = C_HknKknKbn.valueOf(pGaikaKokyakuTuutiTy.getZtysbhknkngkhknkkn());

            C_UmuKbn initsbjiyensitihsytkhukaumu = kykSonotaTkyk.getInitsbjiyensitihsytkhukaumu();

            if (C_HknKknKbn.DAI1HKNKKN.eq(hknKknKbn) &&
                C_UmuKbn.ARI.eq(initsbjiyensitihsytkhukaumu)) {
                BizCurrency kijyunkingaku =
                    BizCurrency.valueOf(
                        Long.parseLong(pGaikaKokyakuTuutiTy.getZtykijyunkingaku()),
                        BizCurrencyTypes.YEN);

                BizCurrency sbhknkngkyen =
                    BizCurrency.valueOf(
                        Long.parseLong(pGaikaKokyakuTuutiTy.getZtysbhknkngkyen()),
                        BizCurrencyTypes.YEN);

                BizCurrency saigaisbhknkngakukyen =
                    BizCurrency.valueOf(
                        Long.parseLong(pGaikaKokyakuTuutiTy.getZtysaigaisbhknkngakukyen()),
                        BizCurrencyTypes.YEN);

                if (sbhknkngkyen.compareTo(kijyunkingaku) <= 0) {
                    khKykNaiyouOsiraseBean.setIrSbhknkngkyen("「基準金額」と同額");
                }
                else {
                    khKykNaiyouOsiraseBean.setIrSbhknkngkyen(
                        getConvertKg(
                            pGaikaKokyakuTuutiTy.getZtysbhknkngkyen(),
                            C_Tuukasyu.JPY,
                            HENKANKBN_ZENSYMBOL));
                }

                if (saigaisbhknkngakukyen.compareTo(kijyunkingaku) <= 0) {
                    khKykNaiyouOsiraseBean.setIrSaigaisbhknkngakukyen("「基準金額」と同額");
                }
                else {
                    khKykNaiyouOsiraseBean.setIrSaigaisbhknkngakukyen(
                        getConvertKg(
                            pGaikaKokyakuTuutiTy.getZtysaigaisbhknkngakukyen(),
                            C_Tuukasyu.JPY,
                            HENKANKBN_ZENSYMBOL));
                }
            }
            else {
                khKykNaiyouOsiraseBean.setIrSbhknkngkyen(
                    getConvertKg(
                        pGaikaKokyakuTuutiTy.getZtysbhknkngkyen(),
                        C_Tuukasyu.JPY,
                        HENKANKBN_ZENSYMBOL));

                khKykNaiyouOsiraseBean.setIrSaigaisbhknkngakukyen(
                    getConvertKg(
                        pGaikaKokyakuTuutiTy.getZtysaigaisbhknkngakukyen(),
                        C_Tuukasyu.JPY,
                        HENKANKBN_ZENSYMBOL));
            }

            if (KNGKHYOUJIKBN_KG.equals(pGaikaKokyakuTuutiTy.getZtysaigaisbhknkngakuumu())) {
                khKykNaiyouOsiraseBean.setIrSaigaisbhknkngakuumu(C_UmuKbn.ARI);
            }
            else {
                khKykNaiyouOsiraseBean.setIrSaigaisbhknkngakuumu(
                    C_UmuKbn.valueOf(pGaikaKokyakuTuutiTy.getZtysaigaisbhknkngakuumu()));
            }

            khKykNaiyouOsiraseBean.setIrSaigaisbhknkngakuktuuka(
                getConvertKg(
                    pGaikaKokyakuTuutiTy.getZtysaigaisbhknkngakuktuuka(),
                    kyktuuka,
                    HENKANKBN_ZENSYMBOL));
            khKykNaiyouOsiraseBean.setIrTumitatekngkktuuka(
                getConvertKg(
                    pGaikaKokyakuTuutiTy.getZtytumitatekngkktuuka(),
                    kyktuuka,
                    HENKANKBN_ZENSYMBOL));
            khKykNaiyouOsiraseBean.setIrTumitatekngkkyen(
                getConvertKg(
                    pGaikaKokyakuTuutiTy.getZtytumitatekngkkyen(),
                    C_Tuukasyu.JPY,
                    HENKANKBN_ZENSYMBOL));
            khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakkyktuuka(
                getConvertKg(
                    pGaikaKokyakuTuutiTy.getZtykaiyakuhrkngakkyktuuka(),
                    kyktuuka,
                    HENKANKBN_ZENSYMBOL));
            khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen(
                getConvertKg(
                    pGaikaKokyakuTuutiTy.getZtykaiyakuhrkngakyen(),
                    C_Tuukasyu.JPY,
                    HENKANKBN_ZENSYMBOL));
            khKykNaiyouOsiraseBean.setIrMkhgkyen(
                getConvertKg(
                    pGaikaKokyakuTuutiTy.getZtymkhgkyen(),
                    C_Tuukasyu.JPY,
                    HENKANKBN_ZENALL));
            khKykNaiyouOsiraseBean.setIrMkhgkwari(
                ConvertUtil.toZenNumeric(pGaikaKokyakuTuutiTy.getZtymkhgkwari()));
            khKykNaiyouOsiraseBean.setIrMkhgkhyoujikbn(pGaikaKokyakuTuutiTy.getZtymkhgkhyoujikbn());
            khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd1(pGaikaKokyakuTuutiTy.getZtyhosyouhskmsgcd1());
            khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd2(pGaikaKokyakuTuutiTy.getZtyhosyouhskmsgcd2());
            khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd3(pGaikaKokyakuTuutiTy.getZtyhosyouhskmsgcd3());
            khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd4(pGaikaKokyakuTuutiTy.getZtyhosyouhskmsgcd4());
            khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd5(pGaikaKokyakuTuutiTy.getZtyhosyouhskmsgcd5());
            khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd6(pGaikaKokyakuTuutiTy.getZtyhosyouhskmsgcd6());
            khKykNaiyouOsiraseBean.setIrTmtthtkinzndkyen(
                getConvertKg(
                    pGaikaKokyakuTuutiTy.getZtytmtthaitoukinzndkyen(),
                    C_Tuukasyu.JPY,
                    HENKANKBN_ZENSYMBOL));

        }
        else if (EditKykNaiyouOsirase.SYOUHNHANMEIKBN_NENKIN_SISUU.equals(pSyouhnhanmeikbn) ||
            EditKykNaiyouOsirase.SYOUHNHANMEIKBN_NENKIN_TEIRITU.equals(pSyouhnhanmeikbn) ||
            EditKykNaiyouOsirase.SYOUHNHANMEIKBN_NENKIN_TEIRITUITEN.equals(pSyouhnhanmeikbn)) {
            khKykNaiyouOsiraseBean.setIrSyukykgengakuumu(C_UmuKbn.valueOf(pGaikaKokyakuTuutiTy.getZtygengkumu()));
            C_Tuukasyu hrktuuka = C_Tuukasyu.valueOf(pGaikaKokyakuTuutiTy.getZtyhrktuukatype());
            khKykNaiyouOsiraseBean.setIrHrktuuka(hrktuuka);
            khKykNaiyouOsiraseBean.setIrNenkinstartymd(pGaikaKokyakuTuutiTy.getZtynkshrstartymdstr());
            khKykNaiyouOsiraseBean.setIrNenkinstartnen(
                ConvertUtil.convZenHan(
                    IDataConvert.iCONVERT_H2Z_ALL,
                    pGaikaKokyakuTuutiTy.getZtynenkinstartnen()) + TANI_SAI);
            khKykNaiyouOsiraseBean.setIrNenkinsyu(pGaikaKokyakuTuutiTy.getZtynksyuruinm());
            khKykNaiyouOsiraseBean.setIrNkgnsgk(
                getConvertKg(pGaikaKokyakuTuutiTy.getZtynkgnsgkkyktuuka(),
                    kyktuuka,
                    HENKANKBN_ZENSYMBOL));
            khKykNaiyouOsiraseBean.setIrItijibrpkyktuuka(
                getConvertKg(
                    pGaikaKokyakuTuutiTy.getZtyitijibrpkyktuuka(),
                    kyktuuka,
                    HENKANKBN_ZENSYMBOL));
            khKykNaiyouOsiraseBean.setIrKijyunkingakukyktuuka(
                getConvertKg(
                    pGaikaKokyakuTuutiTy.getZtykijyunkingakukyktuuka(),
                    kyktuuka,
                    HENKANKBN_ZENSYMBOL));
            khKykNaiyouOsiraseBean.setIrYenhrkgk(
                getConvertKg(
                    pGaikaKokyakuTuutiTy.getZtyyenhrkgk(),
                    C_Tuukasyu.JPY,
                    HENKANKBN_ZENSYMBOL));
            khKykNaiyouOsiraseBean.setIrStigituukahrkgk(
                getConvertKg(
                    pGaikaKokyakuTuutiTy.getZtystigituukahrkgk(),
                    hrktuuka,
                    HENKANKBN_ZENSYMBOL));
            khKykNaiyouOsiraseBean.setIrYenkhrikmrate(
                getConvertRate(
                    pGaikaKokyakuTuutiTy.getZtyyenkhrikmrate(),
                    YENGAIKAKBN_YENKA,
                    HENKANKBN_ZENSYMBOL));
            khKykNaiyouOsiraseBean.setIrStigikwsrate(
                getConvertRate(
                    pGaikaKokyakuTuutiTy.getZtystigikwsrate(),
                    YENGAIKAKBN_GAIKA,
                    HENKANKBN_ZENSYMBOL));
            khKykNaiyouOsiraseBean.setIrHrkgkhyoujikbn(
                pGaikaKokyakuTuutiTy.getZtyhrkgkhyoujikbn());
            khKykNaiyouOsiraseBean.setIrKijyunkingaku(
                getConvertKg(
                    pGaikaKokyakuTuutiTy.getZtykijyunkingaku(),
                    C_Tuukasyu.JPY,
                    HENKANKBN_ZENSYMBOL));
            khKykNaiyouOsiraseBean.setIrKjnkngkkawaserate(
                getConvertRate(
                    pGaikaKokyakuTuutiTy.getZtykjnkngkkawaserate(),
                    YENGAIKAKBN_YENKA,
                    HENKANKBN_ZENSYMBOL));
            khKykNaiyouOsiraseBean.setIrKjnkngkhyoujikbn(pGaikaKokyakuTuutiTy.getZtykjnkngkhyoujikbn());
            khKykNaiyouOsiraseBean.setIrSakuseikijyunymdkwsrate(
                getConvertRate(
                    pGaikaKokyakuTuutiTy.getZtysakuseikijyunymdkwsrate(),
                    YENGAIKAKBN_YENKA,
                    HENKANKBN_NONE));
            khKykNaiyouOsiraseBean.setIrSbhknkngkkyktuuka(
                getConvertKg(
                    pGaikaKokyakuTuutiTy.getZtysbhknkngkkyktuuka(),
                    kyktuuka,
                    HENKANKBN_ZENSYMBOL));
            khKykNaiyouOsiraseBean.setIrSbhknkngkyen(
                getConvertKg(
                    pGaikaKokyakuTuutiTy.getZtysbhknkngkyen(),
                    C_Tuukasyu.JPY,
                    HENKANKBN_ZENSYMBOL));
            khKykNaiyouOsiraseBean.setIrTumitatekngkktuuka(
                getConvertKg(
                    pGaikaKokyakuTuutiTy.getZtytumitatekngkktuuka(),
                    kyktuuka,
                    HENKANKBN_ZENSYMBOL));
            khKykNaiyouOsiraseBean.setIrTumitatekngkkyen(
                getConvertKg(
                    pGaikaKokyakuTuutiTy.getZtytumitatekngkkyen(),
                    C_Tuukasyu.JPY,
                    HENKANKBN_ZENSYMBOL));
            khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakkyktuuka(
                getConvertKg(
                    pGaikaKokyakuTuutiTy.getZtykaiyakuhrkngakkyktuuka(),
                    kyktuuka,
                    HENKANKBN_ZENSYMBOL));
            khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen(
                getConvertKg(
                    pGaikaKokyakuTuutiTy.getZtykaiyakuhrkngakyen(),
                    C_Tuukasyu.JPY,
                    HENKANKBN_ZENSYMBOL));
            khKykNaiyouOsiraseBean.setIrTmtthtkinzndkyen(
                getConvertKg(
                    pGaikaKokyakuTuutiTy.getZtytmtthaitoukinzndkyen(),
                    C_Tuukasyu.JPY,
                    HENKANKBN_ZENSYMBOL));
            khKykNaiyouOsiraseBean.setIrMkhgkyen(
                getConvertKg(
                    pGaikaKokyakuTuutiTy.getZtymkhgkyen(),
                    C_Tuukasyu.JPY,
                    HENKANKBN_ZENALL));
            khKykNaiyouOsiraseBean.setIrMkhgkwari(
                ConvertUtil.toZenNumeric(pGaikaKokyakuTuutiTy.getZtymkhgkwari()));
            khKykNaiyouOsiraseBean.setIrMkhgkhyoujikbn(pGaikaKokyakuTuutiTy.getZtymkhgkhyoujikbn());
            khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd1(pGaikaKokyakuTuutiTy.getZtyhosyouhskmsgcd1());
            khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd2(pGaikaKokyakuTuutiTy.getZtyhosyouhskmsgcd2());
            khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd3(pGaikaKokyakuTuutiTy.getZtyhosyouhskmsgcd3());
            khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd4(pGaikaKokyakuTuutiTy.getZtyhosyouhskmsgcd4());
            khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd5(pGaikaKokyakuTuutiTy.getZtyhosyouhskmsgcd5());
            khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd6(pGaikaKokyakuTuutiTy.getZtyhosyouhskmsgcd6());
            khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd7(pGaikaKokyakuTuutiTy.getZtyhosyouhskmsgcd7());
            khKykNaiyouOsiraseBean.setIrTnsmbairitu(
                getConvertRateTani(
                    pGaikaKokyakuTuutiTy.getZtysetteibairitustr(),
                    HENKANKBN_ZENALL,
                    2,
                    2,
                    TANI_BAI));
            khKykNaiyouOsiraseBean.setIrTmttknzoukaritujygn(
                getConvertRateTani(
                    pGaikaKokyakuTuutiTy.getZtytmttknzkrtjygnstr(),
                    HENKANKBN_ZENALL,
                    3,
                    2,
                    TANI_PERCENT));
            khKykNaiyouOsiraseBean.setIrTmttknzoukaritukagen("０％");
            khKykNaiyouOsiraseBean.setIrTumitateriritu(
                getConvertRateTani(
                    pGaikaKokyakuTuutiTy.getZtytumitateriritustr(),
                    HENKANKBN_ZENALL,
                    2,
                    2,
                    TANI_PERCENT));
            khKykNaiyouOsiraseBean.setIrSisuunm(pGaikaKokyakuTuutiTy.getZtysisuunm());

            for (int index = 1; index <= 11; index++) {
                KhKykNaiyouOsiraseDataSourceBean kykNaiyouOsiraseDataSourceBean = new KhKykNaiyouOsiraseDataSourceBean();

                String tmttknsuiirirekikbnCovert = "";
                String keiyakuoutoubi = "";
                String tmttknjyoutaiCovert = "";
                String ptumitatekngkktuuka = "";
                String ptumitatekngkyen = "";
                String sisuu = "";
                String irSisuuupritu = "";
                String tmttknzoukaritustr = "";
                String kawaserate = "";
                try {
                    String tmttknsuiirirekikbn =
                        methodNmEditAndExec(
                            ZT_GaikaKokyakuTuutiTy.class,
                            pGaikaKokyakuTuutiTy,
                            "getZtytmttknsuiirirekikbnx",
                            index);
                    if (BizUtil.isBlank(tmttknsuiirirekikbn)) {
                        break;
                    }
                    if (TMTTKNSUIIRIREKIKBN_KYK.equals(tmttknsuiirirekikbn)) {
                        tmttknsuiirirekikbnCovert = "ご契約時";
                    }
                    else if (TMTTKNSUIIRIREKIKBN_TMTTKNITEN.equals(tmttknsuiirirekikbn)) {
                        tmttknsuiirirekikbnCovert = "積立金移転";
                    }
                    keiyakuoutoubi =
                        methodNmEditAndExec(
                            ZT_GaikaKokyakuTuutiTy.class,
                            pGaikaKokyakuTuutiTy,
                            "getZtykeiyakuoutoubix",
                            index);
                    String tmttknjyoutai =
                        methodNmEditAndExec(
                            ZT_GaikaKokyakuTuutiTy.class,
                            pGaikaKokyakuTuutiTy,
                            "getZtytmttknjyoutaix",
                            index);
                    if (TMTTKNJYOUTAI_SISUU.equals(tmttknjyoutai)) {
                        tmttknjyoutaiCovert = "指数連動";
                    }
                    else if (TMTTKNJYOUTAI_TEIRITUTMTT.equals(tmttknjyoutai)) {
                        tmttknjyoutaiCovert = "定率積立";
                    }
                    else if (TMTTKNJYOUTAI_TEIRITUITEN.equals(tmttknjyoutai)) {
                        tmttknjyoutaiCovert = "指数連動↓定率積立";
                    }
                    ptumitatekngkktuuka =
                        methodNmEditAndExec(
                            ZT_GaikaKokyakuTuutiTy.class,
                            pGaikaKokyakuTuutiTy,
                            "getZtyptumitatekngkktuukax",
                            index);
                    ptumitatekngkyen =
                        methodNmEditAndExec(
                            ZT_GaikaKokyakuTuutiTy.class,
                            pGaikaKokyakuTuutiTy,
                            "getZtyptumitatekngkyenx",
                            index);
                    sisuu =
                        methodNmEditAndExec(
                            ZT_GaikaKokyakuTuutiTy.class,
                            pGaikaKokyakuTuutiTy,
                            "getZtysisuux",
                            index);
                    String sisuuuprituhugou =
                        methodNmEditAndExec(
                            ZT_GaikaKokyakuTuutiTy.class,
                            pGaikaKokyakuTuutiTy,
                            "getZtysisuuuprituhugoux",
                            index);
                    String sisuuupritu =
                        methodNmEditAndExec(
                            ZT_GaikaKokyakuTuutiTy.class,
                            pGaikaKokyakuTuutiTy,
                            "getZtysisuuupritux",
                            index);
                    if (!BizUtil.isBlank(sisuuupritu)) {
                        BizNumber sisuuuprituTmp = BizNumber.valueOf(Integer.parseInt(sisuuupritu));

                        if (SISUUUPRITUHUGOU_HUSUU.equals(sisuuuprituhugou)) {
                            sisuuuprituTmp = sisuuuprituTmp.multiply(-1);
                        }
                        irSisuuupritu = sisuuuprituTmp.toString();
                    }

                    tmttknzoukaritustr =
                        methodNmEditAndExec(
                            ZT_GaikaKokyakuTuutiTy.class,
                            pGaikaKokyakuTuutiTy,
                            "getZtytmttknzoukaritustrx",
                            index);
                    kawaserate =
                        methodNmEditAndExec(
                            ZT_GaikaKokyakuTuutiTy.class,
                            pGaikaKokyakuTuutiTy,
                            "getZtykawaseratex",
                            index);
                } catch (IllegalAccessException
                    | NoSuchMethodException
                    | InvocationTargetException e) {
                    throw new CommonBizAppException();
                }
                kykNaiyouOsiraseDataSourceBean.setIrTmttknsuiirirekikbn(tmttknsuiirirekikbnCovert);
                kykNaiyouOsiraseDataSourceBean.setIrKeiyakuoutoubi(keiyakuoutoubi);
                kykNaiyouOsiraseDataSourceBean.setIrTmttknjyoutai(tmttknjyoutaiCovert);
                kykNaiyouOsiraseDataSourceBean.setIrTumitatekngkktuuka(
                    getConvertKg(
                        ptumitatekngkktuuka,
                        kyktuuka,
                        HENKANKBN_NONE));
                kykNaiyouOsiraseDataSourceBean.setIrTumitatekngkkyen(
                    getConvertKg(
                        ptumitatekngkyen,
                        C_Tuukasyu.JPY,
                        HENKANKBN_NONE));
                kykNaiyouOsiraseDataSourceBean.setIrSisuu(
                    getConvertRateTani(
                        sisuu,
                        HENKANKBN_NONE,
                        3,
                        2,
                        ""));
                kykNaiyouOsiraseDataSourceBean.setIrSisuuupritu(
                    getConvertRateTani(
                        irSisuuupritu,
                        HENKANKBN_NONE,
                        2,
                        2,
                        TANI_PERCENT));
                kykNaiyouOsiraseDataSourceBean.setIrTmttknzoukaritu(
                    getConvertRateTani(
                        tmttknzoukaritustr,
                        HENKANKBN_NONE,
                        2,
                        2,
                        TANI_PERCENT));
                kykNaiyouOsiraseDataSourceBean.setIrKawaserate(
                    getConvertRate(
                        kawaserate,
                        YENGAIKAKBN_YENKA,
                        HENKANKBN_NONE) + " 円");

                kykNaiyouOsiraseDataSourceBeanList.add(kykNaiyouOsiraseDataSourceBean);
            }

            if (kykNaiyouOsiraseDataSourceBeanList.size() == 1) {
                kykNaiyouOsiraseDataSourceBeanList.clear();
            }
        }
        else if (EditKykNaiyouOsirase.SYOUHNHANMEIKBN_DUO.equals(pSyouhnhanmeikbn)) {
            khKykNaiyouOsiraseBean.setIrNenkinstartymd(pGaikaKokyakuTuutiTy.getZtynkshrstartymdstr());
            khKykNaiyouOsiraseBean.setIrNenkinstartnen(
                ConvertUtil.convZenHan(
                    IDataConvert.iCONVERT_H2Z_ALL,
                    pGaikaKokyakuTuutiTy.getZtynenkinstartnen()) + TANI_SAI);
            khKykNaiyouOsiraseBean.setIrNenkinsyu(pGaikaKokyakuTuutiTy.getZtynksyuruinm());

            khKykNaiyouOsiraseBean.setIrHaraikomikaisukbn(
                C_Hrkkaisuu.valueOf(
                    delSentouZero(pGaikaKokyakuTuutiTy.getZtyhrkkaisuu())).getContent());

            khKykNaiyouOsiraseBean.setIrTikiktbrisyurui(
                C_TkiktbrisyuruiKbn.valueOf(
                    delSentouZero(pGaikaKokyakuTuutiTy.getZtytikiktbrisyuruikbn())).getContent());

            khKykNaiyouOsiraseBean.setIrZennouumu(
                C_UmuKbn.valueOf(pGaikaKokyakuTuutiTy.getZtyzennouumu()));
            khKykNaiyouOsiraseBean.setIrPhrkkeiro(
                C_Hrkkeiro.valueOf(pGaikaKokyakuTuutiTy.getZtyhrkkeiro()).getContent());
            khKykNaiyouOsiraseBean.setIrPhrkkkn(
                ConvertUtil.convZenHan(
                    IDataConvert.iCONVERT_H2Z_ALL,
                    pGaikaKokyakuTuutiTy.getZtyphrkkkn()) + TANI_SAI);

            String sueokikkn = pGaikaKokyakuTuutiTy.getZtysueokikkn();

            if (INIT_ZERO.equals(sueokikkn)) {
                khKykNaiyouOsiraseBean.setIrSueokikkn(ZENKAKU_MINUS_MSG);
            }
            else {
                khKykNaiyouOsiraseBean.setIrSueokikkn(
                    ConvertUtil.convZenHan(
                        IDataConvert.iCONVERT_H2Z_ALL, sueokikkn) + TANI_NEN);
            }

            khKykNaiyouOsiraseBean.setIrYenhrkgk(
                getConvertKg(
                    pGaikaKokyakuTuutiTy.getZtyyenhrkgk(),
                    C_Tuukasyu.JPY,
                    HENKANKBN_ZENSYMBOL));
            khKykNaiyouOsiraseBean.setIrSakuseikijyunymdkwsrate(
                getConvertRate(
                    pGaikaKokyakuTuutiTy.getZtysakuseikijyunymdkwsrate(),
                    YENGAIKAKBN_YENKA,
                    HENKANKBN_NONE));
            khKykNaiyouOsiraseBean.setIrSbhknkngkkyktuuka(
                getConvertKg(
                    pGaikaKokyakuTuutiTy.getZtysbhknkngkkyktuuka(),
                    kyktuuka,
                    HENKANKBN_ZENSYMBOL));
            khKykNaiyouOsiraseBean.setIrSbhknkngkyen(
                getConvertKg(
                    pGaikaKokyakuTuutiTy.getZtysbhknkngkyen(),
                    C_Tuukasyu.JPY,
                    HENKANKBN_ZENSYMBOL));
            khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakkyktuuka(
                getConvertKg(
                    pGaikaKokyakuTuutiTy.getZtykaiyakuhrkngakkyktuuka(),
                    kyktuuka,
                    HENKANKBN_ZENSYMBOL));
            khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen(
                getConvertKg(
                    pGaikaKokyakuTuutiTy.getZtykaiyakuhrkngakyen(),
                    C_Tuukasyu.JPY,
                    HENKANKBN_ZENSYMBOL));
            khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd7(pGaikaKokyakuTuutiTy.getZtyhosyouhskmsgcd7());
            khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd8(pGaikaKokyakuTuutiTy.getZtyhosyouhskmsgcd8());
            khKykNaiyouOsiraseBean.setIrHosyouhskmsgcd9(pGaikaKokyakuTuutiTy.getZtyhosyouhskmsgcd9());
            khKykNaiyouOsiraseBean.setIrTikiktbriyenhrkgk(
                getConvertKg(
                    pGaikaKokyakuTuutiTy.getZtyyenhrkgkiktnkgk(),
                    C_Tuukasyu.JPY,
                    HENKANKBN_ZENSYMBOL));
            khKykNaiyouOsiraseBean.setIrZnntikiktbriyenhrkgk(
                getConvertKg(
                    pGaikaKokyakuTuutiTy.getZtyzennoutikiktyenhrkgkkykj(),
                    C_Tuukasyu.JPY,
                    HENKANKBN_ZENSYMBOL));
            khKykNaiyouOsiraseBean.setIrKaiyakujshrgk(
                getConvertKg(
                    pGaikaKokyakuTuutiTy.getZtykaiyakusiharaigk(),
                    C_Tuukasyu.JPY,
                    HENKANKBN_ZENSYMBOL));
            khKykNaiyouOsiraseBean.setIrKykujshrgkzennouzndk(
                getConvertKg(
                    pGaikaKokyakuTuutiTy.getZtykaiyakusiharaigkznnuzndk(),
                    C_Tuukasyu.JPY,
                    HENKANKBN_ZENSYMBOL));

            String kaiyakusiharaigksntshrgk = pGaikaKokyakuTuutiTy.getZtykaiyakusiharaigksntshrgk();

            if (INIT_ZERO.equals(kaiyakusiharaigksntshrgk)) {
                khKykNaiyouOsiraseBean.setIrKykujshrgksonotashrkngk(INIT_ZERO);
            }
            else {
                khKykNaiyouOsiraseBean.setIrKykujshrgksonotashrkngk(
                    getConvertKg(
                        pGaikaKokyakuTuutiTy.getZtykaiyakusiharaigksntshrgk(),
                        C_Tuukasyu.JPY,
                        HENKANKBN_ZENSYMBOL));
            }

            String yenhrkgkgoukei = pGaikaKokyakuTuutiTy.getZtyyenhrkgkgoukei();
            String yhrritu = pGaikaKokyakuTuutiTy.getZtyhrritu();

            if (INIT_ZERO.equals(yenhrkgkgoukei)) {
                khKykNaiyouOsiraseBean.setIrYenhrkgknokkeigk(INIT_ZERO);
            }
            else {
                khKykNaiyouOsiraseBean.setIrYenhrkgknokkeigk(
                    getConvertKg(
                        yenhrkgkgoukei,
                        C_Tuukasyu.JPY,
                        HENKANKBN_ZENSYMBOL));
            }

            if (INIT_ZERO.equals(yhrritu)) {
                khKykNaiyouOsiraseBean.setIrHrritukaiyakuhrkngk5(INIT_ZERO);
            }
            else {
                khKykNaiyouOsiraseBean.setIrHrritukaiyakuhrkngk5(
                    yhrritu + " " + TANI_PERCENT_ZEN);
            }

            khKykNaiyouOsiraseBean.setIrNkgnsyensyourai(
                getConvertKg(
                    pGaikaKokyakuTuutiTy.getZtynkgnsyensyourai(),
                    C_Tuukasyu.JPY,
                    HENKANKBN_ZENSYMBOL));
            khKykNaiyouOsiraseBean.setIrNkgnskyktuukasyourai(
                getConvertKg(
                    pGaikaKokyakuTuutiTy.getZtynkgnsgaikasyourai(),
                    kyktuuka,
                    HENKANKBN_ZENSYMBOL));

            String yenhrkgkgoukeisyourai = pGaikaKokyakuTuutiTy.getZtyyenhrkgkgoukeisyourai();
            String hrritusyourai = pGaikaKokyakuTuutiTy.getZtyhrritusyourai();

            if (INIT_ZERO.equals(yenhrkgkgoukeisyourai)) {
                khKykNaiyouOsiraseBean.setIrYenhrkgknokkeigksyourai(INIT_ZERO);
            }
            else {
                khKykNaiyouOsiraseBean.setIrYenhrkgknokkeigksyourai(
                    getConvertKg(
                        yenhrkgkgoukeisyourai,
                        C_Tuukasyu.JPY,
                        HENKANKBN_ZENSYMBOL));
            }

            if (INIT_ZERO.equals(hrritusyourai)) {
                khKykNaiyouOsiraseBean.setIrHrritusyourai5(INIT_ZERO);
            }
            else {
                khKykNaiyouOsiraseBean.setIrHrritusyourai5(
                    hrritusyourai + " " + TANI_PERCENT_ZEN);
            }

            khKykNaiyouOsiraseBean.setYtirrtitrnhskmsgcd5(pGaikaKokyakuTuutiTy.getZtyytirrtitrnhskmsgcd5());

            khKykNaiyouOsiraseBean.setNksyukbn(kykSyouhn.getNksyukbn());

            List<KhKykNaiyouOsiraseDataSourceBean> ytrrtKwsrateP1yearLeftList = Lists.newArrayList();
            List<KhKykNaiyouOsiraseDataSourceBean> ytrrtKwsrateP1yearRightList = Lists.newArrayList();

            for (int index = 1; index <= 12; index++) {
                KhKykNaiyouOsiraseDataSourceBean kykNaiyouOsiraseDataSourceBean = new KhKykNaiyouOsiraseDataSourceBean();
                String yoteiriritukijyunym = "";
                String yoteiriritu = "";
                String ytirrtcalckijyunrrt = "";
                String kwsratekijyunym = "";
                String kaknsnkwsrate = "";
                String pgaika = "";
                String pyen = "";
                String fstphyoujikbn = "";

                try {
                    yoteiriritukijyunym =
                        methodNmEditAndExec(
                            ZT_GaikaKokyakuTuutiTy.class,
                            pGaikaKokyakuTuutiTy,
                            "getZtyyoteiriritukijyunym",
                            index);
                    if (BizUtil.isBlank(yoteiriritukijyunym)) {
                        break;
                    }

                    yoteiriritu =
                        methodNmEditAndExec(
                            ZT_GaikaKokyakuTuutiTy.class,
                            pGaikaKokyakuTuutiTy,
                            "getZtyyoteiriritu",
                            index);

                    ytirrtcalckijyunrrt =
                        methodNmEditAndExec(
                            ZT_GaikaKokyakuTuutiTy.class,
                            pGaikaKokyakuTuutiTy,
                            "getZtyytirrtcalckijyunrrt",
                            index);

                    kwsratekijyunym =
                        methodNmEditAndExec(
                            ZT_GaikaKokyakuTuutiTy.class,
                            pGaikaKokyakuTuutiTy,
                            "getZtykwsratekijyunym",
                            index);

                    kaknsnkwsrate =
                        methodNmEditAndExec(
                            ZT_GaikaKokyakuTuutiTy.class,
                            pGaikaKokyakuTuutiTy,
                            "getZtykaknsnkwsrate",
                            index);

                    pgaika =
                        methodNmEditAndExec(
                            ZT_GaikaKokyakuTuutiTy.class,
                            pGaikaKokyakuTuutiTy,
                            "getZtypgaika",
                            index);

                    pyen =
                        methodNmEditAndExec(
                            ZT_GaikaKokyakuTuutiTy.class,
                            pGaikaKokyakuTuutiTy,
                            "getZtypyen",
                            index);

                    fstphyoujikbn =
                        methodNmEditAndExec(
                            ZT_GaikaKokyakuTuutiTy.class,
                            pGaikaKokyakuTuutiTy,
                            "getZtyfstphyoujikbn",
                            index);

                } catch (IllegalAccessException
                    | NoSuchMethodException
                    | InvocationTargetException e) {
                    throw new CommonBizAppException();
                }

                kykNaiyouOsiraseDataSourceBean.setIrKeiyakugonogetu(yoteiriritukijyunym);
                kykNaiyouOsiraseDataSourceBean.setIrYoteiriritu5(
                    getConvertRateTani(
                        yoteiriritu,
                        HENKANKBN_NONE,
                        3,
                        2,
                        TANI_PERCENT));
                kykNaiyouOsiraseDataSourceBean.setIrYtirrtcalckijyunrrt(
                    getConvertRateTani(
                        ytirrtcalckijyunrrt,
                        HENKANKBN_NONE,
                        3,
                        2,
                        TANI_PERCENT));

                kykNaiyouOsiraseDataSourceBean.setIrKawaseratekijyunym(kwsratekijyunym);

                if (!BizUtil.isBlank(kwsratekijyunym)) {
                    kykNaiyouOsiraseDataSourceBean.setIrKnsnkwsrate(
                        getConvertRate(
                            kaknsnkwsrate,
                            YENGAIKAKBN_YENKA,
                            HENKANKBN_NONE) + " 円");

                    if (BizUtil.isBlank(pgaika)) {
                        kykNaiyouOsiraseDataSourceBean.setIrPkyktuuka(KIGOU_HAN_MINUS);
                    }
                    else {
                        kykNaiyouOsiraseDataSourceBean.setIrPkyktuuka(
                            getConvertKg(
                                pgaika,
                                kyktuuka,
                                HENKANKBN_ZENSYMBOL));
                    }

                    if (BizUtil.isBlank(pyen)) {
                        kykNaiyouOsiraseDataSourceBean.setIrPyen(KIGOU_HAN_MINUS);
                    }
                    else {
                        kykNaiyouOsiraseDataSourceBean.setIrPyen(
                            getConvertKg(
                                pyen,
                                C_Tuukasyu.JPY,
                                HENKANKBN_ZENSYMBOL));
                    }
                }

                kykNaiyouOsiraseDataSourceBean.setFstphyoujikbn(fstphyoujikbn);

                if (index >= 1 && index <= 6) {
                    ytrrtKwsrateP1yearLeftList.add(kykNaiyouOsiraseDataSourceBean);
                }
                else {
                    ytrrtKwsrateP1yearRightList.add(kykNaiyouOsiraseDataSourceBean);
                }
            }

            khKykNaiyouOsiraseBean.setYtrrtKwsrateP1yearLeftList(ytrrtKwsrateP1yearLeftList);
            khKykNaiyouOsiraseBean.setYtrrtKwsrateP1yearRightList(ytrrtKwsrateP1yearRightList);
        }
        else if (EditKykNaiyouOsirase.SYOUHNHANMEIKBN_SYUUSIN_ENKA.equals(pSyouhnhanmeikbn)) {
            khKykNaiyouOsiraseBean.setIrDai2hknkknfrom(pGaikaKokyakuTuutiTy.getZtydai2hknkknfromwa());
            khKykNaiyouOsiraseBean.setIrYendthnkymd(pGaikaKokyakuTuutiTy.getZtyyendthnkymd());
            khKykNaiyouOsiraseBean.setIrSbhknkngkhknkkn(pGaikaKokyakuTuutiTy.getZtysbhknkngkhknkkn());
            khKykNaiyouOsiraseBean.setIrSbhknkngkyen(
                getConvertKg(
                    pGaikaKokyakuTuutiTy.getZtysbhknkngkyen(),
                    C_Tuukasyu.JPY,
                    HENKANKBN_ZENSYMBOL));
            khKykNaiyouOsiraseBean.setIrKaiyakuhrkngakyen(
                getConvertKg(
                    pGaikaKokyakuTuutiTy.getZtykaiyakuhrkngakyen(),
                    C_Tuukasyu.JPY,
                    HENKANKBN_ZENSYMBOL));
            khKykNaiyouOsiraseBean.setIrYendthnkhrgkstr(
                getConvertKg(
                    pGaikaKokyakuTuutiTy.getZtyyendthnkhrkngakyen(),
                    C_Tuukasyu.JPY,
                    HENKANKBN_ZENSYMBOL));
            khKykNaiyouOsiraseBean.setIrTmtthtkinzndkyen(
                getConvertKg(
                    pGaikaKokyakuTuutiTy.getZtytmtthaitoukinzndkyen(),
                    C_Tuukasyu.JPY,
                    HENKANKBN_ZENSYMBOL));

        }
        else if (EditKykNaiyouOsirase.SYOUHNHANMEIKBN_NENKIN_ENKA.equals(pSyouhnhanmeikbn)) {
            khKykNaiyouOsiraseBean.setIrYendthnkymd(pGaikaKokyakuTuutiTy.getZtyyendthnkymd());
            khKykNaiyouOsiraseBean.setIrNenkinstartymd(pGaikaKokyakuTuutiTy.getZtynkshrstartymdstr());
            khKykNaiyouOsiraseBean.setIrNenkinstartnen(
                ConvertUtil.convZenHan(
                    IDataConvert.iCONVERT_H2Z_ALL,
                    pGaikaKokyakuTuutiTy.getZtynenkinstartnen()) + TANI_SAI);
            khKykNaiyouOsiraseBean.setIrNenkinsyu(pGaikaKokyakuTuutiTy.getZtynksyuruinm());
            khKykNaiyouOsiraseBean.setIrKijyunkingaku(
                getConvertKg(
                    pGaikaKokyakuTuutiTy.getZtykijyunkingaku(),
                    C_Tuukasyu.JPY,
                    HENKANKBN_ZENSYMBOL));
            khKykNaiyouOsiraseBean.setIrTumitatekngkkyen(
                getConvertKg(
                    pGaikaKokyakuTuutiTy.getZtytumitatekngkkyen(),
                    C_Tuukasyu.JPY,
                    HENKANKBN_ZENSYMBOL));
            khKykNaiyouOsiraseBean.setIrTmtthtkinzndkyen(
                getConvertKg(
                    pGaikaKokyakuTuutiTy.getZtytmtthaitoukinzndkyen(),
                    C_Tuukasyu.JPY,
                    HENKANKBN_ZENSYMBOL));
            khKykNaiyouOsiraseBean.setIrTumitateriritu(
                getConvertRateTani(
                    pGaikaKokyakuTuutiTy.getZtytumitateriritustr(),
                    HENKANKBN_ZENALL,
                    2,
                    2,
                    TANI_PERCENT));

            List<KhKykNaiyouOsiraseDataSourceBean> hokenryoTmttLeftList = Lists.newArrayList();
            List<KhKykNaiyouOsiraseDataSourceBean> hokenryoTmttrRightList = Lists.newArrayList();

            for (int index = 1; index <= 9; index++) {
                KhKykNaiyouOsiraseDataSourceBean kykNaiyouOsiraseDataSourceBean = new KhKykNaiyouOsiraseDataSourceBean();

                String keiyakuoutoubi = "";
                String ptumitatekngkyen = "";
                try {

                    keiyakuoutoubi =
                        methodNmEditAndExec(
                            ZT_GaikaKokyakuTuutiTy.class,
                            pGaikaKokyakuTuutiTy,
                            "getZtykeiyakuoutoubix",
                            index);

                    if (BizUtil.isBlank(keiyakuoutoubi)) {
                        break;
                    }

                    ptumitatekngkyen =
                        methodNmEditAndExec(
                            ZT_GaikaKokyakuTuutiTy.class,
                            pGaikaKokyakuTuutiTy,
                            "getZtyptumitatekngkyenx",
                            index);

                } catch (IllegalAccessException
                    | NoSuchMethodException
                    | InvocationTargetException e) {
                    throw new CommonBizAppException();
                }
                kykNaiyouOsiraseDataSourceBean.setIrKeiyakuoutoubi(keiyakuoutoubi);

                kykNaiyouOsiraseDataSourceBean.setIrTumitatekngkkyen(
                    getConvertKg(
                        ptumitatekngkyen,
                        C_Tuukasyu.JPY,
                        HENKANKBN_NONE));

                if (index >= 1 && index <= 5) {
                    hokenryoTmttLeftList.add(kykNaiyouOsiraseDataSourceBean);
                }
                else {
                    hokenryoTmttrRightList.add(kykNaiyouOsiraseDataSourceBean);
                }
            }
            khKykNaiyouOsiraseBean.setYtrrtKwsrateP1yearLeftList(hokenryoTmttLeftList);
            khKykNaiyouOsiraseBean.setYtrrtKwsrateP1yearRightList(hokenryoTmttrRightList);
        }

        else if (EditKykNaiyouOsirase.SYOUHNHANMEIKBN_SYUUSIN_ENKA_19.equals(pSyouhnhanmeikbn)) {

            khKykNaiyouOsiraseBean.setIrYendthnkymd(pGaikaKokyakuTuutiTy.getZtyyendthnkymd());
            khKykNaiyouOsiraseBean.setIrKijyunkingaku(
                getConvertKg(
                    pGaikaKokyakuTuutiTy.getZtykijyunkingaku(),
                    C_Tuukasyu.JPY,
                    HENKANKBN_ZENSYMBOL));
            khKykNaiyouOsiraseBean.setIrTumitatekngkkyen(
                getConvertKg(
                    pGaikaKokyakuTuutiTy.getZtytumitatekngkkyen(),
                    C_Tuukasyu.JPY,
                    HENKANKBN_ZENSYMBOL));
            khKykNaiyouOsiraseBean.setIrTmtthtkinzndkyen(
                getConvertKg(
                    pGaikaKokyakuTuutiTy.getZtytmtthaitoukinzndkyen(),
                    C_Tuukasyu.JPY,
                    HENKANKBN_ZENSYMBOL));

        }

        khKykNaiyouOsiraseBean.setIrSakuseisyozoku(pAddKoumokuSetteiBean.getSakuseiSyozoku());

        khKykNaiyouOsiraseBean.setIrSakuseisya(pAddKoumokuSetteiBean.getSakuseisya());

        khKykNaiyouOsiraseBean.setIrYobidasimotoKbn(pYobidasimotoKbn);

        AS_Kinou asKinou = manager.getKinou(IKhozenCommonConstants.KINOUID_KHKYKNAIYOUOSIRASE);

        CreateReport createReport = SWAKInjector.getInstance(CreateReport.class);

        ReportServicesBean serviceBean =
            createReport.createNewReportServiceBean(
                asKinou.getSubSystemId(),
                asKinou.getCategoryId(),
                asKinou.getKinouId(),
                pSyoruiCdKbn);

        serviceBean.addParamObjects(kykNaiyouOsiraseDataSourceBeanList, khKykNaiyouOsiraseBean);

        String tyouhyoukey = "";

        if (pYobidasimotoKbn == YOBIDASIMOTOKBN_SEIHOWEB) {

            tyouhyoukey = createReport.exec(serviceBean);
        }
        else if (pYobidasimotoKbn == YOBIDASIMOTOKBN_ONLINE) {

            tyouhyoukey = createReport.execNoCommit(serviceBean);
        }

        return tyouhyoukey;
    }

    private String getTyouhyouMessage(String pMessageId) {

        String message = "";

        if (!BizUtil.isBlank(pMessageId)) {
            switch (pMessageId) {
                case HUKA_TK_04001:
                    message = IKhozenCommonConstants.TOKUYAKUNM_HOKENRYOUYENKHRIKM;
                    break;
                case HUKA_TK_04012:
                    message = IKhozenCommonConstants.TOKUYAKUNM_HOKENRYOUYENKHRIKM_ITIJI;
                    break;
                case HUKA_TK_04009:
                    message = IKhozenCommonConstants.TOKUYAKUNM_HOKENRYOUYENKHRIKM_YENHRKGK;
                    break;
                case HUKA_TK_04002:
                    message = IKhozenCommonConstants.TOKUYAKUNM_GAIKANYUUKIN;
                    break;
                case HUKA_TK_04004:
                    message = IKhozenCommonConstants.TOKUYAKUNM_MKHYOUYENSYSNHENTK;
                    break;
                case HUKA_TK_04005:
                    message = IKhozenCommonConstants.TOKUYAKUNM_INITSBJIYENSHRGKSITIHSYUTK;
                    break;
                case HUKA_TK_04006:
                    message = IKhozenCommonConstants.TOKUYAKUNM_JYUUDOKAIGOMAEBARAI;
                    break;
                case HUKA_TK_04011:
                    message = IKhozenCommonConstants.TOKUYAKUNM_HOKENKYKDRTKYK;
                    break;
                case HUKA_TK_04007:
                    message = IKhozenCommonConstants.TOKUYAKUNM_SITEIDAIRISEIKYUU;
                    break;
                case HUKA_TK_04008:
                    message = IKhozenCommonConstants.TOKUYAKUNM_MKHYOUYENNKHKNHENTK;
                    break;
                case HUKA_TK_04010:
                    message = IKhozenCommonConstants.TOKUYAKUNM_ZEISEITEKIKAKU_HANKAKU;
                    break;
                default:
                    break;
            }
        }
        return message;
    }

    private String[] getDsTourokuJyou(String pDsTourokuJyouKbn) {

        String[] dsTourokuJyous = new String[2];
        dsTourokuJyous[0] = "";
        dsTourokuJyous[1] = "";

        switch (pDsTourokuJyouKbn) {
            case DSTOUROKUJYOU_TOUROKUNASI:
                dsTourokuJyous[0] = "お申し込みいただいておりません";
                dsTourokuJyous[1] = "未登録";
                break;
            case DSTOUROKUJYOU_TOUROKU_KAIYAKUARI:
                dsTourokuJyous[0] = "登録済";
                dsTourokuJyous[1] = "登録済";
                break;
            case DSTOUROKUJYOU_TOUROKU_KAIYAKUNASI:
                dsTourokuJyous[0] = "登録済";
                dsTourokuJyous[1] = "未登録";
                break;
            case DSTOUROKUJYOU_MOS_KAIYAKUARI:
                dsTourokuJyous[0] = "申込済（パスワード未登録）";
                dsTourokuJyous[1] = "登録済";
                break;
            case DSTOUROKUJYOU_MOS_KAIYAKUNASI:
                dsTourokuJyous[0] = "申込済（パスワード未登録）";
                dsTourokuJyous[1] = "未登録";
                break;
            default:
                break;
        }

        return dsTourokuJyous;
    }

    private String[] getKzkTrkJkInfo(ZT_GaikaKokyakuTuutiTy pGaikaKokyakuTuutiTy) {

        String kzktrkjk = pGaikaKokyakuTuutiTy.getZtykzktrkjk();
        String[] kzkTrkJkInfo = new String[]{"", "", ""};

        if (KZKTRKJK_TOUROKUNASI.equals(kzktrkjk)) {
            kzkTrkJkInfo[0] = "未登録（ご登録ください）";
            kzkTrkJkInfo[1] = KIGOU_ZEN_MINUS;
        }
        else if (KZKTRKJK_TOUROKUZUMI.equals(kzktrkjk)) {
            kzkTrkJkInfo[0] = "登録済";
            kzkTrkJkInfo[1] = ViewReport.editSama(pGaikaKokyakuTuutiTy.getZtytrkkzknm118());
            String kzkTrkNm2 = pGaikaKokyakuTuutiTy.getZtytrkkzknm218();

            if (BizUtil.isBlank(kzkTrkNm2)) {
                kzkTrkNm2 = null;
            }
            kzkTrkJkInfo[2] = ViewReport.editSama(kzkTrkNm2);
        }
        return kzkTrkJkInfo;
    }

    private String[] getSbSiteiUkNms(ZT_GaikaKokyakuTuutiTy pGaikaKokyakuTuutiTy) {

        String[] uktNms = new String[5];

        uktNms[0] = "";
        uktNms[1] = "";
        uktNms[2] = "";
        uktNms[3] = "";
        uktNms[4] = "";

        List<String> uktMidasiKbnLst = Lists.newArrayList(
            pGaikaKokyakuTuutiTy.getZtyuktmidasikbn1(),
            pGaikaKokyakuTuutiTy.getZtyuktmidasikbn2(),
            pGaikaKokyakuTuutiTy.getZtyuktmidasikbn3(),
            pGaikaKokyakuTuutiTy.getZtyuktmidasikbn4(),
            pGaikaKokyakuTuutiTy.getZtyuktmidasikbn5());

        List<String> uktKbnLst = Lists.newArrayList(
            pGaikaKokyakuTuutiTy.getZtyuktkbn1(),
            pGaikaKokyakuTuutiTy.getZtyuktkbn2(),
            pGaikaKokyakuTuutiTy.getZtyuktkbn3(),
            pGaikaKokyakuTuutiTy.getZtyuktkbn4(),
            pGaikaKokyakuTuutiTy.getZtyuktkbn5());

        List<String> uktNmLst = Lists.newArrayList(
            pGaikaKokyakuTuutiTy.getZtyuktnm118(),
            pGaikaKokyakuTuutiTy.getZtyuktnm218(),
            pGaikaKokyakuTuutiTy.getZtyuktnm318(),
            pGaikaKokyakuTuutiTy.getZtyuktnm418(),
            pGaikaKokyakuTuutiTy.getZtyuktnm518());

        for (int i = 0; i < uktMidasiKbnLst.size(); i++) {

            if (BizUtil.isBlank(uktMidasiKbnLst.get(i))) {
                break;
            }
            if (UKTMIDASIKBN_SBUKT.equals(uktMidasiKbnLst.get(i)) ||
                UKTMIDASIKBN_SBKHUUKT.equals(uktMidasiKbnLst.get(i)) ||
                UKTMIDASIKBN_NONE.equals(uktMidasiKbnLst.get(i))) {

                if (UKTRJNKBN_HKN.equals(uktKbnLst.get(i))) {
                    uktNms[i] = UKTRJNKBN_HKN_MSG;

                }
                else if (UKTRJNKBN_HKNKYK.equals(uktKbnLst.get(i))) {
                    uktNms[i] = UKTRJNKBN_HKNKYK_MSG;

                }
                else if (UKTRJNKBN_SOUZOKU.equals(uktKbnLst.get(i))) {
                    uktNms[i] = UKTRJNKBN_SOUZOKU_MSG;

                }
                else if (UKTRJNKBN_HKNSYO.equals(uktKbnLst.get(i))) {
                    uktNms[i] = UKTRJNKBN_HKNSYO_MSG;

                }
                else {
                    uktNms[i] = ViewReport.editSama(uktNmLst.get(i));
                }

            }
            else if (UKTMIDASIKBN_NKUKT.equals(uktMidasiKbnLst.get(i))) {
                if (UKTRJNKBN_HKN.equals(uktKbnLst.get(i))) {
                    uktNms[2] = UKTRJNKBN_HKN_MSG;

                }
                else if (UKTRJNKBN_HKNKYK.equals(uktKbnLst.get(i))) {
                    uktNms[2] = UKTRJNKBN_HKNKYK_MSG;

                }
            }
            else if (UKTMIDASIKBN_KKYDR.equals(uktMidasiKbnLst.get(i))) {
                if (UKTRJNKBN_ZENKAKU_MINUS.equals(uktKbnLst.get(i))) {
                    uktNms[3] = ZENKAKU_MINUS_MSG;
                }
                else {
                    uktNms[3] = ViewReport.editSama(uktNmLst.get(i));
                }
            }
            else if (UKTMIDASIKBN_STDR.equals(uktMidasiKbnLst.get(i))) {
                if (UKTRJNKBN_ZENKAKU_MINUS.equals(uktKbnLst.get(i))) {
                    uktNms[4] = ZENKAKU_MINUS_MSG;
                }
                else {
                    uktNms[4] = ViewReport.editSama(uktNmLst.get(i));
                }
            }
        }
        return uktNms;
    }

    private String getConvertKg(String pKingaku, C_Tuukasyu pTuuka, String pHenkanKbn) {

        if (BizUtil.isBlank(pKingaku)) {
            return "";
        }

        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
        CurrencyType currencyType = henkanTuuka.henkanTuukaKbnToType(pTuuka);

        Long kingaku = Long.parseLong(pKingaku);
        BizCurrency convertKingakuTmp = BizCurrency.valueOf(kingaku, currencyType);

        if (!C_Tuukasyu.JPY.eq(pTuuka)) {
            convertKingakuTmp = convertKingakuTmp.divide(100);
        }

        String convertKingaku = ViewReport.editCommaTuuka(convertKingakuTmp, BizUtil.ZERO_FILL);

        if (HENKANKBN_ZENSYMBOL.equals(pHenkanKbn)) {
            convertKingaku =  ConvertUtil.toZenSymbol(convertKingaku);
        }
        else if (HENKANKBN_ZENALL.equals(pHenkanKbn)) {
            convertKingaku =  ConvertUtil.toZenSymbol(convertKingaku);
            convertKingaku =  ConvertUtil.toZenNumeric(convertKingaku);
        }

        return convertKingaku;
    }

    private String getConvertRate(String pRate, String pYenGaikaKbn, String pHenkanKbn) {

        if (BizUtil.isBlank(pRate)) {
            return "";
        }
        int rate = Integer.parseInt(pRate);
        BizNumber convertRateTmp = BizNumber.valueOf(rate);

        String convertRate = "";

        if (YENGAIKAKBN_YENKA.equals(pYenGaikaKbn)) {
            convertRate =
                BizUtil.num(
                    convertRateTmp.divide(100, 2, RoundingMode.DOWN).toString(),
                    BizUtil.ZERO_FILL_LAST_ONLY,
                    3,
                    BizUtil.ZERO_FILL,
                    2);
        }
        else {
            convertRate =
                BizUtil.num(
                    convertRateTmp.divide(10000, 4, RoundingMode.DOWN).toString(),
                    BizUtil.ZERO_FILL_LAST_ONLY,
                    1,
                    BizUtil.ZERO_FILL,
                    4);
        }

        if (HENKANKBN_ZENSYMBOL.equals(pHenkanKbn)) {
            convertRate = ConvertUtil.toZenSymbol(convertRate);
        }

        return convertRate;
    }

    private BizDate getKwsrateKjYmd(BizDate pSysDate, C_Tuukasyu pKyktuukasyu) {

        GetKawaseRate getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);

        getKawaseRate.exec(
            pSysDate,
            C_KawaserateSyuruiKbn.KOUJIKAWASERATE,
            pKyktuukasyu,
            C_Tuukasyu.JPY,
            C_KawasetekiyoKbn.TTM,
            C_KawasetsryKbn.SYUKKINRATE,
            C_EigyoubiHoseiKbn.ZENEIGYOUBI,
            C_YouhiKbn.YOU);

        return getKawaseRate.getKwsrateKjYmd();
    }

    private int getKawaserateMinasiKbn(BizDate pSysDate, BizDate pKwsrateKjYmd) {

        if (BizDateUtil.compareYmd(pKwsrateKjYmd, pSysDate) == BizDateUtil.COMPARE_LESSER) {
            return KAWASERATE_MINASI;
        }

        return KAWASERATE_SEIJYOU;

    }

    private String getConvertRateTani(
        String pRate,
        String pHenkanKbn,
        int piIntegralPartDigit,
        int piDecimalPartDigit,
        String pTani) {

        if (BizUtil.isBlank(pRate)) {
            if (HENKANKBN_ZENALL.equals(pHenkanKbn)) {
                return KIGOU_ZEN_MINUS;
            }
            return KIGOU_HAN_MINUS;
        }
        int rate = Integer.parseInt(pRate);
        BizNumber convertRateTmp = BizNumber.valueOf(rate);

        String convertRateTani =
            BizUtil.num(
                convertRateTmp.divide(100, 2, RoundingMode.DOWN).toString(),
                BizUtil.ZERO_FILL_LAST_ONLY,
                piIntegralPartDigit,
                BizUtil.ZERO_FILL,
                piDecimalPartDigit) + pTani;

        if (HENKANKBN_ZENALL.equals(pHenkanKbn)) {
            convertRateTani =
                ConvertUtil.convZenHan(IDataConvert.iCONVERT_H2Z_ALL, convertRateTani);
        }

        return convertRateTani;
    }

    private String delSentouZero(String pValue) {

        Integer henkougoValue = Integer.parseInt(pValue);

        return henkougoValue.toString();
    }

    private String methodNmEditAndExec (
        Class<ZT_GaikaKokyakuTuutiTy> pClass,
        ZT_GaikaKokyakuTuutiTy pGaikaKokyakuTuutiTy,
        String pMethodNm,
        int pMethodNo) throws
        IllegalAccessException,
        NoSuchMethodException,
        InvocationTargetException {

        Method getMethod = pClass.getMethod(pMethodNm + String.valueOf(pMethodNo));
        Object getValue  = getMethod.invoke(pGaikaKokyakuTuutiTy);
        return getValue.toString();
    }
}
