package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_SinkeiyakuSyoukenSuii2Rn;
import yuyu.def.db.meta.QZT_SinkeiyakuSyoukenSuii2Rn;

/**
 * 新契約保険証券推移表Ｆテーブル２（連）(ZT_SinkeiyakuSyoukenSuii2RnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_SinkeiyakuSyoukenSuii2RnDao extends AbstractDao<ZT_SinkeiyakuSyoukenSuii2Rn> {

    public ZT_SinkeiyakuSyoukenSuii2RnDao() {
        super(ZT_SinkeiyakuSyoukenSuii2Rn.class);
    }

    public ZT_SinkeiyakuSyoukenSuii2Rn getSinkeiyakuSyoukenSuii2Rn(String pZrnsyono, String pZrntyouhyouymd, String pZrnsuiihyouptn) {
        ZT_SinkeiyakuSyoukenSuii2Rn zT_SinkeiyakuSyoukenSuii2Rn =  new ZT_SinkeiyakuSyoukenSuii2Rn();
        zT_SinkeiyakuSyoukenSuii2Rn.setZrnsyono(pZrnsyono);
        zT_SinkeiyakuSyoukenSuii2Rn.setZrntyouhyouymd(pZrntyouhyouymd);
        zT_SinkeiyakuSyoukenSuii2Rn.setZrnsuiihyouptn(pZrnsuiihyouptn);
        return this.selectOne(zT_SinkeiyakuSyoukenSuii2Rn);
    }

    public ExDBResults<ZT_SinkeiyakuSyoukenSuii2Rn> selectAllZT_SinkeiyakuSyoukenSuii2Rn() {
        StringBuilder jpql = new StringBuilder();
        QZT_SinkeiyakuSyoukenSuii2Rn qZT_SinkeiyakuSyoukenSuii2Rn =  new QZT_SinkeiyakuSyoukenSuii2Rn();
        jpql.append($SELECT);
        jpql.append(qZT_SinkeiyakuSyoukenSuii2Rn);
        jpql.append($FROM);
        jpql.append(qZT_SinkeiyakuSyoukenSuii2Rn.ZT_SinkeiyakuSyoukenSuii2Rn());
        jpql.append($ORDER_BY(qZT_SinkeiyakuSyoukenSuii2Rn.zrnsyono.asc(), qZT_SinkeiyakuSyoukenSuii2Rn.zrntyouhyouymd.asc(), qZT_SinkeiyakuSyoukenSuii2Rn.zrnsuiihyouptn.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_SinkeiyakuSyoukenSuii2Rn).getResults();
    }
}
