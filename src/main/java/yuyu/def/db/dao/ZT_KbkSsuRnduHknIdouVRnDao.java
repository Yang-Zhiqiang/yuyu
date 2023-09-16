package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_KbkSsuRnduHknIdouVRn;
import yuyu.def.db.meta.QZT_KbkSsuRnduHknIdouVRn;

/**
 * 株価指数連動保険異動ＶＦテーブル（連）(ZT_KbkSsuRnduHknIdouVRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_KbkSsuRnduHknIdouVRnDao extends AbstractDao<ZT_KbkSsuRnduHknIdouVRn> {

    public ZT_KbkSsuRnduHknIdouVRnDao() {
        super(ZT_KbkSsuRnduHknIdouVRn.class);
    }

    public ZT_KbkSsuRnduHknIdouVRn getKbkSsuRnduHknIdouVRn(Integer pZrnsequenceno) {
        ZT_KbkSsuRnduHknIdouVRn zT_KbkSsuRnduHknIdouVRn =  new ZT_KbkSsuRnduHknIdouVRn();
        zT_KbkSsuRnduHknIdouVRn.setZrnsequenceno(pZrnsequenceno);
        return this.selectOne(zT_KbkSsuRnduHknIdouVRn);
    }

    public ExDBResults<ZT_KbkSsuRnduHknIdouVRn> selectAllZT_KbkSsuRnduHknIdouVRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_KbkSsuRnduHknIdouVRn qZT_KbkSsuRnduHknIdouVRn =  new QZT_KbkSsuRnduHknIdouVRn();
        jpql.append($SELECT);
        jpql.append(qZT_KbkSsuRnduHknIdouVRn);
        jpql.append($FROM);
        jpql.append(qZT_KbkSsuRnduHknIdouVRn.ZT_KbkSsuRnduHknIdouVRn());
        jpql.append($ORDER_BY(qZT_KbkSsuRnduHknIdouVRn.zrnsequenceno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_KbkSsuRnduHknIdouVRn).getResults();
    }
}
