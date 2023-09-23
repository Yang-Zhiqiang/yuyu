package yuyu.common.hozen.khcommon;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.RoundingMode;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.configuration.CoreConfig;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateFormat;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.date.CHolidayAdjustingMode;
import jp.co.slcs.swak.date.BizDateFormat.FillStyle;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import jp.co.slcs.swak.number.currencytype.CurrencyType;
import jp.co.slcs.swak.util.string.ConvertUtil;
import yuyu.common.base.format.FixedDateFormatter;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.GetKawaseRate;
import yuyu.common.biz.bzcommon.GetSisuu;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.bzcommon.KeisanGaikakanzan;
import yuyu.common.biz.bzcommon.SetNenrei;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.hozen.khcommon.dba4editkyknaiyouosirase.EditKykNaiyouOsiraseDao;
import yuyu.common.siharai.sicommon.CalcHkShrKngk;
import yuyu.common.siharai.sicommon.CalcHkShrKngkBean;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_EigyoubiHoseiKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.classification.C_HokenkinsyuruiKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_KawaserateSyuruiKbn;
import yuyu.def.classification.C_KawasetekiyoKbn;
import yuyu.def.classification.C_KawasetsryKbn;
import yuyu.def.classification.C_Nenkinsyu;
import yuyu.def.classification.C_SiinKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TargetTkKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_TykzentykgoKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.BM_SisuuKihon;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.IT_KhSisuurendoTmttkn;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_NyknJissekiRireki;
import yuyu.def.db.entity.ZT_GaikaKokyakuTuutiTy;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.hozen.result.bean.SisurendoTmttknInfoBean;

/**
 * 契約保全 契約保全共通 契約内容のお知らせ編集２（年金外貨）
 */
public class EditKykNaiyouOsirase2 {

    private static final String AISATUMSGCD_03001 = "03001";

    private static final String AISATUMSGCD_03002 = "03002";

    private static final String AISATUMSGCD_03006 = "03006";

    private static final String AISATUMSGCD_03007 = "03007";

    private static final String HOSYOUH_HSKMSGCD01 = "05001";

    private static final String HOSYOUH_HSKMSGCD07 = "05007";

    private static final String HOSYOUH_HSKMSGCD08 = "05008";

    private static final String HOSYOUH_HSKMSGCD09 = "05009";

    private static final String HOSYOUH_HSKMSGCD10 = "05010";

    private static final String HOSYOUH_HSKMSGCD11 = "05011";

    private static final String HOSYOUH_HSKMSGCD12 = "05012";

    private static final String HRKGKHYOUJIKBN_HIHYOUJI = "0";

    private static final String HRKGKHYOUJIKBN_YEN = "1";

    private static final String HRKGKHYOUJIKBN_STIGI = "2";

    private static final String KJNKNGKHYOUJIKBN_MSG = "1";

    private static final String KJNKNGKHYOUJIKBN_KG = "2";

    private static final String TMTTKNSUIIRIREKIKBN_BLANK = "0";

    private static final String TMTTKNSUIIRIREKIKBN_KYK = "1";

    private static final String TMTTKNSUIIRIREKIKBN_SKSYMD = "2";

    private static final String TMTTKNSUIIRIREKIKBN_TMTTKNITEN = "3";

    private static final String TMTTKNSUIIRIREKIKBN_TYKZEN = "4";

    private static final String MKHGKHYOUJIKBN_TKNASI = "0";

    private static final String MKHGKHYOUJIKBN_TKARI_ZEROIGAI = "1";

    private static final String MKHGKHYOUJIKBN_TKARI_ZERO = "2";

    private static final String SISUUUPRITUHUGOU_SEISUU = "0";

    private static final String SISUUUPRITUHUGOU_HUSUU = "1";

    private static final String GENGAKU_NASI = "0";

    private static final String GENGAKU_ARI = "1";

    private static final String TMTTKNJYOUTAI_SISUU = "1";

    private static final String TMTTKNJYOUTAI_TEIRITUTMTT = "2";

    private static final String TMTTKNJYOUTAI_TEIRITUITEN = "3";

    private static final String NEN = "年";

    private static final String BLANK = "";

    private static final int JYOUSUU_HYAKU = 100;

    private static final int JYOUSUU_MAN = 10000;

    private static final String ERROR_MSG = "金額チェックエラーです。システム管理者にお問い合わせください。";

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private EditKykNaiyouOsiraseDao editKykNaiyouOsiraseDao;

    private C_ErrorKbn commonErrorKbn = C_ErrorKbn.OK;

    public EditKykNaiyouOsirase2() {
        super();
    }

    C_ErrorKbn getCommonErrorKbn() {
        return commonErrorKbn;
    }

    public ZT_GaikaKokyakuTuutiTy editInfo(
        IT_KykKihon pKykKihon,
        BizDate pSyoriYmd,
        BizDate pKykoutoubi,
        String pSyouhnHanmeiKbn,
        ZT_GaikaKokyakuTuutiTy pGaikaKokyakuTuutiTyn) {
        BizCurrency yenHrkgk = BizCurrency.optional(BizCurrencyTypes.YEN);
        String stigiTuukaHrkGk = BLANK;
        String hrktuukasyu = BLANK;
        String hrktuukatype = BLANK;
        String stitukaKawaserate = BLANK;
        String yenkHrikmrateMarumeAri = BLANK;
        String kjnKngkKawaserateMarumeAri = BLANK;
        String hrkgkHyoujikbn = BLANK;
        BizCurrency kjnKngk = BizCurrency.optional(BizCurrencyTypes.YEN);
        String kjnKngkHyoujikbn = KJNKNGKHYOUJIKBN_KG;
        String mkhGk = BLANK;
        String mkhGkwari = BLANK;
        String mkhGkHyoujikbn = BLANK;
        String osiraseTuutiSakuseiYm = BLANK;
        String ttdkkigen = BLANK;
        String karinkgnsgkkyktuuka = BLANK;
        String aisatumsgcd1 = BLANK;

        IT_KykSyouhn kykSyouhn = pKykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU).get(0);
        IT_KykSonotaTkyk kykSonotaTkyk = pKykKihon.getKykSonotaTkyk();
        BM_SyouhnZokusei syouhnZokusei = kykSyouhn.getSyouhnZokusei();

        String syono = pKykKihon.getSyono();
        BizDate kykymd = kykSyouhn.getKykymd();

        if (EditKykNaiyouOsirase.SYOUHNHANMEIKBN_NENKIN_SISUU3MONTHMAE.equals(pSyouhnHanmeiKbn)) {
            aisatumsgcd1 = AISATUMSGCD_03006;
        }
        else if (EditKykNaiyouOsirase.SYOUHNHANMEIKBN_NENKIN_SISUU.equals(pSyouhnHanmeiKbn) ||
            EditKykNaiyouOsirase.SYOUHNHANMEIKBN_NENKIN_TEIRITU.equals(pSyouhnHanmeiKbn)) {
            aisatumsgcd1 = AISATUMSGCD_03007;
        }
        else if (EditKykNaiyouOsirase.SYOUHNHANMEIKBN_NENKIN_TEIRITUITEN.equals(pSyouhnHanmeiKbn)) {

            int teirituitenNendo = getNendo(kykSyouhn.getTmttknitenymd().getBizDateYM());

            int  kykoutouNendo = getNendo(pKykoutoubi.getBizDateYM());

            if (teirituitenNendo == kykoutouNendo) {
                aisatumsgcd1 = AISATUMSGCD_03001;
            }
            else {
                aisatumsgcd1 = AISATUMSGCD_03002;
            }
        }

        SetNenrei setNenrei = SWAKInjector.getInstance(SetNenrei.class);
        int nkNenrei =
            setNenrei.getNkshrStartNenrei(
                kykSyouhn.getHhknnen(),
                kykSyouhn.getHknkkn());

        String nksyukbn;

        if (C_Nenkinsyu.KAKUTEINENKIN.eq(kykSyouhn.getNksyukbn())) {

            nksyukbn =
                ConvertUtil.toZenNumeric(kykSyouhn.getNenkinkkn().toString()) + NEN + kykSyouhn.getNksyukbn().getContent();
        }
        else {
            nksyukbn = kykSyouhn.getNksyukbn().getContent();
        }

        List<IT_NyknJissekiRireki> nyknJissekiRirekiLst = pKykKihon.getNyknJissekiRirekis();

        hrktuukasyu = nyknJissekiRirekiLst.get(0).getRstuukasyu().getContent();
        hrktuukatype = nyknJissekiRirekiLst.get(0).getRstuukasyu().getValue();

        if (C_UmuKbn.ARI.eq(kykSonotaTkyk.getYennykntkhkumu())) {
            yenHrkgk = nyknJissekiRirekiLst.get(0).getRsgaku();
            hrkgkHyoujikbn = HRKGKHYOUJIKBN_YEN;
        }
        else if (C_UmuKbn.ARI.eq(kykSonotaTkyk.getGaikanykntkhkumu())) {
            stigiTuukaHrkGk = nyknJissekiRirekiLst.get(0).getRsgaku().multiply(JYOUSUU_HYAKU).toString();
            hrkgkHyoujikbn = HRKGKHYOUJIKBN_STIGI;
        }
        else {
            hrkgkHyoujikbn = HRKGKHYOUJIKBN_HIHYOUJI;
        }

        CalcHkShrKngk calcHkShrKngk = SWAKInjector.getInstance(CalcHkShrKngk.class);
        C_ErrorKbn errorKbn = calcHkShrKngk.execByKeisanWExt(
            syono,
            pKykoutoubi,
            C_SiinKbn.SP,
            C_HokenkinsyuruiKbn.SBKYUUHUKIN,
            pKykKihon.getSdpdkbn(),
            pKykKihon.getHrkkeiro());

        if (!C_ErrorKbn.OK.eq(errorKbn)) {
            if (CoreConfig.getInstance().isBatchProduct()) {
                commonErrorKbn = C_ErrorKbn.ERROR;
                return pGaikaKokyakuTuutiTyn;
            }

            throw new CommonBizAppException(ERROR_MSG);
        }

        CalcHkShrKngkBean calcHkShrKngkBean = calcHkShrKngk.getCalcHkShrKngkBean();

        BizCurrency sbhknkngkKyktuuka = calcHkShrKngkBean.getSibousGk().multiply(JYOUSUU_HYAKU);
        BizCurrency tmttkngkKyktuuka = calcHkShrKngkBean.getTmttKnGk().multiply(JYOUSUU_HYAKU);
        BizCurrency kaiyakuhrkngakKyktuuka = calcHkShrKngkBean.getKaiyakuhenreiknGk().multiply(JYOUSUU_HYAKU);

        GetKawaseRate getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);
        getKawaseRate.exec(
            nyknJissekiRirekiLst.get(0).getRyosyuymd(),
            C_KawaserateSyuruiKbn.KOUJIKAWASERATE,
            kykSyouhn.getKyktuukasyu(),
            C_Tuukasyu.JPY,
            C_KawasetekiyoKbn.TTM,
            C_KawasetsryKbn.NYUKINRATE,
            C_EigyoubiHoseiKbn.YOKUEIGYOUBI,
            C_YouhiKbn.HUYOU);

        BizNumber yenkHrikmrate = getKawaseRate.getKawaserate();

        if (C_UmuKbn.ARI.eq(kykSonotaTkyk.getYennykntkhkumu())) {

            yenkHrikmrateMarumeAri = String.valueOf(yenkHrikmrate.round(2, RoundingMode.DOWN).multiply(JYOUSUU_HYAKU));
        }

        kjnKngkKawaserateMarumeAri = String.valueOf(yenkHrikmrate.round(2, RoundingMode.DOWN).multiply(JYOUSUU_HYAKU));

        KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);

        kjnKngk = keisanGaikakanzan.exec(
            C_Tuukasyu.JPY,
            pKykKihon.getHrkp(),
            yenkHrikmrate,
            C_HasuusyoriKbn.AGE);

        if (C_UmuKbn.ARI.eq(kykSonotaTkyk.getGaikanykntkhkumu())) {
            getKawaseRate.exec(
                nyknJissekiRirekiLst.get(0).getRyosyuymd(),
                C_KawaserateSyuruiKbn.KOUJIKAWASERATE,
                kykSyouhn.getKyktuukasyu(),
                nyknJissekiRirekiLst.get(0).getRstuukasyu(),
                C_KawasetekiyoKbn.TTM,
                C_KawasetsryKbn.NYUKINRATE,
                C_EigyoubiHoseiKbn.YOKUEIGYOUBI,
                C_YouhiKbn.HUYOU);

            stitukaKawaserate = String.valueOf(getKawaseRate.getKawaserate().multiply(JYOUSUU_MAN));
        }

        C_EigyoubiHoseiKbn eigyoubiHoseiKbn;
        C_YouhiKbn youhiKbn;

        if (CoreConfig.getInstance().isBatchProduct()) {
            eigyoubiHoseiKbn = C_EigyoubiHoseiKbn.YOKUEIGYOUBI;
            youhiKbn =C_YouhiKbn.HUYOU;
        }
        else {
            eigyoubiHoseiKbn = C_EigyoubiHoseiKbn.ZENEIGYOUBI;
            youhiKbn =C_YouhiKbn.YOU;
        }

        getKawaseRate.exec(
            pKykoutoubi,
            C_KawaserateSyuruiKbn.KOUJIKAWASERATE,
            kykSyouhn.getKyktuukasyu(),
            C_Tuukasyu.JPY,
            C_KawasetekiyoKbn.TTM,
            C_KawasetsryKbn.SYUKKINRATE,
            eigyoubiHoseiKbn,
            youhiKbn);

        BizNumber getKawaseRateOutoubiJiten = getKawaseRate.getKawaserate();

        BizCurrency sbhknkngkYen = keisanGaikakanzan.exec(
            C_Tuukasyu.JPY,
            calcHkShrKngkBean.getSibousGk(),
            getKawaseRateOutoubiJiten,
            C_HasuusyoriKbn.AGE);

        BizCurrency tmttkngkkukYen = keisanGaikakanzan.exec(
            C_Tuukasyu.JPY,
            calcHkShrKngkBean.getTmttKnGk(),
            getKawaseRateOutoubiJiten,
            C_HasuusyoriKbn.AGE);

        BizCurrency kaiyakuhrkngakYen = keisanGaikakanzan.exec(
            C_Tuukasyu.JPY,
            calcHkShrKngkBean.getKaiyakuhenreiknGk(),
            getKawaseRateOutoubiJiten,
            C_HasuusyoriKbn.AGE);

        getKawaseRateOutoubiJiten = getKawaseRateOutoubiJiten.round(2, RoundingMode.DOWN);

        if (C_UmuKbn.ARI.eq(kykSonotaTkyk.getTargettkhkumu()) &&
            C_TargetTkKbn.NENKIN.eq(kykSonotaTkyk.getTargettkkbn())) {
            mkhGk = kykSonotaTkyk.getTargettkykkijyungk().toString();
            mkhGkwari = kykSonotaTkyk.getTargettkmokuhyouti().toString();

            if (kykSonotaTkyk.getTargettkmokuhyouti() != 0) {
                mkhGkHyoujikbn = MKHGKHYOUJIKBN_TKARI_ZEROIGAI;
            }
            else {
                mkhGkHyoujikbn = MKHGKHYOUJIKBN_TKARI_ZERO;
            }
        }
        else {
            mkhGkHyoujikbn = MKHGKHYOUJIKBN_TKNASI;
        }

        String sakuseikijyunymdwa = pGaikaKokyakuTuutiTyn.getZtysakuseikijyunymdwa();

        if (!EditKykNaiyouOsirase.SYOUHNHANMEIKBN_NENKIN_SISUU3MONTHMAE.equals(pSyouhnHanmeiKbn)) {
            osiraseTuutiSakuseiYm = pKykoutoubi.getBizDateYM().toString();
        }
        else {
            sakuseikijyunymdwa = FixedDateFormatter.formatYMDZenkakuSeirekiKanji(pKykoutoubi);

            SetOutoubi setOutoubi = SWAKInjector.getInstance(SetOutoubi.class);
            BizDate keiyakuOutoubi = setOutoubi.exec(C_TykzentykgoKbn.TYKGO, kykymd, C_Hrkkaisuu.NEN, pSyoriYmd);

            ttdkkigen =
                FixedDateFormatter.formatYMDZenkakuSeirekiKanji(
                    keiyakuOutoubi.addDays(-14).getBusinessDay(CHolidayAdjustingMode.NEXT));

            BizCurrency nkGnsGk = getNkGnsGk(syono, pSyoriYmd, pSyouhnHanmeiKbn, kykSyouhn, kykSonotaTkyk);

            karinkgnsgkkyktuuka = nkGnsGk.multiply(JYOUSUU_HYAKU).toString();
        }

        String gengakuUmu = GENGAKU_NASI;

        List<IT_KhTtdkRireki> ttdkRirekiList =
            pKykKihon.getKhTtdkRirekisByGyoumuKousinKinou(
                IKhozenCommonConstants.KINOUID_GENGAKU);

        if (ttdkRirekiList.size() > 0) {
            gengakuUmu = GENGAKU_ARI;
        }

        String itijibrpkyktuukaStr = BLANK;
        String yenhrkgkStr = BLANK;
        String stigituukahrkgkStr = BLANK;
        String stigikwsrateStr = BLANK;
        String kijyunkingakukyktuukaStr = BLANK;
        String nkgnsgkkyktuukaStr = BLANK;
        String hosyouhskmsgcd1 = BLANK;
        String hosyouhskmsgcd2 = BLANK;
        String hosyouhskmsgcd5 = BLANK;
        String hosyouhskmsgcd6 = BLANK;

        if (GENGAKU_NASI.equals(gengakuUmu)) {
            itijibrpkyktuukaStr = nyknJissekiRirekiLst.get(0).getHrkp().multiply(JYOUSUU_HYAKU).toString();
            yenhrkgkStr = yenHrkgk.toString();
            stigituukahrkgkStr = stigiTuukaHrkGk;
            stigikwsrateStr = stitukaKawaserate;
            kijyunkingakukyktuukaStr = pKykKihon.getHrkp().multiply(BizNumber.valueOf(JYOUSUU_HYAKU)).toString();

            if (EditKykNaiyouOsirase.SYOUHNHANMEIKBN_NENKIN_TEIRITU.equals(pSyouhnHanmeiKbn) ||
                EditKykNaiyouOsirase.SYOUHNHANMEIKBN_NENKIN_TEIRITUITEN.equals(pSyouhnHanmeiKbn)) {
                BizCurrency nkGnsGk = getNkGnsGk(syono, pSyoriYmd, pSyouhnHanmeiKbn, kykSyouhn, kykSonotaTkyk);
                nkgnsgkkyktuukaStr = nkGnsGk.multiply(JYOUSUU_HYAKU).toString();
            }

            if (C_UmuKbn.ARI.eq(kykSonotaTkyk.getYennykntkhkumu())) {
                kjnKngkHyoujikbn = KJNKNGKHYOUJIKBN_MSG;
            }

            if (C_UmuKbn.ARI.eq(kykSonotaTkyk.getYennykntkhkumu()) ||
                C_UmuKbn.ARI.eq(kykSonotaTkyk.getGaikanykntkhkumu())) {
                hosyouhskmsgcd1 = HOSYOUH_HSKMSGCD01;
            }
        }
        else {
            kijyunkingakukyktuukaStr = pKykKihon.getHrkp().multiply(BizNumber.valueOf(JYOUSUU_HYAKU)).toString();

            if (EditKykNaiyouOsirase.SYOUHNHANMEIKBN_NENKIN_TEIRITU.equals(pSyouhnHanmeiKbn) ||
                EditKykNaiyouOsirase.SYOUHNHANMEIKBN_NENKIN_TEIRITUITEN.equals(pSyouhnHanmeiKbn)) {
                BizCurrency nkGnsGk = getNkGnsGk(syono, pSyoriYmd, pSyouhnHanmeiKbn, kykSyouhn, kykSonotaTkyk);
                nkgnsgkkyktuukaStr = nkGnsGk.multiply(JYOUSUU_HYAKU).toString();
            }
            hosyouhskmsgcd1 = HOSYOUH_HSKMSGCD08;
        }

        if (KJNKNGKHYOUJIKBN_KG.equals(kjnKngkHyoujikbn)) {
            if (C_UmuKbn.NONE.eq(kykSonotaTkyk.getYennykntkhkumu())) {
                if(BizUtil.isBlank(hosyouhskmsgcd1)){
                    hosyouhskmsgcd1 = HOSYOUH_HSKMSGCD09;
                }
                else{
                    hosyouhskmsgcd2 = HOSYOUH_HSKMSGCD09;
                }
            }
        }

        if (EditKykNaiyouOsirase.SYOUHNHANMEIKBN_NENKIN_SISUU3MONTHMAE.equals(pSyouhnHanmeiKbn) ||
            EditKykNaiyouOsirase.SYOUHNHANMEIKBN_NENKIN_TEIRITU.equals(pSyouhnHanmeiKbn)) {
            hosyouhskmsgcd5 = HOSYOUH_HSKMSGCD07;
            hosyouhskmsgcd6 = BLANK;
        }
        else if (EditKykNaiyouOsirase.SYOUHNHANMEIKBN_NENKIN_SISUU.equals(pSyouhnHanmeiKbn)) {
            hosyouhskmsgcd5 = HOSYOUH_HSKMSGCD12;
            hosyouhskmsgcd6 = HOSYOUH_HSKMSGCD07;
        }
        else {
            hosyouhskmsgcd5 = HOSYOUH_HSKMSGCD11;
            hosyouhskmsgcd6 = HOSYOUH_HSKMSGCD07;
        }

        String sisuunm = BLANK;
        BM_SisuuKihon sisuuKihon = bizDomManager.getSisuuKihon(kykSyouhn.getSisuukbn());

        if (sisuuKihon != null) {

            sisuunm = sisuuKihon.getSisuunm();
        }

        pGaikaKokyakuTuutiTyn.setZtysyoruicd(C_SyoruiCdKbn.KK_GAIKA_KOKYAKUTUUTI.getValue().toUpperCase());
        pGaikaKokyakuTuutiTyn.setZtygengkumu(gengakuUmu);
        pGaikaKokyakuTuutiTyn.setZtyaisatumsgcd1(aisatumsgcd1);
        pGaikaKokyakuTuutiTyn.setZtyosirasetuutisakuseiymwa(
            FixedDateFormatter.formatYMZenkakuSeirekiKanji(BizDate.valueOf(osiraseTuutiSakuseiYm + "01")));
        pGaikaKokyakuTuutiTyn.setZtynkshrstartymdstr(
            FixedDateFormatter.formatYMDZenkakuSeirekiKanji(kykSyouhn.getHknkknmanryouymd()));
        pGaikaKokyakuTuutiTyn.setZtynenkinstartnen(String.valueOf(nkNenrei));
        pGaikaKokyakuTuutiTyn.setZtynksyuruinm(nksyukbn);
        pGaikaKokyakuTuutiTyn.setZtysakuseikijyunymdwa(sakuseikijyunymdwa);
        pGaikaKokyakuTuutiTyn.setZtyhrktuukasyuzn(hrktuukasyu);
        pGaikaKokyakuTuutiTyn.setZtyhrktuukatype(hrktuukatype);
        pGaikaKokyakuTuutiTyn.setZtyyenkhrikmrate(yenkHrikmrateMarumeAri);
        pGaikaKokyakuTuutiTyn.setZtyhrkgkhyoujikbn(hrkgkHyoujikbn);
        pGaikaKokyakuTuutiTyn.setZtyitijibrpkyktuuka(itijibrpkyktuukaStr);
        pGaikaKokyakuTuutiTyn.setZtyyenhrkgk(yenhrkgkStr);
        pGaikaKokyakuTuutiTyn.setZtystigituukahrkgk(stigituukahrkgkStr);
        pGaikaKokyakuTuutiTyn.setZtystigikwsrate(stigikwsrateStr);
        pGaikaKokyakuTuutiTyn.setZtykijyunkingaku(kjnKngk.toString());
        pGaikaKokyakuTuutiTyn.setZtykjnkngkkawaserate(kjnKngkKawaserateMarumeAri);
        pGaikaKokyakuTuutiTyn.setZtykjnkngkhyoujikbn(kjnKngkHyoujikbn);
        pGaikaKokyakuTuutiTyn.setZtynkgnsgkkyktuuka(nkgnsgkkyktuukaStr);
        pGaikaKokyakuTuutiTyn.setZtykijyunkingakukyktuuka(kijyunkingakukyktuukaStr);
        pGaikaKokyakuTuutiTyn.setZtysakuseikijyunymdkwsrate(
            String.valueOf(getKawaseRateOutoubiJiten.multiply(JYOUSUU_HYAKU)));
        pGaikaKokyakuTuutiTyn.setZtysbhknkngkkyktuuka(sbhknkngkKyktuuka.toString());
        pGaikaKokyakuTuutiTyn.setZtysbhknkngkyen(sbhknkngkYen.toString());
        pGaikaKokyakuTuutiTyn.setZtytumitatekngkktuuka(tmttkngkKyktuuka.toString());
        pGaikaKokyakuTuutiTyn.setZtytumitatekngkkyen(tmttkngkkukYen.toString());
        pGaikaKokyakuTuutiTyn.setZtykaiyakuhrkngakkyktuuka(kaiyakuhrkngakKyktuuka.toString());
        pGaikaKokyakuTuutiTyn.setZtykaiyakuhrkngakyen(kaiyakuhrkngakYen.toString());
        pGaikaKokyakuTuutiTyn.setZtymkhgkyen(mkhGk);
        pGaikaKokyakuTuutiTyn.setZtymkhgkwari(mkhGkwari);
        pGaikaKokyakuTuutiTyn.setZtymkhgkhyoujikbn(mkhGkHyoujikbn);
        pGaikaKokyakuTuutiTyn.setZtyhosyouhskmsgcd1(hosyouhskmsgcd1);
        pGaikaKokyakuTuutiTyn.setZtyhosyouhskmsgcd2(hosyouhskmsgcd2);
        pGaikaKokyakuTuutiTyn.setZtyhosyouhskmsgcd3(BLANK);
        pGaikaKokyakuTuutiTyn.setZtyhosyouhskmsgcd4(HOSYOUH_HSKMSGCD10);
        pGaikaKokyakuTuutiTyn.setZtyhosyouhskmsgcd5(hosyouhskmsgcd5);
        pGaikaKokyakuTuutiTyn.setZtyhosyouhskmsgcd6(hosyouhskmsgcd6);
        pGaikaKokyakuTuutiTyn.setZtyhosyouhskmsgcd7(BLANK);

        pGaikaKokyakuTuutiTyn.setZtyttdkkigen(ttdkkigen);
        pGaikaKokyakuTuutiTyn.setZtykrnkgnsgk(karinkgnsgkkyktuuka);

        pGaikaKokyakuTuutiTyn.setZtysetteibairitustr(String.valueOf(kykSyouhn.getSetteibairitu().multiply(JYOUSUU_HYAKU)));
        pGaikaKokyakuTuutiTyn.setZtytmttknzkrtjygnstr(String.valueOf(kykSyouhn.getTmttknzoukaritujygn().multiply(JYOUSUU_MAN)));
        pGaikaKokyakuTuutiTyn.setZtytmttknzkrtkgnstr("0");
        pGaikaKokyakuTuutiTyn.setZtytumitateriritustr(String.valueOf(kykSyouhn.getTumitateriritu().multiply(JYOUSUU_MAN)));
        pGaikaKokyakuTuutiTyn.setZtysisuunm(sisuunm);

        List<IT_KhSisuurendoTmttkn> khSisuurendoTmttknList = editKykNaiyouOsiraseDao.getKhSisuurendoTmttkns(syono, pSyoriYmd);

        BizDateFormat format = new BizDateFormat("yyyy年MM月dd日", FillStyle.None);

        if (EditKykNaiyouOsirase.SYOUHNHANMEIKBN_NENKIN_SISUU.equals(pSyouhnHanmeiKbn) ||
            EditKykNaiyouOsirase.SYOUHNHANMEIKBN_NENKIN_TEIRITU.equals(pSyouhnHanmeiKbn) ||
            EditKykNaiyouOsirase.SYOUHNHANMEIKBN_NENKIN_TEIRITUITEN.equals(pSyouhnHanmeiKbn)) {

            int listSize = khSisuurendoTmttknList.size();
            int maxCount = 11;
            int loopCount = 0;
            int methodNo = 1;
            String tmttknsuiirirekikbnStr = BLANK;
            String keiyakuoutoubiStr = BLANK;
            String tmttknjyoutaiStr = BLANK;
            String ptumitatekngkktuukaStr = BLANK;
            String ptumitatekngkyenStr = BLANK;
            String sisuuStr = BLANK;
            String sisuuuprituhugouStr = BLANK;
            String sisuuuprituStr = BLANK;
            String tmttknzoukarituStr = BLANK;
            String kawaserateStr = BLANK;
            BizDateYM teirituitenYm = null;

            if (listSize <= maxCount) {
                loopCount = listSize;
            }
            else {
                loopCount = maxCount;
            }

            for (int index = 0; index < loopCount; index++) {

                IT_KhSisuurendoTmttkn khSisuurendoTmttkn = khSisuurendoTmttknList.get(index);

                if (index == 0) {
                    tmttknsuiirirekikbnStr = TMTTKNSUIIRIREKIKBN_KYK;
                }
                else {

                    if (EditKykNaiyouOsirase.SYOUHNHANMEIKBN_NENKIN_TEIRITUITEN.equals(pSyouhnHanmeiKbn)) {
                        teirituitenYm = kykSyouhn.getTmttknitenymd().getBizDateYM();
                        if (BizDateUtil.compareYm(teirituitenYm, khSisuurendoTmttkn.getTmttkntaisyouym()) == BizDateUtil.COMPARE_EQUAL) {
                            tmttknsuiirirekikbnStr = TMTTKNSUIIRIREKIKBN_TMTTKNITEN;
                        }
                        else {
                            tmttknsuiirirekikbnStr = TMTTKNSUIIRIREKIKBN_BLANK;
                        }
                    }
                    else {
                        tmttknsuiirirekikbnStr = TMTTKNSUIIRIREKIKBN_BLANK;
                    }
                }

                keiyakuoutoubiStr =
                    format.format(BizDate.valueOf(khSisuurendoTmttkn.getTmttkntaisyouym(), kykymd.getDay()).getRekijyou());

                getKawaseRate.exec(
                    khSisuurendoTmttkn.getTmttknkouryokukaisiymd(),
                    C_KawaserateSyuruiKbn.KOUJIKAWASERATE,
                    kykSyouhn.getKyktuukasyu(),
                    C_Tuukasyu.JPY,
                    C_KawasetekiyoKbn.TTM,
                    C_KawasetsryKbn.SYUKKINRATE,
                    eigyoubiHoseiKbn,
                    youhiKbn);

                BizNumber kawaserate = getKawaseRate.getKawaserate();
                kawaserateStr = kawaserate.multiply(JYOUSUU_HYAKU).toString();

                if (EditKykNaiyouOsirase.SYOUHNHANMEIKBN_NENKIN_SISUU.equals(pSyouhnHanmeiKbn)) {
                    tmttknjyoutaiStr = TMTTKNJYOUTAI_SISUU;
                    ptumitatekngkktuukaStr =
                        khSisuurendoTmttkn.getSisuurendoutmttkngk().multiply(JYOUSUU_HYAKU).toString();
                    ptumitatekngkyenStr = keisanGaikakanzan.exec(
                        C_Tuukasyu.JPY,
                        khSisuurendoTmttkn.getSisuurendoutmttkngk(),
                        kawaserate,
                        C_HasuusyoriKbn.AGE).toString();

                    sisuuStr = khSisuurendoTmttkn.getTmttknhaneisisuu().round(2, RoundingMode.DOWN).multiply(JYOUSUU_HYAKU).toString();

                    if (index == 0) {
                        sisuuuprituhugouStr = BLANK;
                        sisuuuprituStr = BLANK;
                        tmttknzoukarituStr = BLANK;
                    }
                    else {
                        BizNumber sisuuupritu = khSisuurendoTmttkn.getSisuuupritu();

                        if (sisuuupritu.compareTo(BizNumber.ZERO) < 0) {
                            sisuuuprituhugouStr = SISUUUPRITUHUGOU_HUSUU;
                            sisuuupritu = sisuuupritu.multiply(JYOUSUU_MAN).multiply(-1);
                        }
                        else {
                            sisuuuprituhugouStr = SISUUUPRITUHUGOU_SEISUU;
                            sisuuupritu = sisuuupritu.multiply(JYOUSUU_MAN);
                        }

                        sisuuuprituStr = sisuuupritu.toString();
                        tmttknzoukarituStr =
                            khSisuurendoTmttkn.getTmttknzoukaritu().multiply(JYOUSUU_MAN).toString();
                    }
                }
                else if (EditKykNaiyouOsirase.SYOUHNHANMEIKBN_NENKIN_TEIRITU.equals(pSyouhnHanmeiKbn)) {
                    ptumitatekngkktuukaStr =
                        khSisuurendoTmttkn.getTeiritutmttkngk().multiply(JYOUSUU_HYAKU).toString();
                    ptumitatekngkyenStr = keisanGaikakanzan.exec(
                        C_Tuukasyu.JPY,
                        khSisuurendoTmttkn.getTeiritutmttkngk(),
                        kawaserate,
                        C_HasuusyoriKbn.AGE).toString();
                }
                else {
                    BizCurrency teiritutmttkngk = khSisuurendoTmttkn.getTeiritutmttkngk();
                    if (!teiritutmttkngk.isZeroOrOptional()) {
                        if (BizDateUtil.compareYm(teirituitenYm, khSisuurendoTmttkn.getTmttkntaisyouym()) == BizDateUtil.COMPARE_EQUAL) {
                            tmttknjyoutaiStr = TMTTKNJYOUTAI_TEIRITUITEN;
                        }
                        else {
                            tmttknjyoutaiStr = TMTTKNJYOUTAI_TEIRITUTMTT;
                        }

                    }
                    else {
                        tmttknjyoutaiStr = TMTTKNJYOUTAI_SISUU;
                    }

                    BizCurrency ptumitatekngkktuuka =
                        khSisuurendoTmttkn.getSisuurendoutmttkngk().add(
                            khSisuurendoTmttkn.getTeiritutmttkngk());
                    ptumitatekngkktuukaStr = ptumitatekngkktuuka.multiply(JYOUSUU_HYAKU).toString();
                    ptumitatekngkyenStr = keisanGaikakanzan.exec(
                        C_Tuukasyu.JPY,
                        ptumitatekngkktuuka,
                        kawaserate,
                        C_HasuusyoriKbn.AGE).toString();

                    if (TMTTKNJYOUTAI_TEIRITUTMTT.equals(tmttknjyoutaiStr)) {
                        sisuuStr =  BLANK;
                    }
                    else {
                        sisuuStr = khSisuurendoTmttkn.getTmttknhaneisisuu().round(2, RoundingMode.DOWN).multiply(JYOUSUU_HYAKU).toString();
                    }

                    if (index == 0) {
                        sisuuuprituhugouStr = BLANK;
                        sisuuuprituStr = BLANK;
                        tmttknzoukarituStr = BLANK;
                    }
                    else {

                        if (TMTTKNJYOUTAI_TEIRITUTMTT.equals(tmttknjyoutaiStr)) {
                            sisuuuprituhugouStr = BLANK;
                            sisuuuprituStr = BLANK;
                            tmttknzoukarituStr =
                                kykSyouhn.getTumitateriritu().multiply(JYOUSUU_MAN).toString();
                        }
                        else {
                            BizNumber sisuuupritu = khSisuurendoTmttkn.getSisuuupritu();

                            if (sisuuupritu.compareTo(BizNumber.ZERO) < 0) {
                                sisuuuprituhugouStr = SISUUUPRITUHUGOU_HUSUU;
                                sisuuupritu = sisuuupritu.multiply(JYOUSUU_MAN).multiply(-1);
                            }
                            else {
                                sisuuuprituhugouStr = SISUUUPRITUHUGOU_SEISUU;
                                sisuuupritu = sisuuupritu.multiply(JYOUSUU_MAN);
                            }

                            sisuuuprituStr = sisuuupritu.toString();
                            tmttknzoukarituStr =
                                khSisuurendoTmttkn.getTmttknzoukaritu().multiply(JYOUSUU_MAN).toString();
                        }
                    }
                }

                try {
                    methodNmEditAndExec(
                        ZT_GaikaKokyakuTuutiTy.class,
                        pGaikaKokyakuTuutiTyn,
                        "setZtytmttknsuiirirekikbnx",
                        methodNo, tmttknsuiirirekikbnStr);
                    methodNmEditAndExec(
                        ZT_GaikaKokyakuTuutiTy.class,
                        pGaikaKokyakuTuutiTyn,
                        "setZtykeiyakuoutoubix",
                        methodNo, keiyakuoutoubiStr);
                    methodNmEditAndExec(
                        ZT_GaikaKokyakuTuutiTy.class,
                        pGaikaKokyakuTuutiTyn,
                        "setZtytmttknjyoutaix",
                        methodNo, tmttknjyoutaiStr);
                    methodNmEditAndExec(
                        ZT_GaikaKokyakuTuutiTy.class,
                        pGaikaKokyakuTuutiTyn,
                        "setZtyptumitatekngkktuukax",
                        methodNo, ptumitatekngkktuukaStr);
                    methodNmEditAndExec(
                        ZT_GaikaKokyakuTuutiTy.class,
                        pGaikaKokyakuTuutiTyn,
                        "setZtyptumitatekngkyenx",
                        methodNo, ptumitatekngkyenStr);
                    methodNmEditAndExec(
                        ZT_GaikaKokyakuTuutiTy.class,
                        pGaikaKokyakuTuutiTyn,
                        "setZtysisuux",
                        methodNo, sisuuStr);
                    methodNmEditAndExec(
                        ZT_GaikaKokyakuTuutiTy.class,
                        pGaikaKokyakuTuutiTyn,
                        "setZtysisuuuprituhugoux",
                        methodNo, sisuuuprituhugouStr);
                    methodNmEditAndExec(
                        ZT_GaikaKokyakuTuutiTy.class,
                        pGaikaKokyakuTuutiTyn,
                        "setZtysisuuupritux",
                        methodNo, sisuuuprituStr);
                    methodNmEditAndExec(
                        ZT_GaikaKokyakuTuutiTy.class,
                        pGaikaKokyakuTuutiTyn,
                        "setZtytmttknzoukaritustrx",
                        methodNo, tmttknzoukarituStr);
                    methodNmEditAndExec(
                        ZT_GaikaKokyakuTuutiTy.class,
                        pGaikaKokyakuTuutiTyn,
                        "setZtykawaseratex",
                        methodNo,
                        kawaserateStr);
                } catch (IllegalAccessException
                    | NoSuchMethodException
                    | InvocationTargetException e) {
                    throw new CommonBizAppException();
                }

                methodNo++;
            }
        }
        else if (EditKykNaiyouOsirase.SYOUHNHANMEIKBN_NENKIN_SISUU3MONTHMAE.equals(pSyouhnHanmeiKbn)) {

            String tmttknsuiirirekikbnStr1 = BLANK;
            String keiyakuoutoubiStr1 = BLANK;
            String tmttknjyoutaiStr1 = BLANK;
            String ptumitatekngkktuukaStr1 = BLANK;
            String ptumitatekngkyenStr1 = BLANK;
            String sisuuStr1 = BLANK;
            String sisuuuprituhugouStr1 = BLANK;
            String sisuuuprituStr1 = BLANK;
            String tmttknzoukarituStr1 = BLANK;
            String kawaserateStr1 = BLANK;

            String tmttknsuiirirekikbnStr2 = BLANK;
            String keiyakuoutoubiStr2 = BLANK;
            String tmttknjyoutaiStr2 = BLANK;
            String ptumitatekngkktuukaStr2 = BLANK;
            String ptumitatekngkyenStr2 = BLANK;
            String sisuuStr2 = BLANK;
            String sisuuuprituhugouStr2 = BLANK;
            String sisuuuprituStr2 = BLANK;
            String tmttknzoukarituStr2 = BLANK;
            String kawaserateStr2 = BLANK;

            String tmttknsuiirirekikbnStr3 = BLANK;
            String keiyakuoutoubiStr3 = BLANK;
            String tmttknjyoutaiStr3 = BLANK;
            String ptumitatekngkktuukaStr3 = BLANK;
            String ptumitatekngkyenStr3 = BLANK;
            String sisuuStr3 = BLANK;
            String sisuuuprituhugouStr3 = BLANK;
            String sisuuuprituStr3 = BLANK;
            String tmttknzoukarituStr3 = BLANK;
            String kawaserateStr3 = BLANK;

            IT_KhSisuurendoTmttkn khSisuurendoTmttknFirstTmp = khSisuurendoTmttknList.get(0);

            BizDateYM tmttkntaisyouymFirst = khSisuurendoTmttknFirstTmp.getTmttkntaisyouym();

            List<IT_KhSisuurendoTmttkn> khSisuurendoTmttknList2 =
                editKykNaiyouOsiraseDao.getKhSisuurendoTmttkns2(syono, tmttkntaisyouymFirst);
            IT_KhSisuurendoTmttkn khSisuurendoTmttknFirst = khSisuurendoTmttknList2.get(0);

            tmttknsuiirirekikbnStr1 = TMTTKNSUIIRIREKIKBN_KYK;
            keiyakuoutoubiStr1 =
                format.format(BizDate.valueOf(khSisuurendoTmttknFirst.getTmttkntaisyouym(), kykymd.getDay()).getRekijyou());
            tmttknjyoutaiStr1 = TMTTKNJYOUTAI_SISUU;
            ptumitatekngkktuukaStr1 =
                khSisuurendoTmttknFirst.getSisuurendoutmttkngk().multiply(JYOUSUU_HYAKU).toString();

            getKawaseRate.exec(
                khSisuurendoTmttknFirst.getTmttknkouryokukaisiymd(),
                C_KawaserateSyuruiKbn.KOUJIKAWASERATE,
                kykSyouhn.getKyktuukasyu(),
                C_Tuukasyu.JPY,
                C_KawasetekiyoKbn.TTM,
                C_KawasetsryKbn.SYUKKINRATE,
                C_EigyoubiHoseiKbn.YOKUEIGYOUBI,
                C_YouhiKbn.HUYOU);

            BizNumber kawaserate1 = getKawaseRate.getKawaserate();
            kawaserateStr1 = kawaserate1.multiply(JYOUSUU_HYAKU).toString();

            ptumitatekngkyenStr1 = keisanGaikakanzan.exec(
                C_Tuukasyu.JPY,
                khSisuurendoTmttknFirst.getSisuurendoutmttkngk(),
                kawaserate1,
                C_HasuusyoriKbn.AGE).toString();

            sisuuStr1 = khSisuurendoTmttknFirst.getTmttknhaneisisuu().round(2, RoundingMode.DOWN).multiply(JYOUSUU_HYAKU).toString();

            pGaikaKokyakuTuutiTyn.setZtytmttknsuiirirekikbnx1(tmttknsuiirirekikbnStr1);
            pGaikaKokyakuTuutiTyn.setZtykeiyakuoutoubix1(keiyakuoutoubiStr1);
            pGaikaKokyakuTuutiTyn.setZtytmttknjyoutaix1(tmttknjyoutaiStr1);
            pGaikaKokyakuTuutiTyn.setZtyptumitatekngkktuukax1(ptumitatekngkktuukaStr1);
            pGaikaKokyakuTuutiTyn.setZtyptumitatekngkyenx1(ptumitatekngkyenStr1);
            pGaikaKokyakuTuutiTyn.setZtysisuux1(sisuuStr1);
            pGaikaKokyakuTuutiTyn.setZtysisuuuprituhugoux1(sisuuuprituhugouStr1);
            pGaikaKokyakuTuutiTyn.setZtysisuuupritux1(sisuuuprituStr1);
            pGaikaKokyakuTuutiTyn.setZtytmttknzoukaritustrx1(tmttknzoukarituStr1);
            pGaikaKokyakuTuutiTyn.setZtykawaseratex1(kawaserateStr1);

            int sisuu3MonthSize = khSisuurendoTmttknList.size();

            if (sisuu3MonthSize > 1) {

                IT_KhSisuurendoTmttkn khSisuurendoTmttknLastTmp = khSisuurendoTmttknList.get(sisuu3MonthSize - 1);

                BizDateYM tmttkntaisyouymLast = khSisuurendoTmttknLastTmp.getTmttkntaisyouym();

                khSisuurendoTmttknList2 =
                    editKykNaiyouOsiraseDao.getKhSisuurendoTmttkns2(syono, tmttkntaisyouymLast);

                int sisuu3MonthSize2 = khSisuurendoTmttknList2.size();

                IT_KhSisuurendoTmttkn khSisuurendoTmttknLast2 = null;
                IT_KhSisuurendoTmttkn khSisuurendoTmttknLast3 = null;

                if (sisuu3MonthSize2 > 1) {
                    khSisuurendoTmttknLast2 = khSisuurendoTmttknList2.get(0);
                    khSisuurendoTmttknLast3 = khSisuurendoTmttknList2.get(sisuu3MonthSize2 - 1);
                }
                else {
                    khSisuurendoTmttknLast2 = khSisuurendoTmttknList2.get(0);
                    khSisuurendoTmttknLast3 = khSisuurendoTmttknList2.get(0);
                }

                tmttknsuiirirekikbnStr2 = TMTTKNSUIIRIREKIKBN_TYKZEN;
                keiyakuoutoubiStr2 =
                    format.format(
                        BizDate.valueOf(khSisuurendoTmttknLast2.getTmttkntaisyouym(),
                            kykymd.getDay()).getRekijyou());
                tmttknjyoutaiStr2 = TMTTKNJYOUTAI_SISUU;
                ptumitatekngkktuukaStr2 =
                    khSisuurendoTmttknLast2.getSisuurendoutmttkngk().multiply(JYOUSUU_HYAKU).toString();
                getKawaseRate.exec(
                    khSisuurendoTmttknLast2.getTmttknkouryokukaisiymd(),
                    C_KawaserateSyuruiKbn.KOUJIKAWASERATE,
                    kykSyouhn.getKyktuukasyu(),
                    C_Tuukasyu.JPY,
                    C_KawasetekiyoKbn.TTM,
                    C_KawasetsryKbn.SYUKKINRATE,
                    C_EigyoubiHoseiKbn.YOKUEIGYOUBI,
                    C_YouhiKbn.HUYOU);
                BizNumber kawaserate2 = getKawaseRate.getKawaserate();
                kawaserateStr2 = kawaserate2.multiply(JYOUSUU_HYAKU).toString();

                ptumitatekngkyenStr2 = keisanGaikakanzan.exec(
                    C_Tuukasyu.JPY,
                    khSisuurendoTmttknLast2.getSisuurendoutmttkngk(),
                    kawaserate2,
                    C_HasuusyoriKbn.AGE).toString();

                sisuuStr2 =
                    khSisuurendoTmttknLast2
                    .getTmttknhaneisisuu().round(2, RoundingMode.DOWN).multiply(JYOUSUU_HYAKU).toString();

                BizNumber sisuuupritu2 = khSisuurendoTmttknLast2.getSisuuupritu();

                if (sisuuupritu2.compareTo(BizNumber.ZERO) < 0) {
                    sisuuuprituhugouStr2 = SISUUUPRITUHUGOU_HUSUU;
                    sisuuupritu2 = sisuuupritu2.multiply(JYOUSUU_MAN).multiply(-1);
                }
                else {
                    sisuuuprituhugouStr2 = SISUUUPRITUHUGOU_SEISUU;
                    sisuuupritu2 = sisuuupritu2.multiply(JYOUSUU_MAN);
                }

                sisuuuprituStr2 = sisuuupritu2.toString();
                tmttknzoukarituStr2 =
                    khSisuurendoTmttknLast2.getTmttknzoukaritu().multiply(JYOUSUU_MAN).toString();

                tmttknsuiirirekikbnStr3 = TMTTKNSUIIRIREKIKBN_SKSYMD;
                keiyakuoutoubiStr3 = format.format(pKykoutoubi);
                tmttknjyoutaiStr3 = TMTTKNJYOUTAI_SISUU;
                ptumitatekngkktuukaStr3 =
                    khSisuurendoTmttknLast3.getSisuurendoutmttkngk().multiply(JYOUSUU_HYAKU).toString();
                getKawaseRate.exec(
                    pKykoutoubi,
                    C_KawaserateSyuruiKbn.KOUJIKAWASERATE,
                    kykSyouhn.getKyktuukasyu(),
                    C_Tuukasyu.JPY,
                    C_KawasetekiyoKbn.TTM,
                    C_KawasetsryKbn.SYUKKINRATE,
                    C_EigyoubiHoseiKbn.YOKUEIGYOUBI,
                    C_YouhiKbn.HUYOU);
                BizNumber kawaserate3 = getKawaseRate.getKawaserate();
                kawaserateStr3 = kawaserate3.multiply(JYOUSUU_HYAKU).toString();

                ptumitatekngkyenStr3 = keisanGaikakanzan.exec(
                    C_Tuukasyu.JPY,
                    khSisuurendoTmttknLast3.getSisuurendoutmttkngk(),
                    kawaserate3,
                    C_HasuusyoriKbn.AGE).toString();

                GetSisuu getSisuu = SWAKInjector.getInstance(GetSisuu.class);
                getSisuu.exec(
                    syouhnZokusei.getSisuukbn(),
                    pKykoutoubi.addBusinessDays(-1),
                    C_YouhiKbn.HUYOU);

                sisuuStr3 = getSisuu.getSisuu().round(2, RoundingMode.DOWN).multiply(JYOUSUU_HYAKU).toString();

                pGaikaKokyakuTuutiTyn.setZtytmttknsuiirirekikbnx2(tmttknsuiirirekikbnStr2);
                pGaikaKokyakuTuutiTyn.setZtykeiyakuoutoubix2(keiyakuoutoubiStr2);
                pGaikaKokyakuTuutiTyn.setZtytmttknjyoutaix2(tmttknjyoutaiStr2);
                pGaikaKokyakuTuutiTyn.setZtyptumitatekngkktuukax2(ptumitatekngkktuukaStr2);
                pGaikaKokyakuTuutiTyn.setZtyptumitatekngkyenx2(ptumitatekngkyenStr2);
                pGaikaKokyakuTuutiTyn.setZtysisuux2(sisuuStr2);
                pGaikaKokyakuTuutiTyn.setZtysisuuuprituhugoux2(sisuuuprituhugouStr2);
                pGaikaKokyakuTuutiTyn.setZtysisuuupritux2(sisuuuprituStr2);
                pGaikaKokyakuTuutiTyn.setZtytmttknzoukaritustrx2(tmttknzoukarituStr2);
                pGaikaKokyakuTuutiTyn.setZtykawaseratex2(kawaserateStr2);

                pGaikaKokyakuTuutiTyn.setZtytmttknsuiirirekikbnx3(tmttknsuiirirekikbnStr3);
                pGaikaKokyakuTuutiTyn.setZtykeiyakuoutoubix3(keiyakuoutoubiStr3);
                pGaikaKokyakuTuutiTyn.setZtytmttknjyoutaix3(tmttknjyoutaiStr3);
                pGaikaKokyakuTuutiTyn.setZtyptumitatekngkktuukax3(ptumitatekngkktuukaStr3);
                pGaikaKokyakuTuutiTyn.setZtyptumitatekngkyenx3(ptumitatekngkyenStr3);
                pGaikaKokyakuTuutiTyn.setZtysisuux3(sisuuStr3);
                pGaikaKokyakuTuutiTyn.setZtysisuuuprituhugoux3(sisuuuprituhugouStr3);
                pGaikaKokyakuTuutiTyn.setZtysisuuupritux3(sisuuuprituStr3);
                pGaikaKokyakuTuutiTyn.setZtytmttknzoukaritustrx3(tmttknzoukarituStr3);
                pGaikaKokyakuTuutiTyn.setZtykawaseratex3(kawaserateStr3);
            }
            else {

                BizDateYM tmttkntaisyouymLast = khSisuurendoTmttknFirstTmp.getTmttkntaisyouym();

                khSisuurendoTmttknList2 =
                    editKykNaiyouOsiraseDao.getKhSisuurendoTmttkns2(syono, tmttkntaisyouymLast);

                int sisuu3MonthSize2 = khSisuurendoTmttknList2.size();

                IT_KhSisuurendoTmttkn khSisuurendoTmttknLast2 = null;

                if (sisuu3MonthSize2 > 1) {
                    khSisuurendoTmttknLast2 = khSisuurendoTmttknList2.get(sisuu3MonthSize2 - 1);
                }
                else {
                    khSisuurendoTmttknLast2 = khSisuurendoTmttknList2.get(0);
                }

                tmttknsuiirirekikbnStr2 = TMTTKNSUIIRIREKIKBN_SKSYMD;
                keiyakuoutoubiStr2 = format.format(pKykoutoubi);
                tmttknjyoutaiStr2 = TMTTKNJYOUTAI_SISUU;
                ptumitatekngkktuukaStr2 =
                    khSisuurendoTmttknLast2.getSisuurendoutmttkngk().multiply(JYOUSUU_HYAKU).toString();
                getKawaseRate.exec(
                    pKykoutoubi,
                    C_KawaserateSyuruiKbn.KOUJIKAWASERATE,
                    kykSyouhn.getKyktuukasyu(),
                    C_Tuukasyu.JPY,
                    C_KawasetekiyoKbn.TTM,
                    C_KawasetsryKbn.SYUKKINRATE,
                    C_EigyoubiHoseiKbn.YOKUEIGYOUBI,
                    C_YouhiKbn.HUYOU);
                BizNumber kawaserate2 = getKawaseRate.getKawaserate();
                kawaserateStr2 = kawaserate2.multiply(JYOUSUU_HYAKU).toString();

                ptumitatekngkyenStr2 = keisanGaikakanzan.exec(
                    C_Tuukasyu.JPY,
                    khSisuurendoTmttknLast2.getSisuurendoutmttkngk(),
                    kawaserate2,
                    C_HasuusyoriKbn.AGE).toString();

                GetSisuu getSisuu = SWAKInjector.getInstance(GetSisuu.class);
                getSisuu.exec(
                    syouhnZokusei.getSisuukbn(),
                    pKykoutoubi.addBusinessDays(-1),
                    C_YouhiKbn.HUYOU);

                sisuuStr2 = getSisuu.getSisuu().round(2, RoundingMode.DOWN).multiply(JYOUSUU_HYAKU).toString();

                pGaikaKokyakuTuutiTyn.setZtytmttknsuiirirekikbnx2(tmttknsuiirirekikbnStr2);
                pGaikaKokyakuTuutiTyn.setZtykeiyakuoutoubix2(keiyakuoutoubiStr2);
                pGaikaKokyakuTuutiTyn.setZtytmttknjyoutaix2(tmttknjyoutaiStr2);
                pGaikaKokyakuTuutiTyn.setZtyptumitatekngkktuukax2(ptumitatekngkktuukaStr2);
                pGaikaKokyakuTuutiTyn.setZtyptumitatekngkyenx2(ptumitatekngkyenStr2);
                pGaikaKokyakuTuutiTyn.setZtysisuux2(sisuuStr2);
                pGaikaKokyakuTuutiTyn.setZtysisuuuprituhugoux2(sisuuuprituhugouStr2);
                pGaikaKokyakuTuutiTyn.setZtysisuuupritux2(sisuuuprituStr2);
                pGaikaKokyakuTuutiTyn.setZtytmttknzoukaritustrx2(tmttknzoukarituStr2);
                pGaikaKokyakuTuutiTyn.setZtykawaseratex2(kawaserateStr2);
            }
        }

        return pGaikaKokyakuTuutiTyn;
    }

    private void methodNmEditAndExec (
        Class<ZT_GaikaKokyakuTuutiTy> pClass,
        ZT_GaikaKokyakuTuutiTy pGaikaKokyakuTuutiTy,
        String pMethodNm,
        int pMethodNo,
        Object pValue) throws
        IllegalAccessException,
        NoSuchMethodException,
        InvocationTargetException {

        Method setMethod =
            pClass.getMethod(pMethodNm +
                String.valueOf(pMethodNo), pValue.getClass());
        setMethod.invoke(pGaikaKokyakuTuutiTy, pValue);
    }

    private BizCurrency getNkGnsGk(
        String pSyono,
        BizDate pCalcKijyunYmd,
        String pSyouhnHanmeiKbn,
        IT_KykSyouhn pKykSyouhn,
        IT_KykSonotaTkyk pKykSonotaTkyk) {

        SisurendoTmttknInfoBean sisurendoTmttknInfoBean =
            hozenDomManager.getSisurendoTmttknInfoBean(pSyono, pCalcKijyunYmd);
        C_Tuukasyu kyktuukasyu = pKykSyouhn.getKyktuukasyu();
        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
        CurrencyType tuukaType = henkanTuuka.henkanTuukaKbnToType(kyktuukasyu);
        BizDateYM hknkknmanryouYm = pKykSyouhn.getHknkknmanryouymd().getBizDateYM();
        BizDateYM tmttknTaisyouYm;
        BizCurrency teirituTmttKngk;
        BizCurrency sisuuRendouTmttKngk;

        if (EditKykNaiyouOsirase.SYOUHNHANMEIKBN_NENKIN_SISUU3MONTHMAE.equals(pSyouhnHanmeiKbn)) {
            tmttknTaisyouYm = sisurendoTmttknInfoBean.getTmttknTaisyouYM().getNextYear();
            teirituTmttKngk = sisurendoTmttknInfoBean.getSisuuRendouTmttknGK();
            sisuuRendouTmttKngk = BizCurrency.valueOf(0, tuukaType);
        }
        else {
            tmttknTaisyouYm = sisurendoTmttknInfoBean.getTmttknTaisyouYM();
            teirituTmttKngk = sisurendoTmttknInfoBean.getTeirituTmttknGK();
            sisuuRendouTmttKngk = sisurendoTmttknInfoBean.getSisuuRendouTmttknGK();
        }

        if (BizDateUtil.compareYm(
            hknkknmanryouYm,
            tmttknTaisyouYm) == BizDateUtil.COMPARE_LESSER) {
            throw new CommonBizAppException("指数連動年金積立金計算が実行できませんでした。");
        }

        int keikamonTukikansan = BizDateUtil.calcDifferenceMonths(hknkknmanryouYm, tmttknTaisyouYm);
        int keikayear = keikamonTukikansan / 12;

        BizDateYM calcStartYm = tmttknTaisyouYm;

        BizDateYM calcKijyunYm = tmttknTaisyouYm;

        KeisanSisuuRendouNkTmttkn keisanSisuuRendouNkTmttkn =
            SWAKInjector.getInstance(KeisanSisuuRendouNkTmttkn.class);

        while(keikayear > 0){
            calcKijyunYm = calcStartYm.getNextYear();

            if(C_ErrorKbn.ERROR.eq(
                keisanSisuuRendouNkTmttkn.exec(
                    pKykSyouhn.getKykymd(),
                    pKykSyouhn.getHknkkn(),
                    pKykSonotaTkyk.getTeikishrtkykhukaumu(),
                    kyktuukasyu,
                    pCalcKijyunYmd,
                    calcKijyunYm,
                    calcStartYm,
                    pKykSyouhn.getTumitateriritu(),
                    teirituTmttKngk,
                    sisuuRendouTmttKngk))){

                throw new CommonBizAppException("指数連動年金積立金計算が実行できませんでした。");
            }

            teirituTmttKngk = keisanSisuuRendouNkTmttkn.getTeiritutmttkngk();
            calcStartYm = calcStartYm.getNextYear();
            keikayear = keikayear - 1 ;
        }
        return teirituTmttKngk;
    }

    private int getNendo(BizDateYM pHanteiYm) {

        BizDateYM kijyunYm = BizDateYM.valueOf(pHanteiYm.getYear(), 4);

        int nendo;

        if (BizDateUtil.compareYm(pHanteiYm, kijyunYm) == BizDateUtil.COMPARE_LESSER) {
            nendo = pHanteiYm.getPreviousYear().getYear();
        }
        else {
            nendo = pHanteiYm.getYear();
        }

        return nendo;
    }
}
