package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.BT_TjtIdouNySk;
import yuyu.def.db.meta.QBT_TjtIdouNySk;

/**
 * 当日異動内容新契約テーブル(BT_TjtIdouNySkDao) アクセス用の DAO クラスです。<br />
 */
public class BT_TjtIdouNySkDao extends AbstractDao<BT_TjtIdouNySk> {

    public BT_TjtIdouNySkDao() {
        super(BT_TjtIdouNySk.class);
    }

    public BT_TjtIdouNySk getTjtIdouNySk(String pMosno,
        Integer pRenno3keta){
        BT_TjtIdouNySk bT_TjtIdouNySk =  new BT_TjtIdouNySk();
        bT_TjtIdouNySk.setMosno(pMosno);
        bT_TjtIdouNySk.setRenno3keta(pRenno3keta);
        return this.selectOne(bT_TjtIdouNySk);
    }

    public Integer getTjtIdouNySkMaxRenno3ketaByMosno(String pMosno) {


        QBT_TjtIdouNySk qBT_TjtIdouNySk = new QBT_TjtIdouNySk();

        String strSql = $SELECT + $MAX(qBT_TjtIdouNySk.renno3keta) +
            $FROM + qBT_TjtIdouNySk.BT_TjtIdouNySk() +
            $WHERE + qBT_TjtIdouNySk.mosno.eq(pMosno);

        return em.createJPQL(strSql).bind(qBT_TjtIdouNySk).getSingleResult();
    }

    public ExDBResults<BT_TjtIdouNySk> getTjtIdouNySks() {


        QBT_TjtIdouNySk qBT_TjtIdouNySk = new QBT_TjtIdouNySk();

        String queryStr = $SELECT + qBT_TjtIdouNySk +
            $FROM + qBT_TjtIdouNySk.BT_TjtIdouNySk();

        return em.createJPQL(queryStr).bind(qBT_TjtIdouNySk).getResults();
    }

    public ExDBResults<BT_TjtIdouNySk> getTjtIdouNySksByKakutyoujobcdMaxRenno3keta() {


        QBT_TjtIdouNySk qBT_TjtIdouNySk1 = new QBT_TjtIdouNySk("q1");


        QBT_TjtIdouNySk qBT_TjtIdouNySk2 = new QBT_TjtIdouNySk("q2");


        String strSql1 = $SELECT + $MAX(qBT_TjtIdouNySk2.renno3keta) +
            $FROM + qBT_TjtIdouNySk2.BT_TjtIdouNySk() +
            $WHERE + qBT_TjtIdouNySk2.mosno.eq(qBT_TjtIdouNySk1.mosno);

        String strSql = $SELECT + qBT_TjtIdouNySk1 +
            $FROM + qBT_TjtIdouNySk1.BT_TjtIdouNySk() +
            $WHERE + qBT_TjtIdouNySk1.renno3keta + $EQ + $(strSql1);


        return em.createJPQL(strSql).bind(qBT_TjtIdouNySk1, qBT_TjtIdouNySk2).getResults();
    }

    public List<BT_TjtIdouNySk> getTjtIdouNySksByMosno(String pMosno) {


        BT_TjtIdouNySk bT_TjtIdouNySk = new BT_TjtIdouNySk();
        bT_TjtIdouNySk.setMosno(pMosno);


        return select(bT_TjtIdouNySk);
    }

    public List<BT_TjtIdouNySk> getTjtIdouNySksByMosnoYoukyuuno(String pMosno, String pYoukyuuno) {
        BT_TjtIdouNySk bT_TjtIdouNySk = new BT_TjtIdouNySk();
        bT_TjtIdouNySk.setMosno(pMosno);
        bT_TjtIdouNySk.setYoukyuuno(pYoukyuuno);
        return this.select(bT_TjtIdouNySk);
    }
}
