package yuyu.common.hozen.khcommon;

import java.io.Serializable;
import java.util.List;

import jp.co.slcs.swak.number.BizCurrency;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_HugouKbn;
import yuyu.def.classification.C_Tuukasyu;

/**
 * 契約保全 契約保全共通 金額明細Beanクラス
 */
public class KngkMeisaiBean implements Serializable{

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private int index;

    @Getter @Setter
    private List<String> tekiyouLst;

    @Getter @Setter
    private List<C_HugouKbn> kngkmeisaihugouLst;

    @Getter @Setter
    private List<BizCurrency> kngkMeisaiLst;

    @Getter @Setter
    private List<C_Tuukasyu> kngkmisituukasyuLst;
}
