package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_UnitFundKbn;
import yuyu.def.db.entity.IT_HengakuUnit;

/**
 * 変額ユニットテーブル(IT_HengakuUnitDao) アクセス用の DAO クラスです。<br />
 */
public class IT_HengakuUnitDao extends AbstractDao<IT_HengakuUnit> {

    public IT_HengakuUnitDao() {
        super(IT_HengakuUnit.class);
    }

    @Deprecated
    public IT_HengakuUnit getHengakuUnit(String pSyono,
         C_UnitFundKbn pUnitfundkbn){
        IT_HengakuUnit iT_HengakuUnit =  new IT_HengakuUnit();
        iT_HengakuUnit.setSyono(pSyono);
        iT_HengakuUnit.setUnitfundkbn(pUnitfundkbn);
        return this.selectOne(iT_HengakuUnit);
    }

    @Override
    @Deprecated
    public List<IT_HengakuUnit> selectAll() {
        return super.selectAll();
    }
}
