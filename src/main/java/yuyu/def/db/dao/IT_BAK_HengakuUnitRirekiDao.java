package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_UnitFundKbn;
import yuyu.def.db.entity.IT_BAK_HengakuUnitRireki;

/**
 * 変額ユニット履歴バックアップテーブル(IT_BAK_HengakuUnitRirekiDao) アクセス用の DAO クラスです。<br />
 */
public class IT_BAK_HengakuUnitRirekiDao extends AbstractDao<IT_BAK_HengakuUnitRireki> {

    public IT_BAK_HengakuUnitRirekiDao() {
        super(IT_BAK_HengakuUnitRireki.class);
    }

    @Deprecated
    public IT_BAK_HengakuUnitRireki getBAKHengakuUnitRireki(String pSyono,
         String pTrkssikibetukey,
         C_UnitFundKbn pUnitfundkbn,
         String pHenkousikibetukey){
        IT_BAK_HengakuUnitRireki iT_BAK_HengakuUnitRireki =  new IT_BAK_HengakuUnitRireki();
        iT_BAK_HengakuUnitRireki.setSyono(pSyono);
        iT_BAK_HengakuUnitRireki.setTrkssikibetukey(pTrkssikibetukey);
        iT_BAK_HengakuUnitRireki.setUnitfundkbn(pUnitfundkbn);
        iT_BAK_HengakuUnitRireki.setHenkousikibetukey(pHenkousikibetukey);
        return this.selectOne(iT_BAK_HengakuUnitRireki);
    }

    @Override
    @Deprecated
    public List<IT_BAK_HengakuUnitRireki> selectAll() {
        return super.selectAll();
    }
}
