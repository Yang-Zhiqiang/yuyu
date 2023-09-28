package yuyu.common.biz.bzdairiten;

import java.math.BigDecimal;

import javax.inject.Inject;

import jp.co.slcs.swak.core.configuration.CoreConfig;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.file.util.FixedlengthConvertUtil;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.CurrencyType;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BzKbnHenkanUtil;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.bzcommon.KbnInfoBean;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.sinkeiyaku.skcommon.EditPalRenkeiKoumoku;
import yuyu.def.biz.bean.mq.BzMqDairitenTesuuryouInfoSyutokuKekkaBean;
import yuyu.def.biz.bean.mq.BzMqDairitenTesuuryouInfoSyutokuYokenBean;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_MQSyorikekkaKbn;
import yuyu.def.classification.C_SystemRenkeiHenkanHoukouKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.infrext.exception.MqFailedException;
import yuyu.infrext.mq.MqApiCaller;

import com.google.common.base.Strings;

/**
 * 業務共通 代理店 代理店手数料情報取得
 */
public class DairitenTesuuryouInfoSyutoku {

    private static final String SYORICD = "PAS4";

    private static final String KUGIRIHUGO = ".";

    private CurrencyType kykTuukaType;

    private CurrencyType hrkTuukaType;

    private boolean dairitenTesuuryouSyutoku;

    private boolean keijouYmSyutoku;

    @Inject
    private static Logger logger;

    @Inject
    private CoreConfig coreConfig;

    @Inject
    private MqApiCaller mqApiCaller;

    public DairitenTesuuryouInfoSyutoku() {
        super();
    }

    public DairitenTesuuryouInfoSyutokuKekkaBean exec(DairitenTsrSyutokuYokenBean pDairitenTsrSyutokuYokenBean,
        KeijouYmSyutokuYokenBean pKeijouYmSyutokuYokenBean) {

        logger.debug("▽ 代理店手数料情報取得 開始");

        DairitenTesuuryouInfoSyutokuKekkaBean dairitenTesuuryouInfoSyutokuKekkaBean = SWAKInjector.getInstance(
            DairitenTesuuryouInfoSyutokuKekkaBean.class);

        BzMqDairitenTesuuryouInfoSyutokuYokenBean bzMqDairitenTesuuryouInfoSyutokuYokenBean = SWAKInjector.getInstance(
            BzMqDairitenTesuuryouInfoSyutokuYokenBean.class);

        dairitenTesuuryouInfoSyutokuKekkaBean.setSyotsryGkYen(BizCurrency.valueOf(0));
        dairitenTesuuryouInfoSyutokuKekkaBean.setSyotsryGkKykTuuka(BizCurrency.valueOf(0));
        dairitenTesuuryouInfoSyutokuKekkaBean.setJitsryGkYen(BizCurrency.valueOf(0));
        dairitenTesuuryouInfoSyutokuKekkaBean.setJitsryGkKykTuuka(BizCurrency.valueOf(0));
        dairitenTesuuryouInfoSyutokuKekkaBean.setSyotsryRuiGkYen(BizCurrency.valueOf(0));
        dairitenTesuuryouInfoSyutokuKekkaBean.setSyotsryRuiGkGaika(BizCurrency.valueOf(0));
        dairitenTesuuryouInfoSyutokuKekkaBean.setJitsryruiGkYen(BizCurrency.valueOf(0));
        dairitenTesuuryouInfoSyutokuKekkaBean.setJitsryruiGkGaika(BizCurrency.valueOf(0));
        dairitenTesuuryouInfoSyutokuKekkaBean.setSoutsryGkYen(BizCurrency.valueOf(0));
        dairitenTesuuryouInfoSyutokuKekkaBean.setSoutsryGkGaika(BizCurrency.valueOf(0));

        bzMqDairitenTesuuryouInfoSyutokuYokenBean.setIwsSyoricd(SYORICD);
        bzMqDairitenTesuuryouInfoSyutokuYokenBean.setIwsKugirihugou(KUGIRIHUGO);
        bzMqDairitenTesuuryouInfoSyutokuYokenBean.setIwsTsrsisanhyouji("0");
        bzMqDairitenTesuuryouInfoSyutokuYokenBean.setIwsKeijyouymsyoukaihyouji("0");
        bzMqDairitenTesuuryouInfoSyutokuYokenBean.setIwsDrtencd("");
        bzMqDairitenTesuuryouInfoSyutokuYokenBean.setIwsAtkiwari("100");
        bzMqDairitenTesuuryouInfoSyutokuYokenBean.setIwsDairitenatkinin("1");
        bzMqDairitenTesuuryouInfoSyutokuYokenBean.setIwsHknsyukigoutesuuryou("");
        bzMqDairitenTesuuryouInfoSyutokuYokenBean.setIwsHokensyuruikigousedaikbn("");
        bzMqDairitenTesuuryouInfoSyutokuYokenBean.setIwsHknsykguybi1x1(" ");
        bzMqDairitenTesuuryouInfoSyutokuYokenBean.setIwsHknsykguybi1x2(" ");
        bzMqDairitenTesuuryouInfoSyutokuYokenBean.setIwsHknsykguybi1x3(" ");
        bzMqDairitenTesuuryouInfoSyutokuYokenBean.setIwsHknsykguybi1x4(" ");
        bzMqDairitenTesuuryouInfoSyutokuYokenBean.setIwsHknsykguybi1x5(" ");
        bzMqDairitenTesuuryouInfoSyutokuYokenBean.setIwsHknsykguybi1x6(" ");
        bzMqDairitenTesuuryouInfoSyutokuYokenBean.setIwsHknsykguybi1x7(" ");
        bzMqDairitenTesuuryouInfoSyutokuYokenBean.setIwsHknsykguybi1x8(" ");
        bzMqDairitenTesuuryouInfoSyutokuYokenBean.setIwsHknsykguybi1x9(" ");
        bzMqDairitenTesuuryouInfoSyutokuYokenBean.setIwsHknsykguybi1x10(" ");
        bzMqDairitenTesuuryouInfoSyutokuYokenBean.setIwsHknsykguybi1x11(" ");
        bzMqDairitenTesuuryouInfoSyutokuYokenBean.setIwsHknsykguybi1x12(" ");
        bzMqDairitenTesuuryouInfoSyutokuYokenBean.setIwsHknsykguybi1x13(" ");
        bzMqDairitenTesuuryouInfoSyutokuYokenBean.setIwsHknsykguybi1x14(" ");
        bzMqDairitenTesuuryouInfoSyutokuYokenBean.setIwsHknsykguybi1x15(" ");
        bzMqDairitenTesuuryouInfoSyutokuYokenBean.setIwsHknsykguybi2x1(" ");
        bzMqDairitenTesuuryouInfoSyutokuYokenBean.setIwsHknsykguybi2x2(" ");
        bzMqDairitenTesuuryouInfoSyutokuYokenBean.setIwsHknsykguybi2x3(" ");
        bzMqDairitenTesuuryouInfoSyutokuYokenBean.setIwsHknsykguybi2x4(" ");
        bzMqDairitenTesuuryouInfoSyutokuYokenBean.setIwsHknsykguybi2x5(" ");
        bzMqDairitenTesuuryouInfoSyutokuYokenBean.setIwsHknsykguybi2x6(" ");
        bzMqDairitenTesuuryouInfoSyutokuYokenBean.setIwsHknsykguybi2x7(" ");
        bzMqDairitenTesuuryouInfoSyutokuYokenBean.setIwsHknsykguybi2x8(" ");
        bzMqDairitenTesuuryouInfoSyutokuYokenBean.setIwsHknsykguybi2x9(" ");
        bzMqDairitenTesuuryouInfoSyutokuYokenBean.setIwsHknsykguybi2x10(" ");
        bzMqDairitenTesuuryouInfoSyutokuYokenBean.setIwsHknsykguybi3x1(" ");
        bzMqDairitenTesuuryouInfoSyutokuYokenBean.setIwsHknsykguybi3x2(" ");
        bzMqDairitenTesuuryouInfoSyutokuYokenBean.setIwsHknsykguybi3x3(" ");
        bzMqDairitenTesuuryouInfoSyutokuYokenBean.setIwsHknsykguybi3x4(" ");
        bzMqDairitenTesuuryouInfoSyutokuYokenBean.setIwsHknsykguybi3x5(" ");
        bzMqDairitenTesuuryouInfoSyutokuYokenBean.setIwsHknsykguybi3x6(" ");
        bzMqDairitenTesuuryouInfoSyutokuYokenBean.setIwsHknsykguybi3x7(" ");
        bzMqDairitenTesuuryouInfoSyutokuYokenBean.setIwsHknsykguybi3x8(" ");
        bzMqDairitenTesuuryouInfoSyutokuYokenBean.setIwsHknsykguybi3x9(" ");
        bzMqDairitenTesuuryouInfoSyutokuYokenBean.setIwsHknsykguybi3x10(" ");
        bzMqDairitenTesuuryouInfoSyutokuYokenBean.setIwsCalckijyunymd1("");
        bzMqDairitenTesuuryouInfoSyutokuYokenBean.setIwsCalckijyunymd2("");
        bzMqDairitenTesuuryouInfoSyutokuYokenBean.setIwsCalckijyunymd3("");
        bzMqDairitenTesuuryouInfoSyutokuYokenBean.setIwsHaraikomikaisuukbn("0");
        bzMqDairitenTesuuryouInfoSyutokuYokenBean.setIwsSaimankikeiyakuhyouji("0");
        bzMqDairitenTesuuryouInfoSyutokuYokenBean.setIwsHhknnen2keta("");
        bzMqDairitenTesuuryouInfoSyutokuYokenBean.setIwsHknkkn("99");
        bzMqDairitenTesuuryouInfoSyutokuYokenBean.setIwsPharaikomikikan("00");
        bzMqDairitenTesuuryouInfoSyutokuYokenBean.setIwsSyup("");
        bzMqDairitenTesuuryouInfoSyutokuYokenBean.setIwsDrtentsryhushrkykhyouji("0");
        bzMqDairitenTesuuryouInfoSyutokuYokenBean.setIwsTkykwsrate("");
        bzMqDairitenTesuuryouInfoSyutokuYokenBean.setIwsTuukasyukbn("1");
        bzMqDairitenTesuuryouInfoSyutokuYokenBean.setIwsYoteiriritu("");
        bzMqDairitenTesuuryouInfoSyutokuYokenBean.setIwsSyupHrktuuka("");
        bzMqDairitenTesuuryouInfoSyutokuYokenBean.setIwsHrktuukasyu("1");
        bzMqDairitenTesuuryouInfoSyutokuYokenBean.setIwsIkkatubaraikbn("0");
        bzMqDairitenTesuuryouInfoSyutokuYokenBean.setIwsIkkatubaraikaisuu("00");
        bzMqDairitenTesuuryouInfoSyutokuYokenBean.setIwsKihons11keta("");
        bzMqDairitenTesuuryouInfoSyutokuYokenBean.setIwsYobiv25("");
        bzMqDairitenTesuuryouInfoSyutokuYokenBean.setIwsBsydrtencd("");
        bzMqDairitenTesuuryouInfoSyutokuYokenBean.setIwsHknsyukigoukeijyouym("");
        bzMqDairitenTesuuryouInfoSyutokuYokenBean.setIwsKokutiymd("");
        bzMqDairitenTesuuryouInfoSyutokuYokenBean.setIwsSyokaipryosyuuymd("");
        bzMqDairitenTesuuryouInfoSyutokuYokenBean.setIwsMosymdstr("");
        bzMqDairitenTesuuryouInfoSyutokuYokenBean.setIwsMossyoumetukbn("0");
        bzMqDairitenTesuuryouInfoSyutokuYokenBean.setIwsMossyoumetukktiymd("");
        bzMqDairitenTesuuryouInfoSyutokuYokenBean.setIwsBosyuuymstr("");
        bzMqDairitenTesuuryouInfoSyutokuYokenBean.setIwsYobiv39("");
        dairitenTesuuryouSyutoku = false;
        keijouYmSyutoku = false;

        if (pDairitenTsrSyutokuYokenBean == null && pKeijouYmSyutokuYokenBean == null) {

            logger.debug("△ 代理店手数料情報取得 param null");

            return dairitenTesuuryouInfoSyutokuKekkaBean;
        }

        if (coreConfig.isBatchProduct()) {

            logger.debug("△ 代理店手数料情報取得 バッチ判定 = true");

            return dairitenTesuuryouInfoSyutokuKekkaBean;
        }

        if (pDairitenTsrSyutokuYokenBean != null) {

            dairitenTesuuryouSyutoku = true;

            setDairitenTsrSyutokuYoken(pDairitenTsrSyutokuYokenBean, bzMqDairitenTesuuryouInfoSyutokuYokenBean);
        }

        if (pKeijouYmSyutokuYokenBean != null) {

            keijouYmSyutoku = true;

            setKeijouYmSyutokuYoken(pKeijouYmSyutokuYokenBean, bzMqDairitenTesuuryouInfoSyutokuYokenBean);
        }

        String bzMqDairitenTesuuryouInfoSyutokuYokenMojiretsu = FixedlengthConvertUtil.beanToStringForFixedlength(
            bzMqDairitenTesuuryouInfoSyutokuYokenBean);

        try {
            bzMqDairitenTesuuryouInfoSyutokuYokenMojiretsu = mqApiCaller.call(SYORICD, bzMqDairitenTesuuryouInfoSyutokuYokenMojiretsu);
            dairitenTesuuryouInfoSyutokuKekkaBean.setMqSyoriKekkaKbn(C_MQSyorikekkaKbn.SEIJYOU);
        }
        catch(MqFailedException e) {

            if (e.getMqFailStatus() == 1) {

                logger.debug("△ 代理店手数料情報取得 MqFailedException　MqFailStatus()　＝　1");

                return dairitenTesuuryouInfoSyutokuKekkaBean;
            }

            if (e.getMqFailStatus() == 2) {

                logger.debug("△ 代理店手数料情報取得 MqFailedException　MqFailStatus()　＝　2");

                return dairitenTesuuryouInfoSyutokuKekkaBean;
            }

            if (e.getMqFailStatus() == 3) {

                logger.debug("△ 代理店手数料情報取得 MqFailedException　MqFailStatus()　＝　3");

                return dairitenTesuuryouInfoSyutokuKekkaBean;
            }
        }

        String acsErrCd = bzMqDairitenTesuuryouInfoSyutokuYokenMojiretsu.substring(0, 4);

        if (!"0000".equals(acsErrCd)) {

            logger.debug("△ 代理店手数料情報取得 ＡＣＳ基盤エラー　： " +  acsErrCd);

            return dairitenTesuuryouInfoSyutokuKekkaBean;
        }

        dairitenTesuuryouInfoSyutokuKekkaBean.setAcsKibanKekkaKbn(C_ErrorKbn.OK);

        BzMqDairitenTesuuryouInfoSyutokuKekkaBean bzMqDairitenTesuuryouInfoSyutokuKekkaBean =
            FixedlengthConvertUtil.stringToBeanForFixedlength(bzMqDairitenTesuuryouInfoSyutokuYokenMojiretsu,
                BzMqDairitenTesuuryouInfoSyutokuKekkaBean.class);

        if (bzMqDairitenTesuuryouInfoSyutokuKekkaBean == null) {

            logger.debug("△ 代理店手数料情報取得 システム間変換処理エラー");

            return dairitenTesuuryouInfoSyutokuKekkaBean;
        }

        setDairitenTesuuryouInfoSyutokuKekka(bzMqDairitenTesuuryouInfoSyutokuKekkaBean, dairitenTesuuryouInfoSyutokuKekkaBean);

        logger.debug("△ 代理店手数料情報取得 終了");

        return dairitenTesuuryouInfoSyutokuKekkaBean;
    }

    private void setDairitenTsrSyutokuYoken(DairitenTsrSyutokuYokenBean pDairitenTsrSyutokuYokenBean,
        BzMqDairitenTesuuryouInfoSyutokuYokenBean pBzMqDairitenTesuuryouInfoSyutokuYokenBean) {

        String tuukaSyu = "0";
        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
        String ryourituSdNo = "0";
        BizNumber yenKnsnTekiRate = BizNumber.ZERO;
        String yenKnsnTekiRateStr = "000000";
        BizNumber yoteiRiritu = BizNumber.ZERO;
        String yoteiRirituStr = "00000";
        String syukykpStr = "00000000000";
        String syupHrktuukaStr = "00000000000";
        String kihonnSStr = "00000000000";

        String hrktuukasyu = "0";
        EditPalRenkeiKoumoku editPalRenkeiKoumoku =SWAKInjector.getInstance(EditPalRenkeiKoumoku.class);

        if (C_Tuukasyu.JPY.eq(pDairitenTsrSyutokuYokenBean.getSyuKeiyakuPTuukaSyu())) {

            tuukaSyu = "1";
        }
        else if (C_Tuukasyu.USD.eq(pDairitenTsrSyutokuYokenBean.getSyuKeiyakuPTuukaSyu())) {

            tuukaSyu = "2";
        }
        else if (C_Tuukasyu.EUR.eq(pDairitenTsrSyutokuYokenBean.getSyuKeiyakuPTuukaSyu())) {

            tuukaSyu = "3";
        }
        else if (C_Tuukasyu.AUD.eq(pDairitenTsrSyutokuYokenBean.getSyuKeiyakuPTuukaSyu())) {

            tuukaSyu = "4";
        }
        ryourituSdNo = pDairitenTsrSyutokuYokenBean.getRyourituSdNo().substring( pDairitenTsrSyutokuYokenBean.getRyourituSdNo().length() - 1);

        yenKnsnTekiRate = pDairitenTsrSyutokuYokenBean.getYenKnsnTekiRate().multiply(100);
        yenKnsnTekiRateStr = yenKnsnTekiRate.toString();
        yenKnsnTekiRateStr = Strings.padStart(yenKnsnTekiRateStr, 6, '0');

        yoteiRiritu = pDairitenTsrSyutokuYokenBean.getYoteiRiritu().multiply(10000);
        yoteiRirituStr = yoteiRiritu.toString();
        yoteiRirituStr = Strings.padStart(yoteiRirituStr, 5, '0');

        syukykpStr = pDairitenTsrSyutokuYokenBean.getSyuKeiyakuP().toAdsoluteString();
        syukykpStr = Strings.padStart(syukykpStr, 11, '0');

        syupHrktuukaStr = pDairitenTsrSyutokuYokenBean.getSyupHrktuuka().toAdsoluteString();
        syupHrktuukaStr = Strings.padStart(syupHrktuukaStr, 11, '0');

        kihonnSStr = pDairitenTsrSyutokuYokenBean.getKihonnS().toAdsoluteString();
        kihonnSStr = Strings.padStart(kihonnSStr, 11, '0');

        if (C_Tuukasyu.JPY.eq(pDairitenTsrSyutokuYokenBean.getHrktuukasyu())) {

            hrktuukasyu = "1";
        }
        else if (C_Tuukasyu.USD.eq(pDairitenTsrSyutokuYokenBean.getHrktuukasyu())) {

            hrktuukasyu = "2";
        }
        else if (C_Tuukasyu.EUR.eq(pDairitenTsrSyutokuYokenBean.getHrktuukasyu())) {

            hrktuukasyu = "3";
        }
        else if (C_Tuukasyu.AUD.eq(pDairitenTsrSyutokuYokenBean.getHrktuukasyu())) {

            hrktuukasyu = "4";
        }

        pBzMqDairitenTesuuryouInfoSyutokuYokenBean.setIwsTsrsisanhyouji("1");
        pBzMqDairitenTesuuryouInfoSyutokuYokenBean.setIwsDrtencd(pDairitenTsrSyutokuYokenBean.getOyaDrtenCd());
        pBzMqDairitenTesuuryouInfoSyutokuYokenBean.setIwsHknsyukigoutesuuryou(pDairitenTsrSyutokuYokenBean.getSyouhnCd());
        pBzMqDairitenTesuuryouInfoSyutokuYokenBean.setIwsHokensyuruikigousedaikbn(ryourituSdNo);
        pBzMqDairitenTesuuryouInfoSyutokuYokenBean.setIwsHaraikomikaisuukbn(editPalRendouKoumoku("払込回数区分",pDairitenTsrSyutokuYokenBean.getHrkKaisuu().toString(),C_Hrkkaisuu.class));
        pBzMqDairitenTesuuryouInfoSyutokuYokenBean.setIwsSaimankikeiyakuhyouji(editPalRendouKoumoku("保険期間歳満期区分",pDairitenTsrSyutokuYokenBean.getSaimankiKeiyakuHyouji(),C_HknkknsmnKbn.class));
        pBzMqDairitenTesuuryouInfoSyutokuYokenBean.setIwsHhknnen2keta(editPalRenkeiKoumoku.editHhknnen(Integer.parseInt(pDairitenTsrSyutokuYokenBean.getHhknNen())));
        pBzMqDairitenTesuuryouInfoSyutokuYokenBean.setIwsHknkkn(Strings.padStart(String.valueOf(  pDairitenTsrSyutokuYokenBean.getHknKkn() ), 2, '0'));
        pBzMqDairitenTesuuryouInfoSyutokuYokenBean.setIwsPharaikomikikan(Strings.padStart(String.valueOf(  pDairitenTsrSyutokuYokenBean.getpHaraikomiKikan() ), 2, '0'));
        pBzMqDairitenTesuuryouInfoSyutokuYokenBean.setIwsSyup(syukykpStr);
        pBzMqDairitenTesuuryouInfoSyutokuYokenBean.setIwsDrtentsryhushrkykhyouji(pDairitenTsrSyutokuYokenBean.getDrtenTsryHushrKykHyouji());
        pBzMqDairitenTesuuryouInfoSyutokuYokenBean.setIwsTkykwsrate(yenKnsnTekiRateStr);
        pBzMqDairitenTesuuryouInfoSyutokuYokenBean.setIwsTuukasyukbn(tuukaSyu);
        pBzMqDairitenTesuuryouInfoSyutokuYokenBean.setIwsCalckijyunymd1(pDairitenTsrSyutokuYokenBean.getCalckijyunymd().toString());
        pBzMqDairitenTesuuryouInfoSyutokuYokenBean.setIwsYoteiriritu(yoteiRirituStr);
        pBzMqDairitenTesuuryouInfoSyutokuYokenBean.setIwsSyupHrktuuka(syupHrktuukaStr);
        pBzMqDairitenTesuuryouInfoSyutokuYokenBean.setIwsHrktuukasyu(hrktuukasyu);
        pBzMqDairitenTesuuryouInfoSyutokuYokenBean.setIwsIkkatubaraikbn(
            pDairitenTsrSyutokuYokenBean.getIkkatubaraikbn().getValue());
        pBzMqDairitenTesuuryouInfoSyutokuYokenBean.setIwsIkkatubaraikaisuu(
            Strings.padStart(pDairitenTsrSyutokuYokenBean.getIkkatubaraikaisuu().getValue(), 2, '0'));
        pBzMqDairitenTesuuryouInfoSyutokuYokenBean.setIwsKihons11keta(kihonnSStr);

        kykTuukaType = henkanTuuka.henkanTuukaKbnToType(pDairitenTsrSyutokuYokenBean.getSyuKeiyakuPTuukaSyu());

        hrkTuukaType = henkanTuuka.henkanTuukaKbnToType(pDairitenTsrSyutokuYokenBean.getHrktuukasyu());

    }

    private void setKeijouYmSyutokuYoken(KeijouYmSyutokuYokenBean pKeijouYmSyutokuYokenBean,
        BzMqDairitenTesuuryouInfoSyutokuYokenBean pBzMqDairitenTesuuryouInfoSyutokuYokenBean) {

        String kokutiYmd = "";
        String syokaiPRyosyuuYmd = "";
        String mosSyumtKktYmd = "";

        if (pKeijouYmSyutokuYokenBean.getKokutiymd() != null) {

            kokutiYmd = pKeijouYmSyutokuYokenBean.getKokutiymd().toString();
        }

        if (pKeijouYmSyutokuYokenBean.getSyokaiPRyosyuuYmd() != null) {

            syokaiPRyosyuuYmd = pKeijouYmSyutokuYokenBean.getSyokaiPRyosyuuYmd().toString();
        }

        if (!"0".equals(pKeijouYmSyutokuYokenBean.getMosSyoumetuKbn())) {

            mosSyumtKktYmd = pKeijouYmSyutokuYokenBean.getMosSyumtKktYmd().toString();
        }

        pBzMqDairitenTesuuryouInfoSyutokuYokenBean.setIwsKeijyouymsyoukaihyouji("1");
        pBzMqDairitenTesuuryouInfoSyutokuYokenBean.setIwsBsydrtencd(pKeijouYmSyutokuYokenBean.getTratkiagCd());
        pBzMqDairitenTesuuryouInfoSyutokuYokenBean.setIwsHknsyukigoukeijyouym(pKeijouYmSyutokuYokenBean.getSyouhnCd());
        pBzMqDairitenTesuuryouInfoSyutokuYokenBean.setIwsKokutiymd(kokutiYmd);
        pBzMqDairitenTesuuryouInfoSyutokuYokenBean.setIwsSyokaipryosyuuymd(syokaiPRyosyuuYmd);
        pBzMqDairitenTesuuryouInfoSyutokuYokenBean.setIwsMosymdstr(pKeijouYmSyutokuYokenBean.getMosYmd().toString());
        pBzMqDairitenTesuuryouInfoSyutokuYokenBean.setIwsMossyoumetukbn(pKeijouYmSyutokuYokenBean.getMosSyoumetuKbn());
        pBzMqDairitenTesuuryouInfoSyutokuYokenBean.setIwsMossyoumetukktiymd(mosSyumtKktYmd);
        pBzMqDairitenTesuuryouInfoSyutokuYokenBean.setIwsBosyuuymstr(pKeijouYmSyutokuYokenBean.getBosyuuYm().toString());
    }

    private void setDairitenTesuuryouInfoSyutokuKekka(BzMqDairitenTesuuryouInfoSyutokuKekkaBean
        pBzMqDairitenTesuuryouInfoSyutokuKekkaBean, DairitenTesuuryouInfoSyutokuKekkaBean pDairitenTesuuryouInfoSyutokuKekkaBean) {

        C_ErrorKbn tsrSisanKekkaKbn = C_ErrorKbn.ERROR;

        if ("0".equals(pBzMqDairitenTesuuryouInfoSyutokuKekkaBean.getIwsTsrsisankekkakbn())) {

            tsrSisanKekkaKbn = C_ErrorKbn.OK;
        }

        C_ErrorKbn keijyouYmSyoukaiKekkaKbn = C_ErrorKbn.ERROR;

        if ("0".equals(pBzMqDairitenTesuuryouInfoSyutokuKekkaBean.getIwsKeijyouymsyoukaikekkakbn())) {

            keijyouYmSyoukaiKekkaKbn = C_ErrorKbn.OK;
        }

        BizCurrency syotsryGkYen = BizCurrency.valueOf(0);
        BizCurrency syotsryGkKykTuuka = BizCurrency.valueOf(0);
        BizCurrency jitsryGkYen = BizCurrency.valueOf(0);
        BizCurrency jitsryGkKykTuuka = BizCurrency.valueOf(0);
        BizCurrency syotsryRuiGkYen = BizCurrency.valueOf(0);
        BizCurrency syotsryRuiGkGaika = BizCurrency.valueOf(0);
        BizCurrency jitsryruiGkYen = BizCurrency.valueOf(0);
        BizCurrency jitsryruiGkGaika = BizCurrency.valueOf(0);
        BizCurrency soutsryGkYen = BizCurrency.valueOf(0);
        BizCurrency soutsryGkGaika = BizCurrency.valueOf(0);
        BigDecimal divide100 = BigDecimal.valueOf(100);

        if (C_ErrorKbn.OK.eq(tsrSisanKekkaKbn) && dairitenTesuuryouSyutoku) {

            C_Tuukasyu syotsrygkTuukasyu = editTuukasyu(pBzMqDairitenTesuuryouInfoSyutokuKekkaBean.getIwsSyotsrygktuukasyu());

            HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);

            CurrencyType henkanCurrencyType = henkanTuuka.henkanTuukaKbnToType(syotsrygkTuukasyu);

            if (C_Tuukasyu.JPY.eq(syotsrygkTuukasyu)) {

                syotsryGkYen = BizCurrency.valueOf(
                    new BigDecimal(pBzMqDairitenTesuuryouInfoSyutokuKekkaBean.getIwsSyotsrygkyen()), henkanCurrencyType);
            }
            else if (!C_Tuukasyu.BLNK.eq(syotsrygkTuukasyu)) {

                syotsryGkKykTuuka = BizCurrency.valueOf(
                    new BigDecimal(pBzMqDairitenTesuuryouInfoSyutokuKekkaBean.
                        getIwsSyotsrygkkyktuuka()).divide(divide100), henkanCurrencyType);
            }

            C_Tuukasyu jitsrygkTuukasyu = editTuukasyu(pBzMqDairitenTesuuryouInfoSyutokuKekkaBean.getIwsJitsrygktuukasyu());

            CurrencyType jitsrygkCurrencyType = henkanTuuka.henkanTuukaKbnToType(jitsrygkTuukasyu);

            if (C_Tuukasyu.JPY.eq(jitsrygkTuukasyu)) {

                jitsryGkYen = BizCurrency.valueOf(
                    new BigDecimal(pBzMqDairitenTesuuryouInfoSyutokuKekkaBean.getIwsJitsrygkyen()), jitsrygkCurrencyType);
            }
            else if (!C_Tuukasyu.BLNK.eq(jitsrygkTuukasyu)) {

                jitsryGkKykTuuka = BizCurrency.valueOf(
                    new BigDecimal(pBzMqDairitenTesuuryouInfoSyutokuKekkaBean.
                        getIwsJitsrygkkyktuuka()).divide(divide100), jitsrygkCurrencyType);
            }

            C_Tuukasyu syotsryruigkTuukasyu = editTuukasyu(pBzMqDairitenTesuuryouInfoSyutokuKekkaBean.getIwsSyotsryruigktuukasyu());

            CurrencyType syotsryruigkCurrencyType = henkanTuuka.henkanTuukaKbnToType(syotsryruigkTuukasyu);

            if (C_Tuukasyu.JPY.eq(syotsryruigkTuukasyu)) {

                syotsryRuiGkYen = BizCurrency.valueOf(
                    new BigDecimal(pBzMqDairitenTesuuryouInfoSyutokuKekkaBean.getIwsSyotsryruigkyen()), syotsryruigkCurrencyType);
            }
            else if (!C_Tuukasyu.BLNK.eq(syotsryruigkTuukasyu)) {

                syotsryRuiGkGaika = BizCurrency.valueOf(
                    new BigDecimal(pBzMqDairitenTesuuryouInfoSyutokuKekkaBean.
                        getIwsSyotsryruigkgaika()).divide(divide100), syotsryruigkCurrencyType);
            }

            C_Tuukasyu jitsryruigkTuukasyu = editTuukasyu(pBzMqDairitenTesuuryouInfoSyutokuKekkaBean.getIwsJitsryruigktuukasyu());

            CurrencyType jitsryruigkCurrencyType = henkanTuuka.henkanTuukaKbnToType(jitsryruigkTuukasyu);

            if (C_Tuukasyu.JPY.eq(jitsryruigkTuukasyu)) {

                jitsryruiGkYen = BizCurrency.valueOf(
                    new BigDecimal(pBzMqDairitenTesuuryouInfoSyutokuKekkaBean.getIwsJitsryruigkyen()), jitsryruigkCurrencyType);
            }
            else if (!C_Tuukasyu.BLNK.eq(jitsryruigkTuukasyu)) {

                jitsryruiGkGaika = BizCurrency.valueOf(
                    new BigDecimal(pBzMqDairitenTesuuryouInfoSyutokuKekkaBean.
                        getIwsJitsryruigkgaika()).divide(divide100), jitsryruigkCurrencyType);
            }

            C_Tuukasyu soutsrygkTuukasyu = editTuukasyu(pBzMqDairitenTesuuryouInfoSyutokuKekkaBean.getIwsSoutsrygktuukasyu());

            CurrencyType soutsrygkCurrencyType = henkanTuuka.henkanTuukaKbnToType(soutsrygkTuukasyu);

            if (C_Tuukasyu.JPY.eq(soutsrygkTuukasyu)) {

                soutsryGkYen = BizCurrency.valueOf(
                    new BigDecimal(pBzMqDairitenTesuuryouInfoSyutokuKekkaBean.getIwsSoutsrygkyen()), soutsrygkCurrencyType);
            }
            else if (!C_Tuukasyu.BLNK.eq(soutsrygkTuukasyu)) {

                soutsryGkGaika = BizCurrency.valueOf(
                    new BigDecimal(pBzMqDairitenTesuuryouInfoSyutokuKekkaBean.
                        getIwsSoutsrygkgaika()).divide(divide100), soutsrygkCurrencyType);
            }

            pDairitenTesuuryouInfoSyutokuKekkaBean.setTsrSisanKekkaKbn(tsrSisanKekkaKbn);
            pDairitenTesuuryouInfoSyutokuKekkaBean.setSyotsryGkYen(syotsryGkYen);
            pDairitenTesuuryouInfoSyutokuKekkaBean.setSyotsryGkKykTuuka(syotsryGkKykTuuka);
            pDairitenTesuuryouInfoSyutokuKekkaBean.setJitsryGkYen(jitsryGkYen);
            pDairitenTesuuryouInfoSyutokuKekkaBean.setJitsryGkKykTuuka(jitsryGkKykTuuka);
            pDairitenTesuuryouInfoSyutokuKekkaBean.setTsryCd(pBzMqDairitenTesuuryouInfoSyutokuKekkaBean.getIwsTsrycd());
            pDairitenTesuuryouInfoSyutokuKekkaBean.setSyotsrygkTuukasyu(syotsrygkTuukasyu);
            pDairitenTesuuryouInfoSyutokuKekkaBean.setJitsrygkTuukasyu(jitsrygkTuukasyu);
            pDairitenTesuuryouInfoSyutokuKekkaBean.setSyotsryRuiGkYen(syotsryRuiGkYen);
            pDairitenTesuuryouInfoSyutokuKekkaBean.setSyotsryRuiGkGaika(syotsryRuiGkGaika);
            pDairitenTesuuryouInfoSyutokuKekkaBean.setSyotsryruigkTuukasyu(syotsryruigkTuukasyu);
            pDairitenTesuuryouInfoSyutokuKekkaBean.setJitsryruiGkYen(jitsryruiGkYen);
            pDairitenTesuuryouInfoSyutokuKekkaBean.setJitsryruiGkGaika(jitsryruiGkGaika);
            pDairitenTesuuryouInfoSyutokuKekkaBean.setJitsryruigkTuukasyu(jitsryruigkTuukasyu);
            pDairitenTesuuryouInfoSyutokuKekkaBean.setSoutsryGkYen(soutsryGkYen);
            pDairitenTesuuryouInfoSyutokuKekkaBean.setSoutsryGkGaika(soutsryGkGaika);
            pDairitenTesuuryouInfoSyutokuKekkaBean.setSoutsrygkTuukasyu(soutsrygkTuukasyu);
        }

        BizDateYM keijyouYm = null;
        if (C_ErrorKbn.OK.eq(keijyouYmSyoukaiKekkaKbn) && keijouYmSyutoku) {

            String keijyouYmSuuti = pBzMqDairitenTesuuryouInfoSyutokuKekkaBean.getIwsKeijyouymstr();

            keijyouYm = BizDateYM.valueOf(keijyouYmSuuti);
            pDairitenTesuuryouInfoSyutokuKekkaBean.setKeijyouYm(keijyouYm);

            pDairitenTesuuryouInfoSyutokuKekkaBean.setKeijyouYmSyoukaiKekkaKbn(keijyouYmSyoukaiKekkaKbn);
        }
    }

    private C_Tuukasyu editTuukasyu(String pTuukaKbn) {

        C_Tuukasyu tuukasyu = null;

        if ("1".equals(pTuukaKbn)) {
            tuukasyu = C_Tuukasyu.JPY;
        }
        else if ("2".equals(pTuukaKbn)) {
            tuukasyu = C_Tuukasyu.USD;
        }
        else if ("3".equals(pTuukaKbn)) {
            tuukasyu = C_Tuukasyu.EUR;
        }
        else if ("4".equals(pTuukaKbn)) {
            tuukasyu = C_Tuukasyu.AUD;
        }
        else {
            tuukasyu = C_Tuukasyu.BLNK;
        }

        return tuukasyu;
    }

    private String editPalRendouKoumoku(String pKbnname, String pBefore, Class<?> pClazz) {

        String kbnData = "";

        BzKbnHenkanUtil bzKbnHenkanUtil = SWAKInjector.getInstance(BzKbnHenkanUtil.class);

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(pBefore, pClazz, C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER);

        if (!kbnInfoBean.isHenkanFlg()) {

            throw new CommonBizAppException("他システム連動用区分値変換に失敗しました。"
                + "区分名：" + pKbnname + "　　区分値：" + pBefore);
        }

        kbnData = kbnInfoBean.getKbnData();
        return kbnData;
    }
}
