package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_RayVKnsyuyuRn;
import yuyu.def.db.meta.QZT_RayVKnsyuyuRn;

/**
 * ＲＡＹＶ検証用Ｆテーブル（連）(ZT_RayVKnsyuyuRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_RayVKnsyuyuRnDao extends AbstractDao<ZT_RayVKnsyuyuRn> {

    public ZT_RayVKnsyuyuRnDao() {
        super(ZT_RayVKnsyuyuRn.class);
    }

    public ZT_RayVKnsyuyuRn getRayVKnsyuyuRn(Integer pZrnsequenceno) {
        ZT_RayVKnsyuyuRn zT_RayVKnsyuyuRn =  new ZT_RayVKnsyuyuRn();
        zT_RayVKnsyuyuRn.setZrnsequenceno(pZrnsequenceno);
        return this.selectOne(zT_RayVKnsyuyuRn);
    }

    public ExDBResults<ZT_RayVKnsyuyuRn> selectAllZT_RayVKnsyuyuRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_RayVKnsyuyuRn qZT_RayVKnsyuyuRn =  new QZT_RayVKnsyuyuRn();
        jpql.append($SELECT);
        jpql.append(qZT_RayVKnsyuyuRn);
        jpql.append($FROM);
        jpql.append(qZT_RayVKnsyuyuRn.ZT_RayVKnsyuyuRn());
        jpql.append($ORDER_BY(qZT_RayVKnsyuyuRn.zrnsequenceno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_RayVKnsyuyuRn).getResults();
    }
}
