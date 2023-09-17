package yuyu.def.biz.bean.report;

import java.io.Serializable;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （共通）収納管理リストヘッダー帳票BEAN データレイアウトのベースBeimport java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;
 */
public class GenBzSyuunouKanriListBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenBzSyuunouKanriListBean() {
    }

    private String irSyoriymd;

    public String getIrSyoriymd() {
        return irSyoriymd;
    }

    public void setIrSyoriymd(String pIrSyoriymd) {
        irSyoriymd = pIrSyoriymd;
    }

    private String irSyunodaikonm;

    public String getIrSyunodaikonm() {
        return irSyunodaikonm;
    }

    public void setIrSyunodaikonm(String pIrSyunodaikonm) {
        irSyunodaikonm = pIrSyunodaikonm;
    }

    private String irHurikaeymd;

    public String getIrHurikaeymd() {
        return irHurikaeymd;
    }

    public void setIrHurikaeymd(String pIrHurikaeymd) {
        irHurikaeymd = pIrHurikaeymd;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
