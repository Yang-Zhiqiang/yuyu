package yuyu.infr.report;

import java.io.Serializable;

/**
 * PDF保存情報。
 */
public class PdfHozonBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String imageId;

    private byte[] pdfData;

    private String kosId;

    private String kosTime;

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String pImageId) {
        imageId = pImageId;
    }

    public byte[] getPdfData() {
        return pdfData;
    }

    public void setPdfData(byte[] pPdfData) {
        pdfData = pPdfData;
    }

    public String getKosId() {
        return kosId;
    }

    public void setKosId(String pKosId) {
        kosId = pKosId;
    }

    public String getKosTime() {
        return kosTime;
    }

    public void setKosTime(String pKosTime) {
        kosTime = pKosTime;
    }

}
