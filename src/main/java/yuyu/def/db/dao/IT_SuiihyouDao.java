package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.entity.IT_Suiihyou;
/**
 * 推移表テーブル(IT_SuiihyouDao) アクセス用の DAO クラスです。<br />
 */
public class IT_SuiihyouDao extends AbstractDao<IT_Suiihyou> {

    public IT_SuiihyouDao() {
        super(IT_Suiihyou.class);
    }

    @Deprecated
    public IT_Suiihyou getSuiihyou(String pSyono,
         BizDate pTyouhyouymd,
         Integer pKeikanensuu){
        IT_Suiihyou iT_Suiihyou =  new IT_Suiihyou();
        iT_Suiihyou.setSyono(pSyono);
        iT_Suiihyou.setTyouhyouymd(pTyouhyouymd);
        iT_Suiihyou.setKeikanensuu(pKeikanensuu);
        return this.selectOne(iT_Suiihyou);
    }

    @Override
    @Deprecated
    public List<IT_Suiihyou> selectAll() {
        return super.selectAll();
    }
}
