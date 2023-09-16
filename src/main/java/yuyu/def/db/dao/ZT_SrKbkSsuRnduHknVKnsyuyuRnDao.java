package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_SrKbkSsuRnduHknVKnsyuyuRn;
import yuyu.def.db.meta.QZT_SrKbkSsuRnduHknVKnsyuyuRn;

/**
 * 株価指数連動保険Ｖ検証用Ｆテーブル（連）(ZT_SrKbkSsuRnduHknVKnsyuyuRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_SrKbkSsuRnduHknVKnsyuyuRnDao extends AbstractDao<ZT_SrKbkSsuRnduHknVKnsyuyuRn> {

    public ZT_SrKbkSsuRnduHknVKnsyuyuRnDao() {
        super(ZT_SrKbkSsuRnduHknVKnsyuyuRn.class);
    }

    public ZT_SrKbkSsuRnduHknVKnsyuyuRn getSrKbkSsuRnduHknVKnsyuyuRn(Integer pZrnsequenceno) {
        ZT_SrKbkSsuRnduHknVKnsyuyuRn zT_SrKbkSsuRnduHknVKnsyuyuRn =  new ZT_SrKbkSsuRnduHknVKnsyuyuRn();
        zT_SrKbkSsuRnduHknVKnsyuyuRn.setZrnsequenceno(pZrnsequenceno);
        return this.selectOne(zT_SrKbkSsuRnduHknVKnsyuyuRn);
    }

    public ExDBResults<ZT_SrKbkSsuRnduHknVKnsyuyuRn> selectAllZT_SrKbkSsuRnduHknVKnsyuyuRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_SrKbkSsuRnduHknVKnsyuyuRn qZT_SrKbkSsuRnduHknVKnsyuyuRn =  new QZT_SrKbkSsuRnduHknVKnsyuyuRn();
        jpql.append($SELECT);
        jpql.append(qZT_SrKbkSsuRnduHknVKnsyuyuRn);
        jpql.append($FROM);
        jpql.append(qZT_SrKbkSsuRnduHknVKnsyuyuRn.ZT_SrKbkSsuRnduHknVKnsyuyuRn());
        jpql.append($ORDER_BY(qZT_SrKbkSsuRnduHknVKnsyuyuRn.zrnsequenceno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_SrKbkSsuRnduHknVKnsyuyuRn).getResults();
    }
}
