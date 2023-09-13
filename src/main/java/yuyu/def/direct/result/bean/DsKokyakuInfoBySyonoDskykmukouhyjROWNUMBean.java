package yuyu.def.direct.result.bean;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_DsKokyakuJtKbn;
import yuyu.def.classification.C_DsTeisiRiyuuKbn;

/**
 * ＤＳ顧客情報Beanクラスです。<br />
 */
@AllArgsConstructor
public class DsKokyakuInfoBySyonoDskykmukouhyjROWNUMBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private String dskokno;

    @Getter @Setter
    private String dskokyakunmkn;

    @Getter @Setter
    private String dskokyakunmkj;

    @Getter @Setter
    private BizDate dskokyakuseiymd;

    @Getter @Setter
    private String dskokyakuyno;

    @Getter @Setter
    private C_DsKokyakuJtKbn dskokyakujtkbn;

    @Getter @Setter
    private C_DsTeisiRiyuuKbn dsteisiriyuukbn;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}