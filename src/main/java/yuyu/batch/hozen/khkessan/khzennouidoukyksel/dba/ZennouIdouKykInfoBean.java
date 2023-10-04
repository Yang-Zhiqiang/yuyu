package yuyu.batch.hozen.khkessan.khzennouidoukyksel.dba;

import java.io.Serializable;
import java.math.BigDecimal;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.BizCurrencySum;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_ZennouSeisanKbn;
/**
 * 契約保全 決算 前納異動契約情報Beanクラスです。<br />
 */
public class ZennouIdouKykInfoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private String kbnkey;

    @Getter @Setter
    private String syono;

    @Getter @Setter
    private BizDate zennoukaisiymd;

    @Getter @Setter
    private Integer renno;

    @Getter @Setter
    private BizDate zennounyuukinsyoriymd;

    @Getter @Setter
    private String zennounyuukindenno;

    @Getter @Setter
    private BizDate zennounyuukindenymd;

    @Getter @Setter
    private BizDate ryosyuymd;

    @Getter @Setter
    private String zennoukikan;

    @Getter @Setter
    private BizCurrency zennounyuukinkgk;

    @Getter @Setter
    private BizCurrency zennoujihrkp;

    @Getter @Setter
    private C_ZennouSeisanKbn zennouseisankbn;

    @Getter @Setter
    private BizDate zennouseisansyoriymd;

    @Getter @Setter
    private BizCurrency zennouseisankgk;

    @Getter @Setter
    private BizDate zennouseisankijyunymd;

    @Getter @Setter
    private BizDate zennouseisandenymd;

    @Getter @Setter
    private BizDateYM annaisaikaiym;

    @Getter @Setter
    private BizDate kjsmyouzennoukaisiymd;

    @Getter @Setter
    private String kjsmyouzennoukikanm;

    @Getter @Setter
    private BizCurrency kjsmyouzennounyuukinkgk;

    @Getter @Setter
    private C_Tuukasyu rstuukasyu;

    @Getter @Setter
    private BizNumber ryosyukwsrate;

    @Getter @Setter
    private BizDate ryosyukwsratekjymd;

    @Getter @Setter
    private BizCurrency zennounyuukinkgkrstk;

    @Getter @Setter
    private BizDate tyakkinymd;

    @Getter @Setter
    private String gyoumuKousinKinou;

    public ZennouIdouKykInfoBean(String pKbnkey,
        String pSyono,
        BizDate pZennoukaisiymd,
        Integer pRenno,
        BizDate pZennounyuukinsyoriymd,
        String pZennounyuukindenno,
        BizDate pZennounyuukindenymd,
        BizDate pRyosyuymd,
        String pZennoukikan,
        String pZennounyuukinkgkType,
        BigDecimal pZennounyuukinkgkValue,
        String pZennoujihrkpType,
        BigDecimal pZennoujihrkpValue,
        C_ZennouSeisanKbn pZennouseisankbn,
        BizDate pZennouseisansyoriymd,
        String pZennouseisankgkType,
        BigDecimal pZennouseisankgkValue,
        BizDate pZennouseisankijyunymd,
        BizDate pZennouseisandenymd,
        BizDateYM pAnnaisaikaiym,
        BizDate pKjsmyouzennoukaisiymd,
        String pKjsmyouzennoukikanm,
        String pKjsmyouzennounyuukinkgkType,
        BigDecimal pKjsmyouzennounyuukinkgkValue,
        C_Tuukasyu pRstuukasyu,
        BizNumber pRyosyukwsrate,
        BizDate pRyosyukwsratekjymd,
        String pZennounyuukinkgkrstkType,
        BigDecimal pZennounyuukinkgkrstkValue,
        BizDate pTyakkinymd,
        String pGyoumuKousinKinou) {
        kbnkey = pKbnkey;
        syono = pSyono;
        zennoukaisiymd = pZennoukaisiymd;
        renno = pRenno;
        zennounyuukinsyoriymd = pZennounyuukinsyoriymd;
        zennounyuukindenno = pZennounyuukindenno;
        zennounyuukindenymd = pZennounyuukindenymd;
        ryosyuymd = pRyosyuymd;
        zennoukikan = pZennoukikan;
        zennounyuukinkgk = new BizCurrencySum(pZennounyuukinkgkType, pZennounyuukinkgkValue).toBizCurrency();
        zennoujihrkp = new BizCurrencySum(pZennoujihrkpType, pZennoujihrkpValue).toBizCurrency();
        zennouseisankbn = pZennouseisankbn;
        zennouseisansyoriymd = pZennouseisansyoriymd;
        zennouseisankgk = new BizCurrencySum(pZennouseisankgkType, pZennouseisankgkValue).toBizCurrency();
        zennouseisankijyunymd = pZennouseisankijyunymd;
        zennouseisandenymd = pZennouseisandenymd;
        annaisaikaiym = pAnnaisaikaiym;
        kjsmyouzennoukaisiymd = pKjsmyouzennoukaisiymd;
        kjsmyouzennoukikanm = pKjsmyouzennoukikanm;
        kjsmyouzennounyuukinkgk = new BizCurrencySum(pKjsmyouzennounyuukinkgkType, pKjsmyouzennounyuukinkgkValue).toBizCurrency();
        rstuukasyu = pRstuukasyu;
        ryosyukwsrate = pRyosyukwsrate;
        ryosyukwsratekjymd = pRyosyukwsratekjymd;
        zennounyuukinkgkrstk = new BizCurrencySum(pZennounyuukinkgkrstkType, pZennounyuukinkgkrstkValue).toBizCurrency();
        tyakkinymd = pTyakkinymd;
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}
