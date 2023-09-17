package yuyu.def.biz.bean.report;

import java.io.Serializable;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （共通）クレカ収納代行件数リスト帳票BEAN データレイアウトのベースBeaimport java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;
*/
public class GenBzCreditSyuunouKsLstBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenBzCreditSyuunouKsLstBean() {
    }

    private String irTyouhyousakuseiymd;

    public String getIrTyouhyousakuseiymd() {
        return irTyouhyousakuseiymd;
    }

    public void setIrTyouhyousakuseiymd(String pIrTyouhyousakuseiymd) {
        irTyouhyousakuseiymd = pIrTyouhyousakuseiymd;
    }

    private String irSyunodaikonm;

    public String getIrSyunodaikonm() {
        return irSyunodaikonm;
    }

    public void setIrSyunodaikonm(String pIrSyunodaikonm) {
        irSyunodaikonm = pIrSyunodaikonm;
    }

    private String irTargetym;

    public String getIrTargetym() {
        return irTargetym;
    }

    public void setIrTargetym(String pIrTargetym) {
        irTargetym = pIrTargetym;
    }

    private String irSkauthorikensu;

    public String getIrSkauthorikensu() {
        return irSkauthorikensu;
    }

    public void setIrSkauthorikensu(String pIrSkauthorikensu) {
        irSkauthorikensu = pIrSkauthorikensu;
    }

    private String irSkuriagekensu;

    public String getIrSkuriagekensu() {
        return irSkuriagekensu;
    }

    public void setIrSkuriagekensu(String pIrSkuriagekensu) {
        irSkuriagekensu = pIrSkuriagekensu;
    }

    private String irKkauthorikensu;

    public String getIrKkauthorikensu() {
        return irKkauthorikensu;
    }

    public void setIrKkauthorikensu(String pIrKkauthorikensu) {
        irKkauthorikensu = pIrKkauthorikensu;
    }

    private String irKkuriagekensu;

    public String getIrKkuriagekensu() {
        return irKkuriagekensu;
    }

    public void setIrKkuriagekensu(String pIrKkuriagekensu) {
        irKkuriagekensu = pIrKkuriagekensu;
    }

    private String irAuthorigoukeikensu;

    public String getIrAuthorigoukeikensu() {
        return irAuthorigoukeikensu;
    }

    public void setIrAuthorigoukeikensu(String pIrAuthorigoukeikensu) {
        irAuthorigoukeikensu = pIrAuthorigoukeikensu;
    }

    private String irUriagegoukeikensu;

    public String getIrUriagegoukeikensu() {
        return irUriagegoukeikensu;
    }

    public void setIrUriagegoukeikensu(String pIrUriagegoukeikensu) {
        irUriagegoukeikensu = pIrUriagegoukeikensu;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
