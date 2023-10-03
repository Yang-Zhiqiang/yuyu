package yuyu.batch.suuri.srsuuritoukei.srsinkeiyakusyuunyuuptoukei;

import java.math.BigDecimal;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBTransactionalUtil;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.GetKawaseRate;
import yuyu.common.biz.bzcommon.SetHokenNenrei;
import yuyu.common.biz.kaikei.BzSegmentCdSyutoku;
import yuyu.common.biz.kaikei.SyouhinbetuSegmentBean;
import yuyu.common.hozen.khcommon.KeisanSisuuRendouNkTmttknOverNnd;
import yuyu.common.hozen.khcommon.SetManryoubi;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.common.suuri.srcommon.SetErrMessageInfoBean;
import yuyu.common.suuri.srcommon.SrCommonConstants;
import yuyu.common.suuri.srcommon.SrSuuriGouseiRateKeisan;
import yuyu.common.suuri.srcommon.SrSuuriGouseiRateKeisanBean;
import yuyu.common.suuri.srcommon.SrSuuriKbnHenkanBean;
import yuyu.common.suuri.srcommon.SrSuuriKbnHenkanSet;
import yuyu.def.MessageId;
import yuyu.def.classification.C_EigyoubiHoseiKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.classification.C_KawaserateSyuruiKbn;
import yuyu.def.classification.C_KawasetekiyoKbn;
import yuyu.def.classification.C_KawasetsryKbn;
import yuyu.def.classification.C_KknsmnKbn;
import yuyu.def.classification.C_KykKbn;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_SnkiSyunyupSyuturyokuKbn;
import yuyu.def.classification.C_SrKbnHenkanKbn;
import yuyu.def.classification.C_SuuriAnnaiFuyouRiyuuKbn;
import yuyu.def.classification.C_SuuriRyourituKbn;
import yuyu.def.classification.C_TumitatekinHaibunWariKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.BT_DenpyoData;
import yuyu.def.db.entity.HT_MosSyouhn;
import yuyu.def.db.entity.HT_Nyuukin;
import yuyu.def.db.entity.IT_KhSisuurendoTmttkn;
import yuyu.def.db.entity.IT_NyknJissekiRireki;
import yuyu.def.db.entity.ST_SuuriyouErrJyouhou;
import yuyu.def.db.entity.ST_SynypTukiTugtTykiyuHozon;
import yuyu.def.db.entity.SV_SnkiykSyunyup;
import yuyu.def.db.entity.ZT_SkeisynyptoukeiksnTy;
import yuyu.def.db.entity.ZT_SkeisynyptoukeirigTy;
import yuyu.def.hozen.result.bean.KhHenkouRirekiBfrnaiyouoriginalNewnaiyouoriginalBySyonoBean;
import yuyu.def.suuri.configuration.YuyuSuuriConfig;
import yuyu.infr.batch.logger.BatchLogger;

import com.google.common.base.Strings;

/**
 * バッチ機能の項目編集クラス
 */
public class SrSinkeiyakuSyuunyuupToukeiItemEditor {

    private final String RENDOUKBNSINKEIYAKU = "2";

    private final String JUUTOUKAISUUHARAI = "0000";

    private final String RECORDKBNKASHIKATA = "2";

    private final String WARIBIKINASHI = "0";

    private final String SHUUNOUKBNHARAI = "001";

    private final String SHUUNOUKBNINIT = "000";

    private final String TENKANKBNSONOTA = "0";

    private final String TOJYOKBNSAKUGEN = "0";

    private final String SECONDTOJYOKBNSAKUGEN = "0";

    @Inject
    private BatchLogger batchLogger;

    private Boolean result;

    public SrSinkeiyakuSyuunyuupToukeiItemEditor() {

        result = false;
    }

    public Boolean editKoumoku(SrSinkeiyakuSyuunyuupToukeiParam pSrSinkeiyakuSyuunyuupToukeiParam,
        C_SnkiSyunyupSyuturyokuKbn pSnkiSyunyupSyuturyokuKbn, SV_SnkiykSyunyup pSnkiykSyunyup, String pBusituCd,
        HT_MosSyouhn pMosSyouhn, HT_Nyuukin pNyuukin, List<BT_DenpyoData> pDenpyoDataLst,
        List<IT_NyknJissekiRireki> pNyknJissekiRirekiLst, ZT_SkeisynyptoukeirigTy pSkeisynyptoukeirigTy,
        ZT_SkeisynyptoukeiksnTy pSkeisynyptoukeiksnTy, ST_SynypTukiTugtTykiyuHozon pSynypTukiTugtTykiyuHozon,
        int pSyouhin, IT_KhSisuurendoTmttkn pKhSisuurendoTmttkn, int pToukipZennoupRecordKbn) {

        editToukeiData(pSrSinkeiyakuSyuunyuupToukeiParam, pSnkiSyunyupSyuturyokuKbn, pSnkiykSyunyup, pBusituCd,
            pMosSyouhn, pDenpyoDataLst, pNyknJissekiRirekiLst, pSkeisynyptoukeirigTy,
            pSkeisynyptoukeiksnTy, pSynypTukiTugtTykiyuHozon, pSyouhin, pToukipZennoupRecordKbn);

        editRayData(pSrSinkeiyakuSyuunyuupToukeiParam, pSnkiSyunyupSyuturyokuKbn, pSnkiykSyunyup, pMosSyouhn, pNyuukin,
            pSkeisynyptoukeirigTy, pSkeisynyptoukeiksnTy, pSynypTukiTugtTykiyuHozon, pSyouhin, pKhSisuurendoTmttkn,
            pToukipZennoupRecordKbn);

        editHeaderData(pSrSinkeiyakuSyuunyuupToukeiParam, pSnkiSyunyupSyuturyokuKbn, pSkeisynyptoukeirigTy,
            pSkeisynyptoukeiksnTy);

        if (pToukipZennoupRecordKbn == SrCommonConstants.TOUKIPZENNOUP_RECORDKBN_TOUKIP) {
            if (pSyouhin == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {

                editUniqueData(pSrSinkeiyakuSyuunyuupToukeiParam, pSnkiSyunyupSyuturyokuKbn, pDenpyoDataLst.get(0),
                    pSynypTukiTugtTykiyuHozon);
            }
        }

        return result;
    }

    public void editToukeiData(SrSinkeiyakuSyuunyuupToukeiParam pSrSinkeiyakuSyuunyuupToukeiParam,
        C_SnkiSyunyupSyuturyokuKbn pSnkiSyunyupSyuturyokuKbn, SV_SnkiykSyunyup pSnkiykSyunyup, String pBusituCd,
        HT_MosSyouhn pMosSyouhn, List<BT_DenpyoData> pDenpyoDataLst, List<IT_NyknJissekiRireki> pNyknJissekiRirekiLst,
        ZT_SkeisynyptoukeirigTy pSkeisynyptoukeirigTy, ZT_SkeisynyptoukeiksnTy pSkeisynyptoukeiksnTy,
        ST_SynypTukiTugtTykiyuHozon pSynypTukiTugtTykiyuHozon, int pSyouhin, int pToukipZennoupRecordKbn) {

        String hhknsyaagetyouseihyj = "";

        String kyksyaagetyouseihyj = "";

        String wkHaitoukbn = "";

        Integer kyknen = 0;

        String syukeiyakusyuruicd = "";

        String dataKanriNo = pSnkiykSyunyup.getSyono();

        BizCurrency seitouKihonS = BizCurrency.valueOf(0);

        if (SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR != pSyouhin
            && SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20 != pSyouhin
            && SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN != pSyouhin) {

            seitouKihonS = pMosSyouhn.getSeitoukihons();
        }

        C_Segcd kbnkeirisegcd = C_Segcd.BLNK;
        BzSegmentCdSyutoku bzSegmentCdSyutoku = SWAKInjector.getInstance(BzSegmentCdSyutoku.class);

        SyouhinbetuSegmentBean syouhinbetuSegmentBean =
            bzSegmentCdSyutoku.exec(pMosSyouhn.getSyouhncd(), pSnkiykSyunyup.getKyktuukasyu());

        if (C_ErrorKbn.ERROR.eq(syouhinbetuSegmentBean.getErrorKbn())) {

            String msg = MessageUtil.getMessage(MessageId.ESA1007, SrCommonConstants.MSGHYOUJIMOJIRETU_SEGCD,
                pSnkiykSyunyup.getSyono(), pMosSyouhn.getSyouhncd(), pSnkiykSyunyup.getKyktuukasyu().getValue());

            batchLogger.warn(msg);

            ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

            suuriyouErrJyouhou.setSyoriYmd(pSrSinkeiyakuSyuunyuupToukeiParam.getSyoriYmd());
            suuriyouErrJyouhou.setKakutyoujobcd(pSrSinkeiyakuSyuunyuupToukeiParam.getIbKakutyoujobcd());
            suuriyouErrJyouhou.setSyono(pSnkiykSyunyup.getSyono());
            suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);
            suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

            ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

            pSrSinkeiyakuSyuunyuupToukeiParam.setZokkouErrorSyoriCount(pSrSinkeiyakuSyuunyuupToukeiParam.getZokkouErrorSyoriCount() + 1);

            result = true;
        }
        else {

            kbnkeirisegcd = syouhinbetuSegmentBean.getSegcd1();
        }

        SetHokenNenrei setHokenNenrei = SWAKInjector.getInstance(SetHokenNenrei.class);

        int hhknhkNenrei = setHokenNenrei.exec(pSnkiykSyunyup.getKykymd(), pSnkiykSyunyup.getHhknseiymd());

        if (pSnkiykSyunyup.getHhknnen() != hhknhkNenrei) {

            hhknsyaagetyouseihyj = SrCommonConstants.HYOUJI_ARI;
        }

        else {

            hhknsyaagetyouseihyj = SrCommonConstants.HYOUJI_NASI;
        }

        if (C_KykKbn.KEIHI_DOUITU.eq(pSnkiykSyunyup.getKykkbn())) {

            kyknen = pSnkiykSyunyup.getHhknnen();

            kyksyaagetyouseihyj = hhknsyaagetyouseihyj;
        }

        else {

            SetHokenNenrei setHokenNenrei1 = SWAKInjector.getInstance(SetHokenNenrei.class);

            int kykhkNenrei = setHokenNenrei1.exec(pSnkiykSyunyup.getKykymd(), pSnkiykSyunyup.getKykseiymd());

            if (pSnkiykSyunyup.getKyknen() != kykhkNenrei) {

                kyksyaagetyouseihyj = SrCommonConstants.HYOUJI_ARI;
            }

            else {

                kyksyaagetyouseihyj = SrCommonConstants.HYOUJI_NASI;
            }

            if (pSnkiykSyunyup.getKyknen() > 99) {
                kyknen = 0;
            }
            else {
                kyknen = pSnkiykSyunyup.getKyknen();
            }
        }

        SrSuuriKbnHenkanSet srSuuriKbnHenkanSet = SWAKInjector.getInstance(SrSuuriKbnHenkanSet.class);

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec2(
            C_SrKbnHenkanKbn.SYOKEIYAKU,
            pMosSyouhn.getSyouhncd(),
            pSnkiykSyunyup.getKyktuukasyu().getValue());

        if(C_ErrorKbn.ERROR.eq(srSuuriKbnHenkanBean.getKekkaKbn())){

            String msg = MessageUtil.getMessage(MessageId.ESA1006, C_SrKbnHenkanKbn.SYOKEIYAKU.getContent(),
                pSnkiykSyunyup.getSyono(), pMosSyouhn.getSyouhncd(), pSnkiykSyunyup.getKyktuukasyu().getValue());

            batchLogger.warn(msg);

            ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

            suuriyouErrJyouhou.setSyoriYmd(pSrSinkeiyakuSyuunyuupToukeiParam.getSyoriYmd());
            suuriyouErrJyouhou.setKakutyoujobcd(pSrSinkeiyakuSyuunyuupToukeiParam.getIbKakutyoujobcd());
            suuriyouErrJyouhou.setSyono(pSnkiykSyunyup.getSyono());
            suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);
            suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

            ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

            pSrSinkeiyakuSyuunyuupToukeiParam.setZokkouErrorSyoriCount(pSrSinkeiyakuSyuunyuupToukeiParam.getZokkouErrorSyoriCount() + 1);

            result = true;
        }
        else {
            syukeiyakusyuruicd = Strings.padStart(srSuuriKbnHenkanBean.getHenkanAtoKbn(), 3, '0');
        }

        String aatsukaishasoshikicd = pSnkiykSyunyup.getDrtenkanrisosikicd();

        String aatukaikojincd = pSnkiykSyunyup.getDaibosyuucd();

        String bosyuukeitaikbn = "";

        srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(C_SrKbnHenkanKbn.BOSYU_KEITAI, pSnkiykSyunyup.getTratkiagcd());

        if(C_ErrorKbn.ERROR.eq(srSuuriKbnHenkanBean.getKekkaKbn())){

            String msg = MessageUtil.getMessage(MessageId.ESA1002, C_SrKbnHenkanKbn.BOSYU_KEITAI.getContent(),
                pSnkiykSyunyup.getSyono(), pSnkiykSyunyup.getTratkiagcd());

            batchLogger.warn(msg);

            ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

            suuriyouErrJyouhou.setSyoriYmd(pSrSinkeiyakuSyuunyuupToukeiParam.getSyoriYmd());
            suuriyouErrJyouhou.setKakutyoujobcd(pSrSinkeiyakuSyuunyuupToukeiParam.getIbKakutyoujobcd());
            suuriyouErrJyouhou.setSyono(pSnkiykSyunyup.getSyono());
            suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);
            suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

            ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

            pSrSinkeiyakuSyuunyuupToukeiParam.setZokkouErrorSyoriCount(pSrSinkeiyakuSyuunyuupToukeiParam.getZokkouErrorSyoriCount() + 1);

            result = true;
        }
        else {
            bosyuukeitaikbn = srSuuriKbnHenkanBean.getHenkanAtoKbn();
        }

        String busituCd = pBusituCd;

        srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(C_SrKbnHenkanKbn.SUURI_HAITOU, pSnkiykSyunyup.getHaitoukbn().getValue());

        if(C_ErrorKbn.ERROR.eq(srSuuriKbnHenkanBean.getKekkaKbn())){

            String msg = MessageUtil.getMessage(MessageId.ESA1002, C_SrKbnHenkanKbn.SUURI_HAITOU.getContent(),
                pSnkiykSyunyup.getSyono(), pSnkiykSyunyup.getHaitoukbn().getValue());

            batchLogger.warn(msg);

            ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

            suuriyouErrJyouhou.setSyoriYmd(pSrSinkeiyakuSyuunyuupToukeiParam.getSyoriYmd());
            suuriyouErrJyouhou.setKakutyoujobcd(pSrSinkeiyakuSyuunyuupToukeiParam.getIbKakutyoujobcd());
            suuriyouErrJyouhou.setSyono(pSnkiykSyunyup.getSyono());
            suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);
            suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

            ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

            pSrSinkeiyakuSyuunyuupToukeiParam.setZokkouErrorSyoriCount(pSrSinkeiyakuSyuunyuupToukeiParam.getZokkouErrorSyoriCount() + 1);

            result = true;
        }
        else {
            wkHaitoukbn = srSuuriKbnHenkanBean.getHenkanAtoKbn();
        }

        BizCurrency syonendosyokaip = BizCurrency.valueOf(0);
        BizCurrency syonendo2kaimeikoup = BizCurrency.valueOf(0);
        BizCurrency jinendoikoup = BizCurrency.valueOf(0);

        for (BT_DenpyoData denpyoData : pDenpyoDataLst) {
            C_Kanjyoukmkcd kanjyoukmkcd = denpyoData.getKanjyoukmkcd();
            if (C_Kanjyoukmkcd.SYONENDOSYOKAIHOKENRYOU_GAIHO_JPY.eq(kanjyoukmkcd)
                || C_Kanjyoukmkcd.SYONENDOSYOKAIHOKENRYOU_GAIHO_USD.eq(kanjyoukmkcd)
                || C_Kanjyoukmkcd.SYONENDOSYOKAIHOKENRYOU_HUTUU.eq(kanjyoukmkcd)
                || C_Kanjyoukmkcd.SYONENDOSYOKAIHOKENRYOU_GAIHO_AUD.eq(kanjyoukmkcd)) {

                syonendosyokaip = denpyoData.getDenyenkagk();
            }
            else if (C_Kanjyoukmkcd.SYONENDO2KAIMEIKOU_GAIHO_JPY.eq(kanjyoukmkcd)
                || C_Kanjyoukmkcd.SYONENDO2KAIMEIKOU_GAIHO_USD.eq(kanjyoukmkcd)
                || C_Kanjyoukmkcd.SYONENDO2KAIMEIKOU_HUTUU.eq(kanjyoukmkcd)
                || C_Kanjyoukmkcd.SYONENDO2KAIMEIKOU_GAIHO_AUD.eq(kanjyoukmkcd)) {

                syonendo2kaimeikoup = denpyoData.getDenyenkagk();
            }
            else{
                jinendoikoup = denpyoData.getDenyenkagk();
            }
        }

        if (C_UmuKbn.ARI.eq(pSnkiykSyunyup.getZennoumousideumu())) {
            if (pToukipZennoupRecordKbn == SrCommonConstants.TOUKIPZENNOUP_RECORDKBN_TOUKIP) {
                jinendoikoup = BizCurrency.valueOf(0);
            }
            else{
                syonendosyokaip = BizCurrency.valueOf(0);
                syonendo2kaimeikoup = BizCurrency.valueOf(0);
            }
        }

        BizDate denYmdTyousei;

        if (C_SnkiSyunyupSyuturyokuKbn.KESSAN.eq(pSnkiSyunyupSyuturyokuKbn)) {

            denYmdTyousei = pSrSinkeiyakuSyuunyuupToukeiParam.getKijyunymd();
        }
        else {

            denYmdTyousei = pSnkiykSyunyup.getSrsyoriymd().addBusinessDays(1);
        }


        String saimankiKykhyouji = SrCommonConstants.HYOUJI_NASI;

        if (C_HknkknsmnKbn.SAIMANKI.eq(pMosSyouhn.getHknkknsmnkbn())) {

            saimankiKykhyouji = SrCommonConstants.HYOUJI_ARI;
        }

        String syuunoukeirokbn = "";

        if (C_Hrkkeiro.HURIKAE.eq(pSnkiykSyunyup.getHrkkeiro())) {
            syuunoukeirokbn = SrCommonConstants.SYUUNOUKEIROKBN_HURIKAERYOURITU;
        }
        else if (C_Hrkkeiro.KOUHURI.eq(pSnkiykSyunyup.getHrkkeiro())) {
            syuunoukeirokbn = SrCommonConstants.SYUUNOUKEIROKBN_KZHURIKAERYOURITU;
        }
        else if (C_Hrkkeiro.CREDIT.eq(pSnkiykSyunyup.getHrkkeiro())) {
            syuunoukeirokbn = SrCommonConstants.SYUUNOUKEIROKBN_CREDITRYOURITU;
        }
        else {
            syuunoukeirokbn = SrCommonConstants.SYUUNOUKEIROKBN_SONOTA;
        }

        BizDateYM jyuutouym = null;

        if (pToukipZennoupRecordKbn == SrCommonConstants.TOUKIPZENNOUP_RECORDKBN_TOUKIP) {
            jyuutouym = pSnkiykSyunyup.getKykymd().getBizDateYM();
        }
        else {
            jyuutouym = pSnkiykSyunyup.getKykymd().addYears(1).getBizDateYM();
        }

        String jyuutoukaisuu = "";

        if (C_Hrkkaisuu.ITIJI.eq(pSnkiykSyunyup.getHrkkaisuu())) {
            jyuutoukaisuu = JUUTOUKAISUUHARAI;
        }
        else {
            if (pToukipZennoupRecordKbn == SrCommonConstants.TOUKIPZENNOUP_RECORDKBN_TOUKIP) {

                int jyutoukaisuuy = 0;
                int jyutoukaisuum = 0;

                for (IT_NyknJissekiRireki nyknJissekiRireki : pNyknJissekiRirekiLst) {

                    jyutoukaisuuy = jyutoukaisuuy + nyknJissekiRireki.getJyutoukaisuuy();
                    jyutoukaisuum = jyutoukaisuum + nyknJissekiRireki.getJyutoukaisuum();
                }

                if (C_Hrkkaisuu.NEN.eq(pSnkiykSyunyup.getHrkkaisuu())) {

                    jyutoukaisuum = jyutoukaisuum + (jyutoukaisuuy * SrCommonConstants.KIKAN_12M);
                    jyutoukaisuuy = 0;
                }

                jyuutoukaisuu = Strings.padStart(String.valueOf(jyutoukaisuuy), 2, '0')
                    + Strings.padStart(String.valueOf(jyutoukaisuum), 2, '0');
            }
            else {
                jyuutoukaisuu = Strings.padStart(pSnkiykSyunyup.getZennoukikan(), 2, '0') + "00";
            }
        }

        String zennoukbn = "";

        if (pToukipZennoupRecordKbn == SrCommonConstants.TOUKIPZENNOUP_RECORDKBN_TOUKIP) {

            zennoukbn = SrCommonConstants.ZENNOUKBN_IPPAN;
        }
        else {

            zennoukbn = SrCommonConstants.ZENNOUKBN_ZENNOU;
        }

        C_SuuriAnnaiFuyouRiyuuKbn annaihuyouriyuukbn = C_SuuriAnnaiFuyouRiyuuKbn.ANNAITYUU;

        if (C_Hrkkaisuu.ITIJI.eq(pSnkiykSyunyup.getHrkkaisuu())) {

            annaihuyouriyuukbn = C_SuuriAnnaiFuyouRiyuuKbn.ITIJI;
        }

        String haraikomikaisukbn = "";
        srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(C_SrKbnHenkanKbn.HRK_KAISUU, pSnkiykSyunyup.getHrkkaisuu().getValue());

        if (C_ErrorKbn.ERROR.eq(srSuuriKbnHenkanBean.getKekkaKbn())) {

            String msg = MessageUtil.getMessage(MessageId.ESA1002, C_SrKbnHenkanKbn.HRK_KAISUU.getContent(),
                pSnkiykSyunyup.getSyono(), pSnkiykSyunyup.getHrkkaisuu().getValue());

            batchLogger.warn(msg);

            ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

            suuriyouErrJyouhou.setSyoriYmd(pSrSinkeiyakuSyuunyuupToukeiParam.getSyoriYmd());
            suuriyouErrJyouhou.setKakutyoujobcd(pSrSinkeiyakuSyuunyuupToukeiParam.getIbKakutyoujobcd());
            suuriyouErrJyouhou.setSyono(pSnkiykSyunyup.getSyono());
            suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);
            suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

            ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

            pSrSinkeiyakuSyuunyuupToukeiParam.setZokkouErrorSyoriCount(pSrSinkeiyakuSyuunyuupToukeiParam.getZokkouErrorSyoriCount() + 1);

            result = true;
        }
        else {
            haraikomikaisukbn = srSuuriKbnHenkanBean.getHenkanAtoKbn();
        }

        String ryouritukbn = "";

        if (C_Hrkkaisuu.ITIJI.eq(pSnkiykSyunyup.getHrkkaisuu()) ||
                C_Hrkkaisuu.NEN.eq(pSnkiykSyunyup.getHrkkaisuu()) ||
                C_Hrkkaisuu.HALFY.eq(pSnkiykSyunyup.getHrkkaisuu())) {

            ryouritukbn = C_SuuriRyourituKbn.OTHER.getValue();
        }
        else {
            if (C_Hrkkeiro.HURIKAE.eq(pSnkiykSyunyup.getHrkkeiro())) {
                ryouritukbn = C_SuuriRyourituKbn.OTHER.getValue();
            }
            else if (C_Hrkkeiro.KOUHURI.eq(pSnkiykSyunyup.getHrkkeiro())) {
                ryouritukbn = C_SuuriRyourituKbn.KOUHURI.getValue();
            }
            else if (C_Hrkkeiro.CREDIT.eq(pSnkiykSyunyup.getHrkkeiro())) {
                ryouritukbn = C_SuuriRyourituKbn.CREDIT.getValue();
            }
        }

        BizCurrency haraikomip;
        BizCurrency syukykp;
        String syuunoukbn;

        if (pSyouhin == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN ||
            pSyouhin == SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN) {

            haraikomip = pSnkiykSyunyup.getHeijyunp();
            syukykp = pMosSyouhn.getHrktuukasyutkp();
            syuunoukbn = SHUUNOUKBNINIT;
        }
        else {

            haraikomip = pSnkiykSyunyup.getHyouteip();
            syukykp = pMosSyouhn.getSyutkp();
            syuunoukbn = SHUUNOUKBNHARAI;
        }

        String sinnyuukinkbn = "";
        if (C_Hrkkaisuu.ITIJI.eq(pSnkiykSyunyup.getHrkkaisuu())) {

            sinnyuukinkbn = SrCommonConstants.SINNYUUKINKBN_ITIJIBARAI;
        }
        else {
            if (pToukipZennoupRecordKbn == SrCommonConstants.TOUKIPZENNOUP_RECORDKBN_TOUKIP) {

                sinnyuukinkbn = SrCommonConstants.SINNYUUKINKBN_IPPAN;
            }
            else {

                sinnyuukinkbn = SrCommonConstants.SINNYUUKINKBN_ZENNOU;
            }
        }

        if (C_SnkiSyunyupSyuturyokuKbn.REIGETU.eq(pSnkiSyunyupSyuturyokuKbn)) {
            pSkeisynyptoukeirigTy.setZtydatakanrino(dataKanriNo);
            pSkeisynyptoukeirigTy.setZtysyoricd("RGHF");
            pSkeisynyptoukeirigTy.setZtyrendoukbn(RENDOUKBNSINKEIYAKU);
            pSkeisynyptoukeirigTy.setZtysyuunoukeirokbn(syuunoukeirokbn);
            pSkeisynyptoukeirigTy.setZtysuitousisya(busituCd);
            pSkeisynyptoukeirigTy.setZtysyuukinym(
                pSnkiykSyunyup.getSrsyoriymd().addBusinessDays(1).getBizDateYM().toString());
            pSkeisynyptoukeirigTy.setZtyjyuutouym(jyuutouym.toString());
            pSkeisynyptoukeirigTy.setZtyjyuutoukaisuu(jyuutoukaisuu);
            pSkeisynyptoukeirigTy.setZtyzennoukbn(zennoukbn);
            pSkeisynyptoukeirigTy.setZtyrecordkbn(RECORDKBNKASHIKATA);
            pSkeisynyptoukeirigTy.setZtysetrenseimrtikatakbn(SrCommonConstants.DEFAULT_STRING_ZERO_1);
            pSkeisynyptoukeirigTy.setZtyhaitoukbn(wkHaitoukbn);
            pSkeisynyptoukeirigTy.setZtysyukeiyakupwaribikikbnx2(WARIBIKINASHI);
            pSkeisynyptoukeirigTy.setZtysetkaigomaruteikatakbn(SrCommonConstants.DEFAULT_STRING_ZERO_1);
            pSkeisynyptoukeirigTy.setZtydenymd(denYmdTyousei.toString());
            pSkeisynyptoukeirigTy.setZtysyonendosyokaip(new BigDecimal(syonendosyokaip.toAdsoluteString()).longValue());
            pSkeisynyptoukeirigTy.setZtysyonendo2kaimeikoup(new BigDecimal(syonendo2kaimeikoup.toAdsoluteString()).longValue());
            pSkeisynyptoukeirigTy.setZtyjinendoikoup(new BigDecimal(jinendoikoup.toAdsoluteString()).longValue());
            pSkeisynyptoukeirigTy.setZtyhknsyukigou(pMosSyouhn.getSyouhncd());
            pSkeisynyptoukeirigTy.setZtysaimnkkykhyj(saimankiKykhyouji);
            pSkeisynyptoukeirigTy.setZtyhknkkn(String.valueOf(pMosSyouhn.getHknkkn()));
            pSkeisynyptoukeirigTy.setZtyphrkkikn(String.valueOf(pMosSyouhn.getHrkkkn()));
            pSkeisynyptoukeirigTy.setZtyhihokensyaagev2(String.valueOf(pSnkiykSyunyup.getHhknnen()));
            pSkeisynyptoukeirigTy.setZtykyksyanen(String.valueOf(kyknen));
            pSkeisynyptoukeirigTy.setZtykykymd(pSnkiykSyunyup.getKykymd().toString());
            pSkeisynyptoukeirigTy.setZtyhhknseikbn(pSnkiykSyunyup.getHhknsei().getValue());
            pSkeisynyptoukeirigTy.setZtyannaifuyouriyuukbn(annaihuyouriyuukbn.getValue());
            pSkeisynyptoukeirigTy.setZtyhrkkaisuukbn(haraikomikaisukbn);
            pSkeisynyptoukeirigTy.setZtysdpdkbn(pSnkiykSyunyup.getSdpdkbn().getValue());
            pSkeisynyptoukeirigTy.setZtyryouritukbn(ryouritukbn);
            pSkeisynyptoukeirigTy.setZtytksyuannaikykkbn(SrCommonConstants.TKSYUANNAIKYKKBN_TAISYOUGAI);
            pSkeisynyptoukeirigTy.setZtyhknsyuruikigousedaikbn(pMosSyouhn.getRyouritusdno());
            pSkeisynyptoukeirigTy.setZtypmenhukakbn(SrCommonConstants.PMENHUKAKBN_PMENTKYKNASI);
            pSkeisynyptoukeirigTy.setZtykihons(new BigDecimal(seitouKihonS.toAdsoluteString()).longValue());
            pSkeisynyptoukeirigTy.setZtyaatukaisosikicd(aatsukaishasoshikicd);
            pSkeisynyptoukeirigTy.setZtyaatukaikojincd(aatukaikojincd);
            pSkeisynyptoukeirigTy.setZtybsyym(pSnkiykSyunyup.getSeisekiym().toString());
            pSkeisynyptoukeirigTy.setZtyharaikomip(new BigDecimal(haraikomip.toAdsoluteString()).longValue());
            pSkeisynyptoukeirigTy.setZtysyukeiyakup(new BigDecimal(syukykp.toAdsoluteString()).longValue());
            pSkeisynyptoukeirigTy.setZtysyuunoukbn(syuunoukbn);
            pSkeisynyptoukeirigTy.setZtytkykkumkhnsyukosuu(SrCommonConstants.DEFAULT_INT_ZERO);
            pSkeisynyptoukeirigTy.setZtysinnyuukinkbn(sinnyuukinkbn);
            pSkeisynyptoukeirigTy.setZtykbnkeiriyousegmentcd(kbnkeirisegcd.getValue());
            pSkeisynyptoukeirigTy.setZtystdssytikbn(SrCommonConstants.HKNSYKGUYBI1X1_SONOTA);
            pSkeisynyptoukeirigTy.setZtysotodasimanagehyouji(SrCommonConstants.HYOUJI_ARI);
            pSkeisynyptoukeirigTy.setZtysotodasiphkbnmnoshyouji(SrCommonConstants.HYOUJI_ARI);
            pSkeisynyptoukeirigTy.setZtystdsstkjytkyuhyj(SrCommonConstants.HYOUJI_ARI);
            pSkeisynyptoukeirigTy.setZtykousinmanryouage(SrCommonConstants.DEFAULT_STRING_ZERO_2);
            pSkeisynyptoukeirigTy.setZtysotodasipmenkbn(SrCommonConstants.HKNSYKGUYBI3X2_PMENTKYKNASI);
            pSkeisynyptoukeirigTy.setZtytokubetuhosyoukikan(SrCommonConstants.DEFAULT_STRING_ZERO_2);
            pSkeisynyptoukeirigTy.setZtytenkanminaosikbn(TENKANKBNSONOTA);
            pSkeisynyptoukeirigTy.setZtyhhknnentysihyj(hhknsyaagetyouseihyj);
            pSkeisynyptoukeirigTy.setZtykyksyaagetyouseihyj(kyksyaagetyouseihyj);
            pSkeisynyptoukeirigTy.setZtysykykhokenhoutekiyouhyj(SrCommonConstants.HYOUJI_ARI);
            pSkeisynyptoukeirigTy.setZtytkjykbn(TOJYOKBNSAKUGEN);
            pSkeisynyptoukeirigTy.setZtydai2tokujyoukbn(SECONDTOJYOKBNSAKUGEN);
            pSkeisynyptoukeirigTy.setZtybosyuukeitaikbn(bosyuukeitaikbn);
            pSkeisynyptoukeirigTy.setZtysyukeiyakusyuruicdv3(syukeiyakusyuruicd);
        }
        else if (C_SnkiSyunyupSyuturyokuKbn.KESSAN.eq(pSnkiSyunyupSyuturyokuKbn)) {
            pSkeisynyptoukeiksnTy.setZtydatakanrino(dataKanriNo);
            pSkeisynyptoukeiksnTy.setZtysyoricd("RGHF");
            pSkeisynyptoukeiksnTy.setZtyrendoukbn(RENDOUKBNSINKEIYAKU);
            pSkeisynyptoukeiksnTy.setZtysyuunoukeirokbn(syuunoukeirokbn);
            pSkeisynyptoukeiksnTy.setZtysuitousisya(busituCd);
            pSkeisynyptoukeiksnTy.setZtysyuukinym(
                pSnkiykSyunyup.getSrsyoriymd().addBusinessDays(1).getBizDateYM().toString());
            pSkeisynyptoukeiksnTy.setZtyjyuutouym(jyuutouym.toString());
            pSkeisynyptoukeiksnTy.setZtyjyuutoukaisuu(jyuutoukaisuu);
            pSkeisynyptoukeiksnTy.setZtyzennoukbn(zennoukbn);
            pSkeisynyptoukeiksnTy.setZtyrecordkbn(RECORDKBNKASHIKATA);
            pSkeisynyptoukeiksnTy.setZtysetrenseimrtikatakbn(SrCommonConstants.DEFAULT_STRING_ZERO_1);
            pSkeisynyptoukeiksnTy.setZtyhaitoukbn(wkHaitoukbn);
            pSkeisynyptoukeiksnTy.setZtysyukeiyakupwaribikikbnx2(WARIBIKINASHI);
            pSkeisynyptoukeiksnTy.setZtysetkaigomaruteikatakbn(SrCommonConstants.DEFAULT_STRING_ZERO_1);
            pSkeisynyptoukeiksnTy.setZtydenymd(denYmdTyousei.toString());
            pSkeisynyptoukeiksnTy.setZtysyonendosyokaip(new BigDecimal(syonendosyokaip.toAdsoluteString()).longValue());
            pSkeisynyptoukeiksnTy.setZtysyonendo2kaimeikoup(new BigDecimal(syonendo2kaimeikoup.toAdsoluteString()).longValue());
            pSkeisynyptoukeiksnTy.setZtyjinendoikoup(new BigDecimal(jinendoikoup.toAdsoluteString()).longValue());
            pSkeisynyptoukeiksnTy.setZtyhknsyukigou(pMosSyouhn.getSyouhncd());
            pSkeisynyptoukeiksnTy.setZtysaimnkkykhyj(saimankiKykhyouji);
            pSkeisynyptoukeiksnTy.setZtyhknkkn(String.valueOf(pMosSyouhn.getHknkkn()));
            pSkeisynyptoukeiksnTy.setZtyphrkkikn(String.valueOf(pMosSyouhn.getHrkkkn()));
            pSkeisynyptoukeiksnTy.setZtyhihokensyaagev2(String.valueOf(pSnkiykSyunyup.getHhknnen()));
            pSkeisynyptoukeiksnTy.setZtykyksyanen(String.valueOf(kyknen));
            pSkeisynyptoukeiksnTy.setZtykykymd(pSnkiykSyunyup.getKykymd().toString());
            pSkeisynyptoukeiksnTy.setZtyhhknseikbn(pSnkiykSyunyup.getHhknsei().getValue());
            pSkeisynyptoukeiksnTy.setZtyannaifuyouriyuukbn(annaihuyouriyuukbn.getValue());
            pSkeisynyptoukeiksnTy.setZtyhrkkaisuukbn(haraikomikaisukbn);
            pSkeisynyptoukeiksnTy.setZtysdpdkbn(pSnkiykSyunyup.getSdpdkbn().getValue());
            pSkeisynyptoukeiksnTy.setZtyryouritukbn(ryouritukbn);
            pSkeisynyptoukeiksnTy.setZtytksyuannaikykkbn(SrCommonConstants.TKSYUANNAIKYKKBN_TAISYOUGAI);
            pSkeisynyptoukeiksnTy.setZtyhknsyuruikigousedaikbn(pMosSyouhn.getRyouritusdno());
            pSkeisynyptoukeiksnTy.setZtypmenhukakbn(SrCommonConstants.PMENHUKAKBN_PMENTKYKNASI);
            pSkeisynyptoukeiksnTy.setZtykihons(new BigDecimal(seitouKihonS.toAdsoluteString()).longValue());
            pSkeisynyptoukeiksnTy.setZtyaatukaisosikicd(aatsukaishasoshikicd);
            pSkeisynyptoukeiksnTy.setZtyaatukaikojincd(aatukaikojincd);
            pSkeisynyptoukeiksnTy.setZtybsyym(pSnkiykSyunyup.getSeisekiym().toString());
            pSkeisynyptoukeiksnTy.setZtyharaikomip(new BigDecimal(haraikomip.toAdsoluteString()).longValue());
            pSkeisynyptoukeiksnTy.setZtysyukeiyakup(new BigDecimal(syukykp.toAdsoluteString()).longValue());
            pSkeisynyptoukeiksnTy.setZtysyuunoukbn(syuunoukbn);
            pSkeisynyptoukeiksnTy.setZtytkykkumkhnsyukosuu(SrCommonConstants.DEFAULT_INT_ZERO);
            pSkeisynyptoukeiksnTy.setZtysinnyuukinkbn(sinnyuukinkbn);
            pSkeisynyptoukeiksnTy.setZtykbnkeiriyousegmentcd(kbnkeirisegcd.getValue());
            pSkeisynyptoukeiksnTy.setZtystdssytikbn(SrCommonConstants.HKNSYKGUYBI1X1_SONOTA);
            pSkeisynyptoukeiksnTy.setZtysotodasimanagehyouji(SrCommonConstants.HYOUJI_ARI);
            pSkeisynyptoukeiksnTy.setZtysotodasiphkbnmnoshyouji(SrCommonConstants.HYOUJI_ARI);
            pSkeisynyptoukeiksnTy.setZtystdsstkjytkyuhyj(SrCommonConstants.HYOUJI_ARI);
            pSkeisynyptoukeiksnTy.setZtykousinmanryouage(SrCommonConstants.DEFAULT_STRING_ZERO_2);
            pSkeisynyptoukeiksnTy.setZtysotodasipmenkbn(SrCommonConstants.HKNSYKGUYBI3X2_PMENTKYKNASI);
            pSkeisynyptoukeiksnTy.setZtytokubetuhosyoukikan(SrCommonConstants.DEFAULT_STRING_ZERO_2);
            pSkeisynyptoukeiksnTy.setZtytenkanminaosikbn(TENKANKBNSONOTA);
            pSkeisynyptoukeiksnTy.setZtyhhknnentysihyj(hhknsyaagetyouseihyj);
            pSkeisynyptoukeiksnTy.setZtykyksyaagetyouseihyj(kyksyaagetyouseihyj);
            pSkeisynyptoukeiksnTy.setZtysykykhokenhoutekiyouhyj(SrCommonConstants.HYOUJI_ARI);
            pSkeisynyptoukeiksnTy.setZtytkjykbn(TOJYOKBNSAKUGEN);
            pSkeisynyptoukeiksnTy.setZtydai2tokujyoukbn(SECONDTOJYOKBNSAKUGEN);
            pSkeisynyptoukeiksnTy.setZtybosyuukeitaikbn(bosyuukeitaikbn);
            pSkeisynyptoukeiksnTy.setZtysyukeiyakusyuruicdv3(syukeiyakusyuruicd);
        }

        if (pToukipZennoupRecordKbn == SrCommonConstants.TOUKIPZENNOUP_RECORDKBN_TOUKIP) {
            if (pSyouhin == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {

                pSynypTukiTugtTykiyuHozon.setZtydatakanrino(dataKanriNo);
                pSynypTukiTugtTykiyuHozon.setZtyjyuutouym(jyuutouym.toString());
                pSynypTukiTugtTykiyuHozon.setZtyjyuutoukaisuu(jyuutoukaisuu);
                pSynypTukiTugtTykiyuHozon.setZtyrecordkbn(RECORDKBNKASHIKATA);
                pSynypTukiTugtTykiyuHozon.setZtydenymd(denYmdTyousei.toString());
                pSynypTukiTugtTykiyuHozon.setZtykbnkeiriyousegmentcd(kbnkeirisegcd.getValue());
            }
        }
    }

    public void editRayData(SrSinkeiyakuSyuunyuupToukeiParam pSrSinkeiyakuSyuunyuupToukeiParam,
        C_SnkiSyunyupSyuturyokuKbn pSnkiSyunyupSyuturyokuKbn, SV_SnkiykSyunyup pSnkiykSyunyup, HT_MosSyouhn pMosSyouhn,
        HT_Nyuukin pNyuukin, ZT_SkeisynyptoukeirigTy pSkeisynyptoukeirigTy,
        ZT_SkeisynyptoukeiksnTy pSkeisynyptoukeiksnTy, ST_SynypTukiTugtTykiyuHozon pSynypTukiTugtTykiyuHozon,
        int pSyouhin, IT_KhSisuurendoTmttkn pKhSisuurendoTmttkn, int pToukipZennoupRecordKbn) {

        String wkGaikakbn = "";

        SrSuuriKbnHenkanSet srSuuriKbnHenkanSet = SWAKInjector.getInstance(SrSuuriKbnHenkanSet.class);

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(C_SrKbnHenkanKbn.SUURI_KEIYAKUDATE_TUUKA,
            pSnkiykSyunyup.getKyktuukasyu().getValue());

        if(C_ErrorKbn.ERROR.eq(srSuuriKbnHenkanBean.getKekkaKbn())){

            String msg = MessageUtil.getMessage(MessageId.ESA1002, C_SrKbnHenkanKbn.SUURI_KEIYAKUDATE_TUUKA.getContent(),
                pSnkiykSyunyup.getSyono(), pSnkiykSyunyup.getKyktuukasyu().getValue());

            batchLogger.warn(msg);

            ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

            suuriyouErrJyouhou.setSyoriYmd(pSrSinkeiyakuSyuunyuupToukeiParam.getSyoriYmd());
            suuriyouErrJyouhou.setKakutyoujobcd(pSrSinkeiyakuSyuunyuupToukeiParam.getIbKakutyoujobcd());
            suuriyouErrJyouhou.setSyono(pSnkiykSyunyup.getSyono());
            suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);
            suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

            ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

            pSrSinkeiyakuSyuunyuupToukeiParam.setZokkouErrorSyoriCount(pSrSinkeiyakuSyuunyuupToukeiParam.getZokkouErrorSyoriCount() + 1);

            result = true;
        }
        else {
            wkGaikakbn = srSuuriKbnHenkanBean.getHenkanAtoKbn();
        }

        BizNumber kykjikawaserate = BizNumber.valueOf(0);
        BizDate kykjikawaseratetkyuymd = null;

        C_KawaserateSyuruiKbn kawaserateSyuruiKbn;
        C_KawasetsryKbn kawasetsryKbn;
        BizDate kwsratekjymd;
        C_ErrorKbn errorKbn;
        if (!C_Tuukasyu.JPY.eq(pSnkiykSyunyup.getKyktuukasyu())) {
            if (C_Tuukasyu.JPY.eq(pSnkiykSyunyup.getHrktuukasyu())) {

                kawaserateSyuruiKbn = C_KawaserateSyuruiKbn.KOUJIKAWASERATE;
                kawasetsryKbn = C_KawasetsryKbn.NYUKINRATE;
            }
            else {

                kawaserateSyuruiKbn = C_KawaserateSyuruiKbn.PM17JIKAWASERATE;
                kawasetsryKbn = C_KawasetsryKbn.JISSEIRATE;
            }

            if (SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN == pSyouhin
                || (SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN == pSyouhin
                && C_UmuKbn.NONE.eq(pSnkiykSyunyup.getZennoumousideumu()))) {

                kwsratekjymd = pNyuukin.getRyosyuymd().addBusinessDays(-1);
            }
            else {

                kwsratekjymd = pNyuukin.getRyosyuymd();
            }

            GetKawaseRate getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);

            errorKbn = getKawaseRate.exec(kwsratekjymd, kawaserateSyuruiKbn,
                pSnkiykSyunyup.getKyktuukasyu(), C_Tuukasyu.JPY, C_KawasetekiyoKbn.TTM, kawasetsryKbn,
                C_EigyoubiHoseiKbn.YOKUEIGYOUBI, C_YouhiKbn.HUYOU);

            if(C_ErrorKbn.ERROR.eq(errorKbn)){

                String msg = MessageUtil.getMessage(MessageId.ESA1004, String.valueOf(pNyuukin.getRyosyuymd()),
                    kawaserateSyuruiKbn.getValue(), pSnkiykSyunyup.getKyktuukasyu().getValue(), C_Tuukasyu.JPY.getValue(),
                    C_KawasetekiyoKbn.TTM.getValue(), kawasetsryKbn.getValue(), C_EigyoubiHoseiKbn.YOKUEIGYOUBI.getValue(),
                    C_YouhiKbn.HUYOU.getValue());

                batchLogger.warn(msg);

                ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

                suuriyouErrJyouhou.setSyoriYmd(pSrSinkeiyakuSyuunyuupToukeiParam.getSyoriYmd());
                suuriyouErrJyouhou.setKakutyoujobcd(pSrSinkeiyakuSyuunyuupToukeiParam.getIbKakutyoujobcd());
                suuriyouErrJyouhou.setSyono(pSnkiykSyunyup.getSyono());
                suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);
                suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

                ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

                pSrSinkeiyakuSyuunyuupToukeiParam.setZokkouErrorSyoriCount(pSrSinkeiyakuSyuunyuupToukeiParam.getZokkouErrorSyoriCount() + 1);

                result = true;
            }
            else {

                kykjikawaserate = getKawaseRate.getKawaserate();
                kykjikawaseratetkyuymd = getKawaseRate.getKwsrateKjYmd();
            }

            if (!pSnkiykSyunyup.getKyktuukasyu().eq(pSnkiykSyunyup.getHrktuukasyu()) &&
                (C_Tuukasyu.AUD.eq(pSnkiykSyunyup.getHrktuukasyu()) || C_Tuukasyu.USD.eq(pSnkiykSyunyup.getHrktuukasyu()))) {


                BizNumber crossRate = BizNumber.valueOf(0);

                errorKbn = getKawaseRate.exec(
                    pNyuukin.getRyosyuymd(),
                    C_KawaserateSyuruiKbn.KOUJIKAWASERATE,
                    pSnkiykSyunyup.getKyktuukasyu(),
                    pSnkiykSyunyup.getHrktuukasyu(),
                    C_KawasetekiyoKbn.TTM,
                    C_KawasetsryKbn.NYUKINRATE,
                    C_EigyoubiHoseiKbn.YOKUEIGYOUBI,
                    C_YouhiKbn.HUYOU);

                if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                    String msg = MessageUtil.getMessage(
                        MessageId.ESA1004,
                        String.valueOf(pNyuukin.getRyosyuymd()),
                        C_KawaserateSyuruiKbn.KOUJIKAWASERATE.getValue(),
                        pSnkiykSyunyup.getKyktuukasyu().getValue(),
                        pSnkiykSyunyup.getHrktuukasyu().getValue(),
                        C_KawasetekiyoKbn.TTM.getValue(),
                        C_KawasetsryKbn.NYUKINRATE.getValue(),
                        C_EigyoubiHoseiKbn.YOKUEIGYOUBI.getValue(),
                        C_YouhiKbn.HUYOU.getValue());

                    batchLogger.warn(msg);

                    ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

                    suuriyouErrJyouhou.setSyoriYmd(pSrSinkeiyakuSyuunyuupToukeiParam.getSyoriYmd());
                    suuriyouErrJyouhou.setKakutyoujobcd(pSrSinkeiyakuSyuunyuupToukeiParam.getIbKakutyoujobcd());
                    suuriyouErrJyouhou.setSyono(pSnkiykSyunyup.getSyono());
                    suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);
                    suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

                    ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

                    pSrSinkeiyakuSyuunyuupToukeiParam.setZokkouErrorSyoriCount(
                        pSrSinkeiyakuSyuunyuupToukeiParam.getZokkouErrorSyoriCount() + 1);

                    result = true;
                }
                else {

                    crossRate = getKawaseRate.getKawaserate();
                }


                SrSuuriGouseiRateKeisan srSuuriGouseiRateKeisan = SWAKInjector.getInstance(SrSuuriGouseiRateKeisan.class);

                SrSuuriGouseiRateKeisanBean srSuuriGouseiRateKeisanBean = srSuuriGouseiRateKeisan.exec(
                    pNyuukin.getRyosyuymd(), pSnkiykSyunyup.getHrktuukasyu(), crossRate);

                if (C_ErrorKbn.ERROR.eq(srSuuriGouseiRateKeisanBean.getErrorKbn())) {

                    SetErrMessageInfoBean setErrMessageInfoBean = srSuuriGouseiRateKeisanBean.getErrMessageInfoBean();

                    String msg = MessageUtil.getMessage(
                        MessageId.ESA1004,
                        String.valueOf(setErrMessageInfoBean.getKwsrateKjYmd()),
                        setErrMessageInfoBean.getKawaserateSyuruiKbn().getValue(),
                        setErrMessageInfoBean.getMotoTuukasyu().getValue(),
                        setErrMessageInfoBean.getKansanTuukasyu().getValue(),
                        setErrMessageInfoBean.getKawasetekiyoKbn().getValue(),
                        setErrMessageInfoBean.getKawasetsryKbn().getValue(),
                        setErrMessageInfoBean.getEigyoubiHoseiKbn().getValue(),
                        setErrMessageInfoBean.getYouhiKbn().getValue());

                    batchLogger.warn(msg + "：合成レート");

                    ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

                    suuriyouErrJyouhou.setSyoriYmd(pSrSinkeiyakuSyuunyuupToukeiParam.getSyoriYmd());
                    suuriyouErrJyouhou.setKakutyoujobcd(pSrSinkeiyakuSyuunyuupToukeiParam.getIbKakutyoujobcd());
                    suuriyouErrJyouhou.setSyono(pSnkiykSyunyup.getSyono());
                    suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg + "：合成レート");
                    suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

                    ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

                    pSrSinkeiyakuSyuunyuupToukeiParam.setZokkouErrorSyoriCount(
                        pSrSinkeiyakuSyuunyuupToukeiParam.getZokkouErrorSyoriCount() + 1);

                    result = true;

                }
                else {
                    kykjikawaserate = srSuuriGouseiRateKeisanBean.getSuuriGouseiRate();
                }
            }
        }

        BizNumber nyknjikwsrate = BizNumber.ZERO;
        BizDate nyknjikawaseratetkyuymd = null;
        if (SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN == pSyouhin
            && !C_Tuukasyu.JPY.eq(pSnkiykSyunyup.getKyktuukasyu())) {

            nyknjikwsrate = kykjikawaserate;
            nyknjikawaseratetkyuymd = kykjikawaseratetkyuymd;
        }


        BizCurrency enkdtsbujsitihsyukngk;

        if (C_UmuKbn.ARI.eq(pSnkiykSyunyup.getInitsbjiyensitihsytkhukaumu())) {

            SrSinkeiyakuSyuunyuupToukeiDbaStatement srSinkeiyakuSyuunyuupToukeiDbaStatement =
                SWAKInjector.getInstance(SrSinkeiyakuSyuunyuupToukeiDbaStatement.class);

            List<KhHenkouRirekiBfrnaiyouoriginalNewnaiyouoriginalBySyonoBean> khHenkouRirekiBeanList =
                srSinkeiyakuSyuunyuupToukeiDbaStatement.getKhHenkouRirekiBfrnaiyouoriginalNewnaiyouoriginalBySyono(
                    pSnkiykSyunyup.getSyono());

            if (khHenkouRirekiBeanList == null || khHenkouRirekiBeanList.size() == 0) {

                enkdtsbujsitihsyukngk = pSnkiykSyunyup.getInitsbjiyenkasaiteihsygk();

            }
            else {

                String kingakuStr = khHenkouRirekiBeanList.get(0).getBfrnaiyouoriginal();
                enkdtsbujsitihsyukngk = BizCurrency.valueOf(new BigDecimal(kingakuStr));
            }
        }
        else {
            enkdtsbujsitihsyukngk = BizCurrency.valueOf(0);
        }

        String nyuukintuukakbn = "";

        srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(C_SrKbnHenkanKbn.SUURI_NYUUSYUKKIN_TUUKA,
            pSnkiykSyunyup.getHrktuukasyu().getValue());

        if(C_ErrorKbn.ERROR.eq(srSuuriKbnHenkanBean.getKekkaKbn())){

            String msg = MessageUtil.getMessage(MessageId.ESA1002, C_SrKbnHenkanKbn.SUURI_NYUUSYUKKIN_TUUKA.getContent(),
                pSnkiykSyunyup.getSyono(), pSnkiykSyunyup.getHrktuukasyu().getValue());

            batchLogger.warn(msg);

            ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

            suuriyouErrJyouhou.setSyoriYmd(pSrSinkeiyakuSyuunyuupToukeiParam.getSyoriYmd());
            suuriyouErrJyouhou.setKakutyoujobcd(pSrSinkeiyakuSyuunyuupToukeiParam.getIbKakutyoujobcd());
            suuriyouErrJyouhou.setSyono(pSnkiykSyunyup.getSyono());
            suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);
            suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

            ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

            pSrSinkeiyakuSyuunyuupToukeiParam.setZokkouErrorSyoriCount(pSrSinkeiyakuSyuunyuupToukeiParam.getZokkouErrorSyoriCount() + 1);

            result = true;
        }
        else {
            nyuukintuukakbn  = srSuuriKbnHenkanBean.getHenkanAtoKbn();
        }


        String tumitatekinHaibunWariKbn = "";

        if (SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR == pSyouhin ||
            SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20 == pSyouhin) {

            if (C_TumitatekinHaibunWariKbn.BLNK.eq(pSnkiykSyunyup.getSisuuhaibunwarikbn())) {

            }
            else {

                tumitatekinHaibunWariKbn = pSnkiykSyunyup.getSisuuhaibunwarikbn().getValue();
            }

        }


        String sisuuKbn = "";

        if (SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR == pSyouhin ||
            SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20 == pSyouhin) {

            srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(C_SrKbnHenkanKbn.SUURI_SISUU,
                pSnkiykSyunyup.getSisuukbn().getValue());

            if (C_ErrorKbn.ERROR.eq(srSuuriKbnHenkanBean.getKekkaKbn())) {

                String msg = MessageUtil.getMessage(
                    MessageId.ESA1002,
                    C_SrKbnHenkanKbn.SUURI_SISUU.getContent(),
                    pSnkiykSyunyup.getSyono(),
                    pSnkiykSyunyup.getSisuukbn().getValue());

                batchLogger.warn(msg);

                ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

                suuriyouErrJyouhou.setSyoriYmd(pSrSinkeiyakuSyuunyuupToukeiParam.getSyoriYmd());
                suuriyouErrJyouhou.setKakutyoujobcd(pSrSinkeiyakuSyuunyuupToukeiParam.getIbKakutyoujobcd());
                suuriyouErrJyouhou.setSyono(pSnkiykSyunyup.getSyono());
                suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);
                suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

                ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

                pSrSinkeiyakuSyuunyuupToukeiParam.setZokkouErrorSyoriCount(pSrSinkeiyakuSyuunyuupToukeiParam.getZokkouErrorSyoriCount() + 1);

                result = true;
            }

            else {

                sisuuKbn = srSuuriKbnHenkanBean.getHenkanAtoKbn();
            }
        }

        String tuukaSyurui = "";

        srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(C_SrKbnHenkanKbn.TUUKA_SYU,
            pSnkiykSyunyup.getKyktuukasyu().getValue());

        if (C_ErrorKbn.ERROR.eq(srSuuriKbnHenkanBean.getKekkaKbn())) {

            String msg = MessageUtil.getMessage(
                MessageId.ESA1002,
                C_SrKbnHenkanKbn.TUUKA_SYU.getContent(),
                pSnkiykSyunyup.getSyono(),
                pSnkiykSyunyup.getKyktuukasyu().getValue());

            batchLogger.warn(msg);

            ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

            suuriyouErrJyouhou.setSyoriYmd(pSrSinkeiyakuSyuunyuupToukeiParam.getSyoriYmd());
            suuriyouErrJyouhou.setKakutyoujobcd(pSrSinkeiyakuSyuunyuupToukeiParam.getIbKakutyoujobcd());
            suuriyouErrJyouhou.setSyono(pSnkiykSyunyup.getSyono());
            suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);
            suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

            ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

            pSrSinkeiyakuSyuunyuupToukeiParam.setZokkouErrorSyoriCount(pSrSinkeiyakuSyuunyuupToukeiParam.getZokkouErrorSyoriCount() + 1);

            result = true;
        }
        else {
            tuukaSyurui = srSuuriKbnHenkanBean.getHenkanAtoKbn();
        }


        SetManryoubi setManryoubi = SWAKInjector.getInstance(SetManryoubi.class);
        KeisanSisuuRendouNkTmttknOverNnd keisanSisuuRendouNkTmttknOverNnd = SWAKInjector.getInstance(
            KeisanSisuuRendouNkTmttknOverNnd.class);
        BizCurrency nkGns = BizCurrency.valueOf(0);

        if (SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR == pSyouhin ||
            SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20 == pSyouhin) {

            BizDate hknKknManryouYmd = setManryoubi.exec(pSnkiykSyunyup.getKykymd(), pSnkiykSyunyup.getHhknnen(),
                pMosSyouhn.getHknkkn(), C_KknsmnKbn.valueOf(pMosSyouhn.getHknkknsmnkbn().getValue()));

            errorKbn = keisanSisuuRendouNkTmttknOverNnd.exec(
                pSnkiykSyunyup.getKykymd(),
                pMosSyouhn.getHknkkn(),
                pSnkiykSyunyup.getTeikishrtkykhukaumu(),
                pSnkiykSyunyup.getKyktuukasyu(),
                hknKknManryouYmd,
                hknKknManryouYmd.getBizDateYM(),
                pKhSisuurendoTmttkn.getTmttkntaisyouym(),
                pMosSyouhn.getTumitateriritu(),
                pKhSisuurendoTmttkn.getTeiritutmttkngk(),
                pKhSisuurendoTmttkn.getSisuurendoutmttkngk());

            if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                String msg = MessageUtil.getMessage(
                    MessageId.ESA1001,
                    "年金原資",
                    pSnkiykSyunyup.getSyono());

                batchLogger.warn(msg);

                ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

                suuriyouErrJyouhou.setSyoriYmd(pSrSinkeiyakuSyuunyuupToukeiParam.getSyoriYmd());
                suuriyouErrJyouhou.setKakutyoujobcd(pSrSinkeiyakuSyuunyuupToukeiParam.getIbKakutyoujobcd());
                suuriyouErrJyouhou.setSyono(pSnkiykSyunyup.getSyono());
                suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);
                suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

                ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

                pSrSinkeiyakuSyuunyuupToukeiParam.setZokkouErrorSyoriCount(
                    pSrSinkeiyakuSyuunyuupToukeiParam.getZokkouErrorSyoriCount() + 1);

                result = true;
            }

            else {

                nkGns = keisanSisuuRendouNkTmttknOverNnd.getTmttkngkkei();
            }
        }


        BizCurrency sisuuBbnTounyuuGk = BizCurrency.valueOf(0);

        if (SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR == pSyouhin ||
            SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20 == pSyouhin) {

            sisuuBbnTounyuuGk = pKhSisuurendoTmttkn.getSisuurendoutmttkngk();
        }

        BizCurrency zennoujiikkatubaraijytgk = BizCurrency.valueOf(0);

        if (C_UmuKbn.ARI.eq(pSnkiykSyunyup.getZennoumousideumu())
            && pToukipZennoupRecordKbn == SrCommonConstants.TOUKIPZENNOUP_RECORDKBN_TOUKIP) {

            zennoujiikkatubaraijytgk = pSnkiykSyunyup.getZennoujyuutoup();
        }

        BizCurrency gaikadatesyukeiyakup = BizCurrency.valueOf(0);

        if (SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN == pSyouhin &&
            !C_Tuukasyu.JPY.eq(pSnkiykSyunyup.getKyktuukasyu())) {

            gaikadatesyukeiyakup = pMosSyouhn.getHrktuukasyutkp();
        }

        if (C_SnkiSyunyupSyuturyokuKbn.REIGETU.eq(pSnkiSyunyupSyuturyokuKbn)) {
            pSkeisynyptoukeirigTy.setZtyraysystemhyj(SrCommonConstants.HYOUJI_ARI);
            pSkeisynyptoukeirigTy.setZtygaikakbn(wkGaikakbn);
            pSkeisynyptoukeirigTy.setZtykykjikawaserate(kykjikawaserate);

            if (kykjikawaseratetkyuymd != null) {
                pSkeisynyptoukeirigTy.setZtykykjikawaseratetkyuymd(String.valueOf(kykjikawaseratetkyuymd));
            }

            pSkeisynyptoukeirigTy.setZtykeiyakujiyoteiriritu(pMosSyouhn.getYoteiriritu());
            pSkeisynyptoukeirigTy.setZtyenkdtsbujsitihsyukngk(new BigDecimal(enkdtsbujsitihsyukngk.toAdsoluteString()).longValue());
            pSkeisynyptoukeirigTy.setZtynyuukintuukakbn(nyuukintuukakbn);
            pSkeisynyptoukeirigTy.setZtysisuurendourate(tumitatekinHaibunWariKbn);
            pSkeisynyptoukeirigTy.setZtysisuukbn(sisuuKbn);
            pSkeisynyptoukeirigTy.setZtynyknjikawaserate(nyknjikwsrate);

            if (nyknjikawaseratetkyuymd != null) {
                pSkeisynyptoukeirigTy.setZtynyknjikawaseratetkyuymd(String.valueOf(nyknjikawaseratetkyuymd));
            }

            pSkeisynyptoukeirigTy.setZtysrdai1hknkkn(String.valueOf(pMosSyouhn.getDai1hknkkn()));
            pSkeisynyptoukeirigTy.setZtytuukasyukbn(tuukaSyurui);
            pSkeisynyptoukeirigTy.setZtynkgns(new BigDecimal(nkGns.toAdsoluteString()).longValue());
            pSkeisynyptoukeirigTy.setZtysisuubbntounyuugk(new BigDecimal(sisuuBbnTounyuuGk.toAdsoluteString()).longValue());
            pSkeisynyptoukeirigTy.setZtyzennoujiikkatubaraijytgk(new BigDecimal(zennoujiikkatubaraijytgk.toAdsoluteString()).longValue());
            pSkeisynyptoukeirigTy.setZtygaikadatesyukeiyakup(new BigDecimal(gaikadatesyukeiyakup.toAdsoluteString()).longValue());
        }
        else if (C_SnkiSyunyupSyuturyokuKbn.KESSAN.eq(pSnkiSyunyupSyuturyokuKbn)) {
            pSkeisynyptoukeiksnTy.setZtyraysystemhyj(SrCommonConstants.HYOUJI_ARI);
            pSkeisynyptoukeiksnTy.setZtygaikakbn(wkGaikakbn);
            pSkeisynyptoukeiksnTy.setZtykykjikawaserate(kykjikawaserate);

            if (kykjikawaseratetkyuymd != null) {
                pSkeisynyptoukeiksnTy.setZtykykjikawaseratetkyuymd(String.valueOf(kykjikawaseratetkyuymd));
            }

            pSkeisynyptoukeiksnTy.setZtykeiyakujiyoteiriritu(pMosSyouhn.getYoteiriritu());
            pSkeisynyptoukeiksnTy.setZtyenkdtsbujsitihsyukngk(new BigDecimal(enkdtsbujsitihsyukngk.toAdsoluteString()).longValue());
            pSkeisynyptoukeiksnTy.setZtynyuukintuukakbn(nyuukintuukakbn);
            pSkeisynyptoukeiksnTy.setZtysisuurendourate(tumitatekinHaibunWariKbn);
            pSkeisynyptoukeiksnTy.setZtysisuukbn(sisuuKbn);
            pSkeisynyptoukeiksnTy.setZtynyknjikawaserate(nyknjikwsrate);

            if (nyknjikawaseratetkyuymd != null) {
                pSkeisynyptoukeiksnTy.setZtynyknjikawaseratetkyuymd(String.valueOf(nyknjikawaseratetkyuymd));
            }

            pSkeisynyptoukeiksnTy.setZtysrdai1hknkkn(String.valueOf(pMosSyouhn.getDai1hknkkn()));
            pSkeisynyptoukeiksnTy.setZtytuukasyukbn(tuukaSyurui);
            pSkeisynyptoukeiksnTy.setZtynkgns(new BigDecimal(nkGns.toAdsoluteString()).longValue());
            pSkeisynyptoukeiksnTy.setZtysisuubbntounyuugk(new BigDecimal(sisuuBbnTounyuuGk.toAdsoluteString()).longValue());
            pSkeisynyptoukeiksnTy.setZtyzennoujiikkatubaraijytgk(new BigDecimal(zennoujiikkatubaraijytgk.toAdsoluteString()).longValue());
            pSkeisynyptoukeiksnTy.setZtygaikadatesyukeiyakup(new BigDecimal(gaikadatesyukeiyakup.toAdsoluteString()).longValue());
        }

        if (pToukipZennoupRecordKbn == SrCommonConstants.TOUKIPZENNOUP_RECORDKBN_TOUKIP) {
            if (pSyouhin == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {

                pSynypTukiTugtTykiyuHozon.setZtyzennoujiikkatubaraijytgk(new BigDecimal(zennoujiikkatubaraijytgk
                    .toAdsoluteString()).longValue());
            }
        }
    }
    public void editHeaderData(SrSinkeiyakuSyuunyuupToukeiParam pSrSinkeiyakuSyuunyuupToukeiParam,
        C_SnkiSyunyupSyuturyokuKbn pSnkiSyunyupSyuturyokuKbn, ZT_SkeisynyptoukeirigTy pSkeisynyptoukeirigTy,
        ZT_SkeisynyptoukeiksnTy pSkeisynyptoukeiksnTy) {

        int sequenceno = 0;

        int yuukourecordlength = 0;

        String rdwArea = "";

        if (C_SnkiSyunyupSyuturyokuKbn.REIGETU.eq(pSnkiSyunyupSyuturyokuKbn)) {

            sequenceno = pSrSinkeiyakuSyuunyuupToukeiParam.getReigetuSyoriCount();
            pSrSinkeiyakuSyuunyuupToukeiParam.setReigetuSyoriCount(pSrSinkeiyakuSyuunyuupToukeiParam
                .getReigetuSyoriCount() + 1);
            int palpxre550length = YuyuSuuriConfig.getInstance().getPalpxre550length();
            int palpxre551length = YuyuSuuriConfig.getInstance().getPalpxre551length();
            int palpxre853length = YuyuSuuriConfig.getInstance().getPalprre853length();
            int palrdwarealength = YuyuSuuriConfig.getInstance().getPalrdwarealength();
            rdwArea = "";

            yuukourecordlength = palrdwarealength + palpxre550length + palpxre853length +
                (palpxre551length * pSkeisynyptoukeirigTy.getZtytkykkumkhnsyukosuu());
        }
        else if (C_SnkiSyunyupSyuturyokuKbn.KESSAN.eq(pSnkiSyunyupSyuturyokuKbn)) {
            sequenceno = pSrSinkeiyakuSyuunyuupToukeiParam.getKessanSyoriCount();
            pSrSinkeiyakuSyuunyuupToukeiParam.setKessanSyoriCount(pSrSinkeiyakuSyuunyuupToukeiParam
                .getKessanSyoriCount() + 1);
            int palpxre550length = YuyuSuuriConfig.getInstance().getPalpxre550length();
            int palpxre551length = YuyuSuuriConfig.getInstance().getPalpxre551length();
            int palpxre853length = YuyuSuuriConfig.getInstance().getPalprre853length();
            int palrdwarealength = YuyuSuuriConfig.getInstance().getPalrdwarealength();
            rdwArea = "";

            yuukourecordlength = palrdwarealength + palpxre550length + palpxre853length +
                (palpxre551length * pSkeisynyptoukeiksnTy.getZtytkykkumkhnsyukosuu());
        }

        if (C_SnkiSyunyupSyuturyokuKbn.REIGETU.eq(pSnkiSyunyupSyuturyokuKbn)) {
            pSkeisynyptoukeirigTy.setZtysequenceno(sequenceno);
            pSkeisynyptoukeirigTy.setZtyyuukourecordlength(yuukourecordlength);
            pSkeisynyptoukeirigTy.setZtyrdwarea(rdwArea);
        }
        else if (C_SnkiSyunyupSyuturyokuKbn.KESSAN.eq(pSnkiSyunyupSyuturyokuKbn)) {
            pSkeisynyptoukeiksnTy.setZtysequenceno(sequenceno);
            pSkeisynyptoukeiksnTy.setZtyyuukourecordlength(yuukourecordlength);
            pSkeisynyptoukeiksnTy.setZtyrdwarea(rdwArea);
        }
    }

    public void editUniqueData(SrSinkeiyakuSyuunyuupToukeiParam pSrSinkeiyakuSyuunyuupToukeiParam,
        C_SnkiSyunyupSyuturyokuKbn pSnkiSyunyupSyuturyokuKbn, BT_DenpyoData pDenpyoData,
        ST_SynypTukiTugtTykiyuHozon pSynypTukiTugtTykiyuHozon) {

        pSynypTukiTugtTykiyuHozon.setZtysrkijyunym(String.valueOf(pSrSinkeiyakuSyuunyuupToukeiParam.getKijyunymd().getBizDateYM()));
        pSynypTukiTugtTykiyuHozon.setZtysrkakutyoujobcd(pSrSinkeiyakuSyuunyuupToukeiParam.getIbKakutyoujobcd());
        pSynypTukiTugtTykiyuHozon.setZtysequenceno(Integer.valueOf(
            pSrSinkeiyakuSyuunyuupToukeiParam.getItijihozonSyoriCount() + pSnkiSyunyupSyuturyokuKbn.getValue()));
        pSynypTukiTugtTykiyuHozon.setZtysyoricd(pDenpyoData.getSyoricd());
        pSynypTukiTugtTykiyuHozon.setZtyhenkousyoriymd(String.valueOf(pDenpyoData.getSyoriYmd()));
        pSynypTukiTugtTykiyuHozon.setZtysrdenrenno(pDenpyoData.getDenrenno());

        pSrSinkeiyakuSyuunyuupToukeiParam.setItijihozonSyoriCount(pSrSinkeiyakuSyuunyuupToukeiParam.getItijihozonSyoriCount() + 1);
    }

}
