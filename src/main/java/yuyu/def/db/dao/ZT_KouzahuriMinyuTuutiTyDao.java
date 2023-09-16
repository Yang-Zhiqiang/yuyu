package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_KouzahuriMinyuTuutiTy;
import yuyu.def.db.meta.QZT_KouzahuriMinyuTuutiTy;

/**
 * 口座振替未入通知テーブル（中）(ZT_KouzahuriMinyuTuutiTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_KouzahuriMinyuTuutiTyDao extends AbstractDao<ZT_KouzahuriMinyuTuutiTy> {

    public ZT_KouzahuriMinyuTuutiTyDao() {
        super(ZT_KouzahuriMinyuTuutiTy.class);
    }

    public ZT_KouzahuriMinyuTuutiTy getKouzahuriMinyuTuutiTy(String pZtytyouhyouymd, String pZtysyono) {
        ZT_KouzahuriMinyuTuutiTy zT_KouzahuriMinyuTuutiTy =  new ZT_KouzahuriMinyuTuutiTy();
        zT_KouzahuriMinyuTuutiTy.setZtytyouhyouymd(pZtytyouhyouymd);
        zT_KouzahuriMinyuTuutiTy.setZtysyono(pZtysyono);
        return this.selectOne(zT_KouzahuriMinyuTuutiTy);
    }

    public ExDBResults<ZT_KouzahuriMinyuTuutiTy> selectAllZT_KouzahuriMinyuTuutiTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_KouzahuriMinyuTuutiTy qZT_KouzahuriMinyuTuutiTy =  new QZT_KouzahuriMinyuTuutiTy();
        jpql.append($SELECT);
        jpql.append(qZT_KouzahuriMinyuTuutiTy);
        jpql.append($FROM);
        jpql.append(qZT_KouzahuriMinyuTuutiTy.ZT_KouzahuriMinyuTuutiTy());
        jpql.append($ORDER_BY(qZT_KouzahuriMinyuTuutiTy.ztytyouhyouymd.asc(), qZT_KouzahuriMinyuTuutiTy.ztysyono.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_KouzahuriMinyuTuutiTy).getResults();
    }
}
