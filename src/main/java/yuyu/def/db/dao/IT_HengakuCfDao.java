package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_UnitFundKbn;
import yuyu.def.db.entity.IT_HengakuCf;
/**
 * 変額ＣＦテーブル(IT_HengakuCfDao) アクセス用の DAO クラスです。<br />
 */
public class IT_HengakuCfDao extends AbstractDao<IT_HengakuCf> {

    public IT_HengakuCfDao() {
        super(IT_HengakuCf.class);
    }

    @Deprecated
    public IT_HengakuCf getHengakuCf(String pSyono,
         String pHenkousikibetukey,
         C_UnitFundKbn pUnitfundkbn,
         BizDate pSyoriYmd,
         Integer pRenno){
        IT_HengakuCf iT_HengakuCf =  new IT_HengakuCf();
        iT_HengakuCf.setSyono(pSyono);
        iT_HengakuCf.setHenkousikibetukey(pHenkousikibetukey);
        iT_HengakuCf.setUnitfundkbn(pUnitfundkbn);
        iT_HengakuCf.setSyoriYmd(pSyoriYmd);
        iT_HengakuCf.setRenno(pRenno);
        return this.selectOne(iT_HengakuCf);
    }

    @Override
    @Deprecated
    public List<IT_HengakuCf> selectAll() {
        return super.selectAll();
    }
}
