package yuyu.common.hozen.khcommon;

import java.math.RoundingMode;
import java.util.List;

import jp.co.slcs.swak.core.configuration.CoreConfig;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import yuyu.common.base.format.FixedDateFormatter;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.GetKawaseRate;
import yuyu.common.biz.bzcommon.HanteiHokenKikan;
import yuyu.common.biz.bzcommon.HanteiHokenKikanBean;
import yuyu.common.biz.bzcommon.KeisanGaikakanzan;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.siharai.sicommon.CalcHkShrKngk;
import yuyu.common.siharai.sicommon.CalcHkShrKngkBean;
import yuyu.def.classification.C_EigyoubiHoseiKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.classification.C_HknKknKbn;
import yuyu.def.classification.C_HokenkinsyuruiKbn;
import yuyu.def.classification.C_KawaserateSyuruiKbn;
import yuyu.def.classification.C_KawasetekiyoKbn;
import yuyu.def.classification.C_KawasetsryKbn;
import yuyu.def.classification.C_SiinKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TargetTkKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_NyknJissekiRireki;
import yuyu.def.db.entity.ZT_GaikaKokyakuTuutiTy;

import com.google.common.collect.Lists;

/**
 * 契約保全 契約保全共通 契約内容のお知らせ編集１（終身外貨）
 */
public class EditKykNaiyouOsirase1 {

    private static final String IKOU_SYSN = "以降（終身）";

    private static final String AISATUMSGCD_03004 = "03004";

    private static final String HOSYOUH_HSKMSGCD1 = "05001";

    private static final String HOSYOUH_HSKMSGCD2 = "05002";

    private static final String HOSYOUH_HSKMSGCD3 = "05003";

    private static final String HOSYOUH_HSKMSGCD4 = "05004";

    private static final String HOSYOUH_HSKMSGCD5 = "05005";

    private static final String HOSYOUH_HSKMSGCD6 = "05007";

    private static final String KWSRATE_MSGCD = "06001";

    private static final String OSIRASEMSGCD_08012 = "08012";

    private static final String HRKGKHYOUJIKBN_HIHYOUJI = "0";

    private static final String HRKGKHYOUJIKBN_YEN = "1";

    private static final String HRKGKHYOUJIKBN_STIGI = "2";

    private static final String KNGKHYOUJIKBN_HIHYOUJI = "0";

    private static final String KNGKHYOUJIKBN_MSG = "1";

    private static final String KNGKHYOUJIKBN_KG = "2";

    private static final String MKHGKHYOUJIKBN_TKNASI = "0";

    private static final String MKHGKHYOUJIKBN_TKARI_ZEROIGAI = "1";

    private static final String MKHGKHYOUJIKBN_TKARI_ZERO = "2";

    private static final String BLANK = "";

    private static final String ERROR_MSG = "金額チェックエラーです。システム管理者にお問い合わせください。";

    private C_ErrorKbn commonErrorKbn = C_ErrorKbn.OK;

    public EditKykNaiyouOsirase1() {
        super();
    }

    C_ErrorKbn getCommonErrorKbn() {
        return commonErrorKbn;
    }

    public ZT_GaikaKokyakuTuutiTy editInfo(
        IT_KykKihon pKykKihon,
        BizDate pSyoriYmd,
        BizDate pKykoutoubi,
        KawaseRateBean pKawaseRateBean,
        ZT_GaikaKokyakuTuutiTy pGaikaKokyakuTuutiTyn) {
        String dai1hknkkn0edit = BLANK;
        BizCurrency yenHrkgk = BizCurrency.optional(BizCurrencyTypes.YEN);
        String stigiTuukaHrkGk = BLANK;
        String hrktuukasyu = BLANK;
        String hrktuukatype = BLANK;
        String stitukaKawaserate = BLANK;
        String yenkHrikmrateMarumeAri = BLANK;
        String kjnKngkKawaserateMarumeAri = BLANK;
        String hrkgkHyoujikbn = BLANK;
        BizCurrency kjnKngk = BizCurrency.optional(BizCurrencyTypes.YEN);
        String kjnKngkHyoujikbn = BLANK;
        String mkhGk = BLANK;
        String mkhGkwari = BLANK;
        String mkhGkHyoujikbn = BLANK;
        String hosyouHskMsgcd1 = BLANK;
        String hosyouHskMsgcd2 = BLANK;
        String hosyouHskMsgcd5 = BLANK;
        String hosyouHskMsgcd6 = BLANK;
        List<String> upsideHosyouhskmsgcdLst = Lists.newArrayList();
        List<String> downsideHosyouhskmsgcdLst = Lists.newArrayList();

        IT_KykSyouhn kykSyouhn = pKykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU).get(0);
        IT_KykSonotaTkyk kykSonotaTkyk = pKykKihon.getKykSonotaTkyk();
        BM_SyouhnZokusei syouhnZokusei = kykSyouhn.getSyouhnZokusei();

        String syono = pKykKihon.getSyono();
        BizDate kykymd = kykSyouhn.getKykymd();
        Integer dai1hknkkn = kykSyouhn.getDai1hknkkn();

        String osiraseTuutiSakuseiYm = pKykoutoubi.getBizDateYM().toString();

        HanteiHokenKikan hanteiHokenKikan = SWAKInjector.getInstance(HanteiHokenKikan.class);
        HanteiHokenKikanBean hanteiHokenKikanBean = SWAKInjector.getInstance(HanteiHokenKikanBean.class);

        hanteiHokenKikanBean.setKykYmd(kykymd);
        hanteiHokenKikanBean.setCalcKijyunYmd(pSyoriYmd);
        hanteiHokenKikanBean.setSyouhnZokusei(syouhnZokusei);
        hanteiHokenKikanBean.setDai1hknkkn(dai1hknkkn);

        hanteiHokenKikan.exec(hanteiHokenKikanBean);

        String dai1hknkknTo = hanteiHokenKikan.getDai2HknkknStartYmd().getPreviousDay().toString();
        String dai2hknkknFrom = hanteiHokenKikan.getDai2HknkknStartYmd().toString();
        String dai2hknkknTo = hanteiHokenKikan.getDai3HknkknStartYmd().getPreviousDay().toString();
        String dai3hknkknFrom = hanteiHokenKikan.getDai3HknkknStartYmd().toString();

        List<IT_NyknJissekiRireki> nyknJissekiRirekiLst = pKykKihon.getNyknJissekiRirekis();

        hrktuukasyu = nyknJissekiRirekiLst.get(0).getRstuukasyu().getContent();
        hrktuukatype = nyknJissekiRirekiLst.get(0).getRstuukasyu().getValue();

        if (C_UmuKbn.ARI.eq(kykSonotaTkyk.getYennykntkhkumu())) {
            yenHrkgk = nyknJissekiRirekiLst.get(0).getRsgaku();
            hrkgkHyoujikbn = HRKGKHYOUJIKBN_YEN;
        }
        else if (C_UmuKbn.ARI.eq(kykSonotaTkyk.getGaikanykntkhkumu())) {
            stigiTuukaHrkGk = nyknJissekiRirekiLst.get(0).getRsgaku().multiply(100).toString();
            hrkgkHyoujikbn = HRKGKHYOUJIKBN_STIGI;
        }
        else {
            hrkgkHyoujikbn = HRKGKHYOUJIKBN_HIHYOUJI;
        }

        if (C_UmuKbn.ARI.eq(kykSonotaTkyk.getInitsbjiyensitihsytkhukaumu())) {
            kjnKngk = kykSonotaTkyk.getInitsbjiyenkasaiteihsygk();

        }
        else if (C_UmuKbn.ARI.eq(kykSonotaTkyk.getTargettkhkumu())) {
            kjnKngk = kykSonotaTkyk.getTargettkykkijyungk();
        }

        if (C_UmuKbn.ARI.eq(kykSonotaTkyk.getInitsbjiyensitihsytkhukaumu()) ||
            C_UmuKbn.ARI.eq(kykSonotaTkyk.getTargettkhkumu())) {

            if (C_UmuKbn.ARI.eq(kykSonotaTkyk.getYennykntkhkumu()) && kjnKngk.compareTo(yenHrkgk) == 0) {
                kjnKngkHyoujikbn = KNGKHYOUJIKBN_MSG;
            }
            else {
                kjnKngkHyoujikbn = KNGKHYOUJIKBN_KG;
            }
        }
        else {
            kjnKngkHyoujikbn = KNGKHYOUJIKBN_HIHYOUJI;
        }

        CalcHkShrKngk calcHkShrKngk = SWAKInjector.getInstance(CalcHkShrKngk.class);
        C_ErrorKbn errorKbn = calcHkShrKngk.execByKeisanWExt(
            syono,
            pKykoutoubi,
            C_SiinKbn.SP,
            C_HokenkinsyuruiKbn.SBHOKENKIN,
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

        BizCurrency sbhknkngkKyktuuka = calcHkShrKngkBean.getSibousGk().multiply(100);
        BizCurrency saigaisbhknkngakuKtuuka = calcHkShrKngkBean.getSaigaisGk().multiply(100);
        BizCurrency kaiyakuhrkngakKyktuuka = calcHkShrKngkBean.getKaiyakuhenreiknGk().multiply(100);
        BizCurrency tmttkngkKyktuuka = calcHkShrKngkBean.getTmttKnGk().multiply(100);
        C_HknKknKbn hknkknkbn = calcHkShrKngkBean.getHknKknKbn();

        String sbhknkngkHknkknFrom = BLANK;
        String sbhknkngkHknkknTo = BLANK;

        if (C_HknKknKbn.DAI1HKNKKN.eq(hknkknkbn)) {
            sbhknkngkHknkknFrom = kykymd.toString();
            sbhknkngkHknkknTo = dai1hknkknTo;
        }
        else if (C_HknKknKbn.DAI2HKNKKN.eq(hknkknkbn)) {
            sbhknkngkHknkknFrom = dai2hknkknFrom;
            sbhknkngkHknkknTo = dai2hknkknTo;
        }
        else {
            sbhknkngkHknkknFrom = dai3hknkknFrom;
            sbhknkngkHknkknTo = IKOU_SYSN;
        }

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

        if (C_UmuKbn.ARI.eq(kykSonotaTkyk.getYennykntkhkumu())) {
            BizNumber yenkHrikmrate = getKawaseRate.getKawaserate();

            yenkHrikmrateMarumeAri = String.valueOf(yenkHrikmrate.round(2, RoundingMode.DOWN).multiply(100));
        }
        else {
            BizNumber kjnKngkKawaserate = getKawaseRate.getKawaserate();

            kjnKngkKawaserateMarumeAri = String.valueOf(kjnKngkKawaserate.round(2, RoundingMode.DOWN).multiply(100));
        }

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

            stitukaKawaserate = String.valueOf(getKawaseRate.getKawaserate().multiply(10000));

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

        KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);
        BizCurrency sbhknkngkYen = keisanGaikakanzan.exec(
            C_Tuukasyu.JPY,
            calcHkShrKngkBean.getSibousGk(),
            getKawaseRateOutoubiJiten,
            C_HasuusyoriKbn.AGE);

        BizCurrency saigaisbhknkngakukYen = keisanGaikakanzan.exec(
            C_Tuukasyu.JPY,
            calcHkShrKngkBean.getSaigaisGk(),
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

        String saigaisbhknkngakuUmu = BLANK;
        String sbhknkngakHyjKbn = BLANK;
        if (C_HknKknKbn.DAI1HKNKKN.eq(hknkknkbn)) {
            if (C_UmuKbn.ARI.eq(kykSonotaTkyk.getInitsbjiyensitihsytkhukaumu())) {

                if (saigaisbhknkngakukYen.compareTo(kjnKngk) <= 0) {
                    saigaisbhknkngakuUmu = KNGKHYOUJIKBN_MSG;

                }
                else {
                    saigaisbhknkngakuUmu = KNGKHYOUJIKBN_KG;
                }

                if (sbhknkngkYen.compareTo(kjnKngk) <= 0) {
                    sbhknkngakHyjKbn = KNGKHYOUJIKBN_MSG;
                }
                else {
                    sbhknkngakHyjKbn = KNGKHYOUJIKBN_KG;
                }

            }
            else {
                saigaisbhknkngakuUmu = KNGKHYOUJIKBN_KG;
                sbhknkngakHyjKbn = KNGKHYOUJIKBN_KG;
            }
        }
        else {
            saigaisbhknkngakuUmu = KNGKHYOUJIKBN_HIHYOUJI;
            sbhknkngakHyjKbn = KNGKHYOUJIKBN_KG;
        }

        if (C_UmuKbn.ARI.eq(kykSonotaTkyk.getTargettkhkumu()) &&
            C_TargetTkKbn.SYUUSIN.eq(kykSonotaTkyk.getTargettkkbn())) {
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

        if (C_UmuKbn.ARI.eq(kykSonotaTkyk.getYennykntkhkumu()) ||
            C_UmuKbn.ARI.eq(kykSonotaTkyk.getGaikanykntkhkumu())) {
            upsideHosyouhskmsgcdLst.add(HOSYOUH_HSKMSGCD1);
        }

        if (C_UmuKbn.ARI.eq(kykSonotaTkyk.getInitsbjiyensitihsytkhukaumu()) ||
            C_UmuKbn.ARI.eq(kykSonotaTkyk.getTargettkhkumu())) {
            if (C_UmuKbn.ARI.eq(kykSonotaTkyk.getYennykntkhkumu()) ||
                C_UmuKbn.ARI.eq(kykSonotaTkyk.getGaikanykntkhkumu())) {
                upsideHosyouhskmsgcdLst.add(HOSYOUH_HSKMSGCD3);
            }
            else {
                upsideHosyouhskmsgcdLst.add(HOSYOUH_HSKMSGCD2);
            }
        }

        while (upsideHosyouhskmsgcdLst.size() < 2) {
            upsideHosyouhskmsgcdLst.add(BLANK);
        }

        hosyouHskMsgcd1 = upsideHosyouhskmsgcdLst.get(0);
        hosyouHskMsgcd2 = upsideHosyouhskmsgcdLst.get(1);

        if (C_HknKknKbn.DAI1HKNKKN.eq(hknkknkbn)) {
            downsideHosyouhskmsgcdLst.add(HOSYOUH_HSKMSGCD5);
        }

        downsideHosyouhskmsgcdLst.add(HOSYOUH_HSKMSGCD6);

        while (downsideHosyouhskmsgcdLst.size() < 2) {
            downsideHosyouhskmsgcdLst.add(BLANK);
        }

        hosyouHskMsgcd5 = downsideHosyouhskmsgcdLst.get(0);
        hosyouHskMsgcd6 = downsideHosyouhskmsgcdLst.get(1);

        dai1hknkkn0edit = BizUtil.zeroNum(String.valueOf(dai1hknkkn), 2, 0);

        pGaikaKokyakuTuutiTyn.setZtysyoruicd(C_SyoruiCdKbn.KK_GAIKA_KOKYAKUTUUTI.getValue().toUpperCase());
        pGaikaKokyakuTuutiTyn.setZtyaisatumsgcd1(AISATUMSGCD_03004);
        pGaikaKokyakuTuutiTyn.setZtyosirasetuutisakuseiymwa(
            FixedDateFormatter.formatYMZenkakuSeirekiKanji(BizDate.valueOf(osiraseTuutiSakuseiYm + "01")));
        pGaikaKokyakuTuutiTyn.setZtydai1hknkknfromwa(
            FixedDateFormatter.formatYMDZenkakuSeirekiKanji(BizDate.valueOf(dai1hknkknTo)));
        pGaikaKokyakuTuutiTyn.setZtydai1hknkkn(dai1hknkkn0edit);
        pGaikaKokyakuTuutiTyn.setZtydai2hknkknfromwa(
            FixedDateFormatter.formatYMDZenkakuSeirekiKanji(BizDate.valueOf(dai2hknkknFrom)));
        pGaikaKokyakuTuutiTyn.setZtydai2hknkkntowa(
            FixedDateFormatter.formatYMDZenkakuSeirekiKanji(BizDate.valueOf(dai2hknkknTo)));
        pGaikaKokyakuTuutiTyn.setZtydai3hknkknfromwa(
            FixedDateFormatter.formatYMDZenkakuSeirekiKanji(BizDate.valueOf(dai3hknkknFrom)));
        pGaikaKokyakuTuutiTyn.setZtydai3hknkknto(IKOU_SYSN);
        pGaikaKokyakuTuutiTyn.setZtyitijibrpkyktuuka(String.valueOf(nyknJissekiRirekiLst.get(0).getHrkp()
            .multiply(100)));
        pGaikaKokyakuTuutiTyn.setZtykihonsktuuka(String.valueOf(kykSyouhn.getKihons().multiply(100)));
        pGaikaKokyakuTuutiTyn.setZtyyenhrkgk(yenHrkgk.toString());
        pGaikaKokyakuTuutiTyn.setZtystigituukahrkgk(stigiTuukaHrkGk);
        pGaikaKokyakuTuutiTyn.setZtyhrktuukasyuzn(hrktuukasyu);
        pGaikaKokyakuTuutiTyn.setZtyhrktuukatype(hrktuukatype);
        pGaikaKokyakuTuutiTyn.setZtyyenkhrikmrate(yenkHrikmrateMarumeAri);
        pGaikaKokyakuTuutiTyn.setZtystigikwsrate(stitukaKawaserate);
        pGaikaKokyakuTuutiTyn.setZtyhrkgkhyoujikbn(hrkgkHyoujikbn);
        pGaikaKokyakuTuutiTyn.setZtykijyunkingaku(kjnKngk.toString());
        pGaikaKokyakuTuutiTyn.setZtykjnkngkkawaserate(kjnKngkKawaserateMarumeAri);
        pGaikaKokyakuTuutiTyn.setZtykjnkngkhyoujikbn(kjnKngkHyoujikbn);
        pGaikaKokyakuTuutiTyn.setZtysakuseikijyunymdkwsrate(
            String.valueOf(getKawaseRateOutoubiJiten.multiply(100)));
        pGaikaKokyakuTuutiTyn.setZtysbhknkngkhknkkn(hknkknkbn.getValue());
        pGaikaKokyakuTuutiTyn.setZtysbhknkngkhknkknfromwa(
            FixedDateFormatter.formatYMDZenkakuSeirekiKanji(BizDate.valueOf(sbhknkngkHknkknFrom)));
        if (C_HknKknKbn.DAI3HKNKKN.eq(hknkknkbn)) {
            pGaikaKokyakuTuutiTyn.setZtysbhknkngkhknkkntowa(sbhknkngkHknkknTo);
        }
        else {
            pGaikaKokyakuTuutiTyn.setZtysbhknkngkhknkkntowa(
                FixedDateFormatter.formatYMDZenkakuSeirekiKanji(BizDate.valueOf(sbhknkngkHknkknTo)));
        }
        pGaikaKokyakuTuutiTyn.setZtysbhknkngkhyoujikbn(sbhknkngakHyjKbn);
        pGaikaKokyakuTuutiTyn.setZtysbhknkngkkyktuuka(sbhknkngkKyktuuka.toString());
        pGaikaKokyakuTuutiTyn.setZtysbhknkngkyen(sbhknkngkYen.toString());
        pGaikaKokyakuTuutiTyn.setZtysaigaisbhknkngakuumu(saigaisbhknkngakuUmu);
        pGaikaKokyakuTuutiTyn.setZtysaigaisbhknkngakuktuuka(saigaisbhknkngakuKtuuka.toString());
        pGaikaKokyakuTuutiTyn.setZtysaigaisbhknkngakukyen(saigaisbhknkngakukYen.toString());
        pGaikaKokyakuTuutiTyn.setZtytumitatekngkktuuka(tmttkngkKyktuuka.toString());
        pGaikaKokyakuTuutiTyn.setZtytumitatekngkkyen(tmttkngkkukYen.toString());
        pGaikaKokyakuTuutiTyn.setZtykaiyakuhrkngakkyktuuka(kaiyakuhrkngakKyktuuka.toString());
        pGaikaKokyakuTuutiTyn.setZtykaiyakuhrkngakyen(kaiyakuhrkngakYen.toString());
        pGaikaKokyakuTuutiTyn.setZtymkhgkyen(mkhGk);
        pGaikaKokyakuTuutiTyn.setZtymkhgkwari(mkhGkwari);
        pGaikaKokyakuTuutiTyn.setZtymkhgkhyoujikbn(mkhGkHyoujikbn);
        pGaikaKokyakuTuutiTyn.setZtyhosyouhskmsgcd1(hosyouHskMsgcd1);
        pGaikaKokyakuTuutiTyn.setZtyhosyouhskmsgcd2(hosyouHskMsgcd2);
        pGaikaKokyakuTuutiTyn.setZtyhosyouhskmsgcd3(BLANK);
        pGaikaKokyakuTuutiTyn.setZtyhosyouhskmsgcd4(HOSYOUH_HSKMSGCD4);
        pGaikaKokyakuTuutiTyn.setZtyhosyouhskmsgcd5(hosyouHskMsgcd5);
        pGaikaKokyakuTuutiTyn.setZtyhosyouhskmsgcd6(hosyouHskMsgcd6);
        if (C_HknKknKbn.DAI1HKNKKN.eq(hknkknkbn)) {
            pGaikaKokyakuTuutiTyn.setZtyosirasemsgcd1(OSIRASEMSGCD_08012);

        }

        if (pKawaseRateBean != null) {

            BizNumber kwsrateUsdjpy1mae = null;
            BizDate kwsrateKijyunymd1mae = null;
            BizNumber kwsrateAudjpy1mae = null;

            BizNumber kwsrateUsdjpy2mae = null;
            BizDate kwsrateKijyunymd2mae = null;
            BizNumber kwsrateAudjpy2mae = null;

            BizNumber kwsrateUsdjpy3mae = null;
            BizDate kwsrateKijyunymd3mae = null;
            BizNumber kwsrateAudjpy3mae = null;

            BizNumber kwsrateUsdjpy4mae = null;
            BizDate kwsrateKijyunymd4mae = null;
            BizNumber kwsrateAudjpy4mae = null;

            BizNumber kwsrateUsdjpy5mae = null;
            BizDate kwsrateKijyunymd5mae = null;
            BizNumber kwsrateAudjpy5mae = null;

            BizNumber kwsrateUsdjpy6mae = null;
            BizDate kwsrateKijyunymd6mae = null;
            BizNumber kwsrateAudjpy6mae = null;

            if (BizDateUtil.compareYm(pKykoutoubi.getBizDateYM(), pSyoriYmd.getBizDateYM()) == BizDateUtil.COMPARE_EQUAL) {
                kwsrateKijyunymd1mae = pKawaseRateBean.getKwsrateKijyunymd1mae();
                kwsrateUsdjpy1mae = pKawaseRateBean.getKwsrateUsdjpy1mae();
                kwsrateAudjpy1mae = pKawaseRateBean.getKwsrateAudjpy1mae();

                kwsrateKijyunymd2mae = pKawaseRateBean.getKwsrateKijyunymd2mae();
                kwsrateUsdjpy2mae = pKawaseRateBean.getKwsrateUsdjpy2mae();
                kwsrateAudjpy2mae = pKawaseRateBean.getKwsrateAudjpy2mae();

                kwsrateKijyunymd3mae = pKawaseRateBean.getKwsrateKijyunymd3mae();
                kwsrateUsdjpy3mae = pKawaseRateBean.getKwsrateUsdjpy3mae();
                kwsrateAudjpy3mae = pKawaseRateBean.getKwsrateAudjpy3mae();

                kwsrateKijyunymd4mae = pKawaseRateBean.getKwsrateKijyunymd4mae();
                kwsrateUsdjpy4mae = pKawaseRateBean.getKwsrateUsdjpy4mae();
                kwsrateAudjpy4mae = pKawaseRateBean.getKwsrateAudjpy4mae();

                kwsrateKijyunymd5mae = pKawaseRateBean.getKwsrateKijyunymd5mae();
                kwsrateUsdjpy5mae = pKawaseRateBean.getKwsrateUsdjpy5mae();
                kwsrateAudjpy5mae = pKawaseRateBean.getKwsrateAudjpy5mae();

                kwsrateKijyunymd6mae = pKawaseRateBean.getKwsrateKijyunymd6mae();
                kwsrateUsdjpy6mae = pKawaseRateBean.getKwsrateUsdjpy6mae();
                kwsrateAudjpy6mae = pKawaseRateBean.getKwsrateAudjpy6mae();
            }
            else {
                kwsrateKijyunymd1mae = pKawaseRateBean.getKwsrateKijyunymd2mae();
                kwsrateUsdjpy1mae = pKawaseRateBean.getKwsrateUsdjpy2mae();
                kwsrateAudjpy1mae = pKawaseRateBean.getKwsrateAudjpy2mae();

                kwsrateKijyunymd2mae = pKawaseRateBean.getKwsrateKijyunymd3mae();
                kwsrateUsdjpy2mae = pKawaseRateBean.getKwsrateUsdjpy3mae();
                kwsrateAudjpy2mae = pKawaseRateBean.getKwsrateAudjpy3mae();

                kwsrateKijyunymd3mae = pKawaseRateBean.getKwsrateKijyunymd4mae();
                kwsrateUsdjpy3mae = pKawaseRateBean.getKwsrateUsdjpy4mae();
                kwsrateAudjpy3mae = pKawaseRateBean.getKwsrateAudjpy4mae();

                kwsrateKijyunymd4mae = pKawaseRateBean.getKwsrateKijyunymd5mae();
                kwsrateUsdjpy4mae = pKawaseRateBean.getKwsrateUsdjpy5mae();
                kwsrateAudjpy4mae = pKawaseRateBean.getKwsrateAudjpy5mae();

                kwsrateKijyunymd5mae = pKawaseRateBean.getKwsrateKijyunymd6mae();
                kwsrateUsdjpy5mae = pKawaseRateBean.getKwsrateUsdjpy6mae();
                kwsrateAudjpy5mae = pKawaseRateBean.getKwsrateAudjpy6mae();

                kwsrateKijyunymd6mae = pKawaseRateBean.getKwsrateKijyunymd7mae();
                kwsrateUsdjpy6mae = pKawaseRateBean.getKwsrateUsdjpy7mae();
                kwsrateAudjpy6mae = pKawaseRateBean.getKwsrateAudjpy7mae();
            }

            pGaikaKokyakuTuutiTyn.setZtykwsratekijyunymd1maewa(
                FixedDateFormatter.formatYMDZenkakuSeirekiKanji(kwsrateKijyunymd1mae));
            pGaikaKokyakuTuutiTyn.setZtykwsrateusdjpy1mae(String.valueOf(kwsrateUsdjpy1mae.multiply(100)));
            pGaikaKokyakuTuutiTyn.setZtykwsrateaudjpy1mae(String.valueOf(kwsrateAudjpy1mae.multiply(100)));
            pGaikaKokyakuTuutiTyn.setZtykwsratekijyunymd2maewa(
                FixedDateFormatter.formatYMDZenkakuSeirekiKanji(kwsrateKijyunymd2mae));
            pGaikaKokyakuTuutiTyn.setZtykwsrateusdjpy2mae(String.valueOf(kwsrateUsdjpy2mae.multiply(100)));
            pGaikaKokyakuTuutiTyn.setZtykwsrateaudjpy2mae(String.valueOf(kwsrateAudjpy2mae.multiply(100)));
            pGaikaKokyakuTuutiTyn.setZtykwsratekijyunymd3maewa(
                FixedDateFormatter.formatYMDZenkakuSeirekiKanji(kwsrateKijyunymd3mae));
            pGaikaKokyakuTuutiTyn.setZtykwsrateusdjpy3mae(String.valueOf(kwsrateUsdjpy3mae.multiply(100)));
            pGaikaKokyakuTuutiTyn.setZtykwsrateaudjpy3mae(String.valueOf(kwsrateAudjpy3mae.multiply(100)));
            pGaikaKokyakuTuutiTyn.setZtykwsratekijyunymd4maewa(
                FixedDateFormatter.formatYMDZenkakuSeirekiKanji(kwsrateKijyunymd4mae));
            pGaikaKokyakuTuutiTyn.setZtykwsrateusdjpy4mae(String.valueOf(kwsrateUsdjpy4mae.multiply(100)));
            pGaikaKokyakuTuutiTyn.setZtykwsrateaudjpy4mae(String.valueOf(kwsrateAudjpy4mae.multiply(100)));
            pGaikaKokyakuTuutiTyn.setZtykwsratekijyunymd5maewa(
                FixedDateFormatter.formatYMDZenkakuSeirekiKanji(kwsrateKijyunymd5mae));
            pGaikaKokyakuTuutiTyn.setZtykwsrateusdjpy5mae(String.valueOf(kwsrateUsdjpy5mae.multiply(100)));
            pGaikaKokyakuTuutiTyn.setZtykwsrateaudjpy5mae(String.valueOf(kwsrateAudjpy5mae.multiply(100)));
            pGaikaKokyakuTuutiTyn.setZtykwsratekijyunymd6maewa(
                FixedDateFormatter.formatYMDZenkakuSeirekiKanji(kwsrateKijyunymd6mae));
            pGaikaKokyakuTuutiTyn.setZtykwsrateusdjpy6mae(String.valueOf(kwsrateUsdjpy6mae.multiply(100)));
            pGaikaKokyakuTuutiTyn.setZtykwsrateaudjpy6mae(String.valueOf(kwsrateAudjpy6mae.multiply(100)));
            pGaikaKokyakuTuutiTyn.setZtykwsratemsgcd(KWSRATE_MSGCD);
        }



        return pGaikaKokyakuTuutiTyn;
    }

}
