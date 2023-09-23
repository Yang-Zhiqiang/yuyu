package yuyu.common.hozen.khcommon.dba4editkoujyonaiyoutblzeiteki;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBEntityManager;
import yuyu.def.classification.C_Delflag;
import yuyu.def.classification.C_KoujyosymnaiyourecKbn;
import yuyu.def.classification.C_Nyktrksflg;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.entity.IT_KihrkmpSeisanRireki;
import yuyu.def.db.entity.IT_KoujyoSymNaiyou;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_KykSyouhnRireki;
import yuyu.def.db.entity.IT_NyknJissekiRireki;
import yuyu.def.db.entity.IT_Zennou;
import yuyu.def.db.meta.QIT_KihrkmpSeisanRireki;
import yuyu.def.db.meta.QIT_KoujyoSymNaiyou;
import yuyu.def.db.meta.QIT_KykSyouhn;
import yuyu.def.db.meta.QIT_KykSyouhnRireki;
import yuyu.def.db.meta.QIT_NyknJissekiRireki;
import yuyu.def.db.meta.QIT_Zennou;

/**
 * 契約保全 契約保全共通 税適特約変更時控除証明内容TBL編集Daoクラス
 */
public class EditKoujyonaiyouTblZeitekiDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public List<IT_KoujyoSymNaiyou> getKoujyoSymNaiyouZtkSyori(BizDateYM pZeitekihenkoYm, IT_KykKihon pKykKihon) {

        QIT_KoujyoSymNaiyou qIT_KoujyoSymNaiyou = new QIT_KoujyoSymNaiyou("qIT_KoujyoSymNaiyou");
        QIT_KykSyouhn qIT_KykSyouhn = new QIT_KykSyouhn("qIT_KykSyouhn");
        QIT_NyknJissekiRireki qIT_NyknJissekiRireki = new QIT_NyknJissekiRireki("qIT_NyknJissekiRireki");

        String subSql = $SELECT + qIT_NyknJissekiRireki.syono +
            $FROM(qIT_NyknJissekiRireki) +
            $WHERE + qIT_NyknJissekiRireki.syono.eq(qIT_KoujyoSymNaiyou.syono) +
            $AND + qIT_NyknJissekiRireki.jyutoustartym.eq(qIT_KoujyoSymNaiyou.jyutoustartym) +
            $AND + qIT_NyknJissekiRireki.renno.eq(qIT_KoujyoSymNaiyou.nyknjskrrkrenno) +
            $AND + qIT_NyknJissekiRireki.nyktrksflg.eq(C_Nyktrksflg.TORIKESI);

        String sql = $SELECT + qIT_KoujyoSymNaiyou +
            $FROM(qIT_KoujyoSymNaiyou, qIT_KykSyouhn) +
            $WHERE + qIT_KoujyoSymNaiyou.syono.eq(pKykKihon.getSyono()) +
            $AND + qIT_KoujyoSymNaiyou.syoumeiendym.ge(pZeitekihenkoYm) +
            $AND + qIT_KoujyoSymNaiyou.koujyosymnaiyoureckbn.ne(C_KoujyosymnaiyourecKbn.NKTRKS) +
            $AND + qIT_KoujyoSymNaiyou.sakujyoflg.ne(C_Delflag.SAKUJYO) +
            $AND + qIT_KykSyouhn.syono.eq(qIT_KoujyoSymNaiyou.syono) +
            $AND + qIT_KykSyouhn.syouhncd.eq(qIT_KoujyoSymNaiyou.syouhncd) +
            $AND + qIT_KykSyouhn.syutkkbn.eq(C_SyutkKbn.SYU) +
            $AND + $NOT_EXISTS(subSql) +
            $ORDER_BY(qIT_KoujyoSymNaiyou.syoumeistartym.asc(),
                qIT_KoujyoSymNaiyou.renno3keta.asc());

        List<IT_KoujyoSymNaiyou> koujyoSymNaiyouSearchResultList  =  exDBEntityManager.createJPQL(sql).bind(
            qIT_KoujyoSymNaiyou, qIT_KykSyouhn, qIT_NyknJissekiRireki).getResultList();

        koujyoSymNaiyouSearchResultList = getKoujyoSymNaiyouList(pKykKihon.getKoujyoSymNaiyous(),
            koujyoSymNaiyouSearchResultList);

        return koujyoSymNaiyouSearchResultList;
    }

    public IT_Zennou getZennou(String pSyono, BizDate pZennoukaisiymd, Integer pRenno) {

        QIT_Zennou qIT_Zennou = new QIT_Zennou("qIT_Zennou");

        String sql = $SELECT + qIT_Zennou +
            $FROM(qIT_Zennou) +
            $WHERE + qIT_Zennou.syono.eq(pSyono) +
            $AND + qIT_Zennou.zennoukaisiymd.eq(pZennoukaisiymd) +
            $AND + qIT_Zennou.renno.eq(pRenno) ;

        return exDBEntityManager.createJPQL(sql).bind(qIT_Zennou).getSingleResult();
    }

    public List<IT_KoujyoSymNaiyou> getHaibunZennouKoujyoSymNaiyou(IT_KykKihon pKykKihon,
        BizDateYM pSyoumeistartym,
        BizDateYM pSyoumeiendym,
        BizDateYM pJyutoustartym,
        Integer pNyknJissekiRirekiRenno,
        Integer pKihrkmpSeisanRirekiRenno) {

        QIT_KoujyoSymNaiyou qIT_KoujyoSymNaiyou = new QIT_KoujyoSymNaiyou("qIT_KoujyoSymNaiyou");
        QIT_NyknJissekiRireki qIT_NyknJissekiRireki = new QIT_NyknJissekiRireki("qIT_NyknJissekiRireki");

        String subSql = $SELECT + qIT_NyknJissekiRireki.syono +
            $FROM(qIT_NyknJissekiRireki)+
            $WHERE + qIT_NyknJissekiRireki.syono.eq(qIT_KoujyoSymNaiyou.syono) +
            $AND + qIT_NyknJissekiRireki.jyutoustartym.eq(qIT_KoujyoSymNaiyou.jyutoustartym) +
            $AND + qIT_NyknJissekiRireki.renno.eq(qIT_KoujyoSymNaiyou.nyknjskrrkrenno) +
            $AND + qIT_NyknJissekiRireki.nyktrksflg.eq(C_Nyktrksflg.TORIKESI);

        String sql1 = $SELECT + qIT_KoujyoSymNaiyou +
            $FROM(qIT_KoujyoSymNaiyou) +
            $WHERE + qIT_KoujyoSymNaiyou.syono.eq(pKykKihon.getSyono()) +
            $AND + qIT_KoujyoSymNaiyou.syoumeistartym.eq(pSyoumeistartym) +
            $AND + qIT_KoujyoSymNaiyou.syoumeiendym.eq(pSyoumeiendym) +
            $AND + qIT_KoujyoSymNaiyou.koujyosymnaiyoureckbn.ne(C_KoujyosymnaiyourecKbn.NKTRKS);

        String sql2;
        if (pJyutoustartym == null) {
            sql2 = $AND + qIT_KoujyoSymNaiyou.jyutoustartym.isNull();
        } else {
            sql2 = $AND + qIT_KoujyoSymNaiyou.jyutoustartym.eq(pJyutoustartym);
        }

        String sql = sql1 + sql2 +
            $AND + qIT_KoujyoSymNaiyou.nyknjskrrkrenno.eq(pNyknJissekiRirekiRenno) +
            $AND + qIT_KoujyoSymNaiyou.kihrkpssrrkrenno.eq(pKihrkmpSeisanRirekiRenno) +
            $AND + qIT_KoujyoSymNaiyou.sakujyoflg.ne(C_Delflag.SAKUJYO) +
            $AND + $NOT_EXISTS(subSql);

        List<IT_KoujyoSymNaiyou> koujyoSymNaiyouSearchResultList =
            exDBEntityManager.createJPQL(sql).bind(qIT_KoujyoSymNaiyou, qIT_NyknJissekiRireki).getResultList();

        koujyoSymNaiyouSearchResultList = getKoujyoSymNaiyouList(pKykKihon.getKoujyoSymNaiyous(),
            koujyoSymNaiyouSearchResultList);

        return koujyoSymNaiyouSearchResultList;
    }

    public IT_NyknJissekiRireki getNyknJissekiRireki(String pSyono, BizDateYM pJyutoustartym, Integer pRenno) {

        QIT_NyknJissekiRireki qIT_NyknJissekiRireki = new QIT_NyknJissekiRireki("qIT_NyknJissekiRireki");

        String sql = $SELECT + qIT_NyknJissekiRireki +
            $FROM(qIT_NyknJissekiRireki) +
            $WHERE + qIT_NyknJissekiRireki.syono.eq(pSyono) +
            $AND + qIT_NyknJissekiRireki.jyutoustartym.eq(pJyutoustartym) +
            $AND + qIT_NyknJissekiRireki.renno.eq(pRenno) ;

        return exDBEntityManager.createJPQL(sql).bind(qIT_NyknJissekiRireki).getSingleResult();
    }

    public IT_KihrkmpSeisanRireki getKihrkmpSeisanRireki(String pSyono, Integer pRenno) {

        QIT_KihrkmpSeisanRireki qIT_KihrkmpSeisanRireki = new QIT_KihrkmpSeisanRireki("qIT_KihrkmpSeisanRireki");

        String sql = $SELECT + qIT_KihrkmpSeisanRireki +
            $FROM(qIT_KihrkmpSeisanRireki) +
            $WHERE + qIT_KihrkmpSeisanRireki.syono.eq(pSyono) +
            $AND + qIT_KihrkmpSeisanRireki.renno.eq(pRenno) ;

        return exDBEntityManager.createJPQL(sql).bind(qIT_KihrkmpSeisanRireki).getSingleResult();
    }

    public List<IT_KykSyouhn> getKykSyouhns(String pSyono, String pHenkousikibetukey) {

        QIT_KykSyouhn qIT_KykSyouhn = new QIT_KykSyouhn("qIT_KykSyouhn");

        String sql = $SELECT + qIT_KykSyouhn +
            $FROM(qIT_KykSyouhn) +
            $WHERE + qIT_KykSyouhn.syono.eq(pSyono) +
            $AND + qIT_KykSyouhn.henkousikibetukey.eq(pHenkousikibetukey) ;

        return exDBEntityManager.createJPQL(sql).bind(qIT_KykSyouhn).getResultList();
    }

    public List<IT_KykSyouhnRireki> getKykSyouhnRirekis(String pSyono, String pHenkousikibetukey) {

        QIT_KykSyouhnRireki qIT_KykSyouhnRireki = new QIT_KykSyouhnRireki("qIT_KykSyouhnRireki");

        String sql = $SELECT + qIT_KykSyouhnRireki +
            $FROM(qIT_KykSyouhnRireki) +
            $WHERE + qIT_KykSyouhnRireki.syono.eq(pSyono) +
            $AND + qIT_KykSyouhnRireki.henkousikibetukey.eq(pHenkousikibetukey) ;

        return exDBEntityManager.createJPQL(sql).bind(qIT_KykSyouhnRireki).getResultList();

    }

    public List<IT_KoujyoSymNaiyou> getSeisanmaeKoujyoSymNaiyou(String pSyono,BizDateYM pSeisansyoumeistartym){

        QIT_KoujyoSymNaiyou qIT_KoujyoSymNaiyou = new QIT_KoujyoSymNaiyou("qIT_KoujyoSymNaiyou");
        QIT_KykSyouhn qIT_KykSyouhn = new QIT_KykSyouhn("qIT_KykSyouhn");
        QIT_NyknJissekiRireki qIT_NyknJissekiRireki = new QIT_NyknJissekiRireki("qIT_NyknJissekiRireki");

        String sql = $SELECT + qIT_KoujyoSymNaiyou +
            $FROM(qIT_KoujyoSymNaiyou, qIT_KykSyouhn, qIT_NyknJissekiRireki) +
            $WHERE + qIT_KoujyoSymNaiyou.syono.eq(pSyono)+
            $AND + qIT_KoujyoSymNaiyou.syoumeistartym.le(pSeisansyoumeistartym) +
            $AND + qIT_KoujyoSymNaiyou.syoumeiendym.ge(pSeisansyoumeistartym) +
            $AND + qIT_KoujyoSymNaiyou.koujyosymnaiyoureckbn.eq(C_KoujyosymnaiyourecKbn.HKRNK) +
            $AND + qIT_KoujyoSymNaiyou.sakujyoflg.eq(C_Delflag.SAKUJYO) +
            $AND + qIT_KykSyouhn.syono.eq(qIT_KoujyoSymNaiyou.syono) +
            $AND + qIT_KykSyouhn.syouhncd.eq(qIT_KoujyoSymNaiyou.syouhncd) +
            $AND + qIT_KykSyouhn.syutkkbn.eq(C_SyutkKbn.SYU) +
            $AND + qIT_KoujyoSymNaiyou.syono.eq(qIT_NyknJissekiRireki.syono) +
            $AND + qIT_KoujyoSymNaiyou.jyutoustartym.eq(qIT_NyknJissekiRireki.jyutoustartym) +
            $AND + qIT_KoujyoSymNaiyou.nyknjskrrkrenno.eq(qIT_NyknJissekiRireki.renno) +
            $AND + qIT_NyknJissekiRireki.nyktrksflg.ne(C_Nyktrksflg.TORIKESI) +
            $ORDER_BY(qIT_KoujyoSymNaiyou.renno3keta.desc());

        return exDBEntityManager.createJPQL(sql).bind(qIT_KoujyoSymNaiyou, qIT_KykSyouhn, qIT_NyknJissekiRireki).getResultList();
    }

    private List<IT_KoujyoSymNaiyou> getKoujyoSymNaiyouList(
        List<IT_KoujyoSymNaiyou> pKoujyoSymNaiyouList, List<IT_KoujyoSymNaiyou> pKoujyoSymNaiyouSearchResultList) {

        List<IT_KoujyoSymNaiyou> koujyoSymNaiyouList =  new ArrayList<>();

        for (IT_KoujyoSymNaiyou searchResult : pKoujyoSymNaiyouSearchResultList) {
            for (IT_KoujyoSymNaiyou koujyoSymnaiyou : pKoujyoSymNaiyouList) {
                if (searchResult.getSyouhncd().equals(koujyoSymnaiyou.getSyouhncd()) &&
                    searchResult.getRenno3keta().equals(koujyoSymnaiyou.getRenno3keta())) {
                    koujyoSymNaiyouList.add(koujyoSymnaiyou);
                }
            }
        }

        return koujyoSymNaiyouList;
    }

    public String getBeforeHenkousikibetukey(String pSyono, String pHenkousikibetukey) {

        QIT_KykSyouhnRireki qIT_KykSyouhnRireki = new QIT_KykSyouhnRireki("qIT_KykSyouhnRireki");

        String sql = $SELECT + $MAX(qIT_KykSyouhnRireki.henkousikibetukey) +
            $FROM(qIT_KykSyouhnRireki) +
            $WHERE + qIT_KykSyouhnRireki.syono.eq(pSyono) +
            $AND + qIT_KykSyouhnRireki.henkousikibetukey.lt(pHenkousikibetukey);

        return exDBEntityManager.createJPQL(sql).bind(qIT_KykSyouhnRireki).getSingleResult();
    }
}
