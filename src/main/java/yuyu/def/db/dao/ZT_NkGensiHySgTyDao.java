package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_NkGensiHySgTy;
import yuyu.def.db.meta.QZT_NkGensiHySgTy;

/**
 * 年金原資Ｆ保有照合用テーブル（中）(ZT_NkGensiHySgTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_NkGensiHySgTyDao extends AbstractDao<ZT_NkGensiHySgTy> {

    public ZT_NkGensiHySgTyDao() {
        super(ZT_NkGensiHySgTy.class);
    }

    public ZT_NkGensiHySgTy getNkGensiHySgTy(Integer pZtysequenceno) {
        ZT_NkGensiHySgTy zT_NkGensiHySgTy =  new ZT_NkGensiHySgTy();
        zT_NkGensiHySgTy.setZtysequenceno(pZtysequenceno);
        return this.selectOne(zT_NkGensiHySgTy);
    }

    public ExDBResults<ZT_NkGensiHySgTy> selectAllZT_NkGensiHySgTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_NkGensiHySgTy qZT_NkGensiHySgTy =  new QZT_NkGensiHySgTy();
        jpql.append($SELECT);
        jpql.append(qZT_NkGensiHySgTy);
        jpql.append($FROM);
        jpql.append(qZT_NkGensiHySgTy.ZT_NkGensiHySgTy());
        jpql.append($ORDER_BY(qZT_NkGensiHySgTy.ztysequenceno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_NkGensiHySgTy).getResults();
    }
}
