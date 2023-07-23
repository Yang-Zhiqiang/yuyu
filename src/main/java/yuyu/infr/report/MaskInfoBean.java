package yuyu.infr.report;

import java.io.Serializable;

/**
 * PDFマスク情報。
 */
public class MaskInfoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private float startX;

    private float startY;

    private float endX;

    private float weight;

    public MaskInfoBean(String pStartX, String pStartY, String pLength, String pWeight) {
        startX = Float.parseFloat(pStartX);
        startY = Float.parseFloat(pStartY);
        endX   = startX + Float.parseFloat(pLength);
        weight = Float.parseFloat(pWeight);
    }

    public float getStartX() {
        return startX;
    }

    public float getStartY() {
        return startY;
    }

    public float getEndX() {
        return endX;
    }

    public float getWeight() {
        return weight;
    }
}
