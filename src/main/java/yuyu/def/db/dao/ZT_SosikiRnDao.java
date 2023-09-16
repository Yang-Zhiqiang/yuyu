package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_SosikiRn;
import yuyu.def.db.meta.QZT_SosikiRn;

/**
 * 普保用組織ＰＲＴ用連動Ｆテーブル（連）(ZT_SosikiRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_SosikiRnDao extends AbstractDao<ZT_SosikiRn> {

    public ZT_SosikiRnDao() {
        super(ZT_SosikiRn.class);
    }

    public ZT_SosikiRn getSosikiRn(String pZrnsosikicd) {
        ZT_SosikiRn zT_SosikiRn =  new ZT_SosikiRn();
        zT_SosikiRn.setZrnsosikicd(pZrnsosikicd);
        return this.selectOne(zT_SosikiRn);
    }

    public ExDBResults<ZT_SosikiRn> selectAllZT_SosikiRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_SosikiRn qZT_SosikiRn =  new QZT_SosikiRn();
        jpql.append($SELECT);
        jpql.append(qZT_SosikiRn);
        jpql.append($FROM);
        jpql.append(qZT_SosikiRn.ZT_SosikiRn());
        jpql.append($ORDER_BY(qZT_SosikiRn.zrnsosikicd.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_SosikiRn).getResults();
    }

    public Long getSosikiRnCount() {


        QZT_SosikiRn qZT_SosikiRn = new QZT_SosikiRn();


        String strSql = $SELECT + $COUNT(qZT_SosikiRn.zrnsosikicd) +
            $FROM + qZT_SosikiRn.ZT_SosikiRn();


        return em.createJPQL(strSql).bind(qZT_SosikiRn).getSingleResult();
    }
}
