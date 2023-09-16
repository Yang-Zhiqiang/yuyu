package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.WT_KengenKoutei;
import yuyu.def.db.id.PKWT_KengenKoutei;
import yuyu.def.db.meta.QAT_UserRole;
import yuyu.def.db.meta.QWT_KengenKoutei;

/**
 * 権限明細（工程）テーブル(WT_KengenKoutei) テーブルアクセス用の DAO クラスです。
 *
 */
public class WT_KengenKouteiDao extends AbstractDao<WT_KengenKoutei> {

    public WT_KengenKouteiDao() {
        super(WT_KengenKoutei.class);
    }

    public WT_KengenKoutei getKengenKoutei(String pRoleCd, String pFlowId, String pNodeId) {
        return selectPk(new PKWT_KengenKoutei(pRoleCd, pFlowId, pNodeId));
    }

    public List<WT_KengenKoutei> getKengenKouteisByRoleCd(String pRoleCd) {
        WT_KengenKoutei condition = new WT_KengenKoutei();
        condition.setRoleCd(pRoleCd);
        return this.select(condition);
    }

    public List<WT_KengenKoutei> getKengenKouteisByRoleCds(String[] pRoleCds) {

        QWT_KengenKoutei kengenKoutei = new QWT_KengenKoutei();


        String query = $SELECT + kengenKoutei + $FROM + kengenKoutei.WT_KengenKoutei() + $WHERE
            + kengenKoutei.roleCd.in(pRoleCds);

        return em.createJPQL(query.toString()).bind(kengenKoutei).getResultList();
    }

    public List<WT_KengenKoutei> getKengenKouteisByFlowIdNodeId(String pFlowId, String pNodeId) {
        WT_KengenKoutei condition = new WT_KengenKoutei();
        condition.setFlowId(pFlowId);
        condition.setNodeId(pNodeId);
        return this.select(condition);
    }

    public List<WT_KengenKoutei> getKengenKouteisByFlowIdRoleCd(String pFlowId, String pRoleCd) {
        WT_KengenKoutei condition = new WT_KengenKoutei();
        condition.setFlowId(pFlowId);
        condition.setRoleCd(pRoleCd);
        return this.select(condition);
    }

    public List<WT_KengenKoutei> getKengenKouteiByUserId(String pUserId) {


        QAT_UserRole qAT_UserRole = new QAT_UserRole("qAT_UserRole");


        QWT_KengenKoutei qWT_KengenKoutei = new QWT_KengenKoutei("qWT_KengenKoutei");

        String querySql = $SELECT + qWT_KengenKoutei +
            $FROM + qWT_KengenKoutei.WT_KengenKoutei() + "," + qAT_UserRole.AT_UserRole() +
            $WHERE + qAT_UserRole.roleCd.eq(qWT_KengenKoutei.roleCd)
            + $AND + qAT_UserRole.userId.eq(pUserId);

        return em.createJPQL(querySql).bind(qWT_KengenKoutei, qAT_UserRole).getResultList();
    }
}
