package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import yuyu.def.db.entity.AM_HaitaSyurui;
import yuyu.def.db.id.PKAM_HaitaSyurui;
import yuyu.def.db.meta.GenQAM_HaitaSyurui;
import yuyu.def.db.meta.QAM_HaitaSyurui;

/**
 * 排他種類マスタ テーブルのマッピング情報クラスで、 {@link AM_HaitaSyurui} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link AM_HaitaSyurui}</td><td colspan="3">排他種類マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getHaitaSyuruiCd haitaSyuruiCd}</td><td>排他種類コード</td><td align="center">{@link PKAM_HaitaSyurui ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHaitaSyuruiNm haitaSyuruiNm}</td><td>排他種類名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHaitaKeyKousei haitaKeyKousei}</td><td>排他キー構成</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     AM_HaitaSyurui
 * @see     PKAM_HaitaSyurui
 * @see     QAM_HaitaSyurui
 * @see     GenQAM_HaitaSyurui
 */
@MappedSuperclass
@Table(name=GenAM_HaitaSyurui.TABLE_NAME)
@IdClass(value=PKAM_HaitaSyurui.class)
public abstract class GenAM_HaitaSyurui extends AbstractExDBEntity<AM_HaitaSyurui, PKAM_HaitaSyurui> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "AM_HaitaSyurui";
    public static final String HAITASYURUICD            = "haitaSyuruiCd";
    public static final String HAITASYURUINM            = "haitaSyuruiNm";
    public static final String HAITAKEYKOUSEI           = "haitaKeyKousei";

    private final PKAM_HaitaSyurui primaryKey;

    public GenAM_HaitaSyurui() {
        primaryKey = new PKAM_HaitaSyurui();
    }

    public GenAM_HaitaSyurui(String pHaitaSyuruiCd) {
        primaryKey = new PKAM_HaitaSyurui(pHaitaSyuruiCd);
    }

    @Transient
    @Override
    public PKAM_HaitaSyurui getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QAM_HaitaSyurui> getMetaClass() {
        return QAM_HaitaSyurui.class;
    }

    @Id
    @Column(name=GenAM_HaitaSyurui.HAITASYURUICD)
    public String getHaitaSyuruiCd() {
        return getPrimaryKey().getHaitaSyuruiCd();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHaitaSyuruiCd(String pHaitaSyuruiCd) {
        getPrimaryKey().setHaitaSyuruiCd(pHaitaSyuruiCd);
    }

    private String haitaSyuruiNm;

    @Column(name=GenAM_HaitaSyurui.HAITASYURUINM)
    public String getHaitaSyuruiNm() {
        return haitaSyuruiNm;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setHaitaSyuruiNm(String pHaitaSyuruiNm) {
        haitaSyuruiNm = pHaitaSyuruiNm;
    }

    private String haitaKeyKousei;

    @Column(name=GenAM_HaitaSyurui.HAITAKEYKOUSEI)
    public String getHaitaKeyKousei() {
        return haitaKeyKousei;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHaitaKeyKousei(String pHaitaKeyKousei) {
        haitaKeyKousei = pHaitaKeyKousei;
    }
}
