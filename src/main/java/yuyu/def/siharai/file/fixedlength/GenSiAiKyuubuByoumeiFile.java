package yuyu.def.siharai.file.fixedlength;

import java.io.Serializable;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.file.description.annotations.MultiByte;
import jp.co.slcs.swak.file.description.text.fixedlength.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （支払）あいキューブ病名マスタ送信ファイル データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenSiAiKyuubuByoumeiFile implements Serializable {


    private static final long serialVersionUID = 1L;


    public GenSiAiKyuubuByoumeiFile() {
    }


    @Column(order = 1, length = 6)
    private String iffByoumeitourokuno;


    public String getIffByoumeitourokuno() {
        return iffByoumeitourokuno;
    }


    @Trim("both")
    public void setIffByoumeitourokuno(String pIffByoumeitourokuno) {
        iffByoumeitourokuno = pIffByoumeitourokuno;
    }


    @Column(order = 2, length = 50)
    @MultiByte
    private String iffByoumei;


    public String getIffByoumei() {
        return iffByoumei;
    }


    @Trim("both")
    public void setIffByoumei(String pIffByoumei) {
        iffByoumei = pIffByoumei;
    }


    @Column(order = 3, length = 100)
    @MultiByte
    private String iffByoumeizenkaku;


    public String getIffByoumeizenkaku() {
        return iffByoumeizenkaku;
    }


    @Trim("both")
    public void setIffByoumeizenkaku(String pIffByoumeizenkaku) {
        iffByoumeizenkaku = pIffByoumeizenkaku;
    }


    @Column(order = 4, length = 60)
    private String iffByoumeihurigana;


    public String getIffByoumeihurigana() {
        return iffByoumeihurigana;
    }


    @Trim("both")
    public void setIffByoumeihurigana(String pIffByoumeihurigana) {
        iffByoumeihurigana = pIffByoumeihurigana;
    }


    @Column(order = 5, length = 60)
    @MultiByte
    private String iffByoumeihuriganakensaku;


    public String getIffByoumeihuriganakensaku() {
        return iffByoumeihuriganakensaku;
    }


    @Trim("both")
    @DataConvert("toMultiByte")
    public void setIffByoumeihuriganakensaku(String pIffByoumeihuriganakensaku) {
        iffByoumeihuriganakensaku = pIffByoumeihuriganakensaku;
    }


    @Column(order = 6, length = 4)
    private String iffByoumeicd;


    public String getIffByoumeicd() {
        return iffByoumeicd;
    }


    @Trim("both")
    public void setIffByoumeicd(String pIffByoumeicd) {
        iffByoumeicd = pIffByoumeicd;
    }


    @Column(order = 7, length = 3)
    private String iffByoumeibuicd;


    public String getIffByoumeibuicd() {
        return iffByoumeibuicd;
    }


    @Trim("both")
    public void setIffByoumeibuicd(String pIffByoumeibuicd) {
        iffByoumeibuicd = pIffByoumeibuicd;
    }


    @Column(order = 8, length = 1)
    private String iffGaitoukbn1;


    public String getIffGaitoukbn1() {
        return iffGaitoukbn1;
    }


    @Trim("both")
    public void setIffGaitoukbn1(String pIffGaitoukbn1) {
        iffGaitoukbn1 = pIffGaitoukbn1;
    }


    @Column(order = 9, length = 1)
    private String iffGaitoukbn2;


    public String getIffGaitoukbn2() {
        return iffGaitoukbn2;
    }


    @Trim("both")
    public void setIffGaitoukbn2(String pIffGaitoukbn2) {
        iffGaitoukbn2 = pIffGaitoukbn2;
    }


    @Column(order = 10, length = 1)
    private String iffGaitoukbn3;


    public String getIffGaitoukbn3() {
        return iffGaitoukbn3;
    }


    @Trim("both")
    public void setIffGaitoukbn3(String pIffGaitoukbn3) {
        iffGaitoukbn3 = pIffGaitoukbn3;
    }


    @Column(order = 11, length = 1)
    private String iffGaitoukbn4;


    public String getIffGaitoukbn4() {
        return iffGaitoukbn4;
    }


    @Trim("both")
    public void setIffGaitoukbn4(String pIffGaitoukbn4) {
        iffGaitoukbn4 = pIffGaitoukbn4;
    }


    @Column(order = 12, length = 1)
    private String iffGaitoukbn5;


    public String getIffGaitoukbn5() {
        return iffGaitoukbn5;
    }


    @Trim("both")
    public void setIffGaitoukbn5(String pIffGaitoukbn5) {
        iffGaitoukbn5 = pIffGaitoukbn5;
    }


    @Column(order = 13, length = 35)
    @MultiByte
    private String iffTyuuimongon;


    public String getIffTyuuimongon() {
        return iffTyuuimongon;
    }


    @Trim("both")
    public void setIffTyuuimongon(String pIffTyuuimongon) {
        iffTyuuimongon = pIffTyuuimongon;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
