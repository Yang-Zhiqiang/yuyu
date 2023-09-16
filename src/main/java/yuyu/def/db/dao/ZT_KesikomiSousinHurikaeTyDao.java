package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_KesikomiSousinHurikaeTy;
import yuyu.def.db.meta.QZT_KesikomiSousinHurikaeTy;

/**
 * 消込送信Ｆ（振替）テーブル（中）(ZT_KesikomiSousinHurikaeTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_KesikomiSousinHurikaeTyDao extends AbstractDao<ZT_KesikomiSousinHurikaeTy> {

    public ZT_KesikomiSousinHurikaeTyDao() {
        super(ZT_KesikomiSousinHurikaeTy.class);
    }

    public ZT_KesikomiSousinHurikaeTy getKesikomiSousinHurikaeTy(String pZtykskmsousinrenno, String pZtykskmfsyoriymd) {
        ZT_KesikomiSousinHurikaeTy zT_KesikomiSousinHurikaeTy =  new ZT_KesikomiSousinHurikaeTy();
        zT_KesikomiSousinHurikaeTy.setZtykskmsousinrenno(pZtykskmsousinrenno);
        zT_KesikomiSousinHurikaeTy.setZtykskmfsyoriymd(pZtykskmfsyoriymd);
        return this.selectOne(zT_KesikomiSousinHurikaeTy);
    }

    public ExDBResults<ZT_KesikomiSousinHurikaeTy> selectAllZT_KesikomiSousinHurikaeTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_KesikomiSousinHurikaeTy qZT_KesikomiSousinHurikaeTy =  new QZT_KesikomiSousinHurikaeTy();
        jpql.append($SELECT);
        jpql.append(qZT_KesikomiSousinHurikaeTy);
        jpql.append($FROM);
        jpql.append(qZT_KesikomiSousinHurikaeTy.ZT_KesikomiSousinHurikaeTy());
        jpql.append($ORDER_BY(qZT_KesikomiSousinHurikaeTy.ztykskmsousinrenno.asc(), qZT_KesikomiSousinHurikaeTy.ztykskmfsyoriymd.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_KesikomiSousinHurikaeTy).getResults();
    }
}
