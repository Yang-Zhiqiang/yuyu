package yuyu.def.hozen.bean.report;

import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （保全）印紙税申告納付用リスト帳票BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenKhInsizeiListBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenKhInsizeiListBean() {
    }

    private String irTantsitunmkj;

    public String getIrTantsitunmkj() {
        return irTantsitunmkj;
    }

    public void setIrTantsitunmkj(String pIrTantsitunmkj) {
        irTantsitunmkj = pIrTantsitunmkj;
    }

    private String irSyoribiwareki;

    public String getIrSyoribiwareki() {
        return irSyoribiwareki;
    }

    public void setIrSyoribiwareki(String pIrSyoribiwareki) {
        irSyoribiwareki = pIrSyoribiwareki;
    }

    private String irTyouhyousakuseiymwareki;

    public String getIrTyouhyousakuseiymwareki() {
        return irTyouhyousakuseiymwareki;
    }

    public void setIrTyouhyousakuseiymwareki(String pIrTyouhyousakuseiymwareki) {
        irTyouhyousakuseiymwareki = pIrTyouhyousakuseiymwareki;
    }

    private Integer irSyoseikihkmaisuu;

    public Integer getIrSyoseikihkmaisuu() {
        return irSyoseikihkmaisuu;
    }

    public void setIrSyoseikihkmaisuu(Integer pIrSyoseikihkmaisuu) {
        irSyoseikihkmaisuu = pIrSyoseikihkmaisuu;
    }

    private Integer irSyosaiskmaisuuyou;

    public Integer getIrSyosaiskmaisuuyou() {
        return irSyosaiskmaisuuyou;
    }

    public void setIrSyosaiskmaisuuyou(Integer pIrSyosaiskmaisuuyou) {
        irSyosaiskmaisuuyou = pIrSyosaiskmaisuuyou;
    }

    private Integer irSyosaiskmaisuufuyou;

    public Integer getIrSyosaiskmaisuufuyou() {
        return irSyosaiskmaisuufuyou;
    }

    public void setIrSyosaiskmaisuufuyou(Integer pIrSyosaiskmaisuufuyou) {
        irSyosaiskmaisuufuyou = pIrSyosaiskmaisuufuyou;
    }

    private Integer irSyosaihkmaisuu;

    public Integer getIrSyosaihkmaisuu() {
        return irSyosaihkmaisuu;
    }

    public void setIrSyosaihkmaisuu(Integer pIrSyosaihkmaisuu) {
        irSyosaihkmaisuu = pIrSyosaihkmaisuu;
    }

    private Integer irInsizeisinkokumaisuu;

    public Integer getIrInsizeisinkokumaisuu() {
        return irInsizeisinkokumaisuu;
    }

    public void setIrInsizeisinkokumaisuu(Integer pIrInsizeisinkokumaisuu) {
        irInsizeisinkokumaisuu = pIrInsizeisinkokumaisuu;
    }

    private String irHozonkkn;

    public String getIrHozonkkn() {
        return irHozonkkn;
    }

    public void setIrHozonkkn(String pIrHozonkkn) {
        irHozonkkn = pIrHozonkkn;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
