package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.util.string.StringUtil;
import yuyu.def.base.result.bean.TaisyouUserAndUserRoleInfosByItemsBean;
import yuyu.def.base.result.bean.TaisyouUserInfosByItemsBean;
import yuyu.def.classification.C_SpecialUserKbn;
import yuyu.def.db.entity.AM_User;
import yuyu.def.db.meta.QAM_IdCard;
import yuyu.def.db.meta.QAM_Role;
import yuyu.def.db.meta.QAM_User;
import yuyu.def.db.meta.QAS_KinouMode;
import yuyu.def.db.meta.QAT_KinouKengen;
import yuyu.def.db.meta.QAT_UserIdKanren;
import yuyu.def.db.meta.QAT_UserRole;

/**
 * ユーザーマスタ(AM_User) テーブルアクセス用の DAO クラスです。
 */
public class AM_UserDao extends AbstractDao<AM_User> {

    protected AM_UserDao() {
        super(AM_User.class);
    }

    public AM_User getAM_User(String pUserId){

        AM_User user = new AM_User();
        user.setUserId(pUserId);

        return selectOne(user);
    }


    public long getUserByCountUserGroupCd (String pUserGroupCd){

        QAM_User qUser = new QAM_User();
        return  em.createJPQL(
            $SELECT + $COUNT(qUser.userId) +
            $FROM   + qUser.AM_User() +
            $WHERE  + qUser.userGroupCd.eq(pUserGroupCd)
            ).bind(qUser).<Long>getSingleResult();
    }

    public long getUserCountByUserIdKinouIdKinouModeId(String pUserId, String pKinouId, String pKinouModeId) {


        QAM_User qAM_User = new QAM_User();

        QAM_Role qAM_Role = new QAM_Role();

        QAT_UserRole qAT_UserRole = new QAT_UserRole();

        QAT_KinouKengen qT_KinouKengen = new QAT_KinouKengen();

        QAS_KinouMode qAS_KinouMode = new QAS_KinouMode();


        String subQuerry = $SELECT + qT_KinouKengen.roleCd +
            $FROM + qT_KinouKengen.AT_KinouKengen() + "," +
            qAS_KinouMode.AS_KinouMode() +
            $WHERE + qAS_KinouMode.kinouId.eq(pKinouId) +
            $AND + qAS_KinouMode.kinouModeId.eq(pKinouModeId) +
            $AND + qAS_KinouMode.kinouId.eq(qT_KinouKengen.kinouId) +
            $AND + qAS_KinouMode.kinouModeId.eq(qT_KinouKengen.kinouModeId) +
            $AND + qT_KinouKengen.roleCd.eq(qAT_UserRole.roleCd);


        String mainQuerry = $SELECT + $COUNT + "(*)" +
            $FROM + qAM_User.AM_User() + "," +
            qAM_Role.AM_Role() + "," +
            qAT_UserRole.AT_UserRole() +
            $WHERE + qAM_User.userId.eq(pUserId) +
            $AND + qAM_User.userId.eq(qAT_UserRole.userId) +
            $AND + qAT_UserRole.roleCd.eq(qAM_Role.roleCd) +
            $AND + $EXISTS(subQuerry);

        return em.createJPQL(mainQuerry).bind(qAM_User, qAM_Role, qAT_UserRole, qT_KinouKengen, qAS_KinouMode).getSingleResult();
    }

    public List<AM_User> getUsersByUserIdUserNmSyozokusosikicd(String pUserId, String pUserNm, String pSyozokusosikicd){


        QAM_User qAM_User = new QAM_User();

        QAT_UserIdKanren qAT_UserIdKanren = new QAT_UserIdKanren();

        QAM_IdCard qAM_IdCard = new QAM_IdCard();


        String subQuerry = "";

        if(!StringUtil.isNullOrBlank(pUserId)){
            subQuerry =$AND + qAM_User.userId.like(pUserId + "%");
        }

        if(!StringUtil.isNullOrBlank(pUserNm)){
            subQuerry = subQuerry + $AND + qAM_User.userNm.like("%" + pUserNm + "%");
        }

        if(!StringUtil.isNullOrBlank(pSyozokusosikicd)){
            subQuerry = subQuerry + $AND + qAM_IdCard.syozokusosikicd.like(pSyozokusosikicd + "%") +
                $AND + qAM_IdCard.syozokusosikicd.substring(1, 3).ge("300") +
                $AND + qAM_IdCard.syozokusosikicd.substring(4,1).eq("0")  ;
        }


        String mainQuerry = $SELECT + qAM_User +
            $FROM + qAM_User.AM_User() + "," +
            qAT_UserIdKanren.AT_UserIdKanren() + "," +
            qAM_IdCard.AM_IdCard() +
            $WHERE + qAM_User.userId.eq(qAT_UserIdKanren.userId) +
            $AND + qAT_UserIdKanren.idkbn.eq(qAM_IdCard.idkbn) +
            $AND + qAT_UserIdKanren.idcd.eq(qAM_IdCard.idcd) +
            subQuerry +
            $ORDER_BY(qAM_User.userId.asc());

        return em.createJPQL(mainQuerry).bind(qAM_User, qAT_UserIdKanren, qAM_IdCard).getResultList();
    }


    public List<TaisyouUserInfosByItemsBean> getTaisyouUserInfosByItems(String pUserId, String pUserNm, String pSyozokusosikicd,
        String[] pSisyaAtukaiSosikiCdList, String[] pSisyaReigaiSosikiCdList){


        QAM_User qAM_User = new QAM_User("qAM_User");

        QAT_UserIdKanren qAT_UserIdKanren = new QAT_UserIdKanren("qAT_UserIdKanren");

        QAM_IdCard qAM_IdCard = new QAM_IdCard("qAM_IdCard");


        String subQuerry = "";

        if(!StringUtil.isNullOrBlank(pUserId)){
            subQuerry =$AND + qAM_User.userId.like(pUserId + "%");
        }

        if(!StringUtil.isNullOrBlank(pUserNm)){
            subQuerry = subQuerry + $AND + qAM_User.userNm.like("%" + pUserNm + "%");
        }

        if(!StringUtil.isNullOrBlank(pSyozokusosikicd)){
            subQuerry = subQuerry + $AND + qAM_IdCard.syozokusosikicd.like(pSyozokusosikicd + "%") ;
        }


        String mainQuerry = $SELECT + $NEW(TaisyouUserInfosByItemsBean.class,
            qAM_User.userId,
            qAM_User.userNm) +
            $FROM (qAM_User,
                qAT_UserIdKanren,
                qAM_IdCard)  +
                $WHERE + qAM_User.userId.eq(qAT_UserIdKanren.userId) +
                $AND + qAT_UserIdKanren.idkbn.eq(qAM_IdCard.idkbn) +
                $AND + qAT_UserIdKanren.idcd.eq(qAM_IdCard.idcd) +
                subQuerry +
                $AND +"("+ "("+ qAM_IdCard.syozokusosikicd.substring(1, 3).ge("300") +
                $AND + qAM_IdCard.syozokusosikicd.substring(1, 3).notIn(pSisyaAtukaiSosikiCdList) + ")" +
                $OR +"(" + qAM_IdCard.syozokusosikicd.substring(1, 3).lt("300") +
                $AND + qAM_IdCard.syozokusosikicd.substring(1, 3).in(pSisyaReigaiSosikiCdList) + ")" + ")"+
                $AND + qAM_User.specialUserKbn.eq(C_SpecialUserKbn.IPPAN) +
                $ORDER_BY(qAM_User.userId.asc());

        return em.createJPQL(mainQuerry,TaisyouUserInfosByItemsBean.class).bind(qAM_User, qAT_UserIdKanren, qAM_IdCard).getResultList();
    }

    public List<TaisyouUserAndUserRoleInfosByItemsBean> getTaisyouUserAndUserRoleInfosByItems(String pUserId,
        String pUserNm, String pSyozokusosikicd, String[] pSisyaAtukaiSosikiCdList, String[] pSisyaReigaiSosikiCdList) {


        QAM_User qAM_User = new QAM_User("qAM_User");

        QAT_UserIdKanren qAT_UserIdKanren = new QAT_UserIdKanren("qAT_UserIdKanren");

        QAM_IdCard qAM_IdCard = new QAM_IdCard("qAM_IdCard");

        QAM_Role qAM_Role = new QAM_Role("qAM_Role");

        QAT_UserRole qAT_UserRole = new QAT_UserRole("qAT_UserRole");


        String subQuerry = "";


        if(!StringUtil.isNullOrBlank(pUserId)){
            subQuerry =$AND + qAM_User.userId.like(pUserId + "%");
        }

        if(!StringUtil.isNullOrBlank(pUserNm)){
            subQuerry = subQuerry + $AND + qAM_User.userNm.like("%" + pUserNm + "%");
        }

        if(!StringUtil.isNullOrBlank(pSyozokusosikicd)){
            subQuerry = subQuerry + $AND + qAM_IdCard.syozokusosikicd.like(pSyozokusosikicd + "%") ;
        }


        String mainQuerry = $SELECT + $NEW(TaisyouUserAndUserRoleInfosByItemsBean.class,
            qAM_User.userId,
            qAM_User.userNm,
            qAT_UserRole.roleCd,
            qAM_Role.roleNm) +
            $FROM(qAM_IdCard,
                qAT_UserIdKanren,
                qAM_User) +
                $LEFT_OUTER_JOIN  + qAM_User.AT_UserRole() +
                $AS + qAT_UserRole +
                $LEFT_OUTER_JOIN + qAT_UserRole.AM_Role() +
                $AS + qAM_Role +
                $WHERE + qAM_User.userId.eq(qAT_UserIdKanren.userId) +
                $AND + qAT_UserIdKanren.idkbn.eq(qAM_IdCard.idkbn) +
                $AND + qAT_UserIdKanren.idcd.eq(qAM_IdCard.idcd) +
                subQuerry +
                $AND  + $((qAM_IdCard.syozokusosikicd.substring(1, 3).ge("300") +
                    $AND + qAM_IdCard.syozokusosikicd.substring(1, 3).notIn(pSisyaAtukaiSosikiCdList)) +
                    $OR + $(qAM_IdCard.syozokusosikicd.substring(1, 3).lt("300") +
                        $AND + qAM_IdCard.syozokusosikicd.substring(1, 3).in(pSisyaReigaiSosikiCdList))) +
                        $AND + qAM_User.specialUserKbn.eq(C_SpecialUserKbn.IPPAN) +
                        $ORDER_BY(qAM_User.userId.asc(),
                            qAM_Role.roleCd.asc());

        return em.createJPQL(mainQuerry, TaisyouUserAndUserRoleInfosByItemsBean.class)
            .bind(qAM_User, qAT_UserIdKanren, qAM_IdCard, qAM_Role, qAT_UserRole).getResultList();
    }

    @Override
    public List<AM_User> select(AM_User pCondition) {
        return new ArrayList<>(new LinkedHashSet<>(super.select(pCondition)));
    }

    @Override
    public List<AM_User> selectAll() {
        return new ArrayList<>(new LinkedHashSet<>(super.selectAll()));
    }
}