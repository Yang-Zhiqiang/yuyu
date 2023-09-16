package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_BikinKeiyakuSeisandRn;
import yuyu.def.db.meta.QZT_BikinKeiyakuSeisandRn;

/**
 * 備金契約精算ＤＦテーブル（連）(ZT_BikinKeiyakuSeisandRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_BikinKeiyakuSeisandRnDao extends AbstractDao<ZT_BikinKeiyakuSeisandRn> {

    public ZT_BikinKeiyakuSeisandRnDao() {
        super(ZT_BikinKeiyakuSeisandRn.class);
    }

    public ZT_BikinKeiyakuSeisandRn getBikinKeiyakuSeisandRn(Integer pZrnsequenceno) {
        ZT_BikinKeiyakuSeisandRn zT_BikinKeiyakuSeisandRn =  new ZT_BikinKeiyakuSeisandRn();
        zT_BikinKeiyakuSeisandRn.setZrnsequenceno(pZrnsequenceno);
        return this.selectOne(zT_BikinKeiyakuSeisandRn);
    }

    public ExDBResults<ZT_BikinKeiyakuSeisandRn> selectAllZT_BikinKeiyakuSeisandRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_BikinKeiyakuSeisandRn qZT_BikinKeiyakuSeisandRn =  new QZT_BikinKeiyakuSeisandRn();
        jpql.append($SELECT);
        jpql.append(qZT_BikinKeiyakuSeisandRn);
        jpql.append($FROM);
        jpql.append(qZT_BikinKeiyakuSeisandRn.ZT_BikinKeiyakuSeisandRn());
        jpql.append($ORDER_BY(qZT_BikinKeiyakuSeisandRn.zrnsequenceno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_BikinKeiyakuSeisandRn).getResults();
    }
}
