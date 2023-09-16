package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.entity.IT_Zennou;
import java.util.List;

/**
 * 前納テーブル(IT_ZennouDao) アクセス用の DAO クラスです。<br />
 */
public class IT_ZennouDao extends AbstractDao<IT_Zennou> {

    public IT_ZennouDao() {
        super(IT_Zennou.class);
    }

    @Deprecated
    public IT_Zennou getZennou(String pSyono, BizDate pZennoukaisiymd, Integer pRenno) {
        IT_Zennou iT_Zennou =  new IT_Zennou( pSyono,  pZennoukaisiymd,  pRenno);
        return this.selectOne(iT_Zennou);
    }

    @Override
    @Deprecated
    public List<IT_Zennou> selectAll() {
        return super.selectAll();
    }
}
