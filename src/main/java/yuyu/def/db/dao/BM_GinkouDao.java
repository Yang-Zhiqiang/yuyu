package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.util.string.StringUtil;
import yuyu.def.db.entity.BM_Ginkou;
import yuyu.def.db.meta.QBM_Ginkou;

/**
 * 銀行マスタ(BM_GinkouDao) アクセス用の DAO クラスです。<br />
 */
public class BM_GinkouDao extends AbstractDao<BM_Ginkou> {

    public BM_GinkouDao() {
        super(BM_Ginkou.class);
    }

    public BM_Ginkou getGinkou(String pBankcd,
        String pSitencd){
        BM_Ginkou bM_Ginkou =  new BM_Ginkou();
        bM_Ginkou.setBankcd(pBankcd);
        bM_Ginkou.setSitencd(pSitencd);
        return this.selectOne(bM_Ginkou);
    }

    public Long getGinkouCountByBankcdSitencdBanknmknSitennmkn(String pBankcd, String pSitencd, String pBanknmkn,
        String pSitennmkn) {


        QBM_Ginkou qBM_Ginkou = new QBM_Ginkou();

        String subquery1 = "";

        String subquery2 = "";

        String subquery3 = "";

        String subquery4 = "";

        String subquery5 = "";

        int subqueryCnt = 0;


        if (!StringUtil.isNullOrBlank(pBankcd)) {


            subquery2 = qBM_Ginkou.bankcd.like(pBankcd + "%");
            subqueryCnt++;

        }


        if (!StringUtil.isNullOrBlank(pSitencd)) {

            if (subqueryCnt > 0) {
                subquery3 = $AND ;

            }


            subquery3 = subquery3 + qBM_Ginkou.sitencd.like(pSitencd + "%");
            subqueryCnt++;

        }


        if (!StringUtil.isNullOrBlank(pBanknmkn)) {

            if (subqueryCnt > 0) {
                subquery4 = $AND ;

            }


            subquery4 = subquery4 + qBM_Ginkou.banknmkn.like(pBanknmkn + "%");
            subqueryCnt++;

        }


        if (!StringUtil.isNullOrBlank(pSitennmkn)) {

            if (subqueryCnt > 0) {
                subquery5 = $AND ;

            }


            subquery5 = subquery5 + qBM_Ginkou.sitennmkn.like(pSitennmkn + "%");
            subqueryCnt++;

        }


        if (subqueryCnt > 0) {

            subquery1 = $WHERE;
        }


        String queryStr = $SELECT + $COUNT + "(*)" +
            $FROM + qBM_Ginkou.BM_Ginkou() +
            subquery1 +
            subquery2 +
            subquery3 +
            subquery4 +
            subquery5;

        return em.createJPQL(queryStr).bind(qBM_Ginkou).getSingleResult();
    }

    public List<BM_Ginkou> getGinkousByBankcdSitencdBanknmknSitennmkn(String pBankcd, String pSitencd,
        String pBanknmkn, String pSitennmkn) {


        QBM_Ginkou qBM_Ginkou = new QBM_Ginkou();

        String subquery1 = "";

        String subquery2 = "";

        String subquery3 = "";

        String subquery4 = "";

        String subquery5 = "";

        int subqueryCnt = 0;


        if (!StringUtil.isNullOrBlank(pBankcd)) {


            subquery2 = qBM_Ginkou.bankcd.like(pBankcd + "%");
            subqueryCnt++;

        }


        if (!StringUtil.isNullOrBlank(pSitencd)) {

            if (subqueryCnt > 0) {
                subquery3 = $AND ;
            }


            subquery3 = subquery3 + qBM_Ginkou.sitencd.like(pSitencd + "%");
            subqueryCnt++;

        }


        if (!StringUtil.isNullOrBlank(pBanknmkn)) {

            if (subqueryCnt > 0) {
                subquery4 = $AND ;

            }


            subquery4 = subquery4 + qBM_Ginkou.banknmkn.like(pBanknmkn + "%");
            subqueryCnt++;

        }


        if (!StringUtil.isNullOrBlank(pSitennmkn)) {

            if (subqueryCnt > 0) {
                subquery5 = $AND ;

            }


            subquery5 = subquery5 + qBM_Ginkou.sitennmkn.like(pSitennmkn + "%");
            subqueryCnt++;

        }


        if (subqueryCnt > 0) {

            subquery1 = $WHERE;
        }


        String queryStr = $SELECT + qBM_Ginkou +
            $FROM + qBM_Ginkou.BM_Ginkou() +
            subquery1 +
            subquery2 +
            subquery3 +
            subquery4 +
            subquery5 +
            $ORDER_BY(qBM_Ginkou.bankcd,
                qBM_Ginkou.sitencd);

        return em.createJPQL(queryStr).bind(qBM_Ginkou).getResultList();
    }

    public Long getGinkouCountByBankcdSitencdBanknmSitennm(String pBankcd, String pSitencd, String pBanknmkn,
        String pSitennmkn, String pBanknmkj, String pSitennmkj) {


        QBM_Ginkou qBM_Ginkou = new QBM_Ginkou();

        String subquery1 = "";

        String subquery2 = "";

        String subquery3 = "";

        String subquery4 = "";

        String subquery5 = "";

        String subquery6 = "";

        String subquery7 = "";

        int subqueryCnt = 0;


        if (!StringUtil.isNullOrBlank(pBankcd)) {


            subquery2 = qBM_Ginkou.bankcd.like(pBankcd + "%");
            subqueryCnt++;

        }


        if (!StringUtil.isNullOrBlank(pSitencd)) {

            if (subqueryCnt > 0) {
                subquery3 = $AND ;

            }


            subquery3 = subquery3 + qBM_Ginkou.sitencd.like(pSitencd + "%");
            subqueryCnt++;

        }


        if (!StringUtil.isNullOrBlank(pBanknmkn)) {

            if (subqueryCnt > 0) {
                subquery4 = $AND ;

            }


            subquery4 = subquery4 + qBM_Ginkou.banknmkn.like(pBanknmkn + "%");
            subqueryCnt++;

        }


        if (!StringUtil.isNullOrBlank(pSitennmkn)) {

            if (subqueryCnt > 0) {
                subquery5 = $AND ;

            }


            subquery5 = subquery5 + qBM_Ginkou.sitennmkn.like(pSitennmkn + "%");
            subqueryCnt++;

        }


        if (!StringUtil.isNullOrBlank(pBanknmkj)) {

            if (subqueryCnt > 0) {
                subquery6 = $AND ;

            }


            subquery6 = subquery6 + qBM_Ginkou.banknmkj.like(pBanknmkj + "%");
            subqueryCnt++;

        }


        if (!StringUtil.isNullOrBlank(pSitennmkj)) {

            if (subqueryCnt > 0) {
                subquery7 = $AND ;

            }


            subquery7 = subquery7 + qBM_Ginkou.sitennmkj.like(pSitennmkj + "%");
            subqueryCnt++;

        }


        if (subqueryCnt > 0) {

            subquery1 = $WHERE;
        }


        String queryStr = $SELECT + $COUNT + "(*)" +
            $FROM + qBM_Ginkou.BM_Ginkou() +
            subquery1 +
            subquery2 +
            subquery3 +
            subquery4 +
            subquery5 +
            subquery6 +
            subquery7;

        return em.createJPQL(queryStr).bind(qBM_Ginkou).getSingleResult();
    }

    public List<BM_Ginkou> getGinkousByBankcdSitencdBanknmSitennm(String pBankcd, String pSitencd, String pBanknmkn,
        String pSitennmkn, String pBanknmkj, String pSitennmkj) {


        QBM_Ginkou qBM_Ginkou = new QBM_Ginkou();

        String subquery1 = "";

        String subquery2 = "";

        String subquery3 = "";

        String subquery4 = "";

        String subquery5 = "";

        String subquery6 = "";

        String subquery7 = "";

        int subqueryCnt = 0;


        if (!StringUtil.isNullOrBlank(pBankcd)) {


            subquery2 = qBM_Ginkou.bankcd.like(pBankcd + "%");
            subqueryCnt++;

        }


        if (!StringUtil.isNullOrBlank(pSitencd)) {

            if (subqueryCnt > 0) {
                subquery3 = $AND ;

            }


            subquery3 = subquery3 + qBM_Ginkou.sitencd.like(pSitencd + "%");
            subqueryCnt++;

        }


        if (!StringUtil.isNullOrBlank(pBanknmkn)) {

            if (subqueryCnt > 0) {
                subquery4 = $AND ;

            }


            subquery4 = subquery4 + qBM_Ginkou.banknmkn.like(pBanknmkn + "%");
            subqueryCnt++;

        }


        if (!StringUtil.isNullOrBlank(pSitennmkn)) {

            if (subqueryCnt > 0) {
                subquery5 = $AND ;

            }


            subquery5 = subquery5 + qBM_Ginkou.sitennmkn.like(pSitennmkn + "%");
            subqueryCnt++;

        }


        if (!StringUtil.isNullOrBlank(pBanknmkj)) {

            if (subqueryCnt > 0) {
                subquery6 = $AND ;

            }


            subquery6 = subquery6 + qBM_Ginkou.banknmkj.like(pBanknmkj + "%");
            subqueryCnt++;

        }


        if (!StringUtil.isNullOrBlank(pSitennmkj)) {

            if (subqueryCnt > 0) {
                subquery7 = $AND ;

            }


            subquery7 = subquery7 + qBM_Ginkou.sitennmkj.like(pSitennmkj + "%");
            subqueryCnt++;

        }


        if (subqueryCnt > 0) {

            subquery1 = $WHERE;
        }


        String queryStr = $SELECT + qBM_Ginkou +
            $FROM + qBM_Ginkou.BM_Ginkou() +
            subquery1 +
            subquery2 +
            subquery3 +
            subquery4 +
            subquery5 +
            subquery6 +
            subquery7 +
            $ORDER_BY(qBM_Ginkou.bankcd,
                qBM_Ginkou.sitencd);

        return em.createJPQL(queryStr).bind(qBM_Ginkou).getResultList();
    }

    public Long getGinkouCountByBankcdSitencdBanknmSitennm(String pBankcd, String pSitencd, String pBanknmkn,
        String pSitennmkn, String pBanknmkj, String pSitennmkj, String[] pTysyttaisyougaibankcdhrt) {


        QBM_Ginkou qBM_Ginkou = new QBM_Ginkou();


        String subQuerry = "";


        if(!StringUtil.isNullOrBlank(pBankcd)){

            subQuerry = $AND + qBM_Ginkou.bankcd.like(pBankcd + "%");
        }


        if(!StringUtil.isNullOrBlank(pSitencd)){

            subQuerry = subQuerry + $AND + qBM_Ginkou.sitencd.like(pSitencd + "%");
        }


        if(!StringUtil.isNullOrBlank(pBanknmkn)){

            subQuerry = subQuerry + $AND + qBM_Ginkou.banknmkn.like(pBanknmkn + "%");
        }


        if (!StringUtil.isNullOrBlank(pSitennmkn)) {

            subQuerry = subQuerry + $AND + qBM_Ginkou.sitennmkn.like(pSitennmkn + "%");
        }


        if (!StringUtil.isNullOrBlank(pBanknmkj)) {

            subQuerry = subQuerry + $AND + qBM_Ginkou.banknmkj.like(pBanknmkj + "%");
        }


        if (!StringUtil.isNullOrBlank(pSitennmkj)) {

            subQuerry = subQuerry + $AND + qBM_Ginkou.sitennmkj.like(pSitennmkj + "%");
        }


        String queryStr = $SELECT + $COUNT + "(*)" +
            $FROM(qBM_Ginkou) +
            $WHERE + qBM_Ginkou.bankcd.notIn(pTysyttaisyougaibankcdhrt) +
            subQuerry;

        return em.createJPQL(queryStr).bind(qBM_Ginkou).getSingleResult();
    }

    public List<BM_Ginkou> getGinkousByBankcdSitencdBanknmSitennm(String pBankcd, String pSitencd, String pBanknmkn,
        String pSitennmkn, String pBanknmkj, String pSitennmkj, String[] pTysyttaisyougaibankcdhrt) {


        QBM_Ginkou qBM_Ginkou = new QBM_Ginkou();


        String subQuerry = "";


        if(!StringUtil.isNullOrBlank(pBankcd)){

            subQuerry = $AND + qBM_Ginkou.bankcd.like(pBankcd + "%");
        }


        if(!StringUtil.isNullOrBlank(pSitencd)){

            subQuerry = subQuerry + $AND + qBM_Ginkou.sitencd.like(pSitencd + "%");
        }


        if(!StringUtil.isNullOrBlank(pBanknmkn)){

            subQuerry = subQuerry + $AND + qBM_Ginkou.banknmkn.like(pBanknmkn + "%");
        }


        if (!StringUtil.isNullOrBlank(pSitennmkn)) {

            subQuerry = subQuerry + $AND + qBM_Ginkou.sitennmkn.like(pSitennmkn + "%");
        }


        if (!StringUtil.isNullOrBlank(pBanknmkj)) {

            subQuerry = subQuerry + $AND + qBM_Ginkou.banknmkj.like(pBanknmkj + "%");
        }


        if (!StringUtil.isNullOrBlank(pSitennmkj)) {

            subQuerry = subQuerry + $AND + qBM_Ginkou.sitennmkj.like(pSitennmkj + "%");
        }


        String queryStr = $SELECT + qBM_Ginkou +
            $FROM(qBM_Ginkou) +
            $WHERE + qBM_Ginkou.bankcd.notIn(pTysyttaisyougaibankcdhrt) +
            subQuerry +
            $ORDER_BY(qBM_Ginkou.bankcd,
                qBM_Ginkou.sitencd);

        return em.createJPQL(queryStr).bind(qBM_Ginkou).getResultList();
    }

    public Long getGinkousCountByBankcdBanknmkn(String pBankcd, String pBanknmkn) {


        QBM_Ginkou qBM_Ginkou1 = new QBM_Ginkou("qBM_Ginkou1");

        QBM_Ginkou qBM_Ginkou2 = new QBM_Ginkou("qBM_Ginkou2");


        String subQuerry = "";


        if (!StringUtil.isNullOrBlank(pBankcd)) {

            subQuerry = $AND + qBM_Ginkou1.bankcd.like(pBankcd + "%");
        }


        if (!StringUtil.isNullOrBlank(pBanknmkn)) {

            subQuerry = subQuerry + $AND + qBM_Ginkou1.banknmkn.like("%" + pBanknmkn + "%");
        }


        String queryStr = $SELECT + $MIN(qBM_Ginkou1.sitencd) +
            $FROM(qBM_Ginkou1) +
            $WHERE + qBM_Ginkou1.bankcd.eq(qBM_Ginkou2.bankcd) +
            $AND + qBM_Ginkou1.banknmkn.eq(qBM_Ginkou2.banknmkn) +
            subQuerry;


        String mainStr = $SELECT + $COUNT + "(*)" +
            $FROM(qBM_Ginkou2) +
            $WHERE + qBM_Ginkou2.sitencd + $EQ + $(queryStr);


        return em.createJPQL(mainStr).bind(qBM_Ginkou1, qBM_Ginkou2).getSingleResult();
    }

    public List<BM_Ginkou> getGinkousByBankcdBanknmknOrderByBankcdAsc(String pBankcd, String pBanknmkn) {


        QBM_Ginkou qBM_Ginkou1 = new QBM_Ginkou("qBM_Ginkou1");

        QBM_Ginkou qBM_Ginkou2 = new QBM_Ginkou("qBM_Ginkou2");


        String subQuerry = "";


        if (!StringUtil.isNullOrBlank(pBankcd)) {

            subQuerry = $AND + qBM_Ginkou1.bankcd.like(pBankcd + "%");
        }


        if (!StringUtil.isNullOrBlank(pBanknmkn)) {

            subQuerry = subQuerry + $AND + qBM_Ginkou1.banknmkn.like("%" + pBanknmkn + "%");
        }


        String queryStr = $SELECT + $MIN(qBM_Ginkou1.sitencd) +
            $FROM(qBM_Ginkou1) +
            $WHERE + qBM_Ginkou1.bankcd.eq(qBM_Ginkou2.bankcd) +
            $AND + qBM_Ginkou1.banknmkn.eq(qBM_Ginkou2.banknmkn) +
            subQuerry;


        String mainStr = $SELECT + qBM_Ginkou2 +
            $FROM(qBM_Ginkou2) +
            $WHERE + qBM_Ginkou2.sitencd + $EQ + $(queryStr) +
            $ORDER_BY(qBM_Ginkou2.bankcd.asc());

        return em.createJPQL(mainStr).bind(qBM_Ginkou1, qBM_Ginkou2).getResultList();
    }
}
