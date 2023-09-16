package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_SinkeiyakuHokensyoukenRn;
import yuyu.def.db.meta.QZT_SinkeiyakuHokensyoukenRn;

/**
 * 新契約保険証券Ｆテーブル（連）(ZT_SinkeiyakuHokensyoukenRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_SinkeiyakuHokensyoukenRnDao extends AbstractDao<ZT_SinkeiyakuHokensyoukenRn> {

    public ZT_SinkeiyakuHokensyoukenRnDao() {
        super(ZT_SinkeiyakuHokensyoukenRn.class);
    }

    public ZT_SinkeiyakuHokensyoukenRn getSinkeiyakuHokensyoukenRn(String pZrntyouhyouymd, String pZrnsyono) {
        ZT_SinkeiyakuHokensyoukenRn zT_SinkeiyakuHokensyoukenRn =  new ZT_SinkeiyakuHokensyoukenRn();
        zT_SinkeiyakuHokensyoukenRn.setZrntyouhyouymd(pZrntyouhyouymd);
        zT_SinkeiyakuHokensyoukenRn.setZrnsyono(pZrnsyono);
        return this.selectOne(zT_SinkeiyakuHokensyoukenRn);
    }

    public ExDBResults<ZT_SinkeiyakuHokensyoukenRn> selectAllZT_SinkeiyakuHokensyoukenRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_SinkeiyakuHokensyoukenRn qZT_SinkeiyakuHokensyoukenRn =  new QZT_SinkeiyakuHokensyoukenRn();
        jpql.append($SELECT);
        jpql.append(qZT_SinkeiyakuHokensyoukenRn);
        jpql.append($FROM);
        jpql.append(qZT_SinkeiyakuHokensyoukenRn.ZT_SinkeiyakuHokensyoukenRn());
        jpql.append($ORDER_BY(qZT_SinkeiyakuHokensyoukenRn.zrntyouhyouymd.asc(), qZT_SinkeiyakuHokensyoukenRn.zrnsyono.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_SinkeiyakuHokensyoukenRn).getResults();
    }
}
