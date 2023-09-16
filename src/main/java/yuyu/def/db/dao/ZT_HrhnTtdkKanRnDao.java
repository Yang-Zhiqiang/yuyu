package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_HrhnTtdkKanRn;
import yuyu.def.db.meta.QZT_HrhnTtdkKanRn;

/**
 * 手続完了（払方変更）テーブル（連）(ZT_HrhnTtdkKanRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_HrhnTtdkKanRnDao extends AbstractDao<ZT_HrhnTtdkKanRn> {

    public ZT_HrhnTtdkKanRnDao() {
        super(ZT_HrhnTtdkKanRn.class);
    }

    public ZT_HrhnTtdkKanRn getHrhnTtdkKanRn(String pZrntyouhyouymd, String pZrnsyono, String pZrnsikibetuno) {
        ZT_HrhnTtdkKanRn zT_HrhnTtdkKanRn =  new ZT_HrhnTtdkKanRn();
        zT_HrhnTtdkKanRn.setZrntyouhyouymd(pZrntyouhyouymd);
        zT_HrhnTtdkKanRn.setZrnsyono(pZrnsyono);
        zT_HrhnTtdkKanRn.setZrnsikibetuno(pZrnsikibetuno);
        return this.selectOne(zT_HrhnTtdkKanRn);
    }

    public ExDBResults<ZT_HrhnTtdkKanRn> selectAllZT_HrhnTtdkKanRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_HrhnTtdkKanRn qZT_HrhnTtdkKanRn =  new QZT_HrhnTtdkKanRn();
        jpql.append($SELECT);
        jpql.append(qZT_HrhnTtdkKanRn);
        jpql.append($FROM);
        jpql.append(qZT_HrhnTtdkKanRn.ZT_HrhnTtdkKanRn());
        jpql.append($ORDER_BY(qZT_HrhnTtdkKanRn.zrntyouhyouymd.asc(), qZT_HrhnTtdkKanRn.zrnsyono.asc(), qZT_HrhnTtdkKanRn.zrnsikibetuno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_HrhnTtdkKanRn).getResults();
    }
}
