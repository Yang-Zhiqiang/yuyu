package yuyu.common.direct.dscommon;

import javax.inject.Inject;

import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.util.message.MessageUtil;
import org.slf4j.Logger;

import yuyu.def.MessageId;

/**
 * ダイレクトサービス ダイレクトサービス共通 ＤＳ顧客番号スクランブル化処理
 */
public class DsKokyakunoScrambleSyori {

    private static final int SAIDAIKETASUU = 10;

    private static final String DSKOKNOPATTERN = "^\\d{10}$";

    private static final String HENKANKETASYURUIMASK = "1111000000";

    private static final String[] HENKANS_ZURENASI = new String[]{"0","1","2","3","4","5","6","7","8","9"};

    private static final String[] HENKANS_ITIZURE = new String[]{"1","2","3","4","5","6","7","8","9","0"};

    @Inject
    private static Logger logger;

    public DsKokyakunoScrambleSyori() {
        super();
    }

    public String exec(String pDsKokNo) {

        logger.debug("▽ ＤＳ顧客番号スクランブル化処理 開始");

        if (pDsKokNo == null) {

            throw new BizAppException(MessageId.EBF0129, MessageUtil.getMessage(MessageId.EMW1012));
        }

        String dsKokNo = pDsKokNo;

        StringBuilder scrambleAtoDsKokNo = new StringBuilder();
        int matubiIndex = SAIDAIKETASUU - 1;

        if (dsKokNo.matches(DSKOKNOPATTERN)) {

        }
        else {

            throw new BizAppException(MessageId.EBF0129, MessageUtil.getMessage(MessageId.EMW1012));
        }

        for (int index = 0; index < SAIDAIKETASUU; index++) {

            int henkanMaeMoji = dsKokNo.charAt(matubiIndex - index) - '0';

            char henkanPattern = HENKANKETASYURUIMASK.charAt(index);

            String henkanAtoMoji = "";

            if (henkanPattern == '1') {

                henkanAtoMoji = HENKANS_ITIZURE[henkanMaeMoji];
            }
            else {

                henkanAtoMoji = HENKANS_ZURENASI[henkanMaeMoji];
            }

            scrambleAtoDsKokNo.append(henkanAtoMoji);
        }

        logger.debug("△ ＤＳ顧客番号スクランブル化処理 終了");

        return scrambleAtoDsKokNo.toString();
    }
}
