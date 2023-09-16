package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_TtdkKanTy;
import yuyu.def.db.meta.QZT_TtdkKanTy;

/**
 * 手続完了Ｆテーブル（中）(ZT_TtdkKanTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_TtdkKanTyDao extends AbstractDao<ZT_TtdkKanTy> {

    public ZT_TtdkKanTyDao() {
        super(ZT_TtdkKanTy.class);
    }

    public ZT_TtdkKanTy getTtdkKanTy(String pZtytyouhyouymd, String pZtysyono, String pZtysikibetuno) {
        ZT_TtdkKanTy zT_TtdkKanTy =  new ZT_TtdkKanTy();
        zT_TtdkKanTy.setZtytyouhyouymd(pZtytyouhyouymd);
        zT_TtdkKanTy.setZtysyono(pZtysyono);
        zT_TtdkKanTy.setZtysikibetuno(pZtysikibetuno);
        return this.selectOne(zT_TtdkKanTy);
    }

    public ExDBResults<ZT_TtdkKanTy> selectAllZT_TtdkKanTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_TtdkKanTy qZT_TtdkKanTy =  new QZT_TtdkKanTy();
        jpql.append($SELECT);
        jpql.append(qZT_TtdkKanTy);
        jpql.append($FROM);
        jpql.append(qZT_TtdkKanTy.ZT_TtdkKanTy());
        jpql.append($ORDER_BY(qZT_TtdkKanTy.ztytyouhyouymd.asc(), qZT_TtdkKanTy.ztysyono.asc(), qZT_TtdkKanTy.ztysikibetuno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_TtdkKanTy).getResults();
    }
}
