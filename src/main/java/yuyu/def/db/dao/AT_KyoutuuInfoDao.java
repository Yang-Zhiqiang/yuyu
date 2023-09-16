package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.AT_KyoutuuInfo;

/**
 * 共通情報テーブル( AT_KyoutuuInfo ) に対するDB操作を提供する。
 */
public class AT_KyoutuuInfoDao extends AbstractDao<AT_KyoutuuInfo> {

    protected AT_KyoutuuInfoDao() {
        super(AT_KyoutuuInfo.class);
    }

    public AT_KyoutuuInfo getKyoutuuInfoByKinouIdByInfoSeqNo(String pKinouId, String pInfoSeqNo){
        AT_KyoutuuInfo aT_KyoutuuInfo = new AT_KyoutuuInfo();
        aT_KyoutuuInfo.setKinouId(pKinouId);
        aT_KyoutuuInfo.setInfoSeqNo(pInfoSeqNo);

        return selectOne(aT_KyoutuuInfo);
    }

}
