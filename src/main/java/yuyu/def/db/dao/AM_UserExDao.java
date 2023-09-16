package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBUpdatableResults;
import yuyu.def.biz.result.bean.UsersByKinouIdKinouModeIdUserIdBean;
import yuyu.def.biz.result.bean.UsersByKinouIdKinouModeIdUserIdFlowIdNodeIdBean;
import yuyu.def.classification.C_HnsyaSosikiKengenKbn;
import yuyu.def.db.entity.AM_User;
import yuyu.def.db.meta.QAM_IdCard;
import yuyu.def.db.meta.QAM_Sosiki;
import yuyu.def.db.meta.QAM_User;
import yuyu.def.db.meta.QAT_KinouKengen;
import yuyu.def.db.meta.QAT_UserIdKanren;
import yuyu.def.db.meta.QAT_UserRole;
import yuyu.def.db.meta.QBT_UserKengenHaneiSskInfo;
import yuyu.def.db.meta.QBW_IdCardWk;
import yuyu.def.db.meta.QBW_UserIdKanrenWk;
import yuyu.def.db.meta.QWT_KengenKoutei;

/**
 * ユーザーマスタ(AM_User) テーブルアクセス用の DAO クラスです。
 */
public class AM_UserExDao extends AbstractDao<AM_User> {

    protected AM_UserExDao() {
        super(AM_User.class);
    }

    public ExDBUpdatableResults<AM_User> getUsersByTables() {


        QAM_User qAM_User = new QAM_User();


        QBW_IdCardWk qBW_IdCardWk = new QBW_IdCardWk();


        QBW_UserIdKanrenWk qBW_UserIdKanrenWk = new QBW_UserIdKanrenWk();


        QBT_UserKengenHaneiSskInfo qBT_UserKengenHaneiSskInfo = new QBT_UserKengenHaneiSskInfo();

        String querySql = $SELECT + qAM_User +
            $FROM  + qAM_User.AM_User() + "," +
            qBW_IdCardWk.BW_IdCardWk() + "," +
            qBW_UserIdKanrenWk.BW_UserIdKanrenWk() + "," +
            qBT_UserKengenHaneiSskInfo.BT_UserKengenHaneiSskInfo() +
            $WHERE + qBW_IdCardWk.idkbn.eq(qBW_UserIdKanrenWk.idkbn) +
            $AND + qBW_IdCardWk.idcd.eq(qBW_UserIdKanrenWk.idcd) +
            $AND + qBW_UserIdKanrenWk.userId.eq(qAM_User.userId) +
            $AND + qBW_IdCardWk.syozokusosikicd.substring(1, 3).eq(qBT_UserKengenHaneiSskInfo.sosikicdkami3) +
            $AND + qBT_UserKengenHaneiSskInfo.hnsyasosikikengenkbn.eq(C_HnsyaSosikiKengenKbn.JIMU) +
            $ORDER_BY(qAM_User.userId.asc());

        return em.createJPQL(querySql).bind(qAM_User, qBW_IdCardWk, qBW_UserIdKanrenWk, qBT_UserKengenHaneiSskInfo).getUpdatableResults();
    }

    public List<UsersByKinouIdKinouModeIdUserIdFlowIdNodeIdBean> getUsersByKinouIdKinouModeIdUserIdFlowIdNodeId(String pKinouId, String pKinouModeId,
        String pUserId, String pFlowId, String pNodeId) {

        QAT_KinouKengen qAT_KinouKengen = new QAT_KinouKengen("qAT_KinouKengen");


        QAT_UserRole qAT_UserRole = new QAT_UserRole("qAT_UserRole");


        QAM_User qAM_User = new QAM_User("qAM_User");


        QWT_KengenKoutei qWT_KengenKoute = new QWT_KengenKoutei("qWT_KengenKoute");


        String querySql = $SELECT_DISTINCT  + $NEW(UsersByKinouIdKinouModeIdUserIdFlowIdNodeIdBean.class,
            qAM_User.userId,
            qAM_User.userNm)+
            $FROM  (qAT_KinouKengen,
                qAT_UserRole,
                qAM_User,
                qWT_KengenKoute) +
                $WHERE + qAT_KinouKengen.kinouId.eq(pKinouId)
                + $AND + qAT_KinouKengen.kinouModeId.eq(pKinouModeId)
                + $AND + qAT_KinouKengen.roleCd.eq(qAT_UserRole.roleCd)
                + $AND + qAT_UserRole.userId.eq(qAM_User.userId)
                + $AND + qAM_User.userId.ne(pUserId)
                + $AND + qWT_KengenKoute.flowId.eq(pFlowId)
                + $AND + qWT_KengenKoute.nodeId.eq(pNodeId)
                + $AND + qWT_KengenKoute.roleCd.eq(qAT_UserRole.roleCd) +
                $ORDER_BY(qAM_User.userId.asc());


        return em.createJPQL(querySql,UsersByKinouIdKinouModeIdUserIdFlowIdNodeIdBean.class).bind(qAT_KinouKengen, qAT_UserRole, qAM_User, qWT_KengenKoute).getResultList();
    }

    public List<UsersByKinouIdKinouModeIdUserIdBean> getUsersByKinouIdKinouModeIdUserId(String pKinouId, String pKinouModeId, String pUserId) {


        QAT_KinouKengen qAT_KinouKengen = new QAT_KinouKengen("qAT_KinouKengen");


        QAT_UserRole qAT_UserRole = new QAT_UserRole("qAT_UserRole");


        QAM_User qAM_User = new QAM_User("qAM_User");


        QAT_UserIdKanren qAT_UserIdKanren = new QAT_UserIdKanren("qAT_UserIdKanren");


        QAM_IdCard qAM_IdCard = new QAM_IdCard("qAM_IdCard");


        QAM_Sosiki qAM_Sosiki = new QAM_Sosiki("qAM_Sosiki");

        String querySql = $SELECT_DISTINCT + $NEW(UsersByKinouIdKinouModeIdUserIdBean.class,
            qAM_User.userId,
            qAM_User.userNm,
            qAM_Sosiki.sosikicd,
            qAM_Sosiki.kanjisosikinm20) +
            $FROM(qAT_KinouKengen,
                qAT_UserRole,
                qAM_User,
                qAT_UserIdKanren,
                qAM_IdCard,
                qAM_Sosiki) +
                $WHERE + qAT_KinouKengen.kinouId.eq(pKinouId) +
                $AND + qAT_KinouKengen.kinouModeId.eq(pKinouModeId) +
                $AND + qAT_KinouKengen.roleCd.eq(qAT_UserRole.roleCd) +
                $AND + qAT_UserRole.userId.eq(qAM_User.userId) +
                $AND + qAM_User.userId.eq(qAT_UserIdKanren.userId) +
                $AND + qAT_UserIdKanren.idkbn.eq(qAM_IdCard.idkbn) +
                $AND + qAT_UserIdKanren.idcd.eq(qAM_IdCard.idcd) +
                $AND + qAM_IdCard.syozokusosikicd.eq(qAM_Sosiki.sosikicd) +
                $AND + qAM_User.userId.ne(pUserId) +
                $ORDER_BY(qAM_Sosiki.sosikicd.asc(),
                    qAM_User.userId.asc());

        return em.createJPQL(querySql, UsersByKinouIdKinouModeIdUserIdBean.class).bind(qAT_KinouKengen, qAT_UserRole, qAM_User, qAT_UserIdKanren, qAM_IdCard, qAM_Sosiki).getResultList();
    }
}