package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_NennkinRatepkisovRn;
import yuyu.def.db.meta.QZT_NennkinRatepkisovRn;

/**
 * 年金開始後Ｐ基礎Ｖレートテーブル（連）(ZT_NennkinRatepkisovRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_NennkinRatepkisovRnDao extends AbstractDao<ZT_NennkinRatepkisovRn> {

    public ZT_NennkinRatepkisovRnDao() {
        super(ZT_NennkinRatepkisovRn.class);
    }

    public ZT_NennkinRatepkisovRn getNennkinRatepkisovRn(String pZrnnenkinkbn, String pZrnnenkinsyu, String pZrnnenkinkigousedaikbn, String pZrnnknshry, String pZrnnkkaisigoyoteiriritukbn, String pZrnnenkinjimutesuuryoukbn) {
        ZT_NennkinRatepkisovRn zT_NennkinRatepkisovRn =  new ZT_NennkinRatepkisovRn();
        zT_NennkinRatepkisovRn.setZrnnenkinkbn(pZrnnenkinkbn);
        zT_NennkinRatepkisovRn.setZrnnenkinsyu(pZrnnenkinsyu);
        zT_NennkinRatepkisovRn.setZrnnenkinkigousedaikbn(pZrnnenkinkigousedaikbn);
        zT_NennkinRatepkisovRn.setZrnnknshry(pZrnnknshry);
        zT_NennkinRatepkisovRn.setZrnnkkaisigoyoteiriritukbn(pZrnnkkaisigoyoteiriritukbn);
        zT_NennkinRatepkisovRn.setZrnnenkinjimutesuuryoukbn(pZrnnenkinjimutesuuryoukbn);
        return this.selectOne(zT_NennkinRatepkisovRn);
    }

    public ExDBResults<ZT_NennkinRatepkisovRn> selectAllZT_NennkinRatepkisovRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_NennkinRatepkisovRn qZT_NennkinRatepkisovRn =  new QZT_NennkinRatepkisovRn();
        jpql.append($SELECT);
        jpql.append(qZT_NennkinRatepkisovRn);
        jpql.append($FROM);
        jpql.append(qZT_NennkinRatepkisovRn.ZT_NennkinRatepkisovRn());
        jpql.append($ORDER_BY(qZT_NennkinRatepkisovRn.zrnnenkinkbn.asc(), qZT_NennkinRatepkisovRn.zrnnenkinsyu.asc(), qZT_NennkinRatepkisovRn.zrnnenkinkigousedaikbn.asc(), qZT_NennkinRatepkisovRn.zrnnknshry.asc(), qZT_NennkinRatepkisovRn.zrnnkkaisigoyoteiriritukbn.asc(), qZT_NennkinRatepkisovRn.zrnnenkinjimutesuuryoukbn.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_NennkinRatepkisovRn).getResults();
    }
}
