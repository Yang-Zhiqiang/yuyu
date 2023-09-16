package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_RayIdouVRn;
import yuyu.def.db.meta.QZT_RayIdouVRn;

/**
 * ＲＡＹ異動ＶＦテーブル（連）(ZT_RayIdouVRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_RayIdouVRnDao extends AbstractDao<ZT_RayIdouVRn> {

    public ZT_RayIdouVRnDao() {
        super(ZT_RayIdouVRn.class);
    }

    public ZT_RayIdouVRn getRayIdouVRn(Integer pZrnsequenceno) {
        ZT_RayIdouVRn zT_RayIdouVRn =  new ZT_RayIdouVRn();
        zT_RayIdouVRn.setZrnsequenceno(pZrnsequenceno);
        return this.selectOne(zT_RayIdouVRn);
    }

    public ExDBResults<ZT_RayIdouVRn> selectAllZT_RayIdouVRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_RayIdouVRn qZT_RayIdouVRn =  new QZT_RayIdouVRn();
        jpql.append($SELECT);
        jpql.append(qZT_RayIdouVRn);
        jpql.append($FROM);
        jpql.append(qZT_RayIdouVRn.ZT_RayIdouVRn());
        jpql.append($ORDER_BY(qZT_RayIdouVRn.zrnsequenceno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_RayIdouVRn).getResults();
    }
}
