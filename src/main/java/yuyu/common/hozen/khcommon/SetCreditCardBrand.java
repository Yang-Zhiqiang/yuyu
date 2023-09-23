package yuyu.common.hozen.khcommon;

import javax.inject.Inject;

import org.slf4j.Logger;

import yuyu.def.classification.C_CardBrandKbn;

/**
 * 契約保全 契約保全共通 クレジットカードブランド設定
 */
public class SetCreditCardBrand {

    @Inject
    private static Logger logger;

    public SetCreditCardBrand() {
        super();
    }


    public C_CardBrandKbn exec(String pCardNo) {

        logger.debug("▽ クレジットカードブランド設定 開始");

        String cardNo1 = pCardNo.substring(0,1);

        String cardNo2 = pCardNo.substring(1,2);

        C_CardBrandKbn  cardbrandKbn = null;

        if ("3".equals(cardNo1)) {

            if ("0".equals(cardNo2) || "6".equals(cardNo2) || "8".equals(cardNo2) || "9".equals(cardNo2)) {

                cardbrandKbn = C_CardBrandKbn.DINERS;

            }

            else if ("4".equals(cardNo2) || "7".equals(cardNo2)) {

                cardbrandKbn = C_CardBrandKbn.AMEX;

            }

            else if ("5".equals(cardNo2)) {

                cardbrandKbn = C_CardBrandKbn.JCB;

            }

            else {

                cardbrandKbn = C_CardBrandKbn.SONOTA;

            }

        }

        else if ("4".equals(cardNo1)) {

            cardbrandKbn = C_CardBrandKbn.VISA;

        }

        else if ("5".equals(cardNo1)) {

            cardbrandKbn = C_CardBrandKbn.MASTER;

        }

        else {

            cardbrandKbn = C_CardBrandKbn.SONOTA;

        }

        logger.debug("△ クレジットカードブランド設定 終了");

        return cardbrandKbn;

    }

}