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
 * 契約保全 契約保全共通 推移表ＴＢＬ編集（終身２）
 */
public class EditSuiihyouTblSyuusin2 {

    private static final String MSGHIKISUU = "解約返戻金計算拡張情報作成が実行できませんでした。";

    private static final String DUMMYSUIIHYOUSYUBETU = "00";

    private static final int DUMMYKEIKANEN = 99;

    @Inject
    private static Logger logger;

    public EditSuiihyouTblSyuusin2() {
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

        logger.debug("▽ 推移表TBL編集（終身２） 開始");

        C_Tuukasyu keiyakuTuukasyu = pKykSyohnSyuLst.get(0).getKyktuukasyu();
        BizDate calcKijyunYmd = pEditHokenSyoukenParam.getCalckijyunYMD();
        BizDate kwsrateKjymd = pKykSyohnSyuLst.get(0).getKykymd();
        C_SinsaihkKbn csinsaihkKbn = C_SinsaihkKbn.BLNK;

        if (C_SinsaihkKbn.SIN.eq(pCSinsaihkKbn) ||
            (C_SinsaihkKbn.SAI.eq(pCSinsaihkKbn) &&
                C_SyoukensaihkKbn.SINKEIYAKUSAISAKUSEI.eq(pEditHokenSyoukenParam.getSyoukenSaihk()))) {
            csinsaihkKbn = C_SinsaihkKbn.SIN;
        }
        else {
            csinsaihkKbn = C_SinsaihkKbn.SAI;
        }

        WSuiihyouSyuusin2 wSuiihyouSyuusin2 = SWAKInjector.getInstance(WSuiihyouSyuusin2.class);

        WSuiihyouParam wSuiihyouParam = SWAKInjector.getInstance(WSuiihyouParam.class);

        KeisanWExtBean keisanWExtBean = SWAKInjector.getInstance(KeisanWExtBean.class);

        List<IT_Suiihyou> wsuiihyouLst = new ArrayList<>();

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
            wSuiihyouSyuusin2.setYenkansannYhKbn(C_YouhiKbn.HUYOU);
        }

        wsuiihyouLst = wSuiihyouSyuusin2.exec(wSuiihyouParam);

        BizDate syoribiYmd = pSyoriYmd;
        String kinouId = pKkanriCommonParam.getFunctionId();
        String kosinsyaId = pKkanriCommonParam.getUserID();
        String sysTime = BizDate.getSysDateTimeMilli();

        int suiihyouTblSttiCnt = 0;

        int sinki_common[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 20, 25, 30, 35, 40, 45, 50, 55 };
        int sinki_nenrei30[] = { 65, 75 };
        int sinki_nenrei31to35[] = { 60, 70 };
        int sinki_nenrei36over[] = { 60, 65 };

        Integer hhknnen = pKykSyohnSyuLst.get(0).getHhknnen();
        Integer hhknnen_30 = 30;
        Integer hhknnen_35 = 35;

        boolean sytrykKeikanenHoseiYouhiKbn = false;
        Integer znMvatekikkn = 0;
        int rnzkSytRykMaxKeikanenSuu = 5;
        int rnzkSyutrykNensuu = 0;
        int mvaNoneSytrykKanouGyoCnt = 0;
        int syryKeikanenSuu = 5;
        int maxSytrykNenrei = 101;
        int mvaNoneMaxSytrykGyou = 14;
        BizNumber sytrykKikanenHoseiOverGyoCnt = BizNumber.ZERO;

        int sai_common[] = { 0, 1, 2, 3, 4, 9, 14, 19, 24, 29, 34, 39 };
        int sai_over0[] = { 44, 49, 54, 59, 64 };
        int sai_over1[] = { 44, 54 };
        int sai_over2[] = { 49, 59 };
        int sai_over1_mva[] = { 44, 49, 59 };
        int yen_common[] = { 0, 1, 2, 3, 4, 9, 14, 19, 24, 29 };
        int yen_over0[] = { 34, 39, 44, 49, 54, 59, 64 };
        int yen_over1[] = { 34, 39, 44, 54 };
        int yen_over2[] = { 34, 39, 49, 59 };
        int yen_over3[] = { 34, 44, 54, 64 };
        int yen_over4[] = { 39, 49, 59, 69 };

        for (int index = 0; index < wsuiihyouLst.size(); index++) {

            IT_Suiihyou suiihyou = wsuiihyouLst.get(index);

            if (C_SinsaihkKbn.SIN.eq(csinsaihkKbn)) {
                if (Arrays.binarySearch(sinki_common, index) >= 0) {
                    setSuiihyouTbl(pKykKihon, suiihyou, syoribiYmd, keiyakuTuukasyu, kinouId, kosinsyaId, sysTime);
                }
                if (hhknnen_30.equals(hhknnen)){
                    if (Arrays.binarySearch(sinki_nenrei30, index) >= 0) {
                        setSuiihyouTbl(pKykKihon, suiihyou, syoribiYmd, keiyakuTuukasyu, kinouId, kosinsyaId, sysTime);
                    }
                }
                else if(hhknnen <= hhknnen_35){
                    if (Arrays.binarySearch(sinki_nenrei31to35, index) >= 0) {
                        setSuiihyouTbl(pKykKihon, suiihyou, syoribiYmd, keiyakuTuukasyu, kinouId, kosinsyaId, sysTime);
                    }
                }
                else {
                    if (Arrays.binarySearch(sinki_nenrei36over, index) >= 0) {
                        setSuiihyouTbl(pKykKihon, suiihyou, syoribiYmd, keiyakuTuukasyu, kinouId, kosinsyaId, sysTime);
                    }
                }
            }

            else if (C_SinsaihkKbn.SAI.eq(csinsaihkKbn)) {
                if (index == 0) {
                    if(pSyouhnZokusei.getMvatekikkn() > suiihyou.getKeikanensuu()){
                        znMvatekikkn = pSyouhnZokusei.getMvatekikkn() - suiihyou.getKeikanensuu();
                    }

                    if (C_MvaTekiyoujyoutaiKbn.MVAARI.eq(suiihyou.getMvatekijyoutaikbn())) {
                        if(znMvatekikkn < rnzkSytRykMaxKeikanenSuu){
                            sytrykKeikanenHoseiYouhiKbn = true;
                        }
                    }
                    else{
                        sytrykKeikanenHoseiYouhiKbn = true;
                    }

                    if(sytrykKeikanenHoseiYouhiKbn){
                        rnzkSyutrykNensuu = maxSytrykNenrei - hhknnen - suiihyou.getKeikanensuu() - rnzkSytRykMaxKeikanenSuu + 1;

                        mvaNoneSytrykKanouGyoCnt = mvaNoneMaxSytrykGyou - (rnzkSytRykMaxKeikanenSuu - znMvatekikkn);

                        sytrykKikanenHoseiOverGyoCnt =
                            BizNumber.valueOf(rnzkSyutrykNensuu).divide(BizNumber.valueOf(syryKeikanenSuu),0, RoundingMode.UP).subtract(
                                BizNumber.valueOf(mvaNoneSytrykKanouGyoCnt));
                    }
                }

                if (!sytrykKeikanenHoseiYouhiKbn) {
                    if (index < rnzkSytRykMaxKeikanenSuu) {
                        setSuiihyouTbl(pKykKihon, suiihyou, syoribiYmd, keiyakuTuukasyu, kinouId, kosinsyaId, sysTime);
                        suiihyouTblSttiCnt = index + 1;
                    }
                    else {
                        if (C_MvaTekiyoujyoutaiKbn.MVAARI.eq(suiihyou.getMvatekijyoutaikbn())) {
                            setSuiihyouTbl(pKykKihon, suiihyou, syoribiYmd, keiyakuTuukasyu, kinouId, kosinsyaId, sysTime);
                            suiihyouTblSttiCnt = index + 1;
                        }
                        else if (index == suiihyouTblSttiCnt) {
                            setSuiihyouTbl(pKykKihon, suiihyou, syoribiYmd, keiyakuTuukasyu, kinouId, kosinsyaId, sysTime);
                            suiihyouTblSttiCnt = suiihyouTblSttiCnt + syryKeikanenSuu;
                        }
                    }
                }
                else{
                    if(pKykSyohnSyuLst.get(0).getYendthnkymd() != null){
                        if (Arrays.binarySearch(yen_common, index) >= 0) {
                            setSuiihyouTbl(pKykKihon, suiihyou, syoribiYmd, keiyakuTuukasyu, kinouId, kosinsyaId, sysTime);
                        }
                        if (sytrykKikanenHoseiOverGyoCnt.equals(BizNumber.valueOf(1)) &&
                            Arrays.binarySearch(yen_over1, index) >= 0) {
                            setSuiihyouTbl(pKykKihon, suiihyou, syoribiYmd, keiyakuTuukasyu, kinouId, kosinsyaId, sysTime);
                        }
                        else if(sytrykKikanenHoseiOverGyoCnt.equals(BizNumber.valueOf(2)) &&
                            Arrays.binarySearch(yen_over2, index) >= 0) {
                            setSuiihyouTbl(pKykKihon, suiihyou, syoribiYmd, keiyakuTuukasyu, kinouId, kosinsyaId, sysTime);
                        }
                        else if(sytrykKikanenHoseiOverGyoCnt.equals(BizNumber.valueOf(3)) &&
                            Arrays.binarySearch(yen_over3, index) >= 0) {
                            setSuiihyouTbl(pKykKihon, suiihyou, syoribiYmd, keiyakuTuukasyu, kinouId, kosinsyaId, sysTime);
                        }
                        else if(sytrykKikanenHoseiOverGyoCnt.equals(BizNumber.valueOf(4)) &&
                            Arrays.binarySearch(yen_over4, index) >= 0) {
                            setSuiihyouTbl(pKykKihon, suiihyou, syoribiYmd, keiyakuTuukasyu, kinouId, kosinsyaId, sysTime);
                        }
                        else if (sytrykKikanenHoseiOverGyoCnt.compareTo(BizNumber.valueOf(1)) < 0 &&
                            Arrays.binarySearch(yen_over0, index) >= 0) {
                            setSuiihyouTbl(pKykKihon, suiihyou, syoribiYmd, keiyakuTuukasyu, kinouId, kosinsyaId, sysTime);
                        }
                    }else{
                        if (Arrays.binarySearch(sai_common, index) >= 0) {
                            setSuiihyouTbl(pKykKihon, suiihyou, syoribiYmd, keiyakuTuukasyu, kinouId, kosinsyaId, sysTime);
                        }
                        if (sytrykKikanenHoseiOverGyoCnt.equals(BizNumber.valueOf(2))){
                            if (Arrays.binarySearch(sai_over2, index) >= 0) {
                                setSuiihyouTbl(pKykKihon, suiihyou, syoribiYmd, keiyakuTuukasyu, kinouId, kosinsyaId, sysTime);
                            }
                        }
                        else if (sytrykKikanenHoseiOverGyoCnt.equals(BizNumber.ONE)){
                            if(znMvatekikkn > 0){
                                if (Arrays.binarySearch(sai_over1_mva, index) >= 0) {
                                    setSuiihyouTbl(pKykKihon, suiihyou, syoribiYmd, keiyakuTuukasyu, kinouId, kosinsyaId, sysTime);
                                }
                            }
                            else{
                                if (Arrays.binarySearch(sai_over1, index) >= 0) {
                                    setSuiihyouTbl(pKykKihon, suiihyou, syoribiYmd, keiyakuTuukasyu, kinouId, kosinsyaId, sysTime);
                                }
                            }
                        }
                        else {
                            if (Arrays.binarySearch(sai_over0, index) >= 0) {
                                setSuiihyouTbl(pKykKihon, suiihyou, syoribiYmd, keiyakuTuukasyu, kinouId, kosinsyaId, sysTime);
                            }
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

        logger.debug("△ 推移表TBL編集（終身２） 終了");
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
