package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.entity.DM_JimutetuzukiRireki;
import java.util.List;

/**
 * 事務手続マスタ履歴保存テーブル(DM_JimutetuzukiRirekiDao) アクセス用の DAO クラスです。<br />
 */
public class DM_JimutetuzukiRirekiDao extends AbstractDao<DM_JimutetuzukiRireki> {

    public DM_JimutetuzukiRirekiDao() {
        super(DM_JimutetuzukiRireki.class);
    }

    @Deprecated
    public DM_JimutetuzukiRireki getJimutetuzukiRireki(BizDate pKensuuHokanYmd, String pJimutetuzukicd, String pSubSystemId) {
        DM_JimutetuzukiRireki dM_JimutetuzukiRireki =  new DM_JimutetuzukiRireki();
        dM_JimutetuzukiRireki.setKensuuHokanYmd(pKensuuHokanYmd);
        dM_JimutetuzukiRireki.setJimutetuzukicd(pJimutetuzukicd);
        dM_JimutetuzukiRireki.setSubSystemId(pSubSystemId);
        return this.selectOne(dM_JimutetuzukiRireki);
    }

    @Override
    @Deprecated
    public List<DM_JimutetuzukiRireki> selectAll() {
        return super.selectAll();
    }
}
