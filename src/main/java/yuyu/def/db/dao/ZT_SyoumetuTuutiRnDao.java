package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_SyoumetuTuutiRn;
import yuyu.def.db.meta.QZT_SyoumetuTuutiRn;

/**
 * 消滅通知Ｆテーブル（連）(ZT_SyoumetuTuutiRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_SyoumetuTuutiRnDao extends AbstractDao<ZT_SyoumetuTuutiRn> {

    public ZT_SyoumetuTuutiRnDao() {
        super(ZT_SyoumetuTuutiRn.class);
    }

    public ZT_SyoumetuTuutiRn getSyoumetuTuutiRn(String pZrntyouhyouymd, String pZrnsyono, String pZrnsikibetuno) {
        ZT_SyoumetuTuutiRn zT_SyoumetuTuutiRn =  new ZT_SyoumetuTuutiRn();
        zT_SyoumetuTuutiRn.setZrntyouhyouymd(pZrntyouhyouymd);
        zT_SyoumetuTuutiRn.setZrnsyono(pZrnsyono);
        zT_SyoumetuTuutiRn.setZrnsikibetuno(pZrnsikibetuno);
        return this.selectOne(zT_SyoumetuTuutiRn);
    }

    public ExDBResults<ZT_SyoumetuTuutiRn> selectAllZT_SyoumetuTuutiRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_SyoumetuTuutiRn qZT_SyoumetuTuutiRn =  new QZT_SyoumetuTuutiRn();
        jpql.append($SELECT);
        jpql.append(qZT_SyoumetuTuutiRn);
        jpql.append($FROM);
        jpql.append(qZT_SyoumetuTuutiRn.ZT_SyoumetuTuutiRn());
        jpql.append($ORDER_BY(qZT_SyoumetuTuutiRn.zrntyouhyouymd.asc(), qZT_SyoumetuTuutiRn.zrnsyono.asc(), qZT_SyoumetuTuutiRn.zrnsikibetuno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_SyoumetuTuutiRn).getResults();
    }
}
