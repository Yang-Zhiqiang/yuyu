package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_OuNnknShrRn;
import yuyu.def.db.meta.QZT_OuNnknShrRn;

/**
 * ＯＵ用年金支払テーブル（連）(ZT_OuNnknShrRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_OuNnknShrRnDao extends AbstractDao<ZT_OuNnknShrRn> {

    public ZT_OuNnknShrRnDao() {
        super(ZT_OuNnknShrRn.class);
    }

    public ZT_OuNnknShrRn getOuNnknShrRn(Integer pZrnsequenceno) {
        ZT_OuNnknShrRn zT_OuNnknShrRn =  new ZT_OuNnknShrRn();
        zT_OuNnknShrRn.setZrnsequenceno(pZrnsequenceno);
        return this.selectOne(zT_OuNnknShrRn);
    }

    public ExDBResults<ZT_OuNnknShrRn> selectAllZT_OuNnknShrRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_OuNnknShrRn qZT_OuNnknShrRn =  new QZT_OuNnknShrRn();
        jpql.append($SELECT);
        jpql.append(qZT_OuNnknShrRn);
        jpql.append($FROM);
        jpql.append(qZT_OuNnknShrRn.ZT_OuNnknShrRn());
        jpql.append($ORDER_BY(qZT_OuNnknShrRn.zrnsequenceno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_OuNnknShrRn).getResults();
    }
}
