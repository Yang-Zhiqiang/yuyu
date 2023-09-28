package yuyu.common.biz.prereport;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.uniquekey.UniqueKeyGenerator;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_QrCodeTaikeiKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.BM_TorikomiSyoruiHukaInfo;

import com.google.common.base.Strings;

/**
 * QRコード値取得処理クラスです。
 */
public class GetQRCode {

    public static String execGetQRCode(String pSyoruiCd) {
        String wkQrCode = null;
        BM_TorikomiSyoruiHukaInfo torikomiSyoruiHukaInfo = null;
        if (!Strings.isNullOrEmpty(C_SyoruiCdKbn.getContentByValue(pSyoruiCd))) {
            BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
            torikomiSyoruiHukaInfo = bizDomManager.getTorikomiSyoruiHukaInfo(C_SyoruiCdKbn.valueOf(pSyoruiCd));
        }

        if (torikomiSyoruiHukaInfo == null) {
        } else if (C_QrCodeTaikeiKbn.YUYU.equals(torikomiSyoruiHukaInfo.getQrcodetaikeikbn())
            || C_QrCodeTaikeiKbn.MOS.equals(torikomiSyoruiHukaInfo.getQrcodetaikeikbn())) {
            UniqueKeyGenerator ukGenerator = SWAKInjector.getInstance(UniqueKeyGenerator.class);
            wkQrCode = torikomiSyoruiHukaInfo.getQrcodetaikeikbn().getValue() + ukGenerator.generateUniqueKey();

            wkQrCode = wkQrCode.toUpperCase();
        }
        return wkQrCode;
    }

    public static String execGetQRCodeMos() {
        String wkQrCode = null;

        UniqueKeyGenerator ukGenerator = SWAKInjector.getInstance(UniqueKeyGenerator.class);

        wkQrCode = C_QrCodeTaikeiKbn.MOS.getValue() + ukGenerator.generateUniqueKey();

        wkQrCode = wkQrCode.toUpperCase();

        return wkQrCode;
    }
}