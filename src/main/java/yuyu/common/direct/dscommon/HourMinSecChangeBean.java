package yuyu.common.direct.dscommon;

import java.io.Serializable;

/**
 * ダイレクト ダイレクト共通 時分秒変換Bean
 */
public class HourMinSecChangeBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private int hour;

    private int min;

    private int sec;

    public HourMinSecChangeBean() {
        super();
        this.hour = 0;
        this.min = 0;
        this.sec = 0;
    }

    public int getHour() {
        return this.hour;
    }

    public void setHour(int pHour) {
        this.hour = pHour;
    }

    public int getMin() {
        return this.min;
    }

    public void setMin(int pMin) {
        this.min = pMin;
    }

    public int getSec() {
        return this.sec;
    }

    public void setSec(int pSec) {
        this.sec = pSec;
    }
}
