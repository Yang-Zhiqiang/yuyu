package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_KokyakuYuyuKykmeisaiFTy;
import yuyu.def.db.meta.QZT_KokyakuYuyuKykmeisaiFTy;

/**
 * 顧客用ゆうゆう契約明細Ｆテーブル（中）(ZT_KokyakuYuyuKykmeisaiFTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_KokyakuYuyuKykmeisaiFTyDao extends AbstractDao<ZT_KokyakuYuyuKykmeisaiFTy> {

    public ZT_KokyakuYuyuKykmeisaiFTyDao() {
        super(ZT_KokyakuYuyuKykmeisaiFTy.class);
    }

    public ZT_KokyakuYuyuKykmeisaiFTy getKokyakuYuyuKykmeisaiFTy(Integer pZtysequenceno) {
        ZT_KokyakuYuyuKykmeisaiFTy zT_KokyakuYuyuKykmeisaiFTy =  new ZT_KokyakuYuyuKykmeisaiFTy();
        zT_KokyakuYuyuKykmeisaiFTy.setZtysequenceno(pZtysequenceno);
        return this.selectOne(zT_KokyakuYuyuKykmeisaiFTy);
    }

    public ExDBResults<ZT_KokyakuYuyuKykmeisaiFTy> selectAllZT_KokyakuYuyuKykmeisaiFTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_KokyakuYuyuKykmeisaiFTy qZT_KokyakuYuyuKykmeisaiFTy =  new QZT_KokyakuYuyuKykmeisaiFTy();
        jpql.append($SELECT);
        jpql.append(qZT_KokyakuYuyuKykmeisaiFTy);
        jpql.append($FROM);
        jpql.append(qZT_KokyakuYuyuKykmeisaiFTy.ZT_KokyakuYuyuKykmeisaiFTy());
        jpql.append($ORDER_BY(qZT_KokyakuYuyuKykmeisaiFTy.ztysequenceno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_KokyakuYuyuKykmeisaiFTy).getResults();
    }
}
