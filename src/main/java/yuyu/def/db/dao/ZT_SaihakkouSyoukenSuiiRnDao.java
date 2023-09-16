package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_SaihakkouSyoukenSuiiRn;
import yuyu.def.db.meta.QZT_SaihakkouSyoukenSuiiRn;

/**
 * 再発行保険証券推移表Ｆテーブル（連）(ZT_SaihakkouSyoukenSuiiRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_SaihakkouSyoukenSuiiRnDao extends AbstractDao<ZT_SaihakkouSyoukenSuiiRn> {

    public ZT_SaihakkouSyoukenSuiiRnDao() {
        super(ZT_SaihakkouSyoukenSuiiRn.class);
    }

    public ZT_SaihakkouSyoukenSuiiRn getSaihakkouSyoukenSuiiRn(String pZrnsyono, String pZrntyouhyouymd, String pZrnsuiihyouptn) {
        ZT_SaihakkouSyoukenSuiiRn zT_SaihakkouSyoukenSuiiRn =  new ZT_SaihakkouSyoukenSuiiRn();
        zT_SaihakkouSyoukenSuiiRn.setZrnsyono(pZrnsyono);
        zT_SaihakkouSyoukenSuiiRn.setZrntyouhyouymd(pZrntyouhyouymd);
        zT_SaihakkouSyoukenSuiiRn.setZrnsuiihyouptn(pZrnsuiihyouptn);
        return this.selectOne(zT_SaihakkouSyoukenSuiiRn);
    }

    public ExDBResults<ZT_SaihakkouSyoukenSuiiRn> selectAllZT_SaihakkouSyoukenSuiiRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_SaihakkouSyoukenSuiiRn qZT_SaihakkouSyoukenSuiiRn =  new QZT_SaihakkouSyoukenSuiiRn();
        jpql.append($SELECT);
        jpql.append(qZT_SaihakkouSyoukenSuiiRn);
        jpql.append($FROM);
        jpql.append(qZT_SaihakkouSyoukenSuiiRn.ZT_SaihakkouSyoukenSuiiRn());
        jpql.append($ORDER_BY(qZT_SaihakkouSyoukenSuiiRn.zrnsyono.asc(), qZT_SaihakkouSyoukenSuiiRn.zrntyouhyouymd.asc(), qZT_SaihakkouSyoukenSuiiRn.zrnsuiihyouptn.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_SaihakkouSyoukenSuiiRn).getResults();
    }
}
