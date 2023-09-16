package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_UnitFundKbn;
import yuyu.def.db.entity.IT_BAK_HengakuUnit;

/**
 * 変額ユニットバックアップテーブル(IT_BAK_HengakuUnitDao) アクセス用の DAO クラスです。<br />
 */
public class IT_BAK_HengakuUnitDao extends AbstractDao<IT_BAK_HengakuUnit> {

    public IT_BAK_HengakuUnitDao() {
        super(IT_BAK_HengakuUnit.class);
    }

    @Deprecated
    public IT_BAK_HengakuUnit getBAKHengakuUnit(String pSyono,
         String pTrkssikibetukey,
         C_UnitFundKbn pUnitfundkbn){
        IT_BAK_HengakuUnit iT_BAK_HengakuUnit =  new IT_BAK_HengakuUnit();
        iT_BAK_HengakuUnit.setSyono(pSyono);
        iT_BAK_HengakuUnit.setTrkssikibetukey(pTrkssikibetukey);
        iT_BAK_HengakuUnit.setUnitfundkbn(pUnitfundkbn);
        return this.selectOne(iT_BAK_HengakuUnit);
    }

    @Override
    @Deprecated
    public List<IT_BAK_HengakuUnit> selectAll() {
        return super.selectAll();
    }
}
