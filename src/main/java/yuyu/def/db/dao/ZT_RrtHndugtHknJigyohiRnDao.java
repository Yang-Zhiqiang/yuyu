package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_RrtHndugtHknJigyohiRn;
import yuyu.def.db.meta.QZT_RrtHndugtHknJigyohiRn;

/**
 * 利率変動型保険事業費Ｆテーブル（連）(ZT_RrtHndugtHknJigyohiRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_RrtHndugtHknJigyohiRnDao extends AbstractDao<ZT_RrtHndugtHknJigyohiRn> {

    public ZT_RrtHndugtHknJigyohiRnDao() {
        super(ZT_RrtHndugtHknJigyohiRn.class);
    }

    public ZT_RrtHndugtHknJigyohiRn getRrtHndugtHknJigyohiRn(Integer pZrnsequenceno) {
        ZT_RrtHndugtHknJigyohiRn zT_RrtHndugtHknJigyohiRn =  new ZT_RrtHndugtHknJigyohiRn();
        zT_RrtHndugtHknJigyohiRn.setZrnsequenceno(pZrnsequenceno);
        return this.selectOne(zT_RrtHndugtHknJigyohiRn);
    }

    public ExDBResults<ZT_RrtHndugtHknJigyohiRn> selectAllZT_RrtHndugtHknJigyohiRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_RrtHndugtHknJigyohiRn qZT_RrtHndugtHknJigyohiRn =  new QZT_RrtHndugtHknJigyohiRn();
        jpql.append($SELECT);
        jpql.append(qZT_RrtHndugtHknJigyohiRn);
        jpql.append($FROM);
        jpql.append(qZT_RrtHndugtHknJigyohiRn.ZT_RrtHndugtHknJigyohiRn());
        jpql.append($ORDER_BY(qZT_RrtHndugtHknJigyohiRn.zrnsequenceno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_RrtHndugtHknJigyohiRn).getResults();
    }
}
