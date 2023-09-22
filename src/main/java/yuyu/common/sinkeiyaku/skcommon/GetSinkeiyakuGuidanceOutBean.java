package yuyu.common.sinkeiyaku.skcommon;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 新契約 新契約共通 新契約ガイダンス出力Bean
 */
public class GetSinkeiyakuGuidanceOutBean implements Serializable {

    private static final long serialVersionUID = 1L;

    List<String> guidansuMessageList = new ArrayList<String>();

    private String knsnkanouhyj = "0";

    private String nngndkkkanouhyj = "0";

    private String mnstskanouhyj = "0";

    private String syktkikanouhyj = "0";

    private String syaikanouhyj = "0";

    private String sndnzknsyouhyj = "0";

    private String ktekknsyouhyj = "0";

    private String knsnsysndnzyou = "0";

    private String knsnktekknsyou = "0";

    public List<String> getGuidansuMessageList() {
        return guidansuMessageList;
    }

    public void setGuidansuMessageList(List<String> pGuidansuMessageList) {
        this.guidansuMessageList = pGuidansuMessageList;
    }

    public String getKnsnkanouhyj() {
        return knsnkanouhyj;
    }

    public void setKnsnkanouhyj(String pKnsnkanouhyj) {
        this.knsnkanouhyj = pKnsnkanouhyj;
    }

    public String getNngndkkkanouhyj() {
        return nngndkkkanouhyj;
    }

    public void setNngndkkkanouhyj(String pNngndkkkanouhyj) {
        this.nngndkkkanouhyj = pNngndkkkanouhyj;
    }

    public String getMnstskanouhyj() {
        return mnstskanouhyj;
    }

    public void setMnstskanouhyj(String pMnstskanouhyj) {
        this.mnstskanouhyj = pMnstskanouhyj;
    }

    public String getSyktkikanouhyj() {
        return syktkikanouhyj;
    }

    public void setSyktkikanouhyj(String pSyktkikanouhyj) {
        this.syktkikanouhyj = pSyktkikanouhyj;
    }

    public String getSyaikanouhyj() {
        return syaikanouhyj;
    }

    public void setSyaikanouhyj(String pSyaikanouhyj) {
        this.syaikanouhyj = pSyaikanouhyj;
    }

    public String getSndnzknsyouhyj() {
        return sndnzknsyouhyj;
    }

    public void setSndnzknsyouhyj(String pSndnzknsyouhyj) {
        this.sndnzknsyouhyj = pSndnzknsyouhyj;
    }

    public String getKtekknsyouhyj() {
        return ktekknsyouhyj;
    }

    public void setKtekknsyouhyj(String pKtekknsyouhyj) {
        this.ktekknsyouhyj = pKtekknsyouhyj;
    }

    public String getKnsnsysndnzyou() {
        return knsnsysndnzyou;
    }

    public void setKnsnsysndnzyou(String pKnsnsysndnzyou) {
        this.knsnsysndnzyou = pKnsnsysndnzyou;
    }

    public String getKnsnktekknsyou() {
        return knsnktekknsyou;
    }

    public void setKnsnktekknsyou(String pKnsnktekknsyou) {
        this.knsnktekknsyou = pKnsnktekknsyou;
    }
}