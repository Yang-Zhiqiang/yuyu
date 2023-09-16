package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_SyainMeiboTy;
import yuyu.def.db.meta.QZT_SyainMeiboTy;

/**
 * 社員名簿Ｆテーブル（中）(ZT_SyainMeiboTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_SyainMeiboTyDao extends AbstractDao<ZT_SyainMeiboTy> {

    public ZT_SyainMeiboTyDao() {
        super(ZT_SyainMeiboTy.class);
    }

    public ZT_SyainMeiboTy getSyainMeiboTy(String pZtysyono) {
        ZT_SyainMeiboTy zT_SyainMeiboTy =  new ZT_SyainMeiboTy();
        zT_SyainMeiboTy.setZtysyono(pZtysyono);
        return this.selectOne(zT_SyainMeiboTy);
    }

    public ExDBResults<ZT_SyainMeiboTy> selectAllZT_SyainMeiboTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_SyainMeiboTy qZT_SyainMeiboTy =  new QZT_SyainMeiboTy();
        jpql.append($SELECT);
        jpql.append(qZT_SyainMeiboTy);
        jpql.append($FROM);
        jpql.append(qZT_SyainMeiboTy.ZT_SyainMeiboTy());
        jpql.append($ORDER_BY(qZT_SyainMeiboTy.ztysyono.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_SyainMeiboTy).getResults();
    }
}
