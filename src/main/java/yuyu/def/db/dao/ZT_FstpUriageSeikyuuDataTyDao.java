package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_FstpUriageSeikyuuDataTy;
import yuyu.def.db.meta.QZT_FstpUriageSeikyuuDataTy;

/**
 * 初回保険料売上請求データテーブル（中）(ZT_FstpUriageSeikyuuDataTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_FstpUriageSeikyuuDataTyDao extends AbstractDao<ZT_FstpUriageSeikyuuDataTy> {

    public ZT_FstpUriageSeikyuuDataTyDao() {
        super(ZT_FstpUriageSeikyuuDataTy.class);
    }

    public ZT_FstpUriageSeikyuuDataTy getFstpUriageSeikyuuDataTy(String pZtyuriageymd6keta, String pZtycreditkessaiyouno, String pZtysyono, String pZtyrecordno, Long pZtyseikyuukngk11keta) {
        ZT_FstpUriageSeikyuuDataTy zT_FstpUriageSeikyuuDataTy =  new ZT_FstpUriageSeikyuuDataTy();
        zT_FstpUriageSeikyuuDataTy.setZtyuriageymd6keta(pZtyuriageymd6keta);
        zT_FstpUriageSeikyuuDataTy.setZtycreditkessaiyouno(pZtycreditkessaiyouno);
        zT_FstpUriageSeikyuuDataTy.setZtysyono(pZtysyono);
        zT_FstpUriageSeikyuuDataTy.setZtyrecordno(pZtyrecordno);
        zT_FstpUriageSeikyuuDataTy.setZtyseikyuukngk11keta(pZtyseikyuukngk11keta);
        return this.selectOne(zT_FstpUriageSeikyuuDataTy);
    }

    public ExDBResults<ZT_FstpUriageSeikyuuDataTy> selectAllZT_FstpUriageSeikyuuDataTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_FstpUriageSeikyuuDataTy qZT_FstpUriageSeikyuuDataTy =  new QZT_FstpUriageSeikyuuDataTy();
        jpql.append($SELECT);
        jpql.append(qZT_FstpUriageSeikyuuDataTy);
        jpql.append($FROM);
        jpql.append(qZT_FstpUriageSeikyuuDataTy.ZT_FstpUriageSeikyuuDataTy());
        jpql.append($ORDER_BY(qZT_FstpUriageSeikyuuDataTy.ztyuriageymd6keta.asc(), qZT_FstpUriageSeikyuuDataTy.ztycreditkessaiyouno.asc(), qZT_FstpUriageSeikyuuDataTy.ztysyono.asc(), qZT_FstpUriageSeikyuuDataTy.ztyrecordno.asc(), qZT_FstpUriageSeikyuuDataTy.ztyseikyuukngk11keta.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_FstpUriageSeikyuuDataTy).getResults();
    }
}
