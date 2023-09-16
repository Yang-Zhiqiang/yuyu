package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_SrKbkSsuRnduHknVKnsyuyuTy;
import yuyu.def.db.meta.QZT_SrKbkSsuRnduHknVKnsyuyuTy;

/**
 * 株価指数連動保険Ｖ検証用Ｆテーブル（中）(ZT_SrKbkSsuRnduHknVKnsyuyuTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_SrKbkSsuRnduHknVKnsyuyuTyDao extends AbstractDao<ZT_SrKbkSsuRnduHknVKnsyuyuTy> {

    public ZT_SrKbkSsuRnduHknVKnsyuyuTyDao() {
        super(ZT_SrKbkSsuRnduHknVKnsyuyuTy.class);
    }

    public ZT_SrKbkSsuRnduHknVKnsyuyuTy getSrKbkSsuRnduHknVKnsyuyuTy(Integer pZtysequenceno) {
        ZT_SrKbkSsuRnduHknVKnsyuyuTy zT_SrKbkSsuRnduHknVKnsyuyuTy =  new ZT_SrKbkSsuRnduHknVKnsyuyuTy();
        zT_SrKbkSsuRnduHknVKnsyuyuTy.setZtysequenceno(pZtysequenceno);
        return this.selectOne(zT_SrKbkSsuRnduHknVKnsyuyuTy);
    }

    public ExDBResults<ZT_SrKbkSsuRnduHknVKnsyuyuTy> selectAllZT_SrKbkSsuRnduHknVKnsyuyuTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_SrKbkSsuRnduHknVKnsyuyuTy qZT_SrKbkSsuRnduHknVKnsyuyuTy =  new QZT_SrKbkSsuRnduHknVKnsyuyuTy();
        jpql.append($SELECT);
        jpql.append(qZT_SrKbkSsuRnduHknVKnsyuyuTy);
        jpql.append($FROM);
        jpql.append(qZT_SrKbkSsuRnduHknVKnsyuyuTy.ZT_SrKbkSsuRnduHknVKnsyuyuTy());
        jpql.append($ORDER_BY(qZT_SrKbkSsuRnduHknVKnsyuyuTy.ztysequenceno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_SrKbkSsuRnduHknVKnsyuyuTy).getResults();
    }
}
