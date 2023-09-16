package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_KsnKbkSsuRnduHknJigyohiRn;
import yuyu.def.db.meta.QZT_KsnKbkSsuRnduHknJigyohiRn;

/**
 * 決算計上用株価指数連動保険事業費Ｆテーブル（連）(ZT_KsnKbkSsuRnduHknJigyohiRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_KsnKbkSsuRnduHknJigyohiRnDao extends AbstractDao<ZT_KsnKbkSsuRnduHknJigyohiRn> {

    public ZT_KsnKbkSsuRnduHknJigyohiRnDao() {
        super(ZT_KsnKbkSsuRnduHknJigyohiRn.class);
    }

    public ZT_KsnKbkSsuRnduHknJigyohiRn getKsnKbkSsuRnduHknJigyohiRn(Integer pZrnsequenceno) {
        ZT_KsnKbkSsuRnduHknJigyohiRn zT_KsnKbkSsuRnduHknJigyohiRn =  new ZT_KsnKbkSsuRnduHknJigyohiRn();
        zT_KsnKbkSsuRnduHknJigyohiRn.setZrnsequenceno(pZrnsequenceno);
        return this.selectOne(zT_KsnKbkSsuRnduHknJigyohiRn);
    }

    public ExDBResults<ZT_KsnKbkSsuRnduHknJigyohiRn> selectAllZT_KsnKbkSsuRnduHknJigyohiRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_KsnKbkSsuRnduHknJigyohiRn qZT_KsnKbkSsuRnduHknJigyohiRn =  new QZT_KsnKbkSsuRnduHknJigyohiRn();
        jpql.append($SELECT);
        jpql.append(qZT_KsnKbkSsuRnduHknJigyohiRn);
        jpql.append($FROM);
        jpql.append(qZT_KsnKbkSsuRnduHknJigyohiRn.ZT_KsnKbkSsuRnduHknJigyohiRn());
        jpql.append($ORDER_BY(qZT_KsnKbkSsuRnduHknJigyohiRn.zrnsequenceno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_KsnKbkSsuRnduHknJigyohiRn).getResults();
    }
}
