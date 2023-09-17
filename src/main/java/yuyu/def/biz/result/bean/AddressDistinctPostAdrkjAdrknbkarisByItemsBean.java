package yuyu.def.biz.result.bean;

import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * 住所マスタ(郵便番号)情報Beanです。<br />
 */
@AllArgsConstructor
public class AddressDistinctPostAdrkjAdrknbkarisByItemsBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private String postalCd;

    @Getter @Setter
    private String adrkj;

    @Getter @Setter
    private String adrknblankari;

    @Getter @Setter
    private Integer kjtodouhukennmketasuu;

    @Getter @Setter
    private Integer kjsikugunnmketasuu;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
