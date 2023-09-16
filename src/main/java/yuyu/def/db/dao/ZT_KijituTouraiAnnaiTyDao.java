package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_KijituTouraiAnnaiTy;
import yuyu.def.db.meta.QZT_KijituTouraiAnnaiTy;

/**
 * 期日到来案内テーブル（中）(ZT_KijituTouraiAnnaiTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_KijituTouraiAnnaiTyDao extends AbstractDao<ZT_KijituTouraiAnnaiTy> {

    public ZT_KijituTouraiAnnaiTyDao() {
        super(ZT_KijituTouraiAnnaiTy.class);
    }

    public ZT_KijituTouraiAnnaiTy getKijituTouraiAnnaiTy(String pZtytyouhyouymd, String pZtysyono) {
        ZT_KijituTouraiAnnaiTy zT_KijituTouraiAnnaiTy =  new ZT_KijituTouraiAnnaiTy();
        zT_KijituTouraiAnnaiTy.setZtytyouhyouymd(pZtytyouhyouymd);
        zT_KijituTouraiAnnaiTy.setZtysyono(pZtysyono);
        return this.selectOne(zT_KijituTouraiAnnaiTy);
    }

    public ExDBResults<ZT_KijituTouraiAnnaiTy> selectAllZT_KijituTouraiAnnaiTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_KijituTouraiAnnaiTy qZT_KijituTouraiAnnaiTy =  new QZT_KijituTouraiAnnaiTy();
        jpql.append($SELECT);
        jpql.append(qZT_KijituTouraiAnnaiTy);
        jpql.append($FROM);
        jpql.append(qZT_KijituTouraiAnnaiTy.ZT_KijituTouraiAnnaiTy());
        jpql.append($ORDER_BY(qZT_KijituTouraiAnnaiTy.ztytyouhyouymd.asc(), qZT_KijituTouraiAnnaiTy.ztysyono.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_KijituTouraiAnnaiTy).getResults();
    }
}
