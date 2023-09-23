package yuyu.common.hozen.khcommon;

import java.util.List;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_SinsaihkKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.IT_HhknSya;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.IT_KykSyouhn;

/**
 * 契約保全 契約保全共通 推移表ＴＢＬ編集
 */
public class EditSuiihyouTbl2 {

//        private static final String MSGHIKISUU = "解約返戻金計算拡張情報作成が実行できませんでした。";
//
//        private final static String SUIIHYOUSYUBETU_SISUU = "05";
//
//        private final static String SUIIHYOUSYUBETU_SISUU_SISYKIKNEN = "06";

    public EditSuiihyouTbl2() {
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

//                C_Tuukasyu keiyakuTuukasyu = pKykSyohnSyuLst.get(0).getKyktuukasyu();
//                BizDate calcKijyunYmd = pEditHokenSyoukenParam.getCalckijyunYMD();
//                BizDate kwsrateKjymd = null;
//                C_SinsaihkKbn csinsaihkKbn = C_SinsaihkKbn.BLNK;
//
//                if (C_SinsaihkKbn.SIN.eq(pCSinsaihkKbn) ||
//                    (C_SinsaihkKbn.SAI.eq(pCSinsaihkKbn) &&
//                        C_SyoukensaihkKbn.SINKEIYAKUSAISAKUSEI.eq(pEditHokenSyoukenParam.getSyoukenSaihk()))) {
//                    csinsaihkKbn = C_SinsaihkKbn.SIN;
//                    kwsrateKjymd = pKykKihon.getFstpnyknymd();
//                }
//                else {
//                    csinsaihkKbn = C_SinsaihkKbn.SAI;
//                    kwsrateKjymd = pSyoriYmd.addBusinessDays(-1);
//                }
//
//                WSuiihyou2 wsuiihyou = SWAKInjector.getInstance(WSuiihyou2.class);
//
//                WSuiihyouParam wSuiihyouParam = SWAKInjector.getInstance(WSuiihyouParam.class);
//
//                KeisanWExtBean keisanWExtBean = SWAKInjector.getInstance(KeisanWExtBean.class);
//
//                List<IT_Suiihyou> wsuiihyouLst = new ArrayList<>();
//
//                int keikanenkjn;
//
//                int keikanenkjn5nengo;
//
//                int maxKeikanenSuu;
//
//                if (C_SinsaihkKbn.SIN.eq(csinsaihkKbn)) {
//
//                    keisanWExtBean.setSyouhncd(pKykSyohnSyuLst.get(0).getSyouhncd());
//                    keisanWExtBean.setSyouhnsdno(pKykSyohnSyuLst.get(0).getSyouhnsdno());
//                    keisanWExtBean.setRyouritusdno(pKykSyohnSyuLst.get(0).getRyouritusdno());
//                    keisanWExtBean.setYoteiriritu(pKykSyohnSyuLst.get(0).getYoteiriritu());
//                    keisanWExtBean.setHrkkaisuu(pKykKihon.getHrkkaisuu());
//                    keisanWExtBean.setHknkknsmnkbn(pKykSyohnSyuLst.get(0).getHknkknsmnkbn());
//                    keisanWExtBean.setHknkkn(pKykSyohnSyuLst.get(0).getHknkkn());
//                    keisanWExtBean.setHrkkkn(pKykSyohnSyuLst.get(0).getHrkkkn());
//                    keisanWExtBean.setHhknnen(pKykSyohnSyuLst.get(0).getHhknnen());
//                    keisanWExtBean.setHhknsei(pKykSyohnSyuLst.get(0).getHhknsei());
//                    keisanWExtBean.setKihons(pKykSyohnSyuLst.get(0).getKihons());
//                    keisanWExtBean.setHokenryou(pKykSyohnSyuLst.get(0).getHokenryou());
//                    keisanWExtBean.setKykymd(pKykSyohnSyuLst.get(0).getKykymd());
//                    keisanWExtBean.setTuukasyu(keiyakuTuukasyu);
//                    keisanWExtBean.setKyksjkkktyouseiriritu(pKykSyohnSyuLst.get(0).getKyksjkkktyouseiriritu());
//                    keisanWExtBean.setKaiyakusjkkktyouseiriritu(BizNumber.valueOf(0));
//                    keisanWExtBean.setTmttkntaisyouym(null);
//                    keisanWExtBean.setTeiritutmttkngk(BizCurrency.valueOf(0));
//                    keisanWExtBean.setSisuurendoutmttkngk(BizCurrency.valueOf(0));
//                    keisanWExtBean.setTmttknhaneisisuu(BizNumber.valueOf(100));
//                    keisanWExtBean.setTumitateriritu(BizNumber.valueOf(0));
//
//                } else {
//                    KeisanWExt keisanWExt = SWAKInjector.getInstance(KeisanWExt.class);
//
//                    C_ErrorKbn errorKbn = keisanWExt.exec(pKykKihon.getSyono(), calcKijyunYmd);
//
//                    if (C_ErrorKbn.ERROR.eq(errorKbn)) {
//
//                        throw new CommonBizAppException(MSGHIKISUU);
//                    }
//
//                    keisanWExtBean = keisanWExt.getKeisanWExtBean();
//
//                }
//
//                wSuiihyouParam.setKeisanWExtBean(keisanWExtBean);
//                wSuiihyouParam.setKwsratekjymd(kwsrateKjymd);
//                wSuiihyouParam.setCalcKijyunYmd(calcKijyunYmd);
//                wSuiihyouParam.setSinsaihkKbn(csinsaihkKbn);
//                wSuiihyouParam.setSyoukensaihkKbn(pEditHokenSyoukenParam.getSyoukenSaihk());
//                wSuiihyouParam.setMvaTekiUmu(pSyouhnZokusei.getMvatekiumu());
//                wSuiihyouParam.setMvaTekiKkn(pSyouhnZokusei.getMvatekikkn());
//                wSuiihyouParam.setSetteiBairitu(pKykSyohnSyuLst.get(0).getSetteibairitu());
//                wSuiihyouParam.setTmttknZoukarituJygn(pKykSyohnSyuLst.get(0).getTmttknzoukaritujygn());
//                wSuiihyouParam.setSisuurendourate(pKykSyohnSyuLst.get(0).getKykjisisuurendourate());
//                wSuiihyouParam.setTargetTkykKijyungk(pKykSonotaTkyk.getTargettkykkijyungk());
//
//                int syohinHanteiKbn = SyouhinUtil.hantei(pKykSyohnSyuLst.get(0).getSyouhncd());
//
//                if (syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR) {
//
//                    keikanenkjn = pKykSyohnSyuLst.get(0).getHknkkn();
//                    keikanenkjn5nengo = -1;
//                    maxKeikanenSuu = pKykSyohnSyuLst.get(0).getHknkkn();
//                }
//                else {
//                    if (C_Tuukasyu.JPY.eq(keiyakuTuukasyu)) {
//
//                        wsuiihyou.setYenkansannYhKbn(C_YouhiKbn.HUYOU);
//                    }
//
//                    wsuiihyouLst = wsuiihyou.exec(wSuiihyouParam);
//                    BizNumber keikanenkjnCalc = BizNumber.valueOf(pKykSyohnSyuLst.get(0).getHhknnen() + 25).divide(4)
//                        .round(0, RoundingMode.HALF_UP).subtract(BizNumber.ONE);
//                    keikanenkjn = Integer.parseInt(keikanenkjnCalc.toString());
//                    keikanenkjn5nengo = keikanenkjn + 5 - 1;
//                    maxKeikanenSuu = 5;
//                }
//
//                BizDate syoribiYmd = BizDate.getSysDate();
//
//                String kinouId = pKkanriCommonParam.getFunctionId();
//
//                String kosinsyaId = pKkanriCommonParam.getUserID();
//
//                String sysTime = BizDate.getSysDateTimeMilli();
//
//                C_MvaTekiyoujyoutaiKbn saihkMvaTekyjyoutaiKbn = C_MvaTekiyoujyoutaiKbn.MVANONE;
//
//                int suiihyouTblSttiCnt = 0;
//
//                int saihakkouMvanone[] = { 0, 1, 2, 3, 4, 9, 14, 19, 24, 29, 34, 39, 44, 49 };
//
//                boolean SuiihyouSaisyuuKeikaFlag = false;
//
//                if (C_SinsaihkKbn.SAI.eq(csinsaihkKbn) && wsuiihyouLst.size() == 1) {
//
//                    IT_Suiihyou suiihyou = wsuiihyouLst.get(0);
//
//                    if (suiihyou.getSuiihyousyubetu().equals(SUIIHYOUSYUBETU_SISUU)){
//                        SuiihyouSaisyuuKeikaFlag = true;
//                    }
//                }
//                if (SuiihyouSaisyuuKeikaFlag){
//                    IT_Suiihyou suiihyou = wsuiihyouLst.get(0);
//
//                    setSuiihyouTblSisuuSaisyuu(pKykKihon,
//                        suiihyou,
//                        syoribiYmd,
//                        keiyakuTuukasyu,
//                        kinouId,
//                        kosinsyaId,
//                        sysTime);
//                }
//                else{
//                    for (int index = 0; index < wsuiihyouLst.size(); index++) {
//
//                        IT_Suiihyou suiihyou = wsuiihyouLst.get(index);
//
//                        if (C_SinsaihkKbn.SIN.eq(csinsaihkKbn)) {
//
//                            if (index < keikanenkjn || (index >= keikanenkjn && index == keikanenkjn5nengo)) {
//
//                                setSuiihyouTbl(pKykKihon,
//                                    suiihyou,
//                                    syoribiYmd,
//                                    keiyakuTuukasyu,
//                                    kinouId,
//                                    kosinsyaId,
//                                    sysTime);
//
//                                if (index == keikanenkjn5nengo) {
//                                    keikanenkjn5nengo += 5;
//                                }
//                            }
//                        }
//                        else if (C_SinsaihkKbn.SAI.eq(csinsaihkKbn)) {
//                            if (index == 0) {
//                                if (C_MvaTekiyoujyoutaiKbn.MVANONE.eq(suiihyou.getMvatekijyoutaikbn()) ||
//                                    (C_MvaTekiyoujyoutaiKbn.MVAARINONE.eq(suiihyou.getMvatekijyoutaikbn()))) {
//                                    saihkMvaTekyjyoutaiKbn = C_MvaTekiyoujyoutaiKbn.MVANONE;
//                                }
//                                else {
//                                    saihkMvaTekyjyoutaiKbn = C_MvaTekiyoujyoutaiKbn.MVAARI;
//                                }
//                            }
//                            if (C_MvaTekiyoujyoutaiKbn.MVANONE.eq(saihkMvaTekyjyoutaiKbn)) {
//                                if (Arrays.binarySearch(saihakkouMvanone, index) >= 0) {
//                                    setSuiihyouTbl(pKykKihon,
//                                        suiihyou,
//                                        syoribiYmd,
//                                        keiyakuTuukasyu,
//                                        kinouId,
//                                        kosinsyaId,
//                                        sysTime);
//                                }
//
//                            }
//                            else if (C_MvaTekiyoujyoutaiKbn.MVAARI.eq(saihkMvaTekyjyoutaiKbn)) {
//                                if (index < maxKeikanenSuu) {
//                                    setSuiihyouTbl(pKykKihon,
//                                        suiihyou,
//                                        syoribiYmd,
//                                        keiyakuTuukasyu,
//                                        kinouId,
//                                        kosinsyaId,
//                                        sysTime);
//
//                                    if (C_MvaTekiyoujyoutaiKbn.MVAARINONE.eq(suiihyou.getMvatekijyoutaikbn())) {
//                                        suiihyouTblSttiCnt = 9;
//                                    }
//
//                                }
//                                else if (index >= maxKeikanenSuu) {
//                                    if (C_MvaTekiyoujyoutaiKbn.MVAARI.eq(suiihyou.getMvatekijyoutaikbn())) {
//                                        setSuiihyouTbl(pKykKihon,
//                                            suiihyou,
//                                            syoribiYmd,
//                                            keiyakuTuukasyu,
//                                            kinouId,
//                                            kosinsyaId,
//                                            sysTime);
//                                    }
//                                    else if (C_MvaTekiyoujyoutaiKbn.MVAARINONE.eq(suiihyou.getMvatekijyoutaikbn())) {
//                                        setSuiihyouTbl(pKykKihon,
//                                            suiihyou,
//                                            syoribiYmd,
//                                            keiyakuTuukasyu,
//                                            kinouId,
//                                            kosinsyaId,
//                                            sysTime);
//                                        suiihyouTblSttiCnt = index + 5;
//
//                                    }
//                                    else if (C_MvaTekiyoujyoutaiKbn.MVANONE.eq(suiihyou.getMvatekijyoutaikbn()) &&
//                                        index == suiihyouTblSttiCnt) {
//                                        setSuiihyouTbl(pKykKihon,
//                                            suiihyou,
//                                            syoribiYmd,
//                                            keiyakuTuukasyu,
//                                            kinouId,
//                                            kosinsyaId,
//                                            sysTime);
//                                        suiihyouTblSttiCnt = suiihyouTblSttiCnt + 5;
//                                    }
//                                }
//                            }
//                        }
//                    }
//                }
    }

//        private void setSuiihyouTbl(IT_KykKihon pKykKihon,
//            IT_Suiihyou pSuiihyou,
//            BizDate pSyoribiYmd,
//            C_Tuukasyu pKeiyakuTuukasyu,
//            String pKinouId,
//            String pKosinsyaId,
//            String pSysTime) {
//
//            IT_Suiihyou suiihyou = pKykKihon.createSuiihyou();
//
//            suiihyou.setTyouhyouymd(pSyoribiYmd);
//            suiihyou.setKeikanensuu(pSuiihyou.getKeikanensuu());
//            suiihyou.setCalckijyunymd(pSuiihyou.getCalckijyunymd());
//            suiihyou.setCalcym(pSuiihyou.getCalcym());
//            suiihyou.setMvatekijyoutaikbn(pSuiihyou.getMvatekijyoutaikbn());
//            suiihyou.setKyktuukasyu(pKeiyakuTuukasyu);
//            suiihyou.setSjkkktusirrtup(pSuiihyou.getSjkkktusirrtup());
//            suiihyou.setSjkkktusirrtsame(pSuiihyou.getSjkkktusirrtsame());
//            suiihyou.setSjkkktusirrtdown(pSuiihyou.getSjkkktusirrtdown());
//            suiihyou.setSjkkktusirrthendouup(pSuiihyou.getSjkkktusirrthendouup());
//            suiihyou.setSjkkktusirrthendoudown(pSuiihyou.getSjkkktusirrthendoudown());
//            suiihyou.setYenknsnkwsrateyendaka(pSuiihyou.getYenknsnkwsrateyendaka());
//            suiihyou.setYenknsnkwsrateyenkijyun(pSuiihyou.getYenknsnkwsrateyenkijyun());
//            suiihyou.setYenknsnkwsrateyenyasu(pSuiihyou.getYenknsnkwsrateyenyasu());
//            suiihyou.setYenknsnkwsrategkyendaka(pSuiihyou.getYenknsnkwsrategkyendaka());
//            suiihyou.setYenknsnkwsrategkyenyasu(pSuiihyou.getYenknsnkwsrategkyenyasu());
//            suiihyou.setMvaariwup(pSuiihyou.getMvaariwup());
//            suiihyou.setMvaariwsame(pSuiihyou.getMvaariwsame());
//            suiihyou.setMvaariwdown(pSuiihyou.getMvaariwdown());
//            suiihyou.setMvaariwyenupyendaka(pSuiihyou.getMvaariwyenupyendaka());
//            suiihyou.setMvaariwyenupyenkijyun(pSuiihyou.getMvaariwyenupyenkijyun());
//            suiihyou.setMvaariwyenupyenyasu(pSuiihyou.getMvaariwyenupyenyasu());
//            suiihyou.setMvaariwyensameyendaka(pSuiihyou.getMvaariwyensameyendaka());
//            suiihyou.setMvaariwyensameyenkijyun(pSuiihyou.getMvaariwyensameyenkijyun());
//            suiihyou.setMvaariwyensameyenyasu(pSuiihyou.getMvaariwyensameyenyasu());
//            suiihyou.setMvaariwyendownyendaka(pSuiihyou.getMvaariwyendownyendaka());
//            suiihyou.setMvaariwyendownyenkijyun(pSuiihyou.getMvaariwyendownyenkijyun());
//            suiihyou.setMvaariwyendownyenyasu(pSuiihyou.getMvaariwyendownyenyasu());
//            suiihyou.setMvaariptumitatekin(pSuiihyou.getMvaariptumitatekin());
//            suiihyou.setMvanonewsame(pSuiihyou.getMvanonewsame());
//            suiihyou.setMvanonewyensameyendaka(pSuiihyou.getMvanonewyensameyendaka());
//            suiihyou.setMvanonewyensameyenkijyun(pSuiihyou.getMvanonewyensameyenkijyun());
//            suiihyou.setMvanonewyensameyenyasu(pSuiihyou.getMvanonewyensameyenyasu());
//            suiihyou.setMvanoneptumitatekin(pSuiihyou.getMvanoneptumitatekin());
//            suiihyou.setMkhyouyensysnikougk(pSuiihyou.getMkhyouyensysnikougk());
//            suiihyou.setGyoumuKousinKinou(pKinouId);
//            suiihyou.setGyoumuKousinsyaId(pKosinsyaId);
//            suiihyou.setGyoumuKousinTime(pSysTime);
//            suiihyou.setSisuuupritu1(pSuiihyou.getSisuuupritu1());
//            suiihyou.setTmttknzoukaritu1(pSuiihyou.getTmttknzoukaritu1());
//            suiihyou.setTutmttknutiwake11(pSuiihyou.getTutmttknutiwake11());
//            suiihyou.setTutmttknutiwake21(pSuiihyou.getTutmttknutiwake21());
//            suiihyou.setMvaaritmttkgkkykkjmaeup1(pSuiihyou.getMvaaritmttkgkkykkjmaeup1());
//            suiihyou.setMvaaritmttkgkkykkjmaesame1(pSuiihyou.getMvaaritmttkgkkykkjmaesame1());
//            suiihyou.setMvaaritmttkgkkykkjmaedown1(pSuiihyou.getMvaaritmttkgkkykkjmaedown1());
//            suiihyou.setSjkkktusirrtup2(pSuiihyou.getSjkkktusirrtup2());
//            suiihyou.setSjkkktusirrtsame2(pSuiihyou.getSjkkktusirrtsame2());
//            suiihyou.setSjkkktusirrtdown2(pSuiihyou.getSjkkktusirrtdown2());
//            suiihyou.setSjkkktusirrthendouup2(pSuiihyou.getSjkkktusirrthendouup2());
//            suiihyou.setSjkkktusirrthendoudown2(pSuiihyou.getSjkkktusirrthendoudown2());
//            suiihyou.setYenknsnkwsrateyendaka2(pSuiihyou.getYenknsnkwsrateyendaka2());
//            suiihyou.setYenknsnkwsrateyenkijyun2(pSuiihyou.getYenknsnkwsrateyenkijyun2());
//            suiihyou.setYenknsnkwsrateyenyasu2(pSuiihyou.getYenknsnkwsrateyenyasu2());
//            suiihyou.setYenknsnkwsrategkyendaka2(pSuiihyou.getYenknsnkwsrategkyendaka2());
//            suiihyou.setYenknsnkwsrategkyenyasu2(pSuiihyou.getYenknsnkwsrategkyenyasu2());
//            suiihyou.setSisuuupritu2(pSuiihyou.getSisuuupritu2());
//            suiihyou.setTmttknzoukaritu2(pSuiihyou.getTmttknzoukaritu2());
//            suiihyou.setMvaaritmttkgkkykkjmaeup2(pSuiihyou.getMvaaritmttkgkkykkjmaeup2());
//            suiihyou.setMvaaritmttkgkkykkjmaesame2(pSuiihyou.getMvaaritmttkgkkykkjmaesame2());
//            suiihyou.setMvaaritmttkgkkykkjmaedown2(pSuiihyou.getMvaaritmttkgkkykkjmaedown2());
//            suiihyou.setMvaariwup2(pSuiihyou.getMvaariwup2());
//            suiihyou.setMvaariwsame2(pSuiihyou.getMvaariwsame2());
//            suiihyou.setMvaariwdown2(pSuiihyou.getMvaariwdown2());
//            suiihyou.setMvaariwyenupyendaka2(pSuiihyou.getMvaariwyenupyendaka2());
//            suiihyou.setMvaariwyenupyenkijyun2(pSuiihyou.getMvaariwyenupyenkijyun2());
//            suiihyou.setMvaariwyenupyenyasu2(pSuiihyou.getMvaariwyenupyenyasu2());
//            suiihyou.setMvaariwyensameyendaka2(pSuiihyou.getMvaariwyensameyendaka2());
//            suiihyou.setMvaariwyensameyenkijyun2(pSuiihyou.getMvaariwyensameyenkijyun2());
//            suiihyou.setMvaariwyensameyenyasu2(pSuiihyou.getMvaariwyensameyenyasu2());
//            suiihyou.setMvaariwyendownyendaka2(pSuiihyou.getMvaariwyendownyendaka2());
//            suiihyou.setMvaariwyendownyenkijyun2(pSuiihyou.getMvaariwyendownyenkijyun2());
//            suiihyou.setMvaariwyendownyenyasu2(pSuiihyou.getMvaariwyendownyenyasu2());
//            suiihyou.setMvaariptumitatekin2(pSuiihyou.getMvaariptumitatekin2());
//            suiihyou.setMvanonewsame2(pSuiihyou.getMvanonewsame2());
//            suiihyou.setMvanonewyensameyendaka2(pSuiihyou.getMvanonewyensameyendaka2());
//            suiihyou.setMvanonewyensameyenkijyun2(pSuiihyou.getMvanonewyensameyenkijyun2());
//            suiihyou.setMvanonewyensameyenyasu2(pSuiihyou.getMvanonewyensameyenyasu2());
//            suiihyou.setMvanoneptumitatekin2(pSuiihyou.getMvanoneptumitatekin2());
//            suiihyou.setTutmttknutiwake12(pSuiihyou.getTutmttknutiwake12());
//            suiihyou.setTutmttknutiwake22(pSuiihyou.getTutmttknutiwake22());
//            suiihyou.setSjkkktusirrtup3(pSuiihyou.getSjkkktusirrtup3());
//            suiihyou.setSjkkktusirrtsame3(pSuiihyou.getSjkkktusirrtsame3());
//            suiihyou.setSjkkktusirrtdown3(pSuiihyou.getSjkkktusirrtdown3());
//            suiihyou.setSjkkktusirrthendouup3(pSuiihyou.getSjkkktusirrthendouup3());
//            suiihyou.setSjkkktusirrthendoudown3(pSuiihyou.getSjkkktusirrthendoudown3());
//            suiihyou.setYenknsnkwsrateyendaka3(pSuiihyou.getYenknsnkwsrateyendaka3());
//            suiihyou.setYenknsnkwsrateyenkijyun3(pSuiihyou.getYenknsnkwsrateyenkijyun3());
//            suiihyou.setYenknsnkwsrateyenyasu3(pSuiihyou.getYenknsnkwsrateyenyasu3());
//            suiihyou.setYenknsnkwsrategkyendaka3(pSuiihyou.getYenknsnkwsrategkyendaka3());
//            suiihyou.setYenknsnkwsrategkyenyasu3(pSuiihyou.getYenknsnkwsrategkyenyasu3());
//            suiihyou.setSisuuupritu3(pSuiihyou.getSisuuupritu3());
//            suiihyou.setTmttknzoukaritu3(pSuiihyou.getTmttknzoukaritu3());
//            suiihyou.setMvaaritmttkgkkykkjmaeup3(pSuiihyou.getMvaaritmttkgkkykkjmaeup3());
//            suiihyou.setMvaaritmttkgkkykkjmaesame3(pSuiihyou.getMvaaritmttkgkkykkjmaesame3());
//            suiihyou.setMvaaritmttkgkkykkjmaedown3(pSuiihyou.getMvaaritmttkgkkykkjmaedown3());
//            suiihyou.setMvaariwup3(pSuiihyou.getMvaariwup3());
//            suiihyou.setMvaariwsame3(pSuiihyou.getMvaariwsame3());
//            suiihyou.setMvaariwdown3(pSuiihyou.getMvaariwdown3());
//            suiihyou.setMvaariwyenupyendaka3(pSuiihyou.getMvaariwyenupyendaka3());
//            suiihyou.setMvaariwyenupyenkijyun3(pSuiihyou.getMvaariwyenupyenkijyun3());
//            suiihyou.setMvaariwyenupyenyasu3(pSuiihyou.getMvaariwyenupyenyasu3());
//            suiihyou.setMvaariwyensameyendaka3(pSuiihyou.getMvaariwyensameyendaka3());
//            suiihyou.setMvaariwyensameyenkijyun3(pSuiihyou.getMvaariwyensameyenkijyun3());
//            suiihyou.setMvaariwyensameyenyasu3(pSuiihyou.getMvaariwyensameyenyasu3());
//            suiihyou.setMvaariwyendownyendaka3(pSuiihyou.getMvaariwyendownyendaka3());
//            suiihyou.setMvaariwyendownyenkijyun3(pSuiihyou.getMvaariwyendownyenkijyun3());
//            suiihyou.setMvaariwyendownyenyasu3(pSuiihyou.getMvaariwyendownyenyasu3());
//            suiihyou.setMvaariptumitatekin3(pSuiihyou.getMvaariptumitatekin3());
//            suiihyou.setMvanonewsame3(pSuiihyou.getMvanonewsame3());
//            suiihyou.setMvanonewyensameyendaka3(pSuiihyou.getMvanonewyensameyendaka3());
//            suiihyou.setMvanonewyensameyenkijyun3(pSuiihyou.getMvanonewyensameyenkijyun3());
//            suiihyou.setMvanonewyensameyenyasu3(pSuiihyou.getMvanonewyensameyenyasu3());
//            suiihyou.setMvanoneptumitatekin3(pSuiihyou.getMvanoneptumitatekin3());
//            suiihyou.setTutmttknutiwake13(pSuiihyou.getTutmttknutiwake13());
//            suiihyou.setTutmttknutiwake23(pSuiihyou.getTutmttknutiwake23());
//            suiihyou.setSuiihyousyubetu(pSuiihyou.getSuiihyousyubetu());
//
//            BizPropertyInitializer.initialize(suiihyou);
//        }
//
//        private void setSuiihyouTblSisuuSaisyuu(IT_KykKihon pKykKihon,
//            IT_Suiihyou pSuiihyou,
//            BizDate pSyoribiYmd,
//            C_Tuukasyu pKeiyakuTuukasyu,
//            String pKinouId,
//            String pKosinsyaId,
//            String pSysTime) {
//
//            IT_Suiihyou suiihyou = pKykKihon.createSuiihyou();
//
//            suiihyou.setTyouhyouymd(pSyoribiYmd);
//            suiihyou.setKeikanensuu(pSuiihyou.getKeikanensuu());
//            suiihyou.setCalckijyunymd(pSuiihyou.getCalckijyunymd());
//            suiihyou.setCalcym(pSuiihyou.getCalcym());
//            suiihyou.setMvatekijyoutaikbn(pSuiihyou.getMvatekijyoutaikbn());
//            suiihyou.setKyktuukasyu(pKeiyakuTuukasyu);
//            suiihyou.setMkhyouyensysnikougk(pSuiihyou.getMkhyouyensysnikougk());
//            suiihyou.setGyoumuKousinKinou(pKinouId);
//            suiihyou.setGyoumuKousinsyaId(pKosinsyaId);
//            suiihyou.setGyoumuKousinTime(pSysTime);
//            suiihyou.setSjkkktusirrtup2(pSuiihyou.getSjkkktusirrtup2());
//            suiihyou.setSjkkktusirrtsame2(pSuiihyou.getSjkkktusirrtsame2());
//            suiihyou.setSjkkktusirrtdown2(pSuiihyou.getSjkkktusirrtdown2());
//            suiihyou.setSjkkktusirrthendouup2(pSuiihyou.getSjkkktusirrthendouup2());
//            suiihyou.setSjkkktusirrthendoudown2(pSuiihyou.getSjkkktusirrthendoudown2());
//            suiihyou.setYenknsnkwsrateyendaka2(pSuiihyou.getYenknsnkwsrateyendaka2());
//            suiihyou.setYenknsnkwsrateyenkijyun2(pSuiihyou.getYenknsnkwsrateyenkijyun2());
//            suiihyou.setYenknsnkwsrateyenyasu2(pSuiihyou.getYenknsnkwsrateyenyasu2());
//            suiihyou.setYenknsnkwsrategkyendaka2(pSuiihyou.getYenknsnkwsrategkyendaka2());
//            suiihyou.setYenknsnkwsrategkyenyasu2(pSuiihyou.getYenknsnkwsrategkyenyasu2());
//            suiihyou.setSisuuupritu2(pSuiihyou.getSisuuupritu2());
//            suiihyou.setTmttknzoukaritu2(pSuiihyou.getTmttknzoukaritu2());
//            suiihyou.setMvaaritmttkgkkykkjmaeup2(pSuiihyou.getMvaaritmttkgkkykkjmaeup2());
//            suiihyou.setMvaaritmttkgkkykkjmaesame2(pSuiihyou.getMvaaritmttkgkkykkjmaesame2());
//            suiihyou.setMvaaritmttkgkkykkjmaedown2(pSuiihyou.getMvaaritmttkgkkykkjmaedown2());
//            suiihyou.setMvaariwup2(pSuiihyou.getMvaariwup2());
//            suiihyou.setMvaariwsame2(pSuiihyou.getMvaariwsame2());
//            suiihyou.setMvaariwdown2(pSuiihyou.getMvaariwdown2());
//            suiihyou.setMvaariwyenupyendaka2(pSuiihyou.getMvaariwyenupyendaka2());
//            suiihyou.setMvaariwyenupyenkijyun2(pSuiihyou.getMvaariwyenupyenkijyun2());
//            suiihyou.setMvaariwyenupyenyasu2(pSuiihyou.getMvaariwyenupyenyasu2());
//            suiihyou.setMvaariwyensameyendaka2(pSuiihyou.getMvaariwyensameyendaka2());
//            suiihyou.setMvaariwyensameyenkijyun2(pSuiihyou.getMvaariwyensameyenkijyun2());
//            suiihyou.setMvaariwyensameyenyasu2(pSuiihyou.getMvaariwyensameyenyasu2());
//            suiihyou.setMvaariwyendownyendaka2(pSuiihyou.getMvaariwyendownyendaka2());
//            suiihyou.setMvaariwyendownyenkijyun2(pSuiihyou.getMvaariwyendownyenkijyun2());
//            suiihyou.setMvaariwyendownyenyasu2(pSuiihyou.getMvaariwyendownyenyasu2());
//            suiihyou.setMvaariptumitatekin2(pSuiihyou.getMvaariptumitatekin2());
//            suiihyou.setMvanonewsame2(pSuiihyou.getMvanonewsame2());
//            suiihyou.setMvanonewyensameyendaka2(pSuiihyou.getMvanonewyensameyendaka2());
//            suiihyou.setMvanonewyensameyenkijyun2(pSuiihyou.getMvanonewyensameyenkijyun2());
//            suiihyou.setMvanonewyensameyenyasu2(pSuiihyou.getMvanonewyensameyenyasu2());
//            suiihyou.setMvanoneptumitatekin2(pSuiihyou.getMvanoneptumitatekin2());
//            suiihyou.setTutmttknutiwake12(pSuiihyou.getTutmttknutiwake12());
//            suiihyou.setTutmttknutiwake22(pSuiihyou.getTutmttknutiwake22());
//            suiihyou.setSjkkktusirrtup3(pSuiihyou.getSjkkktusirrtup3());
//            suiihyou.setSjkkktusirrtsame3(pSuiihyou.getSjkkktusirrtsame3());
//            suiihyou.setSjkkktusirrtdown3(pSuiihyou.getSjkkktusirrtdown3());
//            suiihyou.setSjkkktusirrthendouup3(pSuiihyou.getSjkkktusirrthendouup3());
//            suiihyou.setSjkkktusirrthendoudown3(pSuiihyou.getSjkkktusirrthendoudown3());
//            suiihyou.setYenknsnkwsrateyendaka3(pSuiihyou.getYenknsnkwsrateyendaka3());
//            suiihyou.setYenknsnkwsrateyenkijyun3(pSuiihyou.getYenknsnkwsrateyenkijyun3());
//            suiihyou.setYenknsnkwsrateyenyasu3(pSuiihyou.getYenknsnkwsrateyenyasu3());
//            suiihyou.setYenknsnkwsrategkyendaka3(pSuiihyou.getYenknsnkwsrategkyendaka3());
//            suiihyou.setYenknsnkwsrategkyenyasu3(pSuiihyou.getYenknsnkwsrategkyenyasu3());
//            suiihyou.setSisuuupritu3(pSuiihyou.getSisuuupritu3());
//            suiihyou.setTmttknzoukaritu3(pSuiihyou.getTmttknzoukaritu3());
//            suiihyou.setMvaaritmttkgkkykkjmaeup3(pSuiihyou.getMvaaritmttkgkkykkjmaeup3());
//            suiihyou.setMvaaritmttkgkkykkjmaesame3(pSuiihyou.getMvaaritmttkgkkykkjmaesame3());
//            suiihyou.setMvaaritmttkgkkykkjmaedown3(pSuiihyou.getMvaaritmttkgkkykkjmaedown3());
//            suiihyou.setMvaariwup3(pSuiihyou.getMvaariwup3());
//            suiihyou.setMvaariwsame3(pSuiihyou.getMvaariwsame3());
//            suiihyou.setMvaariwdown3(pSuiihyou.getMvaariwdown3());
//            suiihyou.setMvaariwyenupyendaka3(pSuiihyou.getMvaariwyenupyendaka3());
//            suiihyou.setMvaariwyenupyenkijyun3(pSuiihyou.getMvaariwyenupyenkijyun3());
//            suiihyou.setMvaariwyenupyenyasu3(pSuiihyou.getMvaariwyenupyenyasu3());
//            suiihyou.setMvaariwyensameyendaka3(pSuiihyou.getMvaariwyensameyendaka3());
//            suiihyou.setMvaariwyensameyenkijyun3(pSuiihyou.getMvaariwyensameyenkijyun3());
//            suiihyou.setMvaariwyensameyenyasu3(pSuiihyou.getMvaariwyensameyenyasu3());
//            suiihyou.setMvaariwyendownyendaka3(pSuiihyou.getMvaariwyendownyendaka3());
//            suiihyou.setMvaariwyendownyenkijyun3(pSuiihyou.getMvaariwyendownyenkijyun3());
//            suiihyou.setMvaariwyendownyenyasu3(pSuiihyou.getMvaariwyendownyenyasu3());
//            suiihyou.setMvaariptumitatekin3(pSuiihyou.getMvaariptumitatekin3());
//            suiihyou.setMvanonewsame3(pSuiihyou.getMvanonewsame3());
//            suiihyou.setMvanonewyensameyendaka3(pSuiihyou.getMvanonewyensameyendaka3());
//            suiihyou.setMvanonewyensameyenkijyun3(pSuiihyou.getMvanonewyensameyenkijyun3());
//            suiihyou.setMvanonewyensameyenyasu3(pSuiihyou.getMvanonewyensameyenyasu3());
//            suiihyou.setMvanoneptumitatekin3(pSuiihyou.getMvanoneptumitatekin3());
//            suiihyou.setTutmttknutiwake13(pSuiihyou.getTutmttknutiwake13());
//            suiihyou.setTutmttknutiwake23(pSuiihyou.getTutmttknutiwake23());
//            suiihyou.setSuiihyousyubetu(SUIIHYOUSYUBETU_SISUU_SISYKIKNEN);
//
//            BizPropertyInitializer.initialize(suiihyou);
//        }
}
