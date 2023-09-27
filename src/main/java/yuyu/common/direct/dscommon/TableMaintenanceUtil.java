package yuyu.common.direct.dscommon;

import javax.inject.Inject;

import org.slf4j.Logger;

import yuyu.def.db.entity.MT_BAK_DsKokyakuKanri;
import yuyu.def.db.entity.MT_DsKokyakuKanri;
import yuyu.def.direct.manager.DirectDomManager;

/**
 * ダイレクト ダイレクト共通 テーブルメンテナンスユーティリティ
 */
public class TableMaintenanceUtil {

    @Inject
    private static Logger logger;

    @Inject
    private DirectDomManager directDomManager;

    public TableMaintenanceUtil() {
        super();
    }

    public MT_BAK_DsKokyakuKanri exec(String pDsKokyakuNo, String pHenkouSkbtkey) {

        logger.debug("▽ テーブルメンテナンスユーティリティ 開始");

        MT_DsKokyakuKanri dsKokyakuKanri = directDomManager.getDsKokyakuKanri(pDsKokyakuNo);

        MT_BAK_DsKokyakuKanri bakDsKokyakuKanri = null;

        if (dsKokyakuKanri != null) {

            bakDsKokyakuKanri = (MT_BAK_DsKokyakuKanri)dsKokyakuKanri.createBackup(pHenkouSkbtkey);
        }

        logger.debug("△ テーブルメンテナンスユーティリティ 終了");

        return bakDsKokyakuKanri;
    }
}
