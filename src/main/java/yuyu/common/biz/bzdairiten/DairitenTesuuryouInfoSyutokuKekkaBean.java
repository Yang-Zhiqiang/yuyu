package yuyu.common.biz.bzdairiten;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_MQSyorikekkaKbn;
import yuyu.def.classification.C_Tuukasyu;

/**
 * 業務共通 代理店 代理店手数料情報取得結果BEAN
 */
public class DairitenTesuuryouInfoSyutokuKekkaBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private C_MQSyorikekkaKbn mqSyoriKekkaKbn;

    private C_ErrorKbn acsKibanKekkaKbn;

    private C_ErrorKbn tsrSisanKekkaKbn;

    private C_ErrorKbn keijyouYmSyoukaiKekkaKbn;

    private BizCurrency syotsryGkYen;

    private BizCurrency syotsryGkKykTuuka;

    private BizCurrency jitsryGkYen;

    private BizCurrency jitsryGkKykTuuka;

    private String tsryCd;

    private C_Tuukasyu syotsrygkTuukasyu;

    private C_Tuukasyu jitsrygkTuukasyu;

    private BizCurrency syotsryRuiGkYen;

    private BizCurrency syotsryRuiGkGaika;

    private C_Tuukasyu syotsryruigkTuukasyu;

    private BizCurrency jitsryruiGkYen;

    private BizCurrency jitsryruiGkGaika;

    private C_Tuukasyu jitsryruigkTuukasyu;

    private BizCurrency soutsryGkYen;

    private BizCurrency soutsryGkGaika;

    private C_Tuukasyu soutsrygkTuukasyu;

    private BizDateYM keijyouYm;

    public DairitenTesuuryouInfoSyutokuKekkaBean() {
        super();
        mqSyoriKekkaKbn = C_MQSyorikekkaKbn.ERROR;
        acsKibanKekkaKbn = C_ErrorKbn.ERROR;
        tsrSisanKekkaKbn = C_ErrorKbn.ERROR;
        keijyouYmSyoukaiKekkaKbn = C_ErrorKbn.ERROR;
        syotsryGkYen = null;
        syotsryGkKykTuuka = null;
        jitsryGkYen = null;
        jitsryGkKykTuuka = null;
        tsryCd = "";
        syotsrygkTuukasyu = C_Tuukasyu.BLNK;
        jitsrygkTuukasyu = C_Tuukasyu.BLNK;
        syotsryRuiGkYen = null;
        syotsryRuiGkGaika = null;
        syotsryruigkTuukasyu = C_Tuukasyu.BLNK;
        jitsryruiGkYen = null;
        jitsryruiGkGaika = null;
        jitsryruigkTuukasyu = C_Tuukasyu.BLNK;
        soutsryGkYen = null;
        soutsryGkGaika = null;
        soutsrygkTuukasyu = C_Tuukasyu.BLNK;
        keijyouYm = null;
    }

    public C_MQSyorikekkaKbn getMqSyoriKekkaKbn() {
        return mqSyoriKekkaKbn;
    }

    public void setMqSyoriKekkaKbn(C_MQSyorikekkaKbn pMqSyoriKekkaKbn) {
        this.mqSyoriKekkaKbn = pMqSyoriKekkaKbn;
    }

    public C_ErrorKbn getAcsKibanKekkaKbn() {
        return acsKibanKekkaKbn;
    }

    public void setAcsKibanKekkaKbn(C_ErrorKbn pAcsKibanKekkaKbn) {
        this.acsKibanKekkaKbn = pAcsKibanKekkaKbn;
    }

    public C_ErrorKbn getTsrSisanKekkaKbn() {
        return tsrSisanKekkaKbn;
    }

    public void setTsrSisanKekkaKbn(C_ErrorKbn pTsrSisanKekkaKbn) {
        this.tsrSisanKekkaKbn = pTsrSisanKekkaKbn;
    }

    public C_ErrorKbn getKeijyouYmSyoukaiKekkaKbn() {
        return keijyouYmSyoukaiKekkaKbn;
    }

    public void setKeijyouYmSyoukaiKekkaKbn(C_ErrorKbn pKeijyouYmSyoukaiKekkaKbn) {
        this.keijyouYmSyoukaiKekkaKbn = pKeijyouYmSyoukaiKekkaKbn;
    }

    public BizCurrency getSyotsryGkYen() {
        return syotsryGkYen;
    }

    public void setSyotsryGkYen(BizCurrency pSyotsryGkYen) {
        this.syotsryGkYen = pSyotsryGkYen;
    }

    public BizCurrency getSyotsryGkKykTuuka() {
        return syotsryGkKykTuuka;
    }

    public void setSyotsryGkKykTuuka(BizCurrency pSyotsryGkKykTuuka) {
        this.syotsryGkKykTuuka = pSyotsryGkKykTuuka;
    }

    public BizCurrency getJitsryGkYen() {
        return jitsryGkYen;
    }

    public void setJitsryGkYen(BizCurrency pJitsryGkYen) {
        this.jitsryGkYen = pJitsryGkYen;
    }

    public BizCurrency getJitsryGkKykTuuka() {
        return jitsryGkKykTuuka;
    }

    public void setJitsryGkKykTuuka(BizCurrency pJitsryGkKykTuuka) {
        jitsryGkKykTuuka = pJitsryGkKykTuuka;
    }

    public String getTsryCd() {
        return tsryCd;
    }

    public void setTsryCd(String pTsryCd) {
        this.tsryCd = pTsryCd;
    }

    public C_Tuukasyu getSyotsrygkTuukasyu() {
        return syotsrygkTuukasyu;
    }

    public void setSyotsrygkTuukasyu(C_Tuukasyu pSyotsrygkTuukasyu) {
        this.syotsrygkTuukasyu = pSyotsrygkTuukasyu;
    }

    public C_Tuukasyu getJitsrygkTuukasyu() {
        return jitsrygkTuukasyu;
    }

    public void setJitsrygkTuukasyu(C_Tuukasyu pJitsrygkTuukasyu) {
        this.jitsrygkTuukasyu = pJitsrygkTuukasyu;
    }

    public BizCurrency getSyotsryRuiGkYen() {
        return syotsryRuiGkYen;
    }

    public void setSyotsryRuiGkYen(BizCurrency pSyotsryRuiGkYen) {
        this.syotsryRuiGkYen = pSyotsryRuiGkYen;
    }

    public BizCurrency getSyotsryRuiGkGaika() {
        return syotsryRuiGkGaika;
    }

    public void setSyotsryRuiGkGaika(BizCurrency pSyotsryRuiGkGaika) {
        this.syotsryRuiGkGaika = pSyotsryRuiGkGaika;
    }

    public C_Tuukasyu getSyotsryruigkTuukasyu() {
        return syotsryruigkTuukasyu;
    }

    public void setSyotsryruigkTuukasyu(C_Tuukasyu pSyotsryruigkTuukasyu) {
        this.syotsryruigkTuukasyu = pSyotsryruigkTuukasyu;
    }

    public BizCurrency getJitsryruiGkYen() {
        return jitsryruiGkYen;
    }

    public void setJitsryruiGkYen(BizCurrency pJitsryruiGkYen) {
        this.jitsryruiGkYen = pJitsryruiGkYen;
    }

    public BizCurrency getJitsryruiGkGaika() {
        return jitsryruiGkGaika;
    }

    public void setJitsryruiGkGaika(BizCurrency pJitsryruiGkGaika) {
        this.jitsryruiGkGaika = pJitsryruiGkGaika;
    }

    public C_Tuukasyu getJitsryruigkTuukasyu() {
        return jitsryruigkTuukasyu;
    }

    public void setJitsryruigkTuukasyu(C_Tuukasyu pJitsryruigkTuukasyu) {
        this.jitsryruigkTuukasyu = pJitsryruigkTuukasyu;
    }

    public BizCurrency getSoutsryGkYen() {
        return soutsryGkYen;
    }

    public void setSoutsryGkYen(BizCurrency pSoutsryGkYen) {
        this.soutsryGkYen = pSoutsryGkYen;
    }

    public BizCurrency getSoutsryGkGaika() {
        return soutsryGkGaika;
    }

    public void setSoutsryGkGaika(BizCurrency pSoutsryGkGaika) {
        this.soutsryGkGaika = pSoutsryGkGaika;
    }

    public C_Tuukasyu getSoutsrygkTuukasyu() {
        return soutsrygkTuukasyu;
    }

    public void setSoutsrygkTuukasyu(C_Tuukasyu pSoutsrygkTuukasyu) {
        this.soutsrygkTuukasyu = pSoutsrygkTuukasyu;
    }

    public BizDateYM getKeijyouYm() {
        return keijyouYm;
    }

    public void setKeijyouYm(BizDateYM pKeijyouYm) {
        this.keijyouYm = pKeijyouYm;
    }
}
