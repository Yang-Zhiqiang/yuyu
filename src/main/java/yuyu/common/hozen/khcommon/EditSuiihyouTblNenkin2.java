package yuyu.common.hozen.khcommon;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.GetYoteiriritu;
import yuyu.common.biz.bzcommon.GetYoteirirituBean;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_SinsaihkKbn;
import yuyu.def.classification.C_SyoukensaihkKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.IT_HhknSya;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_Suiihyou;
import yuyu.def.db.entity.IT_Zennou;

/**
 * 契約保全 契約保全共通 推移表ＴＢＬ編集（年金）２
 */
public class EditSuiihyouTblNenkin2 {

    private static final String ERROR_MSG = "解約返戻金計算拡張情報作成が実行できませんでした。";

    private static final String ERROR_MSG_2 = "予定利率取得が実行できませんでした。";

    @Inject
    private static Logger logger;

    public EditSuiihyouTblNenkin2() {
        super();
    }

    public void editTBL(KhozenCommonParam pKkanriCommonParam,
        IT_KykKihon pKykKihon,
        List<IT_KykSyouhn> pKykSyohnSyuLst,
        List<IT_KykSyouhn> pKykSyouhnLst,
        IT_HhknSya pHhknSya,
        BizDate pSyoriYmd,
        EditHokenSyoukenParam pEditHokenSyoukenParam,
        C_SinsaihkKbn pCSinsaihkKbn,
        BM_SyouhnZokusei pSyouhnZokusei,
        IT_KykSonotaTkyk pKykSonotaTkyk,
        IT_Zennou pZennou) {

        logger.debug("▽ 推移表TBL編集（年金２） 開始");

        C_Tuukasyu keiyakuTuukasyu = pKykSyohnSyuLst.get(0).getKyktuukasyu();
        BizDate kykymd = pKykSyohnSyuLst.get(0).getKykymd();
        BizDate haraimanymd = pKykSyohnSyuLst.get(0).getHaraimanymd();
        BizDate haraimanymdMae = haraimanymd.getPreviousDay();
        BizDate hknkknmanryouymd = pKykSyohnSyuLst.get(0).getHknkknmanryouymd();
        BizDate hknkknmanryouymdMae = hknkknmanryouymd.getPreviousDay();
        BizDate calcKijyunYmd = pEditHokenSyoukenParam.getCalckijyunYMD();
        BizDate kwsrateKjymd = pKykKihon.getFstpnyknymd();

        C_SinsaihkKbn csinsaihkKbn = C_SinsaihkKbn.BLNK;

        if (C_SinsaihkKbn.SIN.eq(pCSinsaihkKbn) ||
            (C_SinsaihkKbn.SAI.eq(pCSinsaihkKbn) &&
                C_SyoukensaihkKbn.SINKEIYAKUSAISAKUSEI.eq(pEditHokenSyoukenParam.getSyoukenSaihk()))) {
            csinsaihkKbn = C_SinsaihkKbn.SIN;
        }
        else {
            csinsaihkKbn = C_SinsaihkKbn.SAI;
        }


        GetYoteiriritu getYoteiriritu = SWAKInjector.getInstance(GetYoteiriritu.class);
        GetYoteirirituBean getYoteirirituBean = SWAKInjector.getInstance(GetYoteirirituBean.class);
        BizNumber sitihsyuriritu = pKykSyohnSyuLst.get(0).getYoteirrthendohosyurrt();

        getYoteirirituBean.setSyouhncd(pKykSyohnSyuLst.get(0).getSyouhncd());
        getYoteirirituBean.setKijyunymd(kykymd);
        getYoteirirituBean.setSknnkaisiymd(kykymd);
        getYoteirirituBean.setKykymd(kykymd);
        getYoteirirituBean.setHknkkn(pKykSyohnSyuLst.get(0).getHknkkn());
        getYoteirirituBean.setHknkknsmnkbn(pKykSyohnSyuLst.get(0).getHknkknsmnkbn());
        getYoteirirituBean.setHhknnen(pKykSyohnSyuLst.get(0).getHhknnen());
        getYoteirirituBean.setSitihsyuriritu(sitihsyuriritu);

        C_ErrorKbn errorKbn = getYoteiriritu.exec(getYoteirirituBean);

        if (C_ErrorKbn.ERROR.eq(errorKbn)) {
            throw new CommonBizAppException(ERROR_MSG_2);
        }

        List<BizNumber> yoteiriritulist = new ArrayList<BizNumber>();
        yoteiriritulist.add(getYoteiriritu.getYoteiriritu());
        yoteiriritulist.add(sitihsyuriritu);

        KeisanWExtBean keisanWExtBean = SWAKInjector.getInstance(KeisanWExtBean.class);

        KeisanWExt keisanWExt = SWAKInjector.getInstance(KeisanWExt.class);

        if ((C_SinsaihkKbn.SIN.eq(csinsaihkKbn)) ||
            (C_SinsaihkKbn.SAI.eq(csinsaihkKbn) &&
                (BizDateUtil.compareYmd(pSyoriYmd, kykymd) == BizDateUtil.COMPARE_LESSER))) {

            keisanWExtBean.setSyouhncd(pKykSyohnSyuLst.get(0).getSyouhncd());
            keisanWExtBean.setSyouhnsdno(pKykSyohnSyuLst.get(0).getSyouhnsdno());
            keisanWExtBean.setRyouritusdno(pKykSyohnSyuLst.get(0).getRyouritusdno());
            keisanWExtBean.setYoteiriritu(pKykSyohnSyuLst.get(0).getYoteiriritu());
            keisanWExtBean.setHrkkaisuu(pKykKihon.getHrkkaisuu());
            keisanWExtBean.setHknkknsmnkbn(pKykSyohnSyuLst.get(0).getHknkknsmnkbn());
            keisanWExtBean.setHknkkn(pKykSyohnSyuLst.get(0).getHknkkn());
            keisanWExtBean.setHrkkkn(pKykSyohnSyuLst.get(0).getHrkkkn());
            keisanWExtBean.setHhknnen(pKykSyohnSyuLst.get(0).getHhknnen());
            keisanWExtBean.setHhknsei(pKykSyohnSyuLst.get(0).getHhknsei());
            keisanWExtBean.setKihons(pKykSyohnSyuLst.get(0).getKihons());
            keisanWExtBean.setHokenryou(pKykSyohnSyuLst.get(0).getHokenryou());
            keisanWExtBean.setKykymd(kykymd);
            keisanWExtBean.setTuukasyu(keiyakuTuukasyu);
            keisanWExtBean.setKyksjkkktyouseiriritu(pKykSyohnSyuLst.get(0).getKyksjkkktyouseiriritu());
            keisanWExtBean.setKaiyakusjkkktyouseiriritu(BizNumber.valueOf(0));
            keisanWExtBean.setTmttkntaisyouym(null);
            keisanWExtBean.setTeiritutmttkngk(BizCurrency.valueOf(0));
            keisanWExtBean.setSisuurendoutmttkngk(BizCurrency.valueOf(0));
            keisanWExtBean.setTmttknhaneisisuu(BizNumber.valueOf(100));
            keisanWExtBean.setTumitateriritu(BizNumber.valueOf(0));
            keisanWExtBean.setHrkkknsmnkbn(pKykSyohnSyuLst.get(0).getHrkkknsmnkbn());
            keisanWExtBean.setFstpryosyuymd(pKykKihon.getFstpnyknymd());

        } else {

            errorKbn = keisanWExt.exec(pKykKihon.getSyono(), calcKijyunYmd);

            if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                throw new CommonBizAppException(ERROR_MSG);
            }

            keisanWExtBean = keisanWExt.getKeisanWExtBean();
        }

        C_UmuKbn zennouumu = C_UmuKbn.NONE;
        BizCurrency zennoujihrkp = BizCurrency.valueOf(BigDecimal.ZERO);
        BizDate zennoukaisiymd = null;
        BizDate ryosyuymd = null;
        BizCurrency zennounyuukinkgk = BizCurrency.valueOf(BigDecimal.ZERO);

        if (pZennou != null) {
            zennouumu = C_UmuKbn.ARI;
            zennoujihrkp = pZennou.getZennoujihrkp();
            zennoukaisiymd = pZennou.getZennoukaisiymd();
            ryosyuymd = pZennou.getRyosyuymd();
            zennounyuukinkgk = pZennou.getZennounyuukinkgk();
        }

        WSuiihyouNenkin2 wSuiihyouNenkin2 = SWAKInjector.getInstance(WSuiihyouNenkin2.class);

        WSuiihyouParam wSuiihyouParam = SWAKInjector.getInstance(WSuiihyouParam.class);

        List<IT_Suiihyou> wsuiihyouLst = new ArrayList<>();

        wSuiihyouParam.setKeisanWExtBean(keisanWExtBean);
        wSuiihyouParam.setKwsratekjymd(kwsrateKjymd);
        wSuiihyouParam.setCalcKijyunYmd(calcKijyunYmd);
        wSuiihyouParam.setSinsaihkKbn(csinsaihkKbn);
        wSuiihyouParam.setSyoukensaihkKbn(pEditHokenSyoukenParam.getSyoukenSaihk());
        wSuiihyouParam.setHeijyunP(pKykKihon.getHrkp());
        wSuiihyouParam.setYoteiRirituList(yoteiriritulist);
        wSuiihyouParam.setZennouUmuKbn(zennouumu);
        wSuiihyouParam.setZennoujiHrkP(zennoujihrkp);
        wSuiihyouParam.setZennouKaisiYmd(zennoukaisiymd);
        wSuiihyouParam.setRyosyuYmd(ryosyuymd);
        wSuiihyouParam.setZennouNyuukingk(zennounyuukinkgk);

        wsuiihyouLst = wSuiihyouNenkin2.exec(wSuiihyouParam);

        BizDate syoribiYmd = pSyoriYmd;

        String kinouId = pKkanriCommonParam.getFunctionId();

        String kosinsyaId = pKkanriCommonParam.getUserID();

        String sysTime = BizDate.getSysDateTimeMilli();

        BizDate hrkkknsaisyuuymd = calcKijyunYmd.getPreviousDay();

        BizDate sueokisaisyuuymd = haraimanymd.getPreviousDay();

        Integer sueokiSeigyoNen = 10;

        for (int index = 0; index < wsuiihyouLst.size(); index++) {

            IT_Suiihyou suiihyou = wsuiihyouLst.get(index);

            if (suiihyou.getCalckijyunymd().compareTo(haraimanymdMae) <= 0 &&
                suiihyou.getCalckijyunymd().compareTo(hknkknmanryouymdMae) != 0) {
                if (index < 10) {
                    setSuiihyouTbl(pKykKihon,
                        suiihyou,
                        syoribiYmd,
                        keiyakuTuukasyu,
                        kinouId,
                        kosinsyaId,
                        sysTime);

                    hrkkknsaisyuuymd = suiihyou.getCalckijyunymd();
                }
                else {
                    if (suiihyou.getCalckijyunymd().getBizDateYM().compareTo(hrkkknsaisyuuymd.getBizDateYM().addYears(5)) == 0) {

                        setSuiihyouTbl(pKykKihon,
                            suiihyou,
                            syoribiYmd,
                            keiyakuTuukasyu,
                            kinouId,
                            kosinsyaId,
                            sysTime);

                        hrkkknsaisyuuymd = suiihyou.getCalckijyunymd();
                    }
                    else if (suiihyou.getCalckijyunymd().compareTo(haraimanymdMae) == 0) {

                        setSuiihyouTbl(pKykKihon,
                            suiihyou,
                            syoribiYmd,
                            keiyakuTuukasyu,
                            kinouId,
                            kosinsyaId,
                            sysTime);
                    }
                }
            }
            if (haraimanymd.compareTo(hknkknmanryouymd) != 0 &&
                suiihyou.getCalckijyunymd().compareTo(haraimanymd) == 0) {

                setSuiihyouTbl(pKykKihon,
                    suiihyou,
                    syoribiYmd,
                    keiyakuTuukasyu,
                    kinouId,
                    kosinsyaId,
                    sysTime);

                sueokiSeigyoNen = sueokiSeigyoNen + 1;

                sueokisaisyuuymd = suiihyou.getCalckijyunymd().getPreviousDay();
            }
            if (haraimanymd.compareTo(suiihyou.getCalckijyunymd()) < 0 &&
                suiihyou.getCalckijyunymd().compareTo(hknkknmanryouymdMae) < 0) {

                if (index < sueokiSeigyoNen) {
                    setSuiihyouTbl(pKykKihon,
                        suiihyou,
                        syoribiYmd,
                        keiyakuTuukasyu,
                        kinouId,
                        kosinsyaId,
                        sysTime);

                    sueokisaisyuuymd = suiihyou.getCalckijyunymd();

                }else{
                    if (suiihyou.getCalckijyunymd().getBizDateYM().compareTo(sueokisaisyuuymd.getBizDateYM().addYears(5)) == 0) {

                        setSuiihyouTbl(pKykKihon,
                            suiihyou,
                            syoribiYmd,
                            keiyakuTuukasyu,
                            kinouId,
                            kosinsyaId,
                            sysTime);

                        sueokisaisyuuymd = suiihyou.getCalckijyunymd();
                    }
                }
            }
            if (suiihyou.getCalckijyunymd().compareTo(hknkknmanryouymdMae) == 0) {

                setSuiihyouTbl(pKykKihon,
                    suiihyou,
                    syoribiYmd,
                    keiyakuTuukasyu,
                    kinouId,
                    kosinsyaId,
                    sysTime);

                sueokisaisyuuymd = suiihyou.getCalckijyunymd();
            }
        }
        logger.debug("△ 推移表TBL編集（年金２） 終了");
    }

    private void setSuiihyouTbl(IT_KykKihon pKykKihon,
        IT_Suiihyou pSuiihyou,
        BizDate pSyoribiYmd,
        C_Tuukasyu pKeiyakuTuukasyu,
        String pKinouId,
        String pKosinsyaId,
        String pSysTime) {

        IT_Suiihyou suiihyou = pKykKihon.createSuiihyou();

        suiihyou.setTyouhyouymd(pSyoribiYmd);
        suiihyou.setKeikanensuu(pSuiihyou.getKeikanensuu());
        suiihyou.setCalckijyunymd(pSuiihyou.getCalckijyunymd());
        suiihyou.setCalcym(pSuiihyou.getCalcym());
        suiihyou.setSuiihyousyubetu(pSuiihyou.getSuiihyousyubetu());
        suiihyou.setYenknsnkwsrateyendaka(pSuiihyou.getYenknsnkwsrateyendaka());
        suiihyou.setYenknsnkwsrateyenkijyun(pSuiihyou.getYenknsnkwsrateyenkijyun());
        suiihyou.setYenknsnkwsrateyenyasu(pSuiihyou.getYenknsnkwsrateyenyasu());
        suiihyou.setYenknsnkwsrategkyendaka(pSuiihyou.getYenknsnkwsrategkyendaka());
        suiihyou.setYenknsnkwsrategkyenyasu(pSuiihyou.getYenknsnkwsrategkyenyasu());
        suiihyou.setMvanonewsame(pSuiihyou.getMvanonewsame());
        suiihyou.setMvanonewyensameyendaka(pSuiihyou.getMvanonewyensameyendaka());
        suiihyou.setMvanonewyensameyenkijyun(pSuiihyou.getMvanonewyensameyenkijyun());
        suiihyou.setMvanonewyensameyenyasu(pSuiihyou.getMvanonewyensameyenyasu());
        suiihyou.setMvanoneptumitatekin(pSuiihyou.getMvanoneptumitatekin());
        suiihyou.setYenknsnkwsrateyendaka2(pSuiihyou.getYenknsnkwsrateyendaka2());
        suiihyou.setYenknsnkwsrateyenkijyun2(pSuiihyou.getYenknsnkwsrateyenkijyun2());
        suiihyou.setYenknsnkwsrateyenyasu2(pSuiihyou.getYenknsnkwsrateyenyasu2());
        suiihyou.setYenknsnkwsrategkyendaka2(pSuiihyou.getYenknsnkwsrategkyendaka2());
        suiihyou.setYenknsnkwsrategkyenyasu2(pSuiihyou.getYenknsnkwsrategkyenyasu2());
        suiihyou.setMvanonewsame2(pSuiihyou.getMvanonewsame2());
        suiihyou.setMvanonewyensameyendaka2(pSuiihyou.getMvanonewyensameyendaka2());
        suiihyou.setMvanonewyensameyenkijyun2(pSuiihyou.getMvanonewyensameyenkijyun2());
        suiihyou.setMvanonewyensameyenyasu2(pSuiihyou.getMvanonewyensameyenyasu2());
        suiihyou.setMvanoneptumitatekin2(pSuiihyou.getMvanoneptumitatekin2());
        suiihyou.setYenknsnkwsrateyendaka3(pSuiihyou.getYenknsnkwsrateyendaka3());
        suiihyou.setYenknsnkwsrateyenkijyun3(pSuiihyou.getYenknsnkwsrateyenkijyun3());
        suiihyou.setYenknsnkwsrateyenyasu3(pSuiihyou.getYenknsnkwsrateyenyasu3());
        suiihyou.setYenknsnkwsrategkyendaka3(pSuiihyou.getYenknsnkwsrategkyendaka3());
        suiihyou.setYenknsnkwsrategkyenyasu3(pSuiihyou.getYenknsnkwsrategkyenyasu3());
        suiihyou.setMvanonewsame3(pSuiihyou.getMvanonewsame3());
        suiihyou.setMvanonewyensameyendaka3(pSuiihyou.getMvanonewyensameyendaka3());
        suiihyou.setMvanonewyensameyenkijyun3(pSuiihyou.getMvanonewyensameyenkijyun3());
        suiihyou.setMvanonewyensameyenyasu3(pSuiihyou.getMvanonewyensameyenyasu3());
        suiihyou.setMvanoneptumitatekin3(pSuiihyou.getMvanoneptumitatekin3());
        suiihyou.setHrkkknmnryumukbn(pSuiihyou.getHrkkknmnryumukbn());
        suiihyou.setYtirrtcalckijyunrrt1(pSuiihyou.getYtirrtcalckijyunrrt1());
        suiihyou.setYtirrtcalckijyunrrt2(pSuiihyou.getYtirrtcalckijyunrrt2());
        suiihyou.setYtirrtcalckijyunrrt3(pSuiihyou.getYtirrtcalckijyunrrt3());
        suiihyou.setZennouzndkyen1(pSuiihyou.getZennouzndkyen1());
        suiihyou.setZennouzndkyen2(pSuiihyou.getZennouzndkyen2());
        suiihyou.setZennouzndkyen3(pSuiihyou.getZennouzndkyen3());
        suiihyou.setKihrkmpyen1(pSuiihyou.getKihrkmpyen1());
        suiihyou.setKihrkmpyen2(pSuiihyou.getKihrkmpyen2());
        suiihyou.setKihrkmpyen3(pSuiihyou.getKihrkmpyen3());
        suiihyou.setKihrkmp1(pSuiihyou.getKihrkmp1());
        suiihyou.setKihrkmp2(pSuiihyou.getKihrkmp2());
        suiihyou.setKihrkmp3(pSuiihyou.getKihrkmp3());
        suiihyou.setKyktuukasyu(pKeiyakuTuukasyu);
        suiihyou.setGyoumuKousinKinou(pKinouId);
        suiihyou.setGyoumuKousinsyaId(pKosinsyaId);
        suiihyou.setGyoumuKousinTime(pSysTime);

        BizPropertyInitializer.initialize(suiihyou);
    }
}
