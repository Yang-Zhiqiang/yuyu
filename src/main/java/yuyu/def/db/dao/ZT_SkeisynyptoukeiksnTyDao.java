package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_SkeisynyptoukeiksnTy;
import yuyu.def.db.meta.QZT_SkeisynyptoukeiksnTy;

/**
 * 新契約収入Ｐ統計決算Ｆテーブル（中）(ZT_SkeisynyptoukeiksnTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_SkeisynyptoukeiksnTyDao extends AbstractDao<ZT_SkeisynyptoukeiksnTy> {

    public ZT_SkeisynyptoukeiksnTyDao() {
        super(ZT_SkeisynyptoukeiksnTy.class);
    }

    public ZT_SkeisynyptoukeiksnTy getSkeisynyptoukeiksnTy(Integer pZtysequenceno) {
        ZT_SkeisynyptoukeiksnTy zT_SkeisynyptoukeiksnTy =  new ZT_SkeisynyptoukeiksnTy();
        zT_SkeisynyptoukeiksnTy.setZtysequenceno(pZtysequenceno);
        return this.selectOne(zT_SkeisynyptoukeiksnTy);
    }

    public ExDBResults<ZT_SkeisynyptoukeiksnTy> selectAllZT_SkeisynyptoukeiksnTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_SkeisynyptoukeiksnTy qZT_SkeisynyptoukeiksnTy =  new QZT_SkeisynyptoukeiksnTy();
        jpql.append($SELECT);
        jpql.append(qZT_SkeisynyptoukeiksnTy);
        jpql.append($FROM);
        jpql.append(qZT_SkeisynyptoukeiksnTy.ZT_SkeisynyptoukeiksnTy());
        jpql.append($ORDER_BY(qZT_SkeisynyptoukeiksnTy.ztysequenceno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_SkeisynyptoukeiksnTy).getResults();
    }
}
