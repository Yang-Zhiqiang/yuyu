package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_SntkInfoTourokuTy;
import yuyu.def.db.meta.QZT_SntkInfoTourokuTy;

/**
 * 選択情報登録テーブル（中）(ZT_SntkInfoTourokuTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_SntkInfoTourokuTyDao extends AbstractDao<ZT_SntkInfoTourokuTy> {

    public ZT_SntkInfoTourokuTyDao() {
        super(ZT_SntkInfoTourokuTy.class);
    }

    public ZT_SntkInfoTourokuTy getSntkInfoTourokuTy(String pZtysntkinfono, String pZtyrenno, String pZtysntkinfotourokusyskbn) {
        ZT_SntkInfoTourokuTy zT_SntkInfoTourokuTy =  new ZT_SntkInfoTourokuTy();
        zT_SntkInfoTourokuTy.setZtysntkinfono(pZtysntkinfono);
        zT_SntkInfoTourokuTy.setZtyrenno(pZtyrenno);
        zT_SntkInfoTourokuTy.setZtysntkinfotourokusyskbn(pZtysntkinfotourokusyskbn);
        return this.selectOne(zT_SntkInfoTourokuTy);
    }

    public ExDBResults<ZT_SntkInfoTourokuTy> selectAllZT_SntkInfoTourokuTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_SntkInfoTourokuTy qZT_SntkInfoTourokuTy =  new QZT_SntkInfoTourokuTy();
        jpql.append($SELECT);
        jpql.append(qZT_SntkInfoTourokuTy);
        jpql.append($FROM);
        jpql.append(qZT_SntkInfoTourokuTy.ZT_SntkInfoTourokuTy());
        jpql.append($ORDER_BY(qZT_SntkInfoTourokuTy.ztysntkinfono.asc(), qZT_SntkInfoTourokuTy.ztyrenno.asc(), qZT_SntkInfoTourokuTy.ztysntkinfotourokusyskbn.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_SntkInfoTourokuTy).getResults();
    }
}
