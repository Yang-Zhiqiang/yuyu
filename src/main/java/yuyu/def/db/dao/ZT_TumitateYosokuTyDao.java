package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_TumitateYosokuTy;
import yuyu.def.db.meta.QZT_TumitateYosokuTy;

/**
 * 積立金額予測ファイルテーブル（中）(ZT_TumitateYosokuTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_TumitateYosokuTyDao extends AbstractDao<ZT_TumitateYosokuTy> {

    public ZT_TumitateYosokuTyDao() {
        super(ZT_TumitateYosokuTy.class);
    }

    public ZT_TumitateYosokuTy getTumitateYosokuTy(String pZtyhknsyukigou, String pZtykeiyakuymd, String pZtytysytymd, String pZtykyktuukasyu, String pZtyhknkkn, String pZtytmttknsyuruikbn, String pZtysisuukbn) {
        ZT_TumitateYosokuTy zT_TumitateYosokuTy =  new ZT_TumitateYosokuTy();
        zT_TumitateYosokuTy.setZtyhknsyukigou(pZtyhknsyukigou);
        zT_TumitateYosokuTy.setZtykeiyakuymd(pZtykeiyakuymd);
        zT_TumitateYosokuTy.setZtytysytymd(pZtytysytymd);
        zT_TumitateYosokuTy.setZtykyktuukasyu(pZtykyktuukasyu);
        zT_TumitateYosokuTy.setZtyhknkkn(pZtyhknkkn);
        zT_TumitateYosokuTy.setZtytmttknsyuruikbn(pZtytmttknsyuruikbn);
        zT_TumitateYosokuTy.setZtysisuukbn(pZtysisuukbn);
        return this.selectOne(zT_TumitateYosokuTy);
    }

    public ExDBResults<ZT_TumitateYosokuTy> selectAllZT_TumitateYosokuTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_TumitateYosokuTy qZT_TumitateYosokuTy =  new QZT_TumitateYosokuTy();
        jpql.append($SELECT);
        jpql.append(qZT_TumitateYosokuTy);
        jpql.append($FROM);
        jpql.append(qZT_TumitateYosokuTy.ZT_TumitateYosokuTy());
        jpql.append($ORDER_BY(qZT_TumitateYosokuTy.ztyhknsyukigou.asc(), qZT_TumitateYosokuTy.ztykeiyakuymd.asc(), qZT_TumitateYosokuTy.ztytysytymd.asc(), qZT_TumitateYosokuTy.ztykyktuukasyu.asc(), qZT_TumitateYosokuTy.ztyhknkkn.asc(), qZT_TumitateYosokuTy.ztytmttknsyuruikbn.asc(), qZT_TumitateYosokuTy.ztysisuukbn.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_TumitateYosokuTy).getResults();
    }
}
