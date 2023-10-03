package yuyu.batch.suuri.srsuuritoukei.srkaiyakuhenreikin;

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
import yuyu.common.biz.bzcommon.GetKawaseRate;
import yuyu.common.biz.bzcommon.GetSjkkktyouseiyouriritu;
import yuyu.common.biz.bzcommon.GetSjkkktyouseiyourirituBean;
import yuyu.common.biz.bzcommon.GetYoteiriritu;
import yuyu.common.biz.bzcommon.GetYoteirirituBean;
import yuyu.common.biz.bzcommon.SetNenrei;
import yuyu.common.biz.kaikei.BzSegmentCdSyutoku;
import yuyu.common.biz.kaikei.SyouhinbetuSegmentBean;
import yuyu.common.hozen.khcommon.IKhozenCommonConstants;
import yuyu.common.hozen.khcommon.KeisanSisuuRendouNkTmttknOverNnd;
import yuyu.common.hozen.khcommon.KeisanW;
import yuyu.common.hozen.khcommon.KeisanWExtBean;
import yuyu.common.hozen.khcommon.KeisanWKijunYM;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.common.suuri.srcommon.SrCommonConstants;
import yuyu.common.suuri.srcommon.SrGetTokutejitenAnsyuKihonInfo;
import yuyu.common.suuri.srcommon.SrGetTokutejitenKykKihonInfo;
import yuyu.common.suuri.srcommon.SrGetTokutejitenKykKihonInfoBean;
import yuyu.common.suuri.srcommon.SrSuuriKbnHenkanBean;
import yuyu.common.suuri.srcommon.SrSuuriKbnHenkanSet;
import yuyu.common.suuri.suuricommon.SrGetTokutejitenSyohnInfo;
import yuyu.common.suuri.suuricommon.TkJitenKeiyakuSyouhinKijyunBean;
import yuyu.def.MessageId;
import yuyu.def.classification.C_EigyoubiHoseiKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_KawaserateSyuruiKbn;
import yuyu.def.classification.C_KawasetekiyoKbn;
import yuyu.def.classification.C_KawasetsryKbn;
import yuyu.def.classification.C_KhSisanSyuruiKbn;
import yuyu.def.classification.C_KykKihonTokuteiJitenKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_SrKbnHenkanKbn;
import yuyu.def.classification.C_SuuriAnnaiFuyouRiyuuKbn;
import yuyu.def.classification.C_SuuriHaraikataKbn;
import yuyu.def.classification.C_SuuriRyourituKbn;
import yuyu.def.classification.C_TokutejitenSyoriKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.IT_HokenryouTmttkn;
import yuyu.def.db.entity.IT_KhSisuurendoTmttkn;
import yuyu.def.db.entity.ST_SuuriyouErrJyouhou;
import yuyu.def.db.entity.SV_KiykHnriknSutugk;
import yuyu.def.db.entity.SV_KiykSyuhnData;
import yuyu.def.db.entity.ZT_KaiykHrSoutougakuTy;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 解約返戻金相当額情報項目編集
 */
public class SrKaiyakuHenreikinItemEditor {

    private static final String TENKANITIJIBARAKBN = "1";

    private static final String RECORDNO = "01";

    private boolean errorFlg;

    private BizDateYM jkipjytym;

    private BizNumber yoteiriritu;

    private BizNumber keiyakujiyoteiriritu;

    private BizDateYM tmttkntaisyouym;

    private BizCurrency ptmttkngk;

    private BizCurrency kihrkmpstgk;

    private C_UmuKbn kijunnikouseihenkouumu;

    private C_Hrkkeiro hrkkeiro;

    private C_Hrkkaisuu hrkkaisuu;

    @Inject
    private BatchLogger batchLogger;

    public SrKaiyakuHenreikinItemEditor() {

        errorFlg = false;
        jkipjytym = null;
        yoteiriritu = null;
        keiyakujiyoteiriritu = null;
        tmttkntaisyouym = null;
        ptmttkngk = null;
        kihrkmpstgk = null;
        kijunnikouseihenkouumu = C_UmuKbn.NONE;
        hrkkeiro = null;
        hrkkaisuu = null;

    }

    public boolean editKoumoku(
        SrKaiyakuHenreikinParam pSrKaiyakuHenreikinParam,
        SV_KiykHnriknSutugk pSvKiykHnriknSutugk,
        TkJitenKeiyakuSyouhinKijyunBean pTkJitenKeiyakuSyouhinKijyunBean,
        ZT_KaiykHrSoutougakuTy pZtKaiykHrSoutougakuTy,
        int pSyohinHanteiKbn,
        IT_KhSisuurendoTmttkn pKhSisuurendoTmttkn,
        List<IT_HokenryouTmttkn> pHokenryouTmttknLst,
        List<SV_KiykSyuhnData> pSvKiykSyuhnDataLst) {

        SrKaiyakuHenreikinDbaStatement srKaiyakuHenreikinDbaStatement = SWAKInjector
            .getInstance(SrKaiyakuHenreikinDbaStatement.class);

        BM_SyouhnZokusei bmSyouhnZokusei = srKaiyakuHenreikinDbaStatement.getSyouhnZokusei(
            pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd(),
            pTkJitenKeiyakuSyouhinKijyunBean.getSyouhnsdno());

        jkipjytym = null;
        yoteiriritu = BizNumber.ZERO;
        keiyakujiyoteiriritu = BizNumber.ZERO;
        tmttkntaisyouym = null;
        ptmttkngk = BizCurrency.valueOf(0);
        kihrkmpstgk = BizCurrency.valueOf(0);
        kijunnikouseihenkouumu = C_UmuKbn.NONE;
        hrkkeiro = C_Hrkkeiro.BLNK;
        hrkkaisuu = C_Hrkkaisuu.BLNK;

        if (SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN  == pSyohinHanteiKbn ||
            SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN  == pSyohinHanteiKbn) {
            getHeijyunKytInfo(pSrKaiyakuHenreikinParam,
                pSvKiykHnriknSutugk,
                pTkJitenKeiyakuSyouhinKijyunBean,
                pSyohinHanteiKbn,
                pHokenryouTmttknLst,
                pSvKiykSyuhnDataLst);
        }

        SrKaiyakuHenreikinkinKekkaBean srKaiyakuHenreikinkinKekkaBean = SWAKInjector
            .getInstance(SrKaiyakuHenreikinkinKekkaBean.class);

        if (BizDateUtil.compareYmd(pTkJitenKeiyakuSyouhinKijyunBean.getKykymd(),
            pSrKaiyakuHenreikinParam.getKijyunymd()) == BizDateUtil.COMPARE_EQUAL
            ||
            BizDateUtil.compareYmd(pTkJitenKeiyakuSyouhinKijyunBean.getKykymd(),
                pSrKaiyakuHenreikinParam.getKijyunymd()) == BizDateUtil.COMPARE_LESSER) {

            srKaiyakuHenreikinkinKekkaBean = kayiyakuSansyutu(
                pSrKaiyakuHenreikinParam,
                pSvKiykHnriknSutugk,
                pTkJitenKeiyakuSyouhinKijyunBean,
                pSyohinHanteiKbn,
                pKhSisuurendoTmttkn,
                bmSyouhnZokusei,
                pSvKiykSyuhnDataLst);

            if (!srKaiyakuHenreikinkinKekkaBean.isResultFlg()) {


            }
            else {
                String msg = MessageUtil.getMessage(MessageId.ESA1001, "解約返戻金", pSvKiykHnriknSutugk.getSyono());

                batchLogger.warn(msg);

                ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

                suuriyouErrJyouhou.setSyoriYmd(pSrKaiyakuHenreikinParam.getSyoriYmd());
                suuriyouErrJyouhou.setKakutyoujobcd(pSrKaiyakuHenreikinParam.getIbKakutyoujobcd());
                suuriyouErrJyouhou.setSyono(pSvKiykHnriknSutugk.getSyono());
                suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);
                suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

                ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

                errorFlg = true;

                pSrKaiyakuHenreikinParam.setErrorSyoriKensuu(pSrKaiyakuHenreikinParam.getErrorSyoriKensuu() + 1);
            }
        }
        kayiyakuKoumoku(pSrKaiyakuHenreikinParam,
            pSvKiykHnriknSutugk,
            pTkJitenKeiyakuSyouhinKijyunBean,
            srKaiyakuHenreikinkinKekkaBean,
            pZtKaiykHrSoutougakuTy,
            pSyohinHanteiKbn);

        kayiyakiRAYKoumoku(pSrKaiyakuHenreikinParam,
            pSvKiykHnriknSutugk,
            pTkJitenKeiyakuSyouhinKijyunBean,
            srKaiyakuHenreikinkinKekkaBean,
            pZtKaiykHrSoutougakuTy,
            pSyohinHanteiKbn,
            bmSyouhnZokusei);

        return errorFlg;
    }

    public SrKaiyakuHenreikinkinKekkaBean kayiyakuSansyutu(
        SrKaiyakuHenreikinParam pSrKaiyakuHenreikinParam,
        SV_KiykHnriknSutugk pSvKiykHnriknSutugk,
        TkJitenKeiyakuSyouhinKijyunBean pTkJitenKeiyakuSyouhinKijyunBean,
        int pSyohinHanteiKbn,
        IT_KhSisuurendoTmttkn pKhSisuurendoTmttkn,
        BM_SyouhnZokusei pSyouhnZokusei,
        List<SV_KiykSyuhnData> pSvKiykSyuhnDataLst) {

        SrKaiyakuHenreikinkinKekkaBean srKaiyakuHenreikinkinKekkaBean = SWAKInjector
            .getInstance(SrKaiyakuHenreikinkinKekkaBean.class);
        C_Hrkkaisuu wkHrkkaisuu = C_Hrkkaisuu.BLNK;

        if (C_Kykjyoutai.ITIJIBARAI.eq(pTkJitenKeiyakuSyouhinKijyunBean.getKykjyoutai())) {

            wkHrkkaisuu = pSvKiykHnriknSutugk.getHrkkaisuu();
        }
        else {

            wkHrkkaisuu = hrkkaisuu;
        }

        KeisanWKijunYM keisanWKijunYM = SWAKInjector.getInstance(KeisanWKijunYM.class);

        BizDateYM kijyunym = keisanWKijunYM.exec(pTkJitenKeiyakuSyouhinKijyunBean.getKykymd(),
            pSrKaiyakuHenreikinParam.getKijyunymd(),
            jkipjytym, wkHrkkaisuu, pTkJitenKeiyakuSyouhinKijyunBean.getKykjyoutai(),
            pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd(), pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd());

        KeisanW keisanW = SWAKInjector.getInstance(KeisanW.class);

        BizDate sijouKakakutyouseiyouRiritsuKijyunYdm;
        if (BizDateUtil.compareYmd(pSrKaiyakuHenreikinParam.getSyoriYmd(), pSrKaiyakuHenreikinParam.getKijyunymd()) == BizDateUtil.COMPARE_LESSER) {

            sijouKakakutyouseiyouRiritsuKijyunYdm = pSrKaiyakuHenreikinParam.getSyoriYmd();
        }
        else {
            sijouKakakutyouseiyouRiritsuKijyunYdm = pSrKaiyakuHenreikinParam.getKijyunymd();
        }

        BizDateYM wktmttkntaisyouym = null;
        BizCurrency teiritutmttkngk = BizCurrency.valueOf(0);
        BizCurrency sisuurendoutmttkngk = BizCurrency.valueOf(0);
        BizNumber tumitateriritu = BizNumber.valueOf(0);

        if (pSyohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
            pSyohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) {

            if (C_UmuKbn.ARI.eq(pSyouhnZokusei.getMvatekiumu()) &&
                (BizDateUtil.calcDifferenceMonths(kijyunym, pKhSisuurendoTmttkn.getTmttkntaisyouym()) >
                SrCommonConstants.KIKAN_12M)) {

                int keikamon = BizDateUtil.calcDifferenceMonths(kijyunym, pKhSisuurendoTmttkn.getTmttkntaisyouym());

                int keikanensuu = keikamon / SrCommonConstants.KIKAN_12M;

                wktmttkntaisyouym = pKhSisuurendoTmttkn.getTmttkntaisyouym().addYears(keikanensuu);

                KeisanSisuuRendouNkTmttknOverNnd keisanSisuuRendouNkTmttknOverNnd =
                    SWAKInjector.getInstance(KeisanSisuuRendouNkTmttknOverNnd.class);
                C_ErrorKbn errorKbn2 = keisanSisuuRendouNkTmttknOverNnd.exec(
                    pTkJitenKeiyakuSyouhinKijyunBean.getKykymd(),
                    pTkJitenKeiyakuSyouhinKijyunBean.getHknkkn(),
                    pSvKiykHnriknSutugk.getTeikishrtkykhukaumu(),
                    pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu(),
                    BizDate.valueOf(wktmttkntaisyouym, pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getDay()).getRekijyou(),
                    wktmttkntaisyouym,
                    pKhSisuurendoTmttkn.getTmttkntaisyouym(),
                    pTkJitenKeiyakuSyouhinKijyunBean.getTumitateriritu(),
                    pKhSisuurendoTmttkn.getTeiritutmttkngk(),
                    pKhSisuurendoTmttkn.getSisuurendoutmttkngk());

                if (C_ErrorKbn.OK.eq(errorKbn2)) {

                    teiritutmttkngk = keisanSisuuRendouNkTmttknOverNnd.getTeiritutmttkngk();
                    sisuurendoutmttkngk = keisanSisuuRendouNkTmttknOverNnd.getSisuurendoutmttkngk();
                    tumitateriritu = pTkJitenKeiyakuSyouhinKijyunBean.getTumitateriritu();
                }
                else {

                    srKaiyakuHenreikinkinKekkaBean.setResultFlg(true);

                    return srKaiyakuHenreikinkinKekkaBean;
                }
            }
            else {

                wktmttkntaisyouym = pKhSisuurendoTmttkn.getTmttkntaisyouym();
                teiritutmttkngk = pKhSisuurendoTmttkn.getTeiritutmttkngk();
                sisuurendoutmttkngk = pKhSisuurendoTmttkn.getSisuurendoutmttkngk();
                tumitateriritu = pTkJitenKeiyakuSyouhinKijyunBean.getTumitateriritu();
            }
        }
        else if (pSyohinHanteiKbn == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19 &&
            C_UmuKbn.NONE.eq(pSyouhnZokusei.getMvatekiumu())) {

            wktmttkntaisyouym = null;
            teiritutmttkngk = BizCurrency.valueOf(0);
            sisuurendoutmttkngk = BizCurrency.valueOf(0);
            tumitateriritu = pTkJitenKeiyakuSyouhinKijyunBean.getTumitateriritu();
        }
        else {

            teiritutmttkngk = BizCurrency.valueOf(0);
            sisuurendoutmttkngk = BizCurrency.valueOf(0);
            tumitateriritu = BizNumber.valueOf(0);

            if (SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN  == pSyohinHanteiKbn) {

                if (BizDateUtil.compareYm(jkipjytym, tmttkntaisyouym) == BizDateUtil.COMPARE_LESSER) {

                    tmttkntaisyouym = null;
                    ptmttkngk = BizCurrency.valueOf(0);
                    kihrkmpstgk = BizCurrency.valueOf(0);
                }
                else {

                    wktmttkntaisyouym = tmttkntaisyouym;
                }
            }
        }

        GetSjkkktyouseiyourirituBean getSjkkktyouseiyourirituBean =
            SWAKInjector.getInstance(GetSjkkktyouseiyourirituBean.class);
        GetSjkkktyouseiyouriritu getSjkkktyouseiyouriritu = SWAKInjector.getInstance(GetSjkkktyouseiyouriritu.class);
        BizNumber kaiyakusjkkktyouseiriritu = BizNumber.valueOf(0);
        C_ErrorKbn errorKbn;

        if (C_UmuKbn.ARI.eq(pSyouhnZokusei.getMvatekiumu())) {
            getSjkkktyouseiyourirituBean.setSyouhncd(pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd());
            getSjkkktyouseiyourirituBean.setKijyunymd(sijouKakakutyouseiyouRiritsuKijyunYdm);
            getSjkkktyouseiyourirituBean.setHknkkn(pTkJitenKeiyakuSyouhinKijyunBean.getHknkkn());
            getSjkkktyouseiyourirituBean.setHknkknsmnkbn(pTkJitenKeiyakuSyouhinKijyunBean.getHknkknsmnKbn());
            getSjkkktyouseiyourirituBean.setHhknnen(pTkJitenKeiyakuSyouhinKijyunBean.getHhknnen());

            errorKbn = getSjkkktyouseiyouriritu.exec(getSjkkktyouseiyourirituBean);

            if (C_ErrorKbn.OK.eq(errorKbn)) {

                kaiyakusjkkktyouseiriritu = getSjkkktyouseiyouriritu.getSjkkktyouseiyouriritu();
            }
            else {

                srKaiyakuHenreikinkinKekkaBean.setResultFlg(true);

                return srKaiyakuHenreikinkinKekkaBean;
            }
        }

        C_Hhknsei hhknsei = pTkJitenKeiyakuSyouhinKijyunBean.getHhknsei();

        TkJitenKeiyakuSyouhinKijyunBean tkJitenKeiyakuSyouhinKijyunBeanAto = null;

        if (C_UmuKbn.ARI.eq(kijunnikouseihenkouumu)) {

            SrGetTokutejitenSyohnInfo srGetTokutejitenSyohnInfo =
                SWAKInjector.getInstance(SrGetTokutejitenSyohnInfo.class);

            tkJitenKeiyakuSyouhinKijyunBeanAto = srGetTokutejitenSyohnInfo.exec(
                C_TokutejitenSyoriKbn.KIJYUNBIJITENSYOUHININFO, pSvKiykHnriknSutugk.getSyono(),
                pSrKaiyakuHenreikinParam.getKijyunymd().getBizDateYM().addMonths(-1).getLastDay(),
                "", pSvKiykSyuhnDataLst).getTkJitenKeiyakuSyouhinKijyunBeanAto();
            hhknsei = tkJitenKeiyakuSyouhinKijyunBeanAto.getHhknsei();

            if (hhknsei == null) {
                hhknsei = pTkJitenKeiyakuSyouhinKijyunBean.getHhknsei();
            }
        }

        if (C_Kykjyoutai.ITIJIBARAI.eq(pTkJitenKeiyakuSyouhinKijyunBean.getKykjyoutai())) {

            wkHrkkaisuu = pSvKiykHnriknSutugk.getHrkkaisuu();
        }
        else {

            wkHrkkaisuu = hrkkaisuu;
        }


        KeisanWExtBean keisanWExtBean = SWAKInjector.getInstance(KeisanWExtBean.class);

        keisanWExtBean.setSyouhncd(pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd());
        keisanWExtBean.setSyouhnsdno(pTkJitenKeiyakuSyouhinKijyunBean.getSyouhnsdno());
        keisanWExtBean.setRyouritusdno(pTkJitenKeiyakuSyouhinKijyunBean.getRyouritusdno());
        keisanWExtBean.setYoteiriritu(pTkJitenKeiyakuSyouhinKijyunBean.getYoteiriritu());
        keisanWExtBean.setHrkkaisuu(wkHrkkaisuu);
        keisanWExtBean.setHknkknsmnkbn(pTkJitenKeiyakuSyouhinKijyunBean.getHknkknsmnKbn());
        keisanWExtBean.setHknkkn(pTkJitenKeiyakuSyouhinKijyunBean.getHknkkn());
        keisanWExtBean.setHrkkkn(pTkJitenKeiyakuSyouhinKijyunBean.getHrkkkn());
        keisanWExtBean.setHrkkknsmnkbn(pTkJitenKeiyakuSyouhinKijyunBean.getHrkkknsmnKbn());
        keisanWExtBean.setHhknnen(pTkJitenKeiyakuSyouhinKijyunBean.getHhknnen());
        keisanWExtBean.setHhknsei(hhknsei);
        keisanWExtBean.setKihons(pTkJitenKeiyakuSyouhinKijyunBean.getKihons());
        keisanWExtBean.setHokenryou(pTkJitenKeiyakuSyouhinKijyunBean.getHokenryou());
        keisanWExtBean.setKykymd(pTkJitenKeiyakuSyouhinKijyunBean.getKykymd());
        keisanWExtBean.setTuukasyu(pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu());
        keisanWExtBean.setKyksjkkktyouseiriritu(pTkJitenKeiyakuSyouhinKijyunBean.getKyksjkkktyouseiriritu());
        keisanWExtBean.setKaiyakusjkkktyouseiriritu(kaiyakusjkkktyouseiriritu);
        keisanWExtBean.setTmttkntaisyouym(wktmttkntaisyouym);
        keisanWExtBean.setTeiritutmttkngk(teiritutmttkngk);
        keisanWExtBean.setSisuurendoutmttkngk(sisuurendoutmttkngk);
        keisanWExtBean.setTumitateriritu(tumitateriritu);
        keisanWExtBean.setJkipjytym(jkipjytym);
        keisanWExtBean.setPtmttkngk(ptmttkngk);
        keisanWExtBean.setKihrkmpstgk(kihrkmpstgk);
        keisanWExtBean.setFstpryosyuymd(pSvKiykHnriknSutugk.getFstpnyknymd());
        keisanWExtBean.setYoteirrthendohosyurrt(pTkJitenKeiyakuSyouhinKijyunBean.getYoteirrthendohosyurrt());
        keisanWExtBean.setSisansyuruikbn(C_KhSisanSyuruiKbn.JISSEKI);
        keisanWExtBean.setYendthnkymd(pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd());
        keisanWExtBean.setTeikishrtkykhukaumu(pSvKiykHnriknSutugk.getTeikishrtkykhukaumu());
        keisanWExtBean.setDai1hknkkn(pTkJitenKeiyakuSyouhinKijyunBean.getDai1hknkkn());
        keisanWExtBean.setKykJyoutai(pTkJitenKeiyakuSyouhinKijyunBean.getKykjyoutai());

        errorKbn = keisanW.exec(sijouKakakutyouseiyouRiritsuKijyunYdm, kijyunym, keisanWExtBean);

        if (C_ErrorKbn.OK.eq(errorKbn)) {

            srKaiyakuHenreikinkinKekkaBean.setKeisanW(keisanW);
            srKaiyakuHenreikinkinKekkaBean.setSjkkktyouseiyouriritu(kaiyakusjkkktyouseiriritu);

        }
        else {

            srKaiyakuHenreikinkinKekkaBean.setResultFlg(true);
        }
        return srKaiyakuHenreikinkinKekkaBean;
    }

    public void kayiyakuKoumoku(
        SrKaiyakuHenreikinParam pSrKaiyakuHenreikinParam,
        SV_KiykHnriknSutugk pSvKiykHnriknSutugk,
        TkJitenKeiyakuSyouhinKijyunBean pTkJitenKeiyakuSyouhinKijyunBean,
        SrKaiyakuHenreikinkinKekkaBean pSrKaiyakuHenreikinkinKekkaBean,
        ZT_KaiykHrSoutougakuTy pZtKaiykHrSoutougakuTy,
        int pSyohinHanteiKbn) {

        String syono = pSvKiykHnriknSutugk.getSyono();

        String henkanAtoKbnVal = "";

        SrSuuriKbnHenkanSet srSuuriKbnHenkanSet = SWAKInjector.getInstance(SrSuuriKbnHenkanSet.class);

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec2(C_SrKbnHenkanKbn.SUURISYURUI,
            pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd(),
            pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu().getValue());

        if (C_ErrorKbn.ERROR.eq(srSuuriKbnHenkanBean.getKekkaKbn())) {

            String msg = MessageUtil.getMessage(MessageId.ESA1006, C_SrKbnHenkanKbn.SUURISYURUI.getContent(),
                pSvKiykHnriknSutugk.getSyono(), pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd(),
                pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu().getValue());

            batchLogger.warn(msg);

            ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

            suuriyouErrJyouhou.setSyoriYmd(pSrKaiyakuHenreikinParam.getSyoriYmd());
            suuriyouErrJyouhou.setKakutyoujobcd(pSrKaiyakuHenreikinParam.getIbKakutyoujobcd());
            suuriyouErrJyouhou.setSyono(pSvKiykHnriknSutugk.getSyono());
            suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);
            suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

            ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

            errorFlg = true;

            pSrKaiyakuHenreikinParam.setErrorSyoriKensuu(pSrKaiyakuHenreikinParam.getErrorSyoriKensuu() + 1);
        }
        else {

            henkanAtoKbnVal = srSuuriKbnHenkanBean.getHenkanAtoKbn();
        }

        String kbnkeiriyousegmentkbn = "";
        String kbnkeiriyourgnbnskkbn = "";
        BzSegmentCdSyutoku bzSegmentCdSyutoku = SWAKInjector.getInstance(BzSegmentCdSyutoku.class);

        SyouhinbetuSegmentBean syouhinbetuSegmentBean = bzSegmentCdSyutoku.exec(
            pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd(),
            pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu());

        if (C_ErrorKbn.ERROR.eq(syouhinbetuSegmentBean.getErrorKbn())) {

            String msg = MessageUtil.getMessage(MessageId.ESA1007,
                SrCommonConstants.MSGHYOUJIMOJIRETU_SEGCD,
                pSvKiykHnriknSutugk.getSyono(),
                pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd(),
                pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu().getValue());

            batchLogger.warn(msg);

            ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

            suuriyouErrJyouhou.setSyoriYmd(pSrKaiyakuHenreikinParam.getSyoriYmd());
            suuriyouErrJyouhou.setKakutyoujobcd(pSrKaiyakuHenreikinParam.getIbKakutyoujobcd());
            suuriyouErrJyouhou.setSyono(pSvKiykHnriknSutugk.getSyono());
            suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);
            suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

            ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

            errorFlg = true;

            pSrKaiyakuHenreikinParam.setErrorSyoriKensuu(pSrKaiyakuHenreikinParam.getErrorSyoriKensuu() + 1);
        }
        else {

            kbnkeiriyousegmentkbn = syouhinbetuSegmentBean.getSegcd1().getValue().substring(0, 2);
            kbnkeiriyourgnbnskkbn = syouhinbetuSegmentBean.getSegcd1().getValue().substring(2, 4);
        }

        String suuriHaraikataKbn = "";

        if (C_Kykjyoutai.ITIJIBARAI.eq(pTkJitenKeiyakuSyouhinKijyunBean.getKykjyoutai())) {
            suuriHaraikataKbn = C_SuuriHaraikataKbn.ITIJI.getValue();
        }
        else {
            if (C_Hrkkaisuu.TUKI.eq(hrkkaisuu)) {

                if (C_Hrkkeiro.HURIKAE.eq(hrkkeiro)) {
                    suuriHaraikataKbn = C_SuuriHaraikataKbn.TIZUKI.getValue();
                }
                else if (C_Hrkkeiro.KOUHURI.eq(hrkkeiro)) {
                    suuriHaraikataKbn = C_SuuriHaraikataKbn.BANKZUKI.getValue();
                }
                else if (C_Hrkkeiro.CREDIT.eq(hrkkeiro)) {
                    suuriHaraikataKbn = C_SuuriHaraikataKbn.CREDIT.getValue();
                }
            }
            else if (C_Hrkkaisuu.HALFY.eq(hrkkaisuu)) {

                suuriHaraikataKbn = C_SuuriHaraikataKbn.HALFY.getValue();
            }
            else if (C_Hrkkaisuu.NEN.eq(hrkkaisuu)) {

                suuriHaraikataKbn = C_SuuriHaraikataKbn.NEN.getValue();
            }
        }

        Long kaiyakuhr = Long.valueOf(0);
        if (BizDateUtil.compareYmd(pTkJitenKeiyakuSyouhinKijyunBean.getKykymd(),
            pSrKaiyakuHenreikinParam.getKijyunymd()) == BizDateUtil.COMPARE_EQUAL
            ||
            BizDateUtil.compareYmd(pTkJitenKeiyakuSyouhinKijyunBean.getKykymd(),
                pSrKaiyakuHenreikinParam.getKijyunymd()) == BizDateUtil.COMPARE_LESSER) {

            kaiyakuhr = pSrKaiyakuHenreikinkinKekkaBean.getKeisanW() == null ? null
                : pSrKaiyakuHenreikinkinKekkaBean.getKeisanW().getW() == null ? null : Long
                    .valueOf(pSrKaiyakuHenreikinkinKekkaBean.getKeisanW().getW().toAdsoluteString());
        }
        else {

            if (pSyohinHanteiKbn != SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN &&
                pSyohinHanteiKbn != SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN) {
                kaiyakuhr = Long.valueOf(pTkJitenKeiyakuSyouhinKijyunBean.getHokenryou().toAdsoluteString());
            }
        }

        int keikanensuu = 0;
        int keikatukisuu = 0;

        if (BizDateUtil.compareYmd(pTkJitenKeiyakuSyouhinKijyunBean.getKykymd(),
            pSrKaiyakuHenreikinParam.getKijyunymd()) == BizDateUtil.COMPARE_EQUAL
            ||
            BizDateUtil.compareYmd(pTkJitenKeiyakuSyouhinKijyunBean.getKykymd(),
                pSrKaiyakuHenreikinParam.getKijyunymd()) == BizDateUtil.COMPARE_LESSER) {

            keikanensuu = pSrKaiyakuHenreikinkinKekkaBean.getKeisanW() == null ? 0
                : pSrKaiyakuHenreikinkinKekkaBean.getKeisanW().getKeikanensuu();
            keikatukisuu = pSrKaiyakuHenreikinkinKekkaBean.getKeisanW() == null ? 0
                : pSrKaiyakuHenreikinkinKekkaBean.getKeisanW().getKeikatukisuu();
        }
        else {

            keikanensuu = 0;
            keikatukisuu = 0;
        }

        String hrkkaisuuVal = "";
        C_Hrkkaisuu wkHrkkaisuu = C_Hrkkaisuu.BLNK;

        if (C_Kykjyoutai.ITIJIBARAI.eq(pTkJitenKeiyakuSyouhinKijyunBean.getKykjyoutai())) {

            wkHrkkaisuu = pSvKiykHnriknSutugk.getHrkkaisuu();
        }
        else {

            wkHrkkaisuu = hrkkaisuu;
        }

        srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(
            C_SrKbnHenkanKbn.HRK_KAISUU, wkHrkkaisuu.getValue());

        if (C_ErrorKbn.ERROR.eq(srSuuriKbnHenkanBean.getKekkaKbn())) {

            String msg = MessageUtil.getMessage(MessageId.ESA1002, C_SrKbnHenkanKbn.HRK_KAISUU.getContent(),
                pSvKiykHnriknSutugk.getSyono(), wkHrkkaisuu.getValue());

            batchLogger.warn(msg);

            ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

            suuriyouErrJyouhou.setSyoriYmd(pSrKaiyakuHenreikinParam.getSyoriYmd());
            suuriyouErrJyouhou.setKakutyoujobcd(pSrKaiyakuHenreikinParam.getIbKakutyoujobcd());
            suuriyouErrJyouhou.setSyono(pSvKiykHnriknSutugk.getSyono());
            suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);
            suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

            ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

            errorFlg = true;

            pSrKaiyakuHenreikinParam.setErrorSyoriKensuu(pSrKaiyakuHenreikinParam.getErrorSyoriKensuu() + 1);
        }
        else {
            hrkkaisuuVal = srSuuriKbnHenkanBean.getHenkanAtoKbn();
        }

        String suuriRyourituKbn ="";

        if (C_Kykjyoutai.ITIJIBARAI.eq(pTkJitenKeiyakuSyouhinKijyunBean.getKykjyoutai())) {
            suuriRyourituKbn = C_SuuriRyourituKbn.OTHER.getValue();
        }
        else {
            if (C_Hrkkaisuu.NEN.eq(hrkkaisuu) || C_Hrkkaisuu.HALFY.eq(hrkkaisuu)){
                suuriRyourituKbn = C_SuuriRyourituKbn.OTHER.getValue();
            }
            else {
                if (C_Hrkkeiro.HURIKAE.eq(hrkkeiro)) {
                    suuriRyourituKbn = C_SuuriRyourituKbn.OTHER.getValue();
                }
                else if (C_Hrkkeiro.KOUHURI.eq(hrkkeiro)) {
                    suuriRyourituKbn = C_SuuriRyourituKbn.KOUHURI.getValue();
                }
                else if (C_Hrkkeiro.CREDIT.eq(hrkkeiro)) {
                    suuriRyourituKbn = C_SuuriRyourituKbn.CREDIT.getValue();
                }
            }
        }

        SetNenrei setNenrei = SWAKInjector.getInstance(SetNenrei.class);

        int nenrei = setNenrei.exec(pTkJitenKeiyakuSyouhinKijyunBean.getKykymd(), pSvKiykHnriknSutugk.getKykseiymd());

        int nenreityousei = 0;

        if(nenrei > 99) {

            nenreityousei = 0;
        }
        else{

            nenreityousei = nenrei;
        }
        String kbnkey = pSvKiykHnriknSutugk.getKbnkey();
        int ztysequenceno = Integer.valueOf(pSrKaiyakuHenreikinParam.getSyorikensuu()
            + kbnkey.substring(kbnkey.length() - 1));

        String saimnkkykhyj = "";
        if (C_HknkknsmnKbn.SAIMANKI.eq(pTkJitenKeiyakuSyouhinKijyunBean.getHknkknsmnKbn())) {
            saimnkkykhyj = SrCommonConstants.HYOUJI_ARI;
        }
        else {
            saimnkkykhyj = SrCommonConstants.HYOUJI_NASI;
        }

        C_SuuriAnnaiFuyouRiyuuKbn suuriAnnaiFuyouRiyuuKbn = C_SuuriAnnaiFuyouRiyuuKbn.ANNAITYUU;
        if (C_Kykjyoutai.ITIJIBARAI.eq(pTkJitenKeiyakuSyouhinKijyunBean.getKykjyoutai())) {
            suuriAnnaiFuyouRiyuuKbn = C_SuuriAnnaiFuyouRiyuuKbn.ITIJI;
        }

        String kykjyoutaiVal = "";

        srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(
            C_SrKbnHenkanKbn.KYK_JYOUTAI, pTkJitenKeiyakuSyouhinKijyunBean.getKykjyoutai().getValue());

        if (C_ErrorKbn.ERROR.eq(srSuuriKbnHenkanBean.getKekkaKbn())) {

            String msg = MessageUtil.getMessage(MessageId.ESA1002, C_SrKbnHenkanKbn.KYK_JYOUTAI.getContent(),
                pSvKiykHnriknSutugk.getSyono(), pTkJitenKeiyakuSyouhinKijyunBean.getKykjyoutai().getValue());

            batchLogger.warn(msg);

            ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

            suuriyouErrJyouhou.setSyoriYmd(pSrKaiyakuHenreikinParam.getSyoriYmd());
            suuriyouErrJyouhou.setKakutyoujobcd(pSrKaiyakuHenreikinParam.getIbKakutyoujobcd());
            suuriyouErrJyouhou.setSyono(pSvKiykHnriknSutugk.getSyono());
            suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);
            suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

            ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

            errorFlg = true;

            pSrKaiyakuHenreikinParam.setErrorSyoriKensuu(pSrKaiyakuHenreikinParam.getErrorSyoriKensuu() + 1);
        }
        else {
            kykjyoutaiVal = srSuuriKbnHenkanBean.getHenkanAtoKbn();
        }

        BizDateYM wkjkipjytym = jkipjytym;

        BizCurrency kihons = BizCurrency.valueOf(0);

        if (SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR == pSyohinHanteiKbn ||
            SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20 == pSyohinHanteiKbn) {

            kihons = BizCurrency.valueOf(0);
        }
        else {
            kihons = pTkJitenKeiyakuSyouhinKijyunBean.getKihons();
        }

        pZtKaiykHrSoutougakuTy.setZtysequenceno(ztysequenceno);
        pZtKaiykHrSoutougakuTy.setZtykeisankijyunym(
            pSrKaiyakuHenreikinParam.getKijyunymd().getBizDateYM().toString());
        pZtKaiykHrSoutougakuTy.setZtydatakanrino(syono);
        pZtKaiykHrSoutougakuTy.setZtysyutkkbn(pTkJitenKeiyakuSyouhinKijyunBean.getSyutkKbn().getValue());
        pZtKaiykHrSoutougakuTy.setZtysuurisyuruicd(henkanAtoKbnVal);
        pZtKaiykHrSoutougakuTy.setZtykbnkeiriyousegmentkbn(kbnkeiriyousegmentkbn);
        pZtKaiykHrSoutougakuTy.setZtykbnkeiriyourgnbnskkbn(kbnkeiriyourgnbnskkbn);
        pZtKaiykHrSoutougakuTy.setZtyharaikatakbn(suuriHaraikataKbn);
        pZtKaiykHrSoutougakuTy.setZtytenkanitijibaraikbn(TENKANITIJIBARAKBN);
        pZtKaiykHrSoutougakuTy.setZtytyuutohukahyouji(SrCommonConstants.HYOUJI_NASI);
        pZtKaiykHrSoutougakuTy.setZtykykymd(pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().toString());
        pZtKaiykHrSoutougakuTy.setZtyhknsyukigou(pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd());
        pZtKaiykHrSoutougakuTy.setZtyhknsyuruikigousedaikbn(pTkJitenKeiyakuSyouhinKijyunBean.getRyouritusdno());
        pZtKaiykHrSoutougakuTy.setZtysotodasipmenkbn(SrCommonConstants.HKNSYKGUYBI3X2_PMENTKYKNASI);
        pZtKaiykHrSoutougakuTy.setZtysotodasimanagehyouji(SrCommonConstants.HYOUJI_ARI);
        pZtKaiykHrSoutougakuTy.setZtysotodasiphkbnmnoshyouji(SrCommonConstants.HYOUJI_ARI);
        pZtKaiykHrSoutougakuTy.setZtyknkuzusnzyrttekitkarihyj(SrCommonConstants.HYOUJI_NASI);
        pZtKaiykHrSoutougakuTy.setZtytokuyakugatakbn(SrCommonConstants.DEFAULT_STRING_ZERO_1);
        pZtKaiykHrSoutougakuTy.setZtyhrkkaisuukbn(hrkkaisuuVal);
        pZtKaiykHrSoutougakuTy.setZtyryouritukbn(suuriRyourituKbn);
        pZtKaiykHrSoutougakuTy.setZtyhhknseikbn(pTkJitenKeiyakuSyouhinKijyunBean.getHhknsei().getValue());
        pZtKaiykHrSoutougakuTy.setZtyhihokensyaagev2(pTkJitenKeiyakuSyouhinKijyunBean.getHhknnen().toString());
        pZtKaiykHrSoutougakuTy.setZtykyksyanen(String.valueOf(nenreityousei));
        pZtKaiykHrSoutougakuTy.setZtyhknkkn(pTkJitenKeiyakuSyouhinKijyunBean.getHknkkn().toString());
        pZtKaiykHrSoutougakuTy.setZtyphrkkikn(pTkJitenKeiyakuSyouhinKijyunBean.getHrkkkn().toString());
        pZtKaiykHrSoutougakuTy.setZtysaimnkkykhyj(saimnkkykhyj);
        pZtKaiykHrSoutougakuTy.setZtytkbthsyumnryuhyouji(SrCommonConstants.HYOUJI_NASI);
        pZtKaiykHrSoutougakuTy.setZtynknshry(SrCommonConstants.DEFAULT_STRING_ZERO_2);
        pZtKaiykHrSoutougakuTy.setZtyannaifuyouriyuukbn(suuriAnnaiFuyouRiyuuKbn.getValue());
        pZtKaiykHrSoutougakuTy.setZtykykjyoutai(kykjyoutaiVal);
        pZtKaiykHrSoutougakuTy.setZtykeikanensuu(String.valueOf(keikanensuu));
        pZtKaiykHrSoutougakuTy.setZtykeikatukisuu(String.valueOf(keikatukisuu));
        if (wkjkipjytym != null) {
            pZtKaiykHrSoutougakuTy.setZtyjikaipjyuutouym(wkjkipjytym.toString());
        }
        pZtKaiykHrSoutougakuTy.setZtyrecordno(RECORDNO);
        pZtKaiykHrSoutougakuTy.setZtymfannaihuyouriyuukbn(suuriAnnaiFuyouRiyuuKbn.getValue());
        pZtKaiykHrSoutougakuTy.setZtyhokenhoutekiyouhyouji(SrCommonConstants.HYOUJI_ARI);
        pZtKaiykHrSoutougakuTy.setZtykousinmanryouage(SrCommonConstants.DEFAULT_STRING_ZERO_2);
        pZtKaiykHrSoutougakuTy.setZtyknkuzusnzyrt(SrCommonConstants.DEFAULT_STRING_ZERO_3);
        pZtKaiykHrSoutougakuTy.setZtyerrtokuteikoumoku("");
        pZtKaiykHrSoutougakuTy.setZtykihons(Long.valueOf(kihons.toAdsoluteString()));
        pZtKaiykHrSoutougakuTy.setZtykaiyakuhr(kaiyakuhr);
    }

    public void kayiyakiRAYKoumoku(
        SrKaiyakuHenreikinParam pSrKaiyakuHenreikinParam,
        SV_KiykHnriknSutugk pSvKiykHnriknSutugk,
        TkJitenKeiyakuSyouhinKijyunBean pTkJitenKeiyakuSyouhinKijyunBean,
        SrKaiyakuHenreikinkinKekkaBean pSrKaiyakuHenreikinkinKekkaBean,
        ZT_KaiykHrSoutougakuTy pZtKaiykHrSoutougakuTy,
        int syohinHanteiKbn,
        BM_SyouhnZokusei pSyouhnZokusei) {

        String gaikaKbn = "";

        SrSuuriKbnHenkanSet srSuuriKbnHenkanSet = SWAKInjector.getInstance(SrSuuriKbnHenkanSet.class);

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(C_SrKbnHenkanKbn.SUURI_KEIYAKUDATE_TUUKA,
            pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu().getValue());

        if (C_ErrorKbn.ERROR.eq(srSuuriKbnHenkanBean.getKekkaKbn())) {

            String msg = MessageUtil.getMessage(MessageId.ESA1002, C_SrKbnHenkanKbn.SUURI_KEIYAKUDATE_TUUKA.getContent(),
                pSvKiykHnriknSutugk.getSyono(), pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu().getValue());

            batchLogger.warn(msg);

            ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

            suuriyouErrJyouhou.setSyoriYmd(pSrKaiyakuHenreikinParam.getSyoriYmd());
            suuriyouErrJyouhou.setKakutyoujobcd(pSrKaiyakuHenreikinParam.getIbKakutyoujobcd());
            suuriyouErrJyouhou.setSyono(pSvKiykHnriknSutugk.getSyono());
            suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);
            suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

            ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

            errorFlg = true;

            pSrKaiyakuHenreikinParam.setErrorSyoriKensuu(pSrKaiyakuHenreikinParam.getErrorSyoriKensuu() + 1);
        }
        else {

            gaikaKbn = srSuuriKbnHenkanBean.getHenkanAtoKbn();
        }

        BizNumber kawaserate = BizNumber.valueOf(0);
        BizDate kwsrateKjYmd = BizDate.valueOf(0);

        if (pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() != null ||
            C_Tuukasyu.JPY.eq(pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu())) {
            kawaserate = BizNumber.valueOf(0);
            kwsrateKjYmd = BizDate.valueOf(0);
        }
        else {
            GetKawaseRate getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);

            BizDate kawaseRateKijyunYmd;
            if (BizDateUtil.COMPARE_LESSER == BizDateUtil.compareYmd(pSrKaiyakuHenreikinParam.getSyoriYmd(),
                pSrKaiyakuHenreikinParam.getKijyunymd())) {
                kawaseRateKijyunYmd = pSrKaiyakuHenreikinParam.getSyoriYmd();
            }
            else {
                kawaseRateKijyunYmd = pSrKaiyakuHenreikinParam.getKijyunymd();
            }

            C_ErrorKbn errorKbn = getKawaseRate.exec(kawaseRateKijyunYmd,
                C_KawaserateSyuruiKbn.PM17JIKAWASERATE,
                pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu(),
                C_Tuukasyu.JPY,
                C_KawasetekiyoKbn.TTM,
                C_KawasetsryKbn.JISSEIRATE,
                C_EigyoubiHoseiKbn.ZENEIGYOUBI,
                C_YouhiKbn.HUYOU);

            if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                String msg = MessageUtil.getMessage(MessageId.ESA1004, kawaseRateKijyunYmd.toString(),
                    C_KawaserateSyuruiKbn.PM17JIKAWASERATE.getValue(),
                    pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu().getValue(),
                    C_Tuukasyu.JPY.getValue(),
                    C_KawasetekiyoKbn.TTM.getValue(),
                    C_KawasetsryKbn.JISSEIRATE.getValue(),
                    C_EigyoubiHoseiKbn.ZENEIGYOUBI.getValue(),
                    C_YouhiKbn.HUYOU.getValue());

                batchLogger.warn(msg);

                ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

                suuriyouErrJyouhou.setSyoriYmd(pSrKaiyakuHenreikinParam.getSyoriYmd());
                suuriyouErrJyouhou.setKakutyoujobcd(pSrKaiyakuHenreikinParam.getIbKakutyoujobcd());
                suuriyouErrJyouhou.setSyono(pSvKiykHnriknSutugk.getSyono());
                suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);
                suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

                ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

                errorFlg = true;

                pSrKaiyakuHenreikinParam.setErrorSyoriKensuu(pSrKaiyakuHenreikinParam.getErrorSyoriKensuu() + 1);
            }
            else {

                kawaserate = getKawaseRate.getKawaserate();
                kwsrateKjYmd = getKawaseRate.getKwsrateKjYmd();
            }
        }

        BizNumber saisinyoteiriritu = yoteiriritu;

        BizNumber mvakeisanjikijyunkinri = BizNumber.valueOf(0);
        BizNumber ztykeiyakujikijyunkinri = BizNumber.valueOf(0);
        BizDate mvakeisankijyunymd = BizDate.valueOf(0);
        BizNumber mvatyouseikou = BizNumber.valueOf(0);
        BizNumber ztykeiyakujiyoteiriritu = BizNumber.valueOf(0);

        if (C_UmuKbn.NONE.eq(pSyouhnZokusei.getMvatekiumu())) {
            mvakeisanjikijyunkinri = BizNumber.valueOf(0);
            ztykeiyakujikijyunkinri = BizNumber.valueOf(0);
            mvakeisankijyunymd = BizDate.valueOf(0);
            mvatyouseikou = BizNumber.valueOf(0);

            if (SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR  == syohinHanteiKbn ||
                SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN  == syohinHanteiKbn) {

                ztykeiyakujiyoteiriritu = pTkJitenKeiyakuSyouhinKijyunBean.getYoteiriritu();
            }
            else{
                ztykeiyakujiyoteiriritu = keiyakujiyoteiriritu;
            }
        }
        else {
            if (BizDateUtil.compareYmd(pTkJitenKeiyakuSyouhinKijyunBean.getKykymd(),
                pSrKaiyakuHenreikinParam.getKijyunymd()) == BizDateUtil.COMPARE_EQUAL
                ||
                BizDateUtil.compareYmd(pTkJitenKeiyakuSyouhinKijyunBean.getKykymd(),
                    pSrKaiyakuHenreikinParam.getKijyunymd()) == BizDateUtil.COMPARE_LESSER) {
                mvakeisanjikijyunkinri = pSrKaiyakuHenreikinkinKekkaBean.getSjkkktyouseiyouriritu();
                ztykeiyakujikijyunkinri = pTkJitenKeiyakuSyouhinKijyunBean.getKyksjkkktyouseiriritu();
                mvakeisankijyunymd = pSrKaiyakuHenreikinParam.getKijyunymd();
                mvatyouseikou = pSrKaiyakuHenreikinkinKekkaBean.getKeisanW() == null ? BizNumber.valueOf(0)
                    : pSrKaiyakuHenreikinkinKekkaBean.getKeisanW().getMvaTyouseikou();
                ztykeiyakujiyoteiriritu = pTkJitenKeiyakuSyouhinKijyunBean.getYoteiriritu();
            }
            else {
                mvakeisanjikijyunkinri = BizNumber.valueOf(0);
                ztykeiyakujikijyunkinri = pTkJitenKeiyakuSyouhinKijyunBean.getKyksjkkktyouseiriritu();
                mvakeisankijyunymd = BizDate.valueOf(0);
                mvatyouseikou = BizNumber.valueOf(0);
                ztykeiyakujiyoteiriritu = pTkJitenKeiyakuSyouhinKijyunBean.getYoteiriritu();
            }

        }

        String tuukasyuKbn = "";

        srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(
            C_SrKbnHenkanKbn.TUUKA_SYU, pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu().getValue());

        if (C_ErrorKbn.ERROR.eq(srSuuriKbnHenkanBean.getKekkaKbn())) {

            String msg = MessageUtil.getMessage(MessageId.ESA1002, C_SrKbnHenkanKbn.TUUKA_SYU.getContent(),
                pSvKiykHnriknSutugk.getSyono(), pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu().getValue());

            batchLogger.warn(msg);

            ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();
            suuriyouErrJyouhou.setSyoriYmd(pSrKaiyakuHenreikinParam.getSyoriYmd());
            suuriyouErrJyouhou.setKakutyoujobcd(pSrKaiyakuHenreikinParam.getIbKakutyoujobcd());
            suuriyouErrJyouhou.setSyono(pSvKiykHnriknSutugk.getSyono());
            suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);
            suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

            ExDBTransactionalUtil.insert(suuriyouErrJyouhou);


            errorFlg = true;

            pSrKaiyakuHenreikinParam.setErrorSyoriKensuu(pSrKaiyakuHenreikinParam.getErrorSyoriKensuu() + 1);
        }
        else {

            tuukasyuKbn = srSuuriKbnHenkanBean.getHenkanAtoKbn();
        }

        pZtKaiykHrSoutougakuTy.setZtyraysystemhyj(SrCommonConstants.HYOUJI_ARI);
        pZtKaiykHrSoutougakuTy.setZtygaikakbn(gaikaKbn);
        pZtKaiykHrSoutougakuTy.setZtykawaserate(kawaserate);
        pZtKaiykHrSoutougakuTy.setZtykawaseratetekiyouymd(kwsrateKjYmd.toString());
        pZtKaiykHrSoutougakuTy.setZtysaisinyoteiriritu(saisinyoteiriritu);
        pZtKaiykHrSoutougakuTy.setZtysrkaiyakusjkkktyouseirrt(mvakeisanjikijyunkinri);
        pZtKaiykHrSoutougakuTy.setZtysrkyksjkkktyouseiriritu(ztykeiyakujikijyunkinri);
        pZtKaiykHrSoutougakuTy.setZtymvakeisankijyunymd(String.valueOf(mvakeisankijyunymd));
        pZtKaiykHrSoutougakuTy.setZtymvatyouseikou(mvatyouseikou);
        pZtKaiykHrSoutougakuTy.setZtykeiyakujiyoteiriritu(ztykeiyakujiyoteiriritu);
        pZtKaiykHrSoutougakuTy.setZtysrdai1hknkkn(pTkJitenKeiyakuSyouhinKijyunBean.getDai1hknkkn().toString());
        pZtKaiykHrSoutougakuTy.setZtytuukasyukbn(tuukasyuKbn);
    }

    private void getHeijyunKytInfo(
        SrKaiyakuHenreikinParam pSrKaiyakuHenreikinParam,
        SV_KiykHnriknSutugk pSvKiykHnriknSutugk,
        TkJitenKeiyakuSyouhinKijyunBean pTkJitenKeiyakuSyouhinKijyunBean,
        int pSyohinHanteiKbn,
        List<IT_HokenryouTmttkn> pHokenryouTmttknLst,
        List<SV_KiykSyuhnData> pSvKiykSyuhnDataLst) {

        BizDate yoteirirituKijyunymd = null;

        C_UmuKbn kijunnikouGengkumu = C_UmuKbn.NONE;

        SrGetTokutejitenAnsyuKihonInfo srGetTokutejitenAnsyuKihonInfo =
            SWAKInjector.getInstance(SrGetTokutejitenAnsyuKihonInfo.class);

        jkipjytym = srGetTokutejitenAnsyuKihonInfo.exec(
            pSvKiykHnriknSutugk.getSyono(),
            pSrKaiyakuHenreikinParam.getKijyunymd(),
            pSvKiykHnriknSutugk.getJkipjytym(),
            null);

        if (SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN  == pSyohinHanteiKbn) {

            if (BizDateUtil.compareYmd(
                pTkJitenKeiyakuSyouhinKijyunBean.getKykymd(), pSrKaiyakuHenreikinParam.getKijyunymd()) == BizDateUtil.COMPARE_GREATER) {
                yoteirirituKijyunymd = pTkJitenKeiyakuSyouhinKijyunBean.getKykymd();
            }
            else {
                yoteirirituKijyunymd = pSrKaiyakuHenreikinParam.getKijyunymd();
            }

            GetYoteiriritu getYoteiriritu = SWAKInjector.getInstance(GetYoteiriritu.class);
            GetYoteirirituBean getYoteirirituBean = SWAKInjector.getInstance(GetYoteirirituBean.class);
            getYoteirirituBean.setSyouhncd(pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd());
            getYoteirirituBean.setKijyunymd(yoteirirituKijyunymd);
            getYoteirirituBean.setSknnkaisiymd(pTkJitenKeiyakuSyouhinKijyunBean.getKykymd());
            getYoteirirituBean.setKykymd(pTkJitenKeiyakuSyouhinKijyunBean.getKykymd());
            getYoteirirituBean.setHknkkn(pTkJitenKeiyakuSyouhinKijyunBean.getHknkkn());
            getYoteirirituBean.setHknkknsmnkbn(pTkJitenKeiyakuSyouhinKijyunBean.getHknkknsmnKbn());
            getYoteirirituBean.setHhknnen(pTkJitenKeiyakuSyouhinKijyunBean.getHhknnen());
            getYoteirirituBean.setSitihsyuriritu(pTkJitenKeiyakuSyouhinKijyunBean.getYoteirrthendohosyurrt());
            getYoteirirituBean.setTuukasyu(pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu());

            C_ErrorKbn errorKbn = getYoteiriritu.exec(getYoteirirituBean);

            if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                String msg = MessageUtil.getMessage(MessageId.ESA1001,
                    "最新予定利率",
                    pSvKiykHnriknSutugk.getSyono());

                batchLogger.warn(msg);

                ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

                suuriyouErrJyouhou.setSyoriYmd(pSrKaiyakuHenreikinParam.getSyoriYmd());
                suuriyouErrJyouhou.setKakutyoujobcd(pSrKaiyakuHenreikinParam.getIbKakutyoujobcd());
                suuriyouErrJyouhou.setSyono(pSvKiykHnriknSutugk.getSyono());
                suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);
                suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

                ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

                errorFlg = true;

                pSrKaiyakuHenreikinParam.setErrorSyoriKensuu(pSrKaiyakuHenreikinParam.getErrorSyoriKensuu() + 1);
            }
            else {
                yoteiriritu = getYoteiriritu.getYoteiriritu();
            }
        }

        if (SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN  == pSyohinHanteiKbn) {
            GetYoteiriritu getYoteiriritu = SWAKInjector.getInstance(GetYoteiriritu.class);
            GetYoteirirituBean getYoteirirituBean = SWAKInjector.getInstance(GetYoteirirituBean.class);
            getYoteirirituBean.setSyouhncd(pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd());
            getYoteirirituBean.setKijyunymd(pTkJitenKeiyakuSyouhinKijyunBean.getKykymd());
            getYoteirirituBean.setSknnkaisiymd(pTkJitenKeiyakuSyouhinKijyunBean.getKykymd());
            getYoteirirituBean.setKykymd(pTkJitenKeiyakuSyouhinKijyunBean.getKykymd());
            getYoteirirituBean.setHknkkn(pTkJitenKeiyakuSyouhinKijyunBean.getHknkkn());
            getYoteirirituBean.setHknkknsmnkbn(pTkJitenKeiyakuSyouhinKijyunBean.getHknkknsmnKbn());
            getYoteirirituBean.setHhknnen(pTkJitenKeiyakuSyouhinKijyunBean.getHhknnen());
            getYoteirirituBean.setSitihsyuriritu(pTkJitenKeiyakuSyouhinKijyunBean.getYoteirrthendohosyurrt());
            getYoteirirituBean.setTuukasyu(pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu());

            C_ErrorKbn errorKbn = getYoteiriritu.exec(getYoteirirituBean);

            if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                String msg = MessageUtil.getMessage(MessageId.ESA1001,
                    "契約時予定利率",
                    pSvKiykHnriknSutugk.getSyono());

                batchLogger.warn(msg);

                ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

                suuriyouErrJyouhou.setSyoriYmd(pSrKaiyakuHenreikinParam.getSyoriYmd());
                suuriyouErrJyouhou.setKakutyoujobcd(pSrKaiyakuHenreikinParam.getIbKakutyoujobcd());
                suuriyouErrJyouhou.setSyono(pSvKiykHnriknSutugk.getSyono());
                suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);
                suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

                ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

                errorFlg = true;

                pSrKaiyakuHenreikinParam.setErrorSyoriKensuu(pSrKaiyakuHenreikinParam.getErrorSyoriKensuu() + 1);
            }
            else {
                keiyakujiyoteiriritu = getYoteiriritu.getYoteiriritu();
            }
        }

        if (SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN  == pSyohinHanteiKbn) {

            if (pHokenryouTmttknLst.size() != 0) {

                for (int i = 0; i < pHokenryouTmttknLst.size(); i++) {

                    if (BizDateUtil.compareYm(pSrKaiyakuHenreikinParam.getKijyunymd().getBizDateYM(),
                        pHokenryouTmttknLst.get(i).getTmttkntaisyouym()) == BizDateUtil.COMPARE_LESSER) {

                        if (IKhozenCommonConstants.KINOUID_GENGAKU
                            .equals(pHokenryouTmttknLst.get(i).getGyoumuKousinKinou())) {

                            kijunnikouGengkumu = C_UmuKbn.ARI;
                        }
                        else if (IKhozenCommonConstants.KINOUID_SEINENGAPPISEI
                            .equals(pHokenryouTmttknLst.get(i).getGyoumuKousinKinou())) {

                            kijunnikouseihenkouumu = C_UmuKbn.ARI;
                        }
                        else {
                            continue;
                        }
                    }
                    else {

                        if (C_UmuKbn.NONE.eq(kijunnikouGengkumu)) {

                            tmttkntaisyouym = pHokenryouTmttknLst.get(i).getTmttkntaisyouym();
                            ptmttkngk = pHokenryouTmttknLst.get(i).getPtmttkngk();
                            kihrkmpstgk = pHokenryouTmttknLst.get(i).getKihrkmpstgk();
                        }

                        break;
                    }
                }
            }
        }

        SrGetTokutejitenKykKihonInfo srGetTokutejitenKykKihonInfo =
            SWAKInjector.getInstance(SrGetTokutejitenKykKihonInfo.class);

        SrGetTokutejitenKykKihonInfoBean srGetTokutejitenKykKihonInfoBean = srGetTokutejitenKykKihonInfo.exec(
            C_KykKihonTokuteiJitenKbn.HRIHN_KIJYUNBIJITEN,
            pSvKiykHnriknSutugk.getSyono(),
            pSrKaiyakuHenreikinParam.getKijyunymd(),
            null,
            pSvKiykSyuhnDataLst,
            null,
            pSvKiykHnriknSutugk.getHrkkeiro(),
            pSvKiykHnriknSutugk.getHrkkaisuu());

        hrkkeiro = srGetTokutejitenKykKihonInfoBean.getHrkkeiroMae();
        hrkkaisuu = srGetTokutejitenKykKihonInfoBean.getHrkkaisuuMae();
    }
}