package yuyu.common.hozen.ascommon;

import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateSpan;
import jp.co.slcs.swak.number.BizNumber;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.hozen.ascommon.dba4getzennoukikanriritu2.GetZennouKikanRiritu2Dao;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_ZennouTumitateRitu2;

/**
 * 契約保全 案内収納共通 前納期間利率取得処理２
 */
public class GetZennouKikanRiritu2 {

    private BizNumber zennouKikanRiritu;

    private List<BizDate> zennouTmttrituHnkbiList;

    private List<BizNumber> newZennouTmttrituList;

    @Inject
    private static Logger logger;

    @Inject
    private GetZennouKikanRiritu2Dao getZennouKikanRiritu2Dao;

    public GetZennouKikanRiritu2() {
        super();
    }

    public C_ErrorKbn exec(C_Tuukasyu pTuukasyu, BizDate pKikanfrom, BizDate pKikanto, BizDate pKykYmd) {

        logger.debug("▽ 前納期間利率取得処理２ 開始");

        C_ErrorKbn errorKbn = C_ErrorKbn.OK;

        if (BizDateUtil.compareYmd(pKikanfrom, pKikanto) == BizDateUtil.COMPARE_GREATER) {

            logger.info("前納期間利率取得処理エラー。期間自が期間至より未来になっています。");

            errorKbn = C_ErrorKbn.ERROR;

            return errorKbn;
        }

        BizDateSpan dateSpan = BizDateUtil.calcDifference(pKikanfrom, pKikanto);

        Integer keikatukisuu = dateSpan.getYears() * 12 + dateSpan.getMonths();
        Integer keikanisuu = dateSpan.getDays();

        if (keikanisuu > 15) {
            keikatukisuu = keikatukisuu + 1;
        }

        if (keikatukisuu > 12) {
            logger.info("前納期間利率取得処理エラー。経過月数が１３ヶ月以上となっています。");

            errorKbn = C_ErrorKbn.ERROR;

            return errorKbn;
        }

        BizNumber goukeikikanriritu = BizNumber.ZERO;
        BizDate tekiyoukknfrom = pKikanfrom;

        List<BM_ZennouTumitateRitu2> zennouTumitateRitu2List =
            getZennouKikanRiritu2Dao.getZennouTumitateRitu2s(pTuukasyu, pKikanfrom);

        if (zennouTumitateRitu2List.size() == 0) {
            logger.info("前納期間利率取得処理エラー。前納積立率マスタにデータが存在しません。");

            errorKbn = C_ErrorKbn.ERROR;

            return errorKbn;
        }

        BM_ZennouTumitateRitu2 zennouTumitateRitu2 = zennouTumitateRitu2List.get(0);

        zennouTmttrituHnkbiList = new ArrayList<>();
        newZennouTmttrituList = new ArrayList<>();

        while (!BizDate.MAX_VALUE.toString().equals(zennouTumitateRitu2.getTekiyoukknkto())) {

            BizDate nextTekiyoukknfrom = BizDate.valueOf(zennouTumitateRitu2.getTekiyoukknkto()).addDays(1);

            BizDate tekiyoukknkto = null;

            if (nextTekiyoukknfrom.getDay() <= pKykYmd.getDay()) {

                tekiyoukknkto = BizDate.valueOf(nextTekiyoukknfrom.getBizDateYM(), pKykYmd.getDay()).getRekijyou();
            }
            else {
                tekiyoukknkto = BizDate.valueOf(nextTekiyoukknfrom.getBizDateYM().addMonths(1),
                    pKykYmd.getDay()).getRekijyou();
            }

            if (BizDateUtil.compareYmd(tekiyoukknkto, pKikanto) == BizDateUtil.COMPARE_GREATER) {

                break;
            }

            dateSpan = BizDateUtil.calcDifference(tekiyoukknfrom, tekiyoukknkto);

            keikatukisuu = dateSpan.getYears() * 12 + dateSpan.getMonths();

            keikanisuu = dateSpan.getDays();

            if (keikanisuu > 15) {
                keikatukisuu = keikatukisuu + 1;
            }

            BizNumber kbtkknririyu = zennouTumitateRitu2.getZennoutumitateritu().multiply(keikatukisuu);

            goukeikikanriritu = goukeikikanriritu.add(kbtkknririyu);

            if (BizDateUtil.compareYmd(tekiyoukknfrom, pKikanfrom) != BizDateUtil.COMPARE_EQUAL) {

                zennouTmttrituHnkbiList.add(tekiyoukknfrom);
                newZennouTmttrituList.add(zennouTumitateRitu2.getZennoutumitateritu());
            }

            zennouTumitateRitu2List = getZennouKikanRiritu2Dao.getZennouTumitateRitu2s(pTuukasyu, tekiyoukknkto);

            if (zennouTumitateRitu2List.size() == 0) {

                logger.info("前納期間利率取得処理エラー。前納積立率マスタにデータが存在しません。");

                errorKbn = C_ErrorKbn.ERROR;

                return errorKbn;
            }

            zennouTumitateRitu2 = zennouTumitateRitu2List.get(0);

            tekiyoukknfrom = tekiyoukknkto;
        }

        dateSpan = BizDateUtil.calcDifference(tekiyoukknfrom, pKikanto);

        keikatukisuu = dateSpan.getYears() * 12 + dateSpan.getMonths();

        keikanisuu = dateSpan.getDays();

        if (keikanisuu > 15) {
            keikatukisuu = keikatukisuu + 1;
        }

        BizNumber kbtkknririyu = zennouTumitateRitu2.getZennoutumitateritu().multiply(keikatukisuu);

        goukeikikanriritu = goukeikikanriritu.add(kbtkknririyu);

        if (BizDateUtil.compareYmd(tekiyoukknfrom, pKikanfrom) != BizDateUtil.COMPARE_EQUAL) {

            zennouTmttrituHnkbiList.add(tekiyoukknfrom);
            newZennouTmttrituList.add(zennouTumitateRitu2.getZennoutumitateritu());
        }

        zennouKikanRiritu = goukeikikanriritu.divide(12, 10, RoundingMode.DOWN);

        logger.debug("△ 前納期間利率取得処理２ 終了");

        return errorKbn;
    }

    public BizNumber getZennouKikanRiritu() {
        return zennouKikanRiritu;
    }

    public List<BizDate> getZennouTmttrituHnkbiList() {
        return zennouTmttrituHnkbiList;
    }

    public List<BizNumber> getNewZennouTmttrituList() {
        return newZennouTmttrituList;
    }
}

