package yuyu.batch.sinkeiyaku.sknyuukin.skhurikomikouzahuittilistsks.dba;

import java.io.Serializable;
import java.math.BigDecimal;

import jp.co.slcs.swak.db.typesafe.BizCurrencySum;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_Tuukasyu;

/**
 * 振込口座不一致リスト作成の処理対象を保持するBeanクラス<br />
 */
public class SikinidouInfoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private String sikinidoumotohonkouzacd;

    @Getter
    @Setter
    private String sikinidoumotobankcd;

    @Getter
    @Setter
    private String sikinidoumotositencd;

    @Getter
    @Setter
    private String sikinidoumotokouzano;

    @Getter
    @Setter
    private C_Tuukasyu sikinidoumototuukasyu;

    @Getter
    @Setter
    private BizCurrency sikinidougaku;

    @Getter
    @Setter
    private String sikinidousakihonkouzacd;

    @Getter
    @Setter
    private String sikinidousakihonbankcd;

    @Getter
    @Setter
    private String sikinidousakihonsitencd;

    @Getter
    @Setter
    private String sikinidousakihonkouzano;

    @Getter
    @Setter
    private C_Tuukasyu sikinidousakihontuukasyu;

    @Getter
    @Setter
    private String nykmosno;

    public SikinidouInfoBean(String pSikinidoumotohonkouzacd,
        String pSikinidoumotobankcd,
        String pSikinidoumotositencd,
        String pSikinidoumotokouzano,
        C_Tuukasyu pSikinidoumototuukasyu,
        String pSikinidougakuType,
        BigDecimal pSikinidougakuValue,
        String pSikinidousakihonkouzacd,
        String pSikinidousakihonbankcd,
        String pSikinidousakihonsitencd,
        String pSikinidousakihonkouzano,
        C_Tuukasyu pSikinidousakihontuukasyu,
        String pNykmosno) {

        sikinidoumotohonkouzacd = pSikinidoumotohonkouzacd;
        sikinidoumotobankcd = pSikinidoumotobankcd;
        sikinidoumotositencd = pSikinidoumotositencd;
        sikinidoumotokouzano = pSikinidoumotokouzano;
        sikinidoumototuukasyu = pSikinidoumototuukasyu;
        sikinidougaku = new BizCurrencySum(pSikinidougakuType, pSikinidougakuValue).toBizCurrency();
        sikinidousakihonkouzacd = pSikinidousakihonkouzacd;
        sikinidousakihonbankcd = pSikinidousakihonbankcd;
        sikinidousakihonsitencd = pSikinidousakihonsitencd;
        sikinidousakihonkouzano = pSikinidousakihonkouzano;
        sikinidousakihontuukasyu = pSikinidousakihontuukasyu;
        nykmosno = pNykmosno;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}
