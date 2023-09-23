package yuyu.common.hozen.khcommon;

import java.io.Serializable;
import java.util.List;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_DensysKbn;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_ShrhousiteiKbn;
import yuyu.def.classification.C_Syuudaikocd;

/**
 * 契約保全 契約保全共通 案内収納用仕訳共通処理入力Bean
 */
public class AnsyuuCommonSiwakeInBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String kinouId;

    private C_DensysKbn densysKbn;

    private BizDate denYmd;

    private BizDate syoriYmd;

    private BizDate kykYmd;

    private C_Nykkeiro nykkeiro;

    private String suitouSoshikiCd;

    private C_ShrhousiteiKbn shrhousiteiKbn;

    private List<AnsyuuTaisyouGkBean> ansyuuTaisyouGkBeanLst;

    private String syouhinCd;

    private Integer syouhnsdno;

    private String syono;

    private C_Syuudaikocd syuudaikoCd;

    public String getKinouId() {
        return kinouId;
    }

    public void setKinouId(String pKinouId) {
        kinouId = pKinouId;
    }

    public C_DensysKbn getDensysKbn() {
        return densysKbn;
    }

    public void setDensysKbn(C_DensysKbn pDensysKbn) {
        densysKbn = pDensysKbn;
    }

    public BizDate getDenYmd() {
        return denYmd;
    }

    public void setDenYmd(BizDate pDenYmd) {
        denYmd = pDenYmd;
    }

    public BizDate getSyoriYmd() {
        return syoriYmd;
    }

    public void setSyoriYmd(BizDate pSyoriYmd) {
        syoriYmd = pSyoriYmd;
    }

    public BizDate getKykYmd() {
        return kykYmd;
    }

    public void setKykYmd(BizDate pKykYmd) {
        kykYmd = pKykYmd;
    }

    public C_Nykkeiro getNykkeiro() {
        return nykkeiro;
    }

    public void setNykkeiro(C_Nykkeiro pNykkeiro) {
        nykkeiro = pNykkeiro;
    }

    public String getSuitouSoshikiCd() {
        return suitouSoshikiCd;
    }

    public void setSuitouSoshikiCd(String pSuitouSoshikiCd) {
        suitouSoshikiCd = pSuitouSoshikiCd;
    }

    public C_ShrhousiteiKbn getShrhousiteiKbn() {
        return shrhousiteiKbn;
    }

    public void setShrhousiteiKbn(C_ShrhousiteiKbn pShrhousiteiKbn) {
        shrhousiteiKbn = pShrhousiteiKbn;
    }

    public List<AnsyuuTaisyouGkBean> getAnsyuuTaisyouGkBeanLst() {
        return ansyuuTaisyouGkBeanLst;
    }

    public void setAnsyuuTaisyouGkBeanLst(List<AnsyuuTaisyouGkBean> pAnsyuuTaisyouGkBeanLst) {
        ansyuuTaisyouGkBeanLst = pAnsyuuTaisyouGkBeanLst;
    }

    public String getSyouhinCd() {
        return syouhinCd;
    }

    public void setSyouhinCd(String pSyouhinCd) {
        syouhinCd = pSyouhinCd;
    }

    public Integer getSyouhnsdno() {
        return syouhnsdno;
    }

    public void setSyouhnsdno(Integer pSyouhnsdno) {
        syouhnsdno = pSyouhnsdno;
    }

    public String getSyono() {
        return syono;
    }

    public void setSyono(String pSyono) {
        syono = pSyono;
    }

    public C_Syuudaikocd getSyuudaikoCd() {
        return syuudaikoCd;
    }

    public void setSyuudaikoCd(C_Syuudaikocd pSyuudaikoCd) {
        syuudaikoCd = pSyuudaikoCd;
    }
}
