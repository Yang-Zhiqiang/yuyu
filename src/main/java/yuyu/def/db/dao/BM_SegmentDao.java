package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_Segcd;
import yuyu.def.db.entity.BM_Segment;

/**
 * セグメントマスタ(BM_SegmentDao) アクセス用の DAO クラスです。<br />
 */
public class BM_SegmentDao extends AbstractDao<BM_Segment> {

    public BM_SegmentDao() {
        super(BM_Segment.class);
    }

    public BM_Segment getSegment(C_Segcd pSegcd){
        BM_Segment bM_Segment =  new BM_Segment();
        bM_Segment.setSegcd(pSegcd);
        return this.selectOne(bM_Segment);
    }
}
