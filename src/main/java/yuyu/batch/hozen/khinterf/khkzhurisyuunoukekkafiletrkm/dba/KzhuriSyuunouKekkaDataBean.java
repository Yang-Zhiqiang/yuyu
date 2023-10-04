package yuyu.batch.hozen.khinterf.khkzhurisyuunoukekkafiletrkm.dba;

import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * 契約保全 インターフェイス 口座振替収納結果データBean
 */
@AllArgsConstructor
public class KzhuriSyuunouKekkaDataBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private String ztrsyono;

    @Getter
    @Setter
    private String ztrkzhurikaebankcd;

    @Getter
    @Setter
    private String ztrkzhurikaesitencd;

    @Getter
    @Setter
    private String ztrkzhurikaeyokinkbn;

    @Getter
    @Setter
    private String ztrkzhurikaekouzano;

    @Getter
    @Setter
    private Long ztrrsgaku;

    @Getter
    @Setter
    private String ztrjyuutouym;

    @Getter
    @Setter
    private String ztrjyuutounensuu;

    @Getter
    @Setter
    private String ztrjyuutoutukisuu;

    @Getter
    @Setter
    private String ztrhurikaekekkakbn;

    @Getter
    @Setter
    private String ztrhurikaeymd;

    @Getter
    @Setter
    private String ztrdantaikobetukbn;

    @Getter
    @Setter
    private String ztrnyknaiyoukbn;

    @Getter
    @Setter
    private String ztrhrkkaisuukbn;

    @Getter
    @Setter
    private String ztrkzhurikaetkbtannaihyj;

    @Getter
    @Setter
    private String  ztrkzhurisyuudaikokbn ;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}