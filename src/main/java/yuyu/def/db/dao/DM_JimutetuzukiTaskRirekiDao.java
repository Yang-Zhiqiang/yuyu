package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.entity.DM_JimutetuzukiTaskRireki;
import java.util.List;

/**
 * 事務手続タスクマスタ履歴保存テーブル(DM_JimutetuzukiTaskRirekiDao) アクセス用の DAO クラスです。<br />
 */
public class DM_JimutetuzukiTaskRirekiDao extends AbstractDao<DM_JimutetuzukiTaskRireki> {

    public DM_JimutetuzukiTaskRirekiDao() {
        super(DM_JimutetuzukiTaskRireki.class);
    }

    @Deprecated
    public DM_JimutetuzukiTaskRireki getJimutetuzukiTaskRireki(BizDate pKensuuHokanYmd, String pSubSystemId, String pJimutetuzukicd, String pWorkflowTskId) {
        DM_JimutetuzukiTaskRireki dM_JimutetuzukiTaskRireki =  new DM_JimutetuzukiTaskRireki();
        dM_JimutetuzukiTaskRireki.setKensuuHokanYmd(pKensuuHokanYmd);
        dM_JimutetuzukiTaskRireki.setSubSystemId(pSubSystemId);
        dM_JimutetuzukiTaskRireki.setJimutetuzukicd(pJimutetuzukicd);
        dM_JimutetuzukiTaskRireki.setWorkflowTskId(pWorkflowTskId);
        return this.selectOne(dM_JimutetuzukiTaskRireki);
    }

    @Override
    @Deprecated
    public List<DM_JimutetuzukiTaskRireki> selectAll() {
        return super.selectAll();
    }
}
