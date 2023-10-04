package yuyu.batch.hozen.khansyuu.khdattai.dba;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_CardBrandKbn;
import yuyu.def.classification.C_Creditbrerrorcd;
import yuyu.def.classification.C_CreditdataKbn;
import yuyu.def.classification.C_Dattaikeiro;
import yuyu.def.classification.C_HurihunoKbn;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_YokinKbn;

/**
 * 脱退処理Beanクラスです。<br />
 */
@AllArgsConstructor
public class DattaiBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private String syono;

    @Getter @Setter
    private BizDate syoriYmd;

    @Getter @Setter
    private C_Dattaikeiro dattaikeiro;

    @Getter @Setter
    private String bankcd;

    @Getter @Setter
    private String sitencd;

    @Getter @Setter
    private C_YokinKbn yokinkbn;

    @Getter @Setter
    private String kouzano;

    @Getter @Setter
    private C_HurihunoKbn hurihunokbn;

    @Getter @Setter
    private BizDate hurikaeymd;

    @Getter @Setter
    private C_CreditdataKbn creditdatakbn;

    @Getter @Setter
    private String creditcardno1;

    @Getter @Setter
    private String creditcardno2;

    @Getter @Setter
    private String creditcardno3;

    @Getter @Setter
    private String creditcardno4;

    @Getter @Setter
    private C_Creditbrerrorcd creditbrerrorcd;

    @Getter @Setter
    private BizDateYM dattaiym;

    @Getter @Setter
    private String kbnkey;

    @Getter @Setter
    private C_Nykkeiro nykkeiro;

    @Getter @Setter
    private C_NyknaiyouKbn nyknaiyouKbn;

    @Getter @Setter
    private Integer jyutoukaisuuy;

    @Getter @Setter
    private Integer jyutoukaisuum;

    @Getter @Setter
    private String dattaitrrenno;

    @Getter @Setter
    private String creditkessaiyouno;

    @Getter @Setter
    private C_CardBrandKbn cardbrandkbn;

    @Getter @Setter
    private String creditkaiinnosimo4keta;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
