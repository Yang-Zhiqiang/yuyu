package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_SinBosyuuDrtenHoyuuKykTy;
import yuyu.def.db.meta.QZT_SinBosyuuDrtenHoyuuKykTy;

/**
 * 代理店月次契約情報Ｆテーブル（中）(ZT_SinBosyuuDrtenHoyuuKykTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_SinBosyuuDrtenHoyuuKykTyDao extends AbstractDao<ZT_SinBosyuuDrtenHoyuuKykTy> {

    public ZT_SinBosyuuDrtenHoyuuKykTyDao() {
        super(ZT_SinBosyuuDrtenHoyuuKykTy.class);
    }

    public ZT_SinBosyuuDrtenHoyuuKykTy getSinBosyuuDrtenHoyuuKykTy(String pZtysyono) {
        ZT_SinBosyuuDrtenHoyuuKykTy zT_SinBosyuuDrtenHoyuuKykTy =  new ZT_SinBosyuuDrtenHoyuuKykTy();
        zT_SinBosyuuDrtenHoyuuKykTy.setZtysyono(pZtysyono);
        return this.selectOne(zT_SinBosyuuDrtenHoyuuKykTy);
    }

    public ExDBResults<ZT_SinBosyuuDrtenHoyuuKykTy> selectAllZT_SinBosyuuDrtenHoyuuKykTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_SinBosyuuDrtenHoyuuKykTy qZT_SinBosyuuDrtenHoyuuKykTy =  new QZT_SinBosyuuDrtenHoyuuKykTy();
        jpql.append($SELECT);
        jpql.append(qZT_SinBosyuuDrtenHoyuuKykTy);
        jpql.append($FROM);
        jpql.append(qZT_SinBosyuuDrtenHoyuuKykTy.ZT_SinBosyuuDrtenHoyuuKykTy());
        jpql.append($ORDER_BY(qZT_SinBosyuuDrtenHoyuuKykTy.ztysyono.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_SinBosyuuDrtenHoyuuKykTy).getResults();
    }
}
