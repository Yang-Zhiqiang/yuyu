package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_BosyuuDrtenHoyuuKykTy;
import yuyu.def.db.meta.QZT_BosyuuDrtenHoyuuKykTy;

/**
 * 募集代理店保有契約Ｆテーブル（中）(ZT_BosyuuDrtenHoyuuKykTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_BosyuuDrtenHoyuuKykTyDao extends AbstractDao<ZT_BosyuuDrtenHoyuuKykTy> {

    public ZT_BosyuuDrtenHoyuuKykTyDao() {
        super(ZT_BosyuuDrtenHoyuuKykTy.class);
    }

    public ZT_BosyuuDrtenHoyuuKykTy getBosyuuDrtenHoyuuKykTy(String pZtysyonosyuban) {
        ZT_BosyuuDrtenHoyuuKykTy zT_BosyuuDrtenHoyuuKykTy =  new ZT_BosyuuDrtenHoyuuKykTy();
        zT_BosyuuDrtenHoyuuKykTy.setZtysyonosyuban(pZtysyonosyuban);
        return this.selectOne(zT_BosyuuDrtenHoyuuKykTy);
    }

    public ExDBResults<ZT_BosyuuDrtenHoyuuKykTy> selectAllZT_BosyuuDrtenHoyuuKykTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_BosyuuDrtenHoyuuKykTy qZT_BosyuuDrtenHoyuuKykTy =  new QZT_BosyuuDrtenHoyuuKykTy();
        jpql.append($SELECT);
        jpql.append(qZT_BosyuuDrtenHoyuuKykTy);
        jpql.append($FROM);
        jpql.append(qZT_BosyuuDrtenHoyuuKykTy.ZT_BosyuuDrtenHoyuuKykTy());
        jpql.append($ORDER_BY(qZT_BosyuuDrtenHoyuuKykTy.ztysyonosyuban.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_BosyuuDrtenHoyuuKykTy).getResults();
    }
}
