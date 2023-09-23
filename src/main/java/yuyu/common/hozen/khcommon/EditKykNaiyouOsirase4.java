package yuyu.common.hozen.khcommon;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.configuration.CoreConfig;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import yuyu.common.base.format.FixedDateFormatter;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.HanteiHokenKikan;
import yuyu.common.biz.bzcommon.HanteiHokenKikanBean;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.siharai.sicommon.CalcHkShrKngk;
import yuyu.common.siharai.sicommon.CalcHkShrKngkBean;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HknKknKbn;
import yuyu.def.classification.C_HokenkinsyuruiKbn;
import yuyu.def.classification.C_SiinKbn;
import yuyu.def.classification.C_SyoriKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.IT_KhHenreikin;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.ZT_GaikaKokyakuTuutiTy;
import yuyu.def.hozen.manager.HozenDomManager;

import com.google.common.collect.Lists;

/**
 * 契約保全 契約保全共通 契約内容のお知らせ編集４（終身円貨）
 */
public class EditKykNaiyouOsirase4 {

    private static final String AISATUMSGCD_03005 = "03005";

    private static final String OSIRASEMSGCD_08005 = "08005";

    private static final String OSIRASEMSGCD_08006 = "08006";

    private static final String OSIRASEMSGCD_08009 = "08009";

    private static final String OSIRASEMSGCD_08012 = "08012";

    private static final String HRKNKANSSIRYODOUHUUKBN_NASI = "0";

    private static final String HRKNKANSSIRYODOUHUUKBN_ARI = "1";

    private static final String BLANK = "";

    private static final String ERROR_MSG = "金額チェックエラーです。システム管理者にお問い合わせください。";

    @Inject
    private HozenDomManager hozenDomManager;

    private C_ErrorKbn commonErrorKbn = C_ErrorKbn.OK;

    public EditKykNaiyouOsirase4() {
        super();
    }

    C_ErrorKbn getCommonErrorKbn() {
        return commonErrorKbn;
    }

    public ZT_GaikaKokyakuTuutiTy editInfo(
        IT_KykKihon pKykKihon,
        BizDate pSyoriYmd,
        BizDate pKykoutoubi,
        ZT_GaikaKokyakuTuutiTy pGaikaKokyakuTuutiTyn) {

        List<String> osirasemsgcdLst = Lists.newArrayList();

        IT_KykSyouhn kykSyouhn = pKykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU).get(0);

        String syono = pKykKihon.getSyono();
        BizDate kykymd = kykSyouhn.getKykymd();
        Integer dai1hknkkn = kykSyouhn.getDai1hknkkn();

        String hrknkanssiryodouhuukbn = HRKNKANSSIRYODOUHUUKBN_NASI;
        BizCurrency yendtItijibrSysnHkHnkHr = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

        List<IT_KhHenreikin> khHenreikinYendtMbrList = hozenDomManager.getKhHenreikinYendtMbrsBySyono(syono);

        if (khHenreikinYendtMbrList.size() > 0) {
            hrknkanssiryodouhuukbn = HRKNKANSSIRYODOUHUUKBN_ARI;
            IT_KhHenreikin khHenreikin = khHenreikinYendtMbrList.get(0);
            yendtItijibrSysnHkHnkHr = khHenreikin.getHenreikingk();
        }
        else {
            hrknkanssiryodouhuukbn = HRKNKANSSIRYODOUHUUKBN_NASI;
        }

        HanteiHokenKikan hanteiHokenKikan = SWAKInjector.getInstance(HanteiHokenKikan.class);
        HanteiHokenKikanBean hanteiHokenKikanBean = SWAKInjector.getInstance(HanteiHokenKikanBean.class);
        BM_SyouhnZokusei syouhnZokuseiHnkMae = hozenDomManager.getKykSyouhnHnkmaeBySyono(syono).getSyouhnZokusei();

        hanteiHokenKikanBean.setKykYmd(kykymd);
        hanteiHokenKikanBean.setCalcKijyunYmd(pSyoriYmd);
        hanteiHokenKikanBean.setSyouhnZokusei(syouhnZokuseiHnkMae);
        hanteiHokenKikanBean.setDai1hknkkn(dai1hknkkn);

        hanteiHokenKikan.exec(hanteiHokenKikanBean);

        BizDate dai2hknkknFrom = hanteiHokenKikan.getDai2HknkknStartYmd();

        String dai2hknkknFromStr = BLANK;
        C_HknKknKbn hknkknkbn = C_HknKknKbn.BLNK;

        if (BizDateUtil.compareYmd(pSyoriYmd, dai2hknkknFrom) == BizDateUtil.COMPARE_LESSER) {
            dai2hknkknFromStr = FixedDateFormatter.formatYMDZenkakuSeirekiKanji(dai2hknkknFrom);
            hknkknkbn = C_HknKknKbn.DAI1HKNKKN;
        }

        CalcHkShrKngk calcHkShrKngk = SWAKInjector.getInstance(CalcHkShrKngk.class);
        C_ErrorKbn errorKbn = calcHkShrKngk.execByKeisanWExt(
            syono,
            pKykoutoubi,
            C_SiinKbn.SP,
            C_HokenkinsyuruiKbn.SBHOKENKIN,
            pKykKihon.getSdpdkbn(),
            pKykKihon.getHrkkeiro());

        if (!C_ErrorKbn.OK.eq(errorKbn)) {
            if (CoreConfig.getInstance().isBatchProduct()) {
                commonErrorKbn = C_ErrorKbn.ERROR;
                return pGaikaKokyakuTuutiTyn;
            }

            throw new CommonBizAppException(ERROR_MSG);
        }

        CalcHkShrKngkBean calcHkShrKngkBean = calcHkShrKngk.getCalcHkShrKngkBean();

        BizCurrency kaiyakuhrkngakYen = calcHkShrKngkBean.getKaiyakuhenreiknGk();
        BizCurrency sbhknkngkYen = calcHkShrKngkBean.getSibousGk();

        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.BLNK;

        List<IT_KhTtdkRireki> ttdkRirekiYendthnkList =
            pKykKihon.getKhTtdkRirekisByGyoumuKousinKinou(
                IKhozenCommonConstants.KINOUID_KHMKHGKTTTYENDTHNK);

        if (ttdkRirekiYendthnkList.size() > 0) {
            yendthnkSyoriKbn = ttdkRirekiYendthnkList.get(ttdkRirekiYendthnkList.size() - 1).getSyorikbn();
        }

        if (C_HknKknKbn.DAI1HKNKKN.eq(hknkknkbn)) {
            osirasemsgcdLst.add(OSIRASEMSGCD_08012);
        }

        if (C_SyoriKbn.YENDTHNK_MKHGKTTT.eq(yendthnkSyoriKbn)) {
            osirasemsgcdLst.add(OSIRASEMSGCD_08005);
        }
        else if (C_SyoriKbn.YENDTHNK_NINISEIKYUU.eq(yendthnkSyoriKbn)) {
            osirasemsgcdLst.add(OSIRASEMSGCD_08006);
        }

        if (HRKNKANSSIRYODOUHUUKBN_ARI.equals(hrknkanssiryodouhuukbn)) {
            osirasemsgcdLst.add(OSIRASEMSGCD_08009);
        }

        while (osirasemsgcdLst.size() < 3) {
            osirasemsgcdLst.add(BLANK);
        }

        String osiraseMsgcd1 = osirasemsgcdLst.get(0);
        String osiraseMsgcd2 = osirasemsgcdLst.get(1);
        String osiraseMsgcd3 = osirasemsgcdLst.get(2);

        pGaikaKokyakuTuutiTyn.setZtysyoruicd(C_SyoruiCdKbn.KK_GAIKA_KOKYAKUTUUTI.getValue().toUpperCase());
        pGaikaKokyakuTuutiTyn.setZtyaisatumsgcd1(AISATUMSGCD_03005);
        pGaikaKokyakuTuutiTyn.setZtyhrknkanssiryodouhuukbn(hrknkanssiryodouhuukbn);
        pGaikaKokyakuTuutiTyn.setZtyosirasetuutisakuseiymwa(
            FixedDateFormatter.formatYMZenkakuSeirekiKanji(pKykoutoubi));
        pGaikaKokyakuTuutiTyn.setZtydai2hknkknfromwa(dai2hknkknFromStr);
        pGaikaKokyakuTuutiTyn.setZtyyendthnkymd(FixedDateFormatter.formatYMDZenkakuSeirekiKanji(kykSyouhn.getYendthnkymd()));
        pGaikaKokyakuTuutiTyn.setZtysbhknkngkhknkkn(hknkknkbn.getValue());
        pGaikaKokyakuTuutiTyn.setZtysbhknkngkyen(sbhknkngkYen.toString());
        pGaikaKokyakuTuutiTyn.setZtykaiyakuhrkngakyen(kaiyakuhrkngakYen.toString());
        pGaikaKokyakuTuutiTyn.setZtyyendthnkhrkngakyen(yendtItijibrSysnHkHnkHr.toString());
        pGaikaKokyakuTuutiTyn.setZtyosirasemsgcd1(osiraseMsgcd1);
        pGaikaKokyakuTuutiTyn.setZtyosirasemsgcd2(osiraseMsgcd2);
        pGaikaKokyakuTuutiTyn.setZtyosirasemsgcd3(osiraseMsgcd3);

        return pGaikaKokyakuTuutiTyn;
    }

}
