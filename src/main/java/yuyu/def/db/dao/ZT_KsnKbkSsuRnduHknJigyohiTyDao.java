package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_KsnKbkSsuRnduHknJigyohiTy;
import yuyu.def.db.meta.QZT_KsnKbkSsuRnduHknJigyohiTy;

/**
 * 決算計上用株価指数連動保険事業費Ｆテーブル（中）(ZT_KsnKbkSsuRnduHknJigyohiTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_KsnKbkSsuRnduHknJigyohiTyDao extends AbstractDao<ZT_KsnKbkSsuRnduHknJigyohiTy> {

    public ZT_KsnKbkSsuRnduHknJigyohiTyDao() {
        super(ZT_KsnKbkSsuRnduHknJigyohiTy.class);
    }

    public ZT_KsnKbkSsuRnduHknJigyohiTy getKsnKbkSsuRnduHknJigyohiTy(Integer pZtysequenceno) {
        ZT_KsnKbkSsuRnduHknJigyohiTy zT_KsnKbkSsuRnduHknJigyohiTy =  new ZT_KsnKbkSsuRnduHknJigyohiTy();
        zT_KsnKbkSsuRnduHknJigyohiTy.setZtysequenceno(pZtysequenceno);
        return this.selectOne(zT_KsnKbkSsuRnduHknJigyohiTy);
    }

    public ExDBResults<ZT_KsnKbkSsuRnduHknJigyohiTy> selectAllZT_KsnKbkSsuRnduHknJigyohiTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_KsnKbkSsuRnduHknJigyohiTy qZT_KsnKbkSsuRnduHknJigyohiTy =  new QZT_KsnKbkSsuRnduHknJigyohiTy();
        jpql.append($SELECT);
        jpql.append(qZT_KsnKbkSsuRnduHknJigyohiTy);
        jpql.append($FROM);
        jpql.append(qZT_KsnKbkSsuRnduHknJigyohiTy.ZT_KsnKbkSsuRnduHknJigyohiTy());
        jpql.append($ORDER_BY(qZT_KsnKbkSsuRnduHknJigyohiTy.ztysequenceno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_KsnKbkSsuRnduHknJigyohiTy).getResults();
    }
}
