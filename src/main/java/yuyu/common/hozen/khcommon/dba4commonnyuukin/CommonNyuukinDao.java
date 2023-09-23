package yuyu.common.hozen.khcommon.dba4commonnyuukin;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_AnnaijkKbn;
import yuyu.def.classification.C_Krkseisanzumiflg;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_AnsyuRireki;
import yuyu.def.db.entity.IT_DattaiUktk;
import yuyu.def.db.entity.IT_Kariukekin;
import yuyu.def.db.entity.IT_Kouza;
import yuyu.def.db.entity.IT_KouzaHnknTuuti;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_NyknJissekiRireki;
import yuyu.def.db.entity.IT_SyuunouHenknRireki;
import yuyu.def.db.entity.IT_Tokusin;
import yuyu.def.db.entity.IT_Zennou;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.common.biz.bzcommon.BizDateUtil;

import com.google.common.collect.Collections2;
import com.google.common.collect.Iterables;

/**
 * 入金共通処理の機能DAOです。
 */
public class CommonNyuukinDao {

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private HozenDomManager hozenDomManager;

    public List<IT_KykSyouhn> getKykSyouhns(IT_KykKihon pKykKihon) {

        List<IT_KykSyouhn> itKykSyouhnLst = pKykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        return itKykSyouhnLst;
    }

    public IT_Kouza getKouza(IT_KykKihon pKykKihon) {

        IT_Kouza itKouza = pKykKihon.getKouza();

        return itKouza;
    }

    public IT_AnsyuRireki getAnsyuRireki(
        IT_AnsyuKihon pAnsyuKihon, C_NyknaiyouKbn pNyknaiyouKbn, BizDateYM pJyuutouym, Integer pAnnaino) {

        List<IT_AnsyuRireki> itAnsyuRirekiLst = pAnsyuKihon.getAnsyuRirekis();

        return Iterables.getFirst(Iterables.filter(itAnsyuRirekiLst,
            new FilterAnsyuRireki1(pNyknaiyouKbn, pJyuutouym, pAnnaino)), null);
    }

    public List<IT_AnsyuRireki> getAnsyuRirekis(
        IT_AnsyuKihon pAnsyuKihon, C_NyknaiyouKbn pNyknaiyouKbn, BizDateYM pJyuutouym, C_Nykkeiro pNykkeiro,
        Integer pJyutoukaisuuy, Integer pJyutoukaisuum, C_AnnaijkKbn pAnnaijkkbn, BizDate pRyosyuymd) {

        List<IT_AnsyuRireki> itAnsyuRirekiLst = pAnsyuKihon.getAnsyuRirekis();

        return new ArrayList<IT_AnsyuRireki>(Collections2.filter(itAnsyuRirekiLst,
            new FilterAnsyuRireki2(
                pNyknaiyouKbn, pJyuutouym, pNykkeiro, pJyutoukaisuuy, pJyutoukaisuum, pAnnaijkkbn, pRyosyuymd)));
    }

    public Integer getKariukekinMaxKrkno(IT_KykKihon pKykKihon) {

        List<IT_Kariukekin> itKariukekinLst = pKykKihon.getKariukekins();

        if (itKariukekinLst.size() == 0) {
            return null;
        }

        SortCommonNyuukin sortCommonNyuukin = SWAKInjector.getInstance(SortCommonNyuukin.class);
        List<IT_Kariukekin> sortitKariukekinLst = sortCommonNyuukin.OrderIT_Kariukekin1(itKariukekinLst);

        Integer krknoMax = sortitKariukekinLst.get(0).getKrkno();

        return krknoMax;
    }

    public Integer getNyknJissekiRirekiMaxRenno(IT_KykKihon pKykKihon, BizDateYM pJyutoustartym) {

        List<IT_NyknJissekiRireki> itNyknJissekiRirekiLst =
            pKykKihon.getNyknJissekiRirekisByJyutoustartym(pJyutoustartym);

        if (itNyknJissekiRirekiLst.size() == 0) {
            return null;
        }

        SortCommonNyuukin sortCommonNyuukin = SWAKInjector.getInstance(SortCommonNyuukin.class);
        List<IT_NyknJissekiRireki> sortitNyknJissekiRirekiLst =
            sortCommonNyuukin.OrderIT_NyknJissekiRireki1(itNyknJissekiRirekiLst);

        Integer rennoMax = sortitNyknJissekiRirekiLst.get(0).getRenno();

        return rennoMax;
    }

    public BM_SyouhnZokusei getSyouhnZokusei(String pSyouhncd, Integer pSyouhnsdno) {

        BM_SyouhnZokusei bmSyouhnZokusei = bizDomManager.getSyouhnZokusei(pSyouhncd, pSyouhnsdno);

        return bmSyouhnZokusei;
    }

    public void deleteTokusin(IT_AnsyuKihon pAnsyuKihon, BizDate pYykknMryYMD) {
        List<IT_Tokusin> tokusins = pAnsyuKihon.getTokusins();

        if (tokusins != null &&  tokusins.size() > 0) {
            if(
                BizDateUtil.compareYmd(tokusins.get(0).getTokusinendymd(), pYykknMryYMD) == BizDateUtil.COMPARE_LESSER ||
                BizDateUtil.compareYmd(tokusins.get(0).getTokusinendymd(), pYykknMryYMD) == BizDateUtil.COMPARE_EQUAL
                ){

                tokusins.remove(0);
            }
        }
    }

    public Integer getZennouMaxRenno(IT_AnsyuKihon pAnsyuKihon, BizDate pZennoustartymd) {

        List<IT_Zennou> itZennouLst = pAnsyuKihon.getZennous();

        if (itZennouLst.size() == 0) {
            return null;
        }

        List<IT_Zennou> itZennouLst2 = new ArrayList<IT_Zennou>(Collections2.filter(itZennouLst,
            new FilterZennou1(pZennoustartymd)));

        if (itZennouLst2.size() == 0) {
            return null;
        }

        SortCommonNyuukin sortCommonNyuukin = SWAKInjector.getInstance(SortCommonNyuukin.class);
        List<IT_Zennou> sortitZennouLst = sortCommonNyuukin.OrderIT_Zennou1(itZennouLst2);

        Integer rennoMax = sortitZennouLst.get(0).getRenno();

        return rennoMax;
    }

    public IT_NyknJissekiRireki createNyknJissekiRireki(IT_KykKihon pKykKihon) {

        IT_NyknJissekiRireki itNyknJissekiRireki = pKykKihon.createNyknJissekiRireki();

        return itNyknJissekiRireki;
    }

    public IT_Kariukekin createKariukekin(IT_KykKihon pKykKihon) {

        IT_Kariukekin itKariukekin = pKykKihon.createKariukekin();

        return itKariukekin;
    }

    public IT_SyuunouHenknRireki createSyuunouHenknRireki(IT_AnsyuKihon pAnsyuKihon) {

        IT_SyuunouHenknRireki itSyuunouHenknRireki = pAnsyuKihon.createSyuunouHenknRireki();

        return itSyuunouHenknRireki;
    }

    public IT_Zennou createZennou(IT_AnsyuKihon pAnsyuKihon) {

        IT_Zennou itZennou = pAnsyuKihon.createZennou();

        return itZennou;
    }

    public void flush() {

        hozenDomManager.flush();
    }

    public IT_DattaiUktk getDattaiUktk(IT_AnsyuKihon pAnsyuKihon) {

        IT_DattaiUktk itDattaiUktk = pAnsyuKihon.getDattaiUktk();

        return itDattaiUktk;
    }

    public List<IT_Kariukekin> getKariukekins(IT_KykKihon pKykKihon) {

        List<IT_Kariukekin> itKariukekinLst = pKykKihon.getKariukekins();

        return new ArrayList<IT_Kariukekin>(Collections2.filter(itKariukekinLst,
            new FilterKariukekin1(C_Krkseisanzumiflg.BLNK)));
    }

    public IT_KouzaHnknTuuti createKouzaHnknTuuti(IT_KykKihon pKykKihon) {

        IT_KouzaHnknTuuti itKouzaHnknTuuti = pKykKihon.createKouzaHnknTuuti();

        return itKouzaHnknTuuti;
    }

    public List<IT_KykSyouhn> getKykSyouhns2(IT_KykKihon pKykKihon) {

        List<IT_KykSyouhn> itKykSyouhnLst = pKykKihon.getKykSyouhns();

        return itKykSyouhnLst;
    }

}
