package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_BosyuuDrtenHoyuuKykRn;
import yuyu.def.db.meta.QZT_BosyuuDrtenHoyuuKykRn;

/**
 * 募集代理店保有契約Ｆテーブル（連）(ZT_BosyuuDrtenHoyuuKykRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_BosyuuDrtenHoyuuKykRnDao extends AbstractDao<ZT_BosyuuDrtenHoyuuKykRn> {

    public ZT_BosyuuDrtenHoyuuKykRnDao() {
        super(ZT_BosyuuDrtenHoyuuKykRn.class);
    }

    public ZT_BosyuuDrtenHoyuuKykRn getBosyuuDrtenHoyuuKykRn(String pZrnsyonosyuban) {
        ZT_BosyuuDrtenHoyuuKykRn zT_BosyuuDrtenHoyuuKykRn =  new ZT_BosyuuDrtenHoyuuKykRn();
        zT_BosyuuDrtenHoyuuKykRn.setZrnsyonosyuban(pZrnsyonosyuban);
        return this.selectOne(zT_BosyuuDrtenHoyuuKykRn);
    }

    public ExDBResults<ZT_BosyuuDrtenHoyuuKykRn> selectAllZT_BosyuuDrtenHoyuuKykRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_BosyuuDrtenHoyuuKykRn qZT_BosyuuDrtenHoyuuKykRn =  new QZT_BosyuuDrtenHoyuuKykRn();
        jpql.append($SELECT);
        jpql.append(qZT_BosyuuDrtenHoyuuKykRn);
        jpql.append($FROM);
        jpql.append(qZT_BosyuuDrtenHoyuuKykRn.ZT_BosyuuDrtenHoyuuKykRn());
        jpql.append($ORDER_BY(qZT_BosyuuDrtenHoyuuKykRn.zrnsyonosyuban.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_BosyuuDrtenHoyuuKykRn).getResults();
    }
}
