package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_SyoukenTkListShRn;
import yuyu.def.db.meta.QZT_SyoukenTkListShRn;

/**
 * 証券特殊処理明細リスト（再発行）Ｆテーブル（連）(ZT_SyoukenTkListShRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_SyoukenTkListShRnDao extends AbstractDao<ZT_SyoukenTkListShRn> {

    public ZT_SyoukenTkListShRnDao() {
        super(ZT_SyoukenTkListShRn.class);
    }

    public ZT_SyoukenTkListShRn getSyoukenTkListShRn(String pZrntyouhyouymd, String pZrnsyono) {
        ZT_SyoukenTkListShRn zT_SyoukenTkListShRn =  new ZT_SyoukenTkListShRn();
        zT_SyoukenTkListShRn.setZrntyouhyouymd(pZrntyouhyouymd);
        zT_SyoukenTkListShRn.setZrnsyono(pZrnsyono);
        return this.selectOne(zT_SyoukenTkListShRn);
    }

    public ExDBResults<ZT_SyoukenTkListShRn> selectAllZT_SyoukenTkListShRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_SyoukenTkListShRn qZT_SyoukenTkListShRn =  new QZT_SyoukenTkListShRn();
        jpql.append($SELECT);
        jpql.append(qZT_SyoukenTkListShRn);
        jpql.append($FROM);
        jpql.append(qZT_SyoukenTkListShRn.ZT_SyoukenTkListShRn());
        jpql.append($ORDER_BY(qZT_SyoukenTkListShRn.zrntyouhyouymd.asc(), qZT_SyoukenTkListShRn.zrnsyono.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_SyoukenTkListShRn).getResults();
    }
}
