package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

import yuyu.def.db.entity.WT_KengenSyorui;
import yuyu.def.db.id.PKWT_KengenSyorui;
import yuyu.def.db.meta.QAT_UserRole;
import yuyu.def.db.meta.QWT_KengenSyorui;

/**
 * 権限明細（書類）テーブル(WT_KengenSyorui) テーブルアクセス用の DAO クラスです。
 *
 */
public class WT_KengenSyoruiDao extends AbstractDao<WT_KengenSyorui> {

    public WT_KengenSyoruiDao() {

        super(WT_KengenSyorui.class);
    }

    public WT_KengenSyorui getKengenSyorui(String pRoleCd, String pTorikomiSyoruiCd) {

        return selectPk(new PKWT_KengenSyorui(pRoleCd, pTorikomiSyoruiCd));
    }

    public List<WT_KengenSyorui> getKengenSyoruisByRoleCd(String pRoleCd) {

        WT_KengenSyorui condition = new WT_KengenSyorui();

        condition.setRoleCd(pRoleCd);

        return select(condition);
    }

    public List<WT_KengenSyorui> getKengenSyoruisByRoleCds(String[] pRoleCds) {

        QWT_KengenSyorui kengenSyorui = new QWT_KengenSyorui();


        String query = $SELECT + kengenSyorui + $FROM + kengenSyorui.WT_KengenSyorui() + $WHERE
                + kengenSyorui.roleCd.in(pRoleCds);

        return em.createJPQL(query.toString()).bind(kengenSyorui).getResultList();
    }

    public List<WT_KengenSyorui> getKengenSyoruis(String pTorikomiSyoruiCd, String... pRoleCds) {

        QWT_KengenSyorui kengenSyorui = new QWT_KengenSyorui("kengenSyorui");

        StringBuilder mainQuery = new StringBuilder();
        boolean firstFlg = true;
        mainQuery.append($SELECT + kengenSyorui);
        mainQuery.append($FROM + kengenSyorui.WT_KengenSyorui());


        if (!StringUtils.isEmpty(pTorikomiSyoruiCd)) {
            mainQuery.append($WHERE + kengenSyorui.torikomiSyoruiCd.eq(pTorikomiSyoruiCd));
            firstFlg = false;
        }


        if (null != pRoleCds && !ArrayUtils.isEmpty(pRoleCds)) {
            if(firstFlg){
                mainQuery.append($WHERE);
            } else {
                mainQuery.append($AND);
            }
            mainQuery.append(kengenSyorui.roleCd.in(pRoleCds));
        }

        return em.createJPQL(mainQuery.toString()).bind(kengenSyorui).getResultList();
    }

    public List<WT_KengenSyorui> getKengenSyoruiByUserId(String pUserId) {


        QAT_UserRole qAT_UserRole = new QAT_UserRole("qAT_UserRole");


        QWT_KengenSyorui qWT_KengenSyorui = new QWT_KengenSyorui("qWT_KengenSyorui");

        String querySql = $SELECT + qWT_KengenSyorui +
                $FROM + qWT_KengenSyorui.WT_KengenSyorui() + "," + qAT_UserRole.AT_UserRole() +
                $WHERE + qAT_UserRole.roleCd.eq(qWT_KengenSyorui.roleCd)
                + $AND + qAT_UserRole.userId.eq(pUserId);

        return em.createJPQL(querySql).bind(qWT_KengenSyorui, qAT_UserRole).getResultList();
    }
}