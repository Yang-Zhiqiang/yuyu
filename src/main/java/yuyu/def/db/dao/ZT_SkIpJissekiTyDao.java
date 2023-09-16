package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_SkIpJissekiTy;
import yuyu.def.db.meta.QZT_SkIpJissekiTy;

/**
 * 新契約インプット実績Ｆテーブル（中）(ZT_SkIpJissekiTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_SkIpJissekiTyDao extends AbstractDao<ZT_SkIpJissekiTy> {

    public ZT_SkIpJissekiTyDao() {
        super(ZT_SkIpJissekiTy.class);
    }

    public ZT_SkIpJissekiTy getSkIpJissekiTy(Integer pZtysequenceno) {
        ZT_SkIpJissekiTy zT_SkIpJissekiTy =  new ZT_SkIpJissekiTy();
        zT_SkIpJissekiTy.setZtysequenceno(pZtysequenceno);
        return this.selectOne(zT_SkIpJissekiTy);
    }

    public ExDBResults<ZT_SkIpJissekiTy> selectAllZT_SkIpJissekiTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_SkIpJissekiTy qZT_SkIpJissekiTy =  new QZT_SkIpJissekiTy();
        jpql.append($SELECT);
        jpql.append(qZT_SkIpJissekiTy);
        jpql.append($FROM);
        jpql.append(qZT_SkIpJissekiTy.ZT_SkIpJissekiTy());
        jpql.append($ORDER_BY(qZT_SkIpJissekiTy.ztysequenceno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_SkIpJissekiTy).getResults();
    }
}
