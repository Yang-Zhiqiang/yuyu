package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.AT_FileRirekiKanri;

/**
 * ファイル履歴管理テーブル( AT_FileRirekiKanri ) に対するDB操作を提供する。
 */
public class AT_FileRirekiKanriDao extends AbstractDao<AT_FileRirekiKanri> {

    protected AT_FileRirekiKanriDao() {
        super(AT_FileRirekiKanri.class);
    }

    public AT_FileRirekiKanri getFileRirekiKanriByHistoryId(String pHistoryId){
        AT_FileRirekiKanri aT_FileRirekiKanri = new AT_FileRirekiKanri();
        aT_FileRirekiKanri.setHistoryId(pHistoryId);

        return selectOne(aT_FileRirekiKanri);
    }
}
