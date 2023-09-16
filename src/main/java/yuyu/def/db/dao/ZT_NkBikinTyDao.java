package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_NkBikinTy;
import yuyu.def.db.meta.QZT_NkBikinTy;

/**
 * 年金備金テーブル（中）(ZT_NkBikinTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_NkBikinTyDao extends AbstractDao<ZT_NkBikinTy> {

    public ZT_NkBikinTyDao() {
        super(ZT_NkBikinTy.class);
    }

    public ZT_NkBikinTy getNkBikinTy(String pZtynksyousyono, String pZtyshiharaihasseiymd) {
        ZT_NkBikinTy zT_NkBikinTy =  new ZT_NkBikinTy();
        zT_NkBikinTy.setZtynksyousyono(pZtynksyousyono);
        zT_NkBikinTy.setZtyshiharaihasseiymd(pZtyshiharaihasseiymd);
        return this.selectOne(zT_NkBikinTy);
    }

    public ExDBResults<ZT_NkBikinTy> selectAllZT_NkBikinTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_NkBikinTy qZT_NkBikinTy =  new QZT_NkBikinTy();
        jpql.append($SELECT);
        jpql.append(qZT_NkBikinTy);
        jpql.append($FROM);
        jpql.append(qZT_NkBikinTy.ZT_NkBikinTy());
        jpql.append($ORDER_BY(qZT_NkBikinTy.ztynksyousyono.asc(), qZT_NkBikinTy.ztyshiharaihasseiymd.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_NkBikinTy).getResults();
    }
}
