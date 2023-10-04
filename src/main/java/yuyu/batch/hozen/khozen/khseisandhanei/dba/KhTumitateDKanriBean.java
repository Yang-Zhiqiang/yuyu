package yuyu.batch.hozen.khozen.khseisandhanei.dba;

import java.io.Serializable;
import java.math.BigDecimal;

import yuyu.def.classification.C_NaiteiKakuteiKbn;
import yuyu.def.classification.C_TumitateDSakuseiKbn;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.BizCurrencySum;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.Getter;
import lombok.Setter;

/**
 * 契約保全 契約保全 積立Ｄ管理情報Beanクラス
 */
public class KhTumitateDKanriBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private String kbnkey;

    @Getter @Setter
    private String syono;

    @Getter @Setter
    private BizDate tumitatedtumitateymd;

    @Getter @Setter
    private Integer renno;

    @Getter @Setter
    private C_TumitateDSakuseiKbn tumitatedskskbn;

    @Getter @Setter
    private BizCurrency tumitated;

    @Getter @Setter
    private BizDate tumitatedshrkrkymd;

    @Getter @Setter
    private C_NaiteiKakuteiKbn naiteikakuteikbn;

    public KhTumitateDKanriBean(){

    }

    public KhTumitateDKanriBean(
        String pKbnkey,
        String pSyono,
        BizDate pTumitatedtumitateymd,
        Integer pRenno,
        C_TumitateDSakuseiKbn pTumitatedskskbn,
        String pTumitatedType,
        BigDecimal pTumitatedValue,
        BizDate pTumitatedshrkrkymd,
        C_NaiteiKakuteiKbn pNaiteikakuteikbn) {

        kbnkey = pKbnkey;
        syono = pSyono;
        tumitatedtumitateymd = pTumitatedtumitateymd;
        renno = pRenno;
        tumitatedskskbn = pTumitatedskskbn;
        tumitated = new BizCurrencySum(pTumitatedType, pTumitatedValue).toBizCurrency();
        tumitatedshrkrkymd = pTumitatedshrkrkymd;
        naiteikakuteikbn = pNaiteikakuteikbn;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}
