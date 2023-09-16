package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_SkeisynyptoukeiksnRn;
import yuyu.def.db.meta.QZT_SkeisynyptoukeiksnRn;

/**
 * 新契約収入Ｐ統計決算Ｆテーブル（連）(ZT_SkeisynyptoukeiksnRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_SkeisynyptoukeiksnRnDao extends AbstractDao<ZT_SkeisynyptoukeiksnRn> {

    public ZT_SkeisynyptoukeiksnRnDao() {
        super(ZT_SkeisynyptoukeiksnRn.class);
    }

    public ZT_SkeisynyptoukeiksnRn getSkeisynyptoukeiksnRn(Integer pZrnsequenceno) {
        ZT_SkeisynyptoukeiksnRn zT_SkeisynyptoukeiksnRn =  new ZT_SkeisynyptoukeiksnRn();
        zT_SkeisynyptoukeiksnRn.setZrnsequenceno(pZrnsequenceno);
        return this.selectOne(zT_SkeisynyptoukeiksnRn);
    }

    public ExDBResults<ZT_SkeisynyptoukeiksnRn> selectAllZT_SkeisynyptoukeiksnRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_SkeisynyptoukeiksnRn qZT_SkeisynyptoukeiksnRn =  new QZT_SkeisynyptoukeiksnRn();
        jpql.append($SELECT);
        jpql.append(qZT_SkeisynyptoukeiksnRn);
        jpql.append($FROM);
        jpql.append(qZT_SkeisynyptoukeiksnRn.ZT_SkeisynyptoukeiksnRn());
        jpql.append($ORDER_BY(qZT_SkeisynyptoukeiksnRn.zrnsequenceno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_SkeisynyptoukeiksnRn).getResults();
    }
}
