package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.entity.AS_FileServerInfo;

/**
 * ファイルサーバ情報TBL ( AS_FileServerInfo ) に対するDB操作を提供する。
 */
public class AS_FileServerInfoDao extends AbstractDao<AS_FileServerInfo> {

    public AS_FileServerInfoDao() {
        super(AS_FileServerInfo.class);
    }

    public AS_FileServerInfo getAS_FileServerInfo(Integer pSetteiNo, BizDate pTekiyoYmdFrom) {
        AS_FileServerInfo condEntity = new AS_FileServerInfo();
        condEntity.setSetteiNo(pSetteiNo);
        condEntity.setTekiyouYmdFrom(pTekiyoYmdFrom);
        return selectOne(condEntity);
    }

}