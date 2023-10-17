package yuyu.app.sinkeiyaku.skmousikomi.skmosqrsksyoyaku;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_HknsyuruiNo;
import yuyu.def.classification.C_MosnoSaibanKbn;
import yuyu.def.classification.C_SkeijimuKbn;

/**
 * 申込書類用QR作成予約 - ●予約一覧 の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenYoyakuInfoListDataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private BizDate disptrkymd;

    public BizDate getDisptrkymd() {
        return disptrkymd;
    }

    public void setDisptrkymd(BizDate pDisptrkymd) {
        disptrkymd = pDisptrkymd;
    }


    private String dispqryoyakutime;

    public String getDispqryoyakutime() {
        return dispqryoyakutime;
    }

    public void setDispqryoyakutime(String pDispqryoyakutime) {
        dispqryoyakutime = pDispqryoyakutime;
    }


    private C_SkeijimuKbn dispskeijimukbn;

    public C_SkeijimuKbn getDispskeijimukbn() {
        return dispskeijimukbn;
    }

    public void setDispskeijimukbn(C_SkeijimuKbn pDispskeijimukbn) {
        dispskeijimukbn = pDispskeijimukbn;
    }


    private C_HknsyuruiNo disphknsyuruino;

    public C_HknsyuruiNo getDisphknsyuruino() {
        return disphknsyuruino;
    }

    public void setDisphknsyuruino(C_HknsyuruiNo pDisphknsyuruino) {
        disphknsyuruino = pDisphknsyuruino;
    }


    private C_MosnoSaibanKbn dispmosnosaibankbn;

    public C_MosnoSaibanKbn getDispmosnosaibankbn() {
        return dispmosnosaibankbn;
    }

    public void setDispmosnosaibankbn(C_MosnoSaibanKbn pDispmosnosaibankbn) {
        dispmosnosaibankbn = pDispmosnosaibankbn;
    }


    private Integer dispsakuseikensuu;

    public Integer getDispsakuseikensuu() {
        return dispsakuseikensuu;
    }

    public void setDispsakuseikensuu(Integer pDispsakuseikensuu) {
        dispsakuseikensuu = pDispsakuseikensuu;
    }


    private String sakujyoLink;

    public String getSakujyoLink() {
        return sakujyoLink;
    }

    public void setSakujyoLink(String pSakujyoLink) {
        sakujyoLink = pSakujyoLink;
    }

}
