package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_KzhuriSyuunouKekkaTr;
import yuyu.def.db.meta.QZT_KzhuriSyuunouKekkaTr;

/**
 * 口座振替収納結果Ｆテーブル（取）(ZT_KzhuriSyuunouKekkaTrDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_KzhuriSyuunouKekkaTrDao extends AbstractDao<ZT_KzhuriSyuunouKekkaTr> {

    public ZT_KzhuriSyuunouKekkaTrDao() {
        super(ZT_KzhuriSyuunouKekkaTr.class);
    }

    public ZT_KzhuriSyuunouKekkaTr getKzhuriSyuunouKekkaTr(String pZtrsyono, String pZtrjyuutouym) {
        ZT_KzhuriSyuunouKekkaTr zT_KzhuriSyuunouKekkaTr =  new ZT_KzhuriSyuunouKekkaTr();
        zT_KzhuriSyuunouKekkaTr.setZtrsyono(pZtrsyono);
        zT_KzhuriSyuunouKekkaTr.setZtrjyuutouym(pZtrjyuutouym);
        return this.selectOne(zT_KzhuriSyuunouKekkaTr);
    }

    public ExDBResults<ZT_KzhuriSyuunouKekkaTr> selectAllZT_KzhuriSyuunouKekkaTr() {
        StringBuilder jpql = new StringBuilder();
        QZT_KzhuriSyuunouKekkaTr qZT_KzhuriSyuunouKekkaTr =  new QZT_KzhuriSyuunouKekkaTr();
        jpql.append($SELECT);
        jpql.append(qZT_KzhuriSyuunouKekkaTr);
        jpql.append($FROM);
        jpql.append(qZT_KzhuriSyuunouKekkaTr.ZT_KzhuriSyuunouKekkaTr());
        jpql.append($ORDER_BY(qZT_KzhuriSyuunouKekkaTr.ztrsyono.asc(), qZT_KzhuriSyuunouKekkaTr.ztrjyuutouym.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_KzhuriSyuunouKekkaTr).getResults();
    }
}
