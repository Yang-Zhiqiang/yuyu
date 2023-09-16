package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_SkSeirituRituRn;
import yuyu.def.db.meta.QZT_SkSeirituRituRn;

/**
 * 新契約成立率Ｆテーブル（連）(ZT_SkSeirituRituRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_SkSeirituRituRnDao extends AbstractDao<ZT_SkSeirituRituRn> {

    public ZT_SkSeirituRituRnDao() {
        super(ZT_SkSeirituRituRn.class);
    }

    public ZT_SkSeirituRituRn getSkSeirituRituRn(String pZrneigyouhonbusisyacd, String pZrnsosikicd, String pZrnatukaikojincd, String pZrnmosno) {
        ZT_SkSeirituRituRn zT_SkSeirituRituRn =  new ZT_SkSeirituRituRn();
        zT_SkSeirituRituRn.setZrneigyouhonbusisyacd(pZrneigyouhonbusisyacd);
        zT_SkSeirituRituRn.setZrnsosikicd(pZrnsosikicd);
        zT_SkSeirituRituRn.setZrnatukaikojincd(pZrnatukaikojincd);
        zT_SkSeirituRituRn.setZrnmosno(pZrnmosno);
        return this.selectOne(zT_SkSeirituRituRn);
    }

    public ExDBResults<ZT_SkSeirituRituRn> selectAllZT_SkSeirituRituRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_SkSeirituRituRn qZT_SkSeirituRituRn =  new QZT_SkSeirituRituRn();
        jpql.append($SELECT);
        jpql.append(qZT_SkSeirituRituRn);
        jpql.append($FROM);
        jpql.append(qZT_SkSeirituRituRn.ZT_SkSeirituRituRn());
        jpql.append($ORDER_BY(qZT_SkSeirituRituRn.zrneigyouhonbusisyacd.asc(), qZT_SkSeirituRituRn.zrnsosikicd.asc(), qZT_SkSeirituRituRn.zrnatukaikojincd.asc(), qZT_SkSeirituRituRn.zrnmosno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_SkSeirituRituRn).getResults();
    }
}
