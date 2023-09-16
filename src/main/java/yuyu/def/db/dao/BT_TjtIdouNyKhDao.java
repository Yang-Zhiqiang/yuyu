package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.BT_TjtIdouNyKh;
import yuyu.def.db.meta.QBT_TjtIdouNyKh;

/**
 * 当日異動内容契約保全テーブル(BT_TjtIdouNyKhDao) アクセス用の DAO クラスです。<br />
 */
public class BT_TjtIdouNyKhDao extends AbstractDao<BT_TjtIdouNyKh> {

    public BT_TjtIdouNyKhDao() {
        super(BT_TjtIdouNyKh.class);
    }

    public BT_TjtIdouNyKh getTjtIdouNyKh(String pSyono, Integer pRenno3keta) {
        BT_TjtIdouNyKh bT_TjtIdouNyKh =  new BT_TjtIdouNyKh();
        bT_TjtIdouNyKh.setSyono(pSyono);
        bT_TjtIdouNyKh.setRenno3keta(pRenno3keta);
        return this.selectOne(bT_TjtIdouNyKh);
    }

    public Integer getTjtIdouNyKhMaxRenno3ketaBySyono(String pSyono) {


        QBT_TjtIdouNyKh qBT_TjtIdouNyKh = new QBT_TjtIdouNyKh();

        String strSql = $SELECT + $MAX(qBT_TjtIdouNyKh.renno3keta) +
            $FROM + qBT_TjtIdouNyKh.BT_TjtIdouNyKh() +
            $WHERE + qBT_TjtIdouNyKh.syono.eq(pSyono);

        return em.createJPQL(strSql).bind(qBT_TjtIdouNyKh).getSingleResult();
    }

    public ExDBResults<BT_TjtIdouNyKh> getTjtIdouNyKhs() {


        QBT_TjtIdouNyKh qBT_TjtIdouNyKh = new QBT_TjtIdouNyKh();

        String queryStr = $SELECT + qBT_TjtIdouNyKh +
            $FROM + qBT_TjtIdouNyKh.BT_TjtIdouNyKh();

        return em.createJPQL(queryStr).bind(qBT_TjtIdouNyKh).getResults();
    }

    public ExDBResults<BT_TjtIdouNyKh> getTjtIdouNyKhsByKakutyoujobcdMaxRenno3keta() {


        QBT_TjtIdouNyKh qBT_TjtIdouNyKh1 = new QBT_TjtIdouNyKh("q1");


        QBT_TjtIdouNyKh qBT_TjtIdouNyKh2 = new QBT_TjtIdouNyKh("q2");


        String strSql1 = $SELECT + $MAX(qBT_TjtIdouNyKh2.renno3keta) +
            $FROM + qBT_TjtIdouNyKh2.BT_TjtIdouNyKh() +
            $WHERE + qBT_TjtIdouNyKh2.syono.eq(qBT_TjtIdouNyKh1.syono);

        String strSql = $SELECT + qBT_TjtIdouNyKh1 +
            $FROM + qBT_TjtIdouNyKh1.BT_TjtIdouNyKh() +
            $WHERE + qBT_TjtIdouNyKh1.renno3keta + $EQ + $(strSql1);


        return em.createJPQL(strSql).bind(qBT_TjtIdouNyKh1,qBT_TjtIdouNyKh2).getResults();
    }

    public List<BT_TjtIdouNyKh> getTjtIdouNyKhsBySyono(String pSyono) {

        BT_TjtIdouNyKh bT_TjtIdouNyKh = new BT_TjtIdouNyKh();
        bT_TjtIdouNyKh.setSyono(pSyono);

        return select(bT_TjtIdouNyKh);

    }

    public List<BT_TjtIdouNyKh> getTjtIdouNyKhsBySyonoYoukyuuno(String pSyono, String pYoukyuuno) {
        BT_TjtIdouNyKh BT_TjtIdouNyKh = new BT_TjtIdouNyKh();
        BT_TjtIdouNyKh.setSyono(pSyono);
        BT_TjtIdouNyKh.setYoukyuuno(pYoukyuuno);
        return this.select(BT_TjtIdouNyKh);
    }
}
