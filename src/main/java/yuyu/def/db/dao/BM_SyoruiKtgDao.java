package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.BM_SyoruiKtg;

/**
 * 書類結合マスタ(BM_SyoruiKtgDao) アクセス用の DAO クラスです。<br />
 */
public class BM_SyoruiKtgDao extends AbstractDao<BM_SyoruiKtg> {

    public BM_SyoruiKtgDao() {
        super(BM_SyoruiKtg.class);
    }

    public BM_SyoruiKtg getSyoruiKtg(C_SyoruiCdKbn pSyoruiCd,
         String pKtgsyoruicd){
        BM_SyoruiKtg bM_SyoruiKtg =  new BM_SyoruiKtg();
        bM_SyoruiKtg.setSyoruiCd(pSyoruiCd);
        bM_SyoruiKtg.setKtgsyoruicd(pKtgsyoruicd);
        return this.selectOne(bM_SyoruiKtg);
    }
}
