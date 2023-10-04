package yuyu.batch.hozen.khozen.khseisandhanei.dba;

import java.io.Serializable;
import java.math.BigDecimal;

import yuyu.def.classification.C_HaitoukinsksKbn;
import yuyu.def.classification.C_HaitoumeisaiKbn;
import yuyu.def.classification.C_NaiteiKakuteiKbn;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateY;
import jp.co.slcs.swak.db.typesafe.BizCurrencySum;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.Getter;
import lombok.Setter;

/**
 * 契約保全 契約保全 配当管理情報Beanクラス
 */
public class KhHaitouKanriBean implements Serializable  {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private String kbnkey;

    @Getter @Setter
    private String syono;

    @Getter @Setter
    private BizDateY haitounendo;

    @Getter @Setter
    private Integer renno;

    @Getter @Setter
    private C_HaitoukinsksKbn haitoukinskskbn;

    @Getter @Setter
    private C_HaitoumeisaiKbn haitoumeisaikbn;

    @Getter @Setter
    private BizDateY fstkariwariatednendo;

    @Getter @Setter
    private BizCurrency tounendod;

    @Getter @Setter
    private C_NaiteiKakuteiKbn naiteikakuteikbn;

    @Getter @Setter
    private BizDate kariwariatedshrymd;

    @Getter @Setter
    private BizCurrency kariwariatedruigk;

    @Getter @Setter
    private BizCurrency kariwariatedgngkkngk;

    @Getter @Setter
    private BizCurrency kariwariatedshrgk;

    public KhHaitouKanriBean() {

    }

    public KhHaitouKanriBean(
        String pKbnkey,
        String pSyono,
        BizDateY pHaitounendo,
        Integer pRenno,
        C_HaitoukinsksKbn pHaitoukinskskbn,
        C_HaitoumeisaiKbn pHaitoumeisaikbn,
        BizDateY pFstkariwariatednendo,
        String pTounendodType,
        BigDecimal pTounendodValue,
        C_NaiteiKakuteiKbn pNaiteikakuteikbn,
        BizDate pKariwariatedshrymd,
        String pKariwariatedruigkType,
        BigDecimal pKariwariatedruigkValue,
        String pKariwariatedgngkkngkType,
        BigDecimal pKariwariatedgngkkngkValue,
        String pKariwariatedshrgkType,
        BigDecimal pKariwariatedshrgkValue) {

        kbnkey = pKbnkey;
        syono = pSyono;
        haitounendo = pHaitounendo;
        renno = pRenno;
        haitoukinskskbn = pHaitoukinskskbn;
        haitoumeisaikbn = pHaitoumeisaikbn;
        fstkariwariatednendo = pFstkariwariatednendo;
        tounendod = new BizCurrencySum(pTounendodType, pTounendodValue).toBizCurrency();
        naiteikakuteikbn = pNaiteikakuteikbn;
        kariwariatedshrymd = pKariwariatedshrymd;
        kariwariatedruigk = new BizCurrencySum(pKariwariatedruigkType, pKariwariatedruigkValue).toBizCurrency();
        kariwariatedgngkkngk = new BizCurrencySum(pKariwariatedgngkkngkType, pKariwariatedgngkkngkValue).toBizCurrency();
        kariwariatedshrgk = new BizCurrencySum(pKariwariatedshrgkType, pKariwariatedshrgkValue).toBizCurrency();
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}
