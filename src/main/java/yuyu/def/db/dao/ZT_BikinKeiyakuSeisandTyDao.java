package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_BikinKeiyakuSeisandTy;
import yuyu.def.db.meta.QZT_BikinKeiyakuSeisandTy;

/**
 * 備金契約精算ＤＦテーブル（中）(ZT_BikinKeiyakuSeisandTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_BikinKeiyakuSeisandTyDao extends AbstractDao<ZT_BikinKeiyakuSeisandTy> {

    public ZT_BikinKeiyakuSeisandTyDao() {
        super(ZT_BikinKeiyakuSeisandTy.class);
    }

    public ZT_BikinKeiyakuSeisandTy getBikinKeiyakuSeisandTy(Integer pZtysequenceno) {
        ZT_BikinKeiyakuSeisandTy zT_BikinKeiyakuSeisandTy =  new ZT_BikinKeiyakuSeisandTy();
        zT_BikinKeiyakuSeisandTy.setZtysequenceno(pZtysequenceno);
        return this.selectOne(zT_BikinKeiyakuSeisandTy);
    }

    public ExDBResults<ZT_BikinKeiyakuSeisandTy> selectAllZT_BikinKeiyakuSeisandTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_BikinKeiyakuSeisandTy qZT_BikinKeiyakuSeisandTy =  new QZT_BikinKeiyakuSeisandTy();
        jpql.append($SELECT);
        jpql.append(qZT_BikinKeiyakuSeisandTy);
        jpql.append($FROM);
        jpql.append(qZT_BikinKeiyakuSeisandTy.ZT_BikinKeiyakuSeisandTy());
        jpql.append($ORDER_BY(qZT_BikinKeiyakuSeisandTy.ztysequenceno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_BikinKeiyakuSeisandTy).getResults();
    }
}
