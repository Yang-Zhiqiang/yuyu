package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_AlmNnknHyuTy;
import yuyu.def.db.meta.QZT_AlmNnknHyuTy;

/**
 * ＡＬＭ用年金保有明細テーブル（中）(ZT_AlmNnknHyuTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_AlmNnknHyuTyDao extends AbstractDao<ZT_AlmNnknHyuTy> {

    public ZT_AlmNnknHyuTyDao() {
        super(ZT_AlmNnknHyuTy.class);
    }

    public ZT_AlmNnknHyuTy getAlmNnknHyuTy(String pZtynksyousyono) {
        ZT_AlmNnknHyuTy zT_AlmNnknHyuTy =  new ZT_AlmNnknHyuTy();
        zT_AlmNnknHyuTy.setZtynksyousyono(pZtynksyousyono);
        return this.selectOne(zT_AlmNnknHyuTy);
    }

    public ExDBResults<ZT_AlmNnknHyuTy> selectAllZT_AlmNnknHyuTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_AlmNnknHyuTy qZT_AlmNnknHyuTy =  new QZT_AlmNnknHyuTy();
        jpql.append($SELECT);
        jpql.append(qZT_AlmNnknHyuTy);
        jpql.append($FROM);
        jpql.append(qZT_AlmNnknHyuTy.ZT_AlmNnknHyuTy());
        jpql.append($ORDER_BY(qZT_AlmNnknHyuTy.ztynksyousyono.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_AlmNnknHyuTy).getResults();
    }
}
