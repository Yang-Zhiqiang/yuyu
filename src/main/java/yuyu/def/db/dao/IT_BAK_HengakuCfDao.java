package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_UnitFundKbn;
import yuyu.def.db.entity.IT_BAK_HengakuCf;
/**
 * 変額ＣＦバックアップテーブル(IT_BAK_HengakuCfDao) アクセス用の DAO クラスです。<br />
 */
public class IT_BAK_HengakuCfDao extends AbstractDao<IT_BAK_HengakuCf> {

    public IT_BAK_HengakuCfDao() {
        super(IT_BAK_HengakuCf.class);
    }

    @Deprecated
    public IT_BAK_HengakuCf getBAKHengakuCf(String pSyono,
         String pTrkssikibetukey,
         String pHenkousikibetukey,
         C_UnitFundKbn pUnitfundkbn,
         BizDate pSyoriYmd,
         Integer pRenno){
        IT_BAK_HengakuCf iT_BAK_HengakuCf =  new IT_BAK_HengakuCf();
        iT_BAK_HengakuCf.setSyono(pSyono);
        iT_BAK_HengakuCf.setTrkssikibetukey(pTrkssikibetukey);
        iT_BAK_HengakuCf.setHenkousikibetukey(pHenkousikibetukey);
        iT_BAK_HengakuCf.setUnitfundkbn(pUnitfundkbn);
        iT_BAK_HengakuCf.setSyoriYmd(pSyoriYmd);
        iT_BAK_HengakuCf.setRenno(pRenno);
        return this.selectOne(iT_BAK_HengakuCf);
    }

    @Override
    @Deprecated
    public List<IT_BAK_HengakuCf> selectAll() {
        return super.selectAll();
    }
}
