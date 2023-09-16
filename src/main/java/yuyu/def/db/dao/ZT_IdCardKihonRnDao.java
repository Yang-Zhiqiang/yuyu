package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_IdCardKihonRn;
import yuyu.def.db.meta.QZT_IdCardKihonRn;

/**
 * ＩＤカードＦ基本テーブル（連）(ZT_IdCardKihonRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_IdCardKihonRnDao extends AbstractDao<ZT_IdCardKihonRn> {

    public ZT_IdCardKihonRnDao() {
        super(ZT_IdCardKihonRn.class);
    }

    public ZT_IdCardKihonRn getIdCardKihonRn(String pZrnidkbn, String pZrnidcd) {
        ZT_IdCardKihonRn zT_IdCardKihonRn =  new ZT_IdCardKihonRn();
        zT_IdCardKihonRn.setZrnidkbn(pZrnidkbn);
        zT_IdCardKihonRn.setZrnidcd(pZrnidcd);
        return this.selectOne(zT_IdCardKihonRn);
    }

    public ExDBResults<ZT_IdCardKihonRn> selectAllZT_IdCardKihonRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_IdCardKihonRn qZT_IdCardKihonRn =  new QZT_IdCardKihonRn();
        jpql.append($SELECT);
        jpql.append(qZT_IdCardKihonRn);
        jpql.append($FROM);
        jpql.append(qZT_IdCardKihonRn.ZT_IdCardKihonRn());
        jpql.append($ORDER_BY(qZT_IdCardKihonRn.zrnidkbn.asc(), qZT_IdCardKihonRn.zrnidcd.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_IdCardKihonRn).getResults();
    }

    public Long getIdCardKihonRnCount() {


        QZT_IdCardKihonRn qZT_IdCardKihonRn = new QZT_IdCardKihonRn();

        String queryStr = $SELECT + $COUNT + "(*)" +
            $FROM + qZT_IdCardKihonRn.ZT_IdCardKihonRn();

        return em.createJPQL(queryStr).bind(qZT_IdCardKihonRn).getSingleResult();

    }

    public ExDBResults<ZT_IdCardKihonRn> getIdCardKihonRnsByZrnidcdKeta6(String pZrnidcdKeta6) {


        QZT_IdCardKihonRn qZT_IdCardKihonRn = new QZT_IdCardKihonRn();

        String queryStr = $SELECT + qZT_IdCardKihonRn +
            $FROM + qZT_IdCardKihonRn.ZT_IdCardKihonRn() +
            $WHERE + qZT_IdCardKihonRn.zrnidcd.substring(6, 1).eq(pZrnidcdKeta6) +
            $ORDER_BY(qZT_IdCardKihonRn.zrnidkbn.asc(),
                qZT_IdCardKihonRn.zrnidcd.asc());

        return em.createJPQL(queryStr).bind(qZT_IdCardKihonRn).getResults();
    }
}
