package yuyu.batch.hozen.khansyuu.khuriageseikyuudel.dba;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * 契約保全 案内収納 売上請求データBeanクラス<br />
 */
@AllArgsConstructor
public class UriageSeikyuuDataBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private String kbnkey;

    @Getter
    @Setter
    private String syono;

    @Getter
    @Setter
    private String creditkessaiyouno;

    @Getter
    @Setter
    private BizDate uriagenengappi;

    @Getter
    @Setter
    private Integer renno3keta;

    @Getter
    @Setter
    private BizDate credituriagekekkahaneiymd;

    @Getter
    @Setter
    private String uriageseikyuudatasyono;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}
