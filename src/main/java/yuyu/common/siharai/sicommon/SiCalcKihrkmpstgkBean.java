package yuyu.common.siharai.sicommon;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_Sdpd;
import yuyu.def.classification.C_Tuukasyu;

/**
 * 保険金給付金支払 保険金給付金既払込保険料相当額計算Bean
 */
public class SiCalcKihrkmpstgkBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private BizDate kykYmd;

    @Getter
    @Setter
    private BizDate calcKijyunYmd;

    @Getter
    @Setter
    private String syouhnCd;

    @Getter
    @Setter
    private String ryouriTusdNo;

    @Getter
    @Setter
    private BizNumber yoteiRiritu;

    @Getter
    @Setter
    private C_Hrkkaisuu hrkKaisuu;

    @Getter
    @Setter
    private Integer hhknNen;

    @Getter
    @Setter
    private C_Hhknsei hhknSei;

    @Getter
    @Setter
    private C_HknkknsmnKbn hknkknSmnKbn;

    @Getter
    @Setter
    private Integer hknKkn;

    @Getter
    @Setter
    private C_HrkkknsmnKbn hrkkknSmnKbn;

    @Getter
    @Setter
    private Integer hrkKkn;

    @Getter
    @Setter
    private C_Sdpd sdPdKbn;

    @Getter
    @Setter
    private BizCurrency hokenknGk;

    @Getter
    @Setter
    private BizCurrency hokenRyou;

    @Getter
    @Setter
    private C_Tuukasyu kykTuukaSyu;

    @Getter
    @Setter
    private C_Kykjyoutai kykJyoutai;

    @Getter
    @Setter
    private Integer dai1HknKkn;

    @Getter
    @Setter
    private C_Hrkkeiro hrkKeiro;

    public SiCalcKihrkmpstgkBean() {
        super();
    }
}
