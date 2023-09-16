package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_SinkimatuHoyuuFRn;
import yuyu.def.db.meta.QZT_SinkimatuHoyuuFRn;

/**
 * 新期末保有Ｆテーブル（連）(ZT_SinkimatuHoyuuFRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_SinkimatuHoyuuFRnDao extends AbstractDao<ZT_SinkimatuHoyuuFRn> {

    public ZT_SinkimatuHoyuuFRnDao() {
        super(ZT_SinkimatuHoyuuFRn.class);
    }

    public ZT_SinkimatuHoyuuFRn getSinkimatuHoyuuFRn(Integer pZrnsequenceno) {
        ZT_SinkimatuHoyuuFRn zT_SinkimatuHoyuuFRn =  new ZT_SinkimatuHoyuuFRn();
        zT_SinkimatuHoyuuFRn.setZrnsequenceno(pZrnsequenceno);
        return this.selectOne(zT_SinkimatuHoyuuFRn);
    }

    public ExDBResults<ZT_SinkimatuHoyuuFRn> selectAllZT_SinkimatuHoyuuFRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_SinkimatuHoyuuFRn qZT_SinkimatuHoyuuFRn =  new QZT_SinkimatuHoyuuFRn();
        jpql.append($SELECT);
        jpql.append(qZT_SinkimatuHoyuuFRn);
        jpql.append($FROM);
        jpql.append(qZT_SinkimatuHoyuuFRn.ZT_SinkimatuHoyuuFRn());
        jpql.append($ORDER_BY(qZT_SinkimatuHoyuuFRn.zrnsequenceno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_SinkimatuHoyuuFRn).getResults();
    }
}
