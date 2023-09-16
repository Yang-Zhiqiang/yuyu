package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_ZennouHoyuuIdouKykDtlRn;
import yuyu.def.db.meta.QZT_ZennouHoyuuIdouKykDtlRn;

/**
 * 前納保有異動契約明細Ｆテーブル（連）(ZT_ZennouHoyuuIdouKykDtlRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_ZennouHoyuuIdouKykDtlRnDao extends AbstractDao<ZT_ZennouHoyuuIdouKykDtlRn> {

    public ZT_ZennouHoyuuIdouKykDtlRnDao() {
        super(ZT_ZennouHoyuuIdouKykDtlRn.class);
    }

    public ZT_ZennouHoyuuIdouKykDtlRn getZennouHoyuuIdouKykDtlRn(String pZrndatakanrino, String pZrnsyoricd, Integer pZrnkykmfksnctr) {
        ZT_ZennouHoyuuIdouKykDtlRn zT_ZennouHoyuuIdouKykDtlRn =  new ZT_ZennouHoyuuIdouKykDtlRn();
        zT_ZennouHoyuuIdouKykDtlRn.setZrndatakanrino(pZrndatakanrino);
        zT_ZennouHoyuuIdouKykDtlRn.setZrnsyoricd(pZrnsyoricd);
        zT_ZennouHoyuuIdouKykDtlRn.setZrnkykmfksnctr(pZrnkykmfksnctr);
        return this.selectOne(zT_ZennouHoyuuIdouKykDtlRn);
    }

    public ExDBResults<ZT_ZennouHoyuuIdouKykDtlRn> selectAllZT_ZennouHoyuuIdouKykDtlRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_ZennouHoyuuIdouKykDtlRn qZT_ZennouHoyuuIdouKykDtlRn =  new QZT_ZennouHoyuuIdouKykDtlRn();
        jpql.append($SELECT);
        jpql.append(qZT_ZennouHoyuuIdouKykDtlRn);
        jpql.append($FROM);
        jpql.append(qZT_ZennouHoyuuIdouKykDtlRn.ZT_ZennouHoyuuIdouKykDtlRn());
        jpql.append($ORDER_BY(qZT_ZennouHoyuuIdouKykDtlRn.zrndatakanrino.asc(), qZT_ZennouHoyuuIdouKykDtlRn.zrnsyoricd.asc(), qZT_ZennouHoyuuIdouKykDtlRn.zrnkykmfksnctr.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_ZennouHoyuuIdouKykDtlRn).getResults();
    }
}
