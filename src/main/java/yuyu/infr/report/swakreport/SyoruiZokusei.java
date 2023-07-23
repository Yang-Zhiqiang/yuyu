package yuyu.infr.report.swakreport;

import yuyu.def.classification.C_NengetuKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_YesNoKbn;



/**
 * 書類属性情報クラスです。
 * 設定ファイルの1行分の定義内容を保持します。
 * 設定項目を追加する場合はこのクラスを継承して下さい。
 */
public class SyoruiZokusei {

    private C_SyoruiCdKbn syoruiCdKbn;

    private String syoruiNm;

    private String syoruiNmRyaku;

    private String tyouhyouFormId;

    private long hozonKkn;

    private C_NengetuKbn nengetuKbn;

    private C_YesNoKbn angoukaKbn;

    private C_YesNoKbn pdfHozonKbn;

    private C_YesNoKbn zipHozonKbn;

    private int pageCount;

    private int sortNo;

    private String kensakuKeyKoumokuId1;

    private String kensakuKeyKoumokuId2;

    private String kensakuKeyKoumokuId3;

    private String kensakuKeyKoumokuId4;

    private String kensakuKeyKoumokuId5;

    public SyoruiZokusei(C_SyoruiCdKbn pSyoruicdKbn,
            String pSyoruiNm,
            String pSyoruiNmRyaku,
            String pTyouhyouFormId,
            long pHozonKkn,
            C_NengetuKbn pNengetuKbn,
            C_YesNoKbn pAngoukaKbn,
            C_YesNoKbn pPdfHozonKbn,
            C_YesNoKbn pZipHozonKbn,
            int pPageCount,
            int pSortNo,
            String pKensakuKeyKoumokuId1,
            String pKensakuKeyKoumokuId2,
            String pKensakuKeyKoumokuId3,
            String pKensakuKeyKoumokuId4,
            String pKensakuKeyKoumokuId5
            ) {

        syoruiCdKbn = pSyoruicdKbn;
        syoruiNm = pSyoruiNm;
        syoruiNmRyaku = pSyoruiNmRyaku;
        tyouhyouFormId = pTyouhyouFormId;
        hozonKkn = pHozonKkn;
        nengetuKbn =  pNengetuKbn;
        angoukaKbn = pAngoukaKbn;
        pdfHozonKbn = pPdfHozonKbn;
        zipHozonKbn = pZipHozonKbn;
        pageCount = pPageCount;
        sortNo = pSortNo;
        kensakuKeyKoumokuId1 = pKensakuKeyKoumokuId1;
        kensakuKeyKoumokuId2 = pKensakuKeyKoumokuId2;
        kensakuKeyKoumokuId3 = pKensakuKeyKoumokuId3;
        kensakuKeyKoumokuId4 = pKensakuKeyKoumokuId4;
        kensakuKeyKoumokuId5 = pKensakuKeyKoumokuId5;

    }

    public C_SyoruiCdKbn getSyoruiCdKbn() {
        return syoruiCdKbn;
    }

    public void setSyoruiCdKbn(C_SyoruiCdKbn pSyoruicdKbn) {
        syoruiCdKbn = pSyoruicdKbn;
    }

    public String getSyoruiNm() {
        return syoruiNm;
    }

    public void setSyoruinm(String pSyoruiNm) {
        syoruiNm = pSyoruiNm;
    }

    public String getSyoruiNmRyaku() {
        return syoruiNmRyaku;
    }

    public void setSyoruinmRyaku(String pSyoruiNmRyaku) {
        syoruiNmRyaku = pSyoruiNmRyaku;
    }


    public String getTyouhyouFormId() {
        return tyouhyouFormId;
    }

    public void setTyouhyouFormId(String pTyouhyouFormId) {
        tyouhyouFormId = pTyouhyouFormId;
    }

    public long getHozonKkn() {
        return hozonKkn;
    }

    public void setHozonKkn(long pHozonKkn) {
        hozonKkn = pHozonKkn;
    }

    public C_NengetuKbn getNengetuKbn() {
        return nengetuKbn;
    }

    public void setNengetuKbn(C_NengetuKbn pNengetuKbn) {
        nengetuKbn = pNengetuKbn;
    }

    public C_YesNoKbn getAngoukaKbn() {
        return angoukaKbn;
    }

    public void setAngoukaKbn(C_YesNoKbn pAngoukaKbn) {
        angoukaKbn = pAngoukaKbn;
    }

    public C_YesNoKbn getPdfHozonKbn() {
        return pdfHozonKbn;
    }

    public void setPdfHozonKbn(C_YesNoKbn pPdfHozonKbn) {
        pdfHozonKbn = pPdfHozonKbn;
    }

    public C_YesNoKbn getZipHozonKbn() {
        return zipHozonKbn;
    }

    public void setZipHozonKbn(C_YesNoKbn pZipHozonKbn) {
        zipHozonKbn = pZipHozonKbn;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pPageCount) {
        pageCount = pPageCount;
    }

    public long getSortNo() {
        return sortNo;
    }

    public void setSortNo(int pSortNo) {
        sortNo = pSortNo;
    }

    public String getKensakuKeyKoumokuId1() {
        return kensakuKeyKoumokuId1;
    }

    public void setKensakuKeyKoumokuId1(String pKensakuKeyKoumokuId1) {
        kensakuKeyKoumokuId1 = pKensakuKeyKoumokuId1;
    }

    public String getKensakuKeyKoumokuId2() {
        return kensakuKeyKoumokuId2;
    }

    public void setKensakuKeyKoumokuId2(String pKensakuKeyKoumokuId2) {
        kensakuKeyKoumokuId2 = pKensakuKeyKoumokuId2;
    }

    public String getKensakuKeyKoumokuId3() {
        return kensakuKeyKoumokuId3;
    }

    public void setKensakuKeyKoumokuId3(String pKensakuKeyKoumokuId3) {
        kensakuKeyKoumokuId3 = pKensakuKeyKoumokuId3;
    }

    public String getKensakuKeyKoumokuId4() {
        return kensakuKeyKoumokuId4;
    }

    public void setKensakuKeyKoumokuId4(String pKensakuKeyKoumokuId4) {
        kensakuKeyKoumokuId4 = pKensakuKeyKoumokuId4;
    }

    public String getKensakuKeyKoumokuId5() {
        return kensakuKeyKoumokuId5;
    }

    public void setKensakuKeyKoumokuId5(String pKensakuKeyKoumokuId5) {
        kensakuKeyKoumokuId5 = pKensakuKeyKoumokuId5;
    }

}
