package yuyu.common.hozen.khcommon;

import java.util.ArrayList;
import java.util.List;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_Sdpd;
import yuyu.def.classification.C_SinsaihkKbn;
import yuyu.def.classification.C_SyoukensaihkKbn;
import yuyu.def.classification.C_TmttknhaibunjyoutaiKbn;
import yuyu.def.classification.C_UmuKbn;

/**
 * 契約保全 契約保全共通 解約返戻金推移表作成パラメータ
 */
public class WSuiihyouParam {

    @Getter @Setter
    private KeisanWExtBean keisanWExtBean;

    @Getter @Setter
    private BizDate kwsratekjymd;

    @Getter @Setter
    private BizDate calcKijyunYmd;

    @Getter @Setter
    private C_SinsaihkKbn sinsaihkKbn = C_SinsaihkKbn.BLNK;

    @Getter @Setter
    private C_SyoukensaihkKbn syoukensaihkKbn = C_SyoukensaihkKbn.BLNK;

    @Getter @Setter
    private C_UmuKbn mvaTekiUmu = C_UmuKbn.NONE;

    @Getter @Setter
    private int mvaTekiKkn = 0;

    @Getter @Setter
    private BizNumber setteiBairitu = BizNumber.ZERO;

    @Getter @Setter
    private BizNumber TmttknZoukarituJygn = BizNumber.ZERO;

    @Getter @Setter
    private BizNumber sisuurendourate = BizNumber.ZERO;

    @Getter @Setter
    private C_TmttknhaibunjyoutaiKbn tmttknhaibunjyoutai = C_TmttknhaibunjyoutaiKbn.BLNK;

    @Getter @Setter
    private BizCurrency TargetTkykKijyungk = BizCurrency.valueOf(0);

    @Getter @Setter
    private BizCurrency heijyunP = BizCurrency.valueOf(0);

    @Getter @Setter
    private List<BizNumber> yoteiRirituList;

    @Getter @Setter
    private C_UmuKbn zennouUmuKbn = C_UmuKbn.NONE;

    @Getter @Setter
    private BizCurrency zennoujiHrkP = BizCurrency.valueOf(0);

    @Getter @Setter
    private BizDate zennouKaisiYmd;

    @Getter @Setter
    private BizDate ryosyuYmd;

    @Getter @Setter
    private BizCurrency zennouNyuukingk = BizCurrency.valueOf(0);

    @Getter @Setter
    private BizNumber rendouRitu = BizNumber.ZERO;

    @Getter @Setter
    private List<BizNumber> tmmshanteiSisuuList1;

    @Getter @Setter
    private List<BizNumber> tmmshanteiSisuuList2;

    @Getter @Setter
    private List<BizNumber> tmmshanteiSisuuList3;

    @Getter @Setter
    private C_Sdpd sdpd = C_Sdpd.BLNK;

    @Getter @Setter
    private C_Hrkkeiro hrkkeiro = C_Hrkkeiro.BLNK;

    public WSuiihyouParam() {
        super();
        tmmshanteiSisuuList1 = new ArrayList<BizNumber>();
        for (int i = 0; i < 2; i++) {
            tmmshanteiSisuuList1.add(BizNumber.valueOf(1.05));
            tmmshanteiSisuuList1.add(BizNumber.valueOf(0.95));
            tmmshanteiSisuuList1.add(BizNumber.valueOf(1.05));
            tmmshanteiSisuuList1.add(BizNumber.valueOf(1.05));
            tmmshanteiSisuuList1.add(BizNumber.valueOf(1.05));
        }
        tmmshanteiSisuuList2 = new ArrayList<BizNumber>();
        for (int i = 0; i < 5; i++) {
            tmmshanteiSisuuList2.add(BizNumber.valueOf(1.05));
            tmmshanteiSisuuList2.add(BizNumber.valueOf(0.95));
        }
    }
}
