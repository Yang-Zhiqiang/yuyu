package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_NkGensiRigTy;
import yuyu.def.db.meta.QZT_NkGensiRigTy;

/**
 * 年金原資Ｆ例月用テーブル（中）(ZT_NkGensiRigTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_NkGensiRigTyDao extends AbstractDao<ZT_NkGensiRigTy> {

    public ZT_NkGensiRigTyDao() {
        super(ZT_NkGensiRigTy.class);
    }

    public ZT_NkGensiRigTy getNkGensiRigTy(Integer pZtysequenceno) {
        ZT_NkGensiRigTy zT_NkGensiRigTy =  new ZT_NkGensiRigTy();
        zT_NkGensiRigTy.setZtysequenceno(pZtysequenceno);
        return this.selectOne(zT_NkGensiRigTy);
    }

    public ExDBResults<ZT_NkGensiRigTy> selectAllZT_NkGensiRigTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_NkGensiRigTy qZT_NkGensiRigTy =  new QZT_NkGensiRigTy();
        jpql.append($SELECT);
        jpql.append(qZT_NkGensiRigTy);
        jpql.append($FROM);
        jpql.append(qZT_NkGensiRigTy.ZT_NkGensiRigTy());
        jpql.append($ORDER_BY(qZT_NkGensiRigTy.ztysequenceno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_NkGensiRigTy).getResults();
    }
}
