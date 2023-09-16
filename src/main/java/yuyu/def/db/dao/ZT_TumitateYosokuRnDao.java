package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_TumitateYosokuRn;
import yuyu.def.db.meta.QZT_TumitateYosokuRn;

/**
 * 積立金額予測ファイルテーブル（連）(ZT_TumitateYosokuRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_TumitateYosokuRnDao extends AbstractDao<ZT_TumitateYosokuRn> {

    public ZT_TumitateYosokuRnDao() {
        super(ZT_TumitateYosokuRn.class);
    }

    public ZT_TumitateYosokuRn getTumitateYosokuRn(String pZrnhknsyukigou, String pZrnkeiyakuymd, String pZrntysytymd, String pZrnkyktuukasyu, String pZrnhknkkn, String pZrntmttknsyuruikbn, String pZrnsisuukbn) {
        ZT_TumitateYosokuRn zT_TumitateYosokuRn =  new ZT_TumitateYosokuRn();
        zT_TumitateYosokuRn.setZrnhknsyukigou(pZrnhknsyukigou);
        zT_TumitateYosokuRn.setZrnkeiyakuymd(pZrnkeiyakuymd);
        zT_TumitateYosokuRn.setZrntysytymd(pZrntysytymd);
        zT_TumitateYosokuRn.setZrnkyktuukasyu(pZrnkyktuukasyu);
        zT_TumitateYosokuRn.setZrnhknkkn(pZrnhknkkn);
        zT_TumitateYosokuRn.setZrntmttknsyuruikbn(pZrntmttknsyuruikbn);
        zT_TumitateYosokuRn.setZrnsisuukbn(pZrnsisuukbn);
        return this.selectOne(zT_TumitateYosokuRn);
    }

    public ExDBResults<ZT_TumitateYosokuRn> selectAllZT_TumitateYosokuRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_TumitateYosokuRn qZT_TumitateYosokuRn =  new QZT_TumitateYosokuRn();
        jpql.append($SELECT);
        jpql.append(qZT_TumitateYosokuRn);
        jpql.append($FROM);
        jpql.append(qZT_TumitateYosokuRn.ZT_TumitateYosokuRn());
        jpql.append($ORDER_BY(qZT_TumitateYosokuRn.zrnhknsyukigou.asc(), qZT_TumitateYosokuRn.zrnkeiyakuymd.asc(), qZT_TumitateYosokuRn.zrntysytymd.asc(), qZT_TumitateYosokuRn.zrnkyktuukasyu.asc(), qZT_TumitateYosokuRn.zrnhknkkn.asc(), qZT_TumitateYosokuRn.zrntmttknsyuruikbn.asc(), qZT_TumitateYosokuRn.zrnsisuukbn.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_TumitateYosokuRn).getResults();
    }
}
