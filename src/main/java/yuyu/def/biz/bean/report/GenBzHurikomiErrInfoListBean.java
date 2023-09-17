package yuyu.def.biz.bean.report;

import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （共通）振込入金エラー情報リスト帳票BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenBzHurikomiErrInfoListBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenBzHurikomiErrInfoListBean() {
    }

    private String irTyouhyousakuseiymd;

    public String getIrTyouhyousakuseiymd() {
        return irTyouhyousakuseiymd;
    }

    public void setIrTyouhyousakuseiymd(String pIrTyouhyousakuseiymd) {
        irTyouhyousakuseiymd = pIrTyouhyousakuseiymd;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
