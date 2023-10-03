package yuyu.batch.suuri.srsuuritoukei.srrayjigyohi;

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
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.GetSjkkktyouseiyouriritu;
import yuyu.common.biz.bzcommon.GetSjkkktyouseiyourirituBean;
import yuyu.common.hozen.khcommon.KeisanSisuuRendouNkTmttknOverNnd;
import yuyu.common.hozen.khcommon.KeisanW;
import yuyu.common.hozen.khcommon.KeisanWExtBean;
import yuyu.common.hozen.khcommon.KeisanWKijunYM;
import yuyu.common.suuri.srcommon.KhSisuurendoTmttknBean;
import yuyu.common.suuri.srcommon.SrCommonConstants;
import yuyu.common.suuri.srcommon.SrGetTokutejitenSisuurendoTmttknInfo;
import yuyu.common.suuri.srcommon.SrGetTokutejitenTmttknInfoBean;
import yuyu.common.suuri.suuricommon.SrGetTokutejitenSyohnInfo;
import yuyu.common.suuri.suuricommon.TkJitenKeiyakuSyouhinBean;
import yuyu.common.suuri.suuricommon.TkJitenKeiyakuSyouhinKijyunBean;
import yuyu.def.MessageId;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_KessanKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TmttknhaibunjyoutaiKbn;
import yuyu.def.classification.C_TokutejitenSyoriKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_KhSisuurendoTmttkn;
import yuyu.def.db.entity.ST_HoyuuMeisaiTyukeiyouItzHzn;
import yuyu.def.db.entity.ST_SuuriyouErrJyouhou;
import yuyu.def.db.entity.SV_KiykSyuhnData;
import yuyu.def.db.entity.ZT_KsnRayJigyohiTy;
import yuyu.def.db.entity.ZT_RayJigyohiTy;
import yuyu.infr.batch.logger.BatchLogger;

import com.google.common.collect.Lists;

/**
 * 数理 数理統計 ＲＡＹ事業費情報作成の項目編集クラス
 */
public class SrRayJigyohiBatchEdit {

    private static final String KINOUID_TMTTKNINFOHANEI = "SrGetTokutejitenSisuurendoTmttknInfoHanei";

    private static final String KINOUID_TMTTKNINFOHANEITRKS = "SrGetTokutejitenSisuurendoTmttknInfoHaneiTrks";

    @Inject
    private BatchLogger batchLogger;

    private Boolean errorFlag;

    public Boolean editKoumoku(SrRayJigyohiBatchParam pSrRayJigyohiBatchParam,
        C_KessanKbn pKessanKbn,
        int pRegetuEditTaisyou,
        ST_HoyuuMeisaiTyukeiyouItzHzn pHoyuuMeisaiTyukeiyouItzHzn,
        TkJitenKeiyakuSyouhinKijyunBean pTkJitenKeiyakuSyouhinKijyunBean,
        ZT_RayJigyohiTy pRayJigyohiTy,
        ZT_KsnRayJigyohiTy pKsnRayJigyohiTy,
        TkJitenKeiyakuSyouhinKijyunBean pTkJitenKeiyakuSyouhinKijyunBean_gmjiten) {

        errorFlag = false;

        editHedda(
            pSrRayJigyohiBatchParam,
            pKessanKbn,
            pRayJigyohiTy,
            pKsnRayJigyohiTy);

        editHoyuumeisai(
            pHoyuuMeisaiTyukeiyouItzHzn,
            pKessanKbn,
            pRayJigyohiTy,
            pKsnRayJigyohiTy);

        editRayJigyohi(
            pSrRayJigyohiBatchParam,
            pKessanKbn,
            pRegetuEditTaisyou,
            pHoyuuMeisaiTyukeiyouItzHzn,
            pTkJitenKeiyakuSyouhinKijyunBean,
            pRayJigyohiTy,
            pKsnRayJigyohiTy,
            pTkJitenKeiyakuSyouhinKijyunBean_gmjiten);

        return errorFlag;
    }

    private void editHedda(SrRayJigyohiBatchParam pSrRayJigyohiBatchParam, C_KessanKbn pKessanKbn,
        ZT_RayJigyohiTy pRayJigyohiTy, ZT_KsnRayJigyohiTy pKsnRayJigyohiTy) {

        if (pKessanKbn.eq(C_KessanKbn.TUUJYOU)) {
            int KeyKoumoku = pSrRayJigyohiBatchParam.getReigetuSyoriCount();
            pSrRayJigyohiBatchParam.setReigetuSyoriCount(pSrRayJigyohiBatchParam
                .getReigetuSyoriCount() + 1);
            pRayJigyohiTy.setZtysequenceno(KeyKoumoku);
        }
        else if (pKessanKbn.eq(C_KessanKbn.KESSAN)) {
            int KeyKoumoku = pSrRayJigyohiBatchParam.getKessanSyoriCount();
            pSrRayJigyohiBatchParam.setKessanSyoriCount(pSrRayJigyohiBatchParam
                .getKessanSyoriCount() + 1);
            pKsnRayJigyohiTy.setZtysequenceno(KeyKoumoku);
        }
    }

    private void editHoyuumeisai(ST_HoyuuMeisaiTyukeiyouItzHzn pHoyuuMeisaiTyukeiyouItzHzn, C_KessanKbn pKessanKbn,
        ZT_RayJigyohiTy pRayJigyohiTy, ZT_KsnRayJigyohiTy pKsnRayJigyohiTy) {

        if (pKessanKbn.eq(C_KessanKbn.TUUJYOU)) {
            pRayJigyohiTy.setZtyrecordkbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtyrecordkbn());
            pRayJigyohiTy.setZtynenkinkaisigohyouji(pHoyuuMeisaiTyukeiyouItzHzn.getZtynenkinkaisigohyouji());
            pRayJigyohiTy.setZtynksgokurikosidhyj(pHoyuuMeisaiTyukeiyouItzHzn.getZtynksgokurikosidhyj());
            pRayJigyohiTy.setZtykeijyouym(pHoyuuMeisaiTyukeiyouItzHzn.getZtykeijyouym());
            pRayJigyohiTy.setZtyidojiyukbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtyidojiyukbn());
            pRayJigyohiTy.setZtyzougenkbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtyzougenkbn());
            pRayJigyohiTy.setZtyidourecordkbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtyidourecordkbn());
            pRayJigyohiTy.setZtykeijyouctrlkbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtykeijyouctrlkbn());
            pRayJigyohiTy.setZtyhenkousyoriymd(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhenkousyoriymd());
            pRayJigyohiTy.setZtykykmfksnctr(pHoyuuMeisaiTyukeiyouItzHzn.getZtykykmfksnctr());
            pRayJigyohiTy.setZtyrecordctr(pHoyuuMeisaiTyukeiyouItzHzn.getZtyrecordctr());
            pRayJigyohiTy.setZtysuuriyoukouryokukaisiymd(pHoyuuMeisaiTyukeiyouItzHzn
                .getZtysuuriyoukouryokukaisiymd());
            pRayJigyohiTy.setZtydenymd(pHoyuuMeisaiTyukeiyouItzHzn.getZtydenymd());
            pRayJigyohiTy.setZtybluekeizokuhyouji(pHoyuuMeisaiTyukeiyouItzHzn.getZtybluekeizokuhyouji());
            pRayJigyohiTy.setZtysuuriyouyobin1x2(pHoyuuMeisaiTyukeiyouItzHzn.getZtysuuriyouyobin1x2());
            pRayJigyohiTy.setZtytoukeikeijyoukbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtytoukeikeijyoukbn());
            pRayJigyohiTy.setZtyraysystemhyj(pHoyuuMeisaiTyukeiyouItzHzn.getZtyraysystemhyj());
            pRayJigyohiTy.setZtyzenkiidouteiseikbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtyzenkiidouteiseikbn());
            pRayJigyohiTy.setZtybsyym(pHoyuuMeisaiTyukeiyouItzHzn.getZtybsyym());
            pRayJigyohiTy.setZtytenkangokeiyakubosyuuym(pHoyuuMeisaiTyukeiyouItzHzn
                .getZtytenkangokeiyakubosyuuym());
            pRayJigyohiTy.setZtyidoujiyuucd(pHoyuuMeisaiTyukeiyouItzHzn.getZtyidoujiyuucd());
            pRayJigyohiTy.setZtysyoricd(pHoyuuMeisaiTyukeiyouItzHzn.getZtysyoricd());
            pRayJigyohiTy.setZtysekininteiseihyouji(pHoyuuMeisaiTyukeiyouItzHzn.getZtysekininteiseihyouji());
            pRayJigyohiTy.setZtysuuriyouyobin8(pHoyuuMeisaiTyukeiyouItzHzn.getZtysuuriyouyobin8());
            pRayJigyohiTy.setZtysihankibikinkbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtysihankibikinkbn());
            pRayJigyohiTy.setZtysuuriyouyobin1x3(pHoyuuMeisaiTyukeiyouItzHzn.getZtysuuriyouyobin1x3());
            pRayJigyohiTy.setZtydatakanrino(pHoyuuMeisaiTyukeiyouItzHzn.getZtydatakanrino());
            pRayJigyohiTy.setZtyhknsyukigou(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhknsyukigou());
            pRayJigyohiTy.setZtyhknsyuruikigousedaikbn(pHoyuuMeisaiTyukeiyouItzHzn
                .getZtyhknsyuruikigousedaikbn());
            pRayJigyohiTy.setZtysotodasipmenkbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtysotodasipmenkbn());
            pRayJigyohiTy.setZtystdssytikbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtystdssytikbn());
            pRayJigyohiTy.setZtystdssnskbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtystdssnskbn());
            pRayJigyohiTy
            .setZtysotodasimanagehyouji(pHoyuuMeisaiTyukeiyouItzHzn.getZtysotodasimanagehyouji());
            pRayJigyohiTy.setZtysotodasiphkbnmnoshyouji(pHoyuuMeisaiTyukeiyouItzHzn
                .getZtysotodasiphkbnmnoshyouji());
            pRayJigyohiTy.setZtystdsstkjytkyuhyj(pHoyuuMeisaiTyukeiyouItzHzn.getZtystdsstkjytkyuhyj());
            pRayJigyohiTy.setZtykbnkeiriyousegmentkbn(pHoyuuMeisaiTyukeiyouItzHzn
                .getZtykbnkeiriyousegmentkbn());
            pRayJigyohiTy.setZtykbnkeiriyourgnbnskkbn(pHoyuuMeisaiTyukeiyouItzHzn
                .getZtykbnkeiriyourgnbnskkbn());
            pRayJigyohiTy.setZtysuurisyuruicd(pHoyuuMeisaiTyukeiyouItzHzn.getZtysuurisyuruicd());
            pRayJigyohiTy.setZtyhosyoukinoukbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhosyoukinoukbn());
            pRayJigyohiTy.setZtydaikbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtydaikbn());
            pRayJigyohiTy.setZtytyuukbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtytyuukbn());
            pRayJigyohiTy.setZtysyoukbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtysyoukbn());
            pRayJigyohiTy.setZtysedaikbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtysedaikbn());
            pRayJigyohiTy.setZtyharaikatakbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtyharaikatakbn());
            pRayJigyohiTy.setZtykykymd(pHoyuuMeisaiTyukeiyouItzHzn.getZtykykymd());
            pRayJigyohiTy.setZtyhknkkn(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhknkkn());
            pRayJigyohiTy.setZtyphrkkikn(pHoyuuMeisaiTyukeiyouItzHzn.getZtyphrkkikn());
            pRayJigyohiTy.setZtysaimnkkykhyj(pHoyuuMeisaiTyukeiyouItzHzn.getZtysaimnkkykhyj());
            pRayJigyohiTy.setZtyannaifuyouriyuukbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtyannaifuyouriyuukbn());
            pRayJigyohiTy.setZtytksyuannaikykkbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtytksyuannaikykkbn());
            pRayJigyohiTy.setZtyhrkkaisuukbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhrkkaisuukbn());
            pRayJigyohiTy.setZtyhrkkeirokbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhrkkeirokbn());
            pRayJigyohiTy.setZtysdpdkbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtysdpdkbn());
            pRayJigyohiTy.setZtyryouritukbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtyryouritukbn());
            pRayJigyohiTy.setZtyao3tyou3sibousdatehyouji(pHoyuuMeisaiTyukeiyouItzHzn
                .getZtyao3tyou3sibousdatehyouji());
            pRayJigyohiTy.setZtyhhknseikbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhhknseikbn());
            pRayJigyohiTy.setZtyhihokensyaagev2(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhihokensyaagev2());
            pRayJigyohiTy.setZtykyksyanen(pHoyuuMeisaiTyukeiyouItzHzn.getZtykyksyanen());
            pRayJigyohiTy.setZtydai2hhknnen(pHoyuuMeisaiTyukeiyouItzHzn.getZtydai2hhknnen());
            pRayJigyohiTy.setZtytkbthsyumnryuhyouji(pHoyuuMeisaiTyukeiyouItzHzn.getZtytkbthsyumnryuhyouji());
            pRayJigyohiTy.setZtysyukeiyakupwaribikikbn(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtysyukeiyakupwaribikikbn());
            pRayJigyohiTy.setZtytenkanwaribikikbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtytenkanwaribikikbn());
            pRayJigyohiTy.setZtyyuuhitutnknyuguryurtkbn(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyyuuhitutnknyuguryurtkbn());
            pRayJigyohiTy.setZtysyukeiyakup(pHoyuuMeisaiTyukeiyouItzHzn.getZtysyukeiyakup());
            pRayJigyohiTy.setZtytokujyoup(pHoyuuMeisaiTyukeiyouItzHzn.getZtytokujyoup());
            pRayJigyohiTy.setZtysiteizukisyukeiyakup(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtysiteizukisyukeiyakup());
            pRayJigyohiTy.setZtykihons(pHoyuuMeisaiTyukeiyouItzHzn.getZtykihons());
            pRayJigyohiTy.setZtysibous(pHoyuuMeisaiTyukeiyouItzHzn.getZtysibous());
            pRayJigyohiTy.setZtyhenkougokihons(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhenkougokihons());
            pRayJigyohiTy.setZtyhenkougosibous(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhenkougosibous());
            pRayJigyohiTy.setZtyhenkouymd(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhenkouymd());
            pRayJigyohiTy.setZtyentyoukikan(pHoyuuMeisaiTyukeiyouItzHzn.getZtyentyoukikan());
            pRayJigyohiTy.setZtyseizonkyuuhukinsiteimd(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyseizonkyuuhukinsiteimd());
            pRayJigyohiTy.setZtysyukeiyakusiharaikingaku(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtysyukeiyakusiharaikingaku());
            pRayJigyohiTy.setZtyatukaisisyatodouhukencd(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyatukaisisyatodouhukencd());
            pRayJigyohiTy.setZtytokuyakuhukasuu(pHoyuuMeisaiTyukeiyouItzHzn.getZtytokuyakuhukasuu());
            pRayJigyohiTy.setZtydi2hknkknikoujihisyaage(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtydi2hknkknikoujihisyaage());
            pRayJigyohiTy.setZtyhrimnentyoumaephrkkkn(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyhrimnentyoumaephrkkkn());
            pRayJigyohiTy.setZtytokubetuhosyoukikan(pHoyuuMeisaiTyukeiyouItzHzn.getZtytokubetuhosyoukikan());
            pRayJigyohiTy.setZtykousinmanryouage(pHoyuuMeisaiTyukeiyouItzHzn.getZtykousinmanryouage());
            pRayJigyohiTy.setZtyknkuzusnzyrttekitkarihyj(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyknkuzusnzyrttekitkarihyj());
            pRayJigyohiTy.setZtykuriagekurisagekbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtykuriagekurisagekbn());
            pRayJigyohiTy.setZtyhrizmjhknsyukigousdkbn(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyhrizmjhknsyukigousdkbn());
            pRayJigyohiTy.setZtykrsgjhknsyukigousdkbn(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtykrsgjhknsyukigousdkbn());
            pRayJigyohiTy.setZtysotodasisyouhinkaiteikbn(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtysotodasisyouhinkaiteikbn());
            pRayJigyohiTy.setZtyyobiv4(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobiv4());
            pRayJigyohiTy.setZtygoukeitenkans(pHoyuuMeisaiTyukeiyouItzHzn.getZtygoukeitenkans());
            pRayJigyohiTy.setZtygoukeipbubuntenkans(pHoyuuMeisaiTyukeiyouItzHzn.getZtygoukeipbubuntenkans());
            pRayJigyohiTy.setZtytenkanteikisyuruikigou(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtytenkanteikisyuruikigou());
            pRayJigyohiTy.setZtytenkanteikikigousedaikbn(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtytenkanteikikigousedaikbn());
            pRayJigyohiTy.setZtytnkntiksotodasikusnkbn(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtytnkntiksotodasikusnkbn());
            pRayJigyohiTy.setZtytnkntikstdspmenkbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtytnkntikstdspmenkbn());
            pRayJigyohiTy.setZtytenkanteikikigouyobi(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtytenkanteikikigouyobi());
            pRayJigyohiTy.setZtytenkanteikikikan(pHoyuuMeisaiTyukeiyouItzHzn.getZtytenkanteikikikan());
            pRayJigyohiTy.setZtygoukeitenkanteikis(pHoyuuMeisaiTyukeiyouItzHzn.getZtygoukeitenkanteikis());
            pRayJigyohiTy.setZtytnknteikinkshrkkn(pHoyuuMeisaiTyukeiyouItzHzn.getZtytnknteikinkshrkkn());
            pRayJigyohiTy.setZtytenkansiharaikingaku(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtytenkansiharaikingaku());
            pRayJigyohiTy.setZtytnkntikshrkngk(pHoyuuMeisaiTyukeiyouItzHzn.getZtytnkntikshrkngk());
            pRayJigyohiTy.setZtytenkankaisuu(pHoyuuMeisaiTyukeiyouItzHzn.getZtytenkankaisuu());
            pRayJigyohiTy.setZtygoukeitenkankakaku(pHoyuuMeisaiTyukeiyouItzHzn.getZtygoukeitenkankakaku());
            pRayJigyohiTy.setZtytnknkhnbbnjyuturt(pHoyuuMeisaiTyukeiyouItzHzn.getZtytnknkhnbbnjyuturt());
            pRayJigyohiTy.setZtywnasigoukeitenkanteikis(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtywnasigoukeitenkanteikis());
            pRayJigyohiTy.setZtytnknteikikousinmnryouage(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtytnknteikikousinmnryouage());
            pRayJigyohiTy.setZtyyobiv5(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobiv5());
            pRayJigyohiTy.setZtykanyujidatakanrino(pHoyuuMeisaiTyukeiyouItzHzn.getZtykanyujidatakanrino());
            pRayJigyohiTy.setZtykanyujikykymd(pHoyuuMeisaiTyukeiyouItzHzn.getZtykanyujikykymd());
            pRayJigyohiTy.setZtykanyuujihihokensyaage(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtykanyuujihihokensyaage());
            pRayJigyohiTy.setZtykanyuujitenkanhyouji(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtykanyuujitenkanhyouji());
            pRayJigyohiTy.setZtyhsyuikktminaosikaisu(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyhsyuikktminaosikaisu());
            pRayJigyohiTy.setZtysknnjynbknsisnrt(pHoyuuMeisaiTyukeiyouItzHzn.getZtysknnjynbknsisnrt());
            pRayJigyohiTy.setZtytkjykbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtytkjykbn());
            pRayJigyohiTy.setZtysakugenkikan(pHoyuuMeisaiTyukeiyouItzHzn.getZtysakugenkikan());
            pRayJigyohiTy.setZtyryoumasihyouten(pHoyuuMeisaiTyukeiyouItzHzn.getZtyryoumasihyouten());
            pRayJigyohiTy.setZtysykyktkjyuryumsratehyj(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtysykyktkjyuryumsratehyj());
            pRayJigyohiTy.setZtysykyktkjyuryumsrate(pHoyuuMeisaiTyukeiyouItzHzn.getZtysykyktkjyuryumsrate());
            pRayJigyohiTy.setZtydai2tokujyoukbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtydai2tokujyoukbn());
            pRayJigyohiTy.setZtydai2sakugenkikan(pHoyuuMeisaiTyukeiyouItzHzn.getZtydai2sakugenkikan());
            pRayJigyohiTy.setZtydai2ryoumasihyouten(pHoyuuMeisaiTyukeiyouItzHzn.getZtydai2ryoumasihyouten());
            pRayJigyohiTy.setZtytokuteibuijyoukenhyouji(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtytokuteibuijyoukenhyouji());
            pRayJigyohiTy.setZtytokuteibuino1(pHoyuuMeisaiTyukeiyouItzHzn.getZtytokuteibuino1());
            pRayJigyohiTy.setZtyhtnpkkn1(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhtnpkkn1());
            pRayJigyohiTy.setZtytokuteibuino2(pHoyuuMeisaiTyukeiyouItzHzn.getZtytokuteibuino2());
            pRayJigyohiTy.setZtyhtnpkkn2(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhtnpkkn2());
            pRayJigyohiTy.setZtymhituiryuyutktbijyknhyj(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtymhituiryuyutktbijyknhyj());
            pRayJigyohiTy.setZtymuhaitouiryouyoutktbino1(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtymuhaitouiryouyoutktbino1());
            pRayJigyohiTy.setZtymuhaitouiryouyouhtnpkkn1(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtymuhaitouiryouyouhtnpkkn1());
            pRayJigyohiTy.setZtymuhaitouiryouyoutktbino2(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtymuhaitouiryouyoutktbino2());
            pRayJigyohiTy.setZtymuhaitouiryouyouhtnpkkn2(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtymuhaitouiryouyouhtnpkkn2());
            pRayJigyohiTy.setZtysiteizukipwarimasihyouji(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtysiteizukipwarimasihyouji());
            pRayJigyohiTy.setZtypwarimasisiteim1(pHoyuuMeisaiTyukeiyouItzHzn.getZtypwarimasisiteim1());
            pRayJigyohiTy.setZtypwarimasisiteim2(pHoyuuMeisaiTyukeiyouItzHzn.getZtypwarimasisiteim2());
            pRayJigyohiTy.setZtysiteimsykykpbairitu(pHoyuuMeisaiTyukeiyouItzHzn.getZtysiteimsykykpbairitu());
            pRayJigyohiTy.setZtysaisyuusiteiym(pHoyuuMeisaiTyukeiyouItzHzn.getZtysaisyuusiteiym());
            pRayJigyohiTy.setZtysykykkitmttvkeisanym(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtysykykkitmttvkeisanym());
            pRayJigyohiTy.setZtysykykkitmttsknnjynbkngk(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtysykykkitmttsknnjynbkngk());
            pRayJigyohiTy.setZtydftumitatekingaku(pHoyuuMeisaiTyukeiyouItzHzn.getZtydftumitatekingaku());
            pRayJigyohiTy.setZtydftumimasikin(pHoyuuMeisaiTyukeiyouItzHzn.getZtydftumimasikin());
            pRayJigyohiTy.setZtyvbubundftenkankakaku(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyvbubundftenkankakaku());
            pRayJigyohiTy.setZtydpbubundftenkankakaku(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtydpbubundftenkankakaku());
            pRayJigyohiTy.setZtydftmttkngkitjbrbbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtydftmttkngkitjbrbbn());
            pRayJigyohiTy.setZtyhendous(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhendous());
            pRayJigyohiTy.setZtyhengakujigyounendomatucv(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyhengakujigyounendomatucv());
            pRayJigyohiTy.setZtyitibuitijibarais(pHoyuuMeisaiTyukeiyouItzHzn.getZtyitibuitijibarais());
            pRayJigyohiTy.setZtyitibuitijibaraip(pHoyuuMeisaiTyukeiyouItzHzn.getZtyitibuitijibaraip());
            pRayJigyohiTy.setZtyitibitjbrshrkngk(pHoyuuMeisaiTyukeiyouItzHzn.getZtyitibitjbrshrkngk());
            pRayJigyohiTy.setZtygoukeicv(pHoyuuMeisaiTyukeiyouItzHzn.getZtygoukeicv());
            pRayJigyohiTy.setZtyminasicv(pHoyuuMeisaiTyukeiyouItzHzn.getZtyminasicv());
            pRayJigyohiTy.setZtyloanfund(pHoyuuMeisaiTyukeiyouItzHzn.getZtyloanfund());
            pRayJigyohiTy.setZtysaiteihosyougaku(pHoyuuMeisaiTyukeiyouItzHzn.getZtysaiteihosyougaku());
            pRayJigyohiTy.setZtyhngksitihsyuyusykykp(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyhngksitihsyuyusykykp());
            pRayJigyohiTy.setZtyhijynbrivasbujsitihsyugk(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyhijynbrivasbujsitihsyugk());
            pRayJigyohiTy.setZtyhijynbrivamnkjsitihsyugk(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyhijynbrivamnkjsitihsyugk());
            pRayJigyohiTy.setZtysiinkbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtysiinkbn());
            pRayJigyohiTy.setZtymudkaimasikihons(pHoyuuMeisaiTyukeiyouItzHzn.getZtymudkaimasikihons());
            pRayJigyohiTy.setZtykaimasiymd(pHoyuuMeisaiTyukeiyouItzHzn.getZtykaimasiymd());
            pRayJigyohiTy.setZtykaimasikikan(pHoyuuMeisaiTyukeiyouItzHzn.getZtykaimasikikan());
            pRayJigyohiTy.setZtyhikitugikaimasis(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhikitugikaimasis());
            pRayJigyohiTy.setZtymudkaimasisiharaikingaku(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtymudkaimasisiharaikingaku());
            pRayJigyohiTy.setZtyszoukouryokukaisiymdx1(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyszoukouryokukaisiymdx1());
            pRayJigyohiTy.setZtyszouhokensyuruikigoux1(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyszouhokensyuruikigoux1());
            pRayJigyohiTy.setZtyszoukigousedaikbnx1(pHoyuuMeisaiTyukeiyouItzHzn.getZtyszoukigousedaikbnx1());
            pRayJigyohiTy.setZtyszoukikanx1(pHoyuuMeisaiTyukeiyouItzHzn.getZtyszoukikanx1());
            pRayJigyohiTy.setZtyszouhihokensyaagex1(pHoyuuMeisaiTyukeiyouItzHzn.getZtyszouhihokensyaagex1());
            pRayJigyohiTy.setZtyszoudai2hihknsyaagex1(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyszoudai2hihknsyaagex1());
            pRayJigyohiTy.setZtyzoukasx1(pHoyuuMeisaiTyukeiyouItzHzn.getZtyzoukasx1());
            pRayJigyohiTy.setZtyzennendozoukasx1(pHoyuuMeisaiTyukeiyouItzHzn.getZtyzennendozoukasx1());
            pRayJigyohiTy.setZtyszousiharaikingakux1(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyszousiharaikingakux1());
            pRayJigyohiTy.setZtyszoukouryokukaisiymdx2(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyszoukouryokukaisiymdx2());
            pRayJigyohiTy.setZtyszouhokensyuruikigoux2(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyszouhokensyuruikigoux2());
            pRayJigyohiTy.setZtyszoukigousedaikbnx2(pHoyuuMeisaiTyukeiyouItzHzn.getZtyszoukigousedaikbnx2());
            pRayJigyohiTy.setZtyszoukikanx2(pHoyuuMeisaiTyukeiyouItzHzn.getZtyszoukikanx2());
            pRayJigyohiTy.setZtyszouhihokensyaagex2(pHoyuuMeisaiTyukeiyouItzHzn.getZtyszouhihokensyaagex2());
            pRayJigyohiTy.setZtyszoudai2hihknsyaagex2(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyszoudai2hihknsyaagex2());
            pRayJigyohiTy.setZtyzoukasx2(pHoyuuMeisaiTyukeiyouItzHzn.getZtyzoukasx2());
            pRayJigyohiTy.setZtyzennendozoukasx2(pHoyuuMeisaiTyukeiyouItzHzn.getZtyzennendozoukasx2());
            pRayJigyohiTy.setZtyszousiharaikingakux2(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyszousiharaikingakux2());
            pRayJigyohiTy.setZtysuuriyouyobin1x5(pHoyuuMeisaiTyukeiyouItzHzn.getZtysuuriyouyobin1x5());
            pRayJigyohiTy.setZtysuuriyouyobin1x6(pHoyuuMeisaiTyukeiyouItzHzn.getZtysuuriyouyobin1x6());
            pRayJigyohiTy.setZtyhrimngkizktkykpmenhyj(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyhrimngkizktkykpmenhyj());
            pRayJigyohiTy.setZtymisyuustartym(pHoyuuMeisaiTyukeiyouItzHzn.getZtymisyuustartym());
            pRayJigyohiTy.setZtymisyuukaisuu(pHoyuuMeisaiTyukeiyouItzHzn.getZtymisyuukaisuu());
            pRayJigyohiTy.setZtyitjbrtkykkousnuktkarhyj(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyitjbrtkykkousnuktkarhyj());
            pRayJigyohiTy.setZtygyousekihyoujis(pHoyuuMeisaiTyukeiyouItzHzn.getZtygyousekihyoujis());
            pRayJigyohiTy.setZtysykykgyusekihyjs(pHoyuuMeisaiTyukeiyouItzHzn.getZtysykykgyusekihyjs());
            pRayJigyohiTy.setZtytenkangyousekihyoujis(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtytenkangyousekihyoujis());
            pRayJigyohiTy.setZtytnknteikigyousekihyjs(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtytnknteikigyousekihyjs());
            pRayJigyohiTy.setZtytnkndpbbngyuskhyjs(pHoyuuMeisaiTyukeiyouItzHzn.getZtytnkndpbbngyuskhyjs());
            pRayJigyohiTy.setZtykykjyoutai(pHoyuuMeisaiTyukeiyouItzHzn.getZtykykjyoutai());
            pRayJigyohiTy.setZtypmenhukakbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtypmenhukakbn());
            pRayJigyohiTy.setZtykousinkbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtykousinkbn());
            pRayJigyohiTy.setZtymankiyoteikbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtymankiyoteikbn());
            pRayJigyohiTy.setZtysykyktikmnkyoteikbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtysykyktikmnkyoteikbn());
            pRayJigyohiTy.setZtytnknsykykkhnmnkytikbn(pHoyuuMeisaiTyukeiyouItzHzn
                .getZtytnknsykykkhnmnkytikbn());
            pRayJigyohiTy.setZtytnknsykyktikmnkytikbn(pHoyuuMeisaiTyukeiyouItzHzn
                .getZtytnknsykyktikmnkytikbn());
            pRayJigyohiTy.setZtytenkanteikimankiyoteikbn(pHoyuuMeisaiTyukeiyouItzHzn
                .getZtytenkanteikimankiyoteikbn());
            pRayJigyohiTy.setZtyszoumankiyoteikbnx1(pHoyuuMeisaiTyukeiyouItzHzn.getZtyszoumankiyoteikbnx1());
            pRayJigyohiTy.setZtyszoumankiyoteikbnx2(pHoyuuMeisaiTyukeiyouItzHzn.getZtyszoumankiyoteikbnx2());
            pRayJigyohiTy
            .setZtyvestingmankiyoteikbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtyvestingmankiyoteikbn());
            pRayJigyohiTy.setZtyvkeisanhyouji(pHoyuuMeisaiTyukeiyouItzHzn.getZtyvkeisanhyouji());
            pRayJigyohiTy.setZtytoukisinkeiyakuhyouji(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtytoukisinkeiyakuhyouji());
            pRayJigyohiTy.setZtysykykhokenhoutekiyouhyj(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtysykykhokenhoutekiyouhyj());
            pRayJigyohiTy.setZtytokuteijyoutaihushrhyj(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtytokuteijyoutaihushrhyj());
            pRayJigyohiTy.setZtyytirrthndsysnmnskaisuu(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyytirrthndsysnmnskaisuu());
            pRayJigyohiTy.setZtysuuriyouyobin3(pHoyuuMeisaiTyukeiyouItzHzn.getZtysuuriyouyobin3());
            pRayJigyohiTy.setZtysuuriyouyobin11(pHoyuuMeisaiTyukeiyouItzHzn.getZtysuuriyouyobin11());
            pRayJigyohiTy.setZtywnasigoukeitenkankakaku(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtywnasigoukeitenkankakaku());
            pRayJigyohiTy.setZtyyobin11(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobin11());
            pRayJigyohiTy.setZtyyobin11x2(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobin11x2());
            pRayJigyohiTy.setZtyyobin11x3(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobin11x3());
            pRayJigyohiTy.setZtytukibaraikansantokujyoup(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtytukibaraikansantokujyoup());
            pRayJigyohiTy.setZtytnkngkykkssnkijyuym(pHoyuuMeisaiTyukeiyouItzHzn.getZtytnkngkykkssnkijyuym());
            pRayJigyohiTy.setZtysaiteihosyouhyouji(pHoyuuMeisaiTyukeiyouItzHzn.getZtysaiteihosyouhyouji());
            pRayJigyohiTy.setZtysuuriyouyobin8x2(pHoyuuMeisaiTyukeiyouItzHzn.getZtysuuriyouyobin8x2());
            pRayJigyohiTy.setZtysuuriyouyobin14(pHoyuuMeisaiTyukeiyouItzHzn.getZtysuuriyouyobin14());
            pRayJigyohiTy.setZtyhrimngtkykphrkkaisuukbn(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyhrimngtkykphrkkaisuukbn());
            pRayJigyohiTy.setZtyhrimngtkykphrkkirkbn(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyhrimngtkykphrkkirkbn());
            pRayJigyohiTy.setZtyhrimngtkykpryurtkbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhrimngtkykpryurtkbn());
            pRayJigyohiTy.setZtyyobiv13(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobiv13());
            pRayJigyohiTy.setZtyidoujisaiteihosyoukngk(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyidoujisaiteihosyoukngk());
            pRayJigyohiTy.setZtyidoujisaiteihosyoucost(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyidoujisaiteihosyoucost());
            pRayJigyohiTy.setZtysinhokenfundtumitatekin(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtysinhokenfundtumitatekin());
            pRayJigyohiTy.setZtymsyuptusshkgkaiykhnrikn(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtymsyuptusshkgkaiykhnrikn());
            pRayJigyohiTy.setZtyrrthndugtnkgetumatuv(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyrrthndugtnkgetumatuv());
            pRayJigyohiTy.setZtyrrthndnksaiteihosyonkgns(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyrrthndnksaiteihosyonkgns());
            pRayJigyohiTy.setZtyrrthendougatanksibous(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyrrthendougatanksibous());
            pRayJigyohiTy.setZtyalmyousohutomeisyoukbn(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyalmyousohutomeisyoukbn());
            pRayJigyohiTy.setZtysnkyksoftmeisyoukbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtysnkyksoftmeisyoukbn());
            pRayJigyohiTy.setZtysoftmeisyoukbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtysoftmeisyoukbn());
            pRayJigyohiTy.setZtykykjitokujyouarihyj(pHoyuuMeisaiTyukeiyouItzHzn.getZtykykjitokujyouarihyj());
            pRayJigyohiTy.setZtybnkttnknkbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtybnkttnknkbn());
            pRayJigyohiTy.setZtytenkanminaosikbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtytenkanminaosikbn());
            pRayJigyohiTy.setZtysoujikeitenkankbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtysoujikeitenkankbn());
            pRayJigyohiTy.setZtynenkinkaisinendo(pHoyuuMeisaiTyukeiyouItzHzn.getZtynenkinkaisinendo());
            pRayJigyohiTy.setZtynenkingatakbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtynenkingatakbn());
            pRayJigyohiTy.setZtynknshry(pHoyuuMeisaiTyukeiyouItzHzn.getZtynknshry());
            pRayJigyohiTy.setZtyheiyoubaraikeiyakukbn(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyheiyoubaraikeiyakukbn());
            pRayJigyohiTy.setZtynenkinmaruteihukakbn(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtynenkinmaruteihukakbn());
            pRayJigyohiTy.setZtysinseizonmrtiarihyj(pHoyuuMeisaiTyukeiyouItzHzn.getZtysinseizonmrtiarihyj());
            pRayJigyohiTy.setZtysnkykyouibokijyukbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtysnkykyouibokijyukbn());
            pRayJigyohiTy.setZtytokusitujyuusitusetkbn(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtytokusitujyuusitusetkbn());
            pRayJigyohiTy.setZtysiktsyuknbyugnhsyunshyj(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtysiktsyuknbyugnhsyunshyj());
            pRayJigyohiTy.setZtypmensugugtganhsyunshyj(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtypmensugugtganhsyunshyj());
            pRayJigyohiTy.setZtytkykgyousekihyjszerohyj(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtytkykgyousekihyjszerohyj());
            pRayJigyohiTy.setZtysuuriyouyobin7(pHoyuuMeisaiTyukeiyouItzHzn.getZtysuuriyouyobin7());
            pRayJigyohiTy.setZtysyussaikeitaikbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtysyussaikeitaikbn());
            pRayJigyohiTy.setZtyyobiv6(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobiv6());
            pRayJigyohiTy.setZtybosyuukeitaikbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtybosyuukeitaikbn());
            pRayJigyohiTy.setZtyaatukaisosikicd(pHoyuuMeisaiTyukeiyouItzHzn.getZtyaatukaisosikicd());
            pRayJigyohiTy.setZtyaatukaikojincd(pHoyuuMeisaiTyukeiyouItzHzn.getZtyaatukaikojincd());
            pRayJigyohiTy.setZtybsydrtencd(pHoyuuMeisaiTyukeiyouItzHzn.getZtybsydrtencd());
            pRayJigyohiTy.setZtycifcd(pHoyuuMeisaiTyukeiyouItzHzn.getZtycifcd());
            pRayJigyohiTy.setZtysuuriyouyobiv8(pHoyuuMeisaiTyukeiyouItzHzn.getZtysuuriyouyobiv8());
            pRayJigyohiTy.setZtysinsakbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtysinsakbn());
            pRayJigyohiTy.setZtydai2hihokensyasinsakbn(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtydai2hihokensyasinsakbn());
            pRayJigyohiTy.setZtytoukeiyousinsakbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtytoukeiyousinsakbn());
            pRayJigyohiTy.setZtydai2toukeiyousinsakbn(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtydai2toukeiyousinsakbn());
            pRayJigyohiTy.setZtyketteikijyunkanwakbn(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyketteikijyunkanwakbn());
            pRayJigyohiTy.setZtykihonsibouhyoukbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtykihonsibouhyoukbn());
            pRayJigyohiTy.setZtyteikisibouhyoukbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtyteikisibouhyoukbn());
            pRayJigyohiTy.setZtysonotasibouhyoukbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtysonotasibouhyoukbn());
            pRayJigyohiTy.setZtymrarihyj(pHoyuuMeisaiTyukeiyouItzHzn.getZtymrarihyj());
            pRayJigyohiTy.setZtysentakujyouhouarihyouji(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtysentakujyouhouarihyouji());
            pRayJigyohiTy.setZtydugktnknsntkhuhukbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtydugktnknsntkhuhukbn());
            pRayJigyohiTy.setZtygengakutenkankykhyj(pHoyuuMeisaiTyukeiyouItzHzn.getZtygengakutenkankykhyj());
            pRayJigyohiTy.setZtysykgycd(pHoyuuMeisaiTyukeiyouItzHzn.getZtysykgycd());
            pRayJigyohiTy.setZtyjidoukousinkykkanyuuymd(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyjidoukousinkykkanyuuymd());
            pRayJigyohiTy.setZtysaikohtnknkykkykymd(pHoyuuMeisaiTyukeiyouItzHzn.getZtysaikohtnknkykkykymd());
            pRayJigyohiTy.setZtykousinmaesykyksburtkbn(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtykousinmaesykyksburtkbn());
            pRayJigyohiTy.setZtyhjnkykhyj(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhjnkykhyj());
            pRayJigyohiTy.setZtyanniskcd(pHoyuuMeisaiTyukeiyouItzHzn.getZtyanniskcd());
            pRayJigyohiTy.setZtyhjncd(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhjncd());
            pRayJigyohiTy.setZtyhjnjigyosyocd(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhjnjigyosyocd());
            pRayJigyohiTy.setZtysaihokenno(pHoyuuMeisaiTyukeiyouItzHzn.getZtysaihokenno());
            pRayJigyohiTy.setZtydakuhikettikekkacd(pHoyuuMeisaiTyukeiyouItzHzn.getZtydakuhikettikekkacd());
            pRayJigyohiTy.setZtydai2dakuhiketteikekkacd(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtydai2dakuhiketteikekkacd());
            pRayJigyohiTy.setZtypmenkbnv2(pHoyuuMeisaiTyukeiyouItzHzn.getZtypmenkbnv2());
            pRayJigyohiTy.setZtysiboukyuuhukin(pHoyuuMeisaiTyukeiyouItzHzn.getZtysiboukyuuhukin());
            pRayJigyohiTy.setZtyjyudthumeharaitkykhkhyj(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyjyudthumeharaitkykhkhyj());
            pRayJigyohiTy.setZtyhaitoukbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhaitoukbn());
            pRayJigyohiTy.setZtyhhknnentysihyj(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhhknnentysihyj());
            pRayJigyohiTy.setZtydai2hhknnentysihyj(pHoyuuMeisaiTyukeiyouItzHzn.getZtydai2hhknnentysihyj());
            pRayJigyohiTy.setZtykyksyaagetyouseihyj(pHoyuuMeisaiTyukeiyouItzHzn.getZtykyksyaagetyouseihyj());
            pRayJigyohiTy.setZtykituenkbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtykituenkbn());
            pRayJigyohiTy.setZtykituenhonsuu(pHoyuuMeisaiTyukeiyouItzHzn.getZtykituenhonsuu());
            pRayJigyohiTy.setZtymusentakukeiyakukbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtymusentakukeiyakukbn());
            pRayJigyohiTy.setZtyyobiv6x2(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobiv6x2());
            pRayJigyohiTy.setZtylivingneedstkykarihyj(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtylivingneedstkykarihyj());
            pRayJigyohiTy.setZtylivingneedssiharaihyouji(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtylivingneedssiharaihyouji());
            pRayJigyohiTy.setZtylnseikyuuymd(pHoyuuMeisaiTyukeiyouItzHzn.getZtylnseikyuuymd());
            pRayJigyohiTy.setZtylnshrgenincd(pHoyuuMeisaiTyukeiyouItzHzn.getZtylnshrgenincd());
            pRayJigyohiTy.setZtydakuhikettisyacd(pHoyuuMeisaiTyukeiyouItzHzn.getZtydakuhikettisyacd());
            pRayJigyohiTy.setZtydai2dakuhiketteisyacd(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtydai2dakuhiketteisyacd());
            pRayJigyohiTy.setZtygansapotokuyakuarihyouji(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtygansapotokuyakuarihyouji());
            pRayJigyohiTy.setZtygnspshrhyj(pHoyuuMeisaiTyukeiyouItzHzn.getZtygnspshrhyj());
            pRayJigyohiTy.setZtygansaposeikyuuymd(pHoyuuMeisaiTyukeiyouItzHzn.getZtygansaposeikyuuymd());
            pRayJigyohiTy.setZtygnspshrgenincd(pHoyuuMeisaiTyukeiyouItzHzn.getZtygnspshrgenincd());
            pRayJigyohiTy.setZtyyobiv3x2(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobiv3x2());
            pRayJigyohiTy.setZtytargetmokuhyouritu(pHoyuuMeisaiTyukeiyouItzHzn.getZtytargetmokuhyouritu());
            pRayJigyohiTy.setZtyautoswitchmokuhyouritu(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyautoswitchmokuhyouritu());
            pRayJigyohiTy.setZtytumitatekinitenarihyj(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtytumitatekinitenarihyj());
            pRayJigyohiTy.setZtytumitatekinitenkaisuu(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtytumitatekinitenkaisuu());
            pRayJigyohiTy.setZtydatakanrino2(pHoyuuMeisaiTyukeiyouItzHzn.getZtydatakanrino2());
            pRayJigyohiTy.setZtydatakanrino3(pHoyuuMeisaiTyukeiyouItzHzn.getZtydatakanrino3());
            pRayJigyohiTy.setZtyknkuzusnzyrttekinendo(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyknkuzusnzyrttekinendo());
            pRayJigyohiTy.setZtyknkuzusnzyrt(pHoyuuMeisaiTyukeiyouItzHzn.getZtyknkuzusnzyrt());
            pRayJigyohiTy.setZtyknkuzusnzyrtx2(pHoyuuMeisaiTyukeiyouItzHzn.getZtyknkuzusnzyrtx2());
            pRayJigyohiTy.setZtyknkuzusnzyrtx3(pHoyuuMeisaiTyukeiyouItzHzn.getZtyknkuzusnzyrtx3());
            pRayJigyohiTy.setZtysinkeiyakujiknkuzusnzyrt(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtysinkeiyakujiknkuzusnzyrt());
            pRayJigyohiTy.setZtytenkanjiknkuzusnzyrt(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtytenkanjiknkuzusnzyrt());
            pRayJigyohiTy.setZtysinkeiyakujivithkhyouji(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtysinkeiyakujivithkhyouji());
            pRayJigyohiTy.setZtykykjivithukusuukykhyj(pHoyuuMeisaiTyukeiyouItzHzn.getZtykykjivithukusuukykhyj());
            pRayJigyohiTy.setZtysuuriyouyobin9x2(pHoyuuMeisaiTyukeiyouItzHzn.getZtysuuriyouyobin9x2());
            pRayJigyohiTy.setZtypwrbksidhitekiyouhyj(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtypwrbksidhitekiyouhyj());
            pRayJigyohiTy.setZtysuuriyouyobin9(pHoyuuMeisaiTyukeiyouItzHzn.getZtysuuriyouyobin9());
            pRayJigyohiTy.setZtysuuriyouyobin10x7(pHoyuuMeisaiTyukeiyouItzHzn.getZtysuuriyouyobin10x7());
            pRayJigyohiTy.setZtysuuriyouyobin10x8(pHoyuuMeisaiTyukeiyouItzHzn.getZtysuuriyouyobin10x8());
            pRayJigyohiTy.setZtysuuriyouyobin10x9(pHoyuuMeisaiTyukeiyouItzHzn.getZtysuuriyouyobin10x9());
            pRayJigyohiTy.setZtytumitatekinitenbubun(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtytumitatekinitenbubun());
            pRayJigyohiTy.setZtysagakusknnjynbknzndk(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtysagakusknnjynbknzndk());
            pRayJigyohiTy.setZtyyobin11x5(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobin11x5());
            pRayJigyohiTy.setZtyyobin11x6(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobin11x6());
            pRayJigyohiTy.setZtyyobin11x7(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobin11x7());
            pRayJigyohiTy.setZtyyobin11x8(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobin11x8());
            pRayJigyohiTy.setZtyyobin11x9(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobin11x9());
            pRayJigyohiTy.setZtyyobin11x10(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobin11x10());
            pRayJigyohiTy.setZtyyobin11x11(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobin11x11());
            pRayJigyohiTy.setZtyyobin11x12(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobin11x12());
            pRayJigyohiTy.setZtyyobin11x13(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobin11x13());
            pRayJigyohiTy.setZtyyobin11x14(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobin11x14());
            pRayJigyohiTy.setZtyyobin11x15(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobin11x15());
            pRayJigyohiTy.setZtyyobin11x16(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobin11x16());
            pRayJigyohiTy.setZtyyobin11x17(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobin11x17());
            pRayJigyohiTy.setZtyzyrthntiyustatuskbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtyzyrthntiyustatuskbn());
            pRayJigyohiTy.setZtyzyrthntiyustatuskbnx2(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyzyrthntiyustatuskbnx2());
            pRayJigyohiTy.setZtyzyrthntiyustatuskbnx3(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyzyrthntiyustatuskbnx3());
            pRayJigyohiTy.setZtyzyrthntiyustatuskbnx4(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyzyrthntiyustatuskbnx4());
            pRayJigyohiTy.setZtyzyrthntiyustatuskbnx5(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyzyrthntiyustatuskbnx5());
            pRayJigyohiTy.setZtyyobiv10(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobiv10());
            pRayJigyohiTy.setZtyyobiv15x2(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobiv15x2());
            pRayJigyohiTy.setZtyyobiv15x3(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobiv15x3());
            pRayJigyohiTy.setZtyyobiv15x4(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobiv15x4());
            pRayJigyohiTy.setZtygaikakbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtygaikakbn());
            pRayJigyohiTy.setZtykawaserate1(pHoyuuMeisaiTyukeiyouItzHzn.getZtykawaserate1());
            pRayJigyohiTy.setZtykawaseratetekiyouymd1(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtykawaseratetekiyouymd1());
            pRayJigyohiTy.setZtykawaserate2(pHoyuuMeisaiTyukeiyouItzHzn.getZtykawaserate2());
            pRayJigyohiTy.setZtykawaseratetekiyouymd2(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtykawaseratetekiyouymd2());
            pRayJigyohiTy.setZtykykjikawaserate(pHoyuuMeisaiTyukeiyouItzHzn.getZtykykjikawaserate());
            pRayJigyohiTy.setZtykykjikawaseratetkyuymd(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtykykjikawaseratetkyuymd());
            pRayJigyohiTy.setZtymvatyouseigow(pHoyuuMeisaiTyukeiyouItzHzn.getZtymvatyouseigow());
            pRayJigyohiTy.setZtymvakeisanjisknnjynbkn(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtymvakeisanjisknnjynbkn());
            pRayJigyohiTy.setZtykaiyakukoujyoritu(pHoyuuMeisaiTyukeiyouItzHzn.getZtykaiyakukoujyoritu());
            pRayJigyohiTy.setZtyrendouritu(pHoyuuMeisaiTyukeiyouItzHzn.getZtyrendouritu());
            pRayJigyohiTy.setZtysrkaiyakusjkkktyouseirrt(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtysrkaiyakusjkkktyouseirrt());
            pRayJigyohiTy.setZtysrkyksjkkktyouseiriritu(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtysrkyksjkkktyouseiriritu());
            pRayJigyohiTy.setZtymvakeisankijyunymd(pHoyuuMeisaiTyukeiyouItzHzn.getZtymvakeisankijyunymd());
            pRayJigyohiTy.setZtymvatyouseikou(pHoyuuMeisaiTyukeiyouItzHzn.getZtymvatyouseikou());
            pRayJigyohiTy.setZtyenkdtsbujsitihsyukngk(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyenkdtsbujsitihsyukngk());
            pRayJigyohiTy.setZtyenkdtsbujsitihsyucost(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyenkdtsbujsitihsyucost());
            pRayJigyohiTy.setZtyenkdtsbujsitihsyuarihyj(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyenkdtsbujsitihsyuarihyj());
            pRayJigyohiTy.setZtykeiyakujiyoteiriritu(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtykeiyakujiyoteiriritu());
            pRayJigyohiTy.setZtytumitateriritu(pHoyuuMeisaiTyukeiyouItzHzn.getZtytumitateriritu());
            pRayJigyohiTy.setZtykaigomaebaraitkykarihyj(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtykaigomaebaraitkykarihyj());
            pRayJigyohiTy.setZtysibouhyoukbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtysibouhyoukbn());
            pRayJigyohiTy.setZtynyuukintuukakbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtynyuukintuukakbn());
            pRayJigyohiTy.setZtysiharaituukakbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtysiharaituukakbn());
            pRayJigyohiTy.setZtywyendttargetmokuhyouritu(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtywyendttargetmokuhyouritu());
            pRayJigyohiTy.setZtysisuurendourate(pHoyuuMeisaiTyukeiyouItzHzn.getZtysisuurendourate());
            pRayJigyohiTy.setZtysisuukbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtysisuukbn());
            pRayJigyohiTy.setZtyteirituikouhyouji(pHoyuuMeisaiTyukeiyouItzHzn.getZtyteirituikouhyouji());
            pRayJigyohiTy.setZtysrdai1hknkkn(pHoyuuMeisaiTyukeiyouItzHzn.getZtysrdai1hknkkn());
            pRayJigyohiTy.setZtysuuriyouyobin10x11(pHoyuuMeisaiTyukeiyouItzHzn.getZtysuuriyouyobin10x11());
            pRayJigyohiTy.setZtytmttknzoukaritujygn(pHoyuuMeisaiTyukeiyouItzHzn.getZtytmttknzoukaritujygn());
            pRayJigyohiTy.setZtysetteibairitu(pHoyuuMeisaiTyukeiyouItzHzn.getZtysetteibairitu());
            pRayJigyohiTy.setZtytykzenoutouymdsisuu(pHoyuuMeisaiTyukeiyouItzHzn.getZtytykzenoutouymdsisuu());
            pRayJigyohiTy.setZtykimatusisuu(pHoyuuMeisaiTyukeiyouItzHzn.getZtykimatusisuu());
            pRayJigyohiTy.setZtytuukasyukbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtytuukasyukbn());
            pRayJigyohiTy.setZtyyobiv2(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobiv2());
            pRayJigyohiTy.setZtyyenkadatekihons(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyenkadatekihons());
            pRayJigyohiTy.setZtysitihsyumegkdtsibous(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtysitihsyumegkdtsibous());
            pRayJigyohiTy.setZtyenkdtssrentumitatekin(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyenkdtssrentumitatekin());
            pRayJigyohiTy.setZtysisuurentumitatekin(pHoyuuMeisaiTyukeiyouItzHzn.getZtysisuurentumitatekin());
            pRayJigyohiTy.setZtynksjitirttumitatekin(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtynksjitirttumitatekin());
            pRayJigyohiTy.setZtykimatutirttumitatekin(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtykimatutirttumitatekin());
            pRayJigyohiTy.setZtygaikadatejyuutoup(pHoyuuMeisaiTyukeiyouItzHzn.getZtygaikadatejyuutoup());
            pRayJigyohiTy.setZtyyendttargetkijyunkingaku(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyyendttargetkijyunkingaku());
            pRayJigyohiTy.setZtyyobiv7(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobiv7());
            pRayJigyohiTy.setZtysitivkisnyukykjikwsrate(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtysitivkisnyukykjikwsrate());
            pRayJigyohiTy.setZtysisuurentyokugotmttkn(pHoyuuMeisaiTyukeiyouItzHzn.getZtysisuurentyokugotmttkn());
        }
        else if (pKessanKbn.eq(C_KessanKbn.KESSAN)) {
            pKsnRayJigyohiTy.setZtyrecordkbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtyrecordkbn());
            pKsnRayJigyohiTy.setZtynenkinkaisigohyouji(pHoyuuMeisaiTyukeiyouItzHzn
                .getZtynenkinkaisigohyouji());
            pKsnRayJigyohiTy.setZtynksgokurikosidhyj(pHoyuuMeisaiTyukeiyouItzHzn.getZtynksgokurikosidhyj());
            pKsnRayJigyohiTy.setZtykeijyouym(pHoyuuMeisaiTyukeiyouItzHzn.getZtykeijyouym());
            pKsnRayJigyohiTy.setZtyidojiyukbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtyidojiyukbn());
            pKsnRayJigyohiTy.setZtyzougenkbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtyzougenkbn());
            pKsnRayJigyohiTy.setZtyidourecordkbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtyidourecordkbn());
            pKsnRayJigyohiTy.setZtykeijyouctrlkbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtykeijyouctrlkbn());
            pKsnRayJigyohiTy.setZtyhenkousyoriymd(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhenkousyoriymd());
            pKsnRayJigyohiTy.setZtykykmfksnctr(pHoyuuMeisaiTyukeiyouItzHzn.getZtykykmfksnctr());
            pKsnRayJigyohiTy.setZtyrecordctr(pHoyuuMeisaiTyukeiyouItzHzn.getZtyrecordctr());
            pKsnRayJigyohiTy.setZtysuuriyoukouryokukaisiymd(pHoyuuMeisaiTyukeiyouItzHzn
                .getZtysuuriyoukouryokukaisiymd());
            pKsnRayJigyohiTy.setZtydenymd(pHoyuuMeisaiTyukeiyouItzHzn.getZtydenymd());
            pKsnRayJigyohiTy.setZtybluekeizokuhyouji(pHoyuuMeisaiTyukeiyouItzHzn.getZtybluekeizokuhyouji());
            pKsnRayJigyohiTy.setZtysuuriyouyobin1x2(pHoyuuMeisaiTyukeiyouItzHzn.getZtysuuriyouyobin1x2());
            pKsnRayJigyohiTy.setZtytoukeikeijyoukbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtytoukeikeijyoukbn());
            pKsnRayJigyohiTy.setZtyraysystemhyj(pHoyuuMeisaiTyukeiyouItzHzn.getZtyraysystemhyj());
            pKsnRayJigyohiTy.setZtyzenkiidouteiseikbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtyzenkiidouteiseikbn());
            pKsnRayJigyohiTy.setZtybsyym(pHoyuuMeisaiTyukeiyouItzHzn.getZtybsyym());
            pKsnRayJigyohiTy.setZtytenkangokeiyakubosyuuym(pHoyuuMeisaiTyukeiyouItzHzn
                .getZtytenkangokeiyakubosyuuym());
            pKsnRayJigyohiTy.setZtyidoujiyuucd(pHoyuuMeisaiTyukeiyouItzHzn.getZtyidoujiyuucd());
            pKsnRayJigyohiTy.setZtysyoricd(pHoyuuMeisaiTyukeiyouItzHzn.getZtysyoricd());
            pKsnRayJigyohiTy.setZtysekininteiseihyouji(pHoyuuMeisaiTyukeiyouItzHzn
                .getZtysekininteiseihyouji());
            pKsnRayJigyohiTy.setZtysuuriyouyobin8(pHoyuuMeisaiTyukeiyouItzHzn.getZtysuuriyouyobin8());
            pKsnRayJigyohiTy.setZtysihankibikinkbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtysihankibikinkbn());
            pKsnRayJigyohiTy.setZtysuuriyouyobin1x3(pHoyuuMeisaiTyukeiyouItzHzn.getZtysuuriyouyobin1x3());
            pKsnRayJigyohiTy.setZtydatakanrino(pHoyuuMeisaiTyukeiyouItzHzn.getZtydatakanrino());
            pKsnRayJigyohiTy.setZtyhknsyukigou(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhknsyukigou());
            pKsnRayJigyohiTy.setZtyhknsyuruikigousedaikbn(pHoyuuMeisaiTyukeiyouItzHzn
                .getZtyhknsyuruikigousedaikbn());
            pKsnRayJigyohiTy.setZtysotodasipmenkbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtysotodasipmenkbn());
            pKsnRayJigyohiTy.setZtystdssytikbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtystdssytikbn());
            pKsnRayJigyohiTy.setZtystdssnskbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtystdssnskbn());
            pKsnRayJigyohiTy
            .setZtysotodasimanagehyouji(pHoyuuMeisaiTyukeiyouItzHzn.getZtysotodasimanagehyouji());
            pKsnRayJigyohiTy.setZtysotodasiphkbnmnoshyouji(pHoyuuMeisaiTyukeiyouItzHzn
                .getZtysotodasiphkbnmnoshyouji());
            pKsnRayJigyohiTy.setZtystdsstkjytkyuhyj(pHoyuuMeisaiTyukeiyouItzHzn.getZtystdsstkjytkyuhyj());
            pKsnRayJigyohiTy.setZtykbnkeiriyousegmentkbn(pHoyuuMeisaiTyukeiyouItzHzn
                .getZtykbnkeiriyousegmentkbn());
            pKsnRayJigyohiTy.setZtykbnkeiriyourgnbnskkbn(pHoyuuMeisaiTyukeiyouItzHzn
                .getZtykbnkeiriyourgnbnskkbn());
            pKsnRayJigyohiTy.setZtysuurisyuruicd(pHoyuuMeisaiTyukeiyouItzHzn.getZtysuurisyuruicd());
            pKsnRayJigyohiTy.setZtyhosyoukinoukbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhosyoukinoukbn());
            pKsnRayJigyohiTy.setZtydaikbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtydaikbn());
            pKsnRayJigyohiTy.setZtytyuukbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtytyuukbn());
            pKsnRayJigyohiTy.setZtysyoukbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtysyoukbn());
            pKsnRayJigyohiTy.setZtysedaikbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtysedaikbn());
            pKsnRayJigyohiTy.setZtyharaikatakbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtyharaikatakbn());
            pKsnRayJigyohiTy.setZtykykymd(pHoyuuMeisaiTyukeiyouItzHzn.getZtykykymd());
            pKsnRayJigyohiTy.setZtyhknkkn(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhknkkn());
            pKsnRayJigyohiTy.setZtyphrkkikn(pHoyuuMeisaiTyukeiyouItzHzn.getZtyphrkkikn());
            pKsnRayJigyohiTy.setZtysaimnkkykhyj(pHoyuuMeisaiTyukeiyouItzHzn.getZtysaimnkkykhyj());
            pKsnRayJigyohiTy.setZtyannaifuyouriyuukbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtyannaifuyouriyuukbn());
            pKsnRayJigyohiTy.setZtytksyuannaikykkbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtytksyuannaikykkbn());
            pKsnRayJigyohiTy.setZtyhrkkaisuukbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhrkkaisuukbn());
            pKsnRayJigyohiTy.setZtyhrkkeirokbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhrkkeirokbn());
            pKsnRayJigyohiTy.setZtysdpdkbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtysdpdkbn());
            pKsnRayJigyohiTy.setZtyryouritukbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtyryouritukbn());
            pKsnRayJigyohiTy.setZtyao3tyou3sibousdatehyouji(pHoyuuMeisaiTyukeiyouItzHzn
                .getZtyao3tyou3sibousdatehyouji());
            pKsnRayJigyohiTy.setZtyhhknseikbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhhknseikbn());
            pKsnRayJigyohiTy.setZtyhihokensyaagev2(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhihokensyaagev2());
            pKsnRayJigyohiTy.setZtykyksyanen(pHoyuuMeisaiTyukeiyouItzHzn.getZtykyksyanen());
            pKsnRayJigyohiTy.setZtydai2hhknnen(pHoyuuMeisaiTyukeiyouItzHzn.getZtydai2hhknnen());
            pKsnRayJigyohiTy.setZtytkbthsyumnryuhyouji(pHoyuuMeisaiTyukeiyouItzHzn
                .getZtytkbthsyumnryuhyouji());
            pKsnRayJigyohiTy.setZtysyukeiyakupwaribikikbn(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtysyukeiyakupwaribikikbn());
            pKsnRayJigyohiTy.setZtytenkanwaribikikbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtytenkanwaribikikbn());
            pKsnRayJigyohiTy.setZtyyuuhitutnknyuguryurtkbn(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyyuuhitutnknyuguryurtkbn());
            pKsnRayJigyohiTy.setZtysyukeiyakup(pHoyuuMeisaiTyukeiyouItzHzn.getZtysyukeiyakup());
            pKsnRayJigyohiTy.setZtytokujyoup(pHoyuuMeisaiTyukeiyouItzHzn.getZtytokujyoup());
            pKsnRayJigyohiTy.setZtysiteizukisyukeiyakup(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtysiteizukisyukeiyakup());
            pKsnRayJigyohiTy.setZtykihons(pHoyuuMeisaiTyukeiyouItzHzn.getZtykihons());
            pKsnRayJigyohiTy.setZtysibous(pHoyuuMeisaiTyukeiyouItzHzn.getZtysibous());
            pKsnRayJigyohiTy.setZtyhenkougokihons(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhenkougokihons());
            pKsnRayJigyohiTy.setZtyhenkougosibous(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhenkougosibous());
            pKsnRayJigyohiTy.setZtyhenkouymd(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhenkouymd());
            pKsnRayJigyohiTy.setZtyentyoukikan(pHoyuuMeisaiTyukeiyouItzHzn.getZtyentyoukikan());
            pKsnRayJigyohiTy.setZtyseizonkyuuhukinsiteimd(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyseizonkyuuhukinsiteimd());
            pKsnRayJigyohiTy.setZtysyukeiyakusiharaikingaku(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtysyukeiyakusiharaikingaku());
            pKsnRayJigyohiTy.setZtyatukaisisyatodouhukencd(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyatukaisisyatodouhukencd());
            pKsnRayJigyohiTy.setZtytokuyakuhukasuu(pHoyuuMeisaiTyukeiyouItzHzn.getZtytokuyakuhukasuu());
            pKsnRayJigyohiTy.setZtydi2hknkknikoujihisyaage(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtydi2hknkknikoujihisyaage());
            pKsnRayJigyohiTy.setZtyhrimnentyoumaephrkkkn(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyhrimnentyoumaephrkkkn());
            pKsnRayJigyohiTy.setZtytokubetuhosyoukikan(pHoyuuMeisaiTyukeiyouItzHzn
                .getZtytokubetuhosyoukikan());
            pKsnRayJigyohiTy.setZtykousinmanryouage(pHoyuuMeisaiTyukeiyouItzHzn.getZtykousinmanryouage());
            pKsnRayJigyohiTy.setZtyknkuzusnzyrttekitkarihyj(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyknkuzusnzyrttekitkarihyj());
            pKsnRayJigyohiTy.setZtykuriagekurisagekbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtykuriagekurisagekbn());
            pKsnRayJigyohiTy.setZtyhrizmjhknsyukigousdkbn(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyhrizmjhknsyukigousdkbn());
            pKsnRayJigyohiTy.setZtykrsgjhknsyukigousdkbn(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtykrsgjhknsyukigousdkbn());
            pKsnRayJigyohiTy.setZtysotodasisyouhinkaiteikbn(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtysotodasisyouhinkaiteikbn());
            pKsnRayJigyohiTy.setZtyyobiv4(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobiv4());
            pKsnRayJigyohiTy.setZtygoukeitenkans(pHoyuuMeisaiTyukeiyouItzHzn.getZtygoukeitenkans());
            pKsnRayJigyohiTy.setZtygoukeipbubuntenkans(pHoyuuMeisaiTyukeiyouItzHzn
                .getZtygoukeipbubuntenkans());
            pKsnRayJigyohiTy.setZtytenkanteikisyuruikigou(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtytenkanteikisyuruikigou());
            pKsnRayJigyohiTy.setZtytenkanteikikigousedaikbn(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtytenkanteikikigousedaikbn());
            pKsnRayJigyohiTy.setZtytnkntiksotodasikusnkbn(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtytnkntiksotodasikusnkbn());
            pKsnRayJigyohiTy.setZtytnkntikstdspmenkbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtytnkntikstdspmenkbn());
            pKsnRayJigyohiTy.setZtytenkanteikikigouyobi(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtytenkanteikikigouyobi());
            pKsnRayJigyohiTy.setZtytenkanteikikikan(pHoyuuMeisaiTyukeiyouItzHzn.getZtytenkanteikikikan());
            pKsnRayJigyohiTy.setZtygoukeitenkanteikis(pHoyuuMeisaiTyukeiyouItzHzn.getZtygoukeitenkanteikis());
            pKsnRayJigyohiTy.setZtytnknteikinkshrkkn(pHoyuuMeisaiTyukeiyouItzHzn.getZtytnknteikinkshrkkn());
            pKsnRayJigyohiTy.setZtytenkansiharaikingaku(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtytenkansiharaikingaku());
            pKsnRayJigyohiTy.setZtytnkntikshrkngk(pHoyuuMeisaiTyukeiyouItzHzn.getZtytnkntikshrkngk());
            pKsnRayJigyohiTy.setZtytenkankaisuu(pHoyuuMeisaiTyukeiyouItzHzn.getZtytenkankaisuu());
            pKsnRayJigyohiTy.setZtygoukeitenkankakaku(pHoyuuMeisaiTyukeiyouItzHzn.getZtygoukeitenkankakaku());
            pKsnRayJigyohiTy.setZtytnknkhnbbnjyuturt(pHoyuuMeisaiTyukeiyouItzHzn.getZtytnknkhnbbnjyuturt());
            pKsnRayJigyohiTy.setZtywnasigoukeitenkanteikis(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtywnasigoukeitenkanteikis());
            pKsnRayJigyohiTy.setZtytnknteikikousinmnryouage(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtytnknteikikousinmnryouage());
            pKsnRayJigyohiTy.setZtyyobiv5(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobiv5());
            pKsnRayJigyohiTy.setZtykanyujidatakanrino(pHoyuuMeisaiTyukeiyouItzHzn.getZtykanyujidatakanrino());
            pKsnRayJigyohiTy.setZtykanyujikykymd(pHoyuuMeisaiTyukeiyouItzHzn.getZtykanyujikykymd());
            pKsnRayJigyohiTy.setZtykanyuujihihokensyaage(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtykanyuujihihokensyaage());
            pKsnRayJigyohiTy.setZtykanyuujitenkanhyouji(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtykanyuujitenkanhyouji());
            pKsnRayJigyohiTy.setZtyhsyuikktminaosikaisu(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyhsyuikktminaosikaisu());
            pKsnRayJigyohiTy.setZtysknnjynbknsisnrt(pHoyuuMeisaiTyukeiyouItzHzn.getZtysknnjynbknsisnrt());
            pKsnRayJigyohiTy.setZtytkjykbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtytkjykbn());
            pKsnRayJigyohiTy.setZtysakugenkikan(pHoyuuMeisaiTyukeiyouItzHzn.getZtysakugenkikan());
            pKsnRayJigyohiTy.setZtyryoumasihyouten(pHoyuuMeisaiTyukeiyouItzHzn.getZtyryoumasihyouten());
            pKsnRayJigyohiTy.setZtysykyktkjyuryumsratehyj(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtysykyktkjyuryumsratehyj());
            pKsnRayJigyohiTy.setZtysykyktkjyuryumsrate(pHoyuuMeisaiTyukeiyouItzHzn
                .getZtysykyktkjyuryumsrate());
            pKsnRayJigyohiTy.setZtydai2tokujyoukbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtydai2tokujyoukbn());
            pKsnRayJigyohiTy.setZtydai2sakugenkikan(pHoyuuMeisaiTyukeiyouItzHzn.getZtydai2sakugenkikan());
            pKsnRayJigyohiTy.setZtydai2ryoumasihyouten(pHoyuuMeisaiTyukeiyouItzHzn
                .getZtydai2ryoumasihyouten());
            pKsnRayJigyohiTy.setZtytokuteibuijyoukenhyouji(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtytokuteibuijyoukenhyouji());
            pKsnRayJigyohiTy.setZtytokuteibuino1(pHoyuuMeisaiTyukeiyouItzHzn.getZtytokuteibuino1());
            pKsnRayJigyohiTy.setZtyhtnpkkn1(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhtnpkkn1());
            pKsnRayJigyohiTy.setZtytokuteibuino2(pHoyuuMeisaiTyukeiyouItzHzn.getZtytokuteibuino2());
            pKsnRayJigyohiTy.setZtyhtnpkkn2(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhtnpkkn2());
            pKsnRayJigyohiTy.setZtymhituiryuyutktbijyknhyj(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtymhituiryuyutktbijyknhyj());
            pKsnRayJigyohiTy.setZtymuhaitouiryouyoutktbino1(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtymuhaitouiryouyoutktbino1());
            pKsnRayJigyohiTy.setZtymuhaitouiryouyouhtnpkkn1(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtymuhaitouiryouyouhtnpkkn1());
            pKsnRayJigyohiTy.setZtymuhaitouiryouyoutktbino2(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtymuhaitouiryouyoutktbino2());
            pKsnRayJigyohiTy.setZtymuhaitouiryouyouhtnpkkn2(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtymuhaitouiryouyouhtnpkkn2());
            pKsnRayJigyohiTy.setZtysiteizukipwarimasihyouji(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtysiteizukipwarimasihyouji());
            pKsnRayJigyohiTy.setZtypwarimasisiteim1(pHoyuuMeisaiTyukeiyouItzHzn.getZtypwarimasisiteim1());
            pKsnRayJigyohiTy.setZtypwarimasisiteim2(pHoyuuMeisaiTyukeiyouItzHzn.getZtypwarimasisiteim2());
            pKsnRayJigyohiTy.setZtysiteimsykykpbairitu(pHoyuuMeisaiTyukeiyouItzHzn
                .getZtysiteimsykykpbairitu());
            pKsnRayJigyohiTy.setZtysaisyuusiteiym(pHoyuuMeisaiTyukeiyouItzHzn.getZtysaisyuusiteiym());
            pKsnRayJigyohiTy.setZtysykykkitmttvkeisanym(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtysykykkitmttvkeisanym());
            pKsnRayJigyohiTy.setZtysykykkitmttsknnjynbkngk(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtysykykkitmttsknnjynbkngk());
            pKsnRayJigyohiTy.setZtydftumitatekingaku(pHoyuuMeisaiTyukeiyouItzHzn.getZtydftumitatekingaku());
            pKsnRayJigyohiTy.setZtydftumimasikin(pHoyuuMeisaiTyukeiyouItzHzn.getZtydftumimasikin());
            pKsnRayJigyohiTy.setZtyvbubundftenkankakaku(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyvbubundftenkankakaku());
            pKsnRayJigyohiTy.setZtydpbubundftenkankakaku(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtydpbubundftenkankakaku());
            pKsnRayJigyohiTy.setZtydftmttkngkitjbrbbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtydftmttkngkitjbrbbn());
            pKsnRayJigyohiTy.setZtyhendous(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhendous());
            pKsnRayJigyohiTy.setZtyhengakujigyounendomatucv(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyhengakujigyounendomatucv());
            pKsnRayJigyohiTy.setZtyitibuitijibarais(pHoyuuMeisaiTyukeiyouItzHzn.getZtyitibuitijibarais());
            pKsnRayJigyohiTy.setZtyitibuitijibaraip(pHoyuuMeisaiTyukeiyouItzHzn.getZtyitibuitijibaraip());
            pKsnRayJigyohiTy.setZtyitibitjbrshrkngk(pHoyuuMeisaiTyukeiyouItzHzn.getZtyitibitjbrshrkngk());
            pKsnRayJigyohiTy.setZtygoukeicv(pHoyuuMeisaiTyukeiyouItzHzn.getZtygoukeicv());
            pKsnRayJigyohiTy.setZtyminasicv(pHoyuuMeisaiTyukeiyouItzHzn.getZtyminasicv());
            pKsnRayJigyohiTy.setZtyloanfund(pHoyuuMeisaiTyukeiyouItzHzn.getZtyloanfund());
            pKsnRayJigyohiTy.setZtysaiteihosyougaku(pHoyuuMeisaiTyukeiyouItzHzn.getZtysaiteihosyougaku());
            pKsnRayJigyohiTy.setZtyhngksitihsyuyusykykp(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyhngksitihsyuyusykykp());
            pKsnRayJigyohiTy.setZtyhijynbrivasbujsitihsyugk(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyhijynbrivasbujsitihsyugk());
            pKsnRayJigyohiTy.setZtyhijynbrivamnkjsitihsyugk(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyhijynbrivamnkjsitihsyugk());
            pKsnRayJigyohiTy.setZtysiinkbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtysiinkbn());
            pKsnRayJigyohiTy.setZtymudkaimasikihons(pHoyuuMeisaiTyukeiyouItzHzn.getZtymudkaimasikihons());
            pKsnRayJigyohiTy.setZtykaimasiymd(pHoyuuMeisaiTyukeiyouItzHzn.getZtykaimasiymd());
            pKsnRayJigyohiTy.setZtykaimasikikan(pHoyuuMeisaiTyukeiyouItzHzn.getZtykaimasikikan());
            pKsnRayJigyohiTy.setZtyhikitugikaimasis(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhikitugikaimasis());
            pKsnRayJigyohiTy.setZtymudkaimasisiharaikingaku(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtymudkaimasisiharaikingaku());
            pKsnRayJigyohiTy.setZtyszoukouryokukaisiymdx1(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyszoukouryokukaisiymdx1());
            pKsnRayJigyohiTy.setZtyszouhokensyuruikigoux1(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyszouhokensyuruikigoux1());
            pKsnRayJigyohiTy.setZtyszoukigousedaikbnx1(pHoyuuMeisaiTyukeiyouItzHzn
                .getZtyszoukigousedaikbnx1());
            pKsnRayJigyohiTy.setZtyszoukikanx1(pHoyuuMeisaiTyukeiyouItzHzn.getZtyszoukikanx1());
            pKsnRayJigyohiTy.setZtyszouhihokensyaagex1(pHoyuuMeisaiTyukeiyouItzHzn
                .getZtyszouhihokensyaagex1());
            pKsnRayJigyohiTy.setZtyszoudai2hihknsyaagex1(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyszoudai2hihknsyaagex1());
            pKsnRayJigyohiTy.setZtyzoukasx1(pHoyuuMeisaiTyukeiyouItzHzn.getZtyzoukasx1());
            pKsnRayJigyohiTy.setZtyzennendozoukasx1(pHoyuuMeisaiTyukeiyouItzHzn.getZtyzennendozoukasx1());
            pKsnRayJigyohiTy.setZtyszousiharaikingakux1(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyszousiharaikingakux1());
            pKsnRayJigyohiTy.setZtyszoukouryokukaisiymdx2(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyszoukouryokukaisiymdx2());
            pKsnRayJigyohiTy.setZtyszouhokensyuruikigoux2(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyszouhokensyuruikigoux2());
            pKsnRayJigyohiTy.setZtyszoukigousedaikbnx2(pHoyuuMeisaiTyukeiyouItzHzn
                .getZtyszoukigousedaikbnx2());
            pKsnRayJigyohiTy.setZtyszoukikanx2(pHoyuuMeisaiTyukeiyouItzHzn.getZtyszoukikanx2());
            pKsnRayJigyohiTy.setZtyszouhihokensyaagex2(pHoyuuMeisaiTyukeiyouItzHzn
                .getZtyszouhihokensyaagex2());
            pKsnRayJigyohiTy.setZtyszoudai2hihknsyaagex2(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyszoudai2hihknsyaagex2());
            pKsnRayJigyohiTy.setZtyzoukasx2(pHoyuuMeisaiTyukeiyouItzHzn.getZtyzoukasx2());
            pKsnRayJigyohiTy.setZtyzennendozoukasx2(pHoyuuMeisaiTyukeiyouItzHzn.getZtyzennendozoukasx2());
            pKsnRayJigyohiTy.setZtyszousiharaikingakux2(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyszousiharaikingakux2());
            pKsnRayJigyohiTy.setZtysuuriyouyobin1x5(pHoyuuMeisaiTyukeiyouItzHzn.getZtysuuriyouyobin1x5());
            pKsnRayJigyohiTy.setZtysuuriyouyobin1x6(pHoyuuMeisaiTyukeiyouItzHzn.getZtysuuriyouyobin1x6());
            pKsnRayJigyohiTy.setZtyhrimngkizktkykpmenhyj(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyhrimngkizktkykpmenhyj());
            pKsnRayJigyohiTy.setZtymisyuustartym(pHoyuuMeisaiTyukeiyouItzHzn.getZtymisyuustartym());
            pKsnRayJigyohiTy.setZtymisyuukaisuu(pHoyuuMeisaiTyukeiyouItzHzn.getZtymisyuukaisuu());
            pKsnRayJigyohiTy.setZtyitjbrtkykkousnuktkarhyj(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyitjbrtkykkousnuktkarhyj());
            pKsnRayJigyohiTy.setZtygyousekihyoujis(pHoyuuMeisaiTyukeiyouItzHzn.getZtygyousekihyoujis());
            pKsnRayJigyohiTy.setZtysykykgyusekihyjs(pHoyuuMeisaiTyukeiyouItzHzn.getZtysykykgyusekihyjs());
            pKsnRayJigyohiTy.setZtytenkangyousekihyoujis(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtytenkangyousekihyoujis());
            pKsnRayJigyohiTy.setZtytnknteikigyousekihyjs(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtytnknteikigyousekihyjs());
            pKsnRayJigyohiTy.setZtytnkndpbbngyuskhyjs(pHoyuuMeisaiTyukeiyouItzHzn.getZtytnkndpbbngyuskhyjs());
            pKsnRayJigyohiTy.setZtykykjyoutai(pHoyuuMeisaiTyukeiyouItzHzn.getZtykykjyoutai());
            pKsnRayJigyohiTy.setZtypmenhukakbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtypmenhukakbn());
            pKsnRayJigyohiTy.setZtykousinkbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtykousinkbn());
            pKsnRayJigyohiTy.setZtymankiyoteikbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtymankiyoteikbn());
            pKsnRayJigyohiTy.setZtysykyktikmnkyoteikbn(pHoyuuMeisaiTyukeiyouItzHzn
                .getZtysykyktikmnkyoteikbn());
            pKsnRayJigyohiTy.setZtytnknsykykkhnmnkytikbn(pHoyuuMeisaiTyukeiyouItzHzn
                .getZtytnknsykykkhnmnkytikbn());
            pKsnRayJigyohiTy.setZtytnknsykyktikmnkytikbn(pHoyuuMeisaiTyukeiyouItzHzn
                .getZtytnknsykyktikmnkytikbn());
            pKsnRayJigyohiTy.setZtytenkanteikimankiyoteikbn(pHoyuuMeisaiTyukeiyouItzHzn
                .getZtytenkanteikimankiyoteikbn());
            pKsnRayJigyohiTy.setZtyszoumankiyoteikbnx1(pHoyuuMeisaiTyukeiyouItzHzn
                .getZtyszoumankiyoteikbnx1());
            pKsnRayJigyohiTy.setZtyszoumankiyoteikbnx2(pHoyuuMeisaiTyukeiyouItzHzn
                .getZtyszoumankiyoteikbnx2());
            pKsnRayJigyohiTy
            .setZtyvestingmankiyoteikbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtyvestingmankiyoteikbn());
            pKsnRayJigyohiTy.setZtyvkeisanhyouji(pHoyuuMeisaiTyukeiyouItzHzn.getZtyvkeisanhyouji());
            pKsnRayJigyohiTy.setZtytoukisinkeiyakuhyouji(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtytoukisinkeiyakuhyouji());
            pKsnRayJigyohiTy.setZtysykykhokenhoutekiyouhyj(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtysykykhokenhoutekiyouhyj());
            pKsnRayJigyohiTy.setZtytokuteijyoutaihushrhyj(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtytokuteijyoutaihushrhyj());
            pKsnRayJigyohiTy.setZtyytirrthndsysnmnskaisuu(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyytirrthndsysnmnskaisuu());
            pKsnRayJigyohiTy.setZtysuuriyouyobin3(pHoyuuMeisaiTyukeiyouItzHzn.getZtysuuriyouyobin3());
            pKsnRayJigyohiTy.setZtysuuriyouyobin11(pHoyuuMeisaiTyukeiyouItzHzn.getZtysuuriyouyobin11());
            pKsnRayJigyohiTy.setZtywnasigoukeitenkankakaku(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtywnasigoukeitenkankakaku());
            pKsnRayJigyohiTy.setZtyyobin11(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobin11());
            pKsnRayJigyohiTy.setZtyyobin11x2(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobin11x2());
            pKsnRayJigyohiTy.setZtyyobin11x3(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobin11x3());
            pKsnRayJigyohiTy.setZtytukibaraikansantokujyoup(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtytukibaraikansantokujyoup());
            pKsnRayJigyohiTy.setZtytnkngkykkssnkijyuym(pHoyuuMeisaiTyukeiyouItzHzn
                .getZtytnkngkykkssnkijyuym());
            pKsnRayJigyohiTy.setZtysaiteihosyouhyouji(pHoyuuMeisaiTyukeiyouItzHzn.getZtysaiteihosyouhyouji());
            pKsnRayJigyohiTy.setZtysuuriyouyobin8x2(pHoyuuMeisaiTyukeiyouItzHzn.getZtysuuriyouyobin8x2());
            pKsnRayJigyohiTy.setZtysuuriyouyobin14(pHoyuuMeisaiTyukeiyouItzHzn.getZtysuuriyouyobin14());
            pKsnRayJigyohiTy.setZtyhrimngtkykphrkkaisuukbn(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyhrimngtkykphrkkaisuukbn());
            pKsnRayJigyohiTy.setZtyhrimngtkykphrkkirkbn(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyhrimngtkykphrkkirkbn());
            pKsnRayJigyohiTy.setZtyhrimngtkykpryurtkbn(pHoyuuMeisaiTyukeiyouItzHzn
                .getZtyhrimngtkykpryurtkbn());
            pKsnRayJigyohiTy.setZtyyobiv13(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobiv13());
            pKsnRayJigyohiTy.setZtyidoujisaiteihosyoukngk(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyidoujisaiteihosyoukngk());
            pKsnRayJigyohiTy.setZtyidoujisaiteihosyoucost(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyidoujisaiteihosyoucost());
            pKsnRayJigyohiTy.setZtysinhokenfundtumitatekin(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtysinhokenfundtumitatekin());
            pKsnRayJigyohiTy.setZtymsyuptusshkgkaiykhnrikn(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtymsyuptusshkgkaiykhnrikn());
            pKsnRayJigyohiTy.setZtyrrthndugtnkgetumatuv(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyrrthndugtnkgetumatuv());
            pKsnRayJigyohiTy.setZtyrrthndnksaiteihosyonkgns(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyrrthndnksaiteihosyonkgns());
            pKsnRayJigyohiTy.setZtyrrthendougatanksibous(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyrrthendougatanksibous());
            pKsnRayJigyohiTy.setZtyalmyousohutomeisyoukbn(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyalmyousohutomeisyoukbn());
            pKsnRayJigyohiTy.setZtysnkyksoftmeisyoukbn(pHoyuuMeisaiTyukeiyouItzHzn
                .getZtysnkyksoftmeisyoukbn());
            pKsnRayJigyohiTy.setZtysoftmeisyoukbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtysoftmeisyoukbn());
            pKsnRayJigyohiTy.setZtykykjitokujyouarihyj(pHoyuuMeisaiTyukeiyouItzHzn
                .getZtykykjitokujyouarihyj());
            pKsnRayJigyohiTy.setZtybnkttnknkbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtybnkttnknkbn());
            pKsnRayJigyohiTy.setZtytenkanminaosikbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtytenkanminaosikbn());
            pKsnRayJigyohiTy.setZtysoujikeitenkankbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtysoujikeitenkankbn());
            pKsnRayJigyohiTy.setZtynenkinkaisinendo(pHoyuuMeisaiTyukeiyouItzHzn.getZtynenkinkaisinendo());
            pKsnRayJigyohiTy.setZtynenkingatakbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtynenkingatakbn());
            pKsnRayJigyohiTy.setZtynknshry(pHoyuuMeisaiTyukeiyouItzHzn.getZtynknshry());
            pKsnRayJigyohiTy.setZtyheiyoubaraikeiyakukbn(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyheiyoubaraikeiyakukbn());
            pKsnRayJigyohiTy.setZtynenkinmaruteihukakbn(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtynenkinmaruteihukakbn());
            pKsnRayJigyohiTy.setZtysinseizonmrtiarihyj(pHoyuuMeisaiTyukeiyouItzHzn
                .getZtysinseizonmrtiarihyj());
            pKsnRayJigyohiTy.setZtysnkykyouibokijyukbn(pHoyuuMeisaiTyukeiyouItzHzn
                .getZtysnkykyouibokijyukbn());
            pKsnRayJigyohiTy.setZtytokusitujyuusitusetkbn(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtytokusitujyuusitusetkbn());
            pKsnRayJigyohiTy.setZtysiktsyuknbyugnhsyunshyj(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtysiktsyuknbyugnhsyunshyj());
            pKsnRayJigyohiTy.setZtypmensugugtganhsyunshyj(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtypmensugugtganhsyunshyj());
            pKsnRayJigyohiTy.setZtytkykgyousekihyjszerohyj(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtytkykgyousekihyjszerohyj());
            pKsnRayJigyohiTy.setZtysuuriyouyobin7(pHoyuuMeisaiTyukeiyouItzHzn.getZtysuuriyouyobin7());
            pKsnRayJigyohiTy.setZtysyussaikeitaikbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtysyussaikeitaikbn());
            pKsnRayJigyohiTy.setZtyyobiv6(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobiv6());
            pKsnRayJigyohiTy.setZtybosyuukeitaikbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtybosyuukeitaikbn());
            pKsnRayJigyohiTy.setZtyaatukaisosikicd(pHoyuuMeisaiTyukeiyouItzHzn.getZtyaatukaisosikicd());
            pKsnRayJigyohiTy.setZtyaatukaikojincd(pHoyuuMeisaiTyukeiyouItzHzn.getZtyaatukaikojincd());
            pKsnRayJigyohiTy.setZtybsydrtencd(pHoyuuMeisaiTyukeiyouItzHzn.getZtybsydrtencd());
            pKsnRayJigyohiTy.setZtycifcd(pHoyuuMeisaiTyukeiyouItzHzn.getZtycifcd());
            pKsnRayJigyohiTy.setZtysuuriyouyobiv8(pHoyuuMeisaiTyukeiyouItzHzn.getZtysuuriyouyobiv8());
            pKsnRayJigyohiTy.setZtysinsakbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtysinsakbn());
            pKsnRayJigyohiTy.setZtydai2hihokensyasinsakbn(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtydai2hihokensyasinsakbn());
            pKsnRayJigyohiTy.setZtytoukeiyousinsakbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtytoukeiyousinsakbn());
            pKsnRayJigyohiTy.setZtydai2toukeiyousinsakbn(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtydai2toukeiyousinsakbn());
            pKsnRayJigyohiTy.setZtyketteikijyunkanwakbn(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyketteikijyunkanwakbn());
            pKsnRayJigyohiTy.setZtykihonsibouhyoukbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtykihonsibouhyoukbn());
            pKsnRayJigyohiTy.setZtyteikisibouhyoukbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtyteikisibouhyoukbn());
            pKsnRayJigyohiTy.setZtysonotasibouhyoukbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtysonotasibouhyoukbn());
            pKsnRayJigyohiTy.setZtymrarihyj(pHoyuuMeisaiTyukeiyouItzHzn.getZtymrarihyj());
            pKsnRayJigyohiTy.setZtysentakujyouhouarihyouji(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtysentakujyouhouarihyouji());
            pKsnRayJigyohiTy.setZtydugktnknsntkhuhukbn(pHoyuuMeisaiTyukeiyouItzHzn
                .getZtydugktnknsntkhuhukbn());
            pKsnRayJigyohiTy.setZtygengakutenkankykhyj(pHoyuuMeisaiTyukeiyouItzHzn
                .getZtygengakutenkankykhyj());
            pKsnRayJigyohiTy.setZtysykgycd(pHoyuuMeisaiTyukeiyouItzHzn.getZtysykgycd());
            pKsnRayJigyohiTy.setZtyjidoukousinkykkanyuuymd(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyjidoukousinkykkanyuuymd());
            pKsnRayJigyohiTy.setZtysaikohtnknkykkykymd(pHoyuuMeisaiTyukeiyouItzHzn
                .getZtysaikohtnknkykkykymd());
            pKsnRayJigyohiTy.setZtykousinmaesykyksburtkbn(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtykousinmaesykyksburtkbn());
            pKsnRayJigyohiTy.setZtyhjnkykhyj(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhjnkykhyj());
            pKsnRayJigyohiTy.setZtyanniskcd(pHoyuuMeisaiTyukeiyouItzHzn.getZtyanniskcd());
            pKsnRayJigyohiTy.setZtyhjncd(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhjncd());
            pKsnRayJigyohiTy.setZtyhjnjigyosyocd(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhjnjigyosyocd());
            pKsnRayJigyohiTy.setZtysaihokenno(pHoyuuMeisaiTyukeiyouItzHzn.getZtysaihokenno());
            pKsnRayJigyohiTy.setZtydakuhikettikekkacd(pHoyuuMeisaiTyukeiyouItzHzn.getZtydakuhikettikekkacd());
            pKsnRayJigyohiTy.setZtydai2dakuhiketteikekkacd(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtydai2dakuhiketteikekkacd());
            pKsnRayJigyohiTy.setZtypmenkbnv2(pHoyuuMeisaiTyukeiyouItzHzn.getZtypmenkbnv2());
            pKsnRayJigyohiTy.setZtysiboukyuuhukin(pHoyuuMeisaiTyukeiyouItzHzn.getZtysiboukyuuhukin());
            pKsnRayJigyohiTy.setZtyjyudthumeharaitkykhkhyj(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyjyudthumeharaitkykhkhyj());
            pKsnRayJigyohiTy.setZtyhaitoukbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhaitoukbn());
            pKsnRayJigyohiTy.setZtyhhknnentysihyj(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhhknnentysihyj());
            pKsnRayJigyohiTy.setZtydai2hhknnentysihyj(pHoyuuMeisaiTyukeiyouItzHzn.getZtydai2hhknnentysihyj());
            pKsnRayJigyohiTy.setZtykyksyaagetyouseihyj(pHoyuuMeisaiTyukeiyouItzHzn
                .getZtykyksyaagetyouseihyj());
            pKsnRayJigyohiTy.setZtykituenkbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtykituenkbn());
            pKsnRayJigyohiTy.setZtykituenhonsuu(pHoyuuMeisaiTyukeiyouItzHzn.getZtykituenhonsuu());
            pKsnRayJigyohiTy.setZtymusentakukeiyakukbn(pHoyuuMeisaiTyukeiyouItzHzn
                .getZtymusentakukeiyakukbn());
            pKsnRayJigyohiTy.setZtyyobiv6x2(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobiv6x2());
            pKsnRayJigyohiTy.setZtylivingneedstkykarihyj(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtylivingneedstkykarihyj());
            pKsnRayJigyohiTy.setZtylivingneedssiharaihyouji(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtylivingneedssiharaihyouji());
            pKsnRayJigyohiTy.setZtylnseikyuuymd(pHoyuuMeisaiTyukeiyouItzHzn.getZtylnseikyuuymd());
            pKsnRayJigyohiTy.setZtylnshrgenincd(pHoyuuMeisaiTyukeiyouItzHzn.getZtylnshrgenincd());
            pKsnRayJigyohiTy.setZtydakuhikettisyacd(pHoyuuMeisaiTyukeiyouItzHzn.getZtydakuhikettisyacd());
            pKsnRayJigyohiTy.setZtydai2dakuhiketteisyacd(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtydai2dakuhiketteisyacd());
            pKsnRayJigyohiTy.setZtygansapotokuyakuarihyouji(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtygansapotokuyakuarihyouji());
            pKsnRayJigyohiTy.setZtygnspshrhyj(pHoyuuMeisaiTyukeiyouItzHzn.getZtygnspshrhyj());
            pKsnRayJigyohiTy.setZtygansaposeikyuuymd(pHoyuuMeisaiTyukeiyouItzHzn.getZtygansaposeikyuuymd());
            pKsnRayJigyohiTy.setZtygnspshrgenincd(pHoyuuMeisaiTyukeiyouItzHzn.getZtygnspshrgenincd());
            pKsnRayJigyohiTy.setZtyyobiv3x2(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobiv3x2());
            pKsnRayJigyohiTy.setZtytargetmokuhyouritu(pHoyuuMeisaiTyukeiyouItzHzn.getZtytargetmokuhyouritu());
            pKsnRayJigyohiTy.setZtyautoswitchmokuhyouritu(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyautoswitchmokuhyouritu());
            pKsnRayJigyohiTy.setZtytumitatekinitenarihyj(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtytumitatekinitenarihyj());
            pKsnRayJigyohiTy.setZtytumitatekinitenkaisuu(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtytumitatekinitenkaisuu());
            pKsnRayJigyohiTy.setZtydatakanrino2(pHoyuuMeisaiTyukeiyouItzHzn.getZtydatakanrino2());
            pKsnRayJigyohiTy.setZtydatakanrino3(pHoyuuMeisaiTyukeiyouItzHzn.getZtydatakanrino3());
            pKsnRayJigyohiTy.setZtyknkuzusnzyrttekinendo(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyknkuzusnzyrttekinendo());
            pKsnRayJigyohiTy.setZtyknkuzusnzyrt(pHoyuuMeisaiTyukeiyouItzHzn.getZtyknkuzusnzyrt());
            pKsnRayJigyohiTy.setZtyknkuzusnzyrtx2(pHoyuuMeisaiTyukeiyouItzHzn.getZtyknkuzusnzyrtx2());
            pKsnRayJigyohiTy.setZtyknkuzusnzyrtx3(pHoyuuMeisaiTyukeiyouItzHzn.getZtyknkuzusnzyrtx3());
            pKsnRayJigyohiTy.setZtysinkeiyakujiknkuzusnzyrt(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtysinkeiyakujiknkuzusnzyrt());
            pKsnRayJigyohiTy.setZtytenkanjiknkuzusnzyrt(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtytenkanjiknkuzusnzyrt());
            pKsnRayJigyohiTy.setZtysinkeiyakujivithkhyouji(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtysinkeiyakujivithkhyouji());
            pKsnRayJigyohiTy.setZtykykjivithukusuukykhyj(pHoyuuMeisaiTyukeiyouItzHzn.getZtykykjivithukusuukykhyj());
            pKsnRayJigyohiTy.setZtysuuriyouyobin9x2(pHoyuuMeisaiTyukeiyouItzHzn.getZtysuuriyouyobin9x2());
            pKsnRayJigyohiTy.setZtypwrbksidhitekiyouhyj(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtypwrbksidhitekiyouhyj());
            pKsnRayJigyohiTy.setZtysuuriyouyobin9(pHoyuuMeisaiTyukeiyouItzHzn.getZtysuuriyouyobin9());
            pKsnRayJigyohiTy.setZtysuuriyouyobin10x7(pHoyuuMeisaiTyukeiyouItzHzn.getZtysuuriyouyobin10x7());
            pKsnRayJigyohiTy.setZtysuuriyouyobin10x8(pHoyuuMeisaiTyukeiyouItzHzn.getZtysuuriyouyobin10x8());
            pKsnRayJigyohiTy.setZtysuuriyouyobin10x9(pHoyuuMeisaiTyukeiyouItzHzn.getZtysuuriyouyobin10x9());
            pKsnRayJigyohiTy.setZtytumitatekinitenbubun(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtytumitatekinitenbubun());
            pKsnRayJigyohiTy.setZtysagakusknnjynbknzndk(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtysagakusknnjynbknzndk());
            pKsnRayJigyohiTy.setZtyyobin11x5(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobin11x5());
            pKsnRayJigyohiTy.setZtyyobin11x6(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobin11x6());
            pKsnRayJigyohiTy.setZtyyobin11x7(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobin11x7());
            pKsnRayJigyohiTy.setZtyyobin11x8(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobin11x8());
            pKsnRayJigyohiTy.setZtyyobin11x9(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobin11x9());
            pKsnRayJigyohiTy.setZtyyobin11x10(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobin11x10());
            pKsnRayJigyohiTy.setZtyyobin11x11(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobin11x11());
            pKsnRayJigyohiTy.setZtyyobin11x12(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobin11x12());
            pKsnRayJigyohiTy.setZtyyobin11x13(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobin11x13());
            pKsnRayJigyohiTy.setZtyyobin11x14(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobin11x14());
            pKsnRayJigyohiTy.setZtyyobin11x15(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobin11x15());
            pKsnRayJigyohiTy.setZtyyobin11x16(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobin11x16());
            pKsnRayJigyohiTy.setZtyyobin11x17(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobin11x17());
            pKsnRayJigyohiTy.setZtyzyrthntiyustatuskbn(pHoyuuMeisaiTyukeiyouItzHzn
                .getZtyzyrthntiyustatuskbn());
            pKsnRayJigyohiTy.setZtyzyrthntiyustatuskbnx2(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyzyrthntiyustatuskbnx2());
            pKsnRayJigyohiTy.setZtyzyrthntiyustatuskbnx3(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyzyrthntiyustatuskbnx3());
            pKsnRayJigyohiTy.setZtyzyrthntiyustatuskbnx4(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyzyrthntiyustatuskbnx4());
            pKsnRayJigyohiTy.setZtyzyrthntiyustatuskbnx5(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyzyrthntiyustatuskbnx5());
            pKsnRayJigyohiTy.setZtyyobiv10(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobiv10());
            pKsnRayJigyohiTy.setZtyyobiv15x2(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobiv15x2());
            pKsnRayJigyohiTy.setZtyyobiv15x3(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobiv15x3());
            pKsnRayJigyohiTy.setZtyyobiv15x4(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobiv15x4());
            pKsnRayJigyohiTy.setZtygaikakbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtygaikakbn());
            pKsnRayJigyohiTy.setZtykawaserate1(pHoyuuMeisaiTyukeiyouItzHzn.getZtykawaserate1());
            pKsnRayJigyohiTy.setZtykawaseratetekiyouymd1(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtykawaseratetekiyouymd1());
            pKsnRayJigyohiTy.setZtykawaserate2(pHoyuuMeisaiTyukeiyouItzHzn.getZtykawaserate2());
            pKsnRayJigyohiTy.setZtykawaseratetekiyouymd2(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtykawaseratetekiyouymd2());
            pKsnRayJigyohiTy.setZtykykjikawaserate(pHoyuuMeisaiTyukeiyouItzHzn.getZtykykjikawaserate());
            pKsnRayJigyohiTy.setZtykykjikawaseratetkyuymd(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtykykjikawaseratetkyuymd());
            pKsnRayJigyohiTy.setZtymvatyouseigow(pHoyuuMeisaiTyukeiyouItzHzn.getZtymvatyouseigow());
            pKsnRayJigyohiTy.setZtymvakeisanjisknnjynbkn(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtymvakeisanjisknnjynbkn());
            pKsnRayJigyohiTy.setZtykaiyakukoujyoritu(pHoyuuMeisaiTyukeiyouItzHzn.getZtykaiyakukoujyoritu());
            pKsnRayJigyohiTy.setZtyrendouritu(pHoyuuMeisaiTyukeiyouItzHzn.getZtyrendouritu());
            pKsnRayJigyohiTy.setZtysrkaiyakusjkkktyouseirrt(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtysrkaiyakusjkkktyouseirrt());
            pKsnRayJigyohiTy.setZtysrkyksjkkktyouseiriritu(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtysrkyksjkkktyouseiriritu());
            pKsnRayJigyohiTy.setZtymvakeisankijyunymd(pHoyuuMeisaiTyukeiyouItzHzn.getZtymvakeisankijyunymd());
            pKsnRayJigyohiTy.setZtymvatyouseikou(pHoyuuMeisaiTyukeiyouItzHzn.getZtymvatyouseikou());
            pKsnRayJigyohiTy.setZtyenkdtsbujsitihsyukngk(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyenkdtsbujsitihsyukngk());
            pKsnRayJigyohiTy.setZtyenkdtsbujsitihsyucost(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyenkdtsbujsitihsyucost());
            pKsnRayJigyohiTy.setZtyenkdtsbujsitihsyuarihyj(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyenkdtsbujsitihsyuarihyj());
            pKsnRayJigyohiTy.setZtykeiyakujiyoteiriritu(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtykeiyakujiyoteiriritu());
            pKsnRayJigyohiTy.setZtytumitateriritu(pHoyuuMeisaiTyukeiyouItzHzn.getZtytumitateriritu());
            pKsnRayJigyohiTy.setZtykaigomaebaraitkykarihyj(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtykaigomaebaraitkykarihyj());
            pKsnRayJigyohiTy.setZtysibouhyoukbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtysibouhyoukbn());
            pKsnRayJigyohiTy.setZtynyuukintuukakbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtynyuukintuukakbn());
            pKsnRayJigyohiTy.setZtysiharaituukakbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtysiharaituukakbn());
            pKsnRayJigyohiTy.setZtywyendttargetmokuhyouritu(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtywyendttargetmokuhyouritu());
            pKsnRayJigyohiTy.setZtysisuurendourate(pHoyuuMeisaiTyukeiyouItzHzn.getZtysisuurendourate());
            pKsnRayJigyohiTy.setZtysisuukbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtysisuukbn());
            pKsnRayJigyohiTy.setZtyteirituikouhyouji(pHoyuuMeisaiTyukeiyouItzHzn.getZtyteirituikouhyouji());
            pKsnRayJigyohiTy.setZtysrdai1hknkkn(pHoyuuMeisaiTyukeiyouItzHzn.getZtysrdai1hknkkn());
            pKsnRayJigyohiTy.setZtysuuriyouyobin10x11(pHoyuuMeisaiTyukeiyouItzHzn.getZtysuuriyouyobin10x11());
            pKsnRayJigyohiTy.setZtytmttknzoukaritujygn(pHoyuuMeisaiTyukeiyouItzHzn
                .getZtytmttknzoukaritujygn());
            pKsnRayJigyohiTy.setZtysetteibairitu(pHoyuuMeisaiTyukeiyouItzHzn.getZtysetteibairitu());
            pKsnRayJigyohiTy.setZtytykzenoutouymdsisuu(pHoyuuMeisaiTyukeiyouItzHzn
                .getZtytykzenoutouymdsisuu());
            pKsnRayJigyohiTy.setZtykimatusisuu(pHoyuuMeisaiTyukeiyouItzHzn.getZtykimatusisuu());
            pKsnRayJigyohiTy.setZtytuukasyukbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtytuukasyukbn());
            pKsnRayJigyohiTy.setZtyyobiv2(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobiv2());
            pKsnRayJigyohiTy.setZtyyenkadatekihons(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyenkadatekihons());
            pKsnRayJigyohiTy.setZtysitihsyumegkdtsibous(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtysitihsyumegkdtsibous());
            pKsnRayJigyohiTy.setZtyenkdtssrentumitatekin(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyenkdtssrentumitatekin());
            pKsnRayJigyohiTy.setZtysisuurentumitatekin(pHoyuuMeisaiTyukeiyouItzHzn
                .getZtysisuurentumitatekin());
            pKsnRayJigyohiTy.setZtynksjitirttumitatekin(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtynksjitirttumitatekin());
            pKsnRayJigyohiTy.setZtykimatutirttumitatekin(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtykimatutirttumitatekin());
            pKsnRayJigyohiTy.setZtygaikadatejyuutoup(pHoyuuMeisaiTyukeiyouItzHzn.getZtygaikadatejyuutoup());
            pKsnRayJigyohiTy.setZtyyendttargetkijyunkingaku(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyyendttargetkijyunkingaku());
            pKsnRayJigyohiTy.setZtyyobiv7(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobiv7());
            pKsnRayJigyohiTy.setZtysitivkisnyukykjikwsrate(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtysitivkisnyukykjikwsrate());
            pKsnRayJigyohiTy.setZtysisuurentyokugotmttkn(pHoyuuMeisaiTyukeiyouItzHzn.getZtysisuurentyokugotmttkn());
        }
    }

    private void editRayJigyohi(SrRayJigyohiBatchParam pSrRayJigyohiBatchParam,
        C_KessanKbn pKessanKbn,
        int pRegetuEditTaisyou,
        ST_HoyuuMeisaiTyukeiyouItzHzn pHoyuuMeisaiTyukeiyouItzHzn,
        TkJitenKeiyakuSyouhinKijyunBean pTkJitenKeiyakuSyouhinKijyunBean,
        ZT_RayJigyohiTy pRayJigyohiTy,
        ZT_KsnRayJigyohiTy pKsnRayJigyohiTy,
        TkJitenKeiyakuSyouhinKijyunBean pTkJitenKeiyakuSyouhinKijyunBean_gmjiten) {

        BizDateYM loadingKeijyoYm = null;

        String gmKijyHyj = "";

        String sihankiKsnydataHyj = "";

        BizCurrency vhireilKisnyukngkTeiritu = BizCurrency.valueOf(0);

        BizCurrency vhireilKisnyukngkSisuu = BizCurrency.valueOf(0);

        BizCurrency rpKeisanyouSibous = BizCurrency.valueOf(0);

        KeisanWKijunYM keisanWKijunYM = SWAKInjector.getInstance(KeisanWKijunYM.class);

        SrGetTokutejitenSyohnInfo srGetTokutejitenSyohnInfo = SWAKInjector
            .getInstance(SrGetTokutejitenSyohnInfo.class);

        SrGetTokutejitenSisuurendoTmttknInfo srGetTokutejitenSisuurendoTmttknInfo =
            SWAKInjector.getInstance(SrGetTokutejitenSisuurendoTmttknInfo.class);

        TkJitenKeiyakuSyouhinKijyunBean tkJitenKeiyakuSyouhinKijyunBean =
            SWAKInjector.getInstance(TkJitenKeiyakuSyouhinKijyunBean.class);

        if (pRegetuEditTaisyou == SrCommonConstants.DEFAULT_INT_ZERO) {
            loadingKeijyoYm = pSrRayJigyohiBatchParam.getKijyunymd().getBizDateYM();
            gmKijyHyj = SrCommonConstants.HYOUJI_ARI;
        }
        else {
            loadingKeijyoYm = pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getBizDateYM();
            gmKijyHyj = SrCommonConstants.HYOUJI_NASI;
        }

        if (pKessanKbn.eq(C_KessanKbn.TUUJYOU)) {
            sihankiKsnydataHyj = SrCommonConstants.HYOUJI_NASI;
        }
        else if (pKessanKbn.eq(C_KessanKbn.KESSAN)) {
            sihankiKsnydataHyj = SrCommonConstants.HYOUJI_ARI;
        }

        SrRayJigyohiBatchDbAccess srRayJigyohiBatchDbAccess = SWAKInjector
            .getInstance(SrRayJigyohiBatchDbAccess.class);
        List<SrGetTokutejitenTmttknInfoBean> srGetTokutejitenTmttknInfoBeanList = Lists.newArrayList();

        List<SV_KiykSyuhnData> tumimasimaewKiykSyuhnDataLst =
            srRayJigyohiBatchDbAccess.getKiykSyuhnDatas(
                pHoyuuMeisaiTyukeiyouItzHzn.getZtydatakanrino(), C_SyutkKbn.SYU);

        if (BizDateUtil.compareYmd(pSrRayJigyohiBatchParam.getKijyunymd(),
            pTkJitenKeiyakuSyouhinKijyunBean.getKykymd()) == BizDateUtil.COMPARE_LESSER
            || pRegetuEditTaisyou != SrCommonConstants.DEFAULT_INT_ZERO) {

            List<IT_KhSisuurendoTmttkn> khSisuurendoTmttknLst = srRayJigyohiBatchDbAccess
                .getKhSisuurendoTmttknBySyonoTmttknkouryokukaisiymdAsc(pHoyuuMeisaiTyukeiyouItzHzn.getZtydatakanrino(),
                    pTkJitenKeiyakuSyouhinKijyunBean.getKykymd());

            IT_KhSisuurendoTmttkn khSisuurendoTmttkn = khSisuurendoTmttknLst.get(0);

            vhireilKisnyukngkTeiritu = khSisuurendoTmttkn.getTeiritutmttkngk();
            vhireilKisnyukngkSisuu = khSisuurendoTmttkn.getSisuurendoutmttkngk();
            rpKeisanyouSibous = khSisuurendoTmttkn.getTeiritutmttkngk()
                .add(khSisuurendoTmttkn.getSisuurendoutmttkngk());
        }
        else {
            if (pTkJitenKeiyakuSyouhinKijyunBean_gmjiten.getYendthnkymd() != null) {
                vhireilKisnyukngkTeiritu = BizCurrency.valueOf(pHoyuuMeisaiTyukeiyouItzHzn.getZtykimatutirttumitatekin());
                vhireilKisnyukngkSisuu = BizCurrency.valueOf(0);
                rpKeisanyouSibous = BizCurrency.valueOf(0);
            }
            else {

                if (pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() != null) {

                    TkJitenKeiyakuSyouhinBean tkJitenKeiyakuSyouhinBean = srGetTokutejitenSyohnInfo.exec(
                        C_TokutejitenSyoriKbn.KIJYUNBIJITENSYOUHININFO,
                        pHoyuuMeisaiTyukeiyouItzHzn.getZtydatakanrino(),
                        pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd(),
                        "",
                        tumimasimaewKiykSyuhnDataLst);
                    TkJitenKeiyakuSyouhinKijyunBean tkJitenKeiyakuSyouhinKijyunBeanYendthnk =
                        tkJitenKeiyakuSyouhinBean.getTkJitenKeiyakuSyouhinKijyunBeanAto();

                    tkJitenKeiyakuSyouhinBean = srGetTokutejitenSyohnInfo.exec(
                        C_TokutejitenSyoriKbn.TOKUTEIIDOUSYOUHININFO,
                        pHoyuuMeisaiTyukeiyouItzHzn.getZtydatakanrino(),
                        null,
                        tkJitenKeiyakuSyouhinKijyunBeanYendthnk.getHenkousikibetukey(),
                        tumimasimaewKiykSyuhnDataLst);

                    tkJitenKeiyakuSyouhinKijyunBean = tkJitenKeiyakuSyouhinBean.getTkJitenKeiyakuSyouhinKijyunBeanMae();
                }
                else {

                    tkJitenKeiyakuSyouhinKijyunBean = pTkJitenKeiyakuSyouhinKijyunBean;
                }

                BizDate calckijyunYmd = BizDate.valueOf(loadingKeijyoYm,
                    tkJitenKeiyakuSyouhinKijyunBean.getKykymd().getDay()).getRekijyou();

                srGetTokutejitenTmttknInfoBeanList =
                    srGetTokutejitenSisuurendoTmttknInfo.exec(pHoyuuMeisaiTyukeiyouItzHzn.getZtydatakanrino(),
                        calckijyunYmd, null, tumimasimaewKiykSyuhnDataLst);

                KhSisuurendoTmttknBean khSisuurendoTmttknBean = srGetTokutejitenSisuurendoTmttknInfo
                    .getSisuurendoTmttknInfo(calckijyunYmd, null, srGetTokutejitenTmttknInfoBeanList);
                IT_KhSisuurendoTmttkn khSisuurendoTmttkn = khSisuurendoTmttknBean.getKhSisuurendoTmttknAto();

                GetSjkkktyouseiyouriritu getSjkkktyouseiyouriritu = SWAKInjector
                    .getInstance(GetSjkkktyouseiyouriritu.class);
                GetSjkkktyouseiyourirituBean getSjkkktyouseiyourirituBean = SWAKInjector
                    .getInstance(GetSjkkktyouseiyourirituBean.class);
                KeisanW keisanW = SWAKInjector.getInstance(KeisanW.class);
                KeisanWExtBean keisanWExtBean = SWAKInjector.getInstance(KeisanWExtBean.class);
                BizNumber kaiyakuSjkkktyouseiriritu = BizNumber.ZERO;
                BizDateYM tmttkntaisyouym = null;
                BizCurrency teirituTmttkngk = BizCurrency.valueOf(0);
                BizCurrency sisuuTmttkngk = BizCurrency.valueOf(0);
                BizNumber tumitateriritu = BizNumber.ZERO;


                BizDateYM kaiyakuhrKisnKijyunYM = keisanWKijunYM.exec(tkJitenKeiyakuSyouhinKijyunBean.getKykymd(),
                    calckijyunYmd, null, null, tkJitenKeiyakuSyouhinKijyunBean.getKykjyoutai(),
                    tkJitenKeiyakuSyouhinKijyunBean.getSyouhncd(), tkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd());

                if (BizDateUtil.calcDifferenceMonths(kaiyakuhrKisnKijyunYM,
                    khSisuurendoTmttkn.getTmttkntaisyouym()) > SrCommonConstants.KIKAN_12M) {

                    int keikamon = BizDateUtil.calcDifferenceMonths(
                        kaiyakuhrKisnKijyunYM,
                        khSisuurendoTmttkn.getTmttkntaisyouym());

                    int keikanensuu = keikamon / SrCommonConstants.KIKAN_12M;

                    tmttkntaisyouym = khSisuurendoTmttkn.getTmttkntaisyouym().addYears(keikanensuu);

                    KeisanSisuuRendouNkTmttknOverNnd keisanSisuuRendouNkTmttknOverNnd =
                        SWAKInjector.getInstance(KeisanSisuuRendouNkTmttknOverNnd.class);
                    C_ErrorKbn errorKbn = keisanSisuuRendouNkTmttknOverNnd.exec(
                        tkJitenKeiyakuSyouhinKijyunBean.getKykymd(),
                        tkJitenKeiyakuSyouhinKijyunBean.getHknkkn(),
                        C_UmuKbn.valueOf(pHoyuuMeisaiTyukeiyouItzHzn.getZtysrteikishrtkykhukaumu()),
                        tkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu(),
                        BizDate.valueOf(tmttkntaisyouym, tkJitenKeiyakuSyouhinKijyunBean.getKykymd().getDay()).getRekijyou(),
                        tmttkntaisyouym,
                        khSisuurendoTmttkn.getTmttkntaisyouym(),
                        tkJitenKeiyakuSyouhinKijyunBean.getTumitateriritu(),
                        khSisuurendoTmttkn.getTeiritutmttkngk(),
                        khSisuurendoTmttkn.getSisuurendoutmttkngk());

                    if (errorKbn.eq(C_ErrorKbn.ERROR)) {
                        String message = MessageUtil.getMessage(MessageId.ESA1001,
                            "積立金計算：Ｖ比例Ｌ計算用金額、ＲＰ計算用死亡Ｓ",
                            pHoyuuMeisaiTyukeiyouItzHzn.getZtydatakanrino());

                        batchLogger.warn(message);

                        ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

                        suuriyouErrJyouhou.setSyoriYmd(pSrRayJigyohiBatchParam.getSyoriYmd());
                        suuriyouErrJyouhou.setKakutyoujobcd(pSrRayJigyohiBatchParam.getIbKakutyoujobcd());
                        suuriyouErrJyouhou.setSyono(pHoyuuMeisaiTyukeiyouItzHzn.getZtydatakanrino());
                        suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(message);
                        suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

                        ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

                        pSrRayJigyohiBatchParam.setZokkouErrorSyoriCount(pSrRayJigyohiBatchParam
                            .getZokkouErrorSyoriCount() + 1);

                        errorFlag = true;
                    }
                    else {

                        teirituTmttkngk = keisanSisuuRendouNkTmttknOverNnd.getTeiritutmttkngk();
                        sisuuTmttkngk = keisanSisuuRendouNkTmttknOverNnd.getSisuurendoutmttkngk();
                        tumitateriritu = tkJitenKeiyakuSyouhinKijyunBean.getTumitateriritu();
                    }
                }

                else {

                    tmttkntaisyouym = khSisuurendoTmttkn.getTmttkntaisyouym();
                    teirituTmttkngk = khSisuurendoTmttkn.getTeiritutmttkngk();
                    sisuuTmttkngk = khSisuurendoTmttkn.getSisuurendoutmttkngk();
                    tumitateriritu = tkJitenKeiyakuSyouhinKijyunBean.getTumitateriritu();
                }

                getSjkkktyouseiyourirituBean.setSyouhncd(tkJitenKeiyakuSyouhinKijyunBean.getSyouhncd());
                getSjkkktyouseiyourirituBean.setKijyunymd(calckijyunYmd);
                getSjkkktyouseiyourirituBean.setHknkkn(tkJitenKeiyakuSyouhinKijyunBean.getHknkkn());
                getSjkkktyouseiyourirituBean.setHknkknsmnkbn(tkJitenKeiyakuSyouhinKijyunBean.getHknkknsmnKbn());
                getSjkkktyouseiyourirituBean.setHhknnen(tkJitenKeiyakuSyouhinKijyunBean.getHhknnen());

                C_ErrorKbn errorKbn = getSjkkktyouseiyouriritu.exec(getSjkkktyouseiyourirituBean);

                if (errorKbn.eq(C_ErrorKbn.ERROR)) {
                    String message = MessageUtil.getMessage(MessageId.ESA1001, "市場価格調整用利率",
                        pHoyuuMeisaiTyukeiyouItzHzn.getZtydatakanrino());

                    batchLogger.warn(message);

                    ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

                    suuriyouErrJyouhou.setSyoriYmd(pSrRayJigyohiBatchParam.getSyoriYmd());
                    suuriyouErrJyouhou.setKakutyoujobcd(pSrRayJigyohiBatchParam.getIbKakutyoujobcd());
                    suuriyouErrJyouhou.setSyono(pHoyuuMeisaiTyukeiyouItzHzn.getZtydatakanrino());
                    suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(message);
                    suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

                    ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

                    pSrRayJigyohiBatchParam.setZokkouErrorSyoriCount(pSrRayJigyohiBatchParam
                        .getZokkouErrorSyoriCount() + 1);

                    errorFlag = true;
                }
                else {
                    kaiyakuSjkkktyouseiriritu = getSjkkktyouseiyouriritu.getSjkkktyouseiyouriritu();
                }

                keisanWExtBean.setSyouhncd(tkJitenKeiyakuSyouhinKijyunBean.getSyouhncd());
                keisanWExtBean.setSyouhnsdno(tkJitenKeiyakuSyouhinKijyunBean.getSyouhnsdno());
                keisanWExtBean.setRyouritusdno(tkJitenKeiyakuSyouhinKijyunBean.getRyouritusdno());
                keisanWExtBean.setYoteiriritu(tkJitenKeiyakuSyouhinKijyunBean.getYoteiriritu());
                keisanWExtBean.setHrkkaisuu(C_Hrkkaisuu.ITIJI);
                keisanWExtBean.setHknkknsmnkbn(tkJitenKeiyakuSyouhinKijyunBean.getHknkknsmnKbn());
                keisanWExtBean.setHknkkn(tkJitenKeiyakuSyouhinKijyunBean.getHknkkn());
                keisanWExtBean.setHrkkkn(tkJitenKeiyakuSyouhinKijyunBean.getHrkkkn());
                keisanWExtBean.setHhknnen(tkJitenKeiyakuSyouhinKijyunBean.getHhknnen());
                keisanWExtBean.setHhknsei(tkJitenKeiyakuSyouhinKijyunBean.getHhknsei());
                keisanWExtBean.setKihons(tkJitenKeiyakuSyouhinKijyunBean.getKihons());
                keisanWExtBean.setHokenryou(tkJitenKeiyakuSyouhinKijyunBean.getHokenryou());
                keisanWExtBean.setKykymd(tkJitenKeiyakuSyouhinKijyunBean.getKykymd());
                keisanWExtBean.setTuukasyu(tkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu());
                keisanWExtBean.setKyksjkkktyouseiriritu(tkJitenKeiyakuSyouhinKijyunBean.getKyksjkkktyouseiriritu());
                keisanWExtBean.setKaiyakusjkkktyouseiriritu(kaiyakuSjkkktyouseiriritu);
                keisanWExtBean.setTmttkntaisyouym(tmttkntaisyouym);
                keisanWExtBean.setTeiritutmttkngk(teirituTmttkngk);
                keisanWExtBean.setSisuurendoutmttkngk(sisuuTmttkngk);
                keisanWExtBean.setTumitateriritu(tumitateriritu);
                keisanWExtBean.setYendthnkymd(tkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd());
                keisanWExtBean.setTeikishrtkykhukaumu(C_UmuKbn.valueOf(pHoyuuMeisaiTyukeiyouItzHzn.getZtysrteikishrtkykhukaumu()));
                keisanWExtBean.setDai1hknkkn(tkJitenKeiyakuSyouhinKijyunBean.getDai1hknkkn());
                keisanWExtBean.setKykJyoutai(tkJitenKeiyakuSyouhinKijyunBean.getKykjyoutai());

                C_ErrorKbn resultKbn = keisanW.exec(calckijyunYmd, kaiyakuhrKisnKijyunYM, keisanWExtBean);

                if (resultKbn.eq(C_ErrorKbn.ERROR)) {

                    String message = MessageUtil.getMessage(MessageId.ESA1001, "解約返戻金",
                        pHoyuuMeisaiTyukeiyouItzHzn.getZtydatakanrino());

                    batchLogger.warn(message);

                    ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

                    suuriyouErrJyouhou.setSyoriYmd(pSrRayJigyohiBatchParam.getSyoriYmd());
                    suuriyouErrJyouhou.setKakutyoujobcd(pSrRayJigyohiBatchParam.getIbKakutyoujobcd());
                    suuriyouErrJyouhou.setSyono(pHoyuuMeisaiTyukeiyouItzHzn.getZtydatakanrino());
                    suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(message);
                    suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

                    ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

                    pSrRayJigyohiBatchParam.setZokkouErrorSyoriCount(pSrRayJigyohiBatchParam
                        .getZokkouErrorSyoriCount() + 1);

                    errorFlag = true;
                }
                else {
                    vhireilKisnyukngkTeiritu = keisanW.getTeirituTmttkngk();
                    vhireilKisnyukngkSisuu = keisanW.getSisuurendouTmttkngk();

                    if ((BizDateUtil.compareYm(loadingKeijyoYm, tkJitenKeiyakuSyouhinKijyunBean.getKykymd().getBizDateYM()) ==
                        BizDateUtil.COMPARE_GREATER) &&
                        loadingKeijyoYm.getMonth() == tkJitenKeiyakuSyouhinKijyunBean.getKykymd().getMonth() &&
                        pTkJitenKeiyakuSyouhinKijyunBean_gmjiten.getYendthnkymd() == null &&
                        pTkJitenKeiyakuSyouhinKijyunBean_gmjiten.getTmttknitenYmd() == null &&
                        tkJitenKeiyakuSyouhinKijyunBean.getKykymd().getDay() == SrCommonConstants.DAY_16D  &&
                        C_TmttknhaibunjyoutaiKbn.SISUU_ONLY.eq(pTkJitenKeiyakuSyouhinKijyunBean_gmjiten.
                            getTmttknhaibunjyoutai())) {

                        BizDate kijyunMaeYmd  = calckijyunYmd.addDays(-SrCommonConstants.DAY_1D);

                        KhSisuurendoTmttknBean kiJunYmdMaeTmttknBean = srGetTokutejitenSisuurendoTmttknInfo
                            .getSisuurendoTmttknInfo(kijyunMaeYmd, null, srGetTokutejitenTmttknInfoBeanList);
                        IT_KhSisuurendoTmttkn kijunYmdSisuurendoTmttkn = kiJunYmdMaeTmttknBean.getKhSisuurendoTmttknAto();

                        vhireilKisnyukngkTeiritu = kijunYmdSisuurendoTmttkn.getTeiritutmttkngk();
                        vhireilKisnyukngkSisuu = kijunYmdSisuurendoTmttkn.getSisuurendoutmttkngk();
                    }

                    if (keisanW.getV().compareTo(keisanW.getW()) < 0) {
                        rpKeisanyouSibous = keisanW.getW();
                    }
                    else {
                        rpKeisanyouSibous = keisanW.getV();
                    }
                }
            }
        }

        BizCurrency tumimasimaeW = BizCurrency.valueOf(0);
        Boolean sisuuhaneiFlg = false;
        BizCurrency sisuurendoutmttkngkSagk = BizCurrency.valueOf(0);

        if (pTkJitenKeiyakuSyouhinKijyunBean_gmjiten.getYendthnkymd() == null &&
            pTkJitenKeiyakuSyouhinKijyunBean_gmjiten.getTmttknitenYmd() == null) {

            if (loadingKeijyoYm.getMonth() == pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getMonth() &&
                BizDate.valueOf(pHoyuuMeisaiTyukeiyouItzHzn.getZtykykymd()).getDay() == SrCommonConstants.DAY_16D  &&
                C_TmttknhaibunjyoutaiKbn.SISUU_ONLY.eq(pTkJitenKeiyakuSyouhinKijyunBean_gmjiten.
                    getTmttknhaibunjyoutai())) {

                BizDate tumitatekngkKijunYmd = BizDate.valueOf(loadingKeijyoYm, SrCommonConstants.DAY_16D);

                int kensuu = srGetTokutejitenTmttknInfoBeanList.size();
                for (int i = 0; i < kensuu; i++) {

                    SrGetTokutejitenTmttknInfoBean srGetTokutejitenTmttknInfoBean = srGetTokutejitenTmttknInfoBeanList.get(i);

                    if (srGetTokutejitenTmttknInfoBean.getTmttknkouryokukaisiymd() == null) {
                        continue;
                    }

                    if (BizDateUtil.compareYmd(srGetTokutejitenTmttknInfoBean.getTmttknkouryokukaisiymd(),
                        tumitatekngkKijunYmd) == BizDateUtil.COMPARE_EQUAL &&
                        srGetTokutejitenTmttknInfoBean.getRenno().equals(SrCommonConstants.RENBAN_1)) {

                        if (kensuu == i+1) {
                            break;
                        }

                        for (int j = i + 1; j < kensuu; j++) {

                            if (!KINOUID_TMTTKNINFOHANEI.equals(
                                srGetTokutejitenTmttknInfoBeanList.get(j).getGyoumuKousinKinou()) &&
                                !KINOUID_TMTTKNINFOHANEITRKS.equals(
                                    srGetTokutejitenTmttknInfoBeanList.get(j).getGyoumuKousinKinou())) {

                                sisuurendoutmttkngkSagk = srGetTokutejitenTmttknInfoBean.getSisuurendoutmttkngk().
                                    subtract(srGetTokutejitenTmttknInfoBeanList.get(j).getSisuurendoutmttkngk());

                                break;
                            }
                        }

                        if (sisuurendoutmttkngkSagk.compareTo(BizCurrency.valueOf(0, sisuurendoutmttkngkSagk.getType())) > 0) {
                            sisuuhaneiFlg = true;
                        }
                        break;
                    }

                    if (BizDateUtil.compareYmd(srGetTokutejitenTmttknInfoBean.getTmttknkouryokukaisiymd(),
                        tumitatekngkKijunYmd) == BizDateUtil.COMPARE_LESSER) {
                        break;
                    }
                }

                if (sisuuhaneiFlg) {

                    BizDate loadingKeijyoYmPreLasDay = loadingKeijyoYm.getFirstDay().addDays(-SrCommonConstants.DAY_1D);

                    BizDateYM tumimasimaewKaiyakuhrKijyunYM = keisanWKijunYM.exec(
                        tkJitenKeiyakuSyouhinKijyunBean.getKykymd(),
                        loadingKeijyoYmPreLasDay,
                        null,
                        null,
                        tkJitenKeiyakuSyouhinKijyunBean.getKykjyoutai(),
                        tkJitenKeiyakuSyouhinKijyunBean.getSyouhncd(),
                        tkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd());

                    TkJitenKeiyakuSyouhinBean tkJitenKeiyakuSyouhinBean = srGetTokutejitenSyohnInfo.exec(
                        C_TokutejitenSyoriKbn.KIJYUNBIJITENSYOUHININFO,
                        pHoyuuMeisaiTyukeiyouItzHzn.getZtydatakanrino(),
                        loadingKeijyoYmPreLasDay,
                        "",
                        tumimasimaewKiykSyuhnDataLst);
                    TkJitenKeiyakuSyouhinKijyunBean tumimasimaewSyouhinInfoBean =
                        tkJitenKeiyakuSyouhinBean.getTkJitenKeiyakuSyouhinKijyunBeanAto();

                    List<SrGetTokutejitenTmttknInfoBean> tumimasimaewGetTokutejitenTmttknInfoBeanList =
                        srGetTokutejitenSisuurendoTmttknInfo.exec(pHoyuuMeisaiTyukeiyouItzHzn.getZtydatakanrino(),
                            loadingKeijyoYmPreLasDay, null, tumimasimaewKiykSyuhnDataLst);
                    KhSisuurendoTmttknBean khSisuurendoTmttknBean =
                        srGetTokutejitenSisuurendoTmttknInfo.getSisuurendoTmttknInfo(
                            loadingKeijyoYmPreLasDay, null, tumimasimaewGetTokutejitenTmttknInfoBeanList);
                    IT_KhSisuurendoTmttkn khSisuurendoTmttkn = khSisuurendoTmttknBean.getKhSisuurendoTmttknAto();

                    if (khSisuurendoTmttkn == null) {
                        tumimasimaeW = BizCurrency.valueOf(0);
                    }
                    else {
                        BizNumber tumimasimaewKyksjkkktyouseiRiritu = BizNumber.ZERO;

                        GetSjkkktyouseiyouriritu getSjkkktyouseiyouriritu =
                            SWAKInjector.getInstance(GetSjkkktyouseiyouriritu.class);
                        GetSjkkktyouseiyourirituBean getSjkkktyouseiyourirituBean =
                            SWAKInjector.getInstance(GetSjkkktyouseiyourirituBean.class);

                        if (tumimasimaewSyouhinInfoBean.getYendthnkymd() != null) {

                            tumimasimaewSyouhinInfoBean = tkJitenKeiyakuSyouhinKijyunBean;
                        }

                        getSjkkktyouseiyourirituBean.setSyouhncd(tumimasimaewSyouhinInfoBean.getSyouhncd());
                        getSjkkktyouseiyourirituBean.setKijyunymd(loadingKeijyoYmPreLasDay);
                        getSjkkktyouseiyourirituBean.setHknkkn(tumimasimaewSyouhinInfoBean.getHknkkn());
                        getSjkkktyouseiyourirituBean.setHknkknsmnkbn(tumimasimaewSyouhinInfoBean.getHknkknsmnKbn());
                        getSjkkktyouseiyourirituBean.setHhknnen(tumimasimaewSyouhinInfoBean.getHhknnen());

                        C_ErrorKbn kekkaKbn = getSjkkktyouseiyouriritu.exec(getSjkkktyouseiyourirituBean);

                        if (C_ErrorKbn.ERROR.eq(kekkaKbn)) {

                            String msg = MessageUtil.getMessage(MessageId.ESA1001, "市場価格調整用利率",
                                pHoyuuMeisaiTyukeiyouItzHzn.getZtydatakanrino());

                            batchLogger.warn(msg);

                            ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

                            suuriyouErrJyouhou.setSyoriYmd(pSrRayJigyohiBatchParam.getSyoriYmd());
                            suuriyouErrJyouhou.setKakutyoujobcd(pSrRayJigyohiBatchParam.getIbKakutyoujobcd());
                            suuriyouErrJyouhou.setSyono(pHoyuuMeisaiTyukeiyouItzHzn.getZtydatakanrino());
                            suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);
                            suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

                            ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

                            pSrRayJigyohiBatchParam.setZokkouErrorSyoriCount(pSrRayJigyohiBatchParam
                                .getZokkouErrorSyoriCount() + 1);
                            errorFlag = true;
                        }
                        else {
                            tumimasimaewKyksjkkktyouseiRiritu = getSjkkktyouseiyouriritu.getSjkkktyouseiyouriritu();
                        }

                        KeisanW keisanW= SWAKInjector.getInstance(KeisanW.class);

                        KeisanWExtBean keisanWExtBean = SWAKInjector.getInstance(KeisanWExtBean.class);

                        keisanWExtBean.setSyouhncd(tumimasimaewSyouhinInfoBean.getSyouhncd());
                        keisanWExtBean.setSyouhnsdno(tumimasimaewSyouhinInfoBean.getSyouhnsdno());
                        keisanWExtBean.setRyouritusdno(tumimasimaewSyouhinInfoBean.getRyouritusdno());
                        keisanWExtBean.setYoteiriritu(tumimasimaewSyouhinInfoBean.getYoteiriritu());
                        keisanWExtBean.setHrkkaisuu(C_Hrkkaisuu.ITIJI);
                        keisanWExtBean.setHknkknsmnkbn(tumimasimaewSyouhinInfoBean.getHknkknsmnKbn());
                        keisanWExtBean.setHknkkn(tumimasimaewSyouhinInfoBean.getHknkkn());
                        keisanWExtBean.setHrkkkn(tumimasimaewSyouhinInfoBean.getHrkkkn());
                        keisanWExtBean.setHhknnen(tumimasimaewSyouhinInfoBean.getHhknnen());
                        keisanWExtBean.setHhknsei(tumimasimaewSyouhinInfoBean.getHhknsei());
                        keisanWExtBean.setKihons(tumimasimaewSyouhinInfoBean.getKihons());
                        keisanWExtBean.setHokenryou(tumimasimaewSyouhinInfoBean.getHokenryou());
                        keisanWExtBean.setKykymd(tumimasimaewSyouhinInfoBean.getKykymd());
                        keisanWExtBean.setTuukasyu(tumimasimaewSyouhinInfoBean.getKyktuukasyu());
                        keisanWExtBean.setKyksjkkktyouseiriritu(tumimasimaewSyouhinInfoBean.getKyksjkkktyouseiriritu());
                        keisanWExtBean.setKaiyakusjkkktyouseiriritu(tumimasimaewKyksjkkktyouseiRiritu);
                        keisanWExtBean.setTmttkntaisyouym(khSisuurendoTmttkn.getTmttkntaisyouym());
                        keisanWExtBean.setTeiritutmttkngk(khSisuurendoTmttkn.getTeiritutmttkngk());
                        keisanWExtBean.setSisuurendoutmttkngk(khSisuurendoTmttkn.getSisuurendoutmttkngk());
                        keisanWExtBean.setTumitateriritu(tumimasimaewSyouhinInfoBean.getTumitateriritu());
                        keisanWExtBean.setYendthnkymd(tumimasimaewSyouhinInfoBean.getYendthnkymd());
                        keisanWExtBean.setTeikishrtkykhukaumu(C_UmuKbn.valueOf(pHoyuuMeisaiTyukeiyouItzHzn.getZtysrteikishrtkykhukaumu()));
                        keisanWExtBean.setDai1hknkkn(tumimasimaewSyouhinInfoBean.getDai1hknkkn());
                        keisanWExtBean.setKykJyoutai(tumimasimaewSyouhinInfoBean.getKykjyoutai());

                        kekkaKbn = keisanW.exec(loadingKeijyoYmPreLasDay, tumimasimaewKaiyakuhrKijyunYM, keisanWExtBean);

                        if (C_ErrorKbn.ERROR.eq(kekkaKbn)) {

                            String msg = MessageUtil.getMessage(MessageId.ESA1001, "解約返戻金",
                                pHoyuuMeisaiTyukeiyouItzHzn.getZtydatakanrino());

                            batchLogger.warn(msg);

                            ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

                            suuriyouErrJyouhou.setSyoriYmd(pSrRayJigyohiBatchParam.getSyoriYmd());
                            suuriyouErrJyouhou.setKakutyoujobcd(pSrRayJigyohiBatchParam.getIbKakutyoujobcd());
                            suuriyouErrJyouhou.setSyono(pHoyuuMeisaiTyukeiyouItzHzn.getZtydatakanrino());
                            suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);
                            suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

                            ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

                            pSrRayJigyohiBatchParam.setZokkouErrorSyoriCount(pSrRayJigyohiBatchParam
                                .getZokkouErrorSyoriCount() + 1);
                            errorFlag = true;
                        }
                        else {
                            tumimasimaeW = keisanW.getW();
                        }
                    }
                }
            }
        }

        if (pKessanKbn.eq(C_KessanKbn.TUUJYOU)) {

            pRayJigyohiTy.setZtyloadingkeijyoym(loadingKeijyoYm.toString());
            pRayJigyohiTy.setZtysihankiksnydatahyj(sihankiKsnydataHyj);
            pRayJigyohiTy.setZtygmkijyhyj(gmKijyHyj);
            pRayJigyohiTy.setZtyvhireilkisnyukngkx1(new BigDecimal(vhireilKisnyukngkTeiritu.
                toAdsoluteString()).longValue());
            pRayJigyohiTy.setZtyvhireilkisnyukngkx2(new BigDecimal(vhireilKisnyukngkSisuu.
                toAdsoluteString()).longValue());
            pRayJigyohiTy.setZtyrpkeisanyousibous(new BigDecimal(rpKeisanyouSibous.
                toAdsoluteString()).longValue());
            pRayJigyohiTy.setZtytumimasimaew(new BigDecimal(tumimasimaeW.
                toAdsoluteString()).longValue());
        }
        else if (pKessanKbn.eq(C_KessanKbn.KESSAN)) {

            pKsnRayJigyohiTy.setZtyloadingkeijyoym(loadingKeijyoYm.toString());
            pKsnRayJigyohiTy.setZtysihankiksnydatahyj(sihankiKsnydataHyj);
            pKsnRayJigyohiTy.setZtygmkijyhyj(gmKijyHyj);
            pKsnRayJigyohiTy.setZtyvhireilkisnyukngkx1(new BigDecimal(vhireilKisnyukngkTeiritu.
                toAdsoluteString()).longValue());
            pKsnRayJigyohiTy.setZtyvhireilkisnyukngkx2(new BigDecimal(vhireilKisnyukngkSisuu.
                toAdsoluteString()).longValue());
            pKsnRayJigyohiTy.setZtyrpkeisanyousibous(new BigDecimal(rpKeisanyouSibous.
                toAdsoluteString()).longValue());
            pKsnRayJigyohiTy.setZtytumimasimaew(new BigDecimal(tumimasimaeW.
                toAdsoluteString()).longValue());
        }
    }
}
