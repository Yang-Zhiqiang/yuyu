package yuyu.batch.hozen.khansyuu.khkariukekinseibitokusokulistsks.dba;

import java.io.Serializable;
import java.math.BigDecimal;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.BizCurrencySum;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_KrkriyuuKbn;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_TantouCdKbn;
import yuyu.def.classification.C_UmuKbn;

/**
 * 仮受金整備督促リスト作成対象を保持するBeanクラスです。<br />
 */
public class KariukeTokusokuListSksTaisyouBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private String syono;

    @Getter @Setter
    private Integer krkno;

    @Getter @Setter
    private String atesakiSosikicd;

    @Getter @Setter
    private String atesakiBusitucd;

    @Getter @Setter
    private C_TantouCdKbn tantocd;

    @Getter @Setter
    private String kyknmkj;

    @Getter @Setter
    private C_UmuKbn tyoukimiseibikrkumu;

    @Getter @Setter
    private C_UmuKbn hukusuukrkumu;

    @Getter @Setter
    private BizDate krkkeijyoymd;

    @Getter @Setter
    private BizCurrency krkgk;

    @Getter @Setter
    private C_KrkriyuuKbn krkriyuukbn;

    @Getter @Setter
    private C_NyknaiyouKbn nyknaiyoukbn;

    @Getter @Setter
    private C_Nykkeiro nykkeiro;

    @Getter @Setter
    private BizDateYM jyuutouym;

    @Getter @Setter
    private Integer jyutoukaisuuy;

    @Getter @Setter
    private Integer jyutoukaisuum;

    @Getter @Setter
    private BizDate ryosyuymd;

    @Getter @Setter
    private C_Hrkkaisuu  krkjhrkkaisuu;

    public KariukeTokusokuListSksTaisyouBean(String pSyono,
        Integer pKrkno,
        String pAtesakiSosikicd,
        String pAtesakiBusitucd,
        C_TantouCdKbn pTantocd,
        String pKyknmkj,
        C_UmuKbn pTyoukimiseibikrkumu,
        C_UmuKbn pHukusuukrkumu,
        BizDate pKrkkeijyoymd,
        String pKrkgkType,
        BigDecimal pKrkgkValue,
        C_KrkriyuuKbn pKrkriyuukbn,
        C_NyknaiyouKbn pNyknaiyoukbn,
        C_Nykkeiro pNykkeiro,
        BizDateYM pJyuutouym,
        Integer pJyutoukaisuuy,
        Integer pJyutoukaisuum,
        BizDate pYosyuymd,
        C_Hrkkaisuu pKrkjhrkkaisuu) {
        syono = pSyono;
        krkno = pKrkno;
        atesakiSosikicd = pAtesakiSosikicd;
        atesakiBusitucd = pAtesakiBusitucd;
        tantocd = pTantocd;
        kyknmkj = pKyknmkj;
        tyoukimiseibikrkumu = pTyoukimiseibikrkumu;
        hukusuukrkumu = pHukusuukrkumu;
        krkkeijyoymd = pKrkkeijyoymd;
        krkgk = new BizCurrencySum(pKrkgkType, pKrkgkValue).toBizCurrency();
        krkriyuukbn = pKrkriyuukbn;
        nyknaiyoukbn = pNyknaiyoukbn;
        nykkeiro = pNykkeiro;
        jyuutouym = pJyuutouym;
        jyutoukaisuuy = pJyutoukaisuuy;
        jyutoukaisuum = pJyutoukaisuum;
        ryosyuymd = pYosyuymd;
        krkjhrkkaisuu = pKrkjhrkkaisuu;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}
