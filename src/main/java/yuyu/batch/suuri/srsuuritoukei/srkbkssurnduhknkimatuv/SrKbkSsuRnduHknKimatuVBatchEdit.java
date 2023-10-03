package yuyu.batch.suuri.srsuuritoukei.srkbkssurnduhknkimatuv;

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
import yuyu.def.db.entity.ZT_KbkSsuRnduHknKimatuVTy;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 数理統計 数理統計 株価指数連動保険期末Ｖ情報作成項目編集クラス
 */
public class SrKbkSsuRnduHknKimatuVBatchEdit {

    @Inject
    private BatchLogger batchLogger;

    private Boolean errorFlag;

    public SrKbkSsuRnduHknKimatuVBatchEdit() {

        errorFlag = false;
    }

    public Boolean editKoumoku(SrKbkSsuRnduHknKimatuVBatchParam pBatchParam,
        ST_HoyuuMeisaiTyukeiyouItzHzn pHoyuuMeisaiTyukeiyouItzHzn,
        TkJitenKeiyakuSyouhinKijyunBean pTkJitenKeiyakuSyouhinKijyunBean,
        ZT_KbkSsuRnduHknKimatuVTy pKbkSsuRnduHknKimatuVTy,
        List<SV_KiykSyuhnData> pSvKiykSyuhnDataLst) {

        editHeaderData(
            pBatchParam,
            pKbkSsuRnduHknKimatuVTy);

        editHoyuuMeisaiData(
            pHoyuuMeisaiTyukeiyouItzHzn,
            pKbkSsuRnduHknKimatuVTy);

        editKbkSsuRnduHknKimatuVTyData(
            pBatchParam,
            pHoyuuMeisaiTyukeiyouItzHzn,
            pTkJitenKeiyakuSyouhinKijyunBean,
            pKbkSsuRnduHknKimatuVTy,
            pSvKiykSyuhnDataLst);

        return errorFlag;
    }

    private void editHeaderData(SrKbkSsuRnduHknKimatuVBatchParam pBatchParam,
        ZT_KbkSsuRnduHknKimatuVTy pKbkSsuRnduHknKimatuVTy) {

        Integer keyKoumoku = pBatchParam.getSyoriKensuu();
        pBatchParam.setSyoriKensuu(pBatchParam.getSyoriKensuu() + 1);

        pKbkSsuRnduHknKimatuVTy.setZtysequenceno(keyKoumoku);

    }

    private void editHoyuuMeisaiData(ST_HoyuuMeisaiTyukeiyouItzHzn pHoyuuMeisaiTyukeiyouItzHzn,
        ZT_KbkSsuRnduHknKimatuVTy pKbkSsuRnduHknKimatuVTy) {

        pKbkSsuRnduHknKimatuVTy.setZtyrecordkbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtyrecordkbn());
        pKbkSsuRnduHknKimatuVTy.setZtynenkinkaisigohyouji(pHoyuuMeisaiTyukeiyouItzHzn.getZtynenkinkaisigohyouji());
        pKbkSsuRnduHknKimatuVTy.setZtynksgokurikosidhyj(pHoyuuMeisaiTyukeiyouItzHzn.getZtynksgokurikosidhyj());
        pKbkSsuRnduHknKimatuVTy.setZtykeijyouym(pHoyuuMeisaiTyukeiyouItzHzn.getZtykeijyouym());
        pKbkSsuRnduHknKimatuVTy.setZtyidojiyukbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtyidojiyukbn());
        pKbkSsuRnduHknKimatuVTy.setZtyzougenkbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtyzougenkbn());
        pKbkSsuRnduHknKimatuVTy.setZtyidourecordkbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtyidourecordkbn());
        pKbkSsuRnduHknKimatuVTy.setZtykeijyouctrlkbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtykeijyouctrlkbn());
        pKbkSsuRnduHknKimatuVTy.setZtyhenkousyoriymd(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhenkousyoriymd());
        pKbkSsuRnduHknKimatuVTy.setZtykykmfksnctr(pHoyuuMeisaiTyukeiyouItzHzn.getZtykykmfksnctr());
        pKbkSsuRnduHknKimatuVTy.setZtyrecordctr(pHoyuuMeisaiTyukeiyouItzHzn.getZtyrecordctr());
        pKbkSsuRnduHknKimatuVTy.setZtysuuriyoukouryokukaisiymd(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtysuuriyoukouryokukaisiymd());
        pKbkSsuRnduHknKimatuVTy.setZtydenymd(pHoyuuMeisaiTyukeiyouItzHzn.getZtydenymd());
        pKbkSsuRnduHknKimatuVTy.setZtybluekeizokuhyouji(pHoyuuMeisaiTyukeiyouItzHzn.getZtybluekeizokuhyouji());
        pKbkSsuRnduHknKimatuVTy.setZtysuuriyouyobin1x2(pHoyuuMeisaiTyukeiyouItzHzn.getZtysuuriyouyobin1x2());
        pKbkSsuRnduHknKimatuVTy.setZtytoukeikeijyoukbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtytoukeikeijyoukbn());
        pKbkSsuRnduHknKimatuVTy.setZtyraysystemhyj(pHoyuuMeisaiTyukeiyouItzHzn.getZtyraysystemhyj());
        pKbkSsuRnduHknKimatuVTy.setZtyzenkiidouteiseikbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtyzenkiidouteiseikbn());
        pKbkSsuRnduHknKimatuVTy.setZtybsyym(pHoyuuMeisaiTyukeiyouItzHzn.getZtybsyym());
        pKbkSsuRnduHknKimatuVTy.setZtytenkangokeiyakubosyuuym(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtytenkangokeiyakubosyuuym());
        pKbkSsuRnduHknKimatuVTy.setZtyidoujiyuucd(pHoyuuMeisaiTyukeiyouItzHzn.getZtyidoujiyuucd());
        pKbkSsuRnduHknKimatuVTy.setZtysyoricd(pHoyuuMeisaiTyukeiyouItzHzn.getZtysyoricd());
        pKbkSsuRnduHknKimatuVTy.setZtysekininteiseihyouji(pHoyuuMeisaiTyukeiyouItzHzn.getZtysekininteiseihyouji());
        pKbkSsuRnduHknKimatuVTy.setZtysuuriyouyobin8(pHoyuuMeisaiTyukeiyouItzHzn.getZtysuuriyouyobin8());
        pKbkSsuRnduHknKimatuVTy.setZtysihankibikinkbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtysihankibikinkbn());
        pKbkSsuRnduHknKimatuVTy.setZtysuuriyouyobin1x3(pHoyuuMeisaiTyukeiyouItzHzn.getZtysuuriyouyobin1x3());
        pKbkSsuRnduHknKimatuVTy.setZtydatakanrino(pHoyuuMeisaiTyukeiyouItzHzn.getZtydatakanrino());
        pKbkSsuRnduHknKimatuVTy.setZtyhknsyukigou(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhknsyukigou());
        pKbkSsuRnduHknKimatuVTy.setZtyhknsyuruikigousedaikbn(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtyhknsyuruikigousedaikbn());
        pKbkSsuRnduHknKimatuVTy.setZtysotodasipmenkbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtysotodasipmenkbn());
        pKbkSsuRnduHknKimatuVTy.setZtystdssytikbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtystdssytikbn());
        pKbkSsuRnduHknKimatuVTy.setZtystdssnskbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtystdssnskbn());
        pKbkSsuRnduHknKimatuVTy.setZtysotodasimanagehyouji(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtysotodasimanagehyouji());
        pKbkSsuRnduHknKimatuVTy.setZtysotodasiphkbnmnoshyouji(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtysotodasiphkbnmnoshyouji());
        pKbkSsuRnduHknKimatuVTy.setZtystdsstkjytkyuhyj(pHoyuuMeisaiTyukeiyouItzHzn.getZtystdsstkjytkyuhyj());
        pKbkSsuRnduHknKimatuVTy.setZtykbnkeiriyousegmentkbn(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtykbnkeiriyousegmentkbn());
        pKbkSsuRnduHknKimatuVTy.setZtykbnkeiriyourgnbnskkbn(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtykbnkeiriyourgnbnskkbn());
        pKbkSsuRnduHknKimatuVTy.setZtysuurisyuruicd(pHoyuuMeisaiTyukeiyouItzHzn.getZtysuurisyuruicd());
        pKbkSsuRnduHknKimatuVTy.setZtyhosyoukinoukbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhosyoukinoukbn());
        pKbkSsuRnduHknKimatuVTy.setZtydaikbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtydaikbn());
        pKbkSsuRnduHknKimatuVTy.setZtytyuukbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtytyuukbn());
        pKbkSsuRnduHknKimatuVTy.setZtysyoukbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtysyoukbn());
        pKbkSsuRnduHknKimatuVTy.setZtysedaikbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtysedaikbn());
        pKbkSsuRnduHknKimatuVTy.setZtyharaikatakbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtyharaikatakbn());
        pKbkSsuRnduHknKimatuVTy.setZtykykymd(pHoyuuMeisaiTyukeiyouItzHzn.getZtykykymd());
        pKbkSsuRnduHknKimatuVTy.setZtyhknkkn(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhknkkn());
        pKbkSsuRnduHknKimatuVTy.setZtyphrkkikn(pHoyuuMeisaiTyukeiyouItzHzn.getZtyphrkkikn());
        pKbkSsuRnduHknKimatuVTy.setZtysaimnkkykhyj(pHoyuuMeisaiTyukeiyouItzHzn.getZtysaimnkkykhyj());
        pKbkSsuRnduHknKimatuVTy.setZtyannaifuyouriyuukbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtyannaifuyouriyuukbn());
        pKbkSsuRnduHknKimatuVTy.setZtytksyuannaikykkbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtytksyuannaikykkbn());
        pKbkSsuRnduHknKimatuVTy.setZtyhrkkaisuukbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhrkkaisuukbn());
        pKbkSsuRnduHknKimatuVTy.setZtyhrkkeirokbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhrkkeirokbn());
        pKbkSsuRnduHknKimatuVTy.setZtysdpdkbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtysdpdkbn());
        pKbkSsuRnduHknKimatuVTy.setZtyryouritukbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtyryouritukbn());
        pKbkSsuRnduHknKimatuVTy.setZtyao3tyou3sibousdatehyouji(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtyao3tyou3sibousdatehyouji());
        pKbkSsuRnduHknKimatuVTy.setZtyhhknseikbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhhknseikbn());
        pKbkSsuRnduHknKimatuVTy.setZtyhihokensyaagev2(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhihokensyaagev2());
        pKbkSsuRnduHknKimatuVTy.setZtykyksyanen(pHoyuuMeisaiTyukeiyouItzHzn.getZtykyksyanen());
        pKbkSsuRnduHknKimatuVTy.setZtydai2hhknnen(pHoyuuMeisaiTyukeiyouItzHzn.getZtydai2hhknnen());
        pKbkSsuRnduHknKimatuVTy.setZtytkbthsyumnryuhyouji(pHoyuuMeisaiTyukeiyouItzHzn.getZtytkbthsyumnryuhyouji());
        pKbkSsuRnduHknKimatuVTy.setZtysyukeiyakupwaribikikbn(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtysyukeiyakupwaribikikbn());
        pKbkSsuRnduHknKimatuVTy.setZtytenkanwaribikikbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtytenkanwaribikikbn());
        pKbkSsuRnduHknKimatuVTy.setZtyyuuhitutnknyuguryurtkbn(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtyyuuhitutnknyuguryurtkbn());
        pKbkSsuRnduHknKimatuVTy.setZtysyukeiyakup(pHoyuuMeisaiTyukeiyouItzHzn.getZtysyukeiyakup());
        pKbkSsuRnduHknKimatuVTy.setZtytokujyoup(pHoyuuMeisaiTyukeiyouItzHzn.getZtytokujyoup());
        pKbkSsuRnduHknKimatuVTy.setZtysiteizukisyukeiyakup(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtysiteizukisyukeiyakup());
        pKbkSsuRnduHknKimatuVTy.setZtykihons(pHoyuuMeisaiTyukeiyouItzHzn.getZtykihons());
        pKbkSsuRnduHknKimatuVTy.setZtysibous(pHoyuuMeisaiTyukeiyouItzHzn.getZtysibous());
        pKbkSsuRnduHknKimatuVTy.setZtyhenkougokihons(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhenkougokihons());
        pKbkSsuRnduHknKimatuVTy.setZtyhenkougosibous(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhenkougosibous());
        pKbkSsuRnduHknKimatuVTy.setZtyhenkouymd(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhenkouymd());
        pKbkSsuRnduHknKimatuVTy.setZtyentyoukikan(pHoyuuMeisaiTyukeiyouItzHzn.getZtyentyoukikan());
        pKbkSsuRnduHknKimatuVTy.setZtyseizonkyuuhukinsiteimd(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtyseizonkyuuhukinsiteimd());
        pKbkSsuRnduHknKimatuVTy.setZtysyukeiyakusiharaikingaku(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtysyukeiyakusiharaikingaku());
        pKbkSsuRnduHknKimatuVTy.setZtyatukaisisyatodouhukencd(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtyatukaisisyatodouhukencd());
        pKbkSsuRnduHknKimatuVTy.setZtytokuyakuhukasuu(pHoyuuMeisaiTyukeiyouItzHzn.getZtytokuyakuhukasuu());
        pKbkSsuRnduHknKimatuVTy.setZtydi2hknkknikoujihisyaage(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtydi2hknkknikoujihisyaage());
        pKbkSsuRnduHknKimatuVTy.setZtyhrimnentyoumaephrkkkn(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtyhrimnentyoumaephrkkkn());
        pKbkSsuRnduHknKimatuVTy.setZtytokubetuhosyoukikan(pHoyuuMeisaiTyukeiyouItzHzn.getZtytokubetuhosyoukikan());
        pKbkSsuRnduHknKimatuVTy.setZtykousinmanryouage(pHoyuuMeisaiTyukeiyouItzHzn.getZtykousinmanryouage());
        pKbkSsuRnduHknKimatuVTy.setZtyknkuzusnzyrttekitkarihyj(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtyknkuzusnzyrttekitkarihyj());
        pKbkSsuRnduHknKimatuVTy.setZtykuriagekurisagekbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtykuriagekurisagekbn());
        pKbkSsuRnduHknKimatuVTy.setZtyhrizmjhknsyukigousdkbn(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtyhrizmjhknsyukigousdkbn());
        pKbkSsuRnduHknKimatuVTy.setZtykrsgjhknsyukigousdkbn(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtykrsgjhknsyukigousdkbn());
        pKbkSsuRnduHknKimatuVTy.setZtysotodasisyouhinkaiteikbn(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtysotodasisyouhinkaiteikbn());
        pKbkSsuRnduHknKimatuVTy.setZtyyobiv4(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobiv4());
        pKbkSsuRnduHknKimatuVTy.setZtygoukeitenkans(pHoyuuMeisaiTyukeiyouItzHzn.getZtygoukeitenkans());
        pKbkSsuRnduHknKimatuVTy.setZtygoukeipbubuntenkans(pHoyuuMeisaiTyukeiyouItzHzn.getZtygoukeipbubuntenkans());
        pKbkSsuRnduHknKimatuVTy.setZtytenkanteikisyuruikigou(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtytenkanteikisyuruikigou());
        pKbkSsuRnduHknKimatuVTy.setZtytenkanteikikigousedaikbn(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtytenkanteikikigousedaikbn());
        pKbkSsuRnduHknKimatuVTy.setZtytnkntiksotodasikusnkbn(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtytnkntiksotodasikusnkbn());
        pKbkSsuRnduHknKimatuVTy.setZtytnkntikstdspmenkbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtytnkntikstdspmenkbn());
        pKbkSsuRnduHknKimatuVTy.setZtytenkanteikikigouyobi(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtytenkanteikikigouyobi());
        pKbkSsuRnduHknKimatuVTy.setZtytenkanteikikikan(pHoyuuMeisaiTyukeiyouItzHzn.getZtytenkanteikikikan());
        pKbkSsuRnduHknKimatuVTy.setZtygoukeitenkanteikis(pHoyuuMeisaiTyukeiyouItzHzn.getZtygoukeitenkanteikis());
        pKbkSsuRnduHknKimatuVTy.setZtytnknteikinkshrkkn(pHoyuuMeisaiTyukeiyouItzHzn.getZtytnknteikinkshrkkn());
        pKbkSsuRnduHknKimatuVTy.setZtytenkansiharaikingaku(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtytenkansiharaikingaku());
        pKbkSsuRnduHknKimatuVTy.setZtytnkntikshrkngk(pHoyuuMeisaiTyukeiyouItzHzn.getZtytnkntikshrkngk());
        pKbkSsuRnduHknKimatuVTy.setZtytenkankaisuu(pHoyuuMeisaiTyukeiyouItzHzn.getZtytenkankaisuu());
        pKbkSsuRnduHknKimatuVTy.setZtygoukeitenkankakaku(pHoyuuMeisaiTyukeiyouItzHzn.getZtygoukeitenkankakaku());
        pKbkSsuRnduHknKimatuVTy.setZtytnknkhnbbnjyuturt(pHoyuuMeisaiTyukeiyouItzHzn.getZtytnknkhnbbnjyuturt());
        pKbkSsuRnduHknKimatuVTy.setZtywnasigoukeitenkanteikis(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtywnasigoukeitenkanteikis());
        pKbkSsuRnduHknKimatuVTy.setZtytnknteikikousinmnryouage(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtytnknteikikousinmnryouage());
        pKbkSsuRnduHknKimatuVTy.setZtyyobiv5(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobiv5());
        pKbkSsuRnduHknKimatuVTy.setZtykanyujidatakanrino(pHoyuuMeisaiTyukeiyouItzHzn.getZtykanyujidatakanrino());
        pKbkSsuRnduHknKimatuVTy.setZtykanyujikykymd(pHoyuuMeisaiTyukeiyouItzHzn.getZtykanyujikykymd());
        pKbkSsuRnduHknKimatuVTy.setZtykanyuujihihokensyaage(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtykanyuujihihokensyaage());
        pKbkSsuRnduHknKimatuVTy.setZtykanyuujitenkanhyouji(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtykanyuujitenkanhyouji());
        pKbkSsuRnduHknKimatuVTy.setZtyhsyuikktminaosikaisu(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtyhsyuikktminaosikaisu());
        pKbkSsuRnduHknKimatuVTy.setZtysknnjynbknsisnrt(pHoyuuMeisaiTyukeiyouItzHzn.getZtysknnjynbknsisnrt());
        pKbkSsuRnduHknKimatuVTy.setZtytkjykbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtytkjykbn());
        pKbkSsuRnduHknKimatuVTy.setZtysakugenkikan(pHoyuuMeisaiTyukeiyouItzHzn.getZtysakugenkikan());
        pKbkSsuRnduHknKimatuVTy.setZtyryoumasihyouten(pHoyuuMeisaiTyukeiyouItzHzn.getZtyryoumasihyouten());
        pKbkSsuRnduHknKimatuVTy.setZtysykyktkjyuryumsratehyj(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtysykyktkjyuryumsratehyj());
        pKbkSsuRnduHknKimatuVTy.setZtysykyktkjyuryumsrate(pHoyuuMeisaiTyukeiyouItzHzn.getZtysykyktkjyuryumsrate());
        pKbkSsuRnduHknKimatuVTy.setZtydai2tokujyoukbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtydai2tokujyoukbn());
        pKbkSsuRnduHknKimatuVTy.setZtydai2sakugenkikan(pHoyuuMeisaiTyukeiyouItzHzn.getZtydai2sakugenkikan());
        pKbkSsuRnduHknKimatuVTy.setZtydai2ryoumasihyouten(pHoyuuMeisaiTyukeiyouItzHzn.getZtydai2ryoumasihyouten());
        pKbkSsuRnduHknKimatuVTy.setZtytokuteibuijyoukenhyouji(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtytokuteibuijyoukenhyouji());
        pKbkSsuRnduHknKimatuVTy.setZtytokuteibuino1(pHoyuuMeisaiTyukeiyouItzHzn.getZtytokuteibuino1());
        pKbkSsuRnduHknKimatuVTy.setZtyhtnpkkn1(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhtnpkkn1());
        pKbkSsuRnduHknKimatuVTy.setZtytokuteibuino2(pHoyuuMeisaiTyukeiyouItzHzn.getZtytokuteibuino2());
        pKbkSsuRnduHknKimatuVTy.setZtyhtnpkkn2(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhtnpkkn2());
        pKbkSsuRnduHknKimatuVTy.setZtymhituiryuyutktbijyknhyj(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtymhituiryuyutktbijyknhyj());
        pKbkSsuRnduHknKimatuVTy.setZtymuhaitouiryouyoutktbino1(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtymuhaitouiryouyoutktbino1());
        pKbkSsuRnduHknKimatuVTy.setZtymuhaitouiryouyouhtnpkkn1(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtymuhaitouiryouyouhtnpkkn1());
        pKbkSsuRnduHknKimatuVTy.setZtymuhaitouiryouyoutktbino2(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtymuhaitouiryouyoutktbino2());
        pKbkSsuRnduHknKimatuVTy.setZtymuhaitouiryouyouhtnpkkn2(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtymuhaitouiryouyouhtnpkkn2());
        pKbkSsuRnduHknKimatuVTy.setZtysiteizukipwarimasihyouji(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtysiteizukipwarimasihyouji());
        pKbkSsuRnduHknKimatuVTy.setZtypwarimasisiteim1(pHoyuuMeisaiTyukeiyouItzHzn.getZtypwarimasisiteim1());
        pKbkSsuRnduHknKimatuVTy.setZtypwarimasisiteim2(pHoyuuMeisaiTyukeiyouItzHzn.getZtypwarimasisiteim2());
        pKbkSsuRnduHknKimatuVTy.setZtysiteimsykykpbairitu(pHoyuuMeisaiTyukeiyouItzHzn.getZtysiteimsykykpbairitu());
        pKbkSsuRnduHknKimatuVTy.setZtysaisyuusiteiym(pHoyuuMeisaiTyukeiyouItzHzn.getZtysaisyuusiteiym());
        pKbkSsuRnduHknKimatuVTy.setZtysykykkitmttvkeisanym(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtysykykkitmttvkeisanym());
        pKbkSsuRnduHknKimatuVTy.setZtysykykkitmttsknnjynbkngk(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtysykykkitmttsknnjynbkngk());
        pKbkSsuRnduHknKimatuVTy.setZtydftumitatekingaku(pHoyuuMeisaiTyukeiyouItzHzn.getZtydftumitatekingaku());
        pKbkSsuRnduHknKimatuVTy.setZtydftumimasikin(pHoyuuMeisaiTyukeiyouItzHzn.getZtydftumimasikin());
        pKbkSsuRnduHknKimatuVTy.setZtyvbubundftenkankakaku(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtyvbubundftenkankakaku());
        pKbkSsuRnduHknKimatuVTy.setZtydpbubundftenkankakaku(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtydpbubundftenkankakaku());
        pKbkSsuRnduHknKimatuVTy.setZtydftmttkngkitjbrbbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtydftmttkngkitjbrbbn());
        pKbkSsuRnduHknKimatuVTy.setZtyhendous(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhendous());
        pKbkSsuRnduHknKimatuVTy.setZtyhengakujigyounendomatucv(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtyhengakujigyounendomatucv());
        pKbkSsuRnduHknKimatuVTy.setZtyitibuitijibarais(pHoyuuMeisaiTyukeiyouItzHzn.getZtyitibuitijibarais());
        pKbkSsuRnduHknKimatuVTy.setZtyitibuitijibaraip(pHoyuuMeisaiTyukeiyouItzHzn.getZtyitibuitijibaraip());
        pKbkSsuRnduHknKimatuVTy.setZtyitibitjbrshrkngk(pHoyuuMeisaiTyukeiyouItzHzn.getZtyitibitjbrshrkngk());
        pKbkSsuRnduHknKimatuVTy.setZtygoukeicv(pHoyuuMeisaiTyukeiyouItzHzn.getZtygoukeicv());
        pKbkSsuRnduHknKimatuVTy.setZtyminasicv(pHoyuuMeisaiTyukeiyouItzHzn.getZtyminasicv());
        pKbkSsuRnduHknKimatuVTy.setZtyloanfund(pHoyuuMeisaiTyukeiyouItzHzn.getZtyloanfund());
        pKbkSsuRnduHknKimatuVTy.setZtysaiteihosyougaku(pHoyuuMeisaiTyukeiyouItzHzn.getZtysaiteihosyougaku());
        pKbkSsuRnduHknKimatuVTy.setZtyhngksitihsyuyusykykp(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtyhngksitihsyuyusykykp());
        pKbkSsuRnduHknKimatuVTy.setZtyhijynbrivasbujsitihsyugk(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtyhijynbrivasbujsitihsyugk());
        pKbkSsuRnduHknKimatuVTy.setZtyhijynbrivamnkjsitihsyugk(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtyhijynbrivamnkjsitihsyugk());
        pKbkSsuRnduHknKimatuVTy.setZtysiinkbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtysiinkbn());
        pKbkSsuRnduHknKimatuVTy.setZtymudkaimasikihons(pHoyuuMeisaiTyukeiyouItzHzn.getZtymudkaimasikihons());
        pKbkSsuRnduHknKimatuVTy.setZtykaimasiymd(pHoyuuMeisaiTyukeiyouItzHzn.getZtykaimasiymd());
        pKbkSsuRnduHknKimatuVTy.setZtykaimasikikan(pHoyuuMeisaiTyukeiyouItzHzn.getZtykaimasikikan());
        pKbkSsuRnduHknKimatuVTy.setZtyhikitugikaimasis(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhikitugikaimasis());
        pKbkSsuRnduHknKimatuVTy.setZtymudkaimasisiharaikingaku(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtymudkaimasisiharaikingaku());
        pKbkSsuRnduHknKimatuVTy.setZtyszoukouryokukaisiymdx1(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtyszoukouryokukaisiymdx1());
        pKbkSsuRnduHknKimatuVTy.setZtyszouhokensyuruikigoux1(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtyszouhokensyuruikigoux1());
        pKbkSsuRnduHknKimatuVTy.setZtyszoukigousedaikbnx1(pHoyuuMeisaiTyukeiyouItzHzn.getZtyszoukigousedaikbnx1());
        pKbkSsuRnduHknKimatuVTy.setZtyszoukikanx1(pHoyuuMeisaiTyukeiyouItzHzn.getZtyszoukikanx1());
        pKbkSsuRnduHknKimatuVTy.setZtyszouhihokensyaagex1(pHoyuuMeisaiTyukeiyouItzHzn.getZtyszouhihokensyaagex1());
        pKbkSsuRnduHknKimatuVTy.setZtyszoudai2hihknsyaagex1(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtyszoudai2hihknsyaagex1());
        pKbkSsuRnduHknKimatuVTy.setZtyzoukasx1(pHoyuuMeisaiTyukeiyouItzHzn.getZtyzoukasx1());
        pKbkSsuRnduHknKimatuVTy.setZtyzennendozoukasx1(pHoyuuMeisaiTyukeiyouItzHzn.getZtyzennendozoukasx1());
        pKbkSsuRnduHknKimatuVTy.setZtyszousiharaikingakux1(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtyszousiharaikingakux1());
        pKbkSsuRnduHknKimatuVTy.setZtyszoukouryokukaisiymdx2(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtyszoukouryokukaisiymdx2());
        pKbkSsuRnduHknKimatuVTy.setZtyszouhokensyuruikigoux2(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtyszouhokensyuruikigoux2());
        pKbkSsuRnduHknKimatuVTy.setZtyszoukigousedaikbnx2(pHoyuuMeisaiTyukeiyouItzHzn.getZtyszoukigousedaikbnx2());
        pKbkSsuRnduHknKimatuVTy.setZtyszoukikanx2(pHoyuuMeisaiTyukeiyouItzHzn.getZtyszoukikanx2());
        pKbkSsuRnduHknKimatuVTy.setZtyszouhihokensyaagex2(pHoyuuMeisaiTyukeiyouItzHzn.getZtyszouhihokensyaagex2());
        pKbkSsuRnduHknKimatuVTy.setZtyszoudai2hihknsyaagex2(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtyszoudai2hihknsyaagex2());
        pKbkSsuRnduHknKimatuVTy.setZtyzoukasx2(pHoyuuMeisaiTyukeiyouItzHzn.getZtyzoukasx2());
        pKbkSsuRnduHknKimatuVTy.setZtyzennendozoukasx2(pHoyuuMeisaiTyukeiyouItzHzn.getZtyzennendozoukasx2());
        pKbkSsuRnduHknKimatuVTy.setZtyszousiharaikingakux2(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtyszousiharaikingakux2());
        pKbkSsuRnduHknKimatuVTy.setZtysuuriyouyobin1x5(pHoyuuMeisaiTyukeiyouItzHzn.getZtysuuriyouyobin1x5());
        pKbkSsuRnduHknKimatuVTy.setZtysuuriyouyobin1x6(pHoyuuMeisaiTyukeiyouItzHzn.getZtysuuriyouyobin1x6());
        pKbkSsuRnduHknKimatuVTy.setZtyhrimngkizktkykpmenhyj(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtyhrimngkizktkykpmenhyj());
        pKbkSsuRnduHknKimatuVTy.setZtymisyuustartym(pHoyuuMeisaiTyukeiyouItzHzn.getZtymisyuustartym());
        pKbkSsuRnduHknKimatuVTy.setZtymisyuukaisuu(pHoyuuMeisaiTyukeiyouItzHzn.getZtymisyuukaisuu());
        pKbkSsuRnduHknKimatuVTy.setZtyitjbrtkykkousnuktkarhyj(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtyitjbrtkykkousnuktkarhyj());
        pKbkSsuRnduHknKimatuVTy.setZtygyousekihyoujis(pHoyuuMeisaiTyukeiyouItzHzn.getZtygyousekihyoujis());
        pKbkSsuRnduHknKimatuVTy.setZtysykykgyusekihyjs(pHoyuuMeisaiTyukeiyouItzHzn.getZtysykykgyusekihyjs());
        pKbkSsuRnduHknKimatuVTy.setZtytenkangyousekihyoujis(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtytenkangyousekihyoujis());
        pKbkSsuRnduHknKimatuVTy.setZtytnknteikigyousekihyjs(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtytnknteikigyousekihyjs());
        pKbkSsuRnduHknKimatuVTy.setZtytnkndpbbngyuskhyjs(pHoyuuMeisaiTyukeiyouItzHzn.getZtytnkndpbbngyuskhyjs());
        pKbkSsuRnduHknKimatuVTy.setZtykykjyoutai(pHoyuuMeisaiTyukeiyouItzHzn.getZtykykjyoutai());
        pKbkSsuRnduHknKimatuVTy.setZtypmenhukakbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtypmenhukakbn());
        pKbkSsuRnduHknKimatuVTy.setZtykousinkbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtykousinkbn());
        pKbkSsuRnduHknKimatuVTy.setZtymankiyoteikbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtymankiyoteikbn());
        pKbkSsuRnduHknKimatuVTy.setZtysykyktikmnkyoteikbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtysykyktikmnkyoteikbn());
        pKbkSsuRnduHknKimatuVTy.setZtytnknsykykkhnmnkytikbn(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtytnknsykykkhnmnkytikbn());
        pKbkSsuRnduHknKimatuVTy.setZtytnknsykyktikmnkytikbn(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtytnknsykyktikmnkytikbn());
        pKbkSsuRnduHknKimatuVTy.setZtytenkanteikimankiyoteikbn(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtytenkanteikimankiyoteikbn());
        pKbkSsuRnduHknKimatuVTy.setZtyszoumankiyoteikbnx1(pHoyuuMeisaiTyukeiyouItzHzn.getZtyszoumankiyoteikbnx1());
        pKbkSsuRnduHknKimatuVTy.setZtyszoumankiyoteikbnx2(pHoyuuMeisaiTyukeiyouItzHzn.getZtyszoumankiyoteikbnx2());
        pKbkSsuRnduHknKimatuVTy.setZtyvestingmankiyoteikbn(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtyvestingmankiyoteikbn());
        pKbkSsuRnduHknKimatuVTy.setZtyvkeisanhyouji(pHoyuuMeisaiTyukeiyouItzHzn.getZtyvkeisanhyouji());
        pKbkSsuRnduHknKimatuVTy.setZtytoukisinkeiyakuhyouji(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtytoukisinkeiyakuhyouji());
        pKbkSsuRnduHknKimatuVTy.setZtysykykhokenhoutekiyouhyj(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtysykykhokenhoutekiyouhyj());
        pKbkSsuRnduHknKimatuVTy.setZtytokuteijyoutaihushrhyj(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtytokuteijyoutaihushrhyj());
        pKbkSsuRnduHknKimatuVTy.setZtyytirrthndsysnmnskaisuu(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtyytirrthndsysnmnskaisuu());
        pKbkSsuRnduHknKimatuVTy.setZtysuuriyouyobin3(pHoyuuMeisaiTyukeiyouItzHzn.getZtysuuriyouyobin3());
        pKbkSsuRnduHknKimatuVTy.setZtysuuriyouyobin11(pHoyuuMeisaiTyukeiyouItzHzn.getZtysuuriyouyobin11());
        pKbkSsuRnduHknKimatuVTy.setZtywnasigoukeitenkankakaku(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtywnasigoukeitenkankakaku());
        pKbkSsuRnduHknKimatuVTy.setZtyyobin11(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobin11());
        pKbkSsuRnduHknKimatuVTy.setZtyyobin11x2(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobin11x2());
        pKbkSsuRnduHknKimatuVTy.setZtyyobin11x3(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobin11x3());
        pKbkSsuRnduHknKimatuVTy.setZtytukibaraikansantokujyoup(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtytukibaraikansantokujyoup());
        pKbkSsuRnduHknKimatuVTy.setZtytnkngkykkssnkijyuym(pHoyuuMeisaiTyukeiyouItzHzn.getZtytnkngkykkssnkijyuym());
        pKbkSsuRnduHknKimatuVTy.setZtysaiteihosyouhyouji(pHoyuuMeisaiTyukeiyouItzHzn.getZtysaiteihosyouhyouji());
        pKbkSsuRnduHknKimatuVTy.setZtysuuriyouyobin8x2(pHoyuuMeisaiTyukeiyouItzHzn.getZtysuuriyouyobin8x2());
        pKbkSsuRnduHknKimatuVTy.setZtysuuriyouyobin14(pHoyuuMeisaiTyukeiyouItzHzn.getZtysuuriyouyobin14());
        pKbkSsuRnduHknKimatuVTy.setZtyhrimngtkykphrkkaisuukbn(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtyhrimngtkykphrkkaisuukbn());
        pKbkSsuRnduHknKimatuVTy.setZtyhrimngtkykphrkkirkbn(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtyhrimngtkykphrkkirkbn());
        pKbkSsuRnduHknKimatuVTy.setZtyhrimngtkykpryurtkbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhrimngtkykpryurtkbn());
        pKbkSsuRnduHknKimatuVTy.setZtyyobiv13(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobiv13());
        pKbkSsuRnduHknKimatuVTy.setZtyidoujisaiteihosyoukngk(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtyidoujisaiteihosyoukngk());
        pKbkSsuRnduHknKimatuVTy.setZtyidoujisaiteihosyoucost(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtyidoujisaiteihosyoucost());
        pKbkSsuRnduHknKimatuVTy.setZtysinhokenfundtumitatekin(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtysinhokenfundtumitatekin());
        pKbkSsuRnduHknKimatuVTy.setZtymsyuptusshkgkaiykhnrikn(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtymsyuptusshkgkaiykhnrikn());
        pKbkSsuRnduHknKimatuVTy.setZtyrrthndugtnkgetumatuv(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtyrrthndugtnkgetumatuv());
        pKbkSsuRnduHknKimatuVTy.setZtyrrthndnksaiteihosyonkgns(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtyrrthndnksaiteihosyonkgns());
        pKbkSsuRnduHknKimatuVTy.setZtyrrthendougatanksibous(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtyrrthendougatanksibous());
        pKbkSsuRnduHknKimatuVTy.setZtyalmyousohutomeisyoukbn(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtyalmyousohutomeisyoukbn());
        pKbkSsuRnduHknKimatuVTy.setZtysnkyksoftmeisyoukbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtysnkyksoftmeisyoukbn());
        pKbkSsuRnduHknKimatuVTy.setZtysoftmeisyoukbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtysoftmeisyoukbn());
        pKbkSsuRnduHknKimatuVTy.setZtykykjitokujyouarihyj(pHoyuuMeisaiTyukeiyouItzHzn.getZtykykjitokujyouarihyj());
        pKbkSsuRnduHknKimatuVTy.setZtybnkttnknkbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtybnkttnknkbn());
        pKbkSsuRnduHknKimatuVTy.setZtytenkanminaosikbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtytenkanminaosikbn());
        pKbkSsuRnduHknKimatuVTy.setZtysoujikeitenkankbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtysoujikeitenkankbn());
        pKbkSsuRnduHknKimatuVTy.setZtynenkinkaisinendo(pHoyuuMeisaiTyukeiyouItzHzn.getZtynenkinkaisinendo());
        pKbkSsuRnduHknKimatuVTy.setZtynenkingatakbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtynenkingatakbn());
        pKbkSsuRnduHknKimatuVTy.setZtynknshry(pHoyuuMeisaiTyukeiyouItzHzn.getZtynknshry());
        pKbkSsuRnduHknKimatuVTy.setZtyheiyoubaraikeiyakukbn(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtyheiyoubaraikeiyakukbn());
        pKbkSsuRnduHknKimatuVTy.setZtynenkinmaruteihukakbn(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtynenkinmaruteihukakbn());
        pKbkSsuRnduHknKimatuVTy.setZtysinseizonmrtiarihyj(pHoyuuMeisaiTyukeiyouItzHzn.getZtysinseizonmrtiarihyj());
        pKbkSsuRnduHknKimatuVTy.setZtysnkykyouibokijyukbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtysnkykyouibokijyukbn());
        pKbkSsuRnduHknKimatuVTy.setZtytokusitujyuusitusetkbn(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtytokusitujyuusitusetkbn());
        pKbkSsuRnduHknKimatuVTy.setZtysiktsyuknbyugnhsyunshyj(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtysiktsyuknbyugnhsyunshyj());
        pKbkSsuRnduHknKimatuVTy.setZtypmensugugtganhsyunshyj(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtypmensugugtganhsyunshyj());
        pKbkSsuRnduHknKimatuVTy.setZtytkykgyousekihyjszerohyj(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtytkykgyousekihyjszerohyj());
        pKbkSsuRnduHknKimatuVTy.setZtysuuriyouyobin7(pHoyuuMeisaiTyukeiyouItzHzn.getZtysuuriyouyobin7());
        pKbkSsuRnduHknKimatuVTy.setZtysyussaikeitaikbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtysyussaikeitaikbn());
        pKbkSsuRnduHknKimatuVTy.setZtyyobiv6(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobiv6());
        pKbkSsuRnduHknKimatuVTy.setZtybosyuukeitaikbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtybosyuukeitaikbn());
        pKbkSsuRnduHknKimatuVTy.setZtyaatukaisosikicd(pHoyuuMeisaiTyukeiyouItzHzn.getZtyaatukaisosikicd());
        pKbkSsuRnduHknKimatuVTy.setZtyaatukaikojincd(pHoyuuMeisaiTyukeiyouItzHzn.getZtyaatukaikojincd());
        pKbkSsuRnduHknKimatuVTy.setZtybsydrtencd(pHoyuuMeisaiTyukeiyouItzHzn.getZtybsydrtencd());
        pKbkSsuRnduHknKimatuVTy.setZtycifcd(pHoyuuMeisaiTyukeiyouItzHzn.getZtycifcd());
        pKbkSsuRnduHknKimatuVTy.setZtysuuriyouyobiv8(pHoyuuMeisaiTyukeiyouItzHzn.getZtysuuriyouyobiv8());
        pKbkSsuRnduHknKimatuVTy.setZtysinsakbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtysinsakbn());
        pKbkSsuRnduHknKimatuVTy.setZtydai2hihokensyasinsakbn(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtydai2hihokensyasinsakbn());
        pKbkSsuRnduHknKimatuVTy.setZtytoukeiyousinsakbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtytoukeiyousinsakbn());
        pKbkSsuRnduHknKimatuVTy.setZtydai2toukeiyousinsakbn(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtydai2toukeiyousinsakbn());
        pKbkSsuRnduHknKimatuVTy.setZtyketteikijyunkanwakbn(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtyketteikijyunkanwakbn());
        pKbkSsuRnduHknKimatuVTy.setZtykihonsibouhyoukbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtykihonsibouhyoukbn());
        pKbkSsuRnduHknKimatuVTy.setZtyteikisibouhyoukbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtyteikisibouhyoukbn());
        pKbkSsuRnduHknKimatuVTy.setZtysonotasibouhyoukbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtysonotasibouhyoukbn());
        pKbkSsuRnduHknKimatuVTy.setZtymrarihyj(pHoyuuMeisaiTyukeiyouItzHzn.getZtymrarihyj());
        pKbkSsuRnduHknKimatuVTy.setZtysentakujyouhouarihyouji(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtysentakujyouhouarihyouji());
        pKbkSsuRnduHknKimatuVTy.setZtydugktnknsntkhuhukbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtydugktnknsntkhuhukbn());
        pKbkSsuRnduHknKimatuVTy.setZtygengakutenkankykhyj(pHoyuuMeisaiTyukeiyouItzHzn.getZtygengakutenkankykhyj());
        pKbkSsuRnduHknKimatuVTy.setZtysykgycd(pHoyuuMeisaiTyukeiyouItzHzn.getZtysykgycd());
        pKbkSsuRnduHknKimatuVTy.setZtyjidoukousinkykkanyuuymd(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtyjidoukousinkykkanyuuymd());
        pKbkSsuRnduHknKimatuVTy.setZtysaikohtnknkykkykymd(pHoyuuMeisaiTyukeiyouItzHzn.getZtysaikohtnknkykkykymd());
        pKbkSsuRnduHknKimatuVTy.setZtykousinmaesykyksburtkbn(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtykousinmaesykyksburtkbn());
        pKbkSsuRnduHknKimatuVTy.setZtyhjnkykhyj(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhjnkykhyj());
        pKbkSsuRnduHknKimatuVTy.setZtyanniskcd(pHoyuuMeisaiTyukeiyouItzHzn.getZtyanniskcd());
        pKbkSsuRnduHknKimatuVTy.setZtyhjncd(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhjncd());
        pKbkSsuRnduHknKimatuVTy.setZtyhjnjigyosyocd(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhjnjigyosyocd());
        pKbkSsuRnduHknKimatuVTy.setZtysaihokenno(pHoyuuMeisaiTyukeiyouItzHzn.getZtysaihokenno());
        pKbkSsuRnduHknKimatuVTy.setZtydakuhikettikekkacd(pHoyuuMeisaiTyukeiyouItzHzn.getZtydakuhikettikekkacd());
        pKbkSsuRnduHknKimatuVTy.setZtydai2dakuhiketteikekkacd(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtydai2dakuhiketteikekkacd());
        pKbkSsuRnduHknKimatuVTy.setZtypmenkbnv2(pHoyuuMeisaiTyukeiyouItzHzn.getZtypmenkbnv2());
        pKbkSsuRnduHknKimatuVTy.setZtysiboukyuuhukin(pHoyuuMeisaiTyukeiyouItzHzn.getZtysiboukyuuhukin());
        pKbkSsuRnduHknKimatuVTy.setZtyjyudthumeharaitkykhkhyj(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtyjyudthumeharaitkykhkhyj());
        pKbkSsuRnduHknKimatuVTy.setZtyhaitoukbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhaitoukbn());
        pKbkSsuRnduHknKimatuVTy.setZtyhhknnentysihyj(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhhknnentysihyj());
        pKbkSsuRnduHknKimatuVTy.setZtydai2hhknnentysihyj(pHoyuuMeisaiTyukeiyouItzHzn.getZtydai2hhknnentysihyj());
        pKbkSsuRnduHknKimatuVTy.setZtykyksyaagetyouseihyj(pHoyuuMeisaiTyukeiyouItzHzn.getZtykyksyaagetyouseihyj());
        pKbkSsuRnduHknKimatuVTy.setZtykituenkbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtykituenkbn());
        pKbkSsuRnduHknKimatuVTy.setZtykituenhonsuu(pHoyuuMeisaiTyukeiyouItzHzn.getZtykituenhonsuu());
        pKbkSsuRnduHknKimatuVTy.setZtymusentakukeiyakukbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtymusentakukeiyakukbn());
        pKbkSsuRnduHknKimatuVTy.setZtyyobiv6x2(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobiv6x2());
        pKbkSsuRnduHknKimatuVTy.setZtylivingneedstkykarihyj(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtylivingneedstkykarihyj());
        pKbkSsuRnduHknKimatuVTy.setZtylivingneedssiharaihyouji(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtylivingneedssiharaihyouji());
        pKbkSsuRnduHknKimatuVTy.setZtylnseikyuuymd(pHoyuuMeisaiTyukeiyouItzHzn.getZtylnseikyuuymd());
        pKbkSsuRnduHknKimatuVTy.setZtylnshrgenincd(pHoyuuMeisaiTyukeiyouItzHzn.getZtylnshrgenincd());
        pKbkSsuRnduHknKimatuVTy.setZtydakuhikettisyacd(pHoyuuMeisaiTyukeiyouItzHzn.getZtydakuhikettisyacd());
        pKbkSsuRnduHknKimatuVTy.setZtydai2dakuhiketteisyacd(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtydai2dakuhiketteisyacd());
        pKbkSsuRnduHknKimatuVTy.setZtygansapotokuyakuarihyouji(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtygansapotokuyakuarihyouji());
        pKbkSsuRnduHknKimatuVTy.setZtygnspshrhyj(pHoyuuMeisaiTyukeiyouItzHzn.getZtygnspshrhyj());
        pKbkSsuRnduHknKimatuVTy.setZtygansaposeikyuuymd(pHoyuuMeisaiTyukeiyouItzHzn.getZtygansaposeikyuuymd());
        pKbkSsuRnduHknKimatuVTy.setZtygnspshrgenincd(pHoyuuMeisaiTyukeiyouItzHzn.getZtygnspshrgenincd());
        pKbkSsuRnduHknKimatuVTy.setZtyyobiv3x2(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobiv3x2());
        pKbkSsuRnduHknKimatuVTy.setZtytargetmokuhyouritu(pHoyuuMeisaiTyukeiyouItzHzn.getZtytargetmokuhyouritu());
        pKbkSsuRnduHknKimatuVTy.setZtyautoswitchmokuhyouritu(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtyautoswitchmokuhyouritu());
        pKbkSsuRnduHknKimatuVTy.setZtytumitatekinitenarihyj(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtytumitatekinitenarihyj());
        pKbkSsuRnduHknKimatuVTy.setZtytumitatekinitenkaisuu(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtytumitatekinitenkaisuu());
        pKbkSsuRnduHknKimatuVTy.setZtydatakanrino2(pHoyuuMeisaiTyukeiyouItzHzn.getZtydatakanrino2());
        pKbkSsuRnduHknKimatuVTy.setZtydatakanrino3(pHoyuuMeisaiTyukeiyouItzHzn.getZtydatakanrino3());
        pKbkSsuRnduHknKimatuVTy.setZtyknkuzusnzyrttekinendo(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtyknkuzusnzyrttekinendo());
        pKbkSsuRnduHknKimatuVTy.setZtyknkuzusnzyrt(pHoyuuMeisaiTyukeiyouItzHzn.getZtyknkuzusnzyrt());
        pKbkSsuRnduHknKimatuVTy.setZtyknkuzusnzyrtx2(pHoyuuMeisaiTyukeiyouItzHzn.getZtyknkuzusnzyrtx2());
        pKbkSsuRnduHknKimatuVTy.setZtyknkuzusnzyrtx3(pHoyuuMeisaiTyukeiyouItzHzn.getZtyknkuzusnzyrtx3());
        pKbkSsuRnduHknKimatuVTy.setZtysinkeiyakujiknkuzusnzyrt(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtysinkeiyakujiknkuzusnzyrt());
        pKbkSsuRnduHknKimatuVTy.setZtytenkanjiknkuzusnzyrt(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtytenkanjiknkuzusnzyrt());
        pKbkSsuRnduHknKimatuVTy.setZtysinkeiyakujivithkhyouji(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtysinkeiyakujivithkhyouji());
        pKbkSsuRnduHknKimatuVTy.setZtykykjivithukusuukykhyj(pHoyuuMeisaiTyukeiyouItzHzn.getZtykykjivithukusuukykhyj());
        pKbkSsuRnduHknKimatuVTy.setZtysuuriyouyobin9x2(pHoyuuMeisaiTyukeiyouItzHzn.getZtysuuriyouyobin9x2());
        pKbkSsuRnduHknKimatuVTy.setZtypwrbksidhitekiyouhyj(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtypwrbksidhitekiyouhyj());
        pKbkSsuRnduHknKimatuVTy.setZtysuuriyouyobin9(pHoyuuMeisaiTyukeiyouItzHzn.getZtysuuriyouyobin9());
        pKbkSsuRnduHknKimatuVTy.setZtysuuriyouyobin10x7(pHoyuuMeisaiTyukeiyouItzHzn.getZtysuuriyouyobin10x7());
        pKbkSsuRnduHknKimatuVTy.setZtysuuriyouyobin10x8(pHoyuuMeisaiTyukeiyouItzHzn.getZtysuuriyouyobin10x8());
        pKbkSsuRnduHknKimatuVTy.setZtysuuriyouyobin10x9(pHoyuuMeisaiTyukeiyouItzHzn.getZtysuuriyouyobin10x9());
        pKbkSsuRnduHknKimatuVTy.setZtytumitatekinitenbubun(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtytumitatekinitenbubun());
        pKbkSsuRnduHknKimatuVTy.setZtysagakusknnjynbknzndk(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtysagakusknnjynbknzndk());
        pKbkSsuRnduHknKimatuVTy.setZtyyobin11x5(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobin11x5());
        pKbkSsuRnduHknKimatuVTy.setZtyyobin11x6(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobin11x6());
        pKbkSsuRnduHknKimatuVTy.setZtyyobin11x7(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobin11x7());
        pKbkSsuRnduHknKimatuVTy.setZtyyobin11x8(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobin11x8());
        pKbkSsuRnduHknKimatuVTy.setZtyyobin11x9(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobin11x9());
        pKbkSsuRnduHknKimatuVTy.setZtyyobin11x10(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobin11x10());
        pKbkSsuRnduHknKimatuVTy.setZtyyobin11x11(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobin11x11());
        pKbkSsuRnduHknKimatuVTy.setZtyyobin11x12(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobin11x12());
        pKbkSsuRnduHknKimatuVTy.setZtyyobin11x13(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobin11x13());
        pKbkSsuRnduHknKimatuVTy.setZtyyobin11x14(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobin11x14());
        pKbkSsuRnduHknKimatuVTy.setZtyyobin11x15(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobin11x15());
        pKbkSsuRnduHknKimatuVTy.setZtyyobin11x16(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobin11x16());
        pKbkSsuRnduHknKimatuVTy.setZtyyobin11x17(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobin11x17());
        pKbkSsuRnduHknKimatuVTy.setZtyzyrthntiyustatuskbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtyzyrthntiyustatuskbn());
        pKbkSsuRnduHknKimatuVTy.setZtyzyrthntiyustatuskbnx2(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtyzyrthntiyustatuskbnx2());
        pKbkSsuRnduHknKimatuVTy.setZtyzyrthntiyustatuskbnx3(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtyzyrthntiyustatuskbnx3());
        pKbkSsuRnduHknKimatuVTy.setZtyzyrthntiyustatuskbnx4(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtyzyrthntiyustatuskbnx4());
        pKbkSsuRnduHknKimatuVTy.setZtyzyrthntiyustatuskbnx5(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtyzyrthntiyustatuskbnx5());
        pKbkSsuRnduHknKimatuVTy.setZtyyobiv10(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobiv10());
        pKbkSsuRnduHknKimatuVTy.setZtyyobiv15x2(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobiv15x2());
        pKbkSsuRnduHknKimatuVTy.setZtyyobiv15x3(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobiv15x3());
        pKbkSsuRnduHknKimatuVTy.setZtyyobiv15x4(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobiv15x4());
        pKbkSsuRnduHknKimatuVTy.setZtygaikakbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtygaikakbn());
        pKbkSsuRnduHknKimatuVTy.setZtykawaserate1(pHoyuuMeisaiTyukeiyouItzHzn.getZtykawaserate1());
        pKbkSsuRnduHknKimatuVTy.setZtykawaseratetekiyouymd1(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtykawaseratetekiyouymd1());
        pKbkSsuRnduHknKimatuVTy.setZtykawaserate2(pHoyuuMeisaiTyukeiyouItzHzn.getZtykawaserate2());
        pKbkSsuRnduHknKimatuVTy.setZtykawaseratetekiyouymd2(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtykawaseratetekiyouymd2());
        pKbkSsuRnduHknKimatuVTy.setZtykykjikawaserate(pHoyuuMeisaiTyukeiyouItzHzn.getZtykykjikawaserate());
        pKbkSsuRnduHknKimatuVTy.setZtykykjikawaseratetkyuymd(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtykykjikawaseratetkyuymd());
        pKbkSsuRnduHknKimatuVTy.setZtymvatyouseigow(pHoyuuMeisaiTyukeiyouItzHzn.getZtymvatyouseigow());
        pKbkSsuRnduHknKimatuVTy.setZtymvakeisanjisknnjynbkn(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtymvakeisanjisknnjynbkn());
        pKbkSsuRnduHknKimatuVTy.setZtykaiyakukoujyoritu(pHoyuuMeisaiTyukeiyouItzHzn.getZtykaiyakukoujyoritu());
        pKbkSsuRnduHknKimatuVTy.setZtyrendouritu(pHoyuuMeisaiTyukeiyouItzHzn.getZtyrendouritu());
        pKbkSsuRnduHknKimatuVTy.setZtysrkaiyakusjkkktyouseirrt(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtysrkaiyakusjkkktyouseirrt());
        pKbkSsuRnduHknKimatuVTy.setZtysrkyksjkkktyouseiriritu(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtysrkyksjkkktyouseiriritu());
        pKbkSsuRnduHknKimatuVTy.setZtymvakeisankijyunymd(pHoyuuMeisaiTyukeiyouItzHzn.getZtymvakeisankijyunymd());
        pKbkSsuRnduHknKimatuVTy.setZtymvatyouseikou(pHoyuuMeisaiTyukeiyouItzHzn.getZtymvatyouseikou());
        pKbkSsuRnduHknKimatuVTy.setZtyenkdtsbujsitihsyukngk(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtyenkdtsbujsitihsyukngk());
        pKbkSsuRnduHknKimatuVTy.setZtyenkdtsbujsitihsyucost(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtyenkdtsbujsitihsyucost());
        pKbkSsuRnduHknKimatuVTy.setZtyenkdtsbujsitihsyuarihyj(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtyenkdtsbujsitihsyuarihyj());
        pKbkSsuRnduHknKimatuVTy.setZtykeiyakujiyoteiriritu(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtykeiyakujiyoteiriritu());
        pKbkSsuRnduHknKimatuVTy.setZtytumitateriritu(pHoyuuMeisaiTyukeiyouItzHzn.getZtytumitateriritu());
        pKbkSsuRnduHknKimatuVTy.setZtykaigomaebaraitkykarihyj(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtykaigomaebaraitkykarihyj());
        pKbkSsuRnduHknKimatuVTy.setZtysibouhyoukbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtysibouhyoukbn());
        pKbkSsuRnduHknKimatuVTy.setZtynyuukintuukakbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtynyuukintuukakbn());
        pKbkSsuRnduHknKimatuVTy.setZtysiharaituukakbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtysiharaituukakbn());
        pKbkSsuRnduHknKimatuVTy.setZtywyendttargetmokuhyouritu(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtywyendttargetmokuhyouritu());
        pKbkSsuRnduHknKimatuVTy.setZtysisuurendourate(pHoyuuMeisaiTyukeiyouItzHzn.getZtysisuurendourate());
        pKbkSsuRnduHknKimatuVTy.setZtysisuukbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtysisuukbn());
        pKbkSsuRnduHknKimatuVTy.setZtyteirituikouhyouji(pHoyuuMeisaiTyukeiyouItzHzn.getZtyteirituikouhyouji());
        pKbkSsuRnduHknKimatuVTy.setZtysuuriyouyobin10x11(pHoyuuMeisaiTyukeiyouItzHzn.getZtysuuriyouyobin10x11());
        pKbkSsuRnduHknKimatuVTy.setZtytmttknzoukaritujygn(pHoyuuMeisaiTyukeiyouItzHzn.getZtytmttknzoukaritujygn());
        pKbkSsuRnduHknKimatuVTy.setZtysetteibairitu(pHoyuuMeisaiTyukeiyouItzHzn.getZtysetteibairitu());
        pKbkSsuRnduHknKimatuVTy.setZtytykzenoutouymdsisuu(pHoyuuMeisaiTyukeiyouItzHzn.getZtytykzenoutouymdsisuu());
        pKbkSsuRnduHknKimatuVTy.setZtykimatusisuu(pHoyuuMeisaiTyukeiyouItzHzn.getZtykimatusisuu());
        pKbkSsuRnduHknKimatuVTy.setZtyyenkadatekihons(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyenkadatekihons());
        pKbkSsuRnduHknKimatuVTy.setZtysitihsyumegkdtsibous(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtysitihsyumegkdtsibous());
        pKbkSsuRnduHknKimatuVTy.setZtyenkdtssrentumitatekin(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtyenkdtssrentumitatekin());
        pKbkSsuRnduHknKimatuVTy.setZtysisuurentumitatekin(pHoyuuMeisaiTyukeiyouItzHzn.getZtysisuurentumitatekin());
        pKbkSsuRnduHknKimatuVTy.setZtynksjitirttumitatekin(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtynksjitirttumitatekin());
        pKbkSsuRnduHknKimatuVTy.setZtykimatutirttumitatekin(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtykimatutirttumitatekin());
        pKbkSsuRnduHknKimatuVTy.setZtygaikadatejyuutoup(pHoyuuMeisaiTyukeiyouItzHzn.getZtygaikadatejyuutoup());
        pKbkSsuRnduHknKimatuVTy.setZtyyendttargetkijyunkingaku(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtyyendttargetkijyunkingaku());
        pKbkSsuRnduHknKimatuVTy.setZtyyobiv7(pHoyuuMeisaiTyukeiyouItzHzn.getZtyyobiv7());
        pKbkSsuRnduHknKimatuVTy.setZtysitivkisnyukykjikwsrate(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtysitivkisnyukykjikwsrate());
        pKbkSsuRnduHknKimatuVTy.setZtysisuurentyokugotmttkn(pHoyuuMeisaiTyukeiyouItzHzn.getZtysisuurentyokugotmttkn());
        pKbkSsuRnduHknKimatuVTy.setZtyrrthnduhknvkisovkisnyu1(pHoyuuMeisaiTyukeiyouItzHzn.
            getZtyrrthnduhknvkisovkisnyu1());
    }

    private void editKbkSsuRnduHknKimatuVTyData(SrKbkSsuRnduHknKimatuVBatchParam pBatchParam,
        ST_HoyuuMeisaiTyukeiyouItzHzn pHoyuuMeisaiTyukeiyouItzHzn,
        TkJitenKeiyakuSyouhinKijyunBean pTkJitenKeiyakuSyouhinKijyunBean,
        ZT_KbkSsuRnduHknKimatuVTy pKbkSsuRnduHknKimatuVTy,
        List<SV_KiykSyuhnData> pSvKiykSyuhnDataLst) {

        SrKbkSsuRnduHknKimatuVBatchDbAccess srKbkSsuRnduHknKimatuVBatchDbAccess =
            SWAKInjector.getInstance(SrKbkSsuRnduHknKimatuVBatchDbAccess.class);
        List<IT_KhSisuurendoTmttkn> khSisuurendoTmttknLst;
        IT_KhSisuurendoTmttkn khSisuurendoTmttkn;

        if (BizDateUtil.compareYmd(pBatchParam.getKijyunymd(),
            pTkJitenKeiyakuSyouhinKijyunBean.getKykymd()) == BizDateUtil.COMPARE_LESSER) {

            khSisuurendoTmttknLst = srKbkSsuRnduHknKimatuVBatchDbAccess.
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

        pKbkSsuRnduHknKimatuVTy.setZtyvkimatutirttumitatekin(pHoyuuMeisaiTyukeiyouItzHzn
            .getZtykimatutirttumitatekin());
        pKbkSsuRnduHknKimatuVTy.setZtykimatusisuutumitatekin(pHoyuuMeisaiTyukeiyouItzHzn
            .getZtysisuurentumitatekin());
        pKbkSsuRnduHknKimatuVTy.setZtyvyoutykzenoutouymdsisuu(pHoyuuMeisaiTyukeiyouItzHzn.getZtytykzenoutouymdsisuu());
        if (tykzensisuukijyunymd != null) {
            pKbkSsuRnduHknKimatuVTy.setZtytykzensisuukijyunymd(tykzensisuukijyunymd.toString());
        }
        pKbkSsuRnduHknKimatuVTy.setZtyvyoukimatusisuu(vyoukimatuSisuu);
        if (kmtSisuukijyunYmd != null) {
            pKbkSsuRnduHknKimatuVTy.setZtykmtsisuukijyunymd(kmtSisuukijyunYmd.toString());
        }
        pKbkSsuRnduHknKimatuVTy.setZtyvyoutmttknzoukaritujygn(pHoyuuMeisaiTyukeiyouItzHzn
            .getZtytmttknzoukaritujygn());
        pKbkSsuRnduHknKimatuVTy.setZtyvyousetteibairitu(pHoyuuMeisaiTyukeiyouItzHzn.getZtysetteibairitu());
        pKbkSsuRnduHknKimatuVTy.setZtyvyourendouritu(pHoyuuMeisaiTyukeiyouItzHzn.getZtyrendouritu());
        pKbkSsuRnduHknKimatuVTy.setZtykimatusisuutyokugotmttkn(pHoyuuMeisaiTyukeiyouItzHzn.getZtysisuurentyokugotmttkn());
        pKbkSsuRnduHknKimatuVTy.setZtyjmttirttumitatekinnplus0(Long.parseLong(jmtTirtTumitatekins[0].toAdsoluteString()));
        pKbkSsuRnduHknKimatuVTy.setZtyjmttirttumitatekinnplus1(Long.parseLong(jmtTirtTumitatekins[1].toAdsoluteString()));
        pKbkSsuRnduHknKimatuVTy.setZtyjmttirttumitatekinnplus2(Long.parseLong(jmtTirtTumitatekins[2].toAdsoluteString()));
        pKbkSsuRnduHknKimatuVTy.setZtyjmtssutumitatekinnplus0(Long.parseLong(jmtSisuuTumitatekins[0].toAdsoluteString()));
        pKbkSsuRnduHknKimatuVTy.setZtyjmtssutumitatekinnplus1(Long.parseLong(jmtSisuuTumitatekins[1].toAdsoluteString()));
        pKbkSsuRnduHknKimatuVTy.setZtyjmtssutumitatekinnplus2(Long.parseLong(jmtSisuuTumitatekins[2].toAdsoluteString()));
        pKbkSsuRnduHknKimatuVTy.setZtyjmtmvatyouseigownplus0(Long.parseLong(jmtMvaTyouseigoWs[0].toAdsoluteString()));
        pKbkSsuRnduHknKimatuVTy.setZtyjmtmvakeisanjiwnplus0(Long.parseLong(jmtMvaKeisanjiVs[0].toAdsoluteString()));
        pKbkSsuRnduHknKimatuVTy.setZtyjmtmvatyouseigownplus1(Long.parseLong(jmtMvaTyouseigoWs[1].toAdsoluteString()));
        pKbkSsuRnduHknKimatuVTy.setZtyjmtmvakeisanjiwnplus1(Long.parseLong(jmtMvaKeisanjiVs[1].toAdsoluteString()));
        pKbkSsuRnduHknKimatuVTy.setZtyjmtmvatyouseigownplus2(Long.parseLong(jmtMvaTyouseigoWs[2].toAdsoluteString()));
        pKbkSsuRnduHknKimatuVTy.setZtyjmtmvakeisanjiwnplus2(Long.parseLong(jmtMvaKeisanjiVs[2].toAdsoluteString()));
    }
}
