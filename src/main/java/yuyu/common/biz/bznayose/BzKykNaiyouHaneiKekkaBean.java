package yuyu.common.biz.bznayose;

import java.io.Serializable;

import yuyu.def.classification.C_KyknaiyouhaneiErrKbn;
import yuyu.def.classification.C_MQSyorikekkaKbn;
import yuyu.def.classification.C_NayoseJissiKekkaKbn;
import yuyu.def.db.entity.BT_TjtIdouNyKh;
import yuyu.def.db.entity.BT_TjtIdouNyNk;
import yuyu.def.db.entity.BT_TjtIdouNySk;

/**
 * 業務共通 名寄せ 契約内容反映結果Beanクラス
 */
public class BzKykNaiyouHaneiKekkaBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private C_MQSyorikekkaKbn mqsyorikekkakbn;

    private String acserrcd;

    private C_KyknaiyouhaneiErrKbn kyknaiyouhaneierrkbn;

    private C_NayoseJissiKekkaKbn hhknnysjissikekkakbn;

    private String hhknsakuinmeino;

    private C_NayoseJissiKekkaKbn kyknysjissikekkakbn;

    private String kyksakuinmeino;

    private C_NayoseJissiKekkaKbn nkuktnysjissikekkakbn;

    private String nkuktsakuinnmno;

    private String youkyuuno;

    private BT_TjtIdouNyKh tjtidounykh;

    private BT_TjtIdouNySk tjtidounysk;

    private BT_TjtIdouNyNk tjtidounynk;

    public BzKykNaiyouHaneiKekkaBean() {
        super();
    }

    public C_MQSyorikekkaKbn getMqsyorikekkakbn() {
        return mqsyorikekkakbn;
    }

    public void setMqsyorikekkakbn(C_MQSyorikekkaKbn pMqsyorikekkakbn) {
        mqsyorikekkakbn = pMqsyorikekkakbn;
    }

    public String getAcserrcd() {
        return acserrcd;
    }

    public void setAcserrcd(String pAcserrcd) {
        acserrcd = pAcserrcd;
    }

    public C_KyknaiyouhaneiErrKbn getKyknaiyouhaneierrkbn() {
        return kyknaiyouhaneierrkbn;
    }

    public void setKyknaiyouhaneierrkbn(C_KyknaiyouhaneiErrKbn pKyknaiyouhaneierrkbn) {
        kyknaiyouhaneierrkbn = pKyknaiyouhaneierrkbn;
    }

    public C_NayoseJissiKekkaKbn getHhknnysjissikekkakbn() {
        return hhknnysjissikekkakbn;
    }

    public void setHhknnysjissikekkakbn(C_NayoseJissiKekkaKbn pHhknnysjissikekkakbn) {
        hhknnysjissikekkakbn = pHhknnysjissikekkakbn;
    }

    public String getHhknsakuinmeino() {
        return hhknsakuinmeino;
    }

    public void setHhknsakuinmeino(String pHhknsakuinmeino) {
        hhknsakuinmeino = pHhknsakuinmeino;
    }

    public C_NayoseJissiKekkaKbn getKyknysjissikekkakbn() {
        return kyknysjissikekkakbn;
    }

    public void setKyknysjissikekkakbn(C_NayoseJissiKekkaKbn pKyknysjissikekkakbn) {
        kyknysjissikekkakbn = pKyknysjissikekkakbn;
    }

    public String getKyksakuinmeino() {
        return kyksakuinmeino;
    }

    public void setKyksakuinmeino(String pKyksakuinmeino) {
        kyksakuinmeino = pKyksakuinmeino;
    }

    public C_NayoseJissiKekkaKbn getNkuktnysjissikekkakbn() {
        return nkuktnysjissikekkakbn;
    }

    public void setNkuktnysjissikekkakbn(C_NayoseJissiKekkaKbn pNkuktnysjissikekkakbn) {
        nkuktnysjissikekkakbn = pNkuktnysjissikekkakbn;
    }

    public String getNkuktsakuinnmno() {
        return nkuktsakuinnmno;
    }

    public void setNkuktsakuinnmno(String pNkuktsakuinnmno) {
        nkuktsakuinnmno = pNkuktsakuinnmno;
    }

    public String getYoukyuuno() {
        return youkyuuno;
    }

    public void setYoukyuuno(String pYoukyuuno) {
        youkyuuno = pYoukyuuno;
    }

    public BT_TjtIdouNyKh getTjtidounykh() {
        return tjtidounykh;
    }

    public void setTjtidounykh(BT_TjtIdouNyKh tjtidounykh) {
        this.tjtidounykh = tjtidounykh;
    }

    public BT_TjtIdouNySk getTjtidounysk() {
        return tjtidounysk;
    }

    public void setTjtidounysk(BT_TjtIdouNySk tjtidounysk) {
        this.tjtidounysk = tjtidounysk;
    }

    public BT_TjtIdouNyNk getTjtidounynk() {
        return tjtidounynk;
    }

    public void setTjtidounynk(BT_TjtIdouNyNk tjtidounynk) {
        this.tjtidounynk = tjtidounynk;
    }
}
