package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.entity.DT_SyoriKensuuHokanTask;
import java.util.List;

/**
 * 処理件数保管（タスク別）テーブル(DT_SyoriKensuuHokanTaskDao) アクセス用の DAO クラスです。<br />
 */
public class DT_SyoriKensuuHokanTaskDao extends AbstractDao<DT_SyoriKensuuHokanTask> {

    public DT_SyoriKensuuHokanTaskDao() {
        super(DT_SyoriKensuuHokanTask.class);
    }

    @Deprecated
    public DT_SyoriKensuuHokanTask getSyoriKensuuHokanTask(BizDate pKensuuHokanYmd, String pJimutetuzukicd, String pTskid, String pAccountId) {
        DT_SyoriKensuuHokanTask dT_SyoriKensuuHokanTask =  new DT_SyoriKensuuHokanTask();
        dT_SyoriKensuuHokanTask.setKensuuHokanYmd(pKensuuHokanYmd);
        dT_SyoriKensuuHokanTask.setJimutetuzukicd(pJimutetuzukicd);
        dT_SyoriKensuuHokanTask.setTskid(pTskid);
        dT_SyoriKensuuHokanTask.setAccountId(pAccountId);
        return this.selectOne(dT_SyoriKensuuHokanTask);
    }

    @Override
    @Deprecated
    public List<DT_SyoriKensuuHokanTask> selectAll() {
        return super.selectAll();
    }
}
