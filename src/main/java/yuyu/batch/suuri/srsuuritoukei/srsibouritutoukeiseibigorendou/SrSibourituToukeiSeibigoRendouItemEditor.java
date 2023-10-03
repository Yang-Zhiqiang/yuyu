package yuyu.batch.suuri.srsuuritoukei.srsibouritutoukeiseibigorendou;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateSpan;
import jp.co.slcs.swak.db.ExDBTransactionalUtil;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.SetHokenNenrei;
import yuyu.common.sinkeiyaku.skcommon.EditIjitoukeiS;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.common.suuri.srcommon.SrCommonConstants;
import yuyu.common.suuri.srcommon.SrGetTokutejitenKykKihonInfo;
import yuyu.common.suuri.srcommon.SrGetTokutejitenKykKihonInfoBean;
import yuyu.common.suuri.srcommon.SrGetTokutejitenTokuyakuInfo;
import yuyu.common.suuri.srcommon.SrGetTokutejitenTokuyakuInfoBean;
import yuyu.common.suuri.srcommon.SrSuuriKbnHenkanBean;
import yuyu.common.suuri.srcommon.SrSuuriKbnHenkanSet;
import yuyu.common.suuri.suuricommon.TkJitenKeiyakuSyouhinKijyunBean;
import yuyu.def.MessageId;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_GetTaisyouSonotaTokuyakuKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_KykKihonTokuteiJitenKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_SonotaTkTokuteiJitenKbn;
import yuyu.def.classification.C_SrKbnHenkanKbn;
import yuyu.def.classification.C_SuuriIdoKbn;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhnHnkmae;
import yuyu.def.db.entity.ST_SuuriyouErrJyouhou;
import yuyu.def.db.entity.SV_KiykSyuhnData;
import yuyu.def.db.entity.SV_SibourituToukeiSeibigo;
import yuyu.def.db.entity.ZT_SbRituToukeiSeibiRenTy;
import yuyu.infr.batch.logger.BatchLogger;

import com.google.common.base.Strings;

/**
 * 死亡率統計整備後連動情報作成項目編集
 */
public class SrSibourituToukeiSeibigoRendouItemEditor {

    private static final int SYORINO1RECORD = 1;

    private static final String BOSYUUDAIRITENATKIKEITAIKBNDAIRITENKYOUDOU = "3";

    private static final String BOSYUUDAIRITENATKIKEITAIKBNTANDOKU = "1";

    private static final String KAIJYOKBNSEIZONKAIJYO = "1";

    private static final String KAIJYOKBNSIBOUKAIJYO = "2";

    private static final String SYMTGENINCDSKTEISEIPLS = "120";

    private static final String SYMTGENINCDSKTEISEIMINS = "125";

    private static final String SYMTGENINCDSKTORIKESU = "135";

    private static final String SYMTGENINCDSHENDOUPLS = "300";

    private static final String SYMTGENINCDYENDTSYSNHENKOUPLS = "360";

    private static final String SYMTGENINCDYENDTSYSNHENKOUMINS = "365";

    private static final String SYMTGENINCDSHENDOUMINS = "305";

    private static final String SYMTGENINCDSIBOU = "415";

    private static final String SYMTGENINCDMENSEKI = "435";

    private static final String SYMTGENINCDSIBOUKAISYO = "505";

    private static final String SYMTGENINCDSONOTASYOUMETU = "805";

    private static final String SYORIKBNIDOU = "3";

    private static final String HRKHOUITIJIHR = "00";

    private static final String HRKHOUGETUHR = "70";

    private static final String HRKHOUNEN = "10";

    private static final String HRKHOUHALFY = "20";

    private static final String SNSHUHUKOUKUTISYO = "01";

    private static final String SNSHUHUMUKOKUTI = "07";

    private static final String BOSYUUKEIROKBNMDHAN = "2";

    private static final String KEIKAYMZEROYEARONEMONTH = "0001";

    private static final int KINGAKUONEMANEN = 10000;

    private static final BizNumber KUKAWASERATEMIDORU = BizNumber.valueOf(1);

    private static final BizNumber KUKAWASERATETSUYOSIDORU = BizNumber.valueOf(0.8);

    private static final int KEISANHRKKAISUU12 = 12;

    private static final int KEISANHRKKAISUU2 = 2;

    private static final int KEISANHRKKAISUU1 = 1;

    private static final int  DAI1HKNKKN5Y = 5;
    private int syoriNo = 0;

    private boolean errorFlag = false;

    private BizCurrency initsbjiyenkasaiteihsygk = null;

    private C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.BLNK;

    private C_Hrkkaisuu hrkkaisuuRecordPlus = C_Hrkkaisuu.BLNK;

    @Inject
    private BatchLogger batchLogger;

    public SrSibourituToukeiSeibigoRendouItemEditor() {

        syoriNo = SYORINO1RECORD;

        errorFlag = false;

        initsbjiyenkasaiteihsygk = BizCurrency.optional();

        hrkkaisuu = C_Hrkkaisuu.BLNK;

        hrkkaisuuRecordPlus = C_Hrkkaisuu.BLNK;
    }

    public boolean editKoumoku(SrSibourituToukeiSeibigoRendouBatchParam pSrSibourituToukeiSeibigoRendouBatchParam,
        SV_SibourituToukeiSeibigo pSibourituToukeiSeibigo,
        TkJitenKeiyakuSyouhinKijyunBean pTkJitenKeiyakuSyouhinKijyunBean,
        C_SuuriIdoKbn pSuuriIdoKbn,
        String pSibouRateRdSitei,
        ZT_SbRituToukeiSeibiRenTy pSbRituToukeiSeibiRenTy,
        int pSyohinZokusei,
        BizDate pKykSonotaTkykkouryokuhasseiymd,
        List<SV_KiykSyuhnData> pKiykSyuhnDataLst,
        List<IT_KykSyouhnHnkmae> pKykSyouhnHnkmaeLst) {

        SrSibourituToukeiSeibigoRendouDbaStatement srSibourituToukeiSeibigoRendouDbaStatement = SWAKInjector
            .getInstance(SrSibourituToukeiSeibigoRendouDbaStatement.class);

        BM_SyouhnZokusei syouhnZokusei = srSibourituToukeiSeibigoRendouDbaStatement.getSyouhnZokuseiMst(
            pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd(),
            pTkJitenKeiyakuSyouhinKijyunBean.getSyouhnsdno());

        if (C_Kykjyoutai.ITIJIBARAI.eq(pTkJitenKeiyakuSyouhinKijyunBean.getKykjyoutai())) {

            hrkkaisuu = C_Hrkkaisuu.BLNK;
        }

        else {
            if (pSyohinZokusei == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {

                hrkkaisuu = pSibourituToukeiSeibigo.getHrkkaisuu();
            }

            else{
                BizDate tkJitenKykkihonYutokuKijyunymd = null;
                if (SrCommonConstants.SIBOURITURECSITEI_MINUSREC.equals(pSibouRateRdSitei)) {

                    if (C_SuuriIdoKbn.GENGAKU.eq(pSuuriIdoKbn) || C_SuuriIdoKbn.SINENGAPPISEITEISEI.eq(pSuuriIdoKbn)) {

                        tkJitenKykkihonYutokuKijyunymd = pTkJitenKeiyakuSyouhinKijyunBean.getKouryokuhasseiymd();
                    }

                    else if (C_SuuriIdoKbn.MUKOU.eq(pSuuriIdoKbn) ) {

                        tkJitenKykkihonYutokuKijyunymd = pTkJitenKeiyakuSyouhinKijyunBean.getKykymd();
                    }

                    else {

                        tkJitenKykkihonYutokuKijyunymd = pTkJitenKeiyakuSyouhinKijyunBean.getSyoumetuymd();
                    }

                    SrGetTokutejitenKykKihonInfo srGetTokutejitenKykKihonInfo =
                        SWAKInjector.getInstance(SrGetTokutejitenKykKihonInfo.class);

                    if (C_SuuriIdoKbn.GENGAKU.eq(pSuuriIdoKbn) || C_SuuriIdoKbn.SINENGAPPISEITEISEI.eq(pSuuriIdoKbn)) {

                        SrGetTokutejitenKykKihonInfoBean srGetTokutejitenKykKihonInfoBean = srGetTokutejitenKykKihonInfo.exec(
                            C_KykKihonTokuteiJitenKbn.HRIHN_KIJYUNBIJITEN,
                            pSibourituToukeiSeibigo.getSyono(),
                            tkJitenKykkihonYutokuKijyunymd,
                            pSibourituToukeiSeibigo.getHenkousikibetukey(),
                            pKiykSyuhnDataLst,
                            C_TkiktbrisyuruiKbn.BLNK,
                            C_Hrkkeiro.BLNK,
                            pSibourituToukeiSeibigo.getHrkkaisuu());

                        hrkkaisuu = srGetTokutejitenKykKihonInfoBean.getHrkkaisuuMae();
                        hrkkaisuuRecordPlus = srGetTokutejitenKykKihonInfoBean.getHrkkaisuuMae();
                    }

                    else {

                        SrGetTokutejitenKykKihonInfoBean srGetTokutejitenKykKihonInfoBean = srGetTokutejitenKykKihonInfo.exec(
                            C_KykKihonTokuteiJitenKbn.HRIHN_KIJYUNBIJITEN,
                            pSibourituToukeiSeibigo.getSyono(),
                            tkJitenKykkihonYutokuKijyunymd,
                            null,
                            pKiykSyuhnDataLst,
                            C_TkiktbrisyuruiKbn.BLNK,
                            C_Hrkkeiro.BLNK,
                            pSibourituToukeiSeibigo.getHrkkaisuu());

                        hrkkaisuu = srGetTokutejitenKykKihonInfoBean.getHrkkaisuuMae();
                    }
                }

                else {

                    hrkkaisuu = hrkkaisuuRecordPlus;
                }
            }
        }

        editShibourituToukeiData(pSrSibourituToukeiSeibigoRendouBatchParam,
            pSibourituToukeiSeibigo,
            pTkJitenKeiyakuSyouhinKijyunBean,
            pSuuriIdoKbn,
            pSibouRateRdSitei,
            syouhnZokusei,
            pSbRituToukeiSeibiRenTy,
            pSyohinZokusei,
            pKykSyouhnHnkmaeLst);

        editShibourituToukeiIdouRay(pSrSibourituToukeiSeibigoRendouBatchParam,
            pSibourituToukeiSeibigo,
            pTkJitenKeiyakuSyouhinKijyunBean,
            pSibouRateRdSitei,
            pSbRituToukeiSeibiRenTy,
            pSyohinZokusei,
            pSuuriIdoKbn,
            pKykSonotaTkykkouryokuhasseiymd,
            pKiykSyuhnDataLst,
            pKykSyouhnHnkmaeLst);

        return errorFlag;
    }

    private void editShibourituToukeiData(
        SrSibourituToukeiSeibigoRendouBatchParam pSrSibourituToukeiSeibigoRendouBatchParam,
        SV_SibourituToukeiSeibigo pSibourituToukeiSeibigo,
        TkJitenKeiyakuSyouhinKijyunBean pTkJitenKeiyakuSyouhinKijyunBean,
        C_SuuriIdoKbn pSuuriIdoKbn,
        String pSibouRateRdSitei,
        BM_SyouhnZokusei pSyouhnZokusei,
        ZT_SbRituToukeiSeibiRenTy pSbRituToukeiSeibiRenTy,
        int pSyohinZokusei,
        List<IT_KykSyouhnHnkmae> pKykSyouhnHnkmaeLst) {

        String dataKanriNo = pSibourituToukeiSeibigo.getSyono();

        SrSibourituToukeiSeibigoRendouDbaStatement srSibourituToukeiSeibigoRendouDbaStatement =
            SWAKInjector.getInstance(SrSibourituToukeiSeibigoRendouDbaStatement.class);

        AS_Kinou asKinou = srSibourituToukeiSeibigoRendouDbaStatement.getKinou(
            pSibourituToukeiSeibigo.getGyoumuKousinKinou());

        String syoriCd = asKinou.getSyoricd();

        SrSuuriKbnHenkanSet srSuuriKbnHenkanSet = SWAKInjector.getInstance(SrSuuriKbnHenkanSet.class);

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(C_SrKbnHenkanKbn.SUURI_HAITOU,
            pSyouhnZokusei.getHaitoukbn().getValue());

        String haitouKbn = "";

        if (C_ErrorKbn.ERROR.eq(srSuuriKbnHenkanBean.getKekkaKbn())) {

            batchLogger.warn(MessageUtil.getMessage(MessageId.ESA1002,
                C_SrKbnHenkanKbn.SUURI_HAITOU.getContent(),
                pSibourituToukeiSeibigo.getSyono(),
                pSyouhnZokusei.getHaitoukbn().getValue()));

            ST_SuuriyouErrJyouhou stSuuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

            stSuuriyouErrJyouhou.setSyoriYmd(pSrSibourituToukeiSeibigoRendouBatchParam.getSyoriYmd());
            stSuuriyouErrJyouhou.setKakutyoujobcd(pSrSibourituToukeiSeibigoRendouBatchParam.getIbKakutyoujobcd());
            stSuuriyouErrJyouhou.setSyono(pSibourituToukeiSeibigo.getSyono());
            stSuuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(MessageUtil.getMessage(MessageId.ESA1002,
                C_SrKbnHenkanKbn.SUURI_HAITOU.getContent(),
                pSibourituToukeiSeibigo.getSyono(),
                pSyouhnZokusei.getHaitoukbn().getValue()));
            stSuuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

            ExDBTransactionalUtil.insert(stSuuriyouErrJyouhou);

            pSrSibourituToukeiSeibigoRendouBatchParam.setErrorSyoriKensuu(
                pSrSibourituToukeiSeibigoRendouBatchParam.getErrorSyoriKensuu() + 1);

            errorFlag = true;

        }
        else {

            haitouKbn = srSuuriKbnHenkanBean.getHenkanAtoKbn();

        }

        String aSosikiCd = pSibourituToukeiSeibigo.getDrtenkanrisosikicd();
        String aKojinCd = pSibourituToukeiSeibigo.getDaibosyuucd();

        String bosyuuDairitenKbn = "";
        if (C_UmuKbn.ARI.eq(pSibourituToukeiSeibigo.getDrtenbunumu())) {

            bosyuuDairitenKbn = BOSYUUDAIRITENATKIKEITAIKBNDAIRITENKYOUDOU;
        }
        else {

            bosyuuDairitenKbn = BOSYUUDAIRITENATKIKEITAIKBNTANDOKU;
        }

        String suuriBosyuuKbn = "";
        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean1 = srSuuriKbnHenkanSet.exec(C_SrKbnHenkanKbn.BOSYU_KEITAI,
            pSibourituToukeiSeibigo.getDrtencd());

        if (C_ErrorKbn.ERROR.eq(srSuuriKbnHenkanBean1.getKekkaKbn())) {

            batchLogger.warn(MessageUtil.getMessage(MessageId.ESA1002,
                C_SrKbnHenkanKbn.BOSYU_KEITAI.getContent(),
                pSibourituToukeiSeibigo.getSyono(),
                pSibourituToukeiSeibigo.getDrtencd()));

            ST_SuuriyouErrJyouhou stSuuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

            stSuuriyouErrJyouhou.setSyoriYmd(pSrSibourituToukeiSeibigoRendouBatchParam.getSyoriYmd());
            stSuuriyouErrJyouhou.setKakutyoujobcd(pSrSibourituToukeiSeibigoRendouBatchParam.getIbKakutyoujobcd());
            stSuuriyouErrJyouhou.setSyono(pSibourituToukeiSeibigo.getSyono());
            stSuuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(MessageUtil.getMessage(MessageId.ESA1002,
                C_SrKbnHenkanKbn.BOSYU_KEITAI.getContent(),
                pSibourituToukeiSeibigo.getSyono(),
                pSibourituToukeiSeibigo.getDrtencd()));
            stSuuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

            ExDBTransactionalUtil.insert(stSuuriyouErrJyouhou);

            pSrSibourituToukeiSeibigoRendouBatchParam.setErrorSyoriKensuu(
                pSrSibourituToukeiSeibigoRendouBatchParam.getErrorSyoriKensuu() + 1);

            errorFlag = true;

        }
        else {

            suuriBosyuuKbn = srSuuriKbnHenkanBean1.getHenkanAtoKbn();

        }

        String symtGeninCd = "";
        int shrS = 0;
        String shrYmd = "";
        String symtYmd = "";
        String keikaYm = "";
        String kkYm = "";

        if (C_SuuriIdoKbn.SINENGAPPISEITEISEI.eq(pSuuriIdoKbn) &&
            SrCommonConstants.SIBOURITURECSITEI_MINUSREC.equals(pSibouRateRdSitei)) {

            symtGeninCd = SYMTGENINCDSKTEISEIMINS;
            shrS = 0;
            shrYmd = "";
            symtYmd = "";
            keikaYm = "";
        }
        else if (C_SuuriIdoKbn.SINENGAPPISEITEISEI.eq(pSuuriIdoKbn) &&
            SrCommonConstants.SIBOURITURECSITEI_PLUSREC.equals(pSibouRateRdSitei)) {

            symtGeninCd = SYMTGENINCDSKTEISEIPLS;
            shrS = 0;
            shrYmd = "";
            symtYmd = "";
            keikaYm = "";
        }
        else if (C_SuuriIdoKbn.GENGAKU.eq(pSuuriIdoKbn) &&
            SrCommonConstants.SIBOURITURECSITEI_MINUSREC.equals(pSibouRateRdSitei)) {

            kkYm = getKeikaYM(pTkJitenKeiyakuSyouhinKijyunBean.getKouryokuhasseiymd(),
                pTkJitenKeiyakuSyouhinKijyunBean.getKykymd());

            symtGeninCd = SYMTGENINCDSHENDOUMINS;
            shrS = 0;
            shrYmd = "";
            symtYmd = "";
            keikaYm = kkYm;
        }
        else if (C_SuuriIdoKbn.GENGAKU.eq(pSuuriIdoKbn) &&
            SrCommonConstants.SIBOURITURECSITEI_PLUSREC.equals(pSibouRateRdSitei)) {

            kkYm = getKeikaYM(pTkJitenKeiyakuSyouhinKijyunBean.getKouryokuhasseiymd(),
                pTkJitenKeiyakuSyouhinKijyunBean.getKykymd());

            symtGeninCd = SYMTGENINCDSHENDOUPLS;
            shrS = 0;
            shrYmd = "";
            symtYmd = "";
            keikaYm = kkYm;
        }
        else if (C_SuuriIdoKbn.KYKTORIKESI.eq(pSuuriIdoKbn) &&
            SrCommonConstants.SIBOURITURECSITEI_MINUSREC.equals(pSibouRateRdSitei)) {

            symtGeninCd = SYMTGENINCDSKTORIKESU;
            shrS = 0;
            shrYmd = "";
            symtYmd = "";
            keikaYm = "";
        }
        else if (C_SuuriIdoKbn.CLGOFF.eq(pSuuriIdoKbn) &&
            SrCommonConstants.SIBOURITURECSITEI_MINUSREC.equals(pSibouRateRdSitei)) {

            symtGeninCd = SYMTGENINCDSKTORIKESU;
            shrS = 0;
            shrYmd = "";
            symtYmd = "";
            keikaYm = "";
        }
        else if (C_SuuriIdoKbn.KAIJO.eq(pSuuriIdoKbn) &&
            SrCommonConstants.SIBOURITURECSITEI_MINUSREC.equals(pSibouRateRdSitei)) {

            kkYm = getKeikaYM(pTkJitenKeiyakuSyouhinKijyunBean.getSyoumetuymd(),
                pTkJitenKeiyakuSyouhinKijyunBean.getKykymd());

            symtGeninCd = SYMTGENINCDSONOTASYOUMETU;
            shrS = 0;
            shrYmd = "";
            symtYmd = String.valueOf(pTkJitenKeiyakuSyouhinKijyunBean.getSyoumetuymd());
            keikaYm = kkYm;
        }
        else if (C_SuuriIdoKbn.MENSEKI.eq(pSuuriIdoKbn) &&
            SrCommonConstants.SIBOURITURECSITEI_MINUSREC.equals(pSibouRateRdSitei)) {

            kkYm = getKeikaYM(pTkJitenKeiyakuSyouhinKijyunBean.getSyoumetuymd(),
                pTkJitenKeiyakuSyouhinKijyunBean.getKykymd());

            symtGeninCd = SYMTGENINCDMENSEKI;
            shrS = 0;
            shrYmd = String.valueOf(pSibourituToukeiSeibigo.getTyakkinymd());
            symtYmd = String.valueOf(pTkJitenKeiyakuSyouhinKijyunBean.getSyoumetuymd());
            keikaYm = kkYm;
        }
        else if (C_SuuriIdoKbn.MUKOU.eq(pSuuriIdoKbn) &&
            SrCommonConstants.SIBOURITURECSITEI_MINUSREC.equals(pSibouRateRdSitei)) {

            symtGeninCd = SYMTGENINCDSKTORIKESU;
            shrS = 0;
            shrYmd = "";
            symtYmd = "";
            keikaYm = "";
        }
        else if (C_SuuriIdoKbn.SBMUKOU.eq(pSuuriIdoKbn) &&
            SrCommonConstants.SIBOURITURECSITEI_MINUSREC.equals(pSibouRateRdSitei)) {

            kkYm = getKeikaYM(pTkJitenKeiyakuSyouhinKijyunBean.getSyoumetuymd(),
                pTkJitenKeiyakuSyouhinKijyunBean.getKykymd());

            symtGeninCd = SYMTGENINCDSONOTASYOUMETU;
            shrS = 0;
            shrYmd = "";
            symtYmd = String.valueOf(pTkJitenKeiyakuSyouhinKijyunBean.getSyoumetuymd());
            keikaYm = kkYm;
        }
        else if (C_SuuriIdoKbn.SBKAIJO.eq(pSuuriIdoKbn) &&
            SrCommonConstants.SIBOURITURECSITEI_MINUSREC.equals(pSibouRateRdSitei)) {

            kkYm = getKeikaYM(pTkJitenKeiyakuSyouhinKijyunBean.getSyoumetuymd(),
                pTkJitenKeiyakuSyouhinKijyunBean.getKykymd());

            symtGeninCd = SYMTGENINCDSIBOUKAISYO;
            shrS = 0;
            shrYmd = String.valueOf(pSibourituToukeiSeibigo.getTyakkinymd());
            symtYmd = String.valueOf(pTkJitenKeiyakuSyouhinKijyunBean.getSyoumetuymd());
            keikaYm = kkYm;
        }
        else if (C_SuuriIdoKbn.SIBOU.eq(pSuuriIdoKbn) &&
            SrCommonConstants.SIBOURITURECSITEI_MINUSREC.equals(pSibouRateRdSitei)) {

            if ((pSyohinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
                pSyohinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20 ||
                pSyohinZokusei == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN ||
                pSyohinZokusei == SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN )
                && BizDateUtil.compareYmd(pTkJitenKeiyakuSyouhinKijyunBean.getSyoumetuymd(),
                    pTkJitenKeiyakuSyouhinKijyunBean.getKykymd()) == BizDateUtil.COMPARE_LESSER) {
                kkYm = KEIKAYMZEROYEARONEMONTH;
            }
            else {
                kkYm = getKeikaYM(pTkJitenKeiyakuSyouhinKijyunBean.getSyoumetuymd(),
                    pTkJitenKeiyakuSyouhinKijyunBean.getKykymd());
            }

            symtGeninCd = SYMTGENINCDSIBOU;
            shrS = 0;
            shrYmd = String.valueOf(pSibourituToukeiSeibigo.getTyakkinymd());
            symtYmd = String.valueOf(pTkJitenKeiyakuSyouhinKijyunBean.getSyoumetuymd());
            keikaYm = kkYm;
        }
        else if (C_SuuriIdoKbn.KAIYAKU.eq(pSuuriIdoKbn) &&
            SrCommonConstants.SIBOURITURECSITEI_MINUSREC.equals(pSibouRateRdSitei)) {

            kkYm = getKeikaYM(pTkJitenKeiyakuSyouhinKijyunBean.getSyoumetuymd(),
                pTkJitenKeiyakuSyouhinKijyunBean.getKykymd());

            symtGeninCd = SYMTGENINCDSONOTASYOUMETU;
            shrS = 0;
            shrYmd = "";
            symtYmd = String.valueOf(pTkJitenKeiyakuSyouhinKijyunBean.getSyoumetuymd());
            keikaYm = kkYm;
        }
        else if (C_SuuriIdoKbn.YENDTHENKOU.eq(pSuuriIdoKbn) &&
            SrCommonConstants.SIBOURITURECSITEI_MINUSREC.equals(pSibouRateRdSitei)) {

            kkYm = getKeikaYM(pTkJitenKeiyakuSyouhinKijyunBean.getKouryokuhasseiymd(),
                pTkJitenKeiyakuSyouhinKijyunBean.getKykymd());

            symtGeninCd = SYMTGENINCDYENDTSYSNHENKOUMINS;
            shrS = 0;
            shrYmd = "";
            symtYmd = "";
            keikaYm = kkYm;
        }
        else if (C_SuuriIdoKbn.YENDTHENKOU.eq(pSuuriIdoKbn) &&
            SrCommonConstants.SIBOURITURECSITEI_PLUSREC.equals(pSibouRateRdSitei)) {

            kkYm = getKeikaYM(pTkJitenKeiyakuSyouhinKijyunBean.getKouryokuhasseiymd(),
                pTkJitenKeiyakuSyouhinKijyunBean.getKykymd());

            symtGeninCd = SYMTGENINCDYENDTSYSNHENKOUPLS;
            shrS = 0;
            shrYmd = "";
            symtYmd = "";
            keikaYm = kkYm;
        }
        else if (C_SuuriIdoKbn.YENDTHENKOUTRKS.eq(pSuuriIdoKbn) &&
            SrCommonConstants.SIBOURITURECSITEI_MINUSREC.equals(pSibouRateRdSitei)) {

            kkYm = getKeikaYM(pTkJitenKeiyakuSyouhinKijyunBean.getKouryokuhasseiymd(),
                pTkJitenKeiyakuSyouhinKijyunBean.getKykymd());

            symtGeninCd = SYMTGENINCDYENDTSYSNHENKOUMINS;
            shrS = 0;
            shrYmd = "";
            symtYmd = "";
            keikaYm = kkYm;
        }
        else if (C_SuuriIdoKbn.YENDTHENKOUTRKS.eq(pSuuriIdoKbn) &&
            SrCommonConstants.SIBOURITURECSITEI_PLUSREC.equals(pSibouRateRdSitei)) {

            kkYm = getKeikaYM(pTkJitenKeiyakuSyouhinKijyunBean.getKouryokuhasseiymd(),
                pTkJitenKeiyakuSyouhinKijyunBean.getKykymd());

            symtGeninCd = SYMTGENINCDYENDTSYSNHENKOUPLS;
            shrS = 0;
            shrYmd = "";
            symtYmd = "";
            keikaYm = kkYm;
        }
        else if (C_SuuriIdoKbn.PMINYUUSYOUMETU.eq(pSuuriIdoKbn) &&
            SrCommonConstants.SIBOURITURECSITEI_MINUSREC.equals(pSibouRateRdSitei)) {

            kkYm = getKeikaYM(pTkJitenKeiyakuSyouhinKijyunBean.getSyoumetuymd(),
                pTkJitenKeiyakuSyouhinKijyunBean.getKykymd());

            symtGeninCd = SYMTGENINCDSONOTASYOUMETU;
            shrS = 0;
            shrYmd = "";
            symtYmd = String.valueOf(pTkJitenKeiyakuSyouhinKijyunBean.getSyoumetuymd());
            keikaYm = kkYm;
        }

        String kaijoKbn = "";

        if (C_SuuriIdoKbn.KAIJO.eq(pSuuriIdoKbn)) {

            kaijoKbn = KAIJYOKBNSEIZONKAIJYO;
        }
        else if (C_SuuriIdoKbn.SBKAIJO.eq(pSuuriIdoKbn)) {

            kaijoKbn = KAIJYOKBNSIBOUKAIJYO;
        }
        else {

            kaijoKbn = "";
        }

        SetHokenNenrei setHokenNenrei = SWAKInjector.getInstance(SetHokenNenrei.class);

        int hHknNenrei = setHokenNenrei.exec(pTkJitenKeiyakuSyouhinKijyunBean.getKykymd(),
            pTkJitenKeiyakuSyouhinKijyunBean.getHhknseiymd());

        String hHknNenreiTsHj = "";

        if (hHknNenrei != pTkJitenKeiyakuSyouhinKijyunBean.getHhknnen()) {

            hHknNenreiTsHj = SrCommonConstants.HYOUJI_ARI;
        }
        else {

            hHknNenreiTsHj = SrCommonConstants.HYOUJI_NASI;
        }

        int sequenceNo = pSrSibourituToukeiSeibigoRendouBatchParam.getSequenceNo();

        pSrSibourituToukeiSeibigoRendouBatchParam.setSequenceNo(pSrSibourituToukeiSeibigoRendouBatchParam
            .getSequenceNo() + 1);

        String kykMfKsnCtrSyoriYear = String.valueOf(pSibourituToukeiSeibigo.getSyoriYmd().getYear()).substring(2, 4);

        BizDate kykMfKsnCtrElapsedDaysFrom = BizDate.valueOf(String.valueOf(
            pSibourituToukeiSeibigo.getSyoriYmd().getYear()).concat(SrCommonConstants.FIXEDDAY_NENSYOBI));

        BizDate kykMfKsnCtrElapsedDaysTo = pSibourituToukeiSeibigo.getSyoriYmd();

        String kykMfKsnCtrElapsedDays = Strings.padStart(
            String.valueOf(BizDateUtil.calcDifferenceDays(kykMfKsnCtrElapsedDaysTo,
                kykMfKsnCtrElapsedDaysFrom)), 3, '0');

        String kykmfksnctrNo = Strings.padStart(String.valueOf(
            pSrSibourituToukeiSeibigoRendouBatchParam.getKykmfksnctrNo()), 2, '0');

        String kykMfKsnCtr = kykMfKsnCtrSyoriYear.concat(kykMfKsnCtrElapsedDays).concat(kykmfksnctrNo);

        int syoriNoWk = syoriNo;
        syoriNo = syoriNo + 1;

        Integer kisnkihons = null;
        Integer keisansibous = null;

        if (pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() != null) {

            if (pSyohinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR) {

                BizCurrency syuKykP = getYendtHenkouMaeSyuKykP(pKykSyouhnHnkmaeLst,
                    pTkJitenKeiyakuSyouhinKijyunBean.getHenkousikibetukey());

                kisnkihons = new BigDecimal(syuKykP.toAdsoluteString()).intValue();

                keisansibous = new BigDecimal(syuKykP.toAdsoluteString()).intValue();
            }
            else {

                kisnkihons = new BigDecimal(pTkJitenKeiyakuSyouhinKijyunBean.getKihons()
                    .divide(KINGAKUONEMANEN, 0, RoundingMode.HALF_UP).toAdsoluteString()).intValue();

                keisansibous = new BigDecimal(pTkJitenKeiyakuSyouhinKijyunBean.getKihons()
                    .divide(KINGAKUONEMANEN, 0, RoundingMode.HALF_UP).toAdsoluteString()).intValue();
            }
        }

        else if (pSyohinZokusei == SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN  &&
            C_Tuukasyu.JPY.eq(pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu())) {

            kisnkihons = new BigDecimal(pTkJitenKeiyakuSyouhinKijyunBean.getKihons()
                .divide(KINGAKUONEMANEN, 0, RoundingMode.HALF_UP).toAdsoluteString()).intValue();

            int ksnHrkkaisuu = 0;
            if (C_Hrkkaisuu.TUKI.eq(hrkkaisuu)) {

                ksnHrkkaisuu = KEISANHRKKAISUU12;
            }

            else if (C_Hrkkaisuu.HALFY.eq(hrkkaisuu)) {

                ksnHrkkaisuu = KEISANHRKKAISUU2;
            }

            else if (C_Hrkkaisuu.NEN.eq(hrkkaisuu)) {

                ksnHrkkaisuu = KEISANHRKKAISUU1;
            }

            keisansibous = new BigDecimal((pTkJitenKeiyakuSyouhinKijyunBean.getHokenryou().
                multiply(ksnHrkkaisuu).multiply(DAI1HKNKKN5Y)).divide(2).divide
                (KINGAKUONEMANEN, 0, RoundingMode.HALF_UP).toAdsoluteString()).intValue();
        }

        else {
            kisnkihons = 0;

            keisansibous = 0;
        }

        String haraikomihouhou = null;

        if (C_Kykjyoutai.ITIJIBARAI.eq(pTkJitenKeiyakuSyouhinKijyunBean.getKykjyoutai())) {

            haraikomihouhou = HRKHOUITIJIHR;
        }
        else {

            if (C_Hrkkaisuu.TUKI.eq(hrkkaisuu)) {

                haraikomihouhou = HRKHOUGETUHR;
            }

            else if (C_Hrkkaisuu.HALFY.eq(hrkkaisuu)) {

                haraikomihouhou = HRKHOUHALFY;
            }

            else if (C_Hrkkaisuu.NEN.eq(hrkkaisuu)) {

                haraikomihouhou = HRKHOUNEN;
            }

        }

        String snshuhu = "";

        if (pSyohinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
            pSyohinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20 ||
            pSyohinZokusei == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN ||
            pSyohinZokusei == SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN) {
            snshuhu = SNSHUHUMUKOKUTI;
        }
        else {
            snshuhu = SNSHUHUKOUKUTISYO;
        }

        String sysnikoujiym = "";
        if (pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() != null) {
            sysnikoujiym = pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd().getBizDateYM().toString();
        }
        else {
            sysnikoujiym = "";
        }

        BizCurrency imuStiyuSbus = BizCurrency.valueOf(0);

        if (SYMTGENINCDSKTEISEIMINS.equals(symtGeninCd) || SYMTGENINCDSKTEISEIPLS.equals(symtGeninCd)) {

            List<TkJitenKeiyakuSyouhinKijyunBean> tkJitenKeiyakuSyouhinKijyunBeanList = new ArrayList<>();

            tkJitenKeiyakuSyouhinKijyunBeanList.add(pTkJitenKeiyakuSyouhinKijyunBean);

            IT_KykKihon kykKihon = srSibourituToukeiSeibigoRendouDbaStatement.getKykKihon(pSibourituToukeiSeibigo.getSyono());

            BizDate mosYmd = kykKihon.getMosymd();

            EditIjitoukeiS editIjitoukeiS = SWAKInjector.getInstance(EditIjitoukeiS.class);

            C_ErrorKbn errorKbn = editIjitoukeiS.idougoEdit(tkJitenKeiyakuSyouhinKijyunBeanList,mosYmd);

            if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                batchLogger.warn(MessageUtil.getMessage(MessageId.ESA1001,
                    "医務査定用死亡Ｓ",
                    pSibourituToukeiSeibigo.getSyono()));

                ST_SuuriyouErrJyouhou stSuuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

                stSuuriyouErrJyouhou.setSyoriYmd(pSrSibourituToukeiSeibigoRendouBatchParam.getSyoriYmd());
                stSuuriyouErrJyouhou.setKakutyoujobcd(pSrSibourituToukeiSeibigoRendouBatchParam.getIbKakutyoujobcd());
                stSuuriyouErrJyouhou.setSyono(pSibourituToukeiSeibigo.getSyono());
                stSuuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(MessageUtil.getMessage(MessageId.ESA1001,
                    "医務査定用死亡Ｓ",
                    pSibourituToukeiSeibigo.getSyono()));
                stSuuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

                ExDBTransactionalUtil.insert(stSuuriyouErrJyouhou);

                pSrSibourituToukeiSeibigoRendouBatchParam.setErrorSyoriKensuu(
                    pSrSibourituToukeiSeibigoRendouBatchParam.getErrorSyoriKensuu() + 1);

                errorFlag = true;

            } else {

                imuStiyuSbus = editIjitoukeiS.getSibouS();
            }
        }

        pSbRituToukeiSeibiRenTy.setZtysequenceno(sequenceNo);
        pSbRituToukeiSeibiRenTy.setZtydatakanrino(dataKanriNo);
        pSbRituToukeiSeibiRenTy.setZtysyorikbn(SYORIKBNIDOU);
        pSbRituToukeiSeibiRenTy.setZtysyoriymd(String.valueOf(pSibourituToukeiSeibigo.getSyoriYmd()));
        pSbRituToukeiSeibiRenTy.setZtykykmfksnctr(Integer.valueOf(kykMfKsnCtr));
        pSbRituToukeiSeibiRenTy.setZtysyoricd(syoriCd);
        pSbRituToukeiSeibiRenTy.setZtysyukgu(pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd());
        pSbRituToukeiSeibiRenTy.setZtyhihokensyaagev2(String.valueOf(pTkJitenKeiyakuSyouhinKijyunBean.getHhknnen()));
        pSbRituToukeiSeibiRenTy.setZtyhhknseikbn(pTkJitenKeiyakuSyouhinKijyunBean.getHhknsei().getValue());
        pSbRituToukeiSeibiRenTy
        .setZtykykym(String.valueOf(pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getBizDateYM()));
        pSbRituToukeiSeibiRenTy.setZtykisnkihons(kisnkihons);
        pSbRituToukeiSeibiRenTy.setZtykeisansibous(keisansibous);
        pSbRituToukeiSeibiRenTy.setZtyshrymd(shrYmd);
        pSbRituToukeiSeibiRenTy.setZtysymtgenincd(symtGeninCd);
        pSbRituToukeiSeibiRenTy.setZtykeikaym(keikaYm);
        pSbRituToukeiSeibiRenTy.setZtybsyym(String.valueOf(pSibourituToukeiSeibigo.getBosyuuym()));
        pSbRituToukeiSeibiRenTy.setZtykituenkbn(SrCommonConstants.KITUENKBN_HUMEI);
        pSbRituToukeiSeibiRenTy.setZtyharaikomihouhou(haraikomihouhou);
        pSbRituToukeiSeibiRenTy.setZtysinsahouhou(snshuhu);
        pSbRituToukeiSeibiRenTy.setZtykykniyutksytioukbn(SrCommonConstants.DEFAULT_STRING_ZERO_1);
        pSbRituToukeiSeibiRenTy.setZtyhukasyuksyu(SrCommonConstants.DEFAULT_STRING_ZERO_1);
        pSbRituToukeiSeibiRenTy.setZtyhaitoukbn(haitouKbn);
        pSbRituToukeiSeibiRenTy.setZtysykgycd(pSibourituToukeiSeibigo.getHhknsykgycd());
        pSbRituToukeiSeibiRenTy.setZtyaatukaisosikicd(aSosikiCd);
        pSbRituToukeiSeibiRenTy.setZtyaatukaikojincd(aKojinCd);
        pSbRituToukeiSeibiRenTy.setZtykaijyokbn(kaijoKbn);
        pSbRituToukeiSeibiRenTy.setZtysymtymd(symtYmd);
        pSbRituToukeiSeibiRenTy.setZtysyukgusdkbn(pTkJitenKeiyakuSyouhinKijyunBean.getRyouritusdno());
        pSbRituToukeiSeibiRenTy.setZtybosyuukeirokbn(BOSYUUKEIROKBNMDHAN);
        pSbRituToukeiSeibiRenTy.setZtybsudirtnatkikeitaikbn(bosyuuDairitenKbn);
        pSbRituToukeiSeibiRenTy.setZtysyorinov2(String.valueOf(syoriNoWk));
        pSbRituToukeiSeibiRenTy.setZtysotodasipmenkbn(SrCommonConstants.HKNSYKGUYBI3X2_PMENTKYKNASI);
        pSbRituToukeiSeibiRenTy.setZtystdssnskbn(SrCommonConstants.HKNSYKGUYBI3X1_MUSINSA);
        pSbRituToukeiSeibiRenTy.setZtystdssytikbn(SrCommonConstants.HKNSYKGUYBI1X1_SONOTA);
        pSbRituToukeiSeibiRenTy.setZtyimustiyusbus(new BigDecimal(imuStiyuSbus.toAdsoluteString()).intValue());
        pSbRituToukeiSeibiRenTy.setZtysuuriyoubosyuukeitaikbn(suuriBosyuuKbn);
        pSbRituToukeiSeibiRenTy.setZtysysnikoujiym(sysnikoujiym);
        pSbRituToukeiSeibiRenTy.setZtysotodasimanagehyouji(SrCommonConstants.HYOUJI_ARI);
        pSbRituToukeiSeibiRenTy.setZtyhhknnentysihyj(hHknNenreiTsHj);
        pSbRituToukeiSeibiRenTy.setZtyhokenhoutekiyouhyouji(SrCommonConstants.HYOUJI_ARI);
        pSbRituToukeiSeibiRenTy.setZtysotodasiphkbnmnoshyouji(SrCommonConstants.HYOUJI_ARI);
        pSbRituToukeiSeibiRenTy.setZtystdsstkjytkyuhyj(SrCommonConstants.HYOUJI_ARI);
    }

    private void editShibourituToukeiIdouRay(
        SrSibourituToukeiSeibigoRendouBatchParam pSrSibourituToukeiSeibigoRendouBatchParam,
        SV_SibourituToukeiSeibigo pSibourituToukeiSeibigo,
        TkJitenKeiyakuSyouhinKijyunBean pTkJitenKeiyakuSyouhinKijyunBean,
        String pSibouRateRdSitei,
        ZT_SbRituToukeiSeibiRenTy pSbRituToukeiSeibiRenTy,
        int pSyohinZokusei,
        C_SuuriIdoKbn pSuuriIdoKbn,
        BizDate pKykSonotaTkykkouryokuhasseiymd,
        List<SV_KiykSyuhnData> pKiykSyuhnDataLst,
        List<IT_KykSyouhnHnkmae> pKykSyouhnHnkmaeLst) {

        SrSuuriKbnHenkanSet srSuuriKbnHenkanSet = SWAKInjector.getInstance(SrSuuriKbnHenkanSet.class);

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(C_SrKbnHenkanKbn.SUURI_KEIYAKUDATE_TUUKA,
            pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu().getValue());

        String gaikaKbn = "";
        if (C_ErrorKbn.ERROR.eq(srSuuriKbnHenkanBean.getKekkaKbn())) {

            batchLogger.warn(MessageUtil.getMessage(MessageId.ESA1002,
                C_SrKbnHenkanKbn.SUURI_KEIYAKUDATE_TUUKA.getContent(),
                pSibourituToukeiSeibigo.getSyono(),
                pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu().getValue()));

            ST_SuuriyouErrJyouhou stSuuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

            stSuuriyouErrJyouhou.setSyoriYmd(pSrSibourituToukeiSeibigoRendouBatchParam.getSyoriYmd());
            stSuuriyouErrJyouhou.setKakutyoujobcd(pSrSibourituToukeiSeibigoRendouBatchParam.getIbKakutyoujobcd());
            stSuuriyouErrJyouhou.setSyono(pSibourituToukeiSeibigo.getSyono());
            stSuuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(MessageUtil.getMessage(MessageId.ESA1002,
                C_SrKbnHenkanKbn.SUURI_KEIYAKUDATE_TUUKA.getContent(),
                pSibourituToukeiSeibigo.getSyono(),
                pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu().getValue()));
            stSuuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

            ExDBTransactionalUtil.insert(stSuuriyouErrJyouhou);

            pSrSibourituToukeiSeibigoRendouBatchParam.setErrorSyoriKensuu(
                pSrSibourituToukeiSeibigoRendouBatchParam.getErrorSyoriKensuu() + 1);

            errorFlag = true;

        }
        else {

            gaikaKbn = srSuuriKbnHenkanBean.getHenkanAtoKbn();

        }

        BizCurrency enkdtsbujsitihsyukngk = BizCurrency.valueOf(0);

        if (pSyohinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
            pSyohinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20 ||
            pSyohinZokusei == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN ||
            pSyohinZokusei == SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN ) {
            enkdtsbujsitihsyukngk = BizCurrency.valueOf(0);
        }
        else {
            if (pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() != null &&
                !C_SuuriIdoKbn.YENDTHENKOU.eq(pSuuriIdoKbn) &&
                !C_SuuriIdoKbn.YENDTHENKOUTRKS.eq(pSuuriIdoKbn)) {
                enkdtsbujsitihsyukngk = BizCurrency.valueOf(0);
            }
            else {
                if (SrCommonConstants.SIBOURITURECSITEI_MINUSREC.equals(pSibouRateRdSitei)) {
                    if (C_SuuriIdoKbn.SINENGAPPISEITEISEI.eq(pSuuriIdoKbn) ||
                        C_SuuriIdoKbn.GENGAKU.eq(pSuuriIdoKbn) ||
                        C_SuuriIdoKbn.YENDTHENKOU.eq(pSuuriIdoKbn) ||
                        C_SuuriIdoKbn.YENDTHENKOUTRKS.eq(pSuuriIdoKbn)) {

                        SrGetTokutejitenTokuyakuInfo srGetTokutejitenTokuyakuInfo = SWAKInjector
                            .getInstance(SrGetTokutejitenTokuyakuInfo.class);

                        SrGetTokutejitenTokuyakuInfoBean srGetTokutejitenTokuyakuInfoBean = srGetTokutejitenTokuyakuInfo
                            .exec(C_GetTaisyouSonotaTokuyakuKbn.SYKSBYENSITIHSYUTKYK,
                                C_SonotaTkTokuteiJitenKbn.IDOUBETUSONOTATKINFOGET,
                                null,
                                pSibourituToukeiSeibigo.getSyono(),
                                pSuuriIdoKbn,
                                pSibourituToukeiSeibigo.getHenkousikibetukey(),
                                pKykSonotaTkykkouryokuhasseiymd,
                                pKiykSyuhnDataLst,
                                pSibourituToukeiSeibigo.getYendthnkymd(),
                                pKykSyouhnHnkmaeLst,
                                pSibourituToukeiSeibigo.getInitsbjiyensitihsytkhukaumu(),
                                pSibourituToukeiSeibigo.getInitsbjiyenkasaiteihsygk(),
                                null,
                                null,
                                null,
                                null);

                        enkdtsbujsitihsyukngk = srGetTokutejitenTokuyakuInfoBean.getInitsbjiyenkasaiteihsygkMae();

                        initsbjiyenkasaiteihsygk = srGetTokutejitenTokuyakuInfoBean.getInitsbjiyenkasaiteihsygkAto();
                    }
                    else {

                        if (C_SuuriIdoKbn.MUKOU.eq(pSuuriIdoKbn)) {
                            SrGetTokutejitenTokuyakuInfo srGetTokutejitenTokuyakuInfo = SWAKInjector
                                .getInstance(SrGetTokutejitenTokuyakuInfo.class);

                            SrGetTokutejitenTokuyakuInfoBean srGetTokutejitenTokuyakuInfoBean = srGetTokutejitenTokuyakuInfo
                                .exec(C_GetTaisyouSonotaTokuyakuKbn.SYKSBYENSITIHSYUTKYK,
                                    C_SonotaTkTokuteiJitenKbn.KIJYUNYMDSONOTATKINFOGET,
                                    pTkJitenKeiyakuSyouhinKijyunBean.getSknnkaisiymd(),
                                    pSibourituToukeiSeibigo.getSyono(),
                                    null,
                                    null,
                                    null,
                                    pKiykSyuhnDataLst,
                                    pSibourituToukeiSeibigo.getYendthnkymd(),
                                    pKykSyouhnHnkmaeLst,
                                    pSibourituToukeiSeibigo.getInitsbjiyensitihsytkhukaumu(),
                                    pSibourituToukeiSeibigo.getInitsbjiyenkasaiteihsygk(),
                                    null,
                                    null,
                                    null,
                                    null);
                            enkdtsbujsitihsyukngk = srGetTokutejitenTokuyakuInfoBean.getInitsbjiyenkasaiteihsygkMae();

                        }
                        else {

                            if (C_UmuKbn.ARI.eq(pSibourituToukeiSeibigo.getInitsbjiyensitihsytkhukaumu())) {
                                enkdtsbujsitihsyukngk = pSibourituToukeiSeibigo.getInitsbjiyenkasaiteihsygk();
                            }
                            else {
                                enkdtsbujsitihsyukngk = BizCurrency.valueOf(0);
                            }
                        }

                    }
                }
                else if (SrCommonConstants.SIBOURITURECSITEI_PLUSREC.equals(pSibouRateRdSitei)) {
                    enkdtsbujsitihsyukngk = initsbjiyenkasaiteihsygk;
                }
            }
        }

        BizCurrency gaikadatekihons = BizCurrency.valueOf(0);
        if (pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() != null ||
            pSyohinZokusei == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {
            gaikadatekihons = BizCurrency.valueOf(0);
        }

        else if (pSyohinZokusei == SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN ) {

            if (C_Tuukasyu.JPY.eq(pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu())) {

                gaikadatekihons = BizCurrency.valueOf(0);
            }

            else {

                gaikadatekihons = pTkJitenKeiyakuSyouhinKijyunBean.getKihons();
            }
        }
        else {
            if (pSyohinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
                pSyohinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) {
                gaikadatekihons = pTkJitenKeiyakuSyouhinKijyunBean.getHokenryou();
            }
            else {
                gaikadatekihons = pTkJitenKeiyakuSyouhinKijyunBean.getKihons();
            }
        }

        BizCurrency gaikadatesibous = BizCurrency.valueOf(0);
        if (pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() != null ||
            pSyohinZokusei == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {
            gaikadatesibous = BizCurrency.valueOf(0);
        }

        else if (pSyohinZokusei == SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN) {

            if (C_Tuukasyu.JPY.eq(pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu())) {

                gaikadatesibous = BizCurrency.valueOf(0);
            }

            else {

                int ksnHrkkaisuu = 0;
                if (C_Hrkkaisuu.TUKI.eq(hrkkaisuu)) {

                    ksnHrkkaisuu = KEISANHRKKAISUU12;
                }

                else if (C_Hrkkaisuu.HALFY.eq(hrkkaisuu)) {

                    ksnHrkkaisuu = KEISANHRKKAISUU2;
                }

                else if (C_Hrkkaisuu.NEN.eq(hrkkaisuu)) {

                    ksnHrkkaisuu = KEISANHRKKAISUU1;
                }

                gaikadatesibous = (pTkJitenKeiyakuSyouhinKijyunBean.getHokenryou().
                    multiply(ksnHrkkaisuu).multiply(DAI1HKNKKN5Y)).divide(2, 0, RoundingMode.HALF_UP);
            }

        }

        else {
            gaikadatesibous = pTkJitenKeiyakuSyouhinKijyunBean.getHokenryou();
        }

        BizNumber kykjiyoteiriritu = BizNumber.valueOf(0);
        if (pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() != null) {
            kykjiyoteiriritu = BizNumber.valueOf(0);
        }
        else {
            if (pSyohinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
                pSyohinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20 ||
                pSyohinZokusei == SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN ) {
                kykjiyoteiriritu = BizNumber.valueOf(0);
            }
            else {
                kykjiyoteiriritu = pTkJitenKeiyakuSyouhinKijyunBean.getYoteiriritu();
            }
        }

        srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(C_SrKbnHenkanKbn.TUUKA_SYU,
            pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu().getValue());
        String tuukasyukbn = "";
        if (C_ErrorKbn.ERROR.eq(srSuuriKbnHenkanBean.getKekkaKbn())) {

            batchLogger.warn(MessageUtil.getMessage(MessageId.ESA1002,
                C_SrKbnHenkanKbn.TUUKA_SYU.getContent(),
                pSibourituToukeiSeibigo.getSyono(),
                pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu().getValue()));

            ST_SuuriyouErrJyouhou stSuuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

            stSuuriyouErrJyouhou.setSyoriYmd(pSrSibourituToukeiSeibigoRendouBatchParam.getSyoriYmd());
            stSuuriyouErrJyouhou.setKakutyoujobcd(pSrSibourituToukeiSeibigoRendouBatchParam.getIbKakutyoujobcd());
            stSuuriyouErrJyouhou.setSyono(pSibourituToukeiSeibigo.getSyono());
            stSuuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(MessageUtil.getMessage(MessageId.ESA1002,
                C_SrKbnHenkanKbn.TUUKA_SYU.getContent(),
                pSibourituToukeiSeibigo.getSyono(),
                pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu().getValue()));
            stSuuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

            ExDBTransactionalUtil.insert(stSuuriyouErrJyouhou);

            pSrSibourituToukeiSeibigoRendouBatchParam.setErrorSyoriKensuu(
                pSrSibourituToukeiSeibigoRendouBatchParam.getErrorSyoriKensuu() + 1);

            errorFlag = true;

        }
        else {

            tuukasyukbn = srSuuriKbnHenkanBean.getHenkanAtoKbn();
        }

        pSbRituToukeiSeibiRenTy.setZtyraysystemhyj(SrCommonConstants.HYOUJI_ARI);
        pSbRituToukeiSeibiRenTy.setZtygaikakbn(gaikaKbn);
        pSbRituToukeiSeibiRenTy.setZtygaikadatekihons(new BigDecimal(gaikadatekihons.toAdsoluteString()).longValue());
        pSbRituToukeiSeibiRenTy.setZtygaikadatesibous(new BigDecimal(gaikadatesibous.toAdsoluteString()).longValue());
        pSbRituToukeiSeibiRenTy.setZtykeiyakujiyoteiriritu(kykjiyoteiriritu);
        pSbRituToukeiSeibiRenTy.setZtyenkdtsbujsitihsyukngk(new BigDecimal(
            enkdtsbujsitihsyukngk.toAdsoluteString()).longValue());
        pSbRituToukeiSeibiRenTy.setZtysrdai1hknkkn(pTkJitenKeiyakuSyouhinKijyunBean.getDai1hknkkn().toString());
        pSbRituToukeiSeibiRenTy.setZtytuukasyukbn(tuukasyukbn);
    }

    private String getKeikaYM(BizDate pYmd1, BizDate pYmd2) {

        BizDateSpan syoriAtoYmd = BizDateUtil.calcDifference(pYmd1, pYmd2);

        int syoriY = syoriAtoYmd.getYears();
        int syoriM = syoriAtoYmd.getMonths();

        if (syoriY == 0 && syoriM == 0) {

            syoriM = syoriM + 1;
        }

        String keikaYm = String.valueOf(syoriY) + Strings.padStart(String.valueOf(syoriM), 2, '0');

        return keikaYm;
    }

    private BizCurrency getYendtHenkouMaeSyuKykP(List<IT_KykSyouhnHnkmae> pKykSyouhnHnkmaeLst,
        String pHenKouSikiBetsuKey) {

        BizCurrency syuKykP = BizCurrency.valueOf(0);

        for (IT_KykSyouhnHnkmae ikykSyouhnHnkmae : pKykSyouhnHnkmaeLst) {

            if (ikykSyouhnHnkmae.getHenkousikibetukey().compareTo(pHenKouSikiBetsuKey) < 0) {

                BizCurrency syuKykPGaika = ikykSyouhnHnkmae.getHokenryou();

                if (C_Tuukasyu.USD.eq(ikykSyouhnHnkmae.getKyktuukasyu())) {
                    syuKykP = syuKykPGaika.multiply(KUKAWASERATEMIDORU).divide(KINGAKUONEMANEN, 0, RoundingMode.HALF_UP);

                }
                else if (C_Tuukasyu.AUD.eq(ikykSyouhnHnkmae.getKyktuukasyu())) {
                    syuKykP = syuKykPGaika.multiply(KUKAWASERATETSUYOSIDORU).divide(KINGAKUONEMANEN, 0, RoundingMode.HALF_UP);
                }

                break;
            }
            continue;
        }
        return syuKykP;
    }
}
