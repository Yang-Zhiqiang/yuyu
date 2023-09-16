package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_KbkSsuRnduHknJigyohiRn;
import yuyu.def.db.meta.QZT_KbkSsuRnduHknJigyohiRn;

/**
 * 株価指数連動保険事業費Ｆテーブル（連）(ZT_KbkSsuRnduHknJigyohiRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_KbkSsuRnduHknJigyohiRnDao extends AbstractDao<ZT_KbkSsuRnduHknJigyohiRn> {

    public ZT_KbkSsuRnduHknJigyohiRnDao() {
        super(ZT_KbkSsuRnduHknJigyohiRn.class);
    }

    public ZT_KbkSsuRnduHknJigyohiRn getKbkSsuRnduHknJigyohiRn(Integer pZrnsequenceno) {
        ZT_KbkSsuRnduHknJigyohiRn zT_KbkSsuRnduHknJigyohiRn =  new ZT_KbkSsuRnduHknJigyohiRn();
        zT_KbkSsuRnduHknJigyohiRn.setZrnsequenceno(pZrnsequenceno);
        return this.selectOne(zT_KbkSsuRnduHknJigyohiRn);
    }

    public ExDBResults<ZT_KbkSsuRnduHknJigyohiRn> selectAllZT_KbkSsuRnduHknJigyohiRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_KbkSsuRnduHknJigyohiRn qZT_KbkSsuRnduHknJigyohiRn =  new QZT_KbkSsuRnduHknJigyohiRn();
        jpql.append($SELECT);
        jpql.append(qZT_KbkSsuRnduHknJigyohiRn);
        jpql.append($FROM);
        jpql.append(qZT_KbkSsuRnduHknJigyohiRn.ZT_KbkSsuRnduHknJigyohiRn());
        jpql.append($ORDER_BY(qZT_KbkSsuRnduHknJigyohiRn.zrnsequenceno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_KbkSsuRnduHknJigyohiRn).getResults();
    }
}
