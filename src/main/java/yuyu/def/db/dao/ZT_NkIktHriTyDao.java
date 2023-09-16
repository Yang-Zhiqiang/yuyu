package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_NkIktHriTy;
import yuyu.def.db.meta.QZT_NkIktHriTy;

/**
 * 年金一括払テーブル（中）(ZT_NkIktHriTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_NkIktHriTyDao extends AbstractDao<ZT_NkIktHriTy> {

    public ZT_NkIktHriTyDao() {
        super(ZT_NkIktHriTy.class);
    }

    public ZT_NkIktHriTy getNkIktHriTy(String pZtydatakanrino) {
        ZT_NkIktHriTy zT_NkIktHriTy =  new ZT_NkIktHriTy();
        zT_NkIktHriTy.setZtydatakanrino(pZtydatakanrino);
        return this.selectOne(zT_NkIktHriTy);
    }

    public ExDBResults<ZT_NkIktHriTy> selectAllZT_NkIktHriTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_NkIktHriTy qZT_NkIktHriTy =  new QZT_NkIktHriTy();
        jpql.append($SELECT);
        jpql.append(qZT_NkIktHriTy);
        jpql.append($FROM);
        jpql.append(qZT_NkIktHriTy.ZT_NkIktHriTy());
        jpql.append($ORDER_BY(qZT_NkIktHriTy.ztydatakanrino.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_NkIktHriTy).getResults();
    }
}
