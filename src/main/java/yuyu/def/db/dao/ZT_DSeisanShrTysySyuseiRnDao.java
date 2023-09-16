package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_DSeisanShrTysySyuseiRn;
import yuyu.def.db.meta.QZT_DSeisanShrTysySyuseiRn;

/**
 * Ｄ精算支払調書修正テーブル（連）(ZT_DSeisanShrTysySyuseiRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_DSeisanShrTysySyuseiRnDao extends AbstractDao<ZT_DSeisanShrTysySyuseiRn> {

    public ZT_DSeisanShrTysySyuseiRnDao() {
        super(ZT_DSeisanShrTysySyuseiRn.class);
    }

    public ZT_DSeisanShrTysySyuseiRn getDSeisanShrTysySyuseiRn(String pZrnsyono) {
        ZT_DSeisanShrTysySyuseiRn zT_DSeisanShrTysySyuseiRn =  new ZT_DSeisanShrTysySyuseiRn();
        zT_DSeisanShrTysySyuseiRn.setZrnsyono(pZrnsyono);
        return this.selectOne(zT_DSeisanShrTysySyuseiRn);
    }

    public ExDBResults<ZT_DSeisanShrTysySyuseiRn> selectAllZT_DSeisanShrTysySyuseiRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_DSeisanShrTysySyuseiRn qZT_DSeisanShrTysySyuseiRn =  new QZT_DSeisanShrTysySyuseiRn();
        jpql.append($SELECT);
        jpql.append(qZT_DSeisanShrTysySyuseiRn);
        jpql.append($FROM);
        jpql.append(qZT_DSeisanShrTysySyuseiRn.ZT_DSeisanShrTysySyuseiRn());
        jpql.append($ORDER_BY(qZT_DSeisanShrTysySyuseiRn.zrnsyono.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_DSeisanShrTysySyuseiRn).getResults();
    }
}
