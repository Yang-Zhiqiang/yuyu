package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_FstpUriageSeikyuuKekkaTr;
import yuyu.def.db.meta.QZT_FstpUriageSeikyuuKekkaTr;

/**
 * 初回保険料売上請求結果テーブル（取）(ZT_FstpUriageSeikyuuKekkaTrDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_FstpUriageSeikyuuKekkaTrDao extends AbstractDao<ZT_FstpUriageSeikyuuKekkaTr> {

    public ZT_FstpUriageSeikyuuKekkaTrDao() {
        super(ZT_FstpUriageSeikyuuKekkaTr.class);
    }

    public ZT_FstpUriageSeikyuuKekkaTr getFstpUriageSeikyuuKekkaTr(String pZtruriageymd6keta, String pZtrcreditkessaiyouno, String pZtrsyono, String pZtrrecordno, Long pZtrseikyuukngk) {
        ZT_FstpUriageSeikyuuKekkaTr zT_FstpUriageSeikyuuKekkaTr =  new ZT_FstpUriageSeikyuuKekkaTr();
        zT_FstpUriageSeikyuuKekkaTr.setZtruriageymd6keta(pZtruriageymd6keta);
        zT_FstpUriageSeikyuuKekkaTr.setZtrcreditkessaiyouno(pZtrcreditkessaiyouno);
        zT_FstpUriageSeikyuuKekkaTr.setZtrsyono(pZtrsyono);
        zT_FstpUriageSeikyuuKekkaTr.setZtrrecordno(pZtrrecordno);
        zT_FstpUriageSeikyuuKekkaTr.setZtrseikyuukngk(pZtrseikyuukngk);
        return this.selectOne(zT_FstpUriageSeikyuuKekkaTr);
    }

    public ExDBResults<ZT_FstpUriageSeikyuuKekkaTr> selectAllZT_FstpUriageSeikyuuKekkaTr() {
        StringBuilder jpql = new StringBuilder();
        QZT_FstpUriageSeikyuuKekkaTr qZT_FstpUriageSeikyuuKekkaTr =  new QZT_FstpUriageSeikyuuKekkaTr();
        jpql.append($SELECT);
        jpql.append(qZT_FstpUriageSeikyuuKekkaTr);
        jpql.append($FROM);
        jpql.append(qZT_FstpUriageSeikyuuKekkaTr.ZT_FstpUriageSeikyuuKekkaTr());
        jpql.append($ORDER_BY(qZT_FstpUriageSeikyuuKekkaTr.ztruriageymd6keta.asc(), qZT_FstpUriageSeikyuuKekkaTr.ztrcreditkessaiyouno.asc(), qZT_FstpUriageSeikyuuKekkaTr.ztrsyono.asc(), qZT_FstpUriageSeikyuuKekkaTr.ztrrecordno.asc(), qZT_FstpUriageSeikyuuKekkaTr.ztrseikyuukngk.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_FstpUriageSeikyuuKekkaTr).getResults();
    }
}
