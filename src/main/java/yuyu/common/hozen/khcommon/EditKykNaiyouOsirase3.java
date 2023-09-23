package yuyu.common.hozen.khcommon;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.RoundingMode;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.core.configuration.CoreConfig;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateFormat;
import jp.co.slcs.swak.date.BizDateFormat.FillStyle;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.date.CHolidayAdjustingMode;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.CurrencyType;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.util.string.ConvertUtil;
import yuyu.common.base.format.FixedDateFormatter;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.GetKawaseRate;
import yuyu.common.biz.bzcommon.GetYoteiriritu;
import yuyu.common.biz.bzcommon.GetYoteirirituBean;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.bzcommon.KeisanAzukariGanrikin;
import yuyu.common.biz.bzcommon.KeisanGaikakanzan;
import yuyu.common.biz.bzcommon.SetNenrei;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.hozen.khcommon.dba4editkyknaiyouosirase.EditKykNaiyouOsiraseDao;
import yuyu.common.siharai.sicommon.CalcHkShrKngk;
import yuyu.common.siharai.sicommon.CalcHkShrKngkBean;
import yuyu.common.sinkeiyaku.skcommon.EditNenkinKoumokuUtil;
import yuyu.def.MessageId;
import yuyu.def.classification.C_EigyoubiHoseiKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.classification.C_HokenkinsyuruiKbn;
import yuyu.def.classification.C_KawaserateSyuruiKbn;
import yuyu.def.classification.C_KawasetekiyoKbn;
import yuyu.def.classification.C_KawasetsryKbn;
import yuyu.def.classification.C_KhSisanSyuruiKbn;
import yuyu.def.classification.C_KwsrendouKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_Nenkinsyu;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_SiinKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.BM_KawaseRate;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.BM_YoteiRiritu3;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_HokenryouTmttkn;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_NyknJissekiRireki;
import yuyu.def.db.entity.IT_Zennou;
import yuyu.def.db.entity.ZT_GaikaKokyakuTuutiTy;
import yuyu.def.hozen.manager.HozenDomManager;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;

/**
 * 契約保全 契約保全共通 契約内容のお知らせ編集３（デュオ）
 */
public class EditKykNaiyouOsirase3 {

    private static final String AISATUMSGCD_03008 = "03008";

    private static final String HSKMSG_HSKMSGCD13 = "05013";

    private static final String HSKMSG_HSKMSGCD14 = "05014";

    private static final String HSKMSG_HSKMSGCD15 = "05015";

    private static final String HSKMSG_HSKMSGCD16 = "05016";

    private static final String HSKMSG_HSKMSGCD17 = "05017";

    private static final String HSKMSG_HSKMSGCD18 = "05018";

    private static final String HSKMSG_HSKMSGCD19 = "05019";

    private static final String HSKMSG_HSKMSGCD30 = "05030";

    private static final String HSKMSG_HSKMSGCD31 = "05031";

    private static final String HSKMSG_HSKMSGCD32 = "05032";

    private static final String HSKMSG_HSKMSGCD40 = "05040";

    private static final String HSKMSG_HSKMSGCD41 = "05041";

    private static final String HSKMSG_HSKMSGCD42 = "05042";

    private static final String HSKMSG_HSKMSGCD43 = "05043";

    private static final String HSKMSG_HSKMSGCD44 = "05044";

    private static final String FSTPHYOUJIKBN_HYOJI = "1";

    private static final String ZENNOU_NASI = "0";

    private static final String ZENNOU_ARI = "1";

    private static final String NEN = "年";

    private static final String BLANK = "";

    private static final int JYOUSUU_HYAKU = 100;

    private static final int JYOUSUU_MAN = 10000;

    private static final String DSKAIYKTIRASIDOUHUUKBN_NASI = "0";

    private static final String DSKAIYKTIRASIDOUHUUKBN_ARI = "1";

    public static final int MAX_INT_VALUE_TMTTKNTAISYOUYM = 219912;

    private static final String ERROR_MSG = "金額チェックエラーです。システム管理者にお問い合わせください。";

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private EditKykNaiyouOsiraseDao editKykNaiyouOsiraseDao;

    private C_ErrorKbn commonErrorKbn = C_ErrorKbn.OK;

    private C_ErrorKbn bizLogicErrorKbn = C_ErrorKbn.OK;

    private String bizLogicErrorMsg = "";

    public EditKykNaiyouOsirase3() {
        super();
    }

    C_ErrorKbn getCommonErrorKbn() {
        return commonErrorKbn;
    }

    C_ErrorKbn getBizLogicErrorKbn() {
        return bizLogicErrorKbn;
    }

    public String getBizLogicErrorMsg() {
        return bizLogicErrorMsg;
    }

    public ZT_GaikaKokyakuTuutiTy editInfo(
        IT_KykKihon pKykKihon,
        BizDate pSyoriYmd,
        BizDate pKykoutoubi,
        String pSyouhnHanmeiKbn,
        ZT_GaikaKokyakuTuutiTy pGaikaKokyakuTuutiTyn,
        int pYobidasimotoKbn) {

        IT_KykSyouhn kykSyouhn = pKykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU).get(0);
        BM_SyouhnZokusei syouhnZokusei = kykSyouhn.getSyouhnZokusei();

        String syono = pKykKihon.getSyono();
        BizDate kykymd = kykSyouhn.getKykymd();
        C_Tuukasyu kyktuukasyu = kykSyouhn.getKyktuukasyu();
        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
        CurrencyType tuukaType = henkanTuuka.henkanTuukaKbnToType(kyktuukasyu);

        SetNenrei setNenrei = SWAKInjector.getInstance(SetNenrei.class);
        int nkNenrei =
            setNenrei.exec(
                kykSyouhn.getHknkknmanryouymd(),
                kykSyouhn.getHhknseiymd());

        String nksyukbn;

        if (C_Nenkinsyu.KAKUTEINENKIN.eq(kykSyouhn.getNksyukbn())) {

            nksyukbn =
                ConvertUtil.toZenNumeric(kykSyouhn.getNenkinkkn().toString()) + NEN
                + kykSyouhn.getNksyukbn().getContent() + "（定額年金型）";
        }
        else if (C_Nenkinsyu.KAKUTEIDAI1NENKINBAIGK.eq(kykSyouhn.getNksyukbn())) {
            nksyukbn =
                ConvertUtil.toZenNumeric(kykSyouhn.getNenkinkkn().toString()) + NEN
                + kykSyouhn.getNksyukbn().getContent();
        }
        else {
            nksyukbn = kykSyouhn.getNksyukbn().getContent() + "（定額年金型）";
        }

        int sueokikkn = 0;
        EditNenkinKoumokuUtil editNenkinKoumokuUtil = SWAKInjector.getInstance(EditNenkinKoumokuUtil.class);
        C_ErrorKbn errorKbn = editNenkinKoumokuUtil.editNenkinSueokikikan(
            kykSyouhn.getHknkkn(),
            kykSyouhn.getHknkknsmnkbn(),
            kykSyouhn.getHrkkkn(),
            kykSyouhn.getHrkkknsmnkbn(),
            kykSyouhn.getHhknnen());

        if (C_ErrorKbn.OK.eq(errorKbn)) {
            sueokikkn = editNenkinKoumokuUtil.getNenkinSueokikikan();
        }

        String zennouUmu = ZENNOU_NASI;

        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon(syono);
        List<IT_Zennou> zennouList = ansyuKihon.getZennous();

        int zennouCount = zennouList.size();
        if (zennouCount > 0 && C_Kykjyoutai.ZENNOU.eq(kykSyouhn.getKykjyoutai())) {
            zennouUmu = ZENNOU_ARI;
        }

        CalcHkShrKngk calcHkShrKngk = SWAKInjector.getInstance(CalcHkShrKngk.class);
        errorKbn = calcHkShrKngk.execByKeisanWExt(
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

        C_EigyoubiHoseiKbn eigyoubiHoseiKbn;
        C_YouhiKbn youhiKbn;

        if (CoreConfig.getInstance().isBatchProduct()) {
            eigyoubiHoseiKbn = C_EigyoubiHoseiKbn.YOKUEIGYOUBI;
            youhiKbn = C_YouhiKbn.HUYOU;
        }
        else {
            eigyoubiHoseiKbn = C_EigyoubiHoseiKbn.ZENEIGYOUBI;
            youhiKbn = C_YouhiKbn.YOU;
        }

        GetKawaseRate getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);
        getKawaseRate.exec(
            pKykoutoubi,
            C_KawaserateSyuruiKbn.KOUJIKAWASERATE,
            kyktuukasyu,
            C_Tuukasyu.JPY,
            C_KawasetekiyoKbn.TTM,
            C_KawasetsryKbn.SYUKKINRATE,
            eigyoubiHoseiKbn,
            youhiKbn);

        BizNumber syuKawaseRateOutoubiJiten = getKawaseRate.getKawaserate();

        KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);

        BizCurrency sbhknkngkYen = keisanGaikakanzan.exec(
            C_Tuukasyu.JPY,
            calcHkShrKngkBean.getSibousGk(),
            syuKawaseRateOutoubiJiten,
            C_HasuusyoriKbn.AGE);

        String yenhrkgkiktnkgk = BLANK;
        C_TkiktbrisyuruiKbn tikiktbrisyuruikbn = pKykKihon.getTikiktbrisyuruikbn();

        int jyuutouTukisuu = 0;
        if (C_TkiktbrisyuruiKbn.NONE.eq(tikiktbrisyuruikbn)) {
            jyuutouTukisuu = 1;
        }
        else if (C_TkiktbrisyuruiKbn.TEIKI_6MONTHS.eq(tikiktbrisyuruikbn)) {
            jyuutouTukisuu = 6;
        }
        else if (C_TkiktbrisyuruiKbn.TEIKI_12MONTHS.eq(tikiktbrisyuruikbn)) {
            jyuutouTukisuu = 12;
        }

        KeisanIkkatuNyuukinGkBean keisanIkkatuNyuukinGkBean = new KeisanIkkatuNyuukinGkBean();
        List<KeisanIkkatuNyuukinGkSyouhnBean> keisanIkkatuNyuukinGkSyouhnBeanLst = Lists.newArrayList();
        KeisanIkkatuNyuukinGkSyouhnBean keisanIkkatuNyuukinGkSyouhnBean = new KeisanIkkatuNyuukinGkSyouhnBean();
        KeisanTukiIkkatuNyuukinGk keisanTukiIkkatuNyuukinGk =  SWAKInjector.getInstance(KeisanTukiIkkatuNyuukinGk.class);

        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnCd(kykSyouhn.getSyouhncd());
        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnsdNo(kykSyouhn.getSyouhnsdno());
        keisanIkkatuNyuukinGkSyouhnBean.setRyouritusdNo(kykSyouhn.getRyouritusdno());
        keisanIkkatuNyuukinGkSyouhnBean.setHokenryou(kykSyouhn.getHokenryou());
        keisanIkkatuNyuukinGkSyouhnBean.setYoteiRiritu(BizNumber.ZERO);
        keisanIkkatuNyuukinGkSyouhnBeanLst.add(keisanIkkatuNyuukinGkSyouhnBean);
        keisanIkkatuNyuukinGkBean.setKeisanIkkatuNyuukinGkSyouhnBeanLst(keisanIkkatuNyuukinGkSyouhnBeanLst);
        keisanIkkatuNyuukinGkBean.setJyuutoutuKisuu(jyuutouTukisuu);
        keisanIkkatuNyuukinGkBean.setTkiktbrisyuruiKbn(tikiktbrisyuruikbn);
        keisanIkkatuNyuukinGkBean.setRstuukasyu(C_Tuukasyu.JPY);
        keisanIkkatuNyuukinGkBean.setNyknaiyouKbn(C_NyknaiyouKbn.BLNK);
        keisanIkkatuNyuukinGkBean.setNykkeiro(C_Nykkeiro.BANK);
        keisanIkkatuNyuukinGkBean.setSyokaiprsYmd(null);
        keisanIkkatuNyuukinGkBean.setJyutoustartYm(null);

        errorKbn = keisanTukiIkkatuNyuukinGk.exec(keisanIkkatuNyuukinGkBean, false);

        if (C_ErrorKbn.OK.eq(errorKbn)) {
            yenhrkgkiktnkgk = keisanTukiIkkatuNyuukinGk.getIktnyknkgk().toString();
        }
        else {
            if (CoreConfig.getInstance().isBatchProduct()) {
                commonErrorKbn = C_ErrorKbn.ERROR;
                return pGaikaKokyakuTuutiTyn;
            }

            throw new CommonBizAppException(ERROR_MSG);
        }

        KeisanCommonKaiyaku keisanCommonKaiyaku = SWAKInjector.getInstance(KeisanCommonKaiyaku.class);
        KeisanKaiyakuBean keisanKaiyakuBean = new KeisanKaiyakuBean();

        keisanKaiyakuBean.setSyoruiukeymd(pKykoutoubi);
        keisanKaiyakuBean.setKaiykymd(pKykoutoubi);
        keisanKaiyakuBean.setYenshrkwsrate(syuKawaseRateOutoubiJiten);
        errorKbn = keisanCommonKaiyaku.keisanKaiyakuseisankin(
            KeisanCommonKaiyaku.KINOUBUNRUI_DRCTSERVICE,
            pKykKihon,
            pKykoutoubi,
            keisanKaiyakuBean);

        String znntikiktbriyenhrkgk = BLANK;
        BizCurrency kaiyakusiharaigk = BizCurrency.valueOf(0);
        BizCurrency kaiyakusiharaigkznnuzndk = BizCurrency.valueOf(0);
        BizCurrency kaiyakusiharaigksntshrgk = BizCurrency.valueOf(0);
        BizCurrency kaiyakuhrkngakKyktuuka = BizCurrency.valueOf(0, tuukaType);
        BizCurrency kaiyakuhrkngakYen = BizCurrency.valueOf(0);

        if (C_ErrorKbn.OK.eq(errorKbn)) {
            KeisanCommonKaiyakuOutBean keisanCommonKaiyakuOutBean = keisanCommonKaiyaku.getKeisanCommonKaiyakuOutBean();

            if (ZENNOU_ARI.equals(zennouUmu)) {

                C_UmuKbn zennoumijyuutouFlg = keisanCommonKaiyakuOutBean.getZennoumijyuutouFlg();

                if (C_UmuKbn.ARI.eq(zennoumijyuutouFlg)) {
                    if (CoreConfig.getInstance().isBatchProduct()) {
                        commonErrorKbn = C_ErrorKbn.ERROR;
                        return pGaikaKokyakuTuutiTyn;
                    }

                    if (pYobidasimotoKbn == EditKykNaiyouOsirase.YOBIDASIMOTOKBN_SEIHOWEB) {

                        bizLogicErrorKbn = C_ErrorKbn.ERROR;
                        bizLogicErrorMsg = MessageUtil.getMessage(MessageId.EIF1125);

                        return pGaikaKokyakuTuutiTyn;
                    }

                    throw new BizLogicException(MessageId.EIF1125);
                }

                BizCurrency zennounyuukinkgk = BizCurrency.valueOf(0);
                BizCurrency rsgaku = BizCurrency.valueOf(0);

                IT_Zennou zennou = zennouList.get(0);
                if (zennou != null) {
                    zennounyuukinkgk = zennou.getZennounyuukinkgk();
                }

                IT_NyknJissekiRireki nyknJissekiRireki = pKykKihon.getNyknJissekiRirekis().get(0);
                if (nyknJissekiRireki != null) {
                    rsgaku = nyknJissekiRireki.getRsgaku();
                }

                znntikiktbriyenhrkgk = zennounyuukinkgk.add(rsgaku).toString();
                kaiyakusiharaigkznnuzndk = keisanCommonKaiyakuOutBean.getZennouseisankYen();
            }

            kaiyakuhrkngakKyktuuka = keisanCommonKaiyakuOutBean.getKaiyakuhrgoukeigk().multiply(JYOUSUU_HYAKU);
            kaiyakuhrkngakYen = keisanCommonKaiyakuOutBean.getKaiyakuhrgoukeiYen();
            kaiyakusiharaigk = keisanCommonKaiyakuOutBean.getShrgkkeiYen();
            kaiyakusiharaigksntshrgk =
                kaiyakusiharaigk.subtract(kaiyakuhrkngakYen).subtract(kaiyakusiharaigkznnuzndk);
        }
        else {
            if (CoreConfig.getInstance().isBatchProduct()) {
                commonErrorKbn = C_ErrorKbn.ERROR;
                return pGaikaKokyakuTuutiTyn;
            }

            throw new CommonBizAppException(ERROR_MSG);
        }

        BizDateYM tmttkntaisyouym = null;
        BizCurrency calckaisiYmjitenv = BizCurrency.valueOf(0, tuukaType);
        BizCurrency calckaisiYmjitensump = BizCurrency.valueOf(0, tuukaType);
        BizCurrency nkgnsgaikasyourai = BizCurrency.valueOf(0, tuukaType);
        BizCurrency nkgnsyensyourai = BizCurrency.valueOf(0);

        IT_HokenryouTmttkn hokenryouTmttkn =
            hozenDomManager.getHokenryouTmttknBySyonoTmttkntaisyouym(
                syono,
                BizDateYM.valueOf(MAX_INT_VALUE_TMTTKNTAISYOUYM));

        if (hokenryouTmttkn != null) {
            tmttkntaisyouym = hokenryouTmttkn.getTmttkntaisyouym();
            calckaisiYmjitenv = hokenryouTmttkn.getPtmttkngk();
            calckaisiYmjitensump = hokenryouTmttkn.getKihrkmpstgk();
        }

        getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);
        getKawaseRate.exec(
            pKykoutoubi,
            C_KawaserateSyuruiKbn.KOUJIKAWASERATE,
            kyktuukasyu,
            C_Tuukasyu.JPY,
            C_KawasetekiyoKbn.TTM,
            C_KawasetsryKbn.NYUKINRATE,
            eigyoubiHoseiKbn,
            youhiKbn);

        BizNumber nyuKawaseRateOutoubiJiten = getKawaseRate.getKawaserate();

        KeisanVHeijyunBean keisanVHeijyunBean = SWAKInjector.getInstance(KeisanVHeijyunBean.class);

        keisanVHeijyunBean.setSyouhncd(kykSyouhn.getSyouhncd());
        keisanVHeijyunBean.setRyouritusdno(kykSyouhn.getRyouritusdno());
        keisanVHeijyunBean.setCalckijyunYm(kykSyouhn.getHknkknmanryouymd().getBizDateYM());
        keisanVHeijyunBean.setKykymd(kykymd);
        keisanVHeijyunBean.setHokenryou(kykSyouhn.getHokenryou());
        keisanVHeijyunBean.setKyktuukasyu(kyktuukasyu);
        keisanVHeijyunBean.setHhknsei(kykSyouhn.getHhknsei());
        keisanVHeijyunBean.setHhknnen(kykSyouhn.getHhknnen());
        keisanVHeijyunBean.setHknkkn(kykSyouhn.getHknkkn());
        keisanVHeijyunBean.setHknkknsmnkbn(kykSyouhn.getHknkknsmnkbn());
        keisanVHeijyunBean.setHrkkkn(kykSyouhn.getHrkkkn());
        keisanVHeijyunBean.setHrkkknsmnkbn(kykSyouhn.getHrkkknsmnkbn());
        keisanVHeijyunBean.setHrkkaisuu(pKykKihon.getHrkkaisuu());
        keisanVHeijyunBean.setFstpryosyu(pKykKihon.getFstpnyknymd());
        keisanVHeijyunBean.setSitihsyuriritu(kykSyouhn.getYoteirrthendohosyurrt());
        keisanVHeijyunBean.setTmttkntaisyouym(tmttkntaisyouym);
        keisanVHeijyunBean.setCalckaisiYmjitenv(calckaisiYmjitenv);
        keisanVHeijyunBean.setCalckaisiYmjitensump(calckaisiYmjitensump);
        keisanVHeijyunBean.setSisansyuruikbn(C_KhSisanSyuruiKbn.JISSEKI_SISAN);
        keisanVHeijyunBean.setSisansyoriYmd(pKykoutoubi);
        keisanVHeijyunBean.setSisanyoteiriritu(syouhnZokusei.getYoteirirituminhosyouritu());
        keisanVHeijyunBean.setSisankawaserate(nyuKawaseRateOutoubiJiten);

        KeisanVHeijyun keisanVHeijyun = SWAKInjector.getInstance(KeisanVHeijyun.class);
        C_ErrorKbn heijyunErrorKbn = keisanVHeijyun.exec(keisanVHeijyunBean);

        KeisanAzukariGanrikin keisanAzukariGanrikin = SWAKInjector.getInstance(KeisanAzukariGanrikin.class);
        C_ErrorKbn azukariErrorKbn = keisanAzukariGanrikin.exec(
            syono, kykSyouhn.getHknkknmanryouymd(), kyktuukasyu);

        if (C_ErrorKbn.OK.eq(heijyunErrorKbn) && C_ErrorKbn.OK.eq(azukariErrorKbn)) {

            BizCurrency azukariGanrikinGaika = keisanAzukariGanrikin.getAzukariGanrikinKyktuuka();
            BizCurrency azukariGanrikinYenka = keisanAzukariGanrikin.getAzukariGanrikinYen();
            BizCurrency tmttP = keisanVHeijyun.getV();

            BizCurrency azukariGanrikinYenToGai = keisanGaikakanzan.execDivide(
                kyktuukasyu,
                azukariGanrikinYenka,
                nyuKawaseRateOutoubiJiten,
                C_HasuusyoriKbn.AGE);

            nkgnsgaikasyourai = azukariGanrikinGaika.add(tmttP).add(azukariGanrikinYenToGai);

            BizCurrency tuukaGokeiGai = azukariGanrikinGaika.add(tmttP);

            BizCurrency tuukaGokeiGaiToYen = keisanGaikakanzan.exec(
                C_Tuukasyu.JPY,
                tuukaGokeiGai,
                syuKawaseRateOutoubiJiten,
                C_HasuusyoriKbn.AGE);

            nkgnsyensyourai = azukariGanrikinYenka.add(tuukaGokeiGaiToYen);
        }
        else {
            if (CoreConfig.getInstance().isBatchProduct()) {
                commonErrorKbn = C_ErrorKbn.ERROR;
                return pGaikaKokyakuTuutiTyn;
            }

            throw new CommonBizAppException(ERROR_MSG);
        }

        BizCurrency yenhrkgkgoukei = BizCurrency.valueOf(0);
        BizCurrency yenhrkgkgoukeisyourai = BizCurrency.valueOf(0);
        BizNumber hrritu = BizNumber.ZERO;
        BizNumber hrritusyourai = BizNumber.ZERO;

        KeisanHrrtksnHrkPGkgk keisanHrrtksnHrkPGkgk = SWAKInjector.getInstance(KeisanHrrtksnHrkPGkgk.class);
        errorKbn = keisanHrrtksnHrkPGkgk.exec(syono);

        if (C_ErrorKbn.OK.eq(errorKbn)) {
            boolean keisankahi = keisanHrrtksnHrkPGkgk.getKeisanKahi();

            if (keisankahi) {
                yenhrkgkgoukei = keisanHrrtksnHrkPGkgk.getKihrkmP();
                hrritu =
                    kaiyakusiharaigk.divideBizCurrency(yenhrkgkgoukei, 2, RoundingMode.DOWN).multiply(JYOUSUU_HYAKU);

                yenhrkgkgoukeisyourai = keisanHrrtksnHrkPGkgk.getHrkmPSgkHknkkn();
                hrritusyourai =
                    nkgnsyensyourai.divideBizCurrency(yenhrkgkgoukeisyourai, 2, RoundingMode.DOWN).multiply(JYOUSUU_HYAKU);
            }
        }
        else {
            if (CoreConfig.getInstance().isBatchProduct()) {
                commonErrorKbn = C_ErrorKbn.ERROR;
                return pGaikaKokyakuTuutiTyn;
            }

            throw new CommonBizAppException(ERROR_MSG);
        }

        String hosyouhskmsgcd7 = BLANK;
        String hosyouhskmsgcd8 = BLANK;
        String hosyouhskmsgcd9 = BLANK;

        if (!kaiyakusiharaigksntshrgk.isZeroOrOptional()) {
            hosyouhskmsgcd7 = HSKMSG_HSKMSGCD17;
            hosyouhskmsgcd8 = HSKMSG_HSKMSGCD18;

            if (yenhrkgkgoukei.isZeroOrOptional()) {
                hosyouhskmsgcd9 = HSKMSG_HSKMSGCD19;
            }
        }
        else {
            hosyouhskmsgcd7 = HSKMSG_HSKMSGCD18;
            if (yenhrkgkgoukei.isZeroOrOptional()) {
                hosyouhskmsgcd8 = HSKMSG_HSKMSGCD19;
            }
        }

        String dsKaiykTirasiDouhuuKbn = DSKAIYKTIRASIDOUHUUKBN_NASI;

        BizDateYM kykYmdadd1Year = kykymd.addYears(1).getBizDateYM();

        if (BizDateUtil.compareYm(kykYmdadd1Year, pSyoriYmd.getBizDateYM()) == BizDateUtil.COMPARE_EQUAL) {
            dsKaiykTirasiDouhuuKbn = DSKAIYKTIRASIDOUHUUKBN_ARI;
        }

        pGaikaKokyakuTuutiTyn.setZtysyoruicd(C_SyoruiCdKbn.KK_GAIKA_KOKYAKUTUUTI.getValue().toUpperCase());
        pGaikaKokyakuTuutiTyn.setZtyaisatumsgcd1(AISATUMSGCD_03008);
        pGaikaKokyakuTuutiTyn.setZtydskaiyktirasidouhuukbn(dsKaiykTirasiDouhuuKbn);
        pGaikaKokyakuTuutiTyn.setZtyosirasetuutisakuseiymwa(
            FixedDateFormatter.formatYMZenkakuSeirekiKanji(pKykoutoubi));
        pGaikaKokyakuTuutiTyn.setZtynkshrstartymdstr(
            FixedDateFormatter.formatYMDZenkakuSeirekiKanji(kykSyouhn.getHknkknmanryouymd()));
        pGaikaKokyakuTuutiTyn.setZtynenkinstartnen(String.valueOf(nkNenrei));
        pGaikaKokyakuTuutiTyn.setZtynksyuruinm(nksyukbn);
        pGaikaKokyakuTuutiTyn.setZtyhrkkaisuu(
            Strings.padStart(pKykKihon.getHrkkaisuu().getValue(), 2, '0'));
        pGaikaKokyakuTuutiTyn.setZtytikiktbrisyuruikbn(
            Strings.padStart(tikiktbrisyuruikbn.getValue(), 2, '0'));
        pGaikaKokyakuTuutiTyn.setZtyzennouumu(zennouUmu);
        pGaikaKokyakuTuutiTyn.setZtyhrkkeiro(pKykKihon.getHrkkeiro().getValue());
        pGaikaKokyakuTuutiTyn.setZtyphrkkkn(kykSyouhn.getHrkkkn().toString());
        pGaikaKokyakuTuutiTyn.setZtysueokikkn(String.valueOf(sueokikkn));
        pGaikaKokyakuTuutiTyn.setZtyyenhrkgk(pKykKihon.getHrkp().toString());
        pGaikaKokyakuTuutiTyn.setZtysakuseikijyunymdkwsrate(
            String.valueOf(syuKawaseRateOutoubiJiten.multiply(JYOUSUU_HYAKU)));
        pGaikaKokyakuTuutiTyn.setZtysbhknkngkkyktuuka(sbhknkngkKyktuuka.toString());
        pGaikaKokyakuTuutiTyn.setZtysbhknkngkyen(sbhknkngkYen.toString());
        pGaikaKokyakuTuutiTyn.setZtykaiyakuhrkngakkyktuuka(kaiyakuhrkngakKyktuuka.toString());
        pGaikaKokyakuTuutiTyn.setZtykaiyakuhrkngakyen(kaiyakuhrkngakYen.toString());
        pGaikaKokyakuTuutiTyn.setZtyhosyouhskmsgcd1(HSKMSG_HSKMSGCD13);
        pGaikaKokyakuTuutiTyn.setZtyhosyouhskmsgcd2(BLANK);
        pGaikaKokyakuTuutiTyn.setZtyhosyouhskmsgcd3(BLANK);
        pGaikaKokyakuTuutiTyn.setZtyhosyouhskmsgcd4(HSKMSG_HSKMSGCD14);
        pGaikaKokyakuTuutiTyn.setZtyhosyouhskmsgcd5(HSKMSG_HSKMSGCD15);
        pGaikaKokyakuTuutiTyn.setZtyhosyouhskmsgcd6(HSKMSG_HSKMSGCD16);
        pGaikaKokyakuTuutiTyn.setZtyhosyouhskmsgcd7(hosyouhskmsgcd7);
        pGaikaKokyakuTuutiTyn.setZtyhosyouhskmsgcd8(hosyouhskmsgcd8);
        pGaikaKokyakuTuutiTyn.setZtyhosyouhskmsgcd9(hosyouhskmsgcd9);
        pGaikaKokyakuTuutiTyn.setZtyyenhrkgkiktnkgk(yenhrkgkiktnkgk.toString());
        pGaikaKokyakuTuutiTyn.setZtyzennoutikiktyenhrkgkkykj(znntikiktbriyenhrkgk);
        pGaikaKokyakuTuutiTyn.setZtykaiyakusiharaigk(kaiyakusiharaigk.toString());
        pGaikaKokyakuTuutiTyn.setZtykaiyakusiharaigkznnuzndk(kaiyakusiharaigkznnuzndk.toString());
        pGaikaKokyakuTuutiTyn.setZtykaiyakusiharaigksntshrgk(kaiyakusiharaigksntshrgk.toString());
        pGaikaKokyakuTuutiTyn.setZtyyenhrkgkgoukei(yenhrkgkgoukei.toString());
        pGaikaKokyakuTuutiTyn.setZtyhrritu(hrritu.toString());
        pGaikaKokyakuTuutiTyn.setZtynkgnsyensyourai(nkgnsyensyourai.toString());
        pGaikaKokyakuTuutiTyn.setZtynkgnsgaikasyourai(nkgnsgaikasyourai.multiply(JYOUSUU_HYAKU).toString());
        pGaikaKokyakuTuutiTyn.setZtyyenhrkgkgoukeisyourai(yenhrkgkgoukeisyourai.toString());
        pGaikaKokyakuTuutiTyn.setZtyhrritusyourai(hrritusyourai.toString());
        pGaikaKokyakuTuutiTyn.setZtynkgnshskmsgcd1(HSKMSG_HSKMSGCD30);
        pGaikaKokyakuTuutiTyn.setZtynkgnshskmsgcd2(HSKMSG_HSKMSGCD31);
        pGaikaKokyakuTuutiTyn.setZtynkgnshskmsgcd3(HSKMSG_HSKMSGCD32);
        pGaikaKokyakuTuutiTyn.setZtynkgnshskmsgcd4(BLANK);
        pGaikaKokyakuTuutiTyn.setZtynkgnshskmsgcd5(BLANK);

        int methodNo = 1;

        GetYoteiriritu getYoteiriritu = SWAKInjector.getInstance(GetYoteiriritu.class);

        BizDate kijyunfromymd = pKykoutoubi.getBizDateYM().addMonths(-11).getFirstDay();

        if (BizDateUtil.compareYm(kijyunfromymd.getBizDateYM(), kykymd.getBizDateYM()) ==  BizDateUtil.COMPARE_LESSER ||
            BizDateUtil.compareYm(kijyunfromymd.getBizDateYM(), kykymd.getBizDateYM()) ==  BizDateUtil.COMPARE_EQUAL) {
            kijyunfromymd = kykymd.getBizDateYM().getFirstDay();
        }

        BizDate kijyuntoymd = pKykoutoubi.getBizDateYM().getFirstDay();

        List<BM_YoteiRiritu3> yoteiRiritu3List =
            editKykNaiyouOsiraseDao.getYoteiRiritu3List(
                kykSyouhn.getSyouhncd(),
                BLANK,
                BLANK,
                kijyunfromymd,
                kijyuntoymd);

        BizDateFormat formatYm = new BizDateFormat("yyyy年MM月", FillStyle.None);

        BizDateYM jkipjytym = ansyuKihon.getJkipjytym();

        BizCurrency yenP = pKykKihon.getHrkp();
        String ytirrtitrnhskmsgcd5 = BLANK;

        List<BM_KawaseRate> kawaseRateList =
            getIkkatuKawaseRate(yoteiRiritu3List, kyktuukasyu, kykymd, pKykKihon.getFstpnyknymd());

        for (int index = 0; index < yoteiRiritu3List.size(); index++) {

            BM_YoteiRiritu3 yoteiRiritu3 = yoteiRiritu3List.get(index);

            BizDate kijyunfromYmdLoop = yoteiRiritu3.getKijyunfromymd();

            String yoteirrtkjnYm = formatYm.format(kijyunfromYmdLoop);
            String kwsratekijyunymStr = formatYm.format(kijyunfromYmdLoop.getPreviousMonth());
            BizDateYM kwsratekijyunym = kijyunfromYmdLoop.getPreviousMonth().getBizDateYM();

            GetYoteirirituBean getYoteirirituBean = new GetYoteirirituBean();
            getYoteirirituBean.setSyouhncd(kykSyouhn.getSyouhncd());
            getYoteirirituBean.setKijyunymd(kijyunfromYmdLoop);
            getYoteirirituBean.setSknnkaisiymd(kykSyouhn.getSknnkaisiymd());
            getYoteirirituBean.setKykymd(kykymd);
            getYoteirirituBean.setHknkkn(kykSyouhn.getHknkkn());
            getYoteirirituBean.setHknkknsmnkbn(kykSyouhn.getHknkknsmnkbn());
            getYoteirirituBean.setHhknnen(kykSyouhn.getHhknnen());
            getYoteirirituBean.setSitihsyuriritu(syouhnZokusei.getYoteirirituminhosyouritu());
            getYoteirirituBean.setTuukasyu(kyktuukasyu);

            String yoteirrt = BLANK;

            errorKbn = getYoteiriritu.exec(getYoteirirituBean);

            if (C_ErrorKbn.OK.eq(errorKbn)) {
                yoteirrt = getYoteiriritu.getYoteiriritu().multiply(JYOUSUU_MAN).toString();
            }

            String yoteirrtCalcKjnRrt = yoteiRiritu3.getYoteiriritu().multiply(JYOUSUU_MAN).toString();

            String fstphyoujikbn = BLANK;

            if (index == kawaseRateList.size() - 1) {
                if (BizDateUtil.compareYm(kwsratekijyunym, kykymd.getBizDateYM()) == BizDateUtil.COMPARE_EQUAL) {
                    ytirrtitrnhskmsgcd5 = HSKMSG_HSKMSGCD44;
                    fstphyoujikbn = FSTPHYOUJIKBN_HYOJI;
                }
            }

            String kawaserate = BLANK;
            String kyktuukasyuP = BLANK;
            String yenPStr = BLANK;

            if (yoteiRiritu3List.size() != kawaseRateList.size()) {
                if (index != yoteiRiritu3List.size() - 1) {
                    BM_KawaseRate kawaseRateInfo = kawaseRateList.get(index);
                    kawaserate = kawaseRateInfo.getKawaserate().multiply(JYOUSUU_HYAKU).toString();
                    if ((BizDateUtil.compareYm(jkipjytym, kwsratekijyunym) == BizDateUtil.COMPARE_GREATER) &&
                        !yenP.isZeroOrOptional()) {
                        BizCurrency kyktuuka = keisanGaikakanzan.execDivide(
                            kyktuukasyu,
                            yenP,
                            kawaseRateInfo.getKawaserate(),
                            C_HasuusyoriKbn.AGE);
                        kyktuukasyuP = kyktuuka.multiply(JYOUSUU_HYAKU).toString();
                        yenPStr = yenP.toString();
                    }
                }
                else {
                    kwsratekijyunymStr = BLANK;
                }
            }
            else {
                BM_KawaseRate kawaseRateInfo = kawaseRateList.get(index);
                kawaserate = kawaseRateInfo.getKawaserate().multiply(JYOUSUU_HYAKU).toString();
                if ((BizDateUtil.compareYm(jkipjytym, kwsratekijyunym) == BizDateUtil.COMPARE_GREATER) &&
                    !yenP.isZeroOrOptional()) {
                    BizCurrency kyktuuka = keisanGaikakanzan.execDivide(
                        kyktuukasyu,
                        yenP,
                        kawaseRateInfo.getKawaserate(),
                        C_HasuusyoriKbn.AGE);
                    kyktuukasyuP = kyktuuka.multiply(JYOUSUU_HYAKU).toString();
                    yenPStr = yenP.toString();
                }
            }

            try {
                methodNmEditAndExec(
                    ZT_GaikaKokyakuTuutiTy.class,
                    pGaikaKokyakuTuutiTyn,
                    "setZtyyoteiriritukijyunym",
                    methodNo, yoteirrtkjnYm);
                methodNmEditAndExec(
                    ZT_GaikaKokyakuTuutiTy.class,
                    pGaikaKokyakuTuutiTyn,
                    "setZtyyoteiriritu",
                    methodNo, yoteirrt);
                methodNmEditAndExec(
                    ZT_GaikaKokyakuTuutiTy.class,
                    pGaikaKokyakuTuutiTyn,
                    "setZtyytirrtcalckijyunrrt",
                    methodNo, yoteirrtCalcKjnRrt);
                methodNmEditAndExec(
                    ZT_GaikaKokyakuTuutiTy.class,
                    pGaikaKokyakuTuutiTyn,
                    "setZtykwsratekijyunym",
                    methodNo, kwsratekijyunymStr);
                methodNmEditAndExec(
                    ZT_GaikaKokyakuTuutiTy.class,
                    pGaikaKokyakuTuutiTyn,
                    "setZtykaknsnkwsrate",
                    methodNo, kawaserate);
                methodNmEditAndExec(
                    ZT_GaikaKokyakuTuutiTy.class,
                    pGaikaKokyakuTuutiTyn,
                    "setZtypgaika",
                    methodNo, kyktuukasyuP);
                methodNmEditAndExec(
                    ZT_GaikaKokyakuTuutiTy.class,
                    pGaikaKokyakuTuutiTyn,
                    "setZtypyen",
                    methodNo, yenPStr);
                methodNmEditAndExec(
                    ZT_GaikaKokyakuTuutiTy.class,
                    pGaikaKokyakuTuutiTyn,
                    "setZtyfstphyoujikbn",
                    methodNo, fstphyoujikbn);

            } catch (IllegalAccessException
                | NoSuchMethodException
                | InvocationTargetException e) {
                throw new CommonBizAppException();
            }

            methodNo++;
        }

        pGaikaKokyakuTuutiTyn.setZtyytirrtitrnhskmsgcd1(HSKMSG_HSKMSGCD40);
        pGaikaKokyakuTuutiTyn.setZtyytirrtitrnhskmsgcd2(HSKMSG_HSKMSGCD41);
        pGaikaKokyakuTuutiTyn.setZtyytirrtitrnhskmsgcd3(HSKMSG_HSKMSGCD42);
        pGaikaKokyakuTuutiTyn.setZtyytirrtitrnhskmsgcd4(HSKMSG_HSKMSGCD43);
        pGaikaKokyakuTuutiTyn.setZtyytirrtitrnhskmsgcd5(ytirrtitrnhskmsgcd5);
        pGaikaKokyakuTuutiTyn.setZtyytirrtitrnhskmsgcd6(BLANK);
        pGaikaKokyakuTuutiTyn.setZtyytirrtitrnhskmsgcd7(BLANK);
        pGaikaKokyakuTuutiTyn.setZtyytirrtitrnhskmsgcd8(BLANK);

        return pGaikaKokyakuTuutiTyn;
    }

    private List<BM_KawaseRate> getIkkatuKawaseRate (
        List<BM_YoteiRiritu3> pYoteiRiritu3List,
        C_Tuukasyu pTuukasyu,
        BizDate pKykymd,
        BizDate pFstpryosyu) {
        List<BizDate> kwsratekjymdList = Lists.newArrayList();
        List<BM_KawaseRate> kawaseRateList = Lists.newArrayList();

        if (pYoteiRiritu3List.size() == 1) {
            return kawaseRateList;
        }

        for (int index = 0; index < pYoteiRiritu3List.size(); index++) {
            BM_YoteiRiritu3 yoteiRiritu3 = pYoteiRiritu3List.get(index);
            BizDate kijyunYmd = yoteiRiritu3.getKijyunfromymd();
            BizDateYM kwsratekijyunym = kijyunYmd.getPreviousMonth().getBizDateYM();
            BizDate kwsratekjymd;

            if (BizDateUtil.compareYm(pKykymd.getBizDateYM(), kwsratekijyunym) == BizDateUtil.COMPARE_EQUAL)  {
                kwsratekjymd =
                    pFstpryosyu.getPreviousDay().
                    getBusinessDay(CHolidayAdjustingMode.PREVIOUS);
                kwsratekjymdList.add(kwsratekjymd);
                break;
            }

            kwsratekjymd =
                kwsratekijyunym.getPreviousMonth().getLastDay()
                .getBusinessDay(CHolidayAdjustingMode.PREVIOUS);

            kwsratekjymdList.add(kwsratekjymd);
        }

        C_KwsrendouKbn kwsrendouKbn;
        if (C_Tuukasyu.USD.eq(pTuukasyu)) {

            kwsrendouKbn = C_KwsrendouKbn.KOUJIKAWASERATE1;

        }
        else {
            kwsrendouKbn = C_KwsrendouKbn.KOUJIKAWASERATE2;
        }

        kawaseRateList = editKykNaiyouOsiraseDao.getKawaseRateList(
            kwsratekjymdList,
            kwsrendouKbn,
            pTuukasyu,
            C_Tuukasyu.JPY,
            C_KawasetekiyoKbn.TTM,
            C_KawasetsryKbn.NYUKINRATE);

        return kawaseRateList;
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
}
