package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.util.string.StringUtil;
import yuyu.def.biz.result.bean.AddressDistinctItemsBypostalCdBean;
import yuyu.def.biz.result.bean.AddressDistinctPostAdrkjAdrknbkarisByItemsBean;
import yuyu.def.classification.C_KihontikucdSyoumetuKbn;
import yuyu.def.classification.C_TodouhukenKbn;
import yuyu.def.db.entity.BM_Address;
import yuyu.def.db.meta.QBM_Address;

/**
 * 住所マスタ(BM_AddressDao) アクセス用の DAO クラスです。<br />
 */
public class BM_AddressDao extends AbstractDao<BM_Address> {

    public BM_AddressDao() {
        super(BM_Address.class);
    }

    public BM_Address getAddress(String pPostalCd, String pKihontikucdsimo1) {
        BM_Address bM_Address =  new BM_Address();
        bM_Address.setPostalCd(pPostalCd);
        bM_Address.setKihontikucdsimo1(pKihontikucdsimo1);
        return this.selectOne(bM_Address);
    }

    public List<BM_Address> getAddressesByPostalCd(String pPostalCd) {


        BM_Address bM_Address =  new BM_Address();

        bM_Address.setPostalCd(pPostalCd);


        return this.select(bM_Address);
    }

    public Long getAddressDistinctPostAdrkjAdrknbkarisCountByItems(String pPostalCd, C_KihontikucdSyoumetuKbn pKihontikucdsyoumetukbn,
        C_TodouhukenKbn pTodouhukencd, String pAdrkn, String pAdrkj) {


        QBM_Address qBM_Address1 = new QBM_Address("qBM_Address1");
        QBM_Address qBM_Address2 = new QBM_Address("qBM_Address2");


        String strSubSqlWhere = "";

        if (!StringUtil.isNullOrBlank(pPostalCd)) {


            strSubSqlWhere += $AND ;
            strSubSqlWhere += qBM_Address1.postalCd.like(pPostalCd + "%");
        }


        if (pKihontikucdsyoumetukbn != null) {


            strSubSqlWhere += $AND ;
            strSubSqlWhere += qBM_Address1.kihontikucdsyoumetukbn.eq(pKihontikucdsyoumetukbn);
        }


        if (pTodouhukencd != null ) {


            strSubSqlWhere += $AND ;
            strSubSqlWhere += qBM_Address1.todouhukencd.eq(pTodouhukencd);
        }


        if (!StringUtil.isNullOrBlank(pAdrkn)) {


            strSubSqlWhere += $AND ;
            strSubSqlWhere += qBM_Address1.adrkn.like("%" + pAdrkn + "%");
        }


        if (!StringUtil.isNullOrBlank(pAdrkj)) {


            strSubSqlWhere += $AND ;
            strSubSqlWhere += qBM_Address1.adrkj.like("%" + pAdrkj + "%");
        }


        String strSubSql = $SELECT + $MAX(qBM_Address1.kihontikucdsimo1) +
            $FROM + qBM_Address1.BM_Address() +
            $WHERE + qBM_Address1.postalCd.eq(qBM_Address2.postalCd) +
            strSubSqlWhere +
            $GROUP_BY + qBM_Address1.postalCd + "," +
            qBM_Address1.adrkj + "," +
            qBM_Address1.adrknblankari+ "," +
            qBM_Address1.kjtodouhukennmketasuu + "," +
            qBM_Address1.kjsikugunnmketasuu;


        String strMainSql = $SELECT + $COUNT(qBM_Address2.postalCd) +
            $FROM + qBM_Address2.BM_Address() +
            $WHERE + qBM_Address2.kihontikucdsimo1 + " IN " + $(strSubSql);

        return em.createJPQL(strMainSql).bind(qBM_Address1, qBM_Address2).getSingleResult();
    }

    public List<AddressDistinctPostAdrkjAdrknbkarisByItemsBean> getAddressDistinctPostAdrkjAdrknbkarisByItems(String pPostalCd, C_KihontikucdSyoumetuKbn pKihontikucdsyoumetukbn, C_TodouhukenKbn pTodouhukencd, String pAdrkn
        , String pAdrkj) {


        QBM_Address qBM_Address = new QBM_Address();


        String strWhere = "";


        if (!StringUtil.isNullOrBlank(pPostalCd)) {


            strWhere += qBM_Address.postalCd.like(pPostalCd + "%");
        }


        if (pKihontikucdsyoumetukbn != null) {

            if (!StringUtil.isNullOrBlank(strWhere)) {
                strWhere += $AND ;
            }


            strWhere += qBM_Address.kihontikucdsyoumetukbn.eq(pKihontikucdsyoumetukbn);
        }


        if (pTodouhukencd != null ) {

            if (!StringUtil.isNullOrBlank(strWhere)) {
                strWhere += $AND ;
            }


            strWhere += qBM_Address.todouhukencd.eq(pTodouhukencd);
        }


        if (!StringUtil.isNullOrBlank(pAdrkn)) {

            if (!StringUtil.isNullOrBlank(strWhere)) {
                strWhere += $AND ;
            }


            strWhere += qBM_Address.adrkn.like("%" + pAdrkn + "%");
        }


        if (!StringUtil.isNullOrBlank(pAdrkj)) {

            if (!StringUtil.isNullOrBlank(strWhere)) {
                strWhere += $AND ;
            }


            strWhere += qBM_Address.adrkj.like("%" + pAdrkj + "%");
        }


        if (!StringUtil.isNullOrBlank(strWhere)) {

            strWhere = $WHERE + strWhere;
        }


        String strSql = $SELECT + $NEW(AddressDistinctPostAdrkjAdrknbkarisByItemsBean.class,
            qBM_Address.postalCd + "," +
            qBM_Address.adrkj + "," +
            qBM_Address.adrknblankari + "," +
            qBM_Address.kjtodouhukennmketasuu + "," +
            qBM_Address.kjsikugunnmketasuu) +
            $FROM + qBM_Address.BM_Address() +
            strWhere +
            $GROUP_BY + qBM_Address.postalCd + "," +
            qBM_Address.adrkj + "," +
            qBM_Address.adrknblankari + "," +
            qBM_Address.kjtodouhukennmketasuu + "," +
            qBM_Address.kjsikugunnmketasuu +
            $ORDER_BY(qBM_Address.adrknblankari.asc(),
                qBM_Address.postalCd.asc());

        return em.createJPQL(strSql, AddressDistinctPostAdrkjAdrknbkarisByItemsBean.class).bind(qBM_Address).setFirstResult(0).setMaxResults(1001).getResultList();
    }

    public List<String> getAddressDistinctAdrknblankarisByPostalCd(String pPostalCd, C_KihontikucdSyoumetuKbn pKihontikucdsyoumetukbn) {


        QBM_Address qBM_Address = new QBM_Address();


        String strSql = $SELECT + $DISTINCT + qBM_Address.adrknblankari +
            $FROM + qBM_Address.BM_Address() +
            $WHERE + qBM_Address.postalCd.eq(pPostalCd) +
            $AND + qBM_Address.kihontikucdsyoumetukbn.eq(pKihontikucdsyoumetukbn) +
            $ORDER_BY(qBM_Address.adrknblankari.asc());


        return em.createJPQL(strSql).bind(qBM_Address).getResultList();
    }

    public C_TodouhukenKbn getAddressMinTodouhukencdByPostalCd(String pPostalCd, C_KihontikucdSyoumetuKbn pKihontikucdsyoumetukbn) {


        QBM_Address qBM_Address = new QBM_Address();


        String strSql = $SELECT + $MIN(qBM_Address.todouhukencd) +
            $FROM + qBM_Address.BM_Address() +
            $WHERE + qBM_Address.postalCd.eq(pPostalCd) +
            $AND + qBM_Address.kihontikucdsyoumetukbn.eq(pKihontikucdsyoumetukbn);


        return em.createJPQL(strSql).bind(qBM_Address).getSingleResult();
    }

    public List<AddressDistinctItemsBypostalCdBean> getAddressDistinctItemsBypostalCd(String pPostalCd,
        C_KihontikucdSyoumetuKbn pKihontikucdsyoumetukbn) {


        QBM_Address qBM_Address = new QBM_Address();


        String strSql = $SELECT_DISTINCT + $NEW(AddressDistinctItemsBypostalCdBean.class,
            qBM_Address.adrkj,
            qBM_Address.kjsikugunnmketasuu) +
            $FROM + qBM_Address.BM_Address() +
            $WHERE + qBM_Address.postalCd.eq(pPostalCd) +
            $AND + qBM_Address.kihontikucdsyoumetukbn.eq(pKihontikucdsyoumetukbn) +
            $ORDER_BY(qBM_Address.adrkj.asc(),
                qBM_Address.kjsikugunnmketasuu.asc());


        return em.createJPQL(strSql, AddressDistinctItemsBypostalCdBean.class).bind(qBM_Address).getResultList();
    }
}
