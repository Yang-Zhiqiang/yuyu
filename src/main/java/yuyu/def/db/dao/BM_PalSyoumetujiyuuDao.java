package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_BetukutiKeiyakuKbn;
import yuyu.def.db.entity.BM_PalSyoumetujiyuu;

/**
 * ＰＡＬ消滅事由マスタ(BM_PalSyoumetujiyuuDao) アクセス用の DAO クラスです。<br />
 */
public class BM_PalSyoumetujiyuuDao extends AbstractDao<BM_PalSyoumetujiyuu> {

    public BM_PalSyoumetujiyuuDao() {
        super(BM_PalSyoumetujiyuu.class);
    }

    public BM_PalSyoumetujiyuu getPalSyoumetujiyuu(String pPalsyoumetucd,
         C_BetukutiKeiyakuKbn pBetukutikeiyakukbn){
        BM_PalSyoumetujiyuu bM_PalSyoumetujiyuu =  new BM_PalSyoumetujiyuu();
        bM_PalSyoumetujiyuu.setPalsyoumetucd(pPalsyoumetucd);
        bM_PalSyoumetujiyuu.setBetukutikeiyakukbn(pBetukutikeiyakukbn);
        return this.selectOne(bM_PalSyoumetujiyuu);
    }
}
