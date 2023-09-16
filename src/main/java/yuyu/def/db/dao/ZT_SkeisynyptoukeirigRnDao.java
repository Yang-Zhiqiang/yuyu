package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_SkeisynyptoukeirigRn;
import yuyu.def.db.meta.QZT_SkeisynyptoukeirigRn;

/**
 * 新契約収入Ｐ統計例月Ｆテーブル（連）(ZT_SkeisynyptoukeirigRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_SkeisynyptoukeirigRnDao extends AbstractDao<ZT_SkeisynyptoukeirigRn> {

    public ZT_SkeisynyptoukeirigRnDao() {
        super(ZT_SkeisynyptoukeirigRn.class);
    }

    public ZT_SkeisynyptoukeirigRn getSkeisynyptoukeirigRn(Integer pZrnsequenceno) {
        ZT_SkeisynyptoukeirigRn zT_SkeisynyptoukeirigRn =  new ZT_SkeisynyptoukeirigRn();
        zT_SkeisynyptoukeirigRn.setZrnsequenceno(pZrnsequenceno);
        return this.selectOne(zT_SkeisynyptoukeirigRn);
    }

    public ExDBResults<ZT_SkeisynyptoukeirigRn> selectAllZT_SkeisynyptoukeirigRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_SkeisynyptoukeirigRn qZT_SkeisynyptoukeirigRn =  new QZT_SkeisynyptoukeirigRn();
        jpql.append($SELECT);
        jpql.append(qZT_SkeisynyptoukeirigRn);
        jpql.append($FROM);
        jpql.append(qZT_SkeisynyptoukeirigRn.ZT_SkeisynyptoukeirigRn());
        jpql.append($ORDER_BY(qZT_SkeisynyptoukeirigRn.zrnsequenceno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_SkeisynyptoukeirigRn).getResults();
    }
}
