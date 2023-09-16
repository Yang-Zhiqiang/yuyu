package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_SyoukenTkListSkRn;
import yuyu.def.db.meta.QZT_SyoukenTkListSkRn;

/**
 * 証券特殊処理明細リスト（新契約）Ｆテーブル（連）(ZT_SyoukenTkListSkRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_SyoukenTkListSkRnDao extends AbstractDao<ZT_SyoukenTkListSkRn> {

    public ZT_SyoukenTkListSkRnDao() {
        super(ZT_SyoukenTkListSkRn.class);
    }

    public ZT_SyoukenTkListSkRn getSyoukenTkListSkRn(String pZrntyouhyouymd, String pZrnsyono) {
        ZT_SyoukenTkListSkRn zT_SyoukenTkListSkRn =  new ZT_SyoukenTkListSkRn();
        zT_SyoukenTkListSkRn.setZrntyouhyouymd(pZrntyouhyouymd);
        zT_SyoukenTkListSkRn.setZrnsyono(pZrnsyono);
        return this.selectOne(zT_SyoukenTkListSkRn);
    }

    public ExDBResults<ZT_SyoukenTkListSkRn> selectAllZT_SyoukenTkListSkRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_SyoukenTkListSkRn qZT_SyoukenTkListSkRn =  new QZT_SyoukenTkListSkRn();
        jpql.append($SELECT);
        jpql.append(qZT_SyoukenTkListSkRn);
        jpql.append($FROM);
        jpql.append(qZT_SyoukenTkListSkRn.ZT_SyoukenTkListSkRn());
        jpql.append($ORDER_BY(qZT_SyoukenTkListSkRn.zrntyouhyouymd.asc(), qZT_SyoukenTkListSkRn.zrnsyono.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_SyoukenTkListSkRn).getResults();
    }
}
