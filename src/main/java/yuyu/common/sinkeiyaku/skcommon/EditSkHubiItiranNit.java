package yuyu.common.sinkeiyaku.skcommon;

import java.io.UnsupportedEncodingException;

import javax.inject.Inject;

import org.slf4j.Logger;
import yuyu.common.biz.exception.CommonBizAppException;

/**
 * 新契約 新契約共通 新契約不備一覧（ＮＩＴ）編集
 */
public class EditSkHubiItiranNit {

    public static final int BYTE = 400;

    public static final int MAXLINECNT = 10;

    public static final String CODE = "SHIFT_JIS";

    public static final String KAIGYOU_RN = "\r\n";

    public static final String KAIGYOU_R = "\r";

    public static final String[] MDS_HUBIRENRAKUS = { "＜＜不備連絡１＞＞", "＜＜不備連絡２＞＞", "＜＜不備連絡３＞＞",
        "＜＜不備連絡４＞＞", "＜＜不備連絡５＞＞" };

    public static final String MDS_SKHUBIKOUMOKU = "【区分】";

    public static final String MDS_SKHUBINAIYOU = "【理由】";

    public static final String MDS_SKSEIBISIJINAIYOU = "【依頼内容】";

    public static final String MDS_SKRENRAKUJIKOU = "【連絡事項】";

    private int count = 0;

    private String[] hubijks = { "", "", "", "", "" };

    @Inject
    private static Logger logger;

    public EditSkHubiItiranNit() {
        super();
    }

    public String[] getHubijks() {

        return hubijks;
    }

    public boolean editSkHubiItiran(
        int pIdx,
        String pSkhubikoumoku,
        String pSkhubinaiyou,
        String pSkseibisijinaiyou,
        String pSkrenrakujikou) {

        logger.debug("▽ 新契約不備一覧編集 開始");

        try {
            if (pIdx > 4 || count > 4) {

                logger.debug("△ 新契約不備一覧編集 終了");
                return false;
            }

            boolean keizokuEditKahi = true;
            int byteSuu = 0;
            int linecnt = 1;
            int i = 0;
            boolean flg = false;
            String str27keta = "";
            String strmatu = "";

            StringBuffer objectStr = new StringBuffer();
            String hubiRenraku = MDS_HUBIRENRAKUS[pIdx]
                + KAIGYOU_RN
                + MDS_SKHUBIKOUMOKU
                + pSkhubikoumoku
                + MDS_SKHUBINAIYOU
                + pSkhubinaiyou
                + MDS_SKSEIBISIJINAIYOU
                + pSkseibisijinaiyou
                + KAIGYOU_RN
                + MDS_SKRENRAKUJIKOU
                + pSkrenrakujikou;

            for (; i < hubiRenraku.length();) {

                if (count > 4) {

                    keizokuEditKahi = false;

                    logger.debug("△ 新契約不備一覧編集 終了");
                    return keizokuEditKahi;
                }

                if (str27keta.getBytes(CODE).length >= 54 ||
                    KAIGYOU_RN.equals(strmatu)) {
                    linecnt = linecnt + 1;
                    if (linecnt > MAXLINECNT) {
                        flg = true;
                    }
                    str27keta = "";
                    strmatu = "";
                }

                String nukidasiStr = "";
                if (KAIGYOU_R.equals(hubiRenraku.substring(i, i + 1))) {
                    nukidasiStr = hubiRenraku.substring(i, i + 2);
                    strmatu = hubiRenraku.substring(i, i + 2);
                    i = i + 2;
                }
                else {
                    nukidasiStr = hubiRenraku.substring(i, i + 1);
                    i = i + 1;
                }

                int nukidasuByteSuu = nukidasiStr.getBytes(CODE).length;

                if (byteSuu + nukidasuByteSuu > BYTE) {
                    flg = true;
                }

                if (flg) {

                    hubijks[count] = objectStr.toString();

                    count = count + 1;

                    byteSuu = nukidasuByteSuu;

                    objectStr = new StringBuffer();

                    objectStr.append(nukidasiStr);

                    linecnt = 1;

                    flg = false;

                    str27keta = "";
                }
                else {

                    objectStr.append(nukidasiStr);

                    byteSuu = byteSuu + nukidasuByteSuu;

                    str27keta = str27keta + nukidasiStr;
                }
            }

            if (byteSuu > 0) {
                if (count > 4) {
                    keizokuEditKahi = false;

                }
                else {
                    hubijks[count] = objectStr.toString();

                    count = count + 1;
                }

            }

            logger.debug("△ 新契約不備一覧編集 終了");

            return keizokuEditKahi;

        } catch (UnsupportedEncodingException e) {

            throw new CommonBizAppException("文字のエンコーディングがサポートされていません。文字コード＝" + CODE);
        }
    }
}
