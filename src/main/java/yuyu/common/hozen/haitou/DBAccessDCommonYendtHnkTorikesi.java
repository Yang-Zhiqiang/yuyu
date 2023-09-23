package yuyu.common.hozen.haitou;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HaitoukinsksKbn;
import yuyu.def.classification.C_TumitateDSakuseiKbn;
import yuyu.def.db.entity.IT_KhHaitouKanri;
import yuyu.def.db.entity.IT_KhTumitateDKanri;

/**
 * 契約保全 配当 配当共通ＤＢアクセス（円建変更取消）クラス
 */
public class DBAccessDCommonYendtHnkTorikesi extends DBAccessDCommon {

    @Inject
    private static Logger logger;

    public C_ErrorKbn deleteHaitouInfo(String pSyono) {

        logger.debug("▽ 配当共通ＤＢアクセス（円建変更取消） 開始");

        clear();

        C_HaitoukinsksKbn[] haitoukinsksKbn = { C_HaitoukinsksKbn.YENDTHNKKARIWARIATE,
            C_HaitoukinsksKbn.YENDTHNKSEISIKI };
        C_TumitateDSakuseiKbn[] tumitateDSakuseiKbn = { C_TumitateDSakuseiKbn.YENDTHNKSEISIKI };

        if (BizUtil.isBlank(pSyono)) {

            setErrorInfo("001");

            logger.debug("△ 配当共通ＤＢアクセス（円建変更取消） 終了");

            return C_ErrorKbn.ERROR;
        }

        getHaitouKanriListSyuHaitoukinskskbn(pSyono, haitoukinsksKbn);
        List<IT_KhHaitouKanri> deleteHaitouKanriList = getKhHaitouKanriList();

        getTumitateDKanriListTumitatedskskbn(pSyono, tumitateDSakuseiKbn);
        List<IT_KhTumitateDKanri> deleteTumitateDKanriLIst = getKhTumitateDKanriList();

        if (deleteHaitouKanriList.size() != 2 && deleteHaitouKanriList.size() != 4) {

            setErrorInfo("004");

            logger.debug("△ 配当共通ＤＢアクセス（円建変更取消） 終了");

            return C_ErrorKbn.ERROR;
        }

        if (deleteTumitateDKanriLIst.size() != 1 && deleteTumitateDKanriLIst.size() != 2) {

            setErrorInfo("004");

            logger.debug("△ 配当共通ＤＢアクセス（円建変更取消） 終了");

            return C_ErrorKbn.ERROR;
        }

        deleteHaitouKanri(deleteHaitouKanriList);

        deleteTumitateDKanri(deleteTumitateDKanriLIst);

        logger.debug("△ 配当共通ＤＢアクセス（円建変更取消） 終了");

        return C_ErrorKbn.OK;
    }
}