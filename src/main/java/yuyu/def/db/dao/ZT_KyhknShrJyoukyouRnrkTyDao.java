package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_KyhknShrJyoukyouRnrkTy;
import yuyu.def.db.meta.QZT_KyhknShrJyoukyouRnrkTy;

/**
 * 給付金支払状況連絡Fテーブル（中）(ZT_KyhknShrJyoukyouRnrkTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_KyhknShrJyoukyouRnrkTyDao extends AbstractDao<ZT_KyhknShrJyoukyouRnrkTy> {

    public ZT_KyhknShrJyoukyouRnrkTyDao() {
        super(ZT_KyhknShrJyoukyouRnrkTy.class);
    }

    public ZT_KyhknShrJyoukyouRnrkTy getKyhknShrJyoukyouRnrkTy(Integer pZtysequenceno) {
        ZT_KyhknShrJyoukyouRnrkTy zT_KyhknShrJyoukyouRnrkTy =  new ZT_KyhknShrJyoukyouRnrkTy();
        zT_KyhknShrJyoukyouRnrkTy.setZtysequenceno(pZtysequenceno);
        return this.selectOne(zT_KyhknShrJyoukyouRnrkTy);
    }

    public ExDBResults<ZT_KyhknShrJyoukyouRnrkTy> selectAllZT_KyhknShrJyoukyouRnrkTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_KyhknShrJyoukyouRnrkTy qZT_KyhknShrJyoukyouRnrkTy =  new QZT_KyhknShrJyoukyouRnrkTy();
        jpql.append($SELECT);
        jpql.append(qZT_KyhknShrJyoukyouRnrkTy);
        jpql.append($FROM);
        jpql.append(qZT_KyhknShrJyoukyouRnrkTy.ZT_KyhknShrJyoukyouRnrkTy());
        jpql.append($ORDER_BY(qZT_KyhknShrJyoukyouRnrkTy.ztysequenceno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_KyhknShrJyoukyouRnrkTy).getResults();
    }
}
