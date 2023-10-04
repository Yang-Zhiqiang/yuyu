package yuyu.batch.hozen.khinterf.khsinkokuyokokutuutifsks.dba;

import java.io.Serializable;
import java.math.BigDecimal;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.BizCurrencySum;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_SyoruiCdKbn;

/**
 * 契約保全 インターフェイス 申告予告通知Ｆ作成Beanクラス
 */
public class SinkokuYokokuTuutiDataBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private String kbnkey;

    @Getter @Setter
    private String syono;

    @Getter @Setter
    private String nendo;

    @Getter @Setter
    private BizDate tyouhyouymd;

    @Getter @Setter
    private Integer renno;

    @Getter @Setter
    private C_SyoruiCdKbn syoruiCd;

    @Getter @Setter
    private C_HassouKbn hassoukbn;

    @Getter @Setter
    private String tsinyno;

    @Getter @Setter
    private String tsinadr1kj;

    @Getter @Setter
    private String tsinadr2kj;

    @Getter @Setter
    private String tsinadr3kj;

    @Getter @Setter
    private String toiawasesosikinmkj;

    @Getter @Setter
    private String toiawaseyno;

    @Getter @Setter
    private String toiawaseadr1kj;

    @Getter @Setter
    private String toiawaseadr2kj;

    @Getter @Setter
    private String toiawaseadr3kj;

    @Getter @Setter
    private String toiawasetelno;

    @Getter @Setter
    private String toiawaseteluktkkanou1;

    @Getter @Setter
    private String toiawaseteluktkkanou2;

    @Getter @Setter
    private String toiawasesosikinmkj2;

    @Getter @Setter
    private String toiawasetelno2;

    @Getter @Setter
    private String kyknmkj;

    @Getter @Setter
    private String sinkokunen;

    @Getter @Setter
    private String midasi1;

    @Getter @Setter
    private String midasi2;

    @Getter @Setter
    private String midasi3;

    @Getter @Setter
    private String midasi4;

    @Getter @Setter
    private String midasi5;

    @Getter @Setter
    private String midasi6;

    @Getter @Setter
    private String midasi7;

    @Getter @Setter
    private String kihonjouhoumongon1;

    @Getter @Setter
    private String kihonjouhoumongon2;

    @Getter @Setter
    private String kihonjouhoumongon3;

    @Getter @Setter
    private String kihonjouhoumongon4;

    @Getter @Setter
    private String kihonjouhoumongon5;

    @Getter @Setter
    private String kihonjouhoumongon6;

    @Getter @Setter
    private String kihonjouhoumongon7;

    @Getter @Setter
    private BizCurrency newippanykkp;

    @Getter @Setter
    private BizCurrency newippanykkhaitoukin;

    @Getter @Setter
    private BizCurrency newippanykksyoumeigk;

    @Getter @Setter
    private BizCurrency newiryouykkp;

    @Getter @Setter
    private BizCurrency newiryouykkhaitoukin;

    @Getter @Setter
    private BizCurrency newiryouykksyoumeigk;

    @Getter @Setter
    private BizCurrency newnenkinykkp;

    @Getter @Setter
    private BizCurrency newnenkinykkhaitoukin;

    @Getter @Setter
    private BizCurrency newnenkinykksyoumeigk;

    @Getter @Setter
    private String hknjyutoukikan;

    @Getter @Setter
    private BizDate kykymd;

    @Getter @Setter
    private C_Hrkkaisuu hrkkaisuu;

    public SinkokuYokokuTuutiDataBean(String pKbnkey,
        String pSyono,
        String pNendo,
        BizDate pTyouhyouymd,
        Integer pRenno,
        C_SyoruiCdKbn pSyoruiCd,
        C_HassouKbn pHassoukbn,
        String pTsinyno,
        String pTsinadr1kj,
        String pTsinadr2kj,
        String pTsinadr3kj,
        String pToiawasesosikinmkj,
        String pToiawaseyno,
        String pToiawaseadr1kj,
        String pToiawaseadr2kj,
        String pToiawaseadr3kj,
        String pToiawasetelno,
        String pToiawaseteluktkkanou1,
        String pToiawaseteluktkkanou2,
        String pToiawasesosikinmkj2,
        String pToiawasetelno2,
        String pKyknmkj,
        String pSinkokunen,
        String pMidasi1,
        String pMidasi2,
        String pMidasi3,
        String pMidasi4,
        String pMidasi5,
        String pMidasi6,
        String pMidasi7,
        String pKihonjouhoumongon1,
        String pKihonjouhoumongon2,
        String pKihonjouhoumongon3,
        String pKihonjouhoumongon4,
        String pKihonjouhoumongon5,
        String pKihonjouhoumongon6,
        String pKihonjouhoumongon7,
        String pNewippanykkpType,
        BigDecimal pNewippanykkpValue,
        String pNewippanykkhaitoukinType,
        BigDecimal pNewippanykkhaitoukinValue,
        String pNewippanykksyoumeigkType,
        BigDecimal pNewippanykksyoumeigkValue,
        String pNewiryouykkpType,
        BigDecimal pNewiryouykkpValue,
        String pNewiryouykkhaitoukinType,
        BigDecimal pNewiryouykkhaitoukinValue,
        String pNewiryouykksyoumeigkType,
        BigDecimal pNewiryouykksyoumeigkValue,
        String pNewnenkinykkpType,
        BigDecimal pNewnenkinykkpValue,
        String pNewnenkinykkhaitoukinType,
        BigDecimal pNewnenkinykkhaitoukinValue,
        String pNewnenkinykksyoumeigkType,
        BigDecimal pNewnenkinykksyoumeigkValue,
        String pHknjyutoukikan,
        BizDate pKykymd,
        C_Hrkkaisuu pHrkkaisuu) {

        kbnkey = pKbnkey;

        syono = pSyono;

        nendo = pNendo;

        tyouhyouymd = pTyouhyouymd;

        renno = pRenno;

        syoruiCd = pSyoruiCd;

        hassoukbn = pHassoukbn;

        tsinyno = pTsinyno;

        tsinadr1kj = pTsinadr1kj;

        tsinadr2kj = pTsinadr2kj;

        tsinadr3kj = pTsinadr3kj;

        toiawasesosikinmkj = pToiawasesosikinmkj;

        toiawaseyno = pToiawaseyno;

        toiawaseadr1kj = pToiawaseadr1kj;

        toiawaseadr2kj = pToiawaseadr2kj;

        toiawaseadr3kj = pToiawaseadr3kj;

        toiawasetelno = pToiawasetelno;

        toiawaseteluktkkanou1 = pToiawaseteluktkkanou1;

        toiawaseteluktkkanou2 = pToiawaseteluktkkanou2;

        toiawasesosikinmkj2 = pToiawasesosikinmkj2;

        toiawasetelno2 = pToiawasetelno2;

        kyknmkj = pKyknmkj;

        sinkokunen = pSinkokunen;

        midasi1 = pMidasi1;

        midasi2 = pMidasi2;

        midasi3 = pMidasi3;

        midasi4 = pMidasi4;

        midasi5 = pMidasi5;

        midasi6 = pMidasi6;

        midasi7 = pMidasi7;

        kihonjouhoumongon1 = pKihonjouhoumongon1;

        kihonjouhoumongon2 = pKihonjouhoumongon2;

        kihonjouhoumongon3 = pKihonjouhoumongon3;

        kihonjouhoumongon4 = pKihonjouhoumongon4;

        kihonjouhoumongon5 = pKihonjouhoumongon5;

        kihonjouhoumongon6 = pKihonjouhoumongon6;

        kihonjouhoumongon7 = pKihonjouhoumongon7;

        newippanykkp = new BizCurrencySum(pNewippanykkpType, pNewippanykkpValue).toBizCurrency();

        newippanykkhaitoukin = new BizCurrencySum(pNewippanykkhaitoukinType, pNewippanykkhaitoukinValue).toBizCurrency();

        newippanykksyoumeigk = new BizCurrencySum(pNewippanykksyoumeigkType, pNewippanykksyoumeigkValue).toBizCurrency();

        newiryouykkp = new BizCurrencySum(pNewiryouykkpType, pNewiryouykkpValue).toBizCurrency();

        newiryouykkhaitoukin = new BizCurrencySum(pNewiryouykkhaitoukinType, pNewiryouykkhaitoukinValue).toBizCurrency();

        newiryouykksyoumeigk = new BizCurrencySum(pNewiryouykksyoumeigkType, pNewiryouykksyoumeigkValue).toBizCurrency();

        newnenkinykkp = new BizCurrencySum(pNewnenkinykkpType, pNewnenkinykkpValue).toBizCurrency();

        newnenkinykkhaitoukin = new BizCurrencySum(pNewnenkinykkhaitoukinType, pNewnenkinykkhaitoukinValue).toBizCurrency();

        newnenkinykksyoumeigk = new BizCurrencySum(pNewnenkinykksyoumeigkType, pNewnenkinykksyoumeigkValue).toBizCurrency();

        hknjyutoukikan = pHknjyutoukikan;

        kykymd = pKykymd;

        hrkkaisuu = pHrkkaisuu;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}
