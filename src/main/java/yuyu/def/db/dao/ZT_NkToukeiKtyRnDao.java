package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_NkToukeiKtyRn;
import yuyu.def.db.meta.QZT_NkToukeiKtyRn;

/**
 * 年金統計Ｆ期中報告用テーブル（連）(ZT_NkToukeiKtyRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_NkToukeiKtyRnDao extends AbstractDao<ZT_NkToukeiKtyRn> {

    public ZT_NkToukeiKtyRnDao() {
        super(ZT_NkToukeiKtyRn.class);
    }

    public ZT_NkToukeiKtyRn getNkToukeiKtyRn(Integer pZrnsequenceno) {
        ZT_NkToukeiKtyRn zT_NkToukeiKtyRn =  new ZT_NkToukeiKtyRn();
        zT_NkToukeiKtyRn.setZrnsequenceno(pZrnsequenceno);
        return this.selectOne(zT_NkToukeiKtyRn);
    }

    public ExDBResults<ZT_NkToukeiKtyRn> selectAllZT_NkToukeiKtyRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_NkToukeiKtyRn qZT_NkToukeiKtyRn =  new QZT_NkToukeiKtyRn();
        jpql.append($SELECT);
        jpql.append(qZT_NkToukeiKtyRn);
        jpql.append($FROM);
        jpql.append(qZT_NkToukeiKtyRn.ZT_NkToukeiKtyRn());
        jpql.append($ORDER_BY(qZT_NkToukeiKtyRn.zrnsequenceno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_NkToukeiKtyRn).getResults();
    }
}
