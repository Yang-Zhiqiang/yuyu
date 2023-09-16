package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.ST_SynypTukiTugtTykiyuHozon;

/**
 * 収入Ｐ統計当月処理中継用保存テーブル(ST_SynypTukiTugtTykiyuHozonDao) アクセス用の DAO クラスです。<br />
 */
public class ST_SynypTukiTugtTykiyuHozonDao extends AbstractDao<ST_SynypTukiTugtTykiyuHozon> {

    public ST_SynypTukiTugtTykiyuHozonDao() {
        super(ST_SynypTukiTugtTykiyuHozon.class);
    }

    public ST_SynypTukiTugtTykiyuHozon getSynypTukiTugtTykiyuHozon(String pZtysrkijyunym, String pZtysrkakutyoujobcd, Integer pZtysequenceno) {
        ST_SynypTukiTugtTykiyuHozon sT_SynypTukiTugtTykiyuHozon =  new ST_SynypTukiTugtTykiyuHozon();
        sT_SynypTukiTugtTykiyuHozon.setZtysrkijyunym(pZtysrkijyunym);
        sT_SynypTukiTugtTykiyuHozon.setZtysrkakutyoujobcd(pZtysrkakutyoujobcd);
        sT_SynypTukiTugtTykiyuHozon.setZtysequenceno(pZtysequenceno);
        return this.selectOne(sT_SynypTukiTugtTykiyuHozon);
    }
}
