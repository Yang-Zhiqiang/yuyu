package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_SbRituToukeiSeibiRenRn;
import yuyu.def.db.meta.QZT_SbRituToukeiSeibiRenRn;

/**
 * 死亡率統計整備後連動Ｆテーブル（連）(ZT_SbRituToukeiSeibiRenRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_SbRituToukeiSeibiRenRnDao extends AbstractDao<ZT_SbRituToukeiSeibiRenRn> {

    public ZT_SbRituToukeiSeibiRenRnDao() {
        super(ZT_SbRituToukeiSeibiRenRn.class);
    }

    public ZT_SbRituToukeiSeibiRenRn getSbRituToukeiSeibiRenRn(Integer pZrnsequenceno) {
        ZT_SbRituToukeiSeibiRenRn zT_SbRituToukeiSeibiRenRn =  new ZT_SbRituToukeiSeibiRenRn();
        zT_SbRituToukeiSeibiRenRn.setZrnsequenceno(pZrnsequenceno);
        return this.selectOne(zT_SbRituToukeiSeibiRenRn);
    }

    public ExDBResults<ZT_SbRituToukeiSeibiRenRn> selectAllZT_SbRituToukeiSeibiRenRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_SbRituToukeiSeibiRenRn qZT_SbRituToukeiSeibiRenRn =  new QZT_SbRituToukeiSeibiRenRn();
        jpql.append($SELECT);
        jpql.append(qZT_SbRituToukeiSeibiRenRn);
        jpql.append($FROM);
        jpql.append(qZT_SbRituToukeiSeibiRenRn.ZT_SbRituToukeiSeibiRenRn());
        jpql.append($ORDER_BY(qZT_SbRituToukeiSeibiRenRn.zrnsequenceno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_SbRituToukeiSeibiRenRn).getResults();
    }
}
