package yuyu.batch.hozen.khinterf.khkzhrkmtuutifilesks.dba;

import java.io.Serializable;
import java.math.BigDecimal;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.BizCurrencySum;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_SyoruiCdKbn;


/**
 * 契約保全 インターフェイス 口座振込通知データBean
 */
public class KhKzhrkmTuutiDataBean implements Serializable{

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private String kbnkey;

    @Getter @Setter
    private C_SyoruiCdKbn syoruiCd;

    @Getter @Setter
    private BizDate tyouhyouYmd;

    @Getter @Setter
    private String syono;

    @Getter @Setter
    private String henkousikibetuKey;

    @Getter @Setter
    private Integer krkNo;

    @Getter @Setter
    private C_HassouKbn hassouKbn;

    @Getter @Setter
    private String shskyNo;

    @Getter @Setter
    private String shsadr1Kj;

    @Getter @Setter
    private String shsadr2Kj;

    @Getter @Setter
    private String shsadr3Kj;

    @Getter @Setter
    private String shsnmKj;

    @Getter @Setter
    private String toiawasesosikinmKj;

    @Getter @Setter
    private String toiawaseyNo;

    @Getter @Setter
    private String toiawaseadr1Kj;

    @Getter @Setter
    private String toiawaseadr2Kj;

    @Getter @Setter
    private String toiawaseadr3Kj;

    @Getter @Setter
    private String toiawasetelNo;

    @Getter @Setter
    private String toiawaseteluktkkanou1;

    @Getter @Setter
    private String toiawaseteluktkkanou2;

    @Getter @Setter
    private String toiawasesosikinmKj2;

    @Getter @Setter
    private String toiawasetelNo2;

    @Getter @Setter
    private BizDate hurikomiYmd;

    @Getter @Setter
    private BizCurrency shrGk;

    @Getter @Setter
    private String shririyuu1;

    @Getter @Setter
    private String shririyuu2;

    @Getter @Setter
    private String shririyuu3;

    @Getter @Setter
    private String siteiKouza1;

    @Getter @Setter
    private String siteiKouza2;

    @Getter @Setter
    private String siteiKouza3;

    @Getter @Setter
    private String siteiKouza4;

    @Getter @Setter
    private String siteiKouza5;

    public KhKzhrkmTuutiDataBean(String pKbnkey,
        C_SyoruiCdKbn pSyoruiCd,
        BizDate pTyouhyouYmd,
        String pSyoNo,
        String pHenkousikibetuKey,
        Integer pKrkNo,
        C_HassouKbn pHassouKbn,
        String pShskyNo,
        String pShsadr1Kj,
        String pShsadr2Kj,
        String pShsadr3Kj,
        String pShsnmKj,
        String pToiawasesosikinmKj,
        String pToiawaseyNo,
        String pToiawaseadr1Kj,
        String pToiawaseadr2Kj,
        String pToiawaseadr3Kj,
        String pToiawasetelNo,
        String pToiawaseteluktkkanou1,
        String pToiawaseteluktkkanou2,
        String pToiawasesosikinmKj2,
        String pToiawasetelNo2,
        BizDate pHurikomiYmd,
        String pType,
        BigDecimal pValue,
        String pShririyuu1,
        String pShririyuu2,
        String pShririyuu3,
        String pSiteiKouza1,
        String pSiteiKouza2,
        String pSiteiKouza3,
        String pSiteiKouza4,
        String pSiteiKouza5){

        kbnkey = pKbnkey;

        syoruiCd = pSyoruiCd;

        tyouhyouYmd = pTyouhyouYmd;

        syono = pSyoNo;

        henkousikibetuKey = pHenkousikibetuKey;

        krkNo = pKrkNo;

        hassouKbn = pHassouKbn;

        shskyNo = pShskyNo;

        shsadr1Kj = pShsadr1Kj;

        shsadr2Kj = pShsadr2Kj;

        shsadr3Kj = pShsadr3Kj;

        shsnmKj = pShsnmKj;

        toiawasesosikinmKj = pToiawasesosikinmKj;

        toiawaseyNo = pToiawaseyNo;

        toiawaseadr1Kj = pToiawaseadr1Kj;

        toiawaseadr2Kj = pToiawaseadr2Kj;

        toiawaseadr3Kj = pToiawaseadr3Kj;

        toiawasetelNo = pToiawasetelNo;

        toiawaseteluktkkanou1 = pToiawaseteluktkkanou1;

        toiawaseteluktkkanou2 = pToiawaseteluktkkanou2;

        toiawasesosikinmKj2 = pToiawasesosikinmKj2;

        toiawasetelNo2 = pToiawasetelNo2;

        hurikomiYmd = pHurikomiYmd;

        shrGk = new BizCurrencySum(pType, pValue).toBizCurrency();

        shririyuu1 = pShririyuu1;

        shririyuu2 = pShririyuu2;

        shririyuu3 = pShririyuu3;

        siteiKouza1 = pSiteiKouza1;

        siteiKouza2 = pSiteiKouza2;

        siteiKouza3 = pSiteiKouza3;

        siteiKouza4 = pSiteiKouza4;

        siteiKouza5 = pSiteiKouza5;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}
