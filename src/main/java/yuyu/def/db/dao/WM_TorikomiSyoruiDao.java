package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.WM_TorikomiSyorui;
import yuyu.def.db.id.PKWM_TorikomiSyorui;
import yuyu.def.db.meta.QWM_TorikomiSyorui;

/**
 * 取込書類マスタ(WM_TorikomiSyorui) テーブルアクセス用の DAO クラスです。<br />
 *
 */
public class WM_TorikomiSyoruiDao extends AbstractDao<WM_TorikomiSyorui> {

    public WM_TorikomiSyoruiDao() {

        super(WM_TorikomiSyorui.class);
    }

    public WM_TorikomiSyorui getTorikomiSyorui(String pTorikomiSyoruiCd) {
        return selectPk(new PKWM_TorikomiSyorui(pTorikomiSyoruiCd));
    }

    public List<WM_TorikomiSyorui> getAllTorikomiSyorui() {

        return selectAll();
    }

    public List<WM_TorikomiSyorui> getTorikomiSyoruis(String pTorikomiSyoruiCd) {

        WM_TorikomiSyorui condition = new WM_TorikomiSyorui();

        condition.setTorikomiSyoruiCd(pTorikomiSyoruiCd);

        return getTorikomiSyoruis(condition);
    }

    public List<WM_TorikomiSyorui> getTorikomiSyoruis(String pTorikomiSyoruiCd, String pSyzkDaibunruiId, String pSyzkSyoubunruiId, String pFlowId, String pNodeId) {

        WM_TorikomiSyorui condition = new WM_TorikomiSyorui();

        condition.setTorikomiSyoruiCd(pTorikomiSyoruiCd);
        condition.setSyzkDaiBunruiId(pSyzkDaibunruiId);
        condition.setSyzkSyouBunruiId(pSyzkSyoubunruiId);
        condition.setFlowId(pFlowId);
        condition.setNodeId(pNodeId);

        return getTorikomiSyoruis(condition);
    }

    private List<WM_TorikomiSyorui> getTorikomiSyoruis(WM_TorikomiSyorui pWM_TorikomiSyorui) {

        return select(pWM_TorikomiSyorui);
    }

    public List<WM_TorikomiSyorui> getTorikomiSyoruis(String pTorikomiSyoruiCd, String[] pFlowids) {

        QWM_TorikomiSyorui qWM_TorikomiSyorui = new QWM_TorikomiSyorui();


        StringBuffer mainQuery = new StringBuffer();

        mainQuery.append($SELECT + qWM_TorikomiSyorui + $FROM + qWM_TorikomiSyorui.WM_TorikomiSyorui() + $WHERE +
            qWM_TorikomiSyorui.torikomiSyoruiCd.eq(qWM_TorikomiSyorui.torikomiSyoruiCd));

        if (StringUtils.isNotEmpty(pTorikomiSyoruiCd)) {

            mainQuery.append($AND + qWM_TorikomiSyorui.torikomiSyoruiCd.eq(pTorikomiSyoruiCd));
        }

        if (null != pFlowids && !ArrayUtils.isEmpty(pFlowids)) {

            mainQuery.append($AND + qWM_TorikomiSyorui.flowId.in(pFlowids));
        }

        return em.createJPQL(mainQuery.toString()).bind(qWM_TorikomiSyorui).getResultList();
    }
}