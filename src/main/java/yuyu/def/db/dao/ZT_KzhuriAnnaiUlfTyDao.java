package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_KzhuriAnnaiUlfTy;
import yuyu.def.db.meta.QZT_KzhuriAnnaiUlfTy;

/**
 * 口座振替案内ＵＬＦテーブル（中）(ZT_KzhuriAnnaiUlfTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_KzhuriAnnaiUlfTyDao extends AbstractDao<ZT_KzhuriAnnaiUlfTy> {

    public ZT_KzhuriAnnaiUlfTyDao() {
        super(ZT_KzhuriAnnaiUlfTy.class);
    }

    public ZT_KzhuriAnnaiUlfTy getKzhuriAnnaiUlfTy(String pZtysyono, String pZtyjyuutouym) {
        ZT_KzhuriAnnaiUlfTy zT_KzhuriAnnaiUlfTy =  new ZT_KzhuriAnnaiUlfTy();
        zT_KzhuriAnnaiUlfTy.setZtysyono(pZtysyono);
        zT_KzhuriAnnaiUlfTy.setZtyjyuutouym(pZtyjyuutouym);
        return this.selectOne(zT_KzhuriAnnaiUlfTy);
    }

    public ExDBResults<ZT_KzhuriAnnaiUlfTy> selectAllZT_KzhuriAnnaiUlfTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_KzhuriAnnaiUlfTy qZT_KzhuriAnnaiUlfTy =  new QZT_KzhuriAnnaiUlfTy();
        jpql.append($SELECT);
        jpql.append(qZT_KzhuriAnnaiUlfTy);
        jpql.append($FROM);
        jpql.append(qZT_KzhuriAnnaiUlfTy.ZT_KzhuriAnnaiUlfTy());
        jpql.append($ORDER_BY(qZT_KzhuriAnnaiUlfTy.ztysyono.asc(), qZT_KzhuriAnnaiUlfTy.ztyjyuutouym.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_KzhuriAnnaiUlfTy).getResults();
    }
}
