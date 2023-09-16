package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.entity.IT_BAK_HokenSyoukenHukaInfo;
import java.util.List;

/**
 * 保険証券付加情報データバックアップテーブル(IT_BAK_HokenSyoukenHukaInfoDao) アクセス用の DAO クラスです。<br />
 */
public class IT_BAK_HokenSyoukenHukaInfoDao extends AbstractDao<IT_BAK_HokenSyoukenHukaInfo> {

    public IT_BAK_HokenSyoukenHukaInfoDao() {
        super(IT_BAK_HokenSyoukenHukaInfo.class);
    }

    @Deprecated
    public IT_BAK_HokenSyoukenHukaInfo getBAKHokenSyoukenHukaInfo(String pSyono, String pTrkssikibetukey, BizDate pTyouhyouymd) {
        IT_BAK_HokenSyoukenHukaInfo iT_BAK_HokenSyoukenHukaInfo =  new IT_BAK_HokenSyoukenHukaInfo( pSyono,  pTrkssikibetukey,  pTyouhyouymd);
        return this.selectOne(iT_BAK_HokenSyoukenHukaInfo);
    }

    @Override
    @Deprecated
    public List<IT_BAK_HokenSyoukenHukaInfo> selectAll() {
        return super.selectAll();
    }
}
