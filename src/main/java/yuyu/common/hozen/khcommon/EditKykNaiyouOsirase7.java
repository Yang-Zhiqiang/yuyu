package yuyu.common.hozen.khcommon;

import java.util.List;

import jp.co.slcs.swak.core.configuration.CoreConfig;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import yuyu.common.base.format.FixedDateFormatter;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.siharai.sicommon.CalcHkShrKngk;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HokenkinsyuruiKbn;
import yuyu.def.classification.C_SiinKbn;
import yuyu.def.classification.C_SyoriKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.ZT_GaikaKokyakuTuutiTy;

/**
 * 契約保全 契約保全共通 契約内容のお知らせ編集７（JG改定円貨）
 */
public class EditKykNaiyouOsirase7 {

    private static final String AISATUMSGCD_03005 = "03005";

    private static final String OSIRASEMSGCD_08005 = "08005";

    private static final String OSIRASEMSGCD_08006 = "08006";

    private static final String ERROR_MSG = "金額チェックエラーです。システム管理者にお問い合わせください。";

    private C_ErrorKbn commonErrorKbn = C_ErrorKbn.OK;

    public EditKykNaiyouOsirase7() {
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

        String osiraseMsgcd1 = "";

        IT_KykSyouhn kykSyouhn = pKykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU).get(0);

        String syono = pKykKihon.getSyono();

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

        BizCurrency ptumitatekngkyen = calcHkShrKngk.getCalcHkShrKngkBean().getTmttKnGk();

        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.BLNK;

        List<IT_KhTtdkRireki> ttdkRirekiYendthnkList =
            pKykKihon.getKhTtdkRirekisByGyoumuKousinKinou(
                IKhozenCommonConstants.KINOUID_KHMKHGKTTTYENDTHNK);

        if (ttdkRirekiYendthnkList.size() > 0) {
            yendthnkSyoriKbn = ttdkRirekiYendthnkList.get(ttdkRirekiYendthnkList.size() - 1).getSyorikbn();
        }


        if (C_SyoriKbn.YENDTHNK_MKHGKTTT.eq(yendthnkSyoriKbn)) {
            osiraseMsgcd1 = OSIRASEMSGCD_08005;
        }
        else if (C_SyoriKbn.YENDTHNK_NINISEIKYUU.eq(yendthnkSyoriKbn)) {
            osiraseMsgcd1 = OSIRASEMSGCD_08006;
        }

        pGaikaKokyakuTuutiTyn.setZtysyoruicd(C_SyoruiCdKbn.KK_GAIKA_KOKYAKUTUUTI.getValue().toUpperCase());
        pGaikaKokyakuTuutiTyn.setZtyaisatumsgcd1(AISATUMSGCD_03005);
        pGaikaKokyakuTuutiTyn.setZtyosirasetuutisakuseiymwa(
            FixedDateFormatter.formatYMZenkakuSeirekiKanji(pKykoutoubi));
        pGaikaKokyakuTuutiTyn.setZtyyendthnkymd(FixedDateFormatter.formatYMDZenkakuSeirekiKanji(kykSyouhn.getYendthnkymd()));
        pGaikaKokyakuTuutiTyn.setZtykijyunkingaku(kykSyouhn.getKihons().toString());
        pGaikaKokyakuTuutiTyn.setZtytumitatekngkkyen(ptumitatekngkyen.toString());
        pGaikaKokyakuTuutiTyn.setZtyosirasemsgcd1(osiraseMsgcd1);

        return pGaikaKokyakuTuutiTyn;
    }
}
