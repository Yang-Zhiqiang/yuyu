package yuyu.batch.hozen.khinterf.khdirectmaildatasel.dba;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_AisyoumeiKbn;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_KktyuitaKbn;
import yuyu.def.classification.C_Tdk;
import yuyu.def.classification.C_TtdktyuuiKbn;

/**
 * 契約保全 有効対象契約情報Beanクラス
 */
public class KhYuukouTaisyouKykInfoBean implements Serializable{

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private String kbnkey;

    @Getter @Setter
    private String syono;

    @Getter @Setter
    private BizDateYM bosyuuym;

    @Getter @Setter
    private C_AisyoumeiKbn aisyoumeikbn;

    @Getter @Setter
    private C_Tdk kkkyktdk;

    @Getter @Setter
    private String kyksakuinmeino;

    @Getter @Setter
    private String kyknmkn;

    @Getter @Setter
    private String kyknmkj;

    @Getter @Setter
    private BizDate kykseiymd;

    @Getter @Setter
    private String tsinyno;

    @Getter @Setter
    private String tsinadr1kj;

    @Getter @Setter
    private String tsinadr2kj;

    @Getter @Setter
    private String tsinadr3kj;

    @Getter @Setter
    private String hhknsakuinmeino;

    @Getter @Setter
    private C_HknkknsmnKbn hknkknsmnkbn;

    @Getter @Setter
    private C_KktyuitaKbn kktyuitakbn;

    @Getter @Setter
    private C_TtdktyuuiKbn ttdktyuuikbn1;

    @Getter @Setter
    private C_TtdktyuuiKbn ttdktyuuikbn2;

    @Getter @Setter
    private C_TtdktyuuiKbn ttdktyuuikbn3;

    @Getter @Setter
    private C_TtdktyuuiKbn ttdktyuuikbn4;

    @Getter @Setter
    private C_TtdktyuuiKbn ttdktyuuikbn5;

    public KhYuukouTaisyouKykInfoBean(String pKbnkey,
        String pSyono,
        BizDateYM pBosyuuym,
        C_AisyoumeiKbn pAisyoumeikbn,
        C_Tdk pKkkyktdk,
        String pKyksakuinmeino,
        String pKyknmkn,
        String pKyknmkj,
        BizDate pKykseiymd,
        String pTsinyno,
        String pTsinadr1kj,
        String pTsinadr2kj,
        String pTsinadr3kj,
        String pHhknsakuinmeino,
        C_HknkknsmnKbn pHknkknsmnkbn,
        C_KktyuitaKbn pKktyuitakbn,
        C_TtdktyuuiKbn pTtdktyuuikbn1,
        C_TtdktyuuiKbn pTtdktyuuikbn2,
        C_TtdktyuuiKbn pTtdktyuuikbn3,
        C_TtdktyuuiKbn pTtdktyuuikbn4,
        C_TtdktyuuiKbn pTtdktyuuikbn5) {

        kbnkey = pKbnkey;
        syono = pSyono;
        bosyuuym = pBosyuuym;
        aisyoumeikbn = pAisyoumeikbn;
        kkkyktdk = pKkkyktdk;
        kyksakuinmeino = pKyksakuinmeino;
        kyknmkn = pKyknmkn;
        kyknmkj = pKyknmkj;
        kykseiymd = pKykseiymd;
        tsinyno = pTsinyno;
        tsinadr1kj = pTsinadr1kj;
        tsinadr2kj = pTsinadr2kj;
        tsinadr3kj = pTsinadr3kj;
        hhknsakuinmeino = pHhknsakuinmeino;
        hknkknsmnkbn = pHknkknsmnkbn;
        kktyuitakbn = pKktyuitakbn;
        ttdktyuuikbn1 = pTtdktyuuikbn1;
        ttdktyuuikbn2 = pTtdktyuuikbn2;
        ttdktyuuikbn3 = pTtdktyuuikbn3;
        ttdktyuuikbn4 = pTtdktyuuikbn4;
        ttdktyuuikbn5 = pTtdktyuuikbn5;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}
