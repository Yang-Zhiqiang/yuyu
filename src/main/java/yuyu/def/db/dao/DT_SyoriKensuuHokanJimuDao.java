package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.entity.DT_SyoriKensuuHokanJimu;
import java.util.List;

/**
 * 処理件数保管（事務手続別）テーブル(DT_SyoriKensuuHokanJimuDao) アクセス用の DAO クラスです。<br />
 */
public class DT_SyoriKensuuHokanJimuDao extends AbstractDao<DT_SyoriKensuuHokanJimu> {

    public DT_SyoriKensuuHokanJimuDao() {
        super(DT_SyoriKensuuHokanJimu.class);
    }

    @Deprecated
    public DT_SyoriKensuuHokanJimu getSyoriKensuuHokanJimu(BizDate pKensuuHokanYmd, String pJimutetuzukicd, String pAccountId) {
        DT_SyoriKensuuHokanJimu dT_SyoriKensuuHokanJimu =  new DT_SyoriKensuuHokanJimu();
        dT_SyoriKensuuHokanJimu.setKensuuHokanYmd(pKensuuHokanYmd);
        dT_SyoriKensuuHokanJimu.setJimutetuzukicd(pJimutetuzukicd);
        dT_SyoriKensuuHokanJimu.setAccountId(pAccountId);
        return this.selectOne(dT_SyoriKensuuHokanJimu);
    }

    @Override
    @Deprecated
    public List<DT_SyoriKensuuHokanJimu> selectAll() {
        return super.selectAll();
    }
}
