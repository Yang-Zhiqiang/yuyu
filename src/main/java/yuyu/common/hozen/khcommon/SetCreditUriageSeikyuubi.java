package yuyu.common.hozen.khcommon;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.date.CHolidayAdjustingMode;

import org.slf4j.Logger;

/**
 * 契約保全 契約保全共通 クレカ売上請求日設定
 */
public class SetCreditUriageSeikyuubi {

    @Inject
    private static Logger logger;

    private BizDate jikaiUrsktysytbi;

    private BizDate zenkaiUrskbi;

    private BizDate jikaiUrskbi;

    private BizDate jikaiUrskKekHaneibi;

    public SetCreditUriageSeikyuubi() {
        super();
    }

    public void exec(BizDate pCalckijyunYmd) {

        logger.debug("▽ クレカ売上請求日設定 開始");

        jikaiUrsktysytbi = null;

        zenkaiUrskbi = null;

        jikaiUrskbi = null;

        jikaiUrskKekHaneibi = null;

        BizDateYM calcKijyunYm = pCalckijyunYmd.getBizDateYM();

        BizDateYM calcKijyunYmZengetu = calcKijyunYm.addMonths(-1);

        BizDateYM calcKijyunYmYokugetu = calcKijyunYm.addMonths(1);

        BizDate kjmUrsktysytbi = null;

        BizDate kjmYokugetuUrsktysytbi = null;

        BizDate kjmUrskbi = null;

        BizDate kjmZengetuUrskbi = null;

        BizDate kjmYokugetuUrskbi = null;

        BizDate kjmUrskKekHaneibi = null;

        BizDate kjmYokugetuUrskKekHaneibi = null;

        BizDate kjmUrskbiEigyoubi = null;

        BizDate kjmYokugetuUrskbiEigyoubi = null;

        kjmUrskbi = BizDate.valueOf(calcKijyunYm, 15);

        kjmUrskbiEigyoubi = kjmUrskbi.getBusinessDay(CHolidayAdjustingMode.NEXT);

        kjmUrsktysytbi = kjmUrskbiEigyoubi.addBusinessDays(-3);

        kjmYokugetuUrskbi = BizDate.valueOf(calcKijyunYmYokugetu, 15);

        kjmYokugetuUrskbiEigyoubi = kjmYokugetuUrskbi.getBusinessDay(CHolidayAdjustingMode.NEXT);

        kjmYokugetuUrsktysytbi = kjmYokugetuUrskbiEigyoubi.addBusinessDays(-3);

        if (pCalckijyunYmd.compareTo(kjmUrsktysytbi) <= 0) {

            jikaiUrsktysytbi = kjmUrsktysytbi;
        }
        else {

            jikaiUrsktysytbi = kjmYokugetuUrsktysytbi;
        }

        kjmZengetuUrskbi = BizDate.valueOf(calcKijyunYmZengetu, 15);

        if (pCalckijyunYmd.compareTo(kjmUrskbi) <= 0) {

            zenkaiUrskbi = kjmZengetuUrskbi;

            jikaiUrskbi = kjmUrskbi;
        }
        else {

            zenkaiUrskbi = kjmUrskbi;

            jikaiUrskbi = kjmYokugetuUrskbi;
        }

        kjmUrskKekHaneibi = kjmUrskbiEigyoubi;

        kjmYokugetuUrskKekHaneibi = kjmYokugetuUrskbiEigyoubi;

        if (pCalckijyunYmd.compareTo(kjmUrskKekHaneibi) <= 0) {

            jikaiUrskKekHaneibi = kjmUrskKekHaneibi;
        }
        else {

            jikaiUrskKekHaneibi = kjmYokugetuUrskKekHaneibi;
        }

        logger.debug("△ クレカ売上請求日設定 終了");
    }

    public BizDate getJikaiUrsktysytbi() {

        return jikaiUrsktysytbi;
    }

    public BizDate getZenkaiUrskbi() {

        return zenkaiUrskbi;
    }

    public BizDate getJikaiUrskbi() {

        return jikaiUrskbi;
    }

    public BizDate getJikaiUrskKekHaneibi() {

        return jikaiUrskKekHaneibi;
    }
}
