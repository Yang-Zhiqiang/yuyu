package yuyu.batch.suuri.srsuuritoukei.srkariwariatedmeisai;

import java.math.BigDecimal;

import yuyu.def.db.entity.ST_YuukoukykHtjynbknKarid;
import yuyu.def.db.entity.ZT_KariwariateHtkinMeisaiTy;

/**
 * 数理統計 数理統計 仮割当配当金明細情報作成項目編集クラス
 */
public class SrKariwariateDMeisaiBatchEdit {

    private boolean errorFlg;

    public SrKariwariateDMeisaiBatchEdit() {

        errorFlg = false;
    }

    public boolean editKoumoku(SrKariwariateDMeisaiBatchParam pSrKariwariateDMeisaiBatchParam,
        ST_YuukoukykHtjynbknKarid pYuukoukykHtjynbknKarid, ZT_KariwariateHtkinMeisaiTy pKariwariateHtkinMeisaiTy) {

        editHeaderKoumoku(pSrKariwariateDMeisaiBatchParam, pKariwariateHtkinMeisaiTy);

        editKariwariateDMeisaiKoumoku(pYuukoukykHtjynbknKarid, pKariwariateHtkinMeisaiTy);

        return errorFlg;
    }

    private void editHeaderKoumoku(SrKariwariateDMeisaiBatchParam pSrKariwariateDMeisaiBatchParam,
        ZT_KariwariateHtkinMeisaiTy pKariwariateHtkinMeisaiTy) {

        Integer Koumoku = pSrKariwariateDMeisaiBatchParam.getSyorikensuu();

        pSrKariwariateDMeisaiBatchParam.setSyorikensuu(pSrKariwariateDMeisaiBatchParam.getSyorikensuu() + 1);

        pKariwariateHtkinMeisaiTy.setZtysequenceno(Koumoku);
    }

    private void editKariwariateDMeisaiKoumoku(ST_YuukoukykHtjynbknKarid pYuukoukykHtjynbknKarid,
        ZT_KariwariateHtkinMeisaiTy pKariwariateHtkinMeisaiTy) {

        pKariwariateHtkinMeisaiTy.setZtysyono(pYuukoukykHtjynbknKarid.getSyono());
        pKariwariateHtkinMeisaiTy.setZtyhknsyukigou(pYuukoukykHtjynbknKarid.getHknsyukigou());
        pKariwariateHtkinMeisaiTy.setZtyhrkkaisuukbn(pYuukoukykHtjynbknKarid.getHaraikomikaisukbn());
        pKariwariateHtkinMeisaiTy.setZtyhrkkeirokbn(pYuukoukykHtjynbknKarid.getHrkkeirokbn());
        pKariwariateHtkinMeisaiTy.setZtyannaifuyouriyuukbn(pYuukoukykHtjynbknKarid.getAnnaihuyouriyuukbn());
        pKariwariateHtkinMeisaiTy.setZtyznnndkrkskrwratdruigk(new BigDecimal(pYuukoukykHtjynbknKarid
            .getZnnndkrkskrwratdruigk().toAdsoluteString()).longValue());
        pKariwariateHtkinMeisaiTy.setZtytounendokariwariated(new BigDecimal(pYuukoukykHtjynbknKarid
            .getTounendokariwariated().toAdsoluteString()).longValue());
        pKariwariateHtkinMeisaiTy.setZtytndmatukrkskrwratdruigk(new BigDecimal(pYuukoukykHtjynbknKarid
            .getTndmatukrkskrwratdruigk().toAdsoluteString()).longValue());
        pKariwariateHtkinMeisaiTy.setZtykariwariatedrisoku(new BigDecimal(pYuukoukykHtjynbknKarid
            .getKariwariatedrisoku().toAdsoluteString()).longValue());
        pKariwariateHtkinMeisaiTy.setZtyhsys(new BigDecimal(pYuukoukykHtjynbknKarid
            .getHsys().toAdsoluteString()).longValue());
        pKariwariateHtkinMeisaiTy.setZtysrutiwake(pYuukoukykHtjynbknKarid.getSrutiwake());
        pKariwariateHtkinMeisaiTy.setZtysrkijyunym(pYuukoukykHtjynbknKarid.getSrkijyunym());
        pKariwariateHtkinMeisaiTy.setZtykbnkeiriyousegmentkbn(pYuukoukykHtjynbknKarid.getKbnkeiriyousegmentkbn());
        pKariwariateHtkinMeisaiTy.setZtykbnkeiriyourgnbnskkbn(pYuukoukykHtjynbknKarid.getKbnkeiriyourgnbnskkbn());
        pKariwariateHtkinMeisaiTy.setZtyseisikiwariatenendohyj(pYuukoukykHtjynbknKarid.getSeisikiwariatenendohyj());
        if (pYuukoukykHtjynbknKarid.getMankitouraiym() != null){
            pKariwariateHtkinMeisaiTy.setZtymankitouraiym(pYuukoukykHtjynbknKarid.getMankitouraiym().toString());
        }
        pKariwariateHtkinMeisaiTy.setZtysyukeiyakusyuruicdv2(pYuukoukykHtjynbknKarid.getSyukeiyakusyuruicd());
        pKariwariateHtkinMeisaiTy.setZtykeiyakunendo(pYuukoukykHtjynbknKarid.getKyknendo());
        pKariwariateHtkinMeisaiTy.setZtydaihyouyoteiriritu(pYuukoukykHtjynbknKarid.getDaihyouyoteiriritu());
        pKariwariateHtkinMeisaiTy.setZtyharaikatakbn(pYuukoukykHtjynbknKarid.getHaraikatakbn());
    }
}