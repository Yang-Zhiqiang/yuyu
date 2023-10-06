package yuyu.batch.biz.bzkaikei.bzsikinidoulistdataskshijynbrshr.dba;

import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_Tuukasyu;

/**
 * 業務共通 経理･会計 減額移動データBEAN
 */
public class GengakuIdouDataBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private String syono;

    @Getter @Setter
    private C_Segcd seg1cd;

    @Getter @Setter
    private C_Tuukasyu kyktuukasyu;

    @Getter @Setter
    private String syouhnCd;

    public GengakuIdouDataBean(String pSyono, String pSyouhnCd, C_Tuukasyu pKyktuukasyu){
        syono = pSyono;
        syouhnCd = pSyouhnCd;
        kyktuukasyu = pKyktuukasyu;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}
