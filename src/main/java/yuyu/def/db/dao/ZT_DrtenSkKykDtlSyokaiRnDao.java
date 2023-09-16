package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_DrtenSkKykDtlSyokaiRn;
import yuyu.def.db.meta.QZT_DrtenSkKykDtlSyokaiRn;

/**
 * 代理店失効契約明細照会用Ｆテーブル（連）(ZT_DrtenSkKykDtlSyokaiRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_DrtenSkKykDtlSyokaiRnDao extends AbstractDao<ZT_DrtenSkKykDtlSyokaiRn> {

    public ZT_DrtenSkKykDtlSyokaiRnDao() {
        super(ZT_DrtenSkKykDtlSyokaiRn.class);
    }

    public ZT_DrtenSkKykDtlSyokaiRn getDrtenSkKykDtlSyokaiRn(String pZrnsakuseiym, String pZrnbsydrtencd, String pZrntntusycd, String pZrnsyono) {
        ZT_DrtenSkKykDtlSyokaiRn zT_DrtenSkKykDtlSyokaiRn =  new ZT_DrtenSkKykDtlSyokaiRn();
        zT_DrtenSkKykDtlSyokaiRn.setZrnsakuseiym(pZrnsakuseiym);
        zT_DrtenSkKykDtlSyokaiRn.setZrnbsydrtencd(pZrnbsydrtencd);
        zT_DrtenSkKykDtlSyokaiRn.setZrntntusycd(pZrntntusycd);
        zT_DrtenSkKykDtlSyokaiRn.setZrnsyono(pZrnsyono);
        return this.selectOne(zT_DrtenSkKykDtlSyokaiRn);
    }

    public ExDBResults<ZT_DrtenSkKykDtlSyokaiRn> selectAllZT_DrtenSkKykDtlSyokaiRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_DrtenSkKykDtlSyokaiRn qZT_DrtenSkKykDtlSyokaiRn =  new QZT_DrtenSkKykDtlSyokaiRn();
        jpql.append($SELECT);
        jpql.append(qZT_DrtenSkKykDtlSyokaiRn);
        jpql.append($FROM);
        jpql.append(qZT_DrtenSkKykDtlSyokaiRn.ZT_DrtenSkKykDtlSyokaiRn());
        jpql.append($ORDER_BY(qZT_DrtenSkKykDtlSyokaiRn.zrnsakuseiym.asc(), qZT_DrtenSkKykDtlSyokaiRn.zrnbsydrtencd.asc(), qZT_DrtenSkKykDtlSyokaiRn.zrntntusycd.asc(), qZT_DrtenSkKykDtlSyokaiRn.zrnsyono.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_DrtenSkKykDtlSyokaiRn).getResults();
    }
}
