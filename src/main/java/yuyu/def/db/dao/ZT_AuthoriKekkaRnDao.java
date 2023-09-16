package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_AuthoriKekkaRn;
import yuyu.def.db.meta.QZT_AuthoriKekkaRn;

/**
 * オーソリ結果Ｆテーブル（連）(ZT_AuthoriKekkaRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_AuthoriKekkaRnDao extends AbstractDao<ZT_AuthoriKekkaRn> {

    public ZT_AuthoriKekkaRnDao() {
        super(ZT_AuthoriKekkaRn.class);
    }

    public ZT_AuthoriKekkaRn getAuthoriKekkaRn(String pZrnrenno7, String pZrncreditkessaiyouno, String pZrndatajyusinymd) {
        ZT_AuthoriKekkaRn zT_AuthoriKekkaRn =  new ZT_AuthoriKekkaRn();
        zT_AuthoriKekkaRn.setZrnrenno7(pZrnrenno7);
        zT_AuthoriKekkaRn.setZrncreditkessaiyouno(pZrncreditkessaiyouno);
        zT_AuthoriKekkaRn.setZrndatajyusinymd(pZrndatajyusinymd);
        return this.selectOne(zT_AuthoriKekkaRn);
    }

    public ExDBResults<ZT_AuthoriKekkaRn> selectAllZT_AuthoriKekkaRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_AuthoriKekkaRn qZT_AuthoriKekkaRn =  new QZT_AuthoriKekkaRn();
        jpql.append($SELECT);
        jpql.append(qZT_AuthoriKekkaRn);
        jpql.append($FROM);
        jpql.append(qZT_AuthoriKekkaRn.ZT_AuthoriKekkaRn());
        jpql.append($ORDER_BY(qZT_AuthoriKekkaRn.zrnrenno7.asc(), qZT_AuthoriKekkaRn.zrncreditkessaiyouno.asc(), qZT_AuthoriKekkaRn.zrndatajyusinymd.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_AuthoriKekkaRn).getResults();
    }
}
