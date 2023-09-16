package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_TuukabetuKyuusibiRn;
import yuyu.def.db.meta.QZT_TuukabetuKyuusibiRn;

/**
 * 通貨別休止日取扱休止日Ｆテーブル（連）(ZT_TuukabetuKyuusibiRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_TuukabetuKyuusibiRnDao extends AbstractDao<ZT_TuukabetuKyuusibiRn> {

    public ZT_TuukabetuKyuusibiRnDao() {
        super(ZT_TuukabetuKyuusibiRn.class);
    }

    public ZT_TuukabetuKyuusibiRn getTuukabetuKyuusibiRn(String pZrntekiyouymd) {
        ZT_TuukabetuKyuusibiRn zT_TuukabetuKyuusibiRn =  new ZT_TuukabetuKyuusibiRn();
        zT_TuukabetuKyuusibiRn.setZrntekiyouymd(pZrntekiyouymd);
        return this.selectOne(zT_TuukabetuKyuusibiRn);
    }

    public ExDBResults<ZT_TuukabetuKyuusibiRn> selectAllZT_TuukabetuKyuusibiRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_TuukabetuKyuusibiRn qZT_TuukabetuKyuusibiRn =  new QZT_TuukabetuKyuusibiRn();
        jpql.append($SELECT);
        jpql.append(qZT_TuukabetuKyuusibiRn);
        jpql.append($FROM);
        jpql.append(qZT_TuukabetuKyuusibiRn.ZT_TuukabetuKyuusibiRn());
        jpql.append($ORDER_BY(qZT_TuukabetuKyuusibiRn.zrntekiyouymd.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_TuukabetuKyuusibiRn).getResults();
    }

    public Long getTuukabetuKyuusibiRnCount(){


        QZT_TuukabetuKyuusibiRn qZT_TuukabetuKyuusibiRn = new QZT_TuukabetuKyuusibiRn();


        String strSql = $SELECT + $COUNT(qZT_TuukabetuKyuusibiRn.zrntekiyouymd) +
            $FROM + qZT_TuukabetuKyuusibiRn.ZT_TuukabetuKyuusibiRn();


        return em.createJPQL(strSql).bind(qZT_TuukabetuKyuusibiRn).getSingleResult();
    }
}
