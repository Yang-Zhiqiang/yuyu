package yuyu.batch.suuri.srsuuritoukei.srraykimatuv;

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
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.GetSisuu;
import yuyu.common.biz.bzcommon.GetSjkkktyouseiyouriritu;
import yuyu.common.biz.bzcommon.GetSjkkktyouseiyourirituBean;
import yuyu.common.hozen.khcommon.KeisanSisuuRendouNkTmttknYendtHnk;
import yuyu.common.hozen.khcommon.KeisanW;
import yuyu.common.hozen.khcommon.KeisanWExtBean;
import yuyu.common.hozen.khcommon.KeisanWKijunYM;
import yuyu.common.suuri.srcommon.KhSisuurendoTmttknBean;
import yuyu.common.suuri.srcommon.SrCommonConstants;
import yuyu.common.suuri.srcommon.SrGetTokutejitenSisuurendoTmttknInfo;
import yuyu.common.suuri.srcommon.SrGetTokutejitenTmttknInfoBean;
import yuyu.common.suuri.suuricommon.TkJitenKeiyakuSyouhinKijyunBean;
import yuyu.def.MessageId;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_TmttknhaibunjyoutaiKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.IT_KhSisuurendoTmttkn;
import yuyu.def.db.entity.ST_HoyuuMeisaiTyukeiyouItzHzn;
import yuyu.def.db.entity.ST_SuuriyouErrJyouhou;
import yuyu.def.db.entity.SV_KiykSyuhnData;
import yuyu.def.db.entity.ZT_RayKimatuVTy;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 数理統計 数理統計 ＲＡＹ期末Ｖ情報作成項目編集クラス
 */
public class SrRayKimatuVBatchEdit {

    @Inject
    private BatchLogger batchLogger;

    private Boolean errorFlag;

    public SrRayKimatuVBatchEdit() {

        errorFlag = false;
    }

    public Boolean editKoumoku(SrRayKimatuVBatchParam pBatchParam,
        ST_HoyuuMeisaiTyukeiyouItzHzn pHoyuuMeisaiTyukeiyouItzHzn,
        TkJitenKeiyakuSyouhinKijyunBean pTkJitenKeiyakuSyouhinKijyunBean,
        ZT_RayKimatuVTy pRayKimatuVTy,
        List<SV_KiykSyuhnData> pSvKiykSyuhnDataLst) {

        editHeaderData(
            pBatchParam,
            pRayKimatuVTy);

        editHoyuuMeisaiData(
            pHoyuuMeisaiTyukeiyouItzHzn,
            pRayKimatuVTy);

        editRayKimatuVTyData(
            pBatchParam,
            pHoyuuMeisaiTyukeiyouItzHzn,
            pTkJitenKeiyakuSyouhinKijyunBean,
            pRayKimatuVTy,
            pSvKiykSyuhnDataLst);

        return errorFlag;
    }

    private void editHeaderData(SrRayKimatuVBatchParam pBatchParam,
        ZT_RayKimatuVTy pRayKimatuVTy) {

        Integer keyKoumoku = pBatchParam.getSyoriKensuu();
        pBatchParam.setSyoriKensuu(pBatchParam.getSyoriKensuu() + 1);

        pRayKimatuVTy.setZtysequenceno(keyKoumoku);

    }

    private void editHoyuuMeisaiData(ST_HoyuuMeisaiTyukeiyouItzHzn pHoyuuMeisaiTyukeiyouItzHzn,
        ZT_RayKimatuVTy pRayKimatuVTy) {

        pRayKimatuVTy.setZtyrecordkbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtyrecordkbn());
        pRayKimatuVTy.setZtynenkinkaisigohyouji(pHoyuuMeisaiTyukeiyouItzHzn.getZtynenkinkaisigohyouji());
        pRayKimatuVTy.setZtynksgokurikosidhyj(pHoyuuMeisaiTyukeiyouItzHzn.getZtynksgokurikosidhyj());
        pRayKimatuVTy.setZtykeijyouym(pHoyuuMeisaiTyukeiyouItzHzn.getZtykeijyouym());
        pRayKimatuVTy.setZtyidojiyukbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtyidojiyukbn());
        pRayKimatuVTy.setZtyzougenkbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtyzougenkbn());
        pRayKimatuVTy.setZtyidourecordkbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtyidourecordkbn());
        pRayKimatuVTy.setZtykeijyouctrlkbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtykeijyouctrlkbn());
        pRayKimatuVTy.setZtyhenkousyoriymd(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhenkousyoriymd());
        pRayKimatuVTy.setZtykykmfksnctr(pHoyuuMeisaiTyukeiyouItzHzn.getZtykykmfksnctr());
        pRayKimatuVTy.setZtyrecordctr(pHoyuuMeisaiTyukeiyouItzHzn.getZtyrecordctr());
        pRayKimatuVTy.setZtysuuriyoukouryokukaisiymd(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtysuuriyoukouryokukaisiymd());
        pRayKimatuVTy.setZtydenymd(pHoyuuMeisaiTyukeiyouItzHzn.getZtydenymd());
        pRayKimatuVTy.setZtybluekeizokuhyouji(pHoyuuMeisaiTyukeiyouItzHzn.getZtybluekeizokuhyouji());
        pRayKimatuVTy.setZtysuuriyouyobin1x2(pHoyuuMeisaiTyukeiyouItzHzn.getZtysuuriyouyobin1x2());
        pRayKimatuVTy.setZtytoukeikeijyoukbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtytoukeikeijyoukbn());
        pRayKimatuVTy.setZtyraysystemhyj(pHoyuuMeisaiTyukeiyouItzHzn.getZtyraysystemhyj());
        pRayKimatuVTy.setZtyzenkiidouteiseikbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtyzenkiidouteiseikbn());
        pRayKimatuVTy.setZtybsyym(pHoyuuMeisaiTyukeiyouItzHzn.getZtybsyym());
        pRayKimatuVTy.setZtytenkangokeiyakubosyuuym(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtytenkangokeiyakubosyuuym());
        pRayKimatuVTy.setZtyidoujiyuucd(pHoyuuMeisaiTyukeiyouItzHzn.getZtyidoujiyuucd());
        pRayKimatuVTy.setZtysyoricd(pHoyuuMeisaiTyukeiyouItzHzn.getZtysyoricd());
        pRayKimatuVTy.setZtysekininteiseihyouji(pHoyuuMeisaiTyukeiyouItzHzn.getZtysekininteiseihyouji());
        pRayKimatuVTy.setZtysuuriyouyobin8(pHoyuuMeisaiTyukeiyouItzHzn.getZtysuuriyouyobin8());
        pRayKimatuVTy.setZtysihankibikinkbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtysihankibikinkbn());
        pRayKimatuVTy.setZtysuuriyouyobin1x3(pHoyuuMeisaiTyukeiyouItzHzn.getZtysuuriyouyobin1x3());
        pRayKimatuVTy.setZtydatakanrino(pHoyuuMeisaiTyukeiyouItzHzn.getZtydatakanrino());
        pRayKimatuVTy.setZtyhknsyukigou(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhknsyukigou());
        pRayKimatuVTy.setZtyhknsyuruikigousedaikbn(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtyhknsyuruikigousedaikbn());
        pRayKimatuVTy.setZtysotodasipmenkbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtysotodasipmenkbn());
        pRayKimatuVTy.setZtystdssytikbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtystdssytikbn());
        pRayKimatuVTy.setZtystdssnskbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtystdssnskbn());
        pRayKimatuVTy.setZtysotodasimanagehyouji(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtysotodasimanagehyouji());
        pRayKimatuVTy.setZtysotodasiphkbnmnoshyouji(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtysotodasiphkbnmnoshyouji());
        pRayKimatuVTy.setZtystdsstkjytkyuhyj(pHoyuuMeisaiTyukeiyouItzHzn.getZtystdsstkjytkyuhyj());
        pRayKimatuVTy.setZtykbnkeiriyousegmentkbn(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtykbnkeiriyousegmentkbn());
        pRayKimatuVTy.setZtykbnkeiriyourgnbnskkbn(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtykbnkeiriyourgnbnskkbn());
        pRayKimatuVTy.setZtysuurisyuruicd(pHoyuuMeisaiTyukeiyouItzHzn.getZtysuurisyuruicd());
        pRayKimatuVTy.setZtyhosyoukinoukbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhosyoukinoukbn());
        pRayKimatuVTy.setZtydaikbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtydaikbn());
        pRayKimatuVTy.setZtytyuukbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtytyuukbn());
        pRayKimatuVTy.setZtysyoukbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtysyoukbn());
        pRayKimatuVTy.setZtysedaikbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtysedaikbn());
        pRayKimatuVTy.setZtyharaikatakbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtyharaikatakbn());
        pRayKimatuVTy.setZtykykymd(pHoyuuMeisaiTyukeiyouItzHzn.getZtykykymd());
        pRayKimatuVTy.setZtyhknkkn(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhknkkn());
        pRayKimatuVTy.setZtyphrkkikn(pHoyuuMeisaiTyukeiyouItzHzn.getZtyphrkkikn());
        pRayKimatuVTy.setZtysaimnkkykhyj(pHoyuuMeisaiTyukeiyouItzHzn.getZtysaimnkkykhyj());
        pRayKimatuVTy.setZtyannaifuyouriyuukbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtyannaifuyouriyuukbn());
        pRayKimatuVTy.setZtytksyuannaikykkbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtytksyuannaikykkbn());
        pRayKimatuVTy.setZtyhrkkaisuukbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhrkkaisuukbn());
        pRayKimatuVTy.setZtyhrkkeirokbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhrkkeirokbn());
        pRayKimatuVTy.setZtysdpdkbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtysdpdkbn());
        pRayKimatuVTy.setZtyryouritukbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtyryouritukbn());
        pRayKimatuVTy.setZtyao3tyou3sibousdatehyouji(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtyao3tyou3sibousdatehyouji());
        pRayKimatuVTy.setZtyhhknseikbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhhknseikbn());
        pRayKimatuVTy.setZtyhihokensyaagev2(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhihokensyaagev2());
        pRayKimatuVTy.setZtykyksyanen(pHoyuuMeisaiTyukeiyouItzHzn.getZtykyksyanen());
        pRayKimatuVTy.setZtydai2hhknnen(pHoyuuMeisaiTyukeiyouItzHzn.getZtydai2hhknnen());
        pRayKimatuVTy.setZtytkbthsyumnryuhyouji(pHoyuuMeisaiTyukeiyouItzHzn.getZtytkbthsyumnryuhyouji());
        pRayKimatuVTy.setZtysyukeiyakupwaribikikbn(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtysyukeiyakupwaribikikbn());
        pRayKimatuVTy.setZtytenkanwaribikikbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtytenkanwaribikikbn());
        pRayKimatuVTy.setZtyyuuhitutnknyuguryurtkbn(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtyyuuhitutnknyuguryurtkbn());
        pRayKimatuVTy.setZtysyukeiyakup(pHoyuuMeisaiTyukeiyouItzHzn.getZtysyukeiyakup());
        pRayKimatuVTy.setZtytokujyoup(pHoyuuMeisaiTyukeiyouItzHzn.getZtytokujyoup());
        pRayKimatuVTy.setZtysiteizukisyukeiyakup(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtysiteizukisyukeiyakup());
        pRayKimatuVTy.setZtykihons(pHoyuuMeisaiTyukeiyouItzHzn.getZtykihons());
        pRayKimatuVTy.setZtysibous(pHoyuuMeisaiTyukeiyouItzHzn.getZtysibous());
        pRayKimatuVTy.setZtyhenkougokihons(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhenkougokihons());
        pRayKimatuVTy.setZtyhenkougosibous(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhenkougosibous());
        pRayKimatuVTy.setZtyhenkouymd(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhenkouymd());
        pRayKimatuVTy.setZtyentyoukikan(pHoyuuMeisaiTyukeiyouItzHzn.getZtyentyoukikan());
        pRayKimatuVTy.setZtyseizonkyuuhukinsiteimd(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtyseizonkyuuhukinsiteimd());
        pRayKimatuVTy.setZtysyukeiyakusiharaikingaku(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtysyukeiyakusiharaikingaku());
        pRayKimatuVTy.setZtyatukaisisyatodouhukencd(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtyatukaisisyatodouhukencd());
        pRayKimatuVTy.setZtytokuyakuhukasuu(pHoyuuMeisaiTyukeiyouItzHzn.getZtytokuyakuhukasuu());
        pRayKimatuVTy.setZtydi2hknkknikoujihisyaage(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtydi2hknkknikoujihisyaage());
        pRayKimatuVTy.setZtyhrimnentyoumaephrkkkn(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtyhrimnentyoumaephrkkkn());
        pRayKimatuVTy.setZtytokubetuhosyoukikan(pHoyuuMeisaiTyukeiyouItzHzn.getZtytokubetuhosyoukikan());
        pRayKimatuVTy.setZtykousinmanryouage(pHoyuuMeisaiTyukeiyouItzHzn.getZtykousinmanryouage());
        pRayKimatuVTy.setZtyknkuzusnzyrttekitkarihyj(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtyknkuzusnzyrttekitkarihyj());
        pRayKimatuVTy.setZtykuriagekurisagekbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtykuriagekurisagekbn());
        pRayKimatuVTy.setZtyhrizmjhknsyukigousdkbn(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtyhrizmjhknsyukigousdkbn());
        pRayKimatuVTy.setZtykrsgjhknsyukigousdkbn(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtykrsgjhknsyukigousdkbn());
        pRayKimatuVTy.setZtysotodasisyouhinkaiteikbn(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtysotodasisyouhinkaiteikbn());
        pRayKimatuVTy.setZtyyobiv4(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobiv4());
        pRayKimatuVTy.setZtygoukeitenkans(pHoyuuMeisaiTyukeiyouItzHzn.getZtygoukeitenkans());
        pRayKimatuVTy.setZtygoukeipbubuntenkans(pHoyuuMeisaiTyukeiyouItzHzn.getZtygoukeipbubuntenkans());
        pRayKimatuVTy.setZtytenkanteikisyuruikigou(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtytenkanteikisyuruikigou());
        pRayKimatuVTy.setZtytenkanteikikigousedaikbn(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtytenkanteikikigousedaikbn());
        pRayKimatuVTy.setZtytnkntiksotodasikusnkbn(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtytnkntiksotodasikusnkbn());
        pRayKimatuVTy.setZtytnkntikstdspmenkbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtytnkntikstdspmenkbn());
        pRayKimatuVTy.setZtytenkanteikikigouyobi(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtytenkanteikikigouyobi());
        pRayKimatuVTy.setZtytenkanteikikikan(pHoyuuMeisaiTyukeiyouItzHzn.getZtytenkanteikikikan());
        pRayKimatuVTy.setZtygoukeitenkanteikis(pHoyuuMeisaiTyukeiyouItzHzn.getZtygoukeitenkanteikis());
        pRayKimatuVTy.setZtytnknteikinkshrkkn(pHoyuuMeisaiTyukeiyouItzHzn.getZtytnknteikinkshrkkn());
        pRayKimatuVTy.setZtytenkansiharaikingaku(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtytenkansiharaikingaku());
        pRayKimatuVTy.setZtytnkntikshrkngk(pHoyuuMeisaiTyukeiyouItzHzn.getZtytnkntikshrkngk());
        pRayKimatuVTy.setZtytenkankaisuu(pHoyuuMeisaiTyukeiyouItzHzn.getZtytenkankaisuu());
        pRayKimatuVTy.setZtygoukeitenkankakaku(pHoyuuMeisaiTyukeiyouItzHzn.getZtygoukeitenkankakaku());
        pRayKimatuVTy.setZtytnknkhnbbnjyuturt(pHoyuuMeisaiTyukeiyouItzHzn.getZtytnknkhnbbnjyuturt());
        pRayKimatuVTy.setZtywnasigoukeitenkanteikis(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtywnasigoukeitenkanteikis());
        pRayKimatuVTy.setZtytnknteikikousinmnryouage(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtytnknteikikousinmnryouage());
        pRayKimatuVTy.setZtyyobiv5(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobiv5());
        pRayKimatuVTy.setZtykanyujidatakanrino(pHoyuuMeisaiTyukeiyouItzHzn.getZtykanyujidatakanrino());
        pRayKimatuVTy.setZtykanyujikykymd(pHoyuuMeisaiTyukeiyouItzHzn.getZtykanyujikykymd());
        pRayKimatuVTy.setZtykanyuujihihokensyaage(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtykanyuujihihokensyaage());
        pRayKimatuVTy.setZtykanyuujitenkanhyouji(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtykanyuujitenkanhyouji());
        pRayKimatuVTy.setZtyhsyuikktminaosikaisu(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtyhsyuikktminaosikaisu());
        pRayKimatuVTy.setZtysknnjynbknsisnrt(pHoyuuMeisaiTyukeiyouItzHzn.getZtysknnjynbknsisnrt());
        pRayKimatuVTy.setZtytkjykbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtytkjykbn());
        pRayKimatuVTy.setZtysakugenkikan(pHoyuuMeisaiTyukeiyouItzHzn.getZtysakugenkikan());
        pRayKimatuVTy.setZtyryoumasihyouten(pHoyuuMeisaiTyukeiyouItzHzn.getZtyryoumasihyouten());
        pRayKimatuVTy.setZtysykyktkjyuryumsratehyj(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtysykyktkjyuryumsratehyj());
        pRayKimatuVTy.setZtysykyktkjyuryumsrate(pHoyuuMeisaiTyukeiyouItzHzn.getZtysykyktkjyuryumsrate());
        pRayKimatuVTy.setZtydai2tokujyoukbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtydai2tokujyoukbn());
        pRayKimatuVTy.setZtydai2sakugenkikan(pHoyuuMeisaiTyukeiyouItzHzn.getZtydai2sakugenkikan());
        pRayKimatuVTy.setZtydai2ryoumasihyouten(pHoyuuMeisaiTyukeiyouItzHzn.getZtydai2ryoumasihyouten());
        pRayKimatuVTy.setZtytokuteibuijyoukenhyouji(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtytokuteibuijyoukenhyouji());
        pRayKimatuVTy.setZtytokuteibuino1(pHoyuuMeisaiTyukeiyouItzHzn.getZtytokuteibuino1());
        pRayKimatuVTy.setZtyhtnpkkn1(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhtnpkkn1());
        pRayKimatuVTy.setZtytokuteibuino2(pHoyuuMeisaiTyukeiyouItzHzn.getZtytokuteibuino2());
        pRayKimatuVTy.setZtyhtnpkkn2(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhtnpkkn2());
        pRayKimatuVTy.setZtymhituiryuyutktbijyknhyj(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtymhituiryuyutktbijyknhyj());
        pRayKimatuVTy.setZtymuhaitouiryouyoutktbino1(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtymuhaitouiryouyoutktbino1());
        pRayKimatuVTy.setZtymuhaitouiryouyouhtnpkkn1(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtymuhaitouiryouyouhtnpkkn1());
        pRayKimatuVTy.setZtymuhaitouiryouyoutktbino2(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtymuhaitouiryouyoutktbino2());
        pRayKimatuVTy.setZtymuhaitouiryouyouhtnpkkn2(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtymuhaitouiryouyouhtnpkkn2());
        pRayKimatuVTy.setZtysiteizukipwarimasihyouji(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtysiteizukipwarimasihyouji());
        pRayKimatuVTy.setZtypwarimasisiteim1(pHoyuuMeisaiTyukeiyouItzHzn.getZtypwarimasisiteim1());
        pRayKimatuVTy.setZtypwarimasisiteim2(pHoyuuMeisaiTyukeiyouItzHzn.getZtypwarimasisiteim2());
        pRayKimatuVTy.setZtysiteimsykykpbairitu(pHoyuuMeisaiTyukeiyouItzHzn.getZtysiteimsykykpbairitu());
        pRayKimatuVTy.setZtysaisyuusiteiym(pHoyuuMeisaiTyukeiyouItzHzn.getZtysaisyuusiteiym());
        pRayKimatuVTy.setZtysykykkitmttvkeisanym(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtysykykkitmttvkeisanym());
        pRayKimatuVTy.setZtysykykkitmttsknnjynbkngk(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtysykykkitmttsknnjynbkngk());
        pRayKimatuVTy.setZtydftumitatekingaku(pHoyuuMeisaiTyukeiyouItzHzn.getZtydftumitatekingaku());
        pRayKimatuVTy.setZtydftumimasikin(pHoyuuMeisaiTyukeiyouItzHzn.getZtydftumimasikin());
        pRayKimatuVTy.setZtyvbubundftenkankakaku(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtyvbubundftenkankakaku());
        pRayKimatuVTy.setZtydpbubundftenkankakaku(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtydpbubundftenkankakaku());
        pRayKimatuVTy.setZtydftmttkngkitjbrbbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtydftmttkngkitjbrbbn());
        pRayKimatuVTy.setZtyhendous(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhendous());
        pRayKimatuVTy.setZtyhengakujigyounendomatucv(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtyhengakujigyounendomatucv());
        pRayKimatuVTy.setZtyitibuitijibarais(pHoyuuMeisaiTyukeiyouItzHzn.getZtyitibuitijibarais());
        pRayKimatuVTy.setZtyitibuitijibaraip(pHoyuuMeisaiTyukeiyouItzHzn.getZtyitibuitijibaraip());
        pRayKimatuVTy.setZtyitibitjbrshrkngk(pHoyuuMeisaiTyukeiyouItzHzn.getZtyitibitjbrshrkngk());
        pRayKimatuVTy.setZtygoukeicv(pHoyuuMeisaiTyukeiyouItzHzn.getZtygoukeicv());
        pRayKimatuVTy.setZtyminasicv(pHoyuuMeisaiTyukeiyouItzHzn.getZtyminasicv());
        pRayKimatuVTy.setZtyloanfund(pHoyuuMeisaiTyukeiyouItzHzn.getZtyloanfund());
        pRayKimatuVTy.setZtysaiteihosyougaku(pHoyuuMeisaiTyukeiyouItzHzn.getZtysaiteihosyougaku());
        pRayKimatuVTy.setZtyhngksitihsyuyusykykp(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtyhngksitihsyuyusykykp());
        pRayKimatuVTy.setZtyhijynbrivasbujsitihsyugk(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtyhijynbrivasbujsitihsyugk());
        pRayKimatuVTy.setZtyhijynbrivamnkjsitihsyugk(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtyhijynbrivamnkjsitihsyugk());
        pRayKimatuVTy.setZtysiinkbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtysiinkbn());
        pRayKimatuVTy.setZtymudkaimasikihons(pHoyuuMeisaiTyukeiyouItzHzn.getZtymudkaimasikihons());
        pRayKimatuVTy.setZtykaimasiymd(pHoyuuMeisaiTyukeiyouItzHzn.getZtykaimasiymd());
        pRayKimatuVTy.setZtykaimasikikan(pHoyuuMeisaiTyukeiyouItzHzn.getZtykaimasikikan());
        pRayKimatuVTy.setZtyhikitugikaimasis(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhikitugikaimasis());
        pRayKimatuVTy.setZtymudkaimasisiharaikingaku(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtymudkaimasisiharaikingaku());
        pRayKimatuVTy.setZtyszoukouryokukaisiymdx1(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtyszoukouryokukaisiymdx1());
        pRayKimatuVTy.setZtyszouhokensyuruikigoux1(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtyszouhokensyuruikigoux1());
        pRayKimatuVTy.setZtyszoukigousedaikbnx1(pHoyuuMeisaiTyukeiyouItzHzn.getZtyszoukigousedaikbnx1());
        pRayKimatuVTy.setZtyszoukikanx1(pHoyuuMeisaiTyukeiyouItzHzn.getZtyszoukikanx1());
        pRayKimatuVTy.setZtyszouhihokensyaagex1(pHoyuuMeisaiTyukeiyouItzHzn.getZtyszouhihokensyaagex1());
        pRayKimatuVTy.setZtyszoudai2hihknsyaagex1(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtyszoudai2hihknsyaagex1());
        pRayKimatuVTy.setZtyzoukasx1(pHoyuuMeisaiTyukeiyouItzHzn.getZtyzoukasx1());
        pRayKimatuVTy.setZtyzennendozoukasx1(pHoyuuMeisaiTyukeiyouItzHzn.getZtyzennendozoukasx1());
        pRayKimatuVTy.setZtyszousiharaikingakux1(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtyszousiharaikingakux1());
        pRayKimatuVTy.setZtyszoukouryokukaisiymdx2(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtyszoukouryokukaisiymdx2());
        pRayKimatuVTy.setZtyszouhokensyuruikigoux2(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtyszouhokensyuruikigoux2());
        pRayKimatuVTy.setZtyszoukigousedaikbnx2(pHoyuuMeisaiTyukeiyouItzHzn.getZtyszoukigousedaikbnx2());
        pRayKimatuVTy.setZtyszoukikanx2(pHoyuuMeisaiTyukeiyouItzHzn.getZtyszoukikanx2());
        pRayKimatuVTy.setZtyszouhihokensyaagex2(pHoyuuMeisaiTyukeiyouItzHzn.getZtyszouhihokensyaagex2());
        pRayKimatuVTy.setZtyszoudai2hihknsyaagex2(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtyszoudai2hihknsyaagex2());
        pRayKimatuVTy.setZtyzoukasx2(pHoyuuMeisaiTyukeiyouItzHzn.getZtyzoukasx2());
        pRayKimatuVTy.setZtyzennendozoukasx2(pHoyuuMeisaiTyukeiyouItzHzn.getZtyzennendozoukasx2());
        pRayKimatuVTy.setZtyszousiharaikingakux2(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtyszousiharaikingakux2());
        pRayKimatuVTy.setZtysuuriyouyobin1x5(pHoyuuMeisaiTyukeiyouItzHzn.getZtysuuriyouyobin1x5());
        pRayKimatuVTy.setZtysuuriyouyobin1x6(pHoyuuMeisaiTyukeiyouItzHzn.getZtysuuriyouyobin1x6());
        pRayKimatuVTy.setZtyhrimngkizktkykpmenhyj(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtyhrimngkizktkykpmenhyj());
        pRayKimatuVTy.setZtymisyuustartym(pHoyuuMeisaiTyukeiyouItzHzn.getZtymisyuustartym());
        pRayKimatuVTy.setZtymisyuukaisuu(pHoyuuMeisaiTyukeiyouItzHzn.getZtymisyuukaisuu());
        pRayKimatuVTy.setZtyitjbrtkykkousnuktkarhyj(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtyitjbrtkykkousnuktkarhyj());
        pRayKimatuVTy.setZtygyousekihyoujis(pHoyuuMeisaiTyukeiyouItzHzn.getZtygyousekihyoujis());
        pRayKimatuVTy.setZtysykykgyusekihyjs(pHoyuuMeisaiTyukeiyouItzHzn.getZtysykykgyusekihyjs());
        pRayKimatuVTy.setZtytenkangyousekihyoujis(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtytenkangyousekihyoujis());
        pRayKimatuVTy.setZtytnknteikigyousekihyjs(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtytnknteikigyousekihyjs());
        pRayKimatuVTy.setZtytnkndpbbngyuskhyjs(pHoyuuMeisaiTyukeiyouItzHzn.getZtytnkndpbbngyuskhyjs());
        pRayKimatuVTy.setZtykykjyoutai(pHoyuuMeisaiTyukeiyouItzHzn.getZtykykjyoutai());
        pRayKimatuVTy.setZtypmenhukakbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtypmenhukakbn());
        pRayKimatuVTy.setZtykousinkbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtykousinkbn());
        pRayKimatuVTy.setZtymankiyoteikbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtymankiyoteikbn());
        pRayKimatuVTy.setZtysykyktikmnkyoteikbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtysykyktikmnkyoteikbn());
        pRayKimatuVTy.setZtytnknsykykkhnmnkytikbn(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtytnknsykykkhnmnkytikbn());
        pRayKimatuVTy.setZtytnknsykyktikmnkytikbn(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtytnknsykyktikmnkytikbn());
        pRayKimatuVTy.setZtytenkanteikimankiyoteikbn(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtytenkanteikimankiyoteikbn());
        pRayKimatuVTy.setZtyszoumankiyoteikbnx1(pHoyuuMeisaiTyukeiyouItzHzn.getZtyszoumankiyoteikbnx1());
        pRayKimatuVTy.setZtyszoumankiyoteikbnx2(pHoyuuMeisaiTyukeiyouItzHzn.getZtyszoumankiyoteikbnx2());
        pRayKimatuVTy.setZtyvestingmankiyoteikbn(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtyvestingmankiyoteikbn());
        pRayKimatuVTy.setZtyvkeisanhyouji(pHoyuuMeisaiTyukeiyouItzHzn.getZtyvkeisanhyouji());
        pRayKimatuVTy.setZtytoukisinkeiyakuhyouji(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtytoukisinkeiyakuhyouji());
        pRayKimatuVTy.setZtysykykhokenhoutekiyouhyj(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtysykykhokenhoutekiyouhyj());
        pRayKimatuVTy.setZtytokuteijyoutaihushrhyj(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtytokuteijyoutaihushrhyj());
        pRayKimatuVTy.setZtyytirrthndsysnmnskaisuu(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtyytirrthndsysnmnskaisuu());
        pRayKimatuVTy.setZtysuuriyouyobin3(pHoyuuMeisaiTyukeiyouItzHzn.getZtysuuriyouyobin3());
        pRayKimatuVTy.setZtysuuriyouyobin11(pHoyuuMeisaiTyukeiyouItzHzn.getZtysuuriyouyobin11());
        pRayKimatuVTy.setZtywnasigoukeitenkankakaku(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtywnasigoukeitenkankakaku());
        pRayKimatuVTy.setZtyyobin11(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobin11());
        pRayKimatuVTy.setZtyyobin11x2(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobin11x2());
        pRayKimatuVTy.setZtyyobin11x3(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobin11x3());
        pRayKimatuVTy.setZtytukibaraikansantokujyoup(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtytukibaraikansantokujyoup());
        pRayKimatuVTy.setZtytnkngkykkssnkijyuym(pHoyuuMeisaiTyukeiyouItzHzn.getZtytnkngkykkssnkijyuym());
        pRayKimatuVTy.setZtysaiteihosyouhyouji(pHoyuuMeisaiTyukeiyouItzHzn.getZtysaiteihosyouhyouji());
        pRayKimatuVTy.setZtysuuriyouyobin8x2(pHoyuuMeisaiTyukeiyouItzHzn.getZtysuuriyouyobin8x2());
        pRayKimatuVTy.setZtysuuriyouyobin14(pHoyuuMeisaiTyukeiyouItzHzn.getZtysuuriyouyobin14());
        pRayKimatuVTy.setZtyhrimngtkykphrkkaisuukbn(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtyhrimngtkykphrkkaisuukbn());
        pRayKimatuVTy.setZtyhrimngtkykphrkkirkbn(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtyhrimngtkykphrkkirkbn());
        pRayKimatuVTy.setZtyhrimngtkykpryurtkbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhrimngtkykpryurtkbn());
        pRayKimatuVTy.setZtyyobiv13(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobiv13());
        pRayKimatuVTy.setZtyidoujisaiteihosyoukngk(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtyidoujisaiteihosyoukngk());
        pRayKimatuVTy.setZtyidoujisaiteihosyoucost(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtyidoujisaiteihosyoucost());
        pRayKimatuVTy.setZtysinhokenfundtumitatekin(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtysinhokenfundtumitatekin());
        pRayKimatuVTy.setZtymsyuptusshkgkaiykhnrikn(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtymsyuptusshkgkaiykhnrikn());
        pRayKimatuVTy.setZtyrrthndugtnkgetumatuv(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtyrrthndugtnkgetumatuv());
        pRayKimatuVTy.setZtyrrthndnksaiteihosyonkgns(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtyrrthndnksaiteihosyonkgns());
        pRayKimatuVTy.setZtyrrthendougatanksibous(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtyrrthendougatanksibous());
        pRayKimatuVTy.setZtyalmyousohutomeisyoukbn(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtyalmyousohutomeisyoukbn());
        pRayKimatuVTy.setZtysnkyksoftmeisyoukbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtysnkyksoftmeisyoukbn());
        pRayKimatuVTy.setZtysoftmeisyoukbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtysoftmeisyoukbn());
        pRayKimatuVTy.setZtykykjitokujyouarihyj(pHoyuuMeisaiTyukeiyouItzHzn.getZtykykjitokujyouarihyj());
        pRayKimatuVTy.setZtybnkttnknkbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtybnkttnknkbn());
        pRayKimatuVTy.setZtytenkanminaosikbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtytenkanminaosikbn());
        pRayKimatuVTy.setZtysoujikeitenkankbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtysoujikeitenkankbn());
        pRayKimatuVTy.setZtynenkinkaisinendo(pHoyuuMeisaiTyukeiyouItzHzn.getZtynenkinkaisinendo());
        pRayKimatuVTy.setZtynenkingatakbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtynenkingatakbn());
        pRayKimatuVTy.setZtynknshry(pHoyuuMeisaiTyukeiyouItzHzn.getZtynknshry());
        pRayKimatuVTy.setZtyheiyoubaraikeiyakukbn(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtyheiyoubaraikeiyakukbn());
        pRayKimatuVTy.setZtynenkinmaruteihukakbn(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtynenkinmaruteihukakbn());
        pRayKimatuVTy.setZtysinseizonmrtiarihyj(pHoyuuMeisaiTyukeiyouItzHzn.getZtysinseizonmrtiarihyj());
        pRayKimatuVTy.setZtysnkykyouibokijyukbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtysnkykyouibokijyukbn());
        pRayKimatuVTy.setZtytokusitujyuusitusetkbn(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtytokusitujyuusitusetkbn());
        pRayKimatuVTy.setZtysiktsyuknbyugnhsyunshyj(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtysiktsyuknbyugnhsyunshyj());
        pRayKimatuVTy.setZtypmensugugtganhsyunshyj(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtypmensugugtganhsyunshyj());
        pRayKimatuVTy.setZtytkykgyousekihyjszerohyj(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtytkykgyousekihyjszerohyj());
        pRayKimatuVTy.setZtysuuriyouyobin7(pHoyuuMeisaiTyukeiyouItzHzn.getZtysuuriyouyobin7());
        pRayKimatuVTy.setZtysyussaikeitaikbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtysyussaikeitaikbn());
        pRayKimatuVTy.setZtyyobiv6(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobiv6());
        pRayKimatuVTy.setZtybosyuukeitaikbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtybosyuukeitaikbn());
        pRayKimatuVTy.setZtyaatukaisosikicd(pHoyuuMeisaiTyukeiyouItzHzn.getZtyaatukaisosikicd());
        pRayKimatuVTy.setZtyaatukaikojincd(pHoyuuMeisaiTyukeiyouItzHzn.getZtyaatukaikojincd());
        pRayKimatuVTy.setZtybsydrtencd(pHoyuuMeisaiTyukeiyouItzHzn.getZtybsydrtencd());
        pRayKimatuVTy.setZtycifcd(pHoyuuMeisaiTyukeiyouItzHzn.getZtycifcd());
        pRayKimatuVTy.setZtysuuriyouyobiv8(pHoyuuMeisaiTyukeiyouItzHzn.getZtysuuriyouyobiv8());
        pRayKimatuVTy.setZtysinsakbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtysinsakbn());
        pRayKimatuVTy.setZtydai2hihokensyasinsakbn(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtydai2hihokensyasinsakbn());
        pRayKimatuVTy.setZtytoukeiyousinsakbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtytoukeiyousinsakbn());
        pRayKimatuVTy.setZtydai2toukeiyousinsakbn(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtydai2toukeiyousinsakbn());
        pRayKimatuVTy.setZtyketteikijyunkanwakbn(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtyketteikijyunkanwakbn());
        pRayKimatuVTy.setZtykihonsibouhyoukbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtykihonsibouhyoukbn());
        pRayKimatuVTy.setZtyteikisibouhyoukbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtyteikisibouhyoukbn());
        pRayKimatuVTy.setZtysonotasibouhyoukbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtysonotasibouhyoukbn());
        pRayKimatuVTy.setZtymrarihyj(pHoyuuMeisaiTyukeiyouItzHzn.getZtymrarihyj());
        pRayKimatuVTy.setZtysentakujyouhouarihyouji(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtysentakujyouhouarihyouji());
        pRayKimatuVTy.setZtydugktnknsntkhuhukbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtydugktnknsntkhuhukbn());
        pRayKimatuVTy.setZtygengakutenkankykhyj(pHoyuuMeisaiTyukeiyouItzHzn.getZtygengakutenkankykhyj());
        pRayKimatuVTy.setZtysykgycd(pHoyuuMeisaiTyukeiyouItzHzn.getZtysykgycd());
        pRayKimatuVTy.setZtyjidoukousinkykkanyuuymd(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtyjidoukousinkykkanyuuymd());
        pRayKimatuVTy.setZtysaikohtnknkykkykymd(pHoyuuMeisaiTyukeiyouItzHzn.getZtysaikohtnknkykkykymd());
        pRayKimatuVTy.setZtykousinmaesykyksburtkbn(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtykousinmaesykyksburtkbn());
        pRayKimatuVTy.setZtyhjnkykhyj(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhjnkykhyj());
        pRayKimatuVTy.setZtyanniskcd(pHoyuuMeisaiTyukeiyouItzHzn.getZtyanniskcd());
        pRayKimatuVTy.setZtyhjncd(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhjncd());
        pRayKimatuVTy.setZtyhjnjigyosyocd(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhjnjigyosyocd());
        pRayKimatuVTy.setZtysaihokenno(pHoyuuMeisaiTyukeiyouItzHzn.getZtysaihokenno());
        pRayKimatuVTy.setZtydakuhikettikekkacd(pHoyuuMeisaiTyukeiyouItzHzn.getZtydakuhikettikekkacd());
        pRayKimatuVTy.setZtydai2dakuhiketteikekkacd(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtydai2dakuhiketteikekkacd());
        pRayKimatuVTy.setZtypmenkbnv2(pHoyuuMeisaiTyukeiyouItzHzn.getZtypmenkbnv2());
        pRayKimatuVTy.setZtysiboukyuuhukin(pHoyuuMeisaiTyukeiyouItzHzn.getZtysiboukyuuhukin());
        pRayKimatuVTy.setZtyjyudthumeharaitkykhkhyj(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtyjyudthumeharaitkykhkhyj());
        pRayKimatuVTy.setZtyhaitoukbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhaitoukbn());
        pRayKimatuVTy.setZtyhhknnentysihyj(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhhknnentysihyj());
        pRayKimatuVTy.setZtydai2hhknnentysihyj(pHoyuuMeisaiTyukeiyouItzHzn.getZtydai2hhknnentysihyj());
        pRayKimatuVTy.setZtykyksyaagetyouseihyj(pHoyuuMeisaiTyukeiyouItzHzn.getZtykyksyaagetyouseihyj());
        pRayKimatuVTy.setZtykituenkbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtykituenkbn());
        pRayKimatuVTy.setZtykituenhonsuu(pHoyuuMeisaiTyukeiyouItzHzn.getZtykituenhonsuu());
        pRayKimatuVTy.setZtymusentakukeiyakukbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtymusentakukeiyakukbn());
        pRayKimatuVTy.setZtyyobiv6x2(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobiv6x2());
        pRayKimatuVTy.setZtylivingneedstkykarihyj(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtylivingneedstkykarihyj());
        pRayKimatuVTy.setZtylivingneedssiharaihyouji(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtylivingneedssiharaihyouji());
        pRayKimatuVTy.setZtylnseikyuuymd(pHoyuuMeisaiTyukeiyouItzHzn.getZtylnseikyuuymd());
        pRayKimatuVTy.setZtylnshrgenincd(pHoyuuMeisaiTyukeiyouItzHzn.getZtylnshrgenincd());
        pRayKimatuVTy.setZtydakuhikettisyacd(pHoyuuMeisaiTyukeiyouItzHzn.getZtydakuhikettisyacd());
        pRayKimatuVTy.setZtydai2dakuhiketteisyacd(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtydai2dakuhiketteisyacd());
        pRayKimatuVTy.setZtygansapotokuyakuarihyouji(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtygansapotokuyakuarihyouji());
        pRayKimatuVTy.setZtygnspshrhyj(pHoyuuMeisaiTyukeiyouItzHzn.getZtygnspshrhyj());
        pRayKimatuVTy.setZtygansaposeikyuuymd(pHoyuuMeisaiTyukeiyouItzHzn.getZtygansaposeikyuuymd());
        pRayKimatuVTy.setZtygnspshrgenincd(pHoyuuMeisaiTyukeiyouItzHzn.getZtygnspshrgenincd());
        pRayKimatuVTy.setZtyyobiv3x2(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobiv3x2());
        pRayKimatuVTy.setZtytargetmokuhyouritu(pHoyuuMeisaiTyukeiyouItzHzn.getZtytargetmokuhyouritu());
        pRayKimatuVTy.setZtyautoswitchmokuhyouritu(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtyautoswitchmokuhyouritu());
        pRayKimatuVTy.setZtytumitatekinitenarihyj(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtytumitatekinitenarihyj());
        pRayKimatuVTy.setZtytumitatekinitenkaisuu(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtytumitatekinitenkaisuu());
        pRayKimatuVTy.setZtydatakanrino2(pHoyuuMeisaiTyukeiyouItzHzn.getZtydatakanrino2());
        pRayKimatuVTy.setZtydatakanrino3(pHoyuuMeisaiTyukeiyouItzHzn.getZtydatakanrino3());
        pRayKimatuVTy.setZtyknkuzusnzyrttekinendo(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtyknkuzusnzyrttekinendo());
        pRayKimatuVTy.setZtyknkuzusnzyrt(pHoyuuMeisaiTyukeiyouItzHzn.getZtyknkuzusnzyrt());
        pRayKimatuVTy.setZtyknkuzusnzyrtx2(pHoyuuMeisaiTyukeiyouItzHzn.getZtyknkuzusnzyrtx2());
        pRayKimatuVTy.setZtyknkuzusnzyrtx3(pHoyuuMeisaiTyukeiyouItzHzn.getZtyknkuzusnzyrtx3());
        pRayKimatuVTy.setZtysinkeiyakujiknkuzusnzyrt(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtysinkeiyakujiknkuzusnzyrt());
        pRayKimatuVTy.setZtytenkanjiknkuzusnzyrt(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtytenkanjiknkuzusnzyrt());
        pRayKimatuVTy.setZtysinkeiyakujivithkhyouji(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtysinkeiyakujivithkhyouji());
        pRayKimatuVTy.setZtykykjivithukusuukykhyj(pHoyuuMeisaiTyukeiyouItzHzn.getZtykykjivithukusuukykhyj());
        pRayKimatuVTy.setZtysuuriyouyobin9x2(pHoyuuMeisaiTyukeiyouItzHzn.getZtysuuriyouyobin9x2());
        pRayKimatuVTy.setZtypwrbksidhitekiyouhyj(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtypwrbksidhitekiyouhyj());
        pRayKimatuVTy.setZtysuuriyouyobin9(pHoyuuMeisaiTyukeiyouItzHzn.getZtysuuriyouyobin9());
        pRayKimatuVTy.setZtysuuriyouyobin10x7(pHoyuuMeisaiTyukeiyouItzHzn.getZtysuuriyouyobin10x7());
        pRayKimatuVTy.setZtysuuriyouyobin10x8(pHoyuuMeisaiTyukeiyouItzHzn.getZtysuuriyouyobin10x8());
        pRayKimatuVTy.setZtysuuriyouyobin10x9(pHoyuuMeisaiTyukeiyouItzHzn.getZtysuuriyouyobin10x9());
        pRayKimatuVTy.setZtytumitatekinitenbubun(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtytumitatekinitenbubun());
        pRayKimatuVTy.setZtysagakusknnjynbknzndk(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtysagakusknnjynbknzndk());
        pRayKimatuVTy.setZtyyobin11x5(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobin11x5());
        pRayKimatuVTy.setZtyyobin11x6(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobin11x6());
        pRayKimatuVTy.setZtyyobin11x7(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobin11x7());
        pRayKimatuVTy.setZtyyobin11x8(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobin11x8());
        pRayKimatuVTy.setZtyyobin11x9(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobin11x9());
        pRayKimatuVTy.setZtyyobin11x10(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobin11x10());
        pRayKimatuVTy.setZtyyobin11x11(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobin11x11());
        pRayKimatuVTy.setZtyyobin11x12(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobin11x12());
        pRayKimatuVTy.setZtyyobin11x13(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobin11x13());
        pRayKimatuVTy.setZtyyobin11x14(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobin11x14());
        pRayKimatuVTy.setZtyyobin11x15(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobin11x15());
        pRayKimatuVTy.setZtyyobin11x16(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobin11x16());
        pRayKimatuVTy.setZtyyobin11x17(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobin11x17());
        pRayKimatuVTy.setZtyzyrthntiyustatuskbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtyzyrthntiyustatuskbn());
        pRayKimatuVTy.setZtyzyrthntiyustatuskbnx2(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtyzyrthntiyustatuskbnx2());
        pRayKimatuVTy.setZtyzyrthntiyustatuskbnx3(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtyzyrthntiyustatuskbnx3());
        pRayKimatuVTy.setZtyzyrthntiyustatuskbnx4(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtyzyrthntiyustatuskbnx4());
        pRayKimatuVTy.setZtyzyrthntiyustatuskbnx5(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtyzyrthntiyustatuskbnx5());
        pRayKimatuVTy.setZtyyobiv10(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobiv10());
        pRayKimatuVTy.setZtyyobiv15x2(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobiv15x2());
        pRayKimatuVTy.setZtyyobiv15x3(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobiv15x3());
        pRayKimatuVTy.setZtyyobiv15x4(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobiv15x4());
        pRayKimatuVTy.setZtygaikakbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtygaikakbn());
        pRayKimatuVTy.setZtykawaserate1(pHoyuuMeisaiTyukeiyouItzHzn.getZtykawaserate1());
        pRayKimatuVTy.setZtykawaseratetekiyouymd1(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtykawaseratetekiyouymd1());
        pRayKimatuVTy.setZtykawaserate2(pHoyuuMeisaiTyukeiyouItzHzn.getZtykawaserate2());
        pRayKimatuVTy.setZtykawaseratetekiyouymd2(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtykawaseratetekiyouymd2());
        pRayKimatuVTy.setZtykykjikawaserate(pHoyuuMeisaiTyukeiyouItzHzn.getZtykykjikawaserate());
        pRayKimatuVTy.setZtykykjikawaseratetkyuymd(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtykykjikawaseratetkyuymd());
        pRayKimatuVTy.setZtymvatyouseigow(pHoyuuMeisaiTyukeiyouItzHzn.getZtymvatyouseigow());
        pRayKimatuVTy.setZtymvakeisanjisknnjynbkn(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtymvakeisanjisknnjynbkn());
        pRayKimatuVTy.setZtykaiyakukoujyoritu(pHoyuuMeisaiTyukeiyouItzHzn.getZtykaiyakukoujyoritu());
        pRayKimatuVTy.setZtyrendouritu(pHoyuuMeisaiTyukeiyouItzHzn.getZtyrendouritu());
        pRayKimatuVTy.setZtysrkaiyakusjkkktyouseirrt(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtysrkaiyakusjkkktyouseirrt());
        pRayKimatuVTy.setZtysrkyksjkkktyouseiriritu(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtysrkyksjkkktyouseiriritu());
        pRayKimatuVTy.setZtymvakeisankijyunymd(pHoyuuMeisaiTyukeiyouItzHzn.getZtymvakeisankijyunymd());
        pRayKimatuVTy.setZtymvatyouseikou(pHoyuuMeisaiTyukeiyouItzHzn.getZtymvatyouseikou());
        pRayKimatuVTy.setZtyenkdtsbujsitihsyukngk(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtyenkdtsbujsitihsyukngk());
        pRayKimatuVTy.setZtyenkdtsbujsitihsyucost(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtyenkdtsbujsitihsyucost());
        pRayKimatuVTy.setZtyenkdtsbujsitihsyuarihyj(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtyenkdtsbujsitihsyuarihyj());
        pRayKimatuVTy.setZtykeiyakujiyoteiriritu(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtykeiyakujiyoteiriritu());
        pRayKimatuVTy.setZtytumitateriritu(pHoyuuMeisaiTyukeiyouItzHzn.getZtytumitateriritu());
        pRayKimatuVTy.setZtykaigomaebaraitkykarihyj(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtykaigomaebaraitkykarihyj());
        pRayKimatuVTy.setZtysibouhyoukbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtysibouhyoukbn());
        pRayKimatuVTy.setZtynyuukintuukakbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtynyuukintuukakbn());
        pRayKimatuVTy.setZtysiharaituukakbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtysiharaituukakbn());
        pRayKimatuVTy.setZtywyendttargetmokuhyouritu(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtywyendttargetmokuhyouritu());
        pRayKimatuVTy.setZtysisuurendourate(pHoyuuMeisaiTyukeiyouItzHzn.getZtysisuurendourate());
        pRayKimatuVTy.setZtysisuukbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtysisuukbn());
        pRayKimatuVTy.setZtyteirituikouhyouji(pHoyuuMeisaiTyukeiyouItzHzn.getZtyteirituikouhyouji());
        pRayKimatuVTy.setZtysrdai1hknkkn(pHoyuuMeisaiTyukeiyouItzHzn.getZtysrdai1hknkkn());
        pRayKimatuVTy.setZtysuuriyouyobin10x11(pHoyuuMeisaiTyukeiyouItzHzn.getZtysuuriyouyobin10x11());
        pRayKimatuVTy.setZtytmttknzoukaritujygn(pHoyuuMeisaiTyukeiyouItzHzn.getZtytmttknzoukaritujygn());
        pRayKimatuVTy.setZtysetteibairitu(pHoyuuMeisaiTyukeiyouItzHzn.getZtysetteibairitu());
        pRayKimatuVTy.setZtytykzenoutouymdsisuu(pHoyuuMeisaiTyukeiyouItzHzn.getZtytykzenoutouymdsisuu());
        pRayKimatuVTy.setZtykimatusisuu(pHoyuuMeisaiTyukeiyouItzHzn.getZtykimatusisuu());
        pRayKimatuVTy.setZtytuukasyukbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtytuukasyukbn());
        pRayKimatuVTy.setZtyyobiv2(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobiv2());
        pRayKimatuVTy.setZtyyenkadatekihons(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyenkadatekihons());
        pRayKimatuVTy.setZtysitihsyumegkdtsibous(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtysitihsyumegkdtsibous());
        pRayKimatuVTy.setZtyenkdtssrentumitatekin(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtyenkdtssrentumitatekin());
        pRayKimatuVTy.setZtysisuurentumitatekin(pHoyuuMeisaiTyukeiyouItzHzn.getZtysisuurentumitatekin());
        pRayKimatuVTy.setZtynksjitirttumitatekin(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtynksjitirttumitatekin());
        pRayKimatuVTy.setZtykimatutirttumitatekin(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtykimatutirttumitatekin());
        pRayKimatuVTy.setZtygaikadatejyuutoup(pHoyuuMeisaiTyukeiyouItzHzn.getZtygaikadatejyuutoup());
        pRayKimatuVTy.setZtyyendttargetkijyunkingaku(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtyyendttargetkijyunkingaku());
        pRayKimatuVTy.setZtyyobiv7(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobiv7());
        pRayKimatuVTy.setZtysitivkisnyukykjikwsrate(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtysitivkisnyukykjikwsrate());
        pRayKimatuVTy.setZtysisuurentyokugotmttkn(pHoyuuMeisaiTyukeiyouItzHzn.getZtysisuurentyokugotmttkn());
        pRayKimatuVTy.setZtyrrthnduhknvkisovkisnyu1(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtyrrthnduhknvkisovkisnyu1());
    }

    private void editRayKimatuVTyData(SrRayKimatuVBatchParam pBatchParam,
        ST_HoyuuMeisaiTyukeiyouItzHzn pHoyuuMeisaiTyukeiyouItzHzn,
        TkJitenKeiyakuSyouhinKijyunBean pTkJitenKeiyakuSyouhinKijyunBean,
        ZT_RayKimatuVTy pRayKimatuVTy,
        List<SV_KiykSyuhnData> pSvKiykSyuhnDataLst) {

        SrRayKimatuVBatchDbAccess srRayKimatuVBatchDbAccess =
            SWAKInjector.getInstance(SrRayKimatuVBatchDbAccess.class);
        List<IT_KhSisuurendoTmttkn> khSisuurendoTmttknLst;
        IT_KhSisuurendoTmttkn khSisuurendoTmttkn;

        if (BizDateUtil.compareYmd(pBatchParam.getKijyunymd(),
            pTkJitenKeiyakuSyouhinKijyunBean.getKykymd()) == BizDateUtil.COMPARE_LESSER) {

            khSisuurendoTmttknLst = srRayKimatuVBatchDbAccess.
                getKhSisuurendoTmttknBySyonoTmttknkouryokukaisiymdAsc(
                    pHoyuuMeisaiTyukeiyouItzHzn.getZtydatakanrino(),
                    pTkJitenKeiyakuSyouhinKijyunBean.getKykymd());

            khSisuurendoTmttkn = khSisuurendoTmttknLst.get(0);
        }
        else {

            SrGetTokutejitenSisuurendoTmttknInfo srGetTokutejitenSisuurendoTmttknInfo = SWAKInjector.getInstance(
                SrGetTokutejitenSisuurendoTmttknInfo.class);

            List<SrGetTokutejitenTmttknInfoBean> srGetTokutejitenTmttknInfoBeanLst =
                srGetTokutejitenSisuurendoTmttknInfo.exec(pHoyuuMeisaiTyukeiyouItzHzn.getZtydatakanrino(),
                    pBatchParam.getKijyunymd(), null, pSvKiykSyuhnDataLst);

            KhSisuurendoTmttknBean khSisuurendoTmttknBean = srGetTokutejitenSisuurendoTmttknInfo.
                getSisuurendoTmttknInfo(pBatchParam.getKijyunymd(), null, srGetTokutejitenTmttknInfoBeanLst);

            khSisuurendoTmttkn = khSisuurendoTmttknBean.getKhSisuurendoTmttknAto();
        }

        BizDate nenkinstartymd = pTkJitenKeiyakuSyouhinKijyunBean.getHknkknmanryouymd();

        BizNumber vyoukimatuSisuu = BizNumber.ZERO;
        BizDate kmtSisuukijyunYmd = BizDate.MIN_VALUE;
        BizDate jigyouNdmtYmd = BizDate.MIN_VALUE;
        BizDateYM kaiyakuhrKeisanKijunYm;
        BizDate kaiyakuSjkkkTyouseiRirituKijyunYmd = BizDate.MIN_VALUE;
        BizNumber kaiyakuSjkkkTyouseiRiritu = BizNumber.ZERO;
        GetSisuu getSisuu = SWAKInjector.getInstance(GetSisuu.class);
        C_ErrorKbn errorKbn;
        BizDate tykzensisuukijyunymd = BizDate.MIN_VALUE;

        if (!C_TmttknhaibunjyoutaiKbn.TEIRITU_ONLY.equals(
            pTkJitenKeiyakuSyouhinKijyunBean.getTmttknhaibunjyoutai())) {

            if (pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() == null) {
                errorKbn = getSisuu.exec(pTkJitenKeiyakuSyouhinKijyunBean.getSisuukbn(),
                    pBatchParam.getKijyunymd(), C_YouhiKbn.YOU);

                if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                    String msg = MessageUtil.getMessage(MessageId.ESA1001, "指数取得：期末指数",
                        pHoyuuMeisaiTyukeiyouItzHzn.getZtydatakanrino());

                    batchLogger.warn(msg);

                    ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

                    suuriyouErrJyouhou.setSyoriYmd(pBatchParam.getSyoriYmd());
                    suuriyouErrJyouhou.setKakutyoujobcd(pBatchParam.getIbKakutyoujobcd());
                    suuriyouErrJyouhou.setSyono(pHoyuuMeisaiTyukeiyouItzHzn.getZtydatakanrino());
                    suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);
                    suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

                    BizPropertyInitializer.initialize(suuriyouErrJyouhou);

                    ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

                    pBatchParam.setErrorSyoriKensuu(pBatchParam.getErrorSyoriKensuu() + 1);
                    errorFlag = true;
                }
                else {
                    vyoukimatuSisuu = getSisuu.getSisuu();
                    kmtSisuukijyunYmd = getSisuu.getSisuushutokuymd();
                }
            }
        }

        if (pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() == null &&
            pTkJitenKeiyakuSyouhinKijyunBean.getTmttknitenYmd() == null) {
            if (BizDateUtil.compareYmd(pBatchParam.getKijyunymd(),
                pTkJitenKeiyakuSyouhinKijyunBean.getKykymd()) == BizDateUtil.COMPARE_LESSER) {
                if (pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getDay() == SrCommonConstants.DAY_16D) {
                    tykzensisuukijyunymd = kmtSisuukijyunYmd;
                }
                else {
                    tykzensisuukijyunymd = khSisuurendoTmttkn.getTmttknhaneitmmshanteiymd();
                }
            }
            else {
                tykzensisuukijyunymd = khSisuurendoTmttkn.getTmttknhaneitmmshanteiymd();
            }
        }
        if (pBatchParam.getKijyunymd().getMonth() < SrCommonConstants.MONTH_APRIL) {

            jigyouNdmtYmd = BizDate.valueOf(String.valueOf(pBatchParam.getKijyunymd().getYear())
                + SrCommonConstants.FIXEDDAY_NENDOKSNBI);
        }
        else {

            jigyouNdmtYmd = BizDate.valueOf(String.valueOf(pBatchParam.getKijyunymd().getYear()
                + SrCommonConstants.YEAR_1Y)
                + SrCommonConstants.FIXEDDAY_NENDOKSNBI);
        }

        KeisanWKijunYM keisanWKijunYM = SWAKInjector.getInstance(KeisanWKijunYM.class);

        kaiyakuhrKeisanKijunYm = keisanWKijunYM.exec(pTkJitenKeiyakuSyouhinKijyunBean.getKykymd(), jigyouNdmtYmd,
            null, null, pTkJitenKeiyakuSyouhinKijyunBean.getKykjyoutai(),
            pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd(), pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd());

        if (pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() == null) {
            if (BizDateUtil.compareYmd(pBatchParam.getSyoriYmd(),
                pBatchParam.getKijyunymd()) == BizDateUtil.COMPARE_LESSER) {

                kaiyakuSjkkkTyouseiRirituKijyunYmd = pBatchParam.getSyoriYmd();
            }
            else {

                kaiyakuSjkkkTyouseiRirituKijyunYmd = pBatchParam.getKijyunymd();
            }

            GetSjkkktyouseiyourirituBean getSjkkktyouseiyourirituBean = SWAKInjector
                .getInstance(GetSjkkktyouseiyourirituBean.class);
            GetSjkkktyouseiyouriritu getSjkkktyouseiyouriritu = SWAKInjector.getInstance(GetSjkkktyouseiyouriritu.class);

            getSjkkktyouseiyourirituBean.setSyouhncd(pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd());
            getSjkkktyouseiyourirituBean.setKijyunymd(kaiyakuSjkkkTyouseiRirituKijyunYmd);
            getSjkkktyouseiyourirituBean.setHknkkn(pTkJitenKeiyakuSyouhinKijyunBean.getHknkkn());
            getSjkkktyouseiyourirituBean.setHknkknsmnkbn(pTkJitenKeiyakuSyouhinKijyunBean.getHknkknsmnKbn());
            getSjkkktyouseiyourirituBean.setHhknnen(pTkJitenKeiyakuSyouhinKijyunBean.getHhknnen());

            errorKbn = getSjkkktyouseiyouriritu.exec(getSjkkktyouseiyourirituBean);

            if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                String msg = MessageUtil.getMessage(MessageId.ESA1001, "市場価格調整用利率",
                    pHoyuuMeisaiTyukeiyouItzHzn.getZtydatakanrino());

                batchLogger.warn(msg);

                ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

                suuriyouErrJyouhou.setSyoriYmd(pBatchParam.getSyoriYmd());
                suuriyouErrJyouhou.setKakutyoujobcd(pBatchParam.getIbKakutyoujobcd());
                suuriyouErrJyouhou.setSyono(pHoyuuMeisaiTyukeiyouItzHzn.getZtydatakanrino());
                suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);
                suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

                BizPropertyInitializer.initialize(suuriyouErrJyouhou);

                ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

                pBatchParam.setErrorSyoriKensuu(pBatchParam.getErrorSyoriKensuu() + 1);
                errorFlag = true;
            }
            else {
                kaiyakuSjkkkTyouseiRiritu = getSjkkktyouseiyouriritu.getSjkkktyouseiyouriritu();
            }
        }

        BizCurrency[] jmtTirtTumitatekins = { BizCurrency.valueOf(0), BizCurrency.valueOf(0), BizCurrency.valueOf(0) };
        BizCurrency[] jmtSisuuTumitatekins = { BizCurrency.valueOf(0), BizCurrency.valueOf(0), BizCurrency.valueOf(0) };
        BizCurrency[] jmtMvaTyouseigoWs = { BizCurrency.valueOf(0), BizCurrency.valueOf(0), BizCurrency.valueOf(0) };
        BizCurrency[] jmtMvaKeisanjiVs = { BizCurrency.valueOf(0), BizCurrency.valueOf(0), BizCurrency.valueOf(0) };
        int nensuu = 0;
        KeisanW keisanW = SWAKInjector.getInstance(KeisanW.class);
        KeisanWExtBean keisanWExtBean = null;

        for (int i = 0; i < 3; i++) {

            if (pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() == null) {

                break;
            }

            if (BizDateUtil.compareYmd(nenkinstartymd, jigyouNdmtYmd) == BizDateUtil.COMPARE_LESSER ||
                BizDateUtil.compareYmd(nenkinstartymd, jigyouNdmtYmd) == BizDateUtil.COMPARE_EQUAL) {

                break;
            }

            keisanWKijunYM = SWAKInjector.getInstance(KeisanWKijunYM.class);

            BizDate calcKijyunYmd = BizDate.valueOf(jigyouNdmtYmd.getBizDateYM(),
                pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd().getDay());

            BizDateYM yendthnkCalcKijyunYm = keisanWKijunYM.exec(pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd(),
                calcKijyunYmd, null, null, pTkJitenKeiyakuSyouhinKijyunBean.getKykjyoutai(),
                pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd(), pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd());

            keisanWKijunYM = SWAKInjector.getInstance(KeisanWKijunYM.class);
            BizDateYM yendthnkYendthnkYm = keisanWKijunYM.exec(pTkJitenKeiyakuSyouhinKijyunBean.getKykymd(),
                pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd(), null, null,
                pTkJitenKeiyakuSyouhinKijyunBean.getKykjyoutai(), pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd(),
                null);

            KeisanSisuuRendouNkTmttknYendtHnk keisanSisuuRendouNkTmttknYendtHnk =
                SWAKInjector.getInstance(KeisanSisuuRendouNkTmttknYendtHnk.class);

            C_ErrorKbn kekkaKbn = keisanSisuuRendouNkTmttknYendtHnk.exec(calcKijyunYmd, yendthnkCalcKijyunYm,
                pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd(), yendthnkYendthnkYm,
                pTkJitenKeiyakuSyouhinKijyunBean.getKykymd(), pTkJitenKeiyakuSyouhinKijyunBean.getHknkkn(),
                pTkJitenKeiyakuSyouhinKijyunBean.getKihons(), pTkJitenKeiyakuSyouhinKijyunBean.getTumitateriritu());

            if (C_ErrorKbn.ERROR.eq(kekkaKbn)) {
                String msg = MessageUtil.getMessage(MessageId.ESA1001,
                    "事業年度末項目：指数連動年金積立金計算" + nensuu,
                    pHoyuuMeisaiTyukeiyouItzHzn.getZtydatakanrino());

                batchLogger.warn(msg);

                ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

                suuriyouErrJyouhou.setSyoriYmd(pBatchParam.getSyoriYmd());
                suuriyouErrJyouhou.setKakutyoujobcd(pBatchParam.getIbKakutyoujobcd());
                suuriyouErrJyouhou.setSyono(pHoyuuMeisaiTyukeiyouItzHzn.getZtydatakanrino());
                suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);
                suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

                BizPropertyInitializer.initialize(suuriyouErrJyouhou);

                ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

                pBatchParam.setErrorSyoriKensuu(pBatchParam.getErrorSyoriKensuu() + 1);
                errorFlag = true;
            }
            else {
                jmtTirtTumitatekins[nensuu] = keisanSisuuRendouNkTmttknYendtHnk.getTumitategk();
            }

            keisanWExtBean = SWAKInjector.getInstance(KeisanWExtBean.class);

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
            keisanWExtBean.setTumitateriritu(pTkJitenKeiyakuSyouhinKijyunBean.getTumitateriritu());
            keisanWExtBean.setYendthnkymd(pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd());
            keisanWExtBean.setTeikishrtkykhukaumu(C_UmuKbn.valueOf(pHoyuuMeisaiTyukeiyouItzHzn.getZtysrteikishrtkykhukaumu()));
            keisanWExtBean.setDai1hknkkn(pTkJitenKeiyakuSyouhinKijyunBean.getDai1hknkkn());
            keisanWExtBean.setKykJyoutai(pTkJitenKeiyakuSyouhinKijyunBean.getKykjyoutai());

            C_ErrorKbn keisanWKekkaKbn = keisanW.exec(jigyouNdmtYmd, kaiyakuhrKeisanKijunYm, keisanWExtBean);

            if (C_ErrorKbn.ERROR.eq(keisanWKekkaKbn)) {

                String msg = MessageUtil.getMessage(MessageId.ESA1001,
                    "事業年度末項目：解約返戻金計算" + nensuu,
                    pHoyuuMeisaiTyukeiyouItzHzn.getZtydatakanrino());

                batchLogger.warn(msg);

                ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

                suuriyouErrJyouhou.setSyoriYmd(pBatchParam.getSyoriYmd());
                suuriyouErrJyouhou.setKakutyoujobcd(pBatchParam.getIbKakutyoujobcd());
                suuriyouErrJyouhou.setSyono(pHoyuuMeisaiTyukeiyouItzHzn.getZtydatakanrino());
                suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);
                suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

                BizPropertyInitializer.initialize(suuriyouErrJyouhou);

                ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

                pBatchParam.setErrorSyoriKensuu(pBatchParam.getErrorSyoriKensuu() + 1);
                errorFlag = true;
            }
            else {

                jmtMvaTyouseigoWs[nensuu] = keisanW.getW();
                jmtMvaKeisanjiVs[nensuu] = keisanW.getV();
            }

            jigyouNdmtYmd = jigyouNdmtYmd.addYears(SrCommonConstants.YEAR_1Y).getRekijyou();
            kaiyakuhrKeisanKijunYm = kaiyakuhrKeisanKijunYm.addYears(SrCommonConstants.YEAR_1Y);

            nensuu++;
        }

        pRayKimatuVTy.setZtyvkimatutirttumitatekin(pHoyuuMeisaiTyukeiyouItzHzn
            .getZtykimatutirttumitatekin());
        pRayKimatuVTy.setZtykimatusisuutumitatekin(pHoyuuMeisaiTyukeiyouItzHzn
            .getZtysisuurentumitatekin());
        pRayKimatuVTy.setZtyvyoutykzenoutouymdsisuu(pHoyuuMeisaiTyukeiyouItzHzn.getZtytykzenoutouymdsisuu());
        if (tykzensisuukijyunymd != null) {
            pRayKimatuVTy.setZtytykzensisuukijyunymd(tykzensisuukijyunymd.toString());
        }
        pRayKimatuVTy.setZtyvyoukimatusisuu(vyoukimatuSisuu);
        if (kmtSisuukijyunYmd != null) {
            pRayKimatuVTy.setZtykmtsisuukijyunymd(kmtSisuukijyunYmd.toString());
        }
        pRayKimatuVTy.setZtyvyoutmttknzoukaritujygn(pHoyuuMeisaiTyukeiyouItzHzn
            .getZtytmttknzoukaritujygn());
        pRayKimatuVTy.setZtyvyousetteibairitu(pHoyuuMeisaiTyukeiyouItzHzn.getZtysetteibairitu());
        pRayKimatuVTy.setZtyvyourendouritu(pHoyuuMeisaiTyukeiyouItzHzn.getZtyrendouritu());
        pRayKimatuVTy.setZtykimatusisuutyokugotmttkn(pHoyuuMeisaiTyukeiyouItzHzn.getZtysisuurentyokugotmttkn());
        pRayKimatuVTy.setZtyjmttirttumitatekinnplus0(Long.parseLong(jmtTirtTumitatekins[0].toAdsoluteString()));
        pRayKimatuVTy.setZtyjmttirttumitatekinnplus1(Long.parseLong(jmtTirtTumitatekins[1].toAdsoluteString()));
        pRayKimatuVTy.setZtyjmttirttumitatekinnplus2(Long.parseLong(jmtTirtTumitatekins[2].toAdsoluteString()));
        pRayKimatuVTy.setZtyjmtssutumitatekinnplus0(Long.parseLong(jmtSisuuTumitatekins[0].toAdsoluteString()));
        pRayKimatuVTy.setZtyjmtssutumitatekinnplus1(Long.parseLong(jmtSisuuTumitatekins[1].toAdsoluteString()));
        pRayKimatuVTy.setZtyjmtssutumitatekinnplus2(Long.parseLong(jmtSisuuTumitatekins[2].toAdsoluteString()));
        pRayKimatuVTy.setZtyjmtmvatyouseigownplus0(Long.parseLong(jmtMvaTyouseigoWs[0].toAdsoluteString()));
        pRayKimatuVTy.setZtyjmtmvakeisanjiwnplus0(Long.parseLong(jmtMvaKeisanjiVs[0].toAdsoluteString()));
        pRayKimatuVTy.setZtyjmtmvatyouseigownplus1(Long.parseLong(jmtMvaTyouseigoWs[1].toAdsoluteString()));
        pRayKimatuVTy.setZtyjmtmvakeisanjiwnplus1(Long.parseLong(jmtMvaKeisanjiVs[1].toAdsoluteString()));
        pRayKimatuVTy.setZtyjmtmvatyouseigownplus2(Long.parseLong(jmtMvaTyouseigoWs[2].toAdsoluteString()));
        pRayKimatuVTy.setZtyjmtmvakeisanjiwnplus2(Long.parseLong(jmtMvaKeisanjiVs[2].toAdsoluteString()));
    }
}
