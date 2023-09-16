package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_KzhuriAnnaiUlfRn;
import yuyu.def.db.meta.QZT_KzhuriAnnaiUlfRn;

/**
 * 口座振替案内ＵＬＦテーブル（連）(ZT_KzhuriAnnaiUlfRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_KzhuriAnnaiUlfRnDao extends AbstractDao<ZT_KzhuriAnnaiUlfRn> {

    public ZT_KzhuriAnnaiUlfRnDao() {
        super(ZT_KzhuriAnnaiUlfRn.class);
    }

    public ZT_KzhuriAnnaiUlfRn getKzhuriAnnaiUlfRn(String pZrnsyono, String pZrnjyuutouym) {
        ZT_KzhuriAnnaiUlfRn zT_KzhuriAnnaiUlfRn =  new ZT_KzhuriAnnaiUlfRn();
        zT_KzhuriAnnaiUlfRn.setZrnsyono(pZrnsyono);
        zT_KzhuriAnnaiUlfRn.setZrnjyuutouym(pZrnjyuutouym);
        return this.selectOne(zT_KzhuriAnnaiUlfRn);
    }

    public ExDBResults<ZT_KzhuriAnnaiUlfRn> selectAllZT_KzhuriAnnaiUlfRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_KzhuriAnnaiUlfRn qZT_KzhuriAnnaiUlfRn =  new QZT_KzhuriAnnaiUlfRn();
        jpql.append($SELECT);
        jpql.append(qZT_KzhuriAnnaiUlfRn);
        jpql.append($FROM);
        jpql.append(qZT_KzhuriAnnaiUlfRn.ZT_KzhuriAnnaiUlfRn());
        jpql.append($ORDER_BY(qZT_KzhuriAnnaiUlfRn.zrnsyono.asc(), qZT_KzhuriAnnaiUlfRn.zrnjyuutouym.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_KzhuriAnnaiUlfRn).getResults();
    }
}
