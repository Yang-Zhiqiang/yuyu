package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.entity.IT_BAK_Suiihyou;
/**
 * 推移表バックアップテーブル(IT_BAK_SuiihyouDao) アクセス用の DAO クラスです。<br />
 */
public class IT_BAK_SuiihyouDao extends AbstractDao<IT_BAK_Suiihyou> {

    public IT_BAK_SuiihyouDao() {
        super(IT_BAK_Suiihyou.class);
    }

    @Deprecated
    public IT_BAK_Suiihyou getBAKSuiihyou(String pSyono,
         String pTrkssikibetukey,
         BizDate pTyouhyouymd,
         Integer pKeikanensuu){
        IT_BAK_Suiihyou iT_BAK_Suiihyou =  new IT_BAK_Suiihyou();
        iT_BAK_Suiihyou.setSyono(pSyono);
        iT_BAK_Suiihyou.setTrkssikibetukey(pTrkssikibetukey);
        iT_BAK_Suiihyou.setTyouhyouymd(pTyouhyouymd);
        iT_BAK_Suiihyou.setKeikanensuu(pKeikanensuu);
        return this.selectOne(iT_BAK_Suiihyou);
    }

    @Override
    @Deprecated
    public List<IT_BAK_Suiihyou> selectAll() {
        return super.selectAll();
    }
}
