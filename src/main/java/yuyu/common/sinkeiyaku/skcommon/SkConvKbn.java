package yuyu.common.sinkeiyaku.skcommon;

import javax.inject.Inject;

import org.slf4j.Logger;

import yuyu.def.classification.C_AisyoumeiChannelKbn;
import yuyu.def.classification.C_SkeijimuKbn;

/**
 * 新契約 新契約共通 新契約区分変換処理
 */
public class SkConvKbn {

    @Inject
    private static Logger logger;

    public SkConvKbn() {
        super();
    }

    public C_AisyoumeiChannelKbn getAisyoumeiChannelKbn(C_SkeijimuKbn pSkeiJimuKbn) {

        logger.debug("▽ 愛称名チャネル区分取得 開始");

        C_AisyoumeiChannelKbn aisyoumeiChannelKbn = C_AisyoumeiChannelKbn.BLNK;

        if (C_SkeijimuKbn.SMBC.eq(pSkeiJimuKbn)) {
            aisyoumeiChannelKbn = C_AisyoumeiChannelKbn.SMBC;
        }
        else if (C_SkeijimuKbn.MIZUHO.eq(pSkeiJimuKbn)) {
            aisyoumeiChannelKbn = C_AisyoumeiChannelKbn.MIZUHO;
        }
        else if (C_SkeijimuKbn.SHOP.eq(pSkeiJimuKbn)) {
            aisyoumeiChannelKbn = C_AisyoumeiChannelKbn.SHOP;
        }
        else if ((C_SkeijimuKbn.YUUTYO.eq(pSkeiJimuKbn)) || (C_SkeijimuKbn.NIHONYUUBIN.eq(pSkeiJimuKbn))
            || (C_SkeijimuKbn.KANPOSEIMEI.eq(pSkeiJimuKbn))) {
            aisyoumeiChannelKbn = C_AisyoumeiChannelKbn.YUUSEI;
        }
        else {
            aisyoumeiChannelKbn = C_AisyoumeiChannelKbn.MADOHAN;
        }

        logger.debug("△ 愛称名チャネル区分取得 終了");

        return aisyoumeiChannelKbn;
    }
}
