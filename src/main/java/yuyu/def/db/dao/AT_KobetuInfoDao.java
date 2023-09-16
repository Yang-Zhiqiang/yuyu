package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.AT_KobetuInfo;

/**
 * 共通情報テーブル( AT_KobetuInfo ) に対するDB操作を提供する。
 */
public class AT_KobetuInfoDao extends AbstractDao<AT_KobetuInfo> {

    protected AT_KobetuInfoDao() {
        super(AT_KobetuInfo.class);
    }

    public AT_KobetuInfo getKobetuInfoByUserId(String pUserId, String pInfoSeqNo){

        AT_KobetuInfo kobetuInfo = new AT_KobetuInfo();
        kobetuInfo.setUserId(pUserId);
        kobetuInfo.setInfoSeqNo(pInfoSeqNo);

        return selectOne(kobetuInfo);
    }

}
