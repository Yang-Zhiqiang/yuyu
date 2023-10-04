package yuyu.batch.hozen.khkessan.khyendthnkbikintyusyutu.dba;

import java.io.Serializable;
import java.math.BigDecimal;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.BizCurrencySum;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_Siharaijyoutaikbn;
import yuyu.def.classification.C_TantouCdKbn;

/**
 * 契約保全備金管理対象（円建変更）情報Bean(大量用)クラスです。<br />
 */
public class KhBikinkanriYendthnkInfosBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private String kbnkey;

    @Getter @Setter
    private String syono;

    @Getter @Setter
    private BizCurrency kihons;

    @Getter @Setter
    private String henkousikibetukey;

    @Getter @Setter
    private BizDate shrymd;

    @Getter @Setter
    private BizDate shrsyoriymd;

    @Getter @Setter
    private BizDate hrhsiymd;

    @Getter @Setter
    private BizDate hrhsisyoriymd;

    @Getter @Setter
    private BizCurrency henreikingk;

    @Getter @Setter
    private C_Siharaijyoutaikbn hrsiharaijyoutaikbn;

    @Getter @Setter
    private C_Segcd seg1cd;

    @Getter @Setter
    private C_TantouCdKbn tantocd;

    public KhBikinkanriYendthnkInfosBean(String pKbnkey,
        String pSyono,
        String pKihonsType,
        BigDecimal pKihonsValue,
        String pHenkousikibetukey,
        BizDate pShrymd,
        BizDate pShrsyoriymd,
        BizDate pHrhsiymd,
        BizDate pHrhsisyoriymd,
        String pHenreikingkType,
        BigDecimal pHenreikingkValue,
        C_Siharaijyoutaikbn pHrsiharaijyoutaikbn,
        C_Segcd pSeg1cd,
        C_TantouCdKbn pTantocd
        ) {

        kbnkey = pKbnkey;
        syono = pSyono;
        kihons = new BizCurrencySum(pKihonsType, pKihonsValue).toBizCurrency();
        henkousikibetukey = pHenkousikibetukey;
        shrymd = pShrymd;
        shrsyoriymd = pShrsyoriymd;
        hrhsiymd = pHrhsiymd;
        hrhsisyoriymd = pHrhsisyoriymd;
        henreikingk = new BizCurrencySum(pHenreikingkType, pHenreikingkValue).toBizCurrency();
        hrsiharaijyoutaikbn = pHrsiharaijyoutaikbn;
        seg1cd = pSeg1cd;
        tantocd = pTantocd;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}
