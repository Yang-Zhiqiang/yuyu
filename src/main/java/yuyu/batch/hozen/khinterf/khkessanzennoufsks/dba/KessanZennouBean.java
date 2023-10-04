package yuyu.batch.hozen.khinterf.khkessanzennoufsks.dba;

import java.io.Serializable;
import java.math.BigDecimal;

import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_ZennouKbn;
import yuyu.def.classification.C_ZennouToukeiListKbn;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.BizCurrencySum;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.Getter;
import lombok.Setter;

/**
 * 契約保全 インターフェイス 決算用前納Bean
 */
public class KessanZennouBean implements Serializable{

    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private String syono;

    @Getter
    @Setter
    private C_Segcd kbnkeirisegcd;

    @Getter
    @Setter
    private C_ZennouToukeiListKbn zennoutoukeilistkbn;

    @Getter
    @Setter
    private C_ZennouKbn zennoukbn;

    @Getter
    @Setter
    private BizDateYM zennoustartym;

    @Getter
    @Setter
    private BizDate zennoukaisiymd;

    @Getter
    @Setter
    private BizCurrency zennoukaisijizndk;

    @Getter
    @Setter
    private BizDate keiyakuymd;

    @Getter
    @Setter
    private BizNumber zennouwrbkrt;

    @Getter
    @Setter
    private BizCurrency rthndzndk1;

    @Getter
    @Setter
    private BizNumber tkyrt1;

    @Getter
    @Setter
    private BizDate rthndymd1;
    @Getter
    @Setter
    private BizCurrency rthndzndk2;

    @Getter
    @Setter
    private BizNumber tkyrt2;

    @Getter
    @Setter
    private BizDate rthndymd2;

    @Getter
    @Setter
    private BizCurrency rthndzndk3;

    @Getter
    @Setter
    private BizNumber tkyrt3;

    @Getter
    @Setter
    private BizDate rthndymd3;

    @Getter
    @Setter
    private BizCurrency rthndzndk4;

    @Getter
    @Setter
    private BizNumber tkyrt4;

    @Getter
    @Setter
    private BizDate rthndymd4;

    @Getter
    @Setter
    private BizCurrency tndmatuzndk;

    @Getter
    @Setter
    private BizNumber tndmatutkyrt;

    @Getter
    @Setter
    private BizDate zennounyuukinymd;

    @Getter
    @Setter
    private String tndzndkhikakukbn;

    @Getter
    @Setter
    private String zennoukikan;

    @Getter
    @Setter
    private String bosyuukeitaikbn;

    @Getter
    @Setter
    private String gkdtznnhyj;

    @Getter
    @Setter
    private String znngaikakbn;

    @Getter
    @Setter
    private String yenkanyknhyj;

    @Getter
    @Setter
    private  BizNumber znnnyknjikawaserate;

    @Getter
    @Setter
    private BizDate znnnyknjikawaseratetkyuymd;

    @Getter
    @Setter
    private  BizNumber ksnkisikawaserate;

    @Getter
    @Setter
    private BizNumber tndmatuzndkksnjkwsrate ;

    @Getter
    @Setter
    private BizCurrency zennounyuukinkgkgaika;

    @Getter
    @Setter
    private BizCurrency zennounyuukinkgktkmatu;

    @Getter
    @Setter
    private  BizCurrency zennoukaisijizndktkmatu;

    @Getter
    @Setter
    private BizCurrency rthndzndk1tkmatu;

    @Getter
    @Setter
    private BizCurrency rthndzndk2tkmatu;

    @Getter
    @Setter
    private BizCurrency rthndzndk3tkmatu;

    @Getter
    @Setter
    private BizCurrency rthndzndk4tkmatu;

    @Getter
    @Setter
    private BizCurrency tndmatuzndktkmatu;

    public KessanZennouBean(String pSyono,
        C_Segcd pKbnkeirisegcd,
        C_ZennouToukeiListKbn pZennoutoukeilistkbn,
        C_ZennouKbn pZennoukbn,
        BizDateYM pZennoustartym,
        BizDate pZennoukaisiymd,
        String pZennoukaisijizndkType,
        BigDecimal pZennoukaisijizndkValue,
        BizDate pKeiyakuymd,
        BizNumber pZennouwrbkrt,
        String pRthndzndkType1,
        BigDecimal pRthndzndkValue1,
        BizNumber pTkyrt1,
        BizDate pRthndymd1,
        String pRthndzndkType2,
        BigDecimal pRthndzndkValue2,
        BizNumber pTkyrt2,
        BizDate pRthndymd2,
        String pRthndzndkType3,
        BigDecimal pRthndzndkValue3,
        BizNumber pTkyrt3,
        BizDate pRthndymd3,
        String pRthndzndkType4,
        BigDecimal pRthndzndkValue4,
        BizNumber pTkyrt4,
        BizDate pRthndymd4,
        String pTndmatuzndkType,
        BigDecimal pTndmatuzndkValue,
        BizNumber pTndmatutkyrt,
        BizDate pZennounyuukinymd,
        String pTndzndkhikakukbn,
        String pZennoukikan,
        String pBosyuukeitaikbn,
        String pGkdtznnhyj,
        String pZnngaikakbn,
        String pYenkanyknhyj,
        BizNumber pZnnnyknjikawaserate,
        BizDate pZnnnyknjikawaseratetkyuymd,
        BizNumber pKsnkisikawaserate,
        BizNumber pTndmatuzndkksnjkwsrate,
        String pZennounyuukinkgkgaikaType,
        BigDecimal pZennounyuukinkgkgaikaValue,
        String pZennounyuukinkgktkmatuType,
        BigDecimal pZennounyuukinkgktkmatuValue,
        String pZennoukaisijizndktkmatuType,
        BigDecimal pZennoukaisijizndktkmatuValue,
        String pRthndzndk1tkmatuType,
        BigDecimal pRthndzndk1tkmatuValue,
        String pRthndzndk2tkmatuType,
        BigDecimal pRthndzndk2tkmatuValue,
        String pRthndzndk3tkmatuType,
        BigDecimal pRthndzndk3tkmatuValue,
        String pRthndzndk4tkmatuType,
        BigDecimal pRthndzndk4tkmatuValue,
        String pTndmatuzndktkmatuType,
        BigDecimal pTndmatuzndktkmatuValue){

        syono = pSyono;
        kbnkeirisegcd = pKbnkeirisegcd;
        zennoutoukeilistkbn = pZennoutoukeilistkbn;
        zennoukbn = pZennoukbn;
        zennoustartym = pZennoustartym;
        zennoukaisiymd = pZennoukaisiymd;
        zennoukaisijizndk = new BizCurrencySum(pZennoukaisijizndkType, pZennoukaisijizndkValue).toBizCurrency();
        keiyakuymd = pKeiyakuymd;
        zennouwrbkrt = pZennouwrbkrt;
        rthndzndk1 =  new BizCurrencySum(pRthndzndkType1, pRthndzndkValue1).toBizCurrency();
        tkyrt1 = pTkyrt1;
        rthndymd1 = pRthndymd1;
        rthndzndk2 = new BizCurrencySum(pRthndzndkType2, pRthndzndkValue2).toBizCurrency();
        tkyrt2 = pTkyrt2;
        rthndymd2 = pRthndymd2;
        rthndzndk3 = new BizCurrencySum(pRthndzndkType3, pRthndzndkValue3).toBizCurrency();
        tkyrt3 = pTkyrt3;
        rthndymd3 = pRthndymd3;
        rthndzndk4 = new BizCurrencySum(pRthndzndkType4, pRthndzndkValue4).toBizCurrency();
        tkyrt4 = pTkyrt4;
        rthndymd4 = pRthndymd4;
        tndmatuzndk = new BizCurrencySum(pTndmatuzndkType, pTndmatuzndkValue).toBizCurrency();
        tndmatutkyrt = pTndmatutkyrt;
        zennounyuukinymd = pZennounyuukinymd;
        tndzndkhikakukbn = pTndzndkhikakukbn;
        zennoukikan = pZennoukikan;
        bosyuukeitaikbn = pBosyuukeitaikbn;
        gkdtznnhyj = pGkdtznnhyj;
        znngaikakbn = pZnngaikakbn;
        yenkanyknhyj = pYenkanyknhyj;
        znnnyknjikawaserate = pZnnnyknjikawaserate;
        znnnyknjikawaseratetkyuymd = pZnnnyknjikawaseratetkyuymd;
        ksnkisikawaserate = pKsnkisikawaserate;
        tndmatuzndkksnjkwsrate = pTndmatuzndkksnjkwsrate;
        zennounyuukinkgkgaika = new BizCurrencySum(pZennounyuukinkgkgaikaType, pZennounyuukinkgkgaikaValue).toBizCurrency();
        zennounyuukinkgktkmatu = new BizCurrencySum(pZennounyuukinkgktkmatuType, pZennounyuukinkgktkmatuValue).toBizCurrency();
        zennoukaisijizndktkmatu = new BizCurrencySum(pZennoukaisijizndktkmatuType, pZennoukaisijizndktkmatuValue).toBizCurrency();
        rthndzndk1tkmatu = new BizCurrencySum(pRthndzndk1tkmatuType, pRthndzndk1tkmatuValue).toBizCurrency();
        rthndzndk2tkmatu = new BizCurrencySum(pRthndzndk2tkmatuType, pRthndzndk2tkmatuValue).toBizCurrency();
        rthndzndk3tkmatu = new BizCurrencySum(pRthndzndk3tkmatuType, pRthndzndk3tkmatuValue).toBizCurrency();
        rthndzndk4tkmatu = new BizCurrencySum(pRthndzndk4tkmatuType, pRthndzndk4tkmatuValue).toBizCurrency();
        tndmatuzndktkmatu = new BizCurrencySum(pTndmatuzndktkmatuType, pTndmatuzndktkmatuValue).toBizCurrency();

    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
