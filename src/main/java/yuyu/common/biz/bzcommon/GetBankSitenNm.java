package yuyu.common.biz.bzcommon;

import javax.inject.Inject;

import jp.co.slcs.swak.util.string.ConvertUtil;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.db.entity.BM_Ginkou;

/**
 * 業務共通 共通 銀行名支店名取得
 */
public class GetBankSitenNm {

    private static final String BANKCD_YUUTYO = IGkCommonKoumoku.BANKCD_YTGINKOU ;

    private static final String BANKNM_YUUTYO = "ゆうちょ銀行";

    private static final String BANKNM_KN_YUUTYO = "ユウチョギンコウ";

    private static final String BANKNM_HANKN_YUUTYO = "ﾕｳﾁｮｷﾞﾝｺｳ";

    private static final String BLANK = "";

    private C_ErrorKbn errorKbn;

    private String bankNmKj;

    private String sitenNmKj;

    private String bankNmKn;

    private String sitenNmKn;

    private String bankNmHanKn;

    private String sitenNmHanKn;

    @Inject
    private BizDomManager bizDomManager;

    public GetBankSitenNm() {
        super();
    }

    public C_ErrorKbn getErrorKbn() {
        return errorKbn;
    }

    public String getBankNmKj() {
        return bankNmKj;
    }

    public String getSitenNmKj() {
        return sitenNmKj;
    }

    public String getBankNmKn() {
        return bankNmKn;
    }

    public String getSitenNmKn() {
        return sitenNmKn;
    }

    public String getBankNmHnkakuKn() {
        return bankNmHanKn;
    }

    public String getSitenNmHnkakuKn() {
        return sitenNmHanKn;
    }

    public void exec(String pBankcd, String pSitencd)  {

        if (BANKCD_YUUTYO.equals(pBankcd)) {

            String sitenNm = "1" + pSitencd + "0";

            errorKbn = C_ErrorKbn.OK;

            bankNmKj = BANKNM_YUUTYO;

            sitenNmKj = ConvertUtil.toZenAll(sitenNm, 0, 1);

            bankNmKn = BANKNM_KN_YUUTYO;

            sitenNmKn = ConvertUtil.toZenAll(sitenNm, 0, 1);

            bankNmHanKn = BANKNM_HANKN_YUUTYO;

            sitenNmHanKn = sitenNm;
        }
        else {

            BM_Ginkou ginkou = bizDomManager.getGinkou(pBankcd, pSitencd);

            if (ginkou == null) {

                errorKbn = C_ErrorKbn.ERROR;

                bankNmKj = BLANK;

                sitenNmKj = BLANK;

                bankNmKn = BLANK;

                sitenNmKn = BLANK;

                bankNmHanKn = BLANK;

                sitenNmHanKn = BLANK;
            }
            else {

                errorKbn = C_ErrorKbn.OK;

                bankNmKj = ginkou.getBanknmkj();

                sitenNmKj = ginkou.getSitennmkj();

                bankNmKn = ginkou.getBanknmkn();

                sitenNmKn = ginkou.getSitennmkn();

                bankNmHanKn = ConvertUtil.toHanAll(bankNmKn, 0, 0);

                sitenNmHanKn = ConvertUtil.toHanAll(sitenNmKn, 0, 0);

            }
        }
    }
}