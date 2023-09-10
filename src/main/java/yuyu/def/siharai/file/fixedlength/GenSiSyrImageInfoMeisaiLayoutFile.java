package yuyu.def.siharai.file.fixedlength;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import jp.co.slcs.swak.file.description.text.fixedlength.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （支払）書類イメージ情報ファイル（明細レコード）レイアウトファイル データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenSiSyrImageInfoMeisaiLayoutFile implements Serializable {


    private static final long serialVersionUID = 1L;


    public GenSiSyrImageInfoMeisaiLayoutFile() {
    }


    @Column(order = 1, length = 11)
    @NotNull
    private String iffSyono;


    public String getIffSyono() {
        return iffSyono;
    }


    public void setIffSyono(String pIffSyono) {
        iffSyono = pIffSyono;
    }


    @Column(order = 2, length = 18)
    @NotNull
    private String iffYuyuskankensikibetuno;


    public String getIffYuyuskankensikibetuno() {
        return iffYuyuskankensikibetuno;
    }


    public void setIffYuyuskankensikibetuno(String pIffYuyuskankensikibetuno) {
        iffYuyuskankensikibetuno = pIffYuyuskankensikibetuno;
    }


    @Column(order = 3, length = 2)
    @NotNull
    private String iffHokenkinsyuruikbn;


    public String getIffHokenkinsyuruikbn() {
        return iffHokenkinsyuruikbn;
    }


    public void setIffHokenkinsyuruikbn(String pIffHokenkinsyuruikbn) {
        iffHokenkinsyuruikbn = pIffHokenkinsyuruikbn;
    }


    @Column(order = 4, length = 4)
    private String iffRendouimagerenno;


    public String getIffRendouimagerenno() {
        return iffRendouimagerenno;
    }


    public void setIffRendouimagerenno(String pIffRendouimagerenno) {
        iffRendouimagerenno = pIffRendouimagerenno;
    }


    @Column(order = 5, length = 65)
    private String iffYobiimginfomeisai01;


    public String getIffYobiimginfomeisai01() {
        return iffYobiimginfomeisai01;
    }


    public void setIffYobiimginfomeisai01(String pIffYobiimginfomeisai01) {
        iffYobiimginfomeisai01 = pIffYobiimginfomeisai01;
    }


    @Column(order = 6, length = 5)
    private String iffSyoruicd;


    public String getIffSyoruicd() {
        return iffSyoruicd;
    }


    public void setIffSyoruicd(String pIffSyoruicd) {
        iffSyoruicd = pIffSyoruicd;
    }


    @Column(order = 7, length = 1)
    private String iffHyourikbn;


    public String getIffHyourikbn() {
        return iffHyourikbn;
    }


    public void setIffHyourikbn(String pIffHyourikbn) {
        iffHyourikbn = pIffHyourikbn;
    }


    @Column(order = 8, length = 30)
    private String iffSyoruinm;


    public String getIffSyoruinm() {
        return iffSyoruinm;
    }


    public void setIffSyoruinm(String pIffSyoruinm) {
        iffSyoruinm = pIffSyoruinm;
    }


    @Column(order = 9, length = 30)
    private String iffImagefilenm;


    public String getIffImagefilenm() {
        return iffImagefilenm;
    }


    public void setIffImagefilenm(String pIffImagefilenm) {
        iffImagefilenm = pIffImagefilenm;
    }


    @Column(order = 10, length = 19)
    private String iffImagesikibetuno;


    public String getIffImagesikibetuno() {
        return iffImagesikibetuno;
    }


    public void setIffImagesikibetuno(String pIffImagesikibetuno) {
        iffImagesikibetuno = pIffImagesikibetuno;
    }


    @Column(order = 11, length = 1)
    private String iffHyousikbn;


    public String getIffHyousikbn() {
        return iffHyousikbn;
    }


    public void setIffHyousikbn(String pIffHyousikbn) {
        iffHyousikbn = pIffHyousikbn;
    }


    @Column(order = 12, length = 284)
    private String iffYobiimginfomeisai02;


    public String getIffYobiimginfomeisai02() {
        return iffYobiimginfomeisai02;
    }


    public void setIffYobiimginfomeisai02(String pIffYobiimginfomeisai02) {
        iffYobiimginfomeisai02 = pIffYobiimginfomeisai02;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
