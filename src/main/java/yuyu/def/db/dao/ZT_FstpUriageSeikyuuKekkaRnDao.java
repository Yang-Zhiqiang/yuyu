package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_FstpUriageSeikyuuKekkaRn;
import yuyu.def.db.meta.QZT_FstpUriageSeikyuuKekkaRn;

/**
 * 初回保険料売上請求結果テーブル（連）(ZT_FstpUriageSeikyuuKekkaRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_FstpUriageSeikyuuKekkaRnDao extends AbstractDao<ZT_FstpUriageSeikyuuKekkaRn> {

    public ZT_FstpUriageSeikyuuKekkaRnDao() {
        super(ZT_FstpUriageSeikyuuKekkaRn.class);
    }

    public ZT_FstpUriageSeikyuuKekkaRn getFstpUriageSeikyuuKekkaRn(String pZrnuriageymd6keta, String pZrncreditkessaiyouno, String pZrnsyono, String pZrnrecordno, Long pZrnseikyuukngk) {
        ZT_FstpUriageSeikyuuKekkaRn zT_FstpUriageSeikyuuKekkaRn =  new ZT_FstpUriageSeikyuuKekkaRn();
        zT_FstpUriageSeikyuuKekkaRn.setZrnuriageymd6keta(pZrnuriageymd6keta);
        zT_FstpUriageSeikyuuKekkaRn.setZrncreditkessaiyouno(pZrncreditkessaiyouno);
        zT_FstpUriageSeikyuuKekkaRn.setZrnsyono(pZrnsyono);
        zT_FstpUriageSeikyuuKekkaRn.setZrnrecordno(pZrnrecordno);
        zT_FstpUriageSeikyuuKekkaRn.setZrnseikyuukngk(pZrnseikyuukngk);
        return this.selectOne(zT_FstpUriageSeikyuuKekkaRn);
    }

    public ExDBResults<ZT_FstpUriageSeikyuuKekkaRn> selectAllZT_FstpUriageSeikyuuKekkaRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_FstpUriageSeikyuuKekkaRn qZT_FstpUriageSeikyuuKekkaRn =  new QZT_FstpUriageSeikyuuKekkaRn();
        jpql.append($SELECT);
        jpql.append(qZT_FstpUriageSeikyuuKekkaRn);
        jpql.append($FROM);
        jpql.append(qZT_FstpUriageSeikyuuKekkaRn.ZT_FstpUriageSeikyuuKekkaRn());
        jpql.append($ORDER_BY(qZT_FstpUriageSeikyuuKekkaRn.zrnuriageymd6keta.asc(), qZT_FstpUriageSeikyuuKekkaRn.zrncreditkessaiyouno.asc(), qZT_FstpUriageSeikyuuKekkaRn.zrnsyono.asc(), qZT_FstpUriageSeikyuuKekkaRn.zrnrecordno.asc(), qZT_FstpUriageSeikyuuKekkaRn.zrnseikyuukngk.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_FstpUriageSeikyuuKekkaRn).getResults();
    }
}
