package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_RrtHndugtHknKsnJigyohiRn;
import yuyu.def.db.meta.QZT_RrtHndugtHknKsnJigyohiRn;

/**
 * 利率変動型保険決算用事業費Ｆテーブル（連）(ZT_RrtHndugtHknKsnJigyohiRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_RrtHndugtHknKsnJigyohiRnDao extends AbstractDao<ZT_RrtHndugtHknKsnJigyohiRn> {

    public ZT_RrtHndugtHknKsnJigyohiRnDao() {
        super(ZT_RrtHndugtHknKsnJigyohiRn.class);
    }

    public ZT_RrtHndugtHknKsnJigyohiRn getRrtHndugtHknKsnJigyohiRn(Integer pZrnsequenceno) {
        ZT_RrtHndugtHknKsnJigyohiRn zT_RrtHndugtHknKsnJigyohiRn =  new ZT_RrtHndugtHknKsnJigyohiRn();
        zT_RrtHndugtHknKsnJigyohiRn.setZrnsequenceno(pZrnsequenceno);
        return this.selectOne(zT_RrtHndugtHknKsnJigyohiRn);
    }

    public ExDBResults<ZT_RrtHndugtHknKsnJigyohiRn> selectAllZT_RrtHndugtHknKsnJigyohiRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_RrtHndugtHknKsnJigyohiRn qZT_RrtHndugtHknKsnJigyohiRn =  new QZT_RrtHndugtHknKsnJigyohiRn();
        jpql.append($SELECT);
        jpql.append(qZT_RrtHndugtHknKsnJigyohiRn);
        jpql.append($FROM);
        jpql.append(qZT_RrtHndugtHknKsnJigyohiRn.ZT_RrtHndugtHknKsnJigyohiRn());
        jpql.append($ORDER_BY(qZT_RrtHndugtHknKsnJigyohiRn.zrnsequenceno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_RrtHndugtHknKsnJigyohiRn).getResults();
    }
}
