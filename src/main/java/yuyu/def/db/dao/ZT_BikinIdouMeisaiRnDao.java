package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_BikinIdouMeisaiRn;
import yuyu.def.db.meta.QZT_BikinIdouMeisaiRn;

/**
 * 備金異動明細Ｆテーブル（連）(ZT_BikinIdouMeisaiRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_BikinIdouMeisaiRnDao extends AbstractDao<ZT_BikinIdouMeisaiRn> {

    public ZT_BikinIdouMeisaiRnDao() {
        super(ZT_BikinIdouMeisaiRn.class);
    }

    public ZT_BikinIdouMeisaiRn getBikinIdouMeisaiRn(Integer pZrnsequenceno) {
        ZT_BikinIdouMeisaiRn zT_BikinIdouMeisaiRn =  new ZT_BikinIdouMeisaiRn();
        zT_BikinIdouMeisaiRn.setZrnsequenceno(pZrnsequenceno);
        return this.selectOne(zT_BikinIdouMeisaiRn);
    }

    public ExDBResults<ZT_BikinIdouMeisaiRn> selectAllZT_BikinIdouMeisaiRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_BikinIdouMeisaiRn qZT_BikinIdouMeisaiRn =  new QZT_BikinIdouMeisaiRn();
        jpql.append($SELECT);
        jpql.append(qZT_BikinIdouMeisaiRn);
        jpql.append($FROM);
        jpql.append(qZT_BikinIdouMeisaiRn.ZT_BikinIdouMeisaiRn());
        jpql.append($ORDER_BY(qZT_BikinIdouMeisaiRn.zrnsequenceno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_BikinIdouMeisaiRn).getResults();
    }
}
