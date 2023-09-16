package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_KeizokurituRenrakuULFRn;
import yuyu.def.db.meta.QZT_KeizokurituRenrakuULFRn;

/**
 * 継続率連絡データＵＬＦテーブル（連）(ZT_KeizokurituRenrakuULFRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_KeizokurituRenrakuULFRnDao extends AbstractDao<ZT_KeizokurituRenrakuULFRn> {

    public ZT_KeizokurituRenrakuULFRnDao() {
        super(ZT_KeizokurituRenrakuULFRn.class);
    }

    public ZT_KeizokurituRenrakuULFRn getKeizokurituRenrakuULFRn(Integer pZrnsequenceno) {
        ZT_KeizokurituRenrakuULFRn zT_KeizokurituRenrakuULFRn =  new ZT_KeizokurituRenrakuULFRn();
        zT_KeizokurituRenrakuULFRn.setZrnsequenceno(pZrnsequenceno);
        return this.selectOne(zT_KeizokurituRenrakuULFRn);
    }

    public ExDBResults<ZT_KeizokurituRenrakuULFRn> selectAllZT_KeizokurituRenrakuULFRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_KeizokurituRenrakuULFRn qZT_KeizokurituRenrakuULFRn =  new QZT_KeizokurituRenrakuULFRn();
        jpql.append($SELECT);
        jpql.append(qZT_KeizokurituRenrakuULFRn);
        jpql.append($FROM);
        jpql.append(qZT_KeizokurituRenrakuULFRn.ZT_KeizokurituRenrakuULFRn());
        jpql.append($ORDER_BY(qZT_KeizokurituRenrakuULFRn.zrnsequenceno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_KeizokurituRenrakuULFRn).getResults();
    }
}
