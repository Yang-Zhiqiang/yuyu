package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_SaihakkouHokensyoukenRn;
import yuyu.def.db.meta.QZT_SaihakkouHokensyoukenRn;

/**
 * 再発行保険証券Ｆテーブル（連）(ZT_SaihakkouHokensyoukenRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_SaihakkouHokensyoukenRnDao extends AbstractDao<ZT_SaihakkouHokensyoukenRn> {

    public ZT_SaihakkouHokensyoukenRnDao() {
        super(ZT_SaihakkouHokensyoukenRn.class);
    }

    public ZT_SaihakkouHokensyoukenRn getSaihakkouHokensyoukenRn(String pZrntyouhyouymd, String pZrnsyono) {
        ZT_SaihakkouHokensyoukenRn zT_SaihakkouHokensyoukenRn =  new ZT_SaihakkouHokensyoukenRn();
        zT_SaihakkouHokensyoukenRn.setZrntyouhyouymd(pZrntyouhyouymd);
        zT_SaihakkouHokensyoukenRn.setZrnsyono(pZrnsyono);
        return this.selectOne(zT_SaihakkouHokensyoukenRn);
    }

    public ExDBResults<ZT_SaihakkouHokensyoukenRn> selectAllZT_SaihakkouHokensyoukenRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_SaihakkouHokensyoukenRn qZT_SaihakkouHokensyoukenRn =  new QZT_SaihakkouHokensyoukenRn();
        jpql.append($SELECT);
        jpql.append(qZT_SaihakkouHokensyoukenRn);
        jpql.append($FROM);
        jpql.append(qZT_SaihakkouHokensyoukenRn.ZT_SaihakkouHokensyoukenRn());
        jpql.append($ORDER_BY(qZT_SaihakkouHokensyoukenRn.zrntyouhyouymd.asc(), qZT_SaihakkouHokensyoukenRn.zrnsyono.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_SaihakkouHokensyoukenRn).getResults();
    }
}
