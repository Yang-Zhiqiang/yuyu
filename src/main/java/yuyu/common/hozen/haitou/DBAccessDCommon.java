package yuyu.common.hozen.haitou;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateY;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.hozen.haitou.dba4dbaccessdcommon.DBAccessDCommonDao;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HaitoukinsksKbn;
import yuyu.def.classification.C_HaitoumeisaiKbn;
import yuyu.def.classification.C_TumitateDSakuseiKbn;
import yuyu.def.db.entity.IT_KhHaitouKanri;
import yuyu.def.db.entity.IT_KhTumitateDKanri;
import yuyu.def.hozen.manager.HozenDomManager;

/**
 * 契約保全 配当 配当共通ＤＢアクセスクラス
 */
public class DBAccessDCommon extends BaseDCommon {

    private IT_KhHaitouKanri khHaitouKanri;

    private IT_KhTumitateDKanri khTumitateDKanri;

    private List<IT_KhHaitouKanri> khHaitouKanriList;

    private List<IT_KhTumitateDKanri> khTumitateDKanriList;

    private Long khHaitouKanriCount;

    private Long khTumitateDKanriCount;

    @Inject
    private static Logger logger;

    @Inject
    private DBAccessDCommonDao dbAccessDCommonDao;

    @Inject
    private HozenDomManager hozenDomManager;

    {
        regErrorInfo("001", "入力値エラー", "入力項目にnullが含まれる");
        regErrorInfo("002", "入力値エラー", "積立Ｄ作成区分不正");
        regErrorInfo("003", "レコード追加時エラー", "計算元レコードと最新レコードが一致しない");
        regErrorInfo("004", "レコード削除時エラー", "削除対象のレコード件数が不正");
    }

    public DBAccessDCommon() {
        super();
    }

    public C_ErrorKbn getHaitouKanri(String pSyono, BizDateY pHaitounendo, Integer pRenno,
        C_HaitoukinsksKbn pHaitoukinsksKbn, C_HaitoumeisaiKbn pHaitoumeisaikbn) {

        logger.debug("▽ 配当共通ＤＢアクセス 配当管理情報取得（項目指定） 開始");

        clear();

        khHaitouKanri = null;

        final boolean collectEntityFlg = getCollectEntityFlg();

        try {
            if (BizUtil.isBlank(pSyono) || pHaitounendo == null || pRenno == null ||
                pHaitoukinsksKbn == null || pHaitoumeisaikbn == null) {

                setErrorInfo("001");

                logger.debug("△ 配当共通ＤＢアクセス 配当管理情報取得（項目指定） 終了");

                return C_ErrorKbn.ERROR;
            }

            khHaitouKanri = hozenDomManager.getKhHaitouKanri(
                pSyono, pHaitounendo, pRenno, pHaitoukinsksKbn, pHaitoumeisaikbn);

            setEntity(khHaitouKanri);

            logger.debug("△ 配当共通ＤＢアクセス 配当管理情報取得（項目指定） 終了");

            return C_ErrorKbn.OK;
        }
        finally {
            collectEntity(collectEntityFlg);
        }
    }

    public C_ErrorKbn getHaitouKanri(KhHaitouKanriKeyinfoBean pKhHaitouKanriKeyinfoBean) {

        logger.debug("▽ 配当共通ＤＢアクセス 配当管理情報取得（Bean指定） 開始");

        clear();

        khHaitouKanri = null;

        final boolean collectEntityFlg = getCollectEntityFlg();

        try {
            if (pKhHaitouKanriKeyinfoBean == null) {

                setErrorInfo("001");

                logger.debug("△ 配当共通ＤＢアクセス 配当管理情報取得（Bean指定） 終了");

                return C_ErrorKbn.ERROR;
            }

            C_ErrorKbn errorKbn = getHaitouKanri(pKhHaitouKanriKeyinfoBean.getSyono(),
                pKhHaitouKanriKeyinfoBean.getHaitounendo(),
                pKhHaitouKanriKeyinfoBean.getRenno(), pKhHaitouKanriKeyinfoBean.getHaitoukinsksKbn(),
                pKhHaitouKanriKeyinfoBean.getHaitoumeisaiKbn());

            logger.debug("△ 配当共通ＤＢアクセス 配当管理情報取得（Bean指定） 終了");

            return errorKbn;
        }
        finally {
            collectEntity(collectEntityFlg);
        }
    }

    public void insertHaitouKanri(IT_KhHaitouKanri pKhHaitouKanri) {

        logger.debug("▽ 配当共通ＤＢアクセス 配当管理情報作成 開始");

        clear();

        final boolean collectEntityFlg = getCollectEntityFlg();

        try {
            BizPropertyInitializer.initialize(pKhHaitouKanri);

            hozenDomManager.insert(pKhHaitouKanri);
        }

        finally {
            collectEntity(collectEntityFlg);
        }

        logger.debug("△ 配当共通ＤＢアクセス 配当管理情報作成 終了");
    }

    public void insertHaitouKanriWithRenno(IT_KhHaitouKanri pKhHaitouKanri) {

        logger.debug("▽ 配当共通ＤＢアクセス 配当管理情報作成（連番自動設定） 開始");

        clear();

        final boolean collectEntityFlg = getCollectEntityFlg();

        try {
            List<IT_KhHaitouKanri> haitouKanriList = dbAccessDCommonDao
                .getHaitouKanrisBySyonoHaitoumeisaikbn(pKhHaitouKanri.getSyono(), C_HaitoumeisaiKbn.SYU);

            setEntity(haitouKanriList);

            if (haitouKanriList.size() > 0) {

                IT_KhHaitouKanri haitouKanri = haitouKanriList.get(0);

                if (haitouKanri.getHaitounendo().compareTo(pKhHaitouKanri.getHaitounendo()) == 0) {

                    pKhHaitouKanri.setRenno(haitouKanri.getRenno() + 1);
                }
                else {

                    pKhHaitouKanri.setRenno(1);
                }
            }
            else {

                pKhHaitouKanri.setRenno(1);
            }

            insertHaitouKanri(pKhHaitouKanri);
        }
        finally {
            collectEntity(collectEntityFlg);
        }

        logger.debug("△ 配当共通ＤＢアクセス 配当管理情報作成（連番自動設定） 終了");
    }

    public C_ErrorKbn getTumitateDKanri(String pSyono, BizDate pTumitatedtumitateymd, Integer pRenno) {

        logger.debug("▽ 配当共通ＤＢアクセス 積立Ｄ管理情報取得（項目指定） 開始");

        clear();

        khTumitateDKanri = null;

        final boolean collectEntityFlg = getCollectEntityFlg();

        try {
            if (BizUtil.isBlank(pSyono) || pTumitatedtumitateymd == null || pRenno == null) {

                setErrorInfo("001");

                logger.debug("△ 配当共通ＤＢアクセス 積立Ｄ管理情報取得（項目指定） 終了");

                return C_ErrorKbn.ERROR;
            }

            khTumitateDKanri = hozenDomManager.getKhTumitateDKanri(pSyono, pTumitatedtumitateymd, pRenno);

            setEntity(khTumitateDKanri);

            logger.debug("△ 配当共通ＤＢアクセス 積立Ｄ管理情報取得（項目指定） 終了");

            return C_ErrorKbn.OK;
        }
        finally {
            collectEntity(collectEntityFlg);
        }
    }

    public C_ErrorKbn getTumitateDKanri(KhTumitateDKanriKeyinfoBean pKhTumitateDKanriKeyinfoBean) {

        logger.debug("▽ 配当共通ＤＢアクセス 積立Ｄ管理情報取得（Bean指定） 開始");

        clear();

        khTumitateDKanri = null;

        final boolean collectEntityFlg = getCollectEntityFlg();

        try {
            if (pKhTumitateDKanriKeyinfoBean == null) {

                setErrorInfo("001");

                logger.debug("△ 配当共通ＤＢアクセス 積立Ｄ管理情報取得（Bean指定） 終了");

                return C_ErrorKbn.ERROR;
            }

            C_ErrorKbn errorKbn = getTumitateDKanri(pKhTumitateDKanriKeyinfoBean.getSyono(),
                pKhTumitateDKanriKeyinfoBean.getTumitatedtumitateymd(),
                pKhTumitateDKanriKeyinfoBean.getRenno());

            logger.debug("△ 配当共通ＤＢアクセス 積立Ｄ管理情報取得（Bean指定） 終了");

            return errorKbn;
        }
        finally {
            collectEntity(collectEntityFlg);
        }
    }

    public void insertTumitateDKanri(IT_KhTumitateDKanri pKhTumitateDKanri) {

        logger.debug("▽ 配当共通ＤＢアクセス 積立Ｄ管理情報作成 開始");

        clear();

        final boolean collectEntityFlg = getCollectEntityFlg();

        try {
            BizPropertyInitializer.initialize(pKhTumitateDKanri);

            hozenDomManager.insert(pKhTumitateDKanri);

        }
        finally {
            collectEntity(collectEntityFlg);
        }

        logger.debug("△ 配当共通ＤＢアクセス 積立Ｄ管理情報作成 終了");
    }

    public void insertTumitateDKanriWithRenno(IT_KhTumitateDKanri pKhTumitateDKanri) {

        logger.debug("▽ 配当共通ＤＢアクセス 積立Ｄ管理情報作成（連番自動設定） 開始");

        clear();

        final boolean collectEntityFlg = getCollectEntityFlg();

        try {
            List<IT_KhTumitateDKanri> tumitateDKanriList = dbAccessDCommonDao
                .getTumitateDKanrisBySyono(pKhTumitateDKanri.getSyono());

            setEntity(tumitateDKanriList);

            if (tumitateDKanriList.size() > 0) {

                IT_KhTumitateDKanri tumitateDKanri = tumitateDKanriList.get(0);

                if (tumitateDKanri.getTumitatedtumitateymd().compareTo(pKhTumitateDKanri.getTumitatedtumitateymd()) == 0) {

                    pKhTumitateDKanri.setRenno(tumitateDKanri.getRenno() + 1);
                }
                else {

                    pKhTumitateDKanri.setRenno(1);
                }
            }
            else {

                pKhTumitateDKanri.setRenno(1);
            }

            insertTumitateDKanri(pKhTumitateDKanri);

        }
        finally {
            collectEntity(collectEntityFlg);
        }

        logger.debug("△ 配当共通ＤＢアクセス 積立Ｄ管理情報作成（連番自動設定） 終了");
    }

    public C_ErrorKbn getSaisinHaitouKanriSyu(String pSyono) {

        logger.debug("▽ 配当共通ＤＢアクセス 最新配当管理情報取得（主契約） 開始");

        clear();

        khHaitouKanri = null;

        final boolean collectEntityFlg = getCollectEntityFlg();

        try {
            if (BizUtil.isBlank(pSyono)) {

                setErrorInfo("001");

                logger.debug("△ 配当共通ＤＢアクセス 最新配当管理情報取得（主契約） 終了");

                return C_ErrorKbn.ERROR;
            }

            List<IT_KhHaitouKanri> haitouKanriList = dbAccessDCommonDao
                .getHaitouKanrisBySyonoHaitoumeisaikbn(pSyono, C_HaitoumeisaiKbn.SYU);

            setEntity(haitouKanriList);

            if (haitouKanriList.size() > 0) {

                khHaitouKanri = haitouKanriList.get(0);
            }

            logger.debug("△ 配当共通ＤＢアクセス 最新配当管理情報取得（主契約） 終了");

            return C_ErrorKbn.OK;

        }
        finally {
            collectEntity(collectEntityFlg);
        }
    }

    public C_ErrorKbn getKijyunymdTykzenHaitouKanriSyu(String pSyono, BizDate pKijyunymd) {

        logger.debug("▽ 配当共通ＤＢアクセス 基基準日直前配当管理情報取得（主契約） 開始");

        clear();

        khHaitouKanri = null;

        final boolean collectEntityFlg = getCollectEntityFlg();

        try {
            if (BizUtil.isBlank(pSyono) || pKijyunymd == null) {

                setErrorInfo("001");

                logger.debug("△ 配当共通ＤＢアクセス 基準日直前配当管理情報取得（主契約） 終了");

                return C_ErrorKbn.ERROR;
            }

            List<IT_KhHaitouKanri> haitouKanriList = dbAccessDCommonDao
                .getHaitouKanrisBySyonoHaitoumeisaikbnKijyunymd(pSyono, C_HaitoumeisaiKbn.SYU, pKijyunymd);

            setEntity(haitouKanriList);

            if (haitouKanriList.size() > 0) {

                khHaitouKanri = haitouKanriList.get(0);
            }

            logger.debug("△ 配当共通ＤＢアクセス 基準日直前配当管理情報取得（主契約） 終了");

            return C_ErrorKbn.OK;

        }
        finally {
            collectEntity(collectEntityFlg);
        }
    }

    public C_ErrorKbn getHaitouKanriListSyuHaitoukinskskbn(String pSyono, C_HaitoukinsksKbn[] pHaitoukinsksKbn) {

        logger.debug("▽ 配当共通ＤＢアクセス 配当管理情報リスト取得（主契約、配当金作成区分指定） 開始");

        clear();

        khHaitouKanriList = null;

        final boolean collectEntityFlg = getCollectEntityFlg();

        try {
            if (BizUtil.isBlank(pSyono) || pHaitoukinsksKbn == null) {

                setErrorInfo("001");

                logger.debug("△ 配当共通ＤＢアクセス 配当管理情報リスト取得（主契約、配当金作成区分指定） 終了");

                return C_ErrorKbn.ERROR;
            }

            List<IT_KhHaitouKanri> haitouKanriList = dbAccessDCommonDao
                .getHaitouKanrisBySyonoHaitoumeisaikbnHaitoukinskskbn(pSyono, C_HaitoumeisaiKbn.SYU, pHaitoukinsksKbn);

            setEntity(haitouKanriList);

            if (haitouKanriList.size() > 0) {

                khHaitouKanriList = haitouKanriList;
            }

            logger.debug("△ 配当共通ＤＢアクセス 配当管理情報リスト取得（主契約、配当金作成区分指定） 終了");

            return C_ErrorKbn.OK;
        }
        finally {
            collectEntity(collectEntityFlg);
        }
    }

    public C_ErrorKbn getSaisinSeisikiHaitouKanriSyu(String pSyono) {

        logger.debug("▽ 配当共通ＤＢアクセス 最新正式割当配当管理情報取得（主契約） 開始");

        clear();

        khHaitouKanri = null;

        final boolean collectEntityFlg = getCollectEntityFlg();

        try {
            if (BizUtil.isBlank(pSyono)) {

                setErrorInfo("001");

                logger.debug("△ 配当共通ＤＢアクセス 最新正式割当配当管理情報取得（主契約） 終了");

                return C_ErrorKbn.ERROR;
            }

            List<IT_KhHaitouKanri> haitouKanriList = dbAccessDCommonDao
                .getHaitouKanrisBySyonoHaitoumeisaikbnSeisiki(pSyono, C_HaitoumeisaiKbn.SYU);

            setEntity(haitouKanriList);

            if (haitouKanriList.size() > 0) {

                khHaitouKanri = haitouKanriList.get(0);
            }

            logger.debug("△ 配当共通ＤＢアクセス 最新正式割当配当管理情報取得（主契約） 終了");

            return C_ErrorKbn.OK;

        }
        finally {
            collectEntity(collectEntityFlg);
        }
    }

    public C_ErrorKbn getSaisinTumitateDKanri(String pSyono) {

        logger.debug("▽ 配当共通ＤＢアクセス 最新積立Ｄ管理情報取得 開始");

        clear();

        khTumitateDKanri = null;

        final boolean collectEntityFlg = getCollectEntityFlg();

        try {
            if (BizUtil.isBlank(pSyono)) {

                setErrorInfo("001");

                logger.debug("△ 配当共通ＤＢアクセス 最新積立Ｄ管理情報取得 終了");

                return C_ErrorKbn.ERROR;
            }

            List<IT_KhTumitateDKanri> tumitateDKanriList = dbAccessDCommonDao.getTumitateDKanrisBySyono(pSyono);

            setEntity(tumitateDKanriList);

            if (tumitateDKanriList.size() > 0) {

                khTumitateDKanri = tumitateDKanriList.get(0);
            }

            logger.debug("△ 配当共通ＤＢアクセス 最新積立Ｄ管理情報取得 終了");

            return C_ErrorKbn.OK;

        }
        finally {
            collectEntity(collectEntityFlg);
        }
    }

    public C_ErrorKbn getKijyunymdTykzenTumitateDKanri(String pSyono, BizDate pKijyunymd) {

        logger.debug("▽ 配当共通ＤＢアクセス 基準日直前積立Ｄ管理情報取得 開始");

        clear();

        khTumitateDKanri = null;

        final boolean collectEntityFlg = getCollectEntityFlg();

        try {
            if (BizUtil.isBlank(pSyono) || pKijyunymd == null) {

                setErrorInfo("001");

                logger.debug("△ 配当共通ＤＢアクセス 基準日直前積立Ｄ管理情報取得 終了");

                return C_ErrorKbn.ERROR;
            }

            List<IT_KhTumitateDKanri> tumitateDKanriList = dbAccessDCommonDao
                .getTumitateDKanrisBySyonoKijyunymd(pSyono, pKijyunymd);

            setEntity(tumitateDKanriList);

            if (tumitateDKanriList.size() > 0) {

                khTumitateDKanri = tumitateDKanriList.get(0);
            }

            logger.debug("△ 配当共通ＤＢアクセス 基準日直前積立Ｄ管理情報取得 終了");

            return C_ErrorKbn.OK;

        }
        finally {
            collectEntity(collectEntityFlg);
        }
    }

    public C_ErrorKbn getTumitateDKanriListTumitatedskskbn(
        String pSyono, C_TumitateDSakuseiKbn[] pTumitateDSakuseiKbn) {

        logger.debug("▽ 配当共通ＤＢアクセス 積立Ｄ管理情報リスト取得（積立Ｄ作成区分指定） 開始");

        clear();

        khTumitateDKanriList = null;

        final boolean collectEntityFlg = getCollectEntityFlg();

        try {
            if (BizUtil.isBlank(pSyono) || pTumitateDSakuseiKbn == null) {

                setErrorInfo("001");

                logger.debug("△ 配当共通ＤＢアクセス 積立Ｄ管理情報リスト取得（積立Ｄ作成区分指定） 終了");

                return C_ErrorKbn.ERROR;
            }

            List<IT_KhTumitateDKanri> khTumitateDKanriLst = dbAccessDCommonDao
                .getTumitateDKanrisBysyonoTumitatedskskbn(pSyono, pTumitateDSakuseiKbn);

            setEntity(khTumitateDKanriLst);

            khTumitateDKanriList = khTumitateDKanriLst;

            logger.debug("△ 配当共通ＤＢアクセス 積立Ｄ管理情報リスト取得（積立Ｄ作成区分指定） 終了");

            return C_ErrorKbn.OK;
        }
        finally {
            collectEntity(collectEntityFlg);
        }
    }

    public C_ErrorKbn getCountKijyunymdGoHaitouKnari(String pSyono, BizDate pKijyunymd) {

        logger.debug("▽ 配当共通ＤＢアクセス 基準日後配当管理情報件数取得（主契約） 開始");

        clear();

        khHaitouKanriCount = null;

        final boolean collectEntityFlg = getCollectEntityFlg();

        try {
            if (BizUtil.isBlank(pSyono) || pKijyunymd == null) {

                setErrorInfo("001");

                logger.debug("△ 配当共通ＤＢアクセス 基準日後配当管理情報件数取得（主契約） 終了");

                return C_ErrorKbn.ERROR;
            }

            khHaitouKanriCount = dbAccessDCommonDao
                .getHaitouKanriCountBySyonoHaitoumeisaiKbnAfterKijyunYmd(pSyono, C_HaitoumeisaiKbn.SYU, pKijyunymd);

            logger.debug("△ 配当共通ＤＢアクセス 基準日後配当管理情報件数取得（主契約） 終了");

            return C_ErrorKbn.OK;
        }
        finally {
            collectEntity(collectEntityFlg);
        }
    }

    public C_ErrorKbn getCountKijyunymdGoTumitateDKanriTumitatedskskbn(
        String pSyono, C_TumitateDSakuseiKbn[] pTumitateDSakuseiKbn, BizDate pKijyunymd) {

        logger.debug("▽ 配当共通ＤＢアクセス 基準日後積立Ｄ管理情報件数取得（積立Ｄ作成区分指定） 開始");

        clear();

        khTumitateDKanriCount = null;

        final boolean collectEntityFlg = getCollectEntityFlg();

        try {
            if (BizUtil.isBlank(pSyono) || pTumitateDSakuseiKbn == null || pKijyunymd == null) {

                setErrorInfo("001");

                logger.debug("△ 配当共通ＤＢアクセス 基準日後積立Ｄ管理情報件数取得（積立Ｄ作成区分指定） 終了");

                return C_ErrorKbn.ERROR;
            }

            khTumitateDKanriCount = dbAccessDCommonDao
                .getTumitateDKanriCountBySyonoTumitatedsksKbnAfterKijyunYmd(pSyono, pTumitateDSakuseiKbn, pKijyunymd);

            logger.debug("△ 配当共通ＤＢアクセス 基準日後積立Ｄ管理情報件数取得（積立Ｄ作成区分指定） 終了");

            return C_ErrorKbn.OK;

        }
        finally {
            collectEntity(collectEntityFlg);
        }
    }

    public C_ErrorKbn getCountKijyunymdGoTumitatedtumitateYmdTumitateDKanriByTumitatedskskbn(
        String pSyono, C_TumitateDSakuseiKbn[] pTumitateDSakuseiKbn, BizDate pKijyunymd) {

        logger.debug("▽ 配当共通ＤＢアクセス 基準日後積立Ｄ管理情報件数取得（積立Ｄ作成区分指定_積立Ｄ積立年月日比較） 開始");

        clear();

        khTumitateDKanriCount = null;

        final boolean collectEntityFlg = getCollectEntityFlg();

        try {
            if (BizUtil.isBlank(pSyono) || pTumitateDSakuseiKbn == null || pKijyunymd == null) {

                setErrorInfo("001");

                logger.debug("△ 配当共通ＤＢアクセス 基準日後積立Ｄ管理情報件数取得（積立Ｄ作成区分指定_積立Ｄ積立年月日比較） 終了");

                return C_ErrorKbn.ERROR;
            }

            khTumitateDKanriCount = dbAccessDCommonDao
                .getTumitatedtumitateYmdAfterKijyunYmdTumitateDKanriCountBySyonoTumitatedsksKbn(pSyono,
                    pTumitateDSakuseiKbn, pKijyunymd);

            logger.debug("△ 配当共通ＤＢアクセス 基準日後積立Ｄ管理情報件数取得（積立Ｄ作成区分指定_積立Ｄ積立年月日比較） 終了");

            return C_ErrorKbn.OK;

        }
        finally {
            collectEntity(collectEntityFlg);
        }
    }

    public void deleteHaitouKanri(List<IT_KhHaitouKanri> pKhHaitouKanriList) {

        logger.debug("▽ 配当共通ＤＢアクセス 配当管理情報削除 開始");

        final boolean collectEntityFlg = getCollectEntityFlg();

        try {
            hozenDomManager.delete(pKhHaitouKanriList);
        }
        finally {
            collectEntity(collectEntityFlg);
        }

        logger.debug("△ 配当共通ＤＢアクセス 配当管理情報削除 終了");
    }

    public void deleteTumitateDKanri(List<IT_KhTumitateDKanri> pKhTumitateDKanriList) {

        logger.debug("▽ 配当共通ＤＢアクセス 積立Ｄ管理情報削除 開始");

        final boolean collectEntityFlg = getCollectEntityFlg();

        try {
            hozenDomManager.delete(pKhTumitateDKanriList);
        }
        finally {
            collectEntity(collectEntityFlg);
        }

        logger.debug("△ 配当共通ＤＢアクセス 積立Ｄ管理情報削除 終了");
    }

    public IT_KhHaitouKanri getKhHaitouKanri() {

        return khHaitouKanri;
    }

    public void setKhHaitouKanri(IT_KhHaitouKanri pKhHaitouKanri) {

        khHaitouKanri = pKhHaitouKanri;
    }

    public IT_KhTumitateDKanri getKhTumitateDKanri() {

        return khTumitateDKanri;
    }

    public List<IT_KhHaitouKanri> getKhHaitouKanriList() {

        return khHaitouKanriList;
    }

    public List<IT_KhTumitateDKanri> getKhTumitateDKanriList() {

        return khTumitateDKanriList;
    }

    public Long getKhHaitouKanriCount() {

        return khHaitouKanriCount;
    }

    public Long getKhTumitateDKanriCount() {

        return khTumitateDKanriCount;
    }
}