package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_SyuSibouToukeiRn;
import yuyu.def.db.meta.QZT_SyuSibouToukeiRn;

/**
 * 主契約死亡統計データテーブル（連）(ZT_SyuSibouToukeiRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_SyuSibouToukeiRnDao extends AbstractDao<ZT_SyuSibouToukeiRn> {

    public ZT_SyuSibouToukeiRnDao() {
        super(ZT_SyuSibouToukeiRn.class);
    }

    public ZT_SyuSibouToukeiRn getSyuSibouToukeiRn(String pZrnsyono) {
        ZT_SyuSibouToukeiRn zT_SyuSibouToukeiRn =  new ZT_SyuSibouToukeiRn();
        zT_SyuSibouToukeiRn.setZrnsyono(pZrnsyono);
        return this.selectOne(zT_SyuSibouToukeiRn);
    }

    public ExDBResults<ZT_SyuSibouToukeiRn> selectAllZT_SyuSibouToukeiRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_SyuSibouToukeiRn qZT_SyuSibouToukeiRn =  new QZT_SyuSibouToukeiRn();
        jpql.append($SELECT);
        jpql.append(qZT_SyuSibouToukeiRn);
        jpql.append($FROM);
        jpql.append(qZT_SyuSibouToukeiRn.ZT_SyuSibouToukeiRn());
        jpql.append($ORDER_BY(qZT_SyuSibouToukeiRn.zrnsyono.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_SyuSibouToukeiRn).getResults();
    }
}
