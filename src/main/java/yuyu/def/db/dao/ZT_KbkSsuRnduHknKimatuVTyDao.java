package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_KbkSsuRnduHknKimatuVTy;
import yuyu.def.db.meta.QZT_KbkSsuRnduHknKimatuVTy;

/**
 * 株価指数連動保険期末ＶＦテーブル（中）(ZT_KbkSsuRnduHknKimatuVTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_KbkSsuRnduHknKimatuVTyDao extends AbstractDao<ZT_KbkSsuRnduHknKimatuVTy> {

    public ZT_KbkSsuRnduHknKimatuVTyDao() {
        super(ZT_KbkSsuRnduHknKimatuVTy.class);
    }

    public ZT_KbkSsuRnduHknKimatuVTy getKbkSsuRnduHknKimatuVTy(Integer pZtysequenceno) {
        ZT_KbkSsuRnduHknKimatuVTy zT_KbkSsuRnduHknKimatuVTy =  new ZT_KbkSsuRnduHknKimatuVTy();
        zT_KbkSsuRnduHknKimatuVTy.setZtysequenceno(pZtysequenceno);
        return this.selectOne(zT_KbkSsuRnduHknKimatuVTy);
    }

    public ExDBResults<ZT_KbkSsuRnduHknKimatuVTy> selectAllZT_KbkSsuRnduHknKimatuVTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_KbkSsuRnduHknKimatuVTy qZT_KbkSsuRnduHknKimatuVTy =  new QZT_KbkSsuRnduHknKimatuVTy();
        jpql.append($SELECT);
        jpql.append(qZT_KbkSsuRnduHknKimatuVTy);
        jpql.append($FROM);
        jpql.append(qZT_KbkSsuRnduHknKimatuVTy.ZT_KbkSsuRnduHknKimatuVTy());
        jpql.append($ORDER_BY(qZT_KbkSsuRnduHknKimatuVTy.ztysequenceno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_KbkSsuRnduHknKimatuVTy).getResults();
    }
}
