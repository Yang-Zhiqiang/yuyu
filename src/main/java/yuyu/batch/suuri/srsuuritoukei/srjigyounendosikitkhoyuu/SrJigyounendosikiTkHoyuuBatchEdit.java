package yuyu.batch.suuri.srsuuritoukei.srjigyounendosikitkhoyuu;

import java.math.BigDecimal;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBTransactionalUtil;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.CurrencyType;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.bzcommon.SetHokenNenrei;
import yuyu.common.siharai.sicommon.CalcHkShrKngk;
import yuyu.common.siharai.sicommon.CalcHkShrKngkBean;
import yuyu.common.suuri.srcommon.SrCommonConstants;
import yuyu.common.suuri.srcommon.SrSuuriKbnHenkanBean;
import yuyu.common.suuri.srcommon.SrSuuriKbnHenkanSet;
import yuyu.def.MessageId;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HaitouKbn;
import yuyu.def.classification.C_HokenkinsyuruiKbn;
import yuyu.def.classification.C_SiinKbn;
import yuyu.def.classification.C_SrKbnHenkanKbn;
import yuyu.def.classification.C_TodouhukenKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.IT_ItekiToukeiInfo;
import yuyu.def.db.entity.IT_KykDairiten;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.ST_SuuriyouErrJyouhou;
import yuyu.def.db.entity.ZT_JigyounndsikiTkHoyuuTy;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 数理 数理統計 事業年度式特約保有情報作成の項目編集クラス
 */
public class SrJigyounendosikiTkHoyuuBatchEdit {

    private boolean errorFlag;

    private static final String SINKEITYUUTOKBN = "1";

    private static final String BOSYUUKEIROKBN = "1";

    private static final String HOSYOUKIKANKBN = "2";

    private static final String HAITOUKBN_YUUHAI = "0";

    private static final String HAITOUKBN_RISAHAI = "2";

    private static final String HAITOUKBN_NONE = "4";

    @Inject
    private BatchLogger batchLogger;

    public SrJigyounendosikiTkHoyuuBatchEdit() {
        super();
        errorFlag = false;
    }

    public boolean editKoumoku(SrJigyounendosikiTkHoyuuBatchParam pSrJigyounendosikiTkHoyuuBatchParam,
        IT_KykSyouhn pKykSyouhn, IT_KykDairiten pKykDairiten, IT_KykSonotaTkyk pKykSonotaTkyk,
        IT_ItekiToukeiInfo pItekiToukeiInfo, IT_KykKihon pKykKihon, BM_SyouhnZokusei pSyouhnZokusei,
        ZT_JigyounndsikiTkHoyuuTy pJigyounndsikiTkHoyuuTy) {

        editTyHasseirtHoyuuData(
            pSrJigyounendosikiTkHoyuuBatchParam,
            pKykSyouhn,
            pKykDairiten,
            pItekiToukeiInfo,
            pKykKihon,
            pSyouhnZokusei,
            pJigyounndsikiTkHoyuuTy);

        editTyHasseirtHoyuuRayItem(
            pSrJigyounendosikiTkHoyuuBatchParam,
            pKykSyouhn,
            pKykSonotaTkyk,
            pKykKihon,
            pSyouhnZokusei,
            pJigyounndsikiTkHoyuuTy);

        return errorFlag;

    }

    private void editTyHasseirtHoyuuData(SrJigyounendosikiTkHoyuuBatchParam pSrJigyounendosikiTkHoyuuBatchParam,
        IT_KykSyouhn pKykSyouhn, IT_KykDairiten pKykDairiten, IT_ItekiToukeiInfo pItekiToukeiInfo,
        IT_KykKihon pKykKihon, BM_SyouhnZokusei pSyouhnZokusei, ZT_JigyounndsikiTkHoyuuTy pJigyounndsikiTkHoyuuTy) {

        String kbnkey = pKykSyouhn.getKbnkey();

        int sequenceNo = Integer.valueOf(pSrJigyounendosikiTkHoyuuBatchParam.getSyoriKensuu() +
            kbnkey.substring(kbnkey.length()-1));

        String todoufukencd = pKykKihon.getDrtenkanritodoufukencd();

        if (C_TodouhukenKbn.BLNK.getValue().equals(todoufukencd)) {

            todoufukencd = C_TodouhukenKbn.OSAKA.getValue();
        }

        int syukeiyakuKykjigyouY = 0;

        if (pKykSyouhn.getKykymd().getMonth() >= SrCommonConstants.MONTH_APRIL) {
            syukeiyakuKykjigyouY = pKykSyouhn.getKykymd().getYear();
        }
        else {
            syukeiyakuKykjigyouY = pKykSyouhn.getKykymd().getYear() - 1;
        }

        String haitouKbn = "";

        if (C_HaitouKbn.YUUHAI.eq(pSyouhnZokusei.getHaitoukbn())) {
            haitouKbn = HAITOUKBN_YUUHAI;
        }
        else if (C_HaitouKbn.RISAHAI.eq(pSyouhnZokusei.getHaitoukbn())) {
            haitouKbn = HAITOUKBN_RISAHAI;
        }
        else if (C_HaitouKbn.NONE.eq(pSyouhnZokusei.getHaitoukbn())) {
            haitouKbn = HAITOUKBN_NONE;
        }
        else {
            String kbnHenkanErrorMsg = MessageUtil.getMessage(MessageId.ESA1002, "数理発生率用配当区分",
                pKykKihon.getSyono(), pSyouhnZokusei.getHaitoukbn().getValue());

            batchLogger.warn(kbnHenkanErrorMsg);

            ST_SuuriyouErrJyouhou suuriyouErrJyouhou =  new ST_SuuriyouErrJyouhou();
            suuriyouErrJyouhou.setSyoriYmd(pSrJigyounendosikiTkHoyuuBatchParam.getSyoriYmd());
            suuriyouErrJyouhou.setKakutyoujobcd(pSrJigyounendosikiTkHoyuuBatchParam.getIbKakutyoujobcd());
            suuriyouErrJyouhou.setSyono(pKykKihon.getSyono());
            suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(kbnHenkanErrorMsg);
            suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

            BizPropertyInitializer.initialize(suuriyouErrJyouhou);
            ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

            pSrJigyounendosikiTkHoyuuBatchParam.setErrorSyoriKensuu(pSrJigyounendosikiTkHoyuuBatchParam.getErrorSyoriKensuu() + 1);

            errorFlag = true;
        }

        SrSuuriKbnHenkanSet srSuuriKbnHenkanSet = SWAKInjector.getInstance(SrSuuriKbnHenkanSet.class);

        String bosyuukeitaiKbn = "";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(C_SrKbnHenkanKbn.BOSYU_KEITAI, pKykDairiten.getDrtencd());

        if (C_ErrorKbn.ERROR.eq(srSuuriKbnHenkanBean.getKekkaKbn())) {

            String kbnHenkanErrorMsg = MessageUtil.getMessage(MessageId.ESA1002,
                C_SrKbnHenkanKbn.BOSYU_KEITAI.getContent(), pKykKihon.getSyono(), pKykDairiten.getDrtencd());
            batchLogger.warn(kbnHenkanErrorMsg);

            ST_SuuriyouErrJyouhou suuriyouErrJyouhou =  new ST_SuuriyouErrJyouhou();
            suuriyouErrJyouhou.setSyoriYmd(pSrJigyounendosikiTkHoyuuBatchParam.getSyoriYmd());
            suuriyouErrJyouhou.setKakutyoujobcd(pSrJigyounendosikiTkHoyuuBatchParam.getIbKakutyoujobcd());
            suuriyouErrJyouhou.setSyono(pKykKihon.getSyono());
            suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(kbnHenkanErrorMsg);
            suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

            BizPropertyInitializer.initialize(suuriyouErrJyouhou);
            ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

            pSrJigyounendosikiTkHoyuuBatchParam.setErrorSyoriKensuu(pSrJigyounendosikiTkHoyuuBatchParam.getErrorSyoriKensuu() + 1);

            errorFlag = true;
        }
        else {
            bosyuukeitaiKbn = srSuuriKbnHenkanBean.getHenkanAtoKbn();
        }

        SetHokenNenrei setHokenNenrei = SWAKInjector.getInstance(SetHokenNenrei.class);
        String hhknnenTysihyj = "";
        int hhknHkNenrei = setHokenNenrei.exec(pKykSyouhn.getKykymd(), pKykSyouhn.getHhknseiymd());

        if (pKykSyouhn.getHhknnen() != hhknHkNenrei) {
            hhknnenTysihyj = SrCommonConstants.HYOUJI_ARI;
        }
        else {
            hhknnenTysihyj = SrCommonConstants.HYOUJI_NASI;
        }

        pJigyounndsikiTkHoyuuTy.setZtysequenceno(sequenceNo);
        pJigyounndsikiTkHoyuuTy.setZtydatakanrino(pKykKihon.getSyono());
        pJigyounndsikiTkHoyuuTy.setZtysuuriyoutokuyakukbn(pKykSyouhn.getSyouhncd());
        pJigyounndsikiTkHoyuuTy.setZtytokuyakukisi(pKykSyouhn.getKykymd().toString());
        pJigyounndsikiTkHoyuuTy.setZtyhihokensyaagev2(pKykSyouhn.getHhknnen().toString());
        pJigyounndsikiTkHoyuuTy.setZtyhhknseikbn(pKykSyouhn.getHhknsei().getValue());
        pJigyounndsikiTkHoyuuTy.setZtyhknsyukigou(pKykSyouhn.getSyouhncd());
        pJigyounndsikiTkHoyuuTy.setZtysisyacd(pKykDairiten.getDrtenkanrisosikicd().substring(0, 3));
        pJigyounndsikiTkHoyuuTy.setZtysibucd(pKykDairiten.getDrtenkanrisosikicd().substring(4, 7));
        pJigyounndsikiTkHoyuuTy.setZtybsyym(pKykKihon.getBosyuuym().toString());
        pJigyounndsikiTkHoyuuTy.setZtyhhknhnsktodouhukencd(todoufukencd);
        pJigyounndsikiTkHoyuuTy.setZtysinkeityuutokbn(SINKEITYUUTOKBN);
        pJigyounndsikiTkHoyuuTy.setZtysyukeiyakukykjigyouy(String.valueOf(syukeiyakuKykjigyouY));
        pJigyounndsikiTkHoyuuTy.setZtyhrkkaisuukbn(SrCommonConstants.HRKKAISUUKBN_ITIJIBARAI);
        pJigyounndsikiTkHoyuuTy.setZtyryouritukbn(SrCommonConstants.RYOURITUKBN_HUTUUITIJIBARAI);
        pJigyounndsikiTkHoyuuTy.setZtytksyuannaikykkbn(SrCommonConstants.TKSYUANNAIKYKKBN_TAISYOUGAI);
        pJigyounndsikiTkHoyuuTy.setZtyannaifuyouriyuukbn(SrCommonConstants.ANNAIFUYOURIYUUKBN_ITIJIBARAI);
        pJigyounndsikiTkHoyuuTy.setZtyhaitoukbn(haitouKbn);
        pJigyounndsikiTkHoyuuTy.setZtysykgycd(pKykKihon.getHhknsykgycd());
        pJigyounndsikiTkHoyuuTy.setZtytoukeiyousinsakbn(SrCommonConstants.TOUKEIYOUSINSAKBN_KOKUTISYO);
        pJigyounndsikiTkHoyuuTy.setZtypmenhukakbn(SrCommonConstants.PMENHUKAKBN_PMENTKYKNASI);
        pJigyounndsikiTkHoyuuTy.setZtyketteikijyunkanwakbn(SrCommonConstants.DEFAULT_STRING_ZERO_1);
        pJigyounndsikiTkHoyuuTy.setZtyhknsyuruikigousedaikbn(pKykSyouhn.getRyouritusdno());
        pJigyounndsikiTkHoyuuTy.setZtytokuyakusedaikbn(pKykSyouhn.getRyouritusdno());
        pJigyounndsikiTkHoyuuTy.setZtybosyuukeirokbn(BOSYUUKEIROKBN);
        pJigyounndsikiTkHoyuuTy.setZtystdssnskbn(SrCommonConstants.HKNSYKGUYBI3X1_MUSINSA);
        pJigyounndsikiTkHoyuuTy.setZtystdssytikbn(SrCommonConstants.HKNSYKGUYBI1X1_SONOTA);
        pJigyounndsikiTkHoyuuTy.setZtyhosyoukikankbn(HOSYOUKIKANKBN);
        pJigyounndsikiTkHoyuuTy.setZtykeijyouym(
            pSrJigyounendosikiTkHoyuuBatchParam.getSyoriYmd().getBizDateYM().addMonths(-SrCommonConstants.KIKAN_1M).toString());
        pJigyounndsikiTkHoyuuTy.setZtybosyuukeitaikbn(bosyuukeitaiKbn);
        pJigyounndsikiTkHoyuuTy.setZtydakuhikettisyacd(pItekiToukeiInfo.getPalketsyacd());
        pJigyounndsikiTkHoyuuTy.setZtymannenreihyj(SrCommonConstants.HYOUJI_ARI);
        pJigyounndsikiTkHoyuuTy.setZtyhhknnentysihyj(hhknnenTysihyj);
        pJigyounndsikiTkHoyuuTy.setZtyhokenhoutekiyouhyouji(SrCommonConstants.HYOUJI_ARI);
        pJigyounndsikiTkHoyuuTy.setZtysotodasiphkbnmnoshyouji(SrCommonConstants.HYOUJI_ARI);
        pJigyounndsikiTkHoyuuTy.setZtykykymd(pKykSyouhn.getKykymd().toString());

    }

    private void editTyHasseirtHoyuuRayItem(SrJigyounendosikiTkHoyuuBatchParam pSrJigyounendosikiTkHoyuuBatchParam,
        IT_KykSyouhn pKykSyouhn, IT_KykSonotaTkyk pKykSonotaTkyk, IT_KykKihon pKykKihon,
        BM_SyouhnZokusei pSyouhnZokusei, ZT_JigyounndsikiTkHoyuuTy pJigyounndsikiTkHoyuuTy) {

        SrSuuriKbnHenkanSet srSuuriKbnHenkanSet = SWAKInjector.getInstance(SrSuuriKbnHenkanSet.class);
        String gaikaKbn = "";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(C_SrKbnHenkanKbn.SUURI_KEIYAKUDATE_TUUKA,
            pKykSyouhn.getKyktuukasyu().getValue());

        if (C_ErrorKbn.ERROR.eq(srSuuriKbnHenkanBean.getKekkaKbn())) {

            String kbnHenkanErrorMsg = MessageUtil.getMessage(MessageId.ESA1002,
                C_SrKbnHenkanKbn.SUURI_KEIYAKUDATE_TUUKA.getContent(), pKykKihon.getSyono(),
                pKykSyouhn.getKyktuukasyu().toString());
            batchLogger.warn(kbnHenkanErrorMsg);

            ST_SuuriyouErrJyouhou suuriyouErrJyouhou =  new ST_SuuriyouErrJyouhou();
            suuriyouErrJyouhou.setSyoriYmd(pSrJigyounendosikiTkHoyuuBatchParam.getSyoriYmd());
            suuriyouErrJyouhou.setKakutyoujobcd(pSrJigyounendosikiTkHoyuuBatchParam.getIbKakutyoujobcd());
            suuriyouErrJyouhou.setSyono(pKykKihon.getSyono());
            suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(kbnHenkanErrorMsg);
            suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

            BizPropertyInitializer.initialize(suuriyouErrJyouhou);
            ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

            pSrJigyounendosikiTkHoyuuBatchParam.setErrorSyoriKensuu(pSrJigyounendosikiTkHoyuuBatchParam.getErrorSyoriKensuu() + 1);
            errorFlag = true;

        }
        else {
            gaikaKbn = srSuuriKbnHenkanBean.getHenkanAtoKbn();
        }

        CalcHkShrKngk calcHkShrKngk = SWAKInjector.getInstance(CalcHkShrKngk.class);
        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
        CurrencyType currencyType = henkanTuuka.henkanTuukaKbnToType(pKykSyouhn.getKyktuukasyu());
        BizCurrency sbhokenknGk = BizCurrency.valueOf(0, currencyType);
        BizCurrency gaikadateTokuyakuS = BizCurrency.valueOf(0, currencyType);
        BizCurrency mvaTyouseigoW = BizCurrency.valueOf(0, currencyType);
        BizCurrency mvaKeisanjiSknnjynbkn = BizCurrency.valueOf(0, currencyType);

        C_ErrorKbn errorKbn = calcHkShrKngk.execByKeisanWExt(
            pKykKihon.getSyono(),
            pSrJigyounendosikiTkHoyuuBatchParam.getHoyuuHanteiymd(),
            C_SiinKbn.SP,
            C_HokenkinsyuruiKbn.SBHOKENKIN,
            pKykKihon.getSdpdkbn(),
            pKykKihon.getHrkkeiro());

        if (C_ErrorKbn.ERROR.eq(errorKbn)) {

            String sbusSsyErrorMsg = MessageUtil.getMessage(MessageId.ESA1001,
                "死亡Ｓ", pKykKihon.getSyono());
            batchLogger.warn(sbusSsyErrorMsg);

            ST_SuuriyouErrJyouhou suuriyouErrJyouhou =  new ST_SuuriyouErrJyouhou();
            suuriyouErrJyouhou.setSyoriYmd(pSrJigyounendosikiTkHoyuuBatchParam.getSyoriYmd());
            suuriyouErrJyouhou.setKakutyoujobcd(pSrJigyounendosikiTkHoyuuBatchParam.getIbKakutyoujobcd());
            suuriyouErrJyouhou.setSyono(pKykKihon.getSyono());
            suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(sbusSsyErrorMsg);
            suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

            BizPropertyInitializer.initialize(suuriyouErrJyouhou);
            ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

            pSrJigyounendosikiTkHoyuuBatchParam.setErrorSyoriKensuu(pSrJigyounendosikiTkHoyuuBatchParam.getErrorSyoriKensuu() + 1);
            errorFlag = true;

        }
        else {
            CalcHkShrKngkBean calcHkShrKngkBean = calcHkShrKngk.getCalcHkShrKngkBean();
            sbhokenknGk = calcHkShrKngkBean.getSibousGk();
            mvaTyouseigoW = calcHkShrKngkBean.getKaiyakuhenreiknGk();
            mvaKeisanjiSknnjynbkn = calcHkShrKngkBean.getTmttKnGk();
        }
        gaikadateTokuyakuS = pKykSyouhn.getKihons().subtract(sbhokenknGk);

        BizCurrency enkadatesaiteihosyoukngk = BizCurrency.valueOf(0);
        if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getInitsbjiyensitihsytkhukaumu())) {
            enkadatesaiteihosyoukngk = pKykSonotaTkyk.getInitsbjiyenkasaiteihsygk();
        }

        pJigyounndsikiTkHoyuuTy.setZtyraysystemhyj(SrCommonConstants.HYOUJI_ARI);
        pJigyounndsikiTkHoyuuTy.setZtygaikakbn(gaikaKbn);
        pJigyounndsikiTkHoyuuTy.setZtykeiyakujiyoteiriritu(pKykSyouhn.getYoteiriritu());
        pJigyounndsikiTkHoyuuTy.setZtygaikadatetokuyakus(Long.parseLong(gaikadateTokuyakuS.toAdsoluteString()));
        pJigyounndsikiTkHoyuuTy.setZtygaikadatesyukeiyakus(Long.parseLong(pKykSyouhn.getKihons().toAdsoluteString()));
        pJigyounndsikiTkHoyuuTy.setZtygaikadatesyukeiyakup(Long.parseLong(pKykSyouhn.getHokenryou().toAdsoluteString()));
        pJigyounndsikiTkHoyuuTy.setZtyenkdtsbujsitihsyukngk(Long.parseLong(enkadatesaiteihosyoukngk.toAdsoluteString()));
        pJigyounndsikiTkHoyuuTy.setZtymvatyouseigow(new BigDecimal(mvaTyouseigoW.toAdsoluteString()).longValue());
        pJigyounndsikiTkHoyuuTy.setZtymvakeisanjisknnjynbkn(new BigDecimal(mvaKeisanjiSknnjynbkn.toAdsoluteString()).longValue());

        BizPropertyInitializer.initialize(pJigyounndsikiTkHoyuuTy);

        SrJigyounendosikiTkHoyuuConverter.convertPadding(pJigyounndsikiTkHoyuuTy);
    }

}