package yuyu.common.biz.bznayose;

import java.io.Serializable;

import yuyu.def.classification.C_Huho2kyknoKbn;
import yuyu.def.classification.C_JdTrksPalTrksZanKbn;
import yuyu.def.classification.C_KyknaiyouhaneiErrKbn;
import yuyu.def.classification.C_MQSyorikekkaKbn;
import yuyu.def.classification.C_MqkousintrksiraiKbn;
import yuyu.def.classification.C_TorikesiKekkaKbn;

/**
 * 業務共通 名寄せ 要求通番管理テーブル追加更新Beanクラス
 */
public class BzYoukyuuNoKanriTblTuikaKousinBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private C_MqkousintrksiraiKbn mqkousintrksiraiKbn;

    private String youkyuuNo;

    private C_Huho2kyknoKbn huho2KykNoKbn;

    private String huho2KykNo;

    private C_MQSyorikekkaKbn mqSyorikekkaKbn;

    private String acserrcd;

    private C_KyknaiyouhaneiErrKbn kyknaiyouhaneiErrKbn;

    private C_TorikesiKekkaKbn torikesiKekkaKbn;

    private C_JdTrksPalTrksZanKbn jdTrksPalTrksZanKbn;

    public C_MqkousintrksiraiKbn getMqkousintrksiraiKbn() {
        return mqkousintrksiraiKbn;
    }

    public void setMqkousintrksiraiKbn(C_MqkousintrksiraiKbn pMqkousintrksiraiKbn) {
        this.mqkousintrksiraiKbn = pMqkousintrksiraiKbn;
    }

    public String getYoukyuuNo() {
        return youkyuuNo;
    }

    public void setYoukyuuNo(String pYoukyuuNo) {
        this.youkyuuNo = pYoukyuuNo;
    }

    public C_Huho2kyknoKbn getHuho2KykNoKbn() {
        return huho2KykNoKbn;
    }

    public void setHuho2KykNoKbn(C_Huho2kyknoKbn pHuho2KykNoKbn) {
        this.huho2KykNoKbn = pHuho2KykNoKbn;
    }

    public String getHuho2KykNo() {
        return huho2KykNo;
    }

    public void setHuho2KykNo(String pHuho2KykNo) {
        this.huho2KykNo = pHuho2KykNo;
    }

    public C_MQSyorikekkaKbn getMqSyorikekkaKbn() {
        return mqSyorikekkaKbn;
    }

    public void setMqSyorikekkaKbn(C_MQSyorikekkaKbn pMqSyorikekkaKbn) {
        this.mqSyorikekkaKbn = pMqSyorikekkaKbn;
    }

    public String getAcserrcd() {
        return acserrcd;
    }

    public void setAcserrcd(String pAcserrcd) {
        this.acserrcd = pAcserrcd;
    }

    public C_KyknaiyouhaneiErrKbn getKyknaiyouhaneiErrKbn() {
        return kyknaiyouhaneiErrKbn;
    }

    public void setKyknaiyouhaneiErrKbn(C_KyknaiyouhaneiErrKbn pKyknaiyouhaneiErrKbn) {
        this.kyknaiyouhaneiErrKbn = pKyknaiyouhaneiErrKbn;
    }

    public C_TorikesiKekkaKbn getTorikesiKekkaKbn() {
        return torikesiKekkaKbn;
    }

    public void setTorikesiKekkaKbn(C_TorikesiKekkaKbn pTorikesiKekkaKbn) {
        this.torikesiKekkaKbn = pTorikesiKekkaKbn;
    }

    public C_JdTrksPalTrksZanKbn getJdTrksPalTrksZanKbn() {
        return jdTrksPalTrksZanKbn;
    }

    public void setJdTrksPalTrksZanKbn(C_JdTrksPalTrksZanKbn pJdTrksPalTrksZanKbn) {
        this.jdTrksPalTrksZanKbn = pJdTrksPalTrksZanKbn;
    }
}
