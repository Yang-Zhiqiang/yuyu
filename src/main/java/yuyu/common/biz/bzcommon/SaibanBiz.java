package yuyu.common.biz.bzcommon;

import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.sequence.RenbanUtil;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.def.MessageId;
import yuyu.def.classification.C_NosyuruiKbn;

/**
 * 採番業務共通クラス
 */
public class SaibanBiz {

    static final int NOSYURUI_KOKYAKUNO = Integer.parseInt(C_NosyuruiKbn.KOKYAKUNO.toString());

    static final int NOSYURUI_MRINFONO = Integer.parseInt(C_NosyuruiKbn.MRJHNO.toString());

    static final int NOSYURUI_SEIKYUNO = Integer.parseInt(C_NosyuruiKbn.SEIKYUNO.toString());

    static final int NOSYURUI_SATEISYOUNINKEY = Integer.parseInt(C_NosyuruiKbn.SATEISYOUNINKEY.toString());

    static final int NOSYURUI_SHRSIKIBETUKEY = Integer.parseInt(C_NosyuruiKbn.SHRSIKIBETUKEY.toString());

    static final int NOSYURUI_TYOUSASIKIBETUKEY = Integer.parseInt(C_NosyuruiKbn.TYOUSASIKIBETUKEY.toString());

    static final int NOSYURUI_TTDKRRKSIKIBETUKEY = Integer.parseInt(C_NosyuruiKbn.TTDKRRKSIKIBETUKEY.toString());

    static final int NOSYURUI_SHRKENSYOUSIKIBETUKEY = Integer.parseInt(C_NosyuruiKbn.SHRKENSYOUSIKIBETUKEY.toString());

    static final int NOSYURUI_NYUKINTRRENNO = Integer.parseInt(C_NosyuruiKbn.NYUKINTRRENNO.toString());

    static final int NOSYURUI_HENKOUSIKIBETUKEY = Integer.parseInt(C_NosyuruiKbn.HENKOUSIKIBETUKEY.toString());

    static final int NOSYURUI_HANDKARIKANJONO = Integer.parseInt(C_NosyuruiKbn.HANDKARIKANJONO.toString());

    static final int NOSYURUI_AKS_RENDOUIMAGENO = Integer.parseInt(C_NosyuruiKbn.AKS_RENDOUIMAGENO.toString());

    static final int NOSYURUI_HOZENHENKOUUKTKRENNO = Integer.parseInt(C_NosyuruiKbn.HOZENHENKOUUKTKRENNO.toString());

    static final int NOSYURUI_SEIKYUUINFOFRENNO = Integer.parseInt(C_NosyuruiKbn.SEIKYUUINFOFRENNO.toString());

    static final int NOSYURUI_BUNKATUSIFRENNO = Integer.parseInt(C_NosyuruiKbn.BUNKATUSIFRENNO.toString());

    static final int NOSYURUI_KEIRISYORIRENNO  = Integer.parseInt(C_NosyuruiKbn.KEIRISYORIRENNO.toString());

    public static long getHandKarikanjoNo() {
        return RenbanUtil.getRenban(NOSYURUI_HANDKARIKANJONO);
    }

    public static String getMrInfoNo() {
        return RenbanUtil.getRenbanAsString(NOSYURUI_MRINFONO);
    }

    public static String getKokNo() {
        return RenbanUtil.getRenbanAsString(NOSYURUI_KOKYAKUNO);
    }

    public static String getSeikyuBangou() {
        return RenbanUtil.getRenbanAsString(NOSYURUI_SEIKYUNO);
    }

    public static String getSateSyouninSikibetukey(String pSyono) {
        if (BizUtil.isBlank(pSyono)) {
            throw new BizAppException(MessageId.EBA0023, MessageUtil.getMessage(MessageId.IBW0001));
        }

        return RenbanUtil.getRenbanAsString(NOSYURUI_SATEISYOUNINKEY, pSyono);
    }

    public static String getShrSikibetukey(String pSyono) {
        if (BizUtil.isBlank(pSyono)) {
            throw new BizAppException(MessageId.EBA0023, MessageUtil.getMessage(MessageId.IBW0001));
        }

        return RenbanUtil.getRenbanAsString(NOSYURUI_SHRSIKIBETUKEY, pSyono);
    }

    public static String getTetudukirirekiSikibetukey(String pSyono) {
        if (BizUtil.isBlank(pSyono)) {
            throw new BizAppException(MessageId.EBA0023, MessageUtil.getMessage(MessageId.IBW0001));
        }

        return RenbanUtil.getRenbanAsString(NOSYURUI_TTDKRRKSIKIBETUKEY, pSyono);

    }

    public static String getTyousaSikibetukey(String pSyono) {
        if (BizUtil.isBlank(pSyono)) {
            throw new BizAppException(MessageId.EBA0023, MessageUtil.getMessage(MessageId.IBW0001));
        }

        return RenbanUtil.getRenbanAsString(NOSYURUI_TYOUSASIKIBETUKEY, pSyono);
    }

    public static String getShrgoKensyouSikibetukey(String pSyono) {
        if (BizUtil.isBlank(pSyono)) {
            throw new BizAppException(MessageId.EBA0023, MessageUtil.getMessage(MessageId.IBW0001));
        }

        return RenbanUtil.getRenbanAsString(NOSYURUI_SHRKENSYOUSIKIBETUKEY, pSyono);
    }

    public static String getNyukinTRRenban(String pSyoriYmd) {
        if (BizUtil.isBlank(pSyoriYmd)) {
            throw new BizAppException(MessageId.EBA0023, MessageUtil.getMessage(MessageId.IBW0001));
        }

        return RenbanUtil.getRenbanAsString(NOSYURUI_NYUKINTRRENNO, pSyoriYmd);
    }

    public static String getHenkouSikibetukey(String pSyono) {
        if (BizUtil.isBlank(pSyono)) {
            throw new BizAppException(MessageId.EBA0023, MessageUtil.getMessage(MessageId.IBW0001));
        }

        return RenbanUtil.getRenbanAsString(NOSYURUI_HENKOUSIKIBETUKEY, pSyono);
    }

    public static String getAksRendouImageNo(String pSyoriYmd) {
        if (BizUtil.isBlank(pSyoriYmd)) {
            throw new BizAppException(MessageId.EBA0023, MessageUtil.getMessage(MessageId.IBW0001));
        }

        return RenbanUtil.getRenbanAsString(pSyoriYmd, NOSYURUI_AKS_RENDOUIMAGENO);
    }

    public static String getHozenHenkouUktkrenNo(String pSyono) {
        if (BizUtil.isBlank(pSyono)) {
            throw new BizAppException(MessageId.EBA0023, MessageUtil.getMessage(MessageId.IBW0001));
        }

        return RenbanUtil.getRenbanAsString(NOSYURUI_HOZENHENKOUUKTKRENNO, pSyono);
    }

    public static String getSeikyuuInfoFRenNo(String pSyoriYmd) {
        if (BizUtil.isBlank(pSyoriYmd)) {
            throw new BizAppException(MessageId.EBA0023, MessageUtil.getMessage(MessageId.IBW0001));
        }

        return RenbanUtil.getRenbanAsString(NOSYURUI_SEIKYUUINFOFRENNO, pSyoriYmd);
    }

    public static String getBunkatuSiKeisanFRenNo(String pSyoriYmd) {
        if (BizUtil.isBlank(pSyoriYmd)) {
            throw new BizAppException(MessageId.EBA0023, MessageUtil.getMessage(MessageId.IBW0001));
        }

        return RenbanUtil.getRenbanAsString(NOSYURUI_BUNKATUSIFRENNO, pSyoriYmd);
    }

    public static String getKeirisyoriRenNo(String pSyoriYmd) {
        if (BizUtil.isBlank(pSyoriYmd)) {
            throw new BizAppException(MessageId.EBA0023, MessageUtil.getMessage(MessageId.IBW0001));
        }

        return RenbanUtil.getRenbanAsString(NOSYURUI_KEIRISYORIRENNO, pSyoriYmd);
    }

}
