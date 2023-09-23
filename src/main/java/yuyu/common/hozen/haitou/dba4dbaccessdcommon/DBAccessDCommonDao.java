package yuyu.common.hozen.haitou.dba4dbaccessdcommon;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import yuyu.def.classification.C_HaitoukinsksKbn;
import yuyu.def.classification.C_HaitoumeisaiKbn;
import yuyu.def.classification.C_TumitateDSakuseiKbn;
import yuyu.def.db.entity.IT_KhHaitouKanri;
import yuyu.def.db.entity.IT_KhTumitateDKanri;
import yuyu.def.db.meta.QIT_KhHaitouKanri;
import yuyu.def.db.meta.QIT_KhTumitateDKanri;

/**
 * 契約保全 契約保全共通 配当共通ＤＢアクセスの機能DAOクラスです。
 */
public class DBAccessDCommonDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public List<IT_KhHaitouKanri> getHaitouKanrisBySyonoHaitoumeisaikbn(
        String pSyono, C_HaitoumeisaiKbn pHaitoumeisaiKbn) {

        QIT_KhHaitouKanri qIT_KhHaitouKanri = new QIT_KhHaitouKanri("qIT_KhHaitouKanri");

        String strSql = $SELECT + qIT_KhHaitouKanri +
            $FROM(qIT_KhHaitouKanri) +
            $WHERE + qIT_KhHaitouKanri.syono.eq(pSyono) +
            $AND + qIT_KhHaitouKanri.haitoumeisaikbn.eq(pHaitoumeisaiKbn) +
            $ORDER_BY(qIT_KhHaitouKanri.kariwariatedshrymd.desc(),
                qIT_KhHaitouKanri.renno.desc());

        return exDBEntityManager.createJPQL(strSql).bind(qIT_KhHaitouKanri).getResultList();
    }

    public List<IT_KhHaitouKanri> getHaitouKanrisBySyonoHaitoumeisaikbnKijyunymd(
        String pSyono, C_HaitoumeisaiKbn pHaitoumeisaiKbn, BizDate pKijyunymd) {

        QIT_KhHaitouKanri qIT_KhHaitouKanri = new QIT_KhHaitouKanri("qIT_KhHaitouKanri");

        String strSql = $SELECT + qIT_KhHaitouKanri +
            $FROM(qIT_KhHaitouKanri) +
            $WHERE + qIT_KhHaitouKanri.syono.eq(pSyono) +
            $AND + qIT_KhHaitouKanri.haitoumeisaikbn.eq(pHaitoumeisaiKbn) +
            $AND + qIT_KhHaitouKanri.kariwariatedshrymd.le(pKijyunymd) +
            $ORDER_BY(qIT_KhHaitouKanri.kariwariatedshrymd.desc(),
                qIT_KhHaitouKanri.renno.desc());

        return exDBEntityManager.createJPQL(strSql).bind(qIT_KhHaitouKanri).getResultList();
    }

    public List<IT_KhHaitouKanri> getHaitouKanrisBySyonoHaitoumeisaikbnHaitoukinskskbn(
        String pSyono, C_HaitoumeisaiKbn pHaitoumeisaiKbn, C_HaitoukinsksKbn[] pHaitoukinsksKbn) {

        QIT_KhHaitouKanri qIT_KhHaitouKanri = new QIT_KhHaitouKanri("qIT_KhHaitouKanri");

        String strSql = $SELECT + qIT_KhHaitouKanri +
            $FROM(qIT_KhHaitouKanri) +
            $WHERE + qIT_KhHaitouKanri.syono.eq(pSyono) +
            $AND + qIT_KhHaitouKanri.haitoumeisaikbn.eq(pHaitoumeisaiKbn) +
            $AND + qIT_KhHaitouKanri.haitoukinskskbn.in(pHaitoukinsksKbn) +
            $ORDER_BY(qIT_KhHaitouKanri.kariwariatedshrymd.desc(),
                qIT_KhHaitouKanri.renno.desc());

        return exDBEntityManager.createJPQL(strSql).bind(qIT_KhHaitouKanri).getResultList();
    }

    public List<IT_KhHaitouKanri> getHaitouKanrisBySyonoHaitoumeisaikbnSeisiki(
        String pSyono, C_HaitoumeisaiKbn pHaitoumeisaiKbn) {

        QIT_KhHaitouKanri qIT_KhHaitouKanri = new QIT_KhHaitouKanri("qIT_KhHaitouKanri");

        String strSql = $SELECT + qIT_KhHaitouKanri +
            $FROM(qIT_KhHaitouKanri) +
            $WHERE + qIT_KhHaitouKanri.syono.eq(pSyono) +
            $AND + qIT_KhHaitouKanri.haitoumeisaikbn.eq(pHaitoumeisaiKbn) +
            $AND + qIT_KhHaitouKanri.haitoukinskskbn
            .in(C_HaitoukinsksKbn.SEISIKI, C_HaitoukinsksKbn.YENDTHNKSEISIKI) +
            $ORDER_BY(qIT_KhHaitouKanri.kariwariatedshrymd.desc(),
                qIT_KhHaitouKanri.renno.desc());

        return exDBEntityManager.createJPQL(strSql).bind(qIT_KhHaitouKanri).getResultList();
    }

    public List<IT_KhTumitateDKanri> getTumitateDKanrisBySyono(String pSyono) {

        QIT_KhTumitateDKanri qIT_KhTumitateDKanri = new QIT_KhTumitateDKanri("qIT_KhTumitateDKanri");

        String strSql = $SELECT + qIT_KhTumitateDKanri +
            $FROM(qIT_KhTumitateDKanri) +
            $WHERE + qIT_KhTumitateDKanri.syono.eq(pSyono) +
            $ORDER_BY(qIT_KhTumitateDKanri.tumitatedtumitateymd.desc(),
                qIT_KhTumitateDKanri.renno.desc());

        return exDBEntityManager.createJPQL(strSql).bind(qIT_KhTumitateDKanri).getResultList();
    }

    public List<IT_KhTumitateDKanri> getTumitateDKanrisBySyonoKijyunymd(String pSyono, BizDate pKijyunymd) {

        QIT_KhTumitateDKanri qIT_KhTumitateDKanri = new QIT_KhTumitateDKanri("qIT_KhTumitateDKanri");

        String strSql = $SELECT + qIT_KhTumitateDKanri +
            $FROM(qIT_KhTumitateDKanri) +
            $WHERE + qIT_KhTumitateDKanri.syono.eq(pSyono) +
            $AND + qIT_KhTumitateDKanri.tumitatedtumitateymd.le(pKijyunymd) +
            $ORDER_BY(qIT_KhTumitateDKanri.tumitatedtumitateymd.desc(),
                qIT_KhTumitateDKanri.renno.desc());

        return exDBEntityManager.createJPQL(strSql).bind(qIT_KhTumitateDKanri).getResultList();
    }

    public List<IT_KhTumitateDKanri> getTumitateDKanrisBysyonoTumitatedskskbn(
        String pSyono, C_TumitateDSakuseiKbn[] pTumitateDSakuseiKbn) {

        QIT_KhTumitateDKanri qIT_KhTumitateDKanri = new QIT_KhTumitateDKanri("qIT_KhTumitateDKanri");

        String strSql = $SELECT + qIT_KhTumitateDKanri +
            $FROM(qIT_KhTumitateDKanri) +
            $WHERE + qIT_KhTumitateDKanri.syono.eq(pSyono) +
            $AND + qIT_KhTumitateDKanri.tumitatedskskbn.in(pTumitateDSakuseiKbn) +
            $ORDER_BY(qIT_KhTumitateDKanri.tumitatedtumitateymd.desc(),
                qIT_KhTumitateDKanri.renno.desc());

        return exDBEntityManager.createJPQL(strSql).bind(qIT_KhTumitateDKanri).getResultList();
    }

    public long getHaitouKanriCountBySyonoHaitoumeisaiKbnAfterKijyunYmd(
        String pSyono, C_HaitoumeisaiKbn pHaitoumeisaiKbn, BizDate pKijyunymd) {

        QIT_KhHaitouKanri qIT_KhHaitouKanri = new QIT_KhHaitouKanri("qIT_KhHaitouKanri");

        String strSql = $SELECT + $COUNT + "(*)" +
            $FROM(qIT_KhHaitouKanri) +
            $WHERE + qIT_KhHaitouKanri.syono.eq(pSyono) +
            $AND + qIT_KhHaitouKanri.haitoumeisaikbn.eq(pHaitoumeisaiKbn) +
            $AND + qIT_KhHaitouKanri.kariwariatedshrymd.gt(pKijyunymd);

        return exDBEntityManager.createJPQL(strSql).bind(qIT_KhHaitouKanri).getSingleResult();
    }

    public long getTumitateDKanriCountBySyonoTumitatedsksKbnAfterKijyunYmd(
        String pSyono, C_TumitateDSakuseiKbn[] pTumitateDSakuseiKbn, BizDate pKijyunymd) {

        QIT_KhTumitateDKanri qIT_KhTumitateDKanri = new QIT_KhTumitateDKanri("qIT_KhTumitateDKanri");

        String strSql = $SELECT + $COUNT + "(*)" +
            $FROM(qIT_KhTumitateDKanri) +
            $WHERE + qIT_KhTumitateDKanri.syono.eq(pSyono) +
            $AND + qIT_KhTumitateDKanri.tumitatedskskbn.in(pTumitateDSakuseiKbn) +
            $AND + qIT_KhTumitateDKanri.tumitatedshrkrkymd.gt(pKijyunymd);

        return exDBEntityManager.createJPQL(strSql).bind(qIT_KhTumitateDKanri).getSingleResult();
    }

    public long getTumitatedtumitateYmdAfterKijyunYmdTumitateDKanriCountBySyonoTumitatedsksKbn(
        String pSyono, C_TumitateDSakuseiKbn[] pTumitateDSakuseiKbn, BizDate pKijyunymd) {

        QIT_KhTumitateDKanri qIT_KhTumitateDKanri = new QIT_KhTumitateDKanri("qIT_KhTumitateDKanri");

        String strSql = $SELECT + $COUNT + "(*)" +
            $FROM(qIT_KhTumitateDKanri) +
            $WHERE + qIT_KhTumitateDKanri.syono.eq(pSyono) +
            $AND + qIT_KhTumitateDKanri.tumitatedskskbn.in(pTumitateDSakuseiKbn) +
            $AND + qIT_KhTumitateDKanri.tumitatedtumitateymd.gt(pKijyunymd);

        return exDBEntityManager.createJPQL(strSql).bind(qIT_KhTumitateDKanri).getSingleResult();
    }
}
