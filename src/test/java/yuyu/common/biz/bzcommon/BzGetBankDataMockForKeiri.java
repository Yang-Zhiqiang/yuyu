package yuyu.common.biz.bzcommon;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import yuyu.common.biz.kaikei.BzFbSoukinFileSksTest_creadFBsoukinfwairu;
import yuyu.def.classification.C_BankYuuksHantKbn;
import yuyu.def.classification.C_BankmasterUmuKbn;
import yuyu.def.classification.C_EnkashrKahiKbn;
import yuyu.def.classification.C_GaikashrKahiKbn;
import yuyu.def.classification.C_Kokunaikwskameihyj;

/**
 * {@link BzGetBankData}のモッククラスです。<br />
 */
public class BzGetBankDataMockForKeiri extends BzGetBankData {

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public static final String TESTPATTERN1 = "1";

    @Override
    public BzGetBankDataBean exec(String pBankCd, String pSitenCd, BizDate pKijyunYmd) {

        if (caller == BzFbSoukinFileSksTest_creadFBsoukinfwairu.class) {

            BzGetBankDataBean getBankDataBean = SWAKInjector.getInstance(BzGetBankDataBean.class);
            getBankDataBean.setBankCd(pBankCd);
            getBankDataBean.setSitenCd(pSitenCd);
            getBankDataBean.setBankYuuksHantKbn(C_BankYuuksHantKbn.HANTEIHUKA);
            getBankDataBean.setBankmasterUmuKbn(C_BankmasterUmuKbn.ARI);
            getBankDataBean.setEnkashrKahiKbn(C_EnkashrKahiKbn.KA);
            getBankDataBean.setGaikashrKahiKbn(C_GaikashrKahiKbn.HUKA);

            if ("1002".equals(pBankCd)) {
                getBankDataBean.setBankNmKn("ギンコウメイギンコウメイ１");

                getBankDataBean.setSitenNmKn("シテンメイシテンメイシテンメ１");

                getBankDataBean.setBankmasterUmuKbn(C_BankmasterUmuKbn.ARI);

                getBankDataBean.setKokunaikwskameihyj(C_Kokunaikwskameihyj.KAMEI);
            }
            else if ("1003".equals(pBankCd)) {
                getBankDataBean.setBankNmKn("ギンコウメイギンコウメイ２");

                getBankDataBean.setSitenNmKn("シテンメイシテンメイシテンメ２");

                getBankDataBean.setBankmasterUmuKbn(C_BankmasterUmuKbn.ARI);

                getBankDataBean.setKokunaikwskameihyj(C_Kokunaikwskameihyj.MIKAMEI);
            }
            else if ("1004".equals(pBankCd)) {
                getBankDataBean.setBankNmKn("ギンコウメイギンコウメイ３");

                getBankDataBean.setSitenNmKn("シテンメイシテンメイシテンメ３");

                getBankDataBean.setBankmasterUmuKbn(C_BankmasterUmuKbn.NONE);

                getBankDataBean.setKokunaikwskameihyj(C_Kokunaikwskameihyj.KAMEI);
            }
            else if ("1005".equals(pBankCd)) {
                getBankDataBean.setBankNmKn("ギンコウメイギンコウメイ４");

                getBankDataBean.setSitenNmKn("シテンメイシテンメイシテンメ４");

                getBankDataBean.setBankmasterUmuKbn(C_BankmasterUmuKbn.ARI);

                getBankDataBean.setKokunaikwskameihyj(C_Kokunaikwskameihyj.KAMEI);
            }
            if (TESTPATTERN1.equals(SYORIPTN)) {
                getBankDataBean.setBankNmKn("ギンコウメイギンコウメイ１");

                getBankDataBean.setSitenNmKn("シテンメイシテンメイシテンメ１");

                getBankDataBean.setBankmasterUmuKbn(C_BankmasterUmuKbn.ARI);

                getBankDataBean.setKokunaikwskameihyj(C_Kokunaikwskameihyj.KAMEI);
            }
            return getBankDataBean;
        }

        return super.exec(pBankCd, pSitenCd, pKijyunYmd);
    }
}
