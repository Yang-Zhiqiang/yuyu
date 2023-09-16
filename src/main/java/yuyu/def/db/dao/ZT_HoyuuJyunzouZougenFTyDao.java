package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_HoyuuJyunzouZougenFTy;
import yuyu.def.db.meta.QZT_HoyuuJyunzouZougenFTy;

/**
 * 保有純増増減Ｆテーブル（中）(ZT_HoyuuJyunzouZougenFTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_HoyuuJyunzouZougenFTyDao extends AbstractDao<ZT_HoyuuJyunzouZougenFTy> {

    public ZT_HoyuuJyunzouZougenFTyDao() {
        super(ZT_HoyuuJyunzouZougenFTy.class);
    }

    public ZT_HoyuuJyunzouZougenFTy getHoyuuJyunzouZougenFTy(Integer pZtysequenceno) {
        ZT_HoyuuJyunzouZougenFTy zT_HoyuuJyunzouZougenFTy =  new ZT_HoyuuJyunzouZougenFTy();
        zT_HoyuuJyunzouZougenFTy.setZtysequenceno(pZtysequenceno);
        return this.selectOne(zT_HoyuuJyunzouZougenFTy);
    }

    public ExDBResults<ZT_HoyuuJyunzouZougenFTy> selectAllZT_HoyuuJyunzouZougenFTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_HoyuuJyunzouZougenFTy qZT_HoyuuJyunzouZougenFTy =  new QZT_HoyuuJyunzouZougenFTy();
        jpql.append($SELECT);
        jpql.append(qZT_HoyuuJyunzouZougenFTy);
        jpql.append($FROM);
        jpql.append(qZT_HoyuuJyunzouZougenFTy.ZT_HoyuuJyunzouZougenFTy());
        jpql.append($ORDER_BY(qZT_HoyuuJyunzouZougenFTy.ztysequenceno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_HoyuuJyunzouZougenFTy).getResults();
    }
}
