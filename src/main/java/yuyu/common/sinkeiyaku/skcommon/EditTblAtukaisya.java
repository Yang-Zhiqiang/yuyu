package yuyu.common.sinkeiyaku.skcommon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;

import org.slf4j.Logger;

import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.sinkeiyaku.moschk.MosnaiCheckParam;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.HT_MosDairiten;
import yuyu.def.db.entity.HT_SyoriCTL;

/**
 * 新契約 新契約共通 扱者TBL編集
 */
public class EditTblAtukaisya {

    private static final String ALL_ZERO_7 = "0000000";

    private static final String ALL_ZERO_6 = "000000";

    private static final String ALL_ZERO_4 = "0000";

    private static final String BLANK = "";

    public static final String ATUKAISYAJHKEY_RENNO = "01";
    public static final String ATUKAISYAJHKEY_KINYUUCD = "04";
    public static final String ATUKAISYAJHKEY_KINYUUSITENCD = "05";
    public static final String ATUKAISYAJHKEY_DAIRITENCD = "06";
    public static final String ATUKAISYAJHKEY_DAIRITENNM = "07";
    public static final String ATUKAISYAJHKEY_TRATKIAGCD = "08";
    public static final String ATUKAISYAJHKEY_TRATKIAGNM = "09";
    public static final String ATUKAISYAJHKEY_OYADRTENCD = "10";
    public static final String ATUKAISYAJHKEY_OYADRTENNM = "11";
    public static final String ATUKAISYAJHKEY_BOSYUUNINCD = "12";
    public static final String ATUKAISYAJHKEY_BOSYUUTRKNO = "13";
    public static final String ATUKAISYAJHKEY_BOSYUUNINNM = "14";

    @Inject
    private GetDairitenInfo getDairitenInfo;

    @Inject
    private static Logger logger;

    public EditTblAtukaisya() {
        super();
    }

    public ArrayList<Map<String, String>> exec(MosnaiCheckParam pMP) {

        if (logger.isDebugEnabled()) {

            logger.debug("▽ 扱者TBL編集 開始");
        }

        HT_SyoriCTL syoriCTL = pMP.getDataSyoriControl();
        String mosNo = syoriCTL.getMosno();
        C_UmuKbn mosNrkUmu = syoriCTL.getMosnrkumu();
        BizDate mosYmd = syoriCTL.getMosKihon().getMosymd();

        if (logger.isDebugEnabled()) {

            logger.debug("｜ 申込番号 = " + mosNo);
        }

        long renNo = 1;
        String kinyuuCd = ALL_ZERO_4;
        String kinyuuSitenCd = ALL_ZERO_4;
        String dairitenCd = ALL_ZERO_7;
        String dairitenNm = BLANK;
        String tratkiagCd = ALL_ZERO_7;
        String tratkiagNm = BLANK;
        String oyaDrtenCd = ALL_ZERO_7;
        String oyaDrtenNm = BLANK;
        String bosyuuninCd = ALL_ZERO_6;
        String bosyuuTrkNo = BLANK;
        String bosyuuninNm = BLANK;

        ArrayList<Map<String, String>> atukaisyaLst = new ArrayList<>();

        if (mosNrkUmu.eq(C_UmuKbn.ARI)) {

            List<HT_MosDairiten> mosDairitenLst = syoriCTL.getMosDairitens();

            if (mosDairitenLst == null || mosDairitenLst.size() == 0) {

                throw new CommonBizAppException("申込代理店TBLにデータ無（申込番号 = "
                    + mosNo + ")");
            }

            for (HT_MosDairiten mosDairiten : mosDairitenLst) {

                renNo = mosDairiten.getRenno();
                kinyuuCd = mosDairiten.getKinyuucd();
                kinyuuSitenCd = mosDairiten.getKinyuusitencd();
                dairitenCd = mosDairiten.getDrtencd();
                tratkiagCd = mosDairiten.getTratkiagcd();
                oyaDrtenCd = mosDairiten.getOyadrtencd();
                bosyuuTrkNo = mosDairiten.getBosyuutrkno();
                bosyuuninCd = mosDairiten.getBosyuucd();

                getDairitenInfo.exec(tratkiagCd, oyaDrtenCd, bosyuuninCd, mosYmd);
                tratkiagNm = getDairitenInfo.getTratkiagnm();
                oyaDrtenNm = getDairitenInfo.getOyadrtennm();
                bosyuuninNm = getDairitenInfo.getBosyuunm();

                Map<String, String> atukaisyaMap = new HashMap<>();
                atukaisyaMap.put(ATUKAISYAJHKEY_RENNO, String.valueOf(renNo));
                atukaisyaMap.put(ATUKAISYAJHKEY_KINYUUCD, kinyuuCd);
                atukaisyaMap.put(ATUKAISYAJHKEY_KINYUUSITENCD, kinyuuSitenCd);
                atukaisyaMap.put(ATUKAISYAJHKEY_DAIRITENCD, dairitenCd);
                atukaisyaMap.put(ATUKAISYAJHKEY_DAIRITENNM, dairitenNm);
                atukaisyaMap.put(ATUKAISYAJHKEY_TRATKIAGCD, tratkiagCd);
                atukaisyaMap.put(ATUKAISYAJHKEY_TRATKIAGNM, tratkiagNm);
                atukaisyaMap.put(ATUKAISYAJHKEY_OYADRTENCD, oyaDrtenCd);
                atukaisyaMap.put(ATUKAISYAJHKEY_OYADRTENNM, oyaDrtenNm);
                atukaisyaMap.put(ATUKAISYAJHKEY_BOSYUUNINCD, bosyuuninCd);
                atukaisyaMap.put(ATUKAISYAJHKEY_BOSYUUTRKNO, bosyuuTrkNo);
                atukaisyaMap.put(ATUKAISYAJHKEY_BOSYUUNINNM, bosyuuninNm);

                atukaisyaLst.add(atukaisyaMap);

                if (logger.isDebugEnabled()) {

                    logAtukaisyaMap(atukaisyaMap);
                }
            }
        }
        else {

            Map<String, String> atukaisyaMap = new HashMap<>();
            atukaisyaMap.put(ATUKAISYAJHKEY_RENNO, String.valueOf(renNo));
            atukaisyaMap.put(ATUKAISYAJHKEY_KINYUUCD, kinyuuCd);
            atukaisyaMap.put(ATUKAISYAJHKEY_KINYUUSITENCD, kinyuuSitenCd);
            atukaisyaMap.put(ATUKAISYAJHKEY_DAIRITENCD, dairitenCd);
            atukaisyaMap.put(ATUKAISYAJHKEY_DAIRITENNM, dairitenNm);
            atukaisyaMap.put(ATUKAISYAJHKEY_TRATKIAGCD, tratkiagCd);
            atukaisyaMap.put(ATUKAISYAJHKEY_TRATKIAGNM, tratkiagNm);
            atukaisyaMap.put(ATUKAISYAJHKEY_OYADRTENCD, oyaDrtenCd);
            atukaisyaMap.put(ATUKAISYAJHKEY_OYADRTENNM, oyaDrtenNm);
            atukaisyaMap.put(ATUKAISYAJHKEY_BOSYUUNINCD, bosyuuninCd);
            atukaisyaMap.put(ATUKAISYAJHKEY_BOSYUUTRKNO, bosyuuTrkNo);
            atukaisyaMap.put(ATUKAISYAJHKEY_BOSYUUNINNM, bosyuuninNm);

            atukaisyaLst.add(atukaisyaMap);

            if (logger.isDebugEnabled()) {

                logAtukaisyaMap(atukaisyaMap);
            }
        }

        if (logger.isDebugEnabled()) {

            logger.debug("△ 扱者TBL編集 終了");
        }

        return atukaisyaLst;
    }

    private void logAtukaisyaMap(Map<String, String> pAtukaisyaMap) {

        logger.debug("｜ ▽扱者情報");
        logger.debug("｜ 連番 = " + pAtukaisyaMap.get(ATUKAISYAJHKEY_RENNO));
        logger.debug("｜ 金融機関コード =" + pAtukaisyaMap.get(ATUKAISYAJHKEY_KINYUUCD));
        logger.debug("｜ 金融機関支店コード =" + pAtukaisyaMap.get(ATUKAISYAJHKEY_KINYUUSITENCD));
        logger.debug("｜ 代理店コード =" + pAtukaisyaMap.get(ATUKAISYAJHKEY_DAIRITENCD));
        logger.debug("｜ 代理店名 =" + pAtukaisyaMap.get(ATUKAISYAJHKEY_DAIRITENNM));
        logger.debug("｜ 取扱代理店コード =" + pAtukaisyaMap.get(ATUKAISYAJHKEY_TRATKIAGCD));
        logger.debug("｜ 取扱代理店名 =" + pAtukaisyaMap.get(ATUKAISYAJHKEY_TRATKIAGNM));
        logger.debug("｜ 親代理店コード =" + pAtukaisyaMap.get(ATUKAISYAJHKEY_OYADRTENCD));
        logger.debug("｜ 親代理店名 =" + pAtukaisyaMap.get(ATUKAISYAJHKEY_OYADRTENNM));
        logger.debug("｜ 募集人コード =" + pAtukaisyaMap.get(ATUKAISYAJHKEY_BOSYUUNINCD));
        logger.debug("｜ 募集人登録番号 =" + pAtukaisyaMap.get(ATUKAISYAJHKEY_BOSYUUTRKNO));
        logger.debug("｜ 募集人名 =" + pAtukaisyaMap.get(ATUKAISYAJHKEY_BOSYUUNINNM));
        logger.debug("｜ △");
    }
}
