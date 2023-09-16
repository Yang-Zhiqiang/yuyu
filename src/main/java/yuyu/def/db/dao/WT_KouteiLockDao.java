package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;

import org.apache.commons.lang.ArrayUtils;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfDateUtils;
import yuyu.def.db.entity.WT_KouteiLock;
import yuyu.def.db.id.PKWT_KouteiLock;
import yuyu.def.db.meta.QWT_KouteiLock;

/**
 * 工程ロック情報テーブル(WT_KouteiLock) テーブルアクセス用の DAO クラスです。<br />
 *
 */
public class WT_KouteiLockDao extends AbstractDao<WT_KouteiLock> {

    public WT_KouteiLockDao() {

        super(WT_KouteiLock.class);
    }

    public WT_KouteiLock getKouteiLock(String pFlowId, String pGyoumuKey) {
        return selectPk(new PKWT_KouteiLock(pFlowId, pGyoumuKey));
    }

    public List<WT_KouteiLock> getAllKouteiLock() {

        return selectAll();
    }

    public List<WT_KouteiLock> getKouteiLockByCond(String[] pGyoumukeys, String[] pFlowids) {

        QWT_KouteiLock qKouteiLock = new QWT_KouteiLock("kouteiLock");


        StringBuffer mainQuery = new StringBuffer();
        mainQuery.append($SELECT + qKouteiLock);


        mainQuery.append(getWhereQuery(qKouteiLock, pGyoumukeys, pFlowids));

        return em.createJPQL(mainQuery.toString()).bind(qKouteiLock).getResultList();
    }

    private String getWhereQuery(QWT_KouteiLock kouteiLock, String[] pGyoumukeys, String[] pFlowids) {

        StringBuffer sbSql = new StringBuffer();
        sbSql.append($FROM + kouteiLock.WT_KouteiLock());
        sbSql.append($WHERE + kouteiLock.gyoumuKey.eq(kouteiLock.gyoumuKey));

        if (null != pGyoumukeys && !ArrayUtils.isEmpty(pGyoumukeys)) {

            sbSql.append($AND + kouteiLock.gyoumuKey.in(pGyoumukeys));
        }

        if (null != pFlowids && !ArrayUtils.isEmpty(pFlowids)) {

            sbSql.append($AND + kouteiLock.flowId.in(pFlowids));
        }

        sbSql.append($AND + kouteiLock.lockTime.gt(IwfDateUtils.getLockYuukouTime()));

        return sbSql.toString();
    }
}