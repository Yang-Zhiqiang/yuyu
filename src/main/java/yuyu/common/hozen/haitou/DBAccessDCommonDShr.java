package yuyu.common.hozen.haitou;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_TumitateDSakuseiKbn;
import yuyu.def.db.entity.IT_KhTumitateDKanri;

/**
 * 契約保全 配当 配当共通ＤＢアクセス（配当金支払）クラス
 */
public class DBAccessDCommonDShr extends DBAccessDCommon {

    @Inject
    private static Logger logger;

    public C_ErrorKbn insertHaitouInfo(
        BizDate pCalckijyunymd,
        BizCurrency pTumitatedWarimodosiGo,
        KhTumitateDKanriKeyinfoBean pKhTumitateDKanriKeyinfoBean,
        C_TumitateDSakuseiKbn pTumitateDSakuseiKbn,
        KhozenCommonParam pKhozenCommonParam) {

        logger.debug("▽ 配当共通ＤＢアクセス（配当金支払） 開始");

        clear();

        if (pCalckijyunymd == null || pTumitatedWarimodosiGo == null || pTumitatedWarimodosiGo.isOptional() ||
            pKhTumitateDKanriKeyinfoBean == null || pTumitateDSakuseiKbn == null || pKhozenCommonParam == null) {

            setErrorInfo("001");

            logger.debug("△ 配当共通ＤＢアクセス（配当金支払） 終了");

            return C_ErrorKbn.ERROR;
        }

        if (!C_TumitateDSakuseiKbn.ZENHIKIDASI.eq(pTumitateDSakuseiKbn) &&
            !C_TumitateDSakuseiKbn.ITIBUHIKIDASI.eq(pTumitateDSakuseiKbn)) {

            setErrorInfo("002");

            logger.debug("△ 配当共通ＤＢアクセス（配当金支払） 終了");

            return C_ErrorKbn.ERROR;

        }

        if (C_ErrorKbn.ERROR.eq(getTumitateDKanri(pKhTumitateDKanriKeyinfoBean))) {

            logger.debug("△ 配当共通ＤＢアクセス（配当金支払） 終了");

            return C_ErrorKbn.ERROR;
        }

        IT_KhTumitateDKanri tumitateDKanriOld = getKhTumitateDKanri();

        if (C_ErrorKbn.ERROR.eq(getSaisinTumitateDKanri(pKhTumitateDKanriKeyinfoBean.getSyono()))) {

            logger.debug("△ 配当共通ＤＢアクセス（配当金支払） 終了");

            return C_ErrorKbn.ERROR;
        }

        IT_KhTumitateDKanri tumitateDKanriNew = getKhTumitateDKanri();

        if (BizDateUtil.compareYmd(tumitateDKanriOld.getTumitatedtumitateymd(),
            tumitateDKanriNew.getTumitatedtumitateymd()) != BizDateUtil.COMPARE_EQUAL
            || !tumitateDKanriOld.getRenno().equals(tumitateDKanriNew.getRenno())) {

            setErrorInfo("003");

            logger.debug("△ 配当共通ＤＢアクセス（配当金支払） 終了");

            return C_ErrorKbn.ERROR;
        }

        IT_KhTumitateDKanri tumitateDKanri = new IT_KhTumitateDKanri();
        tumitateDKanri.setKbnkey(tumitateDKanriOld.getKbnkey());
        tumitateDKanri.setSyono(tumitateDKanriOld.getSyono());
        tumitateDKanri.setTumitatedtumitateymd(tumitateDKanriOld.getTumitatedtumitateymd());
        tumitateDKanri.setRenno(tumitateDKanriOld.getRenno() + 1);
        tumitateDKanri.setTumitatedskskbn(pTumitateDSakuseiKbn);
        tumitateDKanri.setTumitated(pTumitatedWarimodosiGo);
        tumitateDKanri.setTumitatedshrkrkymd(pCalckijyunymd);
        tumitateDKanri.setNaiteikakuteikbn(tumitateDKanriOld.getNaiteikakuteikbn());
        tumitateDKanri.setGyoumuKousinKinou(pKhozenCommonParam.getFunctionId());
        tumitateDKanri.setGyoumuKousinsyaId(pKhozenCommonParam.getUserID());
        tumitateDKanri.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

        insertTumitateDKanri(tumitateDKanri);

        logger.debug("△ 配当共通ＤＢアクセス（配当金支払） 終了");

        return C_ErrorKbn.OK;
    }
}