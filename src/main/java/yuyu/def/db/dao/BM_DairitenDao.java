package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.string.StringUtil;
import yuyu.def.db.entity.BM_Dairiten;
import yuyu.def.db.meta.QBM_Dairiten;

/**
 * 代理店マスタ(BM_DairitenDao) アクセス用の DAO クラスです。<br />
 */
public class BM_DairitenDao extends AbstractDao<BM_Dairiten> {

    public BM_DairitenDao() {
        super(BM_Dairiten.class);
    }

    public BM_Dairiten getDairiten(String pDrtencd){
        BM_Dairiten bM_Dairiten =  new BM_Dairiten();
        bM_Dairiten.setDrtencd(pDrtencd);
        return this.selectOne(bM_Dairiten);
    }

    public List<BM_Dairiten> getDairitensByKinyuucdKinyuusitencd(String pKinyuucd, String pKinyuusitencd) {
        BM_Dairiten bM_Dairiten =  new BM_Dairiten();
        bM_Dairiten.setKinyuucd(pKinyuucd);
        bM_Dairiten.setKinyuusitencd(pKinyuusitencd);
        return this.select(bM_Dairiten);
    }

    public List<BM_Dairiten> getDairitensByOyadrtencdDrtenjimcd(String pOyadrtencd, String pDrtenjimcd) {


        QBM_Dairiten qBM_Dairiten = new QBM_Dairiten();


        String queryStr = $SELECT + qBM_Dairiten +
            $FROM + qBM_Dairiten.BM_Dairiten() +
            $WHERE + qBM_Dairiten.oyadrtencd.eq(pOyadrtencd) +
            $AND + qBM_Dairiten.drtenjimcd.eq(pDrtenjimcd) +
            $AND + qBM_Dairiten.dairitenkouryokusyuuryouymd.isNull();

        return em.createJPQL(queryStr).bind(qBM_Dairiten).getResultList();
    }

    public List<BM_Dairiten> getDairitensByDrtencds(String[] pDrtencd) {


        QBM_Dairiten qBM_Dairiten = new QBM_Dairiten();


        String queryStr = $SELECT + qBM_Dairiten +
            $FROM + qBM_Dairiten.BM_Dairiten() +
            $WHERE + qBM_Dairiten.drtencd.in(pDrtencd);

        return em.createJPQL(queryStr).bind(qBM_Dairiten).getResultList();
    }

    public List<BM_Dairiten> getDairitensByKinyuucd(String pKinyuucd) {


        QBM_Dairiten qBM_Dairiten = new QBM_Dairiten();


        String strSql = $SELECT + qBM_Dairiten +
            $FROM + qBM_Dairiten.BM_Dairiten() +
            $WHERE + qBM_Dairiten.kinyuucd.eq(pKinyuucd) +
            $AND + qBM_Dairiten.drtencd.eq(qBM_Dairiten.oyadrtencd) +
            $AND + qBM_Dairiten.dairitenkouryokukaisiymd.le(BizDate.getSysDate()) +
            $AND + "(" + qBM_Dairiten.dairitenkouryokusyuuryouymd.ge(BizDate.getSysDate()) +
            $OR + qBM_Dairiten.dairitenkouryokusyuuryouymd.isNull() + ")";


        return em.createJPQL(strSql).bind(qBM_Dairiten).getResultList();
    }

    public String getDairitenMinDrtencdByKinyuucdDrtenjimcd(String pKinyuucd, String pDrtenjimcd) {


        QBM_Dairiten qBM_Dairiten = new QBM_Dairiten("qBM_Dairiten");


        String queryStr = $SELECT + $MIN(qBM_Dairiten.drtencd) +
            $FROM (qBM_Dairiten) +
            $WHERE + qBM_Dairiten.kinyuucd.eq(pKinyuucd) +
            $AND + qBM_Dairiten.drtenjimcd.eq(pDrtenjimcd) +
            $AND + qBM_Dairiten.dairitenkouryokusyuuryouymd.isNull();

        return em.createJPQL(queryStr).bind(qBM_Dairiten).getSingleResult();
    }

    public long getDairitenCountByDrtencdDrtennm(String pDrtencd, String pDrtennmkn, String pDrtennmkj1, String pDrtennmkj2) {


        QBM_Dairiten qBM_Dairiten = new QBM_Dairiten("qBM_Dairiten");


        String subQuery1 = "";

        String subQuery2 = "";

        String subQuery3 = "";

        String subQuery4 = "";

        String subQuery5 = "";

        int subqueryCnt = 0;


        if (!StringUtil.isNullOrBlank(pDrtencd)) {

            subQuery2 = qBM_Dairiten.drtencd.like(pDrtencd + "%");
            subqueryCnt++;

        }


        if (!StringUtil.isNullOrBlank(pDrtennmkn)) {

            if (subqueryCnt > 0) {
                subQuery3 = $AND ;

            }

            subQuery3 = subQuery3 + qBM_Dairiten.drtennm.like("%" + pDrtennmkn + "%");
            subqueryCnt++;
        }


        if (!StringUtil.isNullOrBlank(pDrtennmkj1)) {

            if (subqueryCnt > 0) {
                subQuery4 = $AND ;

            }

            subQuery4 = subQuery4 + qBM_Dairiten.kanjidairitennm.like("%" + pDrtennmkj1 + "%");
            subqueryCnt++;
        }


        if (!StringUtil.isNullOrBlank(pDrtennmkj2)) {

            if (subqueryCnt > 0) {
                subQuery5 = $AND ;

            }

            subQuery5 = subQuery5 + qBM_Dairiten.kanjidairitennm.like("%" + pDrtennmkj2 + "%");
            subqueryCnt++;
        }


        if (subqueryCnt > 0) {

            subQuery1 = $WHERE;
        }


        String queryStr = $SELECT + $COUNT + "(*)" +
            $FROM(qBM_Dairiten) +
            subQuery1 +
            subQuery2 +
            subQuery3 +
            subQuery4 +
            subQuery5;


        return em.createJPQL(queryStr).bind(qBM_Dairiten).getSingleResult();
    }

    public List<BM_Dairiten> getDairitenByDrtencdDrtennmOrderByDrtencdAsc(String pDrtencd, String pDrtennmkn, String pDrtennmkj1, String pDrtennmkj2) {


        QBM_Dairiten qBM_Dairiten = new QBM_Dairiten("qBM_Dairiten");


        String subQuery1 = "";

        String subQuery2 = "";

        String subQuery3 = "";

        String subQuery4 = "";

        String subQuery5 = "";

        int subqueryCnt = 0;


        if (!StringUtil.isNullOrBlank(pDrtencd)) {

            subQuery2 = qBM_Dairiten.drtencd.like(pDrtencd + "%");
            subqueryCnt++;

        }


        if (!StringUtil.isNullOrBlank(pDrtennmkn)) {

            if (subqueryCnt > 0) {
                subQuery3 = $AND ;

            }

            subQuery3 = subQuery3 + qBM_Dairiten.drtennm.like("%" + pDrtennmkn + "%");
            subqueryCnt++;
        }


        if (!StringUtil.isNullOrBlank(pDrtennmkj1)) {

            if (subqueryCnt > 0) {
                subQuery4 = $AND ;

            }

            subQuery4 = subQuery4 + qBM_Dairiten.kanjidairitennm.like("%" + pDrtennmkj1 + "%");
            subqueryCnt++;
        }


        if (!StringUtil.isNullOrBlank(pDrtennmkj2)) {

            if (subqueryCnt > 0) {
                subQuery5 = $AND ;

            }

            subQuery5 = subQuery5 + qBM_Dairiten.kanjidairitennm.like("%" + pDrtennmkj2 + "%");
            subqueryCnt++;
        }


        if (subqueryCnt > 0) {

            subQuery1 = $WHERE;
        }

        String queryStr = $SELECT + qBM_Dairiten +
            $FROM(qBM_Dairiten) +
            subQuery1 +
            subQuery2 +
            subQuery3 +
            subQuery4 +
            subQuery5 +
            $ORDER_BY(qBM_Dairiten.drtencd.asc());

        return em.createJPQL(queryStr).bind(qBM_Dairiten).getResultList();
    }
}
