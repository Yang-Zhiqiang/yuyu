package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_SntkInfoTourokuRn;
import yuyu.def.db.meta.QZT_SntkInfoTourokuRn;

/**
 * 選択情報登録テーブル（連）(ZT_SntkInfoTourokuRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_SntkInfoTourokuRnDao extends AbstractDao<ZT_SntkInfoTourokuRn> {

    public ZT_SntkInfoTourokuRnDao() {
        super(ZT_SntkInfoTourokuRn.class);
    }

    public ZT_SntkInfoTourokuRn getSntkInfoTourokuRn(String pZrnsntkinfono, String pZrnrenno, String pZrnsntkinfotourokusyskbn) {
        ZT_SntkInfoTourokuRn zT_SntkInfoTourokuRn =  new ZT_SntkInfoTourokuRn();
        zT_SntkInfoTourokuRn.setZrnsntkinfono(pZrnsntkinfono);
        zT_SntkInfoTourokuRn.setZrnrenno(pZrnrenno);
        zT_SntkInfoTourokuRn.setZrnsntkinfotourokusyskbn(pZrnsntkinfotourokusyskbn);
        return this.selectOne(zT_SntkInfoTourokuRn);
    }

    public ExDBResults<ZT_SntkInfoTourokuRn> selectAllZT_SntkInfoTourokuRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_SntkInfoTourokuRn qZT_SntkInfoTourokuRn =  new QZT_SntkInfoTourokuRn();
        jpql.append($SELECT);
        jpql.append(qZT_SntkInfoTourokuRn);
        jpql.append($FROM);
        jpql.append(qZT_SntkInfoTourokuRn.ZT_SntkInfoTourokuRn());
        jpql.append($ORDER_BY(qZT_SntkInfoTourokuRn.zrnsntkinfono.asc(), qZT_SntkInfoTourokuRn.zrnrenno.asc(), qZT_SntkInfoTourokuRn.zrnsntkinfotourokusyskbn.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_SntkInfoTourokuRn).getResults();
    }
}
