package yuyu.batch.suuri.srsuuritoukei.srbikinkykseisand;

import java.math.BigDecimal;

import yuyu.def.db.entity.ST_BknkykHtjynbkn;
import yuyu.def.db.entity.ZT_BikinKeiyakuSeisandTy;

/**
 * 備金契約精算Ｄ情報作成パラメータクラス
 */
public class SrBikinKykSeisanDBatchEdit {

    private boolean errorFlg;

    public SrBikinKykSeisanDBatchEdit() {

        errorFlg = false;
    }

    public boolean editKoumoku(SrBikinKykSeisanDBatchParam pSrBikinKykSeisanDBatchParam,
        ST_BknkykHtjynbkn pBknkykHtjynbkn,ZT_BikinKeiyakuSeisandTy pBikinKeiyakuSeisandTy) {

        editHeaderKoumoku(pSrBikinKykSeisanDBatchParam,
            pBikinKeiyakuSeisandTy);

        editBikinKeiyakuSeisandKoumoku(pBknkykHtjynbkn,
            pBikinKeiyakuSeisandTy);

        return errorFlg;
    }

    private void editHeaderKoumoku(SrBikinKykSeisanDBatchParam pSrBikinKykSeisanDBatchParam,
        ZT_BikinKeiyakuSeisandTy pBikinKeiyakuSeisandTy) {

        Integer keyKoumoku = pSrBikinKykSeisanDBatchParam.getSyorikensuu();

        pSrBikinKykSeisanDBatchParam.setSyorikensuu(pSrBikinKykSeisanDBatchParam.getSyorikensuu() + 1);

        pBikinKeiyakuSeisandTy.setZtysequenceno(keyKoumoku);
    }

    private void editBikinKeiyakuSeisandKoumoku(ST_BknkykHtjynbkn pBknkykHtjynbkn,
        ZT_BikinKeiyakuSeisandTy pBikinKeiyakuSeisandTy) {

        pBikinKeiyakuSeisandTy.setZtysyono(pBknkykHtjynbkn.getSyono());
        pBikinKeiyakuSeisandTy.setZtyhknsyukigou(pBknkykHtjynbkn.getHknsyukigou());
        pBikinKeiyakuSeisandTy.setZtyhrkkaisuukbn(pBknkykHtjynbkn.getHaraikomikaisukbn());
        pBikinKeiyakuSeisandTy.setZtyhrkkeirokbn(pBknkykHtjynbkn.getHrkkeirokbn());
        pBikinKeiyakuSeisandTy.setZtyannaifuyouriyuukbn(pBknkykHtjynbkn.getAnnaihuyouriyuukbn());
        pBikinKeiyakuSeisandTy.setZtybikinkbn(pBknkykHtjynbkn.getBikinkbn());
        pBikinKeiyakuSeisandTy.setZtybikinnendokbn(pBknkykHtjynbkn.getBikinnendokbn());
        pBikinKeiyakuSeisandTy.setZtyseisand(new BigDecimal(pBknkykHtjynbkn.getSeisand().toAdsoluteString()).longValue());
        pBikinKeiyakuSeisandTy.setZtytumitaterisoku(
            new BigDecimal(pBknkykHtjynbkn.getTumitaterisoku().toAdsoluteString()).longValue());
        pBikinKeiyakuSeisandTy.setZtysyuruicd1(pBknkykHtjynbkn.getSyuruicd1());
        pBikinKeiyakuSeisandTy.setZtysyuruicd3(pBknkykHtjynbkn.getSyuruicd3());
        pBikinKeiyakuSeisandTy.setZtysrkijyunym(pBknkykHtjynbkn.getSrkijyunym());
        pBikinKeiyakuSeisandTy.setZtykbnkeiriyousegmentkbn(pBknkykHtjynbkn.getKbnkeiriyousegmentkbn());
        pBikinKeiyakuSeisandTy.setZtykbnkeiriyourgnbnskkbn(pBknkykHtjynbkn.getKbnkeiriyourgnbnskkbn());
        pBikinKeiyakuSeisandTy.setZtysyuruicd2(pBknkykHtjynbkn.getSyuruicd2());
        pBikinKeiyakuSeisandTy.setZtykariwariatedganrikin(new BigDecimal(pBknkykHtjynbkn.getKariwariatedganrikin()
            .toAdsoluteString()).longValue());
        pBikinKeiyakuSeisandTy.setZtykariwariatedrisoku(new BigDecimal(pBknkykHtjynbkn.getKariwariatedrisoku()
            .toAdsoluteString()).longValue());
        pBikinKeiyakuSeisandTy.setZtysyukeiyakusyuruicdv2(pBknkykHtjynbkn.getSyukeiyakusyuruicd());
        pBikinKeiyakuSeisandTy.setZtykeiyakunendo(pBknkykHtjynbkn.getKyknendo());
        pBikinKeiyakuSeisandTy.setZtydaihyouyoteiriritu(pBknkykHtjynbkn.getDaihyouyoteiriritu());
        pBikinKeiyakuSeisandTy.setZtyharaikatakbn(pBknkykHtjynbkn.getHaraikatakbn());
    }
}
