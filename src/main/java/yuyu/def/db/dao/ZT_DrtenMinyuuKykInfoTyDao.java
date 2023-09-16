package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_DrtenMinyuuKykInfoTy;
import yuyu.def.db.meta.QZT_DrtenMinyuuKykInfoTy;

/**
 * 代理店未入契約情報Ｆテーブル（中）(ZT_DrtenMinyuuKykInfoTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_DrtenMinyuuKykInfoTyDao extends AbstractDao<ZT_DrtenMinyuuKykInfoTy> {

    public ZT_DrtenMinyuuKykInfoTyDao() {
        super(ZT_DrtenMinyuuKykInfoTy.class);
    }

    public ZT_DrtenMinyuuKykInfoTy getDrtenMinyuuKykInfoTy(String pZtysyono) {
        ZT_DrtenMinyuuKykInfoTy zT_DrtenMinyuuKykInfoTy =  new ZT_DrtenMinyuuKykInfoTy();
        zT_DrtenMinyuuKykInfoTy.setZtysyono(pZtysyono);
        return this.selectOne(zT_DrtenMinyuuKykInfoTy);
    }

    public ExDBResults<ZT_DrtenMinyuuKykInfoTy> selectAllZT_DrtenMinyuuKykInfoTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_DrtenMinyuuKykInfoTy qZT_DrtenMinyuuKykInfoTy =  new QZT_DrtenMinyuuKykInfoTy();
        jpql.append($SELECT);
        jpql.append(qZT_DrtenMinyuuKykInfoTy);
        jpql.append($FROM);
        jpql.append(qZT_DrtenMinyuuKykInfoTy.ZT_DrtenMinyuuKykInfoTy());
        jpql.append($ORDER_BY(qZT_DrtenMinyuuKykInfoTy.ztysyono.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_DrtenMinyuuKykInfoTy).getResults();
    }
}
