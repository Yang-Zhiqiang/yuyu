package yuyu.app.hozen.khozen.khkeiyakusyoukai.dba;

import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_DsMailSousinJyoutaiKbn;
import yuyu.def.classification.C_DsMailSousinTeisiRiyuuKbn;

/**
 * 契約保全 契約保全 ＤＳメール登録状況情報Beanクラスです。
 */
public class DsMailAddressInfosBySyonoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private C_DsMailSousinJyoutaiKbn dsmailsousinjyoutaikbn;

    @Getter
    @Setter
    private C_DsMailSousinTeisiRiyuuKbn dsmailsousintisrykbn;

    public DsMailAddressInfosBySyonoBean(C_DsMailSousinJyoutaiKbn pDsmailsousinjyoutaikbn,
        C_DsMailSousinTeisiRiyuuKbn pDsmailsousintisrykbn) {
        dsmailsousinjyoutaikbn = pDsmailsousinjyoutaikbn;
        dsmailsousintisrykbn = pDsmailsousintisrykbn;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}
