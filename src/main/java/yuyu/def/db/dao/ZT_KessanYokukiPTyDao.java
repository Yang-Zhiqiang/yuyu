package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_KessanYokukiPTy;
import yuyu.def.db.meta.QZT_KessanYokukiPTy;

/**
 * 決算用翌期Ｐテーブル（中）(ZT_KessanYokukiPTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_KessanYokukiPTyDao extends AbstractDao<ZT_KessanYokukiPTy> {

    public ZT_KessanYokukiPTyDao() {
        super(ZT_KessanYokukiPTy.class);
    }

    public ZT_KessanYokukiPTy getKessanYokukiPTy(String pZtykeijyouym, String pZtysyono) {
        ZT_KessanYokukiPTy zT_KessanYokukiPTy =  new ZT_KessanYokukiPTy();
        zT_KessanYokukiPTy.setZtykeijyouym(pZtykeijyouym);
        zT_KessanYokukiPTy.setZtysyono(pZtysyono);
        return this.selectOne(zT_KessanYokukiPTy);
    }

    public ExDBResults<ZT_KessanYokukiPTy> selectAllZT_KessanYokukiPTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_KessanYokukiPTy qZT_KessanYokukiPTy =  new QZT_KessanYokukiPTy();
        jpql.append($SELECT);
        jpql.append(qZT_KessanYokukiPTy);
        jpql.append($FROM);
        jpql.append(qZT_KessanYokukiPTy.ZT_KessanYokukiPTy());
        jpql.append($ORDER_BY(qZT_KessanYokukiPTy.ztykeijyouym.asc(), qZT_KessanYokukiPTy.ztysyono.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_KessanYokukiPTy).getResults();
    }
}
