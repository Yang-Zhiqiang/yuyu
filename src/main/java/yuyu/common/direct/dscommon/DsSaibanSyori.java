package yuyu.common.direct.dscommon;

import javax.inject.Inject;

import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.sequence.RenbanUtil;
import jp.co.slcs.swak.util.message.MessageUtil;

import org.slf4j.Logger;

import yuyu.def.MessageId;
import yuyu.def.biz.configuration.YuyuBizConfig;
import yuyu.def.classification.C_NosyuruiKbn;

/**
 * ダイレクト ダイレクト共通 ＤＳ採番処理クラス
 */
public class DsSaibanSyori {

    @Inject
    private static Logger logger;

    private static final C_NosyuruiKbn NOSYURUI_DS_KOKYAKUNO = C_NosyuruiKbn.DS_KOKYAKUNO;

    private static final C_NosyuruiKbn NOSYURUI_DS_HENKOUSIKIBETUKEY = C_NosyuruiKbn.DS_HENKOUSIKIBETUKEY;

    private static final C_NosyuruiKbn NOSYURUI_DS_SOUSINNORENBAN = C_NosyuruiKbn.DS_SOUSINNORENNO;

    private static final C_NosyuruiKbn NOSYURUI_DS_SOUSINNORENBAN_REALTIMEMAIL = C_NosyuruiKbn.DS_SOUSINNORENNO_REALTIMEMAIL;

    private static final C_NosyuruiKbn NOSYURUI_DS_TETUZUKISIKIBETUID = C_NosyuruiKbn.DS_TETUZUKISIKIBETUID;

    private static final int RETRY_COUNT = 10000;

    private static final int FIRST_CORRECTION = 800000000;

    private static final int CHECK_DIGITALERROR = -999;

    private static final int[] WEIGHT = { 3, 1, 3, 1, 3, 1, 3, 1, 3 };

    private static final long[] WEIGHT2 = { 1, 10, 100, 1000, 10000, 100000, 1000000, 10000000 };

    private static final long ERROR_DS_KOKYAKUNO = -1;

    public DsSaibanSyori() {
        super();
    }

    public String saibanDsKokno() {

        logger.debug("▽ ＤＳ採番処理 ＤＳ顧客番号採番 開始");

        int count = 1;
        long dsKokno = 0L;

        for (count = 1; count <= RETRY_COUNT; count++) {

            long dsKoknoCheckNasi = FIRST_CORRECTION
                + RenbanUtil.getRenban(Integer.parseInt(NOSYURUI_DS_KOKYAKUNO.getValue()));

            int checkDigit = calcCheckDigit(dsKoknoCheckNasi);

            if (checkDigit < 0) {

                throw new BizAppException(MessageId.EBF0129, MessageUtil.getMessage(MessageId.EMW1009));
            }

            dsKokno = dsKoknoCheckNasi * 10 + checkDigit;

            boolean iminoNasi = checkIminoNasi(dsKokno);

            if (iminoNasi) {

                logger.debug("△ ＤＳ採番処理 ＤＳ顧客番号採番 終了");
                return String.valueOf(dsKokno);
            }

            iminoNasi = checkIminoNasi(dsKoknoCheckNasi);
            if (iminoNasi) {
            }
            else {
                skipImino(dsKoknoCheckNasi);
            }
        }

        throw new BizAppException(MessageId.EBF0129, MessageUtil.getMessage(MessageId.EMW1009));
    }

    public String saibanDsHenkouSikibetukey() {

        logger.debug("▽ ＤＳ採番処理 ＤＳ変更識別キー採番 開始");

        String renbanResult = RenbanUtil.getRenbanAsString(Integer.parseInt(NOSYURUI_DS_HENKOUSIKIBETUKEY.getValue()));

        logger.debug("△ ＤＳ採番処理 ＤＳ変更識別キー採番 終了");

        return renbanResult;
    }

    public String saibanDsSousinNoRenban() {

        logger.debug("▽ ＤＳ採番処理 ＤＳ送信番号連番採番 開始");

        String renbanResult = RenbanUtil.getRenbanAsString(Integer.parseInt(NOSYURUI_DS_SOUSINNORENBAN.getValue()));

        logger.debug("△ ＤＳ採番処理 ＤＳ送信番号連番採番 終了");

        return renbanResult;
    }
    public String saibanRealTimeMailDsSousinNoRenban(String pKey) {

        logger.debug("▽ ＤＳ採番処理 リアルタイムメールＤＳ送信番号連番採番 開始");

        String renbanResult = RenbanUtil.getRenbanAsString(Integer.parseInt(NOSYURUI_DS_SOUSINNORENBAN_REALTIMEMAIL.
            getValue()), pKey);

        logger.debug("△ ＤＳ採番処理 リアルタイムメールＤＳ送信番号連番採番 終了");

        return renbanResult;
    }

    public String saibanDsTetuzukiSikibetuId(BizDate pDate) {

        logger.debug("▽ ＤＳ採番処理 ＤＳ手続識別ＩＤ採番 開始");

        String date = String.valueOf(pDate);

        String renbanResult = date.substring(2, 8)  + RenbanUtil.getRenbanAsString(Integer.parseInt(NOSYURUI_DS_TETUZUKISIKIBETUID.
            getValue()), date);

        logger.debug("△ ＤＳ採番処理 ＤＳ手続識別ＩＤ採番 終了");

        return renbanResult;
    }

    private int calcCheckDigit(long pDsKoknoCheckNasi) {

        int weightCount = 9;
        long remainder = 0L;
        long quotient = pDsKoknoCheckNasi;
        long total = 0L;
        Long checkDigit = 0L;

        if (String.valueOf(pDsKoknoCheckNasi).length() != 9) {

            return CHECK_DIGITALERROR;
        }

        while (weightCount > 0) {

            weightCount = weightCount - 1;
            remainder = quotient % 10;
            quotient = quotient / 10;
            total = total + remainder * WEIGHT[weightCount];
        }

        checkDigit = total % 10;

        return checkDigit.intValue();
    }

    private boolean checkIminoNasi(long pDsKokno) {

        String objectStr = String.valueOf(pDsKokno);

        boolean result = objectStr.matches(YuyuBizConfig.getInstance().getImiBangouChkPtn());

        if (result) {

            return false;
        }

        return true;
    }

    private void skipImino(long pDsKokno) {

        long skipWeight = 0L;
        long syou = 0L;
        long koknoKouho = 0L;
        long newDsKokno = ERROR_DS_KOKYAKUNO;
        boolean syoriErrorFlag = true;

        for (int i = 0; i < 8; i++) {
            skipWeight = WEIGHT2[i];
            syou = pDsKokno / skipWeight;
            koknoKouho = syou * skipWeight;

            for (int k = 0; k < 9; k++) {
                koknoKouho = koknoKouho + skipWeight;

                boolean iminoNasi = checkIminoNasi(koknoKouho);

                if (iminoNasi) {
                    newDsKokno = koknoKouho;
                    syoriErrorFlag = false;
                    break;
                }
            }

            if (!syoriErrorFlag) {
                break;
            }

        }

        long skipNumber = newDsKokno - pDsKokno -1;

        if (skipNumber > 0) {
            RenbanUtil.getRenbans(new Long(skipNumber).intValue(),Integer.parseInt(NOSYURUI_DS_KOKYAKUNO.getValue()));
        }

    }

}
