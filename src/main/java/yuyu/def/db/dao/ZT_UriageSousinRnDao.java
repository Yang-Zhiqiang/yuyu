package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_UriageSousinRn;
import yuyu.def.db.meta.QZT_UriageSousinRn;

/**
 * 売上送信Ｆテーブル（連）(ZT_UriageSousinRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_UriageSousinRnDao extends AbstractDao<ZT_UriageSousinRn> {

    public ZT_UriageSousinRnDao() {
        super(ZT_UriageSousinRn.class);
    }

    public ZT_UriageSousinRn getUriageSousinRn(String pZrncreditkessaiyouno, String pZrnsyono, String pZrnuriageseikyuuymd, Long pZrnrsgaku, String pZrnrecordno) {
        ZT_UriageSousinRn zT_UriageSousinRn =  new ZT_UriageSousinRn();
        zT_UriageSousinRn.setZrncreditkessaiyouno(pZrncreditkessaiyouno);
        zT_UriageSousinRn.setZrnsyono(pZrnsyono);
        zT_UriageSousinRn.setZrnuriageseikyuuymd(pZrnuriageseikyuuymd);
        zT_UriageSousinRn.setZrnrsgaku(pZrnrsgaku);
        zT_UriageSousinRn.setZrnrecordno(pZrnrecordno);
        return this.selectOne(zT_UriageSousinRn);
    }

    public ExDBResults<ZT_UriageSousinRn> selectAllZT_UriageSousinRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_UriageSousinRn qZT_UriageSousinRn =  new QZT_UriageSousinRn();
        jpql.append($SELECT);
        jpql.append(qZT_UriageSousinRn);
        jpql.append($FROM);
        jpql.append(qZT_UriageSousinRn.ZT_UriageSousinRn());
        jpql.append($ORDER_BY(qZT_UriageSousinRn.zrncreditkessaiyouno.asc(), qZT_UriageSousinRn.zrnsyono.asc(), qZT_UriageSousinRn.zrnuriageseikyuuymd.asc(), qZT_UriageSousinRn.zrnrsgaku.asc(), qZT_UriageSousinRn.zrnrecordno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_UriageSousinRn).getResults();
    }
}
