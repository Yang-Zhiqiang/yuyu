package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_NkGensiKtyTy;
import yuyu.def.db.meta.QZT_NkGensiKtyTy;

/**
 * 年金原資Ｆ期中報告用テーブル（中）(ZT_NkGensiKtyTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_NkGensiKtyTyDao extends AbstractDao<ZT_NkGensiKtyTy> {

    public ZT_NkGensiKtyTyDao() {
        super(ZT_NkGensiKtyTy.class);
    }

    public ZT_NkGensiKtyTy getNkGensiKtyTy(Integer pZtysequenceno) {
        ZT_NkGensiKtyTy zT_NkGensiKtyTy =  new ZT_NkGensiKtyTy();
        zT_NkGensiKtyTy.setZtysequenceno(pZtysequenceno);
        return this.selectOne(zT_NkGensiKtyTy);
    }

    public ExDBResults<ZT_NkGensiKtyTy> selectAllZT_NkGensiKtyTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_NkGensiKtyTy qZT_NkGensiKtyTy =  new QZT_NkGensiKtyTy();
        jpql.append($SELECT);
        jpql.append(qZT_NkGensiKtyTy);
        jpql.append($FROM);
        jpql.append(qZT_NkGensiKtyTy.ZT_NkGensiKtyTy());
        jpql.append($ORDER_BY(qZT_NkGensiKtyTy.ztysequenceno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_NkGensiKtyTy).getResults();
    }
}
