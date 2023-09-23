package yuyu.common.hozen.haitou;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;

import org.slf4j.Logger;

import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HaitoukinsksKbn;
import yuyu.def.db.entity.IT_KhHaitouKanri;

/**
 * 契約保全 配当 配当共通ＤＢアクセス（減額）クラス
 */
public class DBAccessDCommonGengaku extends DBAccessDCommon {

    @Inject
    private static Logger logger;

    public C_ErrorKbn insertHaitouInfo(
        BizDate pCalckijyunymd,
        BizCurrency pKariwariatedruigk,
        BizCurrency pKariwariatedgngkkngk,
        BizCurrency pKariwariatedshrgk,
        KhHaitouKanriKeyinfoBean pKhHaitouKanriKeyinfoBean,
        KhozenCommonParam pKhozenCommonParam) {

        logger.debug("▽ 配当共通ＤＢアクセス（減額） 開始");

        clear();

        if (pCalckijyunymd == null || pKariwariatedruigk == null || pKariwariatedruigk.isOptional() ||
            pKariwariatedgngkkngk == null || pKariwariatedgngkkngk.isOptional() ||
            pKariwariatedshrgk == null || pKariwariatedshrgk.isOptional() || pKhozenCommonParam == null) {

            setErrorInfo("001");

            logger.debug("△ 配当共通ＤＢアクセス（減額） 終了");

            return C_ErrorKbn.ERROR;
        }

        if (pKhHaitouKanriKeyinfoBean == null) {

            logger.debug("△ 配当共通ＤＢアクセス（減額） 終了");

            return C_ErrorKbn.OK;
        }

        if (C_ErrorKbn.ERROR.eq(getHaitouKanri(pKhHaitouKanriKeyinfoBean))) {

            logger.debug("△ 配当共通ＤＢアクセス（減額） 終了");

            return C_ErrorKbn.ERROR;
        }

        IT_KhHaitouKanri haitouKanriOld = getKhHaitouKanri();

        if (C_ErrorKbn.ERROR.eq(getSaisinHaitouKanriSyu(pKhHaitouKanriKeyinfoBean.getSyono()))) {

            logger.debug("△ 配当共通ＤＢアクセス（減額） 終了");

            return C_ErrorKbn.ERROR;
        }

        IT_KhHaitouKanri haitouKanriNew = getKhHaitouKanri();

        if (haitouKanriOld.getHaitounendo().compareTo(haitouKanriNew.getHaitounendo()) != 0 ||
            !haitouKanriOld.getRenno().equals(haitouKanriNew.getRenno())) {

            setErrorInfo("003");

            logger.debug("△ 配当共通ＤＢアクセス（減額） 終了");

            return C_ErrorKbn.ERROR;
        }

        if (C_HaitoukinsksKbn.SEISIKI.eq(haitouKanriOld.getHaitoukinskskbn()) ||
            C_HaitoukinsksKbn.YENDTHNKSEISIKI.eq(haitouKanriOld.getHaitoukinskskbn())) {

            logger.debug("△ 配当共通ＤＢアクセス（減額） 終了");

            return C_ErrorKbn.OK;
        }

        IT_KhHaitouKanri haitouKanri = new IT_KhHaitouKanri();
        haitouKanri.setKbnkey(haitouKanriOld.getKbnkey());
        haitouKanri.setSyono(haitouKanriOld.getSyono());
        haitouKanri.setHaitounendo(haitouKanriOld.getHaitounendo());
        haitouKanri.setRenno(haitouKanriOld.getRenno() + 1);
        haitouKanri.setHaitoukinskskbn(C_HaitoukinsksKbn.KARIDSIHARAI);
        haitouKanri.setHaitoumeisaikbn(haitouKanriOld.getHaitoumeisaikbn());
        haitouKanri.setFstkariwariatednendo(haitouKanriOld.getFstkariwariatednendo());
        haitouKanri.setNaiteikakuteikbn(haitouKanriOld.getNaiteikakuteikbn());
        haitouKanri.setKariwariatedshrymd(pCalckijyunymd);
        haitouKanri.setKariwariatedruigk(pKariwariatedruigk);
        haitouKanri.setKariwariatedgngkkngk(pKariwariatedgngkkngk);
        haitouKanri.setKariwariatedshrgk(pKariwariatedshrgk);
        haitouKanri.setGyoumuKousinKinou(pKhozenCommonParam.getFunctionId());
        haitouKanri.setGyoumuKousinsyaId(pKhozenCommonParam.getUserID());
        haitouKanri.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

        insertHaitouKanri(haitouKanri);

        setKhHaitouKanri(haitouKanri);

        logger.debug("△ 配当共通ＤＢアクセス（減額） 終了");

        return C_ErrorKbn.OK;
    }
}