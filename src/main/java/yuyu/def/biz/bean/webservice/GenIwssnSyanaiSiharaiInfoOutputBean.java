package yuyu.def.biz.bean.webservice;

import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （共通Web）社内用Web保険金情報出力BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenIwssnSyanaiSiharaiInfoOutputBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenIwssnSyanaiSiharaiInfoOutputBean() {
    }

    private String iwssnSiboushryymd;

    public String getIwssnSiboushryymd() {
        return iwssnSiboushryymd;
    }

    public void setIwssnSiboushryymd(String pIwssnSiboushryymd) {
        iwssnSiboushryymd = pIwssnSiboushryymd;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
