package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_AzukariRiritu;

/**
 * 預り利率マスタ(BM_AzukariRirituDao) アクセス用の DAO クラスです。<br />
 */
public class BM_AzukariRirituDao extends AbstractDao<BM_AzukariRiritu> {

    public BM_AzukariRirituDao() {
        super(BM_AzukariRiritu.class);
    }

    public BM_AzukariRiritu getAzukariRiritu(C_Tuukasyu pTuukasyu, BizDate pTkyfromymd, BizDate pTkytoymd) {
        BM_AzukariRiritu bM_AzukariRiritu =  new BM_AzukariRiritu();
        bM_AzukariRiritu.setTuukasyu(pTuukasyu);
        bM_AzukariRiritu.setTkyfromymd(pTkyfromymd);
        bM_AzukariRiritu.setTkytoymd(pTkytoymd);
        return this.selectOne(bM_AzukariRiritu);
    }

}
