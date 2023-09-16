package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_KesikomiSousinKouhuriRn;
import yuyu.def.db.meta.QZT_KesikomiSousinKouhuriRn;

/**
 * 消込送信Ｆ（口振）テーブル（連）(ZT_KesikomiSousinKouhuriRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_KesikomiSousinKouhuriRnDao extends AbstractDao<ZT_KesikomiSousinKouhuriRn> {

    public ZT_KesikomiSousinKouhuriRnDao() {
        super(ZT_KesikomiSousinKouhuriRn.class);
    }

    public ZT_KesikomiSousinKouhuriRn getKesikomiSousinKouhuriRn(String pZrnkskmsousinrenno, String pZrnkskmfsyoriymd) {
        ZT_KesikomiSousinKouhuriRn zT_KesikomiSousinKouhuriRn =  new ZT_KesikomiSousinKouhuriRn();
        zT_KesikomiSousinKouhuriRn.setZrnkskmsousinrenno(pZrnkskmsousinrenno);
        zT_KesikomiSousinKouhuriRn.setZrnkskmfsyoriymd(pZrnkskmfsyoriymd);
        return this.selectOne(zT_KesikomiSousinKouhuriRn);
    }

    public ExDBResults<ZT_KesikomiSousinKouhuriRn> selectAllZT_KesikomiSousinKouhuriRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_KesikomiSousinKouhuriRn qZT_KesikomiSousinKouhuriRn =  new QZT_KesikomiSousinKouhuriRn();
        jpql.append($SELECT);
        jpql.append(qZT_KesikomiSousinKouhuriRn);
        jpql.append($FROM);
        jpql.append(qZT_KesikomiSousinKouhuriRn.ZT_KesikomiSousinKouhuriRn());
        jpql.append($ORDER_BY(qZT_KesikomiSousinKouhuriRn.zrnkskmsousinrenno.asc(), qZT_KesikomiSousinKouhuriRn.zrnkskmfsyoriymd.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_KesikomiSousinKouhuriRn).getResults();
    }
}
