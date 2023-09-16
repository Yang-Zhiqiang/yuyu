package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_BosyuuninRn;
import yuyu.def.db.meta.QZT_BosyuuninRn;

/**
 * 募集人ＰＲＴ用連動Ｆテーブル（連）(ZT_BosyuuninRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_BosyuuninRnDao extends AbstractDao<ZT_BosyuuninRn> {

    public ZT_BosyuuninRnDao() {
        super(ZT_BosyuuninRn.class);
    }

    public ZT_BosyuuninRn getBosyuuninRn(String pZrnbosyuunincd) {
        ZT_BosyuuninRn zT_BosyuuninRn =  new ZT_BosyuuninRn();
        zT_BosyuuninRn.setZrnbosyuunincd(pZrnbosyuunincd);
        return this.selectOne(zT_BosyuuninRn);
    }

    public ExDBResults<ZT_BosyuuninRn> selectAllZT_BosyuuninRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_BosyuuninRn qZT_BosyuuninRn =  new QZT_BosyuuninRn();
        jpql.append($SELECT);
        jpql.append(qZT_BosyuuninRn);
        jpql.append($FROM);
        jpql.append(qZT_BosyuuninRn.ZT_BosyuuninRn());
        jpql.append($ORDER_BY(qZT_BosyuuninRn.zrnbosyuunincd.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_BosyuuninRn).getResults();
    }


    public Long getBosyuuninRnCount(){


        QZT_BosyuuninRn qZT_BosyuuninRn = new QZT_BosyuuninRn();

        String strSql = $SELECT+$COUNT(qZT_BosyuuninRn.zrnbosyuunincd) +
            $FROM + qZT_BosyuuninRn.ZT_BosyuuninRn();

        return em.createJPQL(strSql).bind(qZT_BosyuuninRn).getSingleResult();

    }

    public ExDBResults<ZT_BosyuuninRn> getBosyuuninRnsByZrnbosyuunincdKeta6(String pZrnbosyuunincdKeta6) {


        QZT_BosyuuninRn qZT_BosyuuninRn = new QZT_BosyuuninRn();


        String strSql = $SELECT + qZT_BosyuuninRn +
            $FROM + qZT_BosyuuninRn.ZT_BosyuuninRn() +
            $WHERE + qZT_BosyuuninRn.zrnbosyuunincd.substring(6, 1).eq(pZrnbosyuunincdKeta6) +
            $ORDER_BY(qZT_BosyuuninRn.zrnbosyuunincd.asc());


        return em.createJPQL(strSql).bind(qZT_BosyuuninRn).getResults();
    }
}
