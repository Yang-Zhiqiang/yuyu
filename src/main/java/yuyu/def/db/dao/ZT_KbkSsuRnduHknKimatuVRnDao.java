package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_KbkSsuRnduHknKimatuVRn;
import yuyu.def.db.meta.QZT_KbkSsuRnduHknKimatuVRn;

/**
 * 株価指数連動保険期末ＶＦテーブル（連）(ZT_KbkSsuRnduHknKimatuVRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_KbkSsuRnduHknKimatuVRnDao extends AbstractDao<ZT_KbkSsuRnduHknKimatuVRn> {

    public ZT_KbkSsuRnduHknKimatuVRnDao() {
        super(ZT_KbkSsuRnduHknKimatuVRn.class);
    }

    public ZT_KbkSsuRnduHknKimatuVRn getKbkSsuRnduHknKimatuVRn(Integer pZrnsequenceno) {
        ZT_KbkSsuRnduHknKimatuVRn zT_KbkSsuRnduHknKimatuVRn =  new ZT_KbkSsuRnduHknKimatuVRn();
        zT_KbkSsuRnduHknKimatuVRn.setZrnsequenceno(pZrnsequenceno);
        return this.selectOne(zT_KbkSsuRnduHknKimatuVRn);
    }

    public ExDBResults<ZT_KbkSsuRnduHknKimatuVRn> selectAllZT_KbkSsuRnduHknKimatuVRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_KbkSsuRnduHknKimatuVRn qZT_KbkSsuRnduHknKimatuVRn =  new QZT_KbkSsuRnduHknKimatuVRn();
        jpql.append($SELECT);
        jpql.append(qZT_KbkSsuRnduHknKimatuVRn);
        jpql.append($FROM);
        jpql.append(qZT_KbkSsuRnduHknKimatuVRn.ZT_KbkSsuRnduHknKimatuVRn());
        jpql.append($ORDER_BY(qZT_KbkSsuRnduHknKimatuVRn.zrnsequenceno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_KbkSsuRnduHknKimatuVRn).getResults();
    }
}
