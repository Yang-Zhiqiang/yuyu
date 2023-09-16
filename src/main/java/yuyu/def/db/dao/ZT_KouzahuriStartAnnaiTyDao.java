package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_KouzahuriStartAnnaiTy;
import yuyu.def.db.meta.QZT_KouzahuriStartAnnaiTy;

/**
 * 口座振替開始案内テーブル（中）(ZT_KouzahuriStartAnnaiTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_KouzahuriStartAnnaiTyDao extends AbstractDao<ZT_KouzahuriStartAnnaiTy> {

    public ZT_KouzahuriStartAnnaiTyDao() {
        super(ZT_KouzahuriStartAnnaiTy.class);
    }

    public ZT_KouzahuriStartAnnaiTy getKouzahuriStartAnnaiTy(String pZtytyouhyouymd, String pZtysyono) {
        ZT_KouzahuriStartAnnaiTy zT_KouzahuriStartAnnaiTy =  new ZT_KouzahuriStartAnnaiTy();
        zT_KouzahuriStartAnnaiTy.setZtytyouhyouymd(pZtytyouhyouymd);
        zT_KouzahuriStartAnnaiTy.setZtysyono(pZtysyono);
        return this.selectOne(zT_KouzahuriStartAnnaiTy);
    }

    public ExDBResults<ZT_KouzahuriStartAnnaiTy> selectAllZT_KouzahuriStartAnnaiTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_KouzahuriStartAnnaiTy qZT_KouzahuriStartAnnaiTy =  new QZT_KouzahuriStartAnnaiTy();
        jpql.append($SELECT);
        jpql.append(qZT_KouzahuriStartAnnaiTy);
        jpql.append($FROM);
        jpql.append(qZT_KouzahuriStartAnnaiTy.ZT_KouzahuriStartAnnaiTy());
        jpql.append($ORDER_BY(qZT_KouzahuriStartAnnaiTy.ztytyouhyouymd.asc(), qZT_KouzahuriStartAnnaiTy.ztysyono.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_KouzahuriStartAnnaiTy).getResults();
    }
}
