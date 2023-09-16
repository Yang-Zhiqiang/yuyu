package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_DattaiTuutiKzhuriRn;
import yuyu.def.db.meta.QZT_DattaiTuutiKzhuriRn;

/**
 * 脱退通知（口座振替）テーブル（連）(ZT_DattaiTuutiKzhuriRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_DattaiTuutiKzhuriRnDao extends AbstractDao<ZT_DattaiTuutiKzhuriRn> {

    public ZT_DattaiTuutiKzhuriRnDao() {
        super(ZT_DattaiTuutiKzhuriRn.class);
    }

    public ZT_DattaiTuutiKzhuriRn getDattaiTuutiKzhuriRn(String pZrntyouhyouymd, String pZrnsyono) {
        ZT_DattaiTuutiKzhuriRn zT_DattaiTuutiKzhuriRn =  new ZT_DattaiTuutiKzhuriRn();
        zT_DattaiTuutiKzhuriRn.setZrntyouhyouymd(pZrntyouhyouymd);
        zT_DattaiTuutiKzhuriRn.setZrnsyono(pZrnsyono);
        return this.selectOne(zT_DattaiTuutiKzhuriRn);
    }

    public ExDBResults<ZT_DattaiTuutiKzhuriRn> selectAllZT_DattaiTuutiKzhuriRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_DattaiTuutiKzhuriRn qZT_DattaiTuutiKzhuriRn =  new QZT_DattaiTuutiKzhuriRn();
        jpql.append($SELECT);
        jpql.append(qZT_DattaiTuutiKzhuriRn);
        jpql.append($FROM);
        jpql.append(qZT_DattaiTuutiKzhuriRn.ZT_DattaiTuutiKzhuriRn());
        jpql.append($ORDER_BY(qZT_DattaiTuutiKzhuriRn.zrntyouhyouymd.asc(), qZT_DattaiTuutiKzhuriRn.zrnsyono.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_DattaiTuutiKzhuriRn).getResults();
    }
}
