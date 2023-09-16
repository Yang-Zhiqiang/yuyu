package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.AT_BatchLogFile;

/**
 * バッチログファイルテーブル( AT_BatchLogFile ) に対するDB操作を提供する。
 */
public class AT_BatchLogFileDao extends AbstractDao<AT_BatchLogFile> {

    protected AT_BatchLogFileDao() {
        super(AT_BatchLogFile.class);
    }

}
