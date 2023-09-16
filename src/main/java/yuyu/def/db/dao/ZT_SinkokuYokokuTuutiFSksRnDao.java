package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_SinkokuYokokuTuutiFSksRn;
import yuyu.def.db.meta.QZT_SinkokuYokokuTuutiFSksRn;

/**
 * 申告予告通知Ｆテーブル（連）(ZT_SinkokuYokokuTuutiFSksRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_SinkokuYokokuTuutiFSksRnDao extends AbstractDao<ZT_SinkokuYokokuTuutiFSksRn> {

    public ZT_SinkokuYokokuTuutiFSksRnDao() {
        super(ZT_SinkokuYokokuTuutiFSksRn.class);
    }

    public ZT_SinkokuYokokuTuutiFSksRn getSinkokuYokokuTuutiFSksRn(String pZrntyouhyouymd, String pZrnsyono, String pZrnsinkokunenkj) {
        ZT_SinkokuYokokuTuutiFSksRn zT_SinkokuYokokuTuutiFSksRn =  new ZT_SinkokuYokokuTuutiFSksRn();
        zT_SinkokuYokokuTuutiFSksRn.setZrntyouhyouymd(pZrntyouhyouymd);
        zT_SinkokuYokokuTuutiFSksRn.setZrnsyono(pZrnsyono);
        zT_SinkokuYokokuTuutiFSksRn.setZrnsinkokunenkj(pZrnsinkokunenkj);
        return this.selectOne(zT_SinkokuYokokuTuutiFSksRn);
    }

    public ExDBResults<ZT_SinkokuYokokuTuutiFSksRn> selectAllZT_SinkokuYokokuTuutiFSksRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_SinkokuYokokuTuutiFSksRn qZT_SinkokuYokokuTuutiFSksRn =  new QZT_SinkokuYokokuTuutiFSksRn();
        jpql.append($SELECT);
        jpql.append(qZT_SinkokuYokokuTuutiFSksRn);
        jpql.append($FROM);
        jpql.append(qZT_SinkokuYokokuTuutiFSksRn.ZT_SinkokuYokokuTuutiFSksRn());
        jpql.append($ORDER_BY(qZT_SinkokuYokokuTuutiFSksRn.zrntyouhyouymd.asc(), qZT_SinkokuYokokuTuutiFSksRn.zrnsyono.asc(), qZT_SinkokuYokokuTuutiFSksRn.zrnsinkokunenkj.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_SinkokuYokokuTuutiFSksRn).getResults();
    }
}
