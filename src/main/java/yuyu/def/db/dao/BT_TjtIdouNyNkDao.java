package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.BT_TjtIdouNyNk;
import yuyu.def.db.meta.QBT_TjtIdouNyNk;

/**
 * 当日異動内容年金支払テーブル(BT_TjtIdouNyNkDao) アクセス用の DAO クラスです。<br />
 */
public class BT_TjtIdouNyNkDao extends AbstractDao<BT_TjtIdouNyNk> {

    public BT_TjtIdouNyNkDao() {
        super(BT_TjtIdouNyNk.class);
    }

    public BT_TjtIdouNyNk getTjtIdouNyNk(String pNksysyno,
        Integer pRenno3keta){
        BT_TjtIdouNyNk bT_TjtIdouNyNk =  new BT_TjtIdouNyNk();
        bT_TjtIdouNyNk.setNksysyno(pNksysyno);
        bT_TjtIdouNyNk.setRenno3keta(pRenno3keta);
        return this.selectOne(bT_TjtIdouNyNk);
    }

    public Integer getTjtIdouNyNkMaxRenno3ketaByNksysyno(String pNksysyno) {


        QBT_TjtIdouNyNk tjtIdouNyNk = new QBT_TjtIdouNyNk();

        String strSql = $SELECT + $MAX(tjtIdouNyNk.renno3keta) +
            $FROM + tjtIdouNyNk.BT_TjtIdouNyNk() +
            $WHERE + tjtIdouNyNk.nksysyno.eq(pNksysyno);

        return em.createJPQL(strSql).bind(tjtIdouNyNk).getSingleResult();
    }

    public ExDBResults<BT_TjtIdouNyNk> getTjtIdouNyNks() {


        QBT_TjtIdouNyNk qBT_TjtIdouNyNk = new QBT_TjtIdouNyNk();

        String queryStr = $SELECT + qBT_TjtIdouNyNk +
            $FROM + qBT_TjtIdouNyNk.BT_TjtIdouNyNk();

        return em.createJPQL(queryStr).bind(qBT_TjtIdouNyNk).getResults();
    }

    public ExDBResults<BT_TjtIdouNyNk> getTjtIdouNyNksByKakutyoujobcdMaxRenno3keta() {


        QBT_TjtIdouNyNk qBT_TjtIdouNyNk1 = new QBT_TjtIdouNyNk("q1");


        QBT_TjtIdouNyNk qBT_TjtIdouNyNk2 = new QBT_TjtIdouNyNk("q2");


        String subQuerry = $SELECT + qBT_TjtIdouNyNk1.nksysyno + "," +
            $MAX(qBT_TjtIdouNyNk1.renno3keta) +
            $FROM + qBT_TjtIdouNyNk1.BT_TjtIdouNyNk() +
            $GROUP_BY + qBT_TjtIdouNyNk1.nksysyno +
            $HAVING + qBT_TjtIdouNyNk1.nksysyno + $EQ + qBT_TjtIdouNyNk2.nksysyno +
            $AND + $MAX(qBT_TjtIdouNyNk1.renno3keta) + $EQ + qBT_TjtIdouNyNk2.renno3keta;



        String strSql = $SELECT + qBT_TjtIdouNyNk2 +
            $FROM + qBT_TjtIdouNyNk2.BT_TjtIdouNyNk() +
            $WHERE + $EXISTS(subQuerry);


        return em.createJPQL(strSql).bind(qBT_TjtIdouNyNk1, qBT_TjtIdouNyNk2).getResults();
    }

    public List<BT_TjtIdouNyNk> getTjtIdouNyNksByNksysyno(String pNksysyno) {


        BT_TjtIdouNyNk bT_TjtIdouNyNk = new BT_TjtIdouNyNk();
        bT_TjtIdouNyNk.setNksysyno(pNksysyno);


        return this.select(bT_TjtIdouNyNk);
    }

    public List<BT_TjtIdouNyNk> getTjtIdouNyNksByNksysynoYoukyuuno(String pNksysyno, String pYoukyuuno) {
        BT_TjtIdouNyNk bT_TjtIdouNyNk = new BT_TjtIdouNyNk();
        bT_TjtIdouNyNk.setNksysyno(pNksysyno);
        bT_TjtIdouNyNk.setYoukyuuno(pYoukyuuno);
        return this.select(bT_TjtIdouNyNk);
    }
}
