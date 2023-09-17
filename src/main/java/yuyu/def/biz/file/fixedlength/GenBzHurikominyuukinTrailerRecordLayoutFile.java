package yuyu.def.biz.file.fixedlength;

import java.io.Serializable;

import jp.co.slcs.swak.file.description.text.fixedlength.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （共通）振込入金ファイル（トレーラーレコード）レイアウトファイル データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenBzHurikominyuukinTrailerRecordLayoutFile implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenBzHurikominyuukinTrailerRecordLayoutFile() {
    }

    @Column(order = 1, length = 1)
    private String iffDatakbn;

    public String getIffDatakbn() {
        return iffDatakbn;
    }

    public void setIffDatakbn(String pIffDatakbn) {
        iffDatakbn = pIffDatakbn;
    }

    @Column(order = 2, length = 6)
    private Integer iffNyknkensuu;

    public Integer getIffNyknkensuu() {
        return iffNyknkensuu;
    }

    public void setIffNyknkensuu(Integer pIffNyknkensuu) {
        iffNyknkensuu = pIffNyknkensuu;
    }

    @Column(order = 3, length = 13)
    private String iffNykngkkei;

    public String getIffNykngkkei() {
        return iffNykngkkei;
    }

    public void setIffNykngkkei(String pIffNykngkkei) {
        iffNykngkkei = pIffNykngkkei;
    }

    @Column(order = 4, length = 6)
    private Integer iffSyukkinkensuu;

    public Integer getIffSyukkinkensuu() {
        return iffSyukkinkensuu;
    }

    public void setIffSyukkinkensuu(Integer pIffSyukkinkensuu) {
        iffSyukkinkensuu = pIffSyukkinkensuu;
    }

    @Column(order = 5, length = 13)
    private String iffSyukkingkkei;

    public String getIffSyukkingkkei() {
        return iffSyukkingkkei;
    }

    public void setIffSyukkingkkei(String pIffSyukkingkkei) {
        iffSyukkingkkei = pIffSyukkingkkei;
    }

    @Column(order = 6, length = 1)
    private Integer iffKasikosikbn;

    public Integer getIffKasikosikbn() {
        return iffKasikosikbn;
    }

    public void setIffKasikosikbn(Integer pIffKasikosikbn) {
        iffKasikosikbn = pIffKasikosikbn;
    }

    @Column(order = 7, length = 14)
    private String iffTrhkgozndk;

    public String getIffTrhkgozndk() {
        return iffTrhkgozndk;
    }

    public void setIffTrhkgozndk(String pIffTrhkgozndk) {
        iffTrhkgozndk = pIffTrhkgozndk;
    }

    @Column(order = 8, length = 10)
    private Long iffDtrecordkensuu;

    public Long getIffDtrecordkensuu() {
        return iffDtrecordkensuu;
    }

    public void setIffDtrecordkensuu(Long pIffDtrecordkensuu) {
        iffDtrecordkensuu = pIffDtrecordkensuu;
    }

    @Column(order = 9, length = 139)
    private String iffDummy139;

    public String getIffDummy139() {
        return iffDummy139;
    }

    public void setIffDummy139(String pIffDummy139) {
        iffDummy139 = pIffDummy139;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
