package yuyu.batch.direct.dsneugokihantei.dsneugokihantei.dba;

import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_DsKokyakuJtKbn;
import yuyu.def.classification.C_DsMailSousinJyoutaiKbn;
import yuyu.def.classification.C_DsMailTourokuJyoutaiKbn;
import yuyu.def.classification.C_DsTeisiRiyuuKbn;

/**
 * ＤＳ顧客情報Beanクラス<br />
 */
@AllArgsConstructor
public class DsKokyakuInfoBySyonoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private String dskokno;

    @Getter @Setter
    private C_DsKokyakuJtKbn dskokyakujtkbn;

    @Getter @Setter
    private C_DsTeisiRiyuuKbn dsteisiriyuukbn;

    @Getter @Setter
    private Integer dsmailaddressrenban;

    @Getter @Setter
    private String dsmailaddress;

    @Getter @Setter
    private C_DsMailTourokuJyoutaiKbn dsmailtourokujyoutaikbn;

    @Getter @Setter
    private C_DsMailSousinJyoutaiKbn dsmailsousinjyoutaikbn;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
