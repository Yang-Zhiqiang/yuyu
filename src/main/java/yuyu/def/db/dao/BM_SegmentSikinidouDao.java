package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_Segcd;
import yuyu.def.db.entity.BM_SegmentSikinidou;

/**
 * セグメントコード別資金移動処理マスタ(BM_SegmentSikinidouDao) アクセス用の DAO クラスです。<br />
 */
public class BM_SegmentSikinidouDao extends AbstractDao<BM_SegmentSikinidou> {

    public BM_SegmentSikinidouDao() {
        super(BM_SegmentSikinidou.class);
    }

    public BM_SegmentSikinidou getSegmentSikinidou(C_Segcd pSegcd) {
        BM_SegmentSikinidou bM_SegmentSikinidou =  new BM_SegmentSikinidou();
        bM_SegmentSikinidou.setSegcd(pSegcd);
        return this.selectOne(bM_SegmentSikinidou);
    }
}
