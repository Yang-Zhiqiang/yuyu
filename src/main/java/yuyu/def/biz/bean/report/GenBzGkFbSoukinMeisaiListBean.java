package yuyu.def.biz.bean.report;

import java.io.Serializable;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （共通）外貨ＦＢ送金明細リスト帳票BEAN データレイアウトのベースBeanクラimport java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;
author  Deffer
 * @version Deffer 新規作成<br />
 *          yyyy/MM/dd 変更者 変更内容<br />
 */
public class GenBzGkFbSoukinMeisaiListBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenBzGkFbSoukinMeisaiListBean() {
    }

    private String irSyoriymd;

    public String getIrSyoriymd() {
        return irSyoriymd;
    }

    public void setIrSyoriymd(String pIrSyoriymd) {
        irSyoriymd = pIrSyoriymd;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
