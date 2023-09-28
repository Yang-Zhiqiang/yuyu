package yuyu.common.biz.interf;

import java.math.BigDecimal;

import jp.co.slcs.swak.number.BizCurrency;
import yuyu.def.classification.C_HnknhkgnKbn;

/**
 * 業務共通 インターフェイス 伝送用売上金額変換処理
 */
public class DensouUriageKgHenkan {

    private final String[] plusWords = {"{", "A", "B", "C", "D", "E", "F", "G", "H", "I"};

    private final String[] minusWords = {"}", "J", "K", "L", "M", "N", "O", "P", "Q", "R"};

    private BizCurrency signUrageGk;

    private String densoUriageGk;

    private boolean errFlag = false;

    public DensouUriageKgHenkan() {
        super();
    }

    public BizCurrency getSignUrageGk() {
        return signUrageGk;
    }

    public String getDensoUriageGk() {
        return densoUriageGk;
    }

    public boolean getErrFlag() {
        return errFlag;
    }

    public void exec(C_HnknhkgnKbn pHnknhkgnKbn,
                     BizCurrency pSignUrageGk,
                     String pDensoUriageGk) {
        if (C_HnknhkgnKbn.HNKN.eq(pHnknhkgnKbn)) {
            String tmpStr = pSignUrageGk.toString();

            if (isExistSyousuuten(tmpStr)) {
                errFlag = true;
                return;
            }

            int lstNum = Integer.parseInt(tmpStr.substring(tmpStr.length() - 1));

            if (pSignUrageGk.compareTo(BizCurrency.valueOf(0, pSignUrageGk.getType())) >= 0) {
                for (int loop = 0; loop < 10; loop++) {
                    if (loop == lstNum) {
                        densoUriageGk = plusWords[lstNum];
                        break;
                    }
                }
            }
            else {
                for (int loop = 0; loop < 10; loop++) {
                    if (loop == lstNum) {
                        densoUriageGk = minusWords[lstNum];
                        break;
                    }
                }

                tmpStr = tmpStr.substring(1);
            }

            tmpStr = tmpStr.substring(0, tmpStr.length() - 1);
            densoUriageGk = tmpStr.substring(0, tmpStr.length()) + densoUriageGk;

        }
        else {
            String tmpLstChar = pDensoUriageGk.substring(pDensoUriageGk.length() - 1);

            boolean isPlus = false;
            boolean notExist = true;

            for (int loop = 0; loop < 10; loop++) {
                if (plusWords[loop].toString().equals(tmpLstChar)) {
                    signUrageGk = BizCurrency.
                        valueOf(new BigDecimal(pDensoUriageGk.substring(0, pDensoUriageGk.length() - 1) + loop));
                    notExist = false;
                    isPlus = true;
                    break;
                }
            }

            if (!isPlus) {
                for (int loop = 0; loop < 10; loop++) {
                    if (minusWords[loop].toString().equals(tmpLstChar)) {
                        signUrageGk = BizCurrency.
                            valueOf(new BigDecimal(pDensoUriageGk.substring(0,pDensoUriageGk.length() - 1) + loop)).
                            multiply(-1);
                        notExist = false;
                        break;
                    }
                }
            }

            if (notExist) {
                errFlag = true;
                return;
            }
        }
    }

    private boolean isExistSyousuuten(String pChkStr) {
        for (int loop = 0; loop < pChkStr.length(); loop++) {
            if (".".equals(pChkStr.substring(loop, loop + 1))) {
                return true;
            }
        }
        return false;
    }
}