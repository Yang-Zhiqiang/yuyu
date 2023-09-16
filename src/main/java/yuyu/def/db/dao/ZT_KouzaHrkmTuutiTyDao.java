package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_KouzaHrkmTuutiTy;
import yuyu.def.db.meta.QZT_KouzaHrkmTuutiTy;

/**
 * 口座振込通知テーブル（中）(ZT_KouzaHrkmTuutiTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_KouzaHrkmTuutiTyDao extends AbstractDao<ZT_KouzaHrkmTuutiTy> {

    public ZT_KouzaHrkmTuutiTyDao() {
        super(ZT_KouzaHrkmTuutiTy.class);
    }

    public ZT_KouzaHrkmTuutiTy getKouzaHrkmTuutiTy(String pZtysyono, String pZtytyouhyouymd, String pZtysikibetuno) {
        ZT_KouzaHrkmTuutiTy zT_KouzaHrkmTuutiTy =  new ZT_KouzaHrkmTuutiTy();
        zT_KouzaHrkmTuutiTy.setZtysyono(pZtysyono);
        zT_KouzaHrkmTuutiTy.setZtytyouhyouymd(pZtytyouhyouymd);
        zT_KouzaHrkmTuutiTy.setZtysikibetuno(pZtysikibetuno);
        return this.selectOne(zT_KouzaHrkmTuutiTy);
    }

    public ExDBResults<ZT_KouzaHrkmTuutiTy> selectAllZT_KouzaHrkmTuutiTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_KouzaHrkmTuutiTy qZT_KouzaHrkmTuutiTy =  new QZT_KouzaHrkmTuutiTy();
        jpql.append($SELECT);
        jpql.append(qZT_KouzaHrkmTuutiTy);
        jpql.append($FROM);
        jpql.append(qZT_KouzaHrkmTuutiTy.ZT_KouzaHrkmTuutiTy());
        jpql.append($ORDER_BY(qZT_KouzaHrkmTuutiTy.ztysyono.asc(), qZT_KouzaHrkmTuutiTy.ztytyouhyouymd.asc(), qZT_KouzaHrkmTuutiTy.ztysikibetuno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_KouzaHrkmTuutiTy).getResults();
    }
}
