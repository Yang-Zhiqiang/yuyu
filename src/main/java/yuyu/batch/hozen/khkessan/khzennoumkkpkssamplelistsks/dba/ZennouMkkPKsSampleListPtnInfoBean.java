package yuyu.batch.hozen.khkessan.khzennoumkkpkssamplelistsks.dba;

import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_ZennouKbn;
import yuyu.def.classification.C_ZennouToukeiListKbn;

/**
 * 前納未経過Ｐ検証サンプルリストパターン情報Beanクラスです。<br />
 */
@AllArgsConstructor
public class ZennouMkkPKsSampleListPtnInfoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private C_ZennouToukeiListKbn zennoutoukeilistkbn;

    @Getter @Setter
    private C_ZennouKbn zennoukbn;

    @Getter @Setter
    private C_Segcd kbnkeirisegcd;

    @Getter @Setter
    private String znnmkkpkssamplekslsttitle;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}
