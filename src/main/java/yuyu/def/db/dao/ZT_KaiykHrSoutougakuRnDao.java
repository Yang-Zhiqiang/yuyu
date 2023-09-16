package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_KaiykHrSoutougakuRn;
import yuyu.def.db.meta.QZT_KaiykHrSoutougakuRn;

/**
 * 解約返戻金相当額Ｆテーブル（連）(ZT_KaiykHrSoutougakuRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_KaiykHrSoutougakuRnDao extends AbstractDao<ZT_KaiykHrSoutougakuRn> {

    public ZT_KaiykHrSoutougakuRnDao() {
        super(ZT_KaiykHrSoutougakuRn.class);
    }

    public ZT_KaiykHrSoutougakuRn getKaiykHrSoutougakuRn(Integer pZrnsequenceno) {
        ZT_KaiykHrSoutougakuRn zT_KaiykHrSoutougakuRn =  new ZT_KaiykHrSoutougakuRn();
        zT_KaiykHrSoutougakuRn.setZrnsequenceno(pZrnsequenceno);
        return this.selectOne(zT_KaiykHrSoutougakuRn);
    }

    public ExDBResults<ZT_KaiykHrSoutougakuRn> selectAllZT_KaiykHrSoutougakuRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_KaiykHrSoutougakuRn qZT_KaiykHrSoutougakuRn =  new QZT_KaiykHrSoutougakuRn();
        jpql.append($SELECT);
        jpql.append(qZT_KaiykHrSoutougakuRn);
        jpql.append($FROM);
        jpql.append(qZT_KaiykHrSoutougakuRn.ZT_KaiykHrSoutougakuRn());
        jpql.append($ORDER_BY(qZT_KaiykHrSoutougakuRn.zrnsequenceno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_KaiykHrSoutougakuRn).getResults();
    }
}
