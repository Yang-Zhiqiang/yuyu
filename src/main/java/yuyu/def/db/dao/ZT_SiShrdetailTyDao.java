package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_SiShrdetailTy;
import yuyu.def.db.meta.QZT_SiShrdetailTy;

/**
 * 保険金給付金支払明細書テーブル（中）(ZT_SiShrdetailTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_SiShrdetailTyDao extends AbstractDao<ZT_SiShrdetailTy> {

    public ZT_SiShrdetailTyDao() {
        super(ZT_SiShrdetailTy.class);
    }

    public ZT_SiShrdetailTy getSiShrdetailTy(String pZtytyouhyouymd, String pZtysyono, String pZtysikibetuno) {
        ZT_SiShrdetailTy zT_SiShrdetailTy =  new ZT_SiShrdetailTy();
        zT_SiShrdetailTy.setZtytyouhyouymd(pZtytyouhyouymd);
        zT_SiShrdetailTy.setZtysyono(pZtysyono);
        zT_SiShrdetailTy.setZtysikibetuno(pZtysikibetuno);
        return this.selectOne(zT_SiShrdetailTy);
    }

    public ExDBResults<ZT_SiShrdetailTy> selectAllZT_SiShrdetailTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_SiShrdetailTy qZT_SiShrdetailTy =  new QZT_SiShrdetailTy();
        jpql.append($SELECT);
        jpql.append(qZT_SiShrdetailTy);
        jpql.append($FROM);
        jpql.append(qZT_SiShrdetailTy.ZT_SiShrdetailTy());
        jpql.append($ORDER_BY(qZT_SiShrdetailTy.ztytyouhyouymd.asc(), qZT_SiShrdetailTy.ztysyono.asc(), qZT_SiShrdetailTy.ztysikibetuno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_SiShrdetailTy).getResults();
    }
}
