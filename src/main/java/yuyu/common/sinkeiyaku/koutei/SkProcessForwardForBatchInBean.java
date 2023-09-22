package yuyu.common.sinkeiyaku.koutei;

import java.io.Serializable;

import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.HT_SyoriCTL;

/**
 * 新契約 工程 新契約工程遷移（バッチ用）入力Bean
 */
public class SkProcessForwardForBatchInBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private HT_SyoriCTL htSyoriCTL;

    private String tskNm;

    private String syoriComment;

    private C_UmuKbn skHubiDetailUmu;

    public SkProcessForwardForBatchInBean() {
        super();

        htSyoriCTL = new HT_SyoriCTL();
        tskNm = "";
        syoriComment = "";
        skHubiDetailUmu = C_UmuKbn.NONE;
    }

    public HT_SyoriCTL getHtSyoriCTL() {
        return htSyoriCTL;
    }

    public void setHtSyoriCTL(HT_SyoriCTL pHtSyoriCTL) {
        htSyoriCTL = pHtSyoriCTL;
    }

    public String getTskNm() {
        return tskNm;
    }

    public void setTskNm(String pTskNm) {
        tskNm = pTskNm;
    }

    public String getSyoriComment() {
        return syoriComment;
    }

    public void setSyoriComment(String pSyoriComment) {
        syoriComment = pSyoriComment;
    }

    public C_UmuKbn getSkHubiDetailUmu() {
        return skHubiDetailUmu;
    }

    public void setSkHubiDtailUmu(C_UmuKbn pSkHubiDetailUmu) {
        skHubiDetailUmu = pSkHubiDetailUmu;
    }
}
