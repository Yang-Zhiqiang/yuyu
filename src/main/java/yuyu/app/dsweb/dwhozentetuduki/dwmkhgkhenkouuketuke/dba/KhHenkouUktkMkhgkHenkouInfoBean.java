package yuyu.app.dsweb.dwhozentetuduki.dwmkhgkhenkouuketuke.dba;

import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * 契約保全変更受付目標額変更情報Bean
 */
@AllArgsConstructor
public class KhHenkouUktkMkhgkHenkouInfoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private String syono;

    @Getter @Setter
    private Integer hozenhenkouuktkrenno;

    @Getter @Setter
    private Integer targettkmokuhyouti;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}
