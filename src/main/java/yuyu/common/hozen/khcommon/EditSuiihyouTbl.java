package yuyu.common.hozen.khcommon;

import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_MvaTekiyoujyoutaiKbn;
import yuyu.def.classification.C_SinsaihkKbn;
import yuyu.def.classification.C_SyoukensaihkKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.IT_HhknSya;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_Suiihyou;

/**
 * 契約保全 契約保全共通 推移表ＴＢＬ編集
 */
public class EditSuiihyouTbl {

    private static final String MSGHIKISUU = "解約返戻金計算拡張情報作成が実行できませんでした。";

    private static final String DUMMYSUIIHYOUSYUBETU = "00";

    private static final int DUMMYKEIKANEN = 99;

    @Inject
    private static Logger logger;

    public EditSuiihyouTbl() {
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
        IT_KykSonotaTkyk pKykSonotaTkyk) {

        logger.debug("▽ 推移表TBL編集 開始");

        C_Tuukasyu keiyakuTuukasyu = pKykSyohnSyuLst.get(0).getKyktuukasyu();
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

        WSuiihyou wsuiihyou = SWAKInjector.getInstance(WSuiihyou.class);

        WSuiihyouParam wSuiihyouParam = SWAKInjector.getInstance(WSuiihyouParam.class);

        KeisanWExtBean keisanWExtBean = SWAKInjector.getInstance(KeisanWExtBean.class);

        List<IT_Suiihyou> wsuiihyouLst = new ArrayList<>();

        int keikanenkjn;

        int keikanenkjn5nengo;

        int maxKeikanenSuu;

        if ((C_SinsaihkKbn.SIN.eq(csinsaihkKbn)) ||
            (C_SinsaihkKbn.SAI.eq(csinsaihkKbn) && (BizDateUtil.compareYmd(pSyoriYmd, pKykSyohnSyuLst.get(0).getKykymd()) == BizDateUtil.COMPARE_LESSER))) {

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
            keisanWExtBean.setKykymd(pKykSyohnSyuLst.get(0).getKykymd());
            keisanWExtBean.setTuukasyu(keiyakuTuukasyu);
            keisanWExtBean.setKyksjkkktyouseiriritu(pKykSyohnSyuLst.get(0).getKyksjkkktyouseiriritu());
            keisanWExtBean.setKaiyakusjkkktyouseiriritu(BizNumber.valueOf(0));
            keisanWExtBean.setTmttkntaisyouym(null);
            keisanWExtBean.setTeiritutmttkngk(BizCurrency.valueOf(0));
            keisanWExtBean.setSisuurendoutmttkngk(BizCurrency.valueOf(0));
            keisanWExtBean.setTmttknhaneisisuu(BizNumber.valueOf(100));
            keisanWExtBean.setTumitateriritu(BizNumber.valueOf(0));

        } else {
            KeisanWExt keisanWExt = SWAKInjector.getInstance(KeisanWExt.class);

            C_ErrorKbn errorKbn = keisanWExt.exec(pKykKihon.getSyono(), calcKijyunYmd);

            if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                throw new CommonBizAppException(MSGHIKISUU);
            }

            keisanWExtBean = keisanWExt.getKeisanWExtBean();

        }

        wSuiihyouParam.setKeisanWExtBean(keisanWExtBean);
        wSuiihyouParam.setKwsratekjymd(kwsrateKjymd);
        wSuiihyouParam.setCalcKijyunYmd(calcKijyunYmd);
        wSuiihyouParam.setSinsaihkKbn(csinsaihkKbn);
        wSuiihyouParam.setSyoukensaihkKbn(pEditHokenSyoukenParam.getSyoukenSaihk());
        wSuiihyouParam.setMvaTekiUmu(pSyouhnZokusei.getMvatekiumu());
        wSuiihyouParam.setMvaTekiKkn(pSyouhnZokusei.getMvatekikkn());
        wSuiihyouParam.setSetteiBairitu(pKykSyohnSyuLst.get(0).getSetteibairitu());
        wSuiihyouParam.setTmttknZoukarituJygn(pKykSyohnSyuLst.get(0).getTmttknzoukaritujygn());
        wSuiihyouParam.setSisuurendourate(pKykSyohnSyuLst.get(0).getKykjisisuurendourate());
        wSuiihyouParam.setTargetTkykKijyungk(pKykSonotaTkyk.getTargettkykkijyungk());

        if (C_Tuukasyu.JPY.eq(keiyakuTuukasyu)) {

            wsuiihyou.setYenkansannYhKbn(C_YouhiKbn.HUYOU);
        }

        wsuiihyouLst = wsuiihyou.exec(wSuiihyouParam);
        BizNumber keikanenkjnCalc = BizNumber.valueOf(pKykSyohnSyuLst.get(0).getHhknnen() + 25).divide(4)
            .round(0, RoundingMode.HALF_UP).subtract(BizNumber.ONE);
        keikanenkjn = Integer.parseInt(keikanenkjnCalc.toString());
        keikanenkjn5nengo = keikanenkjn + 5 - 1;
        maxKeikanenSuu = 5;

        BizDate syoribiYmd = pSyoriYmd;

        String kinouId = pKkanriCommonParam.getFunctionId();

        String kosinsyaId = pKkanriCommonParam.getUserID();

        String sysTime = BizDate.getSysDateTimeMilli();

        C_MvaTekiyoujyoutaiKbn saihkMvaTekyjyoutaiKbn = C_MvaTekiyoujyoutaiKbn.MVANONE;

        int suiihyouTblSttiCnt = 0;

        int saihakkouMvanone[] = { 0, 1, 2, 3, 4, 9, 14, 19, 24, 29, 34, 39, 44, 49 };

        for (int index = 0; index < wsuiihyouLst.size(); index++) {

            IT_Suiihyou suiihyou = wsuiihyouLst.get(index);

            if (C_SinsaihkKbn.SIN.eq(csinsaihkKbn)) {

                if (index < keikanenkjn || (index >= keikanenkjn && index == keikanenkjn5nengo)) {

                    setSuiihyouTbl(pKykKihon,
                        suiihyou,
                        syoribiYmd,
                        keiyakuTuukasyu,
                        kinouId,
                        kosinsyaId,
                        sysTime);

                    if (index == keikanenkjn5nengo) {
                        keikanenkjn5nengo += 5;
                    }
                }
            }
            else if (C_SinsaihkKbn.SAI.eq(csinsaihkKbn)) {
                if (index == 0) {
                    if (C_MvaTekiyoujyoutaiKbn.MVANONE.eq(suiihyou.getMvatekijyoutaikbn()) ||
                        (C_MvaTekiyoujyoutaiKbn.MVAARINONE.eq(suiihyou.getMvatekijyoutaikbn()))) {
                        saihkMvaTekyjyoutaiKbn = C_MvaTekiyoujyoutaiKbn.MVANONE;
                    }
                    else {
                        saihkMvaTekyjyoutaiKbn = C_MvaTekiyoujyoutaiKbn.MVAARI;
                    }
                }
                if (C_MvaTekiyoujyoutaiKbn.MVANONE.eq(saihkMvaTekyjyoutaiKbn)) {
                    if (Arrays.binarySearch(saihakkouMvanone, index) >= 0) {
                        setSuiihyouTbl(pKykKihon,
                            suiihyou,
                            syoribiYmd,
                            keiyakuTuukasyu,
                            kinouId,
                            kosinsyaId,
                            sysTime);
                    }

                }
                else if (C_MvaTekiyoujyoutaiKbn.MVAARI.eq(saihkMvaTekyjyoutaiKbn)) {
                    if (index < maxKeikanenSuu) {
                        setSuiihyouTbl(pKykKihon,
                            suiihyou,
                            syoribiYmd,
                            keiyakuTuukasyu,
                            kinouId,
                            kosinsyaId,
                            sysTime);

                        if (C_MvaTekiyoujyoutaiKbn.MVAARINONE.eq(suiihyou.getMvatekijyoutaikbn())) {
                            suiihyouTblSttiCnt = 9;
                        }

                    }
                    else if (index >= maxKeikanenSuu) {
                        if (C_MvaTekiyoujyoutaiKbn.MVAARI.eq(suiihyou.getMvatekijyoutaikbn())) {
                            setSuiihyouTbl(pKykKihon,
                                suiihyou,
                                syoribiYmd,
                                keiyakuTuukasyu,
                                kinouId,
                                kosinsyaId,
                                sysTime);
                        }
                        else if (C_MvaTekiyoujyoutaiKbn.MVAARINONE.eq(suiihyou.getMvatekijyoutaikbn())) {
                            setSuiihyouTbl(pKykKihon,
                                suiihyou,
                                syoribiYmd,
                                keiyakuTuukasyu,
                                kinouId,
                                kosinsyaId,
                                sysTime);
                            suiihyouTblSttiCnt = index + 5;

                        }
                        else if (C_MvaTekiyoujyoutaiKbn.MVANONE.eq(suiihyou.getMvatekijyoutaikbn()) &&
                            index == suiihyouTblSttiCnt) {
                            setSuiihyouTbl(pKykKihon,
                                suiihyou,
                                syoribiYmd,
                                keiyakuTuukasyu,
                                kinouId,
                                kosinsyaId,
                                sysTime);
                            suiihyouTblSttiCnt = suiihyouTblSttiCnt + 5;
                        }
                    }
                }
            }
        }

        if(wsuiihyouLst.size()==0){
            IT_Suiihyou suiihyou = new IT_Suiihyou();

            suiihyou.setSuiihyousyubetu(DUMMYSUIIHYOUSYUBETU);

            suiihyou.setKeikanensuu(DUMMYKEIKANEN);

            setSuiihyouTbl(pKykKihon, suiihyou, syoribiYmd, null, kinouId, kosinsyaId, sysTime);
        }

        logger.debug("△ 推移表TBL編集 終了");
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
        suiihyou.setMvatekijyoutaikbn(pSuiihyou.getMvatekijyoutaikbn());
        suiihyou.setKyktuukasyu(pKeiyakuTuukasyu);
        suiihyou.setSjkkktusirrtup(pSuiihyou.getSjkkktusirrtup());
        suiihyou.setSjkkktusirrtsame(pSuiihyou.getSjkkktusirrtsame());
        suiihyou.setSjkkktusirrtdown(pSuiihyou.getSjkkktusirrtdown());
        suiihyou.setSjkkktusirrthendouup(pSuiihyou.getSjkkktusirrthendouup());
        suiihyou.setSjkkktusirrthendoudown(pSuiihyou.getSjkkktusirrthendoudown());
        suiihyou.setYenknsnkwsrateyendaka(pSuiihyou.getYenknsnkwsrateyendaka());
        suiihyou.setYenknsnkwsrateyenkijyun(pSuiihyou.getYenknsnkwsrateyenkijyun());
        suiihyou.setYenknsnkwsrateyenyasu(pSuiihyou.getYenknsnkwsrateyenyasu());
        suiihyou.setYenknsnkwsrategkyendaka(pSuiihyou.getYenknsnkwsrategkyendaka());
        suiihyou.setYenknsnkwsrategkyenyasu(pSuiihyou.getYenknsnkwsrategkyenyasu());
        suiihyou.setMvaariwup(pSuiihyou.getMvaariwup());
        suiihyou.setMvaariwsame(pSuiihyou.getMvaariwsame());
        suiihyou.setMvaariwdown(pSuiihyou.getMvaariwdown());
        suiihyou.setMvaariwyenupyendaka(pSuiihyou.getMvaariwyenupyendaka());
        suiihyou.setMvaariwyenupyenkijyun(pSuiihyou.getMvaariwyenupyenkijyun());
        suiihyou.setMvaariwyenupyenyasu(pSuiihyou.getMvaariwyenupyenyasu());
        suiihyou.setMvaariwyensameyendaka(pSuiihyou.getMvaariwyensameyendaka());
        suiihyou.setMvaariwyensameyenkijyun(pSuiihyou.getMvaariwyensameyenkijyun());
        suiihyou.setMvaariwyensameyenyasu(pSuiihyou.getMvaariwyensameyenyasu());
        suiihyou.setMvaariwyendownyendaka(pSuiihyou.getMvaariwyendownyendaka());
        suiihyou.setMvaariwyendownyenkijyun(pSuiihyou.getMvaariwyendownyenkijyun());
        suiihyou.setMvaariwyendownyenyasu(pSuiihyou.getMvaariwyendownyenyasu());
        suiihyou.setMvaariptumitatekin(pSuiihyou.getMvaariptumitatekin());
        suiihyou.setMvanonewsame(pSuiihyou.getMvanonewsame());
        suiihyou.setMvanonewyensameyendaka(pSuiihyou.getMvanonewyensameyendaka());
        suiihyou.setMvanonewyensameyenkijyun(pSuiihyou.getMvanonewyensameyenkijyun());
        suiihyou.setMvanonewyensameyenyasu(pSuiihyou.getMvanonewyensameyenyasu());
        suiihyou.setMvanoneptumitatekin(pSuiihyou.getMvanoneptumitatekin());
        suiihyou.setMkhyouyensysnikougk(pSuiihyou.getMkhyouyensysnikougk());
        suiihyou.setGyoumuKousinKinou(pKinouId);
        suiihyou.setGyoumuKousinsyaId(pKosinsyaId);
        suiihyou.setGyoumuKousinTime(pSysTime);
        suiihyou.setSuiihyousyubetu(pSuiihyou.getSuiihyousyubetu());

        BizPropertyInitializer.initialize(suiihyou);
    }
}
