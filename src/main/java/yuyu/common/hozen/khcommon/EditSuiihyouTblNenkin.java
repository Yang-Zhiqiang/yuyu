package yuyu.common.hozen.khcommon;

import java.util.ArrayList;
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
 * 契約保全 契約保全共通 推移表ＴＢＬ編集（年金）
 */
public class EditSuiihyouTblNenkin {

    private static final String MSGHIKISUU = "解約返戻金計算拡張情報作成が実行できませんでした。";

    private final static String SUIIHYOUSYUBETU_SISUU = "05";

    private final static String SUIIHYOUSYUBETU_SISUU_SISYKIKNEN = "06";

    private static final String DUMMYSUIIHYOUSYUBETU = "00";

    private static final int DUMMYKEIKANEN = 99;

    @Inject
    private static Logger logger;

    public EditSuiihyouTblNenkin() {
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

        logger.debug("▽ 推移表TBL編集（年金） 開始");

        C_Tuukasyu keiyakuTuukasyu = pKykSyohnSyuLst.get(0).getKyktuukasyu();
        BizDate calcKijyunYmd = pEditHokenSyoukenParam.getCalckijyunYMD();
        BizDate kwsrateKjymd = pKykKihon.getFstpnyknymd();
        C_SinsaihkKbn csinsaihkKbn = C_SinsaihkKbn.BLNK;

        if (C_SinsaihkKbn.SIN.eq(pCSinsaihkKbn) ||
            (C_SinsaihkKbn.SAI.eq(pCSinsaihkKbn) &&
                C_SyoukensaihkKbn.SINKEIYAKUSAISAKUSEI.eq(pEditHokenSyoukenParam.getSyoukenSaihk()) ||
                BizDateUtil.compareYmd(pSyoriYmd, pKykSyohnSyuLst.get(0).getKykymd()) == BizDateUtil.COMPARE_LESSER)) {
            csinsaihkKbn = C_SinsaihkKbn.SIN;
        }
        else {
            csinsaihkKbn = C_SinsaihkKbn.SAI;
        }

        WSuiihyouNenkin wSuiihyouNenkin = SWAKInjector.getInstance(WSuiihyouNenkin.class);

        WSuiihyouParam wSuiihyouParam = SWAKInjector.getInstance(WSuiihyouParam.class);

        KeisanWExtBean keisanWExtBean = SWAKInjector.getInstance(KeisanWExtBean.class);

        List<IT_Suiihyou> wsuiihyouLst = new ArrayList<>();

        int keikanenkjn;

        if (C_SinsaihkKbn.SIN.eq(csinsaihkKbn)) {
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

        wSuiihyouParam.setKwsratekjymd(kwsrateKjymd);
        wSuiihyouParam.setCalcKijyunYmd(calcKijyunYmd);
        wSuiihyouParam.setSinsaihkKbn(csinsaihkKbn);
        wSuiihyouParam.setSyoukensaihkKbn(pEditHokenSyoukenParam.getSyoukenSaihk());
        wSuiihyouParam.setMvaTekiUmu(pSyouhnZokusei.getMvatekiumu());
        wSuiihyouParam.setMvaTekiKkn(pSyouhnZokusei.getMvatekikkn());
        wSuiihyouParam.setSetteiBairitu(pKykSyohnSyuLst.get(0).getSetteibairitu());
        wSuiihyouParam.setTmttknZoukarituJygn(pKykSyohnSyuLst.get(0).getTmttknzoukaritujygn());
        wSuiihyouParam.setSisuurendourate(pKykSyohnSyuLst.get(0).getKykjisisuurendourate());
        wSuiihyouParam.setTmttknhaibunjyoutai(pKykSyohnSyuLst.get(0).getTmttknhaibunjyoutai());
        wSuiihyouParam.setTargetTkykKijyungk(pKykSonotaTkyk.getTargettkykkijyungk());

        if (C_SinsaihkKbn.SIN.eq(csinsaihkKbn)) {

            KeisanSisuuRendouNkKykTmttkn keisanSisuuRendouNkKykTmttkn = SWAKInjector
                .getInstance(KeisanSisuuRendouNkKykTmttkn.class);

            keisanSisuuRendouNkKykTmttkn.exec(keiyakuTuukasyu, pKykSyohnSyuLst.get(0).getHokenryou(), pKykSyohnSyuLst
                .get(0).getKykjisisuurendourate());

            keisanWExtBean.setTmttkntaisyouym(calcKijyunYmd.getBizDateYM());
            keisanWExtBean.setTeiritutmttkngk(keisanSisuuRendouNkKykTmttkn.getTeiritutmttkngk());
            keisanWExtBean.setSisuurendoutmttkngk(keisanSisuuRendouNkKykTmttkn.getSisuurendoutmttkngk());
            keisanWExtBean.setTumitateriritu(pKykSyohnSyuLst.get(0).getTumitateriritu());
        }

        wSuiihyouParam.setKeisanWExtBean(keisanWExtBean);

        if(C_Tuukasyu.JPY.eq(keiyakuTuukasyu)){
            wSuiihyouNenkin.setYenkansannYhKbn(C_YouhiKbn.HUYOU);
        }

        wsuiihyouLst = wSuiihyouNenkin.exec(wSuiihyouParam);
        keikanenkjn = pKykSyohnSyuLst.get(0).getHknkkn();

        BizDate syoribiYmd = pSyoriYmd;

        String kinouId = pKkanriCommonParam.getFunctionId();

        String kosinsyaId = pKkanriCommonParam.getUserID();

        String sysTime = BizDate.getSysDateTimeMilli();

        boolean SuiihyouSaisyuuKeikaFlag = false;

        if (C_SinsaihkKbn.SAI.eq(csinsaihkKbn) && wsuiihyouLst.size() == 1) {

            IT_Suiihyou suiihyou = wsuiihyouLst.get(0);

            if (suiihyou.getSuiihyousyubetu().equals(SUIIHYOUSYUBETU_SISUU)){
                SuiihyouSaisyuuKeikaFlag = true;
            }
        }
        if (SuiihyouSaisyuuKeikaFlag){
            IT_Suiihyou suiihyou = wsuiihyouLst.get(0);

            setSuiihyouTblSisuuSaisyuu(pKykKihon,
                suiihyou,
                syoribiYmd,
                keiyakuTuukasyu,
                kinouId,
                kosinsyaId,
                sysTime);
        }
        else{
            for (int index = 0; index < wsuiihyouLst.size(); index++) {

                IT_Suiihyou suiihyou = wsuiihyouLst.get(index);

                if (index < keikanenkjn) {

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

        if(wsuiihyouLst.size()==0){
            IT_Suiihyou suiihyou = new IT_Suiihyou();

            suiihyou.setSuiihyousyubetu(DUMMYSUIIHYOUSYUBETU);

            suiihyou.setKeikanensuu(DUMMYKEIKANEN);

            setSuiihyouTbl(pKykKihon, suiihyou, syoribiYmd, null, kinouId, kosinsyaId, sysTime);
        }

        logger.debug("△ 推移表TBL編集（年金） 終了");
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
        suiihyou.setSisuuupritu1(pSuiihyou.getSisuuupritu1());
        suiihyou.setTmttknzoukaritu1(pSuiihyou.getTmttknzoukaritu1());
        suiihyou.setTutmttknutiwake11(pSuiihyou.getTutmttknutiwake11());
        suiihyou.setTutmttknutiwake21(pSuiihyou.getTutmttknutiwake21());
        suiihyou.setMvaaritmttkgkkykkjmaeup1(pSuiihyou.getMvaaritmttkgkkykkjmaeup1());
        suiihyou.setMvaaritmttkgkkykkjmaesame1(pSuiihyou.getMvaaritmttkgkkykkjmaesame1());
        suiihyou.setMvaaritmttkgkkykkjmaedown1(pSuiihyou.getMvaaritmttkgkkykkjmaedown1());
        suiihyou.setSjkkktusirrtup2(pSuiihyou.getSjkkktusirrtup2());
        suiihyou.setSjkkktusirrtsame2(pSuiihyou.getSjkkktusirrtsame2());
        suiihyou.setSjkkktusirrtdown2(pSuiihyou.getSjkkktusirrtdown2());
        suiihyou.setSjkkktusirrthendouup2(pSuiihyou.getSjkkktusirrthendouup2());
        suiihyou.setSjkkktusirrthendoudown2(pSuiihyou.getSjkkktusirrthendoudown2());
        suiihyou.setYenknsnkwsrateyendaka2(pSuiihyou.getYenknsnkwsrateyendaka2());
        suiihyou.setYenknsnkwsrateyenkijyun2(pSuiihyou.getYenknsnkwsrateyenkijyun2());
        suiihyou.setYenknsnkwsrateyenyasu2(pSuiihyou.getYenknsnkwsrateyenyasu2());
        suiihyou.setYenknsnkwsrategkyendaka2(pSuiihyou.getYenknsnkwsrategkyendaka2());
        suiihyou.setYenknsnkwsrategkyenyasu2(pSuiihyou.getYenknsnkwsrategkyenyasu2());
        suiihyou.setSisuuupritu2(pSuiihyou.getSisuuupritu2());
        suiihyou.setTmttknzoukaritu2(pSuiihyou.getTmttknzoukaritu2());
        suiihyou.setMvaaritmttkgkkykkjmaeup2(pSuiihyou.getMvaaritmttkgkkykkjmaeup2());
        suiihyou.setMvaaritmttkgkkykkjmaesame2(pSuiihyou.getMvaaritmttkgkkykkjmaesame2());
        suiihyou.setMvaaritmttkgkkykkjmaedown2(pSuiihyou.getMvaaritmttkgkkykkjmaedown2());
        suiihyou.setMvaariwup2(pSuiihyou.getMvaariwup2());
        suiihyou.setMvaariwsame2(pSuiihyou.getMvaariwsame2());
        suiihyou.setMvaariwdown2(pSuiihyou.getMvaariwdown2());
        suiihyou.setMvaariwyenupyendaka2(pSuiihyou.getMvaariwyenupyendaka2());
        suiihyou.setMvaariwyenupyenkijyun2(pSuiihyou.getMvaariwyenupyenkijyun2());
        suiihyou.setMvaariwyenupyenyasu2(pSuiihyou.getMvaariwyenupyenyasu2());
        suiihyou.setMvaariwyensameyendaka2(pSuiihyou.getMvaariwyensameyendaka2());
        suiihyou.setMvaariwyensameyenkijyun2(pSuiihyou.getMvaariwyensameyenkijyun2());
        suiihyou.setMvaariwyensameyenyasu2(pSuiihyou.getMvaariwyensameyenyasu2());
        suiihyou.setMvaariwyendownyendaka2(pSuiihyou.getMvaariwyendownyendaka2());
        suiihyou.setMvaariwyendownyenkijyun2(pSuiihyou.getMvaariwyendownyenkijyun2());
        suiihyou.setMvaariwyendownyenyasu2(pSuiihyou.getMvaariwyendownyenyasu2());
        suiihyou.setMvaariptumitatekin2(pSuiihyou.getMvaariptumitatekin2());
        suiihyou.setMvanonewsame2(pSuiihyou.getMvanonewsame2());
        suiihyou.setMvanonewyensameyendaka2(pSuiihyou.getMvanonewyensameyendaka2());
        suiihyou.setMvanonewyensameyenkijyun2(pSuiihyou.getMvanonewyensameyenkijyun2());
        suiihyou.setMvanonewyensameyenyasu2(pSuiihyou.getMvanonewyensameyenyasu2());
        suiihyou.setMvanoneptumitatekin2(pSuiihyou.getMvanoneptumitatekin2());
        suiihyou.setTutmttknutiwake12(pSuiihyou.getTutmttknutiwake12());
        suiihyou.setTutmttknutiwake22(pSuiihyou.getTutmttknutiwake22());
        suiihyou.setSjkkktusirrtup3(pSuiihyou.getSjkkktusirrtup3());
        suiihyou.setSjkkktusirrtsame3(pSuiihyou.getSjkkktusirrtsame3());
        suiihyou.setSjkkktusirrtdown3(pSuiihyou.getSjkkktusirrtdown3());
        suiihyou.setSjkkktusirrthendouup3(pSuiihyou.getSjkkktusirrthendouup3());
        suiihyou.setSjkkktusirrthendoudown3(pSuiihyou.getSjkkktusirrthendoudown3());
        suiihyou.setYenknsnkwsrateyendaka3(pSuiihyou.getYenknsnkwsrateyendaka3());
        suiihyou.setYenknsnkwsrateyenkijyun3(pSuiihyou.getYenknsnkwsrateyenkijyun3());
        suiihyou.setYenknsnkwsrateyenyasu3(pSuiihyou.getYenknsnkwsrateyenyasu3());
        suiihyou.setYenknsnkwsrategkyendaka3(pSuiihyou.getYenknsnkwsrategkyendaka3());
        suiihyou.setYenknsnkwsrategkyenyasu3(pSuiihyou.getYenknsnkwsrategkyenyasu3());
        suiihyou.setSisuuupritu3(pSuiihyou.getSisuuupritu3());
        suiihyou.setTmttknzoukaritu3(pSuiihyou.getTmttknzoukaritu3());
        suiihyou.setMvaaritmttkgkkykkjmaeup3(pSuiihyou.getMvaaritmttkgkkykkjmaeup3());
        suiihyou.setMvaaritmttkgkkykkjmaesame3(pSuiihyou.getMvaaritmttkgkkykkjmaesame3());
        suiihyou.setMvaaritmttkgkkykkjmaedown3(pSuiihyou.getMvaaritmttkgkkykkjmaedown3());
        suiihyou.setMvaariwup3(pSuiihyou.getMvaariwup3());
        suiihyou.setMvaariwsame3(pSuiihyou.getMvaariwsame3());
        suiihyou.setMvaariwdown3(pSuiihyou.getMvaariwdown3());
        suiihyou.setMvaariwyenupyendaka3(pSuiihyou.getMvaariwyenupyendaka3());
        suiihyou.setMvaariwyenupyenkijyun3(pSuiihyou.getMvaariwyenupyenkijyun3());
        suiihyou.setMvaariwyenupyenyasu3(pSuiihyou.getMvaariwyenupyenyasu3());
        suiihyou.setMvaariwyensameyendaka3(pSuiihyou.getMvaariwyensameyendaka3());
        suiihyou.setMvaariwyensameyenkijyun3(pSuiihyou.getMvaariwyensameyenkijyun3());
        suiihyou.setMvaariwyensameyenyasu3(pSuiihyou.getMvaariwyensameyenyasu3());
        suiihyou.setMvaariwyendownyendaka3(pSuiihyou.getMvaariwyendownyendaka3());
        suiihyou.setMvaariwyendownyenkijyun3(pSuiihyou.getMvaariwyendownyenkijyun3());
        suiihyou.setMvaariwyendownyenyasu3(pSuiihyou.getMvaariwyendownyenyasu3());
        suiihyou.setMvaariptumitatekin3(pSuiihyou.getMvaariptumitatekin3());
        suiihyou.setMvanonewsame3(pSuiihyou.getMvanonewsame3());
        suiihyou.setMvanonewyensameyendaka3(pSuiihyou.getMvanonewyensameyendaka3());
        suiihyou.setMvanonewyensameyenkijyun3(pSuiihyou.getMvanonewyensameyenkijyun3());
        suiihyou.setMvanonewyensameyenyasu3(pSuiihyou.getMvanonewyensameyenyasu3());
        suiihyou.setMvanoneptumitatekin3(pSuiihyou.getMvanoneptumitatekin3());
        suiihyou.setTutmttknutiwake13(pSuiihyou.getTutmttknutiwake13());
        suiihyou.setTutmttknutiwake23(pSuiihyou.getTutmttknutiwake23());
        suiihyou.setSuiihyousyubetu(pSuiihyou.getSuiihyousyubetu());

        BizPropertyInitializer.initialize(suiihyou);
    }

    private void setSuiihyouTblSisuuSaisyuu(IT_KykKihon pKykKihon,
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
        suiihyou.setMkhyouyensysnikougk(pSuiihyou.getMkhyouyensysnikougk());
        suiihyou.setGyoumuKousinKinou(pKinouId);
        suiihyou.setGyoumuKousinsyaId(pKosinsyaId);
        suiihyou.setGyoumuKousinTime(pSysTime);
        suiihyou.setSjkkktusirrtup2(pSuiihyou.getSjkkktusirrtup2());
        suiihyou.setSjkkktusirrtsame2(pSuiihyou.getSjkkktusirrtsame2());
        suiihyou.setSjkkktusirrtdown2(pSuiihyou.getSjkkktusirrtdown2());
        suiihyou.setSjkkktusirrthendouup2(pSuiihyou.getSjkkktusirrthendouup2());
        suiihyou.setSjkkktusirrthendoudown2(pSuiihyou.getSjkkktusirrthendoudown2());
        suiihyou.setYenknsnkwsrateyendaka2(pSuiihyou.getYenknsnkwsrateyendaka2());
        suiihyou.setYenknsnkwsrateyenkijyun2(pSuiihyou.getYenknsnkwsrateyenkijyun2());
        suiihyou.setYenknsnkwsrateyenyasu2(pSuiihyou.getYenknsnkwsrateyenyasu2());
        suiihyou.setYenknsnkwsrategkyendaka2(pSuiihyou.getYenknsnkwsrategkyendaka2());
        suiihyou.setYenknsnkwsrategkyenyasu2(pSuiihyou.getYenknsnkwsrategkyenyasu2());
        suiihyou.setSisuuupritu2(pSuiihyou.getSisuuupritu2());
        suiihyou.setTmttknzoukaritu2(pSuiihyou.getTmttknzoukaritu2());
        suiihyou.setMvaaritmttkgkkykkjmaeup2(pSuiihyou.getMvaaritmttkgkkykkjmaeup2());
        suiihyou.setMvaaritmttkgkkykkjmaesame2(pSuiihyou.getMvaaritmttkgkkykkjmaesame2());
        suiihyou.setMvaaritmttkgkkykkjmaedown2(pSuiihyou.getMvaaritmttkgkkykkjmaedown2());
        suiihyou.setMvaariwup2(pSuiihyou.getMvaariwup2());
        suiihyou.setMvaariwsame2(pSuiihyou.getMvaariwsame2());
        suiihyou.setMvaariwdown2(pSuiihyou.getMvaariwdown2());
        suiihyou.setMvaariwyenupyendaka2(pSuiihyou.getMvaariwyenupyendaka2());
        suiihyou.setMvaariwyenupyenkijyun2(pSuiihyou.getMvaariwyenupyenkijyun2());
        suiihyou.setMvaariwyenupyenyasu2(pSuiihyou.getMvaariwyenupyenyasu2());
        suiihyou.setMvaariwyensameyendaka2(pSuiihyou.getMvaariwyensameyendaka2());
        suiihyou.setMvaariwyensameyenkijyun2(pSuiihyou.getMvaariwyensameyenkijyun2());
        suiihyou.setMvaariwyensameyenyasu2(pSuiihyou.getMvaariwyensameyenyasu2());
        suiihyou.setMvaariwyendownyendaka2(pSuiihyou.getMvaariwyendownyendaka2());
        suiihyou.setMvaariwyendownyenkijyun2(pSuiihyou.getMvaariwyendownyenkijyun2());
        suiihyou.setMvaariwyendownyenyasu2(pSuiihyou.getMvaariwyendownyenyasu2());
        suiihyou.setMvaariptumitatekin2(pSuiihyou.getMvaariptumitatekin2());
        suiihyou.setMvanonewsame2(pSuiihyou.getMvanonewsame2());
        suiihyou.setMvanonewyensameyendaka2(pSuiihyou.getMvanonewyensameyendaka2());
        suiihyou.setMvanonewyensameyenkijyun2(pSuiihyou.getMvanonewyensameyenkijyun2());
        suiihyou.setMvanonewyensameyenyasu2(pSuiihyou.getMvanonewyensameyenyasu2());
        suiihyou.setMvanoneptumitatekin2(pSuiihyou.getMvanoneptumitatekin2());
        suiihyou.setTutmttknutiwake12(pSuiihyou.getTutmttknutiwake12());
        suiihyou.setTutmttknutiwake22(pSuiihyou.getTutmttknutiwake22());
        suiihyou.setSjkkktusirrtup3(pSuiihyou.getSjkkktusirrtup3());
        suiihyou.setSjkkktusirrtsame3(pSuiihyou.getSjkkktusirrtsame3());
        suiihyou.setSjkkktusirrtdown3(pSuiihyou.getSjkkktusirrtdown3());
        suiihyou.setSjkkktusirrthendouup3(pSuiihyou.getSjkkktusirrthendouup3());
        suiihyou.setSjkkktusirrthendoudown3(pSuiihyou.getSjkkktusirrthendoudown3());
        suiihyou.setYenknsnkwsrateyendaka3(pSuiihyou.getYenknsnkwsrateyendaka3());
        suiihyou.setYenknsnkwsrateyenkijyun3(pSuiihyou.getYenknsnkwsrateyenkijyun3());
        suiihyou.setYenknsnkwsrateyenyasu3(pSuiihyou.getYenknsnkwsrateyenyasu3());
        suiihyou.setYenknsnkwsrategkyendaka3(pSuiihyou.getYenknsnkwsrategkyendaka3());
        suiihyou.setYenknsnkwsrategkyenyasu3(pSuiihyou.getYenknsnkwsrategkyenyasu3());
        suiihyou.setSisuuupritu3(pSuiihyou.getSisuuupritu3());
        suiihyou.setTmttknzoukaritu3(pSuiihyou.getTmttknzoukaritu3());
        suiihyou.setMvaaritmttkgkkykkjmaeup3(pSuiihyou.getMvaaritmttkgkkykkjmaeup3());
        suiihyou.setMvaaritmttkgkkykkjmaesame3(pSuiihyou.getMvaaritmttkgkkykkjmaesame3());
        suiihyou.setMvaaritmttkgkkykkjmaedown3(pSuiihyou.getMvaaritmttkgkkykkjmaedown3());
        suiihyou.setMvaariwup3(pSuiihyou.getMvaariwup3());
        suiihyou.setMvaariwsame3(pSuiihyou.getMvaariwsame3());
        suiihyou.setMvaariwdown3(pSuiihyou.getMvaariwdown3());
        suiihyou.setMvaariwyenupyendaka3(pSuiihyou.getMvaariwyenupyendaka3());
        suiihyou.setMvaariwyenupyenkijyun3(pSuiihyou.getMvaariwyenupyenkijyun3());
        suiihyou.setMvaariwyenupyenyasu3(pSuiihyou.getMvaariwyenupyenyasu3());
        suiihyou.setMvaariwyensameyendaka3(pSuiihyou.getMvaariwyensameyendaka3());
        suiihyou.setMvaariwyensameyenkijyun3(pSuiihyou.getMvaariwyensameyenkijyun3());
        suiihyou.setMvaariwyensameyenyasu3(pSuiihyou.getMvaariwyensameyenyasu3());
        suiihyou.setMvaariwyendownyendaka3(pSuiihyou.getMvaariwyendownyendaka3());
        suiihyou.setMvaariwyendownyenkijyun3(pSuiihyou.getMvaariwyendownyenkijyun3());
        suiihyou.setMvaariwyendownyenyasu3(pSuiihyou.getMvaariwyendownyenyasu3());
        suiihyou.setMvaariptumitatekin3(pSuiihyou.getMvaariptumitatekin3());
        suiihyou.setMvanonewsame3(pSuiihyou.getMvanonewsame3());
        suiihyou.setMvanonewyensameyendaka3(pSuiihyou.getMvanonewyensameyendaka3());
        suiihyou.setMvanonewyensameyenkijyun3(pSuiihyou.getMvanonewyensameyenkijyun3());
        suiihyou.setMvanonewyensameyenyasu3(pSuiihyou.getMvanonewyensameyenyasu3());
        suiihyou.setMvanoneptumitatekin3(pSuiihyou.getMvanoneptumitatekin3());
        suiihyou.setTutmttknutiwake13(pSuiihyou.getTutmttknutiwake13());
        suiihyou.setTutmttknutiwake23(pSuiihyou.getTutmttknutiwake23());
        suiihyou.setSuiihyousyubetu(SUIIHYOUSYUBETU_SISUU_SISYKIKNEN);

        BizPropertyInitializer.initialize(suiihyou);
    }
}
