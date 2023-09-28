package yuyu.common.biz.kaikei.dba4bzhijynbrsikinidoudatatysyt;

import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * 業務共通 経理・会計 支払伝票データ連番の処理対象を保持するBeanクラス
 */
@AllArgsConstructor
public class SiDenrennoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private String denRenno;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}
