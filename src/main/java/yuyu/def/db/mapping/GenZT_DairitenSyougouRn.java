package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import yuyu.def.db.entity.ZT_DairitenSyougouRn;
import yuyu.def.db.id.PKZT_DairitenSyougouRn;
import yuyu.def.db.meta.GenQZT_DairitenSyougouRn;
import yuyu.def.db.meta.QZT_DairitenSyougouRn;

/**
 * 代理店法人商号連動ＵＬＦテーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_DairitenSyougouRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_DairitenSyougouRn}</td><td colspan="3">代理店法人商号連動ＵＬＦテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrndairitencd zrndairitencd}</td><td>（連携用）代理店コード</td><td align="center">{@link PKZT_DairitenSyougouRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkanjihoujinsyougou zrnkanjihoujinsyougou}</td><td>（連携用）漢字法人商号</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv13 zrnyobiv13}</td><td>（連携用）予備項目Ｖ１３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_DairitenSyougouRn
 * @see     PKZT_DairitenSyougouRn
 * @see     QZT_DairitenSyougouRn
 * @see     GenQZT_DairitenSyougouRn
 */
@MappedSuperclass
@Table(name=GenZT_DairitenSyougouRn.TABLE_NAME)
@IdClass(value=PKZT_DairitenSyougouRn.class)
public abstract class GenZT_DairitenSyougouRn extends AbstractExDBEntityForZDB<ZT_DairitenSyougouRn, PKZT_DairitenSyougouRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_DairitenSyougouRn";
    public static final String ZRNDAIRITENCD            = "zrndairitencd";
    public static final String ZRNKANJIHOUJINSYOUGOU    = "zrnkanjihoujinsyougou";
    public static final String ZRNYOBIV13               = "zrnyobiv13";

    private final PKZT_DairitenSyougouRn primaryKey;

    public GenZT_DairitenSyougouRn() {
        primaryKey = new PKZT_DairitenSyougouRn();
    }

    public GenZT_DairitenSyougouRn(String pZrndairitencd) {
        primaryKey = new PKZT_DairitenSyougouRn(pZrndairitencd);
    }

    @Transient
    @Override
    public PKZT_DairitenSyougouRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_DairitenSyougouRn> getMetaClass() {
        return QZT_DairitenSyougouRn.class;
    }

    @Id
    @Column(name=GenZT_DairitenSyougouRn.ZRNDAIRITENCD)
    public String getZrndairitencd() {
        return getPrimaryKey().getZrndairitencd();
    }

    public void setZrndairitencd(String pZrndairitencd) {
        getPrimaryKey().setZrndairitencd(pZrndairitencd);
    }

    private String zrnkanjihoujinsyougou;

    @Column(name=GenZT_DairitenSyougouRn.ZRNKANJIHOUJINSYOUGOU)
    public String getZrnkanjihoujinsyougou() {
        return zrnkanjihoujinsyougou;
    }

    @DataConvert("toMultiByte")
    public void setZrnkanjihoujinsyougou(String pZrnkanjihoujinsyougou) {
        zrnkanjihoujinsyougou = pZrnkanjihoujinsyougou;
    }

    private String zrnyobiv13;

    @Column(name=GenZT_DairitenSyougouRn.ZRNYOBIV13)
    public String getZrnyobiv13() {
        return zrnyobiv13;
    }

    public void setZrnyobiv13(String pZrnyobiv13) {
        zrnyobiv13 = pZrnyobiv13;
    }
}