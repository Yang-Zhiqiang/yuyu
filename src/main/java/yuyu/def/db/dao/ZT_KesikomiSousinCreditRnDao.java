package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_KesikomiSousinCreditRn;
import yuyu.def.db.meta.QZT_KesikomiSousinCreditRn;

/**
 * 消込送信Ｆ（クレ払）テーブル（連）(ZT_KesikomiSousinCreditRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_KesikomiSousinCreditRnDao extends AbstractDao<ZT_KesikomiSousinCreditRn> {

    public ZT_KesikomiSousinCreditRnDao() {
        super(ZT_KesikomiSousinCreditRn.class);
    }

    public ZT_KesikomiSousinCreditRn getKesikomiSousinCreditRn(String pZrnkskmsousinrenno, String pZrnkskmfsyoriymd) {
        ZT_KesikomiSousinCreditRn zT_KesikomiSousinCreditRn =  new ZT_KesikomiSousinCreditRn();
        zT_KesikomiSousinCreditRn.setZrnkskmsousinrenno(pZrnkskmsousinrenno);
        zT_KesikomiSousinCreditRn.setZrnkskmfsyoriymd(pZrnkskmfsyoriymd);
        return this.selectOne(zT_KesikomiSousinCreditRn);
    }

    public ExDBResults<ZT_KesikomiSousinCreditRn> selectAllZT_KesikomiSousinCreditRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_KesikomiSousinCreditRn qZT_KesikomiSousinCreditRn =  new QZT_KesikomiSousinCreditRn();
        jpql.append($SELECT);
        jpql.append(qZT_KesikomiSousinCreditRn);
        jpql.append($FROM);
        jpql.append(qZT_KesikomiSousinCreditRn.ZT_KesikomiSousinCreditRn());
        jpql.append($ORDER_BY(qZT_KesikomiSousinCreditRn.zrnkskmsousinrenno.asc(), qZT_KesikomiSousinCreditRn.zrnkskmfsyoriymd.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_KesikomiSousinCreditRn).getResults();
    }
}
