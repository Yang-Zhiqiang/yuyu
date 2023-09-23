package yuyu.common.hozen.khcommon;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.hozen.khcommon.dba4editkoujyonaiyoudtbl.EditKoujyonaiyouDTblDao;
import yuyu.def.classification.C_Delflag;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Kjsmhakkouzumiflg;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_KoujyoSymNaiyouD;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.hozen.manager.HozenDomManager;
/**
 * 契約保全 契約保全共通 控除証明内容ＤＴＢＬ編集クラス
 */
public class EditKoujyonaiyouDTbl {

    @Inject
    private static Logger logger;

    @Inject
    private EditKoujyonaiyouDTblDao editKoujyonaiyouDTblDao;

    @Inject
    private HozenDomManager hozenDomManager;

    public C_ErrorKbn editTBL(KhozenCommonParam pKhozenCommonParam,
        KoujyonaiyouDTBLSksParam pKoujyonaiyouDTBLSksParam) {

        logger.debug("▽ 控除証明内容ＤＴＢＬ編集 開始");

        if (C_UmuKbn.NONE.eq(pKoujyonaiyouDTBLSksParam.getZeiseiTkkktkykhukaUmu()) &&
            pKoujyonaiyouDTBLSksParam.getKhHaitouKanri().getKariwariatedshrgk().compareTo(BizCurrency.valueOf(0)) > 0) {

            Integer rennoMax = editKoujyonaiyouDTblDao.getEditKoujyonaiyouDMaxRenno3keta(
                pKoujyonaiyouDTBLSksParam.getKykSyouhn().getSyono(),
                pKoujyonaiyouDTBLSksParam.getKykSyouhn().getSyouhncd());

            Integer renno = null;

            if (rennoMax == null) {
                renno = 1;
            }
            else {
                renno = rennoMax + 1;
            }

            IT_KykKihon kykKihon = hozenDomManager.getKykKihon(pKoujyonaiyouDTBLSksParam.getKykSyouhn().getSyono());

            IT_KoujyoSymNaiyouD koujyoSymNaiyouD = kykKihon.createKoujyoSymNaiyouD();

            koujyoSymNaiyouD.setSyouhncd(pKoujyonaiyouDTBLSksParam.getKykSyouhn().getSyouhncd());
            koujyoSymNaiyouD.setRenno3keta(renno);
            koujyoSymNaiyouD.setKoujyosyoumeinnd(
                String.valueOf(pKoujyonaiyouDTBLSksParam.getKhHaitouKanri().getKariwariatedshrymd().getYear()));
            koujyoSymNaiyouD.setKoujyosyoumeid(pKoujyonaiyouDTBLSksParam.getKhHaitouKanri().getKariwariatedshrgk());
            koujyoSymNaiyouD.setHaitounendo(pKoujyonaiyouDTBLSksParam.getKhHaitouKanri().getHaitounendo());
            koujyoSymNaiyouD.setHaitoukanrirenno(pKoujyonaiyouDTBLSksParam.getKhHaitouKanri().getRenno());
            koujyoSymNaiyouD.setHaitoukinskskbn(pKoujyonaiyouDTBLSksParam.getKhHaitouKanri().getHaitoukinskskbn());
            koujyoSymNaiyouD.setHaitoumeisaikbn(pKoujyonaiyouDTBLSksParam.getKhHaitouKanri().getHaitoumeisaikbn());
            koujyoSymNaiyouD.setKjsmhakkouzumiflg(C_Kjsmhakkouzumiflg.BLNK);
            koujyoSymNaiyouD.setSakujyoflg(C_Delflag.BLNK);
            koujyoSymNaiyouD.setGyoumuKousinKinou(pKhozenCommonParam.getFunctionId());
            koujyoSymNaiyouD.setGyoumuKousinsyaId(pKhozenCommonParam.getUserID());
            koujyoSymNaiyouD.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

            BizPropertyInitializer.initialize(koujyoSymNaiyouD);

            hozenDomManager.update(kykKihon);
        }

        logger.debug("△ 控除証明内容ＤＴＢＬ編集 終了");

        return C_ErrorKbn.OK;
    }
}
