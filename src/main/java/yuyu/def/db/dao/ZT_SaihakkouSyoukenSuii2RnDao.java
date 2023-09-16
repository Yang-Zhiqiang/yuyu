package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_SaihakkouSyoukenSuii2Rn;
import yuyu.def.db.meta.QZT_SaihakkouSyoukenSuii2Rn;

/**
 * 再発行保険証券推移表Ｆテーブル２（連）(ZT_SaihakkouSyoukenSuii2RnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_SaihakkouSyoukenSuii2RnDao extends AbstractDao<ZT_SaihakkouSyoukenSuii2Rn> {

    public ZT_SaihakkouSyoukenSuii2RnDao() {
        super(ZT_SaihakkouSyoukenSuii2Rn.class);
    }

    public ZT_SaihakkouSyoukenSuii2Rn getSaihakkouSyoukenSuii2Rn(String pZrnsyono, String pZrntyouhyouymd, String pZrnsuiihyouptn) {
        ZT_SaihakkouSyoukenSuii2Rn zT_SaihakkouSyoukenSuii2Rn =  new ZT_SaihakkouSyoukenSuii2Rn();
        zT_SaihakkouSyoukenSuii2Rn.setZrnsyono(pZrnsyono);
        zT_SaihakkouSyoukenSuii2Rn.setZrntyouhyouymd(pZrntyouhyouymd);
        zT_SaihakkouSyoukenSuii2Rn.setZrnsuiihyouptn(pZrnsuiihyouptn);
        return this.selectOne(zT_SaihakkouSyoukenSuii2Rn);
    }

    public ExDBResults<ZT_SaihakkouSyoukenSuii2Rn> selectAllZT_SaihakkouSyoukenSuii2Rn() {
        StringBuilder jpql = new StringBuilder();
        QZT_SaihakkouSyoukenSuii2Rn qZT_SaihakkouSyoukenSuii2Rn =  new QZT_SaihakkouSyoukenSuii2Rn();
        jpql.append($SELECT);
        jpql.append(qZT_SaihakkouSyoukenSuii2Rn);
        jpql.append($FROM);
        jpql.append(qZT_SaihakkouSyoukenSuii2Rn.ZT_SaihakkouSyoukenSuii2Rn());
        jpql.append($ORDER_BY(qZT_SaihakkouSyoukenSuii2Rn.zrnsyono.asc(), qZT_SaihakkouSyoukenSuii2Rn.zrntyouhyouymd.asc(), qZT_SaihakkouSyoukenSuii2Rn.zrnsuiihyouptn.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_SaihakkouSyoukenSuii2Rn).getResults();
    }
}
