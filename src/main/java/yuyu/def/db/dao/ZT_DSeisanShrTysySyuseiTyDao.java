package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_DSeisanShrTysySyuseiTy;
import yuyu.def.db.meta.QZT_DSeisanShrTysySyuseiTy;

/**
 * Ｄ精算支払調書修正テーブル（中）(ZT_DSeisanShrTysySyuseiTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_DSeisanShrTysySyuseiTyDao extends AbstractDao<ZT_DSeisanShrTysySyuseiTy> {

    public ZT_DSeisanShrTysySyuseiTyDao() {
        super(ZT_DSeisanShrTysySyuseiTy.class);
    }

    public ZT_DSeisanShrTysySyuseiTy getDSeisanShrTysySyuseiTy(String pZtysyono) {
        ZT_DSeisanShrTysySyuseiTy zT_DSeisanShrTysySyuseiTy =  new ZT_DSeisanShrTysySyuseiTy();
        zT_DSeisanShrTysySyuseiTy.setZtysyono(pZtysyono);
        return this.selectOne(zT_DSeisanShrTysySyuseiTy);
    }

    public ExDBResults<ZT_DSeisanShrTysySyuseiTy> selectAllZT_DSeisanShrTysySyuseiTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_DSeisanShrTysySyuseiTy qZT_DSeisanShrTysySyuseiTy =  new QZT_DSeisanShrTysySyuseiTy();
        jpql.append($SELECT);
        jpql.append(qZT_DSeisanShrTysySyuseiTy);
        jpql.append($FROM);
        jpql.append(qZT_DSeisanShrTysySyuseiTy.ZT_DSeisanShrTysySyuseiTy());
        jpql.append($ORDER_BY(qZT_DSeisanShrTysySyuseiTy.ztysyono.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_DSeisanShrTysySyuseiTy).getResults();
    }
}
