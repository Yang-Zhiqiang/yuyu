package yuyu.batch.suuri.srsuuritoukei.srkyhkinshrjyukyurnrk;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBTransactionalUtil;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.CurrencyType;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.GetSjkkktyouseiyouriritu;
import yuyu.common.biz.bzcommon.GetSjkkktyouseiyourirituBean;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.bzcommon.SetHokenNenrei;
import yuyu.common.siharai.sicommon.CalcHkShrKngk;
import yuyu.common.suuri.srcommon.SrCommonConstants;
import yuyu.common.suuri.srcommon.SrSuuriKbnHenkanBean;
import yuyu.common.suuri.srcommon.SrSuuriKbnHenkanSet;
import yuyu.common.suuri.suuricommon.TkJitenKeiyakuSyouhinKijyunBean;
import yuyu.def.MessageId;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HokenkinsyuruiKbn;
import yuyu.def.classification.C_SiinKbn;
import yuyu.def.classification.C_SrKbnHenkanKbn;
import yuyu.def.classification.C_TodouhukenKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.IT_KykDairiten;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.JT_SiRireki;
import yuyu.def.db.entity.JT_SkJiyuu;
import yuyu.def.db.entity.ST_SuuriyouErrJyouhou;
import yuyu.def.db.entity.ZT_KyhknShrJyoukyouRnrkTy;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 数理統計 数理統計 給付金支払状況連絡情報作成の項目編集クラス
 */
public class SrKyhkinShrJyukyuRnrkBatchEdit {

    private boolean errorFlag;

    private static final String TKSYURUIKIGOU_ZTYNAIZOUGATA = "01";

    private static final String TOKUYAKUKATAKBN_KATANASI = "0";

    private static final String TOHUKAKBN_SKDOUJIHUKA = "1";

    private static final String HYOUKATAIKBN_HYOUJYUNNTAI = "1";

    private static final String TKYKDAI2HIHOKENSYAHYJ_TANNSEIORRENNSEI1HI = "0";

    private static final String KYHKBN_SGSBHSYKDSIN = "9";

    private static final String SIHARAIJYOUTAIKBN_SIHARAI = "0";

    private static final String SYOUINCD_SIBOUKOUDOSG = "100";

    private static final String KYUUHUWARIAI_SGSBHSYKDSIN = "000";

    private static final String SAIGAIGENINCD_SGSBHSYKDSIN = "0";

    private static final String BOSYUUKEIROKBN_BANKMDHN = "1";

    private static final String MESSAGEARG = "死亡保険金";

    private static final String MESSAGEGS = "市場価格調整用利率";

    @Inject
    private BatchLogger batchLogger;

    public SrKyhkinShrJyukyuRnrkBatchEdit() {
        super();
        errorFlag = false;
    }

    public boolean editKoumoku(SrKyhkinShrJyukyuRnrkBatchParam pSrKyhkinShrJyukyuRnrkBatchParam, JT_SiRireki pSiRireki,
        JT_SkJiyuu pSkJiyuu, IT_KykDairiten pKykDairiten, IT_KykSonotaTkyk pKykSonotaTkyk, IT_KykKihon pKykKihon,
        BM_SyouhnZokusei pSyouhnZokusei, TkJitenKeiyakuSyouhinKijyunBean pTkJitenKeiyakuSyouhinKijyunBean,
        ZT_KyhknShrJyoukyouRnrkTy pKyhknShrJyoukyouRnrkTy) {

        editTkhasseirtIdouDataKoumoku(pSrKyhkinShrJyukyuRnrkBatchParam, pSiRireki, pKykDairiten, pKykKihon,
            pTkJitenKeiyakuSyouhinKijyunBean, pKyhknShrJyoukyouRnrkTy);

        editTkhasseirtIdouRayKoumoku(pSrKyhkinShrJyukyuRnrkBatchParam, pSkJiyuu, pKykSonotaTkyk, pKykKihon,
            pSyouhnZokusei, pTkJitenKeiyakuSyouhinKijyunBean, pKyhknShrJyoukyouRnrkTy);

        return errorFlag;
    }

    private void editTkhasseirtIdouDataKoumoku(SrKyhkinShrJyukyuRnrkBatchParam pSrKyhkinShrJyukyuRnrkBatchParam,
        JT_SiRireki pSiRireki, IT_KykDairiten pKykDairiten, IT_KykKihon pKykKihon,
        TkJitenKeiyakuSyouhinKijyunBean pTkJitenKeiyakuSyouhinKijyunBean,
        ZT_KyhknShrJyoukyouRnrkTy pKyhknShrJyoukyouRnrkTy) {

        int sequenceNo = pSrKyhkinShrJyukyuRnrkBatchParam.getSyoriKensuu();

        String todoufukencd = pKykKihon.getDrtenkanritodoufukencd();

        if (C_TodouhukenKbn.BLNK.getValue().equals(todoufukencd)) {

            todoufukencd = C_TodouhukenKbn.OSAKA.getValue();
        }

        String hhknnenTysiHyj = "";
        SetHokenNenrei setHokenNenrei = SWAKInjector.getInstance(SetHokenNenrei.class);

        int hhknHkNenrei = setHokenNenrei.exec(
            pTkJitenKeiyakuSyouhinKijyunBean.getKykymd(),
            pTkJitenKeiyakuSyouhinKijyunBean.getHhknseiymd());

        if (pTkJitenKeiyakuSyouhinKijyunBean.getHhknnen() != hhknHkNenrei) {

            hhknnenTysiHyj = SrCommonConstants.HYOUJI_ARI;
        }
        else {

            hhknnenTysiHyj = SrCommonConstants.HYOUJI_NASI;
        }

        String bosyuKeitaiKbn = "";
        SrSuuriKbnHenkanSet srSuuriKbnHenkanSet = SWAKInjector.getInstance(SrSuuriKbnHenkanSet.class);
        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(
            C_SrKbnHenkanKbn.BOSYU_KEITAI,
            pKykDairiten.getDrtencd());

        if (C_ErrorKbn.ERROR.eq(srSuuriKbnHenkanBean.getKekkaKbn())) {

            String errorMessage = MessageUtil.getMessage(MessageId.ESA1002, C_SrKbnHenkanKbn.BOSYU_KEITAI.getContent(),
                pKykKihon.getSyono(), pKykDairiten.getDrtencd());

            batchLogger.warn(errorMessage);

            ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();
            suuriyouErrJyouhou.setSyoriYmd(pSrKyhkinShrJyukyuRnrkBatchParam.getSyoriYmd());
            suuriyouErrJyouhou.setKakutyoujobcd(pSrKyhkinShrJyukyuRnrkBatchParam.getIbKakutyoujobcd());
            suuriyouErrJyouhou.setSyono(pKykKihon.getSyono());
            suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(errorMessage);
            suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

            BizPropertyInitializer.initialize(suuriyouErrJyouhou);

            ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

            pSrKyhkinShrJyukyuRnrkBatchParam.setErrorSyoriKensuu(pSrKyhkinShrJyukyuRnrkBatchParam.getErrorSyoriKensuu() + 1);
            errorFlag = true;
        }
        else {

            bosyuKeitaiKbn = srSuuriKbnHenkanBean.getHenkanAtoKbn();
        }

        pKyhknShrJyoukyouRnrkTy.setZtysequenceno(sequenceNo);
        pKyhknShrJyoukyouRnrkTy.setZtydatakanrino(pKykKihon.getSyono());
        pKyhknShrJyoukyouRnrkTy.setZtytksyukgu(TKSYURUIKIGOU_ZTYNAIZOUGATA);
        pKyhknShrJyoukyouRnrkTy.setZtytokuyakugatakbn(TOKUYAKUKATAKBN_KATANASI);
        pKyhknShrJyoukyouRnrkTy.setZtytokuyakukisi(pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().toString());
        pKyhknShrJyoukyouRnrkTy.setZtyhknsyukigou(pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd());
        pKyhknShrJyoukyouRnrkTy.setZtytyuutohukakbn(TOHUKAKBN_SKDOUJIHUKA);
        pKyhknShrJyoukyouRnrkTy.setZtyhyoukataikbn(HYOUKATAIKBN_HYOUJYUNNTAI);
        pKyhknShrJyoukyouRnrkTy.setZtyatukaisisyatodouhukencd(todoufukencd);
        pKyhknShrJyoukyouRnrkTy.setZtytokuyakusinkyuukbn(SrCommonConstants.DEFAULT_STRING_ZERO_1);
        pKyhknShrJyoukyouRnrkTy.setZtybsyym(pKykKihon.getBosyuuym().toString());
        pKyhknShrJyoukyouRnrkTy.setZtytkykdai2hihokensyahyj(TKYKDAI2HIHOKENSYAHYJ_TANNSEIORRENNSEI1HI);
        pKyhknShrJyoukyouRnrkTy.setZtyjyusyousyaseibetukbn(pTkJitenKeiyakuSyouhinKijyunBean.getHhknsei().getValue());
        pKyhknShrJyoukyouRnrkTy.setZtykeiyakunen(pTkJitenKeiyakuSyouhinKijyunBean.getHhknnen().toString());
        pKyhknShrJyoukyouRnrkTy.setZtymannenreihyj(SrCommonConstants.HYOUJI_ARI);
        pKyhknShrJyoukyouRnrkTy.setZtyhhknnentysihyj(hhknnenTysiHyj);
        pKyhknShrJyoukyouRnrkTy.setZtykyuuhukbn(KYHKBN_SGSBHSYKDSIN);
        pKyhknShrJyoukyouRnrkTy.setZtysiharaijyoutaikbn(SIHARAIJYOUTAIKBN_SIHARAI);
        pKyhknShrJyoukyouRnrkTy.setZtysyouincd(SYOUINCD_SIBOUKOUDOSG);
        pKyhknShrJyoukyouRnrkTy.setZtyjikohasseiymd2(pTkJitenKeiyakuSyouhinKijyunBean.getSyoumetuymd().toString());
        pKyhknShrJyoukyouRnrkTy.setZtyshrymd(pSiRireki.getTyakkinymd().toString());
        pKyhknShrJyoukyouRnrkTy.setZtykyuuhuwariai(KYUUHUWARIAI_SGSBHSYKDSIN);
        pKyhknShrJyoukyouRnrkTy.setZtysiboukoudosyougaicd(SrCommonConstants.DEFAULT_STRING_ZERO_1);
        pKyhknShrJyoukyouRnrkTy.setZtysaigaigenincd(SAIGAIGENINCD_SGSBHSYKDSIN);
        pKyhknShrJyoukyouRnrkTy.setZtybosyuukeirokbn(BOSYUUKEIROKBN_BANKMDHN);
        pKyhknShrJyoukyouRnrkTy.setZtytoukeiyousinsakbn(SrCommonConstants.TOUKEIYOUSINSAKBN_KOKUTISYO);
        pKyhknShrJyoukyouRnrkTy.setZtypmenhukakbn(SrCommonConstants.PMENHUKAKBN_PMENTKYKNASI);
        pKyhknShrJyoukyouRnrkTy.setZtyketteikijyunkanwakbn(SrCommonConstants.DEFAULT_STRING_ZERO_1);
        pKyhknShrJyoukyouRnrkTy.setZtyhknsyuruikigousedaikbn(pTkJitenKeiyakuSyouhinKijyunBean.getRyouritusdno());
        pKyhknShrJyoukyouRnrkTy.setZtytokuyakukigousedaikbn(SrCommonConstants.DEFAULT_STRING_ZERO_1);
        pKyhknShrJyoukyouRnrkTy.setZtysotodasipmenkbn(SrCommonConstants.HKNSYKGUYBI3X2_PMENTKYKNASI);
        pKyhknShrJyoukyouRnrkTy.setZtystdssnskbn(SrCommonConstants.HKNSYKGUYBI3X1_MUSINSA);
        pKyhknShrJyoukyouRnrkTy.setZtybosyuukeitaikbn(bosyuKeitaiKbn);
        pKyhknShrJyoukyouRnrkTy.setZtyhokenhoutekiyouhyouji(SrCommonConstants.HYOUJI_ARI);
        pKyhknShrJyoukyouRnrkTy.setZtysotodasiphkbnmnoshyouji(SrCommonConstants.HYOUJI_ARI);
        pKyhknShrJyoukyouRnrkTy.setZtysisyacd(pKykDairiten.getDrtenkanrisosikicd().substring(0, 3));
        pKyhknShrJyoukyouRnrkTy.setZtysykgycd(pKykKihon.getHhknsykgycd());
        pKyhknShrJyoukyouRnrkTy.setZtystdssytikbn(SrCommonConstants.HKNSYKGUYBI1X1_SONOTA);
        pKyhknShrJyoukyouRnrkTy.setZtyhisei(pTkJitenKeiyakuSyouhinKijyunBean.getHhknsei().getValue());
        pKyhknShrJyoukyouRnrkTy.setZtytokuyakuhinen(pTkJitenKeiyakuSyouhinKijyunBean.getHhknnen().toString());
        pKyhknShrJyoukyouRnrkTy.setZtykykymd(pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().toString());

    }

    private void editTkhasseirtIdouRayKoumoku(SrKyhkinShrJyukyuRnrkBatchParam pSrKyhkinShrJyukyuRnrkBatchParam,
        JT_SkJiyuu pSkJiyuu, IT_KykSonotaTkyk pKykSonotaTkyk, IT_KykKihon pKykKihon, BM_SyouhnZokusei pSyouhnZokusei,
        TkJitenKeiyakuSyouhinKijyunBean pTkJitenKeiyakuSyouhinKijyunBean,
        ZT_KyhknShrJyoukyouRnrkTy pKyhknShrJyoukyouRnrkTy) {

        String gaikaKbn = "";
        String errorMessage = "";
        SrSuuriKbnHenkanSet srSuuriKbnHenkanSet = SWAKInjector.getInstance(SrSuuriKbnHenkanSet.class);
        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(
            C_SrKbnHenkanKbn.SUURI_KEIYAKUDATE_TUUKA,
            pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu().getValue());

        if (C_ErrorKbn.ERROR.eq(srSuuriKbnHenkanBean.getKekkaKbn())) {

            errorMessage = MessageUtil.getMessage(MessageId.ESA1002,
                C_SrKbnHenkanKbn.SUURI_KEIYAKUDATE_TUUKA.getContent(),
                pKykKihon.getSyono(),
                pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu().getValue());

            batchLogger.warn(errorMessage);

            ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();
            suuriyouErrJyouhou.setSyoriYmd(pSrKyhkinShrJyukyuRnrkBatchParam.getSyoriYmd());
            suuriyouErrJyouhou.setKakutyoujobcd(pSrKyhkinShrJyukyuRnrkBatchParam.getIbKakutyoujobcd());
            suuriyouErrJyouhou.setSyono(pKykKihon.getSyono());
            suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(errorMessage);
            suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

            BizPropertyInitializer.initialize(suuriyouErrJyouhou);

            ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

            pSrKyhkinShrJyukyuRnrkBatchParam.setErrorSyoriKensuu(pSrKyhkinShrJyukyuRnrkBatchParam.getErrorSyoriKensuu() + 1);
            errorFlag = true;
        }
        else {

            gaikaKbn = srSuuriKbnHenkanBean.getHenkanAtoKbn();
        }

        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
        CurrencyType currencyType = henkanTuuka.henkanTuukaKbnToType(pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu());
        BizCurrency sibousGk = BizCurrency.valueOf(0, currencyType);
        CalcHkShrKngk calcHkShrKngk = SWAKInjector.getInstance(CalcHkShrKngk.class);
        BizCurrency mvaTyouseigoW = BizCurrency.valueOf(0, currencyType);
        BizCurrency mvaKeisanjiSknnJynbkn = BizCurrency.valueOf(0, currencyType);
        GetSjkkktyouseiyouriritu getSjkkktyouseiyouriritu = SWAKInjector.getInstance(GetSjkkktyouseiyouriritu.class);
        GetSjkkktyouseiyourirituBean getSjkkktyouseiyourirituBean =
            SWAKInjector.getInstance(GetSjkkktyouseiyourirituBean.class);
        BizNumber sjkkktyouseiyouriritu = BizNumber.valueOf(0);
        BizDateYM tmttkntaisyouYm = null;
        BizCurrency teiritutmttKngk = BizCurrency.valueOf(0, currencyType);
        BizCurrency sisuurendoutmttKngk = BizCurrency.valueOf(0, currencyType);
        BizNumber tumitateRiritu = BizNumber.valueOf(0);

        getSjkkktyouseiyourirituBean.setSyouhncd(pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd());
        getSjkkktyouseiyourirituBean.setKijyunymd(pSkJiyuu.getSibouymd());
        getSjkkktyouseiyourirituBean.setHknkkn(pTkJitenKeiyakuSyouhinKijyunBean.getHknkkn());
        getSjkkktyouseiyourirituBean.setHknkknsmnkbn(pTkJitenKeiyakuSyouhinKijyunBean.getHknkknsmnKbn());
        getSjkkktyouseiyourirituBean.setHhknnen(pTkJitenKeiyakuSyouhinKijyunBean.getHhknnen());

        C_ErrorKbn errorGs = getSjkkktyouseiyouriritu.exec(getSjkkktyouseiyourirituBean);
        if (C_ErrorKbn.ERROR.eq(errorGs)) {

            errorMessage = MessageUtil.getMessage(MessageId.ESA1001, MESSAGEGS, pKykKihon.getSyono());

            batchLogger.warn(errorMessage);

            ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();
            suuriyouErrJyouhou.setSyoriYmd(pSrKyhkinShrJyukyuRnrkBatchParam.getSyoriYmd());
            suuriyouErrJyouhou.setKakutyoujobcd(pSrKyhkinShrJyukyuRnrkBatchParam.getIbKakutyoujobcd());
            suuriyouErrJyouhou.setSyono(pKykKihon.getSyono());
            suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(errorMessage);
            suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

            BizPropertyInitializer.initialize(suuriyouErrJyouhou);

            ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

            pSrKyhkinShrJyukyuRnrkBatchParam
            .setErrorSyoriKensuu(pSrKyhkinShrJyukyuRnrkBatchParam.getErrorSyoriKensuu() + 1);
            errorFlag = true;
        } else {

            sjkkktyouseiyouriritu = getSjkkktyouseiyouriritu.getSjkkktyouseiyouriritu();
        }

        C_ErrorKbn errorKbn = calcHkShrKngk.exec(
            pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd(),
            pTkJitenKeiyakuSyouhinKijyunBean.getSyouhnsdno(),
            pTkJitenKeiyakuSyouhinKijyunBean.getRyouritusdno(),
            pTkJitenKeiyakuSyouhinKijyunBean.getYoteiriritu(),
            pKykKihon.getHrkkaisuu(),
            pTkJitenKeiyakuSyouhinKijyunBean.getHknkknsmnKbn(),
            pTkJitenKeiyakuSyouhinKijyunBean.getHknkkn(),
            pTkJitenKeiyakuSyouhinKijyunBean.getHrkkkn(),
            pTkJitenKeiyakuSyouhinKijyunBean.getHhknnen(),
            pTkJitenKeiyakuSyouhinKijyunBean.getHhknsei(),
            pTkJitenKeiyakuSyouhinKijyunBean.getKihons(),
            pTkJitenKeiyakuSyouhinKijyunBean.getKykymd(),
            pSkJiyuu.getSibouymd(),
            pKykKihon.getSyono(),
            pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu(),
            pTkJitenKeiyakuSyouhinKijyunBean.getDai1hknkkn(),
            C_SiinKbn.SP,
            C_HokenkinsyuruiKbn.SBHOKENKIN,
            pTkJitenKeiyakuSyouhinKijyunBean.getHokenryou(),
            sjkkktyouseiyouriritu,
            pTkJitenKeiyakuSyouhinKijyunBean.getKyksjkkktyouseiriritu(),
            tmttkntaisyouYm,
            teiritutmttKngk,
            sisuurendoutmttKngk,
            tumitateRiritu,
            null,
            null,
            null,
            null,
            null,
            null,
            pTkJitenKeiyakuSyouhinKijyunBean.getKykjyoutai(),
            pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd(),
            pKykKihon.getSdpdkbn(),
            pKykKihon.getHrkkeiro());

        if (C_ErrorKbn.ERROR.eq(errorKbn)) {

            errorMessage = MessageUtil.getMessage(MessageId.ESA1001, MESSAGEARG, pKykKihon.getSyono());

            batchLogger.warn(errorMessage);

            ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();
            suuriyouErrJyouhou.setSyoriYmd(pSrKyhkinShrJyukyuRnrkBatchParam.getSyoriYmd());
            suuriyouErrJyouhou.setKakutyoujobcd(pSrKyhkinShrJyukyuRnrkBatchParam.getIbKakutyoujobcd());
            suuriyouErrJyouhou.setSyono(pKykKihon.getSyono());
            suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(errorMessage);
            suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

            BizPropertyInitializer.initialize(suuriyouErrJyouhou);

            ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

            pSrKyhkinShrJyukyuRnrkBatchParam.setErrorSyoriKensuu(pSrKyhkinShrJyukyuRnrkBatchParam.getErrorSyoriKensuu() + 1);
            errorFlag = true;
        }
        else {

            sibousGk = calcHkShrKngk.getCalcHkShrKngkBean().getSibousGk();
            mvaTyouseigoW = calcHkShrKngk.getCalcHkShrKngkBean().getKaiyakuhenreiknGk();
            mvaKeisanjiSknnJynbkn = calcHkShrKngk.getCalcHkShrKngkBean().getTmttKnGk();
        }

        BizCurrency gaikadateSiharaiS = pTkJitenKeiyakuSyouhinKijyunBean.getKihons().subtract(sibousGk);

        BizCurrency enkdtsbujsitihsyuknGk = null;
        if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getInitsbjiyensitihsytkhukaumu())) {
            enkdtsbujsitihsyuknGk = pKykSonotaTkyk.getInitsbjiyenkasaiteihsygk();
        }
        else {
            enkdtsbujsitihsyuknGk = BizCurrency.valueOf(0);
        }

        pKyhknShrJyoukyouRnrkTy.setZtyraysystemhyj(SrCommonConstants.HYOUJI_ARI);
        pKyhknShrJyoukyouRnrkTy.setZtygaikakbn(gaikaKbn);
        pKyhknShrJyoukyouRnrkTy.setZtykeiyakujiyoteiriritu(
            pTkJitenKeiyakuSyouhinKijyunBean.getYoteiriritu());
        pKyhknShrJyoukyouRnrkTy.setZtygaikadatesiharais(Long.parseLong(gaikadateSiharaiS.toAdsoluteString()));
        pKyhknShrJyoukyouRnrkTy.setZtygaikadatesyukeiyakus(
            Long.parseLong(pTkJitenKeiyakuSyouhinKijyunBean.getKihons().toAdsoluteString()));
        pKyhknShrJyoukyouRnrkTy.setZtygaikadatesyukeiyakup(
            Long.parseLong(pTkJitenKeiyakuSyouhinKijyunBean.getHokenryou().toAdsoluteString()));
        pKyhknShrJyoukyouRnrkTy.setZtyenkdtsbujsitihsyukngk(Long.parseLong(enkdtsbujsitihsyuknGk.toAdsoluteString()));
        pKyhknShrJyoukyouRnrkTy.setZtymvatyouseigow(Long.parseLong(mvaTyouseigoW.toAdsoluteString()));
        pKyhknShrJyoukyouRnrkTy.setZtymvakeisanjisknnjynbkn(Long.parseLong(mvaKeisanjiSknnJynbkn.toAdsoluteString()));

        BizPropertyInitializer.initialize(pKyhknShrJyoukyouRnrkTy);

        SrKyhkinShrJyukyuRnrkConverter.convertPadding(pKyhknShrJyoukyouRnrkTy);

    }

}
