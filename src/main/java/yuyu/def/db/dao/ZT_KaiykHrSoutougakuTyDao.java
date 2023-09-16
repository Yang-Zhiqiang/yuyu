package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_KaiykHrSoutougakuTy;
import yuyu.def.db.meta.QZT_KaiykHrSoutougakuTy;

/**
 * 解約返戻金相当額Ｆテーブル（中）(ZT_KaiykHrSoutougakuTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_KaiykHrSoutougakuTyDao extends AbstractDao<ZT_KaiykHrSoutougakuTy> {

    public ZT_KaiykHrSoutougakuTyDao() {
        super(ZT_KaiykHrSoutougakuTy.class);
    }

    public ZT_KaiykHrSoutougakuTy getKaiykHrSoutougakuTy(Integer pZtysequenceno) {
        ZT_KaiykHrSoutougakuTy zT_KaiykHrSoutougakuTy =  new ZT_KaiykHrSoutougakuTy();
        zT_KaiykHrSoutougakuTy.setZtysequenceno(pZtysequenceno);
        return this.selectOne(zT_KaiykHrSoutougakuTy);
    }

    public ExDBResults<ZT_KaiykHrSoutougakuTy> selectAllZT_KaiykHrSoutougakuTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_KaiykHrSoutougakuTy qZT_KaiykHrSoutougakuTy =  new QZT_KaiykHrSoutougakuTy();
        jpql.append($SELECT);
        jpql.append(qZT_KaiykHrSoutougakuTy);
        jpql.append($FROM);
        jpql.append(qZT_KaiykHrSoutougakuTy.ZT_KaiykHrSoutougakuTy());
        jpql.append($ORDER_BY(qZT_KaiykHrSoutougakuTy.ztysequenceno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_KaiykHrSoutougakuTy).getResults();
    }
}
