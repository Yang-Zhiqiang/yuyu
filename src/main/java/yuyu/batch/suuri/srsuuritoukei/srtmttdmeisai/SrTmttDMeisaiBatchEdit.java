package yuyu.batch.suuri.srsuuritoukei.srtmttdmeisai;

import java.math.BigDecimal;

import yuyu.def.db.entity.ST_YuukoukykHtjynbknTmttd;
import yuyu.def.db.entity.ZT_TmttHaitoukinMeisaiTy;

/**
 * 数理統計 数理統計 積立配当金明細情報作成項目編集クラス
 */
public class SrTmttDMeisaiBatchEdit {

    private boolean errorFlg;

    public SrTmttDMeisaiBatchEdit() {

        errorFlg = false;
    }

    public boolean editKoumoku(SrTmttDMeisaiBatchParam pSrTmttDMeisaiParam,
        ST_YuukoukykHtjynbknTmttd pYuukoukykHtjynbknTmttd,
        ZT_TmttHaitoukinMeisaiTy pTmttHaitoukinMeisaiTy) {

        editHeaderKoumoku(pSrTmttDMeisaiParam, pTmttHaitoukinMeisaiTy);

        editTmttHaitoukinMeisaiKoumoku(pYuukoukykHtjynbknTmttd, pTmttHaitoukinMeisaiTy);

        return errorFlg;
    }

    private void editHeaderKoumoku(SrTmttDMeisaiBatchParam pSrTmttDMeisaiParam,
        ZT_TmttHaitoukinMeisaiTy pTmttHaitoukinMeisaiTy) {

        Integer keyKoumoku = pSrTmttDMeisaiParam.getSyorikensuu();

        pSrTmttDMeisaiParam.setSyorikensuu(pSrTmttDMeisaiParam.getSyorikensuu() + 1);

        pTmttHaitoukinMeisaiTy.setZtysequenceno(keyKoumoku);
    }

    private void editTmttHaitoukinMeisaiKoumoku(ST_YuukoukykHtjynbknTmttd pYuukoukykHtjynbknTmttd,
        ZT_TmttHaitoukinMeisaiTy pTmttHaitoukinMeisaiTy) {

        pTmttHaitoukinMeisaiTy.setZtysyono(pYuukoukykHtjynbknTmttd.getSyono());
        pTmttHaitoukinMeisaiTy.setZtyhknsyukigou(pYuukoukykHtjynbknTmttd.getHknsyukigou());
        pTmttHaitoukinMeisaiTy.setZtyhrkkaisuukbn(pYuukoukykHtjynbknTmttd.getHaraikomikaisukbn());
        pTmttHaitoukinMeisaiTy.setZtyhrkkeirokbn(pYuukoukykHtjynbknTmttd.getHrkkeirokbn());
        pTmttHaitoukinMeisaiTy.setZtyannaifuyouriyuukbn(pYuukoukykHtjynbknTmttd.getAnnaihuyouriyuukbn());
        pTmttHaitoukinMeisaiTy.setZtyzennendokurikosid(
            new BigDecimal(pYuukoukykHtjynbknTmttd.getZennendkurikosid().toAdsoluteString()).longValue());
        pTmttHaitoukinMeisaiTy.setZtytounendod(
            new BigDecimal(pYuukoukykHtjynbknTmttd.getTounendod().toAdsoluteString()).longValue());
        pTmttHaitoukinMeisaiTy.setZtytounendomatutumitated(
            new BigDecimal(pYuukoukykHtjynbknTmttd.getTndmatutumitated().toAdsoluteString()).longValue());
        pTmttHaitoukinMeisaiTy.setZtytumitaterisoku(
            new BigDecimal(pYuukoukykHtjynbknTmttd.getTumitaterisoku().toAdsoluteString()).longValue());
        pTmttHaitoukinMeisaiTy.setZtyhsys(
            new BigDecimal(pYuukoukykHtjynbknTmttd.getHsys().toAdsoluteString()).longValue());
        pTmttHaitoukinMeisaiTy.setZtysyuruicd1(pYuukoukykHtjynbknTmttd.getSyuruicd1());
        pTmttHaitoukinMeisaiTy.setZtysyuruicd3(pYuukoukykHtjynbknTmttd.getSyuruicd3());
        pTmttHaitoukinMeisaiTy.setZtysrutiwake(pYuukoukykHtjynbknTmttd.getSrutiwake());
        pTmttHaitoukinMeisaiTy.setZtysrkijyunym(pYuukoukykHtjynbknTmttd.getSrkijyunym());
        pTmttHaitoukinMeisaiTy.setZtykbnkeiriyousegmentkbn(pYuukoukykHtjynbknTmttd.getKbnkeiriyousegmentkbn());
        pTmttHaitoukinMeisaiTy.setZtykbnkeiriyourgnbnskkbn(pYuukoukykHtjynbknTmttd.getKbnkeiriyourgnbnskkbn());
        pTmttHaitoukinMeisaiTy.setZtysyuruicd2(pYuukoukykHtjynbknTmttd.getSyuruicd2());
        if (pYuukoukykHtjynbknTmttd.getMankitouraiym() != null){
            pTmttHaitoukinMeisaiTy.setZtymankitouraiym(pYuukoukykHtjynbknTmttd.getMankitouraiym().toString());
        }
        pTmttHaitoukinMeisaiTy.setZtysyukeiyakusyuruicdv2(pYuukoukykHtjynbknTmttd.getSyukeiyakusyuruicd());
        pTmttHaitoukinMeisaiTy.setZtykeiyakunendo(pYuukoukykHtjynbknTmttd.getKyknendo());
        pTmttHaitoukinMeisaiTy.setZtydaihyouyoteiriritu(pYuukoukykHtjynbknTmttd.getDaihyouyoteiriritu());
        pTmttHaitoukinMeisaiTy.setZtyharaikatakbn(pYuukoukykHtjynbknTmttd.getHaraikatakbn());
    }
}