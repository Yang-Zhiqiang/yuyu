package yuyu.batch.hozen.khkessan.khzennoutoukeilistsks.dba;

import java.io.Serializable;
import java.math.BigDecimal;

import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_ZennouKbn;
import yuyu.def.classification.C_ZennouToukeiListKbn;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.BizCurrencySum;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.Getter;
import lombok.Setter;

/**
 *  前納統計リスト作成対象Beanクラスです。<br />
 */
public class ZennouToukeiListSksTaisyouBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private C_ZennouToukeiListKbn zennoutoukeilistkbn;

    @Getter @Setter
    private C_ZennouKbn zennoukbn;

    @Getter @Setter
    private C_Segcd kbnkeirisegcd;

    @Getter @Setter
    private BizDateYM zennoustartym;

    @Getter @Setter
    private long cnt;

    @Getter @Setter
    private BizCurrency zennoukaisijizndk;

    @Getter @Setter
    private BizCurrency tndmatuzndk;

    @Getter @Setter
    private BizCurrency zennoukaisijizndktkmatu;

    @Getter @Setter
    private BizCurrency tndmatuzndktkmatu;

    public ZennouToukeiListSksTaisyouBean(
        C_ZennouToukeiListKbn pZennoutoukeilistkbn,
        C_ZennouKbn pZennoukbn,
        C_Segcd pKbnkeirisegcd,
        BizDateYM pZennoustartym,
        long pCnt,
        String pZennoukaisijizndkType,
        BigDecimal pZennoukaisijizndkValue,
        String pTndmatuzndkType,
        BigDecimal pTndmatuzndkValue,
        String pZennoukaisijizndktkmatuType,
        BigDecimal pZennoukaisijizndktkmatuValue,
        String pTndmatuzndktkmatuType,
        BigDecimal pTndmatuzndktkmatuValue) {

        zennoutoukeilistkbn = pZennoutoukeilistkbn;
        zennoukbn = pZennoukbn;
        kbnkeirisegcd = pKbnkeirisegcd;
        zennoustartym = pZennoustartym;
        cnt = pCnt;
        zennoukaisijizndk = new BizCurrencySum(pZennoukaisijizndkType, pZennoukaisijizndkValue).toBizCurrency();
        tndmatuzndk = new BizCurrencySum(pTndmatuzndkType, pTndmatuzndkValue).toBizCurrency();
        zennoukaisijizndktkmatu = new BizCurrencySum(pZennoukaisijizndktkmatuType, pZennoukaisijizndktkmatuValue).toBizCurrency();
        tndmatuzndktkmatu = new BizCurrencySum(pTndmatuzndktkmatuType, pTndmatuzndktkmatuValue).toBizCurrency();
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}
