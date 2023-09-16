package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_IjiToukeiIdouInfoTr;
import yuyu.def.db.meta.QZT_IjiToukeiIdouInfoTr;

/**
 * 医事統計異動情報テーブル（取）(ZT_IjiToukeiIdouInfoTrDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_IjiToukeiIdouInfoTrDao extends AbstractDao<ZT_IjiToukeiIdouInfoTr> {

    public ZT_IjiToukeiIdouInfoTrDao() {
        super(ZT_IjiToukeiIdouInfoTr.class);
    }

    public ZT_IjiToukeiIdouInfoTr getIjiToukeiIdouInfoTr(String pZtrsyono, Integer pZtrkykmfksnctr) {
        ZT_IjiToukeiIdouInfoTr zT_IjiToukeiIdouInfoTr =  new ZT_IjiToukeiIdouInfoTr();
        zT_IjiToukeiIdouInfoTr.setZtrsyono(pZtrsyono);
        zT_IjiToukeiIdouInfoTr.setZtrkykmfksnctr(pZtrkykmfksnctr);
        return this.selectOne(zT_IjiToukeiIdouInfoTr);
    }

    public ExDBResults<ZT_IjiToukeiIdouInfoTr> selectAllZT_IjiToukeiIdouInfoTr() {
        StringBuilder jpql = new StringBuilder();
        QZT_IjiToukeiIdouInfoTr qZT_IjiToukeiIdouInfoTr =  new QZT_IjiToukeiIdouInfoTr();
        jpql.append($SELECT);
        jpql.append(qZT_IjiToukeiIdouInfoTr);
        jpql.append($FROM);
        jpql.append(qZT_IjiToukeiIdouInfoTr.ZT_IjiToukeiIdouInfoTr());
        jpql.append($ORDER_BY(qZT_IjiToukeiIdouInfoTr.ztrsyono.asc(), qZT_IjiToukeiIdouInfoTr.ztrkykmfksnctr.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_IjiToukeiIdouInfoTr).getResults();
    }
}
