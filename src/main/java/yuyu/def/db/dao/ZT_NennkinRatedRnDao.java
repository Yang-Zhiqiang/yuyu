package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_NennkinRatedRn;
import yuyu.def.db.meta.QZT_NennkinRatedRn;

/**
 * 年金開始後Ｄレートテーブル（連）(ZT_NennkinRatedRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_NennkinRatedRnDao extends AbstractDao<ZT_NennkinRatedRn> {

    public ZT_NennkinRatedRnDao() {
        super(ZT_NennkinRatedRn.class);
    }

    public ZT_NennkinRatedRn getNennkinRatedRn(String pZrnnenkinkbn, String pZrnnenkinsyu, String pZrnnenkinkigousedaikbn, String pZrnnknshry, String pZrnnkkaisigoyoteiriritukbn, String pZrnnenkinjimutesuuryoukbn, String pZrndnendo, String pZrnnaiteikakuteikbn) {
        ZT_NennkinRatedRn zT_NennkinRatedRn =  new ZT_NennkinRatedRn();
        zT_NennkinRatedRn.setZrnnenkinkbn(pZrnnenkinkbn);
        zT_NennkinRatedRn.setZrnnenkinsyu(pZrnnenkinsyu);
        zT_NennkinRatedRn.setZrnnenkinkigousedaikbn(pZrnnenkinkigousedaikbn);
        zT_NennkinRatedRn.setZrnnknshry(pZrnnknshry);
        zT_NennkinRatedRn.setZrnnkkaisigoyoteiriritukbn(pZrnnkkaisigoyoteiriritukbn);
        zT_NennkinRatedRn.setZrnnenkinjimutesuuryoukbn(pZrnnenkinjimutesuuryoukbn);
        zT_NennkinRatedRn.setZrndnendo(pZrndnendo);
        zT_NennkinRatedRn.setZrnnaiteikakuteikbn(pZrnnaiteikakuteikbn);
        return this.selectOne(zT_NennkinRatedRn);
    }

    public ExDBResults<ZT_NennkinRatedRn> selectAllZT_NennkinRatedRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_NennkinRatedRn qZT_NennkinRatedRn =  new QZT_NennkinRatedRn();
        jpql.append($SELECT);
        jpql.append(qZT_NennkinRatedRn);
        jpql.append($FROM);
        jpql.append(qZT_NennkinRatedRn.ZT_NennkinRatedRn());
        jpql.append($ORDER_BY(qZT_NennkinRatedRn.zrnnenkinkbn.asc(), qZT_NennkinRatedRn.zrnnenkinsyu.asc(), qZT_NennkinRatedRn.zrnnenkinkigousedaikbn.asc(), qZT_NennkinRatedRn.zrnnknshry.asc(), qZT_NennkinRatedRn.zrnnkkaisigoyoteiriritukbn.asc(), qZT_NennkinRatedRn.zrnnenkinjimutesuuryoukbn.asc(), qZT_NennkinRatedRn.zrndnendo.asc(), qZT_NennkinRatedRn.zrnnaiteikakuteikbn.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_NennkinRatedRn).getResults();
    }
}
