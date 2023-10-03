package yuyu.batch.suuri.srsuuritoukei.srsibouriturendou;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBTransactionalUtil;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.SetHokenNenrei;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.common.suuri.srcommon.SrCommonConstants;
import yuyu.common.suuri.srcommon.SrSuuriKbnHenkanBean;
import yuyu.common.suuri.srcommon.SrSuuriKbnHenkanSet;
import yuyu.def.MessageId;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_KokutiKbn;
import yuyu.def.classification.C_SntkhouKbn;
import yuyu.def.classification.C_SrKbnHenkanKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.HT_MosSyouhn;
import yuyu.def.db.entity.ST_SuuriyouErrJyouhou;
import yuyu.def.db.entity.SV_SibourituRendou;
import yuyu.def.db.entity.ZT_SbRituRendouTy;
import yuyu.def.hozen.result.bean.KhHenkouRirekiBfrnaiyouoriginalNewnaiyouoriginalBySyonoBean;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 死亡率用連動情報作成項目編集
 */
public class SrSibourituRendouItemEditor {

    private static final String RENDOUYOUITIJI = "00";

    private static final String RENDOUYOUSYOSINHOUJYOUSINSAHOUHOUKUBUNMUSENTAKU = "00";

    private static final String RENDOUYOUSYOSINHOUJYOUSINSAHOUHOUKUBUNKOKUTISYOATUKAI = "01";

    private static final String RENDOUYOUSYOSINHOUJYOUSINSAHOUHOUKUBUNKANIKOKUTI = "03";

    private static final String RENDOUYOUSYOSINHOUJYOUSINSAHOUHOUKUBUNSYOKUGYOUNOMIKOKUTI = "05";

    private static final String RENDOUYOUSYOSINHOUJYOUSINSAHOUHOUKUBUNMUKOKUTI = "07";

    private static final int BUNWARI100 = 100;

    private static final String BOSYUUDAIRITENATKIKEITAIKBNDAIRITENKYOUDOU = "3";

    private static final String BOSYUUDAIRITENATKIKEITAIKBNTANDOKU = "1";

    private static final String RENDOUYOUHOUHOUKBNITIJI = "00";

    private static final String RENDOUYOUHOUHOUKBNHURIKAE_TUKI = "75";

    private static final String RENDOUYOUHOUHOUKBNHURIKAE_NEN = "15";

    private static final String RENDOUYOUHOUHOUKBNHURIKAE_HALFY = "25";

    private static final String RENDOUYOUHOUHOUKBNCREDIT = "76";

    private static final String FILEKBNSEIRITUBN = "1";

    private static final String BOSYUUKEIROKBNMDHN = "2";

    private static final String KEIYAKUSYAHOUJINKBNKEIYAKUSYAHOUJINIGAI = "2";

    private static final String IMUSATEIYOUKNSNSYTRYSKBNNASI = "0";

    private static final Integer TAIKAKUSIRUBETENHYOUJYUNKARADA = 100;

    private static final Integer SOUSIRUBENTEN100 = 100;

    private Boolean errorFlag;

    @Inject
    private BatchLogger batchLogger;

    public SrSibourituRendouItemEditor() {

        errorFlag = false;
    }

    public Boolean editKoumoku(SrSibourituRendouBatchParam pSrSibourituRendouBatchParam,
        SV_SibourituRendou pSibourituRendou, HT_MosSyouhn pMosSyouhn, ZT_SbRituRendouTy pSbRituRendouTy,
        int pSyohinHanteiKbn) {

        SrSibourituRendouDbaStatement srSibourituRendouDbaStatement = SWAKInjector
            .getInstance(SrSibourituRendouDbaStatement.class);

        BM_SyouhnZokusei syouhnZokusei = srSibourituRendouDbaStatement.getSyouhnZokuseiMstDate(
            pMosSyouhn.getSyouhncd(), pMosSyouhn.getSyouhnsdno());

        editShibourituToukeiData(pSrSibourituRendouBatchParam, pSibourituRendou, pMosSyouhn, syouhnZokusei,
            pSbRituRendouTy, pSyohinHanteiKbn);

        editShibourituToukeiRAYData(pSrSibourituRendouBatchParam, pSibourituRendou, pMosSyouhn,
            pSbRituRendouTy, pSyohinHanteiKbn);

        return errorFlag;
    }

    private void editShibourituToukeiData(SrSibourituRendouBatchParam pSrSibourituRendouParam,
        SV_SibourituRendou pSibourituRendou, HT_MosSyouhn pMosSyouhn, BM_SyouhnZokusei pSyouhnZokusei,
        ZT_SbRituRendouTy pSbRituRendouTy, int pSyohinHanteiKbn) {

        String dataKanriNo = pSibourituRendou.getSyono();

        String saimnkkykhyj = "";
        if (C_HknkknsmnKbn.SAIMANKI.eq(pMosSyouhn.getHknkknsmnkbn())) {

            saimnkkykhyj = SrCommonConstants.HYOUJI_ARI;
        }
        else {

            saimnkkykhyj = SrCommonConstants.HYOUJI_NASI;
        }

        String rendouKikan = RENDOUYOUITIJI;

        BizCurrency rendouyoukihons = BizCurrency.valueOf(0);
        BizCurrency rendouyousibous = BizCurrency.valueOf(0);

        if (pSyohinHanteiKbn == SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN &&
            C_Tuukasyu.JPY.eq(pSibourituRendou.getKyktuukasyu())) {

            rendouyoukihons = pMosSyouhn.getSeitoukihons().divide(SrCommonConstants.YEN_10000, 0, RoundingMode.HALF_UP);
            rendouyousibous = pSibourituRendou.getPharaikomisougaku().divide(2).divide(SrCommonConstants.YEN_10000, 0, RoundingMode.HALF_UP);
        }

        String rendouyouHouhouKbn = "";

        if (C_Hrkkaisuu.ITIJI.eq(pSibourituRendou.getHrkkaisuu())) {

            rendouyouHouhouKbn = RENDOUYOUHOUHOUKBNITIJI;
        }
        else {

            if (C_Hrkkaisuu.TUKI.eq(pSibourituRendou.getHrkkaisuu())) {

                if (C_Hrkkeiro.KOUHURI.eq(pSibourituRendou.getHrkkeiro())
                    || C_Hrkkeiro.HURIKAE.eq(pSibourituRendou.getHrkkeiro())) {

                    rendouyouHouhouKbn = RENDOUYOUHOUHOUKBNHURIKAE_TUKI;
                }
                else if (C_Hrkkeiro.CREDIT.eq(pSibourituRendou.getHrkkeiro())) {

                    rendouyouHouhouKbn = RENDOUYOUHOUHOUKBNCREDIT;
                }
            }
            else if (C_Hrkkaisuu.HALFY.eq(pSibourituRendou.getHrkkaisuu())) {

                rendouyouHouhouKbn = RENDOUYOUHOUHOUKBNHURIKAE_HALFY;
            }
            else if (C_Hrkkaisuu.NEN.eq(pSibourituRendou.getHrkkaisuu())) {

                rendouyouHouhouKbn = RENDOUYOUHOUHOUKBNHURIKAE_NEN;
            }
        }

        SrSuuriKbnHenkanSet srSuuriKbnHenkanSet = SWAKInjector.getInstance(SrSuuriKbnHenkanSet.class);

        String ketteiketkakubun = "";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(C_SrKbnHenkanKbn.KETTEI_KEKKA,
            pSibourituRendou.getKetkekkacd().getValue());

        if (C_ErrorKbn.ERROR.eq(srSuuriKbnHenkanBean.getKekkaKbn())) {

            String msg = MessageUtil.getMessage(MessageId.ESA1002, C_SrKbnHenkanKbn.KETTEI_KEKKA.getContent(),
                pSibourituRendou.getSyono(), pSibourituRendou.getKetkekkacd().getValue());

            batchLogger.warn(msg);

            ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();
            suuriyouErrJyouhou.setSyoriYmd(pSrSibourituRendouParam.getSyoriYmd());
            suuriyouErrJyouhou.setKakutyoujobcd(pSrSibourituRendouParam.getIbKakutyoujobcd());
            suuriyouErrJyouhou.setSyono(pSibourituRendou.getSyono());
            suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);
            suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

            ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

            pSrSibourituRendouParam.setErrorkensuu(pSrSibourituRendouParam.getErrorkensuu() + 1);

            errorFlag = true;
        }

        else {

            ketteiketkakubun = srSuuriKbnHenkanBean.getHenkanAtoKbn();
        }

        String keiyakukakuninsyuruikubun = "";

        if (pSibourituRendou.getKykkaksyrui() != null) {

            srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(C_SrKbnHenkanKbn.KEIYAKU_KAKUNI_SYU,
                pSibourituRendou.getKykkaksyrui().getValue());

            if (C_ErrorKbn.ERROR.eq(srSuuriKbnHenkanBean.getKekkaKbn())) {

                String msg = MessageUtil.getMessage(MessageId.ESA1002,
                    C_SrKbnHenkanKbn.KEIYAKU_KAKUNI_SYU.getContent(),
                    pSibourituRendou.getSyono(), pSibourituRendou.getKykkaksyrui().getValue());

                batchLogger.warn(msg);

                ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();
                suuriyouErrJyouhou.setSyoriYmd(pSrSibourituRendouParam.getSyoriYmd());
                suuriyouErrJyouhou.setKakutyoujobcd(pSrSibourituRendouParam.getIbKakutyoujobcd());
                suuriyouErrJyouhou.setSyono(pSibourituRendou.getSyono());
                suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);
                suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

                ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

                pSrSibourituRendouParam.setErrorkensuu(pSrSibourituRendouParam.getErrorkensuu() + 1);

                errorFlag = true;
            }

            else {

                keiyakukakuninsyuruikubun = srSuuriKbnHenkanBean.getHenkanAtoKbn();
            }
        }

        String rendouyousyosinhoujyousinsahouhoukubun = "";

        if (C_SntkhouKbn.KKT.eq(pSibourituRendou.getSntkhoukbn())) {

            if (C_KokutiKbn.KANIKOKUTI.eq(pSyouhnZokusei.getKokutikbn())) {

                rendouyousyosinhoujyousinsahouhoukubun = RENDOUYOUSYOSINHOUJYOUSINSAHOUHOUKUBUNKANIKOKUTI;
            }

            else {

                rendouyousyosinhoujyousinsahouhoukubun = RENDOUYOUSYOSINHOUJYOUSINSAHOUHOUKUBUNKOKUTISYOATUKAI;
            }
        }

        else if (C_SntkhouKbn.SYOKUGYOU.eq(pSibourituRendou.getSntkhoukbn())) {

            rendouyousyosinhoujyousinsahouhoukubun = RENDOUYOUSYOSINHOUJYOUSINSAHOUHOUKUBUNSYOKUGYOUNOMIKOKUTI;
        }

        else if (C_SntkhouKbn.NONE.eq(pSibourituRendou.getSntkhoukbn())) {

            rendouyousyosinhoujyousinsahouhoukubun = RENDOUYOUSYOSINHOUJYOUSINSAHOUHOUKUBUNMUKOKUTI;
        }

        else {

            rendouyousyosinhoujyousinsahouhoukubun = RENDOUYOUSYOSINHOUJYOUSINSAHOUHOUKUBUNMUKOKUTI;
        }

        String haitoukubun = "";

        srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(C_SrKbnHenkanKbn.SUURI_HAITOU, pSibourituRendou
            .getHaitoukbn().getValue());

        if (C_ErrorKbn.ERROR.eq(srSuuriKbnHenkanBean.getKekkaKbn())) {

            String msg = MessageUtil.getMessage(MessageId.ESA1002, C_SrKbnHenkanKbn.SUURI_HAITOU.getContent(),
                pSibourituRendou.getSyono(),
                pSibourituRendou.getHaitoukbn().getValue());

            batchLogger.warn(msg);

            ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();
            suuriyouErrJyouhou.setSyoriYmd(pSrSibourituRendouParam.getSyoriYmd());
            suuriyouErrJyouhou.setKakutyoujobcd(pSrSibourituRendouParam.getIbKakutyoujobcd());
            suuriyouErrJyouhou.setSyono(pSibourituRendou.getSyono());
            suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);
            suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

            ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

            pSrSibourituRendouParam.setErrorkensuu(pSrSibourituRendouParam.getErrorkensuu() + 1);

            errorFlag = true;
        }

        else {

            haitoukubun = srSuuriKbnHenkanBean.getHenkanAtoKbn();
        }

        Integer taikakusirubeten = TAIKAKUSIRUBETENHYOUJYUNKARADA;

        SetHokenNenrei setHokenNenrei = SWAKInjector.getInstance(SetHokenNenrei.class);

        int hkNenrei = setHokenNenrei.exec(pSibourituRendou.getKykymd(), pSibourituRendou.getHhknseiymd());

        String hhknNenTysiHyj = "";

        if (hkNenrei != pSibourituRendou.getHhknnen()) {

            hhknNenTysiHyj = SrCommonConstants.HYOUJI_ARI;
        }

        else {

            hhknNenTysiHyj = SrCommonConstants.HYOUJI_NASI;
        }

        String aAtsukaishaSoshikiCd = pSibourituRendou.getDrtenkanrisosikicd();

        String aAtukaiKojinCd = pSibourituRendou.getDaibosyuucd();

        String bosyuuDairitenAtkiKeitaiKbn = "";

        if (!BizNumber.valueOf(BUNWARI100).equals(pSibourituRendou.getBunwari())) {

            bosyuuDairitenAtkiKeitaiKbn = BOSYUUDAIRITENATKIKEITAIKBNDAIRITENKYOUDOU;
        }

        else {

            bosyuuDairitenAtkiKeitaiKbn = BOSYUUDAIRITENATKIKEITAIKBNTANDOKU;
        }

        String bosyuuDairitenCd = pSibourituRendou.getOyadrtencd();

        String suuriyoubosyuukeitaikubun = "";

        srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(C_SrKbnHenkanKbn.BOSYU_KEITAI,
            pSibourituRendou.getTratkiagcd());

        if (C_ErrorKbn.ERROR.eq(srSuuriKbnHenkanBean.getKekkaKbn())) {

            String msg = MessageUtil.getMessage(MessageId.ESA1002, C_SrKbnHenkanKbn.BOSYU_KEITAI.getContent(),
                pSibourituRendou.getSyono(),
                pSibourituRendou.getTratkiagcd());

            batchLogger.warn(msg);

            ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();
            suuriyouErrJyouhou.setSyoriYmd(pSrSibourituRendouParam.getSyoriYmd());
            suuriyouErrJyouhou.setKakutyoujobcd(pSrSibourituRendouParam.getIbKakutyoujobcd());
            suuriyouErrJyouhou.setSyono(pSibourituRendou.getSyono());
            suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);
            suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

            ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

            pSrSibourituRendouParam.setErrorkensuu(pSrSibourituRendouParam.getErrorkensuu() + 1);

            errorFlag = true;
        }

        else {

            suuriyoubosyuukeitaikubun = srSuuriKbnHenkanBean.getHenkanAtoKbn();
        }

        pSbRituRendouTy.setZtydatakanrino(dataKanriNo);
        pSbRituRendouTy.setZtyhknsyukigou(pMosSyouhn.getSyouhncd());
        pSbRituRendouTy.setZtysaimnkkykhyj(saimnkkykhyj);
        pSbRituRendouTy.setZtyrendouyoukikan(rendouKikan);
        pSbRituRendouTy.setZtyhihokensyaagev2(String.valueOf(pSibourituRendou.getHhknnen()));
        pSbRituRendouTy.setZtyhhknseikbn(pSibourituRendou.getHhknsei().getValue());
        pSbRituRendouTy.setZtyrendouyoukeiyakunengetu(String.valueOf(pSibourituRendou.getKykymd().getBizDateYM()));
        pSbRituRendouTy.setZtyrendouyoukihons(new BigDecimal(rendouyoukihons.toAdsoluteString()).intValue());
        pSbRituRendouTy.setZtyrendouyousibous(new BigDecimal(rendouyousibous.toAdsoluteString()).intValue());
        pSbRituRendouTy.setZtyrendouyouhrkhouhoukbn(rendouyouHouhouKbn);
        pSbRituRendouTy.setZtyrendouyoujyuusyokbn(pSibourituRendou.getHhkntodouhukencd());
        pSbRituRendouTy.setZtyaatukaisosikicd(aAtsukaishaSoshikiCd);
        pSbRituRendouTy.setZtyrendouyoubosyuuym(String.valueOf(pSibourituRendou.getBosyuuym()));
        pSbRituRendouTy.setZtysykgycd(pSibourituRendou.getHhknsykgycd());
        pSbRituRendouTy.setZtydakuhikettisyacd(pSibourituRendou.getPalketsyacd());
        pSbRituRendouTy.setZtyketteikekkakbn(ketteiketkakubun);
        pSbRituRendouTy.setZtykeiyakukakuninsyuruikbn(keiyakukakuninsyuruikubun);
        pSbRituRendouTy.setZtyrndyusysnhujyusnshuhukbn(rendouyousyosinhoujyousinsahouhoukubun);
        pSbRituRendouTy.setZtysintyou(pSibourituRendou.getSintyou());
        pSbRituRendouTy.setZtytaijyuu(pSibourituRendou.getTaijyuu());
        pSbRituRendouTy.setZtykituenkbn(SrCommonConstants.KITUENKBN_HUMEI);
        pSbRituRendouTy.setZtyhaitoukbn(haitoukubun);
        pSbRituRendouTy.setZtyaatukaikojincd(aAtukaiKojinCd);
        pSbRituRendouTy.setZtyfilekbn(FILEKBNSEIRITUBN);
        pSbRituRendouTy.setZtytaikakuhyouten(taikakusirubeten);
        pSbRituRendouTy.setZtysekininkaisiymd(String.valueOf(pSibourituRendou.getSknnkaisiymd()));
        pSbRituRendouTy.setZtysouhyouten(SOUSIRUBENTEN100);
        pSbRituRendouTy.setZtytoukeiyukykymd(String.valueOf(pSibourituRendou.getKykymd()));
        pSbRituRendouTy.setZtydakuhiketteiriyuucdx1(pSibourituRendou.getKetriyuucd1().getValue());
        pSbRituRendouTy.setZtydakuhiketteiriyuucdx2(pSibourituRendou.getKetriyuucd2().getValue());
        pSbRituRendouTy.setZtydakuhiketteiriyuucdx3(pSibourituRendou.getKetriyuucd3().getValue());
        pSbRituRendouTy.setZtydakuhiketteiriyuucdx4(pSibourituRendou.getKetriyuucd4().getValue());
        pSbRituRendouTy.setZtyhknsyuruikigousedaikbn(pMosSyouhn.getRyouritusdno());
        pSbRituRendouTy.setZtyhhknsynensyuukbn(pSibourituRendou.getHhknnensyuukbn().getValue());
        pSbRituRendouTy.setZtybosyuukeirokbn(BOSYUUKEIROKBNMDHN);
        pSbRituRendouTy.setZtybsudirtnatkikeitaikbn(bosyuuDairitenAtkiKeitaiKbn);
        pSbRituRendouTy.setZtyhokensyuruikigouyobi1x1(SrCommonConstants.HKNSYKGUYBI1X1_SONOTA);
        pSbRituRendouTy.setZtyhokensyuruikigouyobi1x2(SrCommonConstants.HKNSYKGUYBI1X2_MANNENREIHOUSIKI);
        pSbRituRendouTy.setZtyhokensyuruikigouyobi1x3(SrCommonConstants.HKNSYKGUYBI1X3_SINHOKENHOUTEKIYOU);
        pSbRituRendouTy.setZtyhokensyuruikigouyobi1x4(SrCommonConstants.HKNSYKGUYBI1X4_SINTOKUJYOUTEKIYOU);
        pSbRituRendouTy.setZtyhokensyuruikigouyobi3x1(SrCommonConstants.HKNSYKGUYBI3X1_MUSINSA);
        pSbRituRendouTy.setZtyhokensyuruikigouyobi3x2(SrCommonConstants.HKNSYKGUYBI3X2_PMENTKYKNASI);
        pSbRituRendouTy.setZtykeiyakusyahoujinkbn(KEIYAKUSYAHOUJINKBNKEIYAKUSYAHOUJINIGAI);
        pSbRituRendouTy.setZtyhyujynkttidkhkttikekkacd(pSibourituRendou.getKetkekkacd().getValue());
        pSbRituRendouTy.setZtyhyujynkttidkhkttiryucdx1(pSibourituRendou.getKetriyuucd1().getValue());
        pSbRituRendouTy.setZtyhyujynkttidkhkttiryucdx2(pSibourituRendou.getKetriyuucd2().getValue());
        pSbRituRendouTy.setZtyhyujynkttidkhkttiryucdx3(pSibourituRendou.getKetriyuucd3().getValue());
        pSbRituRendouTy.setZtyhyujynkttidkhkttiryucdx4(pSibourituRendou.getKetriyuucd4().getValue());
        pSbRituRendouTy.setZtyoyabosyuudairitencd(bosyuuDairitenCd);
        pSbRituRendouTy.setZtysuuriyoubosyuukeitaikbn(suuriyoubosyuukeitaikubun);
        pSbRituRendouTy.setZtyhihokensyahokenage(String.valueOf(hkNenrei));
        pSbRituRendouTy.setZtyhhknnentysihyj(hhknNenTysiHyj);
        pSbRituRendouTy.setZtyimusateiyouknsnsytryskbn(IMUSATEIYOUKNSNSYTRYSKBNNASI);
    }

    private void editShibourituToukeiRAYData(SrSibourituRendouBatchParam pSrSibourituRendouParam,
        SV_SibourituRendou pSibourituRendou, HT_MosSyouhn pMosSyouhn, ZT_SbRituRendouTy pSbRituRendouTy,
        int pSyouhnZokusei) {

        SrSuuriKbnHenkanSet srSuuriKbnHenkanSet = SWAKInjector.getInstance(SrSuuriKbnHenkanSet.class);

        String gaikakubun = "";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(C_SrKbnHenkanKbn.SUURI_KEIYAKUDATE_TUUKA,
            pSibourituRendou.getKyktuukasyu().getValue());

        if (C_ErrorKbn.ERROR.eq(srSuuriKbnHenkanBean.getKekkaKbn())) {

            String msg = MessageUtil.getMessage(MessageId.ESA1002,
                C_SrKbnHenkanKbn.SUURI_KEIYAKUDATE_TUUKA.getContent(),
                pSibourituRendou.getSyono(),
                pSibourituRendou.getKyktuukasyu().getValue());

            batchLogger.warn(msg);

            ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();
            suuriyouErrJyouhou.setSyoriYmd(pSrSibourituRendouParam.getSyoriYmd());
            suuriyouErrJyouhou.setKakutyoujobcd(pSrSibourituRendouParam.getIbKakutyoujobcd());
            suuriyouErrJyouhou.setSyono(pSibourituRendou.getSyono());
            suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);
            suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

            ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

            pSrSibourituRendouParam.setErrorkensuu(pSrSibourituRendouParam.getErrorkensuu() + 1);

            errorFlag = true;
        }

        else {

            gaikakubun = srSuuriKbnHenkanBean.getHenkanAtoKbn();
        }

        BizCurrency gaikadatekihons = BizCurrency.valueOf(0);

        if (SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR == pSyouhnZokusei ||
            SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20 == pSyouhnZokusei) {

            gaikadatekihons = pMosSyouhn.getSyutkp();
        }
        else if (SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN == pSyouhnZokusei){
        }
        else if (SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN == pSyouhnZokusei){
            if (!C_Tuukasyu.JPY.eq(pSibourituRendou.getKyktuukasyu())) {

                gaikadatekihons = pMosSyouhn.getSeitoukihons();
            }
        }
        else {
            gaikadatekihons = pMosSyouhn.getSeitoukihons();
        }

        BizCurrency gaikadatesibous = BizCurrency.valueOf(0);

        if (SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN == pSyouhnZokusei){
            if (!C_Tuukasyu.JPY.eq(pSibourituRendou.getKyktuukasyu())) {

                gaikadatesibous = pSibourituRendou.getPharaikomisougaku().divide(2, 0, RoundingMode.HALF_UP);
            }
        }
        else if (SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN != pSyouhnZokusei) {

            gaikadatesibous = pMosSyouhn.getSyutkp();
        }

        BizNumber keiyakujiyoteiriritu = BizNumber.valueOf(0);

        if (SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR == pSyouhnZokusei ||
            SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20 == pSyouhnZokusei ||
            SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN == pSyouhnZokusei ||
            SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN == pSyouhnZokusei) {

            keiyakujiyoteiriritu = BizNumber.valueOf(0);
        }
        else {

            keiyakujiyoteiriritu = pMosSyouhn.getYoteiriritu();
        }

        BizCurrency yksbsthskingaku = BizCurrency.valueOf(0);

        if (C_UmuKbn.ARI.eq(pSibourituRendou.getInitsbjiyensitihsytkhukaumu())) {

            SrSibourituRendouDbaStatement srSibourituRendouDbaStatement = SWAKInjector
                .getInstance(SrSibourituRendouDbaStatement.class);

            List<KhHenkouRirekiBfrnaiyouoriginalNewnaiyouoriginalBySyonoBean> khHenkouRirekiBeanList =
                srSibourituRendouDbaStatement.getKhHenkouRirekiBfrnaiyouoriginalNewnaiyouoriginalBySyono(
                    pSibourituRendou.getSyono());

            if (khHenkouRirekiBeanList == null || khHenkouRirekiBeanList.size() == 0) {

                yksbsthskingaku = pSibourituRendou.getInitsbjiyenkasaiteihsygk();
            }
            else {
                String kingakuStr = khHenkouRirekiBeanList.get(0).getBfrnaiyouoriginal();
                yksbsthskingaku = BizCurrency.valueOf(new BigDecimal(kingakuStr));
            }
        }
        else {

            yksbsthskingaku = BizCurrency.valueOf(0);
        }

        String tuukasyukbn = "";

        srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(C_SrKbnHenkanKbn.TUUKA_SYU,
            pSibourituRendou.getKyktuukasyu().getValue());

        if (C_ErrorKbn.ERROR.eq(srSuuriKbnHenkanBean.getKekkaKbn())) {

            String msg = MessageUtil.getMessage(MessageId.ESA1002,
                C_SrKbnHenkanKbn.TUUKA_SYU.getContent(),
                pSibourituRendou.getSyono(),
                pSibourituRendou.getKyktuukasyu().getValue());

            batchLogger.warn(msg);

            ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();
            suuriyouErrJyouhou.setSyoriYmd(pSrSibourituRendouParam.getSyoriYmd());
            suuriyouErrJyouhou.setKakutyoujobcd(pSrSibourituRendouParam.getIbKakutyoujobcd());
            suuriyouErrJyouhou.setSyono(pSibourituRendou.getSyono());
            suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);
            suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

            ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

            pSrSibourituRendouParam.setErrorkensuu(pSrSibourituRendouParam.getErrorkensuu() + 1);

            errorFlag = true;
        }

        else {

            tuukasyukbn = srSuuriKbnHenkanBean.getHenkanAtoKbn();
        }

        pSbRituRendouTy.setZtyraysystemhyj(SrCommonConstants.HYOUJI_ARI);
        pSbRituRendouTy.setZtygaikakbn(gaikakubun);
        pSbRituRendouTy.setZtygaikadatekihons(new BigDecimal(gaikadatekihons.toAdsoluteString()).longValue());
        pSbRituRendouTy.setZtygaikadatesibous(new BigDecimal(gaikadatesibous.toAdsoluteString()).longValue());
        pSbRituRendouTy.setZtykeiyakujiyoteiriritu(keiyakujiyoteiriritu);
        pSbRituRendouTy.setZtyenkdtsbujsitihsyukngk(new BigDecimal(yksbsthskingaku.toAdsoluteString()).longValue());
        pSbRituRendouTy.setZtysrdai1hknkkn(pMosSyouhn.getDai1hknkkn().toString());
        pSbRituRendouTy.setZtytuukasyukbn(tuukasyukbn);
    }
}
