package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_RayKimatuVRn;
import yuyu.def.db.meta.QZT_RayKimatuVRn;

/**
 * ＲＡＹ期末ＶＦテーブル（連）(ZT_RayKimatuVRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_RayKimatuVRnDao extends AbstractDao<ZT_RayKimatuVRn> {

    public ZT_RayKimatuVRnDao() {
        super(ZT_RayKimatuVRn.class);
    }

    public ZT_RayKimatuVRn getRayKimatuVRn(Integer pZrnsequenceno) {
        ZT_RayKimatuVRn zT_RayKimatuVRn =  new ZT_RayKimatuVRn();
        zT_RayKimatuVRn.setZrnsequenceno(pZrnsequenceno);
        return this.selectOne(zT_RayKimatuVRn);
    }

    public ExDBResults<ZT_RayKimatuVRn> selectAllZT_RayKimatuVRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_RayKimatuVRn qZT_RayKimatuVRn =  new QZT_RayKimatuVRn();
        jpql.append($SELECT);
        jpql.append(qZT_RayKimatuVRn);
        jpql.append($FROM);
        jpql.append(qZT_RayKimatuVRn.ZT_RayKimatuVRn());
        jpql.append($ORDER_BY(qZT_RayKimatuVRn.zrnsequenceno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_RayKimatuVRn).getResults();
    }
}
