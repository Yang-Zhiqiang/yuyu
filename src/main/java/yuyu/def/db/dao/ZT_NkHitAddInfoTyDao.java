package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_NkHitAddInfoTy;
import yuyu.def.db.meta.QZT_NkHitAddInfoTy;

/**
 * 年金配当所要額追加情報反映テーブル（中）(ZT_NkHitAddInfoTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_NkHitAddInfoTyDao extends AbstractDao<ZT_NkHitAddInfoTy> {

    public ZT_NkHitAddInfoTyDao() {
        super(ZT_NkHitAddInfoTy.class);
    }

    public ZT_NkHitAddInfoTy getNkHitAddInfoTy(String pZtynksyousyono) {
        ZT_NkHitAddInfoTy zT_NkHitAddInfoTy =  new ZT_NkHitAddInfoTy();
        zT_NkHitAddInfoTy.setZtynksyousyono(pZtynksyousyono);
        return this.selectOne(zT_NkHitAddInfoTy);
    }

    public ExDBResults<ZT_NkHitAddInfoTy> selectAllZT_NkHitAddInfoTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_NkHitAddInfoTy qZT_NkHitAddInfoTy =  new QZT_NkHitAddInfoTy();
        jpql.append($SELECT);
        jpql.append(qZT_NkHitAddInfoTy);
        jpql.append($FROM);
        jpql.append(qZT_NkHitAddInfoTy.ZT_NkHitAddInfoTy());
        jpql.append($ORDER_BY(qZT_NkHitAddInfoTy.ztynksyousyono.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_NkHitAddInfoTy).getResults();
    }
}
