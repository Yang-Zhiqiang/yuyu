package yuyu.common.hozen.khcommon.dba4editkoujyonaiyoutbl;

import java.io.Serializable;
import java.math.BigDecimal;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.BizCurrencySum;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_KoujyosyoumeipKbn;

/**
 * 契約保全 契約保全共通 入金時控除証明内容情報Bean
 */
public class NyknjiKoujyoSymNaiyouBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private String syono;

    @Getter @Setter
    private String syouhncd;

    @Getter @Setter
    private String koujyosyoumeinnd;

    @Getter @Setter
    private BizDateYM syoumeistartym;

    @Getter @Setter
    private BizDateYM syoumeiendym;

    @Getter @Setter
    private C_KoujyosyoumeipKbn koujyosyoumeipkbn;

    @Getter @Setter
    private BizCurrency koujyosyoumeigk;

    @Getter @Setter
    private BizDate zennoukaisiymd;

    @Getter @Setter
    private Integer zennourenno;

    @Getter @Setter
    private BizDateYM jyutoustartym;

    @Getter @Setter
    private BizDateYM jyutouendym;

    @Getter @Setter
    private C_Hrkkaisuu hrkkaisuu;

    public NyknjiKoujyoSymNaiyouBean() {
    }


    public NyknjiKoujyoSymNaiyouBean(String pSyono,
        String pSyouhncd,
        String pKoujyosyoumeinnd,
        BizDateYM pSyoumeistartym,
        BizDateYM pSyoumeiendym,
        C_KoujyosyoumeipKbn pKoujyosyoumeipkbn,
        String pKoujyosyoumeigkType,
        BigDecimal pKoujyosyoumeigkValue,
        BizDate pZennoukaisiymd,
        Integer pZennourenno,
        BizDateYM pJyutoustartym,
        BizDateYM pJyutouendym,
        C_Hrkkaisuu pHrkkaisuu) {

        syono = pSyono;
        syouhncd = pSyouhncd;
        koujyosyoumeinnd = pKoujyosyoumeinnd;
        syoumeistartym = pSyoumeistartym;
        syoumeiendym = pSyoumeiendym;
        koujyosyoumeipkbn = pKoujyosyoumeipkbn;
        koujyosyoumeigk = new BizCurrencySum(pKoujyosyoumeigkType, pKoujyosyoumeigkValue).toBizCurrency();
        zennoukaisiymd = pZennoukaisiymd;
        zennourenno = pZennourenno;
        jyutoustartym = pJyutoustartym;
        jyutouendym = pJyutouendym;
        hrkkaisuu = pHrkkaisuu;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}
