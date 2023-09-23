package yuyu.common.hozen.khcommon;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_YuukousyoumetuKbn;

/**
 * 契約保全 契約保全共通 契約保全索引結果Beanクラス
 */
public class KykSakuinKekkaBean {

    private String kykSyoNo;

    private C_YuukousyoumetuKbn kykYuukSumtKbn;

    private C_Kykjyoutai kykKykJyoutai;

    private BizDate kykKykYMD;

    private C_Syoumetujiyuu kykSumetuJiyuu;

    private BizDate kykSyoumetuYMD;

    private String khSyouhnCd;

    private Integer khsyouhnsdno;

    public String getKykSyoNo() {
        return this.kykSyoNo;
    }

    public void setKykSyoNo(String pKykSyoNo) {
        this.kykSyoNo = pKykSyoNo;
    }

    public C_YuukousyoumetuKbn getKykYuukSumtKbn() {
        return this.kykYuukSumtKbn;
    }

    public void setKykYuukSumtKbn(C_YuukousyoumetuKbn pKykYuukSumtKbn) {
        this.kykYuukSumtKbn = pKykYuukSumtKbn;
    }

    public C_Kykjyoutai getKykKykJyoutai() {
        return this.kykKykJyoutai;
    }

    public void setKykKykJyoutai(C_Kykjyoutai pKykKykJyoutai) {
        this.kykKykJyoutai = pKykKykJyoutai;
    }

    public BizDate getKykKykYMD() {
        return this.kykKykYMD;
    }

    public void setKykKykYMD(BizDate pKykKykYMD) {
        this.kykKykYMD = pKykKykYMD;
    }

    public C_Syoumetujiyuu getKykSumetuJiyuu() {
        return this.kykSumetuJiyuu;
    }

    public void setKykSumetuJiyuu(C_Syoumetujiyuu pKykSumetuJiyuu) {
        this.kykSumetuJiyuu = pKykSumetuJiyuu;
    }

    public BizDate getKykSyoumetuYMD() {
        return this.kykSyoumetuYMD;
    }

    public void setKykSyoumetuYMD(BizDate pKykSyoumetuYMD) {
        this.kykSyoumetuYMD = pKykSyoumetuYMD;
    }

    public String getKhSyouhnCd() {
        return this.khSyouhnCd;
    }

    public void setKhSyouhnCd(String pKhSyouhnCd) {
        this.khSyouhnCd = pKhSyouhnCd;
    }

    public Integer getKhsyouhnsdno() {
        return this.khsyouhnsdno;
    }

    public void setKhsyouhnsdno(Integer pKhsyouhnsdno) {
        this.khsyouhnsdno = pKhsyouhnsdno;
    }


}
