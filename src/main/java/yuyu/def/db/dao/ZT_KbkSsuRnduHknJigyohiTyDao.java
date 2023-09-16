package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_KbkSsuRnduHknJigyohiTy;
import yuyu.def.db.meta.QZT_KbkSsuRnduHknJigyohiTy;

/**
 * 株価指数連動保険事業費Ｆテーブル（中）(ZT_KbkSsuRnduHknJigyohiTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_KbkSsuRnduHknJigyohiTyDao extends AbstractDao<ZT_KbkSsuRnduHknJigyohiTy> {

    public ZT_KbkSsuRnduHknJigyohiTyDao() {
        super(ZT_KbkSsuRnduHknJigyohiTy.class);
    }

    public ZT_KbkSsuRnduHknJigyohiTy getKbkSsuRnduHknJigyohiTy(Integer pZtysequenceno) {
        ZT_KbkSsuRnduHknJigyohiTy zT_KbkSsuRnduHknJigyohiTy =  new ZT_KbkSsuRnduHknJigyohiTy();
        zT_KbkSsuRnduHknJigyohiTy.setZtysequenceno(pZtysequenceno);
        return this.selectOne(zT_KbkSsuRnduHknJigyohiTy);
    }

    public ExDBResults<ZT_KbkSsuRnduHknJigyohiTy> selectAllZT_KbkSsuRnduHknJigyohiTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_KbkSsuRnduHknJigyohiTy qZT_KbkSsuRnduHknJigyohiTy =  new QZT_KbkSsuRnduHknJigyohiTy();
        jpql.append($SELECT);
        jpql.append(qZT_KbkSsuRnduHknJigyohiTy);
        jpql.append($FROM);
        jpql.append(qZT_KbkSsuRnduHknJigyohiTy.ZT_KbkSsuRnduHknJigyohiTy());
        jpql.append($ORDER_BY(qZT_KbkSsuRnduHknJigyohiTy.ztysequenceno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_KbkSsuRnduHknJigyohiTy).getResults();
    }
}
