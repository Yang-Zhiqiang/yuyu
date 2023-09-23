package yuyu.common.hozen.khcommon;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import jp.co.slcs.swak.number.currencytype.CurrencyType;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.bzcommon.KeisanAzukariGanrikin;
import yuyu.common.biz.bzcommon.KeisanGaikakanzan;
import yuyu.common.hozen.ascommon.KeisanZennouSeisanGk2;
import yuyu.common.hozen.haitou.KeisanDCommonKaiyaku;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.classification.C_Kaiyakujiyuu;
import yuyu.def.classification.C_Krkseisanzumiflg;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_MisyuptsKbn;
import yuyu.def.classification.C_NaiteiKakuteiKbn;
import yuyu.def.classification.C_RatesyutokukekkaKbn;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_KhHenreikin;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.hozen.manager.HozenDomManager;

/**
 * 契約保全 契約保全共通 解約共通計算
 */

public class KeisanCommonKaiyaku {

    @Inject
    private static Logger logger;

    private String errorMessage = "";

    private KeisanCommonKaiyakuOutBean keisanKaiyakuOutBean;

    public static final String KINOUBUNRUI_ONLINE = "online";

    public static final String KINOUBUNRUI_BATCH = "batch";

    public static final String KINOUBUNRUI_DRCTSERVICE = "drctservice";

    @Inject
    private HozenDomManager hozenDomManager;

    public KeisanCommonKaiyaku() {
        super();
    }

    public String getErrorMessage () {
        return errorMessage;
    }

    public KeisanCommonKaiyakuOutBean getKeisanCommonKaiyakuOutBean () {
        return keisanKaiyakuOutBean;
    }

    public C_ErrorKbn keisanKaiyakuseisankin(String pKinouBunrui, IT_KykKihon pKykKihon,
        BizDate pSyoriYmd, KeisanKaiyakuBean pKeisanKaiyakuInBean) {

        logger.debug("▽ 解約精算金計算処理 開始");

        String syoNo = pKykKihon.getSyono();
        List<IT_KykSyouhn> kykSyouhnList = pKykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSyouhn kykSyouhn = kykSyouhnList.get(0);

        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon(syoNo);

        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
        CurrencyType currencyType = henkanTuuka.henkanTuukaKbnToType(kykSyouhn.getKyktuukasyu());

        C_ErrorKbn errorKbn = C_ErrorKbn.OK;
        C_ErrorKbn errorKbnHanteiyou = C_ErrorKbn.OK;
        BizCurrency shrgkkeigk = BizCurrency.valueOf(0, currencyType);
        BizCurrency shrgkkeiYen = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        BizCurrency sonotaShrgkgk = BizCurrency.valueOf(0, currencyType);
        BizCurrency sonotaShrgkYen = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        BizCurrency kaiyakuHrgoukeigk = BizCurrency.valueOf(0, currencyType);
        BizCurrency kaiyakuHrgoukeiYen = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        BizCurrency kaiyakuHr = BizCurrency.valueOf(0, currencyType);
        BizCurrency kaiyakuHrYen = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        BizCurrency yendthnkKaiyakuhr = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        BizCurrency zennouseisankGk = BizCurrency.valueOf(0, currencyType);
        BizCurrency zennouSeisankYen = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        BizCurrency mikeikapGk = BizCurrency.valueOf(0, currencyType);
        BizCurrency mikeikapYen = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        BizCurrency azukariGanrikingk = BizCurrency.valueOf(0, currencyType);
        BizCurrency azukariGanrikinYen = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        BizCurrency krkgkYen = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        BizCurrency haitoukinYen = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        BizCurrency tkbthaitoukinYen = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        BizCurrency tmtthaitoukinYen = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        BizCurrency sonotahaitoukinYen = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        BizCurrency sonotaSeisan = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        BizCurrency gensen = BizCurrency.valueOf(0, currencyType);
        BizCurrency gaikaShrYenGsTsZeigk = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        BizCurrency gaikaShrYenGsTsZeigkKokuz = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        BizCurrency gaikaShrYenGsTsZeigkTihouz = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        C_UmuKbn gaikaGsBunriTaisyouFlag = C_UmuKbn.NONE;
        BizCurrency gaikaShrYenGsTsTaisyouSaeki = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        BizCurrency gaikaShrYenHtyKeihi = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        C_RatesyutokukekkaKbn zeimuRatesyutokukekkaKbn = C_RatesyutokukekkaKbn.SEIJYOU;
        BizDate  zeimuRatesyutokuYmd = null;
        BizNumber zeimukwsrate = BizNumber.valueOf(0);
        BizCurrency gensengkYenkaiyakuhr = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

        BizCurrency yenGensen = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        BizCurrency jpyShrjiYengstszeigkKokuz = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        BizCurrency jpyShrjiYengstszeigkTihouz = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        C_UmuKbn jpyShrjiGsbunritaisyou = C_UmuKbn.NONE;
        BizCurrency jpyKaShrYenGsTsTaisyouSaeki = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        BizCurrency jpyShrjiYenhtykeihi = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        BizCurrency sonotaShrgkKeisanKhGensen = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        C_Kaiyakujiyuu kaiyakujiyuu = C_Kaiyakujiyuu.TUUJYOU;

        int syohinHanteiKbn = SyouhinUtil.hantei(kykSyouhn.getSyouhncd());

        KeisanWKijunYM keisanWKijunYM = SWAKInjector.getInstance(KeisanWKijunYM.class);

        BizDateYM kaiyakuhrKeisankijyunYm = keisanWKijunYM.exec(kykSyouhn.getKykymd(),
            pKeisanKaiyakuInBean.getKaiykymd(),
            ansyuKihon.getJkipjytym(),
            pKykKihon.getHrkkaisuu(),
            kykSyouhn.getKykjyoutai(),
            kykSyouhn.getSyouhncd(),
            kykSyouhn.getYendthnkymd());

        KeisanWExt keisanWExt = SWAKInjector.getInstance(KeisanWExt.class);
        errorKbnHanteiyou = keisanWExt.exec(syoNo, pKeisanKaiyakuInBean.getKaiykymd());

        if (C_ErrorKbn.ERROR.eq(errorKbnHanteiyou)) {

            errorKbn = C_ErrorKbn.ERROR;

            errorMessage = "解約返戻金計算拡張情報作成が実行できませんでした。";

            logger.debug("△ 解約精算金計算処理 終了");

            return errorKbn;
        }

        KeisanW keisanW = SWAKInjector.getInstance(KeisanW.class);
        errorKbnHanteiyou = keisanW.exec(pKeisanKaiyakuInBean.getKaiykymd(),
            kaiyakuhrKeisankijyunYm,
            keisanWExt.getKeisanWExtBean());

        if (C_ErrorKbn.ERROR.eq(errorKbnHanteiyou)) {

            errorKbn = C_ErrorKbn.ERROR;

            errorMessage = "解約返戻金計算が実行できませんでした。";

            logger.debug("△ 解約精算金計算処理 終了");

            return errorKbn;
        }

        KeisanGaikakanzan keisanGaikakanzan= SWAKInjector.getInstance(KeisanGaikakanzan.class);
        if (!C_Tuukasyu.JPY.eq(kykSyouhn.getKyktuukasyu())) {

            BizCurrency kanzanGaku = keisanGaikakanzan.exec(C_Tuukasyu.JPY,
                keisanW.getW(),
                pKeisanKaiyakuInBean.getYenshrkwsrate(),
                C_HasuusyoriKbn.AGE);

            kaiyakuHr = keisanW.getW();
            kaiyakuHrYen = kanzanGaku;
        }

        else  {
            kaiyakuHr = keisanW.getW();
            kaiyakuHrYen = keisanW.getW();
            yendthnkKaiyakuhr = keisanW.getW();

        }


        BizDateYM mikeikaPjyutouYm = null;
        int mikeikaPJyutouKaisuuY = 0;
        int mikeikaPJyutouKaisuuM = 0;
        MiKeikaPBean[] miKeikaPBeans = null;
        BizDateYM lastpjytoym = null;
        C_UmuKbn zennoumijyuutouFlg = C_UmuKbn.NONE;

        if (C_Kykjyoutai.HRKMTYUU.eq(kykSyouhn.getKykjyoutai()) ||
            C_Kykjyoutai.IKKATUNK.eq(kykSyouhn.getKykjyoutai()) ||
            C_Kykjyoutai.ZENNOU.eq(kykSyouhn.getKykjyoutai())) {

            BizDateYM jkipjytym;
            if (C_Kykjyoutai.ZENNOU.eq(kykSyouhn.getKykjyoutai())) {
                if (BizDateUtil.compareYmd(pKeisanKaiyakuInBean.getSyoruiukeymd(), BizDate.valueOf(
                    ansyuKihon.getJkipjytym(), kykSyouhn.getKykymd().getDay()).getRekijyou()) == BizDateUtil.COMPARE_LESSER) {
                    KeisanZennouSeisanGk2 keisanZennouSeisanGk2 = SWAKInjector.getInstance(KeisanZennouSeisanGk2.class);
                    errorKbnHanteiyou = keisanZennouSeisanGk2.exec(
                        pKeisanKaiyakuInBean.getKaiykymd(),
                        syoNo);

                    if (C_ErrorKbn.ERROR.eq(errorKbnHanteiyou)) {

                        errorKbn = C_ErrorKbn.ERROR;

                        errorMessage = "前納精算額計算が実行できませんでした。";

                        logger.debug("△ 解約精算金計算処理 終了");

                        return errorKbn;
                    }

                    if (SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN == syohinHanteiKbn) {
                        zennouSeisankYen = keisanZennouSeisanGk2.getZennouSeisanGk();

                    }
                    else {
                        if (!C_Tuukasyu.JPY.eq(kykSyouhn.getKyktuukasyu())) {
                            zennouseisankGk = keisanZennouSeisanGk2.getZennouSeisanGk();

                        }
                        else {
                            zennouSeisankYen = keisanZennouSeisanGk2.getZennouSeisanGk();

                        }
                    }

                    jkipjytym = keisanZennouSeisanGk2.getLastPJyuutouYm().addYears(1);
                    lastpjytoym = keisanZennouSeisanGk2.getLastPJyuutouYm();

                }
                else {

                    zennouSeisankYen = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                    jkipjytym = ansyuKihon.getJkipjytym();
                    zennoumijyuutouFlg = C_UmuKbn.ARI;
                }
            }
            else {
                jkipjytym = ansyuKihon.getJkipjytym();
            }
            KeisanMsyMkeiP keisanMsyMkeiP = SWAKInjector.getInstance(KeisanMsyMkeiP.class);
            keisanMsyMkeiP.exec(syoNo,
                pKeisanKaiyakuInBean.getKaiykymd(),
                jkipjytym,
                kykSyouhn.getHokenryou(),
                C_MisyuptsKbn.MITS);

            if (SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN == syohinHanteiKbn) {
                mikeikapYen = keisanMsyMkeiP.getMikeikaP();

            }
            else {
                if (!C_Tuukasyu.JPY.eq(kykSyouhn.getKyktuukasyu())) {
                    mikeikapGk = keisanMsyMkeiP.getMikeikaP();

                }
                else {
                    mikeikapYen = keisanMsyMkeiP.getMikeikaP();

                }
            }

            mikeikaPjyutouYm = keisanMsyMkeiP.getMikeikaPJyutouYM();
            mikeikaPJyutouKaisuuY = keisanMsyMkeiP.getMikeikaPJyutouKaisuuY();
            mikeikaPJyutouKaisuuM = keisanMsyMkeiP.getMikeikaPJyutouKaisuuM();
            miKeikaPBeans = keisanMsyMkeiP.getMiKeikaPBeans();

        }


        KeisanAzukariGanrikin keisanAzukariGanrikin = SWAKInjector.getInstance(KeisanAzukariGanrikin.class);
        errorKbnHanteiyou = keisanAzukariGanrikin.exec(
            syoNo,
            pKeisanKaiyakuInBean.getKaiykymd(),
            kykSyouhn.getKyktuukasyu());

        if (C_ErrorKbn.ERROR.eq(errorKbnHanteiyou)) {

            errorKbn = C_ErrorKbn.ERROR;

            errorMessage = "預り元利金計算が実行できませんでした。";

            logger.debug("△ 解約精算金計算処理 終了");

            return errorKbn;
        }

        azukariGanrikingk = keisanAzukariGanrikin.getAzukariGanrikinKyktuuka();
        azukariGanrikinYen = keisanAzukariGanrikin.getAzukariGanrikinYen();


        Map<CurrencyType, BizCurrency> kykKihonMap = pKykKihon.getKariukekinSumKrkgkByKrkseisanzumiflg(
            C_Krkseisanzumiflg.SUMI);
        if (kykKihonMap.size() != 0) {
            krkgkYen = kykKihonMap.get(BizCurrencyTypes.YEN);
        }


        KeisanDCommonKaiyaku keisanDCommonKaiyaku = SWAKInjector.getInstance(KeisanDCommonKaiyaku.class);
        errorKbnHanteiyou = keisanDCommonKaiyaku.calcDShrgk(
            syoNo,
            pKeisanKaiyakuInBean.getKaiykymd(),
            pSyoriYmd,
            ansyuKihon.getJkipjytym());

        if (C_ErrorKbn.ERROR.eq(errorKbnHanteiyou)) {

            errorKbn = C_ErrorKbn.ERROR;

            errorMessage = "配当共通計算（解約）が実行できませんでした。";

            logger.debug("△ 解約精算金計算処理 終了");

            return errorKbn;
        }
        haitoukinYen = keisanDCommonKaiyaku.getDShrkn();
        tkbthaitoukinYen = keisanDCommonKaiyaku.getTkbtD();
        tmtthaitoukinYen = keisanDCommonKaiyaku.getTumitateDGanrikin();
        sonotahaitoukinYen = keisanDCommonKaiyaku.getKariwariateDGanrikinForDShrkn();
        C_NaiteiKakuteiKbn khHaitouKanriNaiteiKakuteiKbn = keisanDCommonKaiyaku.getKhHaitouKanriNaiteiKakuteiKbn();


        C_Segcd seg1cd = C_Segcd.BLNK;
        C_Segcd seg2cd = C_Segcd.BLNK;
        if (C_Tuukasyu.JPY.eq(kykSyouhn.getKyktuukasyu()) &&
            kykSyouhn.getYendthnkymd() != null) {
            List<IT_KhHenreikin> khHenreikinLst = hozenDomManager.getKhHenreikinYendtMbrsBySyono(syoNo);

            if (khHenreikinLst.size() > 0) {
                sonotaSeisan = khHenreikinLst.get(0).getHenreikingk();
                seg1cd = khHenreikinLst.get(0).getSeg1cd();
                seg2cd = khHenreikinLst.get(0).getSeg2cd();
            }
        }

        if (SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN == syohinHanteiKbn) {
            kaiyakuHrgoukeigk = kaiyakuHr.add(zennouseisankGk).add(mikeikapGk);
            kaiyakuHrgoukeiYen = kaiyakuHrYen.add(zennouSeisankYen).add(mikeikapYen);
            sonotaShrgkYen = azukariGanrikinYen.add(krkgkYen).add(haitoukinYen).add(tkbthaitoukinYen);

        }
        else {
            kaiyakuHrgoukeigk = kaiyakuHr.add(azukariGanrikingk);
            sonotaShrgkYen = zennouSeisankYen.add(mikeikapYen).add(
                azukariGanrikinYen).add(krkgkYen).add(haitoukinYen).add(tkbthaitoukinYen);

        }

        if (!C_Tuukasyu.JPY.eq(kykSyouhn.getKyktuukasyu())) {
            kaiyakuHrgoukeiYen = keisanGaikakanzan.exec(
                C_Tuukasyu.JPY,
                kaiyakuHrgoukeigk,
                pKeisanKaiyakuInBean.getYenshrkwsrate(),
                C_HasuusyoriKbn.AGE);

            if (!KINOUBUNRUI_DRCTSERVICE.equals(pKinouBunrui) ||
                pKeisanKaiyakuInBean.getGkshrkwsrate() != null) {
                sonotaShrgkgk = keisanGaikakanzan.execDivide(
                    kykSyouhn.getKyktuukasyu(),
                    sonotaShrgkYen,
                    pKeisanKaiyakuInBean.getGkshrkwsrate(),
                    C_HasuusyoriKbn.AGE);
            }

        }


        C_UmuKbn gsbunrikztaisyouFlg = C_UmuKbn.NONE;

        if (C_UmuKbn.ARI.eq(kykSyouhn.getGsbunritaisyou())) {
            if (KINOUBUNRUI_ONLINE.equals(pKinouBunrui)) {
                kaiyakujiyuu = pKeisanKaiyakuInBean.getKaiyakujiyuu();
            }

            if (C_Kaiyakujiyuu.KYKSB.eq(kaiyakujiyuu)) {
                sonotaShrgkKeisanKhGensen = sonotaShrgkYen;
            }
            else {
                sonotaShrgkKeisanKhGensen = sonotaShrgkYen.subtract(krkgkYen);
            }


            KeisanKhGensen keisanKhGensen = SWAKInjector.getInstance(KeisanKhGensen.class);


            errorKbnHanteiyou = keisanKhGensen.exec(
                syoNo,
                kykSyouhn.getKyktuukasyu(),
                C_UmuKbn.NONE,
                kaiyakuHrgoukeigk,
                sonotaShrgkKeisanKhGensen,
                pKeisanKaiyakuInBean.getKaiykymd());

            if (C_ErrorKbn.ERROR.eq(errorKbnHanteiyou)) {

                errorKbn = C_ErrorKbn.ERROR;

                errorMessage = "源泉徴収額計算が実行できませんでした。";

                logger.debug("△ 解約精算金計算処理 終了");

                return errorKbn;
            }
            C_UmuKbn gsBunriTaisyouGaika = keisanKhGensen.getGsBunriTaisyou();
            gensen = keisanKhGensen.getGensen();
            gaikaShrYenGsTsZeigk = keisanKhGensen.getYenGensen();
            gaikaShrYenGsTsZeigkKokuz = keisanKhGensen.getYenGsTszeiGkKokuz();
            gaikaShrYenGsTsZeigkTihouz = keisanKhGensen.getYenGsTszeiGkTihouz();
            gaikaGsBunriTaisyouFlag = keisanKhGensen.getGsBunriTaisyou();
            gaikaShrYenGsTsTaisyouSaeki = keisanKhGensen.getYenKztGk();
            gaikaShrYenHtyKeihi = keisanKhGensen.getYenHtyKeihi();
            zeimuRatesyutokukekkaKbn = keisanKhGensen.getRateSyutokuKekkaKbn();
            zeimuRatesyutokuYmd = keisanKhGensen.getRatesyutokuYmd();
            zeimukwsrate = keisanKhGensen.getKawaseRate();
            gensengkYenkaiyakuhr = keisanKhGensen.getYenW();


            BizCurrency kaiyakuHrPam;
            if (!C_Tuukasyu.JPY.eq(kykSyouhn.getKyktuukasyu())) {
                kaiyakuHrPam = kaiyakuHrgoukeiYen;
            } else {
                kaiyakuHrPam = kaiyakuHr;
            }

            errorKbnHanteiyou = keisanKhGensen.exec(
                syoNo,
                kykSyouhn.getKyktuukasyu(),
                C_UmuKbn.ARI,
                kaiyakuHrPam,
                sonotaShrgkKeisanKhGensen,
                pKeisanKaiyakuInBean.getKaiykymd());

            if (C_ErrorKbn.ERROR.eq(errorKbnHanteiyou)) {
                errorKbn = C_ErrorKbn.ERROR;

                errorMessage = "源泉徴収額計算が実行できませんでした。";

                logger.debug("△ 解約精算金計算処理 終了");

                return errorKbn;
            }

            C_UmuKbn gsBunriTaisyouYen = keisanKhGensen.getGsBunriTaisyou();
            yenGensen = keisanKhGensen.getYenGensen();
            jpyShrjiYengstszeigkKokuz = keisanKhGensen.getYenGsTszeiGkKokuz();
            jpyShrjiYengstszeigkTihouz = keisanKhGensen.getYenGsTszeiGkTihouz();
            jpyShrjiGsbunritaisyou = keisanKhGensen.getGsBunriTaisyou();
            jpyKaShrYenGsTsTaisyouSaeki = keisanKhGensen.getYenKztGk();
            jpyShrjiYenhtykeihi = keisanKhGensen.getYenHtyKeihi();

            if (!KINOUBUNRUI_ONLINE.equals(pKinouBunrui)) {
                gsbunrikztaisyouFlg = setGsbunrikztaisyouFlg(C_UmuKbn.ARI,
                    gsBunriTaisyouYen,
                    gsBunriTaisyouGaika,
                    kykSyouhn.getKyktuukasyu());
            }
        }


        if (C_Tuukasyu.JPY.eq(kykSyouhn.getKyktuukasyu()) &&
            kykSyouhn.getYendthnkymd() != null) {
            shrgkkeigk = yendthnkKaiyakuhr.add(sonotaSeisan).add(haitoukinYen).add(tkbthaitoukinYen).subtract(yenGensen);
            shrgkkeiYen = yendthnkKaiyakuhr.add(sonotaSeisan).add(haitoukinYen).add(tkbthaitoukinYen).subtract(yenGensen);
        }
        else {
            shrgkkeigk = sonotaShrgkgk.add(kaiyakuHrgoukeigk).subtract(gensen);
            shrgkkeiYen = kaiyakuHrgoukeiYen.add(sonotaShrgkYen).subtract(yenGensen);
        }
        keisanKaiyakuOutBean = new KeisanCommonKaiyakuOutBean();
        keisanKaiyakuOutBean.setShrgkkeigk(shrgkkeigk);
        keisanKaiyakuOutBean.setShrgkkeiYen(shrgkkeiYen);
        keisanKaiyakuOutBean.setSonotashrgkgk(sonotaShrgkgk);
        keisanKaiyakuOutBean.setSonotashrgkYen(sonotaShrgkYen);
        keisanKaiyakuOutBean.setKaiyakuhrgoukeigk(kaiyakuHrgoukeigk);
        keisanKaiyakuOutBean.setKaiyakuhrgoukeiYen(kaiyakuHrgoukeiYen);
        keisanKaiyakuOutBean.setKaiyakuHr(kaiyakuHr);
        keisanKaiyakuOutBean.setKaiyakuHrYen(kaiyakuHrYen);
        keisanKaiyakuOutBean.setYendthnkkaiyakuhr(yendthnkKaiyakuhr);
        keisanKaiyakuOutBean.setPtumitatekin(keisanW.getV());
        keisanKaiyakuOutBean.setSjkkkTyouseiGk(keisanW.getSjkkktyouseigk());
        keisanKaiyakuOutBean.setSjkkkTyouseiRitu(keisanW.getSjkkktyouseiritu());
        keisanKaiyakuOutBean.setKaiyakusjkkktyouseiriritu(keisanWExt.getKeisanWExtBean().getKaiyakusjkkktyouseiriritu());
        keisanKaiyakuOutBean.setTeiriTutmttKngk(keisanW.getTeirituTmttkngk());
        keisanKaiyakuOutBean.setSisuuRendouTmttKngkl(keisanW.getSisuurendouTmttkngk());
        keisanKaiyakuOutBean.setKaiyakuKjgk(keisanW.getKaiyakukjgk());
        keisanKaiyakuOutBean.setKaiyakuKjRitu(keisanW.getKaiyakukjritu());
        keisanKaiyakuOutBean.setFiSiyouKbn(keisanW.getFiSiyouKbn());
        keisanKaiyakuOutBean.setZennouseisankGk(zennouseisankGk);
        keisanKaiyakuOutBean.setZennouseisankYen(zennouSeisankYen);
        keisanKaiyakuOutBean.setMikeikapGk(mikeikapGk);
        keisanKaiyakuOutBean.setMikeikapYen(mikeikapYen);
        keisanKaiyakuOutBean.setMikeikaPjyutouYm(mikeikaPjyutouYm);
        keisanKaiyakuOutBean.setMikeikaPJyutouKaisuuY(mikeikaPJyutouKaisuuY);
        keisanKaiyakuOutBean.setMikeikaPJyutouKaisuuM(mikeikaPJyutouKaisuuM);
        keisanKaiyakuOutBean.setMiKeikaPBeans(miKeikaPBeans);
        keisanKaiyakuOutBean.setAzukariGanrikingk(azukariGanrikingk);
        keisanKaiyakuOutBean.setAzukariGanrikinYen(azukariGanrikinYen);
        keisanKaiyakuOutBean.setKrkgkYen(krkgkYen);
        keisanKaiyakuOutBean.setHaitoukinYen(haitoukinYen);
        keisanKaiyakuOutBean.setYentkbthaitoukin(tkbthaitoukinYen);
        keisanKaiyakuOutBean.setTmtthaitoukinYen(tmtthaitoukinYen);
        keisanKaiyakuOutBean.setSonotahaitoukinYen(sonotahaitoukinYen);
        keisanKaiyakuOutBean.setSonotaseisan(sonotaSeisan);
        keisanKaiyakuOutBean.setSegcdOne(seg1cd);
        keisanKaiyakuOutBean.setSegcdTwo(seg2cd);
        keisanKaiyakuOutBean.setGstszeigk(gensen);
        keisanKaiyakuOutBean.setGaikaShrYenGsTsZeigk(gaikaShrYenGsTsZeigk);
        keisanKaiyakuOutBean.setGaikaShrYenGsTsZeigkKokuz(gaikaShrYenGsTsZeigkKokuz);
        keisanKaiyakuOutBean.setGaikaShrYenGsTsZeigkTihouz(gaikaShrYenGsTsZeigkTihouz);
        keisanKaiyakuOutBean.setGaikaGsBunriTaisyouFlag(gaikaGsBunriTaisyouFlag);
        keisanKaiyakuOutBean.setGaikaShrYenGsTsTaisyouSaeki(gaikaShrYenGsTsTaisyouSaeki);
        keisanKaiyakuOutBean.setGaikaShrYenHtyKeihi(gaikaShrYenHtyKeihi);
        keisanKaiyakuOutBean.setZeimuRatesyutokukekkaKbn(zeimuRatesyutokukekkaKbn);
        keisanKaiyakuOutBean.setZeimuRatesyutokuYmd(zeimuRatesyutokuYmd);
        keisanKaiyakuOutBean.setZeimukwsrate(zeimukwsrate);
        keisanKaiyakuOutBean.setGensengkYenkaiyakuhr(gensengkYenkaiyakuhr);
        keisanKaiyakuOutBean.setJpygstszeigk(yenGensen);
        keisanKaiyakuOutBean.setJpyShrjiYengstszeigkKokuz(jpyShrjiYengstszeigkKokuz);
        keisanKaiyakuOutBean.setJpyShrjiYengstszeigkTihouz(jpyShrjiYengstszeigkTihouz);
        keisanKaiyakuOutBean.setJpyGsBunriTaisyouFlag(jpyShrjiGsbunritaisyou);
        keisanKaiyakuOutBean.setJpykaShrYenGsTsTaisyouSaeki(jpyKaShrYenGsTsTaisyouSaeki);
        keisanKaiyakuOutBean.setJpyShrjiYenhtykeihi(jpyShrjiYenhtykeihi);
        keisanKaiyakuOutBean.setGsbunritaisyouFlg(gsbunrikztaisyouFlg);
        keisanKaiyakuOutBean.setLastpjytoymi(lastpjytoym);
        keisanKaiyakuOutBean.setZennoumijyuutouFlg(zennoumijyuutouFlg);
        keisanKaiyakuOutBean.setKhHaitouKanriNaiteiKakuteiKbn(khHaitouKanriNaiteiKakuteiKbn);
        keisanKaiyakuOutBean.setEditDshrTukiDKoumokuBean(keisanDCommonKaiyaku.getEditDshrTukiDKoumokuBean());

        logger.debug("△ 解約精算金計算処理 終了");

        return errorKbn;
    }

    public C_ErrorKbn keisanZeimuinfo(String pKinouBunrui, IT_KykKihon pKykKihon, BizDate pSyoriYmd,
        C_Tuukasyu pShrTuukasyu, C_Kaiyakujiyuu pKaiyakujiyuu,
        KeisanKaiyakuBean pKeisanKaiyakuInBean, KeisanCommonKaiyakuOutBean pKeisanKaiyakuOutBean) {

        logger.debug("▽ 税務情報計算処理 開始");

        C_ErrorKbn errorKbn = C_ErrorKbn.OK;
        String syoNo = pKykKihon.getSyono();
        BizCurrency synyknGk = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        BizCurrency htyKeihi = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        int kykhnkKaisuu = 0;
        BizCurrency yenshrkykhtyKeihi = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

        List<IT_KykSyouhn> kykSyouhnList = pKykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        IT_KykSyouhn kykSyouhn = kykSyouhnList.get(0);

        keisanKaiyakuOutBean = pKeisanKaiyakuOutBean;

        if (C_Tuukasyu.JPY.eq(kykSyouhn.getKyktuukasyu())) {
            if (C_Kaiyakujiyuu.KYKSB.eq(pKaiyakujiyuu)) {
                synyknGk = keisanKaiyakuOutBean.getKaiyakuhrgoukeiYen()
                    .add(keisanKaiyakuOutBean.getSonotaseisan())
                    .add(keisanKaiyakuOutBean.getHaitoukinYen())
                    .add(keisanKaiyakuOutBean.getYentkbthaitoukin())
                    .add(keisanKaiyakuOutBean.getKrkgkYen());
            }
            else {
                synyknGk = keisanKaiyakuOutBean.getKaiyakuhrgoukeiYen()
                    .add(keisanKaiyakuOutBean.getHaitoukinYen())
                    .add(keisanKaiyakuOutBean.getYentkbthaitoukin());
            }
        }

        else  {
            if (C_Tuukasyu.JPY.eq(pShrTuukasyu)) {
                if (C_Kaiyakujiyuu.KYKSB.eq(pKaiyakujiyuu)) {
                    synyknGk = keisanKaiyakuOutBean.getKaiyakuhrgoukeiYen()
                        .add(keisanKaiyakuOutBean.getMikeikapYen())
                        .add(keisanKaiyakuOutBean.getZennouseisankYen())
                        .add(keisanKaiyakuOutBean.getAzukariGanrikinYen())
                        .add(keisanKaiyakuOutBean.getHaitoukinYen())
                        .add(keisanKaiyakuOutBean.getYentkbthaitoukin())
                        .add(keisanKaiyakuOutBean.getKrkgkYen());
                }
                else {
                    synyknGk = keisanKaiyakuOutBean.getKaiyakuhrgoukeiYen()
                        .add(keisanKaiyakuOutBean.getMikeikapYen())
                        .add(keisanKaiyakuOutBean.getZennouseisankYen())
                        .add(keisanKaiyakuOutBean.getAzukariGanrikinYen())
                        .add(keisanKaiyakuOutBean.getHaitoukinYen())
                        .add(keisanKaiyakuOutBean.getYentkbthaitoukin());
                }
            }
            else {
                KeisanGaikakanzan keisanGaikakanzan= SWAKInjector.getInstance(KeisanGaikakanzan.class);
                BizCurrency kanzanGaku = keisanGaikakanzan.exec(C_Tuukasyu.JPY,
                    keisanKaiyakuOutBean.getKaiyakuHr().add(keisanKaiyakuOutBean.getMikeikapGk())
                    .add(keisanKaiyakuOutBean.getZennouseisankGk()).add(keisanKaiyakuOutBean.getAzukariGanrikingk())
                    ,
                    keisanKaiyakuOutBean.getZeimukwsrate(),
                    C_HasuusyoriKbn.SUTE);

                if (C_Kaiyakujiyuu.KYKSB.eq(pKaiyakujiyuu)) {
                    synyknGk = kanzanGaku
                        .add(keisanKaiyakuOutBean.getMikeikapYen())
                        .add(keisanKaiyakuOutBean.getZennouseisankYen())
                        .add(keisanKaiyakuOutBean.getAzukariGanrikinYen())
                        .add(keisanKaiyakuOutBean.getHaitoukinYen())
                        .add(keisanKaiyakuOutBean.getYentkbthaitoukin())
                        .add(keisanKaiyakuOutBean.getKrkgkYen());
                }
                else {
                    synyknGk = kanzanGaku
                        .add(keisanKaiyakuOutBean.getMikeikapYen())
                        .add(keisanKaiyakuOutBean.getZennouseisankYen())
                        .add(keisanKaiyakuOutBean.getAzukariGanrikinYen())
                        .add(keisanKaiyakuOutBean.getHaitoukinYen())
                        .add(keisanKaiyakuOutBean.getYentkbthaitoukin());
                }
            }
        }

        KeisanHtyKeihi keisanHtyKeihi = SWAKInjector.getInstance(KeisanHtyKeihi.class);
        keisanHtyKeihi.exec(syoNo, kykSyouhn.getKyktuukasyu());

        if (C_UmuKbn.ARI.eq(keisanKaiyakuOutBean.getGsbunritaisyouFlg())) {
            if (C_Tuukasyu.JPY.eq(pShrTuukasyu)) {
                htyKeihi = keisanKaiyakuOutBean.getJpyShrjiYenhtykeihi();
            }
            else {
                htyKeihi = keisanKaiyakuOutBean.getGaikaShrYenHtyKeihi();
            }
        }
        else {
            htyKeihi = keisanHtyKeihi.getYenHtyKeihi();

        }
        kykhnkKaisuu = keisanHtyKeihi.getKykSyaHenkouKaisuu();

        if (keisanHtyKeihi.getKykSyaHenkouKaisuu() > 0) {
            yenshrkykhtyKeihi = keisanHtyKeihi.getYenGenKykSyaHtyKeihi();
        }

        keisanKaiyakuOutBean.setSynykngk(synyknGk);
        keisanKaiyakuOutBean.setHtykeihi(htyKeihi);
        keisanKaiyakuOutBean.setKykhnkkaisuu(kykhnkKaisuu);
        keisanKaiyakuOutBean.setYenShrKykHtyKeihi(yenshrkykhtyKeihi);

        if (C_Tuukasyu.JPY.eq(pShrTuukasyu)) {
            keisanKaiyakuOutBean.setYengstszeigk(keisanKaiyakuOutBean.getJpygstszeigk());
            keisanKaiyakuOutBean.setYengststaisyousaeki(keisanKaiyakuOutBean.getJpykaShrYenGsTsTaisyouSaeki());
        }
        else {
            keisanKaiyakuOutBean.setYengstszeigk(keisanKaiyakuOutBean.getGaikaShrYenGsTsZeigk());
            keisanKaiyakuOutBean.setYengststaisyousaeki(keisanKaiyakuOutBean.getGaikaShrYenGsTsTaisyouSaeki());
        }

        logger.debug("△ 税務情報計算処理 終了");

        return errorKbn;
    }

    public C_UmuKbn setGsbunrikztaisyouFlg(C_UmuKbn pYenshrtkUmu, C_UmuKbn pJpyGsBunriTaisyouFlag,
        C_UmuKbn pGaikaGsBunriTaisyouFlag, C_Tuukasyu pKykTuukasyu) {

        C_UmuKbn gsbunrikztaisyouFlg;

        if ((C_UmuKbn.ARI.eq(pYenshrtkUmu) && C_UmuKbn.ARI.eq(pJpyGsBunriTaisyouFlag)) ||
            (C_UmuKbn.NONE.eq(pYenshrtkUmu) && C_UmuKbn.ARI.eq(pGaikaGsBunriTaisyouFlag)) ||
            (C_Tuukasyu.JPY.eq(pKykTuukasyu) && C_UmuKbn.ARI.eq(pJpyGsBunriTaisyouFlag))) {
            gsbunrikztaisyouFlg = C_UmuKbn.ARI;
        }
        else {
            gsbunrikztaisyouFlg = C_UmuKbn.NONE;
        }

        return gsbunrikztaisyouFlg;
    }
}
