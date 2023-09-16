package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.AT_FileRireki;

/**
 * ファイル履歴テーブル( AT_FileRireki ) に対するDB操作を提供する。
 */
public class AT_FileRirekiDao extends AbstractDao<AT_FileRireki> {

    protected AT_FileRirekiDao() {
        super(AT_FileRireki.class);
    }

    public AT_FileRireki getFileRirekiByUniqueIdHistoryIdTourokuTimeFileNm(String pUniqueId, String pHistoryId,
        String pTourokuTime, int pFileNmSuffix){

        AT_FileRireki fileRireki = new AT_FileRireki();
        fileRireki.setUniqueId(pUniqueId);
        fileRireki.setHistoryId(pHistoryId);
        fileRireki.setTourokuTime(pTourokuTime);
        fileRireki.setFileNmSuffix(pFileNmSuffix);

        return selectOne(fileRireki);

    }

}
