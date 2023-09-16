package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_FstpUriageSeikyuuDataRn;
import yuyu.def.db.meta.QZT_FstpUriageSeikyuuDataRn;

/**
 * 初回保険料売上請求データテーブル（連）(ZT_FstpUriageSeikyuuDataRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_FstpUriageSeikyuuDataRnDao extends AbstractDao<ZT_FstpUriageSeikyuuDataRn> {

    public ZT_FstpUriageSeikyuuDataRnDao() {
        super(ZT_FstpUriageSeikyuuDataRn.class);
    }

    public ZT_FstpUriageSeikyuuDataRn getFstpUriageSeikyuuDataRn(String pZrnuriageymd6keta, String pZrncreditkessaiyouno, String pZrnsyono, String pZrnrecordno, Long pZrnseikyuukngk11keta) {
        ZT_FstpUriageSeikyuuDataRn zT_FstpUriageSeikyuuDataRn =  new ZT_FstpUriageSeikyuuDataRn();
        zT_FstpUriageSeikyuuDataRn.setZrnuriageymd6keta(pZrnuriageymd6keta);
        zT_FstpUriageSeikyuuDataRn.setZrncreditkessaiyouno(pZrncreditkessaiyouno);
        zT_FstpUriageSeikyuuDataRn.setZrnsyono(pZrnsyono);
        zT_FstpUriageSeikyuuDataRn.setZrnrecordno(pZrnrecordno);
        zT_FstpUriageSeikyuuDataRn.setZrnseikyuukngk11keta(pZrnseikyuukngk11keta);
        return this.selectOne(zT_FstpUriageSeikyuuDataRn);
    }

    public ExDBResults<ZT_FstpUriageSeikyuuDataRn> selectAllZT_FstpUriageSeikyuuDataRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_FstpUriageSeikyuuDataRn qZT_FstpUriageSeikyuuDataRn =  new QZT_FstpUriageSeikyuuDataRn();
        jpql.append($SELECT);
        jpql.append(qZT_FstpUriageSeikyuuDataRn);
        jpql.append($FROM);
        jpql.append(qZT_FstpUriageSeikyuuDataRn.ZT_FstpUriageSeikyuuDataRn());
        jpql.append($ORDER_BY(qZT_FstpUriageSeikyuuDataRn.zrnuriageymd6keta.asc(), qZT_FstpUriageSeikyuuDataRn.zrncreditkessaiyouno.asc(), qZT_FstpUriageSeikyuuDataRn.zrnsyono.asc(), qZT_FstpUriageSeikyuuDataRn.zrnrecordno.asc(), qZT_FstpUriageSeikyuuDataRn.zrnseikyuukngk11keta.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_FstpUriageSeikyuuDataRn).getResults();
    }
}
