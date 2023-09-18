package yuyu.common.workflowcore.iwfcommon.pga;

import java.io.Serializable;

/**
 * PDFページです。
 * PDFファイルの１ページに相当する情報をイメージIDを関連付けて保持します。
 */
public class PdfPage implements Serializable {

    private static final long serialVersionUID = 1L;

    private String sImageid_;

    private byte[] btPdfdatas_;

    private String sKosid_;

    private String sKostime_;

    public String getS_imageid() {
        return sImageid_;
    }

    public void setS_imageid(String psImageid) {
        sImageid_ = psImageid;
    }

    public byte[] getS_pdfdata() {
        return btPdfdatas_;
    }

    public void setS_pdfdata(byte[] pbtPdfdatas) {
        btPdfdatas_ = pbtPdfdatas;
    }

    public String getS_kosid() {
        return sKosid_;
    }

    public void setS_kosid(String psKosid) {
        sKosid_ = psKosid;
    }

    public String getS_kostime() {
        return sKostime_;
    }

    public void setS_kostime(String psKostime) {
        sKostime_ = psKostime;
    }

}
