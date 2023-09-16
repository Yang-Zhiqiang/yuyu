package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_KbkSsuRnduHknIdouVTy;
import yuyu.def.db.meta.QZT_KbkSsuRnduHknIdouVTy;

/**
 * 株価指数連動保険異動ＶＦテーブル（中）(ZT_KbkSsuRnduHknIdouVTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_KbkSsuRnduHknIdouVTyDao extends AbstractDao<ZT_KbkSsuRnduHknIdouVTy> {

    public ZT_KbkSsuRnduHknIdouVTyDao() {
        super(ZT_KbkSsuRnduHknIdouVTy.class);
    }

    public ZT_KbkSsuRnduHknIdouVTy getKbkSsuRnduHknIdouVTy(Integer pZtysequenceno) {
        ZT_KbkSsuRnduHknIdouVTy zT_KbkSsuRnduHknIdouVTy =  new ZT_KbkSsuRnduHknIdouVTy();
        zT_KbkSsuRnduHknIdouVTy.setZtysequenceno(pZtysequenceno);
        return this.selectOne(zT_KbkSsuRnduHknIdouVTy);
    }

    public ExDBResults<ZT_KbkSsuRnduHknIdouVTy> selectAllZT_KbkSsuRnduHknIdouVTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_KbkSsuRnduHknIdouVTy qZT_KbkSsuRnduHknIdouVTy =  new QZT_KbkSsuRnduHknIdouVTy();
        jpql.append($SELECT);
        jpql.append(qZT_KbkSsuRnduHknIdouVTy);
        jpql.append($FROM);
        jpql.append(qZT_KbkSsuRnduHknIdouVTy.ZT_KbkSsuRnduHknIdouVTy());
        jpql.append($ORDER_BY(qZT_KbkSsuRnduHknIdouVTy.ztysequenceno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_KbkSsuRnduHknIdouVTy).getResults();
    }
}
