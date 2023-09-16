package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_KsnRayJigyohiRn;
import yuyu.def.db.meta.QZT_KsnRayJigyohiRn;

/**
 * 決算計上用ＲＡＹ事業費Ｆテーブル（連）(ZT_KsnRayJigyohiRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_KsnRayJigyohiRnDao extends AbstractDao<ZT_KsnRayJigyohiRn> {

    public ZT_KsnRayJigyohiRnDao() {
        super(ZT_KsnRayJigyohiRn.class);
    }

    public ZT_KsnRayJigyohiRn getKsnRayJigyohiRn(Integer pZrnsequenceno) {
        ZT_KsnRayJigyohiRn zT_KsnRayJigyohiRn =  new ZT_KsnRayJigyohiRn();
        zT_KsnRayJigyohiRn.setZrnsequenceno(pZrnsequenceno);
        return this.selectOne(zT_KsnRayJigyohiRn);
    }

    public ExDBResults<ZT_KsnRayJigyohiRn> selectAllZT_KsnRayJigyohiRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_KsnRayJigyohiRn qZT_KsnRayJigyohiRn =  new QZT_KsnRayJigyohiRn();
        jpql.append($SELECT);
        jpql.append(qZT_KsnRayJigyohiRn);
        jpql.append($FROM);
        jpql.append(qZT_KsnRayJigyohiRn.ZT_KsnRayJigyohiRn());
        jpql.append($ORDER_BY(qZT_KsnRayJigyohiRn.zrnsequenceno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_KsnRayJigyohiRn).getResults();
    }
}
