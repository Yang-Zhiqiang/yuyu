package yuyu.batch.hozen.khozen.khkanryoutuutijigosgylistsks.dba;

import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * 契約保全 契約保全 手続完了情報Beanクラス
 */
@AllArgsConstructor
public class TtdkKanBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private String kbnkey;

    @Getter @Setter
    private String syono;

    @Getter @Setter
    private String shsnmkj;

    @Getter @Setter
    private String kyknmkj;

    @Getter @Setter
    private Integer sbuktnin;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
