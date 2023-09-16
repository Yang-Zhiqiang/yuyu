package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_SinBosyuuDrtenHoyuuKykRn;
import yuyu.def.db.meta.QZT_SinBosyuuDrtenHoyuuKykRn;

/**
 * 代理店月次契約情報Ｆテーブル（連）(ZT_SinBosyuuDrtenHoyuuKykRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_SinBosyuuDrtenHoyuuKykRnDao extends AbstractDao<ZT_SinBosyuuDrtenHoyuuKykRn> {

    public ZT_SinBosyuuDrtenHoyuuKykRnDao() {
        super(ZT_SinBosyuuDrtenHoyuuKykRn.class);
    }

    public ZT_SinBosyuuDrtenHoyuuKykRn getSinBosyuuDrtenHoyuuKykRn(String pZrnsyono) {
        ZT_SinBosyuuDrtenHoyuuKykRn zT_SinBosyuuDrtenHoyuuKykRn =  new ZT_SinBosyuuDrtenHoyuuKykRn();
        zT_SinBosyuuDrtenHoyuuKykRn.setZrnsyono(pZrnsyono);
        return this.selectOne(zT_SinBosyuuDrtenHoyuuKykRn);
    }

    public ExDBResults<ZT_SinBosyuuDrtenHoyuuKykRn> selectAllZT_SinBosyuuDrtenHoyuuKykRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_SinBosyuuDrtenHoyuuKykRn qZT_SinBosyuuDrtenHoyuuKykRn =  new QZT_SinBosyuuDrtenHoyuuKykRn();
        jpql.append($SELECT);
        jpql.append(qZT_SinBosyuuDrtenHoyuuKykRn);
        jpql.append($FROM);
        jpql.append(qZT_SinBosyuuDrtenHoyuuKykRn.ZT_SinBosyuuDrtenHoyuuKykRn());
        jpql.append($ORDER_BY(qZT_SinBosyuuDrtenHoyuuKykRn.zrnsyono.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_SinBosyuuDrtenHoyuuKykRn).getResults();
    }
}
