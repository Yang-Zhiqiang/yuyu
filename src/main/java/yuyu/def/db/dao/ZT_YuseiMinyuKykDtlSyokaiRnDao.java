package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_YuseiMinyuKykDtlSyokaiRn;
import yuyu.def.db.meta.QZT_YuseiMinyuKykDtlSyokaiRn;

/**
 * 郵政未入契約明細照会用Ｆテーブル（連）(ZT_YuseiMinyuKykDtlSyokaiRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_YuseiMinyuKykDtlSyokaiRnDao extends AbstractDao<ZT_YuseiMinyuKykDtlSyokaiRn> {

    public ZT_YuseiMinyuKykDtlSyokaiRnDao() {
        super(ZT_YuseiMinyuKykDtlSyokaiRn.class);
    }

    public ZT_YuseiMinyuKykDtlSyokaiRn getYuseiMinyuKykDtlSyokaiRn(String pZrnsakuseiym, String pZrnbsydrtencd, String pZrntntusycd, String pZrnsyono) {
        ZT_YuseiMinyuKykDtlSyokaiRn zT_YuseiMinyuKykDtlSyokaiRn =  new ZT_YuseiMinyuKykDtlSyokaiRn();
        zT_YuseiMinyuKykDtlSyokaiRn.setZrnsakuseiym(pZrnsakuseiym);
        zT_YuseiMinyuKykDtlSyokaiRn.setZrnbsydrtencd(pZrnbsydrtencd);
        zT_YuseiMinyuKykDtlSyokaiRn.setZrntntusycd(pZrntntusycd);
        zT_YuseiMinyuKykDtlSyokaiRn.setZrnsyono(pZrnsyono);
        return this.selectOne(zT_YuseiMinyuKykDtlSyokaiRn);
    }

    public ExDBResults<ZT_YuseiMinyuKykDtlSyokaiRn> selectAllZT_YuseiMinyuKykDtlSyokaiRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_YuseiMinyuKykDtlSyokaiRn qZT_YuseiMinyuKykDtlSyokaiRn =  new QZT_YuseiMinyuKykDtlSyokaiRn();
        jpql.append($SELECT);
        jpql.append(qZT_YuseiMinyuKykDtlSyokaiRn);
        jpql.append($FROM);
        jpql.append(qZT_YuseiMinyuKykDtlSyokaiRn.ZT_YuseiMinyuKykDtlSyokaiRn());
        jpql.append($ORDER_BY(qZT_YuseiMinyuKykDtlSyokaiRn.zrnsakuseiym.asc(), qZT_YuseiMinyuKykDtlSyokaiRn.zrnbsydrtencd.asc(), qZT_YuseiMinyuKykDtlSyokaiRn.zrntntusycd.asc(), qZT_YuseiMinyuKykDtlSyokaiRn.zrnsyono.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_YuseiMinyuKykDtlSyokaiRn).getResults();
    }
}
