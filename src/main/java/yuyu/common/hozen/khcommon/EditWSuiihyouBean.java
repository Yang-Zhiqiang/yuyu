package yuyu.common.hozen.khcommon;

import yuyu.def.classification.C_MvaTekiyoujyoutaiKbn;
import lombok.Getter;
import lombok.Setter;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;

/**
 * 契約保全 契約保全共通 解約返戻金推移表編集用Bean
 */
public class EditWSuiihyouBean {

    @Getter@Setter
    private BizCurrency kihrkmPStgk = BizCurrency.valueOf(0);

    @Getter@Setter
    private BizCurrency kaiyakuHrKngak = BizCurrency.valueOf(0);

    @Getter@Setter
    private BizCurrency tmttKngk = BizCurrency.valueOf(0);

    @Getter@Setter
    private C_MvaTekiyoujyoutaiKbn mvaTekiyoujyoutaiKbn = C_MvaTekiyoujyoutaiKbn.MVANONE;

    @Getter@Setter
    private BizNumber sisuuupritu = BizNumber.ZERO;

    @Getter@Setter
    private BizNumber tmttknzoukaritu = BizNumber.ZERO;

    @Getter@Setter
    private BizNumber sjkkktusirrtUp = BizNumber.ZERO;

    @Getter@Setter
    private BizNumber sjkkktusirrtSame = BizNumber.ZERO;

    @Getter@Setter
    private BizNumber sjkkktusirrtDown = BizNumber.ZERO;

    @Getter@Setter
    private BizCurrency tmttkgkKykkjmaeUp = BizCurrency.valueOf(0);

    @Getter@Setter
    private BizCurrency tmttkgkKykkjmaeSame = BizCurrency.valueOf(0);

    @Getter@Setter
    private BizCurrency tmttkgkKykkjmaeDown = BizCurrency.valueOf(0);

    @Getter@Setter
    private BizCurrency kaiyakuHrKngakUp = BizCurrency.valueOf(0);

    @Getter@Setter
    private BizCurrency kaiyakuHrKngakSame = BizCurrency.valueOf(0);

    @Getter@Setter
    private BizCurrency kaiyakuHrKngakDown = BizCurrency.valueOf(0);

    public EditWSuiihyouBean() {
        super();
    }
}
