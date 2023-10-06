package yuyu.app.workflow.imagekanri.qrsealsakusei;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.co.slcs.swak.web.conversation.annotations.ConversationScoped;
import yuyu.common.workflow.workflowutility.TorikomiSyoruiMstBean;
import yuyu.def.classification.C_HknsyuruiNo;
import yuyu.def.classification.C_MosUketukeKbn;
import yuyu.def.classification.C_SkeijimuKbn;

/**
 * QRシール用紙作成 の画面UiBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
@ConversationScoped
public class QRSealSakuseiUiBean extends GenQRSealSakuseiUiBean {

    private static final long serialVersionUID = 1L;

    public QRSealSakuseiUiBean() {
    }

    private String syrCdSelectNum;

    public String getSyrCdSelectNum() {
        return syrCdSelectNum;
    }

    public void setSyrCdSelectNum(String pSyrCdSelectNum) {
        this.syrCdSelectNum = pSyrCdSelectNum;
    }

    private List<TorikomiSyoruiMstBean> syrCdSelectData;

    public List<TorikomiSyoruiMstBean> getSyrCdSelectData() {
        return syrCdSelectData;
    }

    public void setSyrCdSelectData(List<TorikomiSyoruiMstBean> pSyrCdSelectData) {
        this.syrCdSelectData = pSyrCdSelectData;
    }

    private List<String> nyuuryokuMosNo;

    public List<String> getNyuuryokuMosNo() {
        return nyuuryokuMosNo;
    }

    public void setNyuuryokuMosNo(List<String> pNyuuryokuMosNo) {
        this.nyuuryokuMosNo = pNyuuryokuMosNo;
    }

    private Map<Integer, List<String>> nyuuryokuSyNm;

    public Map<Integer, List<String>> getNyuuryokuSyNm() {
        return nyuuryokuSyNm;
    }

    public void setNyuuryokuSyNm(Map<Integer, List<String>> pNyuuryokuSyNm) {
        this.nyuuryokuSyNm = pNyuuryokuSyNm;
    }

    private List<String> countNum;

    public List<String> getCountNum() {
        return countNum;
    }

    public void setCountNum(List<String> pCountNum) {
        this.countNum = pCountNum;
    }

    private String reportKey;

    public String getReportKey() {
        return reportKey;
    }

    public void setReportKey(String pReportKey) {
        reportKey = pReportKey;
    }

    private HashMap<String, C_SkeijimuKbn> skeijimuKbnMap;

    public HashMap<String, C_SkeijimuKbn> getSkeijimuKbnMap() {
        return skeijimuKbnMap;
    }

    public void setSkeijimuKbnMap(HashMap<String, C_SkeijimuKbn> pSkeijimuKbnMap) {
        skeijimuKbnMap = pSkeijimuKbnMap;
    }

    private HashMap<String, C_HknsyuruiNo> hknsyuruiNoMap;

    public HashMap<String, C_HknsyuruiNo> getHknsyuruiNoMap() {
        return hknsyuruiNoMap;
    }

    public void setHknsyuruiNoMap(HashMap<String, C_HknsyuruiNo> pHknsyuruiNoMap) {
        hknsyuruiNoMap = pHknsyuruiNoMap;
    }

    private HashMap<String, C_MosUketukeKbn> mosuketukekbnMap;

    public HashMap<String, C_MosUketukeKbn> getMosuketukekbnMap() {
        return mosuketukekbnMap;
    }

    public void setMosuketukekbnMap(HashMap<String, C_MosUketukeKbn> pMosuketukekbnMap) {
        mosuketukekbnMap = pMosuketukekbnMap;
    }

    private HashMap<String, String> dairitencd1Map;

    public HashMap<String, String> getDairitencd1Map() {
        return dairitencd1Map;
    }

    public void setDairitencd1Map(HashMap<String, String> pDairitencd1Map) {
        dairitencd1Map = pDairitencd1Map;
    }

    private boolean createTrikomiyouhyousiFlg;

    public boolean isCreateTrikomiyouhyousiFlg() {
        return createTrikomiyouhyousiFlg;
    }

    public void setCreateTrikomiyouhyousiFlg(boolean createTrikomiyouhyousiFlg) {
        this.createTrikomiyouhyousiFlg = createTrikomiyouhyousiFlg;
    }

    private List<String> qrFileNmList;

    public List<String> getQrFileNmList() {
        return qrFileNmList;
    }

    public void setQrFileNmList(String pQrFileNm) {
        if (qrFileNmList == null) {
            qrFileNmList = new ArrayList<String>();
        }
        qrFileNmList.add(pQrFileNm);
    }

}
