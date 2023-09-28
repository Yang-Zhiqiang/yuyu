package yuyu.common.biz.kaikei;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_DensysKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_NykshrKbn;
import yuyu.def.classification.C_Nyktrksflg;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_ShrhousiteiKbn;
import yuyu.def.classification.C_ShrsyoriKbn;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Tuukasyu;

/**
 * 業務共通 経理・会計 資金移動履歴データBeanクラス
 */
public class SikinIdouRirekiDataBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private BizDate syoriYmd = null;

    @Getter
    @Setter
    private String syono = "";

    @Getter
    @Setter
    private String henkouSikibetuKey = "";

    @Getter
    @Setter
    private String targetKinouId = "";

    @Getter
    @Setter
    private String skno = "";

    @Getter
    @Setter
    private Integer seikyuuRirekiNo = 0;

    @Getter
    @Setter
    private C_NykshrKbn nykshrKbn = C_NykshrKbn.BLNK;

    @Getter
    @Setter
    private String syoricd = "";

    @Getter
    @Setter
    private C_DensysKbn densysKbn = C_DensysKbn.BLNK;

    @Getter
    @Setter
    private String denrenno = "";

    @Getter
    @Setter
    private C_Segcd seg1cd = C_Segcd.BLNK;

    @Getter
    @Setter
    private C_Tuukasyu kykTuukasyu = C_Tuukasyu.BLNK;

    @Getter
    @Setter
    private C_SyutkKbn syutkKbn = C_SyutkKbn.NONE;

    @Getter
    @Setter
    private C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.BLNK;

    @Getter
    @Setter
    private String syouhnCd = "";

    @Getter
    @Setter
    private Integer syouhnSdno = 0;

    @Getter
    @Setter
    private Integer kykSyouhnRenno = 0;

    @Getter
    @Setter
    private C_ShrhousiteiKbn shrhousiteiKbn = C_ShrhousiteiKbn.BLNK;

    @Getter
    @Setter
    private BizDateYM phendouKaisiYm = null;

    @Getter
    @Setter
    private BizCurrency phendoumaeGk = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

    @Getter
    @Setter
    private BizCurrency phendougoGk = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

    @Getter
    @Setter
    private BizDate kykYmd = null;

    @Getter
    @Setter
    private BizDate seirituYmd = null;

    @Getter
    @Setter
    private BizDate syoumetuYmd = null;

    @Getter
    @Setter
    private BizDateYM misyuupJyuutouYm = null;

    @Getter
    @Setter
    private C_ShrsyoriKbn shrsyoriKbn = C_ShrsyoriKbn.BLNK;

    @Getter
    @Setter
    private C_SeikyuuSyubetu seikyuuSyubetu = C_SeikyuuSyubetu.BLNK;

    @Getter
    @Setter
    private C_Syoumetujiyuu syoumetuJiyuu = C_Syoumetujiyuu.BLNK;

    @Getter
    @Setter
    private BizDateYM jkipjytYm = null;

    @Getter
    @Setter
    private BizDateYM jyutouStartYm = null;

    @Getter
    @Setter
    private BizDateYM jyutouEndYm = null;

    @Getter
    @Setter
    private C_Nykkeiro nykkeiro = C_Nykkeiro.BLNK;

    @Getter
    @Setter
    private C_NyknaiyouKbn nyknaiyouKbn = C_NyknaiyouKbn.BLNK;

    @Getter
    @Setter
    private C_Nyktrksflg nyktrksFlg = C_Nyktrksflg.BLNK;

    @Getter
    @Setter
    private BizCurrency hrkp = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

    @Getter
    @Setter
    private BizCurrency hokenryou = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

    public SikinIdouRirekiDataBean() {
        super();
    }
}
