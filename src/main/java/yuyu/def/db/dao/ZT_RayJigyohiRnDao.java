package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_RayJigyohiRn;
import yuyu.def.db.meta.QZT_RayJigyohiRn;

/**
 * ＲＡＹ事業費Ｆテーブル（連）(ZT_RayJigyohiRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_RayJigyohiRnDao extends AbstractDao<ZT_RayJigyohiRn> {

    public ZT_RayJigyohiRnDao() {
        super(ZT_RayJigyohiRn.class);
    }

    public ZT_RayJigyohiRn getRayJigyohiRn(Integer pZrnsequenceno) {
        ZT_RayJigyohiRn zT_RayJigyohiRn =  new ZT_RayJigyohiRn();
        zT_RayJigyohiRn.setZrnsequenceno(pZrnsequenceno);
        return this.selectOne(zT_RayJigyohiRn);
    }

    public ExDBResults<ZT_RayJigyohiRn> selectAllZT_RayJigyohiRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_RayJigyohiRn qZT_RayJigyohiRn =  new QZT_RayJigyohiRn();
        jpql.append($SELECT);
        jpql.append(qZT_RayJigyohiRn);
        jpql.append($FROM);
        jpql.append(qZT_RayJigyohiRn.ZT_RayJigyohiRn());
        jpql.append($ORDER_BY(qZT_RayJigyohiRn.zrnsequenceno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_RayJigyohiRn).getResults();
    }
}
