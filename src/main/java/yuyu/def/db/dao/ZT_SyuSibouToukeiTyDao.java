package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_SyuSibouToukeiTy;
import yuyu.def.db.meta.QZT_SyuSibouToukeiTy;

/**
 * 主契約死亡統計データテーブル（中）(ZT_SyuSibouToukeiTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_SyuSibouToukeiTyDao extends AbstractDao<ZT_SyuSibouToukeiTy> {

    public ZT_SyuSibouToukeiTyDao() {
        super(ZT_SyuSibouToukeiTy.class);
    }

    public ZT_SyuSibouToukeiTy getSyuSibouToukeiTy(String pZtysyono) {
        ZT_SyuSibouToukeiTy zT_SyuSibouToukeiTy =  new ZT_SyuSibouToukeiTy();
        zT_SyuSibouToukeiTy.setZtysyono(pZtysyono);
        return this.selectOne(zT_SyuSibouToukeiTy);
    }

    public ExDBResults<ZT_SyuSibouToukeiTy> selectAllZT_SyuSibouToukeiTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_SyuSibouToukeiTy qZT_SyuSibouToukeiTy =  new QZT_SyuSibouToukeiTy();
        jpql.append($SELECT);
        jpql.append(qZT_SyuSibouToukeiTy);
        jpql.append($FROM);
        jpql.append(qZT_SyuSibouToukeiTy.ZT_SyuSibouToukeiTy());
        jpql.append($ORDER_BY(qZT_SyuSibouToukeiTy.ztysyono.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_SyuSibouToukeiTy).getResults();
    }
}
