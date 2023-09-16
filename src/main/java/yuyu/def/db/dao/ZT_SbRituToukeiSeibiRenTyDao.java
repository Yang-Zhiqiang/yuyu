package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_SbRituToukeiSeibiRenTy;
import yuyu.def.db.meta.QZT_SbRituToukeiSeibiRenTy;

/**
 * 死亡率統計整備後連動Ｆテーブル（中）(ZT_SbRituToukeiSeibiRenTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_SbRituToukeiSeibiRenTyDao extends AbstractDao<ZT_SbRituToukeiSeibiRenTy> {

    public ZT_SbRituToukeiSeibiRenTyDao() {
        super(ZT_SbRituToukeiSeibiRenTy.class);
    }

    public ZT_SbRituToukeiSeibiRenTy getSbRituToukeiSeibiRenTy(Integer pZtysequenceno) {
        ZT_SbRituToukeiSeibiRenTy zT_SbRituToukeiSeibiRenTy =  new ZT_SbRituToukeiSeibiRenTy();
        zT_SbRituToukeiSeibiRenTy.setZtysequenceno(pZtysequenceno);
        return this.selectOne(zT_SbRituToukeiSeibiRenTy);
    }

    public ExDBResults<ZT_SbRituToukeiSeibiRenTy> selectAllZT_SbRituToukeiSeibiRenTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_SbRituToukeiSeibiRenTy qZT_SbRituToukeiSeibiRenTy =  new QZT_SbRituToukeiSeibiRenTy();
        jpql.append($SELECT);
        jpql.append(qZT_SbRituToukeiSeibiRenTy);
        jpql.append($FROM);
        jpql.append(qZT_SbRituToukeiSeibiRenTy.ZT_SbRituToukeiSeibiRenTy());
        jpql.append($ORDER_BY(qZT_SbRituToukeiSeibiRenTy.ztysequenceno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_SbRituToukeiSeibiRenTy).getResults();
    }
}
