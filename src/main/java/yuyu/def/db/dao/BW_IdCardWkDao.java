package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.classification.C_HnsyaSosikiKengenKbn;
import yuyu.def.db.entity.BW_IdCardWk;
import yuyu.def.db.meta.QBT_UserKengenHaneiSskInfo;
import yuyu.def.db.meta.QBW_IdCardWk;
import yuyu.def.db.meta.QBW_UserIdKanrenWk;
import yuyu.def.db.meta.QBW_UserWk;
/**
 * ＩＤカードマスタワークテーブル(BW_IdCardWkDao) アクセス用の DAO クラスです。<br />
 */
public class BW_IdCardWkDao extends AbstractDao<BW_IdCardWk> {

    public BW_IdCardWkDao() {
        super(BW_IdCardWk.class);
    }

    public BW_IdCardWk getIdCardWk(String pIdkbn, String pIdcd) {
        BW_IdCardWk bW_IdCardWk =  new BW_IdCardWk();
        bW_IdCardWk.setIdkbn(pIdkbn);
        bW_IdCardWk.setIdcd(pIdcd);
        return this.selectOne(bW_IdCardWk);
    }

    public ExDBResults<BW_IdCardWk> getIdCardWksByNotExistsUserWk() {


        QBW_IdCardWk qBW_IdCardWk = new QBW_IdCardWk();


        QBW_UserIdKanrenWk qBW_UserIdKanrenWk = new QBW_UserIdKanrenWk();


        QBW_UserWk qBW_UserWk = new QBW_UserWk();


        String strSubSql = $SELECT + qBW_UserWk.userId +
            $FROM + qBW_UserWk.BW_UserWk() +
            $WHERE + qBW_UserWk.userId.eq(qBW_UserIdKanrenWk.userId);


        String queryStr = $SELECT + qBW_IdCardWk +
            $FROM + qBW_IdCardWk.BW_IdCardWk() + "," +
            qBW_UserIdKanrenWk.BW_UserIdKanrenWk() +
            $WHERE + qBW_IdCardWk.idkbn.eq(qBW_UserIdKanrenWk.idkbn) +
            $AND + qBW_IdCardWk.idcd.eq(qBW_UserIdKanrenWk.idcd) +
            $AND + $NOT_EXISTS(strSubSql) +
            $ORDER_BY(qBW_IdCardWk.idkbn.asc(),
                qBW_IdCardWk.idcd.asc());

        return em.createJPQL(queryStr).bind(qBW_IdCardWk, qBW_UserIdKanrenWk, qBW_UserWk).getResults();
    }

    public ExDBResults<BW_IdCardWk> getIdCardWksByNotExistsUserWkUserNm() {


        QBW_IdCardWk qBW_IdCardWk = new QBW_IdCardWk();


        QBW_UserIdKanrenWk qBW_UserIdKanrenWk = new QBW_UserIdKanrenWk();


        QBW_UserWk qBW_UserWk = new QBW_UserWk();


        String strSubSql = $SELECT + qBW_UserWk.userId +
            $FROM + qBW_UserWk.BW_UserWk() +
            $WHERE + qBW_UserWk.userId.eq(qBW_UserIdKanrenWk.userId) +
            $AND + qBW_UserWk.userNm.ne(qBW_IdCardWk.kanjiidnyuuryokusyanm);


        String queryStr = $SELECT + qBW_IdCardWk +
            $FROM + qBW_IdCardWk.BW_IdCardWk() + "," +
            qBW_UserIdKanrenWk.BW_UserIdKanrenWk() +
            $WHERE + qBW_IdCardWk.idkbn.eq(qBW_UserIdKanrenWk.idkbn) +
            $AND + qBW_IdCardWk.idcd.eq(qBW_UserIdKanrenWk.idcd) +
            $AND + $EXISTS(strSubSql) +
            $ORDER_BY(qBW_IdCardWk.idkbn.asc(),
                qBW_IdCardWk.idcd.asc());

        return em.createJPQL(queryStr).bind(qBW_IdCardWk,qBW_UserIdKanrenWk,qBW_UserWk).getResults();

    }

    public ExDBResults<BW_IdCardWk> getIdCardWks() {

        QBW_IdCardWk qBW_IdCardWk = new QBW_IdCardWk();

        String queryStr = $SELECT + qBW_IdCardWk +
            $FROM + qBW_IdCardWk.BW_IdCardWk() +
            $ORDER_BY(qBW_IdCardWk.idkbn.asc(),
                qBW_IdCardWk.idcd.asc());

        return em.createJPQL(queryStr).bind(qBW_IdCardWk).getResults();
    }

    public Long getIdCardWkCount() {

        QBW_IdCardWk qBW_IdCardWk = new QBW_IdCardWk();

        String queryStr = $SELECT + $COUNT + "(*)" +
            $FROM + qBW_IdCardWk.BW_IdCardWk() ;

        return em.createJPQL(queryStr).bind(qBW_IdCardWk).getSingleResult();
    }

    public ExDBResults<BW_IdCardWk> getIdCardWksSyoukaiUserByNotExistsUserWk() {


        QBW_UserWk qBW_UserWk = new QBW_UserWk("qBW_UserWk");

        QBW_IdCardWk qBW_IdCardWk = new QBW_IdCardWk("qBW_IdCardWk");

        QBW_UserIdKanrenWk qBW_UserIdKanrenWk = new QBW_UserIdKanrenWk("qBW_UserIdKanrenWk");

        QBT_UserKengenHaneiSskInfo qBT_UserKengenHaneiSskInfo = new QBT_UserKengenHaneiSskInfo("qBT_UserKengenHaneiSskInfo");


        String strSubSql = $SELECT + qBW_UserWk +
            $FROM(qBW_UserWk) +
            $WHERE + qBW_UserWk.userId.eq(qBW_UserIdKanrenWk.userId);


        String queryStr = $SELECT + qBW_IdCardWk +
            $FROM(qBW_IdCardWk,
                qBW_UserIdKanrenWk,
                qBT_UserKengenHaneiSskInfo) +
                $WHERE + qBW_IdCardWk.idkbn.eq(qBW_UserIdKanrenWk.idkbn) +
                $AND + qBW_IdCardWk.idcd.eq(qBW_UserIdKanrenWk.idcd) +
                $AND + qBW_IdCardWk.syozokusosikicd.substring(1, 3).eq(qBT_UserKengenHaneiSskInfo.sosikicdkami3) +
                $AND + qBT_UserKengenHaneiSskInfo.hnsyasosikikengenkbn.eq(C_HnsyaSosikiKengenKbn.SYOUKAI) +
                $AND + $NOT_EXISTS(strSubSql) +
                $ORDER_BY(qBW_IdCardWk.idkbn.asc(),
                    qBW_IdCardWk.idcd.asc());

        return em.createJPQL(queryStr).bind(qBW_UserWk, qBW_IdCardWk, qBW_UserIdKanrenWk, qBT_UserKengenHaneiSskInfo).getResults();
    }
}
