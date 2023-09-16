package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_SntkInfoHaneiKekkaRn;
import yuyu.def.db.meta.QZT_SntkInfoHaneiKekkaRn;

/**
 * 普保Ⅱ選択情報反映結果テーブル（連）(ZT_SntkInfoHaneiKekkaRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_SntkInfoHaneiKekkaRnDao extends AbstractDao<ZT_SntkInfoHaneiKekkaRn> {

    public ZT_SntkInfoHaneiKekkaRnDao() {
        super(ZT_SntkInfoHaneiKekkaRn.class);
    }

    public ZT_SntkInfoHaneiKekkaRn getSntkInfoHaneiKekkaRn(String pZrnsntkinfono, String pZrnrenno, String pZrnsntkinfotourokusyskbn) {
        ZT_SntkInfoHaneiKekkaRn zT_SntkInfoHaneiKekkaRn =  new ZT_SntkInfoHaneiKekkaRn();
        zT_SntkInfoHaneiKekkaRn.setZrnsntkinfono(pZrnsntkinfono);
        zT_SntkInfoHaneiKekkaRn.setZrnrenno(pZrnrenno);
        zT_SntkInfoHaneiKekkaRn.setZrnsntkinfotourokusyskbn(pZrnsntkinfotourokusyskbn);
        return this.selectOne(zT_SntkInfoHaneiKekkaRn);
    }

    public ExDBResults<ZT_SntkInfoHaneiKekkaRn> selectAllZT_SntkInfoHaneiKekkaRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_SntkInfoHaneiKekkaRn qZT_SntkInfoHaneiKekkaRn =  new QZT_SntkInfoHaneiKekkaRn();
        jpql.append($SELECT);
        jpql.append(qZT_SntkInfoHaneiKekkaRn);
        jpql.append($FROM);
        jpql.append(qZT_SntkInfoHaneiKekkaRn.ZT_SntkInfoHaneiKekkaRn());
        jpql.append($ORDER_BY(qZT_SntkInfoHaneiKekkaRn.zrnsntkinfono.asc(), qZT_SntkInfoHaneiKekkaRn.zrnrenno.asc(), qZT_SntkInfoHaneiKekkaRn.zrnsntkinfotourokusyskbn.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_SntkInfoHaneiKekkaRn).getResults();
    }
}
