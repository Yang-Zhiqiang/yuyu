package yuyu.def.hozen.result.bean;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_DsKokyakuJtKbn;

/**
 * 保全名義変更情報Beanクラスです。<br />
 */
@AllArgsConstructor
public class KykKihonsBySyoriYmdFromSyoriYmdToDskykmukouhyjBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private BizDate lastkyknmseiymdhenkouymd;

    @Getter @Setter
    private BizDate lastkyknmkanakjteiymd;

    @Getter @Setter
    private String kyknmkj;

    @Getter @Setter
    private String kyknmkn;

    @Getter @Setter
    private BizDate kykseiymd;

    @Getter @Setter
    private String syono;

    @Getter @Setter
    private String dskokno;

    @Getter @Setter
    private String dskokyakunmkj;

    @Getter @Setter
    private String dskokyakunmkn;

    @Getter @Setter
    private BizDate dskokyakuseiymd;

    @Getter @Setter
    private String dskokyakuyno;

    @Getter @Setter
    private C_DsKokyakuJtKbn dskokyakujtkbn;

    @Getter @Setter
    private String dshnnkakcd;

    @Getter @Setter
    private String dskrhnnkakcd;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
