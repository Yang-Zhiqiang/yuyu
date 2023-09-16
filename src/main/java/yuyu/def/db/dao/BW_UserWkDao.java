package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBUpdatableResults;
import yuyu.def.biz.configuration.YuyuBizConfig;
import yuyu.def.classification.C_HnsyaSosikiKengenKbn;
import yuyu.def.classification.C_SpecialUserKbn;
import yuyu.def.db.entity.BW_UserWk;
import yuyu.def.db.meta.QBT_UserKengenHaneiSskInfo;
import yuyu.def.db.meta.QBW_IdCardWk;
import yuyu.def.db.meta.QBW_UserIdKanrenWk;
import yuyu.def.db.meta.QBW_UserRoleWk;
import yuyu.def.db.meta.QBW_UserWk;
/**
 * ユーザーマスタワークテーブル(BW_UserWkDao) アクセス用の DAO クラスです。<br />
 */
public class BW_UserWkDao extends AbstractDao<BW_UserWk> {

    public BW_UserWkDao() {
        super(BW_UserWk.class);
    }

    public BW_UserWk getUserWk(String pUserId) {
        BW_UserWk bW_UserWk =  new BW_UserWk();
        bW_UserWk.setUserId(pUserId);
        return this.selectOne(bW_UserWk);
    }

    public ExDBUpdatableResults<BW_UserWk> getUserWksNotExistsSisyaUserRoleWk(String[] pSisyaReigaiSosikiCdList,
        String[] pSisyayouRoleCdList) {


        QBW_UserWk qBW_UserWk = new QBW_UserWk();


        QBW_UserRoleWk qBW_UserRoleWk = new QBW_UserRoleWk();


        QBW_IdCardWk qBW_IdCardWk = new QBW_IdCardWk();


        QBW_UserIdKanrenWk qBW_UserIdKanrenWk = new QBW_UserIdKanrenWk();


        String strSubSql = $SELECT + qBW_UserRoleWk.userId +
            $FROM(qBW_UserRoleWk) +
            $WHERE + qBW_UserWk.userId.eq(qBW_UserRoleWk.userId);


        String querySql = $SELECT + qBW_UserRoleWk.userId +
            $FROM(qBW_UserRoleWk) +
            $WHERE + qBW_UserWk.userId.eq(qBW_UserRoleWk.userId) +
            $AND + qBW_UserRoleWk.roleCd.notIn(pSisyayouRoleCdList)
            ;


        String sql = $SELECT + qBW_UserWk +
            $FROM(qBW_UserWk,
                qBW_IdCardWk,
                qBW_UserIdKanrenWk) +
                $WHERE + qBW_IdCardWk.idkbn.eq(qBW_UserIdKanrenWk.idkbn) +
                $AND + qBW_IdCardWk.idcd.eq(qBW_UserIdKanrenWk.idcd) +
                $AND + qBW_UserIdKanrenWk.userId.eq(qBW_UserWk.userId) +
                $AND + $($(qBW_IdCardWk.syozokusosikicd.substring(1, 3).lt("300") +
                    $OR + qBW_IdCardWk.syozokusosikicd.substring(1, 3).in(YuyuBizConfig.getInstance().getSisyaAtukaiSosikiCdList())) +
                    $AND + qBW_IdCardWk.syozokusosikicd.substring(4, 1).eq("0") +
                    $AND + $($(qBW_IdCardWk.idkbn.eq("01") +
                        $AND + qBW_IdCardWk.tanmatusiyoukbn.in("1","2")) +
                        $OR + $(qBW_IdCardWk.idkbn.eq("03") +
                            $AND + qBW_IdCardWk.tanmatusiyoukbn.eq("1"))) +
                            $AND + qBW_IdCardWk.syozokusosikicd.substring(1, 3).notIn(pSisyaReigaiSosikiCdList)) +
                            $AND + $($NOT_EXISTS(strSubSql) +
                                $OR + $EXISTS(querySql)) +
                                $ORDER_BY(qBW_UserWk.userId.asc());

        return em.createJPQL(sql).bind(qBW_UserWk,qBW_UserRoleWk,qBW_IdCardWk, qBW_UserIdKanrenWk).getUpdatableResults();
    }

    public ExDBUpdatableResults<BW_UserWk> getUserWksNotExistsUserIdKanrenWk() {


        QBW_UserWk qBW_UserWk = new QBW_UserWk();


        QBW_UserIdKanrenWk qBW_UserIdKanrenWk = new QBW_UserIdKanrenWk();


        String strSubSql = $SELECT + qBW_UserIdKanrenWk.idkbn +
            $FROM + qBW_UserIdKanrenWk.BW_UserIdKanrenWk() +
            $WHERE + qBW_UserIdKanrenWk.userId.eq(qBW_UserWk.userId);


        String sql = $SELECT + qBW_UserWk +
            $FROM + qBW_UserWk.BW_UserWk() +
            $WHERE + qBW_UserWk.specialUserKbn.eq(C_SpecialUserKbn.IPPAN) +
            $AND + $NOT_EXISTS(strSubSql) +
            $ORDER_BY(qBW_UserWk.userId.asc());

        return em.createJPQL(sql).bind(qBW_UserWk, qBW_UserIdKanrenWk).getUpdatableResults();
    }

    public ExDBUpdatableResults<BW_UserWk> getUserWksNotExistsUserKengenHaneiSskInfo(String[] pSisyaReigaiSosikiCdList) {


        QBW_UserWk qBW_UserWk = new QBW_UserWk();


        QBW_UserRoleWk qBW_UserRoleWk = new QBW_UserRoleWk();


        QBW_IdCardWk qBW_IdCardWk = new QBW_IdCardWk();


        QBW_UserIdKanrenWk qBW_UserIdKanrenWk = new QBW_UserIdKanrenWk();


        QBT_UserKengenHaneiSskInfo qBT_UserKengenHaneiSskInfo = new QBT_UserKengenHaneiSskInfo();


        String strSubSql = $SELECT + qBW_UserRoleWk.userId +
            $FROM(qBW_UserRoleWk) +
            $WHERE + qBW_UserRoleWk.userId.eq(qBW_UserWk.userId);


        String querySql = $SELECT + qBT_UserKengenHaneiSskInfo.sosikicdkami3 +
            $FROM(qBT_UserKengenHaneiSskInfo) +
            $WHERE + qBW_IdCardWk.syozokusosikicd.substring(1, 3).eq(qBT_UserKengenHaneiSskInfo.sosikicdkami3);


        String sql = $SELECT + qBW_UserWk +
            $FROM(qBW_UserWk,
                qBW_IdCardWk,
                qBW_UserIdKanrenWk) +
                $WHERE + qBW_IdCardWk.idkbn.eq(qBW_UserIdKanrenWk.idkbn) +
                $AND + qBW_IdCardWk.idcd.eq(qBW_UserIdKanrenWk.idcd) +
                $AND + qBW_UserIdKanrenWk.userId.eq(qBW_UserWk.userId) +
                $AND + $EXISTS(strSubSql) +
                $AND + $NOT_EXISTS(querySql) +
                $AND + $NOT + "(" + "(" + qBW_IdCardWk.syozokusosikicd.substring(1, 3).lt("300") +
                $OR + qBW_IdCardWk.syozokusosikicd.substring(1, 3).in(YuyuBizConfig.getInstance().getSisyaAtukaiSosikiCdList()) + ")" +
                $AND + qBW_IdCardWk.syozokusosikicd.substring(4, 1).eq("0") +
                $AND + qBW_IdCardWk.tanmatusiyoukbn.eq("1") + ")" +
                $AND + qBW_IdCardWk.syozokusosikicd.substring(1, 3).notIn(pSisyaReigaiSosikiCdList) +
                $ORDER_BY(qBW_UserWk.userId.asc());

        return em.createJPQL(sql).bind(qBW_UserWk, qBW_UserRoleWk, qBW_IdCardWk, qBW_UserIdKanrenWk, qBT_UserKengenHaneiSskInfo).getUpdatableResults();
    }

    public ExDBUpdatableResults<BW_UserWk> getUserWksNotExistsUserKengenHaneiSskInfo(String[] pSisyaAtukaiSosikiCdList, String[] pSisyaReigaiSosikiCdList) {


        QBW_UserWk qBW_UserWk = new QBW_UserWk();


        QBW_UserRoleWk qBW_UserRoleWk = new QBW_UserRoleWk();


        QBW_IdCardWk qBW_IdCardWk = new QBW_IdCardWk();


        QBW_UserIdKanrenWk qBW_UserIdKanrenWk = new QBW_UserIdKanrenWk();


        QBT_UserKengenHaneiSskInfo qBT_UserKengenHaneiSskInfo = new QBT_UserKengenHaneiSskInfo();


        String strSubSql = $SELECT + qBW_UserRoleWk.userId +
            $FROM(qBW_UserRoleWk) +
            $WHERE + qBW_UserRoleWk.userId.eq(qBW_UserWk.userId);


        String querySql = $SELECT + qBT_UserKengenHaneiSskInfo.sosikicdkami3 +
            $FROM(qBT_UserKengenHaneiSskInfo) +
            $WHERE + qBW_IdCardWk.syozokusosikicd.substring(1, 3).eq(qBT_UserKengenHaneiSskInfo.sosikicdkami3) +
            $AND + $( qBT_UserKengenHaneiSskInfo.hnsyasosikikengenkbn.eq(C_HnsyaSosikiKengenKbn.JIMU) +
                $OR + qBT_UserKengenHaneiSskInfo.hnsyasosikikengenkbn.eq(C_HnsyaSosikiKengenKbn.SYOUKAI) );


        String sql = $SELECT + qBW_UserWk +
            $FROM(qBW_UserWk,
                qBW_IdCardWk,
                qBW_UserIdKanrenWk) +
                $WHERE + qBW_IdCardWk.idkbn.eq(qBW_UserIdKanrenWk.idkbn) +
                $AND + qBW_IdCardWk.idcd.eq(qBW_UserIdKanrenWk.idcd) +
                $AND + qBW_UserIdKanrenWk.userId.eq(qBW_UserWk.userId) +
                $AND + $EXISTS(strSubSql) +
                $AND + $NOT_EXISTS(querySql) +
                $AND + $NOT + "(" + "(" + qBW_IdCardWk.syozokusosikicd.substring(1, 3).lt("300") +
                $OR + qBW_IdCardWk.syozokusosikicd.substring(1, 3).in(pSisyaAtukaiSosikiCdList) + ")" +
                $AND + qBW_IdCardWk.syozokusosikicd.substring(4, 1).eq("0") +
                $AND + $($(qBW_IdCardWk.idkbn.eq("01") +
                    $AND + qBW_IdCardWk.tanmatusiyoukbn.in("1","2")) +
                    $OR + $(qBW_IdCardWk.idkbn.eq("03") +
                        $AND + qBW_IdCardWk.tanmatusiyoukbn.eq("1"))) +
                        $AND + qBW_IdCardWk.syozokusosikicd.substring(1, 3).notIn(pSisyaReigaiSosikiCdList) + ")" +
                        $ORDER_BY(qBW_UserWk.userId.asc());

        return em.createJPQL(sql).bind(qBW_UserWk, qBW_UserRoleWk, qBW_IdCardWk, qBW_UserIdKanrenWk, qBT_UserKengenHaneiSskInfo).getUpdatableResults();
    }

    public ExDBUpdatableResults<BW_UserWk> getUserWksBySyozokusosikicdKeta3() {


        QBW_IdCardWk qBW_IdCardWk = new QBW_IdCardWk();


        QBT_UserKengenHaneiSskInfo qBT_UserKengenHaneiSskInfo = new QBT_UserKengenHaneiSskInfo();


        QBW_UserIdKanrenWk qBW_UserIdKanrenWk = new QBW_UserIdKanrenWk();


        QBW_UserWk qBW_UserWk = new QBW_UserWk();


        String sql = $SELECT + qBW_UserWk +
            $FROM(qBW_UserWk,
                qBW_IdCardWk,
                qBW_UserIdKanrenWk,
                qBT_UserKengenHaneiSskInfo) +
                $WHERE + qBW_IdCardWk.idkbn.eq(qBW_UserIdKanrenWk.idkbn) +
                $AND + qBW_IdCardWk.idcd.eq(qBW_UserIdKanrenWk.idcd) +
                $AND + qBW_UserIdKanrenWk.userId.eq(qBW_UserWk.userId) +
                $AND + qBW_IdCardWk.syozokusosikicd.substring(1, 3).eq(qBT_UserKengenHaneiSskInfo.sosikicdkami3) +
                $AND + qBT_UserKengenHaneiSskInfo.hnsyasosikikengenkbn.eq(C_HnsyaSosikiKengenKbn.JIMU) +
                $ORDER_BY(qBW_UserWk.userId.asc());

        return em.createJPQL(sql).bind(qBW_IdCardWk, qBT_UserKengenHaneiSskInfo, qBW_UserIdKanrenWk, qBW_UserWk).getUpdatableResults();
    }

    public ExDBUpdatableResults<BW_UserWk> getUserWksNotExistsSyoukaiUserRoleWk(String[] pHonsyayouRoleCdList) {


        QBW_UserWk qBW_UserWk = new QBW_UserWk();


        QBW_UserRoleWk qBW_UserRoleWk = new QBW_UserRoleWk();


        QBW_IdCardWk qBW_IdCardWk = new QBW_IdCardWk();


        QBW_UserIdKanrenWk qBW_UserIdKanrenWk = new QBW_UserIdKanrenWk();


        QBT_UserKengenHaneiSskInfo qBT_UserKengenHaneiSskInfo = new QBT_UserKengenHaneiSskInfo();


        String strSubSql = $SELECT + qBW_UserRoleWk.userId +
            $FROM(qBW_UserRoleWk) +
            $WHERE + qBW_UserWk.userId.eq(qBW_UserRoleWk.userId);


        String querySql = $SELECT + qBW_UserRoleWk.userId +
            $FROM(qBW_UserRoleWk) +
            $WHERE + qBW_UserWk.userId.eq(qBW_UserRoleWk.userId) +
            $AND + qBW_UserRoleWk.roleCd.notIn(pHonsyayouRoleCdList);


        String sql = $SELECT + qBW_UserWk +
            $FROM(qBW_UserWk,
                qBW_IdCardWk,
                qBW_UserIdKanrenWk,
                qBT_UserKengenHaneiSskInfo) +
                $WHERE + qBW_IdCardWk.idkbn.eq(qBW_UserIdKanrenWk.idkbn) +
                $AND + qBW_IdCardWk.idcd.eq(qBW_UserIdKanrenWk.idcd) +
                $AND + qBW_UserIdKanrenWk.userId.eq(qBW_UserWk.userId) +
                $AND + qBW_IdCardWk.syozokusosikicd.substring(1, 3).eq(qBT_UserKengenHaneiSskInfo.sosikicdkami3) +
                $AND + qBT_UserKengenHaneiSskInfo.hnsyasosikikengenkbn.eq(C_HnsyaSosikiKengenKbn.SYOUKAI) +
                $AND + $($NOT_EXISTS(strSubSql) +
                    $OR + $EXISTS(querySql)) +
                    $ORDER_BY(qBW_UserWk.userId.asc());

        return em.createJPQL(sql).bind(qBW_UserWk,
            qBW_UserRoleWk,
            qBW_IdCardWk,
            qBW_UserIdKanrenWk,
            qBT_UserKengenHaneiSskInfo).getUpdatableResults();
    }
}
