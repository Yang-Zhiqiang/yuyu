package yuyu.common.workflowcore.iwfcommon.pga;

import java.io.Serializable;

/**
 * PDFマスク情報を保持します。
 */
public class PdfMask implements Serializable {

    private static final long serialVersionUID = 1L;

    private float fStartX_;

    private float fStartY_;

    private float fEndX_;

    private float fWeight_;

    public PdfMask(String psStartX, String psStartY, String psLength, String psWeight) {
        fStartX_ = Float.parseFloat(psStartX);
        fStartY_ = Float.parseFloat(psStartY);
        fEndX_   = fStartX_ + Float.parseFloat(psLength);
        fWeight_ = Float.parseFloat(psWeight);
    }

    public float getStartX() {
        return fStartX_;
    }

    public float getStartY() {
        return fStartY_;
    }

    public float getEndX() {
        return fEndX_;
    }

    public float getWeight() {
        return fWeight_;
    }
}
