package yuyu.batch.hozen.khinterf.khzennouhoyuuidoufsks.dba;

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
import yuyu.def.classification.C_ZennoubikinKbn;

/**
 * 契約保全 インターフェイス 前納保有異動契約明細Beanクラス
 */
public class ZennouHoyuuIdouKykDtlBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private String kbnkey;

    @Getter @Setter
    private String syono;

    @Getter @Setter
    private BizDate sakuseiymd;

    @Getter @Setter
    private String syoricd;

    @Getter @Setter
    private Integer kykmfksnctr;

    @Getter @Setter
    private BizDate henkousyoriymd;

    @Getter @Setter
    private String zennoukessanrecordkbn;

    @Getter @Setter
    private BizDateYM keijyouym;

    @Getter @Setter
    private BizDate denymd;

    @Getter @Setter
    private BizDate zennoucalckijyunymd;

    @Getter @Setter
    private C_ZennoubikinKbn zennoubikinkbn;

    @Getter @Setter
    private String syukeiyakusyuruicd;

    @Getter @Setter
    private C_Segcd kbnkeirisegcd;

    @Getter @Setter
    private C_ZennouToukeiListKbn zennoutoukeilistkbn;

    @Getter @Setter
    private BizDate keiyakuymd;

    @Getter @Setter
    private BizNumber zennouwrbkrt;

    @Getter @Setter
    private BizNumber tndmatutkyrt;

    @Getter @Setter
    private String tndzndkhikakukbn;

    @Getter @Setter
    private BizDate zennoukaisiymd;

    @Getter @Setter
    private C_ZennouKbn zennoukbn;

    @Getter @Setter
    private String zennoukikan;

    @Getter @Setter
    private BizDate zennounyuukinymd;

    @Getter @Setter
    private BizCurrency zennounyuukinkgk;

    @Getter @Setter
    private BizCurrency toukimatuzennouzndk;

    @Getter @Setter
    private BizCurrency toukijyuutoup;

    @Getter @Setter
    private BizCurrency toukizennouseisangk;

    @Getter @Setter
    private BizCurrency toukizennounyuukinkgk;

    @Getter @Setter
    private BizCurrency yokukinenbaraip;

    @Getter @Setter
    private BizCurrency wrbkrttkyrt;

    @Getter @Setter
    private String gkdtznnhyj;

    @Getter @Setter
    private String znngaikakbn;

    @Getter @Setter
    private String yenkanyknhyj;

    @Getter @Setter
    private BizNumber znnnyknjikawaserate;

    @Getter @Setter
    private BizDate znnnyknjikawaseratetkyuymd;

    @Getter @Setter
    private BizNumber ksnkisikawaserate;

    @Getter @Setter
    private BizNumber znncalckjynymdkwsrate;

    @Getter @Setter
    private BizNumber ksnkimatukawaserate;

    @Getter @Setter
    private BizCurrency zennounyuukinkgktkmatu;

    @Getter @Setter
    private BizCurrency tkmatuznnzndktkmatu;

    public ZennouHoyuuIdouKykDtlBean(
        String pKbnkey,
        String pSyono,
        BizDate pSakuseiymd,
        String pSyoricd,
        Integer pKykmfksnctr,
        BizDate pHenkousyoriymd,
        String pZennoukessanrecordkbn,
        BizDateYM pKeijyouym,
        BizDate pDenymd,
        BizDate pZennoucalckijyunymd,
        C_ZennoubikinKbn pZennoubikinkbn,
        String pSyukeiyakusyuruicd,
        C_Segcd pKbnkeirisegcd,
        C_ZennouToukeiListKbn pZennoutoukeilistkbn,
        BizDate pKeiyakuymd,
        BizNumber pZennouwrbkrt,
        BizNumber pTndmatutkyrt,
        String pTndzndkhikakukbn,
        BizDate pZennoukaisiymd,
        C_ZennouKbn pZennoukbn,
        String pZennoukikan,
        BizDate pZennounyuukinymd,
        String pZennounyuukinkgkType,
        BigDecimal pZennounyuukinkgkValue,
        String pToukimatuzennouzndkType,
        BigDecimal pToukimatuzennouzndkValue,
        String pToukijyuutoupType,
        BigDecimal pToukijyuutoupValue,
        String pToukizennouseisangkType,
        BigDecimal pToukizennouseisangkValue,
        String pToukizennounyuukinkgkType,
        BigDecimal pToukizennounyuukinkgkValue,
        String pYokukinenbaraipType,
        BigDecimal pYokukinenbaraipValue,
        String pWrbkrttkyrtType,
        BigDecimal pWrbkrttkyrtValue,
        String pGkdtznnhyj,
        String pZnngaikakbn,
        String pYenkanyknhyj,
        BizNumber pZnnnyknjikawaserate,
        BizDate pZnnnyknjikawaseratetkyuymd,
        BizNumber pKsnkisikawaserate,
        BizNumber pZnncalckjynymdkwsrate,
        BizNumber pKsnkimatukawaserate,
        String pZennounyuukinkgktkmatuType,
        BigDecimal pZennounyuukinkgktkmatuValue,
        String pTkmatuznnzndktkmatuType,
        BigDecimal pTkmatuznnzndktkmatuValue) {

        kbnkey = pKbnkey;
        syono = pSyono;
        sakuseiymd = pSakuseiymd;
        syoricd = pSyoricd;
        kykmfksnctr = pKykmfksnctr;
        henkousyoriymd = pHenkousyoriymd;
        zennoukessanrecordkbn = pZennoukessanrecordkbn;
        keijyouym = pKeijyouym;
        denymd = pDenymd;
        zennoucalckijyunymd = pZennoucalckijyunymd;
        zennoubikinkbn = pZennoubikinkbn;
        syukeiyakusyuruicd = pSyukeiyakusyuruicd;
        kbnkeirisegcd = pKbnkeirisegcd;
        zennoutoukeilistkbn = pZennoutoukeilistkbn;
        keiyakuymd = pKeiyakuymd;
        zennouwrbkrt = pZennouwrbkrt;
        tndmatutkyrt = pTndmatutkyrt;
        tndzndkhikakukbn = pTndzndkhikakukbn;
        zennoukaisiymd = pZennoukaisiymd;
        zennoukbn = pZennoukbn;
        zennoukikan = pZennoukikan;
        zennounyuukinymd = pZennounyuukinymd;
        zennounyuukinkgk = new BizCurrencySum(pZennounyuukinkgkType, pZennounyuukinkgkValue).toBizCurrency();
        toukimatuzennouzndk = new BizCurrencySum(pToukimatuzennouzndkType, pToukimatuzennouzndkValue).toBizCurrency();
        toukijyuutoup = new BizCurrencySum(pToukijyuutoupType, pToukijyuutoupValue).toBizCurrency();
        toukizennouseisangk = new BizCurrencySum(pToukizennouseisangkType, pToukizennouseisangkValue).toBizCurrency();
        toukizennounyuukinkgk = new BizCurrencySum(pToukizennounyuukinkgkType, pToukizennounyuukinkgkValue).toBizCurrency();
        yokukinenbaraip = new BizCurrencySum(pYokukinenbaraipType, pYokukinenbaraipValue).toBizCurrency();
        wrbkrttkyrt = new BizCurrencySum(pWrbkrttkyrtType, pWrbkrttkyrtValue).toBizCurrency();
        gkdtznnhyj = pGkdtznnhyj;
        znngaikakbn = pZnngaikakbn;
        yenkanyknhyj = pYenkanyknhyj;
        znnnyknjikawaserate = pZnnnyknjikawaserate;
        znnnyknjikawaseratetkyuymd = pZnnnyknjikawaseratetkyuymd;
        ksnkisikawaserate = pKsnkisikawaserate;
        znncalckjynymdkwsrate = pZnncalckjynymdkwsrate;
        ksnkimatukawaserate = pKsnkimatukawaserate;
        zennounyuukinkgktkmatu = new BizCurrencySum(pZennounyuukinkgktkmatuType, pZennounyuukinkgktkmatuValue).toBizCurrency();
        tkmatuznnzndktkmatu = new BizCurrencySum(pTkmatuznnzndktkmatuType, pTkmatuznnzndktkmatuValue).toBizCurrency();

    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}
