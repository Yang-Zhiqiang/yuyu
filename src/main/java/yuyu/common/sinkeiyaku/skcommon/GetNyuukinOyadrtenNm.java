package yuyu.common.sinkeiyaku.skcommon;


/**
 * 新契約 新契約共通 入金用親代理店名取得
 */
public class GetNyuukinOyadrtenNm {

    private final String OYADRTENCD_SMBCTIGIN = "9999980";

    private final String OYADRTENCD_SIZUOKA = "5200015";

    private final String OYADRTENCD_FUKUOKA = "5200007";

    private final String OYADRTENCD_KUMAMOTO = "5302555";

    private final String OYADRTENCD_SINWA = "5206170";

    private final String OYADRTENNM_SMBCTIGIN = "ＳＭＢＣ・地方銀行";

    private final String OYADRTENNM_SIZUOKA = "静岡銀行";

    private final String OYADRTENNM_FUKUOKA = "福岡銀行";

    private final String OYADRTENNM_KUMAMOTO ="熊本銀行";

    private final String OYADRTENNM_SINWA ="親和銀行";

    public GetNyuukinOyadrtenNm() {
        super();
    }

    public String exec(String oyadrtencd) {

        String nyuukinoyadrtennm = "";

        if (OYADRTENCD_SMBCTIGIN.equals(oyadrtencd)) {
            nyuukinoyadrtennm = OYADRTENNM_SMBCTIGIN;
        }
        else if (OYADRTENCD_SIZUOKA.equals(oyadrtencd)) {
            nyuukinoyadrtennm = OYADRTENNM_SIZUOKA;
        }
        else if (OYADRTENCD_FUKUOKA.equals(oyadrtencd)) {
            nyuukinoyadrtennm = OYADRTENNM_FUKUOKA;
        }
        else if (OYADRTENCD_KUMAMOTO.equals(oyadrtencd)) {
            nyuukinoyadrtennm = OYADRTENNM_KUMAMOTO;
        }
        else if (OYADRTENCD_SINWA.equals(oyadrtencd)) {
            nyuukinoyadrtennm = OYADRTENNM_SINWA;
        }
        else {
            nyuukinoyadrtennm = "";
        }

        return nyuukinoyadrtennm;
    }
}
