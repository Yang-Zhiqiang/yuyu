package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_UriageKekkaRn;
import yuyu.def.db.meta.QZT_UriageKekkaRn;

/**
 * 売上結果Ｆテーブル（連）(ZT_UriageKekkaRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_UriageKekkaRnDao extends AbstractDao<ZT_UriageKekkaRn> {

    public ZT_UriageKekkaRnDao() {
        super(ZT_UriageKekkaRn.class);
    }

    public ZT_UriageKekkaRn getUriageKekkaRn(String pZrnsyono, String pZrncreditkessaiyouno, String pZrnuriageymd6keta, String pZrnrecordno, Long pZrnseikyuukngk) {
        ZT_UriageKekkaRn zT_UriageKekkaRn =  new ZT_UriageKekkaRn();
        zT_UriageKekkaRn.setZrnsyono(pZrnsyono);
        zT_UriageKekkaRn.setZrncreditkessaiyouno(pZrncreditkessaiyouno);
        zT_UriageKekkaRn.setZrnuriageymd6keta(pZrnuriageymd6keta);
        zT_UriageKekkaRn.setZrnrecordno(pZrnrecordno);
        zT_UriageKekkaRn.setZrnseikyuukngk(pZrnseikyuukngk);
        return this.selectOne(zT_UriageKekkaRn);
    }

    public ExDBResults<ZT_UriageKekkaRn> selectAllZT_UriageKekkaRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_UriageKekkaRn qZT_UriageKekkaRn =  new QZT_UriageKekkaRn();
        jpql.append($SELECT);
        jpql.append(qZT_UriageKekkaRn);
        jpql.append($FROM);
        jpql.append(qZT_UriageKekkaRn.ZT_UriageKekkaRn());
        jpql.append($ORDER_BY(qZT_UriageKekkaRn.zrnsyono.asc(), qZT_UriageKekkaRn.zrncreditkessaiyouno.asc(), qZT_UriageKekkaRn.zrnuriageymd6keta.asc(), qZT_UriageKekkaRn.zrnrecordno.asc(), qZT_UriageKekkaRn.zrnseikyuukngk.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_UriageKekkaRn).getResults();
    }
}
