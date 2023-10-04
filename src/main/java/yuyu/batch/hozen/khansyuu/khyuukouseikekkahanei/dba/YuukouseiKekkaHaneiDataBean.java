package yuyu.batch.hozen.khansyuu.khyuukouseikekkahanei.dba;

import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;

/**
 * 有効性確認結果反映対象Beanクラスです。<br />
 */
@AllArgsConstructor
public class YuukouseiKekkaHaneiDataBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private String syono;

    @Getter @Setter
    private String kbnkey;

    @Getter @Setter
    private C_TkiktbrisyuruiKbn tkiktbrisyuruikbn;

    @Getter @Setter
    private String creditkessaiyouno;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}
