package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_IjiToukeiIdouInfoRn;
import yuyu.def.db.meta.QZT_IjiToukeiIdouInfoRn;

/**
 * 医事統計異動情報テーブル（連）(ZT_IjiToukeiIdouInfoRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_IjiToukeiIdouInfoRnDao extends AbstractDao<ZT_IjiToukeiIdouInfoRn> {

    public ZT_IjiToukeiIdouInfoRnDao() {
        super(ZT_IjiToukeiIdouInfoRn.class);
    }

    public ZT_IjiToukeiIdouInfoRn getIjiToukeiIdouInfoRn(String pZrnsyono, Integer pZrnkykmfksnctr) {
        ZT_IjiToukeiIdouInfoRn zT_IjiToukeiIdouInfoRn =  new ZT_IjiToukeiIdouInfoRn();
        zT_IjiToukeiIdouInfoRn.setZrnsyono(pZrnsyono);
        zT_IjiToukeiIdouInfoRn.setZrnkykmfksnctr(pZrnkykmfksnctr);
        return this.selectOne(zT_IjiToukeiIdouInfoRn);
    }

    public ExDBResults<ZT_IjiToukeiIdouInfoRn> selectAllZT_IjiToukeiIdouInfoRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_IjiToukeiIdouInfoRn qZT_IjiToukeiIdouInfoRn =  new QZT_IjiToukeiIdouInfoRn();
        jpql.append($SELECT);
        jpql.append(qZT_IjiToukeiIdouInfoRn);
        jpql.append($FROM);
        jpql.append(qZT_IjiToukeiIdouInfoRn.ZT_IjiToukeiIdouInfoRn());
        jpql.append($ORDER_BY(qZT_IjiToukeiIdouInfoRn.zrnsyono.asc(), qZT_IjiToukeiIdouInfoRn.zrnkykmfksnctr.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_IjiToukeiIdouInfoRn).getResults();
    }
}
