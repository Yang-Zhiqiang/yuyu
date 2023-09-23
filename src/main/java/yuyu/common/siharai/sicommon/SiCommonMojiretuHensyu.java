package yuyu.common.siharai.sicommon;

import javax.inject.Inject;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import yuyu.def.MessageId;
import jp.co.slcs.swak.date.BizDateFormat;
import jp.co.slcs.swak.date.BizDateFormat.FillStyle;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.util.message.MessageUtil;

/**
 * 保険金給付金支払 保険金給付金支払共通 保険金給付金共通文字列編集
 */
public class SiCommonMojiretuHensyu {

    @Inject
    private static Logger logger;

    public String editPGaitoukkn(BizDateYM pJyuutouym, Integer pJyutouKaisuuY, Integer pJyutouKaisuuM) {

        logger.debug("▽ 保険金給付金共通文字列編集 開始");

        String yuupgaitoukkn = null;

        if ((pJyuutouym == null || pJyutouKaisuuY == null || pJyutouKaisuuM == null)) {

            logger.debug("△ 保険金給付金共通文字列編集 終了");

            return yuupgaitoukkn;
        }
        if (pJyutouKaisuuY == 0 && pJyutouKaisuuM == 0) {

            logger.debug("△ 保険金給付金共通文字列編集 終了");

            return yuupgaitoukkn;
        }

        BizDateFormat dateFormat = new BizDateFormat("yyyy/MM", FillStyle.Zero);

        String jyuutouym = dateFormat.format(pJyuutouym);

        if (pJyutouKaisuuY != 0 && pJyutouKaisuuM != 0) {

            String jyutouKaisuuY = StringUtils.leftPad(String.valueOf(pJyutouKaisuuY), 2);

            String jyutouKaisuuM = StringUtils.leftPad(String.valueOf(pJyutouKaisuuM), 2);

            yuupgaitoukkn = MessageUtil.getMessage(MessageId.IJA1001, jyuutouym, jyutouKaisuuY, jyutouKaisuuM);
        }
        else if (pJyutouKaisuuY != 0 && pJyutouKaisuuM == 0) {

            String jyutouKaisuuY = StringUtils.leftPad(String.valueOf(pJyutouKaisuuY), 2);

            yuupgaitoukkn = MessageUtil.getMessage(MessageId.IJA1002, jyuutouym, jyutouKaisuuY);
        }
        else if (pJyutouKaisuuY == 0 && pJyutouKaisuuM != 0) {

            String jyutouKaisuuM = StringUtils.leftPad(String.valueOf(pJyutouKaisuuM), 2);

            yuupgaitoukkn = MessageUtil.getMessage(MessageId.IJA1003, jyuutouym, jyutouKaisuuM);
        }

        logger.debug("△ 保険金給付金共通文字列編集 終了");

        return yuupgaitoukkn;
    }
}
