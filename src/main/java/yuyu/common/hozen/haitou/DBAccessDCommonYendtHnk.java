package yuyu.common.hozen.haitou;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateY;
import jp.co.slcs.swak.number.BizCurrency;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HaitoukinsksKbn;
import yuyu.def.classification.C_HaitoumeisaiKbn;
import yuyu.def.classification.C_NaiteiKakuteiKbn;
import yuyu.def.classification.C_TumitateDSakuseiKbn;
import yuyu.def.db.entity.IT_KhHaitouKanri;
import yuyu.def.db.entity.IT_KhTumitateDKanri;

/**
 * 契約保全 配当 配当共通ＤＢアクセス（円建変更）クラス
 */
public class DBAccessDCommonYendtHnk extends DBAccessDCommon {

    @Inject
    private static Logger logger;

    public C_ErrorKbn insertHaitouInfo(
        String pSyono,
        BizDate pYendthnkymd,
        BizCurrency pHaitoukin,
        BizCurrency pkariwariatedruigk,
        BizCurrency pTumitated,
        C_NaiteiKakuteiKbn pNaiteiKakuteiKbn,
        BizDateY pHaitounendo,
        KhHaitouKanriKeyinfoBean pKhHaitouKanriKeyinfoBean,
        KhTumitateDKanriKeyinfoBean pKhTumitateDKanriKeyinfoBean,
        KhozenCommonParam pKhozenCommonParam) {

        logger.debug("▽ 配当共通ＤＢアクセス（円建変更） 開始");

        clear();

        IT_KhHaitouKanri haitouKanriOld = null;

        final boolean collectEntityFlg = getCollectEntityFlg();

        try {
            if (BizUtil.isBlank(pSyono) || pYendthnkymd == null || pHaitoukin == null || pHaitoukin.isOptional() ||
                pkariwariatedruigk == null || pkariwariatedruigk.isOptional() || pTumitated == null ||
                pTumitated.isOptional() || pNaiteiKakuteiKbn == null || pHaitounendo == null ||
                pKhozenCommonParam == null) {

                setErrorInfo("001");

                logger.debug("△ 配当共通ＤＢアクセス（円建変更） 終了");

                return C_ErrorKbn.ERROR;
            }

            if (pKhHaitouKanriKeyinfoBean != null) {

                if (C_ErrorKbn.ERROR.eq(getHaitouKanri(pKhHaitouKanriKeyinfoBean))) {

                    logger.debug("△ 配当共通ＤＢアクセス（円建変更） 終了");

                    return C_ErrorKbn.ERROR;
                }

                haitouKanriOld = getKhHaitouKanri();

                if (C_ErrorKbn.ERROR.eq(getSaisinHaitouKanriSyu(pSyono))) {

                    logger.debug("△ 配当共通ＤＢアクセス（円建変更） 終了");

                    return C_ErrorKbn.ERROR;
                }

                IT_KhHaitouKanri haitouKanriNew = getKhHaitouKanri();

                if ((haitouKanriOld.getHaitounendo().compareTo(haitouKanriNew.getHaitounendo()) != 0) ||
                    !haitouKanriOld.getRenno().equals(haitouKanriNew.getRenno())) {

                    logger.debug("△ 配当共通ＤＢアクセス（円建変更） 終了");

                    return C_ErrorKbn.ERROR;
                }
            }

            if (pKhTumitateDKanriKeyinfoBean != null) {

                if (C_ErrorKbn.ERROR.eq(getTumitateDKanri(pKhTumitateDKanriKeyinfoBean))) {

                    logger.debug("△ 配当共通ＤＢアクセス（円建変更） 終了");

                    return C_ErrorKbn.ERROR;
                }

                IT_KhTumitateDKanri tumitateDKanriOld = getKhTumitateDKanri();

                if (C_ErrorKbn.ERROR.eq(getSaisinTumitateDKanri(pSyono))) {

                    logger.debug("△ 配当共通ＤＢアクセス（円建変更） 終了");

                    return C_ErrorKbn.ERROR;
                }

                IT_KhTumitateDKanri tumitateDKanriNew = getKhTumitateDKanri();

                if (BizDateUtil.compareYmd(tumitateDKanriOld.getTumitatedtumitateymd(),
                    tumitateDKanriNew.getTumitatedtumitateymd()) != BizDateUtil.COMPARE_EQUAL ||
                    !tumitateDKanriOld.getRenno().equals(tumitateDKanriNew.getRenno())) {

                    setErrorInfo("003");

                    logger.debug("△ 配当共通ＤＢアクセス（円建変更） 終了");

                    return C_ErrorKbn.ERROR;
                }
            }

            Integer renno = null;
            BizDateY fstKariariatedNendo = null;
            BizCurrency tounendod = null;

            if (haitouKanriOld == null) {

                renno = 1;
                fstKariariatedNendo = pHaitounendo;
            }
            else {
                if (haitouKanriOld.getHaitounendo().equals(pHaitounendo)) {
                    renno = haitouKanriOld.getRenno() + 1;
                }
                else {
                    renno = 1;
                }
                fstKariariatedNendo = haitouKanriOld.getFstkariwariatednendo();
            }
            if (C_NaiteiKakuteiKbn.NAITEI.eq(pNaiteiKakuteiKbn)) {

                tounendod = BizCurrency.valueOf(0);
            }
            else if (C_NaiteiKakuteiKbn.KAKUTEI.eq(pNaiteiKakuteiKbn)) {
                if (pkariwariatedruigk.compareTo(BizCurrency.valueOf(0, pkariwariatedruigk.getType())) < 0) {
                    tounendod = BizCurrency.valueOf(0);
                }
                else {
                    tounendod = pkariwariatedruigk;
                }
            }
            String sysDateTime = BizDate.getSysDateTimeMilli();

            IT_KhHaitouKanri haitouKanriKariwariate = new IT_KhHaitouKanri(
                pSyono, pHaitounendo, renno, C_HaitoukinsksKbn.YENDTHNKKARIWARIATE, C_HaitoumeisaiKbn.SYU);
            haitouKanriKariwariate.setFstkariwariatednendo(fstKariariatedNendo);
            haitouKanriKariwariate.setTounendod(pHaitoukin);
            haitouKanriKariwariate.setNaiteikakuteikbn(pNaiteiKakuteiKbn);
            haitouKanriKariwariate.setKariwariatedshrymd(pYendthnkymd);
            haitouKanriKariwariate.setKariwariatedruigk(pkariwariatedruigk);
            haitouKanriKariwariate.setGyoumuKousinKinou(pKhozenCommonParam.getFunctionId());
            haitouKanriKariwariate.setGyoumuKousinsyaId(pKhozenCommonParam.getUserID());
            haitouKanriKariwariate.setGyoumuKousinTime(sysDateTime);

            insertHaitouKanri(haitouKanriKariwariate);

            IT_KhHaitouKanri haitouKanriKariSeisikiwariate = new IT_KhHaitouKanri(
                pSyono, pHaitounendo, renno + 1, C_HaitoukinsksKbn.YENDTHNKSEISIKI, C_HaitoumeisaiKbn.SYU);
            haitouKanriKariSeisikiwariate.setFstkariwariatednendo(fstKariariatedNendo);
            haitouKanriKariSeisikiwariate.setTounendod(tounendod);
            haitouKanriKariSeisikiwariate.setNaiteikakuteikbn(pNaiteiKakuteiKbn);
            haitouKanriKariSeisikiwariate.setKariwariatedshrymd(pYendthnkymd);
            haitouKanriKariSeisikiwariate.setGyoumuKousinKinou(pKhozenCommonParam.getFunctionId());
            haitouKanriKariSeisikiwariate.setGyoumuKousinsyaId(pKhozenCommonParam.getUserID());
            haitouKanriKariSeisikiwariate.setGyoumuKousinTime(sysDateTime);

            insertHaitouKanri(haitouKanriKariSeisikiwariate);

            IT_KhTumitateDKanri tumitateDKanri = new IT_KhTumitateDKanri(pSyono, pYendthnkymd, 1);
            tumitateDKanri.setTumitatedskskbn(C_TumitateDSakuseiKbn.YENDTHNKSEISIKI);
            tumitateDKanri.setTumitated(pTumitated);
            tumitateDKanri.setNaiteikakuteikbn(pNaiteiKakuteiKbn);
            tumitateDKanri.setGyoumuKousinKinou(pKhozenCommonParam.getFunctionId());
            tumitateDKanri.setGyoumuKousinsyaId(pKhozenCommonParam.getUserID());
            tumitateDKanri.setGyoumuKousinTime(sysDateTime);

            insertTumitateDKanri(tumitateDKanri);

            logger.debug("△ 配当共通ＤＢアクセス（円建変更） 終了");

            return C_ErrorKbn.OK;

        }
        finally {
            collectEntity(collectEntityFlg);
        }
    }
}