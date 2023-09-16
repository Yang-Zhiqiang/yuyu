package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_GaikaKokyakuTuutiRn;
import yuyu.def.db.meta.QZT_GaikaKokyakuTuutiRn;

/**
 * 外貨建顧客通知Ｆテーブル（連）(ZT_GaikaKokyakuTuutiRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_GaikaKokyakuTuutiRnDao extends AbstractDao<ZT_GaikaKokyakuTuutiRn> {

    public ZT_GaikaKokyakuTuutiRnDao() {
        super(ZT_GaikaKokyakuTuutiRn.class);
    }

    public ZT_GaikaKokyakuTuutiRn getGaikaKokyakuTuutiRn(String pZrntyouhyouymd, String pZrnsyono) {
        ZT_GaikaKokyakuTuutiRn zT_GaikaKokyakuTuutiRn =  new ZT_GaikaKokyakuTuutiRn();
        zT_GaikaKokyakuTuutiRn.setZrntyouhyouymd(pZrntyouhyouymd);
        zT_GaikaKokyakuTuutiRn.setZrnsyono(pZrnsyono);
        return this.selectOne(zT_GaikaKokyakuTuutiRn);
    }

    public ExDBResults<ZT_GaikaKokyakuTuutiRn> selectAllZT_GaikaKokyakuTuutiRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_GaikaKokyakuTuutiRn qZT_GaikaKokyakuTuutiRn =  new QZT_GaikaKokyakuTuutiRn();
        jpql.append($SELECT);
        jpql.append(qZT_GaikaKokyakuTuutiRn);
        jpql.append($FROM);
        jpql.append(qZT_GaikaKokyakuTuutiRn.ZT_GaikaKokyakuTuutiRn());
        jpql.append($ORDER_BY(qZT_GaikaKokyakuTuutiRn.zrntyouhyouymd.asc(), qZT_GaikaKokyakuTuutiRn.zrnsyono.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_GaikaKokyakuTuutiRn).getResults();
    }
}
