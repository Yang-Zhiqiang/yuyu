package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_KesikomiSousinHurikaeRn;
import yuyu.def.db.meta.QZT_KesikomiSousinHurikaeRn;

/**
 * 消込送信Ｆ（振替）テーブル（連）(ZT_KesikomiSousinHurikaeRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_KesikomiSousinHurikaeRnDao extends AbstractDao<ZT_KesikomiSousinHurikaeRn> {

    public ZT_KesikomiSousinHurikaeRnDao() {
        super(ZT_KesikomiSousinHurikaeRn.class);
    }

    public ZT_KesikomiSousinHurikaeRn getKesikomiSousinHurikaeRn(String pZrnkskmsousinrenno, String pZrnkskmfsyoriymd) {
        ZT_KesikomiSousinHurikaeRn zT_KesikomiSousinHurikaeRn =  new ZT_KesikomiSousinHurikaeRn();
        zT_KesikomiSousinHurikaeRn.setZrnkskmsousinrenno(pZrnkskmsousinrenno);
        zT_KesikomiSousinHurikaeRn.setZrnkskmfsyoriymd(pZrnkskmfsyoriymd);
        return this.selectOne(zT_KesikomiSousinHurikaeRn);
    }

    public ExDBResults<ZT_KesikomiSousinHurikaeRn> selectAllZT_KesikomiSousinHurikaeRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_KesikomiSousinHurikaeRn qZT_KesikomiSousinHurikaeRn =  new QZT_KesikomiSousinHurikaeRn();
        jpql.append($SELECT);
        jpql.append(qZT_KesikomiSousinHurikaeRn);
        jpql.append($FROM);
        jpql.append(qZT_KesikomiSousinHurikaeRn.ZT_KesikomiSousinHurikaeRn());
        jpql.append($ORDER_BY(qZT_KesikomiSousinHurikaeRn.zrnkskmsousinrenno.asc(), qZT_KesikomiSousinHurikaeRn.zrnkskmfsyoriymd.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_KesikomiSousinHurikaeRn).getResults();
    }
}
