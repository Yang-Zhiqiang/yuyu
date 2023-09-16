package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_KyhknShrJyoukyouRnrkRn;
import yuyu.def.db.meta.QZT_KyhknShrJyoukyouRnrkRn;

/**
 * 給付金支払状況連絡Fテーブル（連）(ZT_KyhknShrJyoukyouRnrkRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_KyhknShrJyoukyouRnrkRnDao extends AbstractDao<ZT_KyhknShrJyoukyouRnrkRn> {

    public ZT_KyhknShrJyoukyouRnrkRnDao() {
        super(ZT_KyhknShrJyoukyouRnrkRn.class);
    }

    public ZT_KyhknShrJyoukyouRnrkRn getKyhknShrJyoukyouRnrkRn(Integer pZrnsequenceno) {
        ZT_KyhknShrJyoukyouRnrkRn zT_KyhknShrJyoukyouRnrkRn =  new ZT_KyhknShrJyoukyouRnrkRn();
        zT_KyhknShrJyoukyouRnrkRn.setZrnsequenceno(pZrnsequenceno);
        return this.selectOne(zT_KyhknShrJyoukyouRnrkRn);
    }

    public ExDBResults<ZT_KyhknShrJyoukyouRnrkRn> selectAllZT_KyhknShrJyoukyouRnrkRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_KyhknShrJyoukyouRnrkRn qZT_KyhknShrJyoukyouRnrkRn =  new QZT_KyhknShrJyoukyouRnrkRn();
        jpql.append($SELECT);
        jpql.append(qZT_KyhknShrJyoukyouRnrkRn);
        jpql.append($FROM);
        jpql.append(qZT_KyhknShrJyoukyouRnrkRn.ZT_KyhknShrJyoukyouRnrkRn());
        jpql.append($ORDER_BY(qZT_KyhknShrJyoukyouRnrkRn.zrnsequenceno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_KyhknShrJyoukyouRnrkRn).getResults();
    }
}
