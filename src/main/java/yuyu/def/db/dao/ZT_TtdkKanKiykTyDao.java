package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_TtdkKanKiykTy;
import yuyu.def.db.meta.QZT_TtdkKanKiykTy;

/**
 * 手続完了（解約）Ｆテーブル（中）(ZT_TtdkKanKiykTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_TtdkKanKiykTyDao extends AbstractDao<ZT_TtdkKanKiykTy> {

    public ZT_TtdkKanKiykTyDao() {
        super(ZT_TtdkKanKiykTy.class);
    }

    public ZT_TtdkKanKiykTy getTtdkKanKiykTy(String pZtytyouhyouymd, String pZtysyono, String pZtysikibetuno) {
        ZT_TtdkKanKiykTy zT_TtdkKanKiykTy =  new ZT_TtdkKanKiykTy();
        zT_TtdkKanKiykTy.setZtytyouhyouymd(pZtytyouhyouymd);
        zT_TtdkKanKiykTy.setZtysyono(pZtysyono);
        zT_TtdkKanKiykTy.setZtysikibetuno(pZtysikibetuno);
        return this.selectOne(zT_TtdkKanKiykTy);
    }

    public ExDBResults<ZT_TtdkKanKiykTy> selectAllZT_TtdkKanKiykTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_TtdkKanKiykTy qZT_TtdkKanKiykTy =  new QZT_TtdkKanKiykTy();
        jpql.append($SELECT);
        jpql.append(qZT_TtdkKanKiykTy);
        jpql.append($FROM);
        jpql.append(qZT_TtdkKanKiykTy.ZT_TtdkKanKiykTy());
        jpql.append($ORDER_BY(qZT_TtdkKanKiykTy.ztytyouhyouymd.asc(), qZT_TtdkKanKiykTy.ztysyono.asc(), qZT_TtdkKanKiykTy.ztysikibetuno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_TtdkKanKiykTy).getResults();
    }
}
