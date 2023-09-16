package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_KouzaHnknTuutiTy;
import yuyu.def.db.meta.QZT_KouzaHnknTuutiTy;

/**
 * 口座返金通知テーブル（中）(ZT_KouzaHnknTuutiTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_KouzaHnknTuutiTyDao extends AbstractDao<ZT_KouzaHnknTuutiTy> {

    public ZT_KouzaHnknTuutiTyDao() {
        super(ZT_KouzaHnknTuutiTy.class);
    }

    public ZT_KouzaHnknTuutiTy getKouzaHnknTuutiTy(String pZtysyono, String pZtytyouhyouymd, String pZtysikibetuno) {
        ZT_KouzaHnknTuutiTy zT_KouzaHnknTuutiTy =  new ZT_KouzaHnknTuutiTy();
        zT_KouzaHnknTuutiTy.setZtysyono(pZtysyono);
        zT_KouzaHnknTuutiTy.setZtytyouhyouymd(pZtytyouhyouymd);
        zT_KouzaHnknTuutiTy.setZtysikibetuno(pZtysikibetuno);
        return this.selectOne(zT_KouzaHnknTuutiTy);
    }

    public ExDBResults<ZT_KouzaHnknTuutiTy> selectAllZT_KouzaHnknTuutiTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_KouzaHnknTuutiTy qZT_KouzaHnknTuutiTy =  new QZT_KouzaHnknTuutiTy();
        jpql.append($SELECT);
        jpql.append(qZT_KouzaHnknTuutiTy);
        jpql.append($FROM);
        jpql.append(qZT_KouzaHnknTuutiTy.ZT_KouzaHnknTuutiTy());
        jpql.append($ORDER_BY(qZT_KouzaHnknTuutiTy.ztysyono.asc(), qZT_KouzaHnknTuutiTy.ztytyouhyouymd.asc(), qZT_KouzaHnknTuutiTy.ztysikibetuno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_KouzaHnknTuutiTy).getResults();
    }
}
