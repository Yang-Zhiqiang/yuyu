package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_SegbunruiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_SyouhnbetuSegment;

/**
 * 商品別セグメントマスタ(BM_SyouhnbetuSegmentDao) アクセス用の DAO クラスです。<br />
 */
public class BM_SyouhnbetuSegmentDao extends AbstractDao<BM_SyouhnbetuSegment> {

    public BM_SyouhnbetuSegmentDao() {
        super(BM_SyouhnbetuSegment.class);
    }

    public BM_SyouhnbetuSegment getSyouhnbetuSegment(String pSyouhncd, C_Tuukasyu pKyktuukasyu, C_SegbunruiKbn pSegbunrui1, C_SegbunruiKbn pSegbunrui2) {
        BM_SyouhnbetuSegment bM_SyouhnbetuSegment =  new BM_SyouhnbetuSegment();
        bM_SyouhnbetuSegment.setSyouhncd(pSyouhncd);
        bM_SyouhnbetuSegment.setKyktuukasyu(pKyktuukasyu);
        bM_SyouhnbetuSegment.setSegbunrui1(pSegbunrui1);
        bM_SyouhnbetuSegment.setSegbunrui2(pSegbunrui2);
        return this.selectOne(bM_SyouhnbetuSegment);
    }
}
