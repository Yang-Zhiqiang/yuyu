package yuyu.common.siharai.siedittyouhyou;

import java.io.Serializable;

/**
 * 保険金給付金支払 保険金給付金支払帳票編集 債権者情報Bean
 */
public class SaikensyaInfoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String saikennmkj;

    private String saikennyno;

    private String saikenadr1kj;

    private String saikenadr2kj;

    private String saikenadr3kj;

    public SaikensyaInfoBean() {
        super();
    }

    public String getSaikennmkj() {
        return saikennmkj;
    }

    public void setSaikennmkj(String saikennmkj) {
        this.saikennmkj = saikennmkj;
    }

    public String getSaikennyno() {
        return saikennyno;
    }

    public void setSaikennyno(String saikennyno) {
        this.saikennyno = saikennyno;
    }

    public String getSaikenadr1kj() {
        return saikenadr1kj;
    }

    public void setSaikenadr1kj(String saikenadr1kj) {
        this.saikenadr1kj = saikenadr1kj;
    }

    public String getSaikenadr2kj() {
        return saikenadr2kj;
    }

    public void setSaikenadr2kj(String saikenadr2kj) {
        this.saikenadr2kj = saikenadr2kj;
    }

    public String getSaikenadr3kj() {
        return saikenadr3kj;
    }

    public void setSaikenadr3kj(String saikenadr3kj) {
        this.saikenadr3kj = saikenadr3kj;
    }
}
