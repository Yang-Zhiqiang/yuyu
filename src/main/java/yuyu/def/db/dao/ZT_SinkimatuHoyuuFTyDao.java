package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_SinkimatuHoyuuFTy;
import yuyu.def.db.meta.QZT_SinkimatuHoyuuFTy;

/**
 * 新期末保有Ｆテーブル（中）(ZT_SinkimatuHoyuuFTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_SinkimatuHoyuuFTyDao extends AbstractDao<ZT_SinkimatuHoyuuFTy> {

    public ZT_SinkimatuHoyuuFTyDao() {
        super(ZT_SinkimatuHoyuuFTy.class);
    }

    public ZT_SinkimatuHoyuuFTy getSinkimatuHoyuuFTy(Integer pZtysequenceno) {
        ZT_SinkimatuHoyuuFTy zT_SinkimatuHoyuuFTy =  new ZT_SinkimatuHoyuuFTy();
        zT_SinkimatuHoyuuFTy.setZtysequenceno(pZtysequenceno);
        return this.selectOne(zT_SinkimatuHoyuuFTy);
    }

    public ExDBResults<ZT_SinkimatuHoyuuFTy> selectAllZT_SinkimatuHoyuuFTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_SinkimatuHoyuuFTy qZT_SinkimatuHoyuuFTy =  new QZT_SinkimatuHoyuuFTy();
        jpql.append($SELECT);
        jpql.append(qZT_SinkimatuHoyuuFTy);
        jpql.append($FROM);
        jpql.append(qZT_SinkimatuHoyuuFTy.ZT_SinkimatuHoyuuFTy());
        jpql.append($ORDER_BY(qZT_SinkimatuHoyuuFTy.ztysequenceno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_SinkimatuHoyuuFTy).getResults();
    }
}
