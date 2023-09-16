package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_SiharaiTyousyoTy;
import yuyu.def.db.meta.QZT_SiharaiTyousyoTy;

/**
 * 支払調書テーブル（中）(ZT_SiharaiTyousyoTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_SiharaiTyousyoTyDao extends AbstractDao<ZT_SiharaiTyousyoTy> {

    public ZT_SiharaiTyousyoTyDao() {
        super(ZT_SiharaiTyousyoTy.class);
    }

    public ZT_SiharaiTyousyoTy getSiharaiTyousyoTy(Integer pZtysequenceno) {
        ZT_SiharaiTyousyoTy zT_SiharaiTyousyoTy =  new ZT_SiharaiTyousyoTy();
        zT_SiharaiTyousyoTy.setZtysequenceno(pZtysequenceno);
        return this.selectOne(zT_SiharaiTyousyoTy);
    }

    public ExDBResults<ZT_SiharaiTyousyoTy> selectAllZT_SiharaiTyousyoTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_SiharaiTyousyoTy qZT_SiharaiTyousyoTy =  new QZT_SiharaiTyousyoTy();
        jpql.append($SELECT);
        jpql.append(qZT_SiharaiTyousyoTy);
        jpql.append($FROM);
        jpql.append(qZT_SiharaiTyousyoTy.ZT_SiharaiTyousyoTy());
        jpql.append($ORDER_BY(qZT_SiharaiTyousyoTy.ztysequenceno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_SiharaiTyousyoTy).getResults();
    }
}
