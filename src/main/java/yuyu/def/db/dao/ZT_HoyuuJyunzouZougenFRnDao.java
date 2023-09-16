package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_HoyuuJyunzouZougenFRn;
import yuyu.def.db.meta.QZT_HoyuuJyunzouZougenFRn;

/**
 * 保有純増増減Ｆテーブル（連）(ZT_HoyuuJyunzouZougenFRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_HoyuuJyunzouZougenFRnDao extends AbstractDao<ZT_HoyuuJyunzouZougenFRn> {

    public ZT_HoyuuJyunzouZougenFRnDao() {
        super(ZT_HoyuuJyunzouZougenFRn.class);
    }

    public ZT_HoyuuJyunzouZougenFRn getHoyuuJyunzouZougenFRn(Integer pZrnsequenceno) {
        ZT_HoyuuJyunzouZougenFRn zT_HoyuuJyunzouZougenFRn =  new ZT_HoyuuJyunzouZougenFRn();
        zT_HoyuuJyunzouZougenFRn.setZrnsequenceno(pZrnsequenceno);
        return this.selectOne(zT_HoyuuJyunzouZougenFRn);
    }

    public ExDBResults<ZT_HoyuuJyunzouZougenFRn> selectAllZT_HoyuuJyunzouZougenFRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_HoyuuJyunzouZougenFRn qZT_HoyuuJyunzouZougenFRn =  new QZT_HoyuuJyunzouZougenFRn();
        jpql.append($SELECT);
        jpql.append(qZT_HoyuuJyunzouZougenFRn);
        jpql.append($FROM);
        jpql.append(qZT_HoyuuJyunzouZougenFRn.ZT_HoyuuJyunzouZougenFRn());
        jpql.append($ORDER_BY(qZT_HoyuuJyunzouZougenFRn.zrnsequenceno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_HoyuuJyunzouZougenFRn).getResults();
    }
}
