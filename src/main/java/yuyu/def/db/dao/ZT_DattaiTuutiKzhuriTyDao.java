package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_DattaiTuutiKzhuriTy;
import yuyu.def.db.meta.QZT_DattaiTuutiKzhuriTy;

/**
 * 脱退通知（口座振替）テーブル（中）(ZT_DattaiTuutiKzhuriTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_DattaiTuutiKzhuriTyDao extends AbstractDao<ZT_DattaiTuutiKzhuriTy> {

    public ZT_DattaiTuutiKzhuriTyDao() {
        super(ZT_DattaiTuutiKzhuriTy.class);
    }

    public ZT_DattaiTuutiKzhuriTy getDattaiTuutiKzhuriTy(String pZtytyouhyouymd, String pZtysyono) {
        ZT_DattaiTuutiKzhuriTy zT_DattaiTuutiKzhuriTy =  new ZT_DattaiTuutiKzhuriTy();
        zT_DattaiTuutiKzhuriTy.setZtytyouhyouymd(pZtytyouhyouymd);
        zT_DattaiTuutiKzhuriTy.setZtysyono(pZtysyono);
        return this.selectOne(zT_DattaiTuutiKzhuriTy);
    }

    public ExDBResults<ZT_DattaiTuutiKzhuriTy> selectAllZT_DattaiTuutiKzhuriTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_DattaiTuutiKzhuriTy qZT_DattaiTuutiKzhuriTy =  new QZT_DattaiTuutiKzhuriTy();
        jpql.append($SELECT);
        jpql.append(qZT_DattaiTuutiKzhuriTy);
        jpql.append($FROM);
        jpql.append(qZT_DattaiTuutiKzhuriTy.ZT_DattaiTuutiKzhuriTy());
        jpql.append($ORDER_BY(qZT_DattaiTuutiKzhuriTy.ztytyouhyouymd.asc(), qZT_DattaiTuutiKzhuriTy.ztysyono.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_DattaiTuutiKzhuriTy).getResults();
    }
}
