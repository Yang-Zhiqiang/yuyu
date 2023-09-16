package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_KzhuriSyuunouKekkaRn;
import yuyu.def.db.meta.QZT_KzhuriSyuunouKekkaRn;

/**
 * 口座振替収納結果Ｆテーブル（連）(ZT_KzhuriSyuunouKekkaRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_KzhuriSyuunouKekkaRnDao extends AbstractDao<ZT_KzhuriSyuunouKekkaRn> {

    public ZT_KzhuriSyuunouKekkaRnDao() {
        super(ZT_KzhuriSyuunouKekkaRn.class);
    }

    public ZT_KzhuriSyuunouKekkaRn getKzhuriSyuunouKekkaRn(String pZrnsyono, String pZrnjyuutouym) {
        ZT_KzhuriSyuunouKekkaRn zT_KzhuriSyuunouKekkaRn =  new ZT_KzhuriSyuunouKekkaRn();
        zT_KzhuriSyuunouKekkaRn.setZrnsyono(pZrnsyono);
        zT_KzhuriSyuunouKekkaRn.setZrnjyuutouym(pZrnjyuutouym);
        return this.selectOne(zT_KzhuriSyuunouKekkaRn);
    }

    public ExDBResults<ZT_KzhuriSyuunouKekkaRn> selectAllZT_KzhuriSyuunouKekkaRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_KzhuriSyuunouKekkaRn qZT_KzhuriSyuunouKekkaRn =  new QZT_KzhuriSyuunouKekkaRn();
        jpql.append($SELECT);
        jpql.append(qZT_KzhuriSyuunouKekkaRn);
        jpql.append($FROM);
        jpql.append(qZT_KzhuriSyuunouKekkaRn.ZT_KzhuriSyuunouKekkaRn());
        jpql.append($ORDER_BY(qZT_KzhuriSyuunouKekkaRn.zrnsyono.asc(), qZT_KzhuriSyuunouKekkaRn.zrnjyuutouym.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_KzhuriSyuunouKekkaRn).getResults();
    }
}
