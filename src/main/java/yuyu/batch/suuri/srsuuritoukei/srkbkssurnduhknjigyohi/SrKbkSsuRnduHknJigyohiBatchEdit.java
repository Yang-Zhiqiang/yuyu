package yuyu.batch.suuri.srsuuritoukei.srkbkssurnduhknjigyohi;

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
import yuyu.def.db.entity.ZT_KbkSsuRnduHknJigyohiTy;
import yuyu.def.db.entity.ZT_KsnKbkSsuRnduHknJigyohiTy;
import yuyu.infr.batch.logger.BatchLogger;

import com.google.common.collect.Lists;

/**
 * 数理 数理統計 株価指数連動保険事業費情報作成の項目編集クラス
 */
public class SrKbkSsuRnduHknJigyohiBatchEdit {

    private static final String KINOUID_TMTTKNINFOHANEI = "SrGetTokutejitenSisuurendoTmttknInfoHanei";

    private static final String KINOUID_TMTTKNINFOHANEITRKS = "SrGetTokutejitenSisuurendoTmttknInfoHaneiTrks";

    @Inject
    private BatchLogger batchLogger;

    private Boolean errorFlag;

    public Boolean editKoumoku(SrKbkSsuRnduHknJigyohiBatchParam pSrKbkSsuRnduHknJigyohiBatchParam,
        C_KessanKbn pKessanKbn,
        int pRegetuEditTaisyou,
        ST_HoyuuMeisaiTyukeiyouItzHzn pHoyuuMeisaiTyukeiyouItzHzn,
        TkJitenKeiyakuSyouhinKijyunBean pTkJitenKeiyakuSyouhinKijyunBean,
        ZT_KbkSsuRnduHknJigyohiTy pKbkSsuRnduHknJigyohiTy,
        ZT_KsnKbkSsuRnduHknJigyohiTy pKsnKbkSsuRnduHknJigyohiTy,
        TkJitenKeiyakuSyouhinKijyunBean pTkJitenKeiyakuSyouhinKijyunBean_gmjiten) {

        errorFlag = false;

        editHedda(
            pSrKbkSsuRnduHknJigyohiBatchParam,
            pKessanKbn,
            pKbkSsuRnduHknJigyohiTy,
            pKsnKbkSsuRnduHknJigyohiTy);

        editHoyuumeisai(
            pHoyuuMeisaiTyukeiyouItzHzn,
            pKessanKbn,
            pKbkSsuRnduHknJigyohiTy,
            pKsnKbkSsuRnduHknJigyohiTy);

        editKbkSsuRnduHknJigyohi(
            pSrKbkSsuRnduHknJigyohiBatchParam,
            pKessanKbn,
            pRegetuEditTaisyou,
            pHoyuuMeisaiTyukeiyouItzHzn,
            pTkJitenKeiyakuSyouhinKijyunBean,
            pKbkSsuRnduHknJigyohiTy,
            pKsnKbkSsuRnduHknJigyohiTy,
            pTkJitenKeiyakuSyouhinKijyunBean_gmjiten);

        return errorFlag;
    }

    private void editHedda(SrKbkSsuRnduHknJigyohiBatchParam pSrKbkSsuRnduHknJigyohiBatchParam, C_KessanKbn pKessanKbn,
        ZT_KbkSsuRnduHknJigyohiTy pKbkSsuRnduHknJigyohiTy, ZT_KsnKbkSsuRnduHknJigyohiTy pKsnKbkSsuRnduHknJigyohiTy) {

        if (pKessanKbn.eq(C_KessanKbn.TUUJYOU)) {
            int KeyKoumoku = pSrKbkSsuRnduHknJigyohiBatchParam.getReigetuSyoriCount();
            pSrKbkSsuRnduHknJigyohiBatchParam.setReigetuSyoriCount(pSrKbkSsuRnduHknJigyohiBatchParam
                .getReigetuSyoriCount() + 1);
            pKbkSsuRnduHknJigyohiTy.setZtysequenceno(KeyKoumoku);
        }
        else if (pKessanKbn.eq(C_KessanKbn.KESSAN)) {
            int KeyKoumoku = pSrKbkSsuRnduHknJigyohiBatchParam.getKessanSyoriCount();
            pSrKbkSsuRnduHknJigyohiBatchParam.setKessanSyoriCount(pSrKbkSsuRnduHknJigyohiBatchParam
                .getKessanSyoriCount() + 1);
            pKsnKbkSsuRnduHknJigyohiTy.setZtysequenceno(KeyKoumoku);
        }
    }

    private void editHoyuumeisai(ST_HoyuuMeisaiTyukeiyouItzHzn pHoyuuMeisaiTyukeiyouItzHzn, C_KessanKbn pKessanKbn,
        ZT_KbkSsuRnduHknJigyohiTy pKbkSsuRnduHknJigyohiTy, ZT_KsnKbkSsuRnduHknJigyohiTy pKsnKbkSsuRnduHknJigyohiTy) {

        if (pKessanKbn.eq(C_KessanKbn.TUUJYOU)) {

            pKbkSsuRnduHknJigyohiTy.setZtyrecordkbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtyrecordkbn());
            pKbkSsuRnduHknJigyohiTy.setZtynenkinkaisigohyouji(pHoyuuMeisaiTyukeiyouItzHzn.getZtynenkinkaisigohyouji());
            pKbkSsuRnduHknJigyohiTy.setZtynksgokurikosidhyj(pHoyuuMeisaiTyukeiyouItzHzn.getZtynksgokurikosidhyj());
            pKbkSsuRnduHknJigyohiTy.setZtykeijyouym(pHoyuuMeisaiTyukeiyouItzHzn.getZtykeijyouym());
            pKbkSsuRnduHknJigyohiTy.setZtyidojiyukbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtyidojiyukbn());
            pKbkSsuRnduHknJigyohiTy.setZtyzougenkbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtyzougenkbn());
            pKbkSsuRnduHknJigyohiTy.setZtyidourecordkbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtyidourecordkbn());
            pKbkSsuRnduHknJigyohiTy.setZtykeijyouctrlkbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtykeijyouctrlkbn());
            pKbkSsuRnduHknJigyohiTy.setZtyhenkousyoriymd(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhenkousyoriymd());
            pKbkSsuRnduHknJigyohiTy.setZtykykmfksnctr(pHoyuuMeisaiTyukeiyouItzHzn.getZtykykmfksnctr());
            pKbkSsuRnduHknJigyohiTy.setZtyrecordctr(pHoyuuMeisaiTyukeiyouItzHzn.getZtyrecordctr());
            pKbkSsuRnduHknJigyohiTy.setZtysuuriyoukouryokukaisiymd(pHoyuuMeisaiTyukeiyouItzHzn
                .getZtysuuriyoukouryokukaisiymd());
            pKbkSsuRnduHknJigyohiTy.setZtydenymd(pHoyuuMeisaiTyukeiyouItzHzn.getZtydenymd());
            pKbkSsuRnduHknJigyohiTy.setZtybluekeizokuhyouji(pHoyuuMeisaiTyukeiyouItzHzn.getZtybluekeizokuhyouji());
            pKbkSsuRnduHknJigyohiTy.setZtysuuriyouyobin1x2(pHoyuuMeisaiTyukeiyouItzHzn.getZtysuuriyouyobin1x2());
            pKbkSsuRnduHknJigyohiTy.setZtytoukeikeijyoukbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtytoukeikeijyoukbn());
            pKbkSsuRnduHknJigyohiTy.setZtyraysystemhyj(pHoyuuMeisaiTyukeiyouItzHzn.getZtyraysystemhyj());
            pKbkSsuRnduHknJigyohiTy.setZtyzenkiidouteiseikbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtyzenkiidouteiseikbn());
            pKbkSsuRnduHknJigyohiTy.setZtybsyym(pHoyuuMeisaiTyukeiyouItzHzn.getZtybsyym());
            pKbkSsuRnduHknJigyohiTy.setZtytenkangokeiyakubosyuuym(pHoyuuMeisaiTyukeiyouItzHzn
                .getZtytenkangokeiyakubosyuuym());
            pKbkSsuRnduHknJigyohiTy.setZtyidoujiyuucd(pHoyuuMeisaiTyukeiyouItzHzn.getZtyidoujiyuucd());
            pKbkSsuRnduHknJigyohiTy.setZtysyoricd(pHoyuuMeisaiTyukeiyouItzHzn.getZtysyoricd());
            pKbkSsuRnduHknJigyohiTy.setZtysekininteiseihyouji(pHoyuuMeisaiTyukeiyouItzHzn.getZtysekininteiseihyouji());
            pKbkSsuRnduHknJigyohiTy.setZtysuuriyouyobin8(pHoyuuMeisaiTyukeiyouItzHzn.getZtysuuriyouyobin8());
            pKbkSsuRnduHknJigyohiTy.setZtysihankibikinkbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtysihankibikinkbn());
            pKbkSsuRnduHknJigyohiTy.setZtysuuriyouyobin1x3(pHoyuuMeisaiTyukeiyouItzHzn.getZtysuuriyouyobin1x3());
            pKbkSsuRnduHknJigyohiTy.setZtydatakanrino(pHoyuuMeisaiTyukeiyouItzHzn.getZtydatakanrino());
            pKbkSsuRnduHknJigyohiTy.setZtyhknsyukigou(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhknsyukigou());
            pKbkSsuRnduHknJigyohiTy.setZtyhknsyuruikigousedaikbn(pHoyuuMeisaiTyukeiyouItzHzn
                .getZtyhknsyuruikigousedaikbn());
            pKbkSsuRnduHknJigyohiTy.setZtysotodasipmenkbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtysotodasipmenkbn());
            pKbkSsuRnduHknJigyohiTy.setZtystdssytikbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtystdssytikbn());
            pKbkSsuRnduHknJigyohiTy.setZtystdssnskbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtystdssnskbn());
            pKbkSsuRnduHknJigyohiTy
            .setZtysotodasimanagehyouji(pHoyuuMeisaiTyukeiyouItzHzn.getZtysotodasimanagehyouji());
            pKbkSsuRnduHknJigyohiTy.setZtysotodasiphkbnmnoshyouji(pHoyuuMeisaiTyukeiyouItzHzn
                .getZtysotodasiphkbnmnoshyouji());
            pKbkSsuRnduHknJigyohiTy.setZtystdsstkjytkyuhyj(pHoyuuMeisaiTyukeiyouItzHzn.getZtystdsstkjytkyuhyj());
            pKbkSsuRnduHknJigyohiTy.setZtykbnkeiriyousegmentkbn(pHoyuuMeisaiTyukeiyouItzHzn
                .getZtykbnkeiriyousegmentkbn());
            pKbkSsuRnduHknJigyohiTy.setZtykbnkeiriyourgnbnskkbn(pHoyuuMeisaiTyukeiyouItzHzn
                .getZtykbnkeiriyourgnbnskkbn());
            pKbkSsuRnduHknJigyohiTy.setZtysuurisyuruicd(pHoyuuMeisaiTyukeiyouItzHzn.getZtysuurisyuruicd());
            pKbkSsuRnduHknJigyohiTy.setZtyhosyoukinoukbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhosyoukinoukbn());
            pKbkSsuRnduHknJigyohiTy.setZtydaikbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtydaikbn());
            pKbkSsuRnduHknJigyohiTy.setZtytyuukbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtytyuukbn());
            pKbkSsuRnduHknJigyohiTy.setZtysyoukbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtysyoukbn());
            pKbkSsuRnduHknJigyohiTy.setZtysedaikbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtysedaikbn());
            pKbkSsuRnduHknJigyohiTy.setZtyharaikatakbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtyharaikatakbn());
            pKbkSsuRnduHknJigyohiTy.setZtykykymd(pHoyuuMeisaiTyukeiyouItzHzn.getZtykykymd());
            pKbkSsuRnduHknJigyohiTy.setZtyhknkkn(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhknkkn());
            pKbkSsuRnduHknJigyohiTy.setZtyphrkkikn(pHoyuuMeisaiTyukeiyouItzHzn.getZtyphrkkikn());
            pKbkSsuRnduHknJigyohiTy.setZtysaimnkkykhyj(pHoyuuMeisaiTyukeiyouItzHzn.getZtysaimnkkykhyj());
            pKbkSsuRnduHknJigyohiTy.setZtyannaifuyouriyuukbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtyannaifuyouriyuukbn());
            pKbkSsuRnduHknJigyohiTy.setZtytksyuannaikykkbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtytksyuannaikykkbn());
            pKbkSsuRnduHknJigyohiTy.setZtyhrkkaisuukbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhrkkaisuukbn());
            pKbkSsuRnduHknJigyohiTy.setZtyhrkkeirokbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhrkkeirokbn());
            pKbkSsuRnduHknJigyohiTy.setZtysdpdkbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtysdpdkbn());
            pKbkSsuRnduHknJigyohiTy.setZtyryouritukbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtyryouritukbn());
            pKbkSsuRnduHknJigyohiTy.setZtyao3tyou3sibousdatehyouji(pHoyuuMeisaiTyukeiyouItzHzn
                .getZtyao3tyou3sibousdatehyouji());
            pKbkSsuRnduHknJigyohiTy.setZtyhhknseikbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhhknseikbn());
            pKbkSsuRnduHknJigyohiTy.setZtyhihokensyaagev2(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhihokensyaagev2());
            pKbkSsuRnduHknJigyohiTy.setZtykyksyanen(pHoyuuMeisaiTyukeiyouItzHzn.getZtykyksyanen());
            pKbkSsuRnduHknJigyohiTy.setZtydai2hhknnen(pHoyuuMeisaiTyukeiyouItzHzn.getZtydai2hhknnen());
            pKbkSsuRnduHknJigyohiTy.setZtytkbthsyumnryuhyouji(pHoyuuMeisaiTyukeiyouItzHzn.getZtytkbthsyumnryuhyouji());
            pKbkSsuRnduHknJigyohiTy.setZtysyukeiyakupwaribikikbn(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtysyukeiyakupwaribikikbn());
            pKbkSsuRnduHknJigyohiTy.setZtytenkanwaribikikbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtytenkanwaribikikbn());
            pKbkSsuRnduHknJigyohiTy.setZtyyuuhitutnknyuguryurtkbn(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyyuuhitutnknyuguryurtkbn());
            pKbkSsuRnduHknJigyohiTy.setZtysyukeiyakup(pHoyuuMeisaiTyukeiyouItzHzn.getZtysyukeiyakup());
            pKbkSsuRnduHknJigyohiTy.setZtytokujyoup(pHoyuuMeisaiTyukeiyouItzHzn.getZtytokujyoup());
            pKbkSsuRnduHknJigyohiTy.setZtysiteizukisyukeiyakup(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtysiteizukisyukeiyakup());
            pKbkSsuRnduHknJigyohiTy.setZtykihons(pHoyuuMeisaiTyukeiyouItzHzn.getZtykihons());
            pKbkSsuRnduHknJigyohiTy.setZtysibous(pHoyuuMeisaiTyukeiyouItzHzn.getZtysibous());
            pKbkSsuRnduHknJigyohiTy.setZtyhenkougokihons(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhenkougokihons());
            pKbkSsuRnduHknJigyohiTy.setZtyhenkougosibous(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhenkougosibous());
            pKbkSsuRnduHknJigyohiTy.setZtyhenkouymd(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhenkouymd());
            pKbkSsuRnduHknJigyohiTy.setZtyentyoukikan(pHoyuuMeisaiTyukeiyouItzHzn.getZtyentyoukikan());
            pKbkSsuRnduHknJigyohiTy.setZtyseizonkyuuhukinsiteimd(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyseizonkyuuhukinsiteimd());
            pKbkSsuRnduHknJigyohiTy.setZtysyukeiyakusiharaikingaku(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtysyukeiyakusiharaikingaku());
            pKbkSsuRnduHknJigyohiTy.setZtyatukaisisyatodouhukencd(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyatukaisisyatodouhukencd());
            pKbkSsuRnduHknJigyohiTy.setZtytokuyakuhukasuu(pHoyuuMeisaiTyukeiyouItzHzn.getZtytokuyakuhukasuu());
            pKbkSsuRnduHknJigyohiTy.setZtydi2hknkknikoujihisyaage(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtydi2hknkknikoujihisyaage());
            pKbkSsuRnduHknJigyohiTy.setZtyhrimnentyoumaephrkkkn(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyhrimnentyoumaephrkkkn());
            pKbkSsuRnduHknJigyohiTy.setZtytokubetuhosyoukikan(pHoyuuMeisaiTyukeiyouItzHzn.getZtytokubetuhosyoukikan());
            pKbkSsuRnduHknJigyohiTy.setZtykousinmanryouage(pHoyuuMeisaiTyukeiyouItzHzn.getZtykousinmanryouage());
            pKbkSsuRnduHknJigyohiTy.setZtyknkuzusnzyrttekitkarihyj(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyknkuzusnzyrttekitkarihyj());
            pKbkSsuRnduHknJigyohiTy.setZtykuriagekurisagekbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtykuriagekurisagekbn());
            pKbkSsuRnduHknJigyohiTy.setZtyhrizmjhknsyukigousdkbn(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyhrizmjhknsyukigousdkbn());
            pKbkSsuRnduHknJigyohiTy.setZtykrsgjhknsyukigousdkbn(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtykrsgjhknsyukigousdkbn());
            pKbkSsuRnduHknJigyohiTy.setZtysotodasisyouhinkaiteikbn(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtysotodasisyouhinkaiteikbn());
            pKbkSsuRnduHknJigyohiTy.setZtyyobiv4(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobiv4());
            pKbkSsuRnduHknJigyohiTy.setZtygoukeitenkans(pHoyuuMeisaiTyukeiyouItzHzn.getZtygoukeitenkans());
            pKbkSsuRnduHknJigyohiTy.setZtygoukeipbubuntenkans(pHoyuuMeisaiTyukeiyouItzHzn.getZtygoukeipbubuntenkans());
            pKbkSsuRnduHknJigyohiTy.setZtytenkanteikisyuruikigou(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtytenkanteikisyuruikigou());
            pKbkSsuRnduHknJigyohiTy.setZtytenkanteikikigousedaikbn(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtytenkanteikikigousedaikbn());
            pKbkSsuRnduHknJigyohiTy.setZtytnkntiksotodasikusnkbn(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtytnkntiksotodasikusnkbn());
            pKbkSsuRnduHknJigyohiTy.setZtytnkntikstdspmenkbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtytnkntikstdspmenkbn());
            pKbkSsuRnduHknJigyohiTy.setZtytenkanteikikigouyobi(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtytenkanteikikigouyobi());
            pKbkSsuRnduHknJigyohiTy.setZtytenkanteikikikan(pHoyuuMeisaiTyukeiyouItzHzn.getZtytenkanteikikikan());
            pKbkSsuRnduHknJigyohiTy.setZtygoukeitenkanteikis(pHoyuuMeisaiTyukeiyouItzHzn.getZtygoukeitenkanteikis());
            pKbkSsuRnduHknJigyohiTy.setZtytnknteikinkshrkkn(pHoyuuMeisaiTyukeiyouItzHzn.getZtytnknteikinkshrkkn());
            pKbkSsuRnduHknJigyohiTy.setZtytenkansiharaikingaku(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtytenkansiharaikingaku());
            pKbkSsuRnduHknJigyohiTy.setZtytnkntikshrkngk(pHoyuuMeisaiTyukeiyouItzHzn.getZtytnkntikshrkngk());
            pKbkSsuRnduHknJigyohiTy.setZtytenkankaisuu(pHoyuuMeisaiTyukeiyouItzHzn.getZtytenkankaisuu());
            pKbkSsuRnduHknJigyohiTy.setZtygoukeitenkankakaku(pHoyuuMeisaiTyukeiyouItzHzn.getZtygoukeitenkankakaku());
            pKbkSsuRnduHknJigyohiTy.setZtytnknkhnbbnjyuturt(pHoyuuMeisaiTyukeiyouItzHzn.getZtytnknkhnbbnjyuturt());
            pKbkSsuRnduHknJigyohiTy.setZtywnasigoukeitenkanteikis(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtywnasigoukeitenkanteikis());
            pKbkSsuRnduHknJigyohiTy.setZtytnknteikikousinmnryouage(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtytnknteikikousinmnryouage());
            pKbkSsuRnduHknJigyohiTy.setZtyyobiv5(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobiv5());
            pKbkSsuRnduHknJigyohiTy.setZtykanyujidatakanrino(pHoyuuMeisaiTyukeiyouItzHzn.getZtykanyujidatakanrino());
            pKbkSsuRnduHknJigyohiTy.setZtykanyujikykymd(pHoyuuMeisaiTyukeiyouItzHzn.getZtykanyujikykymd());
            pKbkSsuRnduHknJigyohiTy.setZtykanyuujihihokensyaage(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtykanyuujihihokensyaage());
            pKbkSsuRnduHknJigyohiTy.setZtykanyuujitenkanhyouji(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtykanyuujitenkanhyouji());
            pKbkSsuRnduHknJigyohiTy.setZtyhsyuikktminaosikaisu(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyhsyuikktminaosikaisu());
            pKbkSsuRnduHknJigyohiTy.setZtysknnjynbknsisnrt(pHoyuuMeisaiTyukeiyouItzHzn.getZtysknnjynbknsisnrt());
            pKbkSsuRnduHknJigyohiTy.setZtytkjykbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtytkjykbn());
            pKbkSsuRnduHknJigyohiTy.setZtysakugenkikan(pHoyuuMeisaiTyukeiyouItzHzn.getZtysakugenkikan());
            pKbkSsuRnduHknJigyohiTy.setZtyryoumasihyouten(pHoyuuMeisaiTyukeiyouItzHzn.getZtyryoumasihyouten());
            pKbkSsuRnduHknJigyohiTy.setZtysykyktkjyuryumsratehyj(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtysykyktkjyuryumsratehyj());
            pKbkSsuRnduHknJigyohiTy.setZtysykyktkjyuryumsrate(pHoyuuMeisaiTyukeiyouItzHzn.getZtysykyktkjyuryumsrate());
            pKbkSsuRnduHknJigyohiTy.setZtydai2tokujyoukbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtydai2tokujyoukbn());
            pKbkSsuRnduHknJigyohiTy.setZtydai2sakugenkikan(pHoyuuMeisaiTyukeiyouItzHzn.getZtydai2sakugenkikan());
            pKbkSsuRnduHknJigyohiTy.setZtydai2ryoumasihyouten(pHoyuuMeisaiTyukeiyouItzHzn.getZtydai2ryoumasihyouten());
            pKbkSsuRnduHknJigyohiTy.setZtytokuteibuijyoukenhyouji(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtytokuteibuijyoukenhyouji());
            pKbkSsuRnduHknJigyohiTy.setZtytokuteibuino1(pHoyuuMeisaiTyukeiyouItzHzn.getZtytokuteibuino1());
            pKbkSsuRnduHknJigyohiTy.setZtyhtnpkkn1(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhtnpkkn1());
            pKbkSsuRnduHknJigyohiTy.setZtytokuteibuino2(pHoyuuMeisaiTyukeiyouItzHzn.getZtytokuteibuino2());
            pKbkSsuRnduHknJigyohiTy.setZtyhtnpkkn2(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhtnpkkn2());
            pKbkSsuRnduHknJigyohiTy.setZtymhituiryuyutktbijyknhyj(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtymhituiryuyutktbijyknhyj());
            pKbkSsuRnduHknJigyohiTy.setZtymuhaitouiryouyoutktbino1(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtymuhaitouiryouyoutktbino1());
            pKbkSsuRnduHknJigyohiTy.setZtymuhaitouiryouyouhtnpkkn1(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtymuhaitouiryouyouhtnpkkn1());
            pKbkSsuRnduHknJigyohiTy.setZtymuhaitouiryouyoutktbino2(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtymuhaitouiryouyoutktbino2());
            pKbkSsuRnduHknJigyohiTy.setZtymuhaitouiryouyouhtnpkkn2(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtymuhaitouiryouyouhtnpkkn2());
            pKbkSsuRnduHknJigyohiTy.setZtysiteizukipwarimasihyouji(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtysiteizukipwarimasihyouji());
            pKbkSsuRnduHknJigyohiTy.setZtypwarimasisiteim1(pHoyuuMeisaiTyukeiyouItzHzn.getZtypwarimasisiteim1());
            pKbkSsuRnduHknJigyohiTy.setZtypwarimasisiteim2(pHoyuuMeisaiTyukeiyouItzHzn.getZtypwarimasisiteim2());
            pKbkSsuRnduHknJigyohiTy.setZtysiteimsykykpbairitu(pHoyuuMeisaiTyukeiyouItzHzn.getZtysiteimsykykpbairitu());
            pKbkSsuRnduHknJigyohiTy.setZtysaisyuusiteiym(pHoyuuMeisaiTyukeiyouItzHzn.getZtysaisyuusiteiym());
            pKbkSsuRnduHknJigyohiTy.setZtysykykkitmttvkeisanym(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtysykykkitmttvkeisanym());
            pKbkSsuRnduHknJigyohiTy.setZtysykykkitmttsknnjynbkngk(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtysykykkitmttsknnjynbkngk());
            pKbkSsuRnduHknJigyohiTy.setZtydftumitatekingaku(pHoyuuMeisaiTyukeiyouItzHzn.getZtydftumitatekingaku());
            pKbkSsuRnduHknJigyohiTy.setZtydftumimasikin(pHoyuuMeisaiTyukeiyouItzHzn.getZtydftumimasikin());
            pKbkSsuRnduHknJigyohiTy.setZtyvbubundftenkankakaku(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyvbubundftenkankakaku());
            pKbkSsuRnduHknJigyohiTy.setZtydpbubundftenkankakaku(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtydpbubundftenkankakaku());
            pKbkSsuRnduHknJigyohiTy.setZtydftmttkngkitjbrbbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtydftmttkngkitjbrbbn());
            pKbkSsuRnduHknJigyohiTy.setZtyhendous(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhendous());
            pKbkSsuRnduHknJigyohiTy.setZtyhengakujigyounendomatucv(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyhengakujigyounendomatucv());
            pKbkSsuRnduHknJigyohiTy.setZtyitibuitijibarais(pHoyuuMeisaiTyukeiyouItzHzn.getZtyitibuitijibarais());
            pKbkSsuRnduHknJigyohiTy.setZtyitibuitijibaraip(pHoyuuMeisaiTyukeiyouItzHzn.getZtyitibuitijibaraip());
            pKbkSsuRnduHknJigyohiTy.setZtyitibitjbrshrkngk(pHoyuuMeisaiTyukeiyouItzHzn.getZtyitibitjbrshrkngk());
            pKbkSsuRnduHknJigyohiTy.setZtygoukeicv(pHoyuuMeisaiTyukeiyouItzHzn.getZtygoukeicv());
            pKbkSsuRnduHknJigyohiTy.setZtyminasicv(pHoyuuMeisaiTyukeiyouItzHzn.getZtyminasicv());
            pKbkSsuRnduHknJigyohiTy.setZtyloanfund(pHoyuuMeisaiTyukeiyouItzHzn.getZtyloanfund());
            pKbkSsuRnduHknJigyohiTy.setZtysaiteihosyougaku(pHoyuuMeisaiTyukeiyouItzHzn.getZtysaiteihosyougaku());
            pKbkSsuRnduHknJigyohiTy.setZtyhngksitihsyuyusykykp(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyhngksitihsyuyusykykp());
            pKbkSsuRnduHknJigyohiTy.setZtyhijynbrivasbujsitihsyugk(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyhijynbrivasbujsitihsyugk());
            pKbkSsuRnduHknJigyohiTy.setZtyhijynbrivamnkjsitihsyugk(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyhijynbrivamnkjsitihsyugk());
            pKbkSsuRnduHknJigyohiTy.setZtysiinkbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtysiinkbn());
            pKbkSsuRnduHknJigyohiTy.setZtymudkaimasikihons(pHoyuuMeisaiTyukeiyouItzHzn.getZtymudkaimasikihons());
            pKbkSsuRnduHknJigyohiTy.setZtykaimasiymd(pHoyuuMeisaiTyukeiyouItzHzn.getZtykaimasiymd());
            pKbkSsuRnduHknJigyohiTy.setZtykaimasikikan(pHoyuuMeisaiTyukeiyouItzHzn.getZtykaimasikikan());
            pKbkSsuRnduHknJigyohiTy.setZtyhikitugikaimasis(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhikitugikaimasis());
            pKbkSsuRnduHknJigyohiTy.setZtymudkaimasisiharaikingaku(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtymudkaimasisiharaikingaku());
            pKbkSsuRnduHknJigyohiTy.setZtyszoukouryokukaisiymdx1(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyszoukouryokukaisiymdx1());
            pKbkSsuRnduHknJigyohiTy.setZtyszouhokensyuruikigoux1(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyszouhokensyuruikigoux1());
            pKbkSsuRnduHknJigyohiTy.setZtyszoukigousedaikbnx1(pHoyuuMeisaiTyukeiyouItzHzn.getZtyszoukigousedaikbnx1());
            pKbkSsuRnduHknJigyohiTy.setZtyszoukikanx1(pHoyuuMeisaiTyukeiyouItzHzn.getZtyszoukikanx1());
            pKbkSsuRnduHknJigyohiTy.setZtyszouhihokensyaagex1(pHoyuuMeisaiTyukeiyouItzHzn.getZtyszouhihokensyaagex1());
            pKbkSsuRnduHknJigyohiTy.setZtyszoudai2hihknsyaagex1(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyszoudai2hihknsyaagex1());
            pKbkSsuRnduHknJigyohiTy.setZtyzoukasx1(pHoyuuMeisaiTyukeiyouItzHzn.getZtyzoukasx1());
            pKbkSsuRnduHknJigyohiTy.setZtyzennendozoukasx1(pHoyuuMeisaiTyukeiyouItzHzn.getZtyzennendozoukasx1());
            pKbkSsuRnduHknJigyohiTy.setZtyszousiharaikingakux1(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyszousiharaikingakux1());
            pKbkSsuRnduHknJigyohiTy.setZtyszoukouryokukaisiymdx2(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyszoukouryokukaisiymdx2());
            pKbkSsuRnduHknJigyohiTy.setZtyszouhokensyuruikigoux2(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyszouhokensyuruikigoux2());
            pKbkSsuRnduHknJigyohiTy.setZtyszoukigousedaikbnx2(pHoyuuMeisaiTyukeiyouItzHzn.getZtyszoukigousedaikbnx2());
            pKbkSsuRnduHknJigyohiTy.setZtyszoukikanx2(pHoyuuMeisaiTyukeiyouItzHzn.getZtyszoukikanx2());
            pKbkSsuRnduHknJigyohiTy.setZtyszouhihokensyaagex2(pHoyuuMeisaiTyukeiyouItzHzn.getZtyszouhihokensyaagex2());
            pKbkSsuRnduHknJigyohiTy.setZtyszoudai2hihknsyaagex2(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyszoudai2hihknsyaagex2());
            pKbkSsuRnduHknJigyohiTy.setZtyzoukasx2(pHoyuuMeisaiTyukeiyouItzHzn.getZtyzoukasx2());
            pKbkSsuRnduHknJigyohiTy.setZtyzennendozoukasx2(pHoyuuMeisaiTyukeiyouItzHzn.getZtyzennendozoukasx2());
            pKbkSsuRnduHknJigyohiTy.setZtyszousiharaikingakux2(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyszousiharaikingakux2());
            pKbkSsuRnduHknJigyohiTy.setZtysuuriyouyobin1x5(pHoyuuMeisaiTyukeiyouItzHzn.getZtysuuriyouyobin1x5());
            pKbkSsuRnduHknJigyohiTy.setZtysuuriyouyobin1x6(pHoyuuMeisaiTyukeiyouItzHzn.getZtysuuriyouyobin1x6());
            pKbkSsuRnduHknJigyohiTy.setZtyhrimngkizktkykpmenhyj(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyhrimngkizktkykpmenhyj());
            pKbkSsuRnduHknJigyohiTy.setZtymisyuustartym(pHoyuuMeisaiTyukeiyouItzHzn.getZtymisyuustartym());
            pKbkSsuRnduHknJigyohiTy.setZtymisyuukaisuu(pHoyuuMeisaiTyukeiyouItzHzn.getZtymisyuukaisuu());
            pKbkSsuRnduHknJigyohiTy.setZtyitjbrtkykkousnuktkarhyj(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyitjbrtkykkousnuktkarhyj());
            pKbkSsuRnduHknJigyohiTy.setZtygyousekihyoujis(pHoyuuMeisaiTyukeiyouItzHzn.getZtygyousekihyoujis());
            pKbkSsuRnduHknJigyohiTy.setZtysykykgyusekihyjs(pHoyuuMeisaiTyukeiyouItzHzn.getZtysykykgyusekihyjs());
            pKbkSsuRnduHknJigyohiTy.setZtytenkangyousekihyoujis(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtytenkangyousekihyoujis());
            pKbkSsuRnduHknJigyohiTy.setZtytnknteikigyousekihyjs(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtytnknteikigyousekihyjs());
            pKbkSsuRnduHknJigyohiTy.setZtytnkndpbbngyuskhyjs(pHoyuuMeisaiTyukeiyouItzHzn.getZtytnkndpbbngyuskhyjs());
            pKbkSsuRnduHknJigyohiTy.setZtykykjyoutai(pHoyuuMeisaiTyukeiyouItzHzn.getZtykykjyoutai());
            pKbkSsuRnduHknJigyohiTy.setZtypmenhukakbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtypmenhukakbn());
            pKbkSsuRnduHknJigyohiTy.setZtykousinkbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtykousinkbn());
            pKbkSsuRnduHknJigyohiTy.setZtymankiyoteikbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtymankiyoteikbn());
            pKbkSsuRnduHknJigyohiTy.setZtysykyktikmnkyoteikbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtysykyktikmnkyoteikbn());
            pKbkSsuRnduHknJigyohiTy.setZtytnknsykykkhnmnkytikbn(pHoyuuMeisaiTyukeiyouItzHzn
                .getZtytnknsykykkhnmnkytikbn());
            pKbkSsuRnduHknJigyohiTy.setZtytnknsykyktikmnkytikbn(pHoyuuMeisaiTyukeiyouItzHzn
                .getZtytnknsykyktikmnkytikbn());
            pKbkSsuRnduHknJigyohiTy.setZtytenkanteikimankiyoteikbn(pHoyuuMeisaiTyukeiyouItzHzn
                .getZtytenkanteikimankiyoteikbn());
            pKbkSsuRnduHknJigyohiTy.setZtyszoumankiyoteikbnx1(pHoyuuMeisaiTyukeiyouItzHzn.getZtyszoumankiyoteikbnx1());
            pKbkSsuRnduHknJigyohiTy.setZtyszoumankiyoteikbnx2(pHoyuuMeisaiTyukeiyouItzHzn.getZtyszoumankiyoteikbnx2());
            pKbkSsuRnduHknJigyohiTy
            .setZtyvestingmankiyoteikbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtyvestingmankiyoteikbn());
            pKbkSsuRnduHknJigyohiTy.setZtyvkeisanhyouji(pHoyuuMeisaiTyukeiyouItzHzn.getZtyvkeisanhyouji());
            pKbkSsuRnduHknJigyohiTy.setZtytoukisinkeiyakuhyouji(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtytoukisinkeiyakuhyouji());
            pKbkSsuRnduHknJigyohiTy.setZtysykykhokenhoutekiyouhyj(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtysykykhokenhoutekiyouhyj());
            pKbkSsuRnduHknJigyohiTy.setZtytokuteijyoutaihushrhyj(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtytokuteijyoutaihushrhyj());
            pKbkSsuRnduHknJigyohiTy.setZtyytirrthndsysnmnskaisuu(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyytirrthndsysnmnskaisuu());
            pKbkSsuRnduHknJigyohiTy.setZtysuuriyouyobin3(pHoyuuMeisaiTyukeiyouItzHzn.getZtysuuriyouyobin3());
            pKbkSsuRnduHknJigyohiTy.setZtysuuriyouyobin11(pHoyuuMeisaiTyukeiyouItzHzn.getZtysuuriyouyobin11());
            pKbkSsuRnduHknJigyohiTy.setZtywnasigoukeitenkankakaku(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtywnasigoukeitenkankakaku());
            pKbkSsuRnduHknJigyohiTy.setZtyyobin11(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobin11());
            pKbkSsuRnduHknJigyohiTy.setZtyyobin11x2(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobin11x2());
            pKbkSsuRnduHknJigyohiTy.setZtyyobin11x3(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobin11x3());
            pKbkSsuRnduHknJigyohiTy.setZtytukibaraikansantokujyoup(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtytukibaraikansantokujyoup());
            pKbkSsuRnduHknJigyohiTy.setZtytnkngkykkssnkijyuym(pHoyuuMeisaiTyukeiyouItzHzn.getZtytnkngkykkssnkijyuym());
            pKbkSsuRnduHknJigyohiTy.setZtysaiteihosyouhyouji(pHoyuuMeisaiTyukeiyouItzHzn.getZtysaiteihosyouhyouji());
            pKbkSsuRnduHknJigyohiTy.setZtysuuriyouyobin8x2(pHoyuuMeisaiTyukeiyouItzHzn.getZtysuuriyouyobin8x2());
            pKbkSsuRnduHknJigyohiTy.setZtysuuriyouyobin14(pHoyuuMeisaiTyukeiyouItzHzn.getZtysuuriyouyobin14());
            pKbkSsuRnduHknJigyohiTy.setZtyhrimngtkykphrkkaisuukbn(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyhrimngtkykphrkkaisuukbn());
            pKbkSsuRnduHknJigyohiTy.setZtyhrimngtkykphrkkirkbn(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyhrimngtkykphrkkirkbn());
            pKbkSsuRnduHknJigyohiTy.setZtyhrimngtkykpryurtkbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhrimngtkykpryurtkbn());
            pKbkSsuRnduHknJigyohiTy.setZtyyobiv13(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobiv13());
            pKbkSsuRnduHknJigyohiTy.setZtyidoujisaiteihosyoukngk(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyidoujisaiteihosyoukngk());
            pKbkSsuRnduHknJigyohiTy.setZtyidoujisaiteihosyoucost(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyidoujisaiteihosyoucost());
            pKbkSsuRnduHknJigyohiTy.setZtysinhokenfundtumitatekin(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtysinhokenfundtumitatekin());
            pKbkSsuRnduHknJigyohiTy.setZtymsyuptusshkgkaiykhnrikn(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtymsyuptusshkgkaiykhnrikn());
            pKbkSsuRnduHknJigyohiTy.setZtyrrthndugtnkgetumatuv(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyrrthndugtnkgetumatuv());
            pKbkSsuRnduHknJigyohiTy.setZtyrrthndnksaiteihosyonkgns(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyrrthndnksaiteihosyonkgns());
            pKbkSsuRnduHknJigyohiTy.setZtyrrthendougatanksibous(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyrrthendougatanksibous());
            pKbkSsuRnduHknJigyohiTy.setZtyalmyousohutomeisyoukbn(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyalmyousohutomeisyoukbn());
            pKbkSsuRnduHknJigyohiTy.setZtysnkyksoftmeisyoukbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtysnkyksoftmeisyoukbn());
            pKbkSsuRnduHknJigyohiTy.setZtysoftmeisyoukbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtysoftmeisyoukbn());
            pKbkSsuRnduHknJigyohiTy.setZtykykjitokujyouarihyj(pHoyuuMeisaiTyukeiyouItzHzn.getZtykykjitokujyouarihyj());
            pKbkSsuRnduHknJigyohiTy.setZtybnkttnknkbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtybnkttnknkbn());
            pKbkSsuRnduHknJigyohiTy.setZtytenkanminaosikbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtytenkanminaosikbn());
            pKbkSsuRnduHknJigyohiTy.setZtysoujikeitenkankbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtysoujikeitenkankbn());
            pKbkSsuRnduHknJigyohiTy.setZtynenkinkaisinendo(pHoyuuMeisaiTyukeiyouItzHzn.getZtynenkinkaisinendo());
            pKbkSsuRnduHknJigyohiTy.setZtynenkingatakbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtynenkingatakbn());
            pKbkSsuRnduHknJigyohiTy.setZtynknshry(pHoyuuMeisaiTyukeiyouItzHzn.getZtynknshry());
            pKbkSsuRnduHknJigyohiTy.setZtyheiyoubaraikeiyakukbn(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyheiyoubaraikeiyakukbn());
            pKbkSsuRnduHknJigyohiTy.setZtynenkinmaruteihukakbn(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtynenkinmaruteihukakbn());
            pKbkSsuRnduHknJigyohiTy.setZtysinseizonmrtiarihyj(pHoyuuMeisaiTyukeiyouItzHzn.getZtysinseizonmrtiarihyj());
            pKbkSsuRnduHknJigyohiTy.setZtysnkykyouibokijyukbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtysnkykyouibokijyukbn());
            pKbkSsuRnduHknJigyohiTy.setZtytokusitujyuusitusetkbn(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtytokusitujyuusitusetkbn());
            pKbkSsuRnduHknJigyohiTy.setZtysiktsyuknbyugnhsyunshyj(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtysiktsyuknbyugnhsyunshyj());
            pKbkSsuRnduHknJigyohiTy.setZtypmensugugtganhsyunshyj(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtypmensugugtganhsyunshyj());
            pKbkSsuRnduHknJigyohiTy.setZtytkykgyousekihyjszerohyj(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtytkykgyousekihyjszerohyj());
            pKbkSsuRnduHknJigyohiTy.setZtysuuriyouyobin7(pHoyuuMeisaiTyukeiyouItzHzn.getZtysuuriyouyobin7());
            pKbkSsuRnduHknJigyohiTy.setZtysyussaikeitaikbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtysyussaikeitaikbn());
            pKbkSsuRnduHknJigyohiTy.setZtyyobiv6(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobiv6());
            pKbkSsuRnduHknJigyohiTy.setZtybosyuukeitaikbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtybosyuukeitaikbn());
            pKbkSsuRnduHknJigyohiTy.setZtyaatukaisosikicd(pHoyuuMeisaiTyukeiyouItzHzn.getZtyaatukaisosikicd());
            pKbkSsuRnduHknJigyohiTy.setZtyaatukaikojincd(pHoyuuMeisaiTyukeiyouItzHzn.getZtyaatukaikojincd());
            pKbkSsuRnduHknJigyohiTy.setZtybsydrtencd(pHoyuuMeisaiTyukeiyouItzHzn.getZtybsydrtencd());
            pKbkSsuRnduHknJigyohiTy.setZtycifcd(pHoyuuMeisaiTyukeiyouItzHzn.getZtycifcd());
            pKbkSsuRnduHknJigyohiTy.setZtysuuriyouyobiv8(pHoyuuMeisaiTyukeiyouItzHzn.getZtysuuriyouyobiv8());
            pKbkSsuRnduHknJigyohiTy.setZtysinsakbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtysinsakbn());
            pKbkSsuRnduHknJigyohiTy.setZtydai2hihokensyasinsakbn(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtydai2hihokensyasinsakbn());
            pKbkSsuRnduHknJigyohiTy.setZtytoukeiyousinsakbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtytoukeiyousinsakbn());
            pKbkSsuRnduHknJigyohiTy.setZtydai2toukeiyousinsakbn(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtydai2toukeiyousinsakbn());
            pKbkSsuRnduHknJigyohiTy.setZtyketteikijyunkanwakbn(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyketteikijyunkanwakbn());
            pKbkSsuRnduHknJigyohiTy.setZtykihonsibouhyoukbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtykihonsibouhyoukbn());
            pKbkSsuRnduHknJigyohiTy.setZtyteikisibouhyoukbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtyteikisibouhyoukbn());
            pKbkSsuRnduHknJigyohiTy.setZtysonotasibouhyoukbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtysonotasibouhyoukbn());
            pKbkSsuRnduHknJigyohiTy.setZtymrarihyj(pHoyuuMeisaiTyukeiyouItzHzn.getZtymrarihyj());
            pKbkSsuRnduHknJigyohiTy.setZtysentakujyouhouarihyouji(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtysentakujyouhouarihyouji());
            pKbkSsuRnduHknJigyohiTy.setZtydugktnknsntkhuhukbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtydugktnknsntkhuhukbn());
            pKbkSsuRnduHknJigyohiTy.setZtygengakutenkankykhyj(pHoyuuMeisaiTyukeiyouItzHzn.getZtygengakutenkankykhyj());
            pKbkSsuRnduHknJigyohiTy.setZtysykgycd(pHoyuuMeisaiTyukeiyouItzHzn.getZtysykgycd());
            pKbkSsuRnduHknJigyohiTy.setZtyjidoukousinkykkanyuuymd(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyjidoukousinkykkanyuuymd());
            pKbkSsuRnduHknJigyohiTy.setZtysaikohtnknkykkykymd(pHoyuuMeisaiTyukeiyouItzHzn.getZtysaikohtnknkykkykymd());
            pKbkSsuRnduHknJigyohiTy.setZtykousinmaesykyksburtkbn(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtykousinmaesykyksburtkbn());
            pKbkSsuRnduHknJigyohiTy.setZtyhjnkykhyj(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhjnkykhyj());
            pKbkSsuRnduHknJigyohiTy.setZtyanniskcd(pHoyuuMeisaiTyukeiyouItzHzn.getZtyanniskcd());
            pKbkSsuRnduHknJigyohiTy.setZtyhjncd(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhjncd());
            pKbkSsuRnduHknJigyohiTy.setZtyhjnjigyosyocd(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhjnjigyosyocd());
            pKbkSsuRnduHknJigyohiTy.setZtysaihokenno(pHoyuuMeisaiTyukeiyouItzHzn.getZtysaihokenno());
            pKbkSsuRnduHknJigyohiTy.setZtydakuhikettikekkacd(pHoyuuMeisaiTyukeiyouItzHzn.getZtydakuhikettikekkacd());
            pKbkSsuRnduHknJigyohiTy.setZtydai2dakuhiketteikekkacd(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtydai2dakuhiketteikekkacd());
            pKbkSsuRnduHknJigyohiTy.setZtypmenkbnv2(pHoyuuMeisaiTyukeiyouItzHzn.getZtypmenkbnv2());
            pKbkSsuRnduHknJigyohiTy.setZtysiboukyuuhukin(pHoyuuMeisaiTyukeiyouItzHzn.getZtysiboukyuuhukin());
            pKbkSsuRnduHknJigyohiTy.setZtyjyudthumeharaitkykhkhyj(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyjyudthumeharaitkykhkhyj());
            pKbkSsuRnduHknJigyohiTy.setZtyhaitoukbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhaitoukbn());
            pKbkSsuRnduHknJigyohiTy.setZtyhhknnentysihyj(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhhknnentysihyj());
            pKbkSsuRnduHknJigyohiTy.setZtydai2hhknnentysihyj(pHoyuuMeisaiTyukeiyouItzHzn.getZtydai2hhknnentysihyj());
            pKbkSsuRnduHknJigyohiTy.setZtykyksyaagetyouseihyj(pHoyuuMeisaiTyukeiyouItzHzn.getZtykyksyaagetyouseihyj());
            pKbkSsuRnduHknJigyohiTy.setZtykituenkbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtykituenkbn());
            pKbkSsuRnduHknJigyohiTy.setZtykituenhonsuu(pHoyuuMeisaiTyukeiyouItzHzn.getZtykituenhonsuu());
            pKbkSsuRnduHknJigyohiTy.setZtymusentakukeiyakukbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtymusentakukeiyakukbn());
            pKbkSsuRnduHknJigyohiTy.setZtyyobiv6x2(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobiv6x2());
            pKbkSsuRnduHknJigyohiTy.setZtylivingneedstkykarihyj(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtylivingneedstkykarihyj());
            pKbkSsuRnduHknJigyohiTy.setZtylivingneedssiharaihyouji(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtylivingneedssiharaihyouji());
            pKbkSsuRnduHknJigyohiTy.setZtylnseikyuuymd(pHoyuuMeisaiTyukeiyouItzHzn.getZtylnseikyuuymd());
            pKbkSsuRnduHknJigyohiTy.setZtylnshrgenincd(pHoyuuMeisaiTyukeiyouItzHzn.getZtylnshrgenincd());
            pKbkSsuRnduHknJigyohiTy.setZtydakuhikettisyacd(pHoyuuMeisaiTyukeiyouItzHzn.getZtydakuhikettisyacd());
            pKbkSsuRnduHknJigyohiTy.setZtydai2dakuhiketteisyacd(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtydai2dakuhiketteisyacd());
            pKbkSsuRnduHknJigyohiTy.setZtygansapotokuyakuarihyouji(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtygansapotokuyakuarihyouji());
            pKbkSsuRnduHknJigyohiTy.setZtygnspshrhyj(pHoyuuMeisaiTyukeiyouItzHzn.getZtygnspshrhyj());
            pKbkSsuRnduHknJigyohiTy.setZtygansaposeikyuuymd(pHoyuuMeisaiTyukeiyouItzHzn.getZtygansaposeikyuuymd());
            pKbkSsuRnduHknJigyohiTy.setZtygnspshrgenincd(pHoyuuMeisaiTyukeiyouItzHzn.getZtygnspshrgenincd());
            pKbkSsuRnduHknJigyohiTy.setZtyyobiv3x2(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobiv3x2());
            pKbkSsuRnduHknJigyohiTy.setZtytargetmokuhyouritu(pHoyuuMeisaiTyukeiyouItzHzn.getZtytargetmokuhyouritu());
            pKbkSsuRnduHknJigyohiTy.setZtyautoswitchmokuhyouritu(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyautoswitchmokuhyouritu());
            pKbkSsuRnduHknJigyohiTy.setZtytumitatekinitenarihyj(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtytumitatekinitenarihyj());
            pKbkSsuRnduHknJigyohiTy.setZtytumitatekinitenkaisuu(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtytumitatekinitenkaisuu());
            pKbkSsuRnduHknJigyohiTy.setZtydatakanrino2(pHoyuuMeisaiTyukeiyouItzHzn.getZtydatakanrino2());
            pKbkSsuRnduHknJigyohiTy.setZtydatakanrino3(pHoyuuMeisaiTyukeiyouItzHzn.getZtydatakanrino3());
            pKbkSsuRnduHknJigyohiTy.setZtyknkuzusnzyrttekinendo(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyknkuzusnzyrttekinendo());
            pKbkSsuRnduHknJigyohiTy.setZtyknkuzusnzyrt(pHoyuuMeisaiTyukeiyouItzHzn.getZtyknkuzusnzyrt());
            pKbkSsuRnduHknJigyohiTy.setZtyknkuzusnzyrtx2(pHoyuuMeisaiTyukeiyouItzHzn.getZtyknkuzusnzyrtx2());
            pKbkSsuRnduHknJigyohiTy.setZtyknkuzusnzyrtx3(pHoyuuMeisaiTyukeiyouItzHzn.getZtyknkuzusnzyrtx3());
            pKbkSsuRnduHknJigyohiTy.setZtysinkeiyakujiknkuzusnzyrt(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtysinkeiyakujiknkuzusnzyrt());
            pKbkSsuRnduHknJigyohiTy.setZtytenkanjiknkuzusnzyrt(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtytenkanjiknkuzusnzyrt());
            pKbkSsuRnduHknJigyohiTy.setZtysinkeiyakujivithkhyouji(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtysinkeiyakujivithkhyouji());
            pKbkSsuRnduHknJigyohiTy.setZtykykjivithukusuukykhyj(pHoyuuMeisaiTyukeiyouItzHzn.getZtykykjivithukusuukykhyj());
            pKbkSsuRnduHknJigyohiTy.setZtysuuriyouyobin9x2(pHoyuuMeisaiTyukeiyouItzHzn.getZtysuuriyouyobin9x2());
            pKbkSsuRnduHknJigyohiTy.setZtypwrbksidhitekiyouhyj(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtypwrbksidhitekiyouhyj());
            pKbkSsuRnduHknJigyohiTy.setZtysuuriyouyobin9(pHoyuuMeisaiTyukeiyouItzHzn.getZtysuuriyouyobin9());
            pKbkSsuRnduHknJigyohiTy.setZtysuuriyouyobin10x7(pHoyuuMeisaiTyukeiyouItzHzn.getZtysuuriyouyobin10x7());
            pKbkSsuRnduHknJigyohiTy.setZtysuuriyouyobin10x8(pHoyuuMeisaiTyukeiyouItzHzn.getZtysuuriyouyobin10x8());
            pKbkSsuRnduHknJigyohiTy.setZtysuuriyouyobin10x9(pHoyuuMeisaiTyukeiyouItzHzn.getZtysuuriyouyobin10x9());
            pKbkSsuRnduHknJigyohiTy.setZtytumitatekinitenbubun(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtytumitatekinitenbubun());
            pKbkSsuRnduHknJigyohiTy.setZtysagakusknnjynbknzndk(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtysagakusknnjynbknzndk());
            pKbkSsuRnduHknJigyohiTy.setZtyyobin11x5(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobin11x5());
            pKbkSsuRnduHknJigyohiTy.setZtyyobin11x6(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobin11x6());
            pKbkSsuRnduHknJigyohiTy.setZtyyobin11x7(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobin11x7());
            pKbkSsuRnduHknJigyohiTy.setZtyyobin11x8(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobin11x8());
            pKbkSsuRnduHknJigyohiTy.setZtyyobin11x9(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobin11x9());
            pKbkSsuRnduHknJigyohiTy.setZtyyobin11x10(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobin11x10());
            pKbkSsuRnduHknJigyohiTy.setZtyyobin11x11(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobin11x11());
            pKbkSsuRnduHknJigyohiTy.setZtyyobin11x12(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobin11x12());
            pKbkSsuRnduHknJigyohiTy.setZtyyobin11x13(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobin11x13());
            pKbkSsuRnduHknJigyohiTy.setZtyyobin11x14(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobin11x14());
            pKbkSsuRnduHknJigyohiTy.setZtyyobin11x15(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobin11x15());
            pKbkSsuRnduHknJigyohiTy.setZtyyobin11x16(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobin11x16());
            pKbkSsuRnduHknJigyohiTy.setZtyyobin11x17(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobin11x17());
            pKbkSsuRnduHknJigyohiTy.setZtyzyrthntiyustatuskbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtyzyrthntiyustatuskbn());
            pKbkSsuRnduHknJigyohiTy.setZtyzyrthntiyustatuskbnx2(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyzyrthntiyustatuskbnx2());
            pKbkSsuRnduHknJigyohiTy.setZtyzyrthntiyustatuskbnx3(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyzyrthntiyustatuskbnx3());
            pKbkSsuRnduHknJigyohiTy.setZtyzyrthntiyustatuskbnx4(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyzyrthntiyustatuskbnx4());
            pKbkSsuRnduHknJigyohiTy.setZtyzyrthntiyustatuskbnx5(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyzyrthntiyustatuskbnx5());
            pKbkSsuRnduHknJigyohiTy.setZtyyobiv10(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobiv10());
            pKbkSsuRnduHknJigyohiTy.setZtyyobiv15x2(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobiv15x2());
            pKbkSsuRnduHknJigyohiTy.setZtyyobiv15x3(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobiv15x3());
            pKbkSsuRnduHknJigyohiTy.setZtyyobiv15x4(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobiv15x4());
            pKbkSsuRnduHknJigyohiTy.setZtygaikakbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtygaikakbn());
            pKbkSsuRnduHknJigyohiTy.setZtykawaserate1(pHoyuuMeisaiTyukeiyouItzHzn.getZtykawaserate1());
            pKbkSsuRnduHknJigyohiTy.setZtykawaseratetekiyouymd1(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtykawaseratetekiyouymd1());
            pKbkSsuRnduHknJigyohiTy.setZtykawaserate2(pHoyuuMeisaiTyukeiyouItzHzn.getZtykawaserate2());
            pKbkSsuRnduHknJigyohiTy.setZtykawaseratetekiyouymd2(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtykawaseratetekiyouymd2());
            pKbkSsuRnduHknJigyohiTy.setZtykykjikawaserate(pHoyuuMeisaiTyukeiyouItzHzn.getZtykykjikawaserate());
            pKbkSsuRnduHknJigyohiTy.setZtykykjikawaseratetkyuymd(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtykykjikawaseratetkyuymd());
            pKbkSsuRnduHknJigyohiTy.setZtymvatyouseigow(pHoyuuMeisaiTyukeiyouItzHzn.getZtymvatyouseigow());
            pKbkSsuRnduHknJigyohiTy.setZtymvakeisanjisknnjynbkn(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtymvakeisanjisknnjynbkn());
            pKbkSsuRnduHknJigyohiTy.setZtykaiyakukoujyoritu(pHoyuuMeisaiTyukeiyouItzHzn.getZtykaiyakukoujyoritu());
            pKbkSsuRnduHknJigyohiTy.setZtyrendouritu(pHoyuuMeisaiTyukeiyouItzHzn.getZtyrendouritu());
            pKbkSsuRnduHknJigyohiTy.setZtysrkaiyakusjkkktyouseirrt(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtysrkaiyakusjkkktyouseirrt());
            pKbkSsuRnduHknJigyohiTy.setZtysrkyksjkkktyouseiriritu(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtysrkyksjkkktyouseiriritu());
            pKbkSsuRnduHknJigyohiTy.setZtymvakeisankijyunymd(pHoyuuMeisaiTyukeiyouItzHzn.getZtymvakeisankijyunymd());
            pKbkSsuRnduHknJigyohiTy.setZtymvatyouseikou(pHoyuuMeisaiTyukeiyouItzHzn.getZtymvatyouseikou());
            pKbkSsuRnduHknJigyohiTy.setZtyenkdtsbujsitihsyukngk(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyenkdtsbujsitihsyukngk());
            pKbkSsuRnduHknJigyohiTy.setZtyenkdtsbujsitihsyucost(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyenkdtsbujsitihsyucost());
            pKbkSsuRnduHknJigyohiTy.setZtyenkdtsbujsitihsyuarihyj(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyenkdtsbujsitihsyuarihyj());
            pKbkSsuRnduHknJigyohiTy.setZtykeiyakujiyoteiriritu(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtykeiyakujiyoteiriritu());
            pKbkSsuRnduHknJigyohiTy.setZtytumitateriritu(pHoyuuMeisaiTyukeiyouItzHzn.getZtytumitateriritu());
            pKbkSsuRnduHknJigyohiTy.setZtykaigomaebaraitkykarihyj(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtykaigomaebaraitkykarihyj());
            pKbkSsuRnduHknJigyohiTy.setZtysibouhyoukbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtysibouhyoukbn());
            pKbkSsuRnduHknJigyohiTy.setZtynyuukintuukakbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtynyuukintuukakbn());
            pKbkSsuRnduHknJigyohiTy.setZtysiharaituukakbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtysiharaituukakbn());
            pKbkSsuRnduHknJigyohiTy.setZtywyendttargetmokuhyouritu(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtywyendttargetmokuhyouritu());
            pKbkSsuRnduHknJigyohiTy.setZtysisuurendourate(pHoyuuMeisaiTyukeiyouItzHzn.getZtysisuurendourate());
            pKbkSsuRnduHknJigyohiTy.setZtysisuukbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtysisuukbn());
            pKbkSsuRnduHknJigyohiTy.setZtyteirituikouhyouji(pHoyuuMeisaiTyukeiyouItzHzn.getZtyteirituikouhyouji());
            pKbkSsuRnduHknJigyohiTy.setZtysuuriyouyobin10x11(pHoyuuMeisaiTyukeiyouItzHzn.getZtysuuriyouyobin10x11());
            pKbkSsuRnduHknJigyohiTy.setZtytmttknzoukaritujygn(pHoyuuMeisaiTyukeiyouItzHzn.getZtytmttknzoukaritujygn());
            pKbkSsuRnduHknJigyohiTy.setZtysetteibairitu(pHoyuuMeisaiTyukeiyouItzHzn.getZtysetteibairitu());
            pKbkSsuRnduHknJigyohiTy.setZtytykzenoutouymdsisuu(pHoyuuMeisaiTyukeiyouItzHzn.getZtytykzenoutouymdsisuu());
            pKbkSsuRnduHknJigyohiTy.setZtykimatusisuu(pHoyuuMeisaiTyukeiyouItzHzn.getZtykimatusisuu());
            pKbkSsuRnduHknJigyohiTy.setZtyyenkadatekihons(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyenkadatekihons());
            pKbkSsuRnduHknJigyohiTy.setZtysitihsyumegkdtsibous(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtysitihsyumegkdtsibous());
            pKbkSsuRnduHknJigyohiTy.setZtyenkdtssrentumitatekin(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyenkdtssrentumitatekin());
            pKbkSsuRnduHknJigyohiTy.setZtysisuurentumitatekin(pHoyuuMeisaiTyukeiyouItzHzn.getZtysisuurentumitatekin());
            pKbkSsuRnduHknJigyohiTy.setZtynksjitirttumitatekin(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtynksjitirttumitatekin());
            pKbkSsuRnduHknJigyohiTy.setZtykimatutirttumitatekin(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtykimatutirttumitatekin());
            pKbkSsuRnduHknJigyohiTy.setZtygaikadatejyuutoup(pHoyuuMeisaiTyukeiyouItzHzn.getZtygaikadatejyuutoup());
            pKbkSsuRnduHknJigyohiTy.setZtyyendttargetkijyunkingaku(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyyendttargetkijyunkingaku());
            pKbkSsuRnduHknJigyohiTy.setZtyyobiv7(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobiv7());
            pKbkSsuRnduHknJigyohiTy.setZtysitivkisnyukykjikwsrate(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtysitivkisnyukykjikwsrate());
            pKbkSsuRnduHknJigyohiTy.setZtysisuurentyokugotmttkn(pHoyuuMeisaiTyukeiyouItzHzn.getZtysisuurentyokugotmttkn());
        }
        else if (pKessanKbn.eq(C_KessanKbn.KESSAN)) {
            pKsnKbkSsuRnduHknJigyohiTy.setZtyrecordkbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtyrecordkbn());
            pKsnKbkSsuRnduHknJigyohiTy.setZtynenkinkaisigohyouji(pHoyuuMeisaiTyukeiyouItzHzn
                .getZtynenkinkaisigohyouji());
            pKsnKbkSsuRnduHknJigyohiTy.setZtynksgokurikosidhyj(pHoyuuMeisaiTyukeiyouItzHzn.getZtynksgokurikosidhyj());
            pKsnKbkSsuRnduHknJigyohiTy.setZtykeijyouym(pHoyuuMeisaiTyukeiyouItzHzn.getZtykeijyouym());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyidojiyukbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtyidojiyukbn());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyzougenkbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtyzougenkbn());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyidourecordkbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtyidourecordkbn());
            pKsnKbkSsuRnduHknJigyohiTy.setZtykeijyouctrlkbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtykeijyouctrlkbn());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyhenkousyoriymd(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhenkousyoriymd());
            pKsnKbkSsuRnduHknJigyohiTy.setZtykykmfksnctr(pHoyuuMeisaiTyukeiyouItzHzn.getZtykykmfksnctr());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyrecordctr(pHoyuuMeisaiTyukeiyouItzHzn.getZtyrecordctr());
            pKsnKbkSsuRnduHknJigyohiTy.setZtysuuriyoukouryokukaisiymd(pHoyuuMeisaiTyukeiyouItzHzn
                .getZtysuuriyoukouryokukaisiymd());
            pKsnKbkSsuRnduHknJigyohiTy.setZtydenymd(pHoyuuMeisaiTyukeiyouItzHzn.getZtydenymd());
            pKsnKbkSsuRnduHknJigyohiTy.setZtybluekeizokuhyouji(pHoyuuMeisaiTyukeiyouItzHzn.getZtybluekeizokuhyouji());
            pKsnKbkSsuRnduHknJigyohiTy.setZtysuuriyouyobin1x2(pHoyuuMeisaiTyukeiyouItzHzn.getZtysuuriyouyobin1x2());
            pKsnKbkSsuRnduHknJigyohiTy.setZtytoukeikeijyoukbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtytoukeikeijyoukbn());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyraysystemhyj(pHoyuuMeisaiTyukeiyouItzHzn.getZtyraysystemhyj());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyzenkiidouteiseikbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtyzenkiidouteiseikbn());
            pKsnKbkSsuRnduHknJigyohiTy.setZtybsyym(pHoyuuMeisaiTyukeiyouItzHzn.getZtybsyym());
            pKsnKbkSsuRnduHknJigyohiTy.setZtytenkangokeiyakubosyuuym(pHoyuuMeisaiTyukeiyouItzHzn
                .getZtytenkangokeiyakubosyuuym());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyidoujiyuucd(pHoyuuMeisaiTyukeiyouItzHzn.getZtyidoujiyuucd());
            pKsnKbkSsuRnduHknJigyohiTy.setZtysyoricd(pHoyuuMeisaiTyukeiyouItzHzn.getZtysyoricd());
            pKsnKbkSsuRnduHknJigyohiTy.setZtysekininteiseihyouji(pHoyuuMeisaiTyukeiyouItzHzn
                .getZtysekininteiseihyouji());
            pKsnKbkSsuRnduHknJigyohiTy.setZtysuuriyouyobin8(pHoyuuMeisaiTyukeiyouItzHzn.getZtysuuriyouyobin8());
            pKsnKbkSsuRnduHknJigyohiTy.setZtysihankibikinkbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtysihankibikinkbn());
            pKsnKbkSsuRnduHknJigyohiTy.setZtysuuriyouyobin1x3(pHoyuuMeisaiTyukeiyouItzHzn.getZtysuuriyouyobin1x3());
            pKsnKbkSsuRnduHknJigyohiTy.setZtydatakanrino(pHoyuuMeisaiTyukeiyouItzHzn.getZtydatakanrino());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyhknsyukigou(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhknsyukigou());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyhknsyuruikigousedaikbn(pHoyuuMeisaiTyukeiyouItzHzn
                .getZtyhknsyuruikigousedaikbn());
            pKsnKbkSsuRnduHknJigyohiTy.setZtysotodasipmenkbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtysotodasipmenkbn());
            pKsnKbkSsuRnduHknJigyohiTy.setZtystdssytikbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtystdssytikbn());
            pKsnKbkSsuRnduHknJigyohiTy.setZtystdssnskbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtystdssnskbn());
            pKsnKbkSsuRnduHknJigyohiTy
            .setZtysotodasimanagehyouji(pHoyuuMeisaiTyukeiyouItzHzn.getZtysotodasimanagehyouji());
            pKsnKbkSsuRnduHknJigyohiTy.setZtysotodasiphkbnmnoshyouji(pHoyuuMeisaiTyukeiyouItzHzn
                .getZtysotodasiphkbnmnoshyouji());
            pKsnKbkSsuRnduHknJigyohiTy.setZtystdsstkjytkyuhyj(pHoyuuMeisaiTyukeiyouItzHzn.getZtystdsstkjytkyuhyj());
            pKsnKbkSsuRnduHknJigyohiTy.setZtykbnkeiriyousegmentkbn(pHoyuuMeisaiTyukeiyouItzHzn
                .getZtykbnkeiriyousegmentkbn());
            pKsnKbkSsuRnduHknJigyohiTy.setZtykbnkeiriyourgnbnskkbn(pHoyuuMeisaiTyukeiyouItzHzn
                .getZtykbnkeiriyourgnbnskkbn());
            pKsnKbkSsuRnduHknJigyohiTy.setZtysuurisyuruicd(pHoyuuMeisaiTyukeiyouItzHzn.getZtysuurisyuruicd());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyhosyoukinoukbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhosyoukinoukbn());
            pKsnKbkSsuRnduHknJigyohiTy.setZtydaikbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtydaikbn());
            pKsnKbkSsuRnduHknJigyohiTy.setZtytyuukbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtytyuukbn());
            pKsnKbkSsuRnduHknJigyohiTy.setZtysyoukbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtysyoukbn());
            pKsnKbkSsuRnduHknJigyohiTy.setZtysedaikbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtysedaikbn());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyharaikatakbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtyharaikatakbn());
            pKsnKbkSsuRnduHknJigyohiTy.setZtykykymd(pHoyuuMeisaiTyukeiyouItzHzn.getZtykykymd());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyhknkkn(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhknkkn());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyphrkkikn(pHoyuuMeisaiTyukeiyouItzHzn.getZtyphrkkikn());
            pKsnKbkSsuRnduHknJigyohiTy.setZtysaimnkkykhyj(pHoyuuMeisaiTyukeiyouItzHzn.getZtysaimnkkykhyj());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyannaifuyouriyuukbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtyannaifuyouriyuukbn());
            pKsnKbkSsuRnduHknJigyohiTy.setZtytksyuannaikykkbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtytksyuannaikykkbn());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyhrkkaisuukbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhrkkaisuukbn());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyhrkkeirokbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhrkkeirokbn());
            pKsnKbkSsuRnduHknJigyohiTy.setZtysdpdkbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtysdpdkbn());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyryouritukbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtyryouritukbn());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyao3tyou3sibousdatehyouji(pHoyuuMeisaiTyukeiyouItzHzn
                .getZtyao3tyou3sibousdatehyouji());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyhhknseikbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhhknseikbn());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyhihokensyaagev2(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhihokensyaagev2());
            pKsnKbkSsuRnduHknJigyohiTy.setZtykyksyanen(pHoyuuMeisaiTyukeiyouItzHzn.getZtykyksyanen());
            pKsnKbkSsuRnduHknJigyohiTy.setZtydai2hhknnen(pHoyuuMeisaiTyukeiyouItzHzn.getZtydai2hhknnen());
            pKsnKbkSsuRnduHknJigyohiTy.setZtytkbthsyumnryuhyouji(pHoyuuMeisaiTyukeiyouItzHzn
                .getZtytkbthsyumnryuhyouji());
            pKsnKbkSsuRnduHknJigyohiTy.setZtysyukeiyakupwaribikikbn(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtysyukeiyakupwaribikikbn());
            pKsnKbkSsuRnduHknJigyohiTy.setZtytenkanwaribikikbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtytenkanwaribikikbn());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyyuuhitutnknyuguryurtkbn(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyyuuhitutnknyuguryurtkbn());
            pKsnKbkSsuRnduHknJigyohiTy.setZtysyukeiyakup(pHoyuuMeisaiTyukeiyouItzHzn.getZtysyukeiyakup());
            pKsnKbkSsuRnduHknJigyohiTy.setZtytokujyoup(pHoyuuMeisaiTyukeiyouItzHzn.getZtytokujyoup());
            pKsnKbkSsuRnduHknJigyohiTy.setZtysiteizukisyukeiyakup(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtysiteizukisyukeiyakup());
            pKsnKbkSsuRnduHknJigyohiTy.setZtykihons(pHoyuuMeisaiTyukeiyouItzHzn.getZtykihons());
            pKsnKbkSsuRnduHknJigyohiTy.setZtysibous(pHoyuuMeisaiTyukeiyouItzHzn.getZtysibous());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyhenkougokihons(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhenkougokihons());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyhenkougosibous(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhenkougosibous());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyhenkouymd(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhenkouymd());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyentyoukikan(pHoyuuMeisaiTyukeiyouItzHzn.getZtyentyoukikan());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyseizonkyuuhukinsiteimd(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyseizonkyuuhukinsiteimd());
            pKsnKbkSsuRnduHknJigyohiTy.setZtysyukeiyakusiharaikingaku(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtysyukeiyakusiharaikingaku());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyatukaisisyatodouhukencd(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyatukaisisyatodouhukencd());
            pKsnKbkSsuRnduHknJigyohiTy.setZtytokuyakuhukasuu(pHoyuuMeisaiTyukeiyouItzHzn.getZtytokuyakuhukasuu());
            pKsnKbkSsuRnduHknJigyohiTy.setZtydi2hknkknikoujihisyaage(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtydi2hknkknikoujihisyaage());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyhrimnentyoumaephrkkkn(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyhrimnentyoumaephrkkkn());
            pKsnKbkSsuRnduHknJigyohiTy.setZtytokubetuhosyoukikan(pHoyuuMeisaiTyukeiyouItzHzn
                .getZtytokubetuhosyoukikan());
            pKsnKbkSsuRnduHknJigyohiTy.setZtykousinmanryouage(pHoyuuMeisaiTyukeiyouItzHzn.getZtykousinmanryouage());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyknkuzusnzyrttekitkarihyj(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyknkuzusnzyrttekitkarihyj());
            pKsnKbkSsuRnduHknJigyohiTy.setZtykuriagekurisagekbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtykuriagekurisagekbn());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyhrizmjhknsyukigousdkbn(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyhrizmjhknsyukigousdkbn());
            pKsnKbkSsuRnduHknJigyohiTy.setZtykrsgjhknsyukigousdkbn(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtykrsgjhknsyukigousdkbn());
            pKsnKbkSsuRnduHknJigyohiTy.setZtysotodasisyouhinkaiteikbn(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtysotodasisyouhinkaiteikbn());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyyobiv4(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobiv4());
            pKsnKbkSsuRnduHknJigyohiTy.setZtygoukeitenkans(pHoyuuMeisaiTyukeiyouItzHzn.getZtygoukeitenkans());
            pKsnKbkSsuRnduHknJigyohiTy.setZtygoukeipbubuntenkans(pHoyuuMeisaiTyukeiyouItzHzn
                .getZtygoukeipbubuntenkans());
            pKsnKbkSsuRnduHknJigyohiTy.setZtytenkanteikisyuruikigou(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtytenkanteikisyuruikigou());
            pKsnKbkSsuRnduHknJigyohiTy.setZtytenkanteikikigousedaikbn(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtytenkanteikikigousedaikbn());
            pKsnKbkSsuRnduHknJigyohiTy.setZtytnkntiksotodasikusnkbn(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtytnkntiksotodasikusnkbn());
            pKsnKbkSsuRnduHknJigyohiTy.setZtytnkntikstdspmenkbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtytnkntikstdspmenkbn());
            pKsnKbkSsuRnduHknJigyohiTy.setZtytenkanteikikigouyobi(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtytenkanteikikigouyobi());
            pKsnKbkSsuRnduHknJigyohiTy.setZtytenkanteikikikan(pHoyuuMeisaiTyukeiyouItzHzn.getZtytenkanteikikikan());
            pKsnKbkSsuRnduHknJigyohiTy.setZtygoukeitenkanteikis(pHoyuuMeisaiTyukeiyouItzHzn.getZtygoukeitenkanteikis());
            pKsnKbkSsuRnduHknJigyohiTy.setZtytnknteikinkshrkkn(pHoyuuMeisaiTyukeiyouItzHzn.getZtytnknteikinkshrkkn());
            pKsnKbkSsuRnduHknJigyohiTy.setZtytenkansiharaikingaku(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtytenkansiharaikingaku());
            pKsnKbkSsuRnduHknJigyohiTy.setZtytnkntikshrkngk(pHoyuuMeisaiTyukeiyouItzHzn.getZtytnkntikshrkngk());
            pKsnKbkSsuRnduHknJigyohiTy.setZtytenkankaisuu(pHoyuuMeisaiTyukeiyouItzHzn.getZtytenkankaisuu());
            pKsnKbkSsuRnduHknJigyohiTy.setZtygoukeitenkankakaku(pHoyuuMeisaiTyukeiyouItzHzn.getZtygoukeitenkankakaku());
            pKsnKbkSsuRnduHknJigyohiTy.setZtytnknkhnbbnjyuturt(pHoyuuMeisaiTyukeiyouItzHzn.getZtytnknkhnbbnjyuturt());
            pKsnKbkSsuRnduHknJigyohiTy.setZtywnasigoukeitenkanteikis(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtywnasigoukeitenkanteikis());
            pKsnKbkSsuRnduHknJigyohiTy.setZtytnknteikikousinmnryouage(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtytnknteikikousinmnryouage());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyyobiv5(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobiv5());
            pKsnKbkSsuRnduHknJigyohiTy.setZtykanyujidatakanrino(pHoyuuMeisaiTyukeiyouItzHzn.getZtykanyujidatakanrino());
            pKsnKbkSsuRnduHknJigyohiTy.setZtykanyujikykymd(pHoyuuMeisaiTyukeiyouItzHzn.getZtykanyujikykymd());
            pKsnKbkSsuRnduHknJigyohiTy.setZtykanyuujihihokensyaage(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtykanyuujihihokensyaage());
            pKsnKbkSsuRnduHknJigyohiTy.setZtykanyuujitenkanhyouji(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtykanyuujitenkanhyouji());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyhsyuikktminaosikaisu(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyhsyuikktminaosikaisu());
            pKsnKbkSsuRnduHknJigyohiTy.setZtysknnjynbknsisnrt(pHoyuuMeisaiTyukeiyouItzHzn.getZtysknnjynbknsisnrt());
            pKsnKbkSsuRnduHknJigyohiTy.setZtytkjykbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtytkjykbn());
            pKsnKbkSsuRnduHknJigyohiTy.setZtysakugenkikan(pHoyuuMeisaiTyukeiyouItzHzn.getZtysakugenkikan());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyryoumasihyouten(pHoyuuMeisaiTyukeiyouItzHzn.getZtyryoumasihyouten());
            pKsnKbkSsuRnduHknJigyohiTy.setZtysykyktkjyuryumsratehyj(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtysykyktkjyuryumsratehyj());
            pKsnKbkSsuRnduHknJigyohiTy.setZtysykyktkjyuryumsrate(pHoyuuMeisaiTyukeiyouItzHzn
                .getZtysykyktkjyuryumsrate());
            pKsnKbkSsuRnduHknJigyohiTy.setZtydai2tokujyoukbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtydai2tokujyoukbn());
            pKsnKbkSsuRnduHknJigyohiTy.setZtydai2sakugenkikan(pHoyuuMeisaiTyukeiyouItzHzn.getZtydai2sakugenkikan());
            pKsnKbkSsuRnduHknJigyohiTy.setZtydai2ryoumasihyouten(pHoyuuMeisaiTyukeiyouItzHzn
                .getZtydai2ryoumasihyouten());
            pKsnKbkSsuRnduHknJigyohiTy.setZtytokuteibuijyoukenhyouji(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtytokuteibuijyoukenhyouji());
            pKsnKbkSsuRnduHknJigyohiTy.setZtytokuteibuino1(pHoyuuMeisaiTyukeiyouItzHzn.getZtytokuteibuino1());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyhtnpkkn1(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhtnpkkn1());
            pKsnKbkSsuRnduHknJigyohiTy.setZtytokuteibuino2(pHoyuuMeisaiTyukeiyouItzHzn.getZtytokuteibuino2());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyhtnpkkn2(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhtnpkkn2());
            pKsnKbkSsuRnduHknJigyohiTy.setZtymhituiryuyutktbijyknhyj(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtymhituiryuyutktbijyknhyj());
            pKsnKbkSsuRnduHknJigyohiTy.setZtymuhaitouiryouyoutktbino1(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtymuhaitouiryouyoutktbino1());
            pKsnKbkSsuRnduHknJigyohiTy.setZtymuhaitouiryouyouhtnpkkn1(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtymuhaitouiryouyouhtnpkkn1());
            pKsnKbkSsuRnduHknJigyohiTy.setZtymuhaitouiryouyoutktbino2(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtymuhaitouiryouyoutktbino2());
            pKsnKbkSsuRnduHknJigyohiTy.setZtymuhaitouiryouyouhtnpkkn2(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtymuhaitouiryouyouhtnpkkn2());
            pKsnKbkSsuRnduHknJigyohiTy.setZtysiteizukipwarimasihyouji(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtysiteizukipwarimasihyouji());
            pKsnKbkSsuRnduHknJigyohiTy.setZtypwarimasisiteim1(pHoyuuMeisaiTyukeiyouItzHzn.getZtypwarimasisiteim1());
            pKsnKbkSsuRnduHknJigyohiTy.setZtypwarimasisiteim2(pHoyuuMeisaiTyukeiyouItzHzn.getZtypwarimasisiteim2());
            pKsnKbkSsuRnduHknJigyohiTy.setZtysiteimsykykpbairitu(pHoyuuMeisaiTyukeiyouItzHzn
                .getZtysiteimsykykpbairitu());
            pKsnKbkSsuRnduHknJigyohiTy.setZtysaisyuusiteiym(pHoyuuMeisaiTyukeiyouItzHzn.getZtysaisyuusiteiym());
            pKsnKbkSsuRnduHknJigyohiTy.setZtysykykkitmttvkeisanym(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtysykykkitmttvkeisanym());
            pKsnKbkSsuRnduHknJigyohiTy.setZtysykykkitmttsknnjynbkngk(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtysykykkitmttsknnjynbkngk());
            pKsnKbkSsuRnduHknJigyohiTy.setZtydftumitatekingaku(pHoyuuMeisaiTyukeiyouItzHzn.getZtydftumitatekingaku());
            pKsnKbkSsuRnduHknJigyohiTy.setZtydftumimasikin(pHoyuuMeisaiTyukeiyouItzHzn.getZtydftumimasikin());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyvbubundftenkankakaku(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyvbubundftenkankakaku());
            pKsnKbkSsuRnduHknJigyohiTy.setZtydpbubundftenkankakaku(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtydpbubundftenkankakaku());
            pKsnKbkSsuRnduHknJigyohiTy.setZtydftmttkngkitjbrbbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtydftmttkngkitjbrbbn());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyhendous(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhendous());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyhengakujigyounendomatucv(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyhengakujigyounendomatucv());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyitibuitijibarais(pHoyuuMeisaiTyukeiyouItzHzn.getZtyitibuitijibarais());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyitibuitijibaraip(pHoyuuMeisaiTyukeiyouItzHzn.getZtyitibuitijibaraip());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyitibitjbrshrkngk(pHoyuuMeisaiTyukeiyouItzHzn.getZtyitibitjbrshrkngk());
            pKsnKbkSsuRnduHknJigyohiTy.setZtygoukeicv(pHoyuuMeisaiTyukeiyouItzHzn.getZtygoukeicv());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyminasicv(pHoyuuMeisaiTyukeiyouItzHzn.getZtyminasicv());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyloanfund(pHoyuuMeisaiTyukeiyouItzHzn.getZtyloanfund());
            pKsnKbkSsuRnduHknJigyohiTy.setZtysaiteihosyougaku(pHoyuuMeisaiTyukeiyouItzHzn.getZtysaiteihosyougaku());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyhngksitihsyuyusykykp(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyhngksitihsyuyusykykp());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyhijynbrivasbujsitihsyugk(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyhijynbrivasbujsitihsyugk());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyhijynbrivamnkjsitihsyugk(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyhijynbrivamnkjsitihsyugk());
            pKsnKbkSsuRnduHknJigyohiTy.setZtysiinkbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtysiinkbn());
            pKsnKbkSsuRnduHknJigyohiTy.setZtymudkaimasikihons(pHoyuuMeisaiTyukeiyouItzHzn.getZtymudkaimasikihons());
            pKsnKbkSsuRnduHknJigyohiTy.setZtykaimasiymd(pHoyuuMeisaiTyukeiyouItzHzn.getZtykaimasiymd());
            pKsnKbkSsuRnduHknJigyohiTy.setZtykaimasikikan(pHoyuuMeisaiTyukeiyouItzHzn.getZtykaimasikikan());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyhikitugikaimasis(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhikitugikaimasis());
            pKsnKbkSsuRnduHknJigyohiTy.setZtymudkaimasisiharaikingaku(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtymudkaimasisiharaikingaku());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyszoukouryokukaisiymdx1(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyszoukouryokukaisiymdx1());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyszouhokensyuruikigoux1(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyszouhokensyuruikigoux1());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyszoukigousedaikbnx1(pHoyuuMeisaiTyukeiyouItzHzn
                .getZtyszoukigousedaikbnx1());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyszoukikanx1(pHoyuuMeisaiTyukeiyouItzHzn.getZtyszoukikanx1());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyszouhihokensyaagex1(pHoyuuMeisaiTyukeiyouItzHzn
                .getZtyszouhihokensyaagex1());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyszoudai2hihknsyaagex1(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyszoudai2hihknsyaagex1());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyzoukasx1(pHoyuuMeisaiTyukeiyouItzHzn.getZtyzoukasx1());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyzennendozoukasx1(pHoyuuMeisaiTyukeiyouItzHzn.getZtyzennendozoukasx1());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyszousiharaikingakux1(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyszousiharaikingakux1());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyszoukouryokukaisiymdx2(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyszoukouryokukaisiymdx2());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyszouhokensyuruikigoux2(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyszouhokensyuruikigoux2());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyszoukigousedaikbnx2(pHoyuuMeisaiTyukeiyouItzHzn
                .getZtyszoukigousedaikbnx2());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyszoukikanx2(pHoyuuMeisaiTyukeiyouItzHzn.getZtyszoukikanx2());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyszouhihokensyaagex2(pHoyuuMeisaiTyukeiyouItzHzn
                .getZtyszouhihokensyaagex2());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyszoudai2hihknsyaagex2(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyszoudai2hihknsyaagex2());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyzoukasx2(pHoyuuMeisaiTyukeiyouItzHzn.getZtyzoukasx2());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyzennendozoukasx2(pHoyuuMeisaiTyukeiyouItzHzn.getZtyzennendozoukasx2());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyszousiharaikingakux2(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyszousiharaikingakux2());
            pKsnKbkSsuRnduHknJigyohiTy.setZtysuuriyouyobin1x5(pHoyuuMeisaiTyukeiyouItzHzn.getZtysuuriyouyobin1x5());
            pKsnKbkSsuRnduHknJigyohiTy.setZtysuuriyouyobin1x6(pHoyuuMeisaiTyukeiyouItzHzn.getZtysuuriyouyobin1x6());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyhrimngkizktkykpmenhyj(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyhrimngkizktkykpmenhyj());
            pKsnKbkSsuRnduHknJigyohiTy.setZtymisyuustartym(pHoyuuMeisaiTyukeiyouItzHzn.getZtymisyuustartym());
            pKsnKbkSsuRnduHknJigyohiTy.setZtymisyuukaisuu(pHoyuuMeisaiTyukeiyouItzHzn.getZtymisyuukaisuu());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyitjbrtkykkousnuktkarhyj(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyitjbrtkykkousnuktkarhyj());
            pKsnKbkSsuRnduHknJigyohiTy.setZtygyousekihyoujis(pHoyuuMeisaiTyukeiyouItzHzn.getZtygyousekihyoujis());
            pKsnKbkSsuRnduHknJigyohiTy.setZtysykykgyusekihyjs(pHoyuuMeisaiTyukeiyouItzHzn.getZtysykykgyusekihyjs());
            pKsnKbkSsuRnduHknJigyohiTy.setZtytenkangyousekihyoujis(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtytenkangyousekihyoujis());
            pKsnKbkSsuRnduHknJigyohiTy.setZtytnknteikigyousekihyjs(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtytnknteikigyousekihyjs());
            pKsnKbkSsuRnduHknJigyohiTy.setZtytnkndpbbngyuskhyjs(pHoyuuMeisaiTyukeiyouItzHzn.getZtytnkndpbbngyuskhyjs());
            pKsnKbkSsuRnduHknJigyohiTy.setZtykykjyoutai(pHoyuuMeisaiTyukeiyouItzHzn.getZtykykjyoutai());
            pKsnKbkSsuRnduHknJigyohiTy.setZtypmenhukakbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtypmenhukakbn());
            pKsnKbkSsuRnduHknJigyohiTy.setZtykousinkbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtykousinkbn());
            pKsnKbkSsuRnduHknJigyohiTy.setZtymankiyoteikbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtymankiyoteikbn());
            pKsnKbkSsuRnduHknJigyohiTy.setZtysykyktikmnkyoteikbn(pHoyuuMeisaiTyukeiyouItzHzn
                .getZtysykyktikmnkyoteikbn());
            pKsnKbkSsuRnduHknJigyohiTy.setZtytnknsykykkhnmnkytikbn(pHoyuuMeisaiTyukeiyouItzHzn
                .getZtytnknsykykkhnmnkytikbn());
            pKsnKbkSsuRnduHknJigyohiTy.setZtytnknsykyktikmnkytikbn(pHoyuuMeisaiTyukeiyouItzHzn
                .getZtytnknsykyktikmnkytikbn());
            pKsnKbkSsuRnduHknJigyohiTy.setZtytenkanteikimankiyoteikbn(pHoyuuMeisaiTyukeiyouItzHzn
                .getZtytenkanteikimankiyoteikbn());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyszoumankiyoteikbnx1(pHoyuuMeisaiTyukeiyouItzHzn
                .getZtyszoumankiyoteikbnx1());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyszoumankiyoteikbnx2(pHoyuuMeisaiTyukeiyouItzHzn
                .getZtyszoumankiyoteikbnx2());
            pKsnKbkSsuRnduHknJigyohiTy
            .setZtyvestingmankiyoteikbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtyvestingmankiyoteikbn());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyvkeisanhyouji(pHoyuuMeisaiTyukeiyouItzHzn.getZtyvkeisanhyouji());
            pKsnKbkSsuRnduHknJigyohiTy.setZtytoukisinkeiyakuhyouji(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtytoukisinkeiyakuhyouji());
            pKsnKbkSsuRnduHknJigyohiTy.setZtysykykhokenhoutekiyouhyj(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtysykykhokenhoutekiyouhyj());
            pKsnKbkSsuRnduHknJigyohiTy.setZtytokuteijyoutaihushrhyj(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtytokuteijyoutaihushrhyj());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyytirrthndsysnmnskaisuu(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyytirrthndsysnmnskaisuu());
            pKsnKbkSsuRnduHknJigyohiTy.setZtysuuriyouyobin3(pHoyuuMeisaiTyukeiyouItzHzn.getZtysuuriyouyobin3());
            pKsnKbkSsuRnduHknJigyohiTy.setZtysuuriyouyobin11(pHoyuuMeisaiTyukeiyouItzHzn.getZtysuuriyouyobin11());
            pKsnKbkSsuRnduHknJigyohiTy.setZtywnasigoukeitenkankakaku(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtywnasigoukeitenkankakaku());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyyobin11(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobin11());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyyobin11x2(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobin11x2());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyyobin11x3(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobin11x3());
            pKsnKbkSsuRnduHknJigyohiTy.setZtytukibaraikansantokujyoup(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtytukibaraikansantokujyoup());
            pKsnKbkSsuRnduHknJigyohiTy.setZtytnkngkykkssnkijyuym(pHoyuuMeisaiTyukeiyouItzHzn
                .getZtytnkngkykkssnkijyuym());
            pKsnKbkSsuRnduHknJigyohiTy.setZtysaiteihosyouhyouji(pHoyuuMeisaiTyukeiyouItzHzn.getZtysaiteihosyouhyouji());
            pKsnKbkSsuRnduHknJigyohiTy.setZtysuuriyouyobin8x2(pHoyuuMeisaiTyukeiyouItzHzn.getZtysuuriyouyobin8x2());
            pKsnKbkSsuRnduHknJigyohiTy.setZtysuuriyouyobin14(pHoyuuMeisaiTyukeiyouItzHzn.getZtysuuriyouyobin14());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyhrimngtkykphrkkaisuukbn(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyhrimngtkykphrkkaisuukbn());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyhrimngtkykphrkkirkbn(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyhrimngtkykphrkkirkbn());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyhrimngtkykpryurtkbn(pHoyuuMeisaiTyukeiyouItzHzn
                .getZtyhrimngtkykpryurtkbn());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyyobiv13(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobiv13());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyidoujisaiteihosyoukngk(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyidoujisaiteihosyoukngk());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyidoujisaiteihosyoucost(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyidoujisaiteihosyoucost());
            pKsnKbkSsuRnduHknJigyohiTy.setZtysinhokenfundtumitatekin(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtysinhokenfundtumitatekin());
            pKsnKbkSsuRnduHknJigyohiTy.setZtymsyuptusshkgkaiykhnrikn(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtymsyuptusshkgkaiykhnrikn());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyrrthndugtnkgetumatuv(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyrrthndugtnkgetumatuv());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyrrthndnksaiteihosyonkgns(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyrrthndnksaiteihosyonkgns());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyrrthendougatanksibous(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyrrthendougatanksibous());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyalmyousohutomeisyoukbn(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyalmyousohutomeisyoukbn());
            pKsnKbkSsuRnduHknJigyohiTy.setZtysnkyksoftmeisyoukbn(pHoyuuMeisaiTyukeiyouItzHzn
                .getZtysnkyksoftmeisyoukbn());
            pKsnKbkSsuRnduHknJigyohiTy.setZtysoftmeisyoukbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtysoftmeisyoukbn());
            pKsnKbkSsuRnduHknJigyohiTy.setZtykykjitokujyouarihyj(pHoyuuMeisaiTyukeiyouItzHzn
                .getZtykykjitokujyouarihyj());
            pKsnKbkSsuRnduHknJigyohiTy.setZtybnkttnknkbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtybnkttnknkbn());
            pKsnKbkSsuRnduHknJigyohiTy.setZtytenkanminaosikbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtytenkanminaosikbn());
            pKsnKbkSsuRnduHknJigyohiTy.setZtysoujikeitenkankbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtysoujikeitenkankbn());
            pKsnKbkSsuRnduHknJigyohiTy.setZtynenkinkaisinendo(pHoyuuMeisaiTyukeiyouItzHzn.getZtynenkinkaisinendo());
            pKsnKbkSsuRnduHknJigyohiTy.setZtynenkingatakbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtynenkingatakbn());
            pKsnKbkSsuRnduHknJigyohiTy.setZtynknshry(pHoyuuMeisaiTyukeiyouItzHzn.getZtynknshry());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyheiyoubaraikeiyakukbn(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyheiyoubaraikeiyakukbn());
            pKsnKbkSsuRnduHknJigyohiTy.setZtynenkinmaruteihukakbn(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtynenkinmaruteihukakbn());
            pKsnKbkSsuRnduHknJigyohiTy.setZtysinseizonmrtiarihyj(pHoyuuMeisaiTyukeiyouItzHzn
                .getZtysinseizonmrtiarihyj());
            pKsnKbkSsuRnduHknJigyohiTy.setZtysnkykyouibokijyukbn(pHoyuuMeisaiTyukeiyouItzHzn
                .getZtysnkykyouibokijyukbn());
            pKsnKbkSsuRnduHknJigyohiTy.setZtytokusitujyuusitusetkbn(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtytokusitujyuusitusetkbn());
            pKsnKbkSsuRnduHknJigyohiTy.setZtysiktsyuknbyugnhsyunshyj(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtysiktsyuknbyugnhsyunshyj());
            pKsnKbkSsuRnduHknJigyohiTy.setZtypmensugugtganhsyunshyj(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtypmensugugtganhsyunshyj());
            pKsnKbkSsuRnduHknJigyohiTy.setZtytkykgyousekihyjszerohyj(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtytkykgyousekihyjszerohyj());
            pKsnKbkSsuRnduHknJigyohiTy.setZtysuuriyouyobin7(pHoyuuMeisaiTyukeiyouItzHzn.getZtysuuriyouyobin7());
            pKsnKbkSsuRnduHknJigyohiTy.setZtysyussaikeitaikbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtysyussaikeitaikbn());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyyobiv6(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobiv6());
            pKsnKbkSsuRnduHknJigyohiTy.setZtybosyuukeitaikbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtybosyuukeitaikbn());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyaatukaisosikicd(pHoyuuMeisaiTyukeiyouItzHzn.getZtyaatukaisosikicd());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyaatukaikojincd(pHoyuuMeisaiTyukeiyouItzHzn.getZtyaatukaikojincd());
            pKsnKbkSsuRnduHknJigyohiTy.setZtybsydrtencd(pHoyuuMeisaiTyukeiyouItzHzn.getZtybsydrtencd());
            pKsnKbkSsuRnduHknJigyohiTy.setZtycifcd(pHoyuuMeisaiTyukeiyouItzHzn.getZtycifcd());
            pKsnKbkSsuRnduHknJigyohiTy.setZtysuuriyouyobiv8(pHoyuuMeisaiTyukeiyouItzHzn.getZtysuuriyouyobiv8());
            pKsnKbkSsuRnduHknJigyohiTy.setZtysinsakbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtysinsakbn());
            pKsnKbkSsuRnduHknJigyohiTy.setZtydai2hihokensyasinsakbn(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtydai2hihokensyasinsakbn());
            pKsnKbkSsuRnduHknJigyohiTy.setZtytoukeiyousinsakbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtytoukeiyousinsakbn());
            pKsnKbkSsuRnduHknJigyohiTy.setZtydai2toukeiyousinsakbn(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtydai2toukeiyousinsakbn());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyketteikijyunkanwakbn(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyketteikijyunkanwakbn());
            pKsnKbkSsuRnduHknJigyohiTy.setZtykihonsibouhyoukbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtykihonsibouhyoukbn());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyteikisibouhyoukbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtyteikisibouhyoukbn());
            pKsnKbkSsuRnduHknJigyohiTy.setZtysonotasibouhyoukbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtysonotasibouhyoukbn());
            pKsnKbkSsuRnduHknJigyohiTy.setZtymrarihyj(pHoyuuMeisaiTyukeiyouItzHzn.getZtymrarihyj());
            pKsnKbkSsuRnduHknJigyohiTy.setZtysentakujyouhouarihyouji(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtysentakujyouhouarihyouji());
            pKsnKbkSsuRnduHknJigyohiTy.setZtydugktnknsntkhuhukbn(pHoyuuMeisaiTyukeiyouItzHzn
                .getZtydugktnknsntkhuhukbn());
            pKsnKbkSsuRnduHknJigyohiTy.setZtygengakutenkankykhyj(pHoyuuMeisaiTyukeiyouItzHzn
                .getZtygengakutenkankykhyj());
            pKsnKbkSsuRnduHknJigyohiTy.setZtysykgycd(pHoyuuMeisaiTyukeiyouItzHzn.getZtysykgycd());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyjidoukousinkykkanyuuymd(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyjidoukousinkykkanyuuymd());
            pKsnKbkSsuRnduHknJigyohiTy.setZtysaikohtnknkykkykymd(pHoyuuMeisaiTyukeiyouItzHzn
                .getZtysaikohtnknkykkykymd());
            pKsnKbkSsuRnduHknJigyohiTy.setZtykousinmaesykyksburtkbn(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtykousinmaesykyksburtkbn());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyhjnkykhyj(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhjnkykhyj());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyanniskcd(pHoyuuMeisaiTyukeiyouItzHzn.getZtyanniskcd());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyhjncd(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhjncd());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyhjnjigyosyocd(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhjnjigyosyocd());
            pKsnKbkSsuRnduHknJigyohiTy.setZtysaihokenno(pHoyuuMeisaiTyukeiyouItzHzn.getZtysaihokenno());
            pKsnKbkSsuRnduHknJigyohiTy.setZtydakuhikettikekkacd(pHoyuuMeisaiTyukeiyouItzHzn.getZtydakuhikettikekkacd());
            pKsnKbkSsuRnduHknJigyohiTy.setZtydai2dakuhiketteikekkacd(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtydai2dakuhiketteikekkacd());
            pKsnKbkSsuRnduHknJigyohiTy.setZtypmenkbnv2(pHoyuuMeisaiTyukeiyouItzHzn.getZtypmenkbnv2());
            pKsnKbkSsuRnduHknJigyohiTy.setZtysiboukyuuhukin(pHoyuuMeisaiTyukeiyouItzHzn.getZtysiboukyuuhukin());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyjyudthumeharaitkykhkhyj(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyjyudthumeharaitkykhkhyj());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyhaitoukbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhaitoukbn());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyhhknnentysihyj(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhhknnentysihyj());
            pKsnKbkSsuRnduHknJigyohiTy.setZtydai2hhknnentysihyj(pHoyuuMeisaiTyukeiyouItzHzn.getZtydai2hhknnentysihyj());
            pKsnKbkSsuRnduHknJigyohiTy.setZtykyksyaagetyouseihyj(pHoyuuMeisaiTyukeiyouItzHzn
                .getZtykyksyaagetyouseihyj());
            pKsnKbkSsuRnduHknJigyohiTy.setZtykituenkbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtykituenkbn());
            pKsnKbkSsuRnduHknJigyohiTy.setZtykituenhonsuu(pHoyuuMeisaiTyukeiyouItzHzn.getZtykituenhonsuu());
            pKsnKbkSsuRnduHknJigyohiTy.setZtymusentakukeiyakukbn(pHoyuuMeisaiTyukeiyouItzHzn
                .getZtymusentakukeiyakukbn());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyyobiv6x2(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobiv6x2());
            pKsnKbkSsuRnduHknJigyohiTy.setZtylivingneedstkykarihyj(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtylivingneedstkykarihyj());
            pKsnKbkSsuRnduHknJigyohiTy.setZtylivingneedssiharaihyouji(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtylivingneedssiharaihyouji());
            pKsnKbkSsuRnduHknJigyohiTy.setZtylnseikyuuymd(pHoyuuMeisaiTyukeiyouItzHzn.getZtylnseikyuuymd());
            pKsnKbkSsuRnduHknJigyohiTy.setZtylnshrgenincd(pHoyuuMeisaiTyukeiyouItzHzn.getZtylnshrgenincd());
            pKsnKbkSsuRnduHknJigyohiTy.setZtydakuhikettisyacd(pHoyuuMeisaiTyukeiyouItzHzn.getZtydakuhikettisyacd());
            pKsnKbkSsuRnduHknJigyohiTy.setZtydai2dakuhiketteisyacd(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtydai2dakuhiketteisyacd());
            pKsnKbkSsuRnduHknJigyohiTy.setZtygansapotokuyakuarihyouji(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtygansapotokuyakuarihyouji());
            pKsnKbkSsuRnduHknJigyohiTy.setZtygnspshrhyj(pHoyuuMeisaiTyukeiyouItzHzn.getZtygnspshrhyj());
            pKsnKbkSsuRnduHknJigyohiTy.setZtygansaposeikyuuymd(pHoyuuMeisaiTyukeiyouItzHzn.getZtygansaposeikyuuymd());
            pKsnKbkSsuRnduHknJigyohiTy.setZtygnspshrgenincd(pHoyuuMeisaiTyukeiyouItzHzn.getZtygnspshrgenincd());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyyobiv3x2(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobiv3x2());
            pKsnKbkSsuRnduHknJigyohiTy.setZtytargetmokuhyouritu(pHoyuuMeisaiTyukeiyouItzHzn.getZtytargetmokuhyouritu());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyautoswitchmokuhyouritu(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyautoswitchmokuhyouritu());
            pKsnKbkSsuRnduHknJigyohiTy.setZtytumitatekinitenarihyj(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtytumitatekinitenarihyj());
            pKsnKbkSsuRnduHknJigyohiTy.setZtytumitatekinitenkaisuu(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtytumitatekinitenkaisuu());
            pKsnKbkSsuRnduHknJigyohiTy.setZtydatakanrino2(pHoyuuMeisaiTyukeiyouItzHzn.getZtydatakanrino2());
            pKsnKbkSsuRnduHknJigyohiTy.setZtydatakanrino3(pHoyuuMeisaiTyukeiyouItzHzn.getZtydatakanrino3());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyknkuzusnzyrttekinendo(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyknkuzusnzyrttekinendo());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyknkuzusnzyrt(pHoyuuMeisaiTyukeiyouItzHzn.getZtyknkuzusnzyrt());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyknkuzusnzyrtx2(pHoyuuMeisaiTyukeiyouItzHzn.getZtyknkuzusnzyrtx2());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyknkuzusnzyrtx3(pHoyuuMeisaiTyukeiyouItzHzn.getZtyknkuzusnzyrtx3());
            pKsnKbkSsuRnduHknJigyohiTy.setZtysinkeiyakujiknkuzusnzyrt(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtysinkeiyakujiknkuzusnzyrt());
            pKsnKbkSsuRnduHknJigyohiTy.setZtytenkanjiknkuzusnzyrt(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtytenkanjiknkuzusnzyrt());
            pKsnKbkSsuRnduHknJigyohiTy.setZtysinkeiyakujivithkhyouji(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtysinkeiyakujivithkhyouji());
            pKsnKbkSsuRnduHknJigyohiTy.setZtykykjivithukusuukykhyj(pHoyuuMeisaiTyukeiyouItzHzn.getZtykykjivithukusuukykhyj());
            pKsnKbkSsuRnduHknJigyohiTy.setZtysuuriyouyobin9x2(pHoyuuMeisaiTyukeiyouItzHzn.getZtysuuriyouyobin9x2());
            pKsnKbkSsuRnduHknJigyohiTy.setZtypwrbksidhitekiyouhyj(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtypwrbksidhitekiyouhyj());
            pKsnKbkSsuRnduHknJigyohiTy.setZtysuuriyouyobin9(pHoyuuMeisaiTyukeiyouItzHzn.getZtysuuriyouyobin9());
            pKsnKbkSsuRnduHknJigyohiTy.setZtysuuriyouyobin10x7(pHoyuuMeisaiTyukeiyouItzHzn.getZtysuuriyouyobin10x7());
            pKsnKbkSsuRnduHknJigyohiTy.setZtysuuriyouyobin10x8(pHoyuuMeisaiTyukeiyouItzHzn.getZtysuuriyouyobin10x8());
            pKsnKbkSsuRnduHknJigyohiTy.setZtysuuriyouyobin10x9(pHoyuuMeisaiTyukeiyouItzHzn.getZtysuuriyouyobin10x9());
            pKsnKbkSsuRnduHknJigyohiTy.setZtytumitatekinitenbubun(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtytumitatekinitenbubun());
            pKsnKbkSsuRnduHknJigyohiTy.setZtysagakusknnjynbknzndk(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtysagakusknnjynbknzndk());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyyobin11x5(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobin11x5());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyyobin11x6(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobin11x6());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyyobin11x7(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobin11x7());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyyobin11x8(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobin11x8());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyyobin11x9(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobin11x9());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyyobin11x10(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobin11x10());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyyobin11x11(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobin11x11());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyyobin11x12(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobin11x12());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyyobin11x13(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobin11x13());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyyobin11x14(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobin11x14());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyyobin11x15(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobin11x15());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyyobin11x16(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobin11x16());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyyobin11x17(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobin11x17());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyzyrthntiyustatuskbn(pHoyuuMeisaiTyukeiyouItzHzn
                .getZtyzyrthntiyustatuskbn());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyzyrthntiyustatuskbnx2(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyzyrthntiyustatuskbnx2());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyzyrthntiyustatuskbnx3(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyzyrthntiyustatuskbnx3());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyzyrthntiyustatuskbnx4(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyzyrthntiyustatuskbnx4());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyzyrthntiyustatuskbnx5(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyzyrthntiyustatuskbnx5());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyyobiv10(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobiv10());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyyobiv15x2(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobiv15x2());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyyobiv15x3(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobiv15x3());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyyobiv15x4(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobiv15x4());
            pKsnKbkSsuRnduHknJigyohiTy.setZtygaikakbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtygaikakbn());
            pKsnKbkSsuRnduHknJigyohiTy.setZtykawaserate1(pHoyuuMeisaiTyukeiyouItzHzn.getZtykawaserate1());
            pKsnKbkSsuRnduHknJigyohiTy.setZtykawaseratetekiyouymd1(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtykawaseratetekiyouymd1());
            pKsnKbkSsuRnduHknJigyohiTy.setZtykawaserate2(pHoyuuMeisaiTyukeiyouItzHzn.getZtykawaserate2());
            pKsnKbkSsuRnduHknJigyohiTy.setZtykawaseratetekiyouymd2(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtykawaseratetekiyouymd2());
            pKsnKbkSsuRnduHknJigyohiTy.setZtykykjikawaserate(pHoyuuMeisaiTyukeiyouItzHzn.getZtykykjikawaserate());
            pKsnKbkSsuRnduHknJigyohiTy.setZtykykjikawaseratetkyuymd(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtykykjikawaseratetkyuymd());
            pKsnKbkSsuRnduHknJigyohiTy.setZtymvatyouseigow(pHoyuuMeisaiTyukeiyouItzHzn.getZtymvatyouseigow());
            pKsnKbkSsuRnduHknJigyohiTy.setZtymvakeisanjisknnjynbkn(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtymvakeisanjisknnjynbkn());
            pKsnKbkSsuRnduHknJigyohiTy.setZtykaiyakukoujyoritu(pHoyuuMeisaiTyukeiyouItzHzn.getZtykaiyakukoujyoritu());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyrendouritu(pHoyuuMeisaiTyukeiyouItzHzn.getZtyrendouritu());
            pKsnKbkSsuRnduHknJigyohiTy.setZtysrkaiyakusjkkktyouseirrt(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtysrkaiyakusjkkktyouseirrt());
            pKsnKbkSsuRnduHknJigyohiTy.setZtysrkyksjkkktyouseiriritu(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtysrkyksjkkktyouseiriritu());
            pKsnKbkSsuRnduHknJigyohiTy.setZtymvakeisankijyunymd(pHoyuuMeisaiTyukeiyouItzHzn.getZtymvakeisankijyunymd());
            pKsnKbkSsuRnduHknJigyohiTy.setZtymvatyouseikou(pHoyuuMeisaiTyukeiyouItzHzn.getZtymvatyouseikou());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyenkdtsbujsitihsyukngk(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyenkdtsbujsitihsyukngk());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyenkdtsbujsitihsyucost(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyenkdtsbujsitihsyucost());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyenkdtsbujsitihsyuarihyj(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyenkdtsbujsitihsyuarihyj());
            pKsnKbkSsuRnduHknJigyohiTy.setZtykeiyakujiyoteiriritu(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtykeiyakujiyoteiriritu());
            pKsnKbkSsuRnduHknJigyohiTy.setZtytumitateriritu(pHoyuuMeisaiTyukeiyouItzHzn.getZtytumitateriritu());
            pKsnKbkSsuRnduHknJigyohiTy.setZtykaigomaebaraitkykarihyj(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtykaigomaebaraitkykarihyj());
            pKsnKbkSsuRnduHknJigyohiTy.setZtysibouhyoukbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtysibouhyoukbn());
            pKsnKbkSsuRnduHknJigyohiTy.setZtynyuukintuukakbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtynyuukintuukakbn());
            pKsnKbkSsuRnduHknJigyohiTy.setZtysiharaituukakbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtysiharaituukakbn());
            pKsnKbkSsuRnduHknJigyohiTy.setZtywyendttargetmokuhyouritu(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtywyendttargetmokuhyouritu());
            pKsnKbkSsuRnduHknJigyohiTy.setZtysisuurendourate(pHoyuuMeisaiTyukeiyouItzHzn.getZtysisuurendourate());
            pKsnKbkSsuRnduHknJigyohiTy.setZtysisuukbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtysisuukbn());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyteirituikouhyouji(pHoyuuMeisaiTyukeiyouItzHzn.getZtyteirituikouhyouji());
            pKsnKbkSsuRnduHknJigyohiTy.setZtysuuriyouyobin10x11(pHoyuuMeisaiTyukeiyouItzHzn.getZtysuuriyouyobin10x11());
            pKsnKbkSsuRnduHknJigyohiTy.setZtytmttknzoukaritujygn(pHoyuuMeisaiTyukeiyouItzHzn
                .getZtytmttknzoukaritujygn());
            pKsnKbkSsuRnduHknJigyohiTy.setZtysetteibairitu(pHoyuuMeisaiTyukeiyouItzHzn.getZtysetteibairitu());
            pKsnKbkSsuRnduHknJigyohiTy.setZtytykzenoutouymdsisuu(pHoyuuMeisaiTyukeiyouItzHzn
                .getZtytykzenoutouymdsisuu());
            pKsnKbkSsuRnduHknJigyohiTy.setZtykimatusisuu(pHoyuuMeisaiTyukeiyouItzHzn.getZtykimatusisuu());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyyenkadatekihons(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyenkadatekihons());
            pKsnKbkSsuRnduHknJigyohiTy.setZtysitihsyumegkdtsibous(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtysitihsyumegkdtsibous());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyenkdtssrentumitatekin(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyenkdtssrentumitatekin());
            pKsnKbkSsuRnduHknJigyohiTy.setZtysisuurentumitatekin(pHoyuuMeisaiTyukeiyouItzHzn
                .getZtysisuurentumitatekin());
            pKsnKbkSsuRnduHknJigyohiTy.setZtynksjitirttumitatekin(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtynksjitirttumitatekin());
            pKsnKbkSsuRnduHknJigyohiTy.setZtykimatutirttumitatekin(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtykimatutirttumitatekin());
            pKsnKbkSsuRnduHknJigyohiTy.setZtygaikadatejyuutoup(pHoyuuMeisaiTyukeiyouItzHzn.getZtygaikadatejyuutoup());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyyendttargetkijyunkingaku(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtyyendttargetkijyunkingaku());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyyobiv7(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobiv7());
            pKsnKbkSsuRnduHknJigyohiTy.setZtysitivkisnyukykjikwsrate(pHoyuuMeisaiTyukeiyouItzHzn.
                getZtysitivkisnyukykjikwsrate());
            pKsnKbkSsuRnduHknJigyohiTy.setZtysisuurentyokugotmttkn(pHoyuuMeisaiTyukeiyouItzHzn.getZtysisuurentyokugotmttkn());
        }
    }

    private void editKbkSsuRnduHknJigyohi(SrKbkSsuRnduHknJigyohiBatchParam pSrKbkSsuRnduHknJigyohiBatchParam,
        C_KessanKbn pKessanKbn,
        int pRegetuEditTaisyou,
        ST_HoyuuMeisaiTyukeiyouItzHzn pHoyuuMeisaiTyukeiyouItzHzn,
        TkJitenKeiyakuSyouhinKijyunBean pTkJitenKeiyakuSyouhinKijyunBean,
        ZT_KbkSsuRnduHknJigyohiTy pKbkSsuRnduHknJigyohiTy,
        ZT_KsnKbkSsuRnduHknJigyohiTy pKsnKbkSsuRnduHknJigyohiTy,
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

        if (pRegetuEditTaisyou == SrCommonConstants.DEFAULT_INT_ZERO) {
            loadingKeijyoYm = pSrKbkSsuRnduHknJigyohiBatchParam.getKijyunymd().getBizDateYM();
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

        SrKbkSsuRnduHknJigyohiBatchDbAccess srKbkSsuRnduHknJigyohiBatchDbAccess = SWAKInjector
            .getInstance(SrKbkSsuRnduHknJigyohiBatchDbAccess.class);
        List<SrGetTokutejitenTmttknInfoBean> srGetTokutejitenTmttknInfoBeanList = Lists.newArrayList();

        List<SV_KiykSyuhnData> tumimasimaewKiykSyuhnDataLst =
            srKbkSsuRnduHknJigyohiBatchDbAccess.getKiykSyuhnDatas(
                pHoyuuMeisaiTyukeiyouItzHzn.getZtydatakanrino(), C_SyutkKbn.SYU);

        if (BizDateUtil.compareYmd(pSrKbkSsuRnduHknJigyohiBatchParam.getKijyunymd(),
            pTkJitenKeiyakuSyouhinKijyunBean.getKykymd()) == BizDateUtil.COMPARE_LESSER
            || pRegetuEditTaisyou != SrCommonConstants.DEFAULT_INT_ZERO) {

            List<IT_KhSisuurendoTmttkn> khSisuurendoTmttknLst = srKbkSsuRnduHknJigyohiBatchDbAccess
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
            else if (pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() != null) {
                vhireilKisnyukngkTeiritu = BizCurrency.valueOf(0);
                vhireilKisnyukngkSisuu = BizCurrency.valueOf(0);
                rpKeisanyouSibous = BizCurrency.valueOf(0);

                String message = MessageUtil.getMessage(MessageId.ESA1001,
                    "円建変更取消：Ｖ比例Ｌ計算用金額、ＲＰ計算用死亡Ｓ",
                    pHoyuuMeisaiTyukeiyouItzHzn.getZtydatakanrino());

                batchLogger.warn(message);

                ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

                suuriyouErrJyouhou.setSyoriYmd(pSrKbkSsuRnduHknJigyohiBatchParam.getSyoriYmd());
                suuriyouErrJyouhou.setKakutyoujobcd(pSrKbkSsuRnduHknJigyohiBatchParam.getIbKakutyoujobcd());
                suuriyouErrJyouhou.setSyono(pHoyuuMeisaiTyukeiyouItzHzn.getZtydatakanrino());
                suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(message);
                suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

                ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

                pSrKbkSsuRnduHknJigyohiBatchParam.setKeikokuSyoriCount(pSrKbkSsuRnduHknJigyohiBatchParam
                    .getKeikokuSyoriCount() + 1);

            }
            else{
                BizDate calckijyunYmd = BizDate.valueOf(loadingKeijyoYm,
                    pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getDay()).getRekijyou();

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


                BizDateYM kaiyakuhrKisnKijyunYM = keisanWKijunYM.exec(pTkJitenKeiyakuSyouhinKijyunBean.getKykymd(),
                    calckijyunYmd, null, null, pTkJitenKeiyakuSyouhinKijyunBean.getKykjyoutai(),
                    pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd(), pTkJitenKeiyakuSyouhinKijyunBean.
                    getYendthnkymd());

                if (pTkJitenKeiyakuSyouhinKijyunBean_gmjiten.getYendthnkymd() == null &&
                    (BizDateUtil.calcDifferenceMonths(kaiyakuhrKisnKijyunYM,
                        khSisuurendoTmttkn.getTmttkntaisyouym()) > SrCommonConstants.KIKAN_12M)) {

                    int keikamon = BizDateUtil.calcDifferenceMonths(
                        kaiyakuhrKisnKijyunYM,
                        khSisuurendoTmttkn.getTmttkntaisyouym());

                    int keikanensuu = keikamon / SrCommonConstants.KIKAN_12M;

                    tmttkntaisyouym = khSisuurendoTmttkn.getTmttkntaisyouym().addYears(keikanensuu);

                    KeisanSisuuRendouNkTmttknOverNnd keisanSisuuRendouNkTmttknOverNnd =
                        SWAKInjector.getInstance(KeisanSisuuRendouNkTmttknOverNnd.class);
                    C_ErrorKbn errorKbn = keisanSisuuRendouNkTmttknOverNnd.exec(
                        pTkJitenKeiyakuSyouhinKijyunBean.getKykymd(),
                        pTkJitenKeiyakuSyouhinKijyunBean.getHknkkn(),
                        C_UmuKbn.valueOf(pHoyuuMeisaiTyukeiyouItzHzn.getZtysrteikishrtkykhukaumu()),
                        pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu(),
                        BizDate.valueOf(tmttkntaisyouym, pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getDay()).getRekijyou(),
                        tmttkntaisyouym,
                        khSisuurendoTmttkn.getTmttkntaisyouym(),
                        pTkJitenKeiyakuSyouhinKijyunBean.getTumitateriritu(),
                        khSisuurendoTmttkn.getTeiritutmttkngk(),
                        khSisuurendoTmttkn.getSisuurendoutmttkngk());

                    if (errorKbn.eq(C_ErrorKbn.ERROR)) {
                        String message = MessageUtil.getMessage(MessageId.ESA1001,
                            "積立金計算：Ｖ比例Ｌ計算用金額、ＲＰ計算用死亡Ｓ",
                            pHoyuuMeisaiTyukeiyouItzHzn.getZtydatakanrino());

                        batchLogger.warn(message);

                        ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

                        suuriyouErrJyouhou.setSyoriYmd(pSrKbkSsuRnduHknJigyohiBatchParam.getSyoriYmd());
                        suuriyouErrJyouhou.setKakutyoujobcd(pSrKbkSsuRnduHknJigyohiBatchParam.getIbKakutyoujobcd());
                        suuriyouErrJyouhou.setSyono(pHoyuuMeisaiTyukeiyouItzHzn.getZtydatakanrino());
                        suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(message);
                        suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

                        ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

                        pSrKbkSsuRnduHknJigyohiBatchParam.setZokkouErrorSyoriCount(pSrKbkSsuRnduHknJigyohiBatchParam
                            .getZokkouErrorSyoriCount() + 1);

                        errorFlag = true;
                    }
                    else {

                        teirituTmttkngk = keisanSisuuRendouNkTmttknOverNnd.getTeiritutmttkngk();
                        sisuuTmttkngk = keisanSisuuRendouNkTmttknOverNnd.getSisuurendoutmttkngk();
                        tumitateriritu = pTkJitenKeiyakuSyouhinKijyunBean.getTumitateriritu();
                    }
                }

                else {

                    tmttkntaisyouym = khSisuurendoTmttkn.getTmttkntaisyouym();
                    teirituTmttkngk = khSisuurendoTmttkn.getTeiritutmttkngk();
                    sisuuTmttkngk = khSisuurendoTmttkn.getSisuurendoutmttkngk();
                    tumitateriritu = pTkJitenKeiyakuSyouhinKijyunBean.getTumitateriritu();
                }

                if (pTkJitenKeiyakuSyouhinKijyunBean_gmjiten.getYendthnkymd() == null) {
                    getSjkkktyouseiyourirituBean.setSyouhncd(pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd());
                    getSjkkktyouseiyourirituBean.setKijyunymd(calckijyunYmd);
                    getSjkkktyouseiyourirituBean.setHknkkn(pTkJitenKeiyakuSyouhinKijyunBean.getHknkkn());
                    getSjkkktyouseiyourirituBean.setHknkknsmnkbn(pTkJitenKeiyakuSyouhinKijyunBean.getHknkknsmnKbn());
                    getSjkkktyouseiyourirituBean.setHhknnen(pTkJitenKeiyakuSyouhinKijyunBean.getHhknnen());

                    C_ErrorKbn errorKbn = getSjkkktyouseiyouriritu.exec(getSjkkktyouseiyourirituBean);

                    if (errorKbn.eq(C_ErrorKbn.ERROR)) {
                        String message = MessageUtil.getMessage(MessageId.ESA1001, "市場価格調整用利率",
                            pHoyuuMeisaiTyukeiyouItzHzn.getZtydatakanrino());

                        batchLogger.warn(message);

                        ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

                        suuriyouErrJyouhou.setSyoriYmd(pSrKbkSsuRnduHknJigyohiBatchParam.getSyoriYmd());
                        suuriyouErrJyouhou.setKakutyoujobcd(pSrKbkSsuRnduHknJigyohiBatchParam.getIbKakutyoujobcd());
                        suuriyouErrJyouhou.setSyono(pHoyuuMeisaiTyukeiyouItzHzn.getZtydatakanrino());
                        suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(message);
                        suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

                        ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

                        pSrKbkSsuRnduHknJigyohiBatchParam.setZokkouErrorSyoriCount(pSrKbkSsuRnduHknJigyohiBatchParam
                            .getZokkouErrorSyoriCount() + 1);

                        errorFlag = true;
                    }
                    else {
                        kaiyakuSjkkktyouseiriritu = getSjkkktyouseiyouriritu.getSjkkktyouseiyouriritu();
                    }
                }

                keisanWExtBean.setSyouhncd(pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd());
                keisanWExtBean.setSyouhnsdno(pTkJitenKeiyakuSyouhinKijyunBean.getSyouhnsdno());
                keisanWExtBean.setRyouritusdno(pTkJitenKeiyakuSyouhinKijyunBean.getRyouritusdno());
                keisanWExtBean.setYoteiriritu(pTkJitenKeiyakuSyouhinKijyunBean.getYoteiriritu());
                keisanWExtBean.setHrkkaisuu(C_Hrkkaisuu.ITIJI);
                keisanWExtBean.setHknkknsmnkbn(pTkJitenKeiyakuSyouhinKijyunBean.getHknkknsmnKbn());
                keisanWExtBean.setHknkkn(pTkJitenKeiyakuSyouhinKijyunBean.getHknkkn());
                keisanWExtBean.setHrkkkn(pTkJitenKeiyakuSyouhinKijyunBean.getHrkkkn());
                keisanWExtBean.setHhknnen(pTkJitenKeiyakuSyouhinKijyunBean.getHhknnen());
                keisanWExtBean.setHhknsei(pTkJitenKeiyakuSyouhinKijyunBean.getHhknsei());
                keisanWExtBean.setKihons(pTkJitenKeiyakuSyouhinKijyunBean.getKihons());
                keisanWExtBean.setHokenryou(pTkJitenKeiyakuSyouhinKijyunBean.getHokenryou());
                keisanWExtBean.setKykymd(pTkJitenKeiyakuSyouhinKijyunBean.getKykymd());
                keisanWExtBean.setTuukasyu(pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu());
                keisanWExtBean.setKyksjkkktyouseiriritu(pTkJitenKeiyakuSyouhinKijyunBean.getKyksjkkktyouseiriritu());
                keisanWExtBean.setKaiyakusjkkktyouseiriritu(kaiyakuSjkkktyouseiriritu);
                keisanWExtBean.setTmttkntaisyouym(tmttkntaisyouym);
                keisanWExtBean.setTeiritutmttkngk(teirituTmttkngk);
                keisanWExtBean.setSisuurendoutmttkngk(sisuuTmttkngk);
                keisanWExtBean.setTumitateriritu(tumitateriritu);
                keisanWExtBean.setYendthnkymd(pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd());
                keisanWExtBean.setTeikishrtkykhukaumu(C_UmuKbn.valueOf(pHoyuuMeisaiTyukeiyouItzHzn.getZtysrteikishrtkykhukaumu()));

                C_ErrorKbn resultKbn = keisanW.exec(calckijyunYmd, kaiyakuhrKisnKijyunYM, keisanWExtBean);

                if (resultKbn.eq(C_ErrorKbn.ERROR)) {

                    String message = MessageUtil.getMessage(MessageId.ESA1001, "解約返戻金",
                        pHoyuuMeisaiTyukeiyouItzHzn.getZtydatakanrino());

                    batchLogger.warn(message);

                    ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

                    suuriyouErrJyouhou.setSyoriYmd(pSrKbkSsuRnduHknJigyohiBatchParam.getSyoriYmd());
                    suuriyouErrJyouhou.setKakutyoujobcd(pSrKbkSsuRnduHknJigyohiBatchParam.getIbKakutyoujobcd());
                    suuriyouErrJyouhou.setSyono(pHoyuuMeisaiTyukeiyouItzHzn.getZtydatakanrino());
                    suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(message);
                    suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

                    ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

                    pSrKbkSsuRnduHknJigyohiBatchParam.setZokkouErrorSyoriCount(pSrKbkSsuRnduHknJigyohiBatchParam
                        .getZokkouErrorSyoriCount() + 1);

                    errorFlag = true;
                }
                else {
                    vhireilKisnyukngkTeiritu = keisanW.getTeirituTmttkngk();
                    vhireilKisnyukngkSisuu = keisanW.getSisuurendouTmttkngk();

                    if ((BizDateUtil.compareYm(loadingKeijyoYm, pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getBizDateYM()) ==
                        BizDateUtil.COMPARE_GREATER) &&
                        loadingKeijyoYm.getMonth() == pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getMonth() &&
                        pTkJitenKeiyakuSyouhinKijyunBean_gmjiten.getYendthnkymd() == null &&
                        pTkJitenKeiyakuSyouhinKijyunBean_gmjiten.getTmttknitenYmd() == null &&
                        pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getDay() == SrCommonConstants.DAY_16D  &&
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

                if (pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() != null) {
                    String message = MessageUtil.getMessage(MessageId.ESA1001,
                        "円建変更取消：積増前Ｗ",
                        pHoyuuMeisaiTyukeiyouItzHzn.getZtydatakanrino());

                    batchLogger.warn(message);

                    ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

                    suuriyouErrJyouhou.setSyoriYmd(pSrKbkSsuRnduHknJigyohiBatchParam.getSyoriYmd());
                    suuriyouErrJyouhou.setKakutyoujobcd(pSrKbkSsuRnduHknJigyohiBatchParam.getIbKakutyoujobcd());
                    suuriyouErrJyouhou.setSyono(pHoyuuMeisaiTyukeiyouItzHzn.getZtydatakanrino());
                    suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(message);
                    suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

                    ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

                    pSrKbkSsuRnduHknJigyohiBatchParam.setKeikokuSyoriCount(pSrKbkSsuRnduHknJigyohiBatchParam
                        .getKeikokuSyoriCount() + 1);

                }
                else{

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
                            pTkJitenKeiyakuSyouhinKijyunBean.getKykymd(),
                            loadingKeijyoYmPreLasDay,
                            null,
                            null,
                            pTkJitenKeiyakuSyouhinKijyunBean.getKykjyoutai(),
                            pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd(),
                            pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd());

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

                                suuriyouErrJyouhou.setSyoriYmd(pSrKbkSsuRnduHknJigyohiBatchParam.getSyoriYmd());
                                suuriyouErrJyouhou.setKakutyoujobcd(pSrKbkSsuRnduHknJigyohiBatchParam.getIbKakutyoujobcd());
                                suuriyouErrJyouhou.setSyono(pHoyuuMeisaiTyukeiyouItzHzn.getZtydatakanrino());
                                suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);
                                suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

                                ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

                                pSrKbkSsuRnduHknJigyohiBatchParam.setZokkouErrorSyoriCount(pSrKbkSsuRnduHknJigyohiBatchParam
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

                            kekkaKbn = keisanW.exec(loadingKeijyoYmPreLasDay, tumimasimaewKaiyakuhrKijyunYM, keisanWExtBean);

                            if (C_ErrorKbn.ERROR.eq(kekkaKbn)) {

                                String msg = MessageUtil.getMessage(MessageId.ESA1001, "解約返戻金",
                                    pHoyuuMeisaiTyukeiyouItzHzn.getZtydatakanrino());

                                batchLogger.warn(msg);

                                ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

                                suuriyouErrJyouhou.setSyoriYmd(pSrKbkSsuRnduHknJigyohiBatchParam.getSyoriYmd());
                                suuriyouErrJyouhou.setKakutyoujobcd(pSrKbkSsuRnduHknJigyohiBatchParam.getIbKakutyoujobcd());
                                suuriyouErrJyouhou.setSyono(pHoyuuMeisaiTyukeiyouItzHzn.getZtydatakanrino());
                                suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);
                                suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

                                ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

                                pSrKbkSsuRnduHknJigyohiBatchParam.setZokkouErrorSyoriCount(pSrKbkSsuRnduHknJigyohiBatchParam
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
        }

        if (pKessanKbn.eq(C_KessanKbn.TUUJYOU)) {

            pKbkSsuRnduHknJigyohiTy.setZtyloadingkeijyoym(loadingKeijyoYm.toString());
            pKbkSsuRnduHknJigyohiTy.setZtysihankiksnydatahyj(sihankiKsnydataHyj);
            pKbkSsuRnduHknJigyohiTy.setZtygmkijyhyj(gmKijyHyj);
            pKbkSsuRnduHknJigyohiTy.setZtyvhireilkisnyukngkx1(new BigDecimal(vhireilKisnyukngkTeiritu.
                toAdsoluteString()).longValue());
            pKbkSsuRnduHknJigyohiTy.setZtyvhireilkisnyukngkx2(new BigDecimal(vhireilKisnyukngkSisuu.
                toAdsoluteString()).longValue());
            pKbkSsuRnduHknJigyohiTy.setZtyrpkeisanyousibous(new BigDecimal(rpKeisanyouSibous.
                toAdsoluteString()).longValue());
            pKbkSsuRnduHknJigyohiTy.setZtytumimasimaew(new BigDecimal(tumimasimaeW.
                toAdsoluteString()).longValue());
        }
        else if (pKessanKbn.eq(C_KessanKbn.KESSAN)) {

            pKsnKbkSsuRnduHknJigyohiTy.setZtyloadingkeijyoym(loadingKeijyoYm.toString());
            pKsnKbkSsuRnduHknJigyohiTy.setZtysihankiksnydatahyj(sihankiKsnydataHyj);
            pKsnKbkSsuRnduHknJigyohiTy.setZtygmkijyhyj(gmKijyHyj);
            pKsnKbkSsuRnduHknJigyohiTy.setZtyvhireilkisnyukngkx1(new BigDecimal(vhireilKisnyukngkTeiritu.
                toAdsoluteString()).longValue());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyvhireilkisnyukngkx2(new BigDecimal(vhireilKisnyukngkSisuu.
                toAdsoluteString()).longValue());
            pKsnKbkSsuRnduHknJigyohiTy.setZtyrpkeisanyousibous(new BigDecimal(rpKeisanyouSibous.
                toAdsoluteString()).longValue());
            pKsnKbkSsuRnduHknJigyohiTy.setZtytumimasimaew(new BigDecimal(tumimasimaeW.
                toAdsoluteString()).longValue());
        }
    }
}
