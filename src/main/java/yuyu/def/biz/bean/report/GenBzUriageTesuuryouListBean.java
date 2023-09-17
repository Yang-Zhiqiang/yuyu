package yuyu.def.biz.bean.report;

import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （共通）クレジットカード売上手数料リストヘッダー帳票BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenBzUriageTesuuryouListBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenBzUriageTesuuryouListBean() {
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

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
