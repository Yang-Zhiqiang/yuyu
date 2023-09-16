package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_SinkeiyakuSyoukenSuiiRn;
import yuyu.def.db.meta.QZT_SinkeiyakuSyoukenSuiiRn;

/**
 * 新契約保険証券推移表Ｆテーブル（連）(ZT_SinkeiyakuSyoukenSuiiRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_SinkeiyakuSyoukenSuiiRnDao extends AbstractDao<ZT_SinkeiyakuSyoukenSuiiRn> {

    public ZT_SinkeiyakuSyoukenSuiiRnDao() {
        super(ZT_SinkeiyakuSyoukenSuiiRn.class);
    }

    public ZT_SinkeiyakuSyoukenSuiiRn getSinkeiyakuSyoukenSuiiRn(String pZrnsyono, String pZrntyouhyouymd, String pZrnsuiihyouptn) {
        ZT_SinkeiyakuSyoukenSuiiRn zT_SinkeiyakuSyoukenSuiiRn =  new ZT_SinkeiyakuSyoukenSuiiRn();
        zT_SinkeiyakuSyoukenSuiiRn.setZrnsyono(pZrnsyono);
        zT_SinkeiyakuSyoukenSuiiRn.setZrntyouhyouymd(pZrntyouhyouymd);
        zT_SinkeiyakuSyoukenSuiiRn.setZrnsuiihyouptn(pZrnsuiihyouptn);
        return this.selectOne(zT_SinkeiyakuSyoukenSuiiRn);
    }

    public ExDBResults<ZT_SinkeiyakuSyoukenSuiiRn> selectAllZT_SinkeiyakuSyoukenSuiiRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_SinkeiyakuSyoukenSuiiRn qZT_SinkeiyakuSyoukenSuiiRn =  new QZT_SinkeiyakuSyoukenSuiiRn();
        jpql.append($SELECT);
        jpql.append(qZT_SinkeiyakuSyoukenSuiiRn);
        jpql.append($FROM);
        jpql.append(qZT_SinkeiyakuSyoukenSuiiRn.ZT_SinkeiyakuSyoukenSuiiRn());
        jpql.append($ORDER_BY(qZT_SinkeiyakuSyoukenSuiiRn.zrnsyono.asc(), qZT_SinkeiyakuSyoukenSuiiRn.zrntyouhyouymd.asc(), qZT_SinkeiyakuSyoukenSuiiRn.zrnsuiihyouptn.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_SinkeiyakuSyoukenSuiiRn).getResults();
    }
}
