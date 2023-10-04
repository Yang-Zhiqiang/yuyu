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
 * @author  魏　瓊
 * @version 2016/12/20 魏　瓊 : 新規作成<br />
 *          2017/03/27 魏　瓊 : S社ナポレオン先行１次追加対応<br />
 *          2018/10/23 何　俊峰:2019年3月25日対応
 *          2019/02/06 石川　翔太郎: 2019年3月25日対応<br />
 *          2019/10/28 桑　海東: 2020年3月24日対応<br />
 */
@AllArgsConstructor
public class DattaiBean implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** 証券番号 */
    @Getter @Setter
    private String syono;

    /** 処理年月日 */
    @Getter @Setter
    private BizDate syoriYmd;

    /** 脱退経路 */
    @Getter @Setter
    private C_Dattaikeiro dattaikeiro;

    /** 銀行コード */
    @Getter @Setter
    private String bankcd;

    /** 支店コード */
    @Getter @Setter
    private String sitencd;

    /** 預金種目区分 */
    @Getter @Setter
    private C_YokinKbn yokinkbn;

    /** 口座番号 */
    @Getter @Setter
    private String kouzano;

    /** 振替不能理由区分 */
    @Getter @Setter
    private C_HurihunoKbn hurihunokbn;

    /** 振替日 */
    @Getter @Setter
    private BizDate hurikaeymd;

    /** クレジットデータ区分 */
    @Getter @Setter
    private C_CreditdataKbn creditdatakbn;

    /** クレジットカード番号１ */
    @Getter @Setter
    private String creditcardno1;

    /** クレジットカード番号２ */
    @Getter @Setter
    private String creditcardno2;

    /** クレジットカード番号３ */
    @Getter @Setter
    private String creditcardno3;

    /** クレジットカード番号４ */
    @Getter @Setter
    private String creditcardno4;

    /** クレジット払エラーコード */
    @Getter @Setter
    private C_Creditbrerrorcd creditbrerrorcd;

    /** 脱退年月 */
    @Getter @Setter
    private BizDateYM dattaiym;

    /** 区分キー */
    @Getter @Setter
    private String kbnkey;

    /** 入金経路 */
    @Getter @Setter
    private C_Nykkeiro nykkeiro;

    /** 入金内容区分 */
    @Getter @Setter
    private C_NyknaiyouKbn nyknaiyouKbn;

    /** 充当回数（年） */
    @Getter @Setter
    private Integer jyutoukaisuuy;

    /** 充当回数（月） */
    @Getter @Setter
    private Integer jyutoukaisuum;

    /** 脱退TR連番 */
    @Getter @Setter
    private String dattaitrrenno;

    /** クレジットカード決済用番号 */
    @Getter @Setter
    private String creditkessaiyouno;

    /** カードブランド区分 */
    @Getter @Setter
    private C_CardBrandKbn cardbrandkbn;

    /** クレジット会員番号（下４桁） */
    @Getter @Setter
    private String creditkaiinnosimo4keta;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
