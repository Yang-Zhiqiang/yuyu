package yuyu.batch.hozen.khkessan.khzennoumkkpkssamplelistsks.dba;

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
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_ZennouKbn;
import yuyu.def.classification.C_ZennouToukeiListKbn;

/**
 * 前納未経過Ｐ検証サンプルリスト作成対象情報Beanクラスです。<br />
 */
public class ZennouMkkPKsSampleListInfoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private String syono;

    @Getter @Setter
    private C_ZennouToukeiListKbn zennoutoukeilistkbn;

    @Getter @Setter
    private C_ZennouKbn zennoukbn;

    @Getter @Setter
    private C_Segcd kbnkeirisegcd;

    @Getter @Setter
    private BizDateYM zennoustartym;

    @Getter @Setter
    private BizDate keiyakuymd;

    @Getter @Setter
    private BizDate zennounyuukinymd;

    @Getter @Setter
    private BizNumber zennouwrbkrt;

    @Getter @Setter
    private BizCurrency zennoukaisijizndk;

    @Getter @Setter
    private BizNumber tndmatutkyrt;

    @Getter @Setter
    private BizCurrency tndmatuzndk;

    @Getter @Setter
    private BizCurrency zennoukaisijizndktkmatu;

    @Getter @Setter
    private BizCurrency tndmatuzndktkmatu;

    public ZennouMkkPKsSampleListInfoBean(String pSyono,
        C_ZennouToukeiListKbn pZennoutoukeilistkbn,
        C_ZennouKbn pZennoukbn,
        C_Segcd pKbnkeirisegcd,
        BizDateYM pZennoustartym,
        BizDate pKeiyakuymd,
        BizDate pZennounyuukinymd,
        BizNumber pZennouwrbkrt,
        String pZennoukaisijizndkType,
        BigDecimal pZennoukaisijizndkValue,
        BizNumber pTndmatutkyrt,
        String pTndmatuzndkType,
        BigDecimal pTndmatuzndkValue,
        String pZennoukaisijizndktkmatuType,
        BigDecimal pZennoukaisijizndktkmatuValue,
        String pTndmatuzndktkmatuType,
        BigDecimal pTndmatuzndktkmatuValue
        ) {

        syono = pSyono;
        zennoutoukeilistkbn = pZennoutoukeilistkbn;
        zennoukbn = pZennoukbn;
        kbnkeirisegcd = pKbnkeirisegcd;
        zennoustartym = pZennoustartym;
        keiyakuymd = pKeiyakuymd;
        zennounyuukinymd = pZennounyuukinymd;
        zennouwrbkrt = pZennouwrbkrt;
        zennoukaisijizndk = new BizCurrencySum(pZennoukaisijizndkType, pZennoukaisijizndkValue).toBizCurrency();
        tndmatutkyrt = pTndmatutkyrt;
        tndmatuzndk = new BizCurrencySum(pTndmatuzndkType, pTndmatuzndkValue).toBizCurrency();
        zennoukaisijizndktkmatu = new BizCurrencySum(pZennoukaisijizndktkmatuType, pZennoukaisijizndktkmatuValue).toBizCurrency();
        tndmatuzndktkmatu = new BizCurrencySum(pTndmatuzndktkmatuType, pTndmatuzndktkmatuValue).toBizCurrency();
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}
