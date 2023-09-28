package yuyu.common.biz.bznayose;

import java.io.Serializable;

import yuyu.def.classification.C_JdTrksPalTrksZanKbn;
import yuyu.def.classification.C_MQSyorikekkaKbn;
import yuyu.def.classification.C_TorikesiKekkaKbn;

/**
 * 取消依頼結果Beanクラスです。<br />
 */
public class BzTrksIraiKekkaBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private C_MQSyorikekkaKbn mqsyorikekkakbn;

    private String acserrcd;

    private C_TorikesiKekkaKbn trkskekkakbn;

    private C_JdTrksPalTrksZanKbn jdtrkspaltrkszankbn;

    public BzTrksIraiKekkaBean() {
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

    public C_TorikesiKekkaKbn getTrkskekkakbn() {
        return trkskekkakbn;
    }

    public void setTrkskekkakbn(C_TorikesiKekkaKbn pTrkskekkakbn) {
        trkskekkakbn = pTrkskekkakbn;
    }

    public C_JdTrksPalTrksZanKbn getJdtrkspaltrkszankbn() {
        return jdtrkspaltrkszankbn;
    }

    public void setJdtrkspaltrkszankbn(C_JdTrksPalTrksZanKbn pJdtrkspaltrkszankbn) {
        jdtrkspaltrkszankbn = pJdtrkspaltrkszankbn;
    }

}
