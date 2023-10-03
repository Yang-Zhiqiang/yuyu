package yuyu.batch.suuri.srsuuritoukei.srrrthndugthknjigyohi;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.classification.C_Nyktrksflg;
import yuyu.def.db.entity.IT_NyknJissekiRireki;
import yuyu.def.db.entity.ST_SynypTukiTugtTykiyuHozon;
import yuyu.def.db.entity.ST_SynypTukiYkgtIkouHozon;
import yuyu.def.db.meta.QIT_NyknJissekiRireki;
import yuyu.def.db.meta.QST_SynypTukiTugtTykiyuHozon;
import yuyu.def.db.meta.QST_SynypTukiYkgtIkouHozon;

/**
 * 利率変動型保険事業費情報作成DAOクラスです。
 */
public class SrRrtHndugtHknJigyohiDao {

    @Inject
    ExDBEntityManager exDBEntityManager;

    public ExDBResults<ST_SynypTukiYkgtIkouHozon> getST_SynypTukiYkgtIkouHozons(BizDateYM pKijyunYm) {

        QST_SynypTukiYkgtIkouHozon qST_SynypTukiYkgtIkouHozon = new QST_SynypTukiYkgtIkouHozon(
            "qST_SynypTukiYkgtIkouHozon");

        String strSql = $SELECT + qST_SynypTukiYkgtIkouHozon +
            $FROM(qST_SynypTukiYkgtIkouHozon) +
            $WHERE + qST_SynypTukiYkgtIkouHozon.jyutoustartym.le(pKijyunYm) +
            $AND + qST_SynypTukiYkgtIkouHozon.jyutouendym.ge(pKijyunYm);

        return exDBEntityManager.createJPQL(strSql).bind(qST_SynypTukiYkgtIkouHozon).getResults();
    }

    public ExDBResults<ST_SynypTukiTugtTykiyuHozon> getSynypTukiTugtTykiyuHozons(BizDateYM pKijyunym,
        String pKakutyoujobcdSkSynyp, String pKakutyoujobcdGekkanHnkSynyp) {

        QST_SynypTukiTugtTykiyuHozon qST_SynypTukiTugtTykiyuHozon = new QST_SynypTukiTugtTykiyuHozon(
            "qST_SynypTukiTugtTykiyuHozon");

        String strSql = $SELECT + qST_SynypTukiTugtTykiyuHozon +
            $FROM(qST_SynypTukiTugtTykiyuHozon) +
            $WHERE + qST_SynypTukiTugtTykiyuHozon.ztysrkijyunym.eq(String.valueOf(pKijyunym)) +
            $AND + $(qST_SynypTukiTugtTykiyuHozon.ztysrkakutyoujobcd.eq(pKakutyoujobcdSkSynyp) +
                $OR  + qST_SynypTukiTugtTykiyuHozon.ztysrkakutyoujobcd.eq(pKakutyoujobcdGekkanHnkSynyp));

        return exDBEntityManager.createJPQL(strSql).bind(qST_SynypTukiTugtTykiyuHozon).getResults();
    }

    public IT_NyknJissekiRireki getNyknJissekiRireki1(String pSyono, BizDateYM pJyuutouym) {

        QIT_NyknJissekiRireki qIT_NyknJissekiRireki = new QIT_NyknJissekiRireki("qIT_NyknJissekiRireki");

        String strSql = $SELECT + qIT_NyknJissekiRireki +
            $FROM(qIT_NyknJissekiRireki) +
            $WHERE + qIT_NyknJissekiRireki.syono.eq(pSyono) +
            $AND + qIT_NyknJissekiRireki.jyutoustartym.le(pJyuutouym) +
            $AND + qIT_NyknJissekiRireki.jyutouendym.ge(pJyuutouym) +
            $AND + qIT_NyknJissekiRireki.nyktrksflg.eq(C_Nyktrksflg.BLNK);

        return exDBEntityManager.createJPQL(strSql).bind(qIT_NyknJissekiRireki).getSingleResult();
    }

    public IT_NyknJissekiRireki getNyknJissekiRireki2(String pSyono, BizDateYM pJyuutouym, String pNyktrksdenno) {

        QIT_NyknJissekiRireki qIT_NyknJissekiRireki = new QIT_NyknJissekiRireki("qIT_NyknJissekiRireki");

        String strSql = $SELECT + qIT_NyknJissekiRireki +
            $FROM(qIT_NyknJissekiRireki) +
            $WHERE + qIT_NyknJissekiRireki.syono.eq(pSyono) +
            $AND + qIT_NyknJissekiRireki.jyutoustartym.le(pJyuutouym) +
            $AND + qIT_NyknJissekiRireki.jyutouendym.ge(pJyuutouym) +
            $AND + qIT_NyknJissekiRireki.nyktrksdenno.eq(pNyktrksdenno);

        return exDBEntityManager.createJPQL(strSql).bind(qIT_NyknJissekiRireki).getSingleResult();
    }
}
